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

public class GrandFatherFrost extends BasePet
{
    private final MModelRenderer GrandfatherFrost;
    private final MModelRenderer Head;
    private final MModelRenderer Eyebrows;
    private final MModelRenderer Eyes;
    private final MModelRenderer NewYearsHat;
    private final MModelRenderer Continued;
    private final MModelRenderer PartOne;
    private final MModelRenderer PartTwo;
    private final MModelRenderer One;
    private final MModelRenderer Two;
    private final MModelRenderer TheBeard;
    private final MModelRenderer Body;
    private final MModelRenderer BellyXD;
    private final MModelRenderer Hands;
    private final MModelRenderer RightHand;
    private final MModelRenderer LeftHand;
    private final MModelRenderer Legs;
    private final MModelRenderer RightLeg;
    private final MModelRenderer LeftLeg;
    private final MModelRenderer Neck;
    private final IAnimation animation;

    public GrandFatherFrost()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.GrandfatherFrost = new MModelRenderer(this);
        this.Head = new MModelRenderer(this);
        this.Head.setRotationPoint(0.0F, -9.75F, 0.0F);
        this.GrandfatherFrost.addChild(this.Head);
        this.Head.cubeList.add(new ModelBox(this.Head, 0, 16, -4.0F, -7.5F, -4.0F, 8, 8, 8, -0.5F, false));
        this.Head.cubeList.add(new ModelBox(this.Head, 0, 0, -4.0F, -7.5F, -4.0F, 8, 8, 8, -0.2F, false));
        this.Eyebrows = new MModelRenderer(this);
        this.Eyebrows.setRotationPoint(0.0F, 9.75F, 0.0F);
        this.Head.addChild(this.Eyebrows);
        this.Eyebrows.cubeList.add(new ModelBox(this.Eyebrows, 30, 30, -4.0F, -17.25F, -4.0F, 8, 8, 2, -0.49F, false));
        this.Eyes = new MModelRenderer(this);
        this.Eyes.setRotationPoint(0.0F, -1.75F, -3.5F);
        this.Head.addChild(this.Eyes);
        this.Eyes.cubeList.add(new ModelBox(this.Eyes, 0, 32, -4.0F, -5.75F, -0.5F, 8, 8, 2, -0.49F, false));
        this.NewYearsHat = new MModelRenderer(this);
        this.NewYearsHat.setRotationPoint(0.0F, 9.75F, 0.0F);
        this.Head.addChild(this.NewYearsHat);
        this.NewYearsHat.cubeList.add(new ModelBox(this.NewYearsHat, 26, 10, -3.0F, -19.25F, -3.0F, 6, 3, 6, -0.5F, false));
        this.Continued = new MModelRenderer(this);
        this.Continued.setRotationPoint(-0.5F, -17.25F, 2.5F);
        this.setRotation(this.Continued, -1.8152F, -0.7703F, 1.7427F);
        this.NewYearsHat.addChild(this.Continued);
        this.PartOne = new MModelRenderer(this);
        this.PartOne.setRotationPoint(-9.8258F, 16.6321F, -1.0588F);
        this.setRotation(this.PartOne, -0.1074F, 0.0749F, 0.6068F);
        this.Continued.addChild(this.PartOne);
        this.PartOne.cubeList.add(new ModelBox(this.PartOne, 32, 19, -3.0F, -21.25F, -3.0F, 4, 3, 4, -0.5F, false));
        this.PartTwo = new MModelRenderer(this);
        this.PartTwo.setRotationPoint(1.9242F, -0.1179F, 0.4412F);
        this.setRotation(this.PartTwo, 0.0F, 0.0F, 0.2182F);
        this.Continued.addChild(this.PartTwo);
        this.One = new MModelRenderer(this);
        this.One.setRotationPoint(-18.4437F, 9.2103F, 0.0F);
        this.setRotation(this.One, 0.0396F, 0.1248F, 1.8787F);
        this.PartTwo.addChild(this.One);
        this.One.cubeList.add(new ModelBox(this.One, 0, 0, -14.9941F, -18.7175F, -2.3597F, 2, 5, 2, -0.4F, false));
        this.Two = new MModelRenderer(this);
        this.Two.setRotationPoint(-16.4437F, 9.2103F, 0.0F);
        this.setRotation(this.Two, 0.0396F, 0.1248F, 1.8787F);
        this.PartTwo.addChild(this.Two);
        this.Two.cubeList.add(new ModelBox(this.Two, 40, 0, -14.8927F, -18.4101F, -2.8597F, 3, 3, 3, -0.5F, false));
        this.TheBeard = new MModelRenderer(this);
        this.TheBeard.setRotationPoint(0.0F, 9.5F, 0.75F);
        this.setRotation(this.TheBeard, -0.1309F, 0.0F, 0.0F);
        this.Head.addChild(this.TheBeard);
        this.TheBeard.cubeList.add(new ModelBox(this.TheBeard, 32, 26, -2.5F, -11.0F, -6.25F, 5, 2, 2, -0.5F, false));
        this.TheBeard.cubeList.add(new ModelBox(this.TheBeard, 38, 6, 0.5F, -10.0F, -6.25F, 2, 2, 2, -0.5F, false));
        this.TheBeard.cubeList.add(new ModelBox(this.TheBeard, 38, 6, -2.5F, -10.0F, -6.25F, 2, 2, 2, -0.5F, false));
        this.TheBeard.cubeList.add(new ModelBox(this.TheBeard, 32, 26, -2.5F, -9.5F, -6.25F, 5, 2, 2, -0.5F, false));
        this.TheBeard.cubeList.add(new ModelBox(this.TheBeard, 24, 19, -1.5F, -8.5F, -6.25F, 3, 2, 2, -0.5F, false));
        this.Body = new MModelRenderer(this);
        this.GrandfatherFrost.addChild(this.Body);
        this.Body.cubeList.add(new ModelBox(this.Body, 20, 38, -2.0F, -9.0F, -1.0F, 4, 6, 2, 0.0F, false));
        this.BellyXD = new MModelRenderer(this);
        this.BellyXD.setRotationPoint(0.0F, -7.0F, -0.5F);
        this.Body.addChild(this.BellyXD);
        this.BellyXD.cubeList.add(new ModelBox(this.BellyXD, 24, 0, -2.0F, -0.3038F, -1.5981F, 4, 4, 4, 0.001F, false));
        this.Hands = new MModelRenderer(this);
        this.Body.addChild(this.Hands);
        this.RightHand = new MModelRenderer(this);
        this.RightHand.setRotationPoint(-2.0F, -9.0F, 0.0F);
        this.setRotation(this.RightHand, 0.0F, 0.0F, 0.6109F);
        this.Hands.addChild(this.RightHand);
        this.RightHand.cubeList.add(new ModelBox(this.RightHand, 0, 16, -0.3F, -0.3F, -1.05F, 2, 5, 2, -0.3F, false));
        this.LeftHand = new MModelRenderer(this);
        this.LeftHand.setRotationPoint(2.0F, -9.0F, 0.0F);
        this.setRotation(this.LeftHand, 0.0F, 0.0F, -0.6109F);
        this.Hands.addChild(this.LeftHand);
        this.LeftHand.cubeList.add(new ModelBox(this.LeftHand, 40, 40, -1.7F, -0.3F, -1.05F, 2, 5, 2, -0.3F, false));
        this.Legs = new MModelRenderer(this);
        this.Body.addChild(this.Legs);
        this.RightLeg = new MModelRenderer(this);
        this.RightLeg.setRotationPoint(-1.0F, -3.0F, 0.0F);
        this.Legs.addChild(this.RightLeg);
        this.RightLeg.cubeList.add(new ModelBox(this.RightLeg, 0, 42, -1.0F, -1.0F, -1.0F, 2, 3, 2, -0.3F, false));
        this.LeftLeg = new MModelRenderer(this);
        this.LeftLeg.setRotationPoint(1.0F, -3.0F, 0.0F);
        this.Legs.addChild(this.LeftLeg);
        this.LeftLeg.cubeList.add(new ModelBox(this.LeftLeg, 20, 32, -1.0F, -1.0F, -1.0F, 2, 3, 2, -0.3F, false));
        this.Neck = new MModelRenderer(this);
        this.Neck.setRotationPoint(0.0F, -9.0F, 0.0F);
        this.Body.addChild(this.Neck);
        this.Neck.cubeList.add(new ModelBox(this.Neck, 32, 40, -1.0F, -7.0F, -1.0F, 2, 7, 2, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/grandfatherfrost.png"));
        this.animation = (new BBAnimationLoader(new ResourceLocation("minidot", "pets/grandfatherfrost_animation.json"))).mustGet("grandfatherfrost.animation", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        this.animation.tick(time);
        GlStateManager.translate(1.25D, Math.sin((double)time * 0.05D) * 0.1D, 0.4D);
    }

    public void renderAsItem(float time)
    {
        this.animation.tick(time);
        GlStateManager.translate(0.0D, 0.3286374D, 0.0D);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0414\u0435\u0434\u0443\u0448\u043a\u0430 \u041c\u043e\u0440\u043e\u0437";
    }

    public String getCreator()
    {
        return "Rander_";
    }
}
