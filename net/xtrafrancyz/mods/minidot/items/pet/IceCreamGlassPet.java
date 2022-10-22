package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class IceCreamGlassPet extends BasePet
{
    private final MModelRenderer main;
    private final MModelRenderer holder;
    private final MModelRenderer cream1;
    private final MModelRenderer cream2;
    private final MModelRenderer cream3;

    public IceCreamGlassPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.main = new MModelRenderer(this);
        this.main.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.main.setTextureOffset(8, 0).addBox(-2.0F, -10.3F, -4.0F, 4, 0, 8, 0.0F);
        this.main.setTextureOffset(0, 16).addBox(-4.0F, -10.3F, -2.0F, 8, 0, 4, 0.0F);
        this.holder = new MModelRenderer(this);
        this.holder.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.main.addChild(this.holder);
        this.holder.setTextureOffset(24, 24).addBox(-1.0F, -1.0F, -2.0F, 2, 2, 4, 0.0F);
        this.holder.setTextureOffset(22, 30).addBox(-2.0F, -1.0F, -1.0F, 4, 2, 2, 0.001F);
        this.holder.setTextureOffset(0, 0).addBox(-1.0F, -3.0F, -1.0F, 2, 2, 2, 0.0F);
        this.holder.setTextureOffset(30, 20).addBox(-2.0F, -5.0F, -1.0F, 4, 2, 2, 0.0F);
        this.holder.setTextureOffset(24, 14).addBox(-1.0F, -5.0F, -2.0F, 2, 2, 4, 0.001F);
        this.holder.setTextureOffset(20, 10).addBox(-3.0F, -7.0F, -1.0F, 6, 2, 2, 0.0F);
        this.holder.setTextureOffset(14, 16).addBox(-1.0F, -7.0F, -3.0F, 2, 2, 6, 0.0F);
        this.holder.setTextureOffset(0, 0).addBox(-2.0F, -9.0F, -4.0F, 4, 2, 8, 0.0F);
        this.holder.setTextureOffset(0, 10).addBox(-4.0F, -9.0F, -2.0F, 8, 2, 4, 0.001F);
        this.holder.setTextureOffset(32, 10).addBox(4.0F, -10.0F, -2.0F, 1, 1, 4, 0.001F);
        this.holder.setTextureOffset(30, 30).addBox(-5.0F, -10.0F, -2.0F, 1, 1, 4, 0.001F);
        this.holder.setTextureOffset(32, 2).addBox(-2.0F, -10.0F, -5.0F, 4, 1, 1, 0.001F);
        this.holder.setTextureOffset(32, 0).addBox(-2.0F, -10.0F, 4.0F, 4, 1, 1, 0.001F);
        this.holder.setTextureOffset(16, 34).addBox(-3.0F, -10.0F, 2.0F, 1, 1, 2, 0.001F);
        this.holder.setTextureOffset(10, 34).addBox(-3.0F, -10.0F, -4.0F, 1, 1, 2, 0.001F);
        this.holder.setTextureOffset(32, 24).addBox(2.0F, -10.0F, 2.0F, 1, 1, 2, 0.001F);
        this.holder.setTextureOffset(34, 4).addBox(2.0F, -10.0F, -4.0F, 1, 1, 2, 0.001F);
        this.holder.setTextureOffset(24, 14).addBox(3.0F, -10.0F, -3.0F, 1, 1, 1, 0.001F);
        this.holder.setTextureOffset(0, 22).addBox(-4.0F, -10.0F, 2.0F, 1, 1, 1, 0.001F);
        this.holder.setTextureOffset(0, 20).addBox(-2.0F, -7.0F, -2.0F, 4, 2, 4, 0.001F);
        this.holder.setTextureOffset(24, 0).addBox(-4.0F, -10.0F, -3.0F, 1, 1, 1, 0.001F);
        this.holder.setTextureOffset(24, 2).addBox(3.0F, -10.0F, 2.0F, 1, 1, 1, 0.001F);
        this.cream1 = new MModelRenderer(this);
        this.cream1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.main.addChild(this.cream1);
        this.cream1.setTextureOffset(0, 26).addBox(1.0F, -11.0F, -2.0F, 2, 1, 4, 0.0F);
        this.cream1.setTextureOffset(32, 15).addBox(1.0F, -12.0F, -0.9F, 2, 1, 2, 0.0F);
        this.cream1.setTextureOffset(0, 32).addBox(0.0F, -11.0F, -0.9F, 4, 1, 2, 0.0F);
        this.cream2 = new MModelRenderer(this);
        this.cream2.setRotationPoint(-2.0F, -0.8F, -2.0F);
        this.main.addChild(this.cream2);
        this.cream2.setTextureOffset(12, 24).addBox(1.0F, -11.0F, -1.9F, 2, 2, 4, 0.0F);
        this.cream2.setTextureOffset(20, 24).addBox(1.0F, -12.0F, -0.9F, 2, 1, 2, 0.0F);
        this.cream2.setTextureOffset(10, 30).addBox(0.0F, -11.0F, -0.9F, 4, 2, 2, -0.005F);
        this.cream3 = new MModelRenderer(this);
        this.cream3.setRotationPoint(-3.0F, -0.2F, 1.0F);
        this.main.addChild(this.cream3);
        this.cream3.setTextureOffset(24, 0).addBox(1.01F, -11.0F, -2.0F, 2, 2, 4, 0.0F);
        this.cream3.setTextureOffset(0, 4).addBox(1.0F, -12.0F, -0.9F, 2, 1, 2, 0.0F);
        this.cream3.setTextureOffset(24, 6).addBox(0.0F, -11.0F, -1.0F, 4, 2, 2, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "pets/icecream_glass.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.05F;
        GlStateManager.translate(0.6F, -1.0F + f, 0.2F);
        super.preRender(modelPlayer, player, time, pi);
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = time * 1.5F;
        GlStateManager.rotate(90.0F + f, 0.0F, 1.0F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
        GlStateManager.translate(0.0F, -0.6F, 0.0F);
        super.renderAsItem(time);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public String getName()
    {
        return "\u041c\u043e\u0440\u043e\u0436\u0435\u043d\u043e\u0435 \u0432 \u0441\u0442\u0430\u043a\u0430\u043d\u0447\u0438\u043a\u0435";
    }
}
