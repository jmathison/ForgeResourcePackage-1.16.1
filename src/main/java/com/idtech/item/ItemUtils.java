package com.idtech.item;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.LazyValue;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

/**
 * Utilities for creating new items and doing things with items
 */
public class ItemUtils {

    /**
     * Build a basic item with no added functionality. Useful for crafting materials, drops, ingots, currency, anything
     * that doesn't need extra code.
     * @param name Item registry name. All lowercase, no spaces. e.g. "meteor_ingot"
     * @param group Item group (creative tab) the item will appear in.
     * @return The built item.
     */
    public static Item buildBasicItem(String name, ItemGroup group){
        return new Item(new Item.Properties().group(group)).setRegistryName(name);
    }

    /**
     * Create a new item tier (tool material). Used for new tool sets that use custom materials.
     * @param harvestLevelIn harvest level of tool, controls how high level of block the tool type can harvest.
     * @param maxUsesIn Durability of tools with this item tier.
     * @param efficiencyIn Harvest speed of tools with this tier.
     * @param attackDamageIn Damage dealt by weapons with this tier.
     * @param enchantabilityIn Enchantability of tools with this tier.
     * @param repairIngredientName A registry name of the ingredient needed to repair this tool e.g. "minecraft:stick"
     *                             or "examplemod:meteor_ingot".
     * @return The built item tier.
     */
    public static IItemTier buildItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, String repairIngredientName){
        Supplier<Ingredient> ingredientSupplier = ()-> Ingredient.fromItems(ForgeRegistries.ITEMS.getValue(new ResourceLocation(repairIngredientName)));
        return buildItemTier(harvestLevelIn, maxUsesIn, efficiencyIn, attackDamageIn, enchantabilityIn, ingredientSupplier);
    }

    /**
     * Alternate method to create an item tier that uses Item Tags instead of a single repair ingredient.
     * Create a new item tier (tool material). Used for new tool sets that use custom materials.
     * @param harvestLevelIn harvest level of tool, controls how high level of block the tool type can harvest.
     * @param maxUsesIn Durability of tools with this item tier.
     * @param efficiencyIn Harvest speed of tools with this tier.
     * @param attackDamageIn Damage dealt by weapons with this tier.
     * @param enchantabilityIn Enchantability of tools with this.
     * @param itemTag an Item Tag indicating a group or type of item that can repair this tool material.
     * @return The built item tier.
     */
    public static IItemTier buildItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Tag<Item> itemTag){
        Supplier<Ingredient> ingredientSupplier = () -> Ingredient.fromTag(itemTag);
        return buildItemTier(harvestLevelIn, maxUsesIn, efficiencyIn, attackDamageIn, enchantabilityIn, ingredientSupplier);
    }

    private static IItemTier buildItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> ingredientSupplierIn){

        return new IItemTier() {
            final int harvestLevel = harvestLevelIn;
            final int maxUses = maxUsesIn;
            final float efficiency = efficiencyIn;
            final float attackDamage = attackDamageIn;
            final int enchantability = enchantabilityIn;
            final LazyValue<Ingredient> repairMaterial = new LazyValue<>(ingredientSupplierIn);

            @Override
            public int getMaxUses() {
                return maxUses;
            }

            @Override
            public float getEfficiency() {
                return efficiency;
            }

            @Override
            public float getAttackDamage() {
                return attackDamage;
            }

            @Override
            public int getHarvestLevel() {
                return harvestLevel;
            }

            @Override
            public int getEnchantability() {
                return enchantability;
            }

            @Override
            public Ingredient getRepairMaterial() {
                return this.repairMaterial.getValue();
            }
        };

    }


}
