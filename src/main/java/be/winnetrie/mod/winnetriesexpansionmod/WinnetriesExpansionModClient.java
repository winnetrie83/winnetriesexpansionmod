package be.winnetrie.mod.winnetriesexpansionmod;

import java.util.List;

import be.winnetrie.mod.winnetriesexpansionmod.registry.ModBlocks;
import net.minecraft.client.color.block.BlockTintSources;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

/** Client-only bootstrap for Winnetrie's Expansion Mod. */
@Mod(value = WinnetriesExpansionMod.MOD_ID, dist = Dist.CLIENT)
public final class WinnetriesExpansionModClient {
    // A stable foliage green used only by tint-aware fruit-leaf particles/models.
    private static final int FRUIT_LEAF_TINT = 0xFF6A8E3A;

    public WinnetriesExpansionModClient(IEventBus modEventBus, ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
        modEventBus.addListener(WinnetriesExpansionModClient::registerFruitLeafColors);
        modEventBus.addListener(WinnetriesExpansionModClient::registerHedgeColors);
    }

    private static void registerFruitLeafColors(RegisterColorHandlersEvent.BlockTintSources event) {
        var tint = List.of(BlockTintSources.constant(FRUIT_LEAF_TINT));
        event.register(tint,
                ModBlocks.BLOCKS_BY_ID.get("apple_leaves").get(),
                ModBlocks.BLOCKS_BY_ID.get("orange_leaves").get(),
                ModBlocks.BLOCKS_BY_ID.get("peach_leaves").get(),
                ModBlocks.BLOCKS_BY_ID.get("pear_leaves").get(),
                ModBlocks.BLOCKS_BY_ID.get("plum_leaves").get(),
                ModBlocks.BLOCKS_BY_ID.get("lemon_leaves").get());
    }

    private static void registerHedgeColors(RegisterColorHandlersEvent.BlockTintSources event) {
        // Biome-tinted vanilla foliage.
        event.register(List.of(BlockTintSources.foliage()),
                ModBlocks.BLOCKS_BY_ID.get("oak_hedge").get(),
                ModBlocks.BLOCKS_BY_ID.get("jungle_hedge").get(),
                ModBlocks.BLOCKS_BY_ID.get("acacia_hedge").get(),
                ModBlocks.BLOCKS_BY_ID.get("dark_oak_hedge").get(),
                ModBlocks.BLOCKS_BY_ID.get("mangrove_hedge").get());

        // Vanilla uses stable special colours for spruce and birch foliage.
        event.register(List.of(BlockTintSources.constant(0xFF619961)),
                ModBlocks.BLOCKS_BY_ID.get("spruce_hedge").get());
        event.register(List.of(BlockTintSources.constant(0xFF80A755)),
                ModBlocks.BLOCKS_BY_ID.get("birch_hedge").get());
}
}
