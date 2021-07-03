package io.github.fallOut015.gardening.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemGroupGardening {
    public static final ItemGroup TAB_GARDENING = new ItemGroup("gardening") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(ItemsGardening.MARIGOLD_SEEDS.get());
        }
    };
}