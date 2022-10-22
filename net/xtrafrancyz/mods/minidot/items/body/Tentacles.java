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

public class Tentacles extends BaseItem
{
    private final MModelRenderer octopus_tentacles;
    private final MModelRenderer tentacles_body;
    private final MModelRenderer tentacle_left_1_part_1;
    private final MModelRenderer tentacle_left_1_part_2;
    private final MModelRenderer tentacle_left_1_part_3;
    private final MModelRenderer tentacle_right_1_part_1;
    private final MModelRenderer tentacle_right_1_part_2;
    private final MModelRenderer tentacle_right_1_part_3;
    private final MModelRenderer tentacle_left_2_part_1;
    private final MModelRenderer tentacle_left_2_part_2;
    private final MModelRenderer tentacle_left_2_part_3;
    private final MModelRenderer tentacle_right_2_part_1;
    private final MModelRenderer tentacle_right_2_part_2;
    private final MModelRenderer tentacle_right_2_part_3;
    private final MModelRenderer tentacle_left_3_part_1;
    private final MModelRenderer tentacle_left_3_part_2;
    private final MModelRenderer tentacle_left_3_part_3;
    private final MModelRenderer tentacle_right_3_part_1;
    private final MModelRenderer tentacle_right_3_part_2;
    private final MModelRenderer tentacle_right_3_part_3;
    private final IAnimation animation;
    private final String color;

