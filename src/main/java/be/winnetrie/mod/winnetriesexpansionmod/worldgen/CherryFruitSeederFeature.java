package be.winnetrie.mod.winnetriesexpansionmod.worldgen;

import java.util.HashSet;
import java.util.Set;

import be.winnetrie.mod.winnetriesexpansionmod.registry.ModBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

/**
 * One-shot world-generation pass for vanilla Cherry Trees.
 *
 * <p>The feature runs only in Cherry Grove through the biome modifier. It finds
 * the base of vanilla cherry trunks in the current chunk and seeds up to five
 * ripe WEM cherries beneath nearby cherry leaves. There is no recurring scan;
 * harvested fruit uses FruitHangingBlock's own scheduled regrowth tick.</p>
 */
public final class CherryFruitSeederFeature extends Feature<NoneFeatureConfiguration> {
    private static final int MAX_INITIAL_CHERRIES = 5;
    private static final int TRUNK_SEARCH_DEPTH = 18;

    public CherryFruitSeederFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        RandomSource random = context.random();
        BlockPos origin = context.origin();
        int minX = origin.getX();
        int minZ = origin.getZ();
        int minBuildY = level.getMinY();

        Set<BlockPos> trunks = new HashSet<>();

        // The placed feature runs once per chunk. Scan only the thin surface band
        // where a vanilla cherry trunk can exist instead of scanning the full Y range.
        for (int dx = 0; dx < 16; dx++) {
            for (int dz = 0; dz < 16; dz++) {
                int x = minX + dx;
                int z = minZ + dz;
                int surfaceY = level.getHeight(Heightmap.Types.WORLD_SURFACE, x, z);
                int startY = Math.max(minBuildY, surfaceY - TRUNK_SEARCH_DEPTH);

                for (int y = startY; y <= surfaceY; y++) {
                    BlockPos pos = new BlockPos(x, y, z);
                    if (!level.getBlockState(pos).is(Blocks.CHERRY_LOG)) continue;

                    // Only accept the bottom of a vertical trunk. This rejects most
                    // horizontal/branch logs and ensures each tree is seeded once.
                    if (level.getBlockState(pos.below()).is(Blocks.CHERRY_LOG)) continue;
                    if (!level.getBlockState(pos.above()).is(Blocks.CHERRY_LOG)) continue;

                    trunks.add(pos.immutable());
                    break;
                }
            }
        }

        boolean placedAny = false;
        for (BlockPos trunk : trunks) {
            if (seedCherryTree(level, random, trunk)) {
                placedAny = true;
            }
        }
        return placedAny;
    }

    private static boolean seedCherryTree(WorldGenLevel level, RandomSource random, BlockPos origin) {
        Block cherryFruit = ModBlocks.BLOCKS_BY_ID.get("cherry_hanging_fruit").get();
        int placed = 0;

        for (BlockPos leafPos : BlockPos.betweenClosed(origin.offset(-4, 1, -4), origin.offset(4, 10, 4))) {
            if (!level.getBlockState(leafPos).is(Blocks.CHERRY_LEAVES)) continue;

            BlockPos fruitPos = leafPos.below();
            if (!level.isEmptyBlock(fruitPos)) continue;
            if (random.nextInt(4) != 0) continue;

            level.setBlock(fruitPos, cherryFruit.defaultBlockState(), Block.UPDATE_CLIENTS);
            if (++placed >= MAX_INITIAL_CHERRIES) break;
        }

        return placed > 0;
    }
}
