package terraforged.mod.entity.client;


import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.util.Identifier;
import terraforged.mod.entity.custom.GlareEntity;
import net.minecraft.client.render.entity.MobEntityRenderer;


public class GlareRenderer extends MobEntityRenderer<GlareEntity, GlareModel, LivingEntityRenderState>{
//    public GlareRenderer(EntityRendererFactory.Context context, EntityModel entityModel, float f) {
//        super(context, entityModel, f);
//    }

    public GlareRenderer (EntityRendererFactory.Context context) {
        super(context, new GlareModel(context.getPart(GlareModel.Glare)), 0.5f);
    }

    @Override
    public GlareModel createRenderState() {
        return null;
    }


    @Override
    public Identifier getTexture(GlareModel state) {
        return null;
    }
}
