package com.winnetrie.winnetriesexpansionmod.util;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class RenderHandler {
	
	public static void registerCustomMeshesAndStates(ResourceLocation registryname, Block blockreference) {
		
		ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(blockreference), new ItemMeshDefinition() {
			
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) {
				
				return new ModelResourceLocation(registryname, "fluid");
			}
		});
		
		ModelLoader.setCustomStateMapper(blockreference, new StateMapperBase() {
			
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				
				return new ModelResourceLocation(registryname, "fluid");
			}
		});
	}

}
