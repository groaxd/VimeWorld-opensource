package net.xtrafrancyz.mods.minidot.items.head;

import java.util.function.Consumer;
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

public class CrabCrown extends BaseItem
{
    private final MModelRenderer Crab_crown;
    private final MModelRenderer bone11;
    private final MModelRenderer bone12;
    private final MModelRenderer bone13;
    private final MModelRenderer bone26;
    private final MModelRenderer bone27;
    private final MModelRenderer bone28;
    private final MModelRenderer bone14;
    private final MModelRenderer bone15;
    private final MModelRenderer bone16;
    private final MModelRenderer bone23;
    private final MModelRenderer bone24;
    private final MModelRenderer bone25;
    private final MModelRenderer bone17;
    private final MModelRenderer bone18;
    private final MModelRenderer bone19;
    private final MModelRenderer bone32;
    private final MModelRenderer bone33;
    private final MModelRenderer bone34;
    private final MModelRenderer bone29;
    private final MModelRenderer bone30;
    private final MModelRenderer bone31;
    private final MModelRenderer bone20;
    private final MModelRenderer bone21;
    private final MModelRenderer bone22;
    private final MModelRenderer clawRight;
    private final MModelRenderer bone6;
    private final MModelRenderer bone5;
    private final MModelRenderer bone4;
    private final MModelRenderer clawLeft;
    private final MModelRenderer bone8;
    private final MModelRenderer bone9;
    private final MModelRenderer bone10;
    private final MModelRenderer crown;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final IAnimation anim;

