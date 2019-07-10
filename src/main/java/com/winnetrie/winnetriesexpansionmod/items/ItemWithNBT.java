package com.winnetrie.winnetriesexpansionmod.items;

import java.util.List;

import javax.annotation.Nullable;

import com.winnetrie.winnetriesexpansionmod.Wtemod;
import com.winnetrie.winnetriesexpansionmod.proxy.ClientProxy;
import com.winnetrie.winnetriesexpansionmod.util.References;
import com.winnetrie.winnetriesexpansionmod.util.Utilities;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;



public class ItemWithNBT extends Item{
	
	public ItemWithNBT(ResourceLocation registryname) {
		
		setUnlocalizedName(registryname.toString());
		setRegistryName(registryname);
		setCreativeTab(Utilities.WINNETRIESEXPANSIONMOD);
		
		
	}
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		
		tooltip.add("this is a demonic shard");
	}
	
	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int metadata, boolean bool) {
		
		if (itemstack.getTagCompound() == null){
			NBTTagCompound itemTag = new NBTTagCompound();
			itemstack.setTagCompound(itemTag);
			itemTag.setString("somekey", "test");
		}
	}
	
	


}
