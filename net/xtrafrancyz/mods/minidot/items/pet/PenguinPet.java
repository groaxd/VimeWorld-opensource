package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class PenguinPet extends BasePet
{
    private final MModelRenderer penguin;
    private final MModelRenderer body;
    private final MModelRenderer wing_first;
    private final MModelRenderer wing_second;
    private final MModelRenderer leg_first;
    private final MModelRenderer leg_second;
    private final MModelRenderer tail;
    private final MModelRenderer tail2;
    private final MModelRenderer head;
    private final MModelRenderer beak;
    private final MModelRenderer hat;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final IAnimation animation;

    public PenguinPet()
    {
        this.textureWidth = 96;
        this.textureHeight = 96;
        this.penguin = new MModelRenderer(this);
        this.penguin.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.body = new MModelRenderer(this);
        this.setRotation(this.body, 0.0698F, 0.0F, 0.0F);
        this.penguin.addChild(this.body);
        this.body.cubeList.add(new ModelBox(this.body, 0, 0, -7.0F, -9.0F, -6.0F, 12, 16, 9, 0.0F, false));
        this.wing_first = new MModelRenderer(this);
        this.wing_first.setRotationPoint(4.7636F, -9.2944F, -1.3934F);
        this.setRotation(this.wing_first, 0.1325F, -0.0151F, -0.2177F);
        this.body.addChild(this.wing_first);
        this.wing_first.cubeList.add(new ModelBox(this.wing_first, 0, 41, -0.0233F, 0.3396F, -3.3232F, 2, 10, 6, 0.0F, false));
        this.wing_second = new MModelRenderer(this);
        this.wing_second.setRotationPoint(-6.7F, -9.3F, -1.2F);
        this.setRotation(this.wing_second, 0.1325F, 0.0151F, 0.2177F);
        this.body.addChild(this.wing_second);
        this.wing_second.cubeList.add(new ModelBox(this.wing_second, 32, 25, -2.0347F, 0.3673F, -2.9963F, 2, 10, 6, 0.0F, false));
        this.leg_first = new MModelRenderer(this);
        this.leg_first.setRotationPoint(3.4286F, 7.0005F, -2.4804F);
        this.setRotation(this.leg_first, 0.0F, -0.1309F, 0.0F);
        this.body.addChild(this.leg_first);
        this.leg_first.cubeList.add(new ModelBox(this.leg_first, 16, 41, -2.2611F, -1.0F, -5.4829F, 4, 2, 7, 0.0F, false));
        this.leg_second = new MModelRenderer(this);
        this.leg_second.setRotationPoint(-5.3991F, 7.0F, -2.4869F);
        this.setRotation(this.leg_second, 0.0F, 0.1309F, 0.0F);
        this.body.addChild(this.leg_second);
        this.leg_second.cubeList.add(new ModelBox(this.leg_second, 33, 0, -1.7389F, -1.0F, -5.4829F, 4, 2, 7, 0.0F, false));
        this.tail = new MModelRenderer(this);
        this.tail.setRotationPoint(-1.0F, 6.4454F, 3.8387F);
        this.setRotation(this.tail, -0.7854F, 0.0F, 0.0F);
        this.body.addChild(this.tail);
        this.tail.cubeList.add(new ModelBox(this.tail, 31, 41, -3.0F, -0.3439F, -2.2547F, 6, 2, 3, 0.0F, false));
        this.tail2 = new MModelRenderer(this);
        this.tail2.setRotationPoint(-1.0F, 6.4454F, 3.8387F);
        this.setRotation(this.tail2, -0.7854F, 0.0F, 0.0F);
        this.body.addChild(this.tail2);
        this.tail2.cubeList.add(new ModelBox(this.tail2, 10, 41, -2.0F, 0.1561F, 0.7453F, 4, 1, 2, 0.0F, false));
        this.head = new MModelRenderer(this);
        this.head.setRotationPoint(0.0F, -0.2F, 0.0F);
        this.penguin.addChild(this.head);
        this.head.cubeList.add(new ModelBox(this.head, 0, 25, -5.0F, -16.6F, -8.0F, 8, 8, 8, 0.0F, false));
        this.beak = new MModelRenderer(this);
        this.beak.setRotationPoint(-1.0F, -11.0F, -9.4F);
        this.setRotation(this.beak, 0.0873F, 0.0F, 0.0F);
        this.head.addChild(this.beak);
        this.beak.cubeList.add(new ModelBox(this.beak, 24, 25, -2.0F, -1.0F, -1.2F, 4, 2, 3, 0.0F, false));
        this.hat = new MModelRenderer(this);
        this.head.addChild(this.hat);
        this.hat.cubeList.add(new ModelBox(this.hat, 56, 0, -6.0F, -17.6F, -9.0F, 10, 1, 10, 0.0F, false));
        this.hat.cubeList.add(new ModelBox(this.hat, 64, 13, -5.0F, -19.6F, -8.0F, 8, 2, 8, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(-1.0F, -19.1F, -4.0F);
        this.setRotation(this.bone, -0.0873F, 0.0F, 0.0F);
        this.hat.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 72, 23, -3.0F, -2.175F, -3.025F, 6, 2, 6, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-1.0F, -21.875F, -3.675F);
        this.setRotation(this.bone2, -0.2618F, 0.0F, 0.0F);
        this.hat.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 74, 25, -2.0F, -1.0F, -2.0F, 4, 2, 4, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(-1.0F, -23.425F, -3.1F);
        this.setRotation(this.bone3, -0.48F, 0.0F, 0.0F);
        this.hat.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 84, 27, -1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(-0.975F, -24.87F, -2.1275F);
        this.setRotation(this.bone4, -((float)Math.PI * 2F / 9F), 0.0F, 0.0F);
        this.hat.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 63, 28, -0.5F, 0.0F, -0.6F, 1, 1, 1, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/penguinpet.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/penguinpet_animation.json"));
        this.animation = bbanimationloader.mustGet("penguin.animation", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        this.animation.tick(time);
        GlStateManager.translate(1.25D, -0.2D, 0.4D);
        double d0 = 0.5D;
        GlStateManager.scale(d0, d0, d0);
    }

    public void renderAsItem(float time)
    {
        this.animation.tick(time);
        double d0 = 0.5985D;
        GlStateManager.scale(d0, d0, d0);
        GlStateManager.translate(0.0D, 0.5915D, 0.0D);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041f\u0438\u043d\u0433\u0432\u0438\u043d";
    }

    public String getCreator()
    {
        return "Mop1k & Lop1k";
    }
}
