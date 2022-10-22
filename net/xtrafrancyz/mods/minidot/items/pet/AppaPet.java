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

public class AppaPet extends BasePet
{
    private final MModelRenderer allappa;
    private final MModelRenderer legall;
    private final MModelRenderer leg7;
    private final MModelRenderer bone12;
    private final MModelRenderer leg4;
    private final MModelRenderer bone9;
    private final MModelRenderer leg6;
    private final MModelRenderer bone11;
    private final MModelRenderer leg3;
    private final MModelRenderer bone8;
    private final MModelRenderer leg5;
    private final MModelRenderer bone10;
    private final MModelRenderer leg2;
    private final MModelRenderer bone14;
    private final MModelRenderer bone13;
    private final MModelRenderer bone7;
    private final MModelRenderer tail;
    private final MModelRenderer tail2;
    private final MModelRenderer saddle;
    private final MModelRenderer saddle2;
    private final MModelRenderer saddle3;
    private final MModelRenderer allears;
    private final MModelRenderer ears2;
    private final MModelRenderer ears;
    private final MModelRenderer bone15;
    private final MModelRenderer hat2;
    private final MModelRenderer hat;
    private final MModelRenderer bone21;
    private final MModelRenderer cheeks4;
    private final MModelRenderer cheeks3;
    private final MModelRenderer cheeks;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final MModelRenderer bone6;
    private final MModelRenderer horns2;
    private final MModelRenderer bone3;
    private final MModelRenderer bone2;
    private final MModelRenderer bone;
    private final MModelRenderer horns;
    private final IAnimation animation;

