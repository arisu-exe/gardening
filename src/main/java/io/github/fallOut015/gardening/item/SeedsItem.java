package io.github.fallOut015.gardening.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class SeedsItem extends Item {
    final List<DyeColor> colors;

    public SeedsItem(final List<DyeColor> colors, Properties properties) {
        super(properties);
        this.colors = colors;
    }

    @Override
    public void fillItemCategory(ItemGroup tab, NonNullList<ItemStack> items) {
        if(this.allowdedIn(tab)) {
            for(final DyeColor color : this.colors) {
                ItemStack itemStack = new ItemStack(this);
                setColor(itemStack, color);
                items.add(itemStack);
            }
        }
    }
    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable World level, List<ITextComponent> lines, ITooltipFlag tooltipFlag) {
        lines.add(new TranslationTextComponent("color." + getColor(itemStack).getName()));
    }

    public static DyeColor getColor(ItemStack itemStack) {
        return DyeColor.byId(itemStack.getOrCreateTag().getInt("color_id"));
    }
    public static void setColor(ItemStack itemStack, DyeColor color) {
        itemStack.getOrCreateTag().putInt("color_id", color.getId());
    }
}