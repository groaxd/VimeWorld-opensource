package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class SummerBallPet extends BasePet
{
    private final MModelRenderer bb_main;

    public SummerBallPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.bb_main = new MModelRenderer(this);
        this.bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.bb_main.setTextureOffset(38, 37).addBox(-2.0F, -1.0F, -1.0F, 4, 1, 2, 3.0E-4F);
        this.bb_main.setTextureOffset(30, 37).addBox(-1.0F, -1.0F, -2.0F, 2, 1, 4, 0.0F);
        this.bb_main.setTextureOffset(34, 7).addBox(-3.0F, -2.0F, -2.0F, 6, 1, 4, 0.001F);
        this.bb_main.setTextureOffset(14, 32).addBox(-2.0F, -2.0F, -3.0F, 4, 1, 6, 0.0F);
        this.bb_main.setTextureOffset(36, 16).addBox(-4.0F, -3.0F, -1.0F, 8, 1, 2, 0.0F);
        this.bb_main.setTextureOffset(28, 28).addBox(-1.0F, -3.0F, -4.0F, 2, 1, 8, 0.0F);
        this.bb_main.setTextureOffset(18, 16).addBox(-3.0F, -3.0F, -3.0F, 6, 1, 6, 3.0E-4F);
        this.bb_main.setTextureOffset(0, 9).addBox(-2.0F, -4.0F, -4.0F, 4, 1, 8, 0.0F);
        this.bb_main.setTextureOffset(28, 23).addBox(-4.0F, -4.0F, -2.0F, 8, 1, 4, 0.0F);
        this.bb_main.setTextureOffset(0, 18).addBox(-3.0F, -4.0F, -3.0F, 6, 1, 6, 3.0E-4F);
        this.bb_main.setTextureOffset(16, 9).addBox(-3.0F, -5.0F, -3.0F, 6, 1, 6, 3.0E-4F);
        this.bb_main.setTextureOffset(0, 0).addBox(-2.0F, -5.0F, -4.0F, 4, 1, 8, 0.0F);
        this.bb_main.setTextureOffset(0, 25).addBox(-4.0F, -5.0F, -2.0F, 8, 1, 4, 0.0F);
        this.bb_main.setTextureOffset(34, 12).addBox(-4.0F, -6.0F, -1.0F, 8, 1, 2, 0.0F);
        this.bb_main.setTextureOffset(16, 23).addBox(-1.0F, -6.0F, -4.0F, 2, 1, 8, 0.0F);
        this.bb_main.setTextureOffset(16, 0).addBox(-3.0F, -6.0F, -3.0F, 6, 1, 6, 0.0F);
        this.bb_main.setTextureOffset(0, 30).addBox(-2.0F, -7.0F, -3.0F, 4, 1, 6, 0.0F);
        this.bb_main.setTextureOffset(34, 0).addBox(-3.0F, -7.0F, -2.0F, 6, 1, 4, 0.001F);
        this.bb_main.setTextureOffset(36, 19).addBox(-2.0F, -8.0F, -1.0F, 4, 1, 2, 0.0F);
        this.bb_main.setTextureOffset(0, 37).addBox(-1.0F, -8.0F, -2.0F, 2, 1, 4, 3.0E-4F);
        this.setTexture(new ResourceLocation("minidot", "pets/summerball_pet.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.06F;
        GlStateManager.translate(0.65F, -1.2F + f, 0.3F);
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
        super.preRender(modelPlayer, player, time, pi);
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = time * 1.5F;
        GlStateManager.rotate(90.0F + f, 0.0F, 1.0F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -1.0F, 0.0F);
        GlStateManager.scale(1.5F, 1.5F, 1.5F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041f\u043b\u044f\u0436\u043d\u044b\u0439 \u043c\u044f\u0447";
    }
}
