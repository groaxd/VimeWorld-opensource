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

public class ButterflyFlower extends BasePet
{
    private final MModelRenderer Butterfly_on_a_flower;
    private final MModelRenderer stebel;
    private final MModelRenderer bone2;
    private final MModelRenderer bone;
    private final MModelRenderer flower;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final MModelRenderer bone6;
    private final MModelRenderer bone7;
    private final MModelRenderer bone8;
    private final MModelRenderer bone9;
    private final MModelRenderer bone10;
    private final MModelRenderer bone11;
    private final MModelRenderer bone12;
    private final MModelRenderer bone13;
    private final MModelRenderer bone14;
    private final IAnimation anim;

    public ButterflyFlower()
    {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.Butterfly_on_a_flower = new MModelRenderer(this);
        this.Butterfly_on_a_flower.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.stebel = new MModelRenderer(this);
        this.stebel.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.Butterfly_on_a_flower.addChild(this.stebel);
        this.stebel.setTextureOffset(4, 15).addBox(-1.0F, -4.0F, 0.0F, 1, 3, 1, 0.0F);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-0.85F, -4.2F, 0.5F);
        this.stebel.addChild(this.bone2);
        this.setRotation(this.bone2, 0.0F, 0.0F, 0.2182F);
        this.bone2.setTextureOffset(0, 0).addBox(-2.9657F, 0.0484F, -1.5F, 3, 0, 3, 0.0F);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.stebel.addChild(this.bone);
        this.setRotation(this.bone, 0.0F, 0.0F, 0.2618F);
        this.bone.setTextureOffset(14, 12).addBox(-2.0012F, -6.6049F, 0.0F, 1, 3, 1, 0.0F);
        this.flower = new MModelRenderer(this);
        this.flower.setRotationPoint(0.1F, -7.7F, 0.0F);
        this.Butterfly_on_a_flower.addChild(this.flower);
        this.flower.setTextureOffset(6, 12).addBox(-0.85F, -1.05F, -0.5F, 2, 1, 2, 0.0F);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.15F, -0.05F, 1.5F);
        this.flower.addChild(this.bone3);
        this.setRotation(this.bone3, 0.1745F, 0.0F, 0.0F);
        this.bone3.setTextureOffset(7, 3).addBox(-1.0F, 0.0F, 0.0F, 2, 0, 3, 0.0F);
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(0.15F, -0.05F, -0.5F);
        this.flower.addChild(this.bone4);
        this.setRotation(this.bone4, -0.1745F, 0.0F, 0.0F);
        this.bone4.setTextureOffset(6, 0).addBox(-1.0F, 0.0F, -3.0F, 2, 0, 3, 0.0F);
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(1.15F, -0.05F, 0.5F);
        this.flower.addChild(this.bone5);
        this.setRotation(this.bone5, 0.0F, 0.0F, -0.1745F);
        this.bone5.setTextureOffset(12, 2).addBox(0.0F, 0.0F, -1.0F, 3, 0, 2, 0.0F);
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(-0.85F, -0.05F, 0.5F);
        this.flower.addChild(this.bone6);
        this.setRotation(this.bone6, 0.0F, 0.0F, 0.1745F);
        this.bone6.setTextureOffset(11, 0).addBox(-3.0F, 0.0F, -1.0F, 3, 0, 2, 0.0F);
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(-0.75F, -0.05F, 1.15F);
        this.flower.addChild(this.bone7);
        this.setRotation(this.bone7, 0.0F, 0.7854F, 0.1745F);
        this.bone7.setTextureOffset(8, 10).addBox(-3.0F, 0.0F, -1.0F, 3, 0, 2, 0.0F);
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(0.55F, -0.05F, 1.15F);
        this.flower.addChild(this.bone8);
        this.setRotation(this.bone8, 0.0F, -0.7854F, -0.1745F);
        this.bone8.setTextureOffset(8, 8).addBox(0.0F, 0.0F, -1.0F, 3, 0, 2, 0.0F);
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(0.55F, -0.05F, -0.15F);
        this.flower.addChild(this.bone9);
        this.setRotation(this.bone9, 0.0F, 0.7854F, -0.1745F);
        this.bone9.setTextureOffset(8, 6).addBox(0.0F, 0.0F, -1.0F, 3, 0, 2, 0.0F);
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(-0.75F, -0.05F, -0.15F);
        this.flower.addChild(this.bone10);
        this.setRotation(this.bone10, 0.0F, -0.7854F, 0.1745F);
        this.bone10.setTextureOffset(0, 3).addBox(-3.0F, 0.0F, -1.0F, 3, 0, 2, 0.0F);
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(-1.0F, -8.5F, 1.5F);
        this.Butterfly_on_a_flower.addChild(this.bone11);
        this.setRotation(this.bone11, 0.2618F, 0.829F, 0.4363F);
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(0.5F, 10.0F, -0.5F);
        this.bone11.addChild(this.bone12);
        this.bone12.setTextureOffset(0, 13).addBox(-1.0F, -14.0F, 0.0F, 1, 4, 1, 0.0F);
        this.bone12.setTextureOffset(0, 7).addBox(-0.5F, -16.0F, -1.5F, 0, 2, 4, 0.0F);
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(-0.5F, -12.0F, 0.0F);
        this.bone12.addChild(this.bone13);
        this.setRotation(this.bone13, 0.0F, 0.7418F, 0.0F);
        this.bone13.setTextureOffset(0, 3).addBox(0.0F, -1.5F, -4.5F, 0, 3, 5, 0.0F);
        this.bone14 = new MModelRenderer(this);
        this.bone14.setRotationPoint(-0.5F, -12.0F, 1.0F);
        this.bone12.addChild(this.bone14);
        this.setRotation(this.bone14, 0.0F, -0.7418F, 0.0F);
        this.bone14.setTextureOffset(0, 0).addBox(0.0F, -1.5F, -0.5F, 0, 3, 5, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "pets/butterflyflower.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/butterflyflower_animation.json"));
        this.anim = bbanimationloader.mustGet("butterfly_animation", this);
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.05F;
        GlStateManager.scale(1.3F, 1.3F, 1.3F);
        GlStateManager.translate(0.5F, -0.9F + f, 0.1F);
        this.anim.tick(time);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -0.8F, 0.0F);
        GlStateManager.scale(1.5F, 1.5F, 1.5F);
        this.anim.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0411\u0430\u0431\u043e\u0447\u043a\u0430 \u043d\u0430 \u0446\u0432\u0435\u0442\u043a\u0435";
    }

    public String getCreator()
    {
        return "xRolaaan";
    }
}
