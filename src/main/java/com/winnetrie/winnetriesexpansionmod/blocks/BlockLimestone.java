package com.winnetrie.winnetriesexpansionmod.blocks;

import java.util.Random;

import com.winnetrie.winnetriesexpansionmod.util.ModBlockReference;
import com.winnetrie.winnetriesexpansionmod.util.Utilities;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class BlockLimestone extends Block{

	public BlockLimestone(ResourceLocation registryname) {
		super(Material.ROCK, MapColor.WHITE_STAINED_HARDENED_CLAY);
		setSoundType(SoundType.STONE);
		setHardness(1.50F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 1);
		setUnlocalizedName(registryname.toString());
		setRegistryName(registryname);
		setCreativeTab(Utilities.WINNETRIESEXPANSIONMOD);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		
		return Item.getItemFromBlock(ModBlockReference.limestone_cobble);
		
	}

}
