package be.winnetrie.mod.winnetriesexpansionmod.block;

import be.winnetrie.mod.winnetriesexpansionmod.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.TintedParticleLeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

/** Fruit-bearing leaves. */
public class FruitLeavesBlock extends TintedParticleLeavesBlock {
    private static final float LEAF_PARTICLE_CHANCE = 0.01F;

    private final String fruitId;

    public FruitLeavesBlock(String fruitId, BlockBehaviour.Properties properties) {
        super(LEAF_PARTICLE_CHANCE, properties);
        this.fruitId = fruitId;
    }

    public String fruitId() {
        return this.fruitId;
    }

    /** Creative middle-click gives the hidden leaves BlockItem. */
    @Override
    public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state, boolean includeData, Player player) {
        var item = ModItems.BLOCK_ITEMS_BY_ID.get(this.fruitId + "_leaves");
        return item == null ? ItemStack.EMPTY : new ItemStack(item.get());
    }
}
