package com.winnetrie.winnetriesexpansionmod.init;

import java.util.ArrayList;
import java.util.List;

import com.winnetrie.winnetriesexpansionmod.blocks.BlockStainedClay;
import com.winnetrie.winnetriesexpansionmod.blocks.BlockTerracottaBrick;
import com.winnetrie.winnetriesexpansionmod.blocks.BlockTin;
import com.winnetrie.winnetriesexpansionmod.blocks.BlockBricks;
import com.winnetrie.winnetriesexpansionmod.blocks.BlockBronze;
import com.winnetrie.winnetriesexpansionmod.blocks.BlockInvar;
import com.winnetrie.winnetriesexpansionmod.blocks.BlockLimestone;
import com.winnetrie.winnetriesexpansionmod.blocks.BlockLimestoneCobble;
import com.winnetrie.winnetriesexpansionmod.blocks.BlockMarblestone;
import com.winnetrie.winnetriesexpansionmod.blocks.BlockMarblestoneCobble;
import com.winnetrie.winnetriesexpansionmod.blocks.BlockOreTin;
import com.winnetrie.winnetriesexpansionmod.blocks.BlockSolder;
import com.winnetrie.winnetriesexpansionmod.blocks.BlockWinnetrieSlab;
import com.winnetrie.winnetriesexpansionmod.blocks.BlockWinnetrieStairs;
import com.winnetrie.winnetriesexpansionmod.blocks.BlockWinnetrieWall;
import com.winnetrie.winnetriesexpansionmod.fluids.FluidSolid;
import com.winnetrie.winnetriesexpansionmod.items.ItemBasic;
import com.winnetrie.winnetriesexpansionmod.items.ItemBrick;
import com.winnetrie.winnetriesexpansionmod.items.ItemClayBall;
import com.winnetrie.winnetriesexpansionmod.items.ItemDeprecate;
import com.winnetrie.winnetriesexpansionmod.items.ItemTerracottaBucket;
import com.winnetrie.winnetriesexpansionmod.items.ModItemPotion;
import com.winnetrie.winnetriesexpansionmod.items.ModItemSlab;
import com.winnetrie.winnetriesexpansionmod.util.ModBlockReference;
import com.winnetrie.winnetriesexpansionmod.util.ModConfig;
import com.winnetrie.winnetriesexpansionmod.util.ModConfig.ModBottles;
import com.winnetrie.winnetriesexpansionmod.util.ModConfig.ModFluids;
import com.winnetrie.winnetriesexpansionmod.util.ModConfig.ModMetalBlocks;
import com.winnetrie.winnetriesexpansionmod.util.ModFluidReference;
import com.winnetrie.winnetriesexpansionmod.util.ModItemReference;
import com.winnetrie.winnetriesexpansionmod.util.References;
import com.winnetrie.winnetriesexpansionmod.util.Utilities;

import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;

@EventBusSubscriber
public class ModRegistry {
		
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		
		System.out.println("Registering all items from the ITEMS registrylist");
		
		//REGISTERING ALL ITEMBLOCKS
		for (Block block : ForgeRegistries.BLOCKS.getValuesCollection()) {
			
			if (block.getRegistryName().getResourceDomain().equals(References.MOD_ID) && !(block instanceof BlockWinnetrieSlab)  ) {

			    event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
			}
		}
				
		//REGISTERING ALL ITEMS
		event.getRegistry().registerAll(	
		//adding stained clayballs

			ModItemReference.white_stained_clayball = new ItemClayBall(new ResourceLocation(References.PREFIX + "white_stained_clayball")),
			ModItemReference.orange_stained_clayball = new ItemClayBall(new ResourceLocation(References.PREFIX + "orange_stained_clayball")),
			ModItemReference.magenta_stained_clayball = new ItemClayBall(new ResourceLocation(References.PREFIX + "magenta_stained_clayball")),
			ModItemReference.lightblue_stained_clayball = new ItemClayBall(new ResourceLocation(References.PREFIX + "lightblue_stained_clayball")),
			ModItemReference.yellow_stained_clayball = new ItemClayBall(new ResourceLocation(References.PREFIX + "yellow_stained_clayball")),
			ModItemReference.lime_stained_clayball = new ItemClayBall(new ResourceLocation(References.PREFIX + "lime_stained_clayball")),
			ModItemReference.pink_stained_clayball = new ItemClayBall(new ResourceLocation(References.PREFIX + "pink_stained_clayball")),
			ModItemReference.gray_stained_clayball = new ItemClayBall(new ResourceLocation(References.PREFIX + "gray_stained_clayball")),
			ModItemReference.silver_stained_clayball = new ItemClayBall(new ResourceLocation(References.PREFIX + "silver_stained_clayball")),
			ModItemReference.cyan_stained_clayball = new ItemClayBall(new ResourceLocation(References.PREFIX + "cyan_stained_clayball")),
			ModItemReference.purple_stained_clayball = new ItemClayBall(new ResourceLocation(References.PREFIX + "purple_stained_clayball")),
			ModItemReference.blue_stained_clayball = new ItemClayBall(new ResourceLocation(References.PREFIX + "blue_stained_clayball")),
			ModItemReference.brown_stained_clayball = new ItemClayBall(new ResourceLocation(References.PREFIX + "brown_stained_clayball")),
			ModItemReference.green_stained_clayball = new ItemClayBall(new ResourceLocation(References.PREFIX + "green_stained_clayball")),
			ModItemReference.red_stained_clayball = new ItemClayBall(new ResourceLocation(References.PREFIX + "red_stained_clayball")),
			ModItemReference.black_stained_clayball = new ItemClayBall(new ResourceLocation(References.PREFIX + "black_stained_clayball")),
	
		//adding colored terracotta brick
			ModItemReference.white_brick = new ItemBrick(new ResourceLocation(References.PREFIX + "white_brick")),
			ModItemReference.orange_brick = new ItemBrick(new ResourceLocation(References.PREFIX + "orange_brick")),
			ModItemReference.magenta_brick = new ItemBrick(new ResourceLocation(References.PREFIX + "magenta_brick")),
			ModItemReference.lightblue_brick = new ItemBrick(new ResourceLocation(References.PREFIX + "lightblue_brick")),
			ModItemReference.yellow_brick = new ItemBrick(new ResourceLocation(References.PREFIX + "yellow_brick")),
			ModItemReference.lime_brick = new ItemBrick(new ResourceLocation(References.PREFIX + "lime_brick")),
			ModItemReference.pink_brick = new ItemBrick(new ResourceLocation(References.PREFIX + "pink_brick")),
			ModItemReference.gray_brick = new ItemBrick(new ResourceLocation(References.PREFIX + "gray_brick")),
			ModItemReference.silver_brick = new ItemBrick(new ResourceLocation(References.PREFIX + "silver_brick")),
			ModItemReference.cyan_brick = new ItemBrick(new ResourceLocation(References.PREFIX + "cyan_brick")),
			ModItemReference.purple_brick = new ItemBrick(new ResourceLocation(References.PREFIX + "purple_brick")),
			ModItemReference.blue_brick = new ItemBrick(new ResourceLocation(References.PREFIX + "blue_brick")),
			ModItemReference.brown_brick = new ItemBrick(new ResourceLocation(References.PREFIX + "brown_brick")),
			ModItemReference.green_brick = new ItemBrick(new ResourceLocation(References.PREFIX + "green_brick")),
			ModItemReference.red_brick = new ItemBrick(new ResourceLocation(References.PREFIX + "red_brick")),
			ModItemReference.black_brick = new ItemBrick(new ResourceLocation(References.PREFIX + "black_brick"))
		
		);
			if(ModConfig.enable_terracotta_buckets==true) {
				
				event.getRegistry().registerAll(
						ModItemReference.clay_bucket = new ItemBasic(new ResourceLocation(References.PREFIX + "clay_bucket")),
						ModItemReference.terracotta_bucket = (new ItemTerracottaBucket(new ResourceLocation(References.PREFIX + "terracotta_bucket"), Blocks.AIR)).setMaxStackSize(16),
						ModItemReference.terracotta_bucket_water = (new ItemTerracottaBucket(new ResourceLocation(References.PREFIX + "terracotta_bucket_water"), Blocks.FLOWING_WATER)).setContainerItem(ModItemReference.terracotta_bucket),
						ModItemReference.terracotta_bucket_lava = (new ItemTerracottaBucket(new ResourceLocation(References.PREFIX + "terracotta_bucket_lava"), Blocks.FLOWING_LAVA)));
			}
			
			if (ModConfig.enable_bottles==true) {
				
				if (ModBottles.enable_apple_juice_bottle==true) {
					
					event.getRegistry().registerAll(ModItemReference.apple_juice = new ModItemPotion(new ResourceLocation(References.PREFIX + "apple_juice_bottle")));
				}
				if (ModBottles.enable_beetroot_juice_bottle==true) {
					
					event.getRegistry().register(ModItemReference.beetroot_juice = new ModItemPotion(new ResourceLocation(References.PREFIX + "beetroot_juice_bottle")));
				}
				if (ModBottles.enable_carrot_juice_bottle==true) {
					
					event.getRegistry().register(ModItemReference.carrot_juice = new ModItemPotion(new ResourceLocation(References.PREFIX + "carrot_juice_bottle")));
				}
				if (ModBottles.enable_melon_juice_bottle==true) {
					
					event.getRegistry().register(ModItemReference.melon_juice = new ModItemPotion(new ResourceLocation(References.PREFIX + "melon_juice_bottle")));
				}
				if (ModBottles.enable_chorusfruit_juice_bottle==true) {
					
					event.getRegistry().register(ModItemReference.chorusfruit_juice = new ModItemPotion(new ResourceLocation(References.PREFIX + "chorusfruit_juice_bottle")));
				}
				if (ModBottles.enable_pumpkin_juice_bottle==true) {
					
					event.getRegistry().register(ModItemReference.pumpkin_juice = new ModItemPotion(new ResourceLocation(References.PREFIX + "pumpkin_juice_bottle")));
				}
				if (ModBottles.enable_cactus_juice_bottle==true) {
					
					event.getRegistry().register(ModItemReference.cactus_juice = new ModItemPotion(new ResourceLocation(References.PREFIX + "cactus_juice_bottle")));
				}
				if (ModBottles.enable_lemon_juice_bottle==true) {
					
					event.getRegistry().register(ModItemReference.lemon_juice = new ModItemPotion(new ResourceLocation(References.PREFIX + "lemon_juice_bottle")));
				}
				if (ModBottles.enable_cherry_juice_bottle==true) {
					
					event.getRegistry().register(ModItemReference.cherry_juice = new ModItemPotion(new ResourceLocation(References.PREFIX + "cherry_juice_bottle")));
				}
				if (ModBottles.enable_tropical_juice_bottle==true) {
					
					event.getRegistry().register(ModItemReference.tropical_juice = new ModItemPotion(new ResourceLocation(References.PREFIX + "tropical_juice_bottle")));
				}
				if (ModBottles.enable_plum_juice_bottle==true) {
					
					event.getRegistry().register(ModItemReference.plum_juice = new ModItemPotion(new ResourceLocation(References.PREFIX + "plum_juice_bottle")));
				}
				if (ModBottles.enable_plum_wine_bottle==true) {
					
					event.getRegistry().register(ModItemReference.plum_wine = new ModItemPotion(new ResourceLocation(References.PREFIX + "plum_wine_bottle")));
				}
				if (ModBottles.enable_apple_cider_bottle==true) {
					
					event.getRegistry().register(ModItemReference.apple_cider = new ModItemPotion(new ResourceLocation(References.PREFIX + "apple_cider_bottle")));
				}
				if (ModBottles.enable_chocolate_milk_bottle==true) {
					
					event.getRegistry().register(ModItemReference.chocolate_milk = new ModItemPotion(new ResourceLocation(References.PREFIX + "chocolate_milk_bottle")));
				}
			
			
			
			
			if (ModConfig.enable_nuggets==true) {
				
				event.getRegistry().registerAll(
						ModItemReference.nugget_invar = new ItemBasic(new ResourceLocation(References.PREFIX +"nugget_invar")),
						ModItemReference.nugget_bronze = new ItemBasic(new ResourceLocation(References.PREFIX +"nugget_bronze")),
						ModItemReference.nugget_tin = new ItemBasic(new ResourceLocation(References.PREFIX +"nugget_tin")),
						ModItemReference.nugget_solder = new ItemBasic(new ResourceLocation(References.PREFIX +"nugget_solder")));
				
				OreDictionary.registerOre("nuggetInvar", new ItemStack(ModItemReference.nugget_invar));
				OreDictionary.registerOre("nuggetBronze", new ItemStack(ModItemReference.nugget_bronze));
				OreDictionary.registerOre("nuggetTin", new ItemStack(ModItemReference.nugget_tin));
				OreDictionary.registerOre("nuggetSolder", new ItemStack(ModItemReference.nugget_solder));
			}
			
			if (ModConfig.enable_ingots==true) {
				
				event.getRegistry().registerAll(
						ModItemReference.ingot_invar = new ItemBasic(new ResourceLocation(References.PREFIX +"ingot_invar")),
						ModItemReference.ingot_bronze = new ItemBasic(new ResourceLocation(References.PREFIX +"ingot_bronze")),
						ModItemReference.ingot_tin = new ItemBasic(new ResourceLocation(References.PREFIX +"ingot_tin")),
						ModItemReference.ingot_solder = new ItemBasic(new ResourceLocation(References.PREFIX +"ingot_solder")));
				
				OreDictionary.registerOre("ingotInvar", new ItemStack(ModItemReference.ingot_invar));
				OreDictionary.registerOre("ingotBronze", new ItemStack(ModItemReference.ingot_bronze));
				OreDictionary.registerOre("ingotTin", new ItemStack(ModItemReference.ingot_tin));
				OreDictionary.registerOre("ingotSolder", new ItemStack(ModItemReference.ingot_solder));
				
			}
			
			if (ModConfig.enable_plates==true) {
				
				event.getRegistry().registerAll(
						ModItemReference.metalplate_invar = new ItemBasic(new ResourceLocation(References.PREFIX +"metalplate_invar")),
						ModItemReference.metalplate_bronze = new ItemBasic(new ResourceLocation(References.PREFIX +"metalplate_bronze")),
						ModItemReference.metalplate_tin = new ItemBasic(new ResourceLocation(References.PREFIX +"metalplate_tin")),
						ModItemReference.metalplate_solder = new ItemBasic(new ResourceLocation(References.PREFIX +"metalplate_solder")));
				
				OreDictionary.registerOre("plateInvar", new ItemStack(ModItemReference.metalplate_invar));
				OreDictionary.registerOre("plateBronze", new ItemStack(ModItemReference.metalplate_bronze));
				OreDictionary.registerOre("plateTin", new ItemStack(ModItemReference.metalplate_tin));
				OreDictionary.registerOre("plateSolder", new ItemStack(ModItemReference.metalplate_solder));
				
			}
			
			if (ModConfig.enable_dusts==true) {
				
				event.getRegistry().registerAll(
						ModItemReference.metaldust_invar = new ItemBasic(new ResourceLocation(References.PREFIX +"metaldust_invar")),
						ModItemReference.metaldust_bronze = new ItemBasic(new ResourceLocation(References.PREFIX +"metaldust_bronze")),
						ModItemReference.metaldust_tin = new ItemBasic(new ResourceLocation(References.PREFIX +"metaldust_tin")),
						ModItemReference.metaldust_solder = new ItemBasic(new ResourceLocation(References.PREFIX +"metaldust_solder")));
				
				OreDictionary.registerOre("dustInvar", new ItemStack(ModItemReference.metaldust_invar));
				OreDictionary.registerOre("dustBronze", new ItemStack(ModItemReference.metaldust_bronze));
				OreDictionary.registerOre("dustTin", new ItemStack(ModItemReference.metaldust_tin));
				OreDictionary.registerOre("dustSolder", new ItemStack(ModItemReference.metaldust_solder));
			}
			if (ModConfig.enable_extra_molds==true) {
				
				event.getRegistry().registerAll(
						ModItemReference.bucket_mold = new ItemBasic(new ResourceLocation(References.PREFIX + "bucket_mold")),
						ModItemReference.arrowhead_mold = new ItemBasic(new ResourceLocation(References.PREFIX + "arrowhead_mold")),
						ModItemReference.hopper_mold = new ItemBasic(new ResourceLocation(References.PREFIX + "hopper_mold")),
						ModItemReference.trapdoor_mold = new ItemBasic(new ResourceLocation(References.PREFIX + "trapdoor_mold")),
						ModItemReference.steel_arrow_head = new ItemBasic(new ResourceLocation(References.PREFIX + "steel_arrow_head")));
				
				
			}
			if (ModConfig.enable_extra_stuff==true) {
				
				event.getRegistry().registerAll(
						ModItemReference.wire_solder = new ItemBasic(new ResourceLocation(References.PREFIX +"wire_solder")),
						ModItemReference.wirecoil_solder = new ItemBasic(new ResourceLocation(References.PREFIX +"wirecoil_solder")),
						ModItemReference.calcium_carbonate = new ItemBasic(new ResourceLocation(References.PREFIX + "calcium_carbonate")),
						ModItemReference.natrium_carbonate = new ItemBasic(new ResourceLocation(References.PREFIX + "natrium_carbonate")),
						ModItemReference.silica = new ItemBasic(new ResourceLocation(References.PREFIX + "silica")),
						ModItemReference.silica_blend = new ItemBasic(new ResourceLocation(References.PREFIX + "silica_blend")));
				
				OreDictionary.registerOre("dustCalciumCarbonate", new ItemStack(ModItemReference.calcium_carbonate));
				OreDictionary.registerOre("dustNatriumCarbonate", new ItemStack(ModItemReference.natrium_carbonate));
				OreDictionary.registerOre("dustSilica", new ItemStack(ModItemReference.silica));
				OreDictionary.registerOre("dustSilicaBlend", new ItemStack(ModItemReference.silica_blend));
			}
			if (ModConfig.enable_gears==true) {
				
				event.getRegistry().registerAll(
						ModItemReference.gear_copper = new ItemBasic(new ResourceLocation(References.PREFIX + "copper_gear")),
						ModItemReference.gear_tin = new ItemBasic(new ResourceLocation(References.PREFIX + "tin_gear")),
						ModItemReference.gear_bronze = new ItemBasic(new ResourceLocation(References.PREFIX + "bronze_gear")),
						ModItemReference.gear_gold = new ItemBasic(new ResourceLocation(References.PREFIX + "gold_gear")),		
						ModItemReference.gear_silver = new ItemBasic(new ResourceLocation(References.PREFIX + "silver_gear")),
						ModItemReference.gear_electrum = new ItemBasic(new ResourceLocation(References.PREFIX + "electrum_gear")),
						ModItemReference.gear_iron = new ItemBasic(new ResourceLocation(References.PREFIX + "iron_gear")),
						ModItemReference.gear_steel = new ItemBasic(new ResourceLocation(References.PREFIX + "steel_gear")),
						ModItemReference.gear_nickel = new ItemBasic(new ResourceLocation(References.PREFIX + "nickel_gear")),		
						ModItemReference.gear_invar = new ItemBasic(new ResourceLocation(References.PREFIX + "invar_gear")),
						ModItemReference.gear_constantan = new ItemBasic(new ResourceLocation(References.PREFIX + "constantan_gear")),
						ModItemReference.gear_lead = new ItemBasic(new ResourceLocation(References.PREFIX + "lead_gear")),
						ModItemReference.gear_aluminum = new ItemBasic(new ResourceLocation(References.PREFIX + "aluminum_gear")));
				
				OreDictionary.registerOre("gearCopper", new ItemStack(ModItemReference.gear_copper));
				OreDictionary.registerOre("gearTin", new ItemStack(ModItemReference.gear_tin));
				OreDictionary.registerOre("gearBronze", new ItemStack(ModItemReference.gear_bronze));
				OreDictionary.registerOre("gearIron", new ItemStack(ModItemReference.gear_iron));
				OreDictionary.registerOre("gearGold", new ItemStack(ModItemReference.gear_gold));
				OreDictionary.registerOre("gearSilver", new ItemStack(ModItemReference.gear_silver));
				OreDictionary.registerOre("gearSteel", new ItemStack(ModItemReference.gear_steel));
				OreDictionary.registerOre("gearElectrum", new ItemStack(ModItemReference.gear_electrum));
				OreDictionary.registerOre("gearNickel", new ItemStack(ModItemReference.gear_nickel));
				OreDictionary.registerOre("gearInvar", new ItemStack(ModItemReference.gear_invar));
				OreDictionary.registerOre("gearConstantan", new ItemStack(ModItemReference.gear_constantan));
				OreDictionary.registerOre("gearAluminum", new ItemStack(ModItemReference.gear_aluminum));
				OreDictionary.registerOre("gearLead", new ItemStack(ModItemReference.gear_lead));
			}
			
			if (ModConfig.make_wooden_tools_useless==true) {
				
				event.getRegistry().registerAll(
						ModItemReference.WOODEN_HOE = new ItemDeprecate(new ResourceLocation("minecraft:wooden_hoe")),
						ModItemReference.WOODEN_AXE = new ItemDeprecate(new ResourceLocation("minecraft:wooden_axe")),
						ModItemReference.WOODEN_PICKAXE = new ItemDeprecate(new ResourceLocation("minecraft:wooden_pickaxe")),
						ModItemReference.WOODEN_SHOVEL = new ItemDeprecate(new ResourceLocation("minecraft:wooden_shovel")),
						ModItemReference.WOODEN_SWORD = new ItemDeprecate(new ResourceLocation("minecraft:wooden_sword")));
			}
			
			if (ModConfig.make_stone_tools_useless==true) {
				
				event.getRegistry().registerAll(
						ModItemReference.STONE_HOE = new ItemDeprecate(new ResourceLocation("minecraft:stone_hoe")),
						ModItemReference.STONE_AXE = new ItemDeprecate(new ResourceLocation("minecraft:stone_axe")),
						ModItemReference.STONE_PICKAXE = new ItemDeprecate(new ResourceLocation("minecraft:stone_pickaxe")),
						ModItemReference.STONE_SHOVEL = new ItemDeprecate(new ResourceLocation("minecraft:stone_shovel")),
						ModItemReference.STONE_SWORD = new ItemDeprecate(new ResourceLocation("minecraft:stone_sword")));
			}
		}
		
