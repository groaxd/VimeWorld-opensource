package net.xtrafrancyz.mods.minidot.items.head;

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

public class HairKnot extends BaseItem
{
    private final MModelRenderer knot_with_flower;
    private final MModelRenderer flower;
    private final MModelRenderer bone10;
    private final MModelRenderer bone11;
    private final MModelRenderer bone8;
    private final MModelRenderer bone9;
    private final MModelRenderer bone7;
    private final MModelRenderer bone6;
    private final MModelRenderer bone5;
    private final MModelRenderer ropes;
    private final MModelRenderer rope1;
    private final MModelRenderer rope2;
    private final MModelRenderer bow_knot;
    private final MModelRenderer bone2;
    private final MModelRenderer bone;
    private final IAnimation animation;
    private final String color;

    public HairKnot(String color)
    {
        super(ItemType.HEAD);
        this.textureWidth = 16;
        this.textureHeight = 16;
        this.color = color;
        this.knot_with_flower = new MModelRenderer(this);
        this.flower = new MModelRenderer(this);
        this.flower.setRotationPoint(0.0F, -6.25F, 5.5F);
        this.setRotation(this.flower, -1.2654F, 0.0F, 0.0F);
        this.knot_with_flower.addChild(this.flower);
        this.bone10 = new MModelRenderer(this);
        this.setRotation(this.bone10, 0.0F, -1.5708F, 0.0F);
        this.flower.addChild(this.bone10);
        this.bone11 = new MModelRenderer(this);
        this.setRotation(this.bone11, -0.4363F, 0.0F, 0.0F);
        this.bone10.addChild(this.bone11);
        this.bone11.cubeList.add(new ModelBox(this.bone11, 8, 0, -1.0F, 0.0F, -2.0F, 2, 0, 2, 0.0F, false));
        this.bone8 = new MModelRenderer(this);
        this.setRotation(this.bone8, -3.1416F, 0.0F, 3.1416F);
        this.flower.addChild(this.bone8);
        this.bone9 = new MModelRenderer(this);
        this.setRotation(this.bone9, -0.4363F, 0.0F, 0.0F);
        this.bone8.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 8, 2, -1.0F, 0.0F, -2.0F, 2, 0, 2, 0.0F, false));
        this.bone7 = new MModelRenderer(this);
        this.setRotation(this.bone7, 0.0F, 1.4835F, 0.0F);
        this.flower.addChild(this.bone7);
        this.bone6 = new MModelRenderer(this);
        this.setRotation(this.bone6, -0.4363F, 0.0F, 0.0F);
        this.bone7.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 8, 4, -1.0F, 0.0F, -2.0F, 2, 0, 2, 0.0F, false));
        this.bone5 = new MModelRenderer(this);
        this.setRotation(this.bone5, -0.4363F, 0.0F, 0.0F);
        this.flower.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 8, 6, -1.0F, 0.0F, -2.0F, 2, 0, 2, 0.0F, false));
        this.ropes = new MModelRenderer(this);
        this.knot_with_flower.addChild(this.ropes);
        this.rope1 = new MModelRenderer(this);
        this.rope1.setRotationPoint(-1.0F, -5.0F, 5.0F);
        this.setRotation(this.rope1, 0.1745F, 0.0F, 0.3054F);
        this.ropes.addChild(this.rope1);
        this.rope1.cubeList.add(new ModelBox(this.rope1, 0, 10, -0.3523F, 0.2081F, 0.0F, 1, 5, 0, 0.0F, false));
        this.rope2 = new MModelRenderer(this);
        this.rope2.setRotationPoint(1.0F, -5.0F, 5.0F);
        this.setRotation(this.rope2, 0.1745F, 0.0F, -0.3054F);
        this.ropes.addChild(this.rope2);
        this.rope2.cubeList.add(new ModelBox(this.rope2, 2, 10, -0.6477F, 0.2081F, 0.0F, 1, 5, 0, 0.0F, false));
        this.bow_knot = new MModelRenderer(this);
        this.knot_with_flower.addChild(this.bow_knot);
        this.bow_knot.cubeList.add(new ModelBox(this.bow_knot, 9, 9, -0.5F, -6.75F, 5.0F, 1, 2, 1, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.0F, -5.0F, 5.0F);
        this.setRotation(this.bone2, 0.3054F, 0.0F, -0.2182F);
        this.bow_knot.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 0, 0.0F, -2.0F, 0.0F, 4, 4, 1, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, -5.0F, 5.0F);
        this.setRotation(this.bone, 0.3054F, 0.0F, 0.2182F);
        this.bow_knot.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 5, -4.0F, -2.0F, 0.0F, 4, 4, 1, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "head/hairknot_" + color + ".png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "head/hairknot_animation.json"));
        this.animation = bbanimationloader.mustGet("hairknot.animation", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        this.animation.tick(time);
        GlStateManager.translate(0.0D, 0.0D, -0.04D);
    }

    public void renderAsItem(float time)
    {
        this.animation.tick(time);
        GlStateManager.translate(0.0D, 0.0D, -0.165D);
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
                    b0 = 3;
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
                    b0 = 1;
                }

                break;

            case 98619139:
                if (s.equals("green"))
                {
                    b0 = 2;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u041a\u0440\u0430\u0441\u043d\u044b\u0439 \u0431\u0430\u043d\u0442\u0438\u043a";

            case 1:
                return "\u0421\u0438\u043d\u0438\u0439 \u0431\u0430\u043d\u0442\u0438\u043a";

            case 2:
                return "\u0417\u0435\u043b\u0435\u043d\u044b\u0439 \u0431\u0430\u043d\u0442\u0438\u043a";

            case 3:
                return "\u0416\u0435\u043b\u0442\u044b\u0439 \u0431\u0430\u043d\u0442\u0438\u043a";

            default:
                return "\u0421\u0442\u0440\u0430\u043d\u043d\u044b\u0439 \u0431\u0430\u043d\u0442\u0438\u043a";
        }
    }

    public String getCreator()
    {
        return "Rander_";
    }
}
