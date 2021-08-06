package com.idtech.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class IceAspectEnchantment extends Enchantment {

    // Set up Enchantment Instance
    public static Enchantment INSTANCE = new IceAspectEnchantment(Rarity.VERY_RARE, EquipmentSlotType.MAINHAND).setRegistryName("ice_aspect");;

    // Constructor
    protected IceAspectEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
        super(rarityIn, EnchantmentType.WEAPON, slots);
    }

    /**
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
    public int getMinEnchantability(int enchantmentLevel) {
        return 10 + 20 * (enchantmentLevel - 1);
    }
    public int getMaxEnchantability(int enchantmentLevel) {
        return super.getMinEnchantability(enchantmentLevel) + 50;
    }
    // Above are the minimum and maximum enchantibility levels needed on a weapon to enchant an item with Ice Aspect enchantment
    // This currently works similar to the enchantability levels of efficiency, based on the current enchantment level of the player

    /**
     * Returns the maximum level that the enchantment can have.
     */
    public int getMaxLevel() {
        return 2;
    }

    /**
     * Called whenever a mob is damaged with an item that has this enchantment on it.
     */
    public void onEntityDamaged(LivingEntity user, Entity target, int level) {
        // When a weapon with this enchantment is used to hit a mob, it will give the mob slowness ("freezing" the mob)
        if (target instanceof LivingEntity) {
            LivingEntity livingentity = (LivingEntity)target;

            // Give the mob the Slowness effect (higher level enchantments give longer durations)
            int i = level * 100;
            livingentity.addPotionEffect(new EffectInstance(Effects.SLOWNESS, i, 4));

        }

    }

}
