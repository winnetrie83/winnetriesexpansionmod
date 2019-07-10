package com.winnetrie.winnetriesexpansionmod.items;

import com.winnetrie.winnetriesexpansionmod.Wtemod;
import com.winnetrie.winnetriesexpansionmod.proxy.ClientProxy;
import com.winnetrie.winnetriesexpansionmod.util.References;
import com.winnetrie.winnetriesexpansionmod.util.Utilities;

import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;



public class ItemBasic extends Item{
	
	public ItemBasic(ResourceLocation registryname) {
		
		setUnlocalizedName(registryname.toString());
		setRegistryName(registryname);
		setCreativeTab(Utilities.WINNETRIESEXPANSIONMOD);
		
		
	}
/*	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		IBlockState block =worldIn.getBlockState(pos);
		float hardnes = block.getBlockHardness(worldIn, pos);
		float resist = block.getBlock().getExplosionResistance(worldIn, pos, null, null);
		float hardnes2 = block.getBlock().getBlockHardness(block, worldIn, pos);
		
		System.out.println("THIS BLOCKSTATE HAS THIS HARDNESS: " + hardnes);
		System.out.println("THIS BLOCK HAS THIS HARDNESS: " + hardnes2);
		System.out.println("THIS BLOCK HAS THIS RESISTANCE: " + resist);
		
		System.out.println("THIS BLOCK HAS THIS MATERIAL: " + block.getBlock().getMaterial(block).toString());
        return EnumActionResult.PASS;
    }
*/

}
