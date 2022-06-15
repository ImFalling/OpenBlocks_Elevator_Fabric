package net.imfalling.obelevator;

import net.imfalling.obelevator.mixin.CooldownMixin;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class Elevator extends Block {
    static int MAXIMUM_TELEPORT_HEIGHT = 32;
    int COOLDOWN = 0;

    public Elevator(Settings settings){
        super(settings);
    }

	/**
	 * Attempts to find a suitable elevator to teleport the player to.
	 * @param player A player, from which position to find the elevator block.
	 * @param searchOnTop If true, will search for the elevator on top of the player, otherwise will search for the elevator below.
	 * @return A block position of the elevator, or null if no elevator was found.
	 */
	public static BlockPos findElevatorBlock(PlayerEntity player, Boolean searchOnTop) {
		// Go through blocks in range and check if they are the same type as the block over or below the player.
		for (int i = (searchOnTop ? 2 : 4); i <= MAXIMUM_TELEPORT_HEIGHT; i++) {
			int height = (searchOnTop ? i : -i);

			// if searchOnTop is false, then we search for the block *below* the player.
			// if searchOnTop is true, then we search for the block *above* the player.
			BlockState blockUnderFeet = player.world.getBlockState(new BlockPos(player.getX(), player.getY() + height, player.getZ()));

			// Check if we have got an Elevator block.
			if (blockUnderFeet.getBlock() != FabricElevatorMod.ELEVATOR_BLOCK) { continue; }

			// ExampleMod.LOGGER.debug("Found!");
			return new BlockPos(player.getX(), player.getY() + height, player.getZ());
		}

		// Return null if no elevator was found:
		return null;
	}

	/**
	 * Plays a "woosh!" sound.
	 * @param player Player to play sound for.
	 */
    static void playWoosh(PlayerEntity player) {
		// We should play the sound on server-side.
		if (player.world.isClient()) { return; }

		// Play the sound.
        player.world.playSound(
            null, // Player - if non-null, will play sound for every nearby player *except* the specified player
            new BlockPos(player.getPos()), // The position of where the sound will come from
            FabricElevatorMod.WOOSH_EVENT, // The sound that will play
            SoundCategory.BLOCKS, // This determines which of the volume sliders affect this sound
            1f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
            1f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
        );
    }

    public static void onPlayerJump(LivingEntity living) {
		// Multiple checks:
		//  - We should not use this function on client-side,
		//  - only players can use the Elevator.
		if (living.world.isClient() || living instanceof PlayerEntity player == false) { return; }

		// Set up variables:
		PlayerEntity player = (PlayerEntity) living;
		BlockState blockUnderFeet = player.world.getBlockState(new BlockPos(new Vec3d(living.getX(), living.getY() - 1, living.getZ())));
		int jumpingCooldown = ((CooldownMixin) player).getJumpingCooldown();

		// Only standing on elevator players with 0 cooldown can use the elevator:
		if ((player.isOnGround() && jumpingCooldown == 0 && blockUnderFeet.getBlock() instanceof Elevator elevator) == false) { return; }

		// Find the elevator on top of a player:
		BlockPos elevatorPos = findElevatorBlock(player, true);

		// If elevator was found, teleport the player:
		if (elevatorPos == null) { return; }

		// Teleport the player:
		// ((CooldownMixin) player).setJumpingCooldown(1);
		player.requestTeleportAndDismount(elevatorPos.getX() + 0.5, elevatorPos.getY() + 1, elevatorPos.getZ() + 0.5);
		playWoosh(player);
    }

    public static void onPlayerSneak(LivingEntity living) {
		// Multiple checks:
		//  - We should not use this function on client-side,
		//  - only players can use the Elevator.
		if (living.world.isClient() || living instanceof PlayerEntity player == false) { return; }

		PlayerEntity player = (PlayerEntity) living;
		BlockState blockUnderFeet = player.world.getBlockState(new BlockPos(new Vec3d(living.getX(), living.getY() - 1, living.getZ())));
		int jumpingCooldown = ((CooldownMixin) player).getJumpingCooldown();

		// Only standing on elevator players with 0 cooldown can use the elevator:
		if ((player.isOnGround() && jumpingCooldown == 0 && blockUnderFeet.getBlock() instanceof Elevator elevator) == false) { return; }

		// Find the elevator on top of a player:
		BlockPos elevatorPos = findElevatorBlock(player, false);

		// If elevator was found, teleport the player:
		if (elevatorPos == null) { return; }

		// Teleport the player:
		// ((CooldownMixin) player).setJumpingCooldown(1);
		player.requestTeleportAndDismount(elevatorPos.getX() + 0.5, elevatorPos.getY() + 1, elevatorPos.getZ() + 0.5);
		playWoosh(player);
	}
}