		ItemBlock white_bricks_slab = new ItemSlab(ModBlockReference.white_bricks_halfslab, 
				(BlockSlab)ModBlockReference.white_bricks_halfslab, 
				(BlockSlab)ModBlockReference.white_bricks_doubleslab);
				white_bricks_slab.setRegistryName(ModBlockReference.white_bricks_halfslab.getRegistryName());
		ItemBlock orange_bricks_slab = new ItemSlab(ModBlockReference.orange_bricks_halfslab, 
				(BlockSlab)ModBlockReference.orange_bricks_halfslab, 
				(BlockSlab)ModBlockReference.orange_bricks_doubleslab);
				orange_bricks_slab.setRegistryName(ModBlockReference.orange_bricks_halfslab.getRegistryName());
		ItemBlock magenta_bricks_slab = new ItemSlab(ModBlockReference.magenta_bricks_halfslab, 
				(BlockSlab)ModBlockReference.magenta_bricks_halfslab, 
				(BlockSlab)ModBlockReference.magenta_bricks_doubleslab);
				magenta_bricks_slab.setRegistryName(ModBlockReference.magenta_bricks_halfslab.getRegistryName());
		ItemBlock lightblue_bricks_slab = new ItemSlab(ModBlockReference.lightblue_bricks_halfslab, 
				(BlockSlab)ModBlockReference.lightblue_bricks_halfslab, 
				(BlockSlab)ModBlockReference.lightblue_bricks_doubleslab);
				lightblue_bricks_slab.setRegistryName(ModBlockReference.lightblue_bricks_halfslab.getRegistryName());
		ItemBlock yellow_bricks_slab = new ItemSlab(ModBlockReference.yellow_bricks_halfslab, 
				(BlockSlab)ModBlockReference.yellow_bricks_halfslab, 
				(BlockSlab)ModBlockReference.yellow_bricks_doubleslab);
				yellow_bricks_slab.setRegistryName(ModBlockReference.yellow_bricks_halfslab.getRegistryName());
		ItemBlock lime_bricks_slab = new ItemSlab(ModBlockReference.lime_bricks_halfslab, 
				(BlockSlab)ModBlockReference.lime_bricks_halfslab, 
				(BlockSlab)ModBlockReference.lime_bricks_doubleslab);
				lime_bricks_slab.setRegistryName(ModBlockReference.lime_bricks_halfslab.getRegistryName());
		ItemBlock pink_bricks_slab = new ItemSlab(ModBlockReference.pink_bricks_halfslab, 
				(BlockSlab)ModBlockReference.pink_bricks_halfslab, 
				(BlockSlab)ModBlockReference.pink_bricks_doubleslab);
				pink_bricks_slab.setRegistryName(ModBlockReference.pink_bricks_halfslab.getRegistryName());
		ItemBlock gray_bricks_slab = new ItemSlab(ModBlockReference.gray_bricks_halfslab, 
				(BlockSlab)ModBlockReference.gray_bricks_halfslab, 
				(BlockSlab)ModBlockReference.gray_bricks_doubleslab);
				gray_bricks_slab.setRegistryName(ModBlockReference.gray_bricks_halfslab.getRegistryName());
		ItemBlock silver_bricks_slab = new ItemSlab(ModBlockReference.silver_bricks_halfslab, 
				(BlockSlab)ModBlockReference.silver_bricks_halfslab, 
				(BlockSlab)ModBlockReference.silver_bricks_doubleslab);
				silver_bricks_slab.setRegistryName(ModBlockReference.silver_bricks_halfslab.getRegistryName());
		ItemBlock cyan_bricks_slab = new ItemSlab(ModBlockReference.cyan_bricks_halfslab, 
				(BlockSlab)ModBlockReference.cyan_bricks_halfslab, 
				(BlockSlab)ModBlockReference.cyan_bricks_doubleslab);
				cyan_bricks_slab.setRegistryName(ModBlockReference.cyan_bricks_halfslab.getRegistryName());
		ItemBlock purple_bricks_slab = new ItemSlab(ModBlockReference.purple_bricks_halfslab, 
				(BlockSlab)ModBlockReference.purple_bricks_halfslab, 
				(BlockSlab)ModBlockReference.purple_bricks_doubleslab);
				purple_bricks_slab.setRegistryName(ModBlockReference.purple_bricks_halfslab.getRegistryName());
		ItemBlock blue_bricks_slab = new ItemSlab(ModBlockReference.blue_bricks_halfslab, 
				(BlockSlab)ModBlockReference.blue_bricks_halfslab, 
				(BlockSlab)ModBlockReference.blue_bricks_doubleslab);
				blue_bricks_slab.setRegistryName(ModBlockReference.blue_bricks_halfslab.getRegistryName());
		ItemBlock brown_bricks_slab = new ItemSlab(ModBlockReference.brown_bricks_halfslab, 
				(BlockSlab)ModBlockReference.brown_bricks_halfslab, 
				(BlockSlab)ModBlockReference.brown_bricks_doubleslab);
				brown_bricks_slab.setRegistryName(ModBlockReference.brown_bricks_halfslab.getRegistryName());
		ItemBlock green_bricks_slab = new ItemSlab(ModBlockReference.green_bricks_halfslab, 
				(BlockSlab)ModBlockReference.green_bricks_halfslab, 
				(BlockSlab)ModBlockReference.green_bricks_doubleslab);
				green_bricks_slab.setRegistryName(ModBlockReference.green_bricks_halfslab.getRegistryName());
		ItemBlock red_bricks_slab = new ItemSlab(ModBlockReference.red_bricks_halfslab, 
				(BlockSlab)ModBlockReference.red_bricks_halfslab, 
				(BlockSlab)ModBlockReference.red_bricks_doubleslab);
				red_bricks_slab.setRegistryName(ModBlockReference.red_bricks_halfslab.getRegistryName());
		ItemBlock black_bricks_slab = new ItemSlab(ModBlockReference.black_bricks_halfslab, 
				(BlockSlab)ModBlockReference.black_bricks_halfslab, 
				(BlockSlab)ModBlockReference.black_bricks_doubleslab);
				black_bricks_slab.setRegistryName(ModBlockReference.black_bricks_halfslab.getRegistryName());
				
				
		ItemBlock white_terracotta_slab = new ItemSlab(ModBlockReference.white_terracotta_halfslab, 
				(BlockSlab)ModBlockReference.white_terracotta_halfslab, 
				(BlockSlab)ModBlockReference.white_terracotta_doubleslab);
				white_terracotta_slab.setRegistryName(ModBlockReference.white_terracotta_halfslab.getRegistryName());
		ItemBlock orange_terracotta_slab = new ItemSlab(ModBlockReference.orange_terracotta_halfslab, 
				(BlockSlab)ModBlockReference.orange_terracotta_halfslab, 
				(BlockSlab)ModBlockReference.orange_terracotta_doubleslab);
				orange_terracotta_slab.setRegistryName(ModBlockReference.orange_terracotta_halfslab.getRegistryName());
		ItemBlock magenta_terracotta_slab = new ItemSlab(ModBlockReference.magenta_terracotta_halfslab, 
				(BlockSlab)ModBlockReference.magenta_terracotta_halfslab, 
				(BlockSlab)ModBlockReference.magenta_terracotta_doubleslab);
				magenta_terracotta_slab.setRegistryName(ModBlockReference.magenta_terracotta_halfslab.getRegistryName());
		ItemBlock lightblue_terracotta_slab = new ItemSlab(ModBlockReference.lightblue_terracotta_halfslab, 
				(BlockSlab)ModBlockReference.lightblue_terracotta_halfslab, 
				(BlockSlab)ModBlockReference.lightblue_terracotta_doubleslab);
				lightblue_terracotta_slab.setRegistryName(ModBlockReference.lightblue_terracotta_halfslab.getRegistryName());
		ItemBlock yellow_terracotta_slab = new ItemSlab(ModBlockReference.yellow_terracotta_halfslab, 
				(BlockSlab)ModBlockReference.yellow_terracotta_halfslab, 
				(BlockSlab)ModBlockReference.yellow_terracotta_doubleslab);
				yellow_terracotta_slab.setRegistryName(ModBlockReference.yellow_terracotta_halfslab.getRegistryName());
		ItemBlock lime_terracotta_slab = new ItemSlab(ModBlockReference.lime_terracotta_halfslab, 
				(BlockSlab)ModBlockReference.lime_terracotta_halfslab, 
				(BlockSlab)ModBlockReference.lime_terracotta_doubleslab);
				lime_terracotta_slab.setRegistryName(ModBlockReference.lime_terracotta_halfslab.getRegistryName());
		ItemBlock pink_terracotta_slab = new ItemSlab(ModBlockReference.pink_terracotta_halfslab, 
				(BlockSlab)ModBlockReference.pink_terracotta_halfslab, 
				(BlockSlab)ModBlockReference.pink_terracotta_doubleslab);
				pink_terracotta_slab.setRegistryName(ModBlockReference.pink_terracotta_halfslab.getRegistryName());
		ItemBlock gray_terracotta_slab = new ItemSlab(ModBlockReference.gray_terracotta_halfslab, 
				(BlockSlab)ModBlockReference.gray_terracotta_halfslab, 
				(BlockSlab)ModBlockReference.gray_terracotta_doubleslab);
				gray_terracotta_slab.setRegistryName(ModBlockReference.gray_terracotta_halfslab.getRegistryName());
		ItemBlock silver_terracotta_slab = new ItemSlab(ModBlockReference.silver_terracotta_halfslab, 
				(BlockSlab)ModBlockReference.silver_terracotta_halfslab, 
				(BlockSlab)ModBlockReference.silver_terracotta_doubleslab);
				silver_terracotta_slab.setRegistryName(ModBlockReference.silver_terracotta_halfslab.getRegistryName());
		ItemBlock cyan_terracotta_slab = new ItemSlab(ModBlockReference.cyan_terracotta_halfslab, 
				(BlockSlab)ModBlockReference.cyan_terracotta_halfslab, 
				(BlockSlab)ModBlockReference.cyan_terracotta_doubleslab);
				cyan_terracotta_slab.setRegistryName(ModBlockReference.cyan_terracotta_halfslab.getRegistryName());
		ItemBlock purple_terracotta_slab = new ItemSlab(ModBlockReference.purple_terracotta_halfslab, 
				(BlockSlab)ModBlockReference.purple_terracotta_halfslab, 
				(BlockSlab)ModBlockReference.purple_terracotta_doubleslab);
				purple_terracotta_slab.setRegistryName(ModBlockReference.purple_terracotta_halfslab.getRegistryName());
		ItemBlock blue_terracotta_slab = new ItemSlab(ModBlockReference.blue_terracotta_halfslab, 
				(BlockSlab)ModBlockReference.blue_terracotta_halfslab, 
				(BlockSlab)ModBlockReference.blue_terracotta_doubleslab);
				blue_terracotta_slab.setRegistryName(ModBlockReference.blue_terracotta_halfslab.getRegistryName());
		ItemBlock brown_terracotta_slab = new ItemSlab(ModBlockReference.brown_terracotta_halfslab, 
				(BlockSlab)ModBlockReference.brown_terracotta_halfslab, 
				(BlockSlab)ModBlockReference.brown_terracotta_doubleslab);
				brown_terracotta_slab.setRegistryName(ModBlockReference.brown_terracotta_halfslab.getRegistryName());
		ItemBlock green_terracotta_slab = new ItemSlab(ModBlockReference.green_terracotta_halfslab, 
				(BlockSlab)ModBlockReference.green_terracotta_halfslab, 
				(BlockSlab)ModBlockReference.green_terracotta_doubleslab);
				green_terracotta_slab.setRegistryName(ModBlockReference.green_terracotta_halfslab.getRegistryName());
		ItemBlock red_terracotta_slab = new ItemSlab(ModBlockReference.red_terracotta_halfslab, 
				(BlockSlab)ModBlockReference.red_terracotta_halfslab, 
				(BlockSlab)ModBlockReference.red_terracotta_doubleslab);
				red_terracotta_slab.setRegistryName(ModBlockReference.red_terracotta_halfslab.getRegistryName());
		ItemBlock black_terracotta_slab = new ItemSlab(ModBlockReference.black_terracotta_halfslab, 
				(BlockSlab)ModBlockReference.black_terracotta_halfslab, 
				(BlockSlab)ModBlockReference.black_terracotta_doubleslab);
				black_terracotta_slab.setRegistryName(ModBlockReference.black_terracotta_halfslab.getRegistryName());
				
				
		ItemBlock white_terracotta_brick_slab = new ItemSlab(ModBlockReference.white_terracotta_brick_halfslab, 
				(BlockSlab)ModBlockReference.white_terracotta_brick_halfslab, 
				(BlockSlab)ModBlockReference.white_terracotta_brick_doubleslab);
				white_terracotta_brick_slab.setRegistryName(ModBlockReference.white_terracotta_brick_halfslab.getRegistryName());
		ItemBlock orange_terracotta_brick_slab = new ItemSlab(ModBlockReference.orange_terracotta_brick_halfslab, 
				(BlockSlab)ModBlockReference.orange_terracotta_brick_halfslab, 
				(BlockSlab)ModBlockReference.orange_terracotta_brick_doubleslab);
				orange_terracotta_brick_slab.setRegistryName(ModBlockReference.orange_terracotta_brick_halfslab.getRegistryName());
		ItemBlock magenta_terracotta_brick_slab = new ItemSlab(ModBlockReference.magenta_terracotta_brick_halfslab, 
				(BlockSlab)ModBlockReference.magenta_terracotta_brick_halfslab, 
				(BlockSlab)ModBlockReference.magenta_terracotta_brick_doubleslab);
				magenta_terracotta_brick_slab.setRegistryName(ModBlockReference.magenta_terracotta_brick_halfslab.getRegistryName());
		ItemBlock lightblue_terracotta_brick_slab = new ItemSlab(ModBlockReference.lightblue_terracotta_brick_halfslab, 
				(BlockSlab)ModBlockReference.lightblue_terracotta_brick_halfslab, 
				(BlockSlab)ModBlockReference.lightblue_terracotta_brick_doubleslab);
				lightblue_terracotta_brick_slab.setRegistryName(ModBlockReference.lightblue_terracotta_brick_halfslab.getRegistryName());
		ItemBlock yellow_terracotta_brick_slab = new ItemSlab(ModBlockReference.yellow_terracotta_brick_halfslab, 
				(BlockSlab)ModBlockReference.yellow_terracotta_brick_halfslab, 
				(BlockSlab)ModBlockReference.yellow_terracotta_brick_doubleslab);
				yellow_terracotta_brick_slab.setRegistryName(ModBlockReference.yellow_terracotta_brick_halfslab.getRegistryName());
		ItemBlock lime_terracotta_brick_slab = new ItemSlab(ModBlockReference.lime_terracotta_brick_halfslab, 
				(BlockSlab)ModBlockReference.lime_terracotta_brick_halfslab, 
				(BlockSlab)ModBlockReference.lime_terracotta_brick_doubleslab);
				lime_terracotta_brick_slab.setRegistryName(ModBlockReference.lime_terracotta_brick_halfslab.getRegistryName());
		ItemBlock pink_terracotta_brick_slab = new ItemSlab(ModBlockReference.pink_terracotta_brick_halfslab, 
				(BlockSlab)ModBlockReference.pink_terracotta_brick_halfslab, 
				(BlockSlab)ModBlockReference.pink_terracotta_brick_doubleslab);
				pink_terracotta_brick_slab.setRegistryName(ModBlockReference.pink_terracotta_brick_halfslab.getRegistryName());
		ItemBlock gray_terracotta_brick_slab = new ItemSlab(ModBlockReference.gray_terracotta_brick_halfslab, 
				(BlockSlab)ModBlockReference.gray_terracotta_brick_halfslab, 
				(BlockSlab)ModBlockReference.gray_terracotta_brick_doubleslab);
				gray_terracotta_brick_slab.setRegistryName(ModBlockReference.gray_terracotta_brick_halfslab.getRegistryName());
		ItemBlock silver_terracotta_brick_slab = new ItemSlab(ModBlockReference.silver_terracotta_brick_halfslab, 
				(BlockSlab)ModBlockReference.silver_terracotta_brick_halfslab, 
				(BlockSlab)ModBlockReference.silver_terracotta_brick_doubleslab);
				silver_terracotta_brick_slab.setRegistryName(ModBlockReference.silver_terracotta_brick_halfslab.getRegistryName());
		ItemBlock cyan_terracotta_brick_slab = new ItemSlab(ModBlockReference.cyan_terracotta_brick_halfslab, 
				(BlockSlab)ModBlockReference.cyan_terracotta_brick_halfslab, 
				(BlockSlab)ModBlockReference.cyan_terracotta_brick_doubleslab);
				cyan_terracotta_brick_slab.setRegistryName(ModBlockReference.cyan_terracotta_brick_halfslab.getRegistryName());
		ItemBlock purple_terracotta_brick_slab = new ItemSlab(ModBlockReference.purple_terracotta_brick_halfslab, 
				(BlockSlab)ModBlockReference.purple_terracotta_brick_halfslab, 
				(BlockSlab)ModBlockReference.purple_terracotta_brick_doubleslab);
				purple_terracotta_brick_slab.setRegistryName(ModBlockReference.purple_terracotta_brick_halfslab.getRegistryName());
		ItemBlock blue_terracotta_brick_slab = new ItemSlab(ModBlockReference.blue_terracotta_brick_halfslab, 
				(BlockSlab)ModBlockReference.blue_terracotta_brick_halfslab, 
				(BlockSlab)ModBlockReference.blue_terracotta_brick_doubleslab);
				blue_terracotta_brick_slab.setRegistryName(ModBlockReference.blue_terracotta_brick_halfslab.getRegistryName());
		ItemBlock brown_terracotta_brick_slab = new ItemSlab(ModBlockReference.brown_terracotta_brick_halfslab, 
				(BlockSlab)ModBlockReference.brown_terracotta_brick_halfslab, 
				(BlockSlab)ModBlockReference.brown_terracotta_brick_doubleslab);
				brown_terracotta_brick_slab.setRegistryName(ModBlockReference.brown_terracotta_brick_halfslab.getRegistryName());
		ItemBlock green_terracotta_brick_slab = new ItemSlab(ModBlockReference.green_terracotta_brick_halfslab, 
				(BlockSlab)ModBlockReference.green_terracotta_brick_halfslab, 
				(BlockSlab)ModBlockReference.green_terracotta_brick_doubleslab);
				green_terracotta_brick_slab.setRegistryName(ModBlockReference.green_terracotta_brick_halfslab.getRegistryName());
		ItemBlock red_terracotta_brick_slab = new ItemSlab(ModBlockReference.red_terracotta_brick_halfslab, 
				(BlockSlab)ModBlockReference.red_terracotta_brick_halfslab, 
				(BlockSlab)ModBlockReference.red_terracotta_brick_doubleslab);
				red_terracotta_brick_slab.setRegistryName(ModBlockReference.red_terracotta_brick_halfslab.getRegistryName());
		ItemBlock black_terracotta_brick_slab = new ItemSlab(ModBlockReference.black_terracotta_brick_halfslab, 
				(BlockSlab)ModBlockReference.black_terracotta_brick_halfslab, 
				(BlockSlab)ModBlockReference.black_terracotta_brick_doubleslab);
				black_terracotta_brick_slab.setRegistryName(ModBlockReference.black_terracotta_brick_halfslab.getRegistryName());
				
