package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.List;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;
import net.xtrafrancyz.mods.minidot.util.MNaming;

public class CrystalMaiden extends BasePet
{
    private final MModelRenderer Player;
    private final MModelRenderer Head;
    private final MModelRenderer Body;
    private final MModelRenderer cape;
    private final MModelRenderer b;
    private final MModelRenderer c;
    private final MModelRenderer RightArm;
    private final MModelRenderer LeftArm;
    private final MModelRenderer Staff;
    private final MModelRenderer bonefour;
    private final MModelRenderer bonetwo;
    private final MModelRenderer boneone;
    private final MModelRenderer bonethree;
    private final MModelRenderer bonef;
    private final MModelRenderer boses;
    private final MModelRenderer bone;
    private final MModelRenderer RightLeg;
    private final MModelRenderer LeftLeg;
    private final MModelRenderer dogi;
    private final MModelRenderer head_two;
    private final MModelRenderer ear_one;
    private final MModelRenderer ear_one2;
    private final MModelRenderer boneee;
    private final MModelRenderer frontlegs;
    private final MModelRenderer body_one;
    private final MModelRenderer body_second;
    private final MModelRenderer backlegs;
    private final MModelRenderer tale;
    private final MModelRenderer bodyyy;
    private final MModelRenderer dogi2;
    private final MModelRenderer head_two2;
    private final MModelRenderer ear_one3;
    private final MModelRenderer ear_one4;
    private final MModelRenderer boneee2;
    private final MModelRenderer tale2;
    private final MModelRenderer water;
    private final IAnimation animation;

