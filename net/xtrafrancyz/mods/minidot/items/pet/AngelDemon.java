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
import org.lwjgl.opengl.GL11;

public class AngelDemon extends BasePet
{
    private final MModelRenderer all;
    private final MModelRenderer angel;
    private final MModelRenderer afra;
    private final MModelRenderer Head;
    private final MModelRenderer nimb;
    private final MModelRenderer Body;
    private final MModelRenderer a_right_wing;
    private final MModelRenderer a_left_wing;
    private final MModelRenderer RightArm;
    private final MModelRenderer LeftArm;
    private final MModelRenderer RightLeg;
    private final MModelRenderer LeftLeg;
    private final MModelRenderer demon;
    private final MModelRenderer Head2;
    private final MModelRenderer right_r;
    private final MModelRenderer left_r;
    private final MModelRenderer Body2;
    private final MModelRenderer d_left_wing;
    private final MModelRenderer d_right_wing;
    private final MModelRenderer Tail;
    private final MModelRenderer g1;
    private final MModelRenderer g2;
    private final MModelRenderer RightArm2;
    private final MModelRenderer Weapon;
    private final MModelRenderer LeftArm2;
    private final MModelRenderer pent;
    private final MModelRenderer RightLeg2;
    private final MModelRenderer LeftLeg2;
    private final IAnimation animation;

