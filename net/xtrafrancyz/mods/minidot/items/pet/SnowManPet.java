package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class SnowManPet extends BasePet
{
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final MModelRenderer bone7;
    private final MModelRenderer bone6;
    private final MModelRenderer bone3;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;

    public SnowManPet()
    {
        this.textureWidth = 34;
        this.textureHeight = 24;
        this.useDisplayLists = true;
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(-0.5F, 24.5F, -0.5F);
        this.bone4.setTextureOffset(0, 0).addBox(-1.5F, -4.5F, -1.5F, 4, 4, 4, 0.0F);
        this.bone4.setTextureOffset(12, 8).addBox(-1.0F, -5.4F, -1.7F, 3, 1, 1, 0.0F);
        this.bone4.setTextureOffset(12, 8).addBox(-1.0F, -5.4F, 1.6F, 3, 1, 1, 0.0F);
        this.bone4.setTextureOffset(10, 19).addBox(1.3F, -5.4F, -1.5F, 1, 1, 4, 0.0F);
        this.bone4.setTextureOffset(10, 19).addBox(-1.3F, -5.4F, -1.5F, 1, 1, 4, 0.0F);
        this.bone4.setTextureOffset(12, 0).addBox(-1.0F, -1.2F, -1.0F, 3, 1, 3, 0.0F);
        this.bone4.setTextureOffset(23, 7).addBox(-1.0F, -4.0F, -1.8F, 3, 3, 1, 0.0F);
        this.bone4.setTextureOffset(12, 13).addBox(-1.0F, -8.0F, -1.1F, 3, 3, 3, 0.0F);
        this.bone4.setTextureOffset(22, 17).addBox(-0.5F, -10.6F, -0.6F, 2, 1, 2, 0.0F);
        this.bone4.setTextureOffset(26, 0).addBox(-1.3F, -8.4F, -1.7F, 3, 1, 1, -0.3F);
        this.bone4.setTextureOffset(0, 19).addBox(-1.0F, -9.4F, -1.2F, 3, 1, 1, -0.3F);
        this.bone4.setTextureOffset(0, 19).addBox(-1.0F, -9.4F, 1.0F, 3, 1, 1, -0.3F);
        this.bone4.setTextureOffset(16, 4).addBox(1.1F, -9.4F, -1.1F, 1, 1, 3, -0.3F);
        this.bone4.setTextureOffset(16, 4).addBox(-1.1F, -9.4F, -1.1F, 1, 1, 3, -0.3F);
        this.bone4.setTextureOffset(26, 0).addBox(-1.3F, -8.4F, 1.5F, 3, 1, 1, -0.3F);
        this.bone4.setTextureOffset(0, 8).addBox(-1.5F, -8.4F, -1.6F, 4, 1, 4, -0.3F);
        this.bone4.setTextureOffset(0, 13).addBox(-1.0F, -10.7F, -1.1F, 3, 3, 3, -0.3F);
        this.bone4.setTextureOffset(26, 0).addBox(-0.7F, -8.4F, -1.7F, 3, 1, 1, -0.3F);
        this.bone4.setTextureOffset(26, 0).addBox(-0.7F, -8.4F, 1.5F, 3, 1, 1, -0.3F);
        this.bone4.setTextureOffset(8, 19).addBox(-0.5F, -7.5F, -1.4F, 2, 2, 1, 0.0F);
        this.bone4.setTextureOffset(30, 6).addBox(0.1F, -4.0F, -2.3F, 1, 1, 1, -0.3F);
        this.bone4.setTextureOffset(30, 6).addBox(0.1F, -3.0F, -2.3F, 1, 1, 1, -0.3F);
        this.bone4.setTextureOffset(30, 6).addBox(-1.0F, -7.3F, -1.8F, 1, 1, 1, -0.3F);
        this.bone4.setTextureOffset(29, 4).addBox(1.0F, -7.3F, -1.8F, 1, 1, 1, -0.3F);
        this.bone4.setTextureOffset(30, 6).addBox(0.8F, -6.6F, -1.9F, 1, 1, 1, -0.4F);
        this.bone4.setTextureOffset(29, 4).addBox(-0.8F, -6.6F, -1.9F, 1, 1, 1, -0.4F);
        this.bone4.setTextureOffset(29, 4).addBox(-0.4F, -6.3F, -1.9F, 1, 1, 1, -0.4F);
        this.bone4.setTextureOffset(30, 6).addBox(0.4F, -6.3F, -1.9F, 1, 1, 1, -0.4F);
        this.bone4.setTextureOffset(30, 6).addBox(0.0F, -6.3F, -1.9F, 1, 1, 1, -0.4F);
        this.bone4.setTextureOffset(28, 11).addBox(1.9F, -5.1F, 0.2F, 2, 1, 1, -0.3F);
        this.bone4.setTextureOffset(28, 11).addBox(-2.8F, -5.1F, 0.2F, 2, 1, 1, -0.3F);
        this.bone4.setTextureOffset(9, 13).addBox(0.0F, -7.1F, -2.8F, 1, 1, 2, -0.3F);
        this.bone4.setTextureOffset(30, 6).addBox(0.1F, -2.0F, -2.3F, 1, 1, 1, -0.3F);
        this.bone4.setTextureOffset(8, 19).addBox(-0.5F, -7.5F, 1.2F, 2, 2, 1, 0.0F);
        this.bone4.setTextureOffset(16, 19).addBox(-1.4F, -7.5F, -0.6F, 1, 2, 2, 0.0F);
        this.bone4.setTextureOffset(16, 19).addBox(1.4F, -7.5F, -0.6F, 1, 2, 2, 0.0F);
        this.bone4.setTextureOffset(23, 7).addBox(-1.0F, -4.0F, 1.9F, 3, 3, 1, 0.0F);
        this.bone4.setTextureOffset(21, 1).addBox(2.0F, -4.0F, -1.0F, 1, 3, 3, 0.0F);
        this.bone4.setTextureOffset(21, 1).addBox(-2.0F, -4.0F, -1.0F, 1, 3, 3, 0.0F);
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(5.1F, -4.9F, -0.8F);
        this.bone4.addChild(this.bone5);
        this.setRotation(this.bone5, 0.0F, 0.0F, -0.7854F);
        this.bone5.setTextureOffset(28, 11).addBox(-1.7142F, -1.4071F, 1.0F, 2, 1, 1, -0.3F);
        this.bone5.setTextureOffset(29, 11).addBox(-5.664F, -6.3569F, 1.0F, 1, 1, 1, -0.3F);
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(-2.9F, -4.9F, -0.8F);
        this.bone4.addChild(this.bone7);
        this.setRotation(this.bone7, 0.0F, 0.0F, 0.7854F);
        this.bone7.setTextureOffset(28, 11).addBox(-1.0636F, -0.6293F, 1.0F, 2, 1, 1, -0.3F);
        this.bone7.setTextureOffset(28, 11).addBox(3.8861F, -5.579F, 1.0F, 1, 1, 1, -0.3F);
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(3.0F, -2.6F, -0.8F);
        this.bone4.addChild(this.bone6);
        this.setRotation(this.bone6, 0.0F, 0.0F, 0.7854F);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(1.1F, -1.3F, -3.4F);
        this.bone4.addChild(this.bone3);
        this.setRotation(this.bone3, -0.2618F, 0.0F, 0.0F);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone3.addChild(this.bone);
        this.setRotation(this.bone, 0.0F, 0.0F, 0.3491F);
        this.bone.setTextureOffset(0, 8).addBox(-2.8883F, -2.9856F, 0.8068F, 1, 2, 1, 0.0F);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(2.1F, -0.4F, 0.0F);
        this.bone3.addChild(this.bone2);
        this.setRotation(this.bone2, 0.0F, 0.0F, -0.3491F);
        this.bone2.setTextureOffset(0, 0).addBox(-1.2323F, -3.6696F, 0.8068F, 1, 2, 1, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "pets/snowmanpet.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.02F;
        float f1 = MathHelper.cos(time * 0.1F);
        GlStateManager.scale(2.0F, 2.0F, 2.0F);
        GlStateManager.translate(0.4F, -0.9F + f, 0.1F);
        GlStateManager.rotate(f1 * 4.0F, 0.0F, 0.6F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -1.35F, 0.0F);
        GlStateManager.scale(2.0F, 2.0F, 2.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0421\u043d\u0435\u0433\u043e\u0432\u0438\u043a";
    }

    public String getCreator()
    {
        return "Veltorn";
    }
}
