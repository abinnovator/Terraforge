package terraforged.mod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import terraforged.mod.Terraforged;
import terraforged.mod.entity.custom.GlareEntity;

public class ModEntities {
    public static final RegistryKey<EntityType<?>> GLARE_KEY = RegistryKey.of(
            RegistryKey.ofRegistry(Identifier.of("minecraft", "entity_type")),
            Identifier.of(Terraforged.MOD_ID, "glare")
    );


    // THE FIX: Used FabricEntityTypeBuilder, corrected the ID, and adjusted dimensions.
    public static final EntityType<GlareEntity> GLARE = Registry.register(
            Registries.ENTITY_TYPE, // or Registry.ENTITY_TYPE in older versions
            GLARE_KEY.getValue(),   // This gets the Identifier
            // The EntityType instance you've built:
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, GlareEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f))
                    .build(GLARE_KEY)
    );

    // THE FIX: Corrected the typo from "registerModeEntities"
    public static void registerModEntities() {
        Terraforged.LOGGER.info("Registering Mod Entities for " + Terraforged.MOD_ID);
    }
}



//package terraforged.mod.entity;
//
//import net.minecraft.entity.EntityType;
//import net.minecraft.entity.SpawnGroup;
//import net.minecraft.registry.Registries;
//import net.minecraft.registry.Registry;
//import net.minecraft.util.Identifier;
//
//import terraforged.mod.Terraforged;
//import terraforged.mod.entity.custom.GlareEntity;
//
//public class ModEntities {
//        public static final EntityType<GlareEntity> GLARE = Registry.register(Registries.ENTITY_TYPE,
//                Identifier.of(Terraforged.MOD_ID, "mantis"),
//                EntityType.Builder.create(GlareEntity::new, SpawnGroup.CREATURE)
//                        .dimensions(1f, 2.5f).build());
//
//
//    public static void registerModeEntities() {
//        Terraforged.LOGGER.info("Registering Mod Entities");
//    }
//}
