package terraforged.mod.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import terraforged.mod.Terraforged;
import terraforged.mod.entity.custom.GlareEntity;

public class GlareModel extends EntityModel<LivingEntityRenderState> {
    public static final EntityModelLayer Glare = new EntityModelLayer(Identifier.of(Terraforged.MOD_ID, "glare"), "main");
    private final ModelPart bone;
    private final ModelPart bone2;
    private final ModelPart bone3;
    private final ModelPart bone4;
    private final ModelPart bone5;
//    public glare(ModelPart root) {
//        this.bone = root.getChild("bone");
//        this.bone2 = this.bone.getChild("bone2");
//        this.bone3 = this.bone.getChild("bone3");
//        this.bone4 = this.bone.getChild("bone4");
//        this.bone5 = this.bone.getChild("bone5");
//    }

    public GlareModel(ModelPart root) {
        super(root);
        this.bone = root.getChild("bone");
        this.bone2 = bone.getChild("bone2");
        this.bone3 = bone.getChild("bone3");
        this.bone4 = bone.getChild("bone4");
        this.bone5 = bone.getChild("bone5");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create().uv(0, 0).cuboid(-10.0F, -13.0F, -1.0F, 11.0F, 10.0F, 11.0F, new Dilation(0.0F))
                .uv(0, 21).cuboid(-8.0F, -3.0F, 1.0F, 7.0F, 2.0F, 7.0F, new Dilation(0.0F))
                .uv(28, 21).cuboid(-7.0F, -1.0F, 1.0F, 5.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.rotation(5.0F, 21.0F, -3.0F));

        ModelPartData bone2 = bone.addChild("bone2", ModelPartBuilder.create().uv(28, 28).cuboid(-1.0F, 6.0F, -1.0F, 11.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.rotation(-9.0F, -13.0F, -1.0F));

        ModelPartData cube_r1 = bone2.addChild("cube_r1", ModelPartBuilder.create().uv(28, 28).cuboid(-10.0F, -3.0F, -1.0F, 11.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

        ModelPartData bone3 = bone.addChild("bone3", ModelPartBuilder.create().uv(28, 28).cuboid(-1.0F, 6.0F, -1.0F, 11.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-10.0F, -13.0F, 9.0F, 0.0F, 1.5708F, 0.0F));

        ModelPartData cube_r2 = bone3.addChild("cube_r2", ModelPartBuilder.create().uv(28, 28).cuboid(-10.0F, -3.0F, -1.0F, 11.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

        ModelPartData bone4 = bone.addChild("bone4", ModelPartBuilder.create().uv(28, 28).cuboid(-1.0F, 6.0F, -1.0F, 11.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -13.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        ModelPartData cube_r3 = bone4.addChild("cube_r3", ModelPartBuilder.create().uv(28, 28).cuboid(-10.0F, -3.0F, -1.0F, 11.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

        ModelPartData bone5 = bone.addChild("bone5", ModelPartBuilder.create().uv(28, 28).cuboid(-1.0F, 6.0F, -1.0F, 11.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -13.0F, 10.0F, 0.0F, 3.1416F, 0.0F));

        ModelPartData cube_r4 = bone5.addChild("cube_r4", ModelPartBuilder.create().uv(28, 28).cuboid(-10.0F, -3.0F, -1.0F, 11.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.1416F));
        return TexturedModelData.of(modelData, 64, 64);
    }
//    TODO: Implement animations
//    @Override
//    public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
//        this.animateMovement(GlareAnimations.HOVERING, limbSwing, limbSwingAmount, 2f, 2.5f);
//        this.updateAnimation(entity.idleAnimationState, GlareAnimations.HOVERING, ageInTicks, 1f);
//
//    }
//    @Override
//    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
//        bone.render(matrices, vertexConsumer, light, overlay, color);
//    }
    public ModelPart getPart() {
        return bone;
    }
}
