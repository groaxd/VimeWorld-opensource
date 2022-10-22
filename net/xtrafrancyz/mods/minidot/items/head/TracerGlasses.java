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

public class TracerGlasses extends BaseItem
{
    private static MModelRenderer bone5;
    private static MModelRenderer bone4;
    private static MModelRenderer bone3;
    private static MModelRenderer bone2;
    private static MModelRenderer bone;
    private final String type;

    public TracerGlasses(String type)
    {
        super(ItemType.MASK);
        this.textureWidth = 32;
        this.textureHeight = 16;
        this.type = type;

        if (bone5 == null)
        {
            bone5 = new MModelRenderer(this);
            bone5.cubeList.add(new ModelBox(bone5, 22, 2, -0.5F, -2.3F, -5.0F, 1, 1, 1, 0.0F, false));
            bone5.cubeList.add(new ModelBox(bone5, 16, 6, -0.5F, -5.5F, -5.0F, 1, 1, 1, 0.0F, false));
            bone5.cubeList.add(new ModelBox(bone5, 12, 6, -4.139F, -6.2424F, -4.99F, 1, 1, 1, 0.0F, false));
            bone5.cubeList.add(new ModelBox(bone5, 16, 0, -4.539F, -5.3424F, -5.0F, 1, 4, 2, 0.0F, false));
            bone5.cubeList.add(new ModelBox(bone5, 0, 6, -4.939F, -4.85F, -4.5F, 1, 3, 1, 0.0F, false));
            bone5.cubeList.add(new ModelBox(bone5, 0, 0, -3.939F, -5.4F, -4.8F, 8, 4, 0, 0.0F, false));
            bone5.cubeList.add(new ModelBox(bone5, 21, 5, 3.861F, -4.85F, -4.5F, 1, 3, 1, 0.0F, false));
            bone5.cubeList.add(new ModelBox(bone5, 16, 0, 3.461F, -5.3424F, -5.0F, 1, 4, 2, 0.0F, true));
            bone5.cubeList.add(new ModelBox(bone5, 4, 6, -4.139F, -1.5576F, -5.0F, 1, 1, 1, 0.0F, false));
            bone5.cubeList.add(new ModelBox(bone5, 8, 6, 3.139F, -6.2424F, -4.99F, 1, 1, 1, 0.0F, false));
            bone5.cubeList.add(new ModelBox(bone5, 4, 6, 3.139F, -1.5576F, -5.0F, 1, 1, 1, 0.0F, true));
            bone4 = new MModelRenderer(this);
            bone4.setRotationPoint(-2.5F, -4.8F, -1.0F);
            this.setRotation(bone4, 0.0F, 0.0F, 0.2618F);
            bone5.addChild(bone4);
            bone4.cubeList.add(new ModelBox(bone4, 0, 4, 3.5448F, 1.6384F, -4.0F, 3, 1, 1, 0.0F, true));
            bone3 = new MModelRenderer(this);
            bone3.setRotationPoint(1.5F, -4.8F, -1.0F);
            this.setRotation(bone3, 0.0F, 0.0F, -0.2618F);
            bone5.addChild(bone3);
            bone3.cubeList.add(new ModelBox(bone3, 0, 4, -5.5789F, 1.8972F, -4.0F, 3, 1, 1, 0.0F, false));
            bone2 = new MModelRenderer(this);
            bone2.setRotationPoint(-2.5F, -4.8F, -1.0F);
            this.setRotation(bone2, 0.0F, 0.0F, 0.2618F);
            bone5.addChild(bone2);
            bone2.cubeList.add(new ModelBox(bone2, 8, 4, -0.9905F, -1.2279F, -4.0F, 3, 1, 1, 0.0F, false));
            bone = new MModelRenderer(this);
            bone.setRotationPoint(1.5F, -4.8F, -1.0F);
            this.setRotation(bone, 0.0F, 0.0F, -0.2618F);
            bone5.addChild(bone);
            bone.cubeList.add(new ModelBox(bone, 20, 0, -1.0436F, -0.969F, -4.0F, 3, 1, 1, 0.0F, false));
        }

        this.setTexture(new ResourceLocation("minidot:masks/" + type + "_tracer_glasses.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, -0.0255F, 0.0F);
    }

    public void itemMotion(float rotation, int number)
    {
        GlStateManager.rotate(180.0F + MathHelper.sin(rotation * 0.025F + (float)number) * 30.0F, 0.0F, 0.2F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -0.15F, 0.2F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        String s = this.type;
        byte b0 = -1;

        switch (s.hashCode())
        {
            case 3181155:
                if (s.equals("gray"))
                {
                    b0 = 1;
                }

                break;

            case 93818879:
                if (s.equals("black"))
                {
                    b0 = 0;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u0427\u0435\u0440\u043d\u044b\u0435 \u043e\u0447\u043a\u0438 \u0422\u0440\u0435\u0439\u0441\u0435\u0440";

            case 1:
                return "\u0421\u0435\u0440\u044b\u0435 \u043e\u0447\u043a\u0438 \u0422\u0440\u0435\u0439\u0441\u0435\u0440";

            default:
                return "\u0419\u0443\u0445";
        }
    }

    public String getCreator()
    {
        return "Veltorn";
    }
}
