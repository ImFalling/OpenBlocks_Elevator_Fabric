package net.imfalling.obelevator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FabricElevatorMod implements ModInitializer {
	// Init blocks and sound
	public static final String MOD_ID = "imfalling";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final Block ELEVATOR_WHITE = new Elevator("white");
	public static final Block ELEVATOR_RED = new Elevator("red");
	public static final Block ELEVATOR_BLACK = new Elevator("black");
	public static final Block ELEVATOR_BLUE = new Elevator("blue");
	public static final Block ELEVATOR_BROWN = new Elevator("brown");
	public static final Block ELEVATOR_CYAN = new Elevator("cyan");
	public static final Block ELEVATOR_GRAY = new Elevator("gray");
	public static final Block ELEVATOR_GREEN = new Elevator("green");
	public static final Block ELEVATOR_LIGHT_BLUE = new Elevator("light_blue");
	public static final Block ELEVATOR_LIGHT_GRAY = new Elevator("light_gray");
	public static final Block ELEVATOR_LIME = new Elevator("lime");
	public static final Block ELEVATOR_MAGENTA = new Elevator("magenta");
	public static final Block ELEVATOR_ORANGE = new Elevator("orange");
	public static final Block ELEVATOR_PINK = new Elevator("pink");
	public static final Block ELEVATOR_PURPLE = new Elevator("purple");
	public static final Block ELEVATOR_YELLOW = new Elevator("yellow");

	public static final Identifier WOOSH_SOUND = new Identifier(MOD_ID, "woosh");
	public static final SoundEvent WOOSH_EVENT = new SoundEvent(WOOSH_SOUND);
	public static Block ELEVATOR_BLOCK;

	@Override
	public void onInitialize() {
		LOGGER.info("Loading OpenBlocks Elevator Mod by ImFalling...");
		//Register blocks and sound
		Registry.register(Registry.BLOCK, new Identifier("imfalling", "elevator_white"), ELEVATOR_WHITE);
        Registry.register(Registry.ITEM, new Identifier("imfalling", "elevator_white"), new BlockItem(ELEVATOR_WHITE, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.BLOCK, new Identifier("imfalling", "elevator_red"), ELEVATOR_RED);
        Registry.register(Registry.ITEM, new Identifier("imfalling", "elevator_red"), new BlockItem(ELEVATOR_RED, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.BLOCK, new Identifier("imfalling", "elevator_black"), ELEVATOR_BLACK);
        Registry.register(Registry.ITEM, new Identifier("imfalling", "elevator_black"), new BlockItem(ELEVATOR_BLACK, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.BLOCK, new Identifier("imfalling", "elevator_blue"), ELEVATOR_BLUE);
        Registry.register(Registry.ITEM, new Identifier("imfalling", "elevator_blue"), new BlockItem(ELEVATOR_BLUE, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.BLOCK, new Identifier("imfalling", "elevator_brown"), ELEVATOR_BROWN);
        Registry.register(Registry.ITEM, new Identifier("imfalling", "elevator_brown"), new BlockItem(ELEVATOR_BROWN, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.BLOCK, new Identifier("imfalling", "elevator_cyan"), ELEVATOR_CYAN);
        Registry.register(Registry.ITEM, new Identifier("imfalling", "elevator_cyan"), new BlockItem(ELEVATOR_CYAN, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.BLOCK, new Identifier("imfalling", "elevator_gray"), ELEVATOR_GRAY);
        Registry.register(Registry.ITEM, new Identifier("imfalling", "elevator_gray"), new BlockItem(ELEVATOR_GRAY, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.BLOCK, new Identifier("imfalling", "elevator_green"), ELEVATOR_GREEN);
        Registry.register(Registry.ITEM, new Identifier("imfalling", "elevator_green"), new BlockItem(ELEVATOR_GREEN, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.BLOCK, new Identifier("imfalling", "elevator_light_blue"), ELEVATOR_LIGHT_BLUE);
        Registry.register(Registry.ITEM, new Identifier("imfalling", "elevator_light_blue"), new BlockItem(ELEVATOR_LIGHT_BLUE, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.BLOCK, new Identifier("imfalling", "elevator_light_gray"), ELEVATOR_LIGHT_GRAY);
        Registry.register(Registry.ITEM, new Identifier("imfalling", "elevator_light_gray"), new BlockItem(ELEVATOR_LIGHT_GRAY, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.BLOCK, new Identifier("imfalling", "elevator_lime"), ELEVATOR_LIME);
        Registry.register(Registry.ITEM, new Identifier("imfalling", "elevator_lime"), new BlockItem(ELEVATOR_LIME, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.BLOCK, new Identifier("imfalling", "elevator_magenta"), ELEVATOR_MAGENTA);
        Registry.register(Registry.ITEM, new Identifier("imfalling", "elevator_magenta"), new BlockItem(ELEVATOR_MAGENTA, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.BLOCK, new Identifier("imfalling", "elevator_orange"), ELEVATOR_ORANGE);
        Registry.register(Registry.ITEM, new Identifier("imfalling", "elevator_orange"), new BlockItem(ELEVATOR_ORANGE, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.BLOCK, new Identifier("imfalling", "elevator_pink"), ELEVATOR_PINK);
        Registry.register(Registry.ITEM, new Identifier("imfalling", "elevator_pink"), new BlockItem(ELEVATOR_PINK, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.BLOCK, new Identifier("imfalling", "elevator_purple"), ELEVATOR_PURPLE);
        Registry.register(Registry.ITEM, new Identifier("imfalling", "elevator_purple"), new BlockItem(ELEVATOR_PURPLE, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.BLOCK, new Identifier("imfalling", "elevator_yellow"), ELEVATOR_YELLOW);
        Registry.register(Registry.ITEM, new Identifier("imfalling", "elevator_yellow"), new BlockItem(ELEVATOR_YELLOW, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.SOUND_EVENT, FabricElevatorMod.WOOSH_SOUND, WOOSH_EVENT);
	}
}
