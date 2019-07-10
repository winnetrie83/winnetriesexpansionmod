package com.winnetrie.winnetriesexpansionmod.blocks;

import com.winnetrie.winnetriesexpansionmod.util.Utilities;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

public class BlockMarblestoneCobble extends Block{

	public BlockMarblestoneCobble(ResourceLocation registryname) {
		super(Material.ROCK, MapColor.GREEN_STAINED_HARDENED_CLAY);
		setSoundType(SoundType.STONE);
		setHardness(2.00F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 1);
		setUnlocalizedName(registryname.toString());
		setRegistryName(registryname);
		setCreativeTab(Utilities.WINNETRIESEXPANSIONMOD);
	}

}
