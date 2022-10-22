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

public class ButterflyWings extends BaseItem
{
    private final MModelRenderer bone10;
    private final MModelRenderer bone11;
    private final MModelRenderer bone12;
    private final MModelRenderer bone16;
    private final MModelRenderer bone18;
    private final MModelRenderer bone20;
    private final MModelRenderer bone13;
    private final IAnimation animation;
    private final String color;

    public ButterflyWings(String color)
    {
        super(ItemType.BODY);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.color = color;
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(0.0F, 11.25F, 0.0F);
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(0.0F, 2.25F, 12.0F);
        this.setRotation(this.bone11, 0.6109F, 0.0F, 0.0F);
        this.bone10.addChild(this.bone11);
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(-1.0F, -20.0F, 2.0F);
        this.setRotation(this.bone12, -0.3113F, 0.3552F, -0.6554F);
        this.bone11.addChild(this.bone12);
        this.bone12.cubeList.add(new ModelBox(this.bone12, 0, 19, -13.0709F, -5.3803F, 0.5615F, 13, 8, 0, 0.0F, false));
        this.bone16 = new MModelRenderer(this);
        this.bone16.setRotationPoint(-1.0F, -23.2027F, 5.4016F);
        this.setRotation(this.bone16, -0.8432F, -0.098F, -0.6314F);
        this.bone11.addChild(this.bone16);
        this.bone16.cubeList.add(new ModelBox(this.bone16, 0, 0, -8.8864F, -17.2109F, -0.1903F, 11, 19, 0, 0.0F, false));
        this.bone18 = new MModelRenderer(this);
        this.bone18.setRotationPoint(0.0F, 2.25F, 12.0F);
        this.setRotation(this.bone18, 0.6109F, 0.0F, 0.0F);
        this.bone10.addChild(this.bone18);
        this.bone20 = new MModelRenderer(this);
        this.bone20.setRotationPoint(1.0F, -20.0F, 2.0F);
        this.setRotation(this.bone20, -0.3113F, -0.3552F, 0.6554F);
        this.bone18.addChild(this.bone20);
        this.bone20.cubeList.add(new ModelBox(this.bone20, 0, 19, 0.0709F, -5.3803F, 0.5615F, 13, 8, 0, 0.0F, true));
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(1.0F, -23.2027F, 5.4016F);
        this.setRotation(this.bone13, -0.8384F, 0.0427F, 0.6991F);
        this.bone18.addChild(this.bone13);
        this.bone13.cubeList.add(new ModelBox(this.bone13, 0, 0, -2.1136F, -17.2109F, -0.1903F, 11, 19, 0, 0.0F, true));
        super.setTexture(new ResourceLocation("minidot", "body/butterflywings_" + color + ".png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "body/butterflywings_animation.json"));
        this.animation = bbanimationloader.mustGet("butterflywings.animation", this);
    }

    public void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        this.animation.tick(time);
        GlStateManager.translate(0.0D, 1.018D, 0.0D);
    }

    public void renderAsItem(float time)
    {
        this.animation.tick(time);
        GlStateManager.translate(0.0D, 0.55D, 0.1187D);
        double d0 = 0.669D;
        GlStateManager.scale(d0, d0, d0);
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
        String s = this.color;
        byte b0 = -1;

        switch (s.hashCode())
        {
            case -734239628:
                if (s.equals("yellow"))
                {
                    b0 = 1;
                }

                break;

            case 112785:
                if (s.equals("red"))
                {
                    b0 = 0;
                }

                break;

            case 3027034:
                if (s.equals("blue"))
                {
                    b0 = 2;
                }

                break;

            case 98619139:
                if (s.equals("green"))
                {
                    b0 = 3;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u041a\u0440\u0430\u0441\u043d\u044b\u0435 \u043a\u0440\u044b\u043b\u044c\u044f \u0431\u0430\u0431\u043e\u0447\u043a\u0438";

            case 1:
                return "\u0416\u0435\u043b\u0442\u044b\u0435 \u043a\u0440\u044b\u043b\u044c\u044f \u0431\u0430\u0431\u043e\u0447\u043a\u0438";

            case 2:
                return "\u0421\u0438\u043d\u0438\u0435 \u043a\u0440\u044b\u043b\u044c\u044f \u0431\u0430\u0431\u043e\u0447\u043a\u0438";

            case 3:
                return "\u0417\u0435\u043b\u0435\u043d\u044b\u0435 \u043a\u0440\u044b\u043b\u044c\u044f \u0431\u0430\u0431\u043e\u0447\u043a\u0438";

            default:
                return "\u041d\u0435\u043e\u0431\u044b\u0447\u043d\u044b\u0435 \u043a\u0440\u044b\u043b\u044c\u044f \u0431\u0430\u0431\u043e\u0447\u043a\u0438";
        }
    }

    public String getCreator()
    {
        return "Wenston";
    }
}
