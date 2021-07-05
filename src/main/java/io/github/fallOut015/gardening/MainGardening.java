package io.github.fallOut015.gardening;

import com.mojang.blaze3d.matrix.MatrixStack;
import io.github.fallOut015.gardening.block.BlocksGardening;
import io.github.fallOut015.gardening.client.registry.ClientRegistryGardening;
import io.github.fallOut015.gardening.item.ItemModelPropertiesGardening;
import io.github.fallOut015.gardening.item.ItemsGardening;
import io.github.fallOut015.gardening.tileentity.TileEntitiesGardening;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.client.event.DrawHighlightEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

@Mod(MainGardening.MODID)
public class MainGardening {
    public static final String MODID = "gardening";
    private static final Logger LOGGER = LogManager.getLogger();
    private static final VoxelShape SELECTION = VoxelShapes.box(0, 0, 0, 0.5, 0.5 + (1d / 16d), 0.5);

    public MainGardening() {
        BlocksGardening.register(FMLJavaModLoadingContext.get().getModEventBus());
        ItemsGardening.register(FMLJavaModLoadingContext.get().getModEventBus());
        TileEntitiesGardening.register(FMLJavaModLoadingContext.get().getModEventBus());

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }
    private void doClientStuff(final FMLClientSetupEvent event) {
        ItemModelPropertiesGardening.doClientStuff(event);
        ClientRegistryGardening.doClientStuff(event);
    }
    private void enqueueIMC(final InterModEnqueueEvent event) {
    }
    private void processIMC(final InterModProcessEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber
    public static class Events {
        @SubscribeEvent
        public static void onHighlightBlock(final DrawHighlightEvent.HighlightBlock event) {
            BlockPos pos = event.getTarget().getBlockPos();
            World level = Minecraft.getInstance().level;
            BlockRayTraceResult result = event.getTarget();
            if(level.getBlockState(pos).is(BlocksGardening.SOIL.get()) && result.getDirection() == Direction.UP) {
                MatrixStack stack = event.getMatrix();
                stack.pushPose();
                Vector3d d = event.getInfo().getPosition();
                stack.translate(pos.getX() - d.x(), pos.getY() - d.y(), pos.getZ() - d.z());
                Vector3d l = result.getLocation();
                double xoff = l.x() - (double) pos.getX() >= 0.5d ? 0.5d : 0;
                double zoff = l.z() - (double) pos.getZ() >= 0.5d ? 0.5d : 0;
                WorldRenderer.renderVoxelShape(stack, event.getBuffers().getBuffer(RenderType.lines()), SELECTION, xoff, 1d - (1d / 16d), zoff, 1.0f, 1.0f, 0, -Math.abs(2f * event.getPartialTicks() - 1.0f) + 1.0f);
                stack.popPose();
            }
        }
    }
}