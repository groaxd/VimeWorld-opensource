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

public class PersonaTank extends BasePet
{
    private final MModelRenderer torso;
    private final MModelRenderer eye_left;
    private final MModelRenderer eye_right;
    private final MModelRenderer ear_right1;
    private final MModelRenderer ear_right2;
    private final MModelRenderer ear_left1;
    private final MModelRenderer ear_left2;
    private final MModelRenderer leg1;
    private final MModelRenderer leg2;
    private final MModelRenderer leg3;
    private final MModelRenderer arm_left;
    private final MModelRenderer arm_right;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;

    public PersonaTank()
    {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.useDisplayLists = true;
        this.torso = new MModelRenderer(this);
        this.torso.setRotationPoint(-0.25F, 0.0F, 0.0F);
        this.torso.cubeList.add(new ModelBox(this.torso, 56, 26, -3.0F, -18.75F, -2.2F, 6, 6, 5, 0.0F, false));
        this.torso.cubeList.add(new ModelBox(this.torso, 56, 0, -3.45F, -19.15F, -1.7F, 7, 7, 4, 0.0F, false));
        this.eye_left = new MModelRenderer(this);
        this.eye_left.setRotationPoint(-0.25F, 0.0F, 0.0F);
        this.eye_left.cubeList.add(new ModelBox(this.eye_left, 0, 17, 1.05F, -18.8F, -2.3F, 2, 2, 1, 0.0F, false));
        this.eye_right = new MModelRenderer(this);
        this.eye_right.setRotationPoint(-0.25F, 0.0F, 0.0F);
        this.eye_right.cubeList.add(new ModelBox(this.eye_right, 0, 17, -3.05F, -18.8F, -2.3F, 2, 2, 1, 0.0F, false));
        this.ear_right1 = new MModelRenderer(this);
        this.ear_right1.setRotationPoint(0.3056F, -0.2311F, 2.0F);
        this.setRotation(this.ear_right1, 0.0F, 0.0F, -0.2269F);
        this.ear_right1.cubeList.add(new ModelBox(this.ear_right1, 0, 4, 1.4391F, -21.51F, -2.7F, 1, 3, 2, 0.0F, false));
        this.ear_right2 = new MModelRenderer(this);
        this.ear_right2.setRotationPoint(-1.3472F, 0.2333F, 0.0F);
        this.setRotation(this.ear_right2, 0.0F, 0.0F, -0.0698F);
        this.ear_right2.cubeList.add(new ModelBox(this.ear_right2, 0, 4, 0.7254F, -21.9747F, -0.7F, 1, 3, 2, 0.0F, false));
        this.ear_left1 = new MModelRenderer(this);
        this.ear_left1.setRotationPoint(2.3979F, -0.9701F, 2.0F);
        this.setRotation(this.ear_left1, 0.0F, 0.0F, -0.1222F);
        this.ear_left1.cubeList.add(new ModelBox(this.ear_left1, 6, 6, 0.855F, -20.2931F, -2.7F, 1, 3, 2, 0.0F, false));
        this.ear_left2 = new MModelRenderer(this);
        this.ear_left2.setRotationPoint(1.694F, 0.2453F, 0.0F);
        this.setRotation(this.ear_left2, 0.0F, 0.0F, 0.1571F);
        this.ear_left2.cubeList.add(new ModelBox(this.ear_left2, 6, 6, -3.3053F, -21.3288F, -0.7F, 1, 3, 2, 0.0F, false));
        this.leg1 = new MModelRenderer(this);
        this.leg1.setRotationPoint(0.0603F, -1.0037F, 0.0F);
        this.leg2 = new MModelRenderer(this);
        this.leg2.setRotationPoint(1.6392F, -1.2155F, 0.0F);
        this.setRotation(this.leg2, 0.0F, 0.0F, 0.1745F);
        this.leg3 = new MModelRenderer(this);
        this.leg3.setRotationPoint(0.25F, 0.0F, 0.0F);
        this.setRotation(this.leg3, 0.0F, 0.0F, -0.1745F);
        this.arm_left = new MModelRenderer(this);
        this.setRotation(this.arm_left, 0.0F, 1.6581F, 0.0F);
        this.arm_left.cubeList.add(new ModelBox(this.arm_left, 0, 0, -0.5724F, -15.325F, 3.3603F, 4, 1, 1, 0.175F, false));
        this.arm_right = new MModelRenderer(this);
        this.setRotation(this.arm_right, 0.0F, -1.6581F, 0.0F);
        this.arm_right.cubeList.add(new ModelBox(this.arm_right, 0, 0, -3.5648F, -15.325F, 3.7141F, 4, 1, 1, 0.175F, false));
        this.bone = new MModelRenderer(this);
        this.bone.cubeList.add(new ModelBox(this.bone, 88, 42, -6.0F, -14.0F, -4.0F, 12, 6, 8, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 82, 5, -2.0F, -13.0F, -21.0F, 4, 4, 17, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 0, -9.0F, -8.0F, -10.0F, 18, 6, 20, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 14, 8, 2.0F, -5.0F, -11.0F, 2, 2, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 14, 8, -4.0F, -5.0F, -11.0F, 2, 2, 1, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 26, -9.0F, -2.0F, -10.0F, 4, 4, 20, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 28, 30, 5.0F, -2.0F, -10.0F, 4, 4, 20, 0.0F, false));
        this.setTexture(new ResourceLocation("minidot", "pets/persona_tank.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.05F;
        GlStateManager.scale(0.6F, 0.6F, 0.6F);
        GlStateManager.translate(1.25F, -0.4F + f, 0.3F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.18F, 0.05F);
        GlStateManager.scale(0.6F, 0.6F, 0.6F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0422\u0430\u043d\u043a\u0438\u0441\u0442";
    }

    public String getCreator()
    {
        return "Wenston";
    }

    public List<String> getDescription()
    {
        return Collections.<String>singletonList(EnumChatFormatting.LIGHT_PURPLE + "9 \u041c\u0430\u044f");
    }
}
