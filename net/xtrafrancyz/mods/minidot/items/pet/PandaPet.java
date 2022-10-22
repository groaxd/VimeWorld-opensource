package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class PandaPet extends BasePet
{
    private final MModelRenderer Panda;
    private final MModelRenderer Body;
    private final MModelRenderer bone5;
    private final MModelRenderer bone4;
    private final MModelRenderer bone8;
    private final MModelRenderer Head;
    private final MModelRenderer bone;
    private final MModelRenderer bone6;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer LeftHand;
    private final MModelRenderer RightHand;
    private final MModelRenderer Bambuk;
    private final MModelRenderer ZzZz;
    private final MModelRenderer bone11;
    private final MModelRenderer bone13;
    private final MModelRenderer bone12;
    private final MModelRenderer bone14;
    private final IAnimation animation;

    public PandaPet()
    {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.Panda = new MModelRenderer(this);
        this.Body = new MModelRenderer(this);
        this.Body.setRotationPoint(0.0F, -0.1F, -2.0F);
        this.Panda.addChild(this.Body);
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(1.0F, -1.0F, 3.0F);
        this.setRotation(this.bone5, 0.0F, -0.0873F, 0.0F);
        this.Body.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 20, 12, 0.0F, -0.9F, -3.3F, 2, 2, 4, 0.0F, false));
        this.bone5.cubeList.add(new ModelBox(this.bone5, 12, 23, 0.0F, -1.0F, -4.4F, 2, 2, 1, 0.1F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(-1.0F, -1.0F, 3.0F);
        this.setRotation(this.bone4, 0.0F, 0.0873F, 0.0F);
        this.Body.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 20, 0, -2.0F, -0.9F, -3.3F, 2, 2, 4, 0.0F, false));
        this.bone4.cubeList.add(new ModelBox(this.bone4, 6, 22, -2.0F, -1.0F, -4.4F, 2, 2, 1, 0.1F, false));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(0.0F, -0.3F, 3.0F);
        this.setRotation(this.bone8, 0.1745F, 0.0F, 0.0F);
        this.Body.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 20, 6, -2.3F, -6.0F, -1.7F, 4, 1, 3, 0.0F, false));
        this.bone8.cubeList.add(new ModelBox(this.bone8, 0, 12, -2.4F, -5.0F, -1.8F, 4, 5, 4, 0.0F, false));
        this.Head = new MModelRenderer(this);
        this.Head.setRotationPoint(0.0F, -5.4564F, 0.2981F);
        this.setRotation(this.Head, 0.1745F, 0.0F, 0.0F);
        this.bone8.addChild(this.Head);
        this.Head.cubeList.add(new ModelBox(this.Head, 0, 0, -2.5F, -5.0F, -2.5F, 5, 5, 5, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, -2.0958F, -2.4091F);
        this.setRotation(this.bone, 0.1745F, 0.0F, 0.0F);
        this.Head.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 15, 0, -1.0F, -0.3478F, -1.389F, 2, 2, 2, 0.0F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(0.1F, 0.283F, -2.6294F);
        this.setRotation(this.bone6, -0.1745F, 0.0F, 0.0F);
        this.Head.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 20, 18, -1.1F, -1.2532F, -1.0362F, 2, 1, 1, -0.1F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(2.3F, -4.6436F, 0.0019F);
        this.setRotation(this.bone2, 0.0873F, 0.0F, 0.3491F);
        this.Head.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 6, 25, -1.0F, -1.5F, -0.5F, 2, 2, 1, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(-2.3F, -4.6436F, 0.0019F);
        this.setRotation(this.bone3, 0.0873F, 0.0F, -0.3491F);
        this.Head.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 24, -1.0F, -1.5F, -0.5F, 2, 2, 1, 0.0F, false));
        this.LeftHand = new MModelRenderer(this);
        this.LeftHand.setRotationPoint(2.0F, -4.1F, 0.0F);
        this.setRotation(this.LeftHand, 0.1571F, -0.1745F, 0.0F);
        this.bone8.addChild(this.LeftHand);
        this.LeftHand.cubeList.add(new ModelBox(this.LeftHand, 15, 23, -1.0F, -1.0F, -4.0F, 2, 2, 5, 0.0F, false));
        this.RightHand = new MModelRenderer(this);
        this.RightHand.setRotationPoint(-2.0F, -4.1F, 0.0F);
        this.setRotation(this.RightHand, 0.1571F, 0.1745F, 0.0F);
        this.bone8.addChild(this.RightHand);
        this.RightHand.cubeList.add(new ModelBox(this.RightHand, 11, 16, -1.0F, -1.0F, -4.0F, 2, 2, 5, 0.0F, false));
        this.Bambuk = new MModelRenderer(this);
        this.Bambuk.setRotationPoint(3.7667F, -2.5F, -2.1F);
        this.setRotation(this.Bambuk, -((float)Math.PI * 2F / 9F), 0.0F, 0.0F);
        this.Bambuk.cubeList.add(new ModelBox(this.Bambuk, 0, 10, -10.6667F, -0.5F, -0.5F, 12, 1, 1, -0.2F, false));
        this.Bambuk.cubeList.add(new ModelBox(this.Bambuk, 0, 2, -10.0667F, -2.3F, 0.0F, 2, 2, 0, 0.0F, false));
        this.Bambuk.cubeList.add(new ModelBox(this.Bambuk, 0, 0, -9.2667F, 0.3F, 0.0F, 2, 2, 0, 0.0F, false));
        this.ZzZz = new MModelRenderer(this);
        this.ZzZz.setRotationPoint(-4.5F, -9.1F, -0.15F);
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(11.5F, -4.1F, 0.0F);
        this.ZzZz.addChild(this.bone11);
        this.bone11.cubeList.add(new ModelBox(this.bone11, 12, 12, -1.0F, -1.0F, 0.0F, 2, 2, 0, 0.0F, false));
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(10.2F, -1.6F, 0.0F);
        this.ZzZz.addChild(this.bone13);
        this.bone13.cubeList.add(new ModelBox(this.bone13, 0, 21, -1.0F, -1.0F, 0.0F, 2, 2, 0, 0.0F, false));
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(9.1F, 0.9F, 0.0F);
        this.ZzZz.addChild(this.bone12);
        this.bone12.cubeList.add(new ModelBox(this.bone12, 0, 14, -1.0F, -1.0F, 0.0F, 2, 2, 0, 0.0F, false));
        this.bone14 = new MModelRenderer(this);
        this.bone14.setRotationPoint(6.0F, 2.0F, 0.0F);
        this.ZzZz.addChild(this.bone14);
        this.bone14.cubeList.add(new ModelBox(this.bone14, 0, 12, -1.0F, -1.0F, 0.0F, 2, 2, 0, 0.0F, false));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/panda_anim.json"));
        this.animation = bbanimationloader.mustGet("panda_animated", this);
        this.setTexture(new ResourceLocation("minidot", "pets/panda.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        GlStateManager.translate(0.7F, -0.15F + f, 0.3F);
        GlStateManager.scale(1.5F, 1.5F, 1.5F);
        this.animation.tick(time);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.32F, 0.0F);
        GlStateManager.scale(1.3F, 1.3F, 1.3F);
        this.animation.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0421\u043e\u043d\u043d\u044b\u0439 \u043f\u0430\u043d\u0434\u0430";
    }

    public String getCreator()
    {
        return "chikon";
    }
}
