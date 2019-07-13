package com.winnetrie.winnetriesexpansionmod.init;

import com.winnetrie.winnetriesexpansionmod.util.ModBlockReference;
import com.winnetrie.winnetriesexpansionmod.util.ModConfig;
import com.winnetrie.winnetriesexpansionmod.util.ModItemReference;
import com.winnetrie.winnetriesexpansionmod.util.References;
import com.winnetrie.winnetriesexpansionmod.util.Utilities;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
	
	public static void init() {//////VERANDEREN + ADDEN
		
		GameRegistry.addSmelting(Utilities.getItem(References.PREFIX, "white_stained_clayball"), new ItemStack(ModItemReference.white_brick, 1), 0.3F);
		GameRegistry.addSmelting(Utilities.getItem(References.PREFIX, "orange_stained_clayball"), new ItemStack(ModItemReference.orange_brick, 1), 0.3F);
		GameRegistry.addSmelting(Utilities.getItem(References.PREFIX, "magenta_stained_clayball"), new ItemStack(ModItemReference.magenta_brick, 1), 0.3F);
		GameRegistry.addSmelting(Utilities.getItem(References.PREFIX, "lightblue_stained_clayball"), new ItemStack(ModItemReference.lightblue_brick, 1), 0.3F);
		GameRegistry.addSmelting(Utilities.getItem(References.PREFIX, "yellow_stained_clayball"), new ItemStack(ModItemReference.yellow_brick, 1), 0.3F);
		GameRegistry.addSmelting(Utilities.getItem(References.PREFIX, "lime_stained_clayball"), new ItemStack(ModItemReference.lime_brick, 1), 0.3F);
		GameRegistry.addSmelting(Utilities.getItem(References.PREFIX, "pink_stained_clayball"), new ItemStack(ModItemReference.pink_brick, 1), 0.3F);
		GameRegistry.addSmelting(Utilities.getItem(References.PREFIX, "gray_stained_clayball"), new ItemStack(ModItemReference.gray_brick, 1), 0.3F);
		GameRegistry.addSmelting(Utilities.getItem(References.PREFIX, "silver_stained_clayball"), new ItemStack(ModItemReference.silver_brick, 1), 0.3F);
		GameRegistry.addSmelting(Utilities.getItem(References.PREFIX, "cyan_stained_clayball"), new ItemStack(ModItemReference.cyan_brick, 1), 0.3F);
		GameRegistry.addSmelting(Utilities.getItem(References.PREFIX, "purple_stained_clayball"), new ItemStack(ModItemReference.purple_brick, 1), 0.3F);
		GameRegistry.addSmelting(Utilities.getItem(References.PREFIX, "blue_stained_clayball"), new ItemStack(ModItemReference.blue_brick, 1), 0.3F);
		GameRegistry.addSmelting(Utilities.getItem(References.PREFIX, "brown_stained_clayball"), new ItemStack(ModItemReference.brown_brick, 1), 0.3F);
		GameRegistry.addSmelting(Utilities.getItem(References.PREFIX, "green_stained_clayball"), new ItemStack(ModItemReference.green_brick, 1), 0.3F);
		GameRegistry.addSmelting(Utilities.getItem(References.PREFIX, "red_stained_clayball"), new ItemStack(ModItemReference.red_brick, 1), 0.3F);
		GameRegistry.addSmelting(Utilities.getItem(References.PREFIX, "black_stained_clayball"), new ItemStack(ModItemReference.black_brick, 1), 0.3F);
		
		
		GameRegistry.addSmelting(Utilities.getBlock(References.PREFIX, "white_stained_clay"), new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, 0), 0.35F);
		GameRegistry.addSmelting(Utilities.getBlock(References.PREFIX, "orange_stained_clay"), new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, 1), 0.35F);
		GameRegistry.addSmelting(Utilities.getBlock(References.PREFIX, "magenta_stained_clay"), new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, 2), 0.35F);
		GameRegistry.addSmelting(Utilities.getBlock(References.PREFIX, "lightblue_stained_clay"), new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, 3), 0.35F);
		GameRegistry.addSmelting(Utilities.getBlock(References.PREFIX, "yellow_stained_clay"), new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, 4), 0.35F);
		GameRegistry.addSmelting(Utilities.getBlock(References.PREFIX, "lime_stained_clay"), new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, 5), 0.35F);
		GameRegistry.addSmelting(Utilities.getBlock(References.PREFIX, "pink_stained_clay"), new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, 6), 0.35F);
		GameRegistry.addSmelting(Utilities.getBlock(References.PREFIX, "gray_stained_clay"), new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, 7), 0.35F);
		GameRegistry.addSmelting(Utilities.getBlock(References.PREFIX, "silver_stained_clay"), new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, 8), 0.35F);
		GameRegistry.addSmelting(Utilities.getBlock(References.PREFIX, "cyan_stained_clay"), new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, 9), 0.35F);
		GameRegistry.addSmelting(Utilities.getBlock(References.PREFIX, "purple_stained_clay"), new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, 10), 0.35F);
		GameRegistry.addSmelting(Utilities.getBlock(References.PREFIX, "blue_stained_clay"), new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, 11), 0.35F);
		GameRegistry.addSmelting(Utilities.getBlock(References.PREFIX, "brown_stained_clay"), new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, 12), 0.35F);
		GameRegistry.addSmelting(Utilities.getBlock(References.PREFIX, "green_stained_clay"), new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, 13), 0.35F);
		GameRegistry.addSmelting(Utilities.getBlock(References.PREFIX, "red_stained_clay"), new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, 14), 0.35F);
		GameRegistry.addSmelting(Utilities.getBlock(References.PREFIX, "black_stained_clay"), new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, 15), 0.35F);
		
		GameRegistry.addSmelting(new ItemStack(ModBlockReference.white_terracotta_brick), new ItemStack(ModBlockReference.white_terracotta_cracked_brick, 1), 0.1F);
		GameRegistry.addSmelting(new ItemStack(ModBlockReference.orange_terracotta_brick), new ItemStack(ModBlockReference.orange_terracotta_cracked_brick, 1), 0.1F);
		GameRegistry.addSmelting(new ItemStack(ModBlockReference.magenta_terracotta_brick), new ItemStack(ModBlockReference.magenta_terracotta_cracked_brick, 1), 0.1F);
		GameRegistry.addSmelting(new ItemStack(ModBlockReference.lightblue_terracotta_brick), new ItemStack(ModBlockReference.lightblue_terracotta_cracked_brick, 1), 0.1F);
		GameRegistry.addSmelting(new ItemStack(ModBlockReference.yellow_terracotta_brick), new ItemStack(ModBlockReference.yellow_terracotta_cracked_brick, 1), 0.1F);
		GameRegistry.addSmelting(new ItemStack(ModBlockReference.lime_terracotta_brick), new ItemStack(ModBlockReference.lime_terracotta_cracked_brick, 1), 0.1F);
		GameRegistry.addSmelting(new ItemStack(ModBlockReference.pink_terracotta_brick), new ItemStack(ModBlockReference.pink_terracotta_cracked_brick, 1), 0.1F);
		GameRegistry.addSmelting(new ItemStack(ModBlockReference.gray_terracotta_brick), new ItemStack(ModBlockReference.gray_terracotta_cracked_brick, 1), 0.1F);
		GameRegistry.addSmelting(new ItemStack(ModBlockReference.silver_terracotta_brick), new ItemStack(ModBlockReference.silver_terracotta_cracked_brick, 1), 0.1F);
		GameRegistry.addSmelting(new ItemStack(ModBlockReference.cyan_terracotta_brick), new ItemStack(ModBlockReference.cyan_terracotta_cracked_brick, 1), 0.1F);
		GameRegistry.addSmelting(new ItemStack(ModBlockReference.purple_terracotta_brick), new ItemStack(ModBlockReference.purple_terracotta_cracked_brick, 1), 0.1F);
		GameRegistry.addSmelting(new ItemStack(ModBlockReference.blue_terracotta_brick), new ItemStack(ModBlockReference.blue_terracotta_cracked_brick, 1), 0.1F);
		GameRegistry.addSmelting(new ItemStack(ModBlockReference.brown_terracotta_brick), new ItemStack(ModBlockReference.brown_terracotta_cracked_brick, 1), 0.1F);
		GameRegistry.addSmelting(new ItemStack(ModBlockReference.green_terracotta_brick), new ItemStack(ModBlockReference.green_terracotta_cracked_brick, 1), 0.1F);
		GameRegistry.addSmelting(new ItemStack(ModBlockReference.red_terracotta_brick), new ItemStack(ModBlockReference.red_terracotta_cracked_brick, 1), 0.1F);
		GameRegistry.addSmelting(new ItemStack(ModBlockReference.black_terracotta_brick), new ItemStack(ModBlockReference.black_terracotta_cracked_brick, 1), 0.1F);
		
		GameRegistry.addSmelting(new ItemStack(ModBlockReference.limestone_cobble), new ItemStack(ModBlockReference.limestone), 0.1F);
		GameRegistry.addSmelting(new ItemStack(ModBlockReference.limestone_brick), new ItemStack(ModBlockReference.limestone_cracked_brick), 0.1F);
		
		GameRegistry.addSmelting(new ItemStack(ModBlockReference.marblestone_cobble), new ItemStack(ModBlockReference.marblestone), 0.1F);
		GameRegistry.addSmelting(new ItemStack(ModBlockReference.marblestone_brick), new ItemStack(ModBlockReference.marblestone_cracked_brick), 0.1F);
		
		if (ModConfig.enable_terracotta_buckets==true)
		GameRegistry.addSmelting(new ItemStack(ModItemReference.clay_bucket), new ItemStack(ModItemReference.terracotta_bucket), 0.2F);
		
		if (ModConfig.enable_flowerpot_uncooked==true)
		GameRegistry.addSmelting(new ItemStack(ModItemReference.flowerpot_uncooked), new ItemStack(Items.FLOWER_POT), 0.2F);
		
		/*
		GameRegistry.addSmelting(new ItemStack(ModBlockReference.demonite_brick), new ItemStack(ModBlockReference.demonite_cracked_brick), 0.1F);
		
		GameRegistry.addSmelting(new ItemStack(ModItemReference.hellsteel_grit,5), new ItemStack(ModItemReference.hellsteel_nugget), 0.1F);
		*/
		
		
		
	}

}
