package be.winnetrie.mod.winnetriesexpansionmod.block;

import java.util.ArrayList;
import java.util.List;

import be.winnetrie.mod.winnetriesexpansionmod.WemConfig;
import be.winnetrie.mod.winnetriesexpansionmod.WemModule;
import be.winnetrie.mod.winnetriesexpansionmod.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

/**
 * Simple self-contained sapling used for the first fruit-tree prototype.
 * Instead of a full configured-feature setup, it grows a small handcrafted tree
 * made of oak logs plus matching fruit leaves.
 */
public class FruitSaplingBlock extends BushBlock implements BonemealableBlock {
    public static final IntegerProperty STAGE = IntegerProperty.create("stage", 0, 1);
    private static final float BONEMEAL_SUCCESS_CHANCE = 0.45F;

    private final String fruitId;

    public FruitSaplingBlock(String fruitId, BlockBehaviour.Properties properties) {
        super(properties);
        this.fruitId = fruitId;
        this.registerDefaultState(this.stateDefinition.any().setValue(STAGE, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(STAGE);
    }

    public String fruitId() {
        return this.fruitId;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        // Explicitly accept the complete vanilla dirt/grass-style planting family.
        // BlockTags.DIRT is kept as the broad compatibility path, while the direct
        // checks make grass/dirt behaviour unambiguous on this Minecraft line.
        return state.is(BlockTags.DIRT)
                || state.is(Blocks.GRASS_BLOCK)
                || state.is(Blocks.DIRT)
                || state.is(Blocks.COARSE_DIRT)
                || state.is(Blocks.PODZOL)
                || state.is(Blocks.ROOTED_DIRT)
                || state.is(Blocks.MYCELIUM)
                || state.is(Blocks.FARMLAND)
                || state.is(Blocks.MOSS_BLOCK);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!WemConfig.isModuleEnabled(WemModule.FRUITS)) return;
        if (level.getMaxLocalRawBrightness(pos.above()) >= 9 && random.nextInt(7) == 0) {
            advanceGrowth(level, pos, state, random);
        }
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return random.nextFloat() < BONEMEAL_SUCCESS_CHANCE;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        if (!WemConfig.isModuleEnabled(WemModule.FRUITS)) return;
        advanceGrowth(level, pos, state, random);
    }

    private void advanceGrowth(ServerLevel level, BlockPos pos, BlockState state, RandomSource random) {
        if (state.getValue(STAGE) == 0) {
            level.setBlock(pos, state.setValue(STAGE, 1), Block.UPDATE_ALL);
            return;
        }
        growTree(level, pos, random);
    }

    private void growTree(ServerLevel level, BlockPos pos, RandomSource random) {
        int trunkHeight = 4 + random.nextInt(2);
        Block leafBlock = ModBlocks.BLOCKS_BY_ID.get(this.fruitId + "_leaves").get();
        Block fruitBlock = ModBlocks.BLOCKS_BY_ID.get(this.fruitId + "_hanging_fruit").get();

        if (!hasSpace(level, pos, trunkHeight)) return;

        level.setBlock(pos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);

        for (int y = 0; y < trunkHeight; y++) {
            level.setBlock(pos.above(y), Blocks.OAK_LOG.defaultBlockState(), Block.UPDATE_ALL);
        }

        BlockPos crown = pos.above(trunkHeight - 1);
        List<BlockPos> candidateFruitLeaves = new ArrayList<>();

        placeLeafLayer(level, crown.above(0), leafBlock, 2, candidateFruitLeaves);
        placeLeafLayer(level, crown.above(1), leafBlock, 2, candidateFruitLeaves);
        placeLeafLayer(level, crown.above(2), leafBlock, 1, candidateFruitLeaves);
        tryPlaceLeaf(level, crown.above(3), leafBlock, candidateFruitLeaves);

        for (BlockPos leafPos : candidateFruitLeaves) {
            BlockPos below = leafPos.below();
            if (below.getY() <= pos.getY() + 1) continue;
            if (level.isEmptyBlock(below) && random.nextInt(5) == 0) {
                level.setBlock(below, fruitBlock.defaultBlockState(), Block.UPDATE_ALL);
            }
        }
    }

    private boolean hasSpace(ServerLevel level, BlockPos pos, int trunkHeight) {
        for (int y = 0; y <= trunkHeight + 3; y++) {
            int radius = y >= trunkHeight - 1 ? 2 : 0;
            for (int x = -radius; x <= radius; x++) {
                for (int z = -radius; z <= radius; z++) {
                    // y=0,x=0,z=0 is the sapling itself. It will be replaced by
                    // the trunk and must never cause its own space check to fail.
                    if (x == 0 && y == 0 && z == 0) continue;

                    BlockPos checkPos = pos.offset(x, y, z);
                    BlockState state = level.getBlockState(checkPos);
                    if (!state.isAir() && !state.is(BlockTags.LEAVES)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void placeLeafLayer(ServerLevel level, BlockPos center, Block leafBlock, int radius, List<BlockPos> fruitCandidates) {
        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                if (Math.abs(x) == radius && Math.abs(z) == radius && radius > 1) continue;
                tryPlaceLeaf(level, center.offset(x, 0, z), leafBlock, fruitCandidates);
            }
        }
    }

    private void tryPlaceLeaf(ServerLevel level, BlockPos pos, Block leafBlock, List<BlockPos> fruitCandidates) {
        BlockState existing = level.getBlockState(pos);
        if (existing.isAir() || existing.is(BlockTags.LEAVES)) {
            level.setBlock(pos, leafBlock.defaultBlockState(), Block.UPDATE_ALL);
            fruitCandidates.add(pos);
        }
    }
}
