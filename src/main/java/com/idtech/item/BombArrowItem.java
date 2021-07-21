package com.idtech.item;

import com.idtech.entity.projectile.BombArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BombArrowItem extends ArrowItem {

    //typical item setup
    private static Properties properties = new Properties().group(ItemGroup.COMBAT);
    public static Item INSTANCE = new BombArrowItem(properties).setRegistryName("bombarrow");;

    //constructor
    public BombArrowItem(Properties properties){
        super(properties);
    }

    //this function is called when the arrow impacts an entity or surface
    //this is where a custom effect can be added
    //onEntityHit can also be used but will only trigger on mobs
    @Override
    public AbstractArrowEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
        BombArrowEntity arrowentity = new BombArrowEntity(worldIn, shooter);
        return arrowentity;
    }
}
