package com.winnetrie.winnetriesexpansionmod;

import java.io.File;

import com.winnetrie.winnetriesexpansionmod.init.FluidInit;
import com.winnetrie.winnetriesexpansionmod.init.ModRecipes;
import com.winnetrie.winnetriesexpansionmod.init.ModRegistry;
import com.winnetrie.winnetriesexpansionmod.proxy.IProxy;
import com.winnetrie.winnetriesexpansionmod.util.ModConfig;
import com.winnetrie.winnetriesexpansionmod.util.References;
import com.winnetrie.winnetriesexpansionmod.world.WinnetrieWorldGenerator;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = References.MOD_ID, name = References.NAME, version = References.VERSION, dependencies=References.DEPENDENCIES)
public class Wtemod {
	
	@Instance
	public static Wtemod instance;
	
	//private static File configDir;
	//public static File getConfigDir() {

      //  return configDir;

    //}
	
	static { FluidRegistry.enableUniversalBucket(); }
	
	@SidedProxy(clientSide = References.CLIENT_PROXY_CLASS, serverSide = References.SERVER_PROXY_CLASS)
	public static IProxy proxy;
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event)
	{
		
		//entities & networking
		
		//configDir = new File(event.getModConfigurationDirectory() + "/" + References.MOD_ID);
        //configDir.mkdirs();
        //ConfigHandler.init(new File(configDir.getPath(), References.MOD_ID + ".cfg"));
        
        if (ModConfig.enable_fluids==true) { FluidInit.registerFluids(); }
       
		
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		//registry events
		ModRecipes.init();
		GameRegistry.registerWorldGenerator(new WinnetrieWorldGenerator(), 10);
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent event)
	{
		//inter-mod stuff
		
		
	}
	@EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
		//server commands registering
    }

	
}
