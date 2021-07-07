package io.github.fallOut015.gardening.client.renderer;

import io.github.fallOut015.gardening.block.BlocksGardening;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class RenderTypeLookupGardening {
    public static void doClientStuff(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(BlocksGardening.MARIGOLD.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlocksGardening.EVENING_PRIMROSE.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlocksGardening.FORGET_ME_NOT.get(), RenderType.cutout());

        RenderTypeLookup.setRenderLayer(BlocksGardening.POTTED_MARIGOLD.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlocksGardening.POTTED_EVENING_PRIMROSE.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlocksGardening.POTTED_FORGET_ME_NOT.get(), RenderType.cutout());
    }
}