    public AppaPet()
    {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.allappa = new MModelRenderer(this);
        this.allappa.cubeList.add(new ModelBox(this.allappa, 34, 40, -5.0F, -13.5F, 6.0F, 13, 3, 3, 0.0F, false));
        this.allappa.cubeList.add(new ModelBox(this.allappa, 0, 0, -4.0F, -11.25F, -8.0F, 11, 7, 19, 0.0F, false));
        this.legall = new MModelRenderer(this);
        this.allappa.addChild(this.legall);
        this.leg7 = new MModelRenderer(this);
        this.leg7.setRotationPoint(5.0F, -7.2F, 9.5F);
        this.setRotation(this.leg7, 0.1745F, 0.0F, 0.0F);
        this.legall.addChild(this.leg7);
        this.leg7.cubeList.add(new ModelBox(this.leg7, 28, 55, -2.0F, -0.4297F, -2.2673F, 4, 5, 4, 0.0F, false));
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(0.0F, 4.3418F, -0.1362F);
        this.setRotation(this.bone12, 0.1745F, 0.0F, 0.0F);
        this.leg7.addChild(this.bone12);
        this.bone12.cubeList.add(new ModelBox(this.bone12, 56, 62, -2.0F, -0.1814F, -2.1259F, 4, 3, 4, 0.0F, false));
        this.leg4 = new MModelRenderer(this);
        this.leg4.setRotationPoint(-2.0F, -7.2F, 9.5F);
        this.setRotation(this.leg4, 0.1745F, 0.0F, 0.0F);
        this.legall.addChild(this.leg4);
        this.leg4.cubeList.add(new ModelBox(this.leg4, 28, 55, -2.0F, -0.4297F, -2.2673F, 4, 5, 4, 0.0F, false));
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(0.0F, 4.3418F, -0.1362F);
        this.setRotation(this.bone9, 0.1745F, 0.0F, 0.0F);
        this.leg4.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 56, 62, -2.0F, -0.1814F, -2.1259F, 4, 3, 4, 0.0F, false));
        this.leg6 = new MModelRenderer(this);
        this.leg6.setRotationPoint(-2.0F, -7.2F, 2.5F);
        this.setRotation(this.leg6, 0.1745F, 0.0F, 0.0F);
        this.legall.addChild(this.leg6);
        this.leg6.cubeList.add(new ModelBox(this.leg6, 28, 55, -2.0F, -0.4297F, -2.2673F, 4, 5, 4, 0.0F, false));
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(0.0F, 4.3418F, -0.1362F);
        this.setRotation(this.bone11, 0.1745F, 0.0F, 0.0F);
        this.leg6.addChild(this.bone11);
        this.bone11.cubeList.add(new ModelBox(this.bone11, 56, 62, -2.0F, -0.1814F, -2.1259F, 4, 3, 4, 0.0F, false));
        this.leg3 = new MModelRenderer(this);
        this.leg3.setRotationPoint(5.0F, -7.2F, 2.5F);
        this.setRotation(this.leg3, 0.1745F, 0.0F, 0.0F);
        this.legall.addChild(this.leg3);
        this.leg3.cubeList.add(new ModelBox(this.leg3, 28, 55, -2.0F, -0.4297F, -2.2673F, 4, 5, 4, 0.0F, false));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(0.0F, 4.3418F, -0.1362F);
        this.setRotation(this.bone8, 0.1745F, 0.0F, 0.0F);
        this.leg3.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 56, 62, -2.0F, -0.1814F, -2.1259F, 4, 3, 4, 0.0F, false));
        this.leg5 = new MModelRenderer(this);
        this.leg5.setRotationPoint(-2.0F, -7.2F, -4.5F);
        this.setRotation(this.leg5, 0.1745F, 0.0F, 0.0F);
        this.legall.addChild(this.leg5);
        this.leg5.cubeList.add(new ModelBox(this.leg5, 28, 55, -2.0F, -0.4297F, -2.2673F, 4, 5, 4, 0.0F, false));
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(0.0F, 4.3418F, -0.1362F);
        this.setRotation(this.bone10, 0.1745F, 0.0F, 0.0F);
        this.leg5.addChild(this.bone10);
        this.bone10.cubeList.add(new ModelBox(this.bone10, 56, 62, -2.0F, -0.1814F, -2.1259F, 4, 3, 4, 0.0F, false));
        this.leg2 = new MModelRenderer(this);
        this.leg2.setRotationPoint(5.0F, -7.2F, -4.5F);
        this.setRotation(this.leg2, 0.1745F, 0.0F, 0.0F);
        this.legall.addChild(this.leg2);
        this.leg2.cubeList.add(new ModelBox(this.leg2, 28, 55, -2.0F, -0.4297F, -2.2673F, 4, 5, 4, 0.0F, false));
        this.bone14 = new MModelRenderer(this);
        this.bone14.setRotationPoint(0.0F, 4.3418F, -0.1362F);
        this.setRotation(this.bone14, 0.1745F, 0.0F, 0.0F);
        this.leg2.addChild(this.bone14);
        this.bone14.cubeList.add(new ModelBox(this.bone14, 56, 62, -2.0F, -0.1814F, -2.1259F, 4, 3, 4, 0.0F, false));
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(1.5F, -7.0F, -13.1F);
        this.allappa.addChild(this.bone13);
        this.bone13.cubeList.add(new ModelBox(this.bone13, 0, 68, -4.5F, -1.0F, 0.0F, 9, 5, 0, 0.0F, false));
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(1.0F, -6.0F, 10.0F);
        this.allappa.addChild(this.bone7);
        this.tail = new MModelRenderer(this);
        this.tail.setRotationPoint(0.5F, -3.0F, 0.0F);
        this.setRotation(this.tail, -0.4363F, 0.0F, 0.0F);
        this.bone7.addChild(this.tail);
        this.tail.cubeList.add(new ModelBox(this.tail, 36, 28, -3.5F, -1.3644F, -0.4205F, 7, 4, 8, 0.0F, false));
        this.tail2 = new MModelRenderer(this);
        this.tail2.setRotationPoint(-0.1F, 0.1761F, 7.4055F);
        this.setRotation(this.tail2, 0.3491F, 0.0F, 0.0F);
        this.tail.addChild(this.tail2);
        this.tail2.cubeList.add(new ModelBox(this.tail2, 28, 46, -2.25F, -0.5557F, -1.2464F, 5, 2, 6, 0.4F, false));
        this.saddle = new MModelRenderer(this);
        this.allappa.addChild(this.saddle);
        this.saddle.cubeList.add(new ModelBox(this.saddle, 0, 26, -5.0F, -12.0F, -3.0F, 13, 1, 9, 0.0F, false));
        this.saddle2 = new MModelRenderer(this);
        this.saddle2.setRotationPoint(0.0F, 0.0F, -10.0F);
        this.allappa.addChild(this.saddle2);
        this.saddle2.cubeList.add(new ModelBox(this.saddle2, 41, 0, -5.0F, -14.0F, 4.0F, 13, 3, 3, 0.0F, false));
        this.saddle3 = new MModelRenderer(this);
        this.saddle3.setRotationPoint(1.5F, -12.0F, 7.5F);
        this.setRotation(this.saddle3, -0.3054F, 0.0F, 0.0F);
        this.allappa.addChild(this.saddle3);
        this.allears = new MModelRenderer(this);
        this.allears.setRotationPoint(8.0F, -7.25F, -11.0F);
        this.allappa.addChild(this.allears);
        this.ears2 = new MModelRenderer(this);
        this.ears2.setRotationPoint(-1.113F, -0.0383F, 0.0F);
        this.setRotation(this.ears2, 0.0F, 0.0F, -0.48F);
        this.allears.addChild(this.ears2);
        this.ears2.cubeList.add(new ModelBox(this.ears2, 12, 0, -0.5F, -1.0F, -1.0F, 1, 2, 2, 0.0F, false));
        this.ears = new MModelRenderer(this);
        this.ears.setRotationPoint(-12.0F, 0.0F, 0.0F);
        this.setRotation(this.ears, 0.0F, 0.0F, 0.48F);
        this.allears.addChild(this.ears);
        this.ears.cubeList.add(new ModelBox(this.ears, 12, 9, -0.5F, -1.0383F, -1.0F, 1, 2, 2, 0.0F, false));
        this.bone15 = new MModelRenderer(this);
        this.bone15.setRotationPoint(1.0F, -6.0F, -11.0F);
        this.hat2 = new MModelRenderer(this);
        this.hat2.setRotationPoint(-1.0F, 6.0F, 11.0F);
        this.bone15.addChild(this.hat2);
        this.hat2.cubeList.add(new ModelBox(this.hat2, 0, 36, -4.0F, -13.0F, -14.0F, 11, 5, 6, 0.0F, false));
        this.hat = new MModelRenderer(this);
        this.hat.setRotationPoint(-1.0F, 6.0F, 11.0F);
        this.bone15.addChild(this.hat);
        this.hat.cubeList.add(new ModelBox(this.hat, 41, 6, -3.0F, -8.0F, -13.0F, 9, 5, 5, 0.0F, false));
        this.bone21 = new MModelRenderer(this);
        this.bone21.setRotationPoint(-1.0F, 6.0F, 11.0F);
        this.bone15.addChild(this.bone21);
        this.bone21.cubeList.add(new ModelBox(this.bone21, 56, 53, 5.5F, -6.0F, -14.0F, 1, 3, 6, 0.0F, false));
        this.cheeks4 = new MModelRenderer(this);
        this.cheeks4.setRotationPoint(0.0F, -0.75F, 0.0F);
        this.bone21.addChild(this.cheeks4);
        this.cheeks4.cubeList.add(new ModelBox(this.cheeks4, 8, 57, 0.0F, -6.0F, -14.75F, 3, 2, 2, 0.0F, false));
        this.cheeks3 = new MModelRenderer(this);
        this.cheeks3.setRotationPoint(-6.0F, 0.0F, 0.0F);
        this.bone21.addChild(this.cheeks3);
        this.cheeks3.cubeList.add(new ModelBox(this.cheeks3, 0, 56, 2.5F, -6.0F, -14.0F, 1, 3, 6, 0.0F, false));
        this.cheeks = new MModelRenderer(this);
        this.bone21.addChild(this.cheeks);
        this.cheeks.cubeList.add(new ModelBox(this.cheeks, 44, 46, -3.0F, -6.0F, -14.0F, 9, 3, 1, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(3.0F, 6.0F, 11.0F);
        this.bone15.addChild(this.bone4);
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(-12.75F, -13.0F, -11.0F);
        this.setRotation(this.bone5, 0.0F, 0.0F, 1.4835F);
        this.bone4.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 60, 16, -1.2423F, -3.5F, -1.2F, 5, 2, 2, -0.4F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(-9.0F, -10.25F, -11.0F);
        this.setRotation(this.bone6, 0.0F, 0.0F, 0.2182F);
        this.bone4.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 30, 64, -1.5F, -0.9F, -1.0F, 3, 2, 2, -0.1F, false));
        this.horns2 = new MModelRenderer(this);
        this.bone4.addChild(this.horns2);
        this.horns2.cubeList.add(new ModelBox(this.horns2, 0, 26, -8.5F, -11.0F, -12.0F, 1, 2, 2, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(-1.0F, 6.0F, 11.0F);
        this.bone15.addChild(this.bone3);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(12.75F, -13.0F, -11.0F);
        this.setRotation(this.bone2, 0.0F, 0.0F, -1.4835F);
        this.bone3.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 64, 6, -3.8448F, -4.4962F, -1.2F, 5, 2, 2, -0.4F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(9.0F, -10.25F, -11.0F);
        this.setRotation(this.bone, 0.0F, 0.0F, -0.2182F);
        this.bone3.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 64, 38, -2.4763F, -1.1164F, -1.0F, 3, 2, 2, -0.1F, false));
        this.horns = new MModelRenderer(this);
        this.bone3.addChild(this.horns);
        this.horns.cubeList.add(new ModelBox(this.horns, 0, 30, 6.5F, -11.0F, -12.0F, 1, 2, 2, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/appapet.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/appapet_animation.json"));
        this.animation = bbanimationloader.mustGet("animation.model.new", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        float f = MathHelper.sin(time * 0.1F) * 0.09F;
        double d0 = 0.6D;
        GlStateManager.scale(d0, d0, d0);
        GlStateManager.translate(1.5D, -0.9D + (double)f, 0.6D);
        this.animation.tick(time);
    }

    public void renderAsItem(float time)
    {
        double d0 = 0.75D;
        GlStateManager.scale(d0, d0, d0);
        GlStateManager.translate(0.0D, 0.2D, -0.1D);
        this.animation.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0410\u043f\u043f\u0430";
    }

    public String getCreator()
    {
        return "_Mc_CMETAHKA";
    }

    public List<String> getDescription()
    {
        return MNaming.fromMult("\u0410\u0432\u0430\u0442\u0430\u0440: \u041b\u0435\u0433\u0435\u043d\u0434\u0430 \u043e\u0431 \u0410\u0430\u043d\u0433\u0435");
    }
}
