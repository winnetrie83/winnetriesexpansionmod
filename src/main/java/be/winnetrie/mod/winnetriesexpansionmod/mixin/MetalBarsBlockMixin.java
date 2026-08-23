package be.winnetrie.mod.winnetriesexpansionmod.mixin;

import be.winnetrie.mod.winnetriesexpansionmod.WemConfig;
import be.winnetrie.mod.winnetriesexpansionmod.WemModule;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(IronBarsBlock.class)
public abstract class MetalBarsBlockMixin {
    @Unique private static final BooleanProperty WEM_TOP_RAIL = BooleanProperty.create("wem_top_rail");
    @Unique private static final BooleanProperty WEM_BOTTOM_RAIL = BooleanProperty.create("wem_bottom_rail");
    @Unique private static final BooleanProperty WEM_TOP_NORTH = BooleanProperty.create("wem_top_north");
    @Unique private static final BooleanProperty WEM_TOP_EAST = BooleanProperty.create("wem_top_east");
    @Unique private static final BooleanProperty WEM_TOP_SOUTH = BooleanProperty.create("wem_top_south");
    @Unique private static final BooleanProperty WEM_TOP_WEST = BooleanProperty.create("wem_top_west");

    /**
     * IronBarsBlock declares createBlockStateDefinition itself in Minecraft 26.2,
     * so this is the safe place to append our two rail-visibility booleans. No constructor shadow
     * or registerDefaultState shadow is needed (those methods are inherited from Block).
     */
    @Inject(method = "createBlockStateDefinition", at = @At("TAIL"))
    private void wem$addVerticalRailState(StateDefinition.Builder<Block, BlockState> builder, CallbackInfo ci) {
        builder.add(WEM_TOP_RAIL, WEM_BOTTOM_RAIL, WEM_TOP_NORTH, WEM_TOP_EAST, WEM_TOP_SOUTH, WEM_TOP_WEST);
    }

    @Inject(method = "getStateForPlacement", at = @At("RETURN"), cancellable = true)
    private void wem$setVerticalRailStateOnPlacement(BlockPlaceContext context, CallbackInfoReturnable<BlockState> cir) {
        BlockState state = cir.getReturnValue();
        if (state != null && state.hasProperty(WEM_TOP_RAIL) && state.hasProperty(WEM_BOTTOM_RAIL) && state.hasProperty(WEM_TOP_NORTH)) {
            cir.setReturnValue(wem$withVerticalRailState(state, context.getLevel(), context.getClickedPos()));
        }
    }

    @Inject(method = "updateShape", at = @At("RETURN"), cancellable = true)
    private void wem$refreshVerticalRailState(
            BlockState state,
            LevelReader level,
            ScheduledTickAccess ticks,
            BlockPos pos,
            Direction directionToNeighbour,
            BlockPos neighbourPos,
            BlockState neighbourState,
            RandomSource random,
            CallbackInfoReturnable<BlockState> cir) {
        BlockState result = cir.getReturnValue();
        if (result != null && result.hasProperty(WEM_TOP_RAIL) && result.hasProperty(WEM_BOTTOM_RAIL) && result.hasProperty(WEM_TOP_NORTH)) {
            cir.setReturnValue(wem$withVerticalRailState(result, level, pos));
        }
    }

    @Unique
    private static BlockState wem$withVerticalRailState(BlockState state, LevelReader level, BlockPos pos) {
        if (!WemConfig.isModuleEnabled(WemModule.VANILLA_3D_BLOCKS)) {
            return state.setValue(WEM_TOP_RAIL, Boolean.TRUE)
                    .setValue(WEM_BOTTOM_RAIL, Boolean.TRUE)
                    .setValue(WEM_TOP_NORTH, Boolean.FALSE)
                    .setValue(WEM_TOP_EAST, Boolean.FALSE)
                    .setValue(WEM_TOP_SOUTH, Boolean.FALSE)
                    .setValue(WEM_TOP_WEST, Boolean.FALSE);
        }

        BlockState above = level.getBlockState(pos.above());
        BlockState below = level.getBlockState(pos.below());

        boolean hasMetalBarsAbove = wem$isMetalBars(above);
        boolean hasMetalBarsBelow = wem$isMetalBars(below);

        boolean topNorth = hasMetalBarsAbove
                && state.getValue(IronBarsBlock.NORTH) != above.getValue(IronBarsBlock.NORTH);
        boolean topEast = hasMetalBarsAbove
                && state.getValue(IronBarsBlock.EAST) != above.getValue(IronBarsBlock.EAST);
        boolean topSouth = hasMetalBarsAbove
                && state.getValue(IronBarsBlock.SOUTH) != above.getValue(IronBarsBlock.SOUTH);
        boolean topWest = hasMetalBarsAbove
                && state.getValue(IronBarsBlock.WEST) != above.getValue(IronBarsBlock.WEST);

        return state.setValue(WEM_TOP_RAIL, !hasMetalBarsAbove)
                .setValue(WEM_BOTTOM_RAIL, !hasMetalBarsBelow)
                .setValue(WEM_TOP_NORTH, topNorth)
                .setValue(WEM_TOP_EAST, topEast)
                .setValue(WEM_TOP_SOUTH, topSouth)
                .setValue(WEM_TOP_WEST, topWest);
    }

    @Unique
    private static boolean wem$isMetalBars(BlockState state) {
        var key = BuiltInRegistries.BLOCK.getKey(state.getBlock());
        if (key == null || !"minecraft".equals(key.getNamespace())) {
            return false;
        }
        return switch (key.getPath()) {
            case "iron_bars",
                 "copper_bars",
                 "exposed_copper_bars",
                 "weathered_copper_bars",
                 "oxidized_copper_bars",
                 "waxed_copper_bars",
                 "waxed_exposed_copper_bars",
                 "waxed_weathered_copper_bars",
                 "waxed_oxidized_copper_bars" -> true;
            default -> false;
        };
    }
}
