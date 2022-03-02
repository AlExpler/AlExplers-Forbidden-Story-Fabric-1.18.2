package net.alexpler.alexplers_forbidden_story.block;

import net.alexpler.alexplers_forbidden_story.MainClass;
import net.alexpler.alexplers_forbidden_story.item.ModItemGroup;
import net.alexpler.alexplers_forbidden_story.item.ModItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block BLOCK_OF_ABANDONED_CRYSTALS = registerBlock("block_of_abandoned_crystals",
            new Block(FabricBlockSettings.of(Material.AMETHYST).strength(70f).requiresTool().luminance(7)), ModItemGroup.ABANDONED_ITEMS);

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(MainClass.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(MainClass.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks() {
        MainClass.LOGGER.info("Registering Mod Blocks for " + MainClass.MOD_ID + "...");
    }

}
