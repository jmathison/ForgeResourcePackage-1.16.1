package com.idtech.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.world.World;

/**
 * This is a custom food that drops another item when eaten
 */
public class CustomFood extends Item {
    public CustomFood(Properties p) {
        super(p);
    }

    private static Food customFood = (new Food.Builder()).hunger(5).saturation(1.5f).setAlwaysEdible().build();

    public static Item INSTANCE = new CustomFood(new Properties().group(ItemGroup.FOOD).food(customFood)).setRegistryName("customfood");

    /**
     * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using
     * the Item before the action is complete.
     *
     * @param stack
     * @param worldIn
     * @param entityLiving
     */
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        PlayerEntity player = (PlayerEntity) entityLiving;
        player.inventory.addItemStackToInventory(new ItemStack(Items.APPLE, 1));
        return stack;
    }
}
