package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class SheepPig extends BasePet
{
    private final MModelRenderer Sheep;
    private final MModelRenderer RBLeg;
    private final MModelRenderer LBLeg;
    private final MModelRenderer RFLeg;
    private final MModelRenderer LFLeg;
    private final MModelRenderer Head;
    private final MModelRenderer Nose;
    private final IAnimation animation;

    public SheepPig()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Sheep = new MModelRenderer(this);
        this.Sheep.cubeList.add(new ModelBox(this.Sheep, 16, 10, -4.0F, -14.0F, -8.0F, 8, 6, 16, 1.75F, true));
        this.RBLeg = new MModelRenderer(this);
        this.RBLeg.setRotationPoint(-3.0F, -7.0F, 7.0F);
        this.Sheep.addChild(this.RBLeg);
        this.RBLeg.cubeList.add(new ModelBox(this.RBLeg, 32, 13, -2.0F, -1.0F, -2.0F, 4, 6, 4, 0.5F, true));
        this.RBLeg.cubeList.add(new ModelBox(this.RBLeg, 0, 22, -2.0F, 1.0F, -2.0F, 4, 6, 4, 0.0F, true));
        this.LBLeg = new MModelRenderer(this);
        this.LBLeg.setRotationPoint(3.0F, -7.0F, 7.0F);
        this.Sheep.addChild(this.LBLeg);
        this.LBLeg.cubeList.add(new ModelBox(this.LBLeg, 32, 13, -2.0F, -1.0F, -2.0F, 4, 6, 4, 0.5F, true));
        this.LBLeg.cubeList.add(new ModelBox(this.LBLeg, 0, 22, -2.0F, 1.0F, -2.0F, 4, 6, 4, 0.0F, false));
        this.RFLeg = new MModelRenderer(this);
        this.RFLeg.setRotationPoint(-3.0F, -7.0F, -5.0F);
        this.Sheep.addChild(this.RFLeg);
        this.RFLeg.cubeList.add(new ModelBox(this.RFLeg, 32, 13, -2.0F, -1.0F, -2.0F, 4, 6, 4, 0.5F, true));
        this.RFLeg.cubeList.add(new ModelBox(this.RFLeg, 0, 22, -2.0F, 1.0F, -2.0F, 4, 6, 4, 0.0F, true));
        this.LFLeg = new MModelRenderer(this);
        this.LFLeg.setRotationPoint(3.0F, -7.0F, -5.0F);
        this.Sheep.addChild(this.LFLeg);
        this.LFLeg.cubeList.add(new ModelBox(this.LFLeg, 32, 13, -2.0F, -1.0F, -2.0F, 4, 6, 4, 0.5F, true));
        this.LFLeg.cubeList.add(new ModelBox(this.LFLeg, 0, 22, -2.0F, 1.0F, -2.0F, 4, 6, 4, 0.0F, false));
        this.Head = new MModelRenderer(this);
        this.Head.setRotationPoint(0.0F, -14.0F, -8.0F);
        this.Sheep.addChild(this.Head);
        this.Head.cubeList.add(new ModelBox(this.Head, 0, 0, -4.0F, -5.0F, -7.0F, 8, 8, 8, -1.0F, true));
        this.Head.cubeList.add(new ModelBox(this.Head, 30, 20, -3.0F, -4.0F, -4.0F, 6, 6, 6, 0.6F, true));
        this.Nose = new MModelRenderer(this);
        this.Nose.setRotationPoint(0.0F, 14.0F, 8.0F);
        this.Head.addChild(this.Nose);
        this.Nose.cubeList.add(new ModelBox(this.Nose, 18, 18, -2.0F, -14.8F, -15.0F, 4, 3, 2, -0.5F, false));
        this.RBLeg.setDynamic(true);
        this.LBLeg.setDynamic(true);
        this.RFLeg.setDynamic(true);
        this.LFLeg.setDynamic(true);
        this.Head.setDynamic(true);
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/sheeppig_animation.json"));
        this.animation = bbanimationloader.mustGet("SheepPig", this);
        this.setTexture(new ResourceLocation("minidot", "pets/sheeppig.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        GlStateManager.translate(0.7F, -0.2F + f, 0.3F);
        GlStateManager.scale(0.9F, 0.9F, 0.9F);
        this.Head.rotationY = modelPlayer.bipedHead.rotateAngleY % ((float)Math.PI * 2F) / 2.5F;
        this.Head.rotationX = modelPlayer.bipedHead.rotateAngleX / 2.0F;
        this.Head.rotationZ = modelPlayer.bipedHead.rotateAngleZ;
        this.LFLeg.rotationX = modelPlayer.bipedLeftLeg.rotateAngleX / 4.0F;
        this.RFLeg.rotationX = modelPlayer.bipedRightLeg.rotateAngleX / 4.0F;
        this.LBLeg.rotationX = this.RFLeg.rotationX;
        this.RBLeg.rotationX = this.LFLeg.rotationX;

        if (modelPlayer.isSneak)
        {
            this.animation.tickDelayed(time, 0.05F);
        }

        this.animation.tickDelayed(time, 10.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.25F, 0.0F);
        GlStateManager.scale(0.7F, 0.7F, 0.7F);
        this.Head.rotationX = 0.0F;
        this.Head.rotationY = 0.0F;
        this.Head.rotationZ = 0.0F;
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0427\u0438\u043a\u0438" + EnumChatFormatting.LIGHT_PURPLE + EnumChatFormatting.BOLD + "\u0421\u0432\u0438\u043d\u043e\u043d\u0438";
    }
}
