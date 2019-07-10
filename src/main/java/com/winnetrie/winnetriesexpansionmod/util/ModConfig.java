package com.winnetrie.winnetriesexpansionmod.util;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.*;
import net.minecraftforge.common.config.Config.Comment;

@Config(modid = References.MOD_ID)
public class ModConfig {
	
	
	@Comment({"Ore and stone generation"})
	public static boolean enable_limestone_gen = true;
	public static boolean enable_marblestone_gen = true;
	@Comment({"Enable this to add Tin Ore to the game. Disabled by default", "If you still want Tin Ore ingame, but not generating, you can tweak this in the Tin Ore section. Setting veinsize to 0 for example"})
	public static boolean enable_tin_ore = false;
	@Comment({"Enable this to make wooden tools useless.", "This makes wooden tools completely useless, but still compateble with other recipes requiring this item", "Nice option for modpack makers! Your welcome!"})
	public static boolean make_wooden_tools_useless = false;
	@Comment({"Enable this to make stone tools useless.", "This makes stone tools completely useless, but still compateble with other recipes requiring this item", "Nice option for modpack makers! Your welcome!"})
	public static boolean make_stone_tools_useless = false;
	
	@Comment({"Enable this to add various metal blocks to the game"})
	public static boolean enable_metal_blocks = false;
	
	@Comment({"Enable the fluids this mod adds!", "Specific customization in the >fluids< section."})
	public static boolean enable_fluids = false;
	
	@Comment({"Enable the bottles this mod adds!", "Specific customization in the >bottles< section."})
	public static boolean enable_bottles = false;
	@Comment({"Adds nuggets for tin, solder, bronze and invar"})
	public static boolean enable_nuggets = false;
	@Comment({"Adds plates for tin, solder, bronze and invar"})
	public static boolean enable_plates = false;
	@Comment({"Adds ingots for tin, solder, bronze and invar"})
	public static boolean enable_ingots = false;
	@Comment({"Adds dusts for tin, solder, bronze and invar"})
	public static boolean enable_dusts = false;
	@Comment({"Adds gears for various metal types"})
	public static boolean enable_gears = false;
	
	@Comment({"Adds some extra molds for the IE press to the game. Hopper mold, trapdoor mold, arrowhead mold, bucket mold", "Use CraftTweaker to add them to the press"})
	public static boolean enable_extra_molds = false;
	
	@Comment({"Adds terracottabuckets to the game"})
	public static boolean enable_terracotta_buckets = false;
	
	@Comment({"Adds various items to the game.", "solder wire, solder wire coil, calcium carbonate, natrium carbonate, silica, silica blend"})
	public static boolean enable_extra_stuff = false;
	
	
	
	@SubConfig
	public static Limestonegen limestonegen;
	@SubConfig
	public static Marblestonegen marblestonegen;
	@SubConfig
	public static TinOre tin_ore;
	@SubConfig
	public static ModMetalBlocks metal_blocks;
	@SubConfig
	public static ModFluids fluids;
	@SubConfig
	public static ModBottles bottles;
	
	
	public static class Limestonegen{
		
		@Comment({"River veinsize. Higher means bigger veins.", "Please do not exaggerate! Default is 25"})
		@RangeInt(min = 0)
		public static int veinsize_river = 25;
		
		@Comment({"Ocean veinsize. Higher means bigger veins.", "Please do not exaggerate! Default is 15"})
		@RangeInt(min = 0)
		public static int veinsize_ocean = 15;
		
		@Comment({"Number of river veins per chunk", "Please do not exaggerate! Default is 1"})
		@RangeInt(min = 0)
		public static int veincount_river = 1;
		
		@Comment({"Number of ocean veins per chunk", "Please do not exaggerate! Default is 1"})
		@RangeInt(min = 0)
		public static int veincount_ocean = 1;
		
		@Comment({"the chance a river vein will generate", "Please do not exaggerate! Default is 100"})
		@RangeInt(min = 0, max = 100)
		public static int veinchance_river = 100;
		