    public AngelDemon()
    {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.all = new MModelRenderer(this);
        this.angel = new MModelRenderer(this);
        this.angel.setRotationPoint(26.0F, -24.0F, 0.0F);
        this.all.addChild(this.angel);
        this.afra = new MModelRenderer(this);
        this.afra.setRotationPoint(-5.0F, 16.0F, -8.0F);
        this.setRotation(this.afra, -3.1416F, 0.0F, 3.1416F);
        this.angel.addChild(this.afra);
        this.afra.cubeList.add(new ModelBox(this.afra, 23, 0, -1.0F, -12.0F, -5.0F, 16, 16, 0, 0.0F, false));
        this.Head = new MModelRenderer(this);
        this.Head.setRotationPoint(-13.0004F, 0.4123F, 0.3821F);
        this.angel.addChild(this.Head);
        this.Head.cubeList.add(new ModelBox(this.Head, 0, 64, -3.9502F, -8.2939F, -3.5089F, 8, 8, 8, 0.0F, false));
        this.Head.cubeList.add(new ModelBox(this.Head, 60, 40, -3.9502F, -8.2939F, -3.5089F, 8, 8, 8, 0.5F, false));
        this.nimb = new MModelRenderer(this);
        this.nimb.setRotationPoint(4.0E-4F, -9.3123F, 0.6179F);
        this.Head.addChild(this.nimb);
        this.nimb.cubeList.add(new ModelBox(this.nimb, 0, 18, -3.0F, -0.5F, -4.0F, 6, 1, 1, 0.0F, false));
        this.nimb.cubeList.add(new ModelBox(this.nimb, 0, 16, -3.0F, -0.5F, 3.0F, 6, 1, 1, 0.0F, false));
        this.nimb.cubeList.add(new ModelBox(this.nimb, 14, 22, 3.0F, -0.5F, -3.0F, 1, 1, 6, 0.0F, false));
        this.nimb.cubeList.add(new ModelBox(this.nimb, 0, 22, -4.0F, -0.5F, -3.0F, 1, 1, 6, 0.0F, false));
        this.Body = new MModelRenderer(this);
        this.angel.addChild(this.Body);
        this.Body.cubeList.add(new ModelBox(this.Body, 80, 68, -17.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F, false));
        this.Body.cubeList.add(new ModelBox(this.Body, 0, 80, -17.0F, 0.0F, -2.0F, 8, 12, 4, 0.25F, false));
        this.a_right_wing = new MModelRenderer(this);
        this.a_right_wing.setRotationPoint(-14.9F, 4.5F, 2.0F);
        this.setRotation(this.a_right_wing, 0.1745F, 0.0F, 0.0F);
        this.Body.addChild(this.a_right_wing);
        this.a_right_wing.cubeList.add(new ModelBox(this.a_right_wing, 0, 0, 0.0F, -9.5443F, -3.6462F, 0, 17, 30, 0.0F, false));
        this.a_left_wing = new MModelRenderer(this);
        this.a_left_wing.setRotationPoint(-9.9F, 4.5F, 2.0F);
        this.setRotation(this.a_left_wing, 0.1745F, 0.0F, 0.0F);
        this.Body.addChild(this.a_left_wing);
        this.a_left_wing.cubeList.add(new ModelBox(this.a_left_wing, 0, 0, 0.0F, -9.5443F, -3.6462F, 0, 17, 30, 0.0F, false));
        this.RightArm = new MModelRenderer(this);
        this.RightArm.setRotationPoint(-19.4F, 2.3F, 0.0F);
        this.angel.addChild(this.RightArm);
        this.RightArm.cubeList.add(new ModelBox(this.RightArm, 32, 100, -1.6F, -2.3F, -2.0F, 4, 12, 4, 0.0F, false));
        this.RightArm.cubeList.add(new ModelBox(this.RightArm, 100, 16, -1.6F, -2.3F, -2.0F, 4, 12, 4, 0.25F, false));
        this.LeftArm = new MModelRenderer(this);
        this.LeftArm.setRotationPoint(-7.8F, 1.0F, 0.0F);
        this.angel.addChild(this.LeftArm);
        this.LeftArm.cubeList.add(new ModelBox(this.LeftArm, 16, 100, -1.2F, -1.0F, -2.0F, 4, 12, 4, 0.0F, false));
        this.LeftArm.cubeList.add(new ModelBox(this.LeftArm, 0, 96, -1.2F, -1.0F, -2.0F, 4, 12, 4, 0.25F, false));
        this.RightLeg = new MModelRenderer(this);
        this.RightLeg.setRotationPoint(-14.8921F, 11.9454F, -0.0866F);
        this.angel.addChild(this.RightLeg);
        this.RightLeg.cubeList.add(new ModelBox(this.RightLeg, 95, 0, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));
        this.RightLeg.cubeList.add(new ModelBox(this.RightLeg, 92, 84, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.25F, false));
        this.LeftLeg = new MModelRenderer(this);
        this.LeftLeg.setRotationPoint(-10.8921F, 11.9532F, -0.0788F);
        this.angel.addChild(this.LeftLeg);
        this.LeftLeg.cubeList.add(new ModelBox(this.LeftLeg, 92, 32, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));
        this.LeftLeg.cubeList.add(new ModelBox(this.LeftLeg, 56, 88, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.25F, false));
        this.demon = new MModelRenderer(this);
        this.demon.setRotationPoint(-1.0F, -23.0F, 0.0F);
        this.all.addChild(this.demon);
        this.Head2 = new MModelRenderer(this);
        this.Head2.setRotationPoint(0.0247F, -5.9408F, -0.0634F);
        this.demon.addChild(this.Head2);
        this.Head2.cubeList.add(new ModelBox(this.Head2, 60, 24, -3.9753F, -7.9408F, -4.0634F, 8, 8, 8, 0.0F, false));
        this.Head2.cubeList.add(new ModelBox(this.Head2, 52, 56, -3.9753F, -7.9408F, -4.0634F, 8, 8, 8, 0.5F, false));
        this.right_r = new MModelRenderer(this);
        this.right_r.setRotationPoint(-13.0247F, -0.0592F, 0.1634F);
        this.setRotation(this.right_r, -0.0349F, 0.0F, 0.0F);
        this.Head2.addChild(this.right_r);
        this.right_r.cubeList.add(new ModelBox(this.right_r, 0, 22, 8.0F, -8.0F, -2.0F, 1, 2, 2, 0.0F, false));
        this.right_r.cubeList.add(new ModelBox(this.right_r, 0, 22, 7.0F, -9.0F, -1.0F, 1, 2, 2, 0.0F, false));
        this.right_r.cubeList.add(new ModelBox(this.right_r, 0, 0, 6.0F, -10.5F, 0.0F, 1, 2, 1, 0.0F, false));
        this.right_r.cubeList.add(new ModelBox(this.right_r, 0, 0, 6.0F, -9.8F, 1.0F, 1, 2, 1, 0.0F, false));
        this.right_r.cubeList.add(new ModelBox(this.right_r, 16, 3, 7.0F, -10.8F, 1.0F, 1, 1, 1, 0.0F, false));
        this.right_r.cubeList.add(new ModelBox(this.right_r, 16, 3, 7.4F, -11.4F, 2.0F, 1, 1, 1, 0.0F, false));
        this.left_r = new MModelRenderer(this);
        this.left_r.setRotationPoint(-2.0247F, -0.0592F, 0.1634F);
        this.setRotation(this.left_r, -0.0349F, 0.0F, 0.0F);
        this.Head2.addChild(this.left_r);
        this.left_r.cubeList.add(new ModelBox(this.left_r, 0, 22, 6.0F, -8.0F, -2.0F, 1, 2, 2, 0.0F, false));
        this.left_r.cubeList.add(new ModelBox(this.left_r, 0, 22, 7.0F, -9.0F, -1.0F, 1, 2, 2, 0.0F, false));
        this.left_r.cubeList.add(new ModelBox(this.left_r, 0, 0, 8.0F, -10.5F, 0.0F, 1, 2, 1, 0.0F, false));
        this.left_r.cubeList.add(new ModelBox(this.left_r, 0, 0, 8.0F, -9.8F, 1.0F, 1, 2, 1, 0.0F, false));
        this.left_r.cubeList.add(new ModelBox(this.left_r, 16, 3, 7.0F, -10.8F, 1.0F, 1, 1, 1, 0.0F, false));
        this.left_r.cubeList.add(new ModelBox(this.left_r, 16, 3, 6.6F, -11.4F, 2.0F, 1, 1, 1, 0.0F, false));
        this.Body2 = new MModelRenderer(this);
        this.Body2.setRotationPoint(13.0F, -6.0F, 0.0F);
        this.demon.addChild(this.Body2);
        this.Body2.cubeList.add(new ModelBox(this.Body2, 56, 72, -17.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F, false));
        this.Body2.cubeList.add(new ModelBox(this.Body2, 36, 27, -14.0F, 10.0F, 1.5F, 2, 2, 1, 0.0F, false));
        this.Body2.cubeList.add(new ModelBox(this.Body2, 71, 0, -17.0F, 0.0F, -2.0F, 8, 12, 4, 0.25F, false));
        this.d_left_wing = new MModelRenderer(this);
        this.d_left_wing.setRotationPoint(-10.9F, 3.3F, 1.9F);
        this.setRotation(this.d_left_wing, 0.1745F, 0.0F, 0.0F);
        this.Body2.addChild(this.d_left_wing);
        this.d_left_wing.cubeList.add(new ModelBox(this.d_left_wing, 0, 17, 0.0F, -9.0233F, -0.6917F, 0, 17, 30, 0.0F, false));
        this.d_right_wing = new MModelRenderer(this);
        this.d_right_wing.setRotationPoint(-15.9F, 3.3F, 1.9F);
        this.setRotation(this.d_right_wing, 0.1745F, 0.0F, 0.0F);
        this.Body2.addChild(this.d_right_wing);
        this.d_right_wing.cubeList.add(new ModelBox(this.d_right_wing, 0, 17, 0.0F, -9.0233F, -0.6917F, 0, 17, 30, 0.0F, false));
        this.Tail = new MModelRenderer(this);
        this.Tail.setRotationPoint(-13.0F, 10.9F, 2.5F);
        this.Body2.addChild(this.Tail);
        this.g1 = new MModelRenderer(this);
        this.g1.setRotationPoint(0.0F, 4.7F, 2.8F);
        this.Tail.addChild(this.g1);
        this.g1.cubeList.add(new ModelBox(this.g1, 22, 23, -0.5F, -3.9F, -2.8F, 1, 1, 6, 0.0F, false));
        this.g1.cubeList.add(new ModelBox(this.g1, 33, 16, -0.5F, 1.1326F, -1.4379F, 1, 1, 4, 0.0F, false));
        this.g1.cubeList.add(new ModelBox(this.g1, 29, 16, -0.5F, 1.3028F, 1.776F, 1, 1, 2, 0.0F, false));
        this.g2 = new MModelRenderer(this);
        this.g2.setRotationPoint(0.1F, 4.9028F, 2.176F);
        this.g1.addChild(this.g2);
        this.g2.cubeList.add(new ModelBox(this.g2, 22, 25, -0.6F, -0.0849F, -0.5182F, 1, 1, 2, 0.0F, false));
        this.g2.cubeList.add(new ModelBox(this.g2, 22, 22, -0.6F, 0.5415F, 1.3649F, 1, 1, 2, 0.0F, false));
        this.g2.cubeList.add(new ModelBox(this.g2, 8, 22, -0.6F, 0.1213F, 2.8065F, 1, 1, 5, 0.0F, false));
        this.g2.cubeList.add(new ModelBox(this.g2, 9, 0, -1.6F, 0.7213F, 7.4065F, 3, 0, 3, 0.0F, false));
        this.RightArm2 = new MModelRenderer(this);
        this.RightArm2.setRotationPoint(-4.0F, -4.0F, 0.0F);
        this.demon.addChild(this.RightArm2);
        this.RightArm2.cubeList.add(new ModelBox(this.RightArm2, 88, 52, -4.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));
        this.Weapon = new MModelRenderer(this);
        this.Weapon.setRotationPoint(-2.0F, 9.0F, -0.1F);
        this.setRotation(this.Weapon, -0.3927F, 0.0F, 0.0F);
        this.RightArm2.addChild(this.Weapon);
        this.Weapon.cubeList.add(new ModelBox(this.Weapon, 0, 0, -0.5F, -0.5F, -11.9F, 1, 1, 21, 0.0F, false));
        this.Weapon.cubeList.add(new ModelBox(this.Weapon, 36, 22, -1.5F, -0.5F, -13.9F, 3, 1, 2, 0.0F, false));
        this.Weapon.cubeList.add(new ModelBox(this.Weapon, 30, 22, -0.5F, -0.5F, -17.9F, 1, 1, 4, 0.0F, false));
        this.Weapon.cubeList.add(new ModelBox(this.Weapon, 23, 16, 1.5F, -0.5F, -16.9F, 1, 1, 4, 0.0F, false));
        this.Weapon.cubeList.add(new ModelBox(this.Weapon, 10, 16, -2.5F, -0.5F, -16.9F, 1, 1, 4, 0.0F, false));
        this.LeftArm2 = new MModelRenderer(this);
        this.LeftArm2.setRotationPoint(4.0F, -5.0F, 0.0F);
        this.demon.addChild(this.LeftArm2);
        this.LeftArm2.cubeList.add(new ModelBox(this.LeftArm2, 76, 84, 0.0F, -1.0F, -2.0F, 4, 12, 4, 0.0F, false));
        this.pent = new MModelRenderer(this);
        this.pent.setRotationPoint(2.0F, 21.0F, -2.0F);
        this.setRotation(this.pent, -1.5708F, 0.0F, 0.0F);
        this.LeftArm2.addChild(this.pent);
        this.pent.cubeList.add(new ModelBox(this.pent, 72, 100, -14.0F, -15.0F, -1.0F, 28, 28, 0, 0.0F, false));
        this.RightLeg2 = new MModelRenderer(this);
        this.RightLeg2.setRotationPoint(-1.9F, 6.0F, 0.0F);
        this.demon.addChild(this.RightLeg2);
        this.RightLeg2.cubeList.add(new ModelBox(this.RightLeg2, 40, 84, -1.9921F, -0.4546F, -2.0866F, 4, 12, 4, 0.0F, false));
        this.LeftLeg2 = new MModelRenderer(this);
        this.LeftLeg2.setRotationPoint(1.9F, 6.0F, 0.0F);
        this.demon.addChild(this.LeftLeg2);
        this.LeftLeg2.cubeList.add(new ModelBox(this.LeftLeg2, 24, 84, -1.9921F, -0.4468F, -2.0788F, 4, 12, 4, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/angeldemon.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/angeldemon_animation.json"));
        this.animation = bbanimationloader.mustGet("Angel_and_demon", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        double d0 = 2.0D;
        GlStateManager.scale(d0, d0, d0);
        GlStateManager.translate(0.0D, 0.85D, 0.65D);
        this.animation.tick(time);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GL11.glEnable(GL11.GL_CULL_FACE);
        super.render(modelPlayer, player, time, pi);
        GL11.glDisable(GL11.GL_CULL_FACE);
    }

    public void renderAsItem(float time)
    {
        this.animation.tick(time);
        double d0 = 1.6D;
        GlStateManager.scale(d0, d0, d0);
        GlStateManager.translate(0.0D, 0.65D, 0.3D);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0410\u043d\u0433\u0435\u043b \u0438 \u0414\u0435\u043c\u043e\u043d";
    }

    public String getCreator()
    {
        return "NovikoV1337 & Sir_Kelt";
    }
}
