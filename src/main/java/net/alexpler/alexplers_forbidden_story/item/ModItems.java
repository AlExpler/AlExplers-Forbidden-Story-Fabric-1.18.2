package net.alexpler.alexplers_forbidden_story.item;

import net.alexpler.alexplers_forbidden_story.MainClass;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item ABANDONED_CRYSTAL = registerItems(
            "abandoned_crystal", new Item(new FabricItemSettings().group(ModItemGroup.ABANDONED_ITEMS))
    );

    private static Item registerItems(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(MainClass.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MainClass.LOGGER.info("Registering Mod Items for " + MainClass.MOD_ID + "...");
    }
}