    public Tentacles(String color)
    {
        super(ItemType.BODY);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.color = color;
        this.octopus_tentacles = new MModelRenderer(this);
        this.tentacles_body = new MModelRenderer(this);
        this.tentacles_body.setRotationPoint(0.0F, -12.0F, 0.0F);
        this.octopus_tentacles.addChild(this.tentacles_body);
        this.tentacle_left_1_part_1 = new MModelRenderer(this);
        this.tentacle_left_1_part_1.setRotationPoint(2.0F, -9.5F, 2.0F);
        this.setRotation(this.tentacle_left_1_part_1, 0.5208F, -0.6178F, -0.7805F);
        this.tentacles_body.addChild(this.tentacle_left_1_part_1);
        this.tentacle_left_1_part_1.cubeList.add(new ModelBox(this.tentacle_left_1_part_1, 28, 18, -0.4264F, -2.3192F, -3.0F, 12, 3, 3, 0.0F, true));
        this.tentacle_left_1_part_2 = new MModelRenderer(this);
        this.tentacle_left_1_part_2.setRotationPoint(10.0F, 0.0F, -1.5F);
        this.setRotation(this.tentacle_left_1_part_2, -0.4193F, 0.0881F, -0.7693F);
        this.tentacle_left_1_part_1.addChild(this.tentacle_left_1_part_2);
        this.tentacle_left_1_part_2.cubeList.add(new ModelBox(this.tentacle_left_1_part_2, 26, 30, 0.9781F, -1.2082F, -0.9982F, 11, 2, 2, 0.0F, true));
        this.tentacle_left_1_part_3 = new MModelRenderer(this);
        this.tentacle_left_1_part_3.setRotationPoint(10.0F, 0.0F, 0.0F);
        this.setRotation(this.tentacle_left_1_part_3, 0.0F, 0.0F, 0.5672F);
        this.tentacle_left_1_part_2.addChild(this.tentacle_left_1_part_3);
        this.tentacle_left_1_part_3.cubeList.add(new ModelBox(this.tentacle_left_1_part_3, 0, 0, -0.2869F, -6.2011F, 0.0018F, 16, 11, 0, 0.0F, true));
        this.tentacle_right_1_part_1 = new MModelRenderer(this);
        this.tentacle_right_1_part_1.setRotationPoint(-2.0F, -9.5F, 2.0F);
        this.setRotation(this.tentacle_right_1_part_1, 0.5208F, 0.6178F, 0.7805F);
        this.tentacles_body.addChild(this.tentacle_right_1_part_1);
        this.tentacle_right_1_part_1.cubeList.add(new ModelBox(this.tentacle_right_1_part_1, 28, 18, -11.5736F, -2.3192F, -3.0F, 12, 3, 3, 0.0F, false));
        this.tentacle_right_1_part_2 = new MModelRenderer(this);
        this.tentacle_right_1_part_2.setRotationPoint(-10.0F, 0.0F, -1.5F);
        this.setRotation(this.tentacle_right_1_part_2, -0.4193F, -0.0881F, 0.7693F);
        this.tentacle_right_1_part_1.addChild(this.tentacle_right_1_part_2);
        this.tentacle_right_1_part_2.cubeList.add(new ModelBox(this.tentacle_right_1_part_2, 26, 30, -11.9781F, -1.2082F, -0.9982F, 11, 2, 2, 0.0F, false));
        this.tentacle_right_1_part_3 = new MModelRenderer(this);
        this.tentacle_right_1_part_3.setRotationPoint(-10.0F, 0.0F, 0.0F);
        this.setRotation(this.tentacle_right_1_part_3, 0.0F, 0.0F, -0.5672F);
        this.tentacle_right_1_part_2.addChild(this.tentacle_right_1_part_3);
        this.tentacle_right_1_part_3.cubeList.add(new ModelBox(this.tentacle_right_1_part_3, 0, 0, -15.7131F, -6.3011F, 0.0018F, 16, 11, 0, 0.0F, false));
        this.tentacle_left_2_part_1 = new MModelRenderer(this);
        this.tentacle_left_2_part_1.setRotationPoint(2.0F, -8.5F, 2.0F);
        this.setRotation(this.tentacle_left_2_part_1, -0.0503F, -0.5214F, 0.1007F);
        this.tentacles_body.addChild(this.tentacle_left_2_part_1);
        this.tentacle_left_2_part_1.cubeList.add(new ModelBox(this.tentacle_left_2_part_1, 28, 24, -1.0F, -1.5F, -3.0F, 11, 3, 3, 0.01F, true));
        this.tentacle_left_2_part_2 = new MModelRenderer(this);
        this.tentacle_left_2_part_2.setRotationPoint(10.0F, 0.0F, -1.5F);
        this.setRotation(this.tentacle_left_2_part_2, -0.2393F, 0.4703F, -1.1484F);
        this.tentacle_left_2_part_1.addChild(this.tentacle_left_2_part_2);
        this.tentacle_left_2_part_2.cubeList.add(new ModelBox(this.tentacle_left_2_part_2, 30, 14, 0.0F, -1.0F, -1.0F, 11, 2, 2, 0.0F, true));
        this.tentacle_left_2_part_3 = new MModelRenderer(this);
        this.tentacle_left_2_part_3.setRotationPoint(10.0F, 0.0F, 0.0F);
        this.setRotation(this.tentacle_left_2_part_3, 0.0F, 0.3927F, 0.5672F);
        this.tentacle_left_2_part_2.addChild(this.tentacle_left_2_part_3);
        this.tentacle_left_2_part_3.cubeList.add(new ModelBox(this.tentacle_left_2_part_3, 0, 11, -2.0F, -5.0F, 0.0F, 15, 10, 0, 0.0F, true));
        this.tentacle_right_2_part_1 = new MModelRenderer(this);
        this.tentacle_right_2_part_1.setRotationPoint(-2.0F, -8.5F, 2.0F);
        this.setRotation(this.tentacle_right_2_part_1, -0.0503F, 0.5214F, -0.1007F);
        this.tentacles_body.addChild(this.tentacle_right_2_part_1);
        this.tentacle_right_2_part_1.cubeList.add(new ModelBox(this.tentacle_right_2_part_1, 28, 24, -10.0F, -1.5F, -3.0F, 11, 3, 3, 0.01F, false));
        this.tentacle_right_2_part_2 = new MModelRenderer(this);
        this.tentacle_right_2_part_2.setRotationPoint(-10.0F, 0.0F, -1.5F);
        this.setRotation(this.tentacle_right_2_part_2, -0.2393F, -0.4703F, 1.1484F);
        this.tentacle_right_2_part_1.addChild(this.tentacle_right_2_part_2);
        this.tentacle_right_2_part_2.cubeList.add(new ModelBox(this.tentacle_right_2_part_2, 30, 14, -11.0F, -1.0F, -1.0F, 11, 2, 2, 0.0F, false));
        this.tentacle_right_2_part_3 = new MModelRenderer(this);
        this.tentacle_right_2_part_3.setRotationPoint(-10.0F, 0.0F, 0.0F);
        this.setRotation(this.tentacle_right_2_part_3, 0.0F, -0.3927F, -0.5672F);
        this.tentacle_right_2_part_2.addChild(this.tentacle_right_2_part_3);
        this.tentacle_right_2_part_3.cubeList.add(new ModelBox(this.tentacle_right_2_part_3, 0, 11, -13.0F, -5.0F, 0.0F, 15, 10, 0, 0.0F, false));
        this.tentacle_left_3_part_1 = new MModelRenderer(this);
        this.tentacle_left_3_part_1.setRotationPoint(2.0F, -6.5F, 2.0F);
        this.setRotation(this.tentacle_left_3_part_1, -0.4995F, -0.6925F, 0.7072F);
        this.tentacles_body.addChild(this.tentacle_left_3_part_1);
        this.tentacle_left_3_part_1.cubeList.add(new ModelBox(this.tentacle_left_3_part_1, 30, 8, -1.0F, -1.5F, -3.0F, 9, 3, 3, 0.0F, true));
        this.tentacle_left_3_part_2 = new MModelRenderer(this);
        this.tentacle_left_3_part_2.setRotationPoint(8.0F, 0.0F, -1.5F);
        this.setRotation(this.tentacle_left_3_part_2, 0.2666F, 0.7541F, -0.0571F);
        this.tentacle_left_3_part_1.addChild(this.tentacle_left_3_part_2);
        this.tentacle_left_3_part_2.cubeList.add(new ModelBox(this.tentacle_left_3_part_2, 0, 31, 0.0F, -1.0F, -1.0F, 9, 2, 2, 0.0F, true));
        this.tentacle_left_3_part_3 = new MModelRenderer(this);
        this.tentacle_left_3_part_3.setRotationPoint(8.0F, 0.0F, 0.0F);
        this.setRotation(this.tentacle_left_3_part_3, 0.1617F, -0.2068F, -0.6713F);
        this.tentacle_left_3_part_2.addChild(this.tentacle_left_3_part_3);
        this.tentacle_left_3_part_3.cubeList.add(new ModelBox(this.tentacle_left_3_part_3, 0, 21, -1.0F, -5.0F, 0.0F, 14, 10, 0, 0.0F, true));
        this.tentacle_right_3_part_1 = new MModelRenderer(this);
        this.tentacle_right_3_part_1.setRotationPoint(-2.0F, -6.5F, 2.0F);
        this.setRotation(this.tentacle_right_3_part_1, -0.4995F, 0.6925F, -0.7072F);
        this.tentacles_body.addChild(this.tentacle_right_3_part_1);
        this.tentacle_right_3_part_1.cubeList.add(new ModelBox(this.tentacle_right_3_part_1, 30, 8, -8.0F, -1.5F, -3.0F, 9, 3, 3, 0.0F, false));
        this.tentacle_right_3_part_2 = new MModelRenderer(this);
        this.tentacle_right_3_part_2.setRotationPoint(-8.0F, 0.0F, -1.5F);
        this.setRotation(this.tentacle_right_3_part_2, 0.2666F, -0.7541F, 0.0571F);
        this.tentacle_right_3_part_1.addChild(this.tentacle_right_3_part_2);
        this.tentacle_right_3_part_2.cubeList.add(new ModelBox(this.tentacle_right_3_part_2, 0, 31, -9.0F, -1.0F, -1.0F, 9, 2, 2, 0.0F, false));
        this.tentacle_right_3_part_3 = new MModelRenderer(this);
        this.tentacle_right_3_part_3.setRotationPoint(-8.0F, 0.0F, 0.0F);
        this.setRotation(this.tentacle_right_3_part_3, 0.1617F, 0.2068F, 0.6713F);
        this.tentacle_right_3_part_2.addChild(this.tentacle_right_3_part_3);
        this.tentacle_right_3_part_3.cubeList.add(new ModelBox(this.tentacle_right_3_part_3, 0, 21, -13.0F, -5.0F, 0.0F, 14, 10, 0, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "body/tentacles_" + color + ".png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "body/tentacles_animation.json"));
        this.animation = bbanimationloader.mustGet("tentacles.animation", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        this.animation.tick(time);
        GlStateManager.translate(0.0D, 1.18D, 0.085D);
        double d0 = 0.6D;
        GlStateManager.scale(d0, d0, d0);
    }

    public void renderAsItem(float time)
    {
        this.animation.tick(time);
        double d0 = 0.3873D;
        GlStateManager.scale(d0, d0, d0);
        GlStateManager.translate(0.0D, 1.5118D, 0.26614D);
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
            case -1008851410:
                if (s.equals("orange"))
                {
                    b0 = 1;
                }

                break;

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
        }

        switch (b0)
        {
            case 0:
                return "\u0413\u043e\u043b\u0443\u0431\u044b\u0435 \u0449\u0443\u043f\u0430\u043b\u044c\u0446\u0430";

            case 1:
                return "\u041e\u0440\u0430\u043d\u0436\u0435\u0432\u044b\u0435 \u0449\u0443\u043f\u0430\u043b\u044c\u0446\u0430";

            case 2:
                return "\u0424\u0438\u043e\u043b\u0435\u0442\u043e\u0432\u044b\u0435 \u0449\u0443\u043f\u0430\u043b\u044c\u0446\u0430";

            case 3:
                return "\u041a\u0440\u0430\u0441\u043d\u044b\u0435 \u0449\u0443\u043f\u0430\u043b\u044c\u0446\u0430";

            default:
                return "\u0421\u0442\u0440\u0430\u043d\u043d\u044b\u0435 \u0449\u0443\u043f\u0430\u043b\u044c\u0446\u0430";
        }
    }

    public String getCreator()
    {
        return "Wenston";
    }
}
