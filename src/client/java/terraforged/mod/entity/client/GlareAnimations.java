package terraforged.mod.entity.client;


import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class GlareAnimations {


    public static final Animation HOVERING = Animation.Builder.create(1.29167f).looping()
            .addBoneAnimation("bone",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(0.08333f, AnimationHelper.createTranslationalVector(0f, 1f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(0.16667f, AnimationHelper.createTranslationalVector(0f, 2f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(0.29167f, AnimationHelper.createTranslationalVector(0f, 3f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(0.79167f, AnimationHelper.createTranslationalVector(0f, 4f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(1.29167f, AnimationHelper.createTranslationalVector(0f, 1f, 0f),
                                    Transformation.Interpolations.LINEAR))).build();
    private static final float NaNf = 0f;
    public static final Animation GIVE_SAPLINGS = Animation.Builder.create(1.08333f)
            .addBoneAnimation("bone",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, NaNf, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.91667f, AnimationHelper.createTranslationalVector(0f, NaNf, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("bone",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(NaNf, 0f, NaNf),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.04167f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.91667f, AnimationHelper.createRotationalVector(NaNf, 0f, NaNf),
                                    Transformation.Interpolations.LINEAR))).build();
}
