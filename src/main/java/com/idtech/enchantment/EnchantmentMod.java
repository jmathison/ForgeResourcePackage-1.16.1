package com.idtech.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EnchantmentMod {

    @SubscribeEvent
    public static void registerEnchantments(RegistryEvent.Register<Enchantment> event) {

        event.getRegistry().register(SkyStrikeEnchantment.INSTANCE);
        event.getRegistry().register(WitherTouchEnchantment.INSTANCE);
        event.getRegistry().register(IceAspectEnchantment.INSTANCE);

    }

}
