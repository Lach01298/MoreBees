package lach_01298.moreBees.util;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.oredict.OreDictionary;

import org.apache.logging.log4j.Level;

public class LoadMods 
{
	public static boolean enableLead = false;
	public static boolean enableSilver = false;
	public static boolean enableUranium = false;
	public static boolean enableIC2 = false;
	public static boolean enableIronDust = false;
	public static boolean enableCopperDust = false;
	public static boolean enableTinDust = false;
	public static boolean enableGoldDust = false;
	public static boolean enableAluminium = false;
	public static boolean enableRuby = false;
	public static boolean enableSapphire = false;
	public static boolean enableTinkers = false;
	
	
	public static void loadMods()
	{
		
	
		//enable dusts
		if(OreDictionary.getOres("dustIron").isEmpty())
		{enableIronDust = true;
		
		}
		
		if(OreDictionary.getOres("dustGold").isEmpty())
		{enableGoldDust = true;}
		
		if(OreDictionary.getOres("dustCopper").isEmpty())
		{enableCopperDust = true;}
		
		if(OreDictionary.getOres("dustTin").isEmpty())
		{enableTinDust = true;}
		
		
		//enable metals
		if(!OreDictionary.getOres("ingotLead").isEmpty())
		{enableLead = true;}
		
		if(!OreDictionary.getOres("ingotSilver").isEmpty())
		{enableSilver = true;}
		
		if(!OreDictionary.getOres("oreUranium").isEmpty())
		{enableUranium = true;}
		
		if(!OreDictionary.getOres("ingotAluminum").isEmpty())
		{enableAluminium = true;}
		
		
		//enable gems
		if(!OreDictionary.getOres("gemRuby").isEmpty())
		{enableRuby = true;}
		
		if(!OreDictionary.getOres("gemSapphire").isEmpty())
		{enableSapphire = true;}
		
		
		
		
		
		//IC2
		
		if (Loader.isModLoaded("IC2")) {
            try 
            {
            	enableIC2 = true;
          
            	Log.log(Level.INFO, "Loaded Industrialcraft2 fetures");
            }

            catch (Exception e) 
            {
                Log.log(Level.INFO, "Could not load Industrialcraft2 fetures");
                e.printStackTrace(System.err);
            }
        }
	
	
	//tinkers construct
	
		if (Loader.isModLoaded("tconstruct")) {
            try 
            {
            	enableTinkers = true;
          
            	Log.log(Level.INFO, "Loaded tinkers construct fetures");
            }

            catch (Exception e) 
            {
                Log.log(Level.INFO, "Could not load tinkers construct fetures");
                e.printStackTrace(System.err);
            }
        }
	
		Log.log(Level.INFO, "Loaded More Bees modCompat fetures");
	
	}
	
	
	
}
