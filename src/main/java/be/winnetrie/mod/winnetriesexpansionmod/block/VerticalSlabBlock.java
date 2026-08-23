package be.winnetrie.mod.winnetriesexpansionmod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

/**
 * A true vertical half-block with four horizontal orientations.
 * A second matching vertical slab can fill the empty half and creates a double slab.
 */
public class VerticalSlabBlock extends Block implements SimpleWaterloggedBlock {
    public static final EnumProperty<VerticalSlabType> TYPE = EnumProperty.create("type", VerticalSlabType.class);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public VerticalSlabBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState()
                .setValue(TYPE, VerticalSlabType.NORTH)
                .setValue(WATERLOGGED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TYPE, WATERLOGGED);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(TYPE).shape;
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(TYPE).shape;
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        BlockState existing = context.getLevel().getBlockState(pos);

        if (existing.getBlock() == this && existing.getValue(TYPE) != VerticalSlabType.DOUBLE) {
            return existing.setValue(TYPE, VerticalSlabType.DOUBLE).setValue(WATERLOGGED, false);
        }

        FluidState fluid = context.getLevel().getFluidState(pos);
        return defaultBlockState()
                .setValue(TYPE, VerticalSlabType.fromDirection(getPlacementSide(context)))
                .setValue(WATERLOGGED, fluid.getType() == Fluids.WATER);
    }

    /**
     * Horizontal-face placement hugs the block that was clicked. Top/bottom
     * placement uses the nearest horizontal half of the clicked square.
     */
    private Direction getPlacementSide(BlockPlaceContext context) {
        Direction clickedFace = context.getClickedFace();
        if (clickedFace.getAxis() != Direction.Axis.Y) {
            return clickedFace.getOpposite();
        }

        BlockPos pos = context.getClickedPos();
        Vec3 hit = context.getClickLocation();
        double dx = hit.x - pos.getX() - 0.5D;
        double dz = hit.z - pos.getZ() - 0.5D;

        if (Math.abs(dx) > Math.abs(dz)) {
            return dx < 0.0D ? Direction.WEST : Direction.EAST;
        }
        return dz < 0.0D ? Direction.NORTH : Direction.SOUTH;
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        VerticalSlabType type = state.getValue(TYPE);
        ItemStack stack = context.getItemInHand();
        if (type == VerticalSlabType.DOUBLE || stack.getItem() != asItem()) {
            return false;
        }

        Direction occupied = type.direction;
        Direction clickedFace = context.getClickedFace();

        // Clicking the exposed centre-cut face fills the opposite half.
        if (clickedFace.getAxis() != Direction.Axis.Y) {
            return clickedFace == occupied.getOpposite();
        }

        // On the top/bottom face, only a click in the empty half combines them.
        return getPlacementSide(context) == occupied.getOpposite();
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED)
                ? Fluids.WATER.getSource(false)
                : super.getFluidState(state);
    }

    public enum VerticalSlabType implements StringRepresentable {
        NORTH(Direction.NORTH, Block.box(0, 0, 0, 16, 16, 8)),
        EAST(Direction.EAST, Block.box(8, 0, 0, 16, 16, 16)),
        SOUTH(Direction.SOUTH, Block.box(0, 0, 8, 16, 16, 16)),
        WEST(Direction.WEST, Block.box(0, 0, 0, 8, 16, 16)),
        DOUBLE(null, Block.box(0, 0, 0, 16, 16, 16));

        public final Direction direction;
        public final VoxelShape shape;
        private final String serializedName;

        VerticalSlabType(Direction direction, VoxelShape shape) {
            this.direction = direction;
            this.shape = shape;
            this.serializedName = direction == null ? "double" : direction.getSerializedName();
        }

        public static VerticalSlabType fromDirection(Direction direction) {
            return switch (direction) {
                case NORTH -> NORTH;
                case EAST -> EAST;
                case SOUTH -> SOUTH;
                case WEST -> WEST;
                default -> NORTH;
            };
        }

        @Override
        public String getSerializedName() {
            return serializedName;
        }
    }
}
