package be.winnetrie.mod.winnetriesexpansionmod.event;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import be.winnetrie.mod.winnetriesexpansionmod.WemConfig;
import be.winnetrie.mod.winnetriesexpansionmod.WemModule;
import be.winnetrie.mod.winnetriesexpansionmod.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.level.BlockDropsEvent;
import net.neoforged.neoforge.event.level.BlockGrowFeatureEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;

/**
 * Event-driven initial seeding for vanilla cherry saplings.
 *
 * <p>There is deliberately no periodic fruit/leaves world scan. A cherry tree
 * growth event queues exactly one small scan around that newly-grown tree on the
 * next server tick. Regrowth after harvesting is handled entirely by each
 * FruitHangingBlock's own scheduled block tick.</p>
 */
public final class FruitGrowthHandler {
    private static final List<PendingCherrySeed> PENDING_CHERRY_TREES = new ArrayList<>();
    private static final int MAX_INITIAL_CHERRIES = 5;


    /**
     * While WEM fruit trees are enabled, apples come from Apple Trees instead of
     * vanilla Oak/Dark Oak leaf loot. Disabling Fruits leaves vanilla mechanics
     * completely untouched.
     */
    @SubscribeEvent
    public void onVanillaLeafDrops(BlockDropsEvent event) {
        if (!WemConfig.isModuleEnabled(WemModule.FRUITS)) return;
        if (!event.getState().is(Blocks.OAK_LEAVES) && !event.getState().is(Blocks.DARK_OAK_LEAVES)) return;

        event.getDrops().removeIf(drop -> drop.getItem().is(Items.APPLE));
    }

    @SubscribeEvent
    public void onTreeGrowth(BlockGrowFeatureEvent event) {
        if (!WemConfig.isModuleEnabled(WemModule.FRUITS)) return;
        if (!(event.getLevel() instanceof ServerLevel level)) return;
        var feature = event.getFeature();
        if (feature == null) return;

        boolean cherryFeature = feature.unwrapKey()
                .map(key -> key.identifier().getPath().contains("cherry"))
                .orElse(false);
        if (!cherryFeature) return;

        PENDING_CHERRY_TREES.add(new PendingCherrySeed(level, event.getPos().immutable(), level.getGameTime() + 1));
    }

    @SubscribeEvent
    public void onServerTick(ServerTickEvent.Post event) {
        if (PENDING_CHERRY_TREES.isEmpty()) return;

        Iterator<PendingCherrySeed> iterator = PENDING_CHERRY_TREES.iterator();
        while (iterator.hasNext()) {
            PendingCherrySeed pending = iterator.next();
            if (pending.level().getGameTime() < pending.dueTime()) continue;
            seedCherryTree(pending.level(), pending.origin());
            iterator.remove();
        }
    }

    private static void seedCherryTree(ServerLevel level, BlockPos origin) {
        Block cherryFruit = ModBlocks.BLOCKS_BY_ID.get("cherry_hanging_fruit").get();
        int placed = 0;

        // One small, bounded scan only for this freshly grown cherry tree.
        for (BlockPos leafPos : BlockPos.betweenClosed(origin.offset(-4, 1, -4), origin.offset(4, 10, 4))) {
            if (!level.getBlockState(leafPos).is(Blocks.CHERRY_LEAVES)) continue;
            BlockPos fruitPos = leafPos.below();
            if (!level.isEmptyBlock(fruitPos)) continue;
            if (level.getRandom().nextInt(4) != 0) continue;

            level.setBlock(fruitPos, cherryFruit.defaultBlockState(), Block.UPDATE_ALL);
            if (++placed >= MAX_INITIAL_CHERRIES) break;
        }
    }

    private record PendingCherrySeed(ServerLevel level, BlockPos origin, long dueTime) {}
}
