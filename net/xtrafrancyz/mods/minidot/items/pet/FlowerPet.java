package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.List;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;
import net.xtrafrancyz.mods.minidot.util.MNaming;

public class FlowerPet extends BasePet
{
    private final MModelRenderer Flower;
    private final MModelRenderer face;
    private final MModelRenderer bone2;
    private final MModelRenderer nojka;
    private final MModelRenderer bone11;
    private final MModelRenderer bone12;
    private final MModelRenderer bone13;
    private final MModelRenderer bone14;
    private final MModelRenderer bone9;
    private final MModelRenderer bone7;
    private final MModelRenderer bone8;
    private final MModelRenderer bone10;
    private final MModelRenderer bone5;
    private final MModelRenderer bone4;
    private final MModelRenderer bone6;
    private final MModelRenderer bone3;
    private final String color;
    private final IAnimation anim;

    public FlowerPet(String color)
    {
        this.color = color;
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.Flower = new MModelRenderer(this);
        this.Flower.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.face = new MModelRenderer(this);
        this.face.setRotationPoint(0.0F, -8.0F, 0.5F);
        this.Flower.addChild(this.face);
        this.setRotation(this.face, -0.1309F, 0.0F, 0.0F);
        this.face.setTextureOffset(11, 11).addBox(-2.5F, 3.0F, -0.5002F, 5, 1, 1, 0.001F);
        this.face.setTextureOffset(4, 12).addBox(-5.5F, -1.5F, -0.5002F, 1, 3, 1, 0.0F);
        this.face.setTextureOffset(8, 13).addBox(-1.5F, -1.5F, -2.0E-4F, 3, 3, 1, 0.0F);
        this.face.setTextureOffset(0, 12).addBox(4.5F, -1.5F, -0.5002F, 1, 3, 1, 0.0F);
        this.face.setTextureOffset(0, 10).addBox(-2.5F, -4.0F, -0.5002F, 5, 1, 1, 0.001F);
        this.face.setTextureOffset(0, 8).addBox(-4.0F, -3.5F, -0.5F, 8, 1, 1, 0.0F);
        this.face.setTextureOffset(0, 6).addBox(-4.0F, 2.5F, -0.5F, 8, 1, 1, 0.0F);
        this.face.setTextureOffset(0, 0).addBox(-5.0F, -2.5F, -0.5F, 10, 5, 1, 0.001F);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.0F, 0.0F, -0.5F);
        this.face.addChild(this.bone2);
        this.bone2.setTextureOffset(22, 0).addBox(-2.0F, -1.0F, -5.0E-4F, 4, 2, 1, 0.002F);
        this.nojka = new MModelRenderer(this);
        this.nojka.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Flower.addChild(this.nojka);
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(0.3F, -0.1F, 0.3F);
        this.nojka.addChild(this.bone11);
        this.setRotation(this.bone11, 0.0F, 0.0F, 0.1745F);
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(-1.15F, -0.25F, -0.5F);
        this.bone11.addChild(this.bone12);
        this.setRotation(this.bone12, 0.5236F, 0.0F, 1.0472F);
        this.bone12.setTextureOffset(0, 16).addBox(-2.0F, -0.75F, 3.0F, 4, 1, 0, 0.0F);
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(-1.15F, -0.25F, -2.5F);
        this.bone11.addChild(this.bone13);
        this.setRotation(this.bone13, 0.0F, 0.0F, 1.0472F);
        this.bone13.setTextureOffset(0, 17).addBox(-2.0F, -4.15F, 4.2239F, 4, 2, 0, 0.0F);
        this.bone14 = new MModelRenderer(this);
        this.bone14.setRotationPoint(-1.15F, -0.25F, -2.5F);
        this.bone11.addChild(this.bone14);
        this.setRotation(this.bone14, -0.5236F, 0.0F, 1.0472F);
        this.bone14.setTextureOffset(0, 19).addBox(-2.0F, -7.7065F, 1.5839F, 4, 2, 0, 0.0F);
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(-0.3F, -0.1F, 0.3F);
        this.nojka.addChild(this.bone9);
        this.setRotation(this.bone9, 0.0F, 0.0F, -0.1745F);
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(1.15F, -0.25F, -0.5F);
        this.bone9.addChild(this.bone7);
        this.setRotation(this.bone7, 0.5236F, 0.0F, -1.0472F);
        this.bone7.setTextureOffset(0, 16).addBox(-2.0F, -0.75F, 3.0F, 4, 1, 0, 0.0F);
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(1.15F, -0.25F, -2.5F);
        this.bone9.addChild(this.bone8);
        this.setRotation(this.bone8, 0.0F, 0.0F, -1.0472F);
        this.bone8.setTextureOffset(0, 17).addBox(-2.0F, -4.15F, 4.2239F, 4, 2, 0, 0.0F);
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(1.15F, -0.25F, -2.5F);
        this.bone9.addChild(this.bone10);
        this.setRotation(this.bone10, -0.5236F, 0.0F, -1.0472F);
        this.bone10.setTextureOffset(0, 19).addBox(-2.0F, -7.7065F, 1.5839F, 4, 2, 0, 0.0F);
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(0.0F, -1.0F, -0.25F);
        this.nojka.addChild(this.bone5);
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(0.0F, -6.5F, 2.45F);
        this.bone5.addChild(this.bone4);
        this.setRotation(this.bone4, 1.0472F, 0.0F, 0.0F);
        this.bone4.setTextureOffset(20, 13).addBox(-0.5F, -1.1397F, -0.658F, 1, 1, 1, 0.001F);
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(0.0F, -6.5F, 2.45F);
        this.bone5.addChild(this.bone6);
        this.setRotation(this.bone6, 0.5236F, 0.0F, 0.0F);
        this.bone6.setTextureOffset(20, 15).addBox(-0.5F, -0.292F, -0.7737F, 1, 1, 1, 0.0F);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone5.addChild(this.bone3);
        this.bone3.setTextureOffset(24, 10).addBox(-0.5F, -6.0F, 2.25F, 1, 7, 1, 0.0F);
        this.bone3.setTextureOffset(24, 10).addBox(-0.75F, -6.0F, 2.0F, 1, 7, 1, 0.0F);
        this.bone3.setTextureOffset(24, 10).addBox(-0.25F, -6.0F, 2.0F, 1, 7, 1, 0.0F);
        this.bone3.setTextureOffset(24, 10).addBox(-0.5F, -6.0F, 1.75F, 1, 7, 1, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "pets/flower_" + color + ".png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/flower_animation.json"));
        this.anim = bbanimationloader.mustGet("flower.anim", this);
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.05F;
        GlStateManager.scale(1.1F, 1.1F, 1.1F);
        GlStateManager.translate(0.55F, -0.95F + f, 0.3F);
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
        GlStateManager.scale(1.3F, 1.3F, 1.3F);
        this.anim.tick(time);
        super.renderAsItem(time);
    }

    public String getCreator()
    {
        return "EvilBendy";
    }

    public String getName()
    {
        return this.color.equals("flame") ? "\u041e\u0433\u043d\u0435\u043d\u043d\u044b\u0439 \u0446\u0432\u0435\u0442\u043e\u043a" : "\u041b\u0435\u0434\u044f\u043d\u043e\u0439 \u0446\u0432\u0435\u0442\u043e\u043a";
    }

    public List<String> getDescription()
    {
        return MNaming.fromGame("Super Mario Bros");
    }
}
