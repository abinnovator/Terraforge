package terraforged.mod.world;

import net.minecraft.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.PlacedFeatures;
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
        context.register(DENSE_JUNGLE, createDenseJungle(context));
    }

    // Datagen bootstrap (used by TerraforgedDataGenerator)
    public static void bootstrapDatagen(FabricDynamicRegistryProvider.Entries entries) {
        entries.add(DENSE_JUNGLE, createDenseJungle(null)); // datagen doesn’t have lookups, safe with null
    }

    // Create the actual biome object
    private static Biome createDenseJungle(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        // Use LookupBackedBuilder when available
        GenerationSettings.LookupBackedBuilder generationBuilder =
                context != null
                        ? new GenerationSettings.LookupBackedBuilder(
                        context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER)
                )
                        : new GenerationSettings.LookupBackedBuilder(null, null);

        // Worldgen features
        DefaultBiomeFeatures.addLandCarvers(generationBuilder);
        DefaultBiomeFeatures.addDefaultOres(generationBuilder);
        DefaultBiomeFeatures.addDefaultDisks(generationBuilder);

        // Vegetation (jungle-style)
        generationBuilder.feature(
                GenerationStep.Feature.VEGETAL_DECORATION,
                PlacedFeatures.of(String.valueOf(Identifier.of(Terraforged.MOD_ID, "misty_jungle_trees")))
        );
        DefaultBiomeFeatures.addBamboo(generationBuilder);
        DefaultBiomeFeatures.addDefaultFlowers(generationBuilder);

        // Mobs
        DefaultBiomeFeatures.addJungleMobs(spawnBuilder);

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
