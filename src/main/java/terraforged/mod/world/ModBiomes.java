package terraforged.mod.world;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import terraforged.mod.Terraforged;

public class ModBiomes {
    // This creates a "key" that we can use to refer to our biome
    public static final RegistryKey<Biome> DENSE_JUNGLE = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(Terraforged.MOD_ID, "dense_jungle"));

    public static void registerBiomes() {
        Terraforged.LOGGER.info("Registering Biomes for " + Terraforged.MOD_ID);
    }
}