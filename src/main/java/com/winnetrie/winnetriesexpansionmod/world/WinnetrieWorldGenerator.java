package com.winnetrie.winnetriesexpansionmod.world;

import java.util.Random;

import com.google.common.base.Predicate;
import com.winnetrie.winnetriesexpansionmod.util.ModBlockReference;
import com.winnetrie.winnetriesexpansionmod.util.ModConfig;
import com.winnetrie.winnetriesexpansionmod.util.ModConfig.Limestonegen;
import com.winnetrie.winnetriesexpansionmod.util.ModConfig.Marblestonegen;
import com.winnetrie.winnetriesexpansionmod.util.ModConfig.TinOre;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WinnetrieWorldGenerator implements IWorldGenerator{
	
public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider){
		
		//System.out.println("WE ARE CURRENTLY IN THIS DIMENSION: " + world.provider.getDimension());
		
  
		switch (world.provider.getDimension()){ 
		
		case -1: 
			generateNether(world, random, chunkX, chunkZ);
			break;
		case 0: 
			generateOverworld(world, random, chunkX, chunkZ);
			//System.out.println("OVERWORLD GENERATOR");
			break;
		case 3: 
			generateEnd(world, random, chunkX, chunkZ);
		}
	}

	public void generateNether(World world, Random rand, int x, int z){
	/*
		if (ConfigHandler.enable_demonite_gen == true){
			
			generateOre(ModBlockReference.demonite.getDefaultState(), world, rand, 0, x, z, 33, 66, ConfigHandler.demonite_gen_chance, 1, 256, BlockMatcher.forBlock(Blocks.NETHERRACK));
			if ( ConfigHandler.enable_feliron_ore_gen == true){
				
				generateOre(ModBlockReference.feliron_ore.getDefaultState(), world, rand, 0, x, z, 4, 8, ConfigHandler.feliron_ore_gen_chance, 1, 256, BlockMatcher.forBlock((ModBlockReference.demonite.getDefaultState()).getBlock()));
			}
		}
	*/
  
	}


	public void generateOverworld(World world, Random rand, int x, int z){
		
		int XX = x * 16;
		int ZZ = z * 16;
		BlockPos pos = new BlockPos(XX, 70, ZZ);
		Biome biome = world.getBiome(pos);
		
		if (ModConfig.enable_limestone_gen == true) {
			if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.RIVER)) {
				generateOre(ModBlockReference.limestone.getDefaultState(), world, rand, 0, x, z, Limestonegen.veinsize_river, Limestonegen.veincount_river, Limestonegen.veinchance_river, 45, 65, Blocks.STONE);
			}
			if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.OCEAN)) {
				generateOre(ModBlockReference.limestone.getDefaultState(), world, rand, 0, x, z, Limestonegen.veinsize_ocean, Limestonegen.veincount_ocean, Limestonegen.veinchance_ocean, 10, 50, Blocks.STONE);
			}
		}
		if ((ModConfig.enable_marblestone_gen == true) && (BiomeDictionary.hasType(biome, BiomeDictionary.Type.HILLS)) || (BiomeDictionary.hasType(biome, BiomeDictionary.Type.MOUNTAIN))) {
			generateOre(ModBlockReference.marblestone.getDefaultState(), world, rand, 0, x, z, Marblestonegen.veinsize, Marblestonegen.veincount, Marblestonegen.veinchance, 65, 256, Blocks.STONE);
		}
		if (ModConfig.enable_tin_ore == true) {
			generateOre(ModBlockReference.tin_ore.getDefaultState(), world, rand, 0, x, z, TinOre.veinsize, TinOre.veincount, TinOre.veinchance, TinOre.minheight, TinOre.maxheight, Blocks.STONE);
		}
	}


	public void generateEnd(World world, Random rand, int x, int z) {}


	public void generateOre(IBlockState state, World world, Random random, int meta, int chunkX, int chunkZ, int vienSize, int veinCount, int generateChance, int minY, int maxY, Block generatedIn){
  
		//int vienSize = minVienSize + random.nextInt(maxVienSize - minVienSize);
		WorldGenMinable gen = new WorldGenMinable(state, vienSize, BlockMatcher.forBlock(generatedIn));
		for (int v = 0; v < veinCount; v++) {
			
			if(random.nextInt(100) < generateChance) {
				int xRand = chunkX * 16 + random.nextInt(16);
				int yRand = minY + random.nextInt(maxY - minY);
				int zRand = chunkZ * 16 + random.nextInt(16);
    
				BlockPos pos = new BlockPos(xRand , yRand, zRand );
				gen.generate(world, random, pos);
			}
		}
	}

/*
	public void generateSingleOre(IBlockState iBlockState, World world, Random random, int meta, int chunkX, int chunkZ, int chance, int minY, int maxY, BlockMatcher blockMatcher){
  
		int heightRange = maxY - minY + 1;
		WorldGenSingleMinable gen = new WorldGenSingleMinable(iBlockState, meta, blockMatcher);
		for (int i = 0; i < chance; i++) {
			int xRand = chunkX * 16 + random.nextInt(16);
			int yRand = random.nextInt(heightRange) + minY;
			int zRand = chunkZ * 16 + random.nextInt(16);
			BlockPos pos = new BlockPos(xRand, yRand, zRand);
			gen.func_180709_b(world, random, pos);
		}
	}
	*/

}
