package lach_01298.moreBees.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;



public final class OreDicPreferences 
{

	public static ItemStack get(String oreName,int amount) 
	{
		List<ItemStack> items = OreDictionary.getOres(oreName);

		ItemStack item = items.get(0);
		item.stackSize = amount;
		return item;
	}

	
	public static Block getBlock(String oreName) 
	{
		List<ItemStack> items = OreDictionary.getOres(oreName);
		
		ItemBlock blockItem = (ItemBlock)items.get(0).getItem();
		Block block = blockItem.getBlock();
		return block;
	}
	
}