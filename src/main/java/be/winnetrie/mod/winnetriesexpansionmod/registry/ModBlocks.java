package be.winnetrie.mod.winnetriesexpansionmod.registry;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import be.winnetrie.mod.winnetriesexpansionmod.WinnetriesExpansionMod;
import be.winnetrie.mod.winnetriesexpansionmod.block.FruitHangingBlock;
import be.winnetrie.mod.winnetriesexpansionmod.block.GlassStairBlock;
import be.winnetrie.mod.winnetriesexpansionmod.block.HedgeBlock;
import be.winnetrie.mod.winnetriesexpansionmod.block.VerticalSlabBlock;
import be.winnetrie.mod.winnetriesexpansionmod.block.FruitLeavesBlock;
import be.winnetrie.mod.winnetriesexpansionmod.block.FruitSaplingBlock;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

/** Registers blocks only. Special behaviour should live in dedicated block classes. */
public final class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(WinnetriesExpansionMod.MOD_ID);
    public static final Map<String, DeferredBlock<? extends Block>> BLOCKS_BY_ID = new LinkedHashMap<>();

    private static final List<String> VANILLA_DYE_COLORS = List.of(
            "white", "orange", "magenta", "light_blue",
            "yellow", "lime", "pink", "gray",
            "light_gray", "cyan", "purple", "blue",
            "brown", "green", "red", "black"
    );

    private static final List<String> FRUIT_TYPES = List.of("apple", "orange", "peach", "pear", "plum", "lemon");

    private static final List<String> BASIC_BLOCKS = List.of(
            "black_terracotta_bricks",
            "black_stained_clay",
            "black_bricked_terracotta",
            "blue_terracotta_bricks",
            "blue_stained_clay",
            "blue_bricked_terracotta",
            "brown_terracotta_bricks",
            "brown_stained_clay",
            "brown_bricked_terracotta",
            "cyan_terracotta_bricks",
            "cyan_stained_clay",
            "cyan_bricked_terracotta",
            "bricked_terracotta",
            "terracotta_bricks",
            "blood_stone",
            "blood_stone_brick",
            "blood_stone_smooth",
            "dread_stone",
            "dread_stone_brick",
            "dread_stone_smooth",
            "gray_terracotta_bricks",
            "gray_stained_clay",
            "gray_bricked_terracotta",
            "green_terracotta_bricks",
            "green_stained_clay",
            "green_bricked_terracotta",
            "light_blue_terracotta_bricks",
            "lightblue_stained_clay",
            "light_blue_bricked_terracotta",
            "lime_terracotta_bricks",
            "lime_stained_clay",
            "lime_bricked_terracotta",
            "limestone",
            "limestone_brick",
            "limestone_carved_brick",
            "limestone_cobble",
            "limestone_cracked_brick",
            "limestone_mossy_brick",
            "limestone_mossy_cobble",
            "magenta_terracotta_bricks",
            "magenta_stained_clay",
            "magenta_bricked_terracotta",
            "marblestone",
            "marblestone_brick",
            "marblestone_carved_brick",
            "marblestone_cobble",
            "marblestone_cracked_brick",
            "marblestone_mossy_brick",
            "marblestone_mossy_cobble",
            "orange_terracotta_bricks",
            "orange_stained_clay",
            "orange_bricked_terracotta",
            "pink_terracotta_bricks",
            "pink_stained_clay",
            "pink_bricked_terracotta",
            "purple_terracotta_bricks",
            "purple_stained_clay",
            "purple_bricked_terracotta",
            "red_terracotta_bricks",
            "red_stained_clay",
            "red_bricked_terracotta",
            "light_gray_terracotta_bricks",
            "silver_stained_clay",
            "light_gray_bricked_terracotta",
            "white_terracotta_bricks",
            "white_stained_clay",
            "white_bricked_terracotta",
            "yellow_terracotta_bricks",
            "yellow_stained_clay",
            "yellow_bricked_terracotta"
    );
    private static final List<String> SLABS = List.of(
            "black_terracotta_bricks_halfslab",
            "black_concrete_halfslab",
            "black_bricked_terracotta_halfslab",
            "black_terracotta_halfslab",
            "blue_terracotta_bricks_halfslab",
            "blue_concrete_halfslab",
            "blue_bricked_terracotta_halfslab",
            "blue_terracotta_halfslab",
            "brown_terracotta_bricks_halfslab",
            "brown_concrete_halfslab",
            "brown_bricked_terracotta_halfslab",
            "brown_terracotta_halfslab",
            "cyan_terracotta_bricks_halfslab",
            "cyan_concrete_halfslab",
            "cyan_bricked_terracotta_halfslab",
            "cyan_terracotta_halfslab",
            "bricked_terracotta_halfslab",
            "terracotta_bricks_halfslab",
            "blood_stone_halfslab",
            "blood_stone_brick_halfslab",
            "blood_stone_smooth_halfslab",
            "dread_stone_halfslab",
            "dread_stone_brick_halfslab",
            "dread_stone_smooth_halfslab",
            "gray_terracotta_bricks_halfslab",
            "gray_concrete_halfslab",
            "gray_bricked_terracotta_halfslab",
            "gray_terracotta_halfslab",
            "green_terracotta_bricks_halfslab",
            "green_concrete_halfslab",
            "green_bricked_terracotta_halfslab",
            "green_terracotta_halfslab",
            "light_blue_terracotta_bricks_halfslab",
            "lightblue_concrete_halfslab",
            "light_blue_bricked_terracotta_halfslab",
            "lightblue_terracotta_halfslab",
            "lime_terracotta_bricks_halfslab",
            "lime_concrete_halfslab",
            "lime_bricked_terracotta_halfslab",
            "lime_terracotta_halfslab",
            "limestone_brick_halfslab",
            "limestone_cobble_halfslab",
            "limestone_cracked_brick_halfslab",
            "limestone_halfslab",
            "magenta_terracotta_bricks_halfslab",
            "magenta_concrete_halfslab",
            "magenta_bricked_terracotta_halfslab",
            "magenta_terracotta_halfslab",
            "marblestone_brick_halfslab",
            "marblestone_cobble_halfslab",
            "marblestone_cracked_brick_halfslab",
            "marblestone_halfslab",
            "orange_terracotta_bricks_halfslab",
            "orange_concrete_halfslab",
            "orange_bricked_terracotta_halfslab",
            "orange_terracotta_halfslab",
            "pink_terracotta_bricks_halfslab",
            "pink_concrete_halfslab",
            "pink_bricked_terracotta_halfslab",
            "pink_terracotta_halfslab",
            "purple_terracotta_bricks_halfslab",
            "purple_concrete_halfslab",
            "purple_bricked_terracotta_halfslab",
            "purple_terracotta_halfslab",
            "red_terracotta_bricks_halfslab",
            "red_concrete_halfslab",
            "red_bricked_terracotta_halfslab",
            "red_terracotta_halfslab",
            "light_gray_terracotta_bricks_halfslab",
            "silver_concrete_halfslab",
            "light_gray_bricked_terracotta_halfslab",
            "silver_terracotta_halfslab",
            "white_terracotta_bricks_halfslab",
            "white_concrete_halfslab",
            "white_bricked_terracotta_halfslab",
            "white_terracotta_halfslab",
            "yellow_terracotta_bricks_halfslab",
            "yellow_concrete_halfslab",
            "yellow_bricked_terracotta_halfslab",
            "yellow_terracotta_halfslab"
    );
    private static final List<String> STAIRS = List.of(
            "black_terracotta_bricks_stairs",
            "black_concrete_stairs",
            "black_bricked_terracotta_stairs",
            "black_terracotta_stairs",
            "blue_terracotta_bricks_stairs",
            "blue_concrete_stairs",
            "blue_bricked_terracotta_stairs",
            "blue_terracotta_stairs",
            "brown_terracotta_bricks_stairs",
            "brown_concrete_stairs",
            "brown_bricked_terracotta_stairs",
            "brown_terracotta_stairs",
            "cyan_terracotta_bricks_stairs",
            "cyan_concrete_stairs",
            "cyan_bricked_terracotta_stairs",
            "cyan_terracotta_stairs",
            "bricked_terracotta_stairs",
            "terracotta_bricks_stairs",
            "blood_stone_stairs",
            "blood_stone_brick_stairs",
            "blood_stone_smooth_stairs",
            "dread_stone_stairs",
            "dread_stone_brick_stairs",
            "dread_stone_smooth_stairs",
            "gray_terracotta_bricks_stairs",
            "gray_concrete_stairs",
            "gray_bricked_terracotta_stairs",
            "gray_terracotta_stairs",
            "green_terracotta_bricks_stairs",
            "green_concrete_stairs",
            "green_bricked_terracotta_stairs",
            "green_terracotta_stairs",
            "light_blue_terracotta_bricks_stairs",
            "lightblue_concrete_stairs",
            "light_blue_bricked_terracotta_stairs",
            "lightblue_terracotta_stairs",
            "lime_terracotta_bricks_stairs",
            "lime_concrete_stairs",
            "lime_bricked_terracotta_stairs",
            "lime_terracotta_stairs",
            "limestone_brick_stairs",
            "limestone_cobble_stairs",
            "limestone_cracked_brick_stairs",
            "magenta_terracotta_bricks_stairs",
            "magenta_concrete_stairs",
            "magenta_bricked_terracotta_stairs",
            "magenta_terracotta_stairs",
            "marblestone_brick_stairs",
            "marblestone_cobble_stairs",
            "marblestone_cracked_brick_stairs",
            "orange_terracotta_bricks_stairs",
            "orange_concrete_stairs",
            "orange_bricked_terracotta_stairs",
            "orange_terracotta_stairs",
            "pink_terracotta_bricks_stairs",
            "pink_concrete_stairs",
            "pink_bricked_terracotta_stairs",
            "pink_terracotta_stairs",
            "purple_terracotta_bricks_stairs",
            "purple_concrete_stairs",
            "purple_bricked_terracotta_stairs",
            "purple_terracotta_stairs",
            "red_terracotta_bricks_stairs",
            "red_concrete_stairs",
            "red_bricked_terracotta_stairs",
            "red_terracotta_stairs",
            "light_gray_terracotta_bricks_stairs",
            "silver_concrete_stairs",
            "light_gray_bricked_terracotta_stairs",
            "silver_terracotta_stairs",
            "white_terracotta_bricks_stairs",
            "white_concrete_stairs",
            "white_bricked_terracotta_stairs",
            "white_terracotta_stairs",
            "yellow_terracotta_bricks_stairs",
            "yellow_concrete_stairs",
            "yellow_bricked_terracotta_stairs",
            "yellow_terracotta_stairs"
    );
    private static final List<String> WALLS = List.of(
            "black_terracotta_bricks_wall",
            "black_concrete_wall",
            "black_bricked_terracotta_wall",
            "black_terracotta_wall",
            "blue_terracotta_bricks_wall",
            "blue_concrete_wall",
            "blue_bricked_terracotta_wall",
            "blue_terracotta_wall",
            "brown_terracotta_bricks_wall",
            "brown_concrete_wall",
            "brown_bricked_terracotta_wall",
            "brown_terracotta_wall",
            "cyan_terracotta_bricks_wall",
            "cyan_concrete_wall",
            "cyan_bricked_terracotta_wall",
            "cyan_terracotta_wall",
            "bricked_terracotta_wall",
            "terracotta_bricks_wall",
            "blood_stone_wall",
            "blood_stone_brick_wall",
            "blood_stone_smooth_wall",
            "dread_stone_wall",
            "dread_stone_brick_wall",
            "dread_stone_smooth_wall",
            "gray_terracotta_bricks_wall",
            "gray_concrete_wall",
            "gray_bricked_terracotta_wall",
            "gray_terracotta_wall",
            "green_terracotta_bricks_wall",
            "green_concrete_wall",
            "green_bricked_terracotta_wall",
            "green_terracotta_wall",
            "light_blue_terracotta_bricks_wall",
            "lightblue_concrete_wall",
            "light_blue_bricked_terracotta_wall",
            "lightblue_terracotta_wall",
            "lime_terracotta_bricks_wall",
            "lime_concrete_wall",
            "lime_bricked_terracotta_wall",
            "lime_terracotta_wall",
            "limestone_brick_wall",
            "limestone_cobble_wall",
            "limestone_cracked_brick_wall",
            "limestone_mossy_cobble_wall",
            "magenta_terracotta_bricks_wall",
            "magenta_concrete_wall",
            "magenta_bricked_terracotta_wall",
            "magenta_terracotta_wall",
            "marblestone_brick_wall",
            "marblestone_cobble_wall",
            "marblestone_cracked_brick_wall",
            "marblestone_mossy_cobble_wall",
            "orange_terracotta_bricks_wall",
            "orange_concrete_wall",
            "orange_bricked_terracotta_wall",
            "orange_terracotta_wall",
            "pink_terracotta_bricks_wall",
            "pink_concrete_wall",
            "pink_bricked_terracotta_wall",
            "pink_terracotta_wall",
            "purple_terracotta_bricks_wall",
            "purple_concrete_wall",
            "purple_bricked_terracotta_wall",
            "purple_terracotta_wall",
            "red_terracotta_bricks_wall",
            "red_concrete_wall",
            "red_bricked_terracotta_wall",
            "red_terracotta_wall",
            "light_gray_terracotta_bricks_wall",
            "silver_concrete_wall",
            "light_gray_bricked_terracotta_wall",
            "silver_terracotta_wall",
            "white_terracotta_bricks_wall",
            "white_concrete_wall",
            "white_bricked_terracotta_wall",
            "white_terracotta_wall",
            "yellow_terracotta_bricks_wall",
            "yellow_concrete_wall",
            "yellow_bricked_terracotta_wall",
            "yellow_terracotta_wall"
    );

    private static final List<Map.Entry<String, Block>> VANILLA_VERTICAL_SLAB_SOURCES = List.of(
            Map.entry("oak_slab", Blocks.OAK_SLAB),
            Map.entry("spruce_slab", Blocks.SPRUCE_SLAB),
            Map.entry("birch_slab", Blocks.BIRCH_SLAB),
            Map.entry("jungle_slab", Blocks.JUNGLE_SLAB),
            Map.entry("acacia_slab", Blocks.ACACIA_SLAB),
            Map.entry("dark_oak_slab", Blocks.DARK_OAK_SLAB),
            Map.entry("pale_oak_slab", Blocks.PALE_OAK_SLAB),
            Map.entry("crimson_slab", Blocks.CRIMSON_SLAB),
            Map.entry("warped_slab", Blocks.WARPED_SLAB),
            Map.entry("mangrove_slab", Blocks.MANGROVE_SLAB),
            Map.entry("bamboo_slab", Blocks.BAMBOO_SLAB),
            Map.entry("cherry_slab", Blocks.CHERRY_SLAB),
            Map.entry("bamboo_mosaic_slab", Blocks.BAMBOO_MOSAIC_SLAB),
            Map.entry("stone_slab", Blocks.STONE_SLAB),
            Map.entry("smooth_stone_slab", Blocks.SMOOTH_STONE_SLAB),
            Map.entry("stone_brick_slab", Blocks.STONE_BRICK_SLAB),
            Map.entry("sandstone_slab", Blocks.SANDSTONE_SLAB),
            Map.entry("purpur_slab", Blocks.PURPUR_SLAB),
            Map.entry("quartz_slab", Blocks.QUARTZ_SLAB),
            Map.entry("red_sandstone_slab", Blocks.RED_SANDSTONE_SLAB),
            Map.entry("brick_slab", Blocks.BRICK_SLAB),
            Map.entry("cobblestone_slab", Blocks.COBBLESTONE_SLAB),
            Map.entry("nether_brick_slab", Blocks.NETHER_BRICK_SLAB),
            Map.entry("prismarine_slab", Blocks.PRISMARINE_SLAB),
            Map.entry("prismarine_brick_slab", Blocks.PRISMARINE_BRICK_SLAB),
            Map.entry("dark_prismarine_slab", Blocks.DARK_PRISMARINE_SLAB),
            Map.entry("polished_granite_slab", Blocks.POLISHED_GRANITE_SLAB),
            Map.entry("smooth_red_sandstone_slab", Blocks.SMOOTH_RED_SANDSTONE_SLAB),
            Map.entry("mossy_stone_brick_slab", Blocks.MOSSY_STONE_BRICK_SLAB),
            Map.entry("polished_diorite_slab", Blocks.POLISHED_DIORITE_SLAB),
            Map.entry("mossy_cobblestone_slab", Blocks.MOSSY_COBBLESTONE_SLAB),
            Map.entry("end_stone_brick_slab", Blocks.END_STONE_BRICK_SLAB),
            Map.entry("smooth_sandstone_slab", Blocks.SMOOTH_SANDSTONE_SLAB),
            Map.entry("smooth_quartz_slab", Blocks.SMOOTH_QUARTZ_SLAB),
            Map.entry("granite_slab", Blocks.GRANITE_SLAB),
            Map.entry("andesite_slab", Blocks.ANDESITE_SLAB),
            Map.entry("red_nether_brick_slab", Blocks.RED_NETHER_BRICK_SLAB),
            Map.entry("polished_andesite_slab", Blocks.POLISHED_ANDESITE_SLAB),
            Map.entry("diorite_slab", Blocks.DIORITE_SLAB),
            Map.entry("cut_sandstone_slab", Blocks.CUT_SANDSTONE_SLAB),
            Map.entry("cut_red_sandstone_slab", Blocks.CUT_RED_SANDSTONE_SLAB),
            Map.entry("blackstone_slab", Blocks.BLACKSTONE_SLAB),
            Map.entry("polished_blackstone_brick_slab", Blocks.POLISHED_BLACKSTONE_BRICK_SLAB),
            Map.entry("polished_blackstone_slab", Blocks.POLISHED_BLACKSTONE_SLAB),
            Map.entry("cobbled_deepslate_slab", Blocks.COBBLED_DEEPSLATE_SLAB),
            Map.entry("polished_deepslate_slab", Blocks.POLISHED_DEEPSLATE_SLAB),
            Map.entry("deepslate_tile_slab", Blocks.DEEPSLATE_TILE_SLAB),
            Map.entry("deepslate_brick_slab", Blocks.DEEPSLATE_BRICK_SLAB),
            Map.entry("mud_brick_slab", Blocks.MUD_BRICK_SLAB),
            Map.entry("tuff_slab", Blocks.TUFF_SLAB),
            Map.entry("polished_tuff_slab", Blocks.POLISHED_TUFF_SLAB),
            Map.entry("tuff_brick_slab", Blocks.TUFF_BRICK_SLAB),
            Map.entry("resin_brick_slab", Blocks.RESIN_BRICK_SLAB),
            Map.entry("cinnabar_slab", Blocks.CINNABAR_SLAB),
            Map.entry("polished_cinnabar_slab", Blocks.POLISHED_CINNABAR_SLAB),
            Map.entry("cinnabar_brick_slab", Blocks.CINNABAR_BRICK_SLAB),
            Map.entry("sulfur_slab", Blocks.SULFUR_SLAB),
            Map.entry("polished_sulfur_slab", Blocks.POLISHED_SULFUR_SLAB),
            Map.entry("sulfur_brick_slab", Blocks.SULFUR_BRICK_SLAB),
            Map.entry("cut_copper_slab", Blocks.CUT_COPPER_SLAB.weathering().unaffected()),
            Map.entry("exposed_cut_copper_slab", Blocks.CUT_COPPER_SLAB.weathering().exposed()),
            Map.entry("weathered_cut_copper_slab", Blocks.CUT_COPPER_SLAB.weathering().weathered()),
            Map.entry("oxidized_cut_copper_slab", Blocks.CUT_COPPER_SLAB.weathering().oxidized()),
            Map.entry("waxed_cut_copper_slab", Blocks.CUT_COPPER_SLAB.waxed().unaffected()),
            Map.entry("waxed_exposed_cut_copper_slab", Blocks.CUT_COPPER_SLAB.waxed().exposed()),
            Map.entry("waxed_weathered_cut_copper_slab", Blocks.CUT_COPPER_SLAB.waxed().weathered()),
            Map.entry("waxed_oxidized_cut_copper_slab", Blocks.CUT_COPPER_SLAB.waxed().oxidized())
    );

    private static final List<String> HEDGES = List.of(
            "oak_hedge",
            "spruce_hedge",
            "birch_hedge",
            "jungle_hedge",
            "acacia_hedge",
            "dark_oak_hedge",
            "mangrove_hedge",
            "cherry_hedge",
            "pale_oak_hedge",
            "azalea_hedge",
            "flowering_azalea_hedge"
    );


    static {
        registerFruitContent();
        HEDGES.forEach(ModBlocks::registerHedge);
        BASIC_BLOCKS.forEach(ModBlocks::registerBasicBlock);
        SLABS.forEach(ModBlocks::registerSlab);
        STAIRS.forEach(ModBlocks::registerStairs);
        WALLS.forEach(ModBlocks::registerWall);
        registerVanillaWoolAndGlassShapes();
        registerVanillaVerticalSlabs();
        registerWemVerticalSlabs();
    }


    private static void registerFruitContent() {
        for (String fruitId : FRUIT_TYPES) {
            registerFruitLeaves(fruitId + "_leaves", fruitId);
            registerFruitSapling(fruitId + "_sapling", fruitId);
            registerHangingFruit(fruitId + "_hanging_fruit", fruitId);
        }
        // Cherry keeps the vanilla cherry tree/leaves, but uses the same hanging-fruit block mechanic.
        registerHangingFruit("cherry_hanging_fruit", "cherry");
    }

    private static void registerFruitLeaves(String id, String fruitId) {
        DeferredBlock<FruitLeavesBlock> block = BLOCKS.registerBlock(id,
                props -> new FruitLeavesBlock(fruitId, props),
                () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).randomTicks());
        BLOCKS_BY_ID.put(id, block);
    }

    private static void registerFruitSapling(String id, String fruitId) {
        DeferredBlock<FruitSaplingBlock> block = BLOCKS.registerBlock(id,
                props -> new FruitSaplingBlock(fruitId, props),
                () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).randomTicks());
        BLOCKS_BY_ID.put(id, block);
    }

    private static void registerHangingFruit(String id, String fruitId) {
        DeferredBlock<FruitHangingBlock> block = BLOCKS.registerBlock(id,
                props -> new FruitHangingBlock(fruitId, props),
                () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING));
        BLOCKS_BY_ID.put(id, block);
    }

    private static void registerVanillaWoolAndGlassShapes() {
        for (String color : VANILLA_DYE_COLORS) {
            registerSlab(color + "_wool_halfslab");
            registerStairs(color + "_wool_stairs");
            registerWall(color + "_wool_wall");
        }

        registerSlab("glass_halfslab");
        registerStairs("glass_stairs");
        registerWall("glass_wall");

        for (String color : VANILLA_DYE_COLORS) {
            registerSlab(color + "_stained_glass_halfslab");
            registerStairs(color + "_stained_glass_stairs");
            registerWall(color + "_stained_glass_wall");
        }
    }

    private static void registerHedge(String id) {
        DeferredBlock<HedgeBlock> block = BLOCKS.registerBlock(id,
                HedgeBlock::new,
                () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES));
        BLOCKS_BY_ID.put(id, block);
    }

    private static void registerVanillaVerticalSlabs() {
        VANILLA_VERTICAL_SLAB_SOURCES.forEach(entry -> {
            String sourceSlabId = entry.getKey();
            String id = sourceSlabId.substring(0, sourceSlabId.length() - "_slab".length()) + "_vertical_slab";
            DeferredBlock<VerticalSlabBlock> block = BLOCKS.registerBlock(id,
                    VerticalSlabBlock::new,
                    () -> BlockBehaviour.Properties.ofFullCopy(entry.getValue()));
            BLOCKS_BY_ID.put(id, block);
        });
    }

    private static void registerWemVerticalSlabs() {
        SLABS.forEach(ModBlocks::registerWemVerticalSlab);

        for (String color : VANILLA_DYE_COLORS) {
            registerWemVerticalSlab(color + "_wool_halfslab");
        }

        registerWemVerticalSlab("glass_halfslab");

        for (String color : VANILLA_DYE_COLORS) {
            registerWemVerticalSlab(color + "_stained_glass_halfslab");
        }
    }

    private static void registerWemVerticalSlab(String sourceSlabId) {
        String id = sourceSlabId.substring(0, sourceSlabId.length() - "_halfslab".length()) + "_vertical_slab";
        DeferredBlock<VerticalSlabBlock> block = BLOCKS.registerBlock(id,
                VerticalSlabBlock::new,
                () -> BlockBehaviour.Properties.ofFullCopy(parentBlockForVariant(sourceSlabId)));
        BLOCKS_BY_ID.put(id, block);
    }

    private static void registerBasicBlock(String id) {
        DeferredBlock<Block> block = BLOCKS.registerSimpleBlock(id, props -> configureProperties(id, props));
        BLOCKS_BY_ID.put(id, block);
    }

    private static void registerSlab(String id) {
        DeferredBlock<SlabBlock> block = BLOCKS.registerBlock(id,
                SlabBlock::new,
                () -> BlockBehaviour.Properties.ofFullCopy(parentBlockForVariant(id)));
        BLOCKS_BY_ID.put(id, block);
    }

    private static void registerStairs(String id) {
        DeferredBlock<StairBlock> block = BLOCKS.registerBlock(id,
                props -> isGlassStairId(id)
                        ? new GlassStairBlock(parentBlockForVariant(id).defaultBlockState(), props)
                        : new StairBlock(parentBlockForVariant(id).defaultBlockState(), props),
                () -> BlockBehaviour.Properties.ofFullCopy(parentBlockForVariant(id)));
        BLOCKS_BY_ID.put(id, block);
    }

    private static boolean isGlassStairId(String id) {
        return id.equals("glass_stairs") || id.endsWith("_stained_glass_stairs");
    }

    private static void registerWall(String id) {
        DeferredBlock<WallBlock> block = BLOCKS.registerBlock(id,
                WallBlock::new,
                () -> BlockBehaviour.Properties.ofFullCopy(parentBlockForVariant(id)));
        BLOCKS_BY_ID.put(id, block);
    }

    /**
     * Returns the real full-block material parent for every WEM building shape.
     *
     * <p>This is intentionally the single source of truth for slabs, stairs,
     * walls and WEM vertical slabs. Shape blocks no longer approximate material
     * properties from their ID. They copy the actual parent block instead.</p>
     */
    private static Block parentBlockForVariant(String variantId) {
        String materialId = materialIdFromVariant(variantId);

        DeferredBlock<? extends Block> wemParent = BLOCKS_BY_ID.get(materialId);
        if (wemParent != null) {
            return wemParent.get();
        }

        if (materialId.equals("glass")) {
            return Blocks.GLASS;
        }

        if (materialId.endsWith("_stained_glass")) {
            return Blocks.STAINED_GLASS.pick(dyeColorFromLegacyMaterial(materialId, "_stained_glass"));
        }

        if (materialId.endsWith("_wool")) {
            return Blocks.WOOL.pick(dyeColorFromLegacyMaterial(materialId, "_wool"));
        }

        if (materialId.endsWith("_concrete")) {
            return Blocks.CONCRETE.pick(dyeColorFromLegacyMaterial(materialId, "_concrete"));
        }

        if (materialId.endsWith("_terracotta")) {
            return Blocks.DYED_TERRACOTTA.pick(dyeColorFromLegacyMaterial(materialId, "_terracotta"));
        }

        throw new IllegalStateException("No parent block mapping for WEM building variant: "
                + variantId + " (material " + materialId + ")");
    }

    private static String materialIdFromVariant(String variantId) {
        if (variantId.endsWith("_halfslab")) {
            return variantId.substring(0, variantId.length() - "_halfslab".length());
        }
        if (variantId.endsWith("_vertical_slab")) {
            return variantId.substring(0, variantId.length() - "_vertical_slab".length());
        }
        if (variantId.endsWith("_stairs")) {
            return variantId.substring(0, variantId.length() - "_stairs".length());
        }
        if (variantId.endsWith("_wall")) {
            return variantId.substring(0, variantId.length() - "_wall".length());
        }
        return variantId;
    }

    private static DyeColor dyeColorFromLegacyMaterial(String materialId, String suffix) {
        String color = materialId.substring(0, materialId.length() - suffix.length());

        // Historical WEM registry IDs predate the vanilla light_blue/light_gray names.
        if (color.equals("lightblue")) color = "light_blue";
        if (color.equals("silver")) color = "light_gray";

        return switch (color) {
            case "white" -> DyeColor.WHITE;
            case "orange" -> DyeColor.ORANGE;
            case "magenta" -> DyeColor.MAGENTA;
            case "light_blue" -> DyeColor.LIGHT_BLUE;
            case "yellow" -> DyeColor.YELLOW;
            case "lime" -> DyeColor.LIME;
            case "pink" -> DyeColor.PINK;
            case "gray" -> DyeColor.GRAY;
            case "light_gray" -> DyeColor.LIGHT_GRAY;
            case "cyan" -> DyeColor.CYAN;
            case "purple" -> DyeColor.PURPLE;
            case "blue" -> DyeColor.BLUE;
            case "brown" -> DyeColor.BROWN;
            case "green" -> DyeColor.GREEN;
            case "red" -> DyeColor.RED;
            case "black" -> DyeColor.BLACK;
            default -> throw new IllegalStateException("Unknown WEM dye color in material ID: " + materialId);
        };
    }

    private static BlockBehaviour.Properties configureProperties(String id, BlockBehaviour.Properties props) {
        // Values below intentionally mirror the old 4.0.3.0 classes where they had unique properties.
        if (id.endsWith("_leaves")) return props;
        if (id.endsWith("_sapling")) return props;
        if (id.endsWith("_hanging_fruit")) return props;
        if (id.startsWith("blood_stone") || id.startsWith("dread_stone")) return props.destroyTime(2.5F).explosionResistance(7.0F).sound(SoundType.STONE);
        if (id.equals("limestone")) return props.destroyTime(1.5F).explosionResistance(5.0F).sound(SoundType.STONE);
        if (id.equals("limestone_cobble")) return props.destroyTime(1.75F).explosionResistance(5.0F).sound(SoundType.STONE);
        if (id.equals("marblestone")) return props.destroyTime(1.75F).explosionResistance(5.0F).sound(SoundType.STONE);
        if (id.equals("marblestone_cobble")) return props.destroyTime(2.0F).explosionResistance(5.0F).sound(SoundType.STONE);
        if (id.contains("_wool_")) return props.destroyTime(0.8F).explosionResistance(0.8F).sound(SoundType.WOOL).ignitedByLava();
        if (id.startsWith("glass_") || id.contains("_stained_glass_")) return props.destroyTime(0.3F).explosionResistance(0.3F).sound(SoundType.GLASS).noOcclusion();
        if (id.contains("concrete")) return props.destroyTime(1.8F).explosionResistance(6.0F).sound(SoundType.STONE);
        if (id.contains("bricked_terracotta") || id.contains("terracotta_bricks")) return props.destroyTime(1.25F).explosionResistance(4.2F).sound(SoundType.STONE);
        if (id.contains("stained_clay")) return props.destroyTime(0.6F).explosionResistance(0.6F).sound(SoundType.GRAVEL);
        return props.destroyTime(1.5F).explosionResistance(6.0F).sound(SoundType.STONE);
    }

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }

    private ModBlocks() {}
}
