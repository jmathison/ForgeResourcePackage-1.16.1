package com.idtech.item;

import com.idtech.entity.LightningArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class LightningArrowItem extends ArrowItem {
    private static Properties properties = new Properties().group(ItemGroup.MISC);
    public static Item INSTANCE = new LightningArrowItem(properties).setRegistryName("lightningarrow");;

    //constructor
    public LightningArrowItem(Properties properties){
        super(properties);
    }

    @Override
    public AbstractArrowEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
        LightningArrowEntity arrowentity = new LightningArrowEntity(worldIn, shooter);
        return arrowentity;
    }
}
