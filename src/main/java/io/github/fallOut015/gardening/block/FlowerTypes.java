package io.github.fallOut015.gardening.block;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.github.fallOut015.gardening.item.FlowerItem;
import io.github.fallOut015.gardening.item.ItemsGardening;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class FlowerTypes {
    private static final Map<String, FlowerType> FLOWERS;

    public static final FlowerType MARIGOLD;
    public static final FlowerType EVENING_PRIMROSE;
    public static final FlowerType FORGET_ME_NOT;

    static {
        FLOWERS = Maps.newHashMap();

        MARIGOLD = register("marigold", Lists.newArrayList(DyeColor.ORANGE, DyeColor.YELLOW), ItemsGardening.MARIGOLD::get);
        EVENING_PRIMROSE = register("evening_primrose", Lists.newArrayList(DyeColor.WHITE, DyeColor.MAGENTA, DyeColor.YELLOW), ItemsGardening.EVENING_PRIMROSE::get);
        FORGET_ME_NOT = register("forget_me_not", Lists.newArrayList(DyeColor.WHITE, DyeColor.LIGHT_BLUE, DyeColor.PINK, DyeColor.PURPLE), ItemsGardening.FORGET_ME_NOT::get);
    }

    static FlowerType register(final String id, final List<DyeColor> colors, final Supplier<Item> itemForm) {
        FlowerType flowerType = new FlowerType(id, colors, itemForm);
        FLOWERS.put(id, flowerType);
        return flowerType;
    }
    static FlowerType fromID(String id) {
        return FLOWERS.get(id);
    }
}