    public CrystalMaiden()
    {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.Player = new MModelRenderer(this);
        this.Player.setRotationPoint(0.0F, -16.0F, 2.0F);
        this.Head = new MModelRenderer(this);
        this.Head.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.Player.addChild(this.Head);
        this.Head.cubeList.add(new ModelBox(this.Head, 0, 16, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F, false));
        this.Head.cubeList.add(new ModelBox(this.Head, 0, 0, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F, false));
        this.Body = new MModelRenderer(this);
        this.Body.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.Player.addChild(this.Body);
        this.Body.cubeList.add(new ModelBox(this.Body, 28, 28, -4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F, false));
        this.Body.cubeList.add(new ModelBox(this.Body, 28, 28, -4.0F, 0.0F, -2.0F, 8, 12, 4, 0.25F, false));
        this.cape = new MModelRenderer(this);
        this.cape.setRotationPoint(0.0F, 0.5F, 3.0F);
        this.setRotation(this.cape, 0.1745F, 0.0F, 0.0F);
        this.Body.addChild(this.cape);
        this.cape.cubeList.add(new ModelBox(this.cape, 61, 0, -4.0F, 0.0F, 0.0F, 8, 20, 0, 0.0F, false));
        this.b = new MModelRenderer(this);
        this.b.setRotationPoint(-1.0F, 0.0F, 0.0F);
        this.setRotation(this.b, 0.0868F, 0.0125F, -0.1744F);
        this.cape.addChild(this.b);
        this.b.cubeList.add(new ModelBox(this.b, 89, 0, 2.0F, 0.0F, 0.0F, 6, 20, 0, 0.0F, false));
        this.c = new MModelRenderer(this);
        this.c.setRotationPoint(-1.0F, 0.0F, 0.0F);
        this.setRotation(this.c, 0.0868F, -0.0125F, 0.1744F);
        this.cape.addChild(this.c);
        this.c.cubeList.add(new ModelBox(this.c, 77, 0, -6.0F, 0.0F, 0.0F, 6, 20, 0, 0.0F, false));
        this.RightArm = new MModelRenderer(this);
        this.RightArm.setRotationPoint(-5.0F, -6.0F, 0.0F);
        this.Player.addChild(this.RightArm);
        this.RightArm.cubeList.add(new ModelBox(this.RightArm, 0, 49, -3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));
        this.RightArm.cubeList.add(new ModelBox(this.RightArm, 52, 44, -3.0F, -2.0F, -2.0F, 4, 12, 4, 0.25F, false));
        this.LeftArm = new MModelRenderer(this);
        this.LeftArm.setRotationPoint(5.0F, -6.0F, 0.0F);
        this.Player.addChild(this.LeftArm);
        this.LeftArm.cubeList.add(new ModelBox(this.LeftArm, 48, 40, -1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));
        this.LeftArm.cubeList.add(new ModelBox(this.LeftArm, 0, 48, -2.0F, -2.0F, -2.0F, 4, 12, 4, 0.25F, false));
        this.Staff = new MModelRenderer(this);
        this.Staff.setRotationPoint(1.5F, 11.5F, 0.5F);
        this.setRotation(this.Staff, 0.9163F, 0.0F, 0.0F);
        this.LeftArm.addChild(this.Staff);
        this.Staff.cubeList.add(new ModelBox(this.Staff, 3, 5, -0.5F, 10.5F, -0.5F, 1, 1, 1, 0.35F, false));
        this.Staff.cubeList.add(new ModelBox(this.Staff, 28, 4, -0.5F, -18.4F, -0.5F, 1, 3, 1, 0.01F, false));
        this.Staff.cubeList.add(new ModelBox(this.Staff, 56, 0, -0.5F, -4.5F, -0.5F, 1, 15, 1, 0.0F, false));
        this.bonefour = new MModelRenderer(this);
        this.bonefour.setRotationPoint(0.2F, -15.3F, 0.0F);
        this.setRotation(this.bonefour, 0.0F, 0.0F, 0.9163F);
        this.Staff.addChild(this.bonefour);
        this.bonefour.cubeList.add(new ModelBox(this.bonefour, 24, 0, -0.9233F, -0.6939F, -0.49F, 5, 1, 1, 0.0F, false));
        this.bonefour.cubeList.add(new ModelBox(this.bonefour, 24, 18, 0.0767F, 0.3061F, -0.49F, 4, 1, 1, 0.0F, false));
        this.bonetwo = new MModelRenderer(this);
        this.bonetwo.setRotationPoint(0.0F, -8.5F, 0.0F);
        this.setRotation(this.bonetwo, 0.0F, 0.0F, 0.9599F);
        this.Staff.addChild(this.bonetwo);
        this.bonetwo.cubeList.add(new ModelBox(this.bonetwo, 0, 16, -0.5F, -4.0F, -0.51F, 1, 4, 1, 0.0F, false));
        this.bonetwo.cubeList.add(new ModelBox(this.bonetwo, 10, 38, -1.5F, -5.0F, -0.51F, 1, 4, 1, 0.0F, false));
        this.boneone = new MModelRenderer(this);
        this.boneone.setRotationPoint(0.0F, -8.5F, 0.0F);
        this.setRotation(this.boneone, 0.0F, 0.0F, -0.9599F);
        this.Staff.addChild(this.boneone);
        this.boneone.cubeList.add(new ModelBox(this.boneone, 4, 16, -0.5F, -4.0F, -0.49F, 1, 4, 1, 0.0F, false));
        this.boneone.cubeList.add(new ModelBox(this.boneone, 10, 32, 0.5F, -5.0F, -0.49F, 1, 5, 1, 0.0F, false));
        this.bonethree = new MModelRenderer(this);
        this.bonethree.setRotationPoint(-2.8F, -12.3F, 0.0F);
        this.setRotation(this.bonethree, 0.0F, 0.0F, -0.9163F);
        this.Staff.addChild(this.bonethree);
        this.bonethree.cubeList.add(new ModelBox(this.bonethree, 24, 2, -0.2F, -0.5F, -0.5F, 5, 1, 1, 0.0F, false));
        this.bonethree.cubeList.add(new ModelBox(this.bonethree, 24, 16, -0.2F, 0.5F, -0.5F, 4, 1, 1, 0.0F, false));
        this.bonef = new MModelRenderer(this);
        this.bonef.setRotationPoint(-2.0F, -14.9F, 0.0F);
        this.setRotation(this.bonef, 0.0F, 0.0F, -0.5236F);
        this.Staff.addChild(this.bonef);
        this.bonef.cubeList.add(new ModelBox(this.bonef, 24, 20, -0.5F, -1.7F, -0.5F, 1, 3, 1, 0.01F, false));
        this.boses = new MModelRenderer(this);
        this.boses.setRotationPoint(2.0F, -14.9F, 0.0F);
        this.setRotation(this.boses, 0.0F, 0.0F, 0.5236F);
        this.Staff.addChild(this.boses);
        this.boses.cubeList.add(new ModelBox(this.boses, 24, 4, -0.5F, -1.7F, -0.5F, 1, 3, 1, 0.01F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(-13.5F, 11.5F, -9.5F);
        this.Staff.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 16, 32, 13.0F, -20.0F, 9.0F, 1, 4, 1, 0.2F, false));
        this.RightLeg = new MModelRenderer(this);
        this.RightLeg.setRotationPoint(-1.9F, 4.0F, 0.0F);
        this.Player.addChild(this.RightLeg);
        this.RightLeg.cubeList.add(new ModelBox(this.RightLeg, 32, 44, -2.1F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));
        this.RightLeg.cubeList.add(new ModelBox(this.RightLeg, 44, 12, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.13F, false));
        this.LeftLeg = new MModelRenderer(this);
        this.LeftLeg.setRotationPoint(1.9F, 4.0F, 0.0F);
        this.Player.addChild(this.LeftLeg);
        this.LeftLeg.cubeList.add(new ModelBox(this.LeftLeg, 16, 40, -1.9F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));
        this.LeftLeg.cubeList.add(new ModelBox(this.LeftLeg, 32, 0, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.13F, false));
        this.dogi = new MModelRenderer(this);
        this.dogi.setRotationPoint(-13.0F, -8.0F, -11.0F);
        this.head_two = new MModelRenderer(this);
        this.head_two.setRotationPoint(0.4833F, -2.7517F, -3.5667F);
        this.dogi.addChild(this.head_two);
        this.head_two.cubeList.add(new ModelBox(this.head_two, 55, 66, -3.4933F, -2.7483F, -4.4333F, 1, 4, 4, 0.0F, false));
        this.head_two.cubeList.add(new ModelBox(this.head_two, 55, 66, 2.5267F, -2.7483F, -4.4333F, 1, 4, 4, 0.0F, false));
        this.head_two.cubeList.add(new ModelBox(this.head_two, 28, 60, -2.9833F, -4.2483F, -5.4333F, 6, 6, 6, 0.0F, false));
        this.head_two.cubeList.add(new ModelBox(this.head_two, 51, 60, -1.5833F, -1.2583F, -8.1333F, 3, 3, 3, 0.0F, false));
        this.head_two.cubeList.add(new ModelBox(this.head_two, 24, 56, 0.6167F, -2.2483F, -5.5333F, 1, 1, 1, 0.0F, false));
        this.head_two.cubeList.add(new ModelBox(this.head_two, 24, 56, -1.5833F, -2.2483F, -5.5333F, 1, 1, 1, 0.0F, false));
        this.ear_one = new MModelRenderer(this);
        this.ear_one.setRotationPoint(2.5167F, -3.7483F, -2.9333F);
        this.setRotation(this.ear_one, 0.0F, 0.0F, 0.1309F);
        this.head_two.addChild(this.ear_one);
        this.ear_one.cubeList.add(new ModelBox(this.ear_one, 0, 0, -1.2611F, -2.4829F, -0.5F, 2, 3, 1, 0.0F, false));
        this.ear_one.cubeList.add(new ModelBox(this.ear_one, 0, 0, -0.7611F, -3.4829F, -0.5F, 1, 1, 1, 0.0F, false));
        this.ear_one2 = new MModelRenderer(this);
        this.ear_one2.setRotationPoint(-2.4833F, -5.7483F, -2.9333F);
        this.setRotation(this.ear_one2, 0.0F, 0.0F, -0.1309F);
        this.head_two.addChild(this.ear_one2);
        this.ear_one2.cubeList.add(new ModelBox(this.ear_one2, 0, 0, -1.0F, -0.5F, -0.5F, 2, 3, 1, 0.0F, false));
        this.ear_one2.cubeList.add(new ModelBox(this.ear_one2, 0, 0, -0.5F, -1.5F, -0.5F, 1, 1, 1, 0.0F, false));
        this.boneee = new MModelRenderer(this);
        this.boneee.setRotationPoint(8.5167F, 10.7517F, 14.5667F);
        this.head_two.addChild(this.boneee);
        this.boneee.cubeList.add(new ModelBox(this.boneee, 28, 56, -9.0F, -13.8F, -20.3F, 1, 2, 1, 0.0F, false));
        this.frontlegs = new MModelRenderer(this);
        this.frontlegs.setRotationPoint(0.5F, 2.5F, -4.0F);
        this.dogi.addChild(this.frontlegs);
        this.frontlegs.cubeList.add(new ModelBox(this.frontlegs, 22, 76, -2.5F, 0.5F, -1.0F, 2, 5, 2, 0.0F, false));
        this.frontlegs.cubeList.add(new ModelBox(this.frontlegs, 22, 83, 0.5F, 0.5F, -1.0F, 2, 5, 2, 0.0F, false));
        this.body_one = new MModelRenderer(this);
        this.body_one.setRotationPoint(0.5F, -0.5F, -3.0F);
        this.dogi.addChild(this.body_one);
        this.body_one.cubeList.add(new ModelBox(this.body_one, 30, 71, -3.5F, -3.5F, -3.0F, 7, 7, 6, 0.0F, false));
        this.body_second = new MModelRenderer(this);
        this.body_second.setRotationPoint(0.5F, -0.5F, 4.0F);
        this.dogi.addChild(this.body_second);
        this.backlegs = new MModelRenderer(this);
        this.backlegs.setRotationPoint(0.0F, 2.5F, 1.0F);
        this.body_second.addChild(this.backlegs);
        this.backlegs.cubeList.add(new ModelBox(this.backlegs, 22, 98, -2.5F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false));
        this.backlegs.cubeList.add(new ModelBox(this.backlegs, 22, 90, 0.5F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false));
        this.tale = new MModelRenderer(this);
        this.tale.setRotationPoint(0.0F, -1.0F, 2.0F);
        this.setRotation(this.tale, ((float)Math.PI * 2F / 9F), 0.0F, 0.0F);
        this.body_second.addChild(this.tale);
        this.tale.cubeList.add(new ModelBox(this.tale, 33, 90, -1.5F, -1.5F, 1.0F, 3, 3, 8, 0.0F, false));
        this.bodyyy = new MModelRenderer(this);
        this.body_second.addChild(this.bodyyy);
        this.bodyyy.cubeList.add(new ModelBox(this.bodyyy, 28, 101, -3.5F, -3.0F, -4.0F, 7, 6, 8, 0.0F, false));
        this.dogi2 = new MModelRenderer(this);
        this.dogi2.setRotationPoint(19.9379F, -0.8F, -4.4577F);
        this.dogi2.cubeList.add(new ModelBox(this.dogi2, 77, 65, 0.7582F, -5.2F, 3.1542F, 2, 6, 2, 0.0F, false));
        this.dogi2.cubeList.add(new ModelBox(this.dogi2, 77, 57, 3.7582F, -5.2F, 3.1542F, 2, 6, 2, 0.0F, false));
        this.dogi2.cubeList.add(new ModelBox(this.dogi2, 77, 43, 0.7582F, -4.2F, -5.8458F, 2, 5, 2, 0.0F, false));
        this.dogi2.cubeList.add(new ModelBox(this.dogi2, 77, 50, 3.7582F, -4.2F, -5.8458F, 2, 5, 2, 0.0F, false));
        this.dogi2.cubeList.add(new ModelBox(this.dogi2, 85, 38, -0.2418F, -11.2F, -6.8458F, 7, 7, 6, 0.0F, false));
        this.dogi2.cubeList.add(new ModelBox(this.dogi2, 83, 68, -0.2418F, -10.7F, -0.8458F, 7, 6, 8, 0.0F, false));
        this.head_two2 = new MModelRenderer(this);
        this.head_two2.setRotationPoint(11.7582F, 0.8F, 10.1542F);
        this.dogi2.addChild(this.head_two2);
        this.head_two2.cubeList.add(new ModelBox(this.head_two2, 110, 33, -12.01F, -13.5F, -19.0F, 1, 4, 4, 0.0F, false));
        this.head_two2.cubeList.add(new ModelBox(this.head_two2, 110, 33, -5.99F, -13.5F, -19.0F, 1, 4, 4, 0.0F, false));
        this.head_two2.cubeList.add(new ModelBox(this.head_two2, 83, 27, -11.5F, -15.0F, -20.0F, 6, 6, 6, 0.0F, false));
        this.head_two2.cubeList.add(new ModelBox(this.head_two2, 106, 27, -10.1F, -12.01F, -22.7F, 3, 3, 3, 0.0F, false));
        this.head_two2.cubeList.add(new ModelBox(this.head_two2, 79, 23, -7.9F, -13.0F, -20.1F, 1, 1, 1, 0.0F, false));
        this.head_two2.cubeList.add(new ModelBox(this.head_two2, 79, 23, -10.1F, -13.0F, -20.1F, 1, 1, 1, 0.0F, false));
        this.ear_one3 = new MModelRenderer(this);
        this.ear_one3.setRotationPoint(-6.0F, -16.5F, -17.5F);
        this.setRotation(this.ear_one3, 0.0F, 0.0F, 0.1309F);
        this.head_two2.addChild(this.ear_one3);
        this.ear_one3.cubeList.add(new ModelBox(this.ear_one3, 77, 31, -1.0F, -0.5F, -0.5F, 2, 3, 1, 0.0F, false));
        this.ear_one3.cubeList.add(new ModelBox(this.ear_one3, 77, 31, -0.5F, -1.5F, -0.5F, 1, 1, 1, 0.0F, false));
        this.ear_one4 = new MModelRenderer(this);
        this.ear_one4.setRotationPoint(-11.0F, -16.5F, -17.5F);
        this.setRotation(this.ear_one4, 0.0F, 0.0F, -0.1309F);
        this.head_two2.addChild(this.ear_one4);
        this.ear_one4.cubeList.add(new ModelBox(this.ear_one4, 77, 31, -1.0F, -0.5F, -0.5F, 2, 3, 1, 0.0F, false));
        this.ear_one4.cubeList.add(new ModelBox(this.ear_one4, 77, 31, -0.5F, -1.5F, -0.5F, 1, 1, 1, 0.0F, false));
        this.boneee2 = new MModelRenderer(this);
        this.head_two2.addChild(this.boneee2);
        this.boneee2.cubeList.add(new ModelBox(this.boneee2, 83, 23, -9.0F, -13.8F, -20.3F, 1, 2, 1, 0.0F, false));
        this.tale2 = new MModelRenderer(this);
        this.tale2.setRotationPoint(3.2582F, -8.7F, 5.1542F);
        this.setRotation(this.tale2, ((float)Math.PI * 2F / 9F), 0.0F, 0.0F);
        this.dogi2.addChild(this.tale2);
        this.tale2.cubeList.add(new ModelBox(this.tale2, 88, 57, -1.5F, -1.5F, 1.0F, 3, 3, 8, 0.0F, false));
        this.water = new MModelRenderer(this);
        this.water.setRotationPoint(22.5F, 0.0F, -7.0F);
        this.water.cubeList.add(new ModelBox(this.water, 34, 103, -11.5F, -1.0F, -12.0F, 23, 2, 24, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/crystalmaiden.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/crystalmaiden_animation.json"));
        this.animation = bbanimationloader.mustGet("crystalmaiden.animation", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        this.animation.tick(time);
        double d0 = Math.sin((double)(time * 0.05F)) * 0.10000000149011612D;
        GlStateManager.translate(1.35D, -0.25D + d0, 0.4D);
        double d1 = 0.38D;
        GlStateManager.scale(d1, d1, d1);
    }

    public void renderAsItem(float time)
    {
        this.animation.tick(time);
        GlStateManager.translate(0.0D, 0.29700000000000004D, 0.0D);
        double d0 = 0.42D;
        GlStateManager.scale(d0, d0, d0);
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
        return "\u041a\u0440\u0438\u0441\u0442\u0430\u043b\u044c\u043d\u0430\u044f \u0414\u0435\u0432\u0430";
    }

    public String getCreator()
    {
        return "NovikoV1337 & Sir_Kelt";
    }

    public List<String> getDescription()
    {
        return MNaming.fromGame("DOTA 2");
    }
}
