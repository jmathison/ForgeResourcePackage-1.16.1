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

    //basic items
    public static final Item structureGel = ItemUtils.buildBasicItem("structuregel", ItemGroup.MISC);
    public static final Item gelOre = ItemUtils.buildBasicItem("gelore", ItemGroup.MISC);

    //tool tier
    public static IItemTier gel = ItemUtils.buildItemTier(3, 1561, 8.0F, 3.0F, 10, "examplemod:gelore");

    //tool instances
    public static Item gelAxe = new GelAxeItem(gel,50, 100, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(BaseMod.MODID,"gelaxe");
    public static Item gelHoe = new GelHoeItem(gel,50, 100, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(BaseMod.MODID,"gelhoe");
    public static Item gelShovel = new GelShovelItem(gel,50, 100, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(BaseMod.MODID,"gelshovel");
    public static Item gelPickaxe = new GelPickaxeItem(gel,50, 100, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(BaseMod.MODID,"gelpickaxe");
    public static Item gelSword = new GelSwordItem(gel,50, 100, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(BaseMod.MODID,"gelsword");

    //foods
    public static Food yummyFood = (new Food.Builder()).hunger(5).saturation(1.4f).effect(new EffectInstance(Effects.SPEED, 400, 1), 1.0F).setAlwaysEdible().build();
    public static Item yummyFoodItem = ItemUtils.buildFoodItem("yummyfood", yummyFood);

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

        // Basic Items
        event.getRegistry().register(structureGel);
        event.getRegistry().register(gelOre);

        // Regular items
        event.getRegistry().register(FireWandItem.INSTANCE);
        event.getRegistry().register(LightningHammerItem.INSTANCE);
        event.getRegistry().register(TeleportRodItem.INSTANCE);
        event.getRegistry().register(ZooSwordItem.INSTANCE);
        event.getRegistry().register(SheepMagicWand.INSTANCE);
        event.getRegistry().register(SqueakyBallItem.INSTANCE);

        // Tools
        event.getRegistry().register(gelAxe);
        event.getRegistry().register(gelHoe);
        event.getRegistry().register(gelShovel);
        event.getRegistry().register(gelPickaxe);
        event.getRegistry().register(gelSword);

        // Food
        event.getRegistry().register(yummyFoodItem);

        // Armor
        event.getRegistry().register(CustomArmorItem.HELM);
//        event.getRegistry().register(CustomArmorItem.CHEST);
//        event.getRegistry().register(CustomArmorItem.LEGS);
//        event.getRegistry().register(CustomArmorItem.BOOTS);

    }
}
