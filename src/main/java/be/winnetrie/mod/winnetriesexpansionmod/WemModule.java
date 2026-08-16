package be.winnetrie.mod.winnetriesexpansionmod;

import java.util.Set;

/**
 * User-facing content modules. Registry entries stay stable for save compatibility;
 * the module switches control visibility and data-driven obtainability/worldgen.
 */
public enum WemModule {
    GLASS_VARIANTS("glass_variants"),
    WOOL_VARIANTS("wool_variants"),
    CONCRETE_VARIANTS("concrete_variants"),
    TERRACOTTA_VARIANTS("terracotta_variants"),
    TERRACOTTA_BRICKS("terracotta_bricks"),
    LIMESTONE("limestone"),
    MARBLE("marble"),
    DREAD_STONE("dread_stone"),
    BLOOD_STONE("blood_stone"),
    FRUITS("fruits"),
    DRINKS("drinks");

    /**
     * Drinks whose normal availability depends on fruit supplied by WEM's optional
     * Fruits module. Apple drinks are deliberately absent: vanilla apples exist even
     * when Fruits is disabled. Future orange/peach/pear drinks are listed already so
     * their dependency cannot accidentally be forgotten when their recipes are added.
     */
    private static final Set<String> OPTIONAL_FRUIT_DRINKS = Set.of(
            "orange_juice_bottle",
            "peach_juice_bottle",
            "pear_juice_bottle",
            "cherry_juice_bottle",
            "lemon_juice_bottle",
            "plum_juice_bottle",
            "plum_wine_bottle"
    );

    private final String id;

    WemModule(String id) {
        this.id = id;
    }

    public String id() {
        return this.id;
    }

    public static WemModule byId(String id) {
        for (WemModule module : values()) {
            if (module.id.equals(id)) {
                return module;
            }
        }
        return null;
    }

    /**
     * Returns the module owning a registered WEM block/item id, or {@code null}
     * for content that is intentionally always enabled.
     */
    public static WemModule forContentId(String id) {
        if (id.startsWith("limestone")) return LIMESTONE;
        if (id.equals("orange") || id.equals("peach") || id.equals("pear") || id.equals("plum") || id.equals("lemon") || id.equals("cherry")
                || id.endsWith("_sapling") || id.endsWith("_leaves") || id.endsWith("_hanging_fruit")) return FRUITS;
        if (id.startsWith("marblestone")) return MARBLE;
        if (id.startsWith("dread_stone")) return DREAD_STONE;
        if (id.startsWith("blood_stone")) return BLOOD_STONE;

        if (id.endsWith("_bottle")) return DRINKS;

        // One all-or-nothing family: stained clay, stained clayballs, coloured
        // bricks, Terracotta Bricks and Bricked Terracotta.
        if (id.contains("terracotta_bricks")
                || id.contains("bricked_terracotta")
                || id.contains("stained_clay")
                || id.endsWith("_brick")) {
            return TERRACOTTA_BRICKS;
        }

        // Vanilla terracotta shape variants. Legacy lightblue/silver ids are
        // intentionally accepted here too.
        if (id.endsWith("_terracotta_halfslab")
                || id.endsWith("_terracotta_stairs")
                || id.endsWith("_terracotta_wall")) {
            return TERRACOTTA_VARIANTS;
        }

        if (id.contains("_concrete_")) return CONCRETE_VARIANTS;
        if (id.contains("_wool_")) return WOOL_VARIANTS;
        if (id.equals("glass_halfslab")
                || id.equals("glass_stairs")
                || id.equals("glass_wall")
                || id.contains("_stained_glass_")) {
            return GLASS_VARIANTS;
        }

        return null;
    }

    public static boolean isContentEnabled(String id) {
        // Drinks have one extra dependency layer. A drink is always gated by the
        // Drinks module; drinks made from optional WEM fruit additionally require
        // the Fruits module. Apple juice/cider intentionally remain independent.
        if (id.endsWith("_bottle")) {
            return isDrinkEnabled(id);
        }

        WemModule module = forContentId(id);
        return module == null || WemConfig.isModuleEnabled(module);
    }

    public static boolean isDrinkEnabled(String id) {
        if (!WemConfig.isModuleEnabled(DRINKS)) return false;
        return !OPTIONAL_FRUIT_DRINKS.contains(id) || WemConfig.isModuleEnabled(FRUITS);
    }

    public static boolean drinkRequiresFruits(String id) {
        return OPTIONAL_FRUIT_DRINKS.contains(id);
    }
}
