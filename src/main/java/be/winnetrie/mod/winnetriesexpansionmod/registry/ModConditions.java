package be.winnetrie.mod.winnetriesexpansionmod.registry;

import java.util.function.Supplier;

import be.winnetrie.mod.winnetriesexpansionmod.WinnetriesExpansionMod;
import be.winnetrie.mod.winnetriesexpansionmod.condition.ModuleEnabledCondition;
import com.mojang.serialization.MapCodec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

/** Registers WEM's custom data-load conditions. */
public final class ModConditions {
    public static final DeferredRegister<MapCodec<? extends ICondition>> CONDITION_CODECS =
            DeferredRegister.create(NeoForgeRegistries.Keys.CONDITION_CODECS, WinnetriesExpansionMod.MOD_ID);

    public static final Supplier<MapCodec<ModuleEnabledCondition>> MODULE_ENABLED =
            CONDITION_CODECS.register("module_enabled", () -> ModuleEnabledCondition.CODEC);

    public static void register(IEventBus modEventBus) {
        CONDITION_CODECS.register(modEventBus);
    }

    private ModConditions() {}
}
