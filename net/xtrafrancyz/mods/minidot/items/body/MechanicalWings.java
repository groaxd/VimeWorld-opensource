package net.xtrafrancyz.mods.minidot.items.body;

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

public class MechanicalWings extends BaseItem
{
    private final MModelRenderer MechanicalWings;
    private final MModelRenderer Wing;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final MModelRenderer bone11;
    private final MModelRenderer bone9;
    private final MModelRenderer bone10;
    private final MModelRenderer bone6;
    private final MModelRenderer Wing2;
    private final MModelRenderer bone12;
    private final MModelRenderer bone13;
    private final MModelRenderer bone14;
    private final MModelRenderer bone15;
    private final MModelRenderer bone16;
    private final MModelRenderer bone17;
    private final MModelRenderer bone18;
    private final MModelRenderer bone19;
    private final MModelRenderer bone20;
    private final MModelRenderer Wing3;
    private final MModelRenderer bone23;
    private final MModelRenderer bone24;
    private final MModelRenderer bone25;
    private final MModelRenderer bone26;
    private final MModelRenderer bone27;
    private final MModelRenderer bone28;
    private final MModelRenderer bone29;
    private final MModelRenderer bone30;
    private final MModelRenderer bone31;
    private final MModelRenderer Wing4;
    private final MModelRenderer bone34;
    private final MModelRenderer bone35;
    private final MModelRenderer bone36;
    private final MModelRenderer bone37;
    private final MModelRenderer bone38;
    private final MModelRenderer bone39;
    private final MModelRenderer bone40;
    private final MModelRenderer bone41;
    private final MModelRenderer bone42;
    private final MModelRenderer Module;
    private final IAnimation animation;

