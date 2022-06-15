package net.imfalling.obelevator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FabricElevatorMod implements ModInitializer {
	// Init blocks and sound
	public static final String MOD_ID = "imfalling";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final Block ELEVATOR = new Elevator(FabricBlockSettings.of(Material.WOOL).strength(4.0f));
	public static final Identifier WOOSH_SOUND = new Identifier(MOD_ID, "woosh");
	public static final SoundEvent WOOSH_EVENT = new SoundEvent(WOOSH_SOUND);
	public static Block ELEVATOR_BLOCK;

	@Override
	public void onInitialize() {
		LOGGER.info("Loading OpenBlocks Elevator Mod by ImFalling...");

		// Register blocks and sound
		ELEVATOR_BLOCK = Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "elevator"), ELEVATOR);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "elevator"), new BlockItem(ELEVATOR, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.SOUND_EVENT, FabricElevatorMod.WOOSH_SOUND, WOOSH_EVENT);
	}
}
