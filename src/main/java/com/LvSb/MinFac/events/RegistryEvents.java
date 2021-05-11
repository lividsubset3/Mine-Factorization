package com.LvSb.MinFac.events;

import com.LvSb.MinFac.Main;
import com.LvSb.MinFac.init.ModItemGroup;
import com.LvSb.MinFac.lists.BlockList;
import com.LvSb.MinFac.lists.ItemList;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryEvents {

    public static final Logger LOGGER = Main.LOGGER;
    public static final String MOD_ID = Main.MOD_ID;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                ItemList.new_egg = new Item(new Item.Properties()
                        .group(ModItemGroup.MOD_ITEM_GROUP))
                        .setRegistryName(location("new_egg")),

                ItemList.new_block = new BlockItem(BlockList.BLOCKS, new Item.Properties()
                        .group(ModItemGroup.MOD_ITEM_GROUP))
                        .setRegistryName(BlockList.BLOCKS.getRegistryName())
        );
    }

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                BlockList.BLOCKS = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.0F,1.0F)).setRegistryName("new_block")
        );
    }

    public static ResourceLocation location(String name) {
        return new ResourceLocation(MOD_ID, name);
    }
}
