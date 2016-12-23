package lach_01298.moreBees.Genetics;

import forestry.api.apiculture.*;
import forestry.api.core.EnumHumidity;
import forestry.api.core.EnumTemperature;
import forestry.api.genetics.AlleleManager;
import forestry.api.genetics.IAllele;
import forestry.apiculture.PluginApiculture;
import forestry.apiculture.genetics.Bee;
import forestry.apiculture.genetics.BeeBranchDefinition;
import forestry.apiculture.genetics.BeeVariation;
import forestry.apiculture.genetics.IBeeDefinition;
import forestry.apiculture.genetics.alleles.AlleleEffect;
import forestry.apiculture.items.EnumHoneyComb;
import forestry.core.PluginCore;
import forestry.core.genetics.IBranchDefinition;
import forestry.core.genetics.alleles.AlleleHelper;
import forestry.core.genetics.alleles.EnumAllele;
import lach_01298.moreBees.MoreBees;
import lach_01298.moreBees.Register;
import lach_01298.moreBees.item.MoreBeesItems;
import lach_01298.moreBees.util.LoadMods;
import lach_01298.moreBees.util.OreDicPreferences;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.BiomeDictionary;
import org.apache.commons.lang3.text.WordUtils;

import java.awt.*;
import java.util.Arrays;
import java.util.Locale;

public enum BeeSpecies implements IBeeDefinition {

