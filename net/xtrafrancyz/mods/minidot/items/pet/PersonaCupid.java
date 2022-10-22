package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.Collections;
import java.util.List;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class PersonaCupid extends BasePet
{
    private final MModelRenderer torso;
    private final MModelRenderer eye_left;
    private final MModelRenderer eye_right;
    private final MModelRenderer ear_right1;
    private final MModelRenderer ear_right2;
    private final MModelRenderer ear_left1;
    private final MModelRenderer ear_left2;
    private final MModelRenderer nimbus;
    private final MModelRenderer leg1;
    private final MModelRenderer leg2;
    private final MModelRenderer leg3;
    private final MModelRenderer arm_left;
    private final MModelRenderer bone;
    private final MModelRenderer bone13;
    private final MModelRenderer bone14;
    private final MModelRenderer bone2;
    private final MModelRenderer arm_right;
    private final MModelRenderer bone15;
    private final MModelRenderer wing_left;
    private final MModelRenderer bone3;
    private final MModelRenderer bone6;
    private final MModelRenderer bone5;
    private final MModelRenderer bone7;
    private final MModelRenderer bone8;
    private final MModelRenderer wing_right;
    private final MModelRenderer bone4;
    private final MModelRenderer bone9;
    private final MModelRenderer bone10;
    private final MModelRenderer bone11;
    private final MModelRenderer bone12;

    public PersonaCupid()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.useDisplayLists = true;
        this.torso = new MModelRenderer(this);
        this.torso.setRotationPoint(-0.25F, 0.0F, 0.0F);
        this.torso.cubeList.add(new ModelBox(this.torso, 0, 11, -3.5F, -10.75F, -1.2F, 6, 6, 5, 0.0F, false));
        this.torso.cubeList.add(new ModelBox(this.torso, 0, 0, -3.95F, -11.15F, -0.7F, 7, 7, 4, 0.0F, false));
        this.eye_left = new MModelRenderer(this);
        this.eye_left.setRotationPoint(-0.25F, 0.0F, 0.0F);
        this.eye_left.cubeList.add(new ModelBox(this.eye_left, 22, 6, 0.5F, -10.75F, -1.3F, 2, 2, 1, -0.001F, false));
        this.eye_right = new MModelRenderer(this);
        this.eye_right.setRotationPoint(-0.25F, 0.0F, 0.0F);
        this.eye_right.cubeList.add(new ModelBox(this.eye_right, 22, 6, -3.5F, -10.75F, -1.3F, 2, 2, 1, -0.001F, false));
        this.ear_right1 = new MModelRenderer(this);
        this.ear_right1.setRotationPoint(0.3056F, -0.2311F, 2.0F);
        this.setRotation(this.ear_right1, 0.0F, 0.0F, -0.2269F);
        this.ear_right1.cubeList.add(new ModelBox(this.ear_right1, 27, 11, -0.8476F, -13.8275F, -1.7F, 1, 3, 2, 0.0F, false));
        this.ear_right2 = new MModelRenderer(this);
        this.ear_right2.setRotationPoint(-1.3472F, 0.2333F, 0.0F);
        this.setRotation(this.ear_right2, 0.0F, 0.0F, -0.0698F);
        this.ear_right2.cubeList.add(new ModelBox(this.ear_right2, 27, 11, -0.3314F, -14.0291F, 0.3F, 1, 3, 2, 0.0F, false));
        this.ear_left1 = new MModelRenderer(this);
        this.ear_left1.setRotationPoint(2.3979F, -0.9701F, 2.0F);
        this.setRotation(this.ear_left1, 0.0F, 0.0F, -0.1222F);
        this.ear_left1.cubeList.add(new ModelBox(this.ear_left1, 33, 11, -0.6162F, -12.4136F, -1.7F, 1, 3, 2, 0.0F, false));
        this.ear_left2 = new MModelRenderer(this);
        this.ear_left2.setRotationPoint(1.694F, 0.2453F, 0.0F);
        this.setRotation(this.ear_left2, 0.0F, 0.0F, 0.1571F);
        this.ear_left2.cubeList.add(new ModelBox(this.ear_left2, 33, 11, -2.5476F, -13.3491F, 0.3F, 1, 3, 2, 0.0F, false));
        this.nimbus = new MModelRenderer(this);
        this.nimbus.setRotationPoint(0.25F, 0.0F, 0.0F);
        this.nimbus.cubeList.add(new ModelBox(this.nimbus, 22, 9, -4.5F, -15.0F, -1.75F, 7, 1, 1, 0.0F, false));
        this.nimbus.cubeList.add(new ModelBox(this.nimbus, 17, 11, 2.5F, -15.0F, -0.75F, 1, 1, 4, 0.0F, false));
        this.nimbus.cubeList.add(new ModelBox(this.nimbus, 22, 9, -4.5F, -15.0F, 3.25F, 7, 1, 1, 0.0F, false));
        this.nimbus.cubeList.add(new ModelBox(this.nimbus, 17, 11, -5.5F, -15.0F, -0.75F, 1, 1, 4, 0.0F, false));
        this.leg1 = new MModelRenderer(this);
        this.leg1.setRotationPoint(0.0603F, -1.0037F, 0.0F);
        this.leg1.cubeList.add(new ModelBox(this.leg1, 43, 4, -3.0348F, -2.2416F, 0.3F, 1, 1, 2, 0.0F, false));
        this.leg1.cubeList.add(new ModelBox(this.leg1, 43, 4, 0.6152F, -2.2416F, 0.3F, 1, 1, 2, 0.0F, false));
        this.leg2 = new MModelRenderer(this);
        this.leg2.setRotationPoint(1.6392F, -1.2155F, 0.0F);
        this.setRotation(this.leg2, 0.0F, 0.0F, 0.1745F);
        this.leg2.cubeList.add(new ModelBox(this.leg2, 43, 0, -4.7377F, -2.3866F, 0.3F, 1, 2, 2, 0.0F, false));
        this.leg2.cubeList.add(new ModelBox(this.leg2, 43, 0, -1.1431F, -3.0204F, 0.3F, 1, 2, 2, 0.0F, false));
        this.leg3 = new MModelRenderer(this);
        this.leg3.setRotationPoint(0.25F, 0.0F, 0.0F);
        this.setRotation(this.leg3, 0.0F, 0.0F, -0.1745F);
        this.leg3.cubeList.add(new ModelBox(this.leg3, 43, 0, -2.7857F, -4.7711F, 0.3F, 1, 2, 2, 0.0F, false));
        this.leg3.cubeList.add(new ModelBox(this.leg3, 43, 0, 0.8089F, -4.1373F, 0.3F, 1, 2, 2, 0.0F, false));
        this.arm_left = new MModelRenderer(this);
        this.setRotation(this.arm_left, 0.0F, 0.0F, 0.5236F);
        this.arm_left.cubeList.add(new ModelBox(this.arm_left, 38, 9, -2.05F, -8.25F, 0.7F, 4, 1, 1, 0.175F, false));
        this.arm_left.cubeList.add(new ModelBox(this.arm_left, 4, 23, 0.95F, -12.8F, 0.7F, 1, 9, 1, -0.4F, false));
        this.arm_left.cubeList.add(new ModelBox(this.arm_left, 17, 12, 1.15F, -6.1F, 0.7F, 1, 2, 1, -0.4F, false));
        this.arm_left.cubeList.add(new ModelBox(this.arm_left, 17, 12, 0.75F, -6.1F, 0.7F, 1, 2, 1, -0.4F, false));
        this.arm_left.cubeList.add(new ModelBox(this.arm_left, 0, 11, 0.95F, -13.9F, 0.7F, 1, 2, 1, -0.39F, false));
        this.arm_left.cubeList.add(new ModelBox(this.arm_left, 31, 6, 0.95F, -14.1F, 0.7F, 1, 1, 1, -0.4F, false));
        this.arm_left.cubeList.add(new ModelBox(this.arm_left, 31, 6, 0.95F, -14.3F, 0.7F, 1, 1, 1, -0.4F, false));
        this.arm_left.cubeList.add(new ModelBox(this.arm_left, 31, 6, 0.95F, -14.5F, 0.7F, 1, 1, 1, -0.4F, false));
        this.arm_left.cubeList.add(new ModelBox(this.arm_left, 31, 6, 0.95F, -14.7F, 0.7F, 1, 1, 1, -0.4F, false));
        this.arm_left.cubeList.add(new ModelBox(this.arm_left, 31, 6, 0.95F, -14.9F, 0.7F, 1, 1, 1, -0.4F, false));
        this.arm_left.cubeList.add(new ModelBox(this.arm_left, 31, 6, 0.95F, -15.1F, 0.7F, 1, 1, 1, -0.4F, false));
        this.arm_left.cubeList.add(new ModelBox(this.arm_left, 31, 6, 0.95F, -15.3F, 0.7F, 1, 1, 1, -0.4F, false));
        this.bone = new MModelRenderer(this);
        this.arm_left.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 31, 6, 0.75F, -14.5F, 0.7F, 2, 1, 1, -0.4F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 31, 6, 1.35F, -14.9F, 0.7F, 1, 1, 1, -0.4F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 31, 6, 1.15F, -15.1F, 0.7F, 1, 2, 1, -0.4F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 31, 6, 0.55F, -14.7F, 0.7F, 2, 1, 1, -0.4F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 31, 6, 0.75F, -14.3F, 0.7F, 2, 1, 1, -0.4F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 31, 6, 0.55F, -14.1F, 0.7F, 2, 1, 1, -0.4F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 31, 6, 1.35F, -13.9F, 0.7F, 1, 1, 1, -0.4F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 31, 6, 1.15F, -14.1F, 0.7F, 1, 1, 1, -0.4F, false));
        this.bone13 = new MModelRenderer(this);
        this.setRotation(this.bone13, 0.0F, -1.5708F, 0.0F);
        this.arm_left.addChild(this.bone13);
        this.bone13.cubeList.add(new ModelBox(this.bone13, 31, 6, 0.5F, -14.5F, -1.95F, 2, 1, 1, -0.4F, false));
        this.bone13.cubeList.add(new ModelBox(this.bone13, 31, 6, 1.1F, -14.9F, -1.95F, 1, 1, 1, -0.4F, false));
        this.bone13.cubeList.add(new ModelBox(this.bone13, 31, 6, 0.9F, -15.1F, -1.95F, 1, 2, 1, -0.4F, false));
        this.bone13.cubeList.add(new ModelBox(this.bone13, 31, 6, 1.3F, -14.7F, -1.95F, 1, 1, 1, -0.4F, false));
        this.bone13.cubeList.add(new ModelBox(this.bone13, 31, 6, 0.5F, -14.3F, -1.95F, 2, 1, 1, -0.4F, false));
        this.bone13.cubeList.add(new ModelBox(this.bone13, 31, 6, 1.3F, -14.1F, -1.95F, 1, 1, 1, -0.4F, false));
        this.bone13.cubeList.add(new ModelBox(this.bone13, 31, 6, 1.1F, -13.9F, -1.95F, 1, 1, 1, -0.4F, false));
        this.bone13.cubeList.add(new ModelBox(this.bone13, 31, 6, 0.9F, -14.1F, -1.95F, 1, 1, 1, -0.4F, false));
        this.bone14 = new MModelRenderer(this);
        this.setRotation(this.bone14, 0.0F, 1.5708F, 0.0F);
        this.arm_left.addChild(this.bone14);
        this.bone14.cubeList.add(new ModelBox(this.bone14, 31, 6, -1.9F, -14.5F, 0.95F, 2, 1, 1, -0.4F, false));
        this.bone14.cubeList.add(new ModelBox(this.bone14, 31, 6, -1.3F, -14.9F, 0.95F, 1, 1, 1, -0.4F, false));
        this.bone14.cubeList.add(new ModelBox(this.bone14, 31, 6, -1.5F, -15.1F, 0.95F, 1, 2, 1, -0.4F, false));
        this.bone14.cubeList.add(new ModelBox(this.bone14, 31, 6, -2.1F, -14.7F, 0.95F, 2, 1, 1, -0.4F, false));
        this.bone14.cubeList.add(new ModelBox(this.bone14, 31, 6, -1.9F, -14.3F, 0.95F, 2, 1, 1, -0.4F, false));
        this.bone14.cubeList.add(new ModelBox(this.bone14, 31, 6, -2.1F, -14.1F, 0.95F, 2, 1, 1, -0.4F, false));
        this.bone14.cubeList.add(new ModelBox(this.bone14, 31, 6, -1.3F, -13.9F, 0.95F, 1, 1, 1, -0.4F, false));
        this.bone14.cubeList.add(new ModelBox(this.bone14, 31, 6, -1.5F, -14.1F, 0.95F, 1, 1, 1, -0.4F, false));
        this.bone2 = new MModelRenderer(this);
        this.setRotation(this.bone2, 0.0F, 3.1416F, 0.0F);
        this.arm_left.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 31, 6, -2.15F, -14.5F, -1.7F, 2, 1, 1, -0.4F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 31, 6, -1.55F, -14.9F, -1.7F, 1, 1, 1, -0.4F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 31, 6, -1.75F, -15.1F, -1.7F, 1, 2, 1, -0.4F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 31, 6, -1.35F, -14.7F, -1.7F, 1, 1, 1, -0.4F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 31, 6, -2.15F, -14.3F, -1.7F, 2, 1, 1, -0.4F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 31, 6, -1.35F, -14.1F, -1.7F, 1, 1, 1, -0.4F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 31, 6, -1.55F, -13.9F, -1.7F, 1, 1, 1, -0.4F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 31, 6, -1.75F, -14.1F, -1.7F, 1, 1, 1, -0.4F, false));
        this.arm_right = new MModelRenderer(this);
        this.setRotation(this.arm_right, 0.0F, -0.5236F, -0.2618F);
        this.arm_right.cubeList.add(new ModelBox(this.arm_right, 38, 9, -5.2061F, -8.654F, 0.4582F, 4, 1, 1, 0.175F, false));
        this.bone15 = new MModelRenderer(this);
        this.setRotation(this.bone15, 0.0F, 1.309F, -0.1745F);
        this.arm_right.addChild(this.bone15);
        this.bone15.cubeList.add(new ModelBox(this.bone15, 0, 0, -1.2061F, -6.004F, -2.9418F, 1, 2, 1, 0.01F, false));
        this.bone15.cubeList.add(new ModelBox(this.bone15, 0, 14, -2.2061F, -6.004F, -2.9418F, 1, 1, 1, 0.01F, false));
        this.bone15.cubeList.add(new ModelBox(this.bone15, 0, 22, -2.1661F, -14.214F, -2.9018F, 1, 10, 1, -1.0F, false));
        this.bone15.cubeList.add(new ModelBox(this.bone15, 0, 0, -1.2061F, -15.004F, -2.9418F, 1, 2, 1, 0.01F, false));
        this.bone15.cubeList.add(new ModelBox(this.bone15, 0, 14, -2.2061F, -14.004F, -2.9418F, 1, 1, 1, 0.01F, false));
        this.bone15.cubeList.add(new ModelBox(this.bone15, 8, 23, -1.0061F, -14.004F, -2.9418F, 1, 9, 1, -0.4F, false));
        this.wing_left = new MModelRenderer(this);
        this.wing_left.setRotationPoint(-0.5F, 0.0F, 0.0F);
        this.setRotation(this.wing_left, 0.0F, -0.1745F, 0.0873F);
        this.wing_left.cubeList.add(new ModelBox(this.wing_left, 22, 20, 0.4203F, -8.9981F, 2.7152F, 6, 3, 1, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.setRotation(this.bone3, 0.0F, -0.1745F, -0.1745F);
        this.wing_left.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 6, 33, 7.7239F, -11.7921F, 1.3951F, 2, 7, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 18, 25, 7.7239F, -11.7921F, 0.3951F, 2, 7, 1, 5.0E-4F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 12, 37, 9.7239F, -11.7921F, 1.3951F, 4, 3, 1, 0.0F, false));
        this.bone6 = new MModelRenderer(this);
        this.setRotation(this.bone6, 0.0F, 0.0F, -0.0524F);
        this.bone3.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 22, 3, 9.091F, -12.0955F, 0.3951F, 10, 2, 1, 0.0F, false));
        this.bone5 = new MModelRenderer(this);
        this.setRotation(this.bone5, 0.0F, 0.0F, 0.1396F);
        this.bone3.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 22, 3, 6.9977F, -11.6447F, 0.3951F, 10, 2, 1, -0.003F, false));
        this.bone7 = new MModelRenderer(this);
        this.setRotation(this.bone7, 0.0F, 0.0F, 0.5585F);
        this.bone5.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 22, 3, 1.7031F, -12.596F, 0.3951F, 10, 2, 1, 0.0F, false));
        this.bone8 = new MModelRenderer(this);
        this.setRotation(this.bone8, 0.0F, 0.0F, 0.3142F);
        this.bone5.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 22, 3, 3.9998F, -12.6098F, 0.3951F, 10, 2, 1, -0.001F, false));
        this.wing_right = new MModelRenderer(this);
        this.wing_right.setRotationPoint(1.25F, -0.25F, 7.0F);
        this.setRotation(this.wing_right, 0.0F, -2.8798F, -0.0873F);
        this.wing_right.cubeList.add(new ModelBox(this.wing_right, 22, 16, 0.4203F, -8.9981F, 3.7F, 6, 3, 1, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(0.0F, 0.0F, 2.0F);
        this.setRotation(this.bone4, 0.0F, 0.0F, -0.1745F);
        this.wing_right.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 0, 33, 7.3643F, -11.7921F, 1.7F, 2, 7, 1, 0.0F, false));
        this.bone4.cubeList.add(new ModelBox(this.bone4, 12, 25, 7.3643F, -11.7921F, 2.6F, 2, 7, 1, 5.0E-4F, false));
        this.bone4.cubeList.add(new ModelBox(this.bone4, 12, 33, 9.3669F, -11.8223F, 1.6995F, 4, 3, 1, 0.0F, false));
        this.bone9 = new MModelRenderer(this);
        this.setRotation(this.bone9, 0.0F, 0.0F, -0.0524F);
        this.bone4.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 18, 0, 8.7361F, -12.1443F, 2.5995F, 10, 2, 1, -0.001F, false));
        this.bone10 = new MModelRenderer(this);
        this.setRotation(this.bone10, 0.0F, 0.0F, 0.1396F);
        this.bone4.addChild(this.bone10);
        this.bone10.cubeList.add(new ModelBox(this.bone10, 18, 0, 6.6399F, -11.6249F, 2.5995F, 10, 2, 1, -0.003F, false));
        this.bone11 = new MModelRenderer(this);
        this.setRotation(this.bone11, 0.0F, 0.0F, 0.5585F);
        this.bone10.addChild(this.bone11);
        this.bone11.cubeList.add(new ModelBox(this.bone11, 18, 0, 1.4102F, -12.3896F, 2.5995F, 10, 2, 1, 0.0F, false));
        this.bone12 = new MModelRenderer(this);
        this.setRotation(this.bone12, 0.0F, 0.0F, 0.3142F);
        this.bone10.addChild(this.bone12);
        this.bone12.cubeList.add(new ModelBox(this.bone12, 18, 0, 3.6657F, -12.4804F, 2.5995F, 10, 2, 1, -0.001F, false));
        this.setTexture(new ResourceLocation("minidot", "pets/persona_cupid.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.05F;
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.translate(1.1F, -0.1F + f, 0.3F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.25F, -0.05F);
        GlStateManager.scale(0.7F, 0.8F, 0.8F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041a\u0443\u043f\u0438\u0434\u043e\u043d";
    }

    public String getCreator()
    {
        return "Wenston";
    }

    public List<String> getDescription()
    {
        return Collections.<String>singletonList(EnumChatFormatting.LIGHT_PURPLE + "\u0414\u0435\u043d\u044c \u0441\u0432\u044f\u0442\u043e\u0433\u043e \u0412\u0430\u043b\u0435\u043d\u0442\u0438\u043d\u0430 2020");
    }
}
