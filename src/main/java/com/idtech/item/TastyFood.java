package com.idtech.item;

import com.idtech.BaseMod;
import com.idtech.Utils;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class TastyFood extends Item{

    public static Food INSTANCE = (new Food.Builder()).hunger(5).saturation(1.4f).effect(new EffectInstance(Effects.HEALTH_BOOST, 500, 1), 1.0f).effect(new EffectInstance(Effects.SPEED, 400, 1), 1.0F).setAlwaysEdible().build();
    public static Item ITEM =  new TastyFood(new Properties().group(ItemGroup.FOOD).food(INSTANCE)).setRegistryName(BaseMod.MODID, "tastyfood");

    public TastyFood(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {


        Utils.playSound(worldIn, playerIn, SoundEvents.ENTITY_GENERIC_DRINK);

        return super.onItemRightClick(worldIn, playerIn, handIn);

    }

    @Override
    public SoundEvent getEatSound() {
        return null;
//        return SoundEvents.ENTITY_GENERIC_DRINK;
    }
}
