package net.alexpler.alexplers_forbidden_story;

import net.alexpler.alexplers_forbidden_story.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainClass implements ModInitializer {

	public static final String MOD_ID = "alexplers_forbidden_story";
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}
