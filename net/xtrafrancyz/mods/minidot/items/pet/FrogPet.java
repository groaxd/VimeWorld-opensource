package net.xtrafrancyz.mods.minidot.items.pet;

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

public class FrogPet extends BasePet
{
    private final MModelRenderer Frog119;
    private final MModelRenderer frog;
    private final MModelRenderer tongue;
    private final MModelRenderer mouth;
    private final MModelRenderer upperHead;
    private final MModelRenderer eyes;
    private final MModelRenderer Legs;
    private final MModelRenderer frogleg_left_back;
    private final MModelRenderer frogleg_right_back;
    private final MModelRenderer frogleg_right;
    private final MModelRenderer frogleg_left;
    private final MModelRenderer firefly;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final MModelRenderer bone6;
    private final MModelRenderer bone7;
    private final MModelRenderer bone8;
    private final IAnimation animation;
    private final String color;

    public FrogPet(String color)
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.color = color;
        this.Frog119 = new MModelRenderer(this);
        this.frog = new MModelRenderer(this);
        this.Frog119.addChild(this.frog);
        this.frog.cubeList.add(new ModelBox(this.frog, 0, 9, -4.0F, -3.25F, -3.0F, 7, 2, 6, 0.0F, false));
        this.frog.cubeList.add(new ModelBox(this.frog, 0, 0, -4.0F, -4.25F, -4.0F, 2, 1, 1, 0.0F, false));
        this.frog.cubeList.add(new ModelBox(this.frog, 0, 2, 1.0F, -4.25F, -4.0F, 2, 1, 1, 0.0F, false));
        this.tongue = new MModelRenderer(this);
        this.tongue.setRotationPoint(-0.5F, -3.25F, 2.0F);
        this.frog.addChild(this.tongue);
        this.tongue.cubeList.add(new ModelBox(this.tongue, 24, 0, -1.5F, 0.0F, -2.0F, 3, 0, 2, 0.0F, false));
        this.mouth = new MModelRenderer(this);
        this.mouth.setRotationPoint(-0.5F, -2.25F, -3.5F);
        this.frog.addChild(this.mouth);
        this.mouth.cubeList.add(new ModelBox(this.mouth, 16, 17, -3.5F, -1.0F, -0.5F, 7, 2, 1, 0.0F, false));
        this.upperHead = new MModelRenderer(this);
        this.upperHead.setRotationPoint(-0.5F, -3.25F, 3.0F);
        this.frog.addChild(this.upperHead);
        this.upperHead.cubeList.add(new ModelBox(this.upperHead, 0, 0, -3.5F, -3.0F, -6.0F, 7, 3, 6, 0.0F, false));
        this.upperHead.cubeList.add(new ModelBox(this.upperHead, 0, 17, -3.5F, -3.0F, -7.0F, 7, 2, 1, 0.0F, false));
        this.upperHead.cubeList.add(new ModelBox(this.upperHead, 22, 25, -1.5F, -1.0F, -7.0F, 3, 1, 1, 0.0F, false));
        this.eyes = new MModelRenderer(this);
        this.eyes.setRotationPoint(0.0F, -2.25F, -5.5F);
        this.upperHead.addChild(this.eyes);
        this.eyes.cubeList.add(new ModelBox(this.eyes, 10, 20, 0.5F, -2.75F, -1.0F, 3, 2, 2, 0.0F, false));
        this.eyes.cubeList.add(new ModelBox(this.eyes, 0, 20, -3.5F, -2.75F, -1.0F, 3, 2, 2, 0.0F, false));
        this.Legs = new MModelRenderer(this);
        this.frog.addChild(this.Legs);
        this.frogleg_left_back = new MModelRenderer(this);
        this.frogleg_left_back.setRotationPoint(3.0F, -2.75F, 2.75F);
        this.Legs.addChild(this.frogleg_left_back);
        this.frogleg_left_back.cubeList.add(new ModelBox(this.frogleg_left_back, 8, 24, -0.5F, -0.5F, -1.0F, 2, 3, 2, 0.0F, false));
        this.frogleg_left_back.cubeList.add(new ModelBox(this.frogleg_left_back, 17, 9, 0.5F, 2.5F, -2.0F, 3, 0, 3, 0.0F, false));
        this.frogleg_right_back = new MModelRenderer(this);
        this.frogleg_right_back.setRotationPoint(-4.0F, -2.75F, 2.75F);
        this.Legs.addChild(this.frogleg_right_back);
        this.frogleg_right_back.cubeList.add(new ModelBox(this.frogleg_right_back, 0, 24, -1.5F, -0.5F, -1.0F, 2, 3, 2, 0.0F, false));
        this.frogleg_right_back.cubeList.add(new ModelBox(this.frogleg_right_back, 17, 3, -3.5F, 2.5F, -2.0F, 3, 0, 3, 0.0F, false));
        this.frogleg_right = new MModelRenderer(this);
        this.frogleg_right.setRotationPoint(-4.0F, -2.75F, -2.75F);
        this.Legs.addChild(this.frogleg_right);
        this.frogleg_right.cubeList.add(new ModelBox(this.frogleg_right, 16, 25, -1.5F, -0.5F, -1.0F, 2, 3, 2, 0.0F, false));
        this.frogleg_right.cubeList.add(new ModelBox(this.frogleg_right, 17, 12, -0.5F, 2.5F, -2.0F, 3, 0, 3, 0.0F, false));
        this.frogleg_left = new MModelRenderer(this);
        this.frogleg_left.setRotationPoint(3.0F, -2.75F, -2.75F);
        this.Legs.addChild(this.frogleg_left);
        this.frogleg_left.cubeList.add(new ModelBox(this.frogleg_left, 20, 20, -0.5F, -0.5F, -1.0F, 2, 3, 2, 0.0F, false));
        this.frogleg_left.cubeList.add(new ModelBox(this.frogleg_left, 17, 0, -2.5F, 2.5F, -2.0F, 3, 0, 3, 0.0F, false));
        this.firefly = new MModelRenderer(this);
        this.firefly.setRotationPoint(-0.5F, -7.0F, 0.0F);
        this.Frog119.addChild(this.firefly);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(5.5F, 0.5F, -7.0F);
        this.firefly.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 12, -1.0F, -0.5F, 0.0F, 2, 1, 0, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(5.5F, -1.5F, 4.0F);
        this.firefly.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 0, 11, -1.0F, -0.5F, 0.0F, 2, 1, 0, 0.0F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(-0.5F, -2.5F, 5.0F);
        this.firefly.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 0, 10, -1.0F, -0.5F, 0.0F, 2, 1, 0, 0.0F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(-5.5F, 1.5F, 6.0F);
        this.firefly.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 0, 9, -1.0F, -0.5F, 0.0F, 2, 1, 0, 0.0F, false));
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(-7.5F, -0.5F, -1.0F);
        this.firefly.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 0, 5, -1.0F, -0.5F, 0.0F, 2, 1, 0, 0.0F, false));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(7.5F, 1.5F, 0.0F);
        this.firefly.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 0, 4, -1.0F, -0.5F, 0.0F, 2, 1, 0, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/frogpet_" + color + ".png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/frogpet_animation.json"));
        this.animation = bbanimationloader.mustGet("frogpet.animation", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        this.animation.tick(time);
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        GlStateManager.translate(1.25D, -0.3D + (double)f, 0.4D);
        double d0 = 0.88D;
        GlStateManager.scale(d0, d0, d0);
    }

    public void renderAsItem(float time)
    {
        this.animation.tick(time);
        GlStateManager.translate(0.0D, 0.165D, 0.0D);
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
            case 97705668:
                if (s.equals("frost"))
                {
                    b0 = 1;
                }

                break;

            case 1544803905:
                if (s.equals("default"))
                {
                    b0 = 0;
                }

                break;

            case 1683236900:
                if (s.equals("tropical"))
                {
                    b0 = 2;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u041b\u044f\u0433\u0443\u0448\u043a\u0430";

            case 1:
                return "\u041c\u043e\u0440\u043e\u0437\u043d\u0430\u044f \u043b\u044f\u0433\u0443\u0448\u043a\u0430";

            case 2:
                return "\u0422\u0440\u043e\u043f\u0438\u0447\u0435\u0441\u043a\u0430\u044f \u043b\u044f\u0433\u0443\u0448\u043a\u0430";

            default:
                return "\u0421\u0442\u0440\u0430\u043d\u043d\u0430\u044f \u043b\u044f\u0433\u0443\u0448\u043a\u0430";
        }
    }

    public String getCreator()
    {
        return "xRolaaan";
    }
}
