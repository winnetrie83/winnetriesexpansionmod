package com.winnetrie.winnetriesexpansionmod.blocks;

import com.winnetrie.winnetriesexpansionmod.util.Utilities;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

public class BlockSolder extends Block{

	public BlockSolder(ResourceLocation registryname) {
		super(Material.IRON, MapColor.IRON);
		setSoundType(SoundType.METAL);
		setHardness(2.0F);
		setResistance(5.0F);
		//setHarvestLevel("pickaxe", 3);
		setUnlocalizedName(registryname.toString());
		setRegistryName(registryname);
		setCreativeTab(Utilities.WINNETRIESEXPANSIONMOD);
	}

}
