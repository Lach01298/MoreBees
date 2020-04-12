package com.tencao.morebees.recipes

import com.google.common.collect.ImmutableMap
import com.tencao.morebees.MBItems
import com.tencao.morebees.util.OreDictUtil
import forestry.api.recipes.RecipeManagers
import forestry.apiculture.ModuleApiculture
import forestry.core.ModuleCore
import net.minecraft.init.Blocks
import net.minecraft.init.Items
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.nbt.NBTTagList
import net.minecraftforge.fml.common.Loader
import net.minecraftforge.fml.common.event.FMLInterModComms
import kotlin.math.roundToInt

object RecipesCentrifuge {
    fun registerRecipe(ticks: Int, input: ItemStack, outputs: Map<ItemStack, Float>) {
        RecipeManagers.centrifugeManager.addRecipe(ticks, input, outputs)
        registerTECentrifugeRecipe(ticks * 200, input, outputs)
    }

    fun registerRecipes() {
        registerRecipe(20, ItemStack(MBItems.CombDirt), ImmutableMap.of(
                ModuleCore.getItems().beeswax.itemStack, 1.0f,
                ItemStack(Blocks.DIRT), 0.9f))

        if (Loader.isModLoaded("IC2")) {
            registerRecipe(20, ItemStack(MBItems.CombRock), ImmutableMap.of(
                    ModuleCore.getItems().beeswax.itemStack, 1.0f,
                    ItemStack(Blocks.STONE, 1, 1), 0.5f,
                    ItemStack(Blocks.STONE, 1, 3), 0.5f,
                    ItemStack(Blocks.STONE, 1, 5), 0.5f,
                    OreDictUtil.getOreStack("dustStone"), 0.9f))
        }
        if (Loader.isModLoaded("IC2-Classic-Spmod")){
            registerRecipe(20, ItemStack(MBItems.CombRock), ImmutableMap.of(
                    ModuleCore.getItems().beeswax.itemStack, 1.0f,
                    ItemStack(Blocks.COBBLESTONE), 0.9f,
                    ItemStack(Blocks.STONE, 1, 1), 0.5f,
                    ItemStack(Blocks.STONE, 1, 3), 0.5f,
                    ItemStack(Blocks.STONE, 1, 5), 0.5f))
        }

        registerRecipe(20, ItemStack(MBItems.CombWither), ImmutableMap.of(
                ModuleCore.getItems().refractoryWax.itemStack, 1.0f,
                ItemStack(Items.BONE), 0.9f,
                ItemStack(Items.COAL), 0.7f))

        registerRecipe(20, ItemStack(MBItems.CombSlime), ImmutableMap.of(
                ModuleCore.getItems().beeswax.itemStack, 1.0f,
                ItemStack(Items.SLIME_BALL), 0.9f))


        registerRecipe(20, ItemStack(MBItems.CombMetallic), ImmutableMap.of(
                ModuleCore.getItems().beeswax.itemStack, 0.8f,
                ModuleApiculture.getItems().honeyDrop.itemStack, 0.5f,
                ItemStack(MBItems.PropolisMetallic), 0.5f))

        registerRecipe(20, ItemStack(MBItems.CombCrystal), ImmutableMap.of(
                ModuleCore.getItems().beeswax.itemStack, 0.8f,
                ModuleApiculture.getItems().honeyDrop.itemStack, 0.5f,
                ItemStack(MBItems.PropolisCrystal), 0.5f))

        registerRecipe(20, ItemStack(MBItems.CombSpectrite), ImmutableMap.of(
                ModuleCore.getItems().beeswax.itemStack, 0.8f,
                ModuleApiculture.getItems().honeyDrop.itemStack, 0.5f,
                ItemStack(MBItems.PropolisSpectrite), 0.35f))

        registerRecipe(10, ItemStack(MBItems.PropolisCrystal), ImmutableMap.of(
                ModuleApiculture.getItems().propolis.itemStack, 0.3f,
                ItemStack(MBItems.GrainsCrystal), 0.6f,
                ItemStack(MBItems.GrainsCrystal), 0.3f))

        registerRecipe(10, ItemStack(MBItems.PropolisMetallic), ImmutableMap.of(
                ModuleApiculture.getItems().propolis.itemStack, 0.3f,
                ItemStack(MBItems.GrainsMetallic), 0.6f,
                ItemStack(MBItems.GrainsMetallic), 0.3f))

        registerRecipe(10, ItemStack(MBItems.PropolisSpectrite), ImmutableMap.of(
                ModuleApiculture.getItems().propolis.itemStack, 0.3f,
                ItemStack(MBItems.GrainsSpectrite), 0.5f,
                ItemStack(MBItems.GrainsSpectrite), 0.2f))
    }

    fun registerTECentrifugeRecipe(energy: Int, input: ItemStack, products: Map<ItemStack, Float>) {
        // Use the FML inter mod comms mechanism to register new recipes with Thermal Expansion,
        // per this example: https://github.com/CoFH/CoFHCore/blob/1.12/src/main/java/cofh/api/util/ThermalExpansionHelper.java

        // This approach avoids having to include any build-time dependencies from TE
        val msg = NBTTagCompound()
        msg.setInteger("energy", energy)
        msg.setTag("input", writeToCompound(input))

        val outputs = NBTTagList()
        for ((item, chance) in products) {
            val entry = writeToCompound(item)
            entry.setInteger("chance", (chance * 100).roundToInt())
            outputs.appendTag(entry)
        }

        msg.setTag("output", outputs)

        FMLInterModComms.sendMessage("thermalexpansion", "addcentrifugerecipe", msg)
    }

    fun writeToCompound(s : ItemStack) : NBTTagCompound {
        val compound = NBTTagCompound()
        s.writeToNBT(compound)
        return compound
    }
}