		ItemBlock white_terracotta_cracked_brick_slab = new ItemSlab(ModBlockReference.white_terracotta_cracked_brick_halfslab, 
				(BlockSlab)ModBlockReference.white_terracotta_cracked_brick_halfslab, 
				(BlockSlab)ModBlockReference.white_terracotta_cracked_brick_doubleslab);
				white_terracotta_cracked_brick_slab.setRegistryName(ModBlockReference.white_terracotta_cracked_brick_halfslab.getRegistryName());
		ItemBlock orange_terracotta_cracked_brick_slab = new ItemSlab(ModBlockReference.orange_terracotta_cracked_brick_halfslab, 
				(BlockSlab)ModBlockReference.orange_terracotta_cracked_brick_halfslab, 
				(BlockSlab)ModBlockReference.orange_terracotta_cracked_brick_doubleslab);
				orange_terracotta_cracked_brick_slab.setRegistryName(ModBlockReference.orange_terracotta_cracked_brick_halfslab.getRegistryName());
		ItemBlock magenta_terracotta_cracked_brick_slab = new ItemSlab(ModBlockReference.magenta_terracotta_cracked_brick_halfslab, 
				(BlockSlab)ModBlockReference.magenta_terracotta_cracked_brick_halfslab, 
				(BlockSlab)ModBlockReference.magenta_terracotta_cracked_brick_doubleslab);
				magenta_terracotta_cracked_brick_slab.setRegistryName(ModBlockReference.magenta_terracotta_cracked_brick_halfslab.getRegistryName());
		ItemBlock lightblue_terracotta_cracked_brick_slab = new ItemSlab(ModBlockReference.lightblue_terracotta_cracked_brick_halfslab, 
				(BlockSlab)ModBlockReference.lightblue_terracotta_cracked_brick_halfslab, 
				(BlockSlab)ModBlockReference.lightblue_terracotta_cracked_brick_doubleslab);
				lightblue_terracotta_cracked_brick_slab.setRegistryName(ModBlockReference.lightblue_terracotta_cracked_brick_halfslab.getRegistryName());
		ItemBlock yellow_terracotta_cracked_brick_slab = new ItemSlab(ModBlockReference.yellow_terracotta_cracked_brick_halfslab, 
				(BlockSlab)ModBlockReference.yellow_terracotta_cracked_brick_halfslab, 
				(BlockSlab)ModBlockReference.yellow_terracotta_cracked_brick_doubleslab);
				yellow_terracotta_cracked_brick_slab.setRegistryName(ModBlockReference.yellow_terracotta_cracked_brick_halfslab.getRegistryName());
		ItemBlock lime_terracotta_cracked_brick_slab = new ItemSlab(ModBlockReference.lime_terracotta_cracked_brick_halfslab, 
				(BlockSlab)ModBlockReference.lime_terracotta_cracked_brick_halfslab, 
				(BlockSlab)ModBlockReference.lime_terracotta_cracked_brick_doubleslab);
				lime_terracotta_cracked_brick_slab.setRegistryName(ModBlockReference.lime_terracotta_cracked_brick_halfslab.getRegistryName());
		ItemBlock pink_terracotta_cracked_brick_slab = new ItemSlab(ModBlockReference.pink_terracotta_cracked_brick_halfslab, 
				(BlockSlab)ModBlockReference.pink_terracotta_cracked_brick_halfslab, 
				(BlockSlab)ModBlockReference.pink_terracotta_cracked_brick_doubleslab);
				pink_terracotta_cracked_brick_slab.setRegistryName(ModBlockReference.pink_terracotta_cracked_brick_halfslab.getRegistryName());
		ItemBlock gray_terracotta_cracked_brick_slab = new ItemSlab(ModBlockReference.gray_terracotta_cracked_brick_halfslab, 
				(BlockSlab)ModBlockReference.gray_terracotta_cracked_brick_halfslab, 
				(BlockSlab)ModBlockReference.gray_terracotta_cracked_brick_doubleslab);
				gray_terracotta_cracked_brick_slab.setRegistryName(ModBlockReference.gray_terracotta_cracked_brick_halfslab.getRegistryName());
		ItemBlock silver_terracotta_cracked_brick_slab = new ItemSlab(ModBlockReference.silver_terracotta_cracked_brick_halfslab, 
				(BlockSlab)ModBlockReference.silver_terracotta_cracked_brick_halfslab, 
				(BlockSlab)ModBlockReference.silver_terracotta_cracked_brick_doubleslab);
				silver_terracotta_cracked_brick_slab.setRegistryName(ModBlockReference.silver_terracotta_cracked_brick_halfslab.getRegistryName());
		ItemBlock cyan_terracotta_cracked_brick_slab = new ItemSlab(ModBlockReference.cyan_terracotta_cracked_brick_halfslab, 
				(BlockSlab)ModBlockReference.cyan_terracotta_cracked_brick_halfslab, 
				(BlockSlab)ModBlockReference.cyan_terracotta_cracked_brick_doubleslab);
				cyan_terracotta_cracked_brick_slab.setRegistryName(ModBlockReference.cyan_terracotta_cracked_brick_halfslab.getRegistryName());
		ItemBlock purple_terracotta_cracked_brick_slab = new ItemSlab(ModBlockReference.purple_terracotta_cracked_brick_halfslab, 
				(BlockSlab)ModBlockReference.purple_terracotta_cracked_brick_halfslab, 
				(BlockSlab)ModBlockReference.purple_terracotta_cracked_brick_doubleslab);
				purple_terracotta_cracked_brick_slab.setRegistryName(ModBlockReference.purple_terracotta_cracked_brick_halfslab.getRegistryName());
		ItemBlock blue_terracotta_cracked_brick_slab = new ItemSlab(ModBlockReference.blue_terracotta_cracked_brick_halfslab, 
				(BlockSlab)ModBlockReference.blue_terracotta_cracked_brick_halfslab, 
				(BlockSlab)ModBlockReference.blue_terracotta_cracked_brick_doubleslab);
				blue_terracotta_cracked_brick_slab.setRegistryName(ModBlockReference.blue_terracotta_cracked_brick_halfslab.getRegistryName());
		ItemBlock brown_terracotta_cracked_brick_slab = new ItemSlab(ModBlockReference.brown_terracotta_cracked_brick_halfslab, 
				(BlockSlab)ModBlockReference.brown_terracotta_cracked_brick_halfslab, 
				(BlockSlab)ModBlockReference.brown_terracotta_cracked_brick_doubleslab);
				brown_terracotta_cracked_brick_slab.setRegistryName(ModBlockReference.brown_terracotta_cracked_brick_halfslab.getRegistryName());
		ItemBlock green_terracotta_cracked_brick_slab = new ItemSlab(ModBlockReference.green_terracotta_cracked_brick_halfslab, 
				(BlockSlab)ModBlockReference.green_terracotta_cracked_brick_halfslab, 
				(BlockSlab)ModBlockReference.green_terracotta_cracked_brick_doubleslab);
				green_terracotta_cracked_brick_slab.setRegistryName(ModBlockReference.green_terracotta_cracked_brick_halfslab.getRegistryName());
		ItemBlock red_terracotta_cracked_brick_slab = new ItemSlab(ModBlockReference.red_terracotta_cracked_brick_halfslab, 
				(BlockSlab)ModBlockReference.red_terracotta_cracked_brick_halfslab, 
				(BlockSlab)ModBlockReference.red_terracotta_cracked_brick_doubleslab);
				red_terracotta_cracked_brick_slab.setRegistryName(ModBlockReference.red_terracotta_cracked_brick_halfslab.getRegistryName());
		ItemBlock black_terracotta_cracked_brick_slab = new ItemSlab(ModBlockReference.black_terracotta_cracked_brick_halfslab, 
				(BlockSlab)ModBlockReference.black_terracotta_cracked_brick_halfslab, 
				(BlockSlab)ModBlockReference.black_terracotta_cracked_brick_doubleslab);
				black_terracotta_cracked_brick_slab.setRegistryName(ModBlockReference.black_terracotta_cracked_brick_halfslab.getRegistryName());
				
		ItemBlock white_concrete_slab = new ItemSlab(ModBlockReference.white_concrete_halfslab, 
				(BlockSlab)ModBlockReference.white_concrete_halfslab, 
				(BlockSlab)ModBlockReference.white_concrete_doubleslab);
				white_concrete_slab.setRegistryName(ModBlockReference.white_concrete_halfslab.getRegistryName());
		ItemBlock orange_concrete_slab = new ItemSlab(ModBlockReference.orange_concrete_halfslab, 
				(BlockSlab)ModBlockReference.orange_concrete_halfslab, 
				(BlockSlab)ModBlockReference.orange_concrete_doubleslab);
				orange_concrete_slab.setRegistryName(ModBlockReference.orange_concrete_halfslab.getRegistryName());
		ItemBlock magenta_concrete_slab = new ItemSlab(ModBlockReference.magenta_concrete_halfslab, 
				(BlockSlab)ModBlockReference.magenta_concrete_halfslab, 
				(BlockSlab)ModBlockReference.magenta_concrete_doubleslab);
				magenta_concrete_slab.setRegistryName(ModBlockReference.magenta_concrete_halfslab.getRegistryName());
		ItemBlock lightblue_concrete_slab = new ItemSlab(ModBlockReference.lightblue_concrete_halfslab, 
				(BlockSlab)ModBlockReference.lightblue_concrete_halfslab, 
				(BlockSlab)ModBlockReference.lightblue_concrete_doubleslab);
				lightblue_concrete_slab.setRegistryName(ModBlockReference.lightblue_concrete_halfslab.getRegistryName());
		ItemBlock yellow_concrete_slab = new ItemSlab(ModBlockReference.yellow_concrete_halfslab, 
				(BlockSlab)ModBlockReference.yellow_concrete_halfslab, 
				(BlockSlab)ModBlockReference.yellow_concrete_doubleslab);
				yellow_concrete_slab.setRegistryName(ModBlockReference.yellow_concrete_halfslab.getRegistryName());
		ItemBlock lime_concrete_slab = new ItemSlab(ModBlockReference.lime_concrete_halfslab, 
				(BlockSlab)ModBlockReference.lime_concrete_halfslab, 
				(BlockSlab)ModBlockReference.lime_concrete_doubleslab);
				lime_concrete_slab.setRegistryName(ModBlockReference.lime_concrete_halfslab.getRegistryName());
		ItemBlock pink_concrete_slab = new ItemSlab(ModBlockReference.pink_concrete_halfslab, 
				(BlockSlab)ModBlockReference.pink_concrete_halfslab, 
				(BlockSlab)ModBlockReference.pink_concrete_doubleslab);
				pink_concrete_slab.setRegistryName(ModBlockReference.pink_concrete_halfslab.getRegistryName());
		ItemBlock gray_concrete_slab = new ItemSlab(ModBlockReference.gray_concrete_halfslab, 
				(BlockSlab)ModBlockReference.gray_concrete_halfslab, 
				(BlockSlab)ModBlockReference.gray_concrete_doubleslab);
				gray_concrete_slab.setRegistryName(ModBlockReference.gray_concrete_halfslab.getRegistryName());
		ItemBlock silver_concrete_slab = new ItemSlab(ModBlockReference.silver_concrete_halfslab, 
				(BlockSlab)ModBlockReference.silver_concrete_halfslab, 
				(BlockSlab)ModBlockReference.silver_concrete_doubleslab);
				silver_concrete_slab.setRegistryName(ModBlockReference.silver_concrete_halfslab.getRegistryName());
		ItemBlock cyan_concrete_slab = new ItemSlab(ModBlockReference.cyan_concrete_halfslab, 
				(BlockSlab)ModBlockReference.cyan_concrete_halfslab, 
				(BlockSlab)ModBlockReference.cyan_concrete_doubleslab);
				cyan_concrete_slab.setRegistryName(ModBlockReference.cyan_concrete_halfslab.getRegistryName());
		ItemBlock purple_concrete_slab = new ItemSlab(ModBlockReference.purple_concrete_halfslab, 
				(BlockSlab)ModBlockReference.purple_concrete_halfslab, 
				(BlockSlab)ModBlockReference.purple_concrete_doubleslab);
				purple_concrete_slab.setRegistryName(ModBlockReference.purple_concrete_halfslab.getRegistryName());
		ItemBlock blue_concrete_slab = new ItemSlab(ModBlockReference.blue_concrete_halfslab, 
				(BlockSlab)ModBlockReference.blue_concrete_halfslab, 
				(BlockSlab)ModBlockReference.blue_concrete_doubleslab);
				blue_concrete_slab.setRegistryName(ModBlockReference.blue_concrete_halfslab.getRegistryName());
		ItemBlock brown_concrete_slab = new ItemSlab(ModBlockReference.brown_concrete_halfslab, 
				(BlockSlab)ModBlockReference.brown_concrete_halfslab, 
				(BlockSlab)ModBlockReference.brown_concrete_doubleslab);
				brown_concrete_slab.setRegistryName(ModBlockReference.brown_concrete_halfslab.getRegistryName());
		ItemBlock green_concrete_slab = new ItemSlab(ModBlockReference.green_concrete_halfslab, 
				(BlockSlab)ModBlockReference.green_concrete_halfslab, 
				(BlockSlab)ModBlockReference.green_concrete_doubleslab);
				green_concrete_slab.setRegistryName(ModBlockReference.green_concrete_halfslab.getRegistryName());
		ItemBlock red_concrete_slab = new ItemSlab(ModBlockReference.red_concrete_halfslab, 
				(BlockSlab)ModBlockReference.red_concrete_halfslab, 
				(BlockSlab)ModBlockReference.red_concrete_doubleslab);
				red_concrete_slab.setRegistryName(ModBlockReference.red_concrete_halfslab.getRegistryName());
		ItemBlock black_concrete_slab = new ItemSlab(ModBlockReference.black_concrete_halfslab, 
				(BlockSlab)ModBlockReference.black_concrete_halfslab, 
				(BlockSlab)ModBlockReference.black_concrete_doubleslab);
				black_concrete_slab.setRegistryName(ModBlockReference.black_concrete_halfslab.getRegistryName());
				
		ItemBlock limestone_slab = new ItemSlab(ModBlockReference.limestone_halfslab,
				(BlockSlab)ModBlockReference.limestone_halfslab,
				(BlockSlab)ModBlockReference.limestone_doubleslab);
				limestone_slab.setRegistryName(ModBlockReference.limestone_halfslab.getRegistryName());
		ItemBlock limestone_cobble_slab = new ItemSlab(ModBlockReference.limestone_cobble_halfslab,
				(BlockSlab)ModBlockReference.limestone_cobble_halfslab,
				(BlockSlab)ModBlockReference.limestone_cobble_doubleslab);
				limestone_cobble_slab.setRegistryName(ModBlockReference.limestone_cobble_halfslab.getRegistryName());
		ItemBlock limestone_brick_slab = new ItemSlab(ModBlockReference.limestone_brick_halfslab,
				(BlockSlab)ModBlockReference.limestone_brick_halfslab,
				(BlockSlab)ModBlockReference.limestone_brick_doubleslab);
				limestone_brick_slab.setRegistryName(ModBlockReference.limestone_brick_halfslab.getRegistryName());
		ItemBlock limestone_cracked_brick_slab = new ItemSlab(ModBlockReference.limestone_cracked_brick_halfslab,
				(BlockSlab)ModBlockReference.limestone_cracked_brick_halfslab,
				(BlockSlab)ModBlockReference.limestone_cracked_brick_doubleslab);
				limestone_cracked_brick_slab.setRegistryName(ModBlockReference.limestone_cracked_brick_halfslab.getRegistryName());
				
