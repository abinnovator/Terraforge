package terraforged.mod.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import terraforged.mod.Terraforged;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;

public class ModBiomes {

    // Create biome key
    public static final RegistryKey<Biome> DENSE_JUNGLE = RegistryKey.of(
            RegistryKeys.BIOME,
             Identifier.of(Terraforged.MOD_ID, "dense_jungle")
    );

    // Runtime bootstrap (used when Minecraft loads)
    public static void bootstrap(Registerable<Biome> context) {
        context.register(DENSE_JUNGLE, createDenseJungle());
    }

    // Datagen bootstrap (used by TerraforgedDataGenerator)
    public static void bootstrapDatagen(FabricDynamicRegistryProvider.Entries entries) {
        entries.add(DENSE_JUNGLE, createDenseJungle());
    }

    // Create the actual biome object
    private static Biome createDenseJungle() {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        GenerationSettings.Builder generationBuilder = new GenerationSettings.Builder();

        return new Biome.Builder()
                .precipitation(true)
                .temperature(0.95f)
                .downfall(0.9f)
                .effects(new BiomeEffects.Builder()
                        .skyColor(7842047)
                        .fogColor(12638463)
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .build())
                .spawnSettings(spawnBuilder.build())
                .generationSettings(generationBuilder.build())
                .build();
    }

    // Debug / logging hook
    public static void registerBiomes() {
        Terraforged.LOGGER.info("Registering Biomes for " + Terraforged.MOD_ID);
    }
}
