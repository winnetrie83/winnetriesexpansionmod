package be.winnetrie.mod.winnetriesexpansionmod;

import be.winnetrie.mod.winnetriesexpansionmod.registry.ModBlocks;
import be.winnetrie.mod.winnetriesexpansionmod.registry.ModCreativeTabs;
import be.winnetrie.mod.winnetriesexpansionmod.registry.ModConditions;
import be.winnetrie.mod.winnetriesexpansionmod.registry.ModItems;
import be.winnetrie.mod.winnetriesexpansionmod.event.FruitGrowthHandler;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;

@Mod(WinnetriesExpansionMod.MOD_ID)
public final class WinnetriesExpansionMod {
    public static final String MOD_ID = "winnetriesexpansionmod";

    public WinnetriesExpansionMod(IEventBus modEventBus, ModContainer modContainer) {
        ModConditions.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
        NeoForge.EVENT_BUS.register(new FruitGrowthHandler());
        modContainer.registerConfig(ModConfig.Type.COMMON, WemConfig.SPEC);
    }
}
