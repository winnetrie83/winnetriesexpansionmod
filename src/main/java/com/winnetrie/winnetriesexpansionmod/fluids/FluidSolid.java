package com.winnetrie.winnetriesexpansionmod.fluids;

import javax.annotation.Nonnull;

import com.winnetrie.winnetriesexpansionmod.util.Utilities;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class FluidSolid extends BlockFluidClassic{

	public FluidSolid(String registryname, Fluid fluid, Material material) {
		super(fluid, material);
		
		setUnlocalizedName(registryname);
		setRegistryName(registryname);
		//setCreativeTab(Utilities.WINNETRIESEXPANSIONMOD);
		//this.setQuantaPerBlock(4);
		//setDensity(10000);
		
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		
		return EnumBlockRenderType.MODEL;
	}
	
	
	
}
