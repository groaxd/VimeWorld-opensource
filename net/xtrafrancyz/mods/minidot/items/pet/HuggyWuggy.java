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
import org.lwjgl.opengl.GL11;

public class HuggyWuggy extends BasePet
{
    private final MModelRenderer Poppy;
    private final MModelRenderer Body;
    private final MModelRenderer Torse;
    private final MModelRenderer Butterfly;
    private final MModelRenderer bone16;
    private final MModelRenderer bone17;
    private final MModelRenderer LeftLeg;
    private final MModelRenderer RightLeg;
    private final MModelRenderer RightArm;
    private final MModelRenderer LeftArm;
    private final MModelRenderer Head;
    private final MModelRenderer Eyes;
    private final MModelRenderer Teeth;
    private final MModelRenderer bone11;
    private final MModelRenderer bone12;
    private final MModelRenderer Roth;
    private final MModelRenderer bone5;
    private final MModelRenderer bone7;
    private final MModelRenderer bone6;
    private final MModelRenderer bone8;
    private final MModelRenderer bone9;
    private final MModelRenderer bone4;
    private final MModelRenderer Base;
    private final MModelRenderer bone;
    private final MModelRenderer bone3;
    private final MModelRenderer bone2;
    private final IAnimation animation;
    private final String type;

