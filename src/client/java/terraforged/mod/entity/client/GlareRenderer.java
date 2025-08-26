package terraforged.mod.entity.client;


import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.util.Identifier;
import terraforged.mod.entity.custom.GlareEntity;
import net.minecraft.client.render.entity.MobEntityRenderer;


public class GlareRenderer extends MobEntityRenderer<GlareEntity, GlareModel<GlareEntity>>{
    public GlareRenderer(EntityRendererFactory.Context context, EntityModel entityModel, float f) {
        super(context, entityModel, f);
    }

    @Override
    public Identifier getTexture(GlareEntity entity) {
        return null;
    }

    @Override
    public Identifier getTexture(LivingEntityRenderState state) {
        return null;
    }

    @Override
    public EntityRenderState createRenderState() {
        return null;
    }
}
