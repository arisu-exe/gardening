package io.github.fallOut015.gardening.client.renderer.tileentity;

import com.mojang.blaze3d.matrix.MatrixStack;
import io.github.fallOut015.gardening.block.FlowerInstance;
import io.github.fallOut015.gardening.client.renderer.tileentity.model.SoilModel;
import io.github.fallOut015.gardening.tileentity.SoilTileEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;

public class SoilRenderer extends TileEntityRenderer<SoilTileEntity> {
    SoilModel model;

    public SoilRenderer(TileEntityRendererDispatcher dispatcher) {
        super(dispatcher);
        this.model = new SoilModel();
    }

    @Override
    public void render(SoilTileEntity soilTileEntity, float partialTicks, MatrixStack stack, IRenderTypeBuffer renderTypeBuffer, int light, int overlay) {
        stack.pushPose();
        stack.translate(0.5f, 1.0f, 0.5f);
        for(int i = 0; i < soilTileEntity.numSlots(); ++ i) {
            FlowerInstance flower = soilTileEntity.getFlowerAt(i);
            if(flower.hasFlower()) {
                this.model.renderFlower(i, stack, renderTypeBuffer.getBuffer(RenderType.entityCutout(flower.getTextureForAge())), light, overlay, 1.0f, 1.0f, 1.0f, 1.0f);
            }
        }
        stack.popPose();
    }
}