		@Comment({"the chance an ocean vein will generate", "Please do not exaggerate! Default is 100"})
		@RangeInt(min = 0, max = 100)
		public static int veinchance_ocean = 100;
					
	}
	
	public static class Marblestonegen{
		
		@Comment({"Veinsize. Higher means bigger veins.", "Please do not exaggerate! Default is 25"})
		@RangeInt(min = 0)
		public static int veinsize = 25;
		
		@Comment({"Number of veins per chunk", "Please do not exaggerate! Default is 1"})
		@RangeInt(min = 0)
		public static int veincount = 1;
		
		@Comment({"the chance a vein will generate", "Please do not exaggerate! Default is 100"})
		@RangeInt(min = 0, max = 100)
		public static int veinchance = 100;
		
	}
	
	public static class ModMetalBlocks{
		
		@Comment({"Adds Tin block to the game"})
		public static boolean enable_tin_block = true;
		@Comment({"Adds Solder block to the game"})
		public static boolean enable_solder_block = true;
		@Comment({"Adds Bronze block to the game"})
		public static boolean enable_bronze_block = true;
		@Comment({"Adds Invar block to the game"})
		public static boolean enable_invar_block = true;
		
	}
	
	public static class TinOre{
		

		@Comment({"Ore Veinsize. Higher means bigger veins."})
		@RangeInt(min = 0)
		public static int veinsize = 4;
		
		@Comment({"Number of Ore veins per chunk"})
		@RangeInt(min = 0)
		public static int veincount = 8;
		
		@Comment({"the chance an Ore vein will generate"})
		@RangeInt(min = 0, max = 100)
		public static int veinchance = 100;
		
		@Comment({"Minimum height the Ore generates"})
		@RangeInt(min = 0, max = 256)
		public static int minheight = 10;
		
		@Comment({"Maximum height the Ore generates"})
		@RangeInt(min = 0, max = 256)
		public static int maxheight = 60;
		
		
		
	}
	
	public static class ModBottles{
		
		public static boolean enable_apple_juice_bottle = false;
		public static boolean enable_beetroot_juice_bottle = false;
		public static boolean enable_cactus_juice_bottle = false;
		public static boolean enable_melon_juice_bottle = false;
		public static boolean enable_pumpkin_juice_bottle = false;
		public static boolean enable_carrot_juice_bottle = false;
		public static boolean enable_chorusfruit_juice_bottle = false;
		public static boolean enable_lemon_juice_bottle = false;
		public static boolean enable_cherry_juice_bottle = false;
		public static boolean enable_plum_juice_bottle = false;
		public static boolean enable_tropical_juice_bottle = false;
		public static boolean enable_chocolate_milk_bottle = false;
		public static boolean enable_apple_cider_bottle = false;
		public static boolean enable_plum_wine_bottle = false;
		
		
	}
	
	public static class ModFluids{
		
		public static boolean enable_liquid_tin = false;
		public static boolean enable_liquid_solder = false;
		public static boolean enable_liquid_bronze = false;
		public static boolean enable_liquid_invar = false;
		public static boolean enable_liquid_constantan = false;
		public static boolean enable_liquid_uranium = false;
		public static boolean enable_apple_juice = false;
		public static boolean enable_beetroot_juice = false;
		public static boolean enable_cactus_juice = false;
		public static boolean enable_melon_juice = false;
		public static boolean enable_pumpkin_juice = false;
		public static boolean enable_carrot_juice = false;
		public static boolean enable_chorusfruit_juice = false;
		public static boolean enable_lemon_juice = false;
		public static boolean enable_cherry_juice = false;
		public static boolean enable_plum_juice = false;
		public static boolean enable_tropical_juice = false;
		public static boolean enable_chocolate_milk = false;
		public static boolean enable_apple_cider = false;
		public static boolean enable_plum_wine = false;
		
	}
	
	
	public @interface SubConfig
	{
	}


}
