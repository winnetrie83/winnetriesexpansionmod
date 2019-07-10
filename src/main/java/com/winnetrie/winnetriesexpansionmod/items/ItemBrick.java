package com.winnetrie.winnetriesexpansionmod.items;

import com.winnetrie.winnetriesexpansionmod.Wtemod;
import com.winnetrie.winnetriesexpansionmod.proxy.ClientProxy;
import com.winnetrie.winnetriesexpansionmod.util.References;
import com.winnetrie.winnetriesexpansionmod.util.Utilities;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;



public class ItemBrick extends Item{
	
	public ItemBrick(ResourceLocation registryname) {
		
		setUnlocalizedName(registryname.toString());
		setRegistryName(registryname);
		setCreativeTab(Utilities.WINNETRIESEXPANSIONMOD);
		
		
	}


}
