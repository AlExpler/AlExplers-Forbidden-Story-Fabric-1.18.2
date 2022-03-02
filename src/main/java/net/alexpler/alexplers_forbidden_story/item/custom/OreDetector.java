package net.alexpler.alexplers_forbidden_story.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.event.BlockPositionSource;

public class OreDetector extends Item {
    public OreDetector(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(context.getWorld().isClient()){
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i < positionClicked.getY() + 64; i++) {
                Block block = context.getWorld().getBlockState(positionClicked.down(i)).getBlock();
                if(isValuableBlock(block)) {
                    outputValuableCoordinates(positionClicked.down(i), player, block);
                    foundBlock = true;
                }
            }

            if(!foundBlock) {
                player.sendMessage(new TranslatableText("item.alexplers_forbidden_story.ore_detector.no_valuable"), false);
            }
        }

        context.getStack().damage(1, context.getPlayer(), (player) -> player.sendToolBreakStatus(player.getActiveHand()));

        return super.useOnBlock(context);
    }

    private boolean isValuableBlock(Block block){
        return  block == Blocks.COAL_ORE || block == Blocks.IRON_ORE || block == Blocks.GOLD_ORE || block == Blocks.DIAMOND_ORE || block == Blocks.EMERALD_ORE ||
                block == Blocks.REDSTONE_BLOCK || block == Blocks.LAPIS_ORE ||
                block == Blocks.DEEPSLATE_COAL_ORE || block == Blocks.DEEPSLATE_IRON_ORE || block == Blocks.DEEPSLATE_GOLD_ORE || block == Blocks.DEEPSLATE_DIAMOND_ORE ||
                block == Blocks.DEEPSLATE_EMERALD_ORE || block == Blocks.DEEPSLATE_REDSTONE_ORE || block == Blocks.DEEPSLATE_LAPIS_ORE;
    }

    private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block block) {
        player.sendMessage(new LiteralText("Found " + block.asItem().getName().getString() + " at " + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ()), false);
    }
}
