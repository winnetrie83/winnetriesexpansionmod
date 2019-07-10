package com.winnetrie.winnetriesexpansionmod.blocks;

import java.util.Random;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.winnetrie.winnetriesexpansionmod.util.References;
import com.winnetrie.winnetriesexpansionmod.util.Utilities;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockSlab.EnumBlockHalf;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BlockWinnetrieSlab extends BlockSlab{
	
	private IBlockState parentBlock;
	
	public static final PropertyEnum<EnumVariant> VARIANT = PropertyEnum.<EnumVariant>create("variant", EnumVariant.class);

	public BlockWinnetrieSlab(IBlockState modelState, ResourceLocation registryname) {
		super(modelState.getMaterial());
		parentBlock = modelState;
		
		setUnlocalizedName(registryname.toString());
		setRegistryName(registryname);
		
		
		IBlockState state = this.blockState.getBaseState().withProperty(VARIANT, EnumVariant.DEFAULT);

		if (!this.isDouble()) {

			state = state.withProperty(BlockSlab.HALF, EnumBlockHalf.BOTTOM);
		}
		setDefaultState(state);
		this.useNeighborBrightness = !this.isDouble();
		setCreativeTab(Utilities.WINNETRIESEXPANSIONMOD);
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
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        
    	return parentBlock.getMapColor(worldIn, pos);
    }
	
	@Override
	public String getUnlocalizedName(int meta) {
		return super.getUnlocalizedName();
	}


	@Override
	public boolean isDouble() {

		return false;
	}
	
	@Override
	public IProperty<?> getVariantProperty() {

		return VARIANT;
	}

	@Override
	public Comparable<?> getTypeForItem(ItemStack stack) {
		return EnumVariant.DEFAULT;
	}
	
	
	@Override
	public int quantityDropped(Random random)
    {
        return this.isDouble() ? 2 : 1;
    }
	
	@Override
	public int damageDropped(IBlockState state) {
		
		return 0;
		
	}
	
	
	public enum EnumVariant implements IStringSerializable {

		DEFAULT();

		@Override
		@Nonnull
		public String getName() {

			return "default";

		}

	}
    
    @Override
    protected BlockStateContainer createBlockState() {

		return this.isDouble() ? new BlockStateContainer(this, new IProperty[]{VARIANT}) : new BlockStateContainer(this, new IProperty[]{HALF, VARIANT});

	}
    
    @Override
	public int getMetaFromState(final IBlockState state) {

		if (this.isDouble()) {

			return 0;

		} else {

			return state.getValue(HALF).ordinal();
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {

		if (!this.isDouble()) {
			
			return this.getDefaultState().withProperty(HALF, BlockSlab.EnumBlockHalf.values()[meta % 2]);

		}

		return this.getDefaultState();

	}
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        IBlockState iblockstate = super.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM);

        if (this.isDouble())
        {
            return iblockstate;
        }
        else
        {
            return facing != EnumFacing.DOWN && (facing == EnumFacing.UP || (double)hitY <= 0.5D) ? iblockstate : iblockstate.withProperty(HALF, BlockSlab.EnumBlockHalf.TOP);
        }
    }
	
	public abstract Item getHalfSlabReference();
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		
		return this.getHalfSlabReference();
		
	}
	

	

	public static class Double extends BlockWinnetrieSlab {
		
		IBlockState slabState;

		public Double(IBlockState modelState, IBlockState slabstate, ResourceLocation registryname) {
			super(modelState, registryname);
			
			slabState = slabstate;
			// TODO Auto-generated constructor stub
		}
		
		@Override
	    public Item getHalfSlabReference()
	    {
	    	return Item.getItemFromBlock(this.slabState.getBlock());
	    }

		@Override
		public boolean isDouble() {

			return true;
		}

	}

	public static class Half extends BlockWinnetrieSlab {
		
		

		public Half(IBlockState modelState, ResourceLocation registryname) {
			super(modelState, registryname);
			// TODO Auto-generated constructor stub
			
		}
		
		@Override
	    public Item getHalfSlabReference()
	    {
	        return Item.getItemFromBlock(this);
	    }

		@Override
		public boolean isDouble() {

			return false;
		}
	}
	

}
