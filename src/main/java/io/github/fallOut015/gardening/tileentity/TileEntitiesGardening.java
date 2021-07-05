package io.github.fallOut015.gardening.tileentity;

import io.github.fallOut015.gardening.MainGardening;
import io.github.fallOut015.gardening.block.BlocksGardening;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Util;
import net.minecraft.util.datafix.TypeReferences;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntitiesGardening {
    private static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MainGardening.MODID);



    public static final RegistryObject<TileEntityType<SoilTileEntity>> SOIL = TILE_ENTITIES.register("soil", () -> TileEntityType.Builder.of(SoilTileEntity::new, BlocksGardening.SOIL.get()).build(Util.fetchChoiceType(TypeReferences.BLOCK_ENTITY, "soil")));



    public static void register(IEventBus bus) {
        TILE_ENTITIES.register(bus);
    }
}