		ItemBlock marblestone_slab = new ItemSlab(ModBlockReference.marblestone_halfslab,
				(BlockSlab)ModBlockReference.marblestone_halfslab,
				(BlockSlab)ModBlockReference.marblestone_doubleslab);
				marblestone_slab.setRegistryName(ModBlockReference.marblestone_halfslab.getRegistryName());
		ItemBlock marblestone_cobble_slab = new ItemSlab(ModBlockReference.marblestone_cobble_halfslab,
				(BlockSlab)ModBlockReference.marblestone_cobble_halfslab,
				(BlockSlab)ModBlockReference.marblestone_cobble_doubleslab);
				marblestone_cobble_slab.setRegistryName(ModBlockReference.marblestone_cobble_halfslab.getRegistryName());
		ItemBlock marblestone_brick_slab = new ItemSlab(ModBlockReference.marblestone_brick_halfslab,
				(BlockSlab)ModBlockReference.marblestone_brick_halfslab,
				(BlockSlab)ModBlockReference.marblestone_brick_doubleslab);
				marblestone_brick_slab.setRegistryName(ModBlockReference.marblestone_brick_halfslab.getRegistryName());
		ItemBlock marblestone_cracked_brick_slab = new ItemSlab(ModBlockReference.marblestone_cracked_brick_halfslab,
				(BlockSlab)ModBlockReference.marblestone_cracked_brick_halfslab,
				(BlockSlab)ModBlockReference.marblestone_cracked_brick_doubleslab);
				marblestone_cracked_brick_slab.setRegistryName(ModBlockReference.marblestone_cracked_brick_halfslab.getRegistryName());
		
		event.getRegistry().registerAll(
				white_bricks_slab,
				orange_bricks_slab,
				magenta_bricks_slab,
				lightblue_bricks_slab,
				yellow_bricks_slab,
				lime_bricks_slab,
				pink_bricks_slab,
				gray_bricks_slab,
				silver_bricks_slab,
				cyan_bricks_slab,
				purple_bricks_slab,
				blue_bricks_slab,
				brown_bricks_slab,
				green_bricks_slab,
				red_bricks_slab,
				black_bricks_slab,
				white_terracotta_slab,
				orange_terracotta_slab,
				magenta_terracotta_slab,
				lightblue_terracotta_slab,
				yellow_terracotta_slab,
				lime_terracotta_slab,
				pink_terracotta_slab,
				gray_terracotta_slab,
				silver_terracotta_slab,
				cyan_terracotta_slab,
				purple_terracotta_slab,
				blue_terracotta_slab,
				brown_terracotta_slab,
				green_terracotta_slab,
				red_terracotta_slab,
				black_terracotta_slab,
				white_terracotta_brick_slab,
				orange_terracotta_brick_slab,
				magenta_terracotta_brick_slab,
				lightblue_terracotta_brick_slab,
				yellow_terracotta_brick_slab,
				lime_terracotta_brick_slab,
				pink_terracotta_brick_slab,
				gray_terracotta_brick_slab,
				silver_terracotta_brick_slab,
				cyan_terracotta_brick_slab,
				purple_terracotta_brick_slab,
				blue_terracotta_brick_slab,
				brown_terracotta_brick_slab,
				green_terracotta_brick_slab,
				red_terracotta_brick_slab,
				black_terracotta_brick_slab,
				white_terracotta_cracked_brick_slab,
				orange_terracotta_cracked_brick_slab,
				magenta_terracotta_cracked_brick_slab,
				lightblue_terracotta_cracked_brick_slab,
				yellow_terracotta_cracked_brick_slab,
				lime_terracotta_cracked_brick_slab,
				pink_terracotta_cracked_brick_slab,
				gray_terracotta_cracked_brick_slab,
				silver_terracotta_cracked_brick_slab,
				cyan_terracotta_cracked_brick_slab,
				purple_terracotta_cracked_brick_slab,
				blue_terracotta_cracked_brick_slab,
				brown_terracotta_cracked_brick_slab,
				green_terracotta_cracked_brick_slab,
				red_terracotta_cracked_brick_slab,
				black_terracotta_cracked_brick_slab,
				white_concrete_slab,
				orange_concrete_slab,
				magenta_concrete_slab,
				lightblue_concrete_slab,
				yellow_concrete_slab,
				lime_concrete_slab,
				pink_concrete_slab,
				gray_concrete_slab,
				silver_concrete_slab,
				cyan_concrete_slab,
				purple_concrete_slab,
				blue_concrete_slab,
				brown_concrete_slab,
				green_concrete_slab,
				red_concrete_slab,
				black_concrete_slab,
				limestone_slab,
				limestone_cobble_slab,
				limestone_brick_slab,
				limestone_cracked_brick_slab,
				marblestone_slab,
				marblestone_cobble_slab,
				marblestone_brick_slab,
				marblestone_cracked_brick_slab				
				);		
		
		OreDictionary.registerOre("blockBricks", new ItemStack(ModBlockReference.white_bricks));
		OreDictionary.registerOre("blockBricks", new ItemStack(ModBlockReference.orange_bricks));
		OreDictionary.registerOre("blockBricks", new ItemStack(ModBlockReference.magenta_bricks));
		OreDictionary.registerOre("blockBricks", new ItemStack(ModBlockReference.lightblue_bricks));
		OreDictionary.registerOre("blockBricks", new ItemStack(ModBlockReference.yellow_bricks));
		OreDictionary.registerOre("blockBricks", new ItemStack(ModBlockReference.lime_bricks));
		OreDictionary.registerOre("blockBricks", new ItemStack(ModBlockReference.pink_bricks));
		OreDictionary.registerOre("blockBricks", new ItemStack(ModBlockReference.gray_bricks));
		OreDictionary.registerOre("blockBricks", new ItemStack(ModBlockReference.silver_bricks));
		OreDictionary.registerOre("blockBricks", new ItemStack(ModBlockReference.cyan_bricks));
		OreDictionary.registerOre("blockBricks", new ItemStack(ModBlockReference.purple_bricks));
		OreDictionary.registerOre("blockBricks", new ItemStack(ModBlockReference.blue_bricks));
		OreDictionary.registerOre("blockBricks", new ItemStack(ModBlockReference.brown_bricks));
		OreDictionary.registerOre("blockBricks", new ItemStack(ModBlockReference.green_bricks));
		OreDictionary.registerOre("blockBricks", new ItemStack(ModBlockReference.red_bricks));
		OreDictionary.registerOre("blockBricks", new ItemStack(ModBlockReference.black_bricks));
	
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		
		
		
		System.out.println("Registering all blocks from the BLOCKS registrylist");
		
