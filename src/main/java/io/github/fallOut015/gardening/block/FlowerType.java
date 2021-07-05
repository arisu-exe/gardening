package io.github.fallOut015.gardening.block;

import com.google.common.collect.Maps;
import io.github.fallOut015.gardening.MainGardening;
import io.github.fallOut015.gardening.item.FlowerItem;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class FlowerType {
    final String id;
    final List<DyeColor> colors;
    final Map<DyeColor, ResourceLocation[]> textures;
    final Supplier<Item> itemForm;

    public FlowerType(final String id, final List<DyeColor> colors, final Supplier<Item> itemForm) {
        this.id = id;
        this.colors = colors;
        this.itemForm = itemForm;
        this.textures = Maps.newHashMap();
        for(final DyeColor color : colors) {
            ResourceLocation[] resourceLocations = new ResourceLocation[] {
                new ResourceLocation(MainGardening.MODID, "textures/block/" + id + "_" + color.getName() + "_0" + ".png"),
                new ResourceLocation(MainGardening.MODID, "textures/block/" + id + "_" + color.getName() + "_1" + ".png"),
                new ResourceLocation(MainGardening.MODID, "textures/block/" + id + "_" + color.getName() + "_2" + ".png"),
                new ResourceLocation(MainGardening.MODID, "textures/block/" + id + "_" + color.getName() + "_3" + ".png"),
                new ResourceLocation(MainGardening.MODID, "textures/block/" + id + "_" + color.getName() + "_4" + ".png")
            };
            this.textures.put(color, resourceLocations);
        }
    }

    public FlowerItem getFlowerItem() {
        return (FlowerItem) this.itemForm.get();
    }
    public final String getID() {
        return this.id;
    }
    public final List<DyeColor> getColors() {
        return this.colors;
    }
    public ResourceLocation getTextureForAgeAndColor(int age, DyeColor color) {
        return this.textures.get(color)[age];
    }
}