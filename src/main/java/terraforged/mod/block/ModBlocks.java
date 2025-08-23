package terraforged.mod.block;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import terraforged.mod.Terraforged;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import java.util.function.Function;

public class ModBlocks {
    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        // Create a registry key for the block
        RegistryKey<Block> blockKey = keyOfBlock(name);
        // Create the block instance
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:moving_piston` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            // Items need to be registered with a different type of registry key, but the ID
            // can be the same.
            RegistryKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Terraforged.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Terraforged.MOD_ID, name));
    }
    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register((itemGroup) -> {
            itemGroup.add(ModBlocks.DENSE_MUD_BLOCK.asItem());
        });
    }
    public static final Block DENSE_MUD_BLOCK = register(
            "dense_mud_block",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.MUD),
            true
    );

}
//public class ModBlocks {
//    public static final Block DENSE_MUD_BLOCK = registerBlock(
//            "dense_mud_block",
//            new Block(AbstractBlock.Settings.create().strength(4f)
//                    .requiresTool().sounds(BlockSoundGroup.MUD)));
//
//
//    private static Block registerBlock(String name, Block block) {
//        registerBlockItem(name, block);
//        return Registry.register(Registries.BLOCK, Identifier.of(Terraforged.MOD_ID, name), block);
//    }
//
//    private static void registerBlockItem(String name, Block block) {
//        Registry.register(Registries.ITEM, Identifier.of(Terraforged.MOD_ID, name),
//                new BlockItem(block, new Item.Settings()));
//    }
//
//    public static void registerModBlocks() {
//        Terraforged.LOGGER.info("Registering Mod Blocks for " + Terraforged.MOD_ID);
//
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
//            entries.add(ModBlocks.DENSE_MUD_BLOCK);
//        });
//    }
//}



//package terraforged.mod.block;
//
//import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
//import net.minecraft.block.AbstractBlock;
//import net.minecraft.block.Block;
//import net.minecraft.item.BlockItem;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemGroups;
//import net.minecraft.registry.Registries;
//import net.minecraft.registry.Registry;
//import net.minecraft.sound.BlockSoundGroup;
//import net.minecraft.util.Identifier;
//import terraforged.mod.Terraforged;
//
//public class ModBlocks {
//    public static final Block DENSE_MUD_BLOCK = registerBlock("dense_mud_block", new Block(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.MUD)));
//
//
//    private static Block registerBlock(String name, Block block) {
//        registerBlockItem(name,block);
//        return Registry.register(Registries.BLOCK,Identifier.of(Terraforged.MOD_ID, name),block);
//    }
//    public static void  registerBlockItem(String name, Block block) {
//        Registry.register(Registries.ITEM, Identifier.of(Terraforged.MOD_ID, name), new BlockItem(block, new Item.Settings()));
//
//    }
//    public static void  registerModBlocks() {
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
//            entries.add(ModBlocks.DENSE_MUD_BLOCK);
//        });
//    }
//
//}