package terraforged.mod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import terraforged.mod.block.ModBlocks;
import terraforged.mod.entity.ModEntities;
import terraforged.mod.entity.custom.GlareEntity;
import terraforged.mod.item.ModItems;
import terraforged.mod.world.ModBiomes;

public class Terraforged implements ModInitializer {
	public static final String MOD_ID = "terraforged";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!"+ MOD_ID);
//        ModBlocks.registerModBlocks();
        // 1. Loads the ModBlocks class, registering the blocks via the static fields.
        ModBlocks.initialize();
        ModItems.initialize();
        ModEntities.registerModEntities();
        FabricDefaultAttributeRegistry.register(ModEntities.GLARE, GlareEntity.createAttributes());
        // Inside your Terraforged.java onInitialize() method
        ModBiomes.registerBiomes();


	}
}