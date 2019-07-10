package com.winnetrie.winnetriesexpansionmod.init;

import com.winnetrie.winnetriesexpansionmod.fluids.FluidLiquid;
import com.winnetrie.winnetriesexpansionmod.util.ModConfig;
import com.winnetrie.winnetriesexpansionmod.util.ModConfig.ModFluids;
import com.winnetrie.winnetriesexpansionmod.util.ModFluidReference;
import com.winnetrie.winnetriesexpansionmod.util.References;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Loader;

public class FluidInit {
	
	public static void registerFluids() {
		
		
		if (ModConfig.enable_fluids==true) {
			
			if (ModFluids.enable_liquid_invar==true)
			registerFluid(ModFluidReference.invar_fluid = new FluidLiquid("invar", 
					new ResourceLocation(References.PREFIX + "blocks/liquid_invar_still"), 
					new ResourceLocation(References.PREFIX + "blocks/liquid_invar_flow")));
			
			if (ModFluids.enable_liquid_bronze==true)
			registerFluid(ModFluidReference.bronze_fluid = new FluidLiquid("bronze", 
					new ResourceLocation(References.PREFIX + "blocks/liquid_bronze_still"), 
					new ResourceLocation(References.PREFIX + "blocks/liquid_bronze_flow")));
			
			if (ModFluids.enable_liquid_tin==true)
			registerFluid(ModFluidReference.tin_fluid = new FluidLiquid("tin", 
					new ResourceLocation(References.PREFIX + "blocks/liquid_tin_still"), 
					new ResourceLocation(References.PREFIX + "blocks/liquid_tin_flow")));
			
			if (ModFluids.enable_liquid_solder==true)
			registerFluid(ModFluidReference.solder_fluid = new FluidLiquid("solder", 
					new ResourceLocation(References.PREFIX + "blocks/liquid_solder_still"), 
					new ResourceLocation(References.PREFIX + "blocks/liquid_solder_flow")));
			
			if (ModFluids.enable_liquid_constantan==true)
			registerFluid(ModFluidReference.constantan_fluid = new FluidLiquid("constantan", 
					new ResourceLocation(References.PREFIX + "blocks/liquid_constantan_still"), 
					new ResourceLocation(References.PREFIX + "blocks/liquid_constantan_flow")));
			
			if (ModFluids.enable_liquid_uranium==true)
			registerFluid(ModFluidReference.uranium_fluid = new FluidLiquid("uranium", 
					new ResourceLocation(References.PREFIX + "blocks/liquid_uranium_still"), 
					new ResourceLocation(References.PREFIX + "blocks/liquid_uranium_flow")));
			
			if (ModFluids.enable_plum_juice==true)
			registerFluid(ModFluidReference.plum_juice = new FluidLiquid("plum_juice", 
					new ResourceLocation(References.PREFIX + "blocks/plum_juice_still"), 
					new ResourceLocation(References.PREFIX + "blocks/plum_juice_flow")));
			
			if (ModFluids.enable_apple_juice==true)
			registerFluid(ModFluidReference.apple_juice = new FluidLiquid("apple_juice", 
					new ResourceLocation(References.PREFIX + "blocks/apple_juice_still"), 
					new ResourceLocation(References.PREFIX + "blocks/apple_juice_flow")));
			
			if (ModFluids.enable_cactus_juice==true)
			registerFluid(ModFluidReference.cactus_juice = new FluidLiquid("cactus_juice", 
					new ResourceLocation(References.PREFIX + "blocks/cactus_juice_still"), 
					new ResourceLocation(References.PREFIX + "blocks/cactus_juice_flow")));
			
			if (ModFluids.enable_melon_juice==true)
			registerFluid(ModFluidReference.melon_juice = new FluidLiquid("melon_juice", 
					new ResourceLocation(References.PREFIX + "blocks/melon_juice_still"), 
					new ResourceLocation(References.PREFIX + "blocks/melon_juice_flow")));
			
			if (ModFluids.enable_carrot_juice==true)
			registerFluid(ModFluidReference.carrot_juice = new FluidLiquid("carrot_juice", 
					new ResourceLocation(References.PREFIX + "blocks/carrot_juice_still"), 
					new ResourceLocation(References.PREFIX + "blocks/carrot_juice_flow")));
			
			if (ModFluids.enable_chorusfruit_juice==true)
			registerFluid(ModFluidReference.chorusfruit_juice = new FluidLiquid("chorusfruit_juice", 
					new ResourceLocation(References.PREFIX + "blocks/chorusfruit_juice_still"), 
					new ResourceLocation(References.PREFIX + "blocks/chorusfruit_juice_flow")));
			
			if (ModFluids.enable_pumpkin_juice==true)
			registerFluid(ModFluidReference.pumpkin_juice = new FluidLiquid("pumpkin_juice", 
					new ResourceLocation(References.PREFIX + "blocks/pumpkin_juice_still"), 
					new ResourceLocation(References.PREFIX + "blocks/pumpkin_juice_flow")));
			
			if (ModFluids.enable_lemon_juice==true)
			registerFluid(ModFluidReference.lemon_juice = new FluidLiquid("lemon_juice", 
					new ResourceLocation(References.PREFIX + "blocks/lemon_juice_still"), 
					new ResourceLocation(References.PREFIX + "blocks/lemon_juice_flow")));
			
			if (ModFluids.enable_beetroot_juice==true)
			registerFluid(ModFluidReference.beetroot_juice = new FluidLiquid("beetroot_juice", 
					new ResourceLocation(References.PREFIX + "blocks/beetroot_juice_still"), 
					new ResourceLocation(References.PREFIX + "blocks/beetroot_juice_flow")));
			
			if (ModFluids.enable_chocolate_milk==true)
			registerFluid(ModFluidReference.chocolate_milk = new FluidLiquid("chocolate_milk", 
					new ResourceLocation(References.PREFIX + "blocks/chocolate_milk_still"), 
					new ResourceLocation(References.PREFIX + "blocks/chocolate_milk_flow")));
			
			if (ModFluids.enable_cherry_juice==true)
			registerFluid(ModFluidReference.cherry_juice = new FluidLiquid("cherry_juice", 
					new ResourceLocation(References.PREFIX + "blocks/cherry_juice_still"), 
					new ResourceLocation(References.PREFIX + "blocks/cherry_juice_flow")));
			
			if (ModFluids.enable_tropical_juice==true)
			registerFluid(ModFluidReference.tropical_juice = new FluidLiquid("tropical_juice", 
					new ResourceLocation(References.PREFIX + "blocks/tropical_juice_still"), 
					new ResourceLocation(References.PREFIX + "blocks/tropical_juice_flow")));
			
			if (ModFluids.enable_plum_wine==true)
			registerFluid(ModFluidReference.plum_wine = new FluidLiquid("plum_wine", 
					new ResourceLocation(References.PREFIX + "blocks/plum_wine_still"), 
					new ResourceLocation(References.PREFIX + "blocks/plum_wine_flow")));
			
			if (ModFluids.enable_apple_cider==true)
			registerFluid(ModFluidReference.apple_cider = new FluidLiquid("apple_cider", 
					new ResourceLocation(References.PREFIX + "blocks/apple_cider_still"), 
					new ResourceLocation(References.PREFIX + "blocks/apple_cider_flow")));
		}
		
	}
	
	public static void registerFluid(Fluid fluid) {
		
		FluidRegistry.registerFluid(fluid);
		FluidRegistry.addBucketForFluid(fluid);
	}

}
