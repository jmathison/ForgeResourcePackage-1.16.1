package com.idtech.item;

import com.idtech.BaseMod;
import net.minecraft.item.Food;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ItemMod {

    //foods
    public static Food yummyFood = (new Food.Builder()).hunger(5).saturation(1.4f).effect(new EffectInstance(Effects.SPEED, 400, 1), 1.0F).setAlwaysEdible().build();
    public static Item yummyFoodItem = ItemUtils.buildFoodItem("yummyfood", yummyFood);

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

        // Basic Items
        event.getRegistry().register(BasicItems.STRUCTURE_GEL);
        event.getRegistry().register(BasicItems.GEL_ORE);

        // Regular items
        event.getRegistry().register(FireWandItem.INSTANCE);
        event.getRegistry().register(LightningHammerItem.INSTANCE);
        event.getRegistry().register(TeleportRodItem.INSTANCE);
        event.getRegistry().register(ZooSwordItem.INSTANCE);
        event.getRegistry().register(SheepMagicWand.INSTANCE);
        event.getRegistry().register(SqueakyBallItem.INSTANCE);

        // Tools
        event.getRegistry().register(GelAxeItem.INSTANCE);
        event.getRegistry().register(GelHoeItem.INSTANCE);
        event.getRegistry().register(GelPickaxeItem.INSTANCE);
        event.getRegistry().register(GelShovelItem.INSTANCE);
        event.getRegistry().register(GelSwordItem.INSTANCE);

        // Food
        event.getRegistry().register(yummyFoodItem);

        // Armor
        event.getRegistry().register(CustomArmorItem.HELM);
//        event.getRegistry().register(CustomArmorItem.CHEST);
//        event.getRegistry().register(CustomArmorItem.LEGS);
//        event.getRegistry().register(CustomArmorItem.BOOTS);

    }
}
