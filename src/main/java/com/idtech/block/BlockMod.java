package com.idtech.block;

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


    public static final Block GEL_ORE_BLOCK = BlockUtils.createBasicBlock("geloreblock", Material.ROCK, 0.5f, 0.6f, ToolType.PICKAXE);
    public static final Item GEL_ORE_BLOCK_ITEM = BlockUtils.createBlockItem(GEL_ORE_BLOCK, ItemGroup.MISC);


    @SubscribeEvent
    public static void registerBlockItems(RegistryEvent.Register<Item> event) {

        event.getRegistry().register(CASTLE_WALL_ITEM);
        event.getRegistry().register(GEL_ORE_BLOCK_ITEM);


        event.getRegistry().register(CoolStoneBlock.ITEM);
        event.getRegistry().register(RubberBlock.ITEM);
        event.getRegistry().register(CreeperSurpriseBlock.ITEM);
        event.getRegistry().register(CreepingMoldBlock.ITEM);
        event.getRegistry().register(HotCoalsBlock.ITEM);
        event.getRegistry().register(FunNewBlock.ITEM);
        event.getRegistry().register(DemoBlock.ITEM);
        event.getRegistry().register(NeatBlock.ITEM);
        event.getRegistry().register(RubberBlockCustomSound.ITEM);
        event.getRegistry().register(TNTCannonBlock.ITEM);


    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {

        event.getRegistry().register(CASTLE_WALL);
        event.getRegistry().register(GEL_ORE_BLOCK);


        event.getRegistry().register(CoolStoneBlock.INSTANCE);
        event.getRegistry().register(RubberBlock.INSTANCE);
        event.getRegistry().register(CreeperSurpriseBlock.INSTANCE);
        event.getRegistry().register(CreepingMoldBlock.INSTANCE);
        event.getRegistry().register(HotCoalsBlock.INSTANCE);
        event.getRegistry().register(FunNewBlock.INSTANCE);
        event.getRegistry().register(DemoBlock.INSTANCE);
        event.getRegistry().register(NeatBlock.INSTANCE);
        event.getRegistry().register(RubberBlockCustomSound.INSTANCE);
        event.getRegistry().register(TNTCannonBlock.INSTANCE);


    }
}
