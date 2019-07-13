package com.winnetrie.winnetriesexpansionmod.items;

import java.util.List;

import javax.annotation.Nullable;

import com.winnetrie.winnetriesexpansionmod.util.Utilities;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItemPotion extends Item{
	
	public String NBTliquid;
	
	public ModItemPotion(ResourceLocation registryname, String liquid) {
		
		
		
		setUnlocalizedName(registryname.toString());
		setRegistryName(registryname);
		setCreativeTab(Utilities.WINNETRIESEXPANSIONMOD);
		this.setMaxStackSize(1);
		NBTliquid = liquid;
		
	}
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		
		NBTTagCompound nbt = stack.getTagCompound();
		if (nbt == null) {nbt = new NBTTagCompound();}
		nbt.setString("FluidName", NBTliquid);
		nbt.setInteger("Amount", 500);
		stack.setTagCompound(nbt);
	}
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {
        //if (!worldIn.isRemote) entityLiving.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("speed")));//curePotionEffects(stack); // FORGE - move up so stack.shrink does not turn stack into air
        if (entityLiving instanceof EntityPlayerMP)
        {
            EntityPlayerMP entityplayermp = (EntityPlayerMP)entityLiving;
            CriteriaTriggers.CONSUME_ITEM.trigger(entityplayermp, stack);
            entityplayermp.addStat(StatList.getObjectUseStats(this));
        }

        if (entityLiving instanceof EntityPlayer && !((EntityPlayer)entityLiving).capabilities.isCreativeMode)
        {
            stack.shrink(1);
        }

        return stack.isEmpty() ? new ItemStack(Items.GLASS_BOTTLE) : stack;
    }

    /**
     * How long it takes to use or consume an item
     */
	@Override
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 32;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
	@Override
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.DRINK;
    }

    @Override
    public net.minecraftforge.common.capabilities.ICapabilityProvider initCapabilities(ItemStack stack, net.minecraft.nbt.NBTTagCompound nbt) {
        return new net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper(stack);
    }

    /**
     * Called when the equipped item is right clicked.
     */
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        playerIn.setActiveHand(handIn);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
    }

}
