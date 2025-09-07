package terraforged.mod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import terraforged.mod.entity.ModEntities;
import terraforged.mod.entity.client.GlareModel;
import terraforged.mod.entity.client.GlareRenderer;

public class TerraforgedClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
        EntityModelLayerRegistry.registerModelLayer(GlareModel.Glare, GlareModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.GLARE, GlareRenderer::new);
	}
}