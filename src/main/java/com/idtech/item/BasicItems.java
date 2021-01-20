package com.idtech.item;

import com.idtech.item.ItemUtils;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class BasicItems {


    public static final Item structureGel = ItemUtils.buildBasicItem("structuregel", ItemGroup.MISC);
    public static final Item gelOre = ItemUtils.buildBasicItem("gelore", ItemGroup.MISC);


    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        // Register Items
        event.getRegistry().register(structureGel);
        event.getRegistry().register(gelOre);
    }


}
