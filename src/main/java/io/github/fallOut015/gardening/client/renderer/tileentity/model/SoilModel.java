package io.github.fallOut015.gardening.client.renderer.tileentity.model;

// Made with Blockbench 3.9.1
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.fml.common.Mod;

public class SoilModel extends Model {
	private final ModelRenderer bb_main;
	private final ModelRenderer[] modelsTLBR;
	private final ModelRenderer[] modelsTRBL;

	public SoilModel() {
		super(RenderType::entityCutout);

		this.modelsTLBR = new ModelRenderer[4];
		this.modelsTRBL = new ModelRenderer[4];

		texWidth = 8;
		texHeight = 9;

		bb_main = new ModelRenderer(this);
		bb_main.setPos(0.0F, 24.0F, 0.0F);

		this.modelsTRBL[0] = new ModelRenderer(this);
		this.modelsTRBL[0].setPos(0.0F, 0.0F, 0.0F);
		bb_main.addChild(this.modelsTRBL[0]);
		setRotationAngle(this.modelsTRBL[0], 0.0F, -0.7854F, 0.0F);
		this.modelsTRBL[0].texOffs(0, 0).addBox(-4.25F, -8.0F, 5.75F, 8.0F, 9.0F, 0.0F, 0.0F, false);

		this.modelsTLBR[0] = new ModelRenderer(this);
		this.modelsTLBR[0].setPos(0.0F, 0.0F, 0.0F);
		bb_main.addChild(this.modelsTLBR[0]);
		setRotationAngle(this.modelsTLBR[0], 0.0F, 0.7854F, 0.0F);
		this.modelsTLBR[0].texOffs(0, 0).addBox(-9.5F, -8.0F, 0.0F, 8.0F, 9.0F, 0.0F, 0.0F, false);

		this.modelsTRBL[1] = new ModelRenderer(this);
		this.modelsTRBL[1].setPos(8.0F, 0.0F, 0.0F);
		bb_main.addChild(this.modelsTRBL[1]);
		setRotationAngle(this.modelsTRBL[1], 0.0F, -0.7854F, 0.0F);
		this.modelsTRBL[1].texOffs(0, 0).addBox(-4.25F, -8.0F, 5.75F, 8.0F, 9.0F, 0.0F, 0.0F, false);

		this.modelsTLBR[1] = new ModelRenderer(this);
		this.modelsTLBR[1].setPos(8.0F, 0.0F, 0.0F);
		bb_main.addChild(this.modelsTLBR[1]);
		setRotationAngle(this.modelsTLBR[1], 0.0F, 0.7854F, 0.0F);
		this.modelsTLBR[1].texOffs(0, 0).addBox(-9.5F, -8.0F, 0.0F, 8.0F, 9.0F, 0.0F, 0.0F, false);

		this.modelsTRBL[2] = new ModelRenderer(this);
		this.modelsTRBL[2].setPos(0.0F, 0.0F, -8.0F);
		bb_main.addChild(this.modelsTRBL[2]);
		setRotationAngle(this.modelsTRBL[2], 0.0F, -0.7854F, 0.0F);
		this.modelsTRBL[2].texOffs(0, 0).addBox(-4.25F, -8.0F, 5.75F, 8.0F, 9.0F, 0.0F, 0.0F, false);

		this.modelsTLBR[2] = new ModelRenderer(this);
		this.modelsTLBR[2].setPos(0.0F, 0.0F, -8.0F);
		bb_main.addChild(this.modelsTLBR[2]);
		setRotationAngle(this.modelsTLBR[2], 0.0F, 0.7854F, 0.0F);
		this.modelsTLBR[2].texOffs(0, 0).addBox(-9.5F, -8.0F, 0.0F, 8.0F, 9.0F, 0.0F, 0.0F, false);

		this.modelsTRBL[3] = new ModelRenderer(this);
		this.modelsTRBL[3].setPos(8.0F, 0.0F, -8.0F);
		bb_main.addChild(this.modelsTRBL[3]);
		setRotationAngle(this.modelsTRBL[3], 0.0F, -0.7854F, 0.0F);
		this.modelsTRBL[3].texOffs(0, 0).addBox(-4.25F, -8.0F, 5.75F, 8.0F, 9.0F, 0.0F, 0.0F, false);

		this.modelsTLBR[3] = new ModelRenderer(this);
		this.modelsTLBR[3].setPos(8.0F, 0.0F, -8.0F);
		bb_main.addChild(this.modelsTLBR[3]);
		setRotationAngle(this.modelsTLBR[3], 0.0F, 0.7854F, 0.0F);
		this.modelsTLBR[3].texOffs(0, 0).addBox(-9.5F, -8.0F, 0.0F, 8.0F, 9.0F, 0.0F, 0.0F, false);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	@Override
	public void renderToBuffer(MatrixStack stack, IVertexBuilder vertexBuilder, int light, int overlay, float r, float g, float b, float a) {
	}

	public void renderFlower(int i, MatrixStack stack, IVertexBuilder vertexBuilder, int light, int overlay, float r, float g, float b, float a) {
		this.modelsTLBR[i].render(stack, vertexBuilder, light, overlay, r, g, b, a);
		this.modelsTRBL[i].render(stack, vertexBuilder, light, overlay, r, g, b, a);
	}
}