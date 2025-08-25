package terraforged.mod.entity.custom;

import com.sun.source.tree.BreakTree;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import terraforged.mod.entity.ModEntities;


public class GlareEntity extends AnimalEntity {
    public final AnimationState idleAnimationState = new AnimationState();
    public int idleAnimationTimeout = 0;

    public GlareEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }
    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new LookAroundGoal(this));
    }
    public static DefaultAttributeContainer.Builder createAtributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.MAX_HEALTH, 18).add(EntityAttributes.MOVEMENT_SPEED,0.35).add(EntityAttributes.ATTACK_DAMAGE, 0);
    }

    private void setupAnimationStates() {
        if(this.idleAnimationTimeout <= 0){
            this.idleAnimationTimeout = 30;
            this.idleAnimationState.start(this.age);
        }else {
            --this.idleAnimationTimeout;
        }
    }
    @Override
    public void tick()  {
        super.tick();
        if(this.getWorld().isClient()) {
            this.setupAnimationStates();
        }
    }
    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Item.fromBlock(Blocks.GLOW_LICHEN));
    }

//    @Override
//    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
//        return null;
//    }
    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.GLARE.create(world);
    }
}
