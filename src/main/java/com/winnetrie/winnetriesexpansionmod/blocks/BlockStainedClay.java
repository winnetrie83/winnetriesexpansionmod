package com.winnetrie.winnetriesexpansionmod.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.winnetrie.winnetriesexpansionmod.init.ModRegistry;
import com.winnetrie.winnetriesexpansionmod.util.References;
import com.winnetrie.winnetriesexpansionmod.util.Utilities;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;



public class BlockStainedClay extends Block{
	
	public String itemdrop;
	public static IBlockState parentBlock = Blocks.CLAY.getBlockState().getBaseState();
	public MapColor mapColor;

	public BlockStainedClay(String itemtodrop, MapColor mapcolor, ResourceLocation registryname) {
		super(Material.CLAY);
		
		
		itemdrop = itemtodrop;
		mapColor = mapcolor;
		//.setHardness(0.2F);
		setUnlocalizedName(registryname.toString());
		setRegistryName(registryname);
		setCreativeTab(Utilities.WINNETRIESEXPANSIONMOD);	
		
	}
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
		
        return Utilities.getItem(References.PREFIX, itemdrop);
    }

    @Override
    public int quantityDropped(Random random)
    {
        return 4;
    }
    
    @Override
	public SoundType getSoundType(IBlockState state, World world, BlockPos pos, @Nullable Entity entity){
		
        return parentBlock.getBlock().getSoundType(state, world, pos, entity);
    }
	
	
	@Override
    public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos)
    {
        return parentBlock.getBlockHardness(worldIn, pos);
    }
	@Override
	public float getExplosionResistance(World world, BlockPos pos, @Nullable Entity exploder, Explosion explosion)
    {
        return parentBlock.getBlock().getExplosionResistance(exploder);
    }
	@Override
	public boolean isToolEffective(String type, IBlockState state)
    {
        if ("shovel".equals(type)) {
        	return true;
        }
        return false;
        
    }
	
	@Override
    public Material getMaterial(IBlockState state)
    {
        return parentBlock.getMaterial();
    }

}
