package io.github.fallOut015.gardening.item;

import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemGroupGardening {
    public static final ItemGroup TAB_GARDENING = new ItemGroup("gardening") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            ItemStack itemStack = new ItemStack(ItemsGardening.MARIGOLD_SEEDS.get());
            SeedsItem.setColor(itemStack, DyeColor.YELLOW);
            return itemStack;
        }
    };
}