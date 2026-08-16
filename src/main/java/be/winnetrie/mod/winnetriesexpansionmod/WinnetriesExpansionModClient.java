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
}
