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

public class GrisSkelly extends BasePet
{
    private final MModelRenderer nogi;
    private final MModelRenderer bone18;
    private final MModelRenderer bone19;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer list;
    private final MModelRenderer bone21;
    private final MModelRenderer bone17;
    private final MModelRenderer bone22;
    private final MModelRenderer bone16;
    private final MModelRenderer bone10;
    private final MModelRenderer bone11;
    private final MModelRenderer bone13;
    private final MModelRenderer bone9;
    private final MModelRenderer bone14;
    private final MModelRenderer bone15;
    private final MModelRenderer bone12;
    private final MModelRenderer apple;
    private final MModelRenderer bone6;
    private final MModelRenderer bone8;
    private final MModelRenderer bone7;
    private final MModelRenderer hand;
    private final MModelRenderer bone4;
    private final MModelRenderer bone20;
    private final MModelRenderer bone3;
    private final MModelRenderer bone5;
    private final MModelRenderer eyes;
    private final MModelRenderer telo;
    private final MModelRenderer head;
    private final MModelRenderer grib;
    private final MModelRenderer bone24;
    private final MModelRenderer bone26;
    private final MModelRenderer bone23;
    private final MModelRenderer bone25;
    private final IAnimation animation;

    public GrisSkelly()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.nogi = new MModelRenderer(this);
        this.bone18 = new MModelRenderer(this);
        this.nogi.addChild(this.bone18);
        this.bone18.cubeList.add(new ModelBox(this.bone18, 30, 18, -1.5F, -4.0F, -2.75F, 1, 4, 1, 0.0F, false));
        this.bone19 = new MModelRenderer(this);
        this.nogi.addChild(this.bone19);
        this.bone19.cubeList.add(new ModelBox(this.bone19, 9, 30, -1.5F, -4.0F, 0.5F, 1, 4, 1, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(-0.5F, 0.0F, -1.0F);
        this.setRotation(this.bone, 0.0436F, 0.0019F, -0.0436F);
        this.nogi.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 4, 31, -0.8314F, -5.8617F, 1.6716F, 1, 2, 1, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.0F, 0.0F, 0.25F);
        this.setRotation(this.bone2, -0.1745F, 0.0F, 0.0F);
        this.nogi.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 13, 31, -1.5F, -5.4183F, -3.649F, 1, 2, 1, 1.0E-4F, false));
        this.list = new MModelRenderer(this);
        this.list.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.list.cubeList.add(new ModelBox(this.list, 30, 27, -1.75F, -26.5F, -4.0F, 1, 2, 1, -0.2F, false));
        this.list.cubeList.add(new ModelBox(this.list, 31, 7, -1.75F, -20.0F, -4.0F, 1, 1, 1, 0.0F, false));
        this.bone21 = new MModelRenderer(this);
        this.list.addChild(this.bone21);
        this.bone21.cubeList.add(new ModelBox(this.bone21, 0, 16, -1.25F, -22.5F, -2.0F, 0, 2, 2, 0.0F, false));
        this.bone17 = new MModelRenderer(this);
        this.bone17.setRotationPoint(0.0F, 0.0F, -3.5F);
        this.setRotation(this.bone17, -0.1309F, 0.0F, 0.0F);
        this.list.addChild(this.bone17);
        this.bone17.cubeList.add(new ModelBox(this.bone17, 4, 2, -1.25F, -27.0F, -2.0F, 0, 2, 2, 0.0F, false));
        this.bone22 = new MModelRenderer(this);
        this.list.addChild(this.bone22);
        this.bone22.cubeList.add(new ModelBox(this.bone22, 4, 5, -1.25F, -23.75F, -7.5F, 0, 2, 2, 0.0F, false));
        this.bone16 = new MModelRenderer(this);
        this.bone16.setRotationPoint(0.0F, -2.5F, -14.5F);
        this.setRotation(this.bone16, -0.5672F, 0.0F, 0.0F);
        this.list.addChild(this.bone16);
        this.bone16.cubeList.add(new ModelBox(this.bone16, 0, 5, -1.25F, -27.5F, -5.0F, 0, 2, 2, 0.0F, false));
        this.bone10 = new MModelRenderer(this);
        this.setRotation(this.bone10, -0.0873F, 0.0F, 0.0F);
        this.list.addChild(this.bone10);
        this.bone10.cubeList.add(new ModelBox(this.bone10, 21, 30, -1.75F, -24.3986F, -6.1409F, 1, 3, 1, 0.0F, false));
        this.bone11 = new MModelRenderer(this);
        this.setRotation(this.bone11, 0.6109F, 0.0F, 0.0F);
        this.list.addChild(this.bone11);
        this.bone11.cubeList.add(new ModelBox(this.bone11, 0, 0, -1.8F, -22.2949F, 10.295F, 1, 1, 3, -0.3F, false));
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(0.0F, -5.0F, 11.25F);
        this.setRotation(this.bone13, 0.6545F, 0.0F, 0.0F);
        this.list.addChild(this.bone13);
        this.bone13.cubeList.add(new ModelBox(this.bone13, 12, 18, -1.75F, -21.0F, -2.0F, 1, 1, 2, -0.3F, false));
        this.bone9 = new MModelRenderer(this);
        this.setRotation(this.bone9, 0.1309F, 0.0F, 0.0F);
        this.list.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 0, 31, -1.75F, -22.2205F, -1.3638F, 1, 2, 1, 0.0F, false));
        this.bone14 = new MModelRenderer(this);
        this.bone14.setRotationPoint(0.0F, 0.0F, -1.75F);
        this.setRotation(this.bone14, -0.0873F, 0.0F, 0.0F);
        this.list.addChild(this.bone14);
        this.bone14.cubeList.add(new ModelBox(this.bone14, 27, 7, -1.75F, -22.0F, -5.0F, 1, 1, 1, -0.2F, false));
        this.bone15 = new MModelRenderer(this);
        this.bone15.setRotationPoint(0.0F, 0.75F, -3.25F);
        this.setRotation(this.bone15, -0.1745F, 0.0F, 0.0F);
        this.list.addChild(this.bone15);
        this.bone15.cubeList.add(new ModelBox(this.bone15, 0, 4, -1.75F, -22.5F, -7.0F, 1, 1, 2, -0.3F, false));
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(0.0F, -0.5F, 3.25F);
        this.setRotation(this.bone12, 0.1745F, 0.0F, 0.0F);
        this.list.addChild(this.bone12);
        this.bone12.cubeList.add(new ModelBox(this.bone12, 31, 4, -1.75F, -21.0F, -3.0F, 1, 1, 1, -0.2F, false));
        this.apple = new MModelRenderer(this);
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(0.0F, -0.5F, -0.75F);
        this.setRotation(this.bone6, -0.0873F, 0.0F, 0.0F);
        this.apple.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 16, 18, -0.25F, -11.0F, 5.0F, 3, 3, 3, 0.0F, false));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(13.25F, -5.75F, 5.25F);
        this.setRotation(this.bone8, 0.4636F, -1.0986F, -1.1286F);
        this.apple.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 0, 0, 1.0F, -12.0F, 7.0F, 1, 1, 0, 0.0F, false));
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(-0.25F, -11.0F, -6.75F);
        this.setRotation(this.bone7, -1.0865F, -0.0671F, -0.6896F);
        this.apple.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 0, 0, 1.75F, -12.0F, 6.0F, 0, 1, 1, 0.0F, false));
        this.hand = new MModelRenderer(this);
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(-0.5F, 0.0F, -0.75F);
        this.setRotation(this.bone4, -0.0436F, 0.1745F, 0.0F);
        this.hand.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 27, 4, -1.5F, -9.5F, 2.5F, 1, 1, 2, 0.0F, false));
        this.bone20 = new MModelRenderer(this);
        this.hand.addChild(this.bone20);
        this.bone20.cubeList.add(new ModelBox(this.bone20, 26, 28, -1.5F, -9.5F, -5.5F, 1, 1, 2, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.setRotation(this.bone3, -0.1745F, 0.0F, 0.0F);
        this.hand.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 22, 27, -1.5F, -8.4158F, -8.6425F, 1, 1, 2, -0.1F, false));
        this.bone5 = new MModelRenderer(this);
        this.setRotation(this.bone5, -0.2765F, 0.5875F, -0.1533F);
        this.hand.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 18, 24, -2.2622F, -10.0533F, 0.9889F, 1, 1, 2, -0.1F, false));
        this.eyes = new MModelRenderer(this);
        this.eyes.cubeList.add(new ModelBox(this.eyes, 25, 18, 2.75F, -13.5F, 1.5F, 1, 1, 1, 0.0F, false));
        this.eyes.cubeList.add(new ModelBox(this.eyes, 0, 20, 2.75F, -13.5F, -3.5F, 1, 1, 1, 0.0F, false));
        this.telo = new MModelRenderer(this);
        this.telo.cubeList.add(new ModelBox(this.telo, 17, 31, -1.5F, -11.75F, -1.0F, 1, 1, 1, 0.0F, false));
        this.telo.cubeList.add(new ModelBox(this.telo, 0, 18, -3.0F, -10.75F, -2.5F, 4, 5, 4, 0.0F, false));
        this.telo.cubeList.add(new ModelBox(this.telo, 24, 20, 1.0F, -9.75F, -2.5F, 1, 3, 4, 0.0F, false));
        this.telo.cubeList.add(new ModelBox(this.telo, 27, 0, -3.0F, -9.75F, -3.5F, 4, 3, 1, 0.0F, false));
        this.telo.cubeList.add(new ModelBox(this.telo, 0, 27, -3.0F, -9.75F, 1.5F, 4, 3, 1, 0.0F, false));
        this.telo.cubeList.add(new ModelBox(this.telo, 12, 24, -4.0F, -9.75F, -2.5F, 1, 3, 4, 0.0F, false));
        this.head = new MModelRenderer(this);
        this.head.cubeList.add(new ModelBox(this.head, 0, 0, -5.5F, -20.0F, -5.0F, 9, 9, 9, 0.0F, false));
        this.grib = new MModelRenderer(this);
        this.bone24 = new MModelRenderer(this);
        this.bone24.setRotationPoint(-3.0F, 0.0F, -1.75F);
        this.setRotation(this.bone24, 0.0F, 0.6109F, 0.0F);
        this.grib.addChild(this.bone24);
        this.bone24.cubeList.add(new ModelBox(this.bone24, 28, 38, -3.0F, -21.0F, 2.5F, 1, 1, 1, -0.3F, false));
        this.bone24.cubeList.add(new ModelBox(this.bone24, 34, 38, -3.0F, -21.17F, 2.5F, 1, 1, 1, -0.4F, false));
        this.bone24.cubeList.add(new ModelBox(this.bone24, 14, 36, -3.0F, -21.0F, 2.5F, 1, 2, 1, -0.4F, false));
        this.bone26 = new MModelRenderer(this);
        this.bone26.setRotationPoint(-0.25F, 0.0F, -0.75F);
        this.setRotation(this.bone26, 0.0F, -0.3491F, 0.0F);
        this.grib.addChild(this.bone26);
        this.bone26.cubeList.add(new ModelBox(this.bone26, 28, 38, -1.0F, -21.0F, -0.25F, 1, 1, 1, -0.3F, false));
        this.bone26.cubeList.add(new ModelBox(this.bone26, 14, 36, -1.0F, -21.0F, -0.25F, 1, 2, 1, -0.4F, false));
        this.bone26.cubeList.add(new ModelBox(this.bone26, 34, 38, -1.0F, -21.17F, -0.25F, 1, 1, 1, -0.4F, false));
        this.bone23 = new MModelRenderer(this);
        this.bone23.setRotationPoint(-0.75F, 0.0F, 2.0F);
        this.setRotation(this.bone23, 0.0F, -0.6109F, 0.0F);
        this.grib.addChild(this.bone23);
        this.bone23.cubeList.add(new ModelBox(this.bone23, 39, 34, -4.5F, -21.5F, -1.5F, 2, 1, 2, -0.4F, false));
        this.bone23.cubeList.add(new ModelBox(this.bone23, 29, 34, -4.0F, -21.56F, -1.0F, 1, 1, 1, -0.35F, false));
        this.bone23.cubeList.add(new ModelBox(this.bone23, 21, 36, -4.0F, -21.5F, -1.0F, 1, 2, 1, -0.4F, false));
        this.bone25 = new MModelRenderer(this);
        this.bone25.setRotationPoint(0.5F, 0.0F, 0.0F);
        this.setRotation(this.bone25, 0.0F, 0.1745F, 0.0F);
        this.grib.addChild(this.bone25);
        this.bone25.cubeList.add(new ModelBox(this.bone25, 39, 34, -0.25F, -21.5F, 1.0F, 2, 1, 2, -0.4F, false));
        this.bone25.cubeList.add(new ModelBox(this.bone25, 21, 36, 0.25F, -21.5F, 1.5F, 1, 2, 1, -0.4F, false));
        this.bone25.cubeList.add(new ModelBox(this.bone25, 29, 34, 0.25F, -21.56F, 1.5F, 1, 1, 1, -0.35F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/grisskelly.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/grisskelly_animation.json"));
        this.animation = bbanimationloader.mustGet("skelly.default", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.translate(0.6D, 0.0D, 0.3D);
        double d0 = (double)MathHelper.sin(time * 0.1F) * 0.03D;
        GlStateManager.translate(0.0D, d0, 0.0D);
        this.animation.tick(time);
        super.preRender(modelPlayer, player, time, pi);
        double d1 = 0.9D;
        GlStateManager.scale(d1, d1, d1);
        GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0D, 0.4D, 0.0D);
        double d0 = 0.9D;
        GlStateManager.scale(d0, d0, d0);
        this.animation.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0421\u043a\u0435\u043b\u043b\u0438";
    }

    public String getCreator()
    {
        return "Florina";
    }

    public List<String> getDescription()
    {
        return MNaming.fromGame("Gris");
    }
}
