package be.winnetrie.mod.winnetriesexpansionmod;

import java.util.EnumMap;
import java.util.Map;

import net.neoforged.neoforge.common.ModConfigSpec;

/**
 * Common content-module configuration.
 *
 * <p>Registry entries are deliberately never conditionally registered. Turning
 * a module off hides it from WEM's creative tab and disables its recipes/loot;
 * natural-stone modules also disable their world generation through NeoForge
 * data-load conditions. A game/server restart is recommended after changing a
 * module switch.</p>
 */
public final class WemConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    private static final Map<WemModule, ModConfigSpec.BooleanValue> MODULE_VALUES =
            new EnumMap<>(WemModule.class);

    public static final ModConfigSpec.BooleanValue GLASS_VARIANTS;
    public static final ModConfigSpec.BooleanValue WOOL_VARIANTS;
    public static final ModConfigSpec.BooleanValue CONCRETE_VARIANTS;
    public static final ModConfigSpec.BooleanValue TERRACOTTA_VARIANTS;
    public static final ModConfigSpec.BooleanValue TERRACOTTA_BRICKS;
    public static final ModConfigSpec.BooleanValue LIMESTONE;
    public static final ModConfigSpec.BooleanValue MARBLE;
    public static final ModConfigSpec.BooleanValue DREAD_STONE;
    public static final ModConfigSpec.BooleanValue BLOOD_STONE;
    public static final ModConfigSpec.BooleanValue FRUITS;
    public static final ModConfigSpec.BooleanValue DRINKS;

    public static final ModConfigSpec SPEC;

    static {
        BUILDER.comment(
                "WEM content modules. All modules default to true.",
                "Changing these switches is intended to take effect after a game/server restart.",
                "Blocks/items remain registered internally so existing worlds never get missing registry entries."
        ).push("modules");

        GLASS_VARIANTS = module(WemModule.GLASS_VARIANTS,
                "Glass slabs, stairs and walls, including every stained-glass colour.");
        WOOL_VARIANTS = module(WemModule.WOOL_VARIANTS,
                "Wool slabs, stairs and walls for all 16 colours.");
        CONCRETE_VARIANTS = module(WemModule.CONCRETE_VARIANTS,
                "Concrete slabs, stairs and walls for all 16 colours.");
        TERRACOTTA_VARIANTS = module(WemModule.TERRACOTTA_VARIANTS,
                "Vanilla coloured terracotta slabs, stairs and walls.");
        TERRACOTTA_BRICKS = module(WemModule.TERRACOTTA_BRICKS,
                "All stained-clay/coloured-brick content plus Terracotta Bricks and Bricked Terracotta families.");
        LIMESTONE = module(WemModule.LIMESTONE,
                "All Limestone content. Disabling also removes Limestone world generation.");
        MARBLE = module(WemModule.MARBLE,
                "All Marblestone content. Disabling also removes Marblestone world generation.");
        DREAD_STONE = module(WemModule.DREAD_STONE,
                "All Dread Stone content. Disabling also removes Warped Forest generation.");
        BLOOD_STONE = module(WemModule.BLOOD_STONE,
                "All Blood Stone content. Disabling also removes Crimson Forest generation.");
        FRUITS = module(WemModule.FRUITS,
                "Fruit items, fruit saplings, fruit leaves and hanging fruit blocks. When enabled, vanilla apple drops from Oak/Dark Oak leaves are suppressed in favour of Apple Trees.");
        DRINKS = module(WemModule.DRINKS,
                "All bottled WEM drinks, cider and wine. Drinks made from optional WEM fruits additionally require the Fruits module; Apple drinks do not.");

        BUILDER.pop();
        SPEC = BUILDER.build();
    }

    private static ModConfigSpec.BooleanValue module(WemModule module, String comment) {
        ModConfigSpec.BooleanValue value = BUILDER
                .comment(comment)
                .translation("config.winnetriesexpansionmod.modules." + module.id())
                .define(module.id(), true);
        MODULE_VALUES.put(module, value);
        return value;
    }

    public static boolean isModuleEnabled(WemModule module) {
        ModConfigSpec.BooleanValue value = MODULE_VALUES.get(module);
        if (value == null) return true;

        // COMMON configs are loaded before normal game/server data loading. The
        // fallback protects very-early callers and deliberately preserves the
        // default-enabled behaviour until the config becomes available.
        try {
            return value.get();
        } catch (IllegalStateException ignored) {
            return true;
        }
    }

    public static boolean isModuleEnabled(String moduleId) {
        WemModule module = WemModule.byId(moduleId);
        return module != null && isModuleEnabled(module);
    }

    private WemConfig() {}
}
