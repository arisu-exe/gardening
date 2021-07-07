package io.github.fallOut015.gardening.block;

import io.github.fallOut015.gardening.MainGardening;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.potion.Effects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlocksGardening {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MainGardening.MODID);



    public static final RegistryObject<Block> SOIL = BLOCKS.register("soil", () -> new SoilBlock(AbstractBlock.Properties.of(Material.DIRT).noOcclusion()));

    public static final RegistryObject<Block> MARIGOLD = BLOCKS.register("marigold", () -> new FlowerBlockGardening(FlowerTypes.MARIGOLD, Effects.HEAL, 100, AbstractBlock.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> EVENING_PRIMROSE = BLOCKS.register("evening_primrose", () -> new FlowerBlockGardening(FlowerTypes.EVENING_PRIMROSE, Effects.HEAL, 100, AbstractBlock.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> FORGET_ME_NOT = BLOCKS.register("forget_me_not", () -> new FlowerBlockGardening(FlowerTypes.FORGET_ME_NOT, Effects.HEAL, 100, AbstractBlock.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));

    public static final RegistryObject<Block> POTTED_MARIGOLD = BLOCKS.register("potted_marigold", () -> new FlowerPotBlockGardening(() -> (FlowerPotBlock) Blocks.FLOWER_POT, MARIGOLD, AbstractBlock.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> POTTED_EVENING_PRIMROSE = BLOCKS.register("potted_evening_primrose", () -> new FlowerPotBlockGardening(() -> (FlowerPotBlock) Blocks.FLOWER_POT, EVENING_PRIMROSE, AbstractBlock.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> POTTED_FORGET_ME_NOT = BLOCKS.register("potted_forget_me_not", () -> new FlowerPotBlockGardening(() -> (FlowerPotBlock) Blocks.FLOWER_POT, FORGET_ME_NOT, AbstractBlock.Properties.of(Material.DECORATION).instabreak().noOcclusion()));



    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
