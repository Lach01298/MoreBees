package lach_01298.moreBees;

import java.io.File;

import org.apache.logging.log4j.Level;

import forestry.api.apiculture.FlowerManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.oredict.OreDictionary;
import lach_01298.moreBees.Genetics.BeeSpecies;
import lach_01298.moreBees.block.MoreBeesBlocks;
import lach_01298.moreBees.item.MoreBeesItems;
import lach_01298.moreBees.modCopat.LoadMods;
import lach_01298.moreBees.recipes.RecipesCarpenter;
import lach_01298.moreBees.recipes.RecipesCentrifuge;
import lach_01298.moreBees.recipes.RecipesCrafting;
import lach_01298.moreBees.recipes.RecipesSmelting;
import lach_01298.moreBees.util.*;





@Mod(modid = MoreBees.MOD_ID, name = "More Bees", version = MoreBees.VERSION, acceptedMinecraftVersions = MoreBees.MCVERSION,dependencies="required-after:forestry;after:IndustrialCraft2;")
public class MoreBees {

	public static final String MOD_ID = "morebees";
	public static final String VERSION = "1.10.2-1.0.1";
	public static final String MCVERSION = "1.10.2";

	// The instance of your mod that Forge uses.
	@Instance("morebees")
	public static MoreBees instance;

	// world gen
	// WorldEventManager WorldGen = new WorldEventManager();

	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide = "lach_01298.moreBees.ClientProxy", serverSide = "lach_01298.moreBees.CommonProxy")
	public static CommonProxy proxy;
	

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{
		proxy.registerProxies();
		LoadMods.loadMods();
		
		
		MoreBeesItems.initItems();
		MoreBeesBlocks.init();
		
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

		LoadMods.loadMods();
		
		RecipesCrafting.registerRecipes();
		RecipesSmelting.registerRecipes();
		RecipesCentrifuge.registerRecipes();
		RecipesCarpenter.registerRecipes();
		
		Register.RegisterGenes();
		Register.RegisterFlowers();
		BeeSpecies.initBees();
		Register.RegisterHives();
		
		
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) 
	{
		 
		
	}

}