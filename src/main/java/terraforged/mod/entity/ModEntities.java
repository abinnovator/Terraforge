package terraforged.mod.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import terraforged.mod.Terraforged;
import terraforged.mod.entity.custom.GlareEntity;

public class ModEntities {
        public static final EntityType<GlareEntity> GLARE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(Terraforged.MOD_ID, "glare"),EntityType.Builder.create(GlareEntity::new,
                    SpawnGroup.CREATURE).dimensions(1f,2.5f)
                    .build());

    public static void registerModeEntities() {
        Terraforged.LOGGER.info("Registering Mod Entities");
    }
}
