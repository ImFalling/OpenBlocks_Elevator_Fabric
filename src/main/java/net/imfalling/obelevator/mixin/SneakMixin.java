package net.imfalling.obelevator.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.imfalling.obelevator.Elevator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

@Mixin(Entity.class)
public abstract class SneakMixin{
    @Inject(at = @At(value = "TAIL"), method = "setSneaking")
	private void onSneak(CallbackInfo info) {
		Elevator.onPlayerSneak((LivingEntity) (Object) this);
	}
}