    // Rock Branch
    ROCK(BeeBranches.ROCK, "Rock", true, new Color(0x6d6d6d), new Color(0xffdc16)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombRock), 0.30f).setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.NORMAL);
        }

        @Override
        protected void setAlleles(IAllele[] template) {

            AlleleHelper.instance.set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
            AlleleHelper.instance.set(template, EnumBeeChromosome.CAVE_DWELLING, true);
            AlleleHelper.instance.set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.NEVER_SLEEPS, true);
            AlleleHelper.instance.set(template, EnumBeeChromosome.FLOWER_PROVIDER, Register.FlowerTypeOre);
        }

        @Override
        protected void registerMutations() {
            // found in hives
        }
    },
    HARDENED(BeeBranches.ROCK, "Hardened", true, new Color(0x464646), new Color(0xffdc16)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombRock), 0.35f).setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.NORMAL);
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
            AlleleHelper.instance.set(template, EnumBeeChromosome.CAVE_DWELLING, true);
            AlleleHelper.instance.set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.NEVER_SLEEPS, true);
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
        }

        @Override
        protected void registerMutations() {

            BeeManager.beeMutationFactory.createMutation(RockBee, CultivatedBee, getTemplate(), 10);

        }
    },
    OBSIDIAN(BeeBranches.ROCK, "Obsidian", false, new Color(0x241e31), new Color(0xffdc16)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombRock), 0.40f).addProduct(new ItemStack(Blocks.OBSIDIAN), 0.1f).setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);

        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
            AlleleHelper.instance.set(template, EnumBeeChromosome.CAVE_DWELLING, true);
            AlleleHelper.instance.set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.NEVER_SLEEPS, true);
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW);
        }

        @Override
        protected void registerMutations() {

            BeeManager.beeMutationFactory.createMutation(HardenedBee, SteadfastBee, getTemplate(), 10);

        }

    },
    LAPIS(BeeBranches.ROCK, "Lapis", false, new Color(0x22479c), new Color(0xffdc16)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombRock), 0.30f).addProduct(new ItemStack(Items.DYE, 1, 4), 0.1f).setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);

        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
            AlleleHelper.instance.set(template, EnumBeeChromosome.CAVE_DWELLING, true);
            AlleleHelper.instance.set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW);

        }

        @Override
        protected void registerMutations() {

            BeeManager.beeMutationFactory.createMutation(ObsidianBee, ImperialBee, getTemplate(), 8);

        }
    },
    // Earth Branch
    DIRT(BeeBranches.EARTH, "Dirt", true, new Color(0x79553a), new Color(0xffdc16)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombDirt), 0.40f).setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.NORMAL);
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
            AlleleHelper.instance.set(template, EnumBeeChromosome.CAVE_DWELLING, true);
            AlleleHelper.instance.set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
            AlleleHelper.instance.set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.NEVER_SLEEPS, true);
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.FAST);
        }

        @Override
        protected void registerMutations() {

            for (int i = 0; i < hiveBees.length; i++) {
                BeeManager.beeMutationFactory.createMutation(RockBee, hiveBees[i], getTemplate(), 15);
            }

        }
    },
    CLAY(BeeBranches.EARTH, "Clay", true, new Color(0xa7abbb), new Color(0xffdc16)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {

            beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombDirt), 0.30f).addProduct(new ItemStack(Items.CLAY_BALL), 1.0f).addProduct(new ItemStack(Items.CLAY_BALL), 0.5f).addProduct(new ItemStack(Items.CLAY_BALL), 0.5f).addProduct(new ItemStack(Items.CLAY_BALL), 0.5f).setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.DAMP);
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
            AlleleHelper.instance.set(template, EnumBeeChromosome.CAVE_DWELLING, true);
            AlleleHelper.instance.set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.FAST);
        }

        @Override
        protected void registerMutations() {

            BeeManager.beeMutationFactory.createMutation(DirtBee, hiveBees[1], getTemplate(), 15);

        }
    },
    REDSAND(BeeBranches.EARTH, "RedSand", false, new Color(0xa75620), new Color(0xffdc16)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombDirt), 0.30f).addProduct(new ItemStack(Blocks.SAND), 0.40f).addProduct(new ItemStack(Blocks.SAND, 1, 1), 0.70f).addProduct(new ItemStack(Blocks.SAND, 2, 1), 0.30f).addProduct(new ItemStack(Blocks.SAND, 1, 1), 0.20f).setTemperature(EnumTemperature.HOT).setHumidity(EnumHumidity.ARID);
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
            AlleleHelper.instance.set(template, EnumBeeChromosome.CAVE_DWELLING, true);
            AlleleHelper.instance.set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
            AlleleHelper.instance.set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.NEVER_SLEEPS, true);
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.FAST);

        }

        @Override
        protected void registerMutations() {

            BeeManager.beeMutationFactory.createMutation(DirtBee, hiveBees[3], getTemplate(), 15);

        }
    },
    // Crystal branch
    REDSTONE(BeeBranches.CRYSTAL, "Redstone", false, new Color(0xaa0404), new Color(0xffdc16)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombRock), 0.30f).addProduct(new ItemStack(Items.REDSTONE), 0.30f).addProduct(new ItemStack(Items.REDSTONE), 0.20f).setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);

        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
            AlleleHelper.instance.set(template, EnumBeeChromosome.CAVE_DWELLING, true);
            AlleleHelper.instance.set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
            AlleleHelper.instance.set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.FLOWER_PROVIDER, Register.FlowerTypeRedstone);
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW);
        }

        @Override
        protected void registerMutations() {

            BeeManager.beeMutationFactory.createMutation(ObsidianBee, SteadfastBee, getTemplate(), 8);

        }
    },
    EMERALD(BeeBranches.CRYSTAL, "Emerald", false, new Color(0x4adc73), new Color(0xffdc16)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombRock), 0.30f).addProduct(new ItemStack(MoreBeesItems.EmeraldFrag), 0.15f).setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);

        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
            AlleleHelper.instance.set(template, EnumBeeChromosome.CAVE_DWELLING, true);
            AlleleHelper.instance.set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
            AlleleHelper.instance.set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.FLOWER_PROVIDER, Register.FlowerTypeEmerald);
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWER);
        }

        @Override
        protected void registerMutations() {

            BeeManager.beeMutationFactory.createMutation(RedstoneBee, ImperialBee, getTemplate(), 5);

        }
    },
    DIAMOND(BeeBranches.CRYSTAL, "Diamond", false, new Color(0x5decf5), new Color(0xffdc16)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombRock), 0.30f).addProduct(new ItemStack(MoreBeesItems.DiamondFrag), 0.15f).setHasEffect().setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);

        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
            AlleleHelper.instance.set(template, EnumBeeChromosome.CAVE_DWELLING, true);
            AlleleHelper.instance.set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.UP_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.FLOWER_PROVIDER, Register.FlowerTypeDiamond);
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWEST);
        }

        @Override
        protected void registerMutations() {

            BeeManager.beeMutationFactory.createMutation(EmeraldBee, LapisBee, getTemplate(), 2);

        }
    },
    RUBY(BeeBranches.CRYSTAL, "Ruby", false, new Color(0xff0000), new Color(0xffdc16)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            if (LoadMods.enableRuby) {
                beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombRock), 0.30f).addProduct(OreDicPreferences.get("gemRuby", 1), 0.15f).setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);
            }
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
            AlleleHelper.instance.set(template, EnumBeeChromosome.CAVE_DWELLING, true);
            AlleleHelper.instance.set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.UP_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW);
        }

        @Override
        protected void registerMutations() {

            BeeManager.beeMutationFactory.createMutation(RedstoneBee, ImperialBee, getTemplate(), 7);

        }
    },
    SAPPHIRE(BeeBranches.CRYSTAL, "Sapphire", false, new Color(0x0058f8), new Color(0xffdc16)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            if (LoadMods.enableSapphire) {
                beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombRock), 0.30f).addProduct(OreDicPreferences.get("gemSapphire", 1), 0.15f).setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);
            }
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
            AlleleHelper.instance.set(template, EnumBeeChromosome.CAVE_DWELLING, true);
            AlleleHelper.instance.set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.UP_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW);
        }

        @Override
        protected void registerMutations() {

            BeeManager.beeMutationFactory.createMutation(RedstoneBee, ImperialBee, getTemplate(), 7);

        }
    },
    SULFUR(BeeBranches.CRYSTAL, "Sulfur", false, new Color(0xE9F800), new Color(0xffdc16)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            if (LoadMods.enableSulfur) {
                beeSpecies.addProduct(PluginApiculture.items.beeComb.get(EnumHoneyComb.SIMMERING, 1), 0.3f).addProduct(OreDicPreferences.get("dustSulfur", 1), 0.15f).setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);
            }
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
            AlleleHelper.instance.set(template, EnumBeeChromosome.CAVE_DWELLING, true);
            AlleleHelper.instance.set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.UP_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW);
        }

        @Override
        protected void registerMutations() {

            BeeManager.beeMutationFactory.createMutation(RedstoneBee, LapisBee, getTemplate(), 15);

        }
    },
    APATITE(BeeBranches.CRYSTAL, "Apatite", false, new Color(0x4baef1), new Color(0xffdc16)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {

            beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombRock), 0.3f).addProduct(new ItemStack(PluginCore.items.apatite), 0.1f).setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
            AlleleHelper.instance.set(template, EnumBeeChromosome.CAVE_DWELLING, true);
            AlleleHelper.instance.set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.UP_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW);
        }

        @Override
        protected void registerMutations() {

            BeeManager.beeMutationFactory.createMutation(RedstoneBee, FiendishBee, getTemplate(), 10);

        }
    },

    // Metal Branch
    Metallic(BeeBranches.METAL, "Metallic", true, new Color(0x999999), new Color(0x999999)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombRock), 0.30f).addProduct(OreDicPreferences.get("dustIron", 1), 0.05f).setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);

        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
            AlleleHelper.instance.set(template, EnumBeeChromosome.CAVE_DWELLING, true);
            AlleleHelper.instance.set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
            AlleleHelper.instance.set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.NEVER_SLEEPS, true);
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWER);

        }

        @Override
        protected void registerMutations() {

            BeeManager.beeMutationFactory.createMutation(ObsidianBee, FiendishBee, getTemplate(), 10);

        }
    },
    IRON(BeeBranches.METAL, "Iron", false, new Color(0xd9d9d9), new Color(0x999999)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombRock), 0.30f).addProduct(OreDicPreferences.get("dustIron", 1), 0.15f).setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);

        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
            AlleleHelper.instance.set(template, EnumBeeChromosome.CAVE_DWELLING, true);
            AlleleHelper.instance.set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
            AlleleHelper.instance.set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
        }

        @Override
        protected void registerMutations() {

            BeeManager.beeMutationFactory.createMutation(MetallicBee, IndustriousBee, getTemplate(), 10);

        }
    },
    COPPER(BeeBranches.METAL, "Copper", false, new Color(0xa76430), new Color(0x999999)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombRock), 0.30f).addProduct(OreDicPreferences.get("dustCopper", 1), 0.15f).setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
            AlleleHelper.instance.set(template, EnumBeeChromosome.CAVE_DWELLING, true);
            AlleleHelper.instance.set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
            AlleleHelper.instance.set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
        }

        @Override
        protected void registerMutations() {

            BeeManager.beeMutationFactory.createMutation(MetallicBee, IndustriousBee, getTemplate(), 10);

        }
    },
    TIN(BeeBranches.METAL, "Tin", false, new Color(0xe8e8e8), new Color(0x999999)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombRock), 0.30f).addProduct(OreDicPreferences.get("dustTin", 1), 0.15f).setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
            AlleleHelper.instance.set(template, EnumBeeChromosome.CAVE_DWELLING, true);
            AlleleHelper.instance.set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
            AlleleHelper.instance.set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
        }

        @Override
        protected void registerMutations() {

            BeeManager.beeMutationFactory.createMutation(MetallicBee, IndustriousBee, getTemplate(), 10);

        }
    },
    ALUMINIUM(BeeBranches.METAL, "Aluminium", false, new Color(0xF6F6F6), new Color(0x999999)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            if (LoadMods.enableAluminium) {
                beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombRock), 0.30f).addProduct(OreDicPreferences.get("dustAluminum", 1), 0.15f).setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);
            }
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
            AlleleHelper.instance.set(template, EnumBeeChromosome.CAVE_DWELLING, true);
            AlleleHelper.instance.set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
            AlleleHelper.instance.set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
        }

        @Override
        protected void registerMutations() {

            BeeManager.beeMutationFactory.createMutation(MetallicBee, IndustriousBee, getTemplate(), 10);

        }
    },
    GOLD(BeeBranches.METAL, "Gold", false, new Color(0xeed83d), new Color(0x999999)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombRock), 0.30f).addProduct(OreDicPreferences.get("dustGold", 1), 0.15f).setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);

        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
            AlleleHelper.instance.set(template, EnumBeeChromosome.CAVE_DWELLING, true);
            AlleleHelper.instance.set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
            AlleleHelper.instance.set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
        }

        @Override
        protected void registerMutations() {

            BeeManager.beeMutationFactory.createMutation(MetallicBee, ImperialBee, getTemplate(), 8);

        }
    },
    SILVER(BeeBranches.METAL, "Silver", false, new Color(0xf4f6f6), new Color(0x999999)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            if (LoadMods.enableSilver) {
                beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombRock), 0.30f).addProduct(OreDicPreferences.get("dustSilver", 1), 0.15f).setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);
            }
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
            AlleleHelper.instance.set(template, EnumBeeChromosome.CAVE_DWELLING, true);
            AlleleHelper.instance.set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
            AlleleHelper.instance.set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW);
        }

        @Override
        protected void registerMutations() {

            BeeManager.beeMutationFactory.createMutation(GoldBee, TinBee, getTemplate(), 8);

        }
    },
    LEAD(BeeBranches.METAL, "Lead", false, new Color(0xd5d9b9), new Color(0x999999)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            if (LoadMods.enableLead) {
                beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombRock), 0.30f).addProduct(OreDicPreferences.get("dustLead", 1), 0.15f).setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.NORMAL);
            }
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
            AlleleHelper.instance.set(template, EnumBeeChromosome.CAVE_DWELLING, true);
            AlleleHelper.instance.set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
            AlleleHelper.instance.set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW);
        }

        @Override
        protected void registerMutations() {

            BeeManager.beeMutationFactory.createMutation(MetallicBee, ObsidianBee, getTemplate(), 8);

        }
    },
    COBALT(BeeBranches.METAL, "Cobalt", false, new Color(0x1d62b8), new Color(0x999999)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            if (LoadMods.enableTinkers) {
                beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombRock), 0.30f).addProduct(OreDicPreferences.get("nuggetCobalt", 1), 0.15f).setTemperature(EnumTemperature.HELLISH).setHumidity(EnumHumidity.ARID);
            }
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
            AlleleHelper.instance.set(template, EnumBeeChromosome.CAVE_DWELLING, true);
            AlleleHelper.instance.set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
            AlleleHelper.instance.set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW);
        }

        @Override
        protected void registerMutations() {

            BeeManager.beeMutationFactory.createMutation(DemonicBee, TinBee, getTemplate(), 8);

        }
    },
    ARDITE(BeeBranches.METAL, "Ardite", false, new Color(0xa82517), new Color(0x999999)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            if (LoadMods.enableTinkers) {
                beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombRock), 0.30f).addProduct(OreDicPreferences.get("nuggetArdite", 1), 0.15f).setTemperature(EnumTemperature.HELLISH).setHumidity(EnumHumidity.ARID);
            }
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
            AlleleHelper.instance.set(template, EnumBeeChromosome.CAVE_DWELLING, true);
            AlleleHelper.instance.set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
            AlleleHelper.instance.set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW);
        }

        @Override
        protected void registerMutations() {

            BeeManager.beeMutationFactory.createMutation(DemonicBee, CopperBee, getTemplate(), 8);

        }
    },
    // RadioActive branch
    RADIOACTIVE(BeeBranches.RADIOACTIVE, "Radioactive", true, new Color(0x3e720c), new Color(0x999999)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            if (LoadMods.enableUranium && !LoadMods.enableIC2Classic) {
                beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombRock), 0.30f).addProduct(OreDicPreferences.get("oreUranium", 1), 0.1f).setTemperature(EnumTemperature.HOT).setHumidity(EnumHumidity.NORMAL);
            } else if (LoadMods.enableIC2Classic) {
                beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombRock), 0.30f).addProduct(OreDicPreferences.get("dropUranium", 1), 0.1f).setTemperature(EnumTemperature.HOT).setHumidity(EnumHumidity.NORMAL);

            }

        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
            AlleleHelper.instance.set(template, EnumBeeChromosome.CAVE_DWELLING, true);
            AlleleHelper.instance.set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
            AlleleHelper.instance.set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWER);
            AlleleHelper.instance.set(template, EnumBeeChromosome.FLOWER_PROVIDER, Register.FlowerTypeUranium);
            AlleleHelper.instance.set(template, EnumBeeChromosome.NEVER_SLEEPS, true);

        }

        @Override
        protected void registerMutations() {

            BeeManager.beeMutationFactory.createMutation(LeadBee, AustereBee, getTemplate(), 8);

        }
    },
    URANIUM(BeeBranches.RADIOACTIVE, "Uranium", false, new Color(0x6ac013), new Color(0x999999)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            if (LoadMods.enableIC2 && !LoadMods.enableIC2Classic) {
                beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombRock), 0.30f).addProduct(OreDicPreferences.get("crushedUranium", 1), 0.15f).setHasEffect().setTemperature(EnumTemperature.HELLISH).setHumidity(EnumHumidity.ARID);
            } else if (LoadMods.enableIC2Classic) {
                beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombRock), 0.30f).addProduct(OreDicPreferences.get("dropUranium", 1), 0.15f).setHasEffect().setTemperature(EnumTemperature.HELLISH).setHumidity(EnumHumidity.ARID);

            }
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
            AlleleHelper.instance.set(template, EnumBeeChromosome.CAVE_DWELLING, true);
            AlleleHelper.instance.set(template, EnumBeeChromosome.NEVER_SLEEPS, true);
            AlleleHelper.instance.set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);

        }

        @Override
        protected void registerMutations() {

            BeeManager.beeMutationFactory.createMutation(RadioactiveBee, ApocalypticBee, getTemplate(), 5).restrictBiomeType(BiomeDictionary.Type.NETHER);

        }
    },

    // Aquatic branch
    PRISMARINE(BeeBranches.AQUATIC, "Prismarine", true, new Color(0x63ab9d), new Color(0xffdc16)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(PluginApiculture.items.beeComb.get(EnumHoneyComb.HONEY, 1), 0.30f).addProduct(new ItemStack(Items.PRISMARINE_CRYSTALS, 2), 0.2f).addProduct(new ItemStack(Items.PRISMARINE_SHARD, 2), 0.2f).setHasEffect().setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.DAMP);

        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
            AlleleHelper.instance.set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
            AlleleHelper.instance.set(template, EnumBeeChromosome.FLOWER_PROVIDER, Register.FlowerTypeWater);
        }

        @Override
        protected void registerMutations() {

            BeeManager.beeMutationFactory.createMutation(ObsidianBee, ClayBee, getTemplate(), 15).restrictBiomeType(BiomeDictionary.Type.OCEAN);

        }
    },
    // Apocalyptic branch
    APOCALYPTIC(BeeBranches.APOCALYTIC, "Apocalyptic", true, new Color(0xcb7204), new Color(0x830d0d)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(PluginApiculture.items.beeComb.get(EnumHoneyComb.SIMMERING, 1), 0.30f).addProduct(new ItemStack(Items.BLAZE_POWDER), 0.2f).addProduct(new ItemStack(Items.GUNPOWDER), 0.2f).addProduct(new ItemStack(Items.GHAST_TEAR), 0.05f).setTemperature(EnumTemperature.HELLISH).setHumidity(EnumHumidity.ARID);
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
            AlleleHelper.instance.set(template, EnumBeeChromosome.CAVE_DWELLING, true);
            AlleleHelper.instance.set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.UP_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_3);
            AlleleHelper.instance.set(template, EnumBeeChromosome.EFFECT, AlleleEffect.effectIgnition);
            AlleleHelper.instance.set(template, EnumBeeChromosome.EFFECT, AlleleEffect.effectCreeper);
            AlleleHelper.instance.set(template, EnumBeeChromosome.FLOWER_PROVIDER, Register.FlowerTypeTNT);
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW);
        }

        @Override
        protected void registerMutations() {

            BeeManager.beeMutationFactory.createMutation(AustereBee, DemonicBee, getTemplate(), 5).restrictBiomeType(BiomeDictionary.Type.NETHER);

        }
    },
    // Wither Branch
    WITHER(BeeBranches.WITHER, "Withering", false, new Color(0xc1c1c1), new Color(0x3c3c3c)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombWither), 0.30f).addSpecialty(new ItemStack(Items.SKULL, 1, 1), 0.02f).setTemperature(EnumTemperature.HELLISH).setHumidity(EnumHumidity.ARID);

        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
            AlleleHelper.instance.set(template, EnumBeeChromosome.CAVE_DWELLING, true);
            AlleleHelper.instance.set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.UP_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_3);
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWER);
        }

        @Override
        protected void registerMutations() {

            BeeManager.beeMutationFactory.createMutation(ApocalypticBee, DemonicBee, getTemplate(), 5).restrictBiomeType(BiomeDictionary.Type.NETHER);

        }
    },
    NETHERSTAR(BeeBranches.WITHER, "wither", false, new Color(0xc1c1c1), new Color(0x3c3c3c)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombWither), 0.35f).addSpecialty(new ItemStack(MoreBeesItems.NetherFrag), 0.05f).setHasEffect().setTemperature(EnumTemperature.HELLISH).setHumidity(EnumHumidity.ARID);
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
            AlleleHelper.instance.set(template, EnumBeeChromosome.CAVE_DWELLING, true);
            AlleleHelper.instance.set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.UP_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_3);
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWEST);
        }

        @Override
        protected void registerMutations() {
            BeeManager.beeMutationFactory.createMutation(WitherBee, EnderBee, getTemplate(), 5).restrictBiomeType(BiomeDictionary.Type.NETHER);
        }
    },
    // Slime Branch
    SLIMEY(BeeBranches.SLIME, "Slimey", true, new Color(0x7dc873), new Color(0x7dc873)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombSlime), 0.70f).setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.DAMP);
        }

        @Override
        protected void setAlleles(IAllele[] template) {

            AlleleHelper.instance.set(template, EnumBeeChromosome.FLOWER_PROVIDER, Register.FlowerTypeSlime);
            AlleleHelper.instance.set(template, EnumBeeChromosome.CAVE_DWELLING, false);
            AlleleHelper.instance.set(template, EnumBeeChromosome.TERRITORY, EnumAllele.Territory.AVERAGE);
            AlleleHelper.instance.set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.NORMAL);
            AlleleHelper.instance.set(template, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.DOWN_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
            AlleleHelper.instance.set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
            AlleleHelper.instance.set(template, EnumBeeChromosome.EFFECT, Register.effectSlimey);

        }

        @Override
        protected void registerMutations() {
            BeeManager.beeMutationFactory.createMutation(RockBee, BoggyBee, getTemplate(), 30);
        }
    },
    BLUESLIMEY(BeeBranches.SLIME, "BlueSlimey", true, new Color(0x7dc873), new Color(0x74c8c7)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            if (LoadMods.enableTinkers) {
                beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombSlime), 0.55f).addProduct(OreDicPreferences.get("slimeballBlue", 1), 0.55f).setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.DAMP);
            }
        }

        @Override
        protected void setAlleles(IAllele[] template) {

            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
        }

        @Override
        protected void registerMutations() {
            BeeManager.beeMutationFactory.createMutation(SlimeyBee, PrismarineBee, getTemplate(), 30);
        }
    },
    PURPLESLIMEY(BeeBranches.SLIME, "PurpleSlimey", false, new Color(0x7dc873), new Color(0xbb5aff)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            if (LoadMods.enableTinkers) {
                beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombSlime), 0.55f).addProduct(OreDicPreferences.get("slimeballPurple", 1), 0.55f).setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.DAMP);
            }
        }

        @Override
        protected void setAlleles(IAllele[] template) {

            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
        }

        @Override
        protected void registerMutations() {
            System.out.println(BlueSlimeyBee);
            BeeManager.beeMutationFactory.createMutation(BlueSlimeyBee, RedstoneBee, getTemplate(), 8);
        }
    },
    MAGMASLIMEY(BeeBranches.SLIME, "MagmaSlimey", false, new Color(0x7dc873), new Color(0xffab49)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            if (LoadMods.enableTinkers) {
                beeSpecies.addProduct(new ItemStack(MoreBeesItems.CombSlime), 0.55f).addProduct(OreDicPreferences.get("slimeballMagma", 1), 0.55f).setTemperature(EnumTemperature.HELLISH).setHumidity(EnumHumidity.ARID);
            }
        }

        @Override
        protected void setAlleles(IAllele[] template) {

            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
        }

        @Override
        protected void registerMutations() {
            BeeManager.beeMutationFactory.createMutation(SlimeyBee, FiendishBee, getTemplate(), 10);
        }
    },
    //forestry branches
    STRINGY(BeeBranchDefinition.TROPICAL, "Stringy", false, new Color(0x6d6d6d), new Color(0xe5e5e5)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(PluginApiculture.items.beeComb.get(EnumHoneyComb.SILKY, 1), 0.30f)
                    .addProduct(PluginApiculture.items.beeComb.get(EnumHoneyComb.STRINGY, 1), 0.30f)
                    .addProduct(new ItemStack(Items.STRING, 1), 0.70f)
                    .setTemperature(EnumTemperature.WARM).setHumidity(EnumHumidity.DAMP);
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
            AlleleHelper.instance.set(template, EnumBeeChromosome.CAVE_DWELLING, false);
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);

        }

        @Override
        protected void registerMutations() {
            BeeManager.beeMutationFactory.createMutation(TropicalBee, DiligentBee, getTemplate(), 10);
        }
    },
    //Ender branch
    ENDERY(BeeBranches.ENDER, "Endery", false, new Color(0x9900ff), new Color(0xffbbff)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(new ItemStack(Items.ENDER_PEARL), 0.30f).setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.ARID);
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            //
        }

        @Override
        protected void registerMutations() {

            BeeManager.beeMutationFactory.createMutation(CultivatedBee, SteadfastBee, getTemplate(), 10);

        }
    },
    ENDERIE(BeeBranches.ENDER, "Enderie", false, new Color(0xdd00ff), new Color(0xffffff)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(new ItemStack(Items.ENDER_PEARL), 0.45f).setTemperature(EnumTemperature.HOT).setHumidity(EnumHumidity.ARID);
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            //
        }

        @Override
        protected void registerMutations() {

            BeeManager.beeMutationFactory.createMutation(EnderyBee, CultivatedBee, getTemplate(), 10);

        }
    },
    DRAGONY(BeeBranches.ENDER, "Dragony", false, new Color(0xdd00ff), new Color(0xffbbff)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(new ItemStack(Blocks.DRAGON_EGG), 0.02f).setHasEffect().setTemperature(EnumTemperature.HELLISH).setHumidity(EnumHumidity.ARID);
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW);
        }

        @Override
        protected void registerMutations() {
            BeeManager.beeMutationFactory.createMutation(EnderyBee, EnderieBee, getTemplate(), 6);
        }
    },
    //Colours branch - lapis is not here because it already has a bee
    WHITY(BeeBranches.COLOUR, "Whity", false, new Color(0xffffff), new Color(0xeeeeee)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(new ItemStack(Items.DYE, 1,15), 0.35f)
                    .addProduct(new ItemStack(Items.DYE, 1,15), 0.20f)
                    .setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.NORMAL);
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
        }

        @Override
        protected void registerMutations() {
            BeeManager.beeMutationFactory.createMutation(CultivatedBee, DiligentBee, getTemplate(), 6);
        }
    },
    BLACKY(BeeBranches.COLOUR, "Blacky", false, new Color(0x191616), new Color(0xeeeeee)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(new ItemStack(Items.DYE, 1,0), 0.35f)
                    .addProduct(new ItemStack(Items.DYE, 1,0), 0.20f)
                    .setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.NORMAL);
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
        }

        @Override
        protected void registerMutations() {
            BeeManager.beeMutationFactory.createMutation(CultivatedBee, WhityBee, getTemplate(), 20);
        }
    },
    REDY(BeeBranches.COLOUR, "Redy", false, new Color(0x963430), new Color(0xeeeeee)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(new ItemStack(Items.DYE, 1,1), 0.35f)
                    .addProduct(new ItemStack(Items.DYE, 1,1), 0.20f)
                    .setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.NORMAL);
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
        }

        @Override
        protected void registerMutations() {
            BeeManager.beeMutationFactory.createMutation(BlackyBee, WhityBee, getTemplate(), 20);
        }
    },
    GREENY(BeeBranches.COLOUR, "Greeny", false, new Color(0x35661B), new Color(0xeeeeee)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(new ItemStack(Items.DYE, 1,2), 0.35f)
                    .addProduct(new ItemStack(Items.DYE, 1,2), 0.20f)
                    .setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.NORMAL);
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
        }

        @Override
        protected void registerMutations() {
            BeeManager.beeMutationFactory.createMutation(RedyBee, WhityBee, getTemplate(), 20);
        }
    },
    BROWNY(BeeBranches.COLOUR, "Browny", false, new Color(0x4F321F), new Color(0xeeeeee)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(new ItemStack(Items.DYE, 1,3), 0.35f)
                    .addProduct(new ItemStack(Items.DYE, 1,3), 0.20f)
                    .setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.NORMAL);
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
        }

        @Override
        protected void registerMutations() {
            BeeManager.beeMutationFactory.createMutation(GreenyBee, WhityBee, getTemplate(), 20);
        }
    },
    PURPLY(BeeBranches.COLOUR, "Purply", false, new Color(0x7E3DB5), new Color(0xeeeeee)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(new ItemStack(Items.DYE, 1,5), 0.35f)
                    .addProduct(new ItemStack(Items.DYE, 1,5), 0.20f)
                    .setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.NORMAL);
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
        }

        @Override
        protected void registerMutations() {
            BeeManager.beeMutationFactory.createMutation(BrownyBee, WhityBee, getTemplate(), 20);
        }
    },
    CYANY(BeeBranches.COLOUR, "Cyany", false, new Color(0x2E6E89), new Color(0xeeeeee)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(new ItemStack(Items.DYE, 1,6), 0.35f)
                    .addProduct(new ItemStack(Items.DYE, 1,6), 0.20f)
                    .setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.NORMAL);
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
        }

        @Override
        protected void registerMutations() {
            BeeManager.beeMutationFactory.createMutation(PurplyBee, WhityBee, getTemplate(), 20);
        }
    },
    LIGHTG(BeeBranches.COLOUR, "Lightg", false, new Color(0x9AA1A1), new Color(0xeeeeee)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(new ItemStack(Items.DYE, 1,7), 0.35f)
                    .addProduct(new ItemStack(Items.DYE, 1,7), 0.20f)
                    .setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.NORMAL);
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
        }

        @Override
        protected void registerMutations() {
            BeeManager.beeMutationFactory.createMutation(CyanyBee, WhityBee, getTemplate(), 20);
        }
    },
    GRAYNY(BeeBranches.COLOUR, "Grayny", false, new Color(0x404040), new Color(0xeeeeee)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(new ItemStack(Items.DYE, 1,8), 0.35f)
                    .addProduct(new ItemStack(Items.DYE, 1,8), 0.20f)
                    .setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.NORMAL);
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
        }

        @Override
        protected void registerMutations() {
            BeeManager.beeMutationFactory.createMutation(LightgBee, WhityBee, getTemplate(), 20);
        }
    },
    PINKY(BeeBranches.COLOUR, "Pinky", false, new Color(0xD08499), new Color(0xeeeeee)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(new ItemStack(Items.DYE, 1,9), 0.35f)
                    .addProduct(new ItemStack(Items.DYE, 1,9), 0.20f)
                    .setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.NORMAL);
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
        }

        @Override
        protected void registerMutations() {
            BeeManager.beeMutationFactory.createMutation(GraynyBee, WhityBee, getTemplate(), 20);
        }
    },
    LIMY(BeeBranches.COLOUR, "Limy", false, new Color(0x41AE38), new Color(0xeeeeee)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(new ItemStack(Items.DYE, 1,10), 0.35f)
                    .addProduct(new ItemStack(Items.DYE, 1,10), 0.20f)
                    .setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.NORMAL);
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
        }

        @Override
        protected void registerMutations() {
            BeeManager.beeMutationFactory.createMutation(PinkyBee, WhityBee, getTemplate(), 20);
        }
    },
    YELLOWY(BeeBranches.COLOUR, "Yellowy", false, new Color(0xB1A627), new Color(0xeeeeee)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(new ItemStack(Items.DYE, 1,11), 0.35f)
                    .addProduct(new ItemStack(Items.DYE, 1,11), 0.20f)
                    .setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.NORMAL);
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
        }

        @Override
        protected void registerMutations() {
            BeeManager.beeMutationFactory.createMutation(LimyBee, WhityBee, getTemplate(), 20);
        }
    },
    LIGHTB(BeeBranches.COLOUR, "Lightb", false, new Color(0x6B8AC9), new Color(0xeeeeee)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(new ItemStack(Items.DYE, 1,12), 0.35f)
                    .addProduct(new ItemStack(Items.DYE, 1,12), 0.20f)
                    .setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.NORMAL);
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
        }

        @Override
        protected void registerMutations() {
            BeeManager.beeMutationFactory.createMutation(YellowyBee, WhityBee, getTemplate(), 20);
        }
    },
    MAGENTY(BeeBranches.COLOUR, "Magenty", false, new Color(0xB350BC), new Color(0xeeeeee)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(new ItemStack(Items.DYE, 1,13), 0.35f)
                    .addProduct(new ItemStack(Items.DYE, 1,13), 0.20f)
                    .setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.NORMAL);
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
        }

        @Override
        protected void registerMutations() {
            BeeManager.beeMutationFactory.createMutation(LightbBee, WhityBee, getTemplate(), 20);
        }
    },
    ORANGY(BeeBranches.COLOUR, "Orangy", false, new Color(0xDB7D3E), new Color(0xeeeeee)) {
        @Override
        protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
            beeSpecies.addProduct(new ItemStack(Items.DYE, 1,14), 0.35f)
                    .addProduct(new ItemStack(Items.DYE, 1,14), 0.20f)
                    .setTemperature(EnumTemperature.NORMAL).setHumidity(EnumHumidity.NORMAL);
        }

        @Override
        protected void setAlleles(IAllele[] template) {
            AlleleHelper.instance.set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
        }

        @Override
        protected void registerMutations() {
            BeeManager.beeMutationFactory.createMutation(MagentyBee, WhityBee, getTemplate(), 20);
        }
    };


    // forestry bees
    private static final IAlleleBeeSpecies[] hiveBees = {
            (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele("forestry.speciesForest"),
            (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele("forestry.speciesMarshy"),
            (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele("forestry.speciesMeadows"),
            (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele("forestry.speciesModest"),
            (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele("forestry.speciesTropical"),
            (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele("forestry.speciesWintry")};
    private static IAlleleBeeSpecies SteadfastBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele("forestry.speciesSteadfast");
    private static IAlleleBeeSpecies CultivatedBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele("forestry.speciesCultivated");
    private static IAlleleBeeSpecies FiendishBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele("forestry.speciesFiendish");
    private static IAlleleBeeSpecies IndustriousBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele("forestry.speciesIndustrious");
    private static IAlleleBeeSpecies ImperialBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele("forestry.speciesImperial");
    private static IAlleleBeeSpecies AustereBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele("forestry.speciesAustere");
    private static IAlleleBeeSpecies DemonicBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele("forestry.speciesDemonic");
    private static IAlleleBeeSpecies EnderBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele("forestry.speciesEnded");
    private static IAlleleBeeSpecies BoggyBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele("forestry.speciesBoggy");
    private static IAlleleBeeSpecies DiligentBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele("forestry.speciesDiligent");
    private static IAlleleBeeSpecies TropicalBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele("forestry.speciesTropical");

    // moreBees Bees
    private static IAlleleBeeSpecies RockBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele(MoreBees.MOD_ID + ".speciesRock");
    private static IAlleleBeeSpecies HardenedBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele(MoreBees.MOD_ID + ".speciesHardened");
    private static IAlleleBeeSpecies ObsidianBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele(MoreBees.MOD_ID + ".speciesObsidian");
    private static IAlleleBeeSpecies LapisBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele(MoreBees.MOD_ID + ".speciesLapis");
    private static IAlleleBeeSpecies RedstoneBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele(MoreBees.MOD_ID + ".speciesRedstone");
    private static IAlleleBeeSpecies EmeraldBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele(MoreBees.MOD_ID + ".speciesEmerald");
    private static IAlleleBeeSpecies DirtBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele(MoreBees.MOD_ID + ".speciesDirt");
    private static IAlleleBeeSpecies ClayBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele(MoreBees.MOD_ID + ".speciesClay");
    private static IAlleleBeeSpecies MetallicBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele(MoreBees.MOD_ID + ".speciesMetallic");
    private static IAlleleBeeSpecies LeadBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele(MoreBees.MOD_ID + ".speciesLead");
    private static IAlleleBeeSpecies GoldBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele(MoreBees.MOD_ID + ".speciesGold");
    private static IAlleleBeeSpecies TinBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele(MoreBees.MOD_ID + ".speciesTin");
    private static IAlleleBeeSpecies RadioactiveBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele(MoreBees.MOD_ID + ".speciesRadioactive");
    private static IAlleleBeeSpecies UraniumBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele(MoreBees.MOD_ID + ".speciesUranium");
    private static IAlleleBeeSpecies ApocalypticBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele(MoreBees.MOD_ID + ".speciesApocalyptic");
    private static IAlleleBeeSpecies WitherBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele(MoreBees.MOD_ID + ".speciesWither");
    private static IAlleleBeeSpecies SlimeyBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele(MoreBees.MOD_ID + ".speciesSlimey");
    private static IAlleleBeeSpecies BlueSlimeyBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele(MoreBees.MOD_ID + ".speciesBlueslimey");
    private static IAlleleBeeSpecies PrismarineBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele(MoreBees.MOD_ID + ".speciesPrismarine");
    private static IAlleleBeeSpecies CopperBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele(MoreBees.MOD_ID + ".speciesCopper");
    private static IAlleleBeeSpecies EnderyBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele(MoreBees.MOD_ID + ".speciesEndery");
    private static IAlleleBeeSpecies EnderieBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele(MoreBees.MOD_ID + ".speciesEnderie");

    private static IAlleleBeeSpecies WhityBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele(MoreBees.MOD_ID + ".speciesWhity");
    private static IAlleleBeeSpecies BlackyBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele(MoreBees.MOD_ID + ".speciesBlacky");
    private static IAlleleBeeSpecies RedyBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele(MoreBees.MOD_ID + ".speciesRedy");
    private static IAlleleBeeSpecies GreenyBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele(MoreBees.MOD_ID + ".speciesGreeny");
    private static IAlleleBeeSpecies BrownyBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele(MoreBees.MOD_ID + ".speciesBrowny");
    private static IAlleleBeeSpecies PurplyBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele(MoreBees.MOD_ID + ".speciesPurply");
    private static IAlleleBeeSpecies CyanyBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele(MoreBees.MOD_ID + ".speciesCyany");

    private static IAlleleBeeSpecies LightgBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele(MoreBees.MOD_ID + ".speciesLightg");

    private static IAlleleBeeSpecies GraynyBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele(MoreBees.MOD_ID + ".speciesGrayny");
    private static IAlleleBeeSpecies PinkyBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele(MoreBees.MOD_ID + ".speciesPinky");
    private static IAlleleBeeSpecies LimyBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele(MoreBees.MOD_ID + ".speciesLimy");
    private static IAlleleBeeSpecies YellowyBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele(MoreBees.MOD_ID + ".speciesYellowy");
    private static IAlleleBeeSpecies LightbBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele(MoreBees.MOD_ID + ".speciesLightb");
    private static IAlleleBeeSpecies MagentyBee = (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele(MoreBees.MOD_ID + ".speciesMagenty");


    private final IBranchDefinition branch;
    private final IAlleleBeeSpecies species;

    private IAllele[] template;
    private IBeeGenome genome;

    BeeSpecies(IBranchDefinition branch, String binomial, boolean dominant, Color primary, Color secondary) {
        String lowercaseName = this.toString().toLowerCase(Locale.ENGLISH);
        String species = "species" + WordUtils.capitalize(lowercaseName);

        String ID = MoreBees.MOD_ID + '.' + species;
        String description = MoreBees.MOD_ID + ".description." + species;
        String name = "for.bees.species." + lowercaseName;

        this.branch = branch;
        IAlleleBeeSpeciesBuilder speciesBuilder = BeeManager.beeFactory.createSpecies(ID, dominant, "Lach_01298", name, description, branch.getBranch(), binomial, primary.getRGB(), secondary.getRGB());
        if (isSecret()) {
            speciesBuilder.setIsSecret();
        }
        setSpeciesProperties(speciesBuilder);
        this.species = speciesBuilder.build();
    }

    protected abstract void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies);

    protected abstract void setAlleles(IAllele[] template);

    protected abstract void registerMutations();

    protected boolean isSecret() {
        return false;
    }

    public static void initBees() {
        for (BeeSpecies bee : values()) {
            switch (bee) {
                // addon bees
                case LEAD:
                    if (LoadMods.enableLead) {
                        bee.init();
                    }
                    break;
                case SILVER:
                    if (LoadMods.enableSilver) {
                        bee.init();
                    }
                    break;
                case RADIOACTIVE:
                    if (LoadMods.enableUranium) {
                        bee.init();
                    }
                    break;
                case URANIUM:
                    if (LoadMods.enableIC2) {
                        bee.init();
                    }
                    break;
                case ALUMINIUM:
                    if (LoadMods.enableAluminium) {
                        bee.init();
                    }
                    break;
                case RUBY:
                    if (LoadMods.enableRuby) {
                        bee.init();
                    }
                    break;
                case SAPPHIRE:
                    if (LoadMods.enableSapphire) {
                        bee.init();
                    }
                    break;
                case SULFUR:
                    if (LoadMods.enableSulfur) {
                        bee.init();
                    }
                    break;
                case COBALT:
                    if (LoadMods.enableTinkers) {
                        bee.init();
                    }
                    break;

                case ARDITE:
                    if (LoadMods.enableTinkers) {
                        bee.init();
                    }
                    break;
                case BLUESLIMEY:
                    if (LoadMods.enableTinkers) {
                        bee.init();
                    }
                    break;
                case MAGMASLIMEY:
                    if (LoadMods.enableTinkers) {
                        bee.init();
                    }
                    break;
                case PURPLESLIMEY:
                    if (LoadMods.enableTinkers) {
                        bee.init();
                    }
                    break;

                default:
                    bee.init();
            }
        }
        for (BeeSpecies bee : values()) {
            switch (bee) {
                // addon bees
                case LEAD:
                    if (LoadMods.enableLead) {
                        bee.registerMutations();
                    }
                    break;
                case SILVER:
                    if (LoadMods.enableSilver) {
                        bee.registerMutations();
                    }
                    break;
                case RADIOACTIVE:
                    if (LoadMods.enableUranium) {
                        bee.registerMutations();
                    }
                    break;
                case URANIUM:
                    if (LoadMods.enableIC2) {
                        bee.registerMutations();
                    }
                    break;
                case ALUMINIUM:
                    if (LoadMods.enableAluminium) {
                        bee.registerMutations();
                    }
                    break;
                case RUBY:
                    if (LoadMods.enableRuby) {
                        bee.registerMutations();
                    }
                    break;
                case SAPPHIRE:
                    if (LoadMods.enableSapphire) {
                        bee.registerMutations();
                    }
                    break;
                case SULFUR:
                    if (LoadMods.enableSulfur) {
                        bee.registerMutations();
                    }
                    break;
                case COBALT:
                    if (LoadMods.enableTinkers) {
                        bee.registerMutations();
                    }
                    break;

                case ARDITE:
                    if (LoadMods.enableTinkers) {
                        bee.registerMutations();
                    }
                    break;
                case BLUESLIMEY:
                    if (LoadMods.enableTinkers) {
                        bee.registerMutations();
                    }
                    break;
                case MAGMASLIMEY:
                    if (LoadMods.enableTinkers) {
                        bee.registerMutations();
                    }
                    break;
                case PURPLESLIMEY:
                    if (LoadMods.enableTinkers) {
                        bee.registerMutations();
                    }
                    break;
                default:
                    bee.registerMutations();
            }

        }
    }

    public static void preInit() {

    }

    private void init() {
        template = branch.getTemplate();
        AlleleHelper.instance.set(template, EnumBeeChromosome.SPECIES, species);
        setAlleles(template);

        genome = BeeManager.beeRoot.templateAsGenome(template);

        BeeManager.beeRoot.registerTemplate(template);
    }

    @Override
    public final IAllele[] getTemplate() {
        return Arrays.copyOf(template, template.length);
    }

    @Override
    public final IBeeGenome getGenome() {
        return genome;
    }

    @Override
    public final IBee getIndividual() {
        return new Bee(genome);
    }

    @Override
    public final ItemStack getMemberStack(EnumBeeType beeType) {
        IBee bee = getIndividual();
        return BeeManager.beeRoot.getMemberStack(bee, beeType);
    }

    public final IBeeDefinition getRainResist() {
        return new BeeVariation.RainResist(this);
    }
}
