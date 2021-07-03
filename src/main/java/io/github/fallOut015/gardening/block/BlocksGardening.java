package io.github.fallOut015.gardening.block;

import io.github.fallOut015.gardening.MainGardening;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlocksGardening {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MainGardening.MODID);



    public static final RegistryObject<Block> SOIL = BLOCKS.register("soil", () -> new SoilBlock(AbstractBlock.Properties.of(Material.DIRT)));



    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
