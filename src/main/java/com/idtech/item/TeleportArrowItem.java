package com.idtech.item;

import com.idtech.BaseMod;
import com.idtech.entity.projectile.TeleportArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TeleportArrowItem extends ArrowItem {

    public static Item INSTANCE = new TeleportArrowItem(new Properties().group(ItemGroup.COMBAT)).setRegistryName(BaseMod.MODID,"teleportarrowitem");


    public TeleportArrowItem(Properties builder) {
        super(builder);
    }

    public AbstractArrowEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
        TeleportArrowEntity arrowentity = new TeleportArrowEntity(worldIn, shooter);

        return arrowentity;
    }




}
