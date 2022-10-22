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

public class CopperGolem extends BasePet
{
    private final MModelRenderer Project;
    private final MModelRenderer Golems;
    private final MModelRenderer c_golem;
    private final MModelRenderer right_leg;
    private final MModelRenderer left_leg;
    private final MModelRenderer Head;
    private final MModelRenderer Left_hand;
    private final MModelRenderer Right_Hand;
    private final MModelRenderer g_golem;
    private final MModelRenderer Head_two;
    private final MModelRenderer Left_hand_two;
    private final MModelRenderer Right_Hand_two;
    private final MModelRenderer Cloud;
    private final MModelRenderer one;
    private final MModelRenderer two;
    private final MModelRenderer three;
    private final MModelRenderer four;
    private final MModelRenderer Lighting_one;
    private final MModelRenderer Lighting_two;
    private final MModelRenderer PDA_destroying;
    private final MModelRenderer button;
    private final IAnimation animation;

    public CopperGolem()
    {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.Project = new MModelRenderer(this);
        this.Project.setRotationPoint(-7.0F, -7.0F, -18.0F);
        this.Golems = new MModelRenderer(this);
        this.Golems.setRotationPoint(7.0F, 7.0F, 0.0F);
        this.Project.addChild(this.Golems);
        this.c_golem = new MModelRenderer(this);
        this.c_golem.setRotationPoint(0.0F, -10.6667F, 16.8333F);
        this.Golems.addChild(this.c_golem);
        this.c_golem.cubeList.add(new ModelBox(this.c_golem, 0, 38, -7.0F, -6.3333F, -1.8333F, 14, 7, 6, 0.0F, false));
        this.right_leg = new MModelRenderer(this);
        this.right_leg.setRotationPoint(-4.0F, 1.1667F, 1.1667F);
        this.c_golem.addChild(this.right_leg);
        this.right_leg.cubeList.add(new ModelBox(this.right_leg, 44, 0, -3.0F, -0.5F, -2.0F, 6, 5, 4, 0.0F, false));
        this.left_leg = new MModelRenderer(this);
        this.left_leg.setRotationPoint(4.0F, 1.1667F, 1.1667F);
        this.c_golem.addChild(this.left_leg);
        this.left_leg.cubeList.add(new ModelBox(this.left_leg, 44, 0, -3.0F, -0.5F, -2.0F, 6, 5, 4, 0.0F, false));
        this.Head = new MModelRenderer(this);
        this.Head.setRotationPoint(0.0F, -6.3333F, 1.1667F);
        this.c_golem.addChild(this.Head);
        this.Head.cubeList.add(new ModelBox(this.Head, 0, 0, -8.0F, -11.0F, -6.0F, 16, 11, 12, 0.0F, false));
        this.Head.cubeList.add(new ModelBox(this.Head, 0, 23, -2.5F, -4.0F, -8.0F, 5, 7, 2, -0.1F, false));
        this.Head.cubeList.add(new ModelBox(this.Head, 0, 0, -1.0F, -16.0F, -1.0F, 2, 5, 2, 0.1F, false));
        this.Head.cubeList.add(new ModelBox(this.Head, 40, 23, -3.0F, -21.0F, -2.5F, 6, 5, 5, -0.2F, false));
        this.Left_hand = new MModelRenderer(this);
        this.Left_hand.setRotationPoint(7.0F, -5.3333F, 1.1667F);
        this.c_golem.addChild(this.Left_hand);
        this.Left_hand.cubeList.add(new ModelBox(this.Left_hand, 40, 38, 0.0F, -1.0F, -2.0F, 5, 15, 4, 0.0F, false));
        this.Right_Hand = new MModelRenderer(this);
        this.Right_Hand.setRotationPoint(-8.0F, -5.3333F, 1.1667F);
        this.c_golem.addChild(this.Right_Hand);
        this.Right_Hand.cubeList.add(new ModelBox(this.Right_Hand, 0, 51, -4.0F, -1.0F, -2.0F, 5, 15, 4, 0.0F, false));
        this.g_golem = new MModelRenderer(this);
        this.g_golem.setRotationPoint(-7.0F, -7.0F, 14.0F);
        this.Golems.addChild(this.g_golem);
        this.g_golem.cubeList.add(new ModelBox(this.g_golem, 82, 45, 0.0F, -3.0F, 2.0F, 6, 5, 4, 0.0F, false));
        this.g_golem.cubeList.add(new ModelBox(this.g_golem, 82, 54, 8.0F, -3.0F, 2.0F, 6, 5, 4, 0.0F, false));
        this.g_golem.cubeList.add(new ModelBox(this.g_golem, 72, 26, 0.0F, -10.0F, 1.0F, 14, 7, 6, 0.0F, false));
        this.Head_two = new MModelRenderer(this);
        this.Head_two.setRotationPoint(7.0F, -10.0F, 4.0F);
        this.g_golem.addChild(this.Head_two);
        this.Head_two.cubeList.add(new ModelBox(this.Head_two, 64, 0, -8.0F, -11.0F, -6.0F, 16, 11, 12, 0.0F, false));
        this.Head_two.cubeList.add(new ModelBox(this.Head_two, 106, 54, -3.0F, -21.0F, -2.5F, 6, 5, 5, -0.2F, false));
        this.Head_two.cubeList.add(new ModelBox(this.Head_two, 64, 25, -1.0F, -16.0F, -1.0F, 2, 5, 2, 0.1F, false));
        this.Head_two.cubeList.add(new ModelBox(this.Head_two, 113, 25, -2.5F, -4.0F, -8.0F, 5, 7, 2, -0.1F, false));
        this.Left_hand_two = new MModelRenderer(this);
        this.Left_hand_two.setRotationPoint(14.0F, -9.0F, 4.0F);
        this.g_golem.addChild(this.Left_hand_two);
        this.Left_hand_two.cubeList.add(new ModelBox(this.Left_hand_two, 108, 35, 0.0F, -1.0F, -2.0F, 5, 15, 4, 0.0F, false));
        this.Right_Hand_two = new MModelRenderer(this);
        this.Right_Hand_two.setRotationPoint(-1.0F, -9.0F, 4.0F);
        this.g_golem.addChild(this.Right_Hand_two);
        this.Right_Hand_two.cubeList.add(new ModelBox(this.Right_Hand_two, 64, 45, -4.0F, -1.0F, -2.0F, 5, 15, 4, 0.0F, false));
        this.Cloud = new MModelRenderer(this);
        this.Cloud.setRotationPoint(7.0F, -58.0F, 18.0F);
        this.Project.addChild(this.Cloud);
        this.one = new MModelRenderer(this);
        this.one.setRotationPoint(-3.0F, -1.0F, 2.875F);
        this.Cloud.addChild(this.one);
        this.one.cubeList.add(new ModelBox(this.one, 30, 115, -8.0F, 6.0F, -5.875F, 18, 6, 7, 0.0F, false));
        this.two = new MModelRenderer(this);
        this.two.setRotationPoint(2.0F, 44.0F, -9.0F);
        this.Cloud.addChild(this.two);
        this.two.cubeList.add(new ModelBox(this.two, 0, 102, -6.0F, -36.0F, 3.0F, 12, 6, 7, 0.0F, false));
        this.three = new MModelRenderer(this);
        this.three.setRotationPoint(2.0F, 44.0F, -9.0F);
        this.Cloud.addChild(this.three);
        this.three.cubeList.add(new ModelBox(this.three, 0, 115, 0.0F, -41.0F, 9.0F, 8, 6, 7, 0.0F, false));
        this.four = new MModelRenderer(this);
        this.four.setRotationPoint(2.0F, 44.0F, -9.0F);
        this.Cloud.addChild(this.four);
        this.four.cubeList.add(new ModelBox(this.four, 38, 102, -17.0F, -40.0F, 10.0F, 8, 6, 7, 0.0F, false));
        this.Lighting_one = new MModelRenderer(this);
        this.Lighting_one.setRotationPoint(12.5F, 20.5F, -1.0F);
        this.Cloud.addChild(this.Lighting_one);
        this.Lighting_one.cubeList.add(new ModelBox(this.Lighting_one, 87, 111, -7.5F, -6.5F, 0.0F, 11, 13, 0, 0.0F, false));
        this.Lighting_two = new MModelRenderer(this);
        this.Lighting_two.setRotationPoint(-9.5F, 20.5F, -1.0F);
        this.Cloud.addChild(this.Lighting_two);
        this.Lighting_two.cubeList.add(new ModelBox(this.Lighting_two, 87, 111, -5.5F, -6.5F, 0.0F, 11, 13, 0, 0.0F, false));
        this.PDA_destroying = new MModelRenderer(this);
        this.PDA_destroying.setRotationPoint(-14.0F, -29.0F, -14.5F);
        this.setRotation(this.PDA_destroying, 1.5708F, 0.0F, 1.5708F);
        this.PDA_destroying.cubeList.add(new ModelBox(this.PDA_destroying, 11, 70, -5.0F, -1.0F, -3.5F, 10, 2, 7, 0.0F, false));
        this.PDA_destroying.cubeList.add(new ModelBox(this.PDA_destroying, 0, 70, -12.0F, -0.5F, -2.5F, 1, 1, 1, 0.2F, false));
        this.PDA_destroying.cubeList.add(new ModelBox(this.PDA_destroying, -5, 79, -13.0F, 0.0F, -2.5F, 8, 0, 5, 0.0F, false));
        this.PDA_destroying.cubeList.add(new ModelBox(this.PDA_destroying, -5, 84, -4.0F, -1.001F, -2.5F, 3, 0, 5, 0.0F, false));
        this.button = new MModelRenderer(this);
        this.button.setRotationPoint(2.0F, -1.3F, 0.0F);
        this.PDA_destroying.addChild(this.button);
        this.button.cubeList.add(new ModelBox(this.button, 0, 89, -1.0F, -1.0F, -1.0F, 2, 2, 2, 0.15F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/coppergolem.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/coppergolem_animation.json"));
        this.animation = bbanimationloader.mustGet("coppergolem.animation", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        GlStateManager.translate(1.25D, -0.08D + (double)f, 0.4D);
        double d0 = 0.49D;
        GlStateManager.scale(d0, d0, d0);
        this.animation.tick(time);
    }

    public void renderAsItem(float time)
    {
        this.animation.tick(time);
        GlStateManager.translate(0.0D, 0.41800000000000004D, 0.0D);
        double d0 = 0.56D;
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
        return "\u041c\u0435\u0434\u043d\u044b\u0439 \u0433\u043e\u043b\u0435\u043c";
    }

    public String getCreator()
    {
        return "NovikoV1337 & Sir_Kelt";
    }
}