    public HuggyWuggy(String type)
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.type = type;
        this.Poppy = new MModelRenderer(this);
        this.Poppy.setRotationPoint(0.0F, -30.0F, 0.0F);
        this.Body = new MModelRenderer(this);
        this.Poppy.addChild(this.Body);
        this.Torse = new MModelRenderer(this);
        this.Torse.setRotationPoint(0.0F, -13.0F, 0.0F);
        this.Body.addChild(this.Torse);
        this.Torse.cubeList.add(new ModelBox(this.Torse, 0, 36, -4.5F, 0.0F, -2.0F, 8, 14, 4, 0.0F, false));
        this.Butterfly = new MModelRenderer(this);
        this.Butterfly.setRotationPoint(-3.0F, -2.0F, 0.0F);
        this.Torse.addChild(this.Butterfly);
        this.bone16 = new MModelRenderer(this);
        this.setRotation(this.bone16, 0.0F, 0.0F, -0.7854F);
        this.Butterfly.addChild(this.bone16);
        this.bone16.cubeList.add(new ModelBox(this.bone16, 44, 18, -4.5F, 2.0F, -2.25F, 5, 3, 0, 0.0F, false));
        this.bone17 = new MModelRenderer(this);
        this.bone17.setRotationPoint(5.0F, 0.0F, 0.0F);
        this.setRotation(this.bone17, 0.0F, 0.0F, 0.7854F);
        this.Butterfly.addChild(this.bone17);
        this.bone17.cubeList.add(new ModelBox(this.bone17, 44, 18, -0.5F, 2.0F, -2.25F, 5, 3, 0, 0.0F, true));
        this.LeftLeg = new MModelRenderer(this);
        this.LeftLeg.setRotationPoint(2.0F, 1.0F, 0.0F);
        this.Body.addChild(this.LeftLeg);
        this.LeftLeg.cubeList.add(new ModelBox(this.LeftLeg, 24, 36, -1.5F, 0.0F, -1.5F, 3, 25, 3, 0.0F, false));
        this.LeftLeg.cubeList.add(new ModelBox(this.LeftLeg, 44, 0, -1.5F, 25.0F, -4.5F, 3, 2, 6, 0.0F, false));
        this.RightLeg = new MModelRenderer(this);
        this.RightLeg.setRotationPoint(-3.0F, 1.0F, 0.0F);
        this.Body.addChild(this.RightLeg);
        this.RightLeg.cubeList.add(new ModelBox(this.RightLeg, 24, 36, -1.5F, 0.0F, -1.5F, 3, 25, 3, 0.0F, false));
        this.RightLeg.cubeList.add(new ModelBox(this.RightLeg, 44, 0, -1.5F, 25.0F, -4.5F, 3, 2, 6, 0.0F, false));
        this.RightArm = new MModelRenderer(this);
        this.RightArm.setRotationPoint(-5.0F, -11.0F, 0.0F);
        this.Body.addChild(this.RightArm);
        this.RightArm.cubeList.add(new ModelBox(this.RightArm, 20, 18, -2.0F, 19.0F, -1.5F, 2, 4, 3, 0.0F, false));
        this.RightArm.cubeList.add(new ModelBox(this.RightArm, 48, 36, -2.5F, -2.0F, -1.5F, 3, 21, 3, 0.0F, false));
        this.LeftArm = new MModelRenderer(this);
        this.LeftArm.setRotationPoint(4.0F, -11.0F, 0.0F);
        this.Body.addChild(this.LeftArm);
        this.LeftArm.cubeList.add(new ModelBox(this.LeftArm, 36, 36, -0.5F, -2.0F, -1.5F, 3, 21, 3, 0.0F, false));
        this.LeftArm.cubeList.add(new ModelBox(this.LeftArm, 20, 18, 0.0F, 19.0F, -1.5F, 2, 4, 3, 0.0F, false));
        this.Head = new MModelRenderer(this);
        this.Head.setRotationPoint(0.0F, -13.0F, 0.0F);
        this.Poppy.addChild(this.Head);
        this.Eyes = new MModelRenderer(this);
        this.Eyes.setRotationPoint(0.0F, 13.0F, 0.0F);
        this.Head.addChild(this.Eyes);
        this.Eyes.cubeList.add(new ModelBox(this.Eyes, 0, 18, 1.25F, -20.75F, -4.225F, 3, 3, 0, 0.0F, false));
        this.Eyes.cubeList.add(new ModelBox(this.Eyes, 0, 21, -5.25F, -20.75F, -4.225F, 3, 3, 0, 0.0F, false));
        this.Teeth = new MModelRenderer(this);
        this.Teeth.setRotationPoint(0.0F, 13.0F, 0.0F);
        this.Head.addChild(this.Teeth);
        this.Teeth.cubeList.add(new ModelBox(this.Teeth, 20, 2, -4.0F, -17.0F, -4.75F, 7, 1, 0, 0.0F, false));
        this.Teeth.cubeList.add(new ModelBox(this.Teeth, 20, 3, -4.0F, -15.0F, -4.75F, 7, 1, 0, 0.0F, false));
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(-1.0F, 0.0F, -0.75F);
        this.setRotation(this.bone11, 0.0F, 0.0F, -1.0036F);
        this.Teeth.addChild(this.bone11);
        this.bone11.cubeList.add(new ModelBox(this.bone11, 0, 7, 12.576F, -5.4547F, -4.0F, 4, 1, 0, 0.0F, false));
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(0.0F, 0.0F, -0.75F);
        this.setRotation(this.bone12, 0.0F, 0.0F, 1.0036F);
        this.Teeth.addChild(this.bone12);
        this.bone12.cubeList.add(new ModelBox(this.bone12, 0, 6, -16.576F, -5.4547F, -4.0F, 4, 1, 0, 0.0F, false));
        this.Roth = new MModelRenderer(this);
        this.Roth.setRotationPoint(0.0F, 13.0F, 0.0F);
        this.Head.addChild(this.Roth);
        this.Roth.cubeList.add(new ModelBox(this.Roth, 0, 4, -2.0F, -17.87F, -4.9F, 3, 1, 1, 0.1F, false));
        this.Roth.cubeList.add(new ModelBox(this.Roth, 20, 0, -4.0F, -14.0F, -5.0F, 7, 1, 1, 0.002F, false));
        this.bone5 = new MModelRenderer(this);
        this.setRotation(this.bone5, 0.0F, 0.0F, -1.0036F);
        this.Roth.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 20, 4, 12.576F, -5.4547F, -5.0F, 5, 1, 1, 0.001F, false));
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(1.0F, -16.0F, 0.0F);
        this.setRotation(this.bone7, 0.0F, 0.0F, -0.2618F);
        this.Roth.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 0, 0, 1.1662F, -0.6998F, -5.0F, 3, 1, 1, 0.0F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(-5.0F, -16.0F, 0.0F);
        this.setRotation(this.bone6, 0.0F, 0.0F, 0.2618F);
        this.Roth.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 0, 2, -1.2684F, -1.4763F, -5.0F, 3, 1, 1, 0.0F, false));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(-5.0F, -16.0F, 0.0F);
        this.setRotation(this.bone8, 0.0F, 0.0F, 2.5307F);
        this.Roth.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 27, 18, -3.4779F, -1.0203F, -5.0F, 2, 1, 1, 0.0F, false));
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(4.0F, -16.0F, 0.0F);
        this.setRotation(this.bone9, 0.0F, 0.0F, -2.5307F);
        this.Roth.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 0, 24, 1.4779F, -1.0203F, -5.0F, 2, 1, 1, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.setRotation(this.bone4, 0.0F, 0.0F, 1.0036F);
        this.Roth.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 20, 6, -18.1133F, -4.6113F, -5.0F, 5, 1, 1, 0.001F, false));
        this.Base = new MModelRenderer(this);
        this.Base.setRotationPoint(0.0F, 13.0F, 0.0F);
        this.Head.addChild(this.Base);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, -13.0F, 0.0F);
        this.Base.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 28, 18, -4.2897F, -9.7331F, -4.0F, 4, 10, 8, 0.2F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 28, 0, -0.7103F, -9.7331F, -4.0F, 4, 10, 8, 0.201F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.setRotation(this.bone3, 0.0F, 0.0F, 0.6109F);
        this.Base.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 0, -9.9565F, -21.649F, -4.0F, 6, 10, 8, 0.21F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-1.0F, -1.0F, 0.0F);
        this.setRotation(this.bone2, 0.0F, 0.0F, -0.6109F);
        this.Base.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 18, 3.9565F, -21.649F, -4.0F, 6, 10, 8, 0.21F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/" + type + ".png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/huggywuggy_animation.json"));
        this.animation = bbanimationloader.mustGet("huggywuggy.animation", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.3D, 0.7685D, -0.25D);
        double d0 = 0.387D;
        GlStateManager.scale(d0, d0, d0);
        this.animation.tick(time);
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        float f1 = MathHelper.sin(time * 0.26F) * 0.05F;
        float f2 = MathHelper.cos(time * 0.16F);
        GL11.glTranslatef(0.6F, -0.5F + f, 0.3F);
        GL11.glRotatef(f2 * 4.0F, 0.0F, 0.6F, 0.0F);
        this.RightLeg.rotationX = modelPlayer.bipedRightLeg.rotateAngleX / 2.0F + f1;
        this.RightLeg.rotationY = f * 2.0F;
        this.LeftLeg.rotationX = modelPlayer.bipedLeftLeg.rotateAngleX / 2.0F - f1;
        this.LeftLeg.rotationZ = f * 2.0F;
        this.LeftArm.rotationX = modelPlayer.bipedLeftArm.rotateAngleX / 1.2F + f2 * 0.1F;
        this.LeftArm.rotationY = -f2 * f * 2.0F;
        this.LeftArm.rotationZ = f2 * f * 4.0F;
        this.RightArm.rotationX = -this.LeftArm.rotationX;
        this.RightArm.rotationY = -this.LeftArm.rotationY;
        this.RightArm.rotationZ = this.LeftArm.rotationZ;
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0D, 0.44000000000000006D, 0.0D);
        double d0 = 0.45D;
        GlStateManager.scale(d0, d0, d0);
        this.animation.tick(time);
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
        return this.type.equals("huggywuggy") ? "\u0425\u0430\u0433\u0433\u0438 \u0412\u0430\u0433\u0433\u0438" : "\u041a\u0438\u0441\u0441\u0438 \u041c\u0438\u0441\u0441\u0438";
    }

    public List<String> getDescription()
    {
        return MNaming.fromGame("Poppy Playtime");
    }

    public String getCreator()
    {
        return "Rander_";
    }
}
