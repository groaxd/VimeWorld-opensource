package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class SunglassesBlue extends BaseItem
{
    private final MModelRenderer main;
    private final MModelRenderer one3;
    private final MModelRenderer glass3;
    private final MModelRenderer one2;
    private final MModelRenderer glass4;
    private final MModelRenderer bb_main;

    public SunglassesBlue()
    {
        super(ItemType.HEAD);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.main = new MModelRenderer(this);
        this.main.setRotationPoint(-0.3F, 22.0F, -2.0F);
        this.main.setTextureOffset(17, 5).addBox(0.5F, -5.0F, -4.9F, 1, 1, 1, -0.3001F);
        this.main.setTextureOffset(17, 1).addBox(-1.1F, -5.0F, -4.9F, 1, 1, 1, -0.3001F);
        this.main.setTextureOffset(0, 10).addBox(-0.8F, -5.4F, -4.9F, 2, 1, 1, -0.3001F);
        this.main.setTextureOffset(9, 9).addBox(5.1F, -5.0F, -4.9F, 2, 1, 1, -0.2501F);
        this.main.setTextureOffset(4, 7).addBox(6.3F, -5.0F, -4.5F, 1, 1, 2, -0.2501F);
        this.main.setTextureOffset(0, 6).addBox(6.1F, -4.8F, -3.1F, 1, 1, 2, -0.2501F);
        this.main.setTextureOffset(4, 4).addBox(6.0F, -4.5F, -1.7F, 1, 1, 2, -0.2501F);
        this.one3 = new MModelRenderer(this);
        this.one3.setRotationPoint(-0.4F, 0.2F, -0.5F);
        this.main.addChild(this.one3);
        this.one3.setTextureOffset(13, 5).addBox(-5.0F, -5.65F, -4.5F, 1, 2, 1, -0.2F);
        this.one3.setTextureOffset(4, 13).addBox(-1.0F, -5.15F, -4.5F, 1, 2, 1, -0.2F);
        this.one3.setTextureOffset(8, 4).addBox(-4.4F, -6.35F, -4.5F, 2, 1, 1, -0.2F);
        this.one3.setTextureOffset(8, 0).addBox(-3.2F, -2.95F, -4.5F, 2, 1, 1, -0.2F);
        this.one3.setTextureOffset(3, 16).addBox(-3.8F, -3.55F, -4.5F, 1, 1, 1, -0.2F);
        this.one3.setTextureOffset(14, 0).addBox(-4.4F, -4.15F, -4.5F, 1, 1, 1, -0.2F);
        this.one3.setTextureOffset(14, 0).addBox(-4.8F, -6.05F, -4.5F, 1, 1, 1, -0.2005F);
        this.one3.setTextureOffset(14, 0).addBox(5.0F, -6.05F, -4.5F, 1, 1, 1, -0.2005F);
        this.one3.setTextureOffset(14, 0).addBox(-1.2F, -6.05F, -4.5F, 1, 1, 1, -0.2005F);
        this.one3.setTextureOffset(14, 0).addBox(1.4F, -6.05F, -4.5F, 1, 1, 1, -0.2005F);
        this.one3.setTextureOffset(14, 0).addBox(-1.4F, -3.55F, -4.5F, 1, 1, 1, -0.2005F);
        this.one3.setTextureOffset(14, 0).addBox(1.6F, -3.55F, -4.5F, 1, 1, 1, -0.2005F);
        this.one3.setTextureOffset(15, 12).addBox(-2.8F, -6.35F, -4.5F, 1, 1, 1, -0.2F);
        this.one3.setTextureOffset(15, 10).addBox(-2.2F, -6.35F, -4.5F, 1, 1, 1, -0.2F);
        this.one3.setTextureOffset(15, 3).addBox(-1.6F, -6.35F, -4.5F, 1, 1, 1, -0.2F);
        this.one3.setTextureOffset(0, 15).addBox(-1.0F, -5.75F, -4.5F, 1, 1, 1, -0.2F);
        this.one3.setTextureOffset(14, 8).addBox(-1.6F, -3.55F, -4.5F, 1, 1, 1, -0.2F);
        this.glass3 = new MModelRenderer(this);
        this.glass3.setRotationPoint(0.0F, -4.0F, -8.0F);
        this.one3.addChild(this.glass3);
        this.glass3.setTextureOffset(14, 18).addBox(-3.6F, -1.75F, 4.0F, 1, 3, 0, -0.001F);
        this.glass3.setTextureOffset(14, 18).addBox(-4.597F, -1.85F, 4.0F, 1, 2, 0, -0.001F);
        this.glass3.setTextureOffset(0, 12).addBox(-2.603F, -1.75F, 4.0F, 2, 3, 0, -0.0013F);
        this.one2 = new MModelRenderer(this);
        this.one2.setRotationPoint(5.8F, 0.2F, -0.5F);
        this.main.addChild(this.one2);
        this.one2.setTextureOffset(12, 14).addBox(-1.0F, -5.65F, -4.5F, 1, 2, 1, -0.2F);
        this.one2.setTextureOffset(8, 13).addBox(-5.0F, -5.15F, -4.5F, 1, 2, 1, -0.2F);
        this.one2.setTextureOffset(5, 11).addBox(-2.6F, -6.35F, -4.5F, 2, 1, 1, -0.2F);
        this.one2.setTextureOffset(3, 18).addBox(-1.6F, -4.15F, -4.5F, 1, 1, 1, -0.2F);
        this.one2.setTextureOffset(10, 2).addBox(-3.8F, -2.95F, -4.5F, 2, 1, 1, -0.2F);
        this.one2.setTextureOffset(10, 17).addBox(-4.4F, -3.55F, -4.5F, 1, 1, 1, -0.2F);
        this.one2.setTextureOffset(15, 16).addBox(-4.4F, -6.35F, -4.5F, 1, 1, 1, -0.2F);
        this.one2.setTextureOffset(16, 14).addBox(-3.8F, -6.35F, -4.5F, 1, 1, 1, -0.2F);
        this.one2.setTextureOffset(7, 16).addBox(-3.2F, -6.35F, -4.5F, 1, 1, 1, -0.2F);
        this.one2.setTextureOffset(0, 17).addBox(-5.0F, -5.75F, -4.5F, 1, 1, 1, -0.2F);
        this.one2.setTextureOffset(17, 7).addBox(-2.2F, -3.55F, -4.5F, 1, 1, 1, -0.2F);
        this.glass4 = new MModelRenderer(this);
        this.glass4.setRotationPoint(5.8F, -4.0F, -8.0F);
        this.one2.addChild(this.glass4);
        this.glass4.setTextureOffset(14, 18).addBox(-8.206F, -1.75F, 4.0F, 1, 3, 0, -0.001F);
        this.glass4.setTextureOffset(14, 18).addBox(-7.206F, -1.85F, 4.0F, 1, 2, 0, -0.001F);
        this.glass4.setTextureOffset(0, 12).addBox(-10.203F, -1.75F, 4.0F, 2, 3, 0, -0.0013F);
        this.bb_main = new MModelRenderer(this);
        this.bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.bb_main.setTextureOffset(8, 7).addBox(-6.8F, -7.0F, -6.9F, 2, 1, 1, -0.2501F);
        this.bb_main.setTextureOffset(4, 1).addBox(-7.0F, -7.0F, -6.5F, 1, 1, 2, -0.2501F);
        this.bb_main.setTextureOffset(0, 3).addBox(-6.8F, -6.8F, -5.1F, 1, 1, 2, -0.2501F);
        this.bb_main.setTextureOffset(0, 0).addBox(-6.6F, -6.5F, -3.7F, 1, 1, 2, -0.2501F);
        this.setTexture(new ResourceLocation("minidot", "head/sunglasses_blue.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(0.7F, 0.7F, 0.8F);
        GlStateManager.translate(0.0F, -1.425F, 0.05F);
    }

    public void itemMotion(float rotation, int number)
    {
        GlStateManager.rotate(180.0F + MathHelper.sin(rotation * 0.04F + (float)number) * 30.0F, 0.0F, 0.2F, 0.0F);
        GlStateManager.translate(0.0F, -1.55F, 0.2F);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public String getName()
    {
        return "\u0413\u043e\u043b\u0443\u0431\u044b\u0435 \u043e\u0447\u043a\u0438";
    }
}
