package be.winnetrie.mod.winnetriesexpansionmod.registry;

import be.winnetrie.mod.winnetriesexpansionmod.WinnetriesExpansionMod;
import be.winnetrie.mod.winnetriesexpansionmod.worldgen.CherryFruitSeederFeature;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(Registries.FEATURE, WinnetriesExpansionMod.MOD_ID);

    public static final Holder<Feature<?>> CHERRY_FRUIT_SEEDER = FEATURES.register(
            "cherry_fruit_seeder",
            () -> new CherryFruitSeederFeature(NoneFeatureConfiguration.CODEC));

    private ModFeatures() {}

    public static void register(IEventBus modEventBus) {
        FEATURES.register(modEventBus);
    }
}
