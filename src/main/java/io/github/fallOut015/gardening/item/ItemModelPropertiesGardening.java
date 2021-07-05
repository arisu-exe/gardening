package io.github.fallOut015.gardening.item;

import io.github.fallOut015.gardening.MainGardening;
import net.minecraft.item.Item;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.stream.Collectors;

public class ItemModelPropertiesGardening {
    public static void doClientStuff(final FMLClientSetupEvent event) {
        for(Item item : ForgeRegistries.ITEMS.getValues().stream().filter(item -> item instanceof SeedsItem || item instanceof FlowerItem).collect(Collectors.toList())) {
            ItemModelsProperties.register(item, new ResourceLocation(MainGardening.MODID, "color_id"), (stack, world, entity) -> SeedsItem.getColor(stack).getId());
        }
    }
}