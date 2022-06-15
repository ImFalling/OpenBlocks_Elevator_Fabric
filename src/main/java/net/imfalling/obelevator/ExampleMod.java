package net.imfalling.obelevator;

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	//Init blocks and sound
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");
	public static final Block ELEVATOR = new Elevator(FabricBlockSettings.of(Material.WOOL).strength(4.0f));
	public static final Identifier WOOSH_SOUND = new Identifier("imfalling:woosh");
	public static final SoundEvent WOOSH_EVENT = new SoundEvent(WOOSH_SOUND);

	@Override
	public void onInitialize() {
		LOGGER.info("Loading OpenBlocks Elevator Mod by ImFalling...");
		//Register blocks and sound
		Registry.register(Registry.BLOCK, new Identifier("imfalling", "elevator"), ELEVATOR);
        Registry.register(Registry.ITEM, new Identifier("imfalling", "elevator"), new BlockItem(ELEVATOR, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.SOUND_EVENT, ExampleMod.WOOSH_SOUND, WOOSH_EVENT);
	}
}
