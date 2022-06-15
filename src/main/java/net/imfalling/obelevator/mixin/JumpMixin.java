package net.imfalling.obelevator.mixin;

import net.imfalling.obelevator.Elevator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class JumpMixin extends Entity{
	public JumpMixin(EntityType<?> type, World world) {
		super(type, world);
	}
    @Inject(at = @At("INVOKE"), method = "jump()V")
	public void onJump(CallbackInfo info) {
		Elevator.onPlayerJump((LivingEntity) (Object) this);
	}
}