    public MechanicalWings()
    {
        super(ItemType.BODY);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.MechanicalWings = new MModelRenderer(this);
        this.Wing = new MModelRenderer(this);
        this.Wing.setRotationPoint(1.5F, -10.25F, 2.0F);
        this.setRotation(this.Wing, 0.5672F, 0.0F, 0.0F);
        this.MechanicalWings.addChild(this.Wing);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.5F, -0.8377F, 0.6621F);
        this.setRotation(this.bone, 0.2182F, 0.6545F, 0.0F);
        this.Wing.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 17, -0.5F, 0.0F, 0.0F, 1, 1, 6, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.5F, -0.8377F, 0.6621F);
        this.setRotation(this.bone2, -0.1309F, 0.6545F, 0.0F);
        this.Wing.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 20, 0, -0.5F, -2.0521F, 5.6382F, 1, 1, 3, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.5F, -0.8377F, 12.6621F);
        this.setRotation(this.bone3, 0.2182F, 0.6545F, 0.0F);
        this.Wing.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 0, 6.8051F, -1.0948F, -0.8175F, 1, 1, 3, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(-2.0F, 10.1623F, -1.3379F);
        this.setRotation(this.bone4, 0.2182F, 0.6545F, 0.0F);
        this.Wing.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 0, 0, 0.7659F, -10.0664F, 3.4158F, 0, 11, 5, 0.0F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(3.75F, -1.5877F, 4.6621F);
        this.setRotation(this.bone5, 0.1851F, 0.6632F, -0.0541F);
        this.Wing.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 10, 0, -0.1424F, 0.6171F, -2.1921F, 0, 7, 5, 0.0F, false));
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(-0.2F, 3.075F, -0.175F);
        this.bone5.addChild(this.bone11);
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(-6.0F, 8.5F, -6.0F);
        this.bone11.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 11, 0, 6.0F, -9.0F, 4.0F, 0, 1, 4, 0.0F, false));
        this.bone10 = new MModelRenderer(this);
        this.setRotation(this.bone10, -1.5708F, 0.0F, 0.0F);
        this.bone11.addChild(this.bone10);
        this.bone10.cubeList.add(new ModelBox(this.bone10, 11, 0, 0.0F, -0.5F, -2.0F, 0, 1, 4, 0.0F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(5.75F, -1.3377F, 8.6621F);
        this.setRotation(this.bone6, 0.1167F, 0.6764F, -0.1641F);
        this.Wing.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 22, 13, 0.706F, -0.5773F, -1.4248F, 0, 5, 3, 0.0F, false));
        this.Wing2 = new MModelRenderer(this);
        this.Wing2.setRotationPoint(-1.5F, -10.25F, 2.0F);
        this.setRotation(this.Wing2, 0.5672F, 0.0F, 0.0F);
        this.MechanicalWings.addChild(this.Wing2);
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(-0.5F, -0.8377F, 0.6621F);
        this.setRotation(this.bone12, 0.2182F, -0.6545F, 0.0F);
        this.Wing2.addChild(this.bone12);
        this.bone12.cubeList.add(new ModelBox(this.bone12, 0, 17, -0.5F, 0.0F, 0.0F, 1, 1, 6, 0.0F, true));
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(-0.5F, -0.8377F, 0.6621F);
        this.setRotation(this.bone13, -0.1309F, -0.6545F, 0.0F);
        this.Wing2.addChild(this.bone13);
        this.bone13.cubeList.add(new ModelBox(this.bone13, 20, 0, -0.5F, -2.0521F, 5.6382F, 1, 1, 3, 0.0F, true));
        this.bone14 = new MModelRenderer(this);
        this.bone14.setRotationPoint(-0.5F, -0.8377F, 12.6621F);
        this.setRotation(this.bone14, 0.2182F, -0.6545F, 0.0F);
        this.Wing2.addChild(this.bone14);
        this.bone14.cubeList.add(new ModelBox(this.bone14, 0, 0, -7.8051F, -1.0948F, -0.8175F, 1, 1, 3, 0.0F, true));
        this.bone15 = new MModelRenderer(this);
        this.bone15.setRotationPoint(2.0F, 10.1623F, -1.3379F);
        this.setRotation(this.bone15, 0.2182F, -0.6545F, 0.0F);
        this.Wing2.addChild(this.bone15);
        this.bone15.cubeList.add(new ModelBox(this.bone15, 0, 0, -0.7659F, -10.0664F, 3.4158F, 0, 11, 5, 0.0F, true));
        this.bone16 = new MModelRenderer(this);
        this.bone16.setRotationPoint(-3.75F, -1.5877F, 4.6621F);
        this.setRotation(this.bone16, 0.1851F, -0.6632F, 0.0541F);
        this.Wing2.addChild(this.bone16);
        this.bone16.cubeList.add(new ModelBox(this.bone16, 10, 0, 0.1424F, 0.6171F, -2.1921F, 0, 7, 5, 0.0F, true));
        this.bone17 = new MModelRenderer(this);
        this.bone17.setRotationPoint(0.2F, 3.075F, -0.175F);
        this.bone16.addChild(this.bone17);
        this.bone18 = new MModelRenderer(this);
        this.bone18.setRotationPoint(6.0F, 8.5F, -6.0F);
        this.bone17.addChild(this.bone18);
        this.bone18.cubeList.add(new ModelBox(this.bone18, 11, 0, -6.0F, -9.0F, 4.0F, 0, 1, 4, 0.0F, true));
        this.bone19 = new MModelRenderer(this);
        this.setRotation(this.bone19, -1.5708F, 0.0F, 0.0F);
        this.bone17.addChild(this.bone19);
        this.bone19.cubeList.add(new ModelBox(this.bone19, 11, 0, 0.0F, -0.5F, -2.0F, 0, 1, 4, 0.0F, true));
        this.bone20 = new MModelRenderer(this);
        this.bone20.setRotationPoint(-5.75F, -1.3377F, 8.6621F);
        this.setRotation(this.bone20, 0.1167F, -0.6764F, 0.1641F);
        this.Wing2.addChild(this.bone20);
        this.bone20.cubeList.add(new ModelBox(this.bone20, 22, 13, -0.706F, -0.5773F, -1.4248F, 0, 5, 3, 0.0F, true));
        this.Wing3 = new MModelRenderer(this);
        this.Wing3.setRotationPoint(1.5F, -10.25F, 2.0F);
        this.setRotation(this.Wing3, -0.2878F, -0.4293F, -0.0808F);
        this.MechanicalWings.addChild(this.Wing3);
        this.bone23 = new MModelRenderer(this);
        this.bone23.setRotationPoint(0.5F, -0.8377F, 0.6621F);
        this.setRotation(this.bone23, 0.2182F, 0.6545F, 0.0F);
        this.Wing3.addChild(this.bone23);
        this.bone23.cubeList.add(new ModelBox(this.bone23, 0, 17, -0.5F, 0.0F, 0.0F, 1, 1, 6, 0.0F, false));
        this.bone24 = new MModelRenderer(this);
        this.bone24.setRotationPoint(0.5F, -0.8377F, 0.6621F);
        this.setRotation(this.bone24, -0.1309F, 0.6545F, 0.0F);
        this.Wing3.addChild(this.bone24);
        this.bone24.cubeList.add(new ModelBox(this.bone24, 20, 0, -0.5F, -2.0521F, 5.6382F, 1, 1, 3, 0.0F, false));
        this.bone25 = new MModelRenderer(this);
        this.bone25.setRotationPoint(0.5F, -0.8377F, 12.6621F);
        this.setRotation(this.bone25, 0.2182F, 0.6545F, 0.0F);
        this.Wing3.addChild(this.bone25);
        this.bone25.cubeList.add(new ModelBox(this.bone25, 0, 0, 6.8051F, -1.0948F, -0.8175F, 1, 1, 3, 0.0F, false));
        this.bone26 = new MModelRenderer(this);
        this.bone26.setRotationPoint(-2.0F, 10.1623F, -1.3379F);
        this.setRotation(this.bone26, 0.2182F, 0.6545F, 0.0F);
        this.Wing3.addChild(this.bone26);
        this.bone26.cubeList.add(new ModelBox(this.bone26, 0, 0, 0.7659F, -10.0664F, 3.4158F, 0, 11, 5, 0.0F, false));
        this.bone27 = new MModelRenderer(this);
        this.bone27.setRotationPoint(3.75F, -1.5877F, 4.6621F);
        this.setRotation(this.bone27, 0.1851F, 0.6632F, -0.0541F);
        this.Wing3.addChild(this.bone27);
        this.bone27.cubeList.add(new ModelBox(this.bone27, 10, 0, -0.1424F, 0.6171F, -2.1921F, 0, 7, 5, 0.0F, false));
        this.bone28 = new MModelRenderer(this);
        this.bone28.setRotationPoint(-0.2F, 3.075F, -0.175F);
        this.bone27.addChild(this.bone28);
        this.bone29 = new MModelRenderer(this);
        this.bone29.setRotationPoint(-6.0F, 8.5F, -6.0F);
        this.bone28.addChild(this.bone29);
        this.bone29.cubeList.add(new ModelBox(this.bone29, 0, 26, 6.0F, -9.0F, 4.0F, 0, 1, 4, 0.0F, false));
        this.bone30 = new MModelRenderer(this);
        this.setRotation(this.bone30, -1.5708F, 0.0F, 0.0F);
        this.bone28.addChild(this.bone30);
        this.bone30.cubeList.add(new ModelBox(this.bone30, 0, 26, 0.0F, -0.5F, -2.0F, 0, 1, 4, 0.0F, false));
        this.bone31 = new MModelRenderer(this);
        this.bone31.setRotationPoint(5.75F, -1.3377F, 8.6621F);
        this.setRotation(this.bone31, 0.1167F, 0.6764F, -0.1641F);
        this.Wing3.addChild(this.bone31);
        this.bone31.cubeList.add(new ModelBox(this.bone31, 10, 12, 0.706F, -0.5773F, -1.4248F, 0, 5, 3, 0.0F, false));
        this.Wing4 = new MModelRenderer(this);
        this.Wing4.setRotationPoint(-1.5F, -10.25F, 2.0F);
        this.setRotation(this.Wing4, -0.2878F, 0.4293F, -0.0808F);
        this.MechanicalWings.addChild(this.Wing4);
        this.bone34 = new MModelRenderer(this);
        this.bone34.setRotationPoint(-0.5F, -0.8377F, 0.6621F);
        this.setRotation(this.bone34, 0.2182F, -0.6545F, 0.0F);
        this.Wing4.addChild(this.bone34);
        this.bone34.cubeList.add(new ModelBox(this.bone34, 0, 17, -0.5F, 0.0F, 0.0F, 1, 1, 6, 0.0F, true));
        this.bone35 = new MModelRenderer(this);
        this.bone35.setRotationPoint(-0.5F, -0.8377F, 0.6621F);
        this.setRotation(this.bone35, -0.1309F, -0.6545F, 0.0F);
        this.Wing4.addChild(this.bone35);
        this.bone35.cubeList.add(new ModelBox(this.bone35, 20, 0, -0.5F, -2.0521F, 5.6382F, 1, 1, 3, 0.0F, true));
        this.bone36 = new MModelRenderer(this);
        this.bone36.setRotationPoint(-0.5F, -0.8377F, 12.6621F);
        this.setRotation(this.bone36, 0.2182F, -0.6545F, 0.0F);
        this.Wing4.addChild(this.bone36);
        this.bone36.cubeList.add(new ModelBox(this.bone36, 0, 0, -7.8051F, -1.0948F, -0.8175F, 1, 1, 3, 0.0F, true));
        this.bone37 = new MModelRenderer(this);
        this.bone37.setRotationPoint(2.0F, 10.1623F, -1.3379F);
        this.setRotation(this.bone37, 0.2182F, -0.6545F, 0.0F);
        this.Wing4.addChild(this.bone37);
        this.bone37.cubeList.add(new ModelBox(this.bone37, 0, 0, -0.7659F, -10.0664F, 3.4158F, 0, 11, 5, 0.0F, true));
        this.bone38 = new MModelRenderer(this);
        this.bone38.setRotationPoint(-3.75F, -1.5877F, 4.6621F);
        this.setRotation(this.bone38, 0.1851F, -0.6632F, 0.0541F);
        this.Wing4.addChild(this.bone38);
        this.bone38.cubeList.add(new ModelBox(this.bone38, 10, 0, 0.1424F, 0.6171F, -2.1921F, 0, 7, 5, 0.0F, true));
        this.bone39 = new MModelRenderer(this);
        this.bone39.setRotationPoint(0.2F, 3.075F, -0.175F);
        this.bone38.addChild(this.bone39);
        this.bone40 = new MModelRenderer(this);
        this.bone40.setRotationPoint(6.0F, 8.5F, -6.0F);
        this.bone39.addChild(this.bone40);
        this.bone40.cubeList.add(new ModelBox(this.bone40, 0, 26, -6.0F, -9.0F, 4.0F, 0, 1, 4, 0.0F, true));
        this.bone41 = new MModelRenderer(this);
        this.setRotation(this.bone41, -1.5708F, 0.0F, 0.0F);
        this.bone39.addChild(this.bone41);
        this.bone41.cubeList.add(new ModelBox(this.bone41, 0, 26, 0.0F, -0.5F, -2.0F, 0, 1, 4, 0.0F, true));
        this.bone42 = new MModelRenderer(this);
        this.bone42.setRotationPoint(-5.75F, -1.3377F, 8.6621F);
        this.setRotation(this.bone42, 0.1167F, -0.6764F, 0.1641F);
        this.Wing4.addChild(this.bone42);
        this.bone42.cubeList.add(new ModelBox(this.bone42, 10, 12, -0.706F, -0.5773F, -1.4248F, 0, 5, 3, 0.0F, true));
        this.Module = new MModelRenderer(this);
        this.MechanicalWings.addChild(this.Module);
        this.Module.cubeList.add(new ModelBox(this.Module, 16, 15, -1.5F, -12.0F, 2.0F, 3, 4, 1, 0.0F, false));
        this.Module.cubeList.add(new ModelBox(this.Module, 20, 4, -1.5F, -8.0F, 2.0F, 3, 7, 1, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "body/mechanicalwings.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "body/mechanicalwings_animation.json"));
        this.animation = bbanimationloader.mustGet("wings.default", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0D, 0.65D, 0.0D);
        float f = 0.9F;
        GlStateManager.scale(f, f, f);

        if (player.getCurrentArmor(2) != null)
        {
            GlStateManager.translate(0.0D, 0.0D, 0.05D);
        }

        this.animation.tick(time);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0D, 0.7D, 0.2D);
        this.animation.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041c\u0435\u0445\u0430\u043d\u0438\u0447\u0435\u0441\u043a\u0438\u0435 \u043a\u0440\u044b\u043b\u044c\u044f";
    }

    public String getCreator()
    {
        return "Rander_";
    }
}
