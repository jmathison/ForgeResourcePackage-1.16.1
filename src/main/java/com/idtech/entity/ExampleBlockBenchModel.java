package com.idtech.entity;



import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
/**
 * Example BlockBench Model
 * Made with Blockbench 3.9.2
 * Exported for Minecraft version 1.15 - 1.16 with MCP mappings
 * Modified to fit animaitons based on quadped model
 */
public class ExampleBlockBenchModel<T extends ExampleBlockBenchEntity> extends EntityModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer frontLegs;
	private final ModelRenderer frontLeftLeg;
	private final ModelRenderer frontRightLeg;
	private final ModelRenderer backLegs;
	private final ModelRenderer backRightLeg;
	private final ModelRenderer backLeftLeg;

	int x = 0, y = 0, z = 0;

	public ExampleBlockBenchModel() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 21.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-3.0F, -4.0F, -9.0F, 6.0F, 4.0F, 16.0F, 0.0F, false);

		frontLegs = new ModelRenderer(this);
		frontLegs.setRotationPoint(0.0F, 0.0F, 5.0F);
		body.addChild(frontLegs);
		

		frontLeftLeg = new ModelRenderer(this);
		frontLeftLeg.setRotationPoint(-2.0F, 0.0F, 0.0F);
		frontLegs.addChild(frontLeftLeg);
		frontLeftLeg.setTextureOffset(8, 7).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		frontLeftLeg.setTextureOffset(4, 4).addBox(-1.0F, 2.0F, 1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		frontRightLeg = new ModelRenderer(this);
		frontRightLeg.setRotationPoint(0.0F, 3.0F, -5.0F);
		frontLegs.addChild(frontRightLeg);
		frontRightLeg.setTextureOffset(4, 1).addBox(2.0F, -1.0F, 6.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		frontRightLeg.setTextureOffset(0, 10).addBox(2.0F, -3.0F, 5.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		backLegs = new ModelRenderer(this);
		backLegs.setRotationPoint(0.0F, 0.0F, -7.0F);
		body.addChild(backLegs);
		

		backRightLeg = new ModelRenderer(this);
		backRightLeg.setRotationPoint(-2.0F, 0.0F, 0.0F);
		backLegs.addChild(backRightLeg);
		backRightLeg.setTextureOffset(0, 6).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		backRightLeg.setTextureOffset(0, 0).addBox(-1.0F, 2.0F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		backLeftLeg = new ModelRenderer(this);
		backLeftLeg.setRotationPoint(2.0F, 0.0F, 0.0F);
		backLegs.addChild(backLeftLeg);
		backLeftLeg.setTextureOffset(0, 3).addBox(0.0F, 2.0F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		backLeftLeg.setTextureOffset(4, 7).addBox(0.0F, 0.0F, -1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
	}

	/**
	 * Sets this entity's model rotation angles
	 *
	 * @param entityIn
	 * @param limbSwing
	 * @param limbSwingAmount
	 * @param ageInTicks
	 * @param netHeadYaw
	 * @param headPitch
	 */
	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.backRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.backLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.frontRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.frontLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}
}