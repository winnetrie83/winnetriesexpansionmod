package com.winnetrie.winnetriesexpansionmod.fluids;

import com.winnetrie.winnetriesexpansionmod.util.Utilities;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidLiquid extends Fluid{

	public FluidLiquid(String registryname, ResourceLocation still, ResourceLocation flowing) {
		super(registryname, still, flowing);
		
		setUnlocalizedName(registryname);
		setViscosity(5000);
		
		
	}

}
