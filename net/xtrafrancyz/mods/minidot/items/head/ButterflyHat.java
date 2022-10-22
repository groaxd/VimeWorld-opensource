package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class ButterflyHat extends BaseItem
{
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer bone5;
    private final MModelRenderer bone6;
    private final MModelRenderer bone4;
    private final MModelRenderer bone7;
    private final MModelRenderer bone8;
    private final MModelRenderer bone9;
    private final MModelRenderer bone10;
    private final MModelRenderer bone11;
    private final MModelRenderer bone12;
    private final MModelRenderer bone13;
    private final MModelRenderer bone14;
    private final MModelRenderer bone15;
    private final IAnimation animation;
    private final String color;

    public ButterflyHat(String color)
    {
        super(ItemType.HEAD);
        this.textureWidth = 16;
        this.textureHeight = 16;
        this.color = color;
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.2F, -8.1F, 4.2F);
        this.setRotation(this.bone, 0.3927F, 0.0F, 0.0F);
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 0, -0.7F, -3.2547F, -0.3198F, 5, 6, 1, -0.5F, true));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-0.25F, -8.0F, 4.5F);
        this.setRotation(this.bone2, 0.3927F, 0.0F, 0.0F);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 0, -4.25F, -3.4619F, -0.5587F, 5, 6, 1, -0.5F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(-2.0F, -8.5F, 4.5F);
        this.setRotation(this.bone3, 0.3927F, 0.0F, 0.0F);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 7, 1.0F, -1.6F, -0.75F, 2, 4, 1, -0.7F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(-9.5F, -7.0F, 0.5F);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 5, 11, -0.5F, -0.9F, -0.5F, 1, 2, 1, -0.3F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone5.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 6, 7, -1.5F, -1.5F, -0.5F, 2, 3, 1, -0.5F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone5.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 6, 7, -0.5F, -1.5F, -0.5F, 2, 3, 1, -0.5F, true));
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(10.5F, -9.0F, -5.1F);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 5, 11, -0.5F, -0.9F, -0.5F, 1, 2, 1, -0.3F, false));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(0.0F, 0.0F, 0.1F);
        this.bone7.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 6, 7, -1.5F, -1.5F, -0.6F, 2, 3, 1, -0.5F, false));
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(0.0F, 0.0F, 0.1F);
        this.bone7.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 6, 7, -0.5F, -1.5F, -0.6F, 2, 3, 1, -0.5F, true));
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(6.5F, -5.0F, 6.5F);
        this.bone10.cubeList.add(new ModelBox(this.bone10, 5, 11, -0.5F, -0.9F, -0.5F, 1, 2, 1, -0.3F, false));
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone10.addChild(this.bone11);
        this.bone11.cubeList.add(new ModelBox(this.bone11, 6, 7, -1.5F, -1.5F, -0.5F, 2, 3, 1, -0.5F, false));
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone10.addChild(this.bone12);
        this.bone12.cubeList.add(new ModelBox(this.bone12, 6, 7, -0.5F, -1.5F, -0.5F, 2, 3, 1, -0.5F, true));
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(-9.5F, -2.0F, -7.5F);
        this.bone13.cubeList.add(new ModelBox(this.bone13, 5, 11, -0.5F, -0.9F, -0.5F, 1, 2, 1, -0.3F, false));
        this.bone14 = new MModelRenderer(this);
        this.bone14.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone13.addChild(this.bone14);
        this.bone14.cubeList.add(new ModelBox(this.bone14, 6, 7, -1.5F, -1.5F, -0.5F, 2, 3, 1, -0.5F, false));
        this.bone15 = new MModelRenderer(this);
        this.bone15.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone13.addChild(this.bone15);
        this.bone15.cubeList.add(new ModelBox(this.bone15, 6, 7, -0.5F, -1.5F, -0.5F, 2, 3, 1, -0.5F, true));
        super.setTexture(new ResourceLocation("minidot", "head/butterflyhat_" + color + ".png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "head/butterflyhat_animation.json"));
        this.animation = bbanimationloader.mustGet("butterflyhat.animation", this);
    }

    public void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        this.animation.tick(time);
    }

    public void renderAsItem(float time)
    {
        this.animation.tick(time);
        GlStateManager.translate(0.0F, 0.0F, 0.0F);
        double d0 = 0.65D;
        GlStateManager.scale(d0, d0, d0);
        super.renderAsItem(time);
    }

    public void itemMotion(float rotation, int number)
    {
        GlStateManager.rotate(180.0F + MathHelper.sin(rotation * 0.06F + (float)number * 0.5F) * 20.0F, 0.0F, 0.2F, 0.0F);
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
            case -976943172:
                if (s.equals("purple"))
                {
                    b0 = 2;
                }

                break;

            case 112785:
                if (s.equals("red"))
                {
                    b0 = 3;
                }

                break;

            case 3002044:
                if (s.equals("aqua"))
                {
                    b0 = 0;
                }

                break;

            case 93818879:
                if (s.equals("black"))
                {
                    b0 = 1;
                }

                break;

            case 113101865:
                if (s.equals("white"))
                {
                    b0 = 4;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u0413\u043e\u043b\u0443\u0431\u044b\u0435 \u0431\u0430\u0431\u043e\u0447\u043a\u0438";

            case 1:
                return "\u0427\u0435\u0440\u043d\u044b\u0435 \u0431\u0430\u0431\u043e\u0447\u043a\u0438";

            case 2:
                return "\u0424\u0438\u043e\u043b\u0435\u0442\u043e\u0432\u044b\u0435 \u0431\u0430\u0431\u043e\u0447\u043a\u0438";

            case 3:
                return "\u041a\u0440\u0430\u0441\u043d\u044b\u0435 \u0431\u0430\u0431\u043e\u0447\u043a\u0438";

            case 4:
                return "\u0411\u0435\u043b\u044b\u0435 \u0431\u0430\u0431\u043e\u0447\u043a\u0438";

            default:
                return "\u0421\u0442\u0440\u0430\u043d\u043d\u044b\u0435 \u0431\u0430\u0431\u043e\u0447\u043a\u0438";
        }
    }

    public String getCreator()
    {
        return "Ceme4ka7";
    }
}