    public CrabCrown()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Crab_crown = new MModelRenderer(this);
        this.Crab_crown.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.Crab_crown.cubeList.add(new ModelBox(this.Crab_crown, 0, 0, -4.5F, -10.0F, -4.5F, 9, 2, 9, 0.0F));
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(-1.25F, -0.85F, 1.75F);
        this.Crab_crown.addChild(this.bone11);
        this.setRotation(this.bone11, 0.0F, 0.1745F, 0.1745F);
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(4.25F, -8.5F, -2.5F);
        this.bone11.addChild(this.bone12);
        this.setRotation(this.bone12, 0.0F, 0.0F, -0.48F);
        this.bone12.cubeList.add(new ModelBox(this.bone12, 8, 24, -0.1039F, -0.5972F, -0.5F, 3, 1, 1, 0.0F));
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(6.25F, -8.5F, -2.5F);
        this.bone11.addChild(this.bone13);
        this.setRotation(this.bone13, 0.0F, 0.0F, 0.48F);
        this.bone13.cubeList.add(new ModelBox(this.bone13, 26, 15, -0.6021F, -1.7914F, -0.5F, 2, 1, 1, 0.0F));
        this.bone26 = new MModelRenderer(this);
        this.bone26.setRotationPoint(1.25F, -0.85F, 1.75F);
        this.Crab_crown.addChild(this.bone26);
        this.setRotation(this.bone26, 0.0F, -0.1745F, -0.1745F);
        this.bone27 = new MModelRenderer(this);
        this.bone27.setRotationPoint(-4.25F, -8.5F, -2.5F);
        this.bone26.addChild(this.bone27);
        this.setRotation(this.bone27, 0.0F, 0.0F, 0.48F);
        this.bone27.cubeList.add(new ModelBox(this.bone27, 8, 22, -2.8961F, -0.5972F, -0.5F, 3, 1, 1, 0.0F));
        this.bone28 = new MModelRenderer(this);
        this.bone28.setRotationPoint(-6.25F, -8.5F, -2.5F);
        this.bone26.addChild(this.bone28);
        this.setRotation(this.bone28, 0.0F, 0.0F, -0.48F);
        this.bone28.cubeList.add(new ModelBox(this.bone28, 24, 11, -1.3979F, -1.7914F, -0.5F, 2, 1, 1, 0.0F));
        this.bone14 = new MModelRenderer(this);
        this.bone14.setRotationPoint(-1.25F, -0.85F, 2.5F);
        this.Crab_crown.addChild(this.bone14);
        this.setRotation(this.bone14, 0.0F, 0.0F, 0.1745F);
        this.bone15 = new MModelRenderer(this);
        this.bone15.setRotationPoint(4.25F, -8.5F, -2.5F);
        this.bone14.addChild(this.bone15);
        this.setRotation(this.bone15, 0.0F, 0.0F, -0.48F);
        this.bone15.cubeList.add(new ModelBox(this.bone15, 0, 24, -0.1039F, -0.5972F, -0.5F, 3, 1, 1, 0.0F));
        this.bone16 = new MModelRenderer(this);
        this.bone16.setRotationPoint(6.25F, -8.5F, -2.5F);
        this.bone14.addChild(this.bone16);
        this.setRotation(this.bone16, 0.0F, 0.0F, 0.48F);
        this.bone16.cubeList.add(new ModelBox(this.bone16, 26, 13, -0.6021F, -1.7914F, -0.5F, 2, 1, 1, 0.0F));
        this.bone23 = new MModelRenderer(this);
        this.bone23.setRotationPoint(1.25F, -0.85F, 2.5F);
        this.Crab_crown.addChild(this.bone23);
        this.setRotation(this.bone23, 0.0F, 0.0F, -0.1745F);
        this.bone24 = new MModelRenderer(this);
        this.bone24.setRotationPoint(-4.25F, -8.5F, -2.5F);
        this.bone23.addChild(this.bone24);
        this.setRotation(this.bone24, 0.0F, 0.0F, 0.48F);
        this.bone24.cubeList.add(new ModelBox(this.bone24, 16, 22, -2.8961F, -0.5972F, -0.5F, 3, 1, 1, 0.0F));
        this.bone25 = new MModelRenderer(this);
        this.bone25.setRotationPoint(-6.25F, -8.5F, -2.5F);
        this.bone23.addChild(this.bone25);
        this.setRotation(this.bone25, 0.0F, 0.0F, -0.48F);
        this.bone25.cubeList.add(new ModelBox(this.bone25, 24, 25, -1.3979F, -1.7914F, -0.5F, 2, 1, 1, 0.0F));
        this.bone17 = new MModelRenderer(this);
        this.bone17.setRotationPoint(-2.6F, -1.85F, 3.5F);
        this.Crab_crown.addChild(this.bone17);
        this.setRotation(this.bone17, 0.0F, -0.1745F, 0.3054F);
        this.bone18 = new MModelRenderer(this);
        this.bone18.setRotationPoint(4.25F, -8.5F, -2.5F);
        this.bone17.addChild(this.bone18);
        this.setRotation(this.bone18, 0.0F, 0.0F, -0.48F);
        this.bone18.cubeList.add(new ModelBox(this.bone18, 23, 23, -0.1039F, -0.5972F, -0.5F, 3, 1, 1, 0.0F));
        this.bone19 = new MModelRenderer(this);
        this.bone19.setRotationPoint(6.25F, -8.5F, -2.5F);
        this.bone17.addChild(this.bone19);
        this.setRotation(this.bone19, 0.0F, 0.0F, 0.48F);
        this.bone19.cubeList.add(new ModelBox(this.bone19, 6, 26, -0.6021F, -1.7914F, -0.5F, 2, 1, 1, 0.0F));
        this.bone32 = new MModelRenderer(this);
        this.bone32.setRotationPoint(-4.4F, -9.05F, 3.0F);
        this.Crab_crown.addChild(this.bone32);
        this.setRotation(this.bone32, -0.3054F, 0.6545F, -((float)Math.PI * 2F / 9F));
        this.bone33 = new MModelRenderer(this);
        this.bone33.setRotationPoint(0.0592F, 0.4313F, 0.1763F);
        this.bone32.addChild(this.bone33);
        this.setRotation(this.bone33, 0.0F, 0.0F, 0.48F);
        this.bone33.cubeList.add(new ModelBox(this.bone33, 0, 22, -2.8961F, -0.5972F, -0.5F, 3, 1, 1, 0.0F));
        this.bone34 = new MModelRenderer(this);
        this.bone34.setRotationPoint(-1.9408F, 0.4313F, 0.1763F);
        this.bone32.addChild(this.bone34);
        this.setRotation(this.bone34, 0.0F, 0.0F, -0.48F);
        this.bone34.cubeList.add(new ModelBox(this.bone34, 13, 17, -1.3979F, -1.7914F, -0.5F, 2, 1, 1, 0.0F));
        this.bone29 = new MModelRenderer(this);
        this.bone29.setRotationPoint(4.4F, -9.05F, 3.0F);
        this.Crab_crown.addChild(this.bone29);
        this.setRotation(this.bone29, -0.3054F, -0.6545F, ((float)Math.PI * 2F / 9F));
        this.bone30 = new MModelRenderer(this);
        this.bone30.setRotationPoint(-0.0592F, 0.4313F, 0.1763F);
        this.bone29.addChild(this.bone30);
        this.setRotation(this.bone30, 0.0F, 0.0F, -0.48F);
        this.bone30.cubeList.add(new ModelBox(this.bone30, 21, 18, -0.1039F, -0.5972F, -0.5F, 3, 1, 1, 0.0F));
        this.bone31 = new MModelRenderer(this);
        this.bone31.setRotationPoint(1.9408F, 0.4313F, 0.1763F);
        this.bone29.addChild(this.bone31);
        this.setRotation(this.bone31, 0.0F, 0.0F, 0.48F);
        this.bone31.cubeList.add(new ModelBox(this.bone31, 5, 17, -0.6021F, -1.7914F, -0.5F, 2, 1, 1, 0.0F));
        this.bone20 = new MModelRenderer(this);
        this.bone20.setRotationPoint(2.6F, -1.85F, 3.5F);
        this.Crab_crown.addChild(this.bone20);
        this.setRotation(this.bone20, 0.0F, 0.1745F, -0.3054F);
        this.bone21 = new MModelRenderer(this);
        this.bone21.setRotationPoint(-4.25F, -8.5F, -2.5F);
        this.bone20.addChild(this.bone21);
        this.setRotation(this.bone21, 0.0F, 0.0F, 0.48F);
        this.bone21.cubeList.add(new ModelBox(this.bone21, 23, 21, -2.8961F, -0.5972F, -0.5F, 3, 1, 1, 0.0F));
        this.bone22 = new MModelRenderer(this);
        this.bone22.setRotationPoint(-6.25F, -8.5F, -2.5F);
        this.bone20.addChild(this.bone22);
        this.setRotation(this.bone22, 0.0F, 0.0F, -0.48F);
        this.bone22.cubeList.add(new ModelBox(this.bone22, 0, 26, -1.3979F, -1.7914F, -0.5F, 2, 1, 1, 0.0F));
        this.clawRight = new MModelRenderer(this);
        this.clawRight.setRotationPoint(-5.0F, -9.0F, -2.75F);
        this.Crab_crown.addChild(this.clawRight);
        this.setRotation(this.clawRight, -0.2182F, -0.0873F, 0.0F);
        this.clawRight.cubeList.add(new ModelBox(this.clawRight, 21, 14, -0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F));
        this.clawRight.cubeList.add(new ModelBox(this.clawRight, 8, 17, -0.5F, -1.0F, -6.0F, 1, 2, 3, 0.0F));
        this.clawRight.cubeList.add(new ModelBox(this.clawRight, 20, 25, -1.4763F, -1.0F, -5.309F, 1, 2, 2, 0.0F));
        this.clawRight.cubeList.add(new ModelBox(this.clawRight, 11, 27, -0.5F, -1.0F, -7.0F, 1, 2, 1, 0.0F));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(1.15F, 9.5F, 3.9F);
        this.clawRight.addChild(this.bone6);
        this.setRotation(this.bone6, 0.0F, -0.4363F, 0.0F);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 16, 17, -4.5052F, -10.5F, -8.9788F, 1, 2, 3, 0.0F));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(5.0F, 9.5F, 3.0F);
        this.clawRight.addChild(this.bone5);
        this.setRotation(this.bone5, 0.0F, -0.3054F, 0.0F);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 27, 3, -8.6751F, -10.5F, -6.977F, 1, 2, 1, 0.0F));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(5.0F, 9.5F, 3.0F);
        this.clawRight.addChild(this.bone4);
        this.setRotation(this.bone4, 0.0F, 0.829F, 0.0F);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 27, 6, 2.657F, -10.5F, -10.8109F, 1, 2, 1, 0.0F));
        this.clawLeft = new MModelRenderer(this);
        this.clawLeft.setRotationPoint(5.0F, -9.0F, -2.75F);
        this.Crab_crown.addChild(this.clawLeft);
        this.setRotation(this.clawLeft, -0.2182F, 0.0873F, 0.0F);
        this.clawLeft.cubeList.add(new ModelBox(this.clawLeft, 0, 5, -0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F));
        this.clawLeft.cubeList.add(new ModelBox(this.clawLeft, 0, 0, -0.5F, -1.0F, -6.0F, 1, 2, 3, 0.0F));
        this.clawLeft.cubeList.add(new ModelBox(this.clawLeft, 14, 24, 0.4763F, -1.0F, -5.309F, 1, 2, 2, 0.0F));
        this.clawLeft.cubeList.add(new ModelBox(this.clawLeft, 5, 5, -0.5F, -1.0F, -7.0F, 1, 2, 1, 0.0F));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(-1.15F, 9.5F, 3.9F);
        this.clawLeft.addChild(this.bone8);
        this.setRotation(this.bone8, 0.0F, 0.4363F, 0.0F);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 0, 17, 3.5052F, -10.5F, -8.9788F, 1, 2, 3, 0.0F));
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(-5.0F, 9.5F, 3.0F);
        this.clawLeft.addChild(this.bone9);
        this.setRotation(this.bone9, 0.0F, 0.3054F, 0.0F);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 27, 0, 7.6751F, -10.5F, -6.977F, 1, 2, 1, 0.0F));
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(-5.0F, 9.5F, 3.0F);
        this.clawLeft.addChild(this.bone10);
        this.setRotation(this.bone10, 0.0F, -0.829F, 0.0F);
        this.bone10.cubeList.add(new ModelBox(this.bone10, 5, 0, -3.657F, -10.5F, -10.8109F, 1, 2, 1, 0.0F));
        this.crown = new MModelRenderer(this);
        this.crown.setRotationPoint(0.0F, 0.0F, 0.5F);
        this.Crab_crown.addChild(this.crown);
        this.crown.cubeList.add(new ModelBox(this.crown, 0, 8, 3.0F, -13.0F, -3.0F, 0, 3, 6, 0.0F));
        this.crown.cubeList.add(new ModelBox(this.crown, 0, 5, -3.0F, -13.0F, -3.0F, 0, 3, 6, 0.0F));
        this.crown.cubeList.add(new ModelBox(this.crown, 12, 14, -3.0F, -13.0F, -3.0F, 6, 3, 0, 0.0F));
        this.crown.cubeList.add(new ModelBox(this.crown, 12, 11, -3.0F, -13.0F, 3.0F, 6, 3, 0, 0.0F));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(1.5F, -10.25F, -3.5F);
        this.Crab_crown.addChild(this.bone);
        this.setRotation(this.bone, 0.0F, 0.0F, 0.1309F);
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 28, -0.4191F, -1.694F, -0.5F, 1, 2, 1, 0.0F));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-1.5F, -10.25F, -3.5F);
        this.Crab_crown.addChild(this.bone2);
        this.setRotation(this.bone2, 0.0F, 0.0F, -0.1309F);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 26, 27, -0.5809F, -1.694F, -0.5F, 1, 2, 1, 0.0F));
        this.setTexture(new ResourceLocation("minidot", "head/crabcrown.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "head/crabcrown_animation.json"));
        this.anim = bbanimationloader.mustGet("crab.rave", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(1.01F, 1.01F, 1.01F);
        GlStateManager.translate(0.0F, -1.45F, 0.0F);

        if (player.isSneaking())
        {
            if (this.anim.isFinished())
            {
                this.anim.reset();
            }

            this.anim.tick(time);
        }
        else
        {
            this.anim.reset();
            this.forEachDynamicModel((rr) ->
            {
                rr.rotationX = 0.0F;
                rr.rotationY = 0.0F;
                rr.rotationZ = 0.0F;
            });
        }
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -1.0F, 0.0F);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041a\u043e\u0440\u043e\u043d\u0430-\u041a\u0440\u0430\u0431";
    }

    public String getCreator()
    {
        return "xRolaaan";
    }
}
