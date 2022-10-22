package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class InfectedPet extends BasePet
{
    private final MModelRenderer infected;
    private final MModelRenderer legs;
    private final MModelRenderer bone3;
    private final MModelRenderer bone2;
    private final MModelRenderer body;
    private final MModelRenderer arms;
    private final MModelRenderer arm_left;
    private final MModelRenderer arm_right;
    private final MModelRenderer head;
    private final MModelRenderer bone;
    private final MModelRenderer blobs;
    private final MModelRenderer eyes;
    private final MModelRenderer one;
    private final MModelRenderer two;
    private final IAnimation animation;

    public InfectedPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.infected = new MModelRenderer(this);
        this.infected.setRotationPoint(0.0F, 0.0F, 1.0F);
        this.legs = new MModelRenderer(this);
        this.legs.setRotationPoint(0.0F, -3.0F, 0.0F);
        this.infected.addChild(this.legs);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(1.0F, 0.0F, 0.0F);
        this.legs.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 24, 0, -1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-1.0F, 0.0F, 0.0F);
        this.legs.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 24, 0, -1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F, false));
        this.body = new MModelRenderer(this);
        this.body.setRotationPoint(0.0F, -3.0F, 0.0F);
        this.infected.addChild(this.body);
        this.body.cubeList.add(new ModelBox(this.body, 0, 16, -2.0F, -5.0F, -1.0F, 4, 5, 2, 0.0F, false));
        this.arms = new MModelRenderer(this);
        this.arms.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.body.addChild(this.arms);
        this.arm_left = new MModelRenderer(this);
        this.arm_left.setRotationPoint(-2.0F, 0.0F, 0.0F);
        this.arms.addChild(this.arm_left);
        this.arm_left.cubeList.add(new ModelBox(this.arm_left, 0, 0, -2.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F, false));
        this.arm_right = new MModelRenderer(this);
        this.arm_right.setRotationPoint(2.0F, 0.0F, 0.0F);
        this.arms.addChild(this.arm_right);
        this.arm_right.cubeList.add(new ModelBox(this.arm_right, 0, 0, 0.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F, false));
        this.head = new MModelRenderer(this);
        this.head.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.body.addChild(this.head);
        this.head.cubeList.add(new ModelBox(this.head, 0, 0, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(-1.5F, -1.75F, -4.0F);
        this.head.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 7, 27, -0.5F, -0.25F, -0.5F, 1, 3, 1, 0.0F, false));
        this.blobs = new MModelRenderer(this);
        this.blobs.setRotationPoint(4.0F, -7.0F, -4.0F);
        this.head.addChild(this.blobs);
        this.blobs.cubeList.add(new ModelBox(this.blobs, 24, 16, -3.0F, -3.0F, 2.0F, 2, 2, 2, 0.0F, false));
        this.blobs.cubeList.add(new ModelBox(this.blobs, 12, 16, -4.0F, -3.0F, 5.0F, 3, 2, 3, 0.0F, false));
        this.blobs.cubeList.add(new ModelBox(this.blobs, 9, 21, 0.0F, 0.0F, 3.0F, 2, 3, 3, 0.0F, false));
        this.blobs.cubeList.add(new ModelBox(this.blobs, 21, 16, 0.0F, 0.0F, 1.0F, 1, 1, 1, 0.0F, false));
        this.blobs.cubeList.add(new ModelBox(this.blobs, 21, 16, 0.0F, 4.0F, 2.0F, 1, 1, 1, 0.0F, false));
        this.blobs.cubeList.add(new ModelBox(this.blobs, 21, 16, 0.0F, 3.0F, 7.0F, 1, 1, 1, 0.0F, false));
        this.blobs.cubeList.add(new ModelBox(this.blobs, 21, 16, -3.0F, 3.0F, 8.0F, 1, 1, 1, 0.0F, false));
        this.blobs.cubeList.add(new ModelBox(this.blobs, 24, 16, -5.0F, 0.0F, 8.0F, 2, 2, 2, 0.0F, false));
        this.blobs.cubeList.add(new ModelBox(this.blobs, 24, 5, -7.0F, -2.0F, 4.0F, 2, 1, 2, 0.0F, false));
        this.blobs.cubeList.add(new ModelBox(this.blobs, 21, 16, -5.0F, -2.0F, 2.0F, 1, 1, 1, 0.0F, false));
        this.eyes = new MModelRenderer(this);
        this.head.addChild(this.eyes);
        this.one = new MModelRenderer(this);
        this.one.setRotationPoint(2.5F, -4.5F, -4.1F);
        this.eyes.addChild(this.one);
        this.one.cubeList.add(new ModelBox(this.one, 32, 10, -1.5F, -1.5F, 0.0F, 3, 3, 0, 0.0F, false));
        this.two = new MModelRenderer(this);
        this.two.setRotationPoint(-2.5F, -4.5F, -4.1F);
        this.eyes.addChild(this.two);
        this.two.cubeList.add(new ModelBox(this.two, 32, 14, -1.5F, -2.5F, 0.0F, 3, 4, 0, 0.0F, true));
        super.setTexture(new ResourceLocation("minidot", "pets/infectedpet.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/infectedpet_animation.json"));
        this.animation = bbanimationloader.mustGet("infected.default", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.translate(0.6D, 0.0D, 0.3D);
        double d0 = (double)MathHelper.sin(time * 0.1F) * 0.03D;
        GlStateManager.translate(0.0D, d0, 0.0D);
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
        GlStateManager.translate(0.0D, 0.4D, 0.0D);
        double d0 = 1.2D;
        GlStateManager.scale(d0, d0, d0);
        this.animation.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0418\u043d\u0444\u0438\u0446\u0438\u0440\u043e\u0432\u0430\u043d\u043d\u044b\u0439";
    }

    public String getCreator()
    {
        return "xRolaaan";
    }
}
