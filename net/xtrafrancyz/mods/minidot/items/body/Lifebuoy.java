package net.xtrafrancyz.mods.minidot.items.body;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class Lifebuoy extends BaseItem
{
    private final MModelRenderer RubberRing;
    private final MModelRenderer Circle;
    private final MModelRenderer Frame;
    private final MModelRenderer bone2;
    private final MModelRenderer Rope;
    private final MModelRenderer Front;
    private final MModelRenderer bone4;
    private final MModelRenderer bone3;
    private final MModelRenderer Back;
    private final MModelRenderer bone5;
    private final MModelRenderer bone6;
    private final MModelRenderer Right;
    private final MModelRenderer bone7;
    private final MModelRenderer bone8;
    private final MModelRenderer Left;
    private final MModelRenderer bone9;
    private final MModelRenderer bone10;
    private final MModelRenderer bone;
    private final MModelRenderer bone11;
    private final MModelRenderer bone12;
    private final MModelRenderer bone13;
    private final MModelRenderer bone14;
    private final IAnimation anim;

    public Lifebuoy()
    {
        super(ItemType.BODY);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.RubberRing = new MModelRenderer(this);
        this.RubberRing.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.Circle = new MModelRenderer(this);
        this.Circle.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.RubberRing.addChild(this.Circle);
        this.Circle.setTextureOffset(0, 13).addBox(4.0F, -15.0F, -5.0F, 2, 3, 10, 0.0F);
        this.Circle.setTextureOffset(12, 28).addBox(5.5F, -14.5F, -5.0F, 1, 2, 10, 0.0F);
        this.Circle.setTextureOffset(0, 0).addBox(-6.0F, -15.0F, -5.0F, 2, 3, 10, 0.0F);
        this.Circle.setTextureOffset(0, 26).addBox(-6.5F, -14.5F, -5.0F, 1, 2, 10, 0.0F);
        this.Circle.setTextureOffset(30, 15).addBox(-5.0F, -15.0F, 4.0F, 10, 3, 2, 0.0F);
        this.Circle.setTextureOffset(30, 10).addBox(-5.0F, -14.5F, 5.5F, 10, 2, 1, 0.0F);
        this.Circle.setTextureOffset(30, 5).addBox(-5.0F, -15.0F, -6.0F, 10, 3, 2, 0.0F);
        this.Circle.setTextureOffset(30, 20).addBox(-5.0F, -14.5F, -6.5F, 10, 2, 1, 0.0F);
        this.Circle.setTextureOffset(24, 28).addBox(-3.0F, -14.5F, -6.0F, 9, 2, 3, 0.0F);
        this.Circle.setTextureOffset(15, 17).addBox(-6.0F, -14.5F, -6.0F, 3, 2, 9, 0.0F);
        this.Circle.setTextureOffset(30, 0).addBox(-6.0F, -14.5F, 3.0F, 9, 2, 3, 0.0F);
        this.Circle.setTextureOffset(15, 4).addBox(3.0F, -14.5F, -3.0F, 3, 2, 9, 0.0F);
        this.Frame = new MModelRenderer(this);
        this.Frame.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Circle.addChild(this.Frame);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-6.0F, -13.5F, -6.0F);
        this.Frame.addChild(this.bone2);
        this.setRotation(this.bone2, 0.0F, 0.7854F, 0.0F);
        this.bone2.setTextureOffset(0, 13).addBox(-1.0F, -0.5F, -1.0F, 2, 1, 2, 0.0F);
        this.bone2.setTextureOffset(0, 6).addBox(7.4853F, -0.5F, 7.4853F, 2, 1, 2, 0.0F);
        this.bone2.setTextureOffset(0, 3).addBox(-1.0F, -0.5F, 15.9706F, 2, 1, 2, 0.0F);
        this.bone2.setTextureOffset(0, 0).addBox(-9.4853F, -0.5F, 7.4853F, 2, 1, 2, 0.0F);
        this.Rope = new MModelRenderer(this);
        this.Rope.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Frame.addChild(this.Rope);
        this.Front = new MModelRenderer(this);
        this.Front.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Rope.addChild(this.Front);
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(0.0F, -12.5F, -7.4F);
        this.Front.addChild(this.bone4);
        this.setRotation(this.bone4, 0.3491F, -0.0873F, -0.1396F);
        this.bone4.setTextureOffset(14, 15).addBox(-0.3F, -0.7F, -0.3F, 7, 1, 1, -0.3F);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.0F, -12.5F, -7.4F);
        this.Front.addChild(this.bone3);
        this.setRotation(this.bone3, 0.3491F, 0.0873F, 0.1396F);
        this.bone3.setTextureOffset(30, 23).addBox(-6.7F, -0.7F, -0.3F, 7, 1, 1, -0.3F);
        this.Back = new MModelRenderer(this);
        this.Back.setRotationPoint(0.0F, 0.0F, 14.4F);
        this.Rope.addChild(this.Back);
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(0.0F, -12.5F, -7.0F);
        this.Back.addChild(this.bone5);
        this.setRotation(this.bone5, -0.3491F, 0.0873F, -0.1396F);
        this.bone5.setTextureOffset(14, 2).addBox(-0.3F, -0.7F, -0.7F, 7, 1, 1, -0.3F);
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(0.0F, -12.5F, -7.0F);
        this.Back.addChild(this.bone6);
        this.setRotation(this.bone6, -0.3491F, -0.0873F, 0.1396F);
        this.bone6.setTextureOffset(14, 0).addBox(-6.7F, -0.7F, -0.7F, 7, 1, 1, -0.3F);
        this.Right = new MModelRenderer(this);
        this.Right.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Rope.addChild(this.Right);
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(-7.4F, -12.5F, 0.0F);
        this.Right.addChild(this.bone7);
        this.setRotation(this.bone7, -0.1047F, -0.1222F, -0.3491F);
        this.bone7.setTextureOffset(9, 40).addBox(-0.3F, -0.7F, -6.7F, 1, 1, 7, -0.3F);
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(-7.4F, -12.5F, 0.0F);
        this.Right.addChild(this.bone8);
        this.setRotation(this.bone8, 0.1047F, 0.1222F, -0.3491F);
        this.bone8.setTextureOffset(0, 38).addBox(-0.3F, -0.7F, -0.3F, 1, 1, 7, -0.3F);
        this.Left = new MModelRenderer(this);
        this.Left.setRotationPoint(14.4F, 0.0F, 0.0F);
        this.Rope.addChild(this.Left);
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(-7.0F, -12.5F, 0.0F);
        this.Left.addChild(this.bone9);
        this.setRotation(this.bone9, -0.1047F, 0.1222F, 0.3491F);
        this.bone9.setTextureOffset(36, 36).addBox(-0.7F, -0.7F, -6.7F, 1, 1, 7, -0.3F);
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(-7.0F, -12.5F, 0.0F);
        this.Left.addChild(this.bone10);
        this.setRotation(this.bone10, 0.1047F, -0.1222F, 0.3491F);
        this.bone10.setTextureOffset(27, 33).addBox(-0.7F, -0.7F, -0.3F, 1, 1, 7, -0.3F);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.5F, -12.3F, 6.8F);
        this.Frame.addChild(this.bone);
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(-0.5F, -0.5F, 0.5F);
        this.bone.addChild(this.bone11);
        this.setRotation(this.bone11, -0.4363F, 0.0F, 0.0F);
        this.bone11.setTextureOffset(6, 6).addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(-0.5F, -0.1F, 0.5F);
        this.bone.addChild(this.bone12);
        this.bone12.setTextureOffset(0, 16).addBox(-0.5F, -0.3F, -0.5F, 1, 2, 1, -0.3F);
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(0.0F, 1.4F, 0.0F);
        this.bone12.addChild(this.bone13);
        this.bone13.setTextureOffset(14, 7).addBox(-0.5F, -0.3F, -0.5F, 1, 2, 1, -0.3F);
        this.bone14 = new MModelRenderer(this);
        this.bone14.setRotationPoint(0.0F, 1.4F, 0.0F);
        this.bone13.addChild(this.bone14);
        this.bone14.setTextureOffset(14, 4).addBox(-0.5F, -0.3F, -0.5F, 1, 2, 1, -0.3F);
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "body/lifebuoy_animation.json"));
        this.anim = bbanimationloader.mustGet("lifebuoy.anim", this);
        this.setTexture(new ResourceLocation("minidot", "body/lifebuoy.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        this.anim.tick(time);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.0F, 0.4F);
        this.anim.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0421\u043f\u0430\u0441\u0430\u0442\u0435\u043b\u044c\u043d\u044b\u0439 \u043a\u0440\u0443\u0433";
    }

    public String getCreator()
    {
        return "chikon";
    }
}
