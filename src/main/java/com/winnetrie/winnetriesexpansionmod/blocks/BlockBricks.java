package com.winnetrie.winnetriesexpansionmod.blocks;

import javax.annotation.Nullable;

import com.winnetrie.winnetriesexpansionmod.init.ModRegistry;
import com.winnetrie.winnetriesexpansionmod.util.References;
import com.winnetrie.winnetriesexpansionmod.util.Utilities;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.config.Property;

public class BlockBricks extends Block{
	
	public Block parentBlock;
	public MapColor mapColor;
	
	

	public BlockBricks(Block parentblock, MapColor mapcolor, ResourceLocation registryname) {
		super(parentblock.getBlockState().getBaseState().getMaterial());
		
		parentBlock = parentblock;
		mapColor = mapcolor;
		setResistance(7.0F);
		setUnlocalizedName(registryname.toString());
		setRegistryName(registryname);
		setCreativeTab(Utilities.WINNETRIESEXPANSIONMOD);
		
		
	}
	
	@Override
	public SoundType getSoundType(IBlockState state, World world, BlockPos pos, @Nullable Entity entity){
		
        return parentBlock.getSoundType(state, world, pos, entity);
    }
	
	
	@Override
    public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos)
    {
        return parentBlock.getBlockState().getBaseState().getBlockHardness(worldIn, pos);
    }
	
	@Override
    public Material getMaterial(IBlockState state)
    {
        return parentBlock.getBlockState().getBaseState().getMaterial();
    }
	@Override
	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		
		return mapColor;
		
	}

}
