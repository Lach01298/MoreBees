package lach_01298.moreBees;

import java.util.List;
import java.util.Locale;

import lach_01298.moreBees.Genetics.BeeSpecies;
import lach_01298.moreBees.block.BlockHive;
import lach_01298.moreBees.hives.MoreBeesHiveDescription;
import lach_01298.moreBees.hives.MoreBeesHiveType;
import lach_01298.moreBees.item.MoreBeesItems;
import lach_01298.moreBees.util.LoadMods;
import lach_01298.moreBees.util.OreDicPreferences;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import forestry.api.apiculture.EnumBeeChromosome;
import forestry.api.apiculture.FlowerManager;
import forestry.api.apiculture.IAlleleBeeEffect;
import forestry.api.apiculture.hives.IHiveRegistry.HiveType;
import forestry.api.core.Tabs;
import forestry.apiculture.PluginApiculture;
import forestry.apiculture.blocks.BlockBeeHives;
import forestry.apiculture.flowers.Flower;
import forestry.apiculture.flowers.FlowerProvider;
import forestry.apiculture.flowers.FlowerRegistry;
import forestry.apiculture.genetics.BeeDefinition;
import forestry.apiculture.genetics.HiveDrop;
import forestry.apiculture.genetics.alleles.AlleleEffectPotion;
import forestry.apiculture.genetics.alleles.AlleleFlowers;
import forestry.apiculture.items.EnumHoneyComb;
import forestry.apiculture.worldgen.HiveDescription;
import forestry.core.genetics.alleles.AlleleFactory;
import forestry.core.genetics.alleles.AlleleHelper;
import forestry.core.genetics.alleles.AlleleRegistry;
import forestry.core.genetics.alleles.EnumAllele;
import forestry.core.genetics.alleles.IAlleleValue;
import forestry.core.items.ItemBlockForestry;
import forestry.api.genetics.AlleleManager;
import forestry.api.genetics.IAllele;
import forestry.api.genetics.IAlleleFlowers;
import forestry.api.genetics.IAlleleRegistry;
import forestry.api.genetics.ICheckPollinatable;
import forestry.api.genetics.IFlowerProvider;
import forestry.api.genetics.IIndividual;
import forestry.api.lepidopterology.EnumButterflyChromosome;

public class Register 
{

	
	//Flower types
	public static final String FlowerOre = "Ore";
	public static final String FlowerDiamond = "Diamond";
	public static final String FlowerEmerald = "Emerald";
	public static final String FlowerRedstone = "Redstone";
	public static final String FlowerUranium = "Uranium";
	public static final String FlowerWater = "Water";
	public static final String FlowerTNT = "TNT";
	public static final String FlowerType = "flowers";
	public static final String FlowerSlime = "Slime";
	
	
	public static IAlleleBeeEffect effectWither;
	public static IAlleleBeeEffect effectRadiation;
	public static IAlleleBeeEffect effectSlimey;
	//
	public static IAlleleFlowers FlowerTypeOre;
	public static IAlleleFlowers FlowerTypeDiamond;
	public static IAlleleFlowers FlowerTypeEmerald;
	public static IAlleleFlowers FlowerTypeRedstone;
	public static IAlleleFlowers FlowerTypeUranium;
	public static IAlleleFlowers FlowerTypeWater;
	public static IAlleleFlowers FlowerTypeTNT;
	public static IAlleleFlowers FlowerTypeSlime;
	
