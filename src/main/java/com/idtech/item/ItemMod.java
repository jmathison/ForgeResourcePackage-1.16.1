package com.idtech.item;

import com.idtech.BaseMod;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ItemMod {


//    public static final Item structureGel = ItemUtils.buildBasicItem("structuregel", ItemGroup.MISC);
//    public static final Item gelOre = ItemUtils.buildBasicItem("gelore", ItemGroup.MISC);

    public static IItemTier tier = ItemUtils.buildItemTier(3, 1561, 8.0F, 3.0F, 10, "examplemod:gelore");
    //static instance for registration
    public static Item gelAxe = new GelAxeItem(tier,50, 100, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(BaseMod.MODID,"gelaxe");
    public static Item gelHoe = new GelHoeItem(tier,50, 100, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(BaseMod.MODID,"gelhoe");
    public static Item gelShovel = new GelShovelItem(tier,50, 100, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(BaseMod.MODID,"gelshovel");
    public static Item gelPickaxe = new GelPickaxeItem(tier,50, 100, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(BaseMod.MODID,"gelpickaxe");
    public static Item gelSword = new GelSwordItem(tier,50, 100, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(BaseMod.MODID,"gelsword");


    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        // Register Items
//        event.getRegistry().register(structureGel);
//        event.getRegistry().register(gelOre);

        event.getRegistry().register(gelAxe);
        event.getRegistry().register(gelHoe);
        event.getRegistry().register(gelShovel);
        event.getRegistry().register(gelPickaxe);
        event.getRegistry().register(gelSword);

    }
}
