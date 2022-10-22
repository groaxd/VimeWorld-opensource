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

public class SunglassesHeart extends BaseItem
{
    private final MModelRenderer main;
    private final MModelRenderer one;
    private final MModelRenderer glass;
    private final MModelRenderer one2;
    private final MModelRenderer glass2;
    private final MModelRenderer bb_main;

    public SunglassesHeart()
    {
        super(ItemType.HEAD);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.main = new MModelRenderer(this);
        this.main.setRotationPoint(-0.3F, 22.0F, -2.0F);
        this.main.setTextureOffset(13, 2).addBox(0.5F, -5.0F, -4.9F, 1, 1, 1, -0.3001F);
        this.main.setTextureOffset(12, 11).addBox(-1.1F, -5.0F, -4.9F, 1, 1, 1, -0.3001F);
        this.main.setTextureOffset(8, 7).addBox(-0.8F, -5.4F, -4.9F, 2, 1, 1, -0.3001F);
        this.main.setTextureOffset(8, 4).addBox(5.1F, -5.0F, -4.9F, 2, 1, 1, -0.2501F);
        this.main.setTextureOffset(4, 7).addBox(6.3F, -5.0F, -4.5F, 1, 1, 2, -0.2501F);
        this.main.setTextureOffset(0, 6).addBox(6.1F, -4.8F, -3.1F, 1, 1, 2, -0.2501F);
        this.main.setTextureOffset(4, 4).addBox(6.0F, -4.5F, -1.7F, 1, 1, 2, -0.2501F);
        this.one = new MModelRenderer(this);
        this.one.setRotationPoint(-0.6F, 0.2F, -0.5F);
        this.main.addChild(this.one);
        this.one.setTextureOffset(8, 12).addBox(-1.0F, -5.75F, -4.5F, 1, 2, 1, -0.2F);
        this.one.setTextureOffset(0, 11).addBox(-4.6F, -5.75F, -4.5F, 1, 2, 1, -0.2F);
        this.one.setTextureOffset(17, 8).addBox(-1.6F, -6.35F, -4.5F, 1, 1, 1, -0.2F);
        this.one.setTextureOffset(16, 6).addBox(-4.0F, -6.35F, -4.5F, 1, 1, 1, -0.2F);
        this.one.setTextureOffset(14, 16).addBox(-3.4F, -6.35F, -4.5F, 1, 1, 1, -0.2F);
        this.one.setTextureOffset(3, 17).addBox(-2.2F, -6.35F, -4.5F, 1, 1, 1, -0.2F);
        this.one.setTextureOffset(17, 1).addBox(-2.8F, -5.75F, -4.5F, 1, 1, 1, -0.2F);
        this.one.setTextureOffset(7, 17).addBox(-1.6F, -4.15F, -4.5F, 1, 1, 1, -0.2F);
        this.one.setTextureOffset(15, 12).addBox(-2.8F, -2.95F, -4.5F, 1, 1, 1, -0.2F);
        this.one.setTextureOffset(16, 3).addBox(-4.0F, -4.15F, -4.5F, 1, 1, 1, -0.2F);
        this.one.setTextureOffset(0, 16).addBox(-3.4F, -3.55F, -4.5F, 1, 1, 1, -0.2F);
        this.one.setTextureOffset(15, 14).addBox(-2.2F, -3.55F, -4.5F, 1, 1, 1, -0.2F);
        this.glass = new MModelRenderer(this);
        this.glass.setRotationPoint(0.0F, -4.0F, -8.0F);
        this.one.addChild(this.glass);
        this.glass.setTextureOffset(0, 18).addBox(-2.8F, -0.75F, 3.8F, 1, 2, 0, 0.0F);
        this.glass.setTextureOffset(11, 17).addBox(-1.8F, -1.35F, 3.8F, 1, 2, 0, 0.0F);
        this.glass.setTextureOffset(0, 6).addBox(-3.8F, -1.35F, 3.8F, 1, 2, 0, 0.0F);
        this.glass.setTextureOffset(0, 10).addBox(-3.8F, -1.55F, 3.805F, 3, 1, 0, 0.001F);
        this.one2 = new MModelRenderer(this);
        this.one2.setRotationPoint(5.6F, 0.2F, -0.5F);
        this.main.addChild(this.one2);
        this.one2.setTextureOffset(5, 10).addBox(-1.0F, -5.75F, -4.5F, 1, 2, 1, -0.2F);
        this.one2.setTextureOffset(9, 9).addBox(-4.6F, -5.75F, -4.5F, 1, 2, 1, -0.2F);
        this.one2.setTextureOffset(11, 15).addBox(-1.6F, -6.35F, -4.5F, 1, 1, 1, -0.2F);
        this.one2.setTextureOffset(15, 10).addBox(-4.0F, -6.35F, -4.5F, 1, 1, 1, -0.2F);
        this.one2.setTextureOffset(7, 15).addBox(-3.4F, -6.35F, -4.5F, 1, 1, 1, -0.2F);
        this.one2.setTextureOffset(3, 15).addBox(-2.2F, -6.35F, -4.5F, 1, 1, 1, -0.2F);
        this.one2.setTextureOffset(14, 0).addBox(-2.8F, -5.75F, -4.5F, 1, 1, 1, -0.2F);
        this.one2.setTextureOffset(0, 14).addBox(-1.6F, -4.15F, -4.5F, 1, 1, 1, -0.2F);
        this.one2.setTextureOffset(12, 13).addBox(-2.8F, -2.95F, -4.5F, 1, 1, 1, -0.2F);
        this.one2.setTextureOffset(13, 8).addBox(-4.0F, -4.15F, -4.5F, 1, 1, 1, -0.2F);
        this.one2.setTextureOffset(13, 5).addBox(-3.4F, -3.55F, -4.5F, 1, 1, 1, -0.2F);
        this.one2.setTextureOffset(3, 13).addBox(-2.2F, -3.55F, -4.5F, 1, 1, 1, -0.2F);
        this.glass2 = new MModelRenderer(this);
        this.glass2.setRotationPoint(0.0F, -4.0F, -8.0F);
        this.one2.addChild(this.glass2);
        this.glass2.setTextureOffset(4, 0).addBox(-2.8F, -0.75F, 3.8F, 1, 2, 0, 0.0F);
        this.glass2.setTextureOffset(0, 3).addBox(-1.8F, -1.35F, 3.8F, 1, 2, 0, 0.0F);
        this.glass2.setTextureOffset(0, 0).addBox(-3.8F, -1.35F, 3.8F, 1, 2, 0, 0.0F);
        this.glass2.setTextureOffset(8, 2).addBox(-3.8F, -1.55F, 3.805F, 3, 1, 0, 0.001F);
        this.bb_main = new MModelRenderer(this);
        this.bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.bb_main.setTextureOffset(8, 0).addBox(-6.8F, -7.0F, -6.9F, 2, 1, 1, -0.2501F);
        this.bb_main.setTextureOffset(4, 1).addBox(-7.0F, -7.0F, -6.5F, 1, 1, 2, -0.2501F);
        this.bb_main.setTextureOffset(0, 3).addBox(-6.8F, -6.8F, -5.1F, 1, 1, 2, -0.2501F);
        this.bb_main.setTextureOffset(0, 0).addBox(-6.6F, -6.5F, -3.7F, 1, 1, 2, -0.2501F);
        this.setTexture(new ResourceLocation("minidot", "head/sunglasses_heart.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(0.7F, 0.7F, 0.8F);
        GlStateManager.translate(0.0F, -1.4F, 0.05F);
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
        return "\u041e\u0447\u043a\u0438-\u0441\u0435\u0440\u0434\u0435\u0447\u043a\u0438";
    }
}
