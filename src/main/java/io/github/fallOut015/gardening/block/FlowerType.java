package io.github.fallOut015.gardening.block;

import com.google.common.collect.Maps;
import io.github.fallOut015.gardening.MainGardening;
import net.minecraft.item.DyeColor;
import net.minecraft.util.ResourceLocation;

import java.util.List;
import java.util.Map;

public class FlowerType {
    final String id;
    final List<DyeColor> colors;
    final Map<DyeColor, ResourceLocation[]> textures;

    public FlowerType(final String id, final List<DyeColor> colors) {
        this.id = id;
        this.colors = colors;
        this.textures = Maps.newHashMap();
        for(final DyeColor color : colors) {
            ResourceLocation[] resourceLocations = new ResourceLocation[] {
                new ResourceLocation(MainGardening.MODID, "textures/block/" + id + "_" + color.getName() + "_0"),
                new ResourceLocation(MainGardening.MODID, "textures/block/" + id + "_" + color.getName() + "_1"),
                new ResourceLocation(MainGardening.MODID, "textures/block/" + id + "_" + color.getName() + "_2"),
                new ResourceLocation(MainGardening.MODID, "textures/block/" + id + "_" + color.getName() + "_3"),
                new ResourceLocation(MainGardening.MODID, "textures/block/" + id + "_" + color.getName() + "_4")
            };
            this.textures.put(color, resourceLocations);
        }
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