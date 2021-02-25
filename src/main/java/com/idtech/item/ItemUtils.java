package com.idtech.item;

import com.idtech.BaseMod;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.Tag;
import net.minecraft.util.LazyValue;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

/**
 * Utilities for creating new item and doing things with item
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
        return new Item(new Item.Properties().group(group)).setRegistryName(BaseMod.MODID, name);
    }

    /**
     * Create a new food item to register a food and have it appear in the game
     * @param name the name of the food item for registry and textures
     * @param food the food item itself.
     * @return
     */
    public static Item buildFoodItem(String name, Food food){
        return new Item(new Item.Properties().group(ItemGroup.FOOD).food(food)).setRegistryName(BaseMod.MODID, name);
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

    /**
     *  Create a new armor material. Used for new armor sets that use custom materials.
     * @param nameIn the name of the material, can be whatever.
     * @param maxDamageFactorIn Multiplier for durability.
     * @param damageReductionAmountArrayIn Defense points for each armor slot.
     * @param enchantabilityIn Enchantability of armor with the item.
     * @param eqiupSoundIn Sound for equipping the armor.
     * @param toughnessIn How long it takes until the armor breaks.
     * @param knockbackResistanceIn A value for knockback resistance of the armor.
     * @param repairIngredientName A registry name of the ingredient needed to repair this tool e.g. "minecraft:stick"
     *      *                       or "examplemod:meteor_ingot".
     * @return the built Armor Material
     */
    public static IArmorMaterial buildArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountArrayIn, int enchantabilityIn, SoundEvent eqiupSoundIn,
                                                    float toughnessIn, float knockbackResistanceIn, String repairIngredientName){
        Supplier<Ingredient> ingredientSupplier = ()-> Ingredient.fromItems(ForgeRegistries.ITEMS.getValue(new ResourceLocation(repairIngredientName)));
        return buildArmorMaterial(nameIn, maxDamageFactorIn, damageReductionAmountArrayIn, enchantabilityIn, eqiupSoundIn, toughnessIn, knockbackResistanceIn, ingredientSupplier);

    }

    /**
     *  Alternate method to create an armor material that uses Item Tags instead of a single repair ingredient.
     *  Create a new armor material. Used for new armor sets that use custom materials.
     * @param nameIn the name of the material, can be whatever.
     * @param maxDamageFactorIn Multiplier for durability.
     * @param damageReductionAmountArrayIn Defense points for each armor slot.
     * @param enchantabilityIn Enchantability of armor with the item.
     * @param eqiupSoundIn Sound for equipping the armor.
     * @param toughnessIn How long it takes until the armor breaks.
     * @param knockbackResistanceIn A value for knockback resistance of the armor.
     * @param itemTag an Item Tag indicating a group or type of item that can repair this armor material.
     * @return the built Armor Material
     */
    public static IArmorMaterial buildArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountArrayIn, int enchantabilityIn, SoundEvent eqiupSoundIn,
                                                    float toughnessIn, float knockbackResistanceIn, Tag<Item> itemTag){
        Supplier<Ingredient> ingredientSupplier = () -> Ingredient.fromTag(itemTag);
        return buildArmorMaterial(nameIn, maxDamageFactorIn, damageReductionAmountArrayIn, enchantabilityIn, eqiupSoundIn, toughnessIn, knockbackResistanceIn, ingredientSupplier);

    }

    private static IArmorMaterial buildArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountArrayIn, int enchantabilityIn, SoundEvent eqiupSoundIn,
                                                     float toughnessIn, float knockbackResistanceIn, Supplier<Ingredient> repairIngredientIn) {

        final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};

        return new IArmorMaterial() {

            final String name = nameIn;
            final int maxDamageFactor = maxDamageFactorIn;
            final int[] damageReductionAmountArray = damageReductionAmountArrayIn;
            final int enchantability = enchantabilityIn;
            final SoundEvent soundEvent = eqiupSoundIn;
            final float toughness = toughnessIn;
            final float field_234660_o_ = knockbackResistanceIn;
            final LazyValue<Ingredient> repairMaterial = new LazyValue<>(repairIngredientIn);


        public int getDurability (EquipmentSlotType slotIn){
            return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
        }

        public int getDamageReductionAmount (EquipmentSlotType slotIn){
            return this.damageReductionAmountArray[slotIn.getIndex()];
        }

        public int getEnchantability () {
            return this.enchantability;
        }

        public SoundEvent getSoundEvent () {
            return this.soundEvent;
        }
        @Override
        public Ingredient getRepairMaterial () {
            return this.repairMaterial.getValue();
        }

        @Override
        public String getName () {
            return this.name;
        }
        @Override
        public float getToughness () {
            return this.toughness;
        }
        @Override
        public float func_230304_f_ () {
            return this.field_234660_o_;
        }
    };

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
