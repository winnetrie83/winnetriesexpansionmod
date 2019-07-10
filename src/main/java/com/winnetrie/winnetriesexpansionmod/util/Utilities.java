package com.winnetrie.winnetriesexpansionmod.util;

import java.util.Iterator;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class Utilities {
	
	public static Block getBlock(String modprefix, String registryname) { 
		
		return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(modprefix + registryname));
		
	}
    public static Item getItem(String modprefix, String registryname) {
    	
    	return ForgeRegistries.ITEMS.getValue(new ResourceLocation(modprefix + registryname));
	}
    
    
    
    
    
    public static final CreativeTabs WINNETRIESEXPANSIONMOD = new CreativeTabs(References.PREFIX + "creativetab") {

		@Override
		public ItemStack getTabIconItem() {

			return new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(References.PREFIX + "white_terracotta_brick")));
		}
		
		@Override

		public boolean hasSearchBar() {

			return true;

		}

	}.setBackgroundImageName("item_search.png");
	
	//removes furnace recipes
    public static void removeSmelting(ItemStack stack) {
		
		ItemStack result = null;
		Map<ItemStack, ItemStack> recipes = FurnaceRecipes.instance().getSmeltingList();
		Iterator<ItemStack> iterator = recipes.keySet().iterator();
		
		while (iterator.hasNext()) {
			
			ItemStack recipe = iterator.next();
			result = recipes.get(recipe);
			
			if (ItemStack.areItemsEqual(stack, result)){
				
				iterator.remove();
			}
			
		}
		
	}

}
