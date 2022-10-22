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

public class InflatableRingUnicorn extends BaseItem
{
    private final MModelRenderer RubberRing;
    private final MModelRenderer Circle;
    private final MModelRenderer Head;
    private final MModelRenderer Horn;
    private final MModelRenderer Mane;
    private final MModelRenderer Face;
    private final String color;
    private final IAnimation anim;

    public InflatableRingUnicorn(String color)
    {
        super(ItemType.BODY);
        this.color = color;
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
        this.Head = new MModelRenderer(this);
        this.Head.setRotationPoint(0.0F, -14.5F, -5.0F);
        this.RubberRing.addChild(this.Head);
        this.setRotation(this.Head, 0.4363F, 0.0F, 0.0F);
        this.Head.setTextureOffset(34, 34).addBox(-1.5F, -8.0F, -1.5F, 3, 8, 3, 0.0F);
        this.Horn = new MModelRenderer(this);
        this.Horn.setRotationPoint(-0.5F, 0.0F, -2.1F);
        this.Head.addChild(this.Horn);
        this.Horn.setTextureOffset(3, 2).addBox(0.0F, -8.8F, 0.5F, 1, 1, 1, -0.2F);
        this.Horn.setTextureOffset(0, 3).addBox(0.0F, -9.8F, 0.5F, 1, 2, 1, -0.3F);
        this.Horn.setTextureOffset(0, 0).addBox(0.0F, -10.5F, 0.5F, 1, 2, 1, -0.4F);
        this.Mane = new MModelRenderer(this);
        this.Mane.setRotationPoint(0.0F, -5.0F, 1.5F);
        this.Head.addChild(this.Mane);
        this.Mane.setTextureOffset(0, 9).addBox(0.0F, -5.0F, -2.0F, 0, 9, 4, 0.0F);
        this.Face = new MModelRenderer(this);
        this.Face.setRotationPoint(-0.5F, -6.0F, -2.5F);
        this.Head.addChild(this.Face);
        this.Face.setTextureOffset(0, 38).addBox(-1.0F, -2.0F, -2.0F, 3, 3, 3, 0.0F);
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "body/inflatable_ring_unicorn_animation.json"));
        this.anim = bbanimationloader.mustGet("inflatable_ring_unicorn.anim", this);
        this.setTexture(new ResourceLocation("minidot", color.equals("pink") ? "body/inflatable_ring_unicorn_pink.png" : "body/inflatable_ring_unicorn_white.png"));
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
        return this.color.equals("pink") ? "\u0420\u043e\u0437\u043e\u0432\u044b\u0439 \u043d\u0430\u0434\u0443\u0432\u043d\u043e\u0439 \u0435\u0434\u0438\u043d\u043e\u0440\u043e\u0433" : "\u0411\u0435\u043b\u044b\u0439 \u043d\u0430\u0434\u0443\u0432\u043d\u043e\u0439 \u0435\u0434\u0438\u043d\u043e\u0440\u043e\u0433";
    }

    public String getCreator()
    {
        return "chikon";
    }
}
