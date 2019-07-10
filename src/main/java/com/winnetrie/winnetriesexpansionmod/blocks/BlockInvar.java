package com.winnetrie.winnetriesexpansionmod.blocks;

import com.winnetrie.winnetriesexpansionmod.util.Utilities;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

public class BlockInvar extends Block{

	public BlockInvar(ResourceLocation registryname) {
		super(Material.IRON, MapColor.IRON);
		setSoundType(SoundType.METAL);
		setHardness(7.0F);
		setResistance(10.0F);
		//setHarvestLevel("pickaxe", 3);
		setUnlocalizedName(registryname.toString());
		setRegistryName(registryname);
		setCreativeTab(Utilities.WINNETRIESEXPANSIONMOD);
	}

}
