package be.winnetrie.mod.winnetriesexpansionmod.block;

import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;

public class GlassStairBlock extends StairBlock {
    public GlassStairBlock(BlockState baseState, Properties properties) {
        super(baseState, properties);
    }

    @Override
    public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction direction) {
        if (isConnectedGlassNeighbor(adjacentBlockState)) {
            return true;
        }
        return super.skipRendering(state, adjacentBlockState, direction);
    }

    private static boolean isConnectedGlassNeighbor(BlockState state) {
        var key = BuiltInRegistries.BLOCK.getKey(state.getBlock());
        if (key == null) {
            return false;
        }

        String namespace = key.getNamespace();
        String path = key.getPath();

        if ("minecraft".equals(namespace)) {
            return "glass".equals(path) || path.endsWith("_stained_glass");
        }

        if ("winnetriesexpansionmod".equals(namespace)) {
            // Full connected glass stairs can safely hide the touching face.
            //
            // Half slabs MUST NOT be treated as a fully-occluding neighbour:
            // skipRendering() works per block face, not per half-face. If we
            // return true for a slab, Minecraft removes the complete stair
            // side and the uncovered half becomes a visible hole.
            return "glass_stairs".equals(path)
                    || path.endsWith("_stained_glass_stairs");
        }

        return false;
    }
}
