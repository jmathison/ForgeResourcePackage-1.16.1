package com.idtech.block;

import com.idtech.item.ItemUtils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class BlockMod {

    //Basic Block

    public static final Block CASTLE_WALL = BlockUtils.createBasicBlock("castlewall", Material.ROCK, 0.5f, 0.9f, ToolType.PICKAXE);
    public static final Item CASTLE_WALL_ITEM = BlockUtils.createBlockItem(CASTLE_WALL, ItemGroup.MISC);


    @SubscribeEvent
    public static void registerBlockItems(RegistryEvent.Register<Item> event) {

        event.getRegistry().register(CASTLE_WALL_ITEM);

    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {

        event.getRegistry().register(CASTLE_WALL);


    }
}























