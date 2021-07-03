package io.github.fallOut015.gardening.item;

import io.github.fallOut015.gardening.MainGardening;
import io.github.fallOut015.gardening.block.BlocksGardening;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemsGardening {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MainGardening.MODID);



    public static final RegistryObject<Item> SOIL = ITEMS.register("soil", () -> new BlockItem(BlocksGardening.SOIL.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));

    public static final RegistryObject<Item> WOODEN_TROWEL = ITEMS.register("wooden_trowel", () -> new TrowelItem(ItemTier.WOOD, 0, -3.0F, new Item.Properties().tab(ItemGroup.TAB_TOOLS)));
    public static final RegistryObject<Item> STONE_TROWEL = ITEMS.register("stone_trowel", () -> new TrowelItem(ItemTier.STONE, -1, -2.0F, new Item.Properties().tab(ItemGroup.TAB_TOOLS)));
    public static final RegistryObject<Item> GOLDEN_TROWEL = ITEMS.register("golden_trowel", () -> new TrowelItem(ItemTier.GOLD, 0, -3.0F, new Item.Properties().tab(ItemGroup.TAB_TOOLS)));
    public static final RegistryObject<Item> IRON_TROWEL = ITEMS.register("iron_trowel", () -> new TrowelItem(ItemTier.IRON, -2, -1.0F, new Item.Properties().tab(ItemGroup.TAB_TOOLS)));
    public static final RegistryObject<Item> DIAMOND_TROWEL = ITEMS.register("diamond_trowel", () -> new TrowelItem(ItemTier.DIAMOND, -3, 0F, new Item.Properties().tab(ItemGroup.TAB_TOOLS)));
    public static final RegistryObject<Item> NETHERITE_TROWEL = ITEMS.register("netherite_trowel", () -> new TrowelItem(ItemTier.NETHERITE, -4, 0F, new Item.Properties().tab(ItemGroup.TAB_TOOLS)));



    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
