package net.xtrafrancyz.mods.minidot.items.mask;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class MaskRobot extends BaseItem
{
    private final MModelRenderer bone;
    private final MModelRenderer bone4;
    private final MModelRenderer bone6;
    private final MModelRenderer bone2;
    private final MModelRenderer bone11;
    private final MModelRenderer bone8;
    private final MModelRenderer bone3;
    private final MModelRenderer bone10;
    private final MModelRenderer bone9;
    private final MModelRenderer bone13;
    private final MModelRenderer bone12;
    private final MModelRenderer bone5;
    private final MModelRenderer bone7;
    private final MModelRenderer bone14;
    private final MModelRenderer bone23;
    private final MModelRenderer bone24;
    private final MModelRenderer bone25;
    private final MModelRenderer bone15;
    private final MModelRenderer bone20;
    private final MModelRenderer bone21;
    private final MModelRenderer bone22;
    private final MModelRenderer bone16;
    private final MModelRenderer bone19;
    private final MModelRenderer bone18;
    private final MModelRenderer bone17;
    private final IAnimation anim;

    public MaskRobot()
    {
        super(ItemType.MASK);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.bone = new MModelRenderer(this);
        this.bone.cubeList.add(new ModelBox(this.bone, 20, 9, -2.0F, -1.0F, -4.999F, 4, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 11, 0, -4.5F, -6.9001F, 3.7F, 9, 2, 1, -0.3F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 11, 18, -3.0F, -9.0F, -5.0001F, 6, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 11, 11, -4.0F, -8.0F, -4.6F, 8, 7, 0, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(-2.0F, 0.0F, -5.0F);
        this.setRotation(this.bone4, 0.0F, 0.0F, -0.9425F);
        this.bone.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 16, 22, 0.0F, -3.0F, 0.0F, 1, 3, 1, 0.0F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(2.0F, 0.0F, -5.0F);
        this.setRotation(this.bone6, 0.0F, 0.0F, 0.9425F);
        this.bone.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 0, 22, -1.0F, -3.0F, -1.0E-4F, 1, 3, 1, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(4.2F, -7.4F, 4.4F);
        this.setRotation(this.bone2, 0.0F, -0.0349F, 0.0F);
        this.bone.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 11, -0.7F, 0.5F, -8.7F, 1, 2, 9, -0.3F, false));
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(0.0F, -0.2F, -8.4F);
        this.setRotation(this.bone11, -0.4363F, 0.0F, 0.0F);
        this.bone2.addChild(this.bone11);
        this.bone11.cubeList.add(new ModelBox(this.bone11, 0, 0, -0.7999F, -0.3015F, -0.2968F, 1, 2, 3, -0.3F, false));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(0.0F, 2.8F, -8.4F);
        this.setRotation(this.bone8, 0.4363F, 0.0F, 0.0F);
        this.bone2.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 0, 22, -0.7999F, -0.9735F, -0.6349F, 1, 2, 4, -0.3F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(-4.2F, -7.4F, 4.4F);
        this.setRotation(this.bone3, 0.0F, 0.0349F, 0.0F);
        this.bone.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 0, -0.3F, 0.5F, -8.7F, 1, 2, 9, -0.3F, false));
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(0.0F, -0.2F, -8.4F);
        this.setRotation(this.bone10, -0.4363F, 0.0F, 0.0F);
        this.bone3.addChild(this.bone10);
        this.bone10.cubeList.add(new ModelBox(this.bone10, 0, 11, -0.2001F, -0.3015F, -0.2968F, 1, 2, 3, -0.3F, false));
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(0.0F, 2.8F, -8.4F);
        this.setRotation(this.bone9, 0.4363F, 0.0F, 0.0F);
        this.bone3.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 0, 22, -0.2001F, -0.9735F, -0.6349F, 1, 2, 4, -0.3F, false));
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(-4.5321F, -7.7144F, -5.0F);
        this.setRotation(this.bone13, 0.0F, 0.0F, -0.0175F);
        this.bone.addChild(this.bone13);
        this.bone13.cubeList.add(new ModelBox(this.bone13, 28, 20, 0.0F, 0.0F, 1.0E-4F, 1, 6, 1, 0.0F, false));
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(4.5321F, -7.7144F, -5.0F);
        this.setRotation(this.bone12, 0.0F, 0.0F, 0.0175F);
        this.bone.addChild(this.bone12);
        this.bone12.cubeList.add(new ModelBox(this.bone12, 27, 11, -1.0F, 0.0F, 0.0F, 1, 6, 1, 0.0F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(-3.0F, -9.0F, -5.0F);
        this.setRotation(this.bone5, 0.0F, 0.0F, -((float)Math.PI * 2F / 9F));
        this.bone.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 0, 30, -2.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F, false));
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(3.0F, -9.0F, -5.0F);
        this.setRotation(this.bone7, 0.0F, 0.0F, ((float)Math.PI * 2F / 9F));
        this.bone.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 25, 18, 0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F, false));
        this.bone14 = new MModelRenderer(this);
        this.bone14.setRotationPoint(0.0F, -4.5F, 0.0F);
        this.bone.addChild(this.bone14);
        this.bone23 = new MModelRenderer(this);
        this.bone23.setRotationPoint(1.75F, -1.25F, -3.5F);
        this.bone14.addChild(this.bone23);
        this.bone23.cubeList.add(new ModelBox(this.bone23, 8, 28, -2.45F, -2.25F, 0.0F, 4, 4, 0, 0.0F, false));
        this.bone24 = new MModelRenderer(this);
        this.bone24.setRotationPoint(-1.75F, -1.25F, -3.5F);
        this.bone14.addChild(this.bone24);
        this.bone24.cubeList.add(new ModelBox(this.bone24, 8, 28, -2.45F, -2.25F, 0.0F, 4, 4, 0, 0.0F, false));
        this.bone25 = new MModelRenderer(this);
        this.bone25.setRotationPoint(0.0F, 2.0F, -3.5F);
        this.bone14.addChild(this.bone25);
        this.bone25.cubeList.add(new ModelBox(this.bone25, 12, 26, -2.2F, -1.5F, 0.0F, 8, 3, 0, 0.0F, false));
        this.bone15 = new MModelRenderer(this);
        this.bone15.setRotationPoint(0.0F, -4.5F, 0.0F);
        this.bone.addChild(this.bone15);
        this.bone20 = new MModelRenderer(this);
        this.bone20.setRotationPoint(2.0F, -1.5F, -3.2F);
        this.bone15.addChild(this.bone20);
        this.bone20.cubeList.add(new ModelBox(this.bone20, 6, 22, -2.7F, -2.0F, 0.0F, 4, 4, 0, 0.0F, false));
        this.bone21 = new MModelRenderer(this);
        this.bone21.setRotationPoint(-2.0F, -1.5F, -3.2F);
        this.bone15.addChild(this.bone21);
        this.bone21.cubeList.add(new ModelBox(this.bone21, 6, 22, -2.0F, -2.0F, 0.0F, 4, 4, 0, 0.0F, false));
        this.bone22 = new MModelRenderer(this);
        this.bone22.setRotationPoint(0.0F, 2.0F, -3.2F);
        this.bone15.addChild(this.bone22);
        this.bone22.cubeList.add(new ModelBox(this.bone22, 11, 6, -4.0F, -1.5F, 0.0F, 8, 3, 0, 0.0F, false));
        this.bone16 = new MModelRenderer(this);
        this.bone16.setRotationPoint(0.0F, -4.5F, -3.0F);
        this.bone.addChild(this.bone16);
        this.bone19 = new MModelRenderer(this);
        this.bone19.setRotationPoint(0.0F, 1.5F, -1.7F);
        this.bone16.addChild(this.bone19);
        this.bone19.cubeList.add(new ModelBox(this.bone19, 11, 3, -4.0F, -1.5F, 0.0F, 8, 3, 0, 0.0F, false));
        this.bone18 = new MModelRenderer(this);
        this.bone18.setRotationPoint(-2.0F, -1.5F, -1.7F);
        this.bone16.addChild(this.bone18);
        this.bone18.cubeList.add(new ModelBox(this.bone18, 0, 5, -2.0F, -2.0F, 0.0F, 4, 4, 0, 0.0F, false));
        this.bone17 = new MModelRenderer(this);
        this.bone17.setRotationPoint(2.0F, -1.5F, -1.7F);
        this.bone16.addChild(this.bone17);
        this.bone17.cubeList.add(new ModelBox(this.bone17, 0, 16, -2.0F, -2.0F, 0.0F, 4, 4, 0, 0.0F, false));
        this.bone16.setDynamic(true);
        this.bone15.setDynamic(true);
        this.bone14.setDynamic(true);
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "masks/3d_mask_robot.json"));
        this.anim = bbanimationloader.mustGet("3d_mask_robot", this);
        this.setTexture(new ResourceLocation("minidot", "masks/3d_mask_robot.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, 0.05F, 0.0F);

        if (player.getCurrentArmor(3) != null)
        {
            GlStateManager.translate(0.0F, 0.0F, 0.001F);
        }

        this.anim.tick(time);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.0F, -0.245F);
        GlStateManager.scale(0.9F, 0.9F, 0.9F);
        this.anim.tick(time);
        super.renderAsItem(time);
    }

    public String getCreator()
    {
        return "chikon";
    }

    public String getName()
    {
        return "\u041c\u0430\u0441\u043a\u0430 \u0440\u043e\u0431\u043e\u0442\u0430";
    }
}
