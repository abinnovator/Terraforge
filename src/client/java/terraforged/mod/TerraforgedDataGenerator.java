package terraforged.mod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.biome.Biome;
import terraforged.mod.world.ModBiomes;

public class TerraforgedDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {


        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        // This will hook your biome bootstrap into the generator
        pack.addProvider((output, registriesFuture) ->
                new FabricDynamicRegistryProvider(output, registriesFuture) {
                    @Override
                    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
                        ModBiomes.bootstrapDatagen(entries); // <-- datagen version
                    }

                    @Override
                    public String getName() {
                        return "Terraforged Biomes";
                    }
                });

    }
}
