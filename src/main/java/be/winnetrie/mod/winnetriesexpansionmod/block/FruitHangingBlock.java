package be.winnetrie.mod.winnetriesexpansionmod.block;

import be.winnetrie.mod.winnetriesexpansionmod.registry.ModBlocks;
import be.winnetrie.mod.winnetriesexpansionmod.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * Harvestable fruit hanging below a supporting leaf.
 *
 * <p>After harvesting the block stays as an invisible unripe state and uses one
 * vanilla scheduled block tick to become ripe again. There is no periodic world
 * scan for regrowth.</p>
 */
public class FruitHangingBlock extends Block {
    public static final BooleanProperty RIPE = BooleanProperty.create("ripe");

    private static final VoxelShape RIPE_SHAPE = Block.box(4.0D, 8.0D, 4.0D, 12.0D, 16.0D, 12.0D);
    private static final int MIN_REGROW_TICKS = 600;   // 30 seconds
    private static final int EXTRA_REGROW_TICKS = 601; // up to 60 seconds total

    private final String fruitId;

    public FruitHangingBlock(String fruitId, BlockBehaviour.Properties properties) {
        super(properties);
        this.fruitId = fruitId;
        this.registerDefaultState(this.stateDefinition.any().setValue(RIPE, true));
    }

    public String fruitId() {
        return this.fruitId;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(RIPE);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(RIPE) ? RIPE_SHAPE : Shapes.empty();
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState above = level.getBlockState(pos.above());
        if (this.fruitId.equals("cherry")) {
            return above.is(Blocks.CHERRY_LEAVES);
        }
        var leaves = ModBlocks.BLOCKS_BY_ID.get(this.fruitId + "_leaves");
        return leaves != null && above.is(leaves.get());
    }

    /** Empty-hand right click: always harvest one ripe fruit. */
    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        if (!state.getValue(RIPE)) return InteractionResult.PASS;
        if (!level.isClientSide() && level instanceof ServerLevel serverLevel) {
            harvest(serverLevel, pos, state, 1);
        }
        return InteractionResult.SUCCESS;
    }

    /**
     * Right click with any item also harvests the fruit. A hoe with Fortune gets
     * a Fortune-scaled yield: 1 + random(0..fortuneLevel).
     */
    @Override
    protected InteractionResult useItemOn(ItemStack itemStack, BlockState state, Level level, BlockPos pos,
                                          Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!state.getValue(RIPE)) return InteractionResult.PASS;
        if (!level.isClientSide() && level instanceof ServerLevel serverLevel) {
            int count = 1;
            if (itemStack.is(ItemTags.HOES)) {
                var fortune = level.registryAccess()
                        .lookupOrThrow(Registries.ENCHANTMENT)
                        .getOrThrow(Enchantments.FORTUNE);
                int fortuneLevel = itemStack.getEnchantmentLevel(fortune);
                if (fortuneLevel > 0) {
                    count += serverLevel.getRandom().nextInt(fortuneLevel + 1);
                }
            }
            harvest(serverLevel, pos, state, count);
        }
        return InteractionResult.SUCCESS;
    }

    /** Creative middle-click returns the fruit item, never the internal block. */
    @Override
    public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state, boolean includeData, Player player) {
        return fruitStack(1);
    }

    /**
     * Mining/breaking the ripe fruit behaves as harvesting rather than removing
     * the internal regrowth block. This also makes Creative breaking drop fruit.
     */
    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player,
                                       ItemStack toolStack, boolean willHarvest, FluidState fluid) {
        if (!state.getValue(RIPE)) return false;
        if (level.isClientSide()) {
            // Mirror vanilla/NeoForge client-side block-break prediction: remove the
            // fruit visually instead of switching to the invisible RIPE=false state.
            // ClientLevel's breaking-particle code asks the current shape for bounds;
            // our unripe state intentionally has Shapes.empty(), which would crash.
            return level.setBlock(pos, fluid.createLegacyBlock(), 11);
        }
        if (level instanceof ServerLevel serverLevel) {
            harvest(serverLevel, pos, state, 1);
        }
        return false;
    }

    private void harvest(ServerLevel level, BlockPos pos, BlockState state, int count) {
        Block.popResource(level, pos, fruitStack(count));
        level.setBlock(pos, state.setValue(RIPE, false), Block.UPDATE_ALL);
        level.scheduleTick(pos, this, MIN_REGROW_TICKS + level.getRandom().nextInt(EXTRA_REGROW_TICKS));
    }

    private ItemStack fruitStack(int count) {
        if (this.fruitId.equals("apple")) {
            return new ItemStack(Items.APPLE, count);
        }
        var item = ModItems.ITEMS_BY_ID.get(this.fruitId);
        return item == null ? ItemStack.EMPTY : new ItemStack(item.get(), count);
    }

    /** The one scheduled regrowth tick for an harvested fruit. */
    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!state.canSurvive(level, pos)) {
            level.removeBlock(pos, false);
            return;
        }
        if (!state.getValue(RIPE)) {
            level.setBlock(pos, state.setValue(RIPE, true), Block.UPDATE_ALL);
        }
    }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks,
                                     BlockPos pos, Direction directionToNeighbour, BlockPos neighbourPos,
                                     BlockState neighbourState, RandomSource random) {
        if (directionToNeighbour == Direction.UP && !state.canSurvive(level, pos)) {
            return Blocks.AIR.defaultBlockState();
        }
        return super.updateShape(state, level, ticks, pos, directionToNeighbour, neighbourPos, neighbourState, random);
    }
}
