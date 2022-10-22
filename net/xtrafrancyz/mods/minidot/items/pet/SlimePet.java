package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class SlimePet extends BasePet
{
    private final MModelRenderer small;
    private final MModelRenderer mouth;
    private final MModelRenderer leftEye;
    private final MModelRenderer rightEye;
    private final MModelRenderer slime;

    public SlimePet()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.useDisplayLists = true;
        this.slime = new MModelRenderer(this, 0, 0);
        this.slime.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8);
        this.small = new MModelRenderer(this, 0, 16);
        this.small.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6);
        this.mouth = new MModelRenderer(this, 32, 8);
        this.mouth.addBox(0.0F, 1.0F, -3.4F, 1, 1, 1);
        this.leftEye = new MModelRenderer(this, 32, 0);
        this.leftEye.addBox(1.4F, -2.0F, -3.4F, 2, 2, 2);
        this.rightEye = new MModelRenderer(this, 32, 0);
        this.rightEye.addBox(-3.4F, -2.0F, -3.4F, 2, 2, 2);
        this.setTexture(new ResourceLocation("minidot", "pets/slime.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        float f1 = MathHelper.sin(time * 0.2F) * 0.05F + 1.5F;
        GlStateManager.translate(0.6F, -0.5F + f, 0.4F);
        GlStateManager.scale(f1, f1 + f * 3.0F, f1);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 0.8F);
        super.render(modelPlayer, player, time, pi);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.blendFunc(770, 771);
        GlStateManager.enableBlend();
        GlStateManager.scale(1.7F, 1.7F, 1.7F);
        super.renderAsItem(time);
        GlStateManager.disableBlend();
    }

    public String getName()
    {
        return "\u0421\u043b\u0430\u0439\u043c";
    }
}
