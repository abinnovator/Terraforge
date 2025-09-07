package terraforged.mod.entity.client;


import net.minecraft.client.render.entity.EntityRendererFactory;

import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.util.Identifier;
import terraforged.mod.Terraforged;
import terraforged.mod.entity.custom.GlareEntity;
import net.minecraft.client.render.entity.MobEntityRenderer;

public class GlareRenderer
        extends MobEntityRenderer<
        GlareEntity,             // T: your entity
        LivingEntityRenderState, // S: your render state
        GlareModel               // M: your model that extends EntityModel<S>
        > {
    public GlareRenderer(EntityRendererFactory.Context context) {
        super(context, new GlareModel(context.getPart(GlareModel.Glare)), 0.5f);
    }

    @Override
    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }

    @Override
    public Identifier getTexture(LivingEntityRenderState state) {
        return Identifier.of(Terraforged.MOD_ID, "textures/entity/glare/glare.png");
    }
}



//public class GlareRenderer extends MobEntityRenderer<GlareEntity, GlareModel, LivingEntityRenderState>{
//
//
//    public GlareRenderer (EntityRendererFactory.Context context) {
//        super(context, new GlareModel(context.getPart(GlareModel.Glare)), 0.5f);
//    }
//
//    @Override
//    public LivingEntityRenderState createRenderState() {
//        return new LivingEntityRenderState();
//    }
//
//
//    @Override
//    public Identifier getTexture(GlareModel state) {
//        return Identifier.of(Terraforged.MOD_ID,"textures/entity/glare/glare.png");
//    }

/*
    @Override
    public void render(GlareEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i){
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
    public GlareRenderer(EntityRendererFactory.Context context, EntityModel entityModel, float f) {
        super(context, entityModel, f);
    }
*/

