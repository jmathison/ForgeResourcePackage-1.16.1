package com.idtech.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;


public class SkyStrikeEnchantment extends Enchantment {

    // Set up Enchantment Instance
    public static Enchantment INSTANCE = new SkyStrikeEnchantment(Rarity.RARE, EquipmentSlotType.MAINHAND).setRegistryName("sky_strike");;

    // Constructor
    protected SkyStrikeEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
        super(rarityIn, EnchantmentType.WEAPON, slots);
    }

    /**
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
    public int getMinEnchantability(int enchantmentLevel) {
        return 1 + 10 * (enchantmentLevel - 1);
    }
    public int getMaxEnchantability(int enchantmentLevel) {
        return super.getMinEnchantability(enchantmentLevel) + 50;
    }
    // Above are the minimum and maximum enchantibility levels needed on a weapon to enchant an item with Sky Strike enchantment
    // This currently works similar to the enchantability levels of efficiency, based on the current enchantment level of the player

    /**
     * Returns the maximum level that the enchantment can have.
     */
    public int getMaxLevel() {
        return 3;
    }

    /**
     * Called whenever a mob is damaged with an item that has this enchantment on it.
     */
    public void onEntityDamaged(LivingEntity user, Entity target, int level) {
        // When a weapon with this enchantment is used to hit a mob, it will shoot the mob up into the air and give it slow falling
        if (target instanceof LivingEntity) {
            LivingEntity livingentity = (LivingEntity)target;

            // Shoot the mob into the air - a higher level enchantment will have the mob go higher (at random distances)
            int i = 1 + user.getRNG().nextInt(level);
            livingentity.addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, 40, 3));
            livingentity.setVelocity(0, i, 0);

        }

    }
}
