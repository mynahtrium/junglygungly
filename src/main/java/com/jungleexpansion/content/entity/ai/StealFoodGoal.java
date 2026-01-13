package com.jungleexpansion.content.entity.ai;

import com.jungleexpansion.content.entity.MonkeyEntity;
import com.jungleexpansion.content.item.ModFoods;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.phys.AABB;

import java.util.EnumSet;
import java.util.List;

public class StealFoodGoal extends Goal {
    private final MonkeyEntity monkey;
    private ItemEntity targetItem;

    public StealFoodGoal(MonkeyEntity monkey) {
        this.monkey = monkey;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        if (this.monkey.isTame()) {
            return false;
        }

        List<ItemEntity> items = this.monkey.level().getEntitiesOfClass(ItemEntity.class,
                this.monkey.getBoundingBox().inflate(8.0D, 8.0D, 8.0D),
                item -> item.getItem().getItem().getFoodProperties(item.getItem(), this.monkey) != null); // Checks for
                                                                                                          // any food,
                                                                                                          // maybe
                                                                                                          // prioritize
                                                                                                          // Banana?

        if (items.isEmpty()) {
            return false;
        }

        // Simple heuristic: pick nearest
        this.targetItem = items.get(0);
        return true;
    }

    @Override
    public void start() {
        this.monkey.getNavigation().moveTo(this.targetItem, 1.2F);
    }

    @Override
    public void tick() {
        if (this.targetItem == null || !this.targetItem.isAlive()) {
            this.monkey.getNavigation().stop();
            return;
        }

        this.monkey.getNavigation().moveTo(this.targetItem, 1.2F);

        if (this.monkey.distanceToSqr(this.targetItem) < 2.0D) {
            // "Steal" the item
            this.monkey.heal(2.0F); // Heals when eating
            this.monkey.playSound(net.minecraft.sounds.SoundEvents.GENERIC_EAT, 1.0F, 1.0F);
            this.targetItem.discard();
            this.targetItem = null;
        }
    }

    @Override
    public boolean canContinueToUse() {
        return this.targetItem != null && this.targetItem.isAlive();
    }
}
