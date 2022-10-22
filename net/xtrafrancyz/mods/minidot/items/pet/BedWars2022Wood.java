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
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class BedWars2022Wood extends BasePet
{
    private final MModelRenderer root;
    private final MModelRenderer Bed;
    private final MModelRenderer Begin;
    private final MModelRenderer bone;
    private final MModelRenderer Pillow;
    private final MModelRenderer End;
    private final MModelRenderer bone2;
    private final MModelRenderer Persona;
    private final MModelRenderer Emotion1;
    private final MModelRenderer Emotion2;
    private final MModelRenderer Emotion3;
    private final MModelRenderer LeftEar;
    private final MModelRenderer RightEar;
    private final MModelRenderer LeftHand;
    private final MModelRenderer RightHand;
    private final MModelRenderer LeftLeg;
    private final MModelRenderer RightLeg;
    private final MModelRenderer Pedestal;
    private final IAnimation animation;

    public BedWars2022Wood()
    {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.root = new MModelRenderer(this);
        this.Bed = new MModelRenderer(this);
        this.Bed.setRotationPoint(1.0F, -9.0F, 0.0F);
        this.root.addChild(this.Bed);
        this.Begin = new MModelRenderer(this);
        this.Begin.setRotationPoint(-8.0F, 0.0F, 0.0F);
        this.Bed.addChild(this.Begin);
        this.Begin.cubeList.add(new ModelBox(this.Begin, 24, 42, -2.0F, -7.0F, -5.0F, 2, 6, 10, 0.0F, false));
        this.Begin.cubeList.add(new ModelBox(this.Begin, 30, 29, -2.0F, -1.0F, -5.0F, 2, 1, 2, 0.0F, false));
        this.Begin.cubeList.add(new ModelBox(this.Begin, 30, 32, -2.0F, -1.0F, 3.0F, 2, 1, 2, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, -3.0F, 0.0F);
        this.Begin.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 38, 0.0F, -2.0F, -5.0F, 7, 4, 10, 0.0F, false));
        this.Pillow = new MModelRenderer(this);
        this.Pillow.setRotationPoint(2.0F, -5.5F, 0.0F);
        this.Begin.addChild(this.Pillow);
        this.Pillow.cubeList.add(new ModelBox(this.Pillow, 52, 0, -2.0F, -0.5F, -4.0F, 4, 1, 8, 0.0F, false));
        this.End = new MModelRenderer(this);
        this.End.setRotationPoint(6.0F, 0.0F, 0.0F);
        this.Bed.addChild(this.End);
        this.End.cubeList.add(new ModelBox(this.End, 38, 48, 0.0F, -6.0F, -5.0F, 2, 5, 10, 0.0F, false));
        this.End.cubeList.add(new ModelBox(this.End, 0, 38, 0.0F, -1.0F, 3.0F, 2, 1, 2, 0.0F, false));
        this.End.cubeList.add(new ModelBox(this.End, 30, 26, 0.0F, -1.0F, -5.0F, 2, 1, 2, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.0F, -3.0F, 0.0F);
        this.End.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 30, 28, -7.0F, -2.0F, -5.0F, 7, 4, 10, 0.0F, false));
        this.Persona = new MModelRenderer(this);
        this.Persona.setRotationPoint(0.0F, -19.5F, 0.0F);
        this.root.addChild(this.Persona);
        this.Persona.cubeList.add(new ModelBox(this.Persona, 0, 52, -3.5F, -3.5F, -2.0F, 7, 7, 4, 0.0F, false));
        this.Emotion1 = new MModelRenderer(this);
        this.Emotion1.setRotationPoint(0.0F, 0.0F, -2.1F);
        this.Persona.addChild(this.Emotion1);
        this.Emotion1.cubeList.add(new ModelBox(this.Emotion1, 38, 42, -3.0F, -2.5F, 0.0F, 6, 5, 0, 0.0F, false));
        this.Emotion2 = new MModelRenderer(this);
        this.Emotion2.setRotationPoint(0.0F, 0.0F, -1.9F);
        this.Persona.addChild(this.Emotion2);
        this.Emotion2.cubeList.add(new ModelBox(this.Emotion2, 0, 0, -3.0F, -2.5F, 0.0F, 6, 5, 0, 0.0F, false));
        this.Emotion3 = new MModelRenderer(this);
        this.Emotion3.setRotationPoint(0.0F, 0.0F, -1.9F);
        this.Persona.addChild(this.Emotion3);
        this.Emotion3.cubeList.add(new ModelBox(this.Emotion3, 0, 5, -3.0F, -2.5F, 0.0F, 6, 5, 0, 0.0F, false));
        this.LeftEar = new MModelRenderer(this);
        this.LeftEar.setRotationPoint(2.0F, -3.5F, 0.0F);
        this.Persona.addChild(this.LeftEar);
        this.LeftEar.cubeList.add(new ModelBox(this.LeftEar, 24, 38, -1.0F, -2.0F, -0.5F, 2, 2, 1, 0.0F, false));
        this.RightEar = new MModelRenderer(this);
        this.RightEar.setRotationPoint(-2.0F, -3.5F, 0.0F);
        this.Persona.addChild(this.RightEar);
        this.RightEar.cubeList.add(new ModelBox(this.RightEar, 0, 41, -1.0F, -2.0F, -0.5F, 2, 2, 1, 0.0F, false));
        this.LeftHand = new MModelRenderer(this);
        this.LeftHand.setRotationPoint(3.5F, 0.5F, 0.0F);
        this.Persona.addChild(this.LeftHand);
        this.LeftHand.cubeList.add(new ModelBox(this.LeftHand, 0, 18, 0.0F, -1.0F, -1.0F, 3, 2, 2, 0.0F, false));
        this.RightHand = new MModelRenderer(this);
        this.RightHand.setRotationPoint(-3.5F, 0.5F, 0.0F);
        this.Persona.addChild(this.RightHand);
        this.RightHand.cubeList.add(new ModelBox(this.RightHand, 0, 14, -3.0F, -1.0F, -1.0F, 3, 2, 2, 0.0F, false));
        this.LeftLeg = new MModelRenderer(this);
        this.LeftLeg.setRotationPoint(1.8F, 3.5F, 0.0F);
        this.Persona.addChild(this.LeftLeg);
        this.LeftLeg.cubeList.add(new ModelBox(this.LeftLeg, 0, 26, -1.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F, false));
        this.RightLeg = new MModelRenderer(this);
        this.RightLeg.setRotationPoint(-1.8F, 3.5F, 0.0F);
        this.Persona.addChild(this.RightLeg);
        this.RightLeg.cubeList.add(new ModelBox(this.RightLeg, 0, 30, -1.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F, false));
        this.Pedestal = new MModelRenderer(this);
        this.Pedestal.setRotationPoint(0.0F, -5.2F, 0.0F);
        this.root.addChild(this.Pedestal);
        this.Pedestal.cubeList.add(new ModelBox(this.Pedestal, 0, 63, -5.0F, -5.3F, -7.0F, 10, 5, 2, 0.0F, false));
        this.Pedestal.cubeList.add(new ModelBox(this.Pedestal, 0, 0, -10.0F, -3.8F, -5.999F, 20, 2, 12, 0.0F, false));
        this.Pedestal.cubeList.add(new ModelBox(this.Pedestal, 0, 14, -8.0F, -1.8F, -4.999F, 16, 2, 10, 0.0F, false));
        this.Pedestal.cubeList.add(new ModelBox(this.Pedestal, 42, 14, -3.5F, 0.2F, -3.5F, 7, 3, 7, 0.0F, false));
        this.Pedestal.cubeList.add(new ModelBox(this.Pedestal, 0, 26, -5.0F, 3.2F, -4.999F, 10, 2, 10, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/bedwars2022wood.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/bedwars2022wood_animation.json"));
        this.animation = bbanimationloader.mustGet("persona.animation", this);
    }

    public void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        this.animation.tick(time);
        float f = MathHelper.sin(time * 0.16F) * 0.04F;
        GlStateManager.translate(0.7D, -0.2D + (double)f, 0.3D);
        float f1 = 0.7F;
        GlStateManager.scale(f1, f1, f1);
        super.preRender(modelPlayer, player, time, pi);
    }

    public void renderAsItem(float time)
    {
        this.animation.tick(time);
        GlStateManager.translate(0.0D, 0.4D, 0.0D);
        float f = 0.7F;
        GlStateManager.scale(f, f, f);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041a\u0440\u043e\u0432\u0430\u0442\u043a\u0430 2022";
    }

    public List<String> getDescription()
    {
        return Collections.<String>singletonList("\u0417\u0430 \u0443\u0447\u0430\u0441\u0442\u0438\u0435 \u0432 \u0442\u0443\u0440\u043d\u0438\u0440\u0435 " + EnumChatFormatting.GREEN + "BedWars Hard [\u041b\u0435\u0442\u043e 2022]");
    }
}
