package io.github.fallOut015.gardening.block;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.minecraft.item.DyeColor;

import java.util.List;
import java.util.Map;

public class FlowerTypes {
    private static final Map<String, FlowerType> FLOWERS;

    public static final FlowerType MARIGOLD;
    public static final FlowerType EVENING_PRIMROSE;
    public static final FlowerType FORGET_ME_NOT;

    static {
        FLOWERS = Maps.newHashMap();

        MARIGOLD = register("marigold", Lists.newArrayList(DyeColor.ORANGE, DyeColor.YELLOW));
        EVENING_PRIMROSE = register("evening_primrose", Lists.newArrayList(DyeColor.WHITE, DyeColor.MAGENTA, DyeColor.YELLOW));
        FORGET_ME_NOT = register("forget_me_not", Lists.newArrayList(DyeColor.WHITE, DyeColor.LIGHT_BLUE, DyeColor.PINK, DyeColor.PURPLE));
    }

    static FlowerType register(final String id, final List<DyeColor> colors) {
        FlowerType flowerType = new FlowerType(id, colors);
        FLOWERS.put(id, flowerType);
        return flowerType;
    }
    static FlowerType fromID(String id) {
        return FLOWERS.get(id);
    }
}