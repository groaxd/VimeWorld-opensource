package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.HashMap;
import java.util.Map;
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

public class CupPet extends BasePet
{
    private static final Map<String, ResourceLocation> colors = new HashMap();
    private static MModelRenderer bone;
    private static MModelRenderer bone2;
    private static MModelRenderer bone3;
    private static MModelRenderer bone4;
    private static MModelRenderer bone5;
    private static MModelRenderer bone6;
    private static MModelRenderer bone7;
    private static MModelRenderer bone8;
    private final IAnimation anim;
    private final String color;

    public CupPet(String color)
    {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.useDisplayLists = true;
        this.color = color;

        if (bone == null)
        {
            bone = new MModelRenderer(this);
            bone2 = new MModelRenderer(this);
            bone.addChild(bone2);
            bone2.cubeList.add(new ModelBox(bone2, 1, 7, -2.0F, -3.0F, 3.0F, 4, 3, 1, 0.0F, false));
            bone2.cubeList.add(new ModelBox(bone2, 1, 7, -2.0F, -3.0F, -4.0F, 4, 3, 1, 0.0F, false));
            bone2.cubeList.add(new ModelBox(bone2, 12, 8, 3.0F, -3.0F, -2.0F, 1, 3, 4, 0.0F, false));
            bone2.cubeList.add(new ModelBox(bone2, 1, 8, -4.0F, -3.0F, -2.0F, 1, 3, 4, 0.0F, false));
            bone2.cubeList.add(new ModelBox(bone2, 12, 8, -3.0F, -3.0F, -3.0F, 1, 3, 1, 0.0F, false));
            bone2.cubeList.add(new ModelBox(bone2, 12, 8, 2.0F, -3.0F, -3.0F, 1, 3, 1, 0.0F, false));
            bone2.cubeList.add(new ModelBox(bone2, 12, 8, 2.0F, -3.0F, 2.0F, 1, 3, 1, 0.0F, false));
            bone2.cubeList.add(new ModelBox(bone2, 12, 8, -3.0F, -3.0F, 2.0F, 1, 3, 1, 0.0F, false));
            bone2.cubeList.add(new ModelBox(bone2, 0, 7, -2.5F, -6.0F, 3.5F, 5, 3, 1, 0.0F, false));
            bone2.cubeList.add(new ModelBox(bone2, 0, 7, -2.5F, -9.0F, 4.0F, 5, 3, 1, 0.0F, false));
            bone2.cubeList.add(new ModelBox(bone2, 0, 7, -2.5F, -6.0F, -4.5F, 5, 3, 1, 0.0F, false));
            bone2.cubeList.add(new ModelBox(bone2, 0, 7, -2.5F, -9.0F, -5.0F, 5, 3, 1, 0.0F, false));
            bone2.cubeList.add(new ModelBox(bone2, 0, 7, -4.5F, -6.0F, -2.5F, 1, 3, 5, 0.0F, false));
            bone2.cubeList.add(new ModelBox(bone2, 0, 7, -5.0F, -9.0F, -2.5F, 1, 3, 5, 0.0F, true));
            bone2.cubeList.add(new ModelBox(bone2, 9, 0, 3.5F, -6.0F, -2.5F, 1, 3, 5, 0.0F, false));
            bone2.cubeList.add(new ModelBox(bone2, 0, 8, 4.0F, -9.0F, -2.5F, 1, 3, 5, 0.0F, false));
            bone2.cubeList.add(new ModelBox(bone2, 0, 16, 2.5F, -6.0F, 1.5F, 1, 3, 2, 0.0F, false));
            bone2.cubeList.add(new ModelBox(bone2, 16, 0, 3.0F, -9.0F, 2.0F, 1, 3, 2, 0.0F, false));
            bone2.cubeList.add(new ModelBox(bone2, 0, 16, -3.5F, -6.0F, 1.5F, 1, 3, 2, 0.0F, false));
            bone2.cubeList.add(new ModelBox(bone2, 16, 0, -4.0F, -9.0F, 2.0F, 1, 3, 2, 0.0F, false));
            bone2.cubeList.add(new ModelBox(bone2, 0, 16, -3.5F, -6.0F, -3.5F, 1, 3, 2, 0.0F, false));
            bone2.cubeList.add(new ModelBox(bone2, 16, 0, -4.0F, -9.0F, -4.0F, 1, 3, 2, 0.0F, false));
            bone2.cubeList.add(new ModelBox(bone2, 0, 16, 2.5F, -6.0F, -3.5F, 1, 3, 2, 0.0F, false));
            bone2.cubeList.add(new ModelBox(bone2, 16, 0, 3.0F, -9.0F, -4.0F, 1, 3, 2, 0.0F, false));
            bone2.cubeList.add(new ModelBox(bone2, 4, 7, 1.5F, -6.0F, -3.5F, 1, 3, 1, 0.0F, false));
            bone2.cubeList.add(new ModelBox(bone2, 1, 7, -2.5F, -6.0F, -3.5F, 1, 3, 1, 0.0F, false));
            bone2.cubeList.add(new ModelBox(bone2, 4, 7, -2.5F, -6.0F, 2.5F, 1, 3, 1, 0.0F, false));
            bone2.cubeList.add(new ModelBox(bone2, 7, 7, 1.5F, -6.0F, 2.5F, 1, 3, 1, 0.0F, false));
            bone2.cubeList.add(new ModelBox(bone2, 18, 8, -3.0F, -9.0F, -4.0F, 1, 3, 1, 0.0F, false));
            bone2.cubeList.add(new ModelBox(bone2, 18, 8, 2.0F, -9.0F, -4.0F, 1, 3, 1, 0.0F, false));
            bone2.cubeList.add(new ModelBox(bone2, 18, 8, 2.0F, -9.0F, 3.0F, 1, 3, 1, 0.0F, false));
            bone2.cubeList.add(new ModelBox(bone2, 18, 8, -3.0F, -9.0F, 3.0F, 1, 3, 1, 0.0F, false));
            bone2.cubeList.add(new ModelBox(bone2, 2, 9, -3.0F, 0.0F, -3.0F, 6, 0, 6, 0.0F, false));
            bone3 = new MModelRenderer(this);
            bone.addChild(bone3);
            bone3.cubeList.add(new ModelBox(bone3, 0, 3, -4.0F, -8.0F, -2.0F, 8, 1, 4, 0.0F, false));
            bone3.cubeList.add(new ModelBox(bone3, 0, 5, -3.0F, -8.0F, -3.0F, 6, 1, 1, 0.0F, false));
            bone3.cubeList.add(new ModelBox(bone3, 0, 5, -3.0F, -8.0F, 2.0F, 6, 1, 1, 0.0F, false));
            bone3.cubeList.add(new ModelBox(bone3, 0, 3, -2.0F, -8.0F, -4.0F, 4, 1, 1, 0.0F, false));
            bone3.cubeList.add(new ModelBox(bone3, 0, 3, -2.0F, -8.0F, 3.0F, 4, 1, 1, 0.0F, false));
            bone4 = new MModelRenderer(this);
            bone.addChild(bone4);
            bone4.cubeList.add(new ModelBox(bone4, 14, 10, 4.0F, -2.5F, -0.5F, 2, 1, 1, 0.0F, false));
            bone4.cubeList.add(new ModelBox(bone4, 8, 0, 5.0F, -7.5F, -0.5F, 1, 1, 1, 0.0F, false));
            bone4.cubeList.add(new ModelBox(bone4, 4, 16, 6.0F, -7.0F, -0.5F, 1, 1, 1, 0.0F, false));
            bone4.cubeList.add(new ModelBox(bone4, 15, 4, 5.5F, -3.0F, -0.5F, 1, 1, 1, 0.0F, false));
            bone4.cubeList.add(new ModelBox(bone4, 8, 0, 6.5F, -3.5F, -0.5F, 1, 1, 1, 0.0F, false));
            bone4.cubeList.add(new ModelBox(bone4, 22, 0, 7.0F, -6.5F, -0.5F, 1, 3, 1, 0.0F, false));
            bone5 = new MModelRenderer(this);
            bone5.setRotationPoint(0.0F, -9.0F, 0.0F);
            bone.addChild(bone5);
            bone6 = new MModelRenderer(this);
            bone6.setRotationPoint(-1.5F, -1.0F, 1.0F);
            this.setRotation(bone6, 0.0F, 0.4363F, 0.0F);
            bone5.addChild(bone6);
            bone6.cubeList.add(new ModelBox(bone6, 0, 0, -1.5F, 1.5F, -1.0F, 3, 1, 2, 0.0F, false));
            bone7 = new MModelRenderer(this);
            bone7.setRotationPoint(1.5F, 1.0F, -1.5F);
            this.setRotation(bone7, 0.0F, -((float)Math.PI * 2F / 9F), 0.0F);
            bone5.addChild(bone7);
            bone7.cubeList.add(new ModelBox(bone7, 2, 0, -2.0F, -0.5F, -0.7F, 2, 1, 1, 0.0F, false));
            bone8 = new MModelRenderer(this);
            bone8.setRotationPoint(2.5F, 0.5F, 0.0F);
            this.setRotation(bone8, -0.4363F, 0.7854F, 0.0F);
            bone5.addChild(bone8);
            bone8.cubeList.add(new ModelBox(bone8, 0, 0, -1.6F, -0.1F, -0.7F, 2, 1, 2, 0.0F, false));
        }

        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/cup_animation.json"));
        this.anim = bbanimationloader.mustGet("cup.anim", this);
        this.setTexture((ResourceLocation)colors.get(color));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.05F;
        GlStateManager.translate(0.8F, -0.25F + f, 0.3F);
        GlStateManager.rotate(time * 1.3F, 0.0F, 1.0F, 0.0F);
        GlStateManager.scale(0.9F, 0.9F, 0.9F);
        this.anim.tick(time);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(1.1F, 1.1F, 1.1F);
        GlStateManager.translate(0.0F, 0.15F, 0.0F);
        this.anim.tick(time);
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
                return "\u041a\u0440\u0430\u0441\u043d\u0430\u044f \u043a\u0440\u0443\u0436\u043a\u0430";

            case 1:
                return "\u0421\u0438\u043d\u044f\u044f \u043a\u0440\u0443\u0436\u043a\u0430";

            case 2:
                return "\u0417\u0435\u043b\u0435\u043d\u0430\u044f \u043a\u0440\u0443\u0436\u043a\u0430";

            case 3:
                return "\u0416\u0435\u043b\u0442\u0430\u044f \u043a\u0440\u0443\u0436\u043a\u0430";

            default:
                return "\u0425\u0443\u0439";
        }
    }

    static
    {
        colors.put("red", new ResourceLocation("minidot", "pets/cup_red.png"));
        colors.put("blue", new ResourceLocation("minidot", "pets/cup_blue.png"));
        colors.put("green", new ResourceLocation("minidot", "pets/cup_green.png"));
        colors.put("yellow", new ResourceLocation("minidot", "pets/cup_yellow.png"));
    }
}
