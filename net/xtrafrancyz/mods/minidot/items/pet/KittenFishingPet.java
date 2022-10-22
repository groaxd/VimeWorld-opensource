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

public class KittenFishingPet extends BasePet
{
    private final MModelRenderer bone;
    private final MModelRenderer tail;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final MModelRenderer bone6;
    private final MModelRenderer bone7;
    private final MModelRenderer body;
    private final MModelRenderer bone11;
    private final MModelRenderer bone10;
    private final MModelRenderer head;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer bone8;
    private final MModelRenderer bone9;
    private final MModelRenderer fish;
    private final MModelRenderer eyes;
    private final MModelRenderer bone12;
    private final MModelRenderer bone13;
    private final MModelRenderer bone14;
    private final IAnimation anim;

    public KittenFishingPet()
    {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.setRotation(this.bone, 0.0F, -1.5708F, 0.0F);
        this.tail = new MModelRenderer(this);
        this.tail.setRotationPoint(5.0F, 0.0F, -1.0F);
        this.bone.addChild(this.tail);
        this.setRotation(this.tail, 0.0F, 0.0F, -0.8727F);
        this.tail.setTextureOffset(18, 22).addBox(-1.2856F, -2.5321F, 0.5F, 2, 1, 1, 0.0F);
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(1.5F, -0.5F, 0.0F);
        this.tail.addChild(this.bone4);
        this.bone4.setTextureOffset(5, 21).addBox(-1.2856F, -2.1321F, 0.4F, 2, 1, 1, 0.0F);
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(1.5F, 0.0F, 0.0F);
        this.bone4.addChild(this.bone5);
        this.setRotation(this.bone5, 0.0F, 0.0F, -0.2618F);
        this.bone5.setTextureOffset(14, 11).addBox(-0.8452F, -2.6126F, 0.2F, 2, 1, 1, 0.0F);
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(1.5F, 0.0F, 0.0F);
        this.bone5.addChild(this.bone6);
        this.setRotation(this.bone6, 0.0F, 0.0F, -0.2618F);
        this.bone6.setTextureOffset(20, 16).addBox(-0.3473F, -2.8696F, 0.1F, 3, 1, 1, 0.0F);
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(3.0F, 0.0F, 0.0F);
        this.bone6.addChild(this.bone7);
        this.setRotation(this.bone7, 0.0F, 0.0F, -0.2618F);
        this.bone7.setTextureOffset(19, 28).addBox(0.6743F, -2.4924F, 0.5F, 1, 1, 1, 0.0F);
        this.bone7.setTextureOffset(23, 28).addBox(-0.1257F, -2.7924F, 0.2F, 1, 1, 1, 0.0F);
        this.body = new MModelRenderer(this);
        this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone.addChild(this.body);
        this.body.setTextureOffset(0, 11).addBox(-2.0F, -6.0F, -2.0F, 3, 6, 4, 0.0F);
        this.body.setTextureOffset(20, 8).addBox(1.0F, -5.0F, -1.7F, 1, 5, 3, 0.0F);
        this.body.setTextureOffset(14, 23).addBox(2.0F, -3.0F, -1.2F, 1, 3, 2, 0.0F);
        this.body.setTextureOffset(20, 20).addBox(-3.0F, -6.5F, -2.4F, 1, 4, 4, 0.0F);
        this.body.setTextureOffset(24, 0).addBox(-1.0F, -3.5F, 2.0F, 2, 3, 1, 0.0F);
        this.body.setTextureOffset(0, 0).addBox(-1.0F, -3.5F, -3.0F, 2, 3, 1, 0.0F);
        this.body.setTextureOffset(7, 25).addBox(-3.0F, -1.0F, 2.0F, 2, 1, 1, 0.0F);
        this.body.setTextureOffset(24, 18).addBox(-3.0F, -1.0F, -3.0F, 2, 1, 1, 0.0F);
        this.body.setTextureOffset(14, 14).addBox(-4.1F, -6.5F, -2.0F, 1, 4, 4, 0.0F);
        this.body.setTextureOffset(28, 4).addBox(-4.4F, -1.0F, 0.1F, 1, 1, 1, 0.0F);
        this.body.setTextureOffset(27, 28).addBox(-4.4F, -1.0F, -1.5F, 1, 1, 1, 0.0F);
        this.body.setTextureOffset(16, 0).addBox(-4.7F, -6.5F, -1.5F, 1, 3, 3, 0.0F);
        this.body.setTextureOffset(8, 21).addBox(-2.0F, -6.5F, -1.9F, 1, 1, 3, 0.0F);
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(-2.0F, -1.0F, -1.3F);
        this.body.addChild(this.bone11);
        this.setRotation(this.bone11, 0.0873F, 0.0F, 0.0F);
        this.bone11.setTextureOffset(4, 26).addBox(-2.0F, -1.9128F, -0.0038F, 1, 2, 1, 0.0F);
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(-2.0F, -1.0F, -0.7F);
        this.body.addChild(this.bone10);
        this.setRotation(this.bone10, -0.0873F, 0.0F, 0.0F);
        this.bone10.setTextureOffset(26, 20).addBox(-2.0F, -2.0872F, 0.9962F, 1, 2, 1, 0.0F);
        this.head = new MModelRenderer(this);
        this.head.setRotationPoint(-3.0F, -6.5F, 0.0F);
        this.bone.addChild(this.head);
        this.head.setTextureOffset(0, 0).addBox(-2.3F, -5.0F, -3.0F, 5, 5, 6, 0.0F);
        this.head.setTextureOffset(0, 21).addBox(-3.0F, -2.0F, -1.5F, 1, 2, 3, 0.0F);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(1.5F, -5.4F, 1.4F);
        this.head.addChild(this.bone2);
        this.bone2.setTextureOffset(0, 26).addBox(-2.9F, -1.0F, 0.6F, 1, 2, 1, 0.0F);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(-0.5F, -1.0F, -0.5F);
        this.bone2.addChild(this.bone3);
        this.setRotation(this.bone3, -0.7854F, 0.0F, 0.0F);
        this.bone3.setTextureOffset(15, 28).addBox(-1.8F, -0.495F, 1.0749F, 1, 1, 1, 0.0F);
        this.bone3.setTextureOffset(24, 4).addBox(-2.5F, -1.7678F, 0.7678F, 1, 3, 1, 0.0F);
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(1.5F, -5.4F, -3.4F);
        this.head.addChild(this.bone8);
        this.bone8.setTextureOffset(25, 8).addBox(-2.9F, -1.0F, 0.0F, 1, 2, 1, 0.0F);
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(-0.5F, -1.0F, 0.5F);
        this.bone8.addChild(this.bone9);
        this.setRotation(this.bone9, 0.7854F, 0.0F, 0.0F);
        this.bone9.setTextureOffset(14, 14).addBox(-2.5F, -0.3536F, -0.3536F, 1, 3, 1, 0.0F);
        this.bone9.setTextureOffset(11, 28).addBox(-1.8F, 0.9192F, -1.0607F, 1, 1, 1, 0.0F);
        this.fish = new MModelRenderer(this);
        this.fish.setRotationPoint(-1.2F, -0.2F, -1.0F);
        this.head.addChild(this.fish);
        this.setRotation(this.fish, 0.0F, 0.0F, -0.5236F);
        this.fish.setTextureOffset(6, 11).addBox(-3.3294F, -1.2819F, -1.4F, 2, 0, 4, 0.0F);
        this.eyes = new MModelRenderer(this);
        this.eyes.setRotationPoint(2.1F, 0.0F, -1.0F);
        this.head.addChild(this.eyes);
        this.eyes.setTextureOffset(27, 15).addBox(-4.6F, -3.7F, 1.9F, 1, 1, 1, 0.0F);
        this.eyes.setTextureOffset(8, 27).addBox(-4.6F, -3.7F, -1.4F, 1, 1, 1, 0.0F);
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(2.1F, 0.0F, -1.0F);
        this.head.addChild(this.bone12);
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(-2.7F, -1.1F, 1.5F);
        this.bone12.addChild(this.bone13);
        this.setRotation(this.bone13, 0.0F, -0.0873F, 0.0F);
        this.bone13.setTextureOffset(0, 9).addBox(-1.9052F, -1.5F, 1.1705F, 0, 2, 2, 0.0F);
        this.bone14 = new MModelRenderer(this);
        this.bone14.setRotationPoint(-2.7F, -1.0F, -1.5F);
        this.bone12.addChild(this.bone14);
        this.setRotation(this.bone14, 0.0F, 0.0873F, 0.0F);
        this.bone14.setTextureOffset(0, 11).addBox(-2.0795F, -1.6F, -1.1781F, 0, 2, 2, 0.0F);
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/kitten_fishing_animation.json"));
        this.anim = bbanimationloader.mustGet("kitten_fishing", this);
        this.setTexture(new ResourceLocation("minidot", "pets/kitten_fishing.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.05F;
        GlStateManager.translate(0.7F, -1.0F + f, 0.35F);
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
        this.anim.tick(time);
        super.preRender(modelPlayer, player, time, pi);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
        GlStateManager.translate(0.0F, -0.6F, 0.0F);
        this.anim.tick(time);
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
        return "\u041a\u043e\u0442\u0435\u043d\u043e\u043a \u0440\u044b\u0431\u043e\u043b\u043e\u0432";
    }

    public String getCreator()
    {
        return "chikon";
    }
}
