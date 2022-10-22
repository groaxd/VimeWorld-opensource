package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class RoyalAnvil extends BasePet
{
    private final MModelRenderer main;
    private final MModelRenderer bone18;
    private final MModelRenderer bone8;
    private final MModelRenderer Damge;
    private final MModelRenderer bone9;
    private final MModelRenderer bone16;
    private final MModelRenderer bone14;
    private final MModelRenderer bone11;
    private final MModelRenderer bone12;
    private final MModelRenderer bone15;
    private final MModelRenderer bone10;
    private final MModelRenderer bone13;
    private final MModelRenderer bone7;
    private final MModelRenderer bone6;
    private final MModelRenderer bone5;
    private final MModelRenderer bone4;
    private final MModelRenderer bone3;
    private final MModelRenderer bone17;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final IAnimation animation;

    public RoyalAnvil()
    {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.main = new MModelRenderer(this);
        this.main.setRotationPoint(-1.0F, 24.0F, -2.0F);
        this.main.setTextureOffset(0, 15).addBox(-3.0F, -7.0F, -1.0F, 8, 0, 5, 0.0F);
        this.main.setTextureOffset(2, 2).addBox(-2.0F, -4.0F, 0.0F, 6, 3, 3, 0.0F);
        this.main.setTextureOffset(0, 1).addBox(-3.0F, -5.0F, -1.0F, 8, 2, 5, -0.2F);
        this.main.setTextureOffset(0, 0).addBox(-3.0F, -7.0F, -1.0F, 8, 3, 5, -0.001F);
        this.main.setTextureOffset(0, 2).addBox(-3.0F, -1.0F, -1.0F, 8, 1, 5, 0.0F);
        this.bone18 = new MModelRenderer(this);
        this.bone18.setRotationPoint(1.0F, -7.0F, 4.0F);
        this.main.addChild(this.bone18);
        this.bone18.setTextureOffset(0, 10).addBox(-3.0F, 0.0F, 0.0F, 6, 5, 0, 0.0F);
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(1.0F, -7.0F, -1.0F);
        this.main.addChild(this.bone8);
        this.setRotation(this.bone8, -0.0436F, 0.0F, 0.0F);
        this.bone8.setTextureOffset(0, 10).addBox(-3.0F, 0.0F, -0.001F, 6, 5, 0, 0.0F);
        this.Damge = new MModelRenderer(this);
        this.Damge.setRotationPoint(3.25F, -7.25F, 2.0F);
        this.main.addChild(this.Damge);
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Damge.addChild(this.bone9);
        this.setRotation(this.bone9, 0.2618F, 0.0F, 0.0F);
        this.bone9.setTextureOffset(0, 0).addBox(-3.0F, 0.0F, 0.0F, 1, 0, 3, 0.0F);
        this.bone16 = new MModelRenderer(this);
        this.bone16.setRotationPoint(0.25F, 0.0F, -0.75F);
        this.Damge.addChild(this.bone16);
        this.setRotation(this.bone16, 0.2618F, 0.7854F, 0.0F);
        this.bone16.setTextureOffset(0, 0).addBox(-2.4142F, -0.366F, -1.366F, 1, 0, 3, 0.0F);
        this.bone14 = new MModelRenderer(this);
        this.bone14.setRotationPoint(-0.75F, 0.0F, 0.25F);
        this.Damge.addChild(this.bone14);
        this.setRotation(this.bone14, 0.2618F, -0.7854F, 0.0F);
        this.bone14.setTextureOffset(0, 0).addBox(-2.4142F, 0.366F, 1.366F, 1, 0, 3, 0.0F);
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(-1.5F, 0.0F, 0.0F);
        this.Damge.addChild(this.bone11);
        this.setRotation(this.bone11, 0.2618F, -1.5708F, 0.0F);
        this.bone11.setTextureOffset(0, 0).addBox(-1.0F, 0.5176F, 1.9319F, 1, 0, 3, 0.0F);
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(-1.5F, 0.0F, -1.5F);
        this.Damge.addChild(this.bone12);
        this.setRotation(this.bone12, 0.2618F, 3.1416F, 0.0F);
        this.bone12.setTextureOffset(0, 0).addBox(1.0F, 0.0F, 0.0F, 1, 0, 3, 0.0F);
        this.bone15 = new MModelRenderer(this);
        this.bone15.setRotationPoint(-1.75F, 0.0F, -0.75F);
        this.Damge.addChild(this.bone15);
        this.setRotation(this.bone15, 0.0F, -2.3562F, 0.0F);
        this.bone15.setTextureOffset(0, 0).addBox(0.4142F, 0.0F, 1.4142F, 1, 0, 3, 0.0F);
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(0.0F, 0.0F, -1.5F);
        this.Damge.addChild(this.bone10);
        this.setRotation(this.bone10, 0.2618F, 1.5708F, 0.0F);
        this.bone10.setTextureOffset(0, 0).addBox(-1.0F, -0.5176F, -1.9319F, 1, 0, 3, 0.0F);
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(-0.75F, 0.0F, -1.75F);
        this.Damge.addChild(this.bone13);
        this.setRotation(this.bone13, 0.2618F, 2.3562F, 0.0F);
        this.bone13.setTextureOffset(0, 0).addBox(0.4142F, -0.366F, -1.366F, 1, 0, 3, 0.0F);
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(1.0F, -7.0F, 1.0F);
        this.main.addChild(this.bone7);
        this.setRotation(this.bone7, 0.0F, -0.3927F, 0.0F);
        this.bone7.setTextureOffset(13, 15).addBox(-1.8376F, -0.5F, -1.392F, 3, 1, 4, -0.1F);
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.main.addChild(this.bone6);
        this.setRotation(this.bone6, 0.0F, 0.0F, 0.1309F);
        this.bone6.setTextureOffset(5, 0).addBox(-5.2268F, -4.4608F, -1.0F, 2, 3, 5, -0.2F);
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.main.addChild(this.bone5);
        this.setRotation(this.bone5, 0.0F, 0.0F, -0.1309F);
        this.bone5.setTextureOffset(5, 0).addBox(5.2097F, -4.1997F, -1.0F, 2, 3, 5, -0.2F);
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.main.addChild(this.bone4);
        this.setRotation(this.bone4, 0.0F, 0.0F, -0.1309F);
        this.bone4.setTextureOffset(5, 0).addBox(5.2183F, -4.3303F, -1.0F, 1, 3, 5, 0.0F);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.main.addChild(this.bone3);
        this.setRotation(this.bone3, 0.0F, 0.0F, 0.1309F);
        this.bone3.setTextureOffset(5, 0).addBox(-4.2354F, -4.5913F, -1.0F, 1, 3, 5, 0.0F);
        this.bone17 = new MModelRenderer(this);
        this.bone17.setRotationPoint(5.0F, -5.0F, 0.0F);
        this.main.addChild(this.bone17);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone17.addChild(this.bone);
        this.setRotation(this.bone, 0.0F, 0.0F, -0.48F);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone17.addChild(this.bone2);
        this.setRotation(this.bone2, 0.0F, 0.0F, -0.2618F);
        this.bone2.setTextureOffset(0, 8).addBox(-3.4925F, -4.7609F, 1.0F, 7, 1, 1, 0.0F);
        this.bone2.setTextureOffset(16, 8).addBox(-4.4667F, -6.2575F, 0.0F, 2, 4, 3, -0.2F);
        this.setTexture(new ResourceLocation("minidot", "pets/royalanvil.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/royalanvil_animation.json"));
        this.animation = bbanimationloader.mustGet("anvil.cracking", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.04F;
        GlStateManager.translate(0.75F, -1.1F + f, 0.25F);
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
        this.animation.tick(time);
        super.preRender(modelPlayer, player, time, pi);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(1.5F, 1.5F, 1.5F);
        GlStateManager.translate(0.0F, -0.7F, 0.0F);
        this.animation.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041a\u043e\u0440\u043e\u043b\u0435\u0432\u0441\u043a\u0430\u044f \u043d\u0430\u043a\u043e\u0432\u0430\u043b\u044c\u043d\u044f";
    }

    public String getCreator()
    {
        return "Rander_";
    }
}