	//hives
	public static BlockHive beeHive;
	
	
	
	
	public static void RegisterFlowers() 
	{
		FlowerRegistry flowerRegistry = (FlowerRegistry) FlowerManager.flowerRegistry;

		// Registers blocks that can be used as flowers for type
		flowerRegistry.registerAcceptableFlower(Blocks.COAL_ORE, FlowerOre);
		flowerRegistry.registerAcceptableFlower(Blocks.IRON_ORE, FlowerOre);
		flowerRegistry.registerAcceptableFlower(OreDicPreferences.getBlock("oreCopper"), FlowerOre);
		flowerRegistry.registerAcceptableFlower(OreDicPreferences.getBlock("oreTin"), FlowerOre);
		flowerRegistry.registerAcceptableFlower(Blocks.DIAMOND_ORE, FlowerDiamond);
		flowerRegistry.registerAcceptableFlower(Blocks.EMERALD_ORE, FlowerEmerald);
		flowerRegistry.registerAcceptableFlower(Blocks.REDSTONE_ORE, FlowerRedstone);
		flowerRegistry.registerAcceptableFlower(Blocks.WATERLILY, FlowerWater);
		flowerRegistry.registerAcceptableFlower(Blocks.TNT, FlowerTNT);
		flowerRegistry.registerAcceptableFlower(Blocks.SLIME_BLOCK, FlowerSlime);
		
		
		if(LoadMods.enableTinkers)
		{
			List<ItemStack> list = OreDictionary.getOres("blockSlime");
			for(ItemStack block : list)
			{
				flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(block.getItem()), FlowerSlime);
			}
		}
		
		
		if(LoadMods.enableUranium)
		{
			List<ItemStack> list = OreDictionary.getOres("oreUranium");
			for(ItemStack block : list)
			{
				flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(block.getItem()), FlowerUranium);
			}	
		}
		
		//tweak
		flowerRegistry.registerAcceptableFlower(Blocks.CHORUS_FLOWER, FlowerManager.FlowerTypeEnd);
	}
	

	public static void RegisterGenes()
	{
		
		
		FlowerTypeOre = AlleleManager.alleleFactory.createFlowers(MoreBees.MOD_ID, FlowerType, FlowerOre, Flowers.ORE.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER);
		FlowerTypeDiamond = AlleleManager.alleleFactory.createFlowers(MoreBees.MOD_ID, FlowerType, FlowerDiamond, Flowers.DIAMOND.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER);
		FlowerTypeEmerald = AlleleManager.alleleFactory.createFlowers(MoreBees.MOD_ID, FlowerType, FlowerEmerald, Flowers.EMERALD.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER);
		FlowerTypeRedstone = AlleleManager.alleleFactory.createFlowers(MoreBees.MOD_ID, FlowerType, FlowerRedstone, Flowers.REDSTONE.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER);
		FlowerTypeWater = AlleleManager.alleleFactory.createFlowers(MoreBees.MOD_ID, FlowerType, FlowerWater, Flowers.WATER.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER);
		FlowerTypeTNT = AlleleManager.alleleFactory.createFlowers(MoreBees.MOD_ID, FlowerType, FlowerTNT, Flowers.TNT.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER);
		FlowerTypeUranium = AlleleManager.alleleFactory.createFlowers(MoreBees.MOD_ID, FlowerType, FlowerUranium, Flowers.URANIUM.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER);
		FlowerTypeSlime = AlleleManager.alleleFactory.createFlowers(MoreBees.MOD_ID, FlowerType, FlowerSlime, Flowers.SLIME.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER);
		
		effectWither = new AlleleEffectPotion("wither", true, MobEffects.WITHER, 400);
		effectRadiation = new AlleleEffectPotion("Radiation", true, MobEffects.HUNGER, 400);
	    effectSlimey = new AlleleEffectPotion("Slimey", true, MobEffects.JUMP_BOOST, 400);;
	}
	public static void RegisterHives()
	{
		PluginApiculture.hiveRegistry.registerHive(MoreBeesHiveType.ROCK.getHiveUid(), MoreBeesHiveDescription.ROCK);
		
		ItemStack honeyComb = PluginApiculture.items.beeComb.get(EnumHoneyComb.HONEY, 1);
		ItemStack rockComb = new ItemStack(MoreBeesItems.CombRock);
		PluginApiculture.hiveRegistry.addDrops(MoreBeesHiveType.ROCK.getHiveUid(),
				new HiveDrop(0.80, BeeSpecies.ROCK, rockComb).setIgnobleShare(0.7),
				new HiveDrop(0.03, BeeDefinition.VALIANT, honeyComb)
		);
	}



	
	


}
