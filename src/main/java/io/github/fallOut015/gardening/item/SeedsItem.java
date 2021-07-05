package io.github.fallOut015.gardening.item;

import io.github.fallOut015.gardening.block.FlowerType;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.*;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class SeedsItem extends Item {
    final FlowerType flowerType;

    public SeedsItem(final FlowerType flowerType, Properties properties) {
        super(properties);
        this.flowerType = flowerType;
    }

    @Override
    public void fillItemCategory(ItemGroup tab, NonNullList<ItemStack> items) {
        if(this.allowdedIn(tab)) {
            for(final DyeColor color : this.flowerType.getColors()) {
                ItemStack itemStack = new ItemStack(this);
                setColor(itemStack, color);
                items.add(itemStack);
            }
        }
    }
    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable World level, List<ITextComponent> lines, ITooltipFlag tooltipFlag) {
        lines.add(new TranslationTextComponent("color." + getColor(itemStack).getName()).withStyle(Style.EMPTY.applyFormat(TextFormatting.WHITE).withColor(Color.fromRgb(getColor(itemStack).getColorValue()))/*.withStyle(textColorFromDyeColor(getColor(itemStack))*/));
    }

    public FlowerType getFlowerType() {
        return this.flowerType;
    }

    public static DyeColor getColor(ItemStack itemStack) {
        return DyeColor.byId(itemStack.getOrCreateTag().getInt("color_id"));
    }
    public static void setColor(ItemStack itemStack, DyeColor color) {
        itemStack.getOrCreateTag().putInt("color_id", color.getId());
    }
}