		//REGISTERING ALL BLOCKS
		event.getRegistry().registerAll(
		
		//Creating terracotta bricks
		ModBlockReference.white_bricks = new BlockBricks(Blocks.BRICK_BLOCK.getBlockState().getBlock(), MapColor.WHITE_STAINED_HARDENED_CLAY , new ResourceLocation(References.PREFIX + "white_bricks")),
		ModBlockReference.orange_bricks = new BlockBricks(Blocks.BRICK_BLOCK.getBlockState().getBlock(), MapColor.ORANGE_STAINED_HARDENED_CLAY, new ResourceLocation(References.PREFIX + "orange_bricks")),
		ModBlockReference.magenta_bricks = new BlockBricks(Blocks.BRICK_BLOCK.getBlockState().getBlock(), MapColor.MAGENTA_STAINED_HARDENED_CLAY, new ResourceLocation(References.PREFIX + "magenta_bricks")),
		ModBlockReference.lightblue_bricks = new BlockBricks(Blocks.BRICK_BLOCK.getBlockState().getBlock(), MapColor.LIGHT_BLUE_STAINED_HARDENED_CLAY, new ResourceLocation(References.PREFIX + "lightblue_bricks")),
		ModBlockReference.yellow_bricks = new BlockBricks(Blocks.BRICK_BLOCK.getBlockState().getBlock(), MapColor.YELLOW_STAINED_HARDENED_CLAY, new ResourceLocation(References.PREFIX + "yellow_bricks")),
		ModBlockReference.lime_bricks = new BlockBricks(Blocks.BRICK_BLOCK.getBlockState().getBlock(), MapColor.LIME_STAINED_HARDENED_CLAY, new ResourceLocation(References.PREFIX + "lime_bricks")),
		ModBlockReference.pink_bricks = new BlockBricks(Blocks.BRICK_BLOCK.getBlockState().getBlock(), MapColor.PINK_STAINED_HARDENED_CLAY, new ResourceLocation(References.PREFIX + "pink_bricks")),
		ModBlockReference.gray_bricks = new BlockBricks(Blocks.BRICK_BLOCK.getBlockState().getBlock(), MapColor.GRAY_STAINED_HARDENED_CLAY, new ResourceLocation(References.PREFIX + "gray_bricks")),
		ModBlockReference.silver_bricks = new BlockBricks(Blocks.BRICK_BLOCK.getBlockState().getBlock(), MapColor.SILVER_STAINED_HARDENED_CLAY, new ResourceLocation(References.PREFIX + "silver_bricks")),
		ModBlockReference.cyan_bricks = new BlockBricks(Blocks.BRICK_BLOCK.getBlockState().getBlock(), MapColor.CYAN_STAINED_HARDENED_CLAY, new ResourceLocation(References.PREFIX + "cyan_bricks")),
		ModBlockReference.purple_bricks = new BlockBricks(Blocks.BRICK_BLOCK.getBlockState().getBlock(), MapColor.PURPLE_STAINED_HARDENED_CLAY, new ResourceLocation(References.PREFIX + "purple_bricks")),
		ModBlockReference.blue_bricks = new BlockBricks(Blocks.BRICK_BLOCK.getBlockState().getBlock(), MapColor.BLUE_STAINED_HARDENED_CLAY, new ResourceLocation(References.PREFIX + "blue_bricks")),
		ModBlockReference.brown_bricks = new BlockBricks(Blocks.BRICK_BLOCK.getBlockState().getBlock(), MapColor.BROWN_STAINED_HARDENED_CLAY, new ResourceLocation(References.PREFIX + "brown_bricks")),
		ModBlockReference.green_bricks = new BlockBricks(Blocks.BRICK_BLOCK.getBlockState().getBlock(), MapColor.GREEN_STAINED_HARDENED_CLAY, new ResourceLocation(References.PREFIX + "green_bricks")),
		ModBlockReference.red_bricks = new BlockBricks(Blocks.BRICK_BLOCK.getBlockState().getBlock(), MapColor.RED_STAINED_HARDENED_CLAY, new ResourceLocation(References.PREFIX + "red_bricks")),
		ModBlockReference.black_bricks = new BlockBricks(Blocks.BRICK_BLOCK.getBlockState().getBlock(), MapColor.BLACK_STAINED_HARDENED_CLAY, new ResourceLocation(References.PREFIX + "black_bricks")),
		
		ModBlockReference.white_terracotta_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.WHITE), new ResourceLocation(References.PREFIX + "white_terracotta_brick")),
		ModBlockReference.orange_terracotta_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.ORANGE), new ResourceLocation(References.PREFIX + "orange_terracotta_brick")),
		ModBlockReference.magenta_terracotta_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.MAGENTA), new ResourceLocation(References.PREFIX + "magenta_terracotta_brick")),
		ModBlockReference.lightblue_terracotta_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.LIGHT_BLUE), new ResourceLocation(References.PREFIX + "lightblue_terracotta_brick")),
		ModBlockReference.yellow_terracotta_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.YELLOW), new ResourceLocation(References.PREFIX + "yellow_terracotta_brick")),
		ModBlockReference.lime_terracotta_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.LIME), new ResourceLocation(References.PREFIX + "lime_terracotta_brick")),
		ModBlockReference.pink_terracotta_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.PINK), new ResourceLocation(References.PREFIX + "pink_terracotta_brick")),
		ModBlockReference.gray_terracotta_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.GRAY), new ResourceLocation(References.PREFIX + "gray_terracotta_brick")),
		ModBlockReference.silver_terracotta_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.SILVER), new ResourceLocation(References.PREFIX + "silver_terracotta_brick")),
		ModBlockReference.cyan_terracotta_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.CYAN), new ResourceLocation(References.PREFIX + "cyan_terracotta_brick")),
		ModBlockReference.purple_terracotta_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.PURPLE), new ResourceLocation(References.PREFIX + "purple_terracotta_brick")),
		ModBlockReference.blue_terracotta_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.BLUE), new ResourceLocation(References.PREFIX + "blue_terracotta_brick")),
		ModBlockReference.brown_terracotta_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.BROWN), new ResourceLocation(References.PREFIX + "brown_terracotta_brick")),
		ModBlockReference.green_terracotta_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.GREEN), new ResourceLocation(References.PREFIX + "green_terracotta_brick")),
		ModBlockReference.red_terracotta_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.RED), new ResourceLocation(References.PREFIX + "red_terracotta_brick")),
		ModBlockReference.black_terracotta_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.BLACK), new ResourceLocation(References.PREFIX + "black_terracotta_brick")),
	    
		ModBlockReference.white_terracotta_cracked_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.WHITE), new ResourceLocation(References.PREFIX + "white_terracotta_cracked_brick")),
		ModBlockReference.orange_terracotta_cracked_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.ORANGE), new ResourceLocation(References.PREFIX + "orange_terracotta_cracked_brick")),
		ModBlockReference.magenta_terracotta_cracked_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.MAGENTA), new ResourceLocation(References.PREFIX + "magenta_terracotta_cracked_brick")),
		ModBlockReference.lightblue_terracotta_cracked_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.LIGHT_BLUE), new ResourceLocation(References.PREFIX + "lightblue_terracotta_cracked_brick")),
		ModBlockReference.yellow_terracotta_cracked_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.YELLOW), new ResourceLocation(References.PREFIX + "yellow_terracotta_cracked_brick")),
		ModBlockReference.lime_terracotta_cracked_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.LIME), new ResourceLocation(References.PREFIX + "lime_terracotta_cracked_brick")),
		ModBlockReference.pink_terracotta_cracked_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.PINK), new ResourceLocation(References.PREFIX + "pink_terracotta_cracked_brick")),
		ModBlockReference.gray_terracotta_cracked_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.GRAY), new ResourceLocation(References.PREFIX + "gray_terracotta_cracked_brick")),
		ModBlockReference.silver_terracotta_cracked_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.SILVER), new ResourceLocation(References.PREFIX + "silver_terracotta_cracked_brick")),
		ModBlockReference.cyan_terracotta_cracked_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.CYAN), new ResourceLocation(References.PREFIX + "cyan_terracotta_cracked_brick")),
		ModBlockReference.purple_terracotta_cracked_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.PURPLE), new ResourceLocation(References.PREFIX + "purple_terracotta_cracked_brick")),
		ModBlockReference.blue_terracotta_cracked_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.BLUE), new ResourceLocation(References.PREFIX + "blue_terracotta_cracked_brick")),
		ModBlockReference.brown_terracotta_cracked_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.BROWN), new ResourceLocation(References.PREFIX + "brown_terracotta_cracked_brick")),
		ModBlockReference.green_terracotta_cracked_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.GREEN), new ResourceLocation(References.PREFIX + "green_terracotta_cracked_brick")),
		ModBlockReference.red_terracotta_cracked_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.RED), new ResourceLocation(References.PREFIX + "red_terracotta_cracked_brick")),
		ModBlockReference.black_terracotta_cracked_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.BLACK), new ResourceLocation(References.PREFIX + "black_terracotta_cracked_brick")),
	    
		ModBlockReference.white_terracotta_carved_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.WHITE), new ResourceLocation(References.PREFIX + "white_terracotta_carved_brick")),
		ModBlockReference.orange_terracotta_carved_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.ORANGE), new ResourceLocation(References.PREFIX + "orange_terracotta_carved_brick")),
		ModBlockReference.magenta_terracotta_carved_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.MAGENTA), new ResourceLocation(References.PREFIX + "magenta_terracotta_carved_brick")),
		ModBlockReference.lightblue_terracotta_carved_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.LIGHT_BLUE), new ResourceLocation(References.PREFIX + "lightblue_terracotta_carved_brick")),
		ModBlockReference.yellow_terracotta_carved_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.YELLOW), new ResourceLocation(References.PREFIX + "yellow_terracotta_carved_brick")),
		ModBlockReference.lime_terracotta_carved_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.LIME), new ResourceLocation(References.PREFIX + "lime_terracotta_carved_brick")),
		ModBlockReference.pink_terracotta_carved_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.PINK), new ResourceLocation(References.PREFIX + "pink_terracotta_carved_brick")),
		ModBlockReference.gray_terracotta_carved_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.GRAY), new ResourceLocation(References.PREFIX + "gray_terracotta_carved_brick")),
		ModBlockReference.silver_terracotta_carved_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.SILVER), new ResourceLocation(References.PREFIX + "silver_terracotta_carved_brick")),
		ModBlockReference.cyan_terracotta_carved_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.CYAN), new ResourceLocation(References.PREFIX + "cyan_terracotta_carved_brick")),
		ModBlockReference.purple_terracotta_carved_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.PURPLE), new ResourceLocation(References.PREFIX + "purple_terracotta_carved_brick")),
		ModBlockReference.blue_terracotta_carved_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.BLUE), new ResourceLocation(References.PREFIX + "blue_terracotta_carved_brick")),
		ModBlockReference.brown_terracotta_carved_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.BROWN), new ResourceLocation(References.PREFIX + "brown_terracotta_carved_brick")),
		ModBlockReference.green_terracotta_carved_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.GREEN), new ResourceLocation(References.PREFIX + "green_terracotta_carved_brick")),
		ModBlockReference.red_terracotta_carved_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.RED), new ResourceLocation(References.PREFIX + "red_terracotta_carved_brick")),
		ModBlockReference.black_terracotta_carved_brick = new BlockTerracottaBrick(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.BLACK), new ResourceLocation(References.PREFIX + "black_terracotta_carved_brick")),
		
		
	    //Creating stained clay blocks
	    ModBlockReference.white_stained_clay = new BlockStainedClay("white_stained_clayball",  MapColor.WHITE_STAINED_HARDENED_CLAY, new ResourceLocation(References.PREFIX + "white_stained_clay")),
	    ModBlockReference.orange_stained_clay = new BlockStainedClay("orange_stained_clayball",  MapColor.ORANGE_STAINED_HARDENED_CLAY, new ResourceLocation(References.PREFIX + "orange_stained_clay")),
	    ModBlockReference.magenta_stained_clay = new BlockStainedClay("magenta_stained_clayball",  MapColor.MAGENTA_STAINED_HARDENED_CLAY,  new ResourceLocation(References.PREFIX + "magenta_stained_clay")),
	    ModBlockReference.lightblue_stained_clay = new BlockStainedClay("lightblue_stained_clayball",  MapColor.LIGHT_BLUE_STAINED_HARDENED_CLAY,  new ResourceLocation(References.PREFIX + "lightblue_stained_clay")),
	    ModBlockReference.yellow_stained_clay = new BlockStainedClay("yellow_stained_clayball",  MapColor.YELLOW_STAINED_HARDENED_CLAY,  new ResourceLocation(References.PREFIX + "yellow_stained_clay")),
	    ModBlockReference.lime_stained_clay = new BlockStainedClay("lime_stained_clayball",  MapColor.LIME_STAINED_HARDENED_CLAY,  new ResourceLocation(References.PREFIX + "lime_stained_clay")),
	    ModBlockReference.pink_stained_clay = new BlockStainedClay("pink_stained_clayball",  MapColor.PINK_STAINED_HARDENED_CLAY,  new ResourceLocation(References.PREFIX + "pink_stained_clay")),
	    ModBlockReference.gray_stained_clay = new BlockStainedClay("gray_stained_clayball",  MapColor.GRAY_STAINED_HARDENED_CLAY,  new ResourceLocation(References.PREFIX + "gray_stained_clay")),
	    ModBlockReference.silver_stained_clay = new BlockStainedClay("silver_stained_clayball",  MapColor.SILVER_STAINED_HARDENED_CLAY,  new ResourceLocation(References.PREFIX + "silver_stained_clay")),
	    ModBlockReference.cyan_stained_clay = new BlockStainedClay("cyan_stained_clayball",  MapColor.CYAN_STAINED_HARDENED_CLAY,  new ResourceLocation(References.PREFIX + "cyan_stained_clay")),
	    ModBlockReference.purple_stained_clay = new BlockStainedClay("purple_stained_clayball",  MapColor.PURPLE_STAINED_HARDENED_CLAY,  new ResourceLocation(References.PREFIX + "purple_stained_clay")),
	    ModBlockReference.blue_stained_clay = new BlockStainedClay("blue_stained_clayball",  MapColor.BLUE_STAINED_HARDENED_CLAY,  new ResourceLocation(References.PREFIX + "blue_stained_clay")),
	    ModBlockReference.brown_stained_clay = new BlockStainedClay("brown_stained_clayball",  MapColor.BROWN_STAINED_HARDENED_CLAY,  new ResourceLocation(References.PREFIX + "brown_stained_clay")),
	    ModBlockReference.green_stained_clay = new BlockStainedClay("green_stained_clayball",  MapColor.GREEN_STAINED_HARDENED_CLAY,  new ResourceLocation(References.PREFIX + "green_stained_clay")),
	    ModBlockReference.red_stained_clay = new BlockStainedClay("red_stained_clayball",  MapColor.RED_STAINED_HARDENED_CLAY,  new ResourceLocation(References.PREFIX + "red_stained_clay")),
	    ModBlockReference.black_stained_clay = new BlockStainedClay("black_stained_clayball",  MapColor.BLACK_STAINED_HARDENED_CLAY,  new ResourceLocation(References.PREFIX + "black_stained_clay")),
	    
	    
	    
	    ModBlockReference.white_bricks_halfslab =  new BlockWinnetrieSlab.Half(ModBlockReference.white_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "white_bricks_halfslab")),
	    ModBlockReference.orange_bricks_halfslab =  new BlockWinnetrieSlab.Half(ModBlockReference.orange_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "orange_bricks_halfslab")),
	    ModBlockReference.magenta_bricks_halfslab =  new BlockWinnetrieSlab.Half(ModBlockReference.magenta_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "magenta_bricks_halfslab")),
	    ModBlockReference.lightblue_bricks_halfslab =  new BlockWinnetrieSlab.Half(ModBlockReference.lightblue_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "lightblue_bricks_halfslab")),
	    ModBlockReference.yellow_bricks_halfslab =  new BlockWinnetrieSlab.Half(ModBlockReference.yellow_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "yellow_bricks_halfslab")),
	    ModBlockReference.lime_bricks_halfslab =  new BlockWinnetrieSlab.Half(ModBlockReference.lime_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "lime_bricks_halfslab")),
	    ModBlockReference.pink_bricks_halfslab =  new BlockWinnetrieSlab.Half(ModBlockReference.pink_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "pink_bricks_halfslab")),
	    ModBlockReference.gray_bricks_halfslab =  new BlockWinnetrieSlab.Half(ModBlockReference.gray_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "gray_bricks_halfslab")),
	    ModBlockReference.silver_bricks_halfslab =  new BlockWinnetrieSlab.Half(ModBlockReference.silver_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "silver_bricks_halfslab")),
	    ModBlockReference.cyan_bricks_halfslab =  new BlockWinnetrieSlab.Half(ModBlockReference.cyan_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "cyan_bricks_halfslab")),
	    ModBlockReference.purple_bricks_halfslab =  new BlockWinnetrieSlab.Half(ModBlockReference.purple_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "purple_bricks_halfslab")),
	    ModBlockReference.blue_bricks_halfslab =  new BlockWinnetrieSlab.Half(ModBlockReference.blue_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "blue_bricks_halfslab")),
	    ModBlockReference.brown_bricks_halfslab =  new BlockWinnetrieSlab.Half(ModBlockReference.brown_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "brown_bricks_halfslab")),
	    ModBlockReference.green_bricks_halfslab =  new BlockWinnetrieSlab.Half(ModBlockReference.green_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "green_bricks_halfslab")),
	    ModBlockReference.red_bricks_halfslab =  new BlockWinnetrieSlab.Half(ModBlockReference.red_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "red_bricks_halfslab")),
	    ModBlockReference.black_bricks_halfslab =  new BlockWinnetrieSlab.Half(ModBlockReference.black_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "black_bricks_halfslab")),
	    																												
	    ModBlockReference.white_bricks_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.white_bricks.getBlockState().getBaseState(), ModBlockReference.white_bricks_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "white_bricks_doubleslab" )),
	    ModBlockReference.orange_bricks_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.orange_bricks.getBlockState().getBaseState(), ModBlockReference.orange_bricks_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "orange_bricks_doubleslab" )),
	    ModBlockReference.magenta_bricks_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.magenta_bricks.getBlockState().getBaseState(), ModBlockReference.magenta_bricks_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "magenta_bricks_doubleslab" )),
	    ModBlockReference.lightblue_bricks_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.lightblue_bricks.getBlockState().getBaseState(), ModBlockReference.lightblue_bricks_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "lightblue_bricks_doubleslab" )),
	    ModBlockReference.yellow_bricks_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.yellow_bricks.getBlockState().getBaseState(), ModBlockReference.yellow_bricks_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "yellow_bricks_doubleslab" )),
	    ModBlockReference.lime_bricks_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.lime_bricks.getBlockState().getBaseState(), ModBlockReference.lime_bricks_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "lime_bricks_doubleslab" )),
	    ModBlockReference.pink_bricks_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.pink_bricks.getBlockState().getBaseState(), ModBlockReference.pink_bricks_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "pink_bricks_doubleslab" )),
	    ModBlockReference.gray_bricks_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.gray_bricks.getBlockState().getBaseState(), ModBlockReference.gray_bricks_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "gray_bricks_doubleslab" )),
	    ModBlockReference.silver_bricks_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.silver_bricks.getBlockState().getBaseState(), ModBlockReference.silver_bricks_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "silver_bricks_doubleslab" )),
	    ModBlockReference.cyan_bricks_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.cyan_bricks.getBlockState().getBaseState(), ModBlockReference.cyan_bricks_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "cyan_bricks_doubleslab" )),
	    ModBlockReference.purple_bricks_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.purple_bricks.getBlockState().getBaseState(), ModBlockReference.purple_bricks_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "purple_bricks_doubleslab" )),
	    ModBlockReference.blue_bricks_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.blue_bricks.getBlockState().getBaseState(), ModBlockReference.blue_bricks_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "blue_bricks_doubleslab" )),
	    ModBlockReference.brown_bricks_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.brown_bricks.getBlockState().getBaseState(), ModBlockReference.brown_bricks_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "brown_bricks_doubleslab" )),
	    ModBlockReference.green_bricks_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.green_bricks.getBlockState().getBaseState(), ModBlockReference.green_bricks_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "green_bricks_doubleslab" )),
	    ModBlockReference.red_bricks_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.red_bricks.getBlockState().getBaseState(), ModBlockReference.red_bricks_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "red_bricks_doubleslab" )),
	    ModBlockReference.black_bricks_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.black_bricks.getBlockState().getBaseState(), ModBlockReference.black_bricks_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "black_bricks_doubleslab" )),
	    
	   	ModBlockReference.white_terracotta_brick_halfslab =  new BlockWinnetrieSlab.Half(ModBlockReference.white_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "white_terracotta_brick_halfslab")),
	    ModBlockReference.orange_terracotta_brick_halfslab =  new BlockWinnetrieSlab.Half(ModBlockReference.orange_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "orange_terracotta_brick_halfslab")),
	   	ModBlockReference.magenta_terracotta_brick_halfslab =  new BlockWinnetrieSlab.Half(ModBlockReference.magenta_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "magenta_terracotta_brick_halfslab")),
	    ModBlockReference.lightblue_terracotta_brick_halfslab =  new BlockWinnetrieSlab.Half(ModBlockReference.lightblue_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "lightblue_terracotta_brick_halfslab")),
	    ModBlockReference.yellow_terracotta_brick_halfslab =  new BlockWinnetrieSlab.Half(ModBlockReference.yellow_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "yellow_terracotta_brick_halfslab")),
	    ModBlockReference.lime_terracotta_brick_halfslab =  new BlockWinnetrieSlab.Half(ModBlockReference.lime_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "lime_terracotta_brick_halfslab")),
	    ModBlockReference.pink_terracotta_brick_halfslab =  new BlockWinnetrieSlab.Half(ModBlockReference.pink_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "pink_terracotta_brick_halfslab")),
	    ModBlockReference.gray_terracotta_brick_halfslab =  new BlockWinnetrieSlab.Half(ModBlockReference.gray_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "gray_terracotta_brick_halfslab")),
	    ModBlockReference.silver_terracotta_brick_halfslab =  new BlockWinnetrieSlab.Half(ModBlockReference.silver_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "silver_terracotta_brick_halfslab")),
	    ModBlockReference.cyan_terracotta_brick_halfslab =  new BlockWinnetrieSlab.Half(ModBlockReference.cyan_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "cyan_terracotta_brick_halfslab")),
	    ModBlockReference.purple_terracotta_brick_halfslab =  new BlockWinnetrieSlab.Half(ModBlockReference.purple_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "purple_terracotta_brick_halfslab")),
	    ModBlockReference.blue_terracotta_brick_halfslab =  new BlockWinnetrieSlab.Half(ModBlockReference.blue_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "blue_terracotta_brick_halfslab")),
	    ModBlockReference.brown_terracotta_brick_halfslab =  new BlockWinnetrieSlab.Half(ModBlockReference.brown_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "brown_terracotta_brick_halfslab")),
	    ModBlockReference.green_terracotta_brick_halfslab =  new BlockWinnetrieSlab.Half(ModBlockReference.green_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "green_terracotta_brick_halfslab")),
	    ModBlockReference.red_terracotta_brick_halfslab =  new BlockWinnetrieSlab.Half(ModBlockReference.red_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "red_terracotta_brick_halfslab")),
	    ModBlockReference.black_terracotta_brick_halfslab =  new BlockWinnetrieSlab.Half(ModBlockReference.black_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "black_terracotta_brick_halfslab")),
	    	    																												
	    ModBlockReference.white_terracotta_brick_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.white_terracotta_brick.getBlockState().getBaseState(), ModBlockReference.white_terracotta_brick_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "white_terracotta_brick_doubleslab" )),
	    ModBlockReference.orange_terracotta_brick_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.orange_terracotta_brick.getBlockState().getBaseState(), ModBlockReference.orange_terracotta_brick_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "orange_terracotta_brick_doubleslab" )),
	    ModBlockReference.magenta_terracotta_brick_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.magenta_terracotta_brick.getBlockState().getBaseState(), ModBlockReference.magenta_terracotta_brick_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "magenta_terracotta_brick_doubleslab" )),
	    ModBlockReference.lightblue_terracotta_brick_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.lightblue_terracotta_brick.getBlockState().getBaseState(), ModBlockReference.lightblue_terracotta_brick_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "lightblue_terracotta_brick_doubleslab" )),
	    ModBlockReference.yellow_terracotta_brick_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.yellow_terracotta_brick.getBlockState().getBaseState(), ModBlockReference.yellow_terracotta_brick_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "yellow_terracotta_brick_doubleslab" )),
	    ModBlockReference.lime_terracotta_brick_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.lime_terracotta_brick.getBlockState().getBaseState(), ModBlockReference.lime_terracotta_brick_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "lime_terracotta_brick_doubleslab" )),
	    ModBlockReference.pink_terracotta_brick_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.pink_terracotta_brick.getBlockState().getBaseState(), ModBlockReference.pink_terracotta_brick_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "pink_terracotta_brick_doubleslab" )),
	    ModBlockReference.gray_terracotta_brick_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.gray_terracotta_brick.getBlockState().getBaseState(), ModBlockReference.gray_terracotta_brick_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "gray_terracotta_brick_doubleslab" )),
	    ModBlockReference.silver_terracotta_brick_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.silver_terracotta_brick.getBlockState().getBaseState(), ModBlockReference.silver_terracotta_brick_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "silver_terracotta_brick_doubleslab" )),
	    ModBlockReference.cyan_terracotta_brick_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.cyan_terracotta_brick.getBlockState().getBaseState(), ModBlockReference.cyan_terracotta_brick_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "cyan_terracotta_brick_doubleslab" )),
	    ModBlockReference.purple_terracotta_brick_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.purple_terracotta_brick.getBlockState().getBaseState(), ModBlockReference.purple_terracotta_brick_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "purple_terracotta_brick_doubleslab" )),
	    ModBlockReference.blue_terracotta_brick_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.blue_terracotta_brick.getBlockState().getBaseState(), ModBlockReference.blue_terracotta_brick_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "blue_terracotta_brick_doubleslab" )),
	    ModBlockReference.brown_terracotta_brick_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.brown_terracotta_brick.getBlockState().getBaseState(), ModBlockReference.brown_terracotta_brick_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "brown_terracotta_brick_doubleslab" )),
	    ModBlockReference.green_terracotta_brick_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.green_terracotta_brick.getBlockState().getBaseState(), ModBlockReference.green_terracotta_brick_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "green_terracotta_brick_doubleslab" )),
	    ModBlockReference.red_terracotta_brick_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.red_terracotta_brick.getBlockState().getBaseState(), ModBlockReference.red_terracotta_brick_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "red_terracotta_brick_doubleslab" )),
	    ModBlockReference.black_terracotta_brick_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.black_terracotta_brick.getBlockState().getBaseState(), ModBlockReference.black_terracotta_brick_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "black_terracotta_brick_doubleslab" )),
	    
	    ModBlockReference.white_terracotta_brick_stairs = new BlockWinnetrieStairs(ModBlockReference.white_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "white_terracotta_brick_stairs")),
	    ModBlockReference.orange_terracotta_brick_stairs = new BlockWinnetrieStairs(ModBlockReference.orange_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "orange_terracotta_brick_stairs")),
	    ModBlockReference.magenta_terracotta_brick_stairs = new BlockWinnetrieStairs(ModBlockReference.magenta_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "magenta_terracotta_brick_stairs")),
	    ModBlockReference.lightblue_terracotta_brick_stairs = new BlockWinnetrieStairs(ModBlockReference.lightblue_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "lightblue_terracotta_brick_stairs")),
	    ModBlockReference.yellow_terracotta_brick_stairs = new BlockWinnetrieStairs(ModBlockReference.yellow_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "yellow_terracotta_brick_stairs")),
	    ModBlockReference.lime_terracotta_brick_stairs = new BlockWinnetrieStairs(ModBlockReference.lime_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "lime_terracotta_brick_stairs")),
	    ModBlockReference.pink_terracotta_brick_stairs = new BlockWinnetrieStairs(ModBlockReference.pink_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "pink_terracotta_brick_stairs")),
	    ModBlockReference.gray_terracotta_brick_stairs = new BlockWinnetrieStairs(ModBlockReference.gray_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "gray_terracotta_brick_stairs")),
	    ModBlockReference.silver_terracotta_brick_stairs = new BlockWinnetrieStairs(ModBlockReference.silver_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "silver_terracotta_brick_stairs")),
	    ModBlockReference.cyan_terracotta_brick_stairs = new BlockWinnetrieStairs(ModBlockReference.cyan_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "cyan_terracotta_brick_stairs")),
	    ModBlockReference.purple_terracotta_brick_stairs = new BlockWinnetrieStairs(ModBlockReference.purple_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "purple_terracotta_brick_stairs")),
	    ModBlockReference.blue_terracotta_brick_stairs = new BlockWinnetrieStairs(ModBlockReference.blue_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "blue_terracotta_brick_stairs")),
	    ModBlockReference.brown_terracotta_brick_stairs = new BlockWinnetrieStairs(ModBlockReference.brown_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "brown_terracotta_brick_stairs")),
	    ModBlockReference.green_terracotta_brick_stairs = new BlockWinnetrieStairs(ModBlockReference.green_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "green_terracotta_brick_stairs")),
	    ModBlockReference.red_terracotta_brick_stairs = new BlockWinnetrieStairs(ModBlockReference.red_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "red_terracotta_brick_stairs")),
	    ModBlockReference.black_terracotta_brick_stairs = new BlockWinnetrieStairs(ModBlockReference.black_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "black_terracotta_brick_stairs")),
	    	    
	    ModBlockReference.white_terracotta_brick_wall = new BlockWinnetrieWall(ModBlockReference.white_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "white_terracotta_brick_wall")),
	    ModBlockReference.orange_terracotta_brick_wall = new BlockWinnetrieWall(ModBlockReference.orange_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "orange_terracotta_brick_wall")),
	    ModBlockReference.magenta_terracotta_brick_wall = new BlockWinnetrieWall(ModBlockReference.magenta_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "magenta_terracotta_brick_wall")),
	    ModBlockReference.lightblue_terracotta_brick_wall = new BlockWinnetrieWall(ModBlockReference.lightblue_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "lightblue_terracotta_brick_wall")),
	    ModBlockReference.yellow_terracotta_brick_wall = new BlockWinnetrieWall(ModBlockReference.yellow_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "yellow_terracotta_brick_wall")),
	    ModBlockReference.lime_terracotta_brick_wall = new BlockWinnetrieWall(ModBlockReference.lime_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "lime_terracotta_brick_wall")),
	    ModBlockReference.pink_terracotta_brick_wall = new BlockWinnetrieWall(ModBlockReference.pink_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "pink_terracotta_brick_wall")),
	    ModBlockReference.gray_terracotta_brick_wall = new BlockWinnetrieWall(ModBlockReference.gray_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "gray_terracotta_brick_wall")),
	    ModBlockReference.silver_terracotta_brick_wall = new BlockWinnetrieWall(ModBlockReference.silver_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "silver_terracotta_brick_wall")),
	    ModBlockReference.cyan_terracotta_brick_wall = new BlockWinnetrieWall(ModBlockReference.cyan_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "cyan_terracotta_brick_wall")),
	    ModBlockReference.purple_terracotta_brick_wall = new BlockWinnetrieWall(ModBlockReference.purple_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "purple_terracotta_brick_wall")),
	    ModBlockReference.blue_terracotta_brick_wall = new BlockWinnetrieWall(ModBlockReference.blue_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "blue_terracotta_brick_wall")),
	    ModBlockReference.brown_terracotta_brick_wall = new BlockWinnetrieWall(ModBlockReference.brown_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "brown_terracotta_brick_wall")),
	    ModBlockReference.green_terracotta_brick_wall = new BlockWinnetrieWall(ModBlockReference.green_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "green_terracotta_brick_wall")),
	    ModBlockReference.red_terracotta_brick_wall = new BlockWinnetrieWall(ModBlockReference.red_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "red_terracotta_brick_wall")),
	    ModBlockReference.black_terracotta_brick_wall = new BlockWinnetrieWall(ModBlockReference.black_terracotta_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "black_terracotta_brick_wall")),
	    
	    
	   	ModBlockReference.white_terracotta_cracked_brick_halfslab = new BlockWinnetrieSlab.Half(ModBlockReference.white_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "white_terracotta_cracked_brick_halfslab" )),
	    ModBlockReference.orange_terracotta_cracked_brick_halfslab = new BlockWinnetrieSlab.Half(ModBlockReference.orange_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "orange_terracotta_cracked_brick_halfslab" )),
	    ModBlockReference.magenta_terracotta_cracked_brick_halfslab = new BlockWinnetrieSlab.Half(ModBlockReference.magenta_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "magenta_terracotta_cracked_brick_halfslab" )),
	    ModBlockReference.lightblue_terracotta_cracked_brick_halfslab = new BlockWinnetrieSlab.Half(ModBlockReference.lightblue_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "lightblue_terracotta_cracked_brick_halfslab" )),
	    ModBlockReference.yellow_terracotta_cracked_brick_halfslab = new BlockWinnetrieSlab.Half(ModBlockReference.yellow_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "yellow_terracotta_cracked_brick_halfslab" )),
	    ModBlockReference.lime_terracotta_cracked_brick_halfslab = new BlockWinnetrieSlab.Half(ModBlockReference.lime_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "lime_terracotta_cracked_brick_halfslab" )),
	    ModBlockReference.pink_terracotta_cracked_brick_halfslab = new BlockWinnetrieSlab.Half(ModBlockReference.pink_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "pink_terracotta_cracked_brick_halfslab" )),
	    ModBlockReference.gray_terracotta_cracked_brick_halfslab = new BlockWinnetrieSlab.Half(ModBlockReference.gray_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "gray_terracotta_cracked_brick_halfslab" )),
	    ModBlockReference.silver_terracotta_cracked_brick_halfslab = new BlockWinnetrieSlab.Half(ModBlockReference.silver_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "silver_terracotta_cracked_brick_halfslab" )),
	    ModBlockReference.cyan_terracotta_cracked_brick_halfslab = new BlockWinnetrieSlab.Half(ModBlockReference.cyan_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "cyan_terracotta_cracked_brick_halfslab" )),
	    ModBlockReference.purple_terracotta_cracked_brick_halfslab = new BlockWinnetrieSlab.Half(ModBlockReference.purple_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "purple_terracotta_cracked_brick_halfslab" )),
	    ModBlockReference.blue_terracotta_cracked_brick_halfslab = new BlockWinnetrieSlab.Half(ModBlockReference.blue_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "blue_terracotta_cracked_brick_halfslab" )),
	    ModBlockReference.brown_terracotta_cracked_brick_halfslab = new BlockWinnetrieSlab.Half(ModBlockReference.brown_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "brown_terracotta_cracked_brick_halfslab" )),
	    ModBlockReference.green_terracotta_cracked_brick_halfslab = new BlockWinnetrieSlab.Half(ModBlockReference.green_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "green_terracotta_cracked_brick_halfslab" )),
	    ModBlockReference.red_terracotta_cracked_brick_halfslab = new BlockWinnetrieSlab.Half(ModBlockReference.red_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "red_terracotta_cracked_brick_halfslab" )),
	    ModBlockReference.black_terracotta_cracked_brick_halfslab = new BlockWinnetrieSlab.Half(ModBlockReference.black_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "black_terracotta_cracked_brick_halfslab" )),
	    
	    ModBlockReference.white_terracotta_cracked_brick_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.white_terracotta_cracked_brick.getBlockState().getBaseState(), ModBlockReference.white_terracotta_cracked_brick_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "white_terracotta_cracked_brick_doubleslab" )),
	    ModBlockReference.orange_terracotta_cracked_brick_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.orange_terracotta_cracked_brick.getBlockState().getBaseState(), ModBlockReference.orange_terracotta_cracked_brick_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "orange_terracotta_cracked_brick_doubleslab" )),
	    ModBlockReference.magenta_terracotta_cracked_brick_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.magenta_terracotta_cracked_brick.getBlockState().getBaseState(), ModBlockReference.magenta_terracotta_cracked_brick_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "magenta_terracotta_cracked_brick_doubleslab" )),
	    ModBlockReference.lightblue_terracotta_cracked_brick_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.lightblue_terracotta_cracked_brick.getBlockState().getBaseState(), ModBlockReference.lightblue_terracotta_cracked_brick_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "lightblue_terracotta_cracked_brick_doubleslab" )),
	    ModBlockReference.yellow_terracotta_cracked_brick_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.yellow_terracotta_cracked_brick.getBlockState().getBaseState(), ModBlockReference.yellow_terracotta_cracked_brick_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "yellow_terracotta_cracked_brick_doubleslab" )),
	    ModBlockReference.lime_terracotta_cracked_brick_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.lime_terracotta_cracked_brick.getBlockState().getBaseState(), ModBlockReference.lime_terracotta_cracked_brick_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "lime_terracotta_cracked_brick_doubleslab" )),
	    ModBlockReference.pink_terracotta_cracked_brick_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.pink_terracotta_cracked_brick.getBlockState().getBaseState(), ModBlockReference.pink_terracotta_cracked_brick_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "pink_terracotta_cracked_brick_doubleslab" )),
	    ModBlockReference.gray_terracotta_cracked_brick_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.gray_terracotta_cracked_brick.getBlockState().getBaseState(), ModBlockReference.gray_terracotta_cracked_brick_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "gray_terracotta_cracked_brick_doubleslab" )),
	    ModBlockReference.silver_terracotta_cracked_brick_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.silver_terracotta_cracked_brick.getBlockState().getBaseState(), ModBlockReference.silver_terracotta_cracked_brick_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "silver_terracotta_cracked_brick_doubleslab" )),
	    ModBlockReference.cyan_terracotta_cracked_brick_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.cyan_terracotta_cracked_brick.getBlockState().getBaseState(), ModBlockReference.cyan_terracotta_cracked_brick_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "cyan_terracotta_cracked_brick_doubleslab" )),
	    ModBlockReference.purple_terracotta_cracked_brick_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.purple_terracotta_cracked_brick.getBlockState().getBaseState(), ModBlockReference.purple_terracotta_cracked_brick_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "purple_terracotta_cracked_brick_doubleslab" )),
	    ModBlockReference.blue_terracotta_cracked_brick_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.blue_terracotta_cracked_brick.getBlockState().getBaseState(), ModBlockReference.blue_terracotta_cracked_brick_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "blue_terracotta_cracked_brick_doubleslab" )),
	    ModBlockReference.brown_terracotta_cracked_brick_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.brown_terracotta_cracked_brick.getBlockState().getBaseState(), ModBlockReference.brown_terracotta_cracked_brick_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "brown_terracotta_cracked_brick_doubleslab" )),
	    ModBlockReference.green_terracotta_cracked_brick_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.green_terracotta_cracked_brick.getBlockState().getBaseState(), ModBlockReference.green_terracotta_cracked_brick_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "green_terracotta_cracked_brick_doubleslab" )),
	    ModBlockReference.red_terracotta_cracked_brick_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.red_terracotta_cracked_brick.getBlockState().getBaseState(), ModBlockReference.red_terracotta_cracked_brick_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "red_terracotta_cracked_brick_doubleslab" )),
	    ModBlockReference.black_terracotta_cracked_brick_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.black_terracotta_cracked_brick.getBlockState().getBaseState(), ModBlockReference.black_terracotta_cracked_brick_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "black_terracotta_cracked_brick_doubleslab" )),
	    	    
	    ModBlockReference.white_terracotta_cracked_brick_stairs = new BlockWinnetrieStairs(ModBlockReference.white_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "white_terracotta_cracked_brick_stairs")),
	    ModBlockReference.orange_terracotta_cracked_brick_stairs = new BlockWinnetrieStairs(ModBlockReference.orange_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "orange_terracotta_cracked_brick_stairs")),
	    ModBlockReference.magenta_terracotta_cracked_brick_stairs = new BlockWinnetrieStairs(ModBlockReference.magenta_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "magenta_terracotta_cracked_brick_stairs")),
	    ModBlockReference.lightblue_terracotta_cracked_brick_stairs = new BlockWinnetrieStairs(ModBlockReference.lightblue_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "lightblue_terracotta_cracked_brick_stairs")),
	    ModBlockReference.yellow_terracotta_cracked_brick_stairs = new BlockWinnetrieStairs(ModBlockReference.yellow_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "yellow_terracotta_cracked_brick_stairs")),
	    ModBlockReference.lime_terracotta_cracked_brick_stairs = new BlockWinnetrieStairs(ModBlockReference.lime_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "lime_terracotta_cracked_brick_stairs")),
	    ModBlockReference.pink_terracotta_cracked_brick_stairs = new BlockWinnetrieStairs(ModBlockReference.pink_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "pink_terracotta_cracked_brick_stairs")),
	    ModBlockReference.gray_terracotta_cracked_brick_stairs = new BlockWinnetrieStairs(ModBlockReference.gray_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "gray_terracotta_cracked_brick_stairs")),
	    ModBlockReference.silver_terracotta_cracked_brick_stairs = new BlockWinnetrieStairs(ModBlockReference.silver_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "silver_terracotta_cracked_brick_stairs")),
	    ModBlockReference.cyan_terracotta_cracked_brick_stairs = new BlockWinnetrieStairs(ModBlockReference.cyan_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "cyan_terracotta_cracked_brick_stairs")),
	    ModBlockReference.purple_terracotta_cracked_brick_stairs = new BlockWinnetrieStairs(ModBlockReference.purple_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "purple_terracotta_cracked_brick_stairs")),
	    ModBlockReference.blue_terracotta_cracked_brick_stairs = new BlockWinnetrieStairs(ModBlockReference.blue_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "blue_terracotta_cracked_brick_stairs")),
	    ModBlockReference.brown_terracotta_cracked_brick_stairs = new BlockWinnetrieStairs(ModBlockReference.brown_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "brown_terracotta_cracked_brick_stairs")),
	    ModBlockReference.green_terracotta_cracked_brick_stairs = new BlockWinnetrieStairs(ModBlockReference.green_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "green_terracotta_cracked_brick_stairs")),
	    ModBlockReference.red_terracotta_cracked_brick_stairs = new BlockWinnetrieStairs(ModBlockReference.red_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "red_terracotta_cracked_brick_stairs")),
	    ModBlockReference.black_terracotta_cracked_brick_stairs = new BlockWinnetrieStairs(ModBlockReference.black_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "black_terracotta_cracked_brick_stairs")),
	     	    
	    ModBlockReference.white_terracotta_cracked_brick_wall = new BlockWinnetrieWall(ModBlockReference.white_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "white_terracotta_cracked_brick_wall")),
	    ModBlockReference.orange_terracotta_cracked_brick_wall = new BlockWinnetrieWall(ModBlockReference.orange_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "orange_terracotta_cracked_brick_wall")),
	    ModBlockReference.magenta_terracotta_cracked_brick_wall = new BlockWinnetrieWall(ModBlockReference.magenta_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "magenta_terracotta_cracked_brick_wall")),
	    ModBlockReference.lightblue_terracotta_cracked_brick_wall = new BlockWinnetrieWall(ModBlockReference.lightblue_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "lightblue_terracotta_cracked_brick_wall")),
	    ModBlockReference.yellow_terracotta_cracked_brick_wall = new BlockWinnetrieWall(ModBlockReference.yellow_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "yellow_terracotta_cracked_brick_wall")),
	    ModBlockReference.lime_terracotta_cracked_brick_wall = new BlockWinnetrieWall(ModBlockReference.lime_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "lime_terracotta_cracked_brick_wall")),
	    ModBlockReference.pink_terracotta_cracked_brick_wall = new BlockWinnetrieWall(ModBlockReference.pink_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "pink_terracotta_cracked_brick_wall")),
	    ModBlockReference.gray_terracotta_cracked_brick_wall = new BlockWinnetrieWall(ModBlockReference.gray_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "gray_terracotta_cracked_brick_wall")),
	    ModBlockReference.silver_terracotta_cracked_brick_wall = new BlockWinnetrieWall(ModBlockReference.silver_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "silver_terracotta_cracked_brick_wall")),
	    ModBlockReference.cyan_terracotta_cracked_brick_wall = new BlockWinnetrieWall(ModBlockReference.cyan_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "cyan_terracotta_cracked_brick_wall")),
	    ModBlockReference.purple_terracotta_cracked_brick_wall = new BlockWinnetrieWall(ModBlockReference.purple_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "purple_terracotta_cracked_brick_wall")),
	    ModBlockReference.blue_terracotta_cracked_brick_wall = new BlockWinnetrieWall(ModBlockReference.blue_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "blue_terracotta_cracked_brick_wall")),
	    ModBlockReference.brown_terracotta_cracked_brick_wall = new BlockWinnetrieWall(ModBlockReference.brown_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "brown_terracotta_cracked_brick_wall")),
	    ModBlockReference.green_terracotta_cracked_brick_wall = new BlockWinnetrieWall(ModBlockReference.green_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "green_terracotta_cracked_brick_wall")),
	    ModBlockReference.red_terracotta_cracked_brick_wall = new BlockWinnetrieWall(ModBlockReference.red_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "red_terracotta_cracked_brick_wall")),
	    ModBlockReference.black_terracotta_cracked_brick_wall = new BlockWinnetrieWall(ModBlockReference.black_terracotta_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "black_terracotta_cracked_brick_wall")),
	    
	    
	    ModBlockReference.white_bricks_stairs = new BlockWinnetrieStairs(ModBlockReference.white_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "white_bricks_stairs")),
	    ModBlockReference.orange_bricks_stairs = new BlockWinnetrieStairs(ModBlockReference.orange_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "orange_bricks_stairs")),
	    ModBlockReference.magenta_bricks_stairs = new BlockWinnetrieStairs(ModBlockReference.magenta_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "magenta_bricks_stairs")),
	    ModBlockReference.lightblue_bricks_stairs = new BlockWinnetrieStairs(ModBlockReference.lightblue_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "lightblue_bricks_stairs")),
	    ModBlockReference.yellow_bricks_stairs = new BlockWinnetrieStairs(ModBlockReference.yellow_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "yellow_bricks_stairs")),
	    ModBlockReference.lime_bricks_stairs = new BlockWinnetrieStairs(ModBlockReference.lime_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "lime_bricks_stairs")),
	    ModBlockReference.pink_bricks_stairs = new BlockWinnetrieStairs(ModBlockReference.pink_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "pink_bricks_stairs")),
	    ModBlockReference.gray_bricks_stairs = new BlockWinnetrieStairs(ModBlockReference.gray_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "gray_bricks_stairs")),
	    ModBlockReference.silver_bricks_stairs = new BlockWinnetrieStairs(ModBlockReference.silver_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "silver_bricks_stairs")),
	    ModBlockReference.cyan_bricks_stairs = new BlockWinnetrieStairs(ModBlockReference.cyan_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "cyan_bricks_stairs")),
	    ModBlockReference.purple_bricks_stairs = new BlockWinnetrieStairs(ModBlockReference.purple_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "purple_bricks_stairs")),
	    ModBlockReference.blue_bricks_stairs = new BlockWinnetrieStairs(ModBlockReference.blue_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "blue_bricks_stairs")),
	    ModBlockReference.brown_bricks_stairs = new BlockWinnetrieStairs(ModBlockReference.brown_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "brown_bricks_stairs")),
	    ModBlockReference.green_bricks_stairs = new BlockWinnetrieStairs(ModBlockReference.green_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "green_bricks_stairs")),
	    ModBlockReference.red__bricks_stairs = new BlockWinnetrieStairs(ModBlockReference.red_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "red_bricks_stairs")),
	    ModBlockReference.black_bricks_stairs = new BlockWinnetrieStairs(ModBlockReference.black_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "black_bricks_stairs")),
	    
	    ModBlockReference.white_bricks_wall = new BlockWinnetrieWall(ModBlockReference.white_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "white_bricks_wall")),
	   	ModBlockReference.orange_bricks_wall = new BlockWinnetrieWall(ModBlockReference.orange_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "orange_bricks_wall")),
	   	ModBlockReference.magenta_bricks_wall = new BlockWinnetrieWall(ModBlockReference.magenta_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "magenta_bricks_wall")),
	   	ModBlockReference.lightblue_bricks_wall = new BlockWinnetrieWall(ModBlockReference.lightblue_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "lightblue_bricks_wall")),
	   	ModBlockReference.yellow_bricks_wall = new BlockWinnetrieWall(ModBlockReference.yellow_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "yellow_bricks_wall")),
	   	ModBlockReference.lime_bricks_wall = new BlockWinnetrieWall(ModBlockReference.lime_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "lime_bricks_wall")),
	   	ModBlockReference.pink_bricks_wall = new BlockWinnetrieWall(ModBlockReference.pink_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "pink_bricks_wall")),
	   	ModBlockReference.gray_bricks_wall = new BlockWinnetrieWall(ModBlockReference.gray_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "gray_bricks_wall")),
	   	ModBlockReference.silver_bricks_wall = new BlockWinnetrieWall(ModBlockReference.silver_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "silver_bricks_wall")),
	   	ModBlockReference.cyan_bricks_wall = new BlockWinnetrieWall(ModBlockReference.cyan_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "cyan_bricks_wall")),
	   	ModBlockReference.purple_bricks_wall = new BlockWinnetrieWall(ModBlockReference.purple_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "purple_bricks_wall")),
	   	ModBlockReference.blue_bricks_wall = new BlockWinnetrieWall(ModBlockReference.blue_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "blue_bricks_wall")),
	   	ModBlockReference.brown_bricks_wall = new BlockWinnetrieWall(ModBlockReference.brown_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "brown_bricks_wall")),
	   	ModBlockReference.green_bricks_wall = new BlockWinnetrieWall(ModBlockReference.green_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "green_bricks_wall")),
	   	ModBlockReference.red_bricks_wall = new BlockWinnetrieWall(ModBlockReference.red_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "red_bricks_wall")),
	   	ModBlockReference.black_bricks_wall = new BlockWinnetrieWall(ModBlockReference.black_bricks.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "black_bricks_wall")),
	    
	    
	    ModBlockReference.white_terracotta_halfslab =  new BlockWinnetrieSlab.Half(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.WHITE), new ResourceLocation(References.PREFIX + "white_terracotta_halfslab")),
	    ModBlockReference.orange_terracotta_halfslab =  new BlockWinnetrieSlab.Half(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.ORANGE), new ResourceLocation(References.PREFIX + "orange_terracotta_halfslab")),
	    ModBlockReference.magenta_terracotta_halfslab =  new BlockWinnetrieSlab.Half(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.MAGENTA), new ResourceLocation(References.PREFIX + "magenta_terracotta_halfslab")),
	    ModBlockReference.lightblue_terracotta_halfslab =  new BlockWinnetrieSlab.Half(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.LIGHT_BLUE), new ResourceLocation(References.PREFIX + "lightblue_terracotta_halfslab")),
	    ModBlockReference.yellow_terracotta_halfslab =  new BlockWinnetrieSlab.Half(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.YELLOW), new ResourceLocation(References.PREFIX + "yellow_terracotta_halfslab")),
	    ModBlockReference.lime_terracotta_halfslab =  new BlockWinnetrieSlab.Half(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.LIME), new ResourceLocation(References.PREFIX + "lime_terracotta_halfslab")),
	    ModBlockReference.pink_terracotta_halfslab =  new BlockWinnetrieSlab.Half(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.PINK), new ResourceLocation(References.PREFIX + "pink_terracotta_halfslab")),
	    ModBlockReference.gray_terracotta_halfslab =  new BlockWinnetrieSlab.Half(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.GRAY), new ResourceLocation(References.PREFIX + "gray_terracotta_halfslab")),
	    ModBlockReference.silver_terracotta_halfslab =  new BlockWinnetrieSlab.Half(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.SILVER), new ResourceLocation(References.PREFIX + "silver_terracotta_halfslab")),
	    ModBlockReference.cyan_terracotta_halfslab =  new BlockWinnetrieSlab.Half(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.CYAN), new ResourceLocation(References.PREFIX + "cyan_terracotta_halfslab")),
	    ModBlockReference.purple_terracotta_halfslab =  new BlockWinnetrieSlab.Half(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.PURPLE), new ResourceLocation(References.PREFIX + "purple_terracotta_halfslab")),
	    ModBlockReference.blue_terracotta_halfslab =  new BlockWinnetrieSlab.Half(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.BLUE), new ResourceLocation(References.PREFIX + "blue_terracotta_halfslab")),
	    ModBlockReference.brown_terracotta_halfslab =  new BlockWinnetrieSlab.Half(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.BROWN), new ResourceLocation(References.PREFIX + "brown_terracotta_halfslab")),
	    ModBlockReference.green_terracotta_halfslab =  new BlockWinnetrieSlab.Half(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.GREEN), new ResourceLocation(References.PREFIX + "green_terracotta_halfslab")),
	    ModBlockReference.red_terracotta_halfslab =  new BlockWinnetrieSlab.Half(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.RED), new ResourceLocation(References.PREFIX + "red_terracotta_halfslab")),
	    ModBlockReference.black_terracotta_halfslab =  new BlockWinnetrieSlab.Half(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.BLACK), new ResourceLocation(References.PREFIX + "black_terracotta_halfslab")),
	    																												
	    ModBlockReference.white_terracotta_doubleslab = new BlockWinnetrieSlab.Double(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.WHITE), ModBlockReference.white_terracotta_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "white_terracotta_doubleslab" )),
	    ModBlockReference.orange_terracotta_doubleslab = new BlockWinnetrieSlab.Double(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.ORANGE), ModBlockReference.orange_terracotta_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "orange_terracotta_doubleslab" )),
	    ModBlockReference.magenta_terracotta_doubleslab = new BlockWinnetrieSlab.Double(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.MAGENTA), ModBlockReference.magenta_terracotta_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "magenta_terracotta_doubleslab" )),
	    ModBlockReference.lightblue_terracotta_doubleslab = new BlockWinnetrieSlab.Double(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.LIGHT_BLUE), ModBlockReference.lightblue_terracotta_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "lightblue_terracotta_doubleslab" )),
	    ModBlockReference.yellow_terracotta_doubleslab = new BlockWinnetrieSlab.Double(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.YELLOW), ModBlockReference.yellow_terracotta_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "yellow_terracotta_doubleslab" )),
	    ModBlockReference.lime_terracotta_doubleslab = new BlockWinnetrieSlab.Double(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.LIME), ModBlockReference.lime_terracotta_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "lime_terracotta_doubleslab" )),
	    ModBlockReference.pink_terracotta_doubleslab = new BlockWinnetrieSlab.Double(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.PINK), ModBlockReference.pink_terracotta_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "pink_terracotta_doubleslab" )),
	    ModBlockReference.gray_terracotta_doubleslab = new BlockWinnetrieSlab.Double(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.GRAY), ModBlockReference.gray_terracotta_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "gray_terracotta_doubleslab" )),
	    ModBlockReference.silver_terracotta_doubleslab = new BlockWinnetrieSlab.Double(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.SILVER), ModBlockReference.silver_terracotta_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "silver_terracotta_doubleslab" )),
	    ModBlockReference.cyan_terracotta_doubleslab = new BlockWinnetrieSlab.Double(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.CYAN), ModBlockReference.cyan_terracotta_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "cyan_terracotta_doubleslab" )),
	    ModBlockReference.purple_terracotta_doubleslab = new BlockWinnetrieSlab.Double(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.PURPLE), ModBlockReference.purple_terracotta_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "purple_terracotta_doubleslab" )),
	    ModBlockReference.blue_terracotta_doubleslab = new BlockWinnetrieSlab.Double(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.BLUE), ModBlockReference.blue_terracotta_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "blue_terracotta_doubleslab" )),
	    ModBlockReference.brown_terracotta_doubleslab = new BlockWinnetrieSlab.Double(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.BROWN), ModBlockReference.brown_terracotta_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "brown_terracotta_doubleslab" )),
	    ModBlockReference.green_terracotta_doubleslab = new BlockWinnetrieSlab.Double(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.GREEN), ModBlockReference.green_terracotta_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "green_terracotta_doubleslab" )),
	    ModBlockReference.red_terracotta_doubleslab = new BlockWinnetrieSlab.Double(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.RED), ModBlockReference.red_terracotta_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "red_terracotta_doubleslab" )),
	    ModBlockReference.black_terracotta_doubleslab = new BlockWinnetrieSlab.Double(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.BLACK), ModBlockReference.black_terracotta_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "black_terracotta_doubleslab" )),
	    
	    
	    ModBlockReference.white_terracotta_stairs = new BlockWinnetrieStairs(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.WHITE), new ResourceLocation(References.PREFIX + "white_terracotta_stairs")),
	    ModBlockReference.orange_terracotta_stairs = new BlockWinnetrieStairs(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.ORANGE), new ResourceLocation(References.PREFIX + "orange_terracotta_stairs")),
	    ModBlockReference.magenta_terracotta_stairs = new BlockWinnetrieStairs(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.MAGENTA), new ResourceLocation(References.PREFIX + "magenta_terracotta_stairs")),
	    ModBlockReference.lightblue_terracotta_stairs = new BlockWinnetrieStairs(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.LIGHT_BLUE), new ResourceLocation(References.PREFIX + "lightblue_terracotta_stairs")),
	    ModBlockReference.yellow_terracotta_stairs = new BlockWinnetrieStairs(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.YELLOW), new ResourceLocation(References.PREFIX + "yellow_terracotta_stairs")),
	    ModBlockReference.lime_terracotta_stairs = new BlockWinnetrieStairs(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.LIME), new ResourceLocation(References.PREFIX + "lime_terracotta_stairs")),
	    ModBlockReference.pink_terracotta_stairs = new BlockWinnetrieStairs(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.PINK), new ResourceLocation(References.PREFIX + "pink_terracotta_stairs")),
	    ModBlockReference.gray_terracotta_stairs = new BlockWinnetrieStairs(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.GRAY), new ResourceLocation(References.PREFIX + "gray_terracotta_stairs")),
	    ModBlockReference.silver_terracotta_stairs = new BlockWinnetrieStairs(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.SILVER), new ResourceLocation(References.PREFIX + "silver_terracotta_stairs")),
	    ModBlockReference.cyan_terracotta_stairs = new BlockWinnetrieStairs(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.CYAN), new ResourceLocation(References.PREFIX + "cyan_terracotta_stairs")),
	    ModBlockReference.purple_terracotta_stairs = new BlockWinnetrieStairs(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.PURPLE), new ResourceLocation(References.PREFIX + "purple_terracotta_stairs")),
	    ModBlockReference.blue_terracotta_stairs = new BlockWinnetrieStairs(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.BLUE), new ResourceLocation(References.PREFIX + "blue_terracotta_stairs")),
	    ModBlockReference.brown_terracotta_stairs = new BlockWinnetrieStairs(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.BROWN), new ResourceLocation(References.PREFIX + "brown_terracotta_stairs")),
	    ModBlockReference.green_terracotta_stairs = new BlockWinnetrieStairs(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.GREEN), new ResourceLocation(References.PREFIX + "green_terracotta_stairs")),
	    ModBlockReference.red_terracotta_stairs = new BlockWinnetrieStairs(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.RED), new ResourceLocation(References.PREFIX + "red_terracotta_stairs")),
	    ModBlockReference.black_terracotta_stairs = new BlockWinnetrieStairs(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.BLACK), new ResourceLocation(References.PREFIX + "black_terracotta_stairs")),
	   
	    ModBlockReference.white_terracotta_wall = new BlockWinnetrieWall(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.WHITE), new ResourceLocation(References.PREFIX + "white_terracotta_wall")),
	   	ModBlockReference.orange_terracotta_wall = new BlockWinnetrieWall(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.ORANGE), new ResourceLocation(References.PREFIX + "orange_terracotta_wall")),
	   	ModBlockReference.magenta_terracotta_wall = new BlockWinnetrieWall(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.MAGENTA), new ResourceLocation(References.PREFIX + "magenta_terracotta_wall")),
	   	ModBlockReference.lightblue_terracotta_wall = new BlockWinnetrieWall(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.LIGHT_BLUE), new ResourceLocation(References.PREFIX + "lightblue_terracotta_wall")),
	   	ModBlockReference.yellow_terracotta_wall = new BlockWinnetrieWall(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.YELLOW), new ResourceLocation(References.PREFIX + "yellow_terracotta_wall")),
	   	ModBlockReference.lime_terracotta_wall = new BlockWinnetrieWall(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.LIME), new ResourceLocation(References.PREFIX + "lime_terracotta_wall")),
	   	ModBlockReference.pink_terracotta_wall = new BlockWinnetrieWall(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.PINK), new ResourceLocation(References.PREFIX + "pink_terracotta_wall")),
	   	ModBlockReference.gray_terracotta_wall = new BlockWinnetrieWall(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.GRAY), new ResourceLocation(References.PREFIX + "gray_terracotta_wall")),
	   	ModBlockReference.silver_terracotta_wall = new BlockWinnetrieWall(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.SILVER), new ResourceLocation(References.PREFIX + "silver_terracotta_wall")),
	   	ModBlockReference.cyan_terracotta_wall = new BlockWinnetrieWall(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.CYAN), new ResourceLocation(References.PREFIX + "cyan_terracotta_wall")),
	   	ModBlockReference.purple_terracotta_wall = new BlockWinnetrieWall(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.PURPLE), new ResourceLocation(References.PREFIX + "purple_terracotta_wall")),
	   	ModBlockReference.blue_terracotta_wall = new BlockWinnetrieWall(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.BLUE), new ResourceLocation(References.PREFIX + "blue_terracotta_wall")),
	   	ModBlockReference.brown_terracotta_wall = new BlockWinnetrieWall(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.BROWN), new ResourceLocation(References.PREFIX + "brown_terracotta_wall")),
	   	ModBlockReference.green_terracotta_wall = new BlockWinnetrieWall(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.GREEN), new ResourceLocation(References.PREFIX + "green_terracotta_wall")),
	   	ModBlockReference.red_terracotta_wall = new BlockWinnetrieWall(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.RED), new ResourceLocation(References.PREFIX + "red_terracotta_wall")),
	   	ModBlockReference.black_terracotta_wall = new BlockWinnetrieWall(Blocks.STAINED_HARDENED_CLAY.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.BLACK), new ResourceLocation(References.PREFIX + "black_terracotta_wall")),

	   	ModBlockReference.white_concrete_halfslab =  new BlockWinnetrieSlab.Half(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.WHITE), new ResourceLocation(References.PREFIX + "white_concrete_halfslab")),
	    ModBlockReference.orange_concrete_halfslab =  new BlockWinnetrieSlab.Half(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.ORANGE), new ResourceLocation(References.PREFIX + "orange_concrete_halfslab")),
	   	ModBlockReference.magenta_concrete_halfslab =  new BlockWinnetrieSlab.Half(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.MAGENTA), new ResourceLocation(References.PREFIX + "magenta_concrete_halfslab")),
	   	ModBlockReference.lightblue_concrete_halfslab =  new BlockWinnetrieSlab.Half(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.LIGHT_BLUE), new ResourceLocation(References.PREFIX + "lightblue_concrete_halfslab")),
	   	ModBlockReference.yellow_concrete_halfslab =  new BlockWinnetrieSlab.Half(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.YELLOW), new ResourceLocation(References.PREFIX + "yellow_concrete_halfslab")),
	   	ModBlockReference.lime_concrete_halfslab =  new BlockWinnetrieSlab.Half(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.LIME), new ResourceLocation(References.PREFIX + "lime_concrete_halfslab")),
	   	ModBlockReference.pink_concrete_halfslab =  new BlockWinnetrieSlab.Half(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.PINK), new ResourceLocation(References.PREFIX + "pink_concrete_halfslab")),
	   	ModBlockReference.gray_concrete_halfslab =  new BlockWinnetrieSlab.Half(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.GRAY), new ResourceLocation(References.PREFIX + "gray_concrete_halfslab")),
	   	ModBlockReference.silver_concrete_halfslab =  new BlockWinnetrieSlab.Half(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.SILVER), new ResourceLocation(References.PREFIX + "silver_concrete_halfslab")),
	   	ModBlockReference.cyan_concrete_halfslab =  new BlockWinnetrieSlab.Half(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.CYAN), new ResourceLocation(References.PREFIX + "cyan_concrete_halfslab")),
	   	ModBlockReference.purple_concrete_halfslab =  new BlockWinnetrieSlab.Half(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.PURPLE), new ResourceLocation(References.PREFIX + "purple_concrete_halfslab")),
	   	ModBlockReference.blue_concrete_halfslab =  new BlockWinnetrieSlab.Half(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.BLUE), new ResourceLocation(References.PREFIX + "blue_concrete_halfslab")),
	   	ModBlockReference.brown_concrete_halfslab =  new BlockWinnetrieSlab.Half(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.BROWN), new ResourceLocation(References.PREFIX + "brown_concrete_halfslab")),
	   	ModBlockReference.green_concrete_halfslab =  new BlockWinnetrieSlab.Half(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.GREEN), new ResourceLocation(References.PREFIX + "green_concrete_halfslab")),
	   	ModBlockReference.red_concrete_halfslab =  new BlockWinnetrieSlab.Half(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.RED), new ResourceLocation(References.PREFIX + "red_concrete_halfslab")),
	   	ModBlockReference.black_concrete_halfslab =  new BlockWinnetrieSlab.Half(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.BLACK), new ResourceLocation(References.PREFIX + "black_concrete_halfslab")),

	   	ModBlockReference.white_concrete_doubleslab = new BlockWinnetrieSlab.Double(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.WHITE), ModBlockReference.white_concrete_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "white_concrete_doubleslab" )),
	   	ModBlockReference.orange_concrete_doubleslab = new BlockWinnetrieSlab.Double(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.ORANGE), ModBlockReference.orange_concrete_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "orange_concrete_doubleslab" )),
	   	ModBlockReference.magenta_concrete_doubleslab = new BlockWinnetrieSlab.Double(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.MAGENTA), ModBlockReference.magenta_concrete_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "magenta_concrete_doubleslab" )),
	   	ModBlockReference.lightblue_concrete_doubleslab = new BlockWinnetrieSlab.Double(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.LIGHT_BLUE), ModBlockReference.lightblue_concrete_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "lightblue_concrete_doubleslab" )),
	   	ModBlockReference.yellow_concrete_doubleslab = new BlockWinnetrieSlab.Double(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.YELLOW), ModBlockReference.yellow_concrete_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "yellow_concrete_doubleslab" )),
	   	ModBlockReference.lime_concrete_doubleslab = new BlockWinnetrieSlab.Double(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.LIME), ModBlockReference.lime_concrete_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "lime_concrete_doubleslab" )),
	   	ModBlockReference.pink_concrete_doubleslab = new BlockWinnetrieSlab.Double(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.PINK), ModBlockReference.pink_concrete_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "pink_concrete_doubleslab" )),
	   	ModBlockReference.gray_concrete_doubleslab = new BlockWinnetrieSlab.Double(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.GRAY), ModBlockReference.gray_concrete_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "gray_concrete_doubleslab" )),
	   	ModBlockReference.silver_concrete_doubleslab = new BlockWinnetrieSlab.Double(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.SILVER), ModBlockReference.silver_concrete_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "silver_concrete_doubleslab" )),
	   	ModBlockReference.cyan_concrete_doubleslab = new BlockWinnetrieSlab.Double(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.CYAN), ModBlockReference.cyan_concrete_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "cyan_concrete_doubleslab" )),
	   	ModBlockReference.purple_concrete_doubleslab = new BlockWinnetrieSlab.Double(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.PURPLE), ModBlockReference.purple_concrete_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "purple_concrete_doubleslab" )),
	   	ModBlockReference.blue_concrete_doubleslab = new BlockWinnetrieSlab.Double(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.BLUE), ModBlockReference.blue_concrete_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "blue_concrete_doubleslab" )),
	   	ModBlockReference.brown_concrete_doubleslab = new BlockWinnetrieSlab.Double(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.BROWN), ModBlockReference.brown_concrete_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "brown_concrete_doubleslab" )),
	   	ModBlockReference.green_concrete_doubleslab = new BlockWinnetrieSlab.Double(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.GREEN), ModBlockReference.green_concrete_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "green_concrete_doubleslab" )),
	   	ModBlockReference.red_concrete_doubleslab = new BlockWinnetrieSlab.Double(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.RED), ModBlockReference.red_concrete_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "red_concrete_doubleslab" )),
	   	ModBlockReference.black_concrete_doubleslab = new BlockWinnetrieSlab.Double(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.BLACK), ModBlockReference.black_concrete_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "black_concrete_doubleslab" )),
	   		    
	   		    
	   	ModBlockReference.white_concrete_stairs = new BlockWinnetrieStairs(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.WHITE), new ResourceLocation(References.PREFIX + "white_concrete_stairs")),
	   	ModBlockReference.orange_concrete_stairs = new BlockWinnetrieStairs(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.ORANGE), new ResourceLocation(References.PREFIX + "orange_concrete_stairs")),
	   	ModBlockReference.magenta_concrete_stairs = new BlockWinnetrieStairs(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.MAGENTA), new ResourceLocation(References.PREFIX + "magenta_concrete_stairs")),
	   	ModBlockReference.lightblue_concrete_stairs = new BlockWinnetrieStairs(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.LIGHT_BLUE), new ResourceLocation(References.PREFIX + "lightblue_concrete_stairs")),
	   	ModBlockReference.yellow_concrete_stairs = new BlockWinnetrieStairs(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.YELLOW), new ResourceLocation(References.PREFIX + "yellow_concrete_stairs")),
	   	ModBlockReference.lime_concrete_stairs = new BlockWinnetrieStairs(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.LIME), new ResourceLocation(References.PREFIX + "lime_concrete_stairs")),
	   	ModBlockReference.pink_concrete_stairs = new BlockWinnetrieStairs(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.PINK), new ResourceLocation(References.PREFIX + "pink_concrete_stairs")),
	   	ModBlockReference.gray_concrete_stairs = new BlockWinnetrieStairs(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.GRAY), new ResourceLocation(References.PREFIX + "gray_concrete_stairs")),
	   	ModBlockReference.silver_concrete_stairs = new BlockWinnetrieStairs(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.SILVER), new ResourceLocation(References.PREFIX + "silver_concrete_stairs")),
	   	ModBlockReference.cyan_concrete_stairs = new BlockWinnetrieStairs(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.CYAN), new ResourceLocation(References.PREFIX + "cyan_concrete_stairs")),
	   	ModBlockReference.purple_concrete_stairs = new BlockWinnetrieStairs(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.PURPLE), new ResourceLocation(References.PREFIX + "purple_concrete_stairs")),
	   	ModBlockReference.blue_concrete_stairs = new BlockWinnetrieStairs(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.BLUE), new ResourceLocation(References.PREFIX + "blue_concrete_stairs")),
	   	ModBlockReference.brown_concrete_stairs = new BlockWinnetrieStairs(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.BROWN), new ResourceLocation(References.PREFIX + "brown_concrete_stairs")),
	   	ModBlockReference.green_concrete_stairs = new BlockWinnetrieStairs(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.GREEN), new ResourceLocation(References.PREFIX + "green_concrete_stairs")),
	   	ModBlockReference.red_concrete_stairs = new BlockWinnetrieStairs(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.RED), new ResourceLocation(References.PREFIX + "red_concrete_stairs")),
	   	ModBlockReference.black_concrete_stairs = new BlockWinnetrieStairs(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.BLACK), new ResourceLocation(References.PREFIX + "black_concrete_stairs")),
	   		   
	   	ModBlockReference.white_concrete_wall = new BlockWinnetrieWall(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.WHITE), new ResourceLocation(References.PREFIX + "white_concrete_wall")),
	   	ModBlockReference.orange_concrete_wall = new BlockWinnetrieWall(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.ORANGE), new ResourceLocation(References.PREFIX + "orange_concrete_wall")),
	   	ModBlockReference.magenta_concrete_wall = new BlockWinnetrieWall(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.MAGENTA), new ResourceLocation(References.PREFIX + "magenta_concrete_wall")),
	   	ModBlockReference.lightblue_concrete_wall = new BlockWinnetrieWall(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.LIGHT_BLUE), new ResourceLocation(References.PREFIX + "lightblue_concrete_wall")),
	   	ModBlockReference.yellow_concrete_wall = new BlockWinnetrieWall(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.YELLOW), new ResourceLocation(References.PREFIX + "yellow_concrete_wall")),
	   	ModBlockReference.lime_concrete_wall = new BlockWinnetrieWall(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.LIME), new ResourceLocation(References.PREFIX + "lime_concrete_wall")),
	   	ModBlockReference.pink_concrete_wall = new BlockWinnetrieWall(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.PINK), new ResourceLocation(References.PREFIX + "pink_concrete_wall")),
	   	ModBlockReference.gray_concrete_wall = new BlockWinnetrieWall(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.GRAY), new ResourceLocation(References.PREFIX + "gray_concrete_wall")),
	   	ModBlockReference.silver_concrete_wall = new BlockWinnetrieWall(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.SILVER), new ResourceLocation(References.PREFIX + "silver_concrete_wall")),
	   	ModBlockReference.cyan_concrete_wall = new BlockWinnetrieWall(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.CYAN), new ResourceLocation(References.PREFIX + "cyan_concrete_wall")),
	   	ModBlockReference.purple_concrete_wall = new BlockWinnetrieWall(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.PURPLE), new ResourceLocation(References.PREFIX + "purple_concrete_wall")),
	   	ModBlockReference.blue_concrete_wall = new BlockWinnetrieWall(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.BLUE), new ResourceLocation(References.PREFIX + "blue_concrete_wall")),
	   	ModBlockReference.brown_concrete_wall = new BlockWinnetrieWall(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.BROWN), new ResourceLocation(References.PREFIX + "brown_concrete_wall")),
	   	ModBlockReference.green_concrete_wall = new BlockWinnetrieWall(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.GREEN), new ResourceLocation(References.PREFIX + "green_concrete_wall")),
	   	ModBlockReference.red_concrete_wall = new BlockWinnetrieWall(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.RED), new ResourceLocation(References.PREFIX + "red_concrete_wall")),
	   	ModBlockReference.black_concrete_wall = new BlockWinnetrieWall(Blocks.CONCRETE.getBlockState().getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.BLACK), new ResourceLocation(References.PREFIX + "black_concrete_wall")),
	   	
	   	ModBlockReference.limestone = new BlockLimestone(new ResourceLocation(References.PREFIX + "limestone")),
	   	ModBlockReference.limestone_halfslab = new BlockWinnetrieSlab.Half(ModBlockReference.limestone.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "limestone_halfslab")),
	   	ModBlockReference.limestone_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.limestone.getBlockState().getBaseState(), ModBlockReference.limestone_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "limestone_doubleslab")),	
	   	ModBlockReference.limestone_cobble = new BlockLimestoneCobble(new ResourceLocation(References.PREFIX + "limestone_cobble")),
	    ModBlockReference.limestone_cobble_halfslab = new BlockWinnetrieSlab.Half(ModBlockReference.limestone_cobble.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "limestone_cobble_halfslab")),
	   	ModBlockReference.limestone_cobble_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.limestone_cobble.getBlockState().getBaseState(), ModBlockReference.limestone_cobble_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "limestone_cobble_doubleslab")),
	   	ModBlockReference.limestone_cobble_stairs = new BlockWinnetrieStairs(ModBlockReference.limestone_cobble.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "limestone_cobble_stairs")),
	   	ModBlockReference.limestone_cobble_wall = new BlockWinnetrieWall(ModBlockReference.limestone_cobble.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "limestone_cobble_wall")),
	   	ModBlockReference.limestone_mossy_cobble = new BlockLimestoneCobble(new ResourceLocation(References.PREFIX + "limestone_mossy_cobble")),
	   	ModBlockReference.limestone_mossy_cobble_wall = new BlockWinnetrieWall(ModBlockReference.limestone_mossy_cobble.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "limestone_mossy_cobble_wall")),
	   	ModBlockReference.limestone_brick = new BlockLimestone(new ResourceLocation(References.PREFIX + "limestone_brick")),
	    ModBlockReference.limestone_brick_halfslab = new BlockWinnetrieSlab.Half(ModBlockReference.limestone_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "limestone_brick_halfslab")),
	   	ModBlockReference.limestone_brick_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.limestone_brick.getBlockState().getBaseState(), ModBlockReference.limestone_brick_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "limestone_brick_doubleslab")),
	   	ModBlockReference.limestone_brick_stairs = new BlockWinnetrieStairs(ModBlockReference.limestone_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "limestone_brick_stairs")),
	   	ModBlockReference.limestone_brick_wall = new BlockWinnetrieWall(ModBlockReference.limestone_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "limestone_brick_wall")),
	   	ModBlockReference.limestone_mossy_brick = new BlockLimestone(new ResourceLocation(References.PREFIX + "limestone_mossy_brick")),
	   	ModBlockReference.limestone_cracked_brick = new BlockLimestone(new ResourceLocation(References.PREFIX + "limestone_cracked_brick")),
	   	ModBlockReference.limestone_cracked_brick_halfslab = new BlockWinnetrieSlab.Half(ModBlockReference.limestone_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "limestone_cracked_brick_halfslab")),
	   	ModBlockReference.limestone_cracked_brick_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.limestone_cracked_brick.getBlockState().getBaseState(), ModBlockReference.limestone_cracked_brick_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "limestone_cracked_brick_doubleslab")),
	   	ModBlockReference.limestone_cracked_brick_stairs = new BlockWinnetrieStairs(ModBlockReference.limestone_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "limestone_cracked_brick_stairs")),
	   	ModBlockReference.limestone_cracked_brick_wall = new BlockWinnetrieWall(ModBlockReference.limestone_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "limestone_cracked_brick_wall")),	    
	   	ModBlockReference.limestone_carved_brick = new BlockLimestone(new ResourceLocation(References.PREFIX + "limestone_carved_brick")),
	   	
	   	ModBlockReference.marblestone = new BlockMarblestone(new ResourceLocation(References.PREFIX + "marblestone")),
	   	ModBlockReference.marblestone_halfslab = new BlockWinnetrieSlab.Half(ModBlockReference.marblestone.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "marblestone_halfslab")),
	   	ModBlockReference.marblestone_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.marblestone.getBlockState().getBaseState(), ModBlockReference.marblestone_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "marblestone_doubleslab")),	
	   	ModBlockReference.marblestone_cobble = new BlockMarblestoneCobble(new ResourceLocation(References.PREFIX + "marblestone_cobble")),
	    ModBlockReference.marblestone_cobble_halfslab = new BlockWinnetrieSlab.Half(ModBlockReference.marblestone_cobble.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "marblestone_cobble_halfslab")),
	   	ModBlockReference.marblestone_cobble_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.marblestone_cobble.getBlockState().getBaseState(), ModBlockReference.marblestone_cobble_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "marblestone_cobble_doubleslab")),
	   	ModBlockReference.marblestone_cobble_stairs = new BlockWinnetrieStairs(ModBlockReference.marblestone_cobble.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "marblestone_cobble_stairs")),
	   	ModBlockReference.marblestone_cobble_wall = new BlockWinnetrieWall(ModBlockReference.marblestone_cobble.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "marblestone_cobble_wall")),
	   	ModBlockReference.marblestone_mossy_cobble = new BlockMarblestoneCobble(new ResourceLocation(References.PREFIX + "marblestone_mossy_cobble")),
	   	ModBlockReference.marblestone_mossy_cobble_wall = new BlockWinnetrieWall(ModBlockReference.marblestone_mossy_cobble.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "marblestone_mossy_cobble_wall")),
	   	ModBlockReference.marblestone_brick = new BlockMarblestone(new ResourceLocation(References.PREFIX + "marblestone_brick")),
	    ModBlockReference.marblestone_brick_halfslab = new BlockWinnetrieSlab.Half(ModBlockReference.marblestone_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "marblestone_brick_halfslab")),
	   	ModBlockReference.marblestone_brick_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.marblestone_brick.getBlockState().getBaseState(), ModBlockReference.marblestone_brick_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "marblestone_brick_doubleslab")),
	   	ModBlockReference.marblestone_brick_stairs = new BlockWinnetrieStairs(ModBlockReference.marblestone_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "marblestone_brick_stairs")),
	   	ModBlockReference.marblestone_brick_wall = new BlockWinnetrieWall(ModBlockReference.marblestone_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "marblestone_brick_wall")),
	   	ModBlockReference.marblestone_mossy_brick = new BlockMarblestone(new ResourceLocation(References.PREFIX + "marblestone_mossy_brick")),
	   	ModBlockReference.marblestone_cracked_brick = new BlockMarblestone(new ResourceLocation(References.PREFIX + "marblestone_cracked_brick")),
	   	ModBlockReference.marblestone_cracked_brick_halfslab = new BlockWinnetrieSlab.Half(ModBlockReference.marblestone_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "marblestone_cracked_brick_halfslab")),
	   	ModBlockReference.marblestone_cracked_brick_doubleslab = new BlockWinnetrieSlab.Double(ModBlockReference.marblestone_cracked_brick.getBlockState().getBaseState(), ModBlockReference.marblestone_cracked_brick_halfslab.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "marblestone_cracked_brick_doubleslab")),
	   	ModBlockReference.marblestone_cracked_brick_stairs = new BlockWinnetrieStairs(ModBlockReference.marblestone_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "marblestone_cracked_brick_stairs")),
	   	ModBlockReference.marblestone_cracked_brick_wall = new BlockWinnetrieWall(ModBlockReference.marblestone_cracked_brick.getBlockState().getBaseState(), new ResourceLocation(References.PREFIX + "marblestone_cracked_brick_wall")),	    
	   	ModBlockReference.marblestone_carved_brick = new BlockMarblestone(new ResourceLocation(References.PREFIX + "marblestone_carved_brick"))
	   	
	   	
	    );	
		if (ModConfig.enable_tin_ore==true) {
			
			event.getRegistry().register(
				ModBlockReference.tin_ore = new BlockOreTin (new ResourceLocation(References.PREFIX + "ore_tin")));
			OreDictionary.registerOre("oreTin", ModBlockReference.tin_ore);
		}
			
		if (ModConfig.enable_fluids==true) {
			
			if (ModFluids.enable_apple_cider==true) {
					
				event.getRegistry().register(ModBlockReference.apple_cider = new FluidSolid("apple_cider", ModFluidReference.apple_cider, Material.WATER));
			}
			if (ModFluids.enable_plum_wine==true) {
					
				event.getRegistry().register(ModBlockReference.plum_wine = new FluidSolid("plum_wine", ModFluidReference.plum_wine, Material.WATER));
			}
			if (ModFluids.enable_chocolate_milk==true) {
					
				event.getRegistry().register(ModBlockReference.chocolate_milk = new FluidSolid("chocolate_milk", ModFluidReference.chocolate_milk, Material.WATER));
			}
			if (ModFluids.enable_apple_juice==true) {
				
				event.getRegistry().register(ModBlockReference.apple_juice = new FluidSolid("apple_juice", ModFluidReference.apple_juice, Material.WATER));
			}
			if (ModFluids.enable_beetroot_juice==true) {
				
				event.getRegistry().register(ModBlockReference.beetroot_juice = new FluidSolid("beetroot_juice", ModFluidReference.beetroot_juice, Material.WATER));
			}
			if (ModFluids.enable_carrot_juice==true) {
				
				event.getRegistry().register(ModBlockReference.carrot_juice = new FluidSolid("carrot_juice", ModFluidReference.carrot_juice, Material.WATER));
			}
			if (ModFluids.enable_cactus_juice==true) {
				
				event.getRegistry().register(ModBlockReference.cactus_juice = new FluidSolid("cactus_juice", ModFluidReference.cactus_juice, Material.WATER));
			}
			if (ModFluids.enable_melon_juice==true) {
				
				event.getRegistry().register(ModBlockReference.melon_juice = new FluidSolid("melon_juice", ModFluidReference.melon_juice, Material.WATER));
			}
			if (ModFluids.enable_pumpkin_juice==true) {
				
				event.getRegistry().register(ModBlockReference.pumpkin_juice = new FluidSolid("pumpkin_juice", ModFluidReference.pumpkin_juice, Material.WATER));
			}
			if (ModFluids.enable_chorusfruit_juice==true) {
				
				event.getRegistry().register(ModBlockReference.chorusfruit_juice = new FluidSolid("chorusfruit_juice", ModFluidReference.chorusfruit_juice, Material.WATER));
			}
			if (ModFluids.enable_lemon_juice==true) {
				
				event.getRegistry().register(ModBlockReference.lemon_juice = new FluidSolid("lemon_juice", ModFluidReference.lemon_juice, Material.WATER));
			}
			if (ModFluids.enable_cherry_juice==true) {
				
				event.getRegistry().register(ModBlockReference.cherry_juice = new FluidSolid("cherry_juice", ModFluidReference.cherry_juice, Material.WATER));
			}
			if (ModFluids.enable_plum_juice==true) {
				
				event.getRegistry().register(ModBlockReference.plum_juice = new FluidSolid("plum_juice", ModFluidReference.plum_juice, Material.WATER));
			}
			if (ModFluids.enable_tropical_juice==true) {
				
				event.getRegistry().register(ModBlockReference.tropical_juice = new FluidSolid("tropical_juice", ModFluidReference.tropical_juice, Material.WATER));
			}
			
			
			if (ModFluids.enable_liquid_tin==true) {
				
				event.getRegistry().register(ModBlockReference.tin_fluid_block = new FluidSolid("tin", ModFluidReference.tin_fluid, Material.LAVA));
			}
			if (ModFluids.enable_liquid_solder==true) {
				
				event.getRegistry().register(ModBlockReference.solder_fluid_block = new FluidSolid("solder", ModFluidReference.solder_fluid, Material.LAVA));
			}
			if (ModFluids.enable_liquid_bronze==true) {
				
				event.getRegistry().register(ModBlockReference.bronze_fluid_block = new FluidSolid("bronze", ModFluidReference.bronze_fluid, Material.LAVA));
			}
			if (ModFluids.enable_liquid_invar==true) {
				
				event.getRegistry().register(ModBlockReference.invar_fluid_block = new FluidSolid("invar", ModFluidReference.invar_fluid, Material.LAVA));
			}
			if (ModFluids.enable_liquid_constantan==true) {
				
				event.getRegistry().register(ModBlockReference.constantan_fluid_block = new FluidSolid("constantan", ModFluidReference.constantan_fluid, Material.LAVA));
			}
			if (ModFluids.enable_liquid_uranium==true) {
					event.getRegistry().register(ModBlockReference.uranium_fluid_block = new FluidSolid("uranium", ModFluidReference.uranium_fluid, Material.LAVA));
			}
		
			
		}
		if (ModConfig.enable_metal_blocks==true) {
			
			if (ModMetalBlocks.enable_tin_block == true) {
				
				event.getRegistry().register(ModBlockReference.tin_block = new BlockTin(new ResourceLocation(References.PREFIX + "block_tin")));
				OreDictionary.registerOre("blockTin", ModBlockReference.tin_block);
			}
			
			if (ModMetalBlocks.enable_solder_block == true) {
				
				event.getRegistry().register(ModBlockReference.solder_block = new BlockSolder(new ResourceLocation(References.PREFIX + "block_solder")));
				OreDictionary.registerOre("blockSolder", ModBlockReference.solder_block);
			}
			
			if (ModMetalBlocks.enable_bronze_block == true) {
				
				event.getRegistry().register(ModBlockReference.bronze_block = new BlockBronze(new ResourceLocation(References.PREFIX + "block_bronze")));
				OreDictionary.registerOre("blockBronze", ModBlockReference.bronze_block);
			}
			
			if (ModMetalBlocks.enable_invar_block == true) {
				
				event.getRegistry().register(ModBlockReference.invar_block = new BlockInvar(new ResourceLocation(References.PREFIX + "block_invar")));
				OreDictionary.registerOre("blockInvar", ModBlockReference.invar_block);
			}
		}		
	}	
}
