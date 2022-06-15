package net.imfalling.obelevator.mixin;

import net.minecraft.entity.LivingEntity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(LivingEntity.class)
public interface CooldownMixin {
    @Accessor("jumpingCooldown")
    public void setJumpingCooldown(int cd);
    @Accessor
    int getJumpingCooldown();

}
