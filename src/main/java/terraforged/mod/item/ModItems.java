package terraforged.mod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import terraforged.mod.Terraforged;
import terraforged.mod.entity.ModEntities;

import java.util.Map;
import java.util.function.Function;

public class ModItems {
    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Terraforged.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }



    //    Items
    public static final Item SPEAR = register("spear", Item::new, new Item.Settings());
    public static final Item GlareSpawnEgg= register("glare_spawn_egg", settings -> new SpawnEggItem(ModEntities.GLARE, settings), new Item.Settings());
    //    public static final RegistryKey<EquipmentAsset> SCUTE_ARMOR_MATERIAL_KEY = RegistryKey.of(
//            EquipmentAssetKeys.REGISTRY_KEY,
//            Identifier.of(Terraforged.MOD_ID, "scute")
//    );
//
//    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
//            10,
//            Map.of(
//                    EquipmentType.HELMET, 3,
//                    EquipmentType.CHESTPLATE, 8,
//                    EquipmentType.LEGGINGS, 6,
//                    EquipmentType.BOOTS, 3
//            ),
//            5,
//            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
//            0.0F,
//            0.0F,
//            REPAIRS_SCUTE_ARMOR,
//            SCUTE_ARMOR_MATERIAL_KEY
//    );
//
//    public static final Item ARMADILO_SCUTE_HELMET = register(
//            "armadilo_scute_helmet",
//            settings -> new ArmorItem(ScuteArmorMaterial.INSTANCE, EquipmentType.HELMET, settings),
//            new Item.Settings().maxDamage(EquipmentType.HELMET.getMaxDamage(ScuteArmorMaterial.BASE_DURABILITY))
//    );
//
//    public static final Item ARMADILO_SCUTE_CHESTPLATE = register(
//            "armadilo_scute_chestplate",
//            settings -> new ArmorItem(ScuteArmorMaterial.INSTANCE, EquipmentType.CHESTPLATE, settings),
//            new Item.Settings().maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(ScuteArmorMaterial.BASE_DURABILITY))
//    );
//
//    public static final Item ARMADILO_SCUTE_LEGGINGS = register(
//            "armadilo_scute_leggings",
//            settings -> new ArmorItem(ScuteArmorMaterial.INSTANCE, EquipmentType.LEGGINGS, settings),
//            new Item.Settings().maxDamage(EquipmentType.LEGGINGS.getMaxDamage(ScuteArmorMaterial.BASE_DURABILITY))
//    );
//
//    public static final Item ARMADILO_SCUTE_BOOTS = register(
//            "armadilo_scute_boots",
//            settings -> new ArmorItem(ScuteArmorMaterial.INSTANCE, EquipmentType.BOOTS, settings),
//            new Item.Settings().maxDamage(EquipmentType.BOOTS.getMaxDamage(ScuteArmorMaterial.BASE_DURABILITY))
//    );


    // Get the event for modifying entries in the ingredients group.
    // And register an event handler that adds our suspicious item to the ingredients group.
    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register((itemGroup) -> itemGroup.add(ModItems.SPEAR));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS)
                .register((itemGroup) -> itemGroup.add(ModItems.GlareSpawnEgg));
    }


}
