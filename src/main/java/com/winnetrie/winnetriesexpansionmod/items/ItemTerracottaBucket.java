package com.winnetrie.winnetriesexpansionmod.items;

import javax.annotation.Nullable;

import com.winnetrie.winnetriesexpansionmod.util.ModItemReference;
import com.winnetrie.winnetriesexpansionmod.util.Utilities;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ItemTerracottaBucket extends Item{

	/** field for checking if the bucket has been filled. */
    private final Block containedBlock;

    public ItemTerracottaBucket(ResourceLocation registryname, Block containedBlockIn)
    
    {
    	
        this.maxStackSize = 1;
        this.containedBlock = containedBlockIn;
        setUnlocalizedName(registryname.toString());
		setRegistryName(registryname);
		setCreativeTab(Utilities.WINNETRIESEXPANSIONMOD);
    }

    /**
     * Called when the equipped item is right clicked.
     */
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        boolean flag = this.containedBlock == Blocks.AIR;
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        RayTraceResult raytraceresult = this.rayTrace(worldIn, playerIn, flag);
        ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onBucketUse(playerIn, worldIn, itemstack, raytraceresult);
        if (ret != null) return ret;

        if (raytraceresult == null)
        {
            return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack);
        }
        else if (raytraceresult.typeOfHit != RayTraceResult.Type.BLOCK)
        {
            return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack);
        }
        else
        {
            BlockPos blockpos = raytraceresult.getBlockPos();

            if (!worldIn.isBlockModifiable(playerIn, blockpos))
            {
                return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
            }
            else if (flag)
            {
                if (!playerIn.canPlayerEdit(blockpos.offset(raytraceresult.sideHit), raytraceresult.sideHit, itemstack))
                {
                    return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
                }
                else
                {
                    IBlockState iblockstate = worldIn.getBlockState(blockpos);
                    Material material = iblockstate.getMaterial();
                    Block block = iblockstate.getBlock();

                    if (block == Blocks.WATER && ((Integer)iblockstate.getValue(BlockLiquid.LEVEL)).intValue() == 0)
                    {
                        worldIn.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 11);
                        playerIn.addStat(StatList.getObjectUseStats(this));
                        playerIn.playSound(SoundEvents.ITEM_BUCKET_FILL, 1.0F, 1.0F);
                        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, this.fillBucket(itemstack, playerIn, ModItemReference.terracotta_bucket_water));
                    }
                    else if (block == Blocks.LAVA && ((Integer)iblockstate.getValue(BlockLiquid.LEVEL)).intValue() == 0)
                    {
                        playerIn.playSound(SoundEvents.ITEM_BUCKET_FILL_LAVA, 1.0F, 1.0F);
                        worldIn.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 11);
                        playerIn.addStat(StatList.getObjectUseStats(this));
                        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, this.fillBucket(itemstack, playerIn, ModItemReference.terracotta_bucket_lava));
                    }
                    else
                    {
                        return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
                    }
                }
            }
            else
            {
                boolean flag1 = worldIn.getBlockState(blockpos).getBlock().isReplaceable(worldIn, blockpos);
                BlockPos blockpos1 = flag1 && raytraceresult.sideHit == EnumFacing.UP ? blockpos : blockpos.offset(raytraceresult.sideHit);

                if (!playerIn.canPlayerEdit(blockpos1, raytraceresult.sideHit, itemstack))
                {
                    return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
                }
                else if (this.tryPlaceContainedLiquid(playerIn, worldIn, blockpos1))
                {
                    if (playerIn instanceof EntityPlayerMP)
                    {
                        CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, blockpos1, itemstack);
                    }

                    boolean flaglava = this.containedBlock==Blocks.FLOWING_LAVA;
                    if (flaglava) 
                    {
                    	playerIn.addStat(StatList.getObjectUseStats(this));
                    	worldIn.playSound(playerIn, blockpos, SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
                        return !playerIn.capabilities.isCreativeMode ? new ActionResult(EnumActionResult.SUCCESS, new ItemStack(Items.AIR)) : new ActionResult(EnumActionResult.SUCCESS, itemstack);
                    }
                    else
                    {
                    playerIn.addStat(StatList.getObjectUseStats(this));
                    return !playerIn.capabilities.isCreativeMode ? new ActionResult(EnumActionResult.SUCCESS, new ItemStack(ModItemReference.terracotta_bucket)) : new ActionResult(EnumActionResult.SUCCESS, itemstack);
                    }
                }
                else
                {
                    return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
                }
            }
        }
    }

    private ItemStack fillBucket(ItemStack emptyBuckets, EntityPlayer player, Item fullBucket)
    {
        if (player.capabilities.isCreativeMode)
        {
            return emptyBuckets;
        }
        else
        {
            emptyBuckets.shrink(1);

            if (emptyBuckets.isEmpty())
            {
                return new ItemStack(fullBucket);
            }
            else
            {
                if (!player.inventory.addItemStackToInventory(new ItemStack(fullBucket)))
                {
                    player.dropItem(new ItemStack(fullBucket), false);
                }

                return emptyBuckets;
            }
        }
    }

    public boolean tryPlaceContainedLiquid(@Nullable EntityPlayer player, World worldIn, BlockPos posIn)
    {
        if (this.containedBlock == Blocks.AIR)
        {
            return false;
        }
        else
        {
            IBlockState iblockstate = worldIn.getBlockState(posIn);
            Material material = iblockstate.getMaterial();
            boolean flag = !material.isSolid();
            boolean flag1 = iblockstate.getBlock().isReplaceable(worldIn, posIn);

            if (!worldIn.isAirBlock(posIn) && !flag && !flag1)
            {
                return false;
            }
            else
            {
                if (worldIn.provider.doesWaterVaporize() && this.containedBlock == Blocks.FLOWING_WATER)
                {
                    int l = posIn.getX();
                    int i = posIn.getY();
                    int j = posIn.getZ();
                    worldIn.playSound(player, posIn, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.8F);

                    for (int k = 0; k < 8; ++k)
                    {
                        worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, (double)l + Math.random(), (double)i + Math.random(), (double)j + Math.random(), 0.0D, 0.0D, 0.0D);
                    }
                }
                else
                {
                    if (!worldIn.isRemote && (flag || flag1) && !material.isLiquid())
                    {
                        worldIn.destroyBlock(posIn, true);
                    }

                    SoundEvent soundevent = this.containedBlock == Blocks.FLOWING_LAVA ? SoundEvents.ITEM_BUCKET_EMPTY_LAVA : SoundEvents.ITEM_BUCKET_EMPTY;
                    worldIn.playSound(player, posIn, soundevent, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    worldIn.setBlockState(posIn, this.containedBlock.getDefaultState(), 11);
                }

                return true;
            }
        }
    }

    @Override
    public net.minecraftforge.common.capabilities.ICapabilityProvider initCapabilities(ItemStack stack, @Nullable net.minecraft.nbt.NBTTagCompound nbt) {
        if (this.getClass() == ItemTerracottaBucket.class)
        {
            return new net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper(stack);
        }
        else
        {
            return super.initCapabilities(stack, nbt);
        }
    }

}
