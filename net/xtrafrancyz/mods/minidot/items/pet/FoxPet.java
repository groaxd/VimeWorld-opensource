package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class FoxPet extends BasePet
{
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final MModelRenderer bb_main;
    private final String color;

    public FoxPet(String color)
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.color = color;
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(2.0F, 16.0F, -3.0F);
        this.setRotation(this.bone, -1.1345F, 0.0F, 0.0F);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-1.0F, 24.1F, -0.7F);
        this.setRotation(this.bone2, -0.1745F, 0.0F, 0.0F);
        this.bone2.setTextureOffset(8, 29).addBox(1.9F, -4.3746F, -1.819F, 2, 6, 2, 0.0F);
        this.bone2.setTextureOffset(0, 29).addBox(-1.9F, -4.3746F, -1.819F, 2, 6, 2, 0.0F);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(2.0F, 24.4F, 1.3F);
        this.setRotation(this.bone3, 0.4363F, 0.0F, 0.0F);
        this.bone3.setTextureOffset(0, 0).addBox(-5.0F, -9.8218F, -0.5494F, 6, 11, 6, 0.0F);
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(-2.0F, 23.0F, 2.0F);
        this.setRotation(this.bone4, -1.2217F, 0.0F, 0.0F);
        this.bone4.setTextureOffset(22, 15).addBox(2.9F, -3.3424F, 0.4609F, 2, 6, 2, 0.0F);
        this.bone4.setTextureOffset(22, 15).addBox(-0.9F, -3.3424F, 0.4609F, 2, 6, 2, 0.0F);
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(2.0F, 27.0F, 12.0F);
        this.setRotation(this.bone5, 1.3963F, 0.0F, 0.0F);
        this.bone5.setTextureOffset(23, 24).addBox(-4.0F, -9.0F, 0.0F, 4, 9, 5, 0.0F);
        this.bb_main = new MModelRenderer(this);
        this.bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.bb_main.setTextureOffset(0, 17).addBox(-4.0F, -14.0F, -4.0F, 8, 6, 6, 0.0F);
        this.bb_main.setTextureOffset(18, 0).addBox(-2.0F, -10.0F, -7.0F, 4, 2, 3, 0.0F);
        this.bb_main.setTextureOffset(0, 3).addBox(2.0F, -16.0F, -3.0F, 2, 2, 1, 0.0F);
        this.bb_main.setTextureOffset(0, 0).addBox(-4.0F, -16.0F, -3.0F, 2, 2, 1, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "pets/fox_" + color + ".png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.02F;
        float f1 = MathHelper.cos(time * 0.1F);
        GlStateManager.translate(0.7F, -1.0F + f, 0.2F);
        GlStateManager.rotate(f1 * 4.0F, 0.0F, 0.6F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -0.6F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return this.color.equalsIgnoreCase("default") ? "\u041b\u0438\u0441\u0430" : "\u0411\u0435\u043b\u0430\u044f \u043b\u0438\u0441\u0430";
    }

    public String getCreator()
    {
        return "Veltorn";
    }
}
