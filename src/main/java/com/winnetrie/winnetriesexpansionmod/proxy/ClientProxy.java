package com.winnetrie.winnetriesexpansionmod.proxy;

import java.util.ArrayList;
import java.util.List;

import com.winnetrie.winnetriesexpansionmod.blocks.BlockWinnetrieSlab;
import com.winnetrie.winnetriesexpansionmod.init.ModRegistry;
import com.winnetrie.winnetriesexpansionmod.util.ModBlockReference;
import com.winnetrie.winnetriesexpansionmod.util.ModConfig;
import com.winnetrie.winnetriesexpansionmod.util.References;
import com.winnetrie.winnetriesexpansionmod.util.RenderHandler;
import com.winnetrie.winnetriesexpansionmod.util.ModConfig.ModFluids;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

@EventBusSubscriber
public class ClientProxy implements IProxy{
	
	private static final String DEFAULT_VARIANT = "default";
	private static final String NORMAL_VARIANT = "normal";

	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		
		if (ModConfig.enable_fluids==true) {
			
			if (ModFluids.enable_liquid_invar==true)
			RenderHandler.registerCustomMeshesAndStates(new ResourceLocation(References.PREFIX + "invar"), ModBlockReference.invar_fluid_block);
			
			if (ModFluids.enable_liquid_bronze==true)
			RenderHandler.registerCustomMeshesAndStates(new ResourceLocation(References.PREFIX + "bronze"), ModBlockReference.bronze_fluid_block);
			
			if (ModFluids.enable_liquid_tin==true)
			RenderHandler.registerCustomMeshesAndStates(new ResourceLocation(References.PREFIX + "tin"), ModBlockReference.tin_fluid_block);
			
			if (ModFluids.enable_liquid_solder==true)
			RenderHandler.registerCustomMeshesAndStates(new ResourceLocation(References.PREFIX + "solder"), ModBlockReference.solder_fluid_block);
			
			if (ModFluids.enable_liquid_constantan==true)
			RenderHandler.registerCustomMeshesAndStates(new ResourceLocation(References.PREFIX + "constantan"), ModBlockReference.constantan_fluid_block);
			
			if (ModFluids.enable_liquid_uranium==true)
			RenderHandler.registerCustomMeshesAndStates(new ResourceLocation(References.PREFIX + "uranium"), ModBlockReference.uranium_fluid_block);
			
			if (ModFluids.enable_plum_juice==true)
			RenderHandler.registerCustomMeshesAndStates(new ResourceLocation(References.PREFIX + "plum_juice"), ModBlockReference.plum_juice);
			
			if (ModFluids.enable_apple_juice==true)
			RenderHandler.registerCustomMeshesAndStates(new ResourceLocation(References.PREFIX + "apple_juice"), ModBlockReference.apple_juice);
			
			if (ModFluids.enable_beetroot_juice==true)
			RenderHandler.registerCustomMeshesAndStates(new ResourceLocation(References.PREFIX + "beetroot_juice"), ModBlockReference.beetroot_juice);
			
			if (ModFluids.enable_carrot_juice==true)
			RenderHandler.registerCustomMeshesAndStates(new ResourceLocation(References.PREFIX + "carrot_juice"), ModBlockReference.carrot_juice);
			
			if (ModFluids.enable_cactus_juice==true)
			RenderHandler.registerCustomMeshesAndStates(new ResourceLocation(References.PREFIX + "cactus_juice"), ModBlockReference.cactus_juice);
			
			if (ModFluids.enable_melon_juice==true)
			RenderHandler.registerCustomMeshesAndStates(new ResourceLocation(References.PREFIX + "melon_juice"), ModBlockReference.melon_juice);
			
			if (ModFluids.enable_chorusfruit_juice==true)
			RenderHandler.registerCustomMeshesAndStates(new ResourceLocation(References.PREFIX + "chorusfruit_juice"), ModBlockReference.chorusfruit_juice);
			
			if (ModFluids.enable_pumpkin_juice==true)
			RenderHandler.registerCustomMeshesAndStates(new ResourceLocation(References.PREFIX + "pumpkin_juice"), ModBlockReference.pumpkin_juice);
			
			if (ModFluids.enable_lemon_juice==true)
			RenderHandler.registerCustomMeshesAndStates(new ResourceLocation(References.PREFIX + "lemon_juice"), ModBlockReference.lemon_juice);
			
			if (ModFluids.enable_cherry_juice==true)
			RenderHandler.registerCustomMeshesAndStates(new ResourceLocation(References.PREFIX + "cherry_juice"), ModBlockReference.cherry_juice);
			
			if (ModFluids.enable_tropical_juice==true)
			RenderHandler.registerCustomMeshesAndStates(new ResourceLocation(References.PREFIX + "tropical_juice"), ModBlockReference.tropical_juice);
			
			if (ModFluids.enable_chocolate_milk==true)
			RenderHandler.registerCustomMeshesAndStates(new ResourceLocation(References.PREFIX + "chocolate_milk"), ModBlockReference.chocolate_milk);
			
			if (ModFluids.enable_plum_wine==true)
			RenderHandler.registerCustomMeshesAndStates(new ResourceLocation(References.PREFIX + "plum_wine"), ModBlockReference.plum_wine);
			
			if (ModFluids.enable_apple_cider==true)
			RenderHandler.registerCustomMeshesAndStates(new ResourceLocation(References.PREFIX + "apple_cider"), ModBlockReference.apple_cider);
		}
		
		
			for (Item item : ForgeRegistries.ITEMS.getValuesCollection()) {
				if (item.getRegistryName().getResourceDomain().equals(References.MOD_ID)) {
					registerItemModel(item);
				}
			}
		
			for (Block block : ForgeRegistries.BLOCKS.getValuesCollection()) {
				if (block.getRegistryName().getResourceDomain().equals(References.MOD_ID) && !(block instanceof BlockWinnetrieSlab.Double)) {
					registerBlockModel(block);
				}
			}
		
		
	}
	
	@Override
	public void PreInit(FMLPreInitializationEvent event) {
		// TODO Auto-generated method stub
		//RenderHandler.registerCustomMeshesAndStates(new ResourceLocation(References.PREFIX + "molten_invar"), ModBlockReference.molten_invar);
		
	}

	@Override
	public void Init(FMLInitializationEvent event) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void PostInit(FMLPostInitializationEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ServerStarting(FMLServerStartingEvent event) {
		// TODO Auto-generated method stub
		
	}

	public static void registerItemModel(Item item) {
		
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), NORMAL_VARIANT));
		
	}
	
	public static void registerItemSlab(Item item) {
		
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), DEFAULT_VARIANT));
		
	}
    public static void registerBlockModel(Block block) {
		
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), NORMAL_VARIANT));
		
	}

}
