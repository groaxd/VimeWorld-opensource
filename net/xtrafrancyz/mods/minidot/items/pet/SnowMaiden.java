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

public class SnowMaiden extends BasePet
{
    private final MModelRenderer SnowMaiden;
    private final MModelRenderer Head;
    private final MModelRenderer Eyebrows;
    private final MModelRenderer Eyes;
    private final MModelRenderer Blips;
    private final MModelRenderer Blips2;
    private final MModelRenderer Hair;
    private final MModelRenderer Braids;
    private final MModelRenderer Bow;
    private final MModelRenderer Body;
    private final MModelRenderer OnePart;
    private final MModelRenderer TwoPart;
    private final MModelRenderer Hands;
    private final MModelRenderer RightHand;
    private final MModelRenderer LeftHand;
    private final MModelRenderer Legs;
    private final MModelRenderer RightLeg;
    private final MModelRenderer LeftLeg;
    private final MModelRenderer Neck;
    private final IAnimation animation;

    public SnowMaiden()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.SnowMaiden = new MModelRenderer(this);
        this.Head = new MModelRenderer(this);
        this.Head.setRotationPoint(0.0F, -9.75F, 0.0F);
        this.SnowMaiden.addChild(this.Head);
        this.Head.cubeList.add(new ModelBox(this.Head, 0, 16, -4.0F, -7.5F, -4.0F, 8, 8, 8, -0.5F, false));
        this.Head.cubeList.add(new ModelBox(this.Head, 0, 0, -4.0F, -7.5F, -4.0F, 8, 8, 8, -0.15F, false));
        this.Head.cubeList.add(new ModelBox(this.Head, 24, 0, -5.0F, -11.25F, -2.0F, 10, 6, 0, 0.0F, false));
        this.Eyebrows = new MModelRenderer(this);
        this.Eyebrows.setRotationPoint(0.0F, 9.75F, 0.0F);
        this.Head.addChild(this.Eyebrows);
        this.Eyebrows.cubeList.add(new ModelBox(this.Eyebrows, 30, 14, -4.0F, -17.25F, -4.0F, 8, 8, 2, -0.49F, false));
        this.Eyes = new MModelRenderer(this);
        this.Eyes.setRotationPoint(0.0F, -1.75F, -3.5F);
        this.Head.addChild(this.Eyes);
        this.Eyes.cubeList.add(new ModelBox(this.Eyes, 30, 30, -4.0F, -5.75F, -0.5F, 8, 8, 2, -0.49F, false));
        this.Blips = new MModelRenderer(this);
        this.Blips.setRotationPoint(0.0F, 11.5F, 3.5F);
        this.Eyes.addChild(this.Blips);
        this.Blips.cubeList.add(new ModelBox(this.Blips, 0, 34, -2.15F, -12.85F, -3.975F, 1, 1, 1, -0.45F, false));
        this.Blips.cubeList.add(new ModelBox(this.Blips, 0, 34, -1.75F, -13.275F, -3.8F, 1, 1, 1, -0.26F, false));
        this.Blips.cubeList.add(new ModelBox(this.Blips, 0, 34, -2.25F, -13.275F, -3.925F, 1, 1, 1, -0.4F, false));
        this.Blips.cubeList.add(new ModelBox(this.Blips, 0, 34, -1.65F, -12.775F, -3.925F, 1, 1, 1, -0.4F, false));
        this.Blips2 = new MModelRenderer(this);
        this.Blips2.setRotationPoint(0.0F, 11.5F, 3.5F);
        this.Eyes.addChild(this.Blips2);
        this.Blips2.cubeList.add(new ModelBox(this.Blips2, 0, 34, 1.15F, -12.85F, -3.975F, 1, 1, 1, -0.45F, true));
        this.Blips2.cubeList.add(new ModelBox(this.Blips2, 0, 34, 0.75F, -13.275F, -3.8F, 1, 1, 1, -0.26F, true));
        this.Blips2.cubeList.add(new ModelBox(this.Blips2, 0, 34, 1.25F, -13.275F, -3.925F, 1, 1, 1, -0.4F, true));
        this.Blips2.cubeList.add(new ModelBox(this.Blips2, 0, 34, 0.65F, -12.775F, -3.925F, 1, 1, 1, -0.4F, true));
        this.Hair = new MModelRenderer(this);
        this.Hair.setRotationPoint(0.0F, -1.75F, 2.75F);
        this.Head.addChild(this.Hair);
        this.Braids = new MModelRenderer(this);
        this.Braids.setRotationPoint(0.0F, 11.5F, -3.25F);
        this.setRotation(this.Braids, 0.0873F, 0.0F, 0.0F);
        this.Hair.addChild(this.Braids);
        this.Braids.cubeList.add(new ModelBox(this.Braids, 24, 16, -1.0F, -12.0F, 4.0F, 2, 7, 1, 0.0F, false));
        this.Braids.cubeList.add(new ModelBox(this.Braids, 20, 37, -1.0F, -5.0F, 4.0F, 2, 2, 1, 0.0F, false));
        this.Bow = new MModelRenderer(this);
        this.Bow.setRotationPoint(0.0F, 15.0F, -3.0F);
        this.setRotation(this.Bow, 0.0873F, 0.0F, 0.0F);
        this.Hair.addChild(this.Bow);
        this.Bow.cubeList.add(new ModelBox(this.Bow, 24, 6, -1.0F, -9.9848F, 4.3486F, 2, 1, 1, 0.0F, false));
        this.Bow.cubeList.add(new ModelBox(this.Bow, 26, 37, -2.0F, -10.9848F, 4.3486F, 1, 3, 1, 0.0F, false));
        this.Bow.cubeList.add(new ModelBox(this.Bow, 26, 37, 1.0F, -10.9848F, 4.3486F, 1, 3, 1, 0.0F, false));
        this.Body = new MModelRenderer(this);
        this.SnowMaiden.addChild(this.Body);
        this.Body.cubeList.add(new ModelBox(this.Body, 0, 32, -2.0F, -9.0F, -1.0F, 4, 6, 2, 0.0F, false));
        this.OnePart = new MModelRenderer(this);
        this.OnePart.setRotationPoint(0.0F, -6.0F, -0.5F);
        this.setRotation(this.OnePart, -0.5236F, 0.0F, 0.0F);
        this.Body.addChild(this.OnePart);
        this.OnePart.cubeList.add(new ModelBox(this.OnePart, 32, 6, -2.0F, -0.3038F, -0.5981F, 4, 4, 2, 0.001F, false));
        this.TwoPart = new MModelRenderer(this);
        this.TwoPart.setRotationPoint(0.0F, -6.0F, 0.5F);
        this.setRotation(this.TwoPart, 0.5236F, 0.0F, 0.0F);
        this.Body.addChild(this.TwoPart);
        this.TwoPart.cubeList.add(new ModelBox(this.TwoPart, 32, 6, -2.0F, -0.3038F, -1.4019F, 4, 4, 2, 0.001F, false));
        this.Hands = new MModelRenderer(this);
        this.Body.addChild(this.Hands);
        this.RightHand = new MModelRenderer(this);
        this.RightHand.setRotationPoint(-2.0F, -9.0F, 0.0F);
        this.setRotation(this.RightHand, 0.0F, 0.0F, 0.6109F);
        this.Hands.addChild(this.RightHand);
        this.RightHand.cubeList.add(new ModelBox(this.RightHand, 0, 0, -0.3F, -0.3F, -1.05F, 2, 5, 2, -0.3F, false));
        this.LeftHand = new MModelRenderer(this);
        this.LeftHand.setRotationPoint(2.0F, -9.0F, 0.0F);
        this.setRotation(this.LeftHand, 0.0F, 0.0F, -0.6109F);
        this.Hands.addChild(this.LeftHand);
        this.LeftHand.cubeList.add(new ModelBox(this.LeftHand, 0, 16, -1.7F, -0.3F, -1.05F, 2, 5, 2, -0.3F, false));
        this.Legs = new MModelRenderer(this);
        this.Body.addChild(this.Legs);
        this.RightLeg = new MModelRenderer(this);
        this.RightLeg.setRotationPoint(-1.0F, -3.0F, 0.0F);
        this.Legs.addChild(this.RightLeg);
        this.RightLeg.cubeList.add(new ModelBox(this.RightLeg, 32, 24, -1.0F, -1.0F, -1.0F, 2, 3, 2, -0.3F, false));
        this.LeftLeg = new MModelRenderer(this);
        this.LeftLeg.setRotationPoint(1.0F, -3.0F, 0.0F);
        this.Legs.addChild(this.LeftLeg);
        this.LeftLeg.cubeList.add(new ModelBox(this.LeftLeg, 20, 32, -1.0F, -1.0F, -1.0F, 2, 3, 2, -0.3F, false));
        this.Neck = new MModelRenderer(this);
        this.Neck.setRotationPoint(0.0F, -9.0F, 0.0F);
        this.Body.addChild(this.Neck);
        this.Neck.cubeList.add(new ModelBox(this.Neck, 12, 32, -1.0F, -7.0F, -1.0F, 2, 7, 2, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/snowmaiden.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/snowmaiden_animation.json"));
        this.animation = bbanimationloader.mustGet("snowmaiden.animation", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        this.animation.tick(time);
        GlStateManager.translate(1.25D, -0.1267D, 0.4D);
    }

    public void renderAsItem(float time)
    {
        this.animation.tick(time);
        GlStateManager.translate(0.0D, 0.30513552D, 0.0D);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0421\u043d\u0435\u0433\u0443\u0440\u043e\u0447\u043a\u0430";
    }

    public String getCreator()
    {
        return "Rander_";
    }
}
