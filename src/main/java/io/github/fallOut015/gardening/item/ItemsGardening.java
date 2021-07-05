package io.github.fallOut015.gardening.item;

import com.google.common.collect.Lists;
import io.github.fallOut015.gardening.MainGardening;
import io.github.fallOut015.gardening.block.BlocksGardening;
import io.github.fallOut015.gardening.block.FlowerType;
import io.github.fallOut015.gardening.block.FlowerTypes;
import net.minecraft.item.BlockItem;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemsGardening {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MainGardening.MODID);



    // Decoration Blocks
    public static final RegistryObject<Item> SOIL = ITEMS.register("soil", () -> new BlockItem(BlocksGardening.SOIL.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));

    // Tools
    public static final RegistryObject<Item> WATERING_CAN = ITEMS.register("watering_can", () -> new WateringCanItem(new Item.Properties().tab(ItemGroup.TAB_TOOLS).stacksTo(1).durability(400)));

    public static final RegistryObject<Item> WOODEN_TROWEL = ITEMS.register("wooden_trowel", () -> new TrowelItem(ItemTier.WOOD, 0, -3.0F, new Item.Properties().tab(ItemGroup.TAB_TOOLS)));
    public static final RegistryObject<Item> STONE_TROWEL = ITEMS.register("stone_trowel", () -> new TrowelItem(ItemTier.STONE, -1, -2.0F, new Item.Properties().tab(ItemGroup.TAB_TOOLS)));
    public static final RegistryObject<Item> GOLDEN_TROWEL = ITEMS.register("golden_trowel", () -> new TrowelItem(ItemTier.GOLD, 0, -3.0F, new Item.Properties().tab(ItemGroup.TAB_TOOLS)));
    public static final RegistryObject<Item> IRON_TROWEL = ITEMS.register("iron_trowel", () -> new TrowelItem(ItemTier.IRON, -2, -1.0F, new Item.Properties().tab(ItemGroup.TAB_TOOLS)));
    public static final RegistryObject<Item> DIAMOND_TROWEL = ITEMS.register("diamond_trowel", () -> new TrowelItem(ItemTier.DIAMOND, -3, 0F, new Item.Properties().tab(ItemGroup.TAB_TOOLS)));
    public static final RegistryObject<Item> NETHERITE_TROWEL = ITEMS.register("netherite_trowel", () -> new TrowelItem(ItemTier.NETHERITE, -4, 0F, new Item.Properties().tab(ItemGroup.TAB_TOOLS)));

    // Gardening
    public static final RegistryObject<Item> MARIGOLD_SEEDS = ITEMS.register("marigold_seeds", () -> new SeedsItem(FlowerTypes.MARIGOLD, new Item.Properties().tab(ItemGroupGardening.TAB_GARDENING)));
    public static final RegistryObject<Item> EVENING_PRIMROSE_SEEDS = ITEMS.register("evening_primrose_seeds", () -> new SeedsItem(FlowerTypes.EVENING_PRIMROSE, new Item.Properties().tab(ItemGroupGardening.TAB_GARDENING)));
    public static final RegistryObject<Item> FORGET_ME_NOT_SEEDS = ITEMS.register("forget_me_not_seeds", () -> new SeedsItem(FlowerTypes.FORGET_ME_NOT, new Item.Properties().tab(ItemGroupGardening.TAB_GARDENING)));

    public static final RegistryObject<Item> MARIGOLD = ITEMS.register("marigold", () -> new FlowerItem(BlocksGardening.MARIGOLD.get(), new Item.Properties().tab(ItemGroupGardening.TAB_GARDENING)));
    public static final RegistryObject<Item> EVENING_PRIMROSE = ITEMS.register("evening_primrose", () -> new FlowerItem(BlocksGardening.EVENING_PRIMROSE.get(), new Item.Properties().tab(ItemGroupGardening.TAB_GARDENING)));
    public static final RegistryObject<Item> FORGET_ME_NOT = ITEMS.register("forget_me_not", () -> new FlowerItem(BlocksGardening.FORGET_ME_NOT.get(), new Item.Properties().tab(ItemGroupGardening.TAB_GARDENING)));



    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}