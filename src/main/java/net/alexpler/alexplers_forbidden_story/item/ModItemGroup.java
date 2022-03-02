package net.alexpler.alexplers_forbidden_story.item;

import net.alexpler.alexplers_forbidden_story.MainClass;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup ABANDONED_ITEMS = FabricItemGroupBuilder.build(new Identifier(MainClass.MOD_ID, "abandoned_items"),
    () -> new ItemStack(ModItems.ABANDONED_CRYSTAL));
}
