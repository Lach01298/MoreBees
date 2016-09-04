package lach_01298.moreBees.modCopat;

import lach_01298.moreBees.util.Log;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.oredict.OreDictionary;

import org.apache.logging.log4j.Level;

public class LoadMods 
{
	public static boolean enableLead = false;
	public static boolean enableSilver = false;
	public static boolean enableRadioactive = false;
	public static boolean enableUranium = false;
	public static boolean enableIronDust = false;
	public static boolean enableCopperDust = false;
	public static boolean enableTinDust = false;
	public static boolean enableGoldDust = false;
	public static boolean enableAluminium = false;
	public static boolean enableRuby = false;
	public static boolean enableSapphire = false;
	
	
	public static void loadMods()
	{
		
	
		//enable dusts
		if(OreDictionary.doesOreNameExist("dustIron"))
		{enableIronDust = true;}
		
		if(OreDictionary.doesOreNameExist("dustGold"))
		{enableGoldDust = true;}
		
		if(OreDictionary.doesOreNameExist("dustCopper"))
		{enableCopperDust = true;}
		
		if(OreDictionary.doesOreNameExist("dustTin"))
		{enableTinDust = true;}
		
		
		//enable metals
		if(OreDictionary.doesOreNameExist("ingotLead"))
		{enableLead = true;}
		
		if(OreDictionary.doesOreNameExist("ingotSilver"))
		{enableSilver = true;}
		
		if(OreDictionary.doesOreNameExist("oreUranium"))
		{enableRadioactive = true;}
		
		if(OreDictionary.doesOreNameExist("ingotAluminum"))
		{enableAluminium = true;}
		
		
		//enable gems
		if(OreDictionary.doesOreNameExist("gemRuby"))
		{enableRuby = true;}
		
		if(OreDictionary.doesOreNameExist("gemSapphire"))
		{enableSapphire = true;}
		
		
		
		
		
		//IC2
		
		if (Loader.isModLoaded("IC2")) {
            try 
            {
            	enableUranium = true;
          
            	Log.log(Level.INFO, "Loaded Industrialcraft2 fetures");
            }

            catch (Exception e) 
            {
                Log.log(Level.INFO, "Could not load Industrialcraft2 fetures");
                e.printStackTrace(System.err);
            }
        }
	
	
	
		Log.log(Level.INFO, "Loaded More Bees modCompat fetures");
	
	
	
	
	
	
	
	}
	
	
	
}
