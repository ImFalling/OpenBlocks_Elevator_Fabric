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

<<<<<<< HEAD:src/main/java/net/imfalling/obelevator/ExampleMod.java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	//Init blocks and sound
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");
	public static final Block ELEVATOR_WHITE = new Elevator_White(FabricBlockSettings.of(Material.WOOL).strength(4.0f));
	public static final Block ELEVATOR_RED = new Elevator_Red(FabricBlockSettings.of(Material.WOOL).strength(4.0f));
	public static final Identifier WOOSH_SOUND = new Identifier("imfalling:woosh");
=======
public class FabricElevatorMod implements ModInitializer {
	// Init blocks and sound
	public static final String MOD_ID = "imfalling";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final Block ELEVATOR = new Elevator(FabricBlockSettings.of(Material.WOOL).strength(4.0f));
	public static final Identifier WOOSH_SOUND = new Identifier(MOD_ID, "woosh");
>>>>>>> 973974dbb8ab3031592ca0792aea7319959e5ab0:src/main/java/net/imfalling/obelevator/FabricElevatorMod.java
	public static final SoundEvent WOOSH_EVENT = new SoundEvent(WOOSH_SOUND);
	public static Block ELEVATOR_BLOCK;

	@Override
	public void onInitialize() {
		LOGGER.info("Loading OpenBlocks Elevator Mod by ImFalling...");
<<<<<<< HEAD:src/main/java/net/imfalling/obelevator/ExampleMod.java
		//Register blocks and sound
		Registry.register(Registry.BLOCK, new Identifier("imfalling", "elevator_white"), ELEVATOR_WHITE);
        Registry.register(Registry.ITEM, new Identifier("imfalling", "elevator_white"), new BlockItem(ELEVATOR_WHITE, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.BLOCK, new Identifier("imfalling", "elevator_red"), ELEVATOR_RED);
        Registry.register(Registry.ITEM, new Identifier("imfalling", "elevator_red"), new BlockItem(ELEVATOR_RED, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.SOUND_EVENT, ExampleMod.WOOSH_SOUND, WOOSH_EVENT);
=======

		// Register blocks and sound
		ELEVATOR_BLOCK = Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "elevator"), ELEVATOR);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "elevator"), new BlockItem(ELEVATOR, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.SOUND_EVENT, FabricElevatorMod.WOOSH_SOUND, WOOSH_EVENT);
>>>>>>> 973974dbb8ab3031592ca0792aea7319959e5ab0:src/main/java/net/imfalling/obelevator/FabricElevatorMod.java
	}
}
