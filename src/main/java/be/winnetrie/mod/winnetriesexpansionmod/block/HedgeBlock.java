package be.winnetrie.mod.winnetriesexpansionmod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.util.TriState;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * Leafy fence-style hedge.
 *
 * <p>The horizontal connection/collision/waterlogging behaviour comes from
 * vanilla FenceBlock, but the visible geometry is intentionally transparent
 * like leaves. The block therefore has no occlusion shape: faces behind the
 * hedge remain rendered and visible through holes in the leaf texture.</p>
 */
public class HedgeBlock extends FenceBlock {
    public static final BooleanProperty UP = BooleanProperty.create("up");
    public static final BooleanProperty DOWN = BooleanProperty.create("down");

    private static final VoxelShape CORE_SHAPE =
            Shapes.box(2.0 / 16.0, 0.0, 2.0 / 16.0, 14.0 / 16.0, 1.0, 14.0 / 16.0);
    private static final VoxelShape NORTH_SHAPE =
            Shapes.box(2.0 / 16.0, 0.0, 0.0, 14.0 / 16.0, 1.0, 8.0 / 16.0);
    private static final VoxelShape EAST_SHAPE =
            Shapes.box(8.0 / 16.0, 0.0, 2.0 / 16.0, 1.0, 1.0, 14.0 / 16.0);
    private static final VoxelShape SOUTH_SHAPE =
            Shapes.box(2.0 / 16.0, 0.0, 8.0 / 16.0, 14.0 / 16.0, 1.0, 1.0);
    private static final VoxelShape WEST_SHAPE =
            Shapes.box(0.0, 0.0, 2.0 / 16.0, 8.0 / 16.0, 1.0, 14.0 / 16.0);

    private static final VoxelShape[] OUTLINE_SHAPES = buildOutlineShapes();

    public HedgeBlock(BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState()
                .setValue(UP, false)
                .setValue(DOWN, false));
    }

    private static VoxelShape[] buildOutlineShapes() {
        VoxelShape[] shapes = new VoxelShape[16];

        for (int mask = 0; mask < shapes.length; mask++) {
            VoxelShape shape = CORE_SHAPE;

            if ((mask & 1) != 0) shape = Shapes.or(shape, NORTH_SHAPE);
            if ((mask & 2) != 0) shape = Shapes.or(shape, EAST_SHAPE);
            if ((mask & 4) != 0) shape = Shapes.or(shape, SOUTH_SHAPE);
            if ((mask & 8) != 0) shape = Shapes.or(shape, WEST_SHAPE);

            shapes[mask] = shape;
        }

        return shapes;
    }

    private static int outlineIndex(BlockState state) {
        int mask = 0;
        if (state.getValue(NORTH)) mask |= 1;
        if (state.getValue(EAST)) mask |= 2;
        if (state.getValue(SOUTH)) mask |= 4;
        if (state.getValue(WEST)) mask |= 8;
        return mask;
    }

    private static boolean isHedge(BlockState state) {
        return state.getBlock() instanceof HedgeBlock;
    }

    private static boolean hasSameHorizontalConnections(BlockState first, BlockState second) {
        return isHedge(second)
                && first.getValue(NORTH).equals(second.getValue(NORTH))
                && first.getValue(EAST).equals(second.getValue(EAST))
                && first.getValue(SOUTH).equals(second.getValue(SOUTH))
                && first.getValue(WEST).equals(second.getValue(WEST));
    }

    private static boolean isConnectedOnSide(BlockState state, Direction direction) {
        return switch (direction) {
            case NORTH -> state.getValue(NORTH);
            case EAST -> state.getValue(EAST);
            case SOUTH -> state.getValue(SOUTH);
            case WEST -> state.getValue(WEST);
            default -> false;
        };
    }

    @Override
    public boolean connectsTo(BlockState state, boolean faceSolid, Direction direction) {
        // Hedges should visually connect to any block registered as leaves.
        // super.connectsTo keeps the normal fence / fence-gate / solid-face behaviour.
        return state.is(BlockTags.LEAVES) || super.connectsTo(state, faceSolid, direction);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(UP, DOWN);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = super.getStateForPlacement(context);
        BlockPos pos = context.getClickedPos();
        BlockGetter level = context.getLevel();

        return state
                .setValue(UP, isHedge(level.getBlockState(pos.above())))
                .setValue(DOWN, isHedge(level.getBlockState(pos.below())));
    }

    @Override
    protected BlockState updateShape(
            BlockState state,
            LevelReader level,
            ScheduledTickAccess ticks,
            BlockPos pos,
            Direction directionToNeighbour,
            BlockPos neighbourPos,
            BlockState neighbourState,
            RandomSource random) {
        BlockState updated = super.updateShape(
                state, level, ticks, pos, directionToNeighbour, neighbourPos, neighbourState, random);

        if (directionToNeighbour == Direction.UP) {
            return updated.setValue(UP, isHedge(neighbourState));
        }
        if (directionToNeighbour == Direction.DOWN) {
            return updated.setValue(DOWN, isHedge(neighbourState));
        }
        return updated;
    }

    @Override
    protected VoxelShape getShape(
            BlockState state,
            BlockGetter level,
            BlockPos pos,
            CollisionContext context) {
        return OUTLINE_SHAPES[outlineIndex(state)];
    }

    @Override
    protected VoxelShape getOcclusionShape(BlockState state) {
        // Leaves are transparent. Returning no occlusion prevents Minecraft from
        // hiding neighbouring faces that should remain visible through the hedge.
        return Shapes.empty();
    }

    @Override
    protected boolean skipRendering(
            BlockState state,
            BlockState neighborState,
            Direction direction) {
        // Between two hedges, the connected boundary is genuinely internal and
        // should remain culled. Against other connected blocks (for example
        // leaves or fence gates), keep the hedge boundary face rendered because
        // those neighbours can be transparent/non-full and otherwise expose a hole.
        if (direction.getAxis().isHorizontal() && isConnectedOnSide(state, direction)) {
            return isHedge(neighborState);
        }

        // For vertically stacked hedges, only remove the top/bottom leaf quads
        // when both blocks have the same horizontal footprint. This keeps a clean
        // seam without opening holes for differently shaped stacked hedges.
        if ((direction == Direction.UP || direction == Direction.DOWN)
                && hasSameHorizontalConnections(state, neighborState)) {
            return true;
        }

        return super.skipRendering(state, neighborState, direction);
    }

    @Override
    public TriState canSustainPlant(
            BlockState state,
            BlockGetter level,
            BlockPos soilPosition,
            Direction facing,
            BlockState plant) {
        if (facing == Direction.UP && plant.is(BlockTags.FLOWERS)) {
            return TriState.TRUE;
        }
        return super.canSustainPlant(state, level, soilPosition, facing, plant);
    }
}
