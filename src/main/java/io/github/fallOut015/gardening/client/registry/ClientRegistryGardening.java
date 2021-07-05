package io.github.fallOut015.gardening.client.registry;

import io.github.fallOut015.gardening.client.renderer.tileentity.SoilRenderer;
import io.github.fallOut015.gardening.tileentity.TileEntitiesGardening;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientRegistryGardening {
    public static void doClientStuff(final FMLClientSetupEvent event) {
        ClientRegistry.bindTileEntityRenderer(TileEntitiesGardening.SOIL.get(), SoilRenderer::new);
    }
}