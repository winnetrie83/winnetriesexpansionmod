package be.winnetrie.mod.winnetriesexpansionmod.mixin;

import java.util.Map;

import be.winnetrie.mod.winnetriesexpansionmod.WemConfig;
import be.winnetrie.mod.winnetriesexpansionmod.WemModule;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Keeps the vanilla ladder's selection/interaction shape aligned with WEM's
 * optional one-pixel-deep 3D ladder model.
 *
 * <p>Vanilla 26.2 uses a three-pixel-deep ladder shape (13..16). WEM's
 * 3D model is only one pixel deep (15..16), so the outline would otherwise
 * visibly stick out beyond the model.</p>
 */
@Mixin(LadderBlock.class)
public abstract class LadderBlockMixin {
    private static final Map<Direction, VoxelShape> WEM_THIN_LADDER_SHAPES =
            Shapes.rotateHorizontal(Block.boxZ(16.0, 15.0, 16.0));

    @Inject(method = "getShape", at = @At("HEAD"), cancellable = true)
    private void wem$useThin3dLadderShape(
            BlockState state,
            BlockGetter level,
            BlockPos pos,
            CollisionContext context,
            CallbackInfoReturnable<VoxelShape> cir) {
        if (WemConfig.isModuleEnabled(WemModule.VANILLA_3D_BLOCKS)) {
            cir.setReturnValue(WEM_THIN_LADDER_SHAPES.get(state.getValue(LadderBlock.FACING)));
        }
    }
}
