package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.List;
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
import net.xtrafrancyz.mods.minidot.util.MNaming;

public class MegaBox extends BasePet
{
    private final MModelRenderer root;
    private final MModelRenderer caze;
    private final MModelRenderer cap;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final MModelRenderer bone2;
    private final MModelRenderer bone;
    private final MModelRenderer PlayerModel;
    private final MModelRenderer head;
    private final MModelRenderer chupa_chups;
    private final MModelRenderer buttons;
    private final MModelRenderer legs;
    private final MModelRenderer l_leg;
    private final MModelRenderer r_leg;
    private final MModelRenderer arms;
    private final MModelRenderer r_arm;
    private final MModelRenderer bone7;
    private final MModelRenderer r_arm2;
    private final MModelRenderer bone8;
    private final MModelRenderer body;
    private final MModelRenderer bone9;
    private final IAnimation animation;
    private final IAnimation secretAnimation;
    private IAnimation activeAnimation;

    public MegaBox()
    {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.root = new MModelRenderer(this);
        this.root.setRotationPoint(1.0F, -16.0F, -1.0F);
        this.caze = new MModelRenderer(this);
        this.caze.setRotationPoint(-1.0F, 16.0F, 1.0F);
        this.root.addChild(this.caze);
        this.caze.cubeList.add(new ModelBox(this.caze, 0, 38, -15.0F, -16.0F, -12.0F, 33, 16, 22, 0.0F, false));
        this.cap = new MModelRenderer(this);
        this.cap.setRotationPoint(1.0F, -15.0F, 10.0F);
        this.caze.addChild(this.cap);
        this.cap.cubeList.add(new ModelBox(this.cap, 0, 0, -17.0F, -13.0F, -23.0F, 35, 13, 25, 0.0F, false));
        this.cap.cubeList.add(new ModelBox(this.cap, 60, 76, -6.0F, 0.0F, -23.0F, 13, 6, 1, 0.0F, false));
        this.cap.cubeList.add(new ModelBox(this.cap, 9, 38, 4.0F, -17.0F, -12.0F, 3, 4, 3, 0.0F, false));
        this.cap.cubeList.add(new ModelBox(this.cap, 55, 83, -6.0F, -17.0F, -12.0F, 3, 4, 3, 0.0F, false));
        this.cap.cubeList.add(new ModelBox(this.cap, 24, 76, -7.0F, -20.0F, -12.0F, 15, 3, 3, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(2.0F, 15.0F, -10.0F);
        this.cap.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 0, -19.0F, -15.0F, -6.0F, 1, 10, 11, 0.0F, true));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(-19.0F, -10.25F, -0.5F);
        this.setRotation(this.bone4, -0.7854F, 0.0F, 0.0F);
        this.bone3.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 32, 82, -2.0F, -3.75F, -3.5F, 1, 2, 7, 0.0F, true));
        this.bone4.cubeList.add(new ModelBox(this.bone4, 0, 38, -1.0F, -3.75F, -3.5F, 1, 7, 7, 0.0F, true));
        this.bone4.cubeList.add(new ModelBox(this.bone4, 81, 76, -2.0F, 1.25F, -3.5F, 1, 2, 7, 0.0F, true));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-1.0F, 15.0F, -10.0F);
        this.cap.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 0, 18.0F, -15.0F, -6.0F, 1, 10, 11, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(19.0F, -10.25F, -0.5F);
        this.setRotation(this.bone, -0.7854F, 0.0F, 0.0F);
        this.bone2.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 32, 82, 1.0F, -3.75F, -3.5F, 1, 2, 7, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 38, 0.0F, -3.75F, -3.5F, 1, 7, 7, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 81, 76, 1.0F, 1.25F, -3.5F, 1, 2, 7, 0.0F, false));
        this.PlayerModel = new MModelRenderer(this);
        this.PlayerModel.setRotationPoint(1.0F, 16.0F, 1.0F);
        this.root.addChild(this.PlayerModel);
        this.head = new MModelRenderer(this);
        this.head.setRotationPoint(0.0F, -15.0F, 0.0F);
        this.PlayerModel.addChild(this.head);
        this.head.cubeList.add(new ModelBox(this.head, 0, 76, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F, false));
        this.head.cubeList.add(new ModelBox(this.head, 0, 92, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F, false));
        this.head.cubeList.add(new ModelBox(this.head, 0, 45, 0.0F, -7.0F, 2.0F, 0, 7, 7, 0.0F, false));
        this.chupa_chups = new MModelRenderer(this);
        this.chupa_chups.setRotationPoint(0.0F, -0.25F, -4.0F);
        this.setRotation(this.chupa_chups, -1.7352F, -0.648F, 0.0998F);
        this.head.addChild(this.chupa_chups);
        this.chupa_chups.cubeList.add(new ModelBox(this.chupa_chups, 95, 10, -0.5F, -0.5F, -1.0F, 1, 4, 1, -0.3F, false));
        this.chupa_chups.cubeList.add(new ModelBox(this.chupa_chups, 95, 8, -0.5F, -0.5F, -1.0F, 1, 1, 1, 0.0F, false));
        this.buttons = new MModelRenderer(this);
        this.buttons.setRotationPoint(-2.0F, 15.0F, 0.0F);
        this.head.addChild(this.buttons);
        this.buttons.cubeList.add(new ModelBox(this.buttons, 95, 15, -3.0F, -21.65F, -1.5F, 1, 3, 3, 0.0F, false));
        this.buttons.cubeList.add(new ModelBox(this.buttons, 95, 15, 6.0F, -21.65F, -1.5F, 1, 3, 3, 0.0F, true));
        this.legs = new MModelRenderer(this);
        this.PlayerModel.addChild(this.legs);
        this.l_leg = new MModelRenderer(this);
        this.l_leg.setRotationPoint(1.0F, -9.0F, 0.0F);
        this.setRotation(this.l_leg, -0.1308F, -0.0057F, -0.1742F);
        this.legs.addChild(this.l_leg);
        this.l_leg.cubeList.add(new ModelBox(this.l_leg, 0, 0, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false));
        this.r_leg = new MModelRenderer(this);
        this.r_leg.setRotationPoint(-1.0F, -9.0F, 0.0F);
        this.setRotation(this.r_leg, 0.1309F, 0.0F, 0.2182F);
        this.legs.addChild(this.r_leg);
        this.r_leg.cubeList.add(new ModelBox(this.r_leg, 14, 50, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false));
        this.arms = new MModelRenderer(this);
        this.PlayerModel.addChild(this.arms);
        this.r_arm = new MModelRenderer(this);
        this.r_arm.setRotationPoint(-3.0F, -14.0F, 0.0F);
        this.setRotation(this.r_arm, 0.0F, 0.0F, 1.7453F);
        this.arms.addChild(this.r_arm);
        this.r_arm.cubeList.add(new ModelBox(this.r_arm, 95, 0, -1.0F, -1.0F, -1.0F, 2, 3, 2, 0.001F, false));
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(-1.0F, 2.0F, 0.0F);
        this.r_arm.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 0, 76, 0.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F, false));
        this.r_arm2 = new MModelRenderer(this);
        this.r_arm2.setRotationPoint(2.0F, -15.0F, 0.0F);
        this.setRotation(this.r_arm2, 0.0F, 0.0F, -0.1367F);
        this.arms.addChild(this.r_arm2);
        this.r_arm2.cubeList.add(new ModelBox(this.r_arm2, 95, 0, 0.0F, 0.0F, -1.0F, 2, 3, 2, 0.001F, true));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(2.0F, 3.0F, 0.0F);
        this.setRotation(this.bone8, 0.0F, 0.0F, 0.6109F);
        this.r_arm2.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 0, 76, -2.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F, true));
        this.body = new MModelRenderer(this);
        this.body.setRotationPoint(0.0F, -15.0F, 0.0F);
        this.PlayerModel.addChild(this.body);
        this.body.cubeList.add(new ModelBox(this.body, 13, 0, -2.0F, 0.0F, -1.0F, 4, 6, 2, 0.0F, false));
        this.body.cubeList.add(new ModelBox(this.body, 43, 84, -2.0001F, 3.0001F, -1.9999F, 4, 3, 1, -1.0E-4F, false));
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(0.0F, 0.0F, -1.0F);
        this.setRotation(this.bone9, -0.1745F, 0.0F, 0.0F);
        this.body.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 95, 5, -1.0F, 0.0F, 0.0F, 2, 3, 0, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/megabox.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/megabox_animation.json"));
        this.animation = bbanimationloader.mustGet("megabox.animation", this);
        this.secretAnimation = bbanimationloader.mustGet("megabox.animation.legendary", this);
        this.activeAnimation = this.animation;
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.04F;
        GlStateManager.translate(0.7F, -0.3F + f, 0.2F);
        float f1 = 0.35F;
        GlStateManager.scale(f1, f1, f1);
        super.preRender(modelPlayer, player, time, pi);
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        if (this.activeAnimation.isFinished() && this.activeAnimation.equals(this.secretAnimation))
        {
            this.activeAnimation = this.animation;
            this.secretAnimation.reset();
        }
        else if (this.animation.isFinished() && (double)player.worldObj.rand.nextFloat() < 0.002D)
        {
            this.activeAnimation = this.secretAnimation;
            this.animation.reset();
        }
        else
        {
            this.activeAnimation.tick(time);
        }
    }

    public void renderAsItem(float time)
    {
        this.activeAnimation.tick(time);
        GlStateManager.translate(0.0D, 0.25D, 0.0D);
        double d0 = 0.3873D;
        GlStateManager.scale(d0, d0, d0);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041c\u0435\u0433\u0430 \u044f\u0449\u0438\u043a";
    }

    public List<String> getDescription()
    {
        return MNaming.fromGame("Brawl Stars");
    }

    public String getCreator()
    {
        return "Rander_";
    }
}
