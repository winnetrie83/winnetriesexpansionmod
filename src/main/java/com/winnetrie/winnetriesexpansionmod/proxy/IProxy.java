package com.winnetrie.winnetriesexpansionmod.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public interface IProxy {
	
	
	//entities & networking
	void PreInit(FMLPreInitializationEvent event);
	
	//registry events
	void Init(FMLInitializationEvent event);
	
	//inter-mod stuff
	void PostInit(FMLPostInitializationEvent event);
	
	//server commands registering
	void ServerStarting(FMLServerStartingEvent event);
	

}
