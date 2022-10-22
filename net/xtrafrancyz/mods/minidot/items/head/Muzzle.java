package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class Muzzle extends BaseItem
{
    private final MModelRenderer muzzle;
    private final MModelRenderer bone5;
    private final MModelRenderer bone6;
    private final MModelRenderer bone;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final MModelRenderer bone2;

    public Muzzle()
    {
        super(ItemType.HEAD);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.muzzle = new MModelRenderer(this);
        this.muzzle.cubeList.add(new ModelBox(this.muzzle, 0, 2, -4.5F, -8.5F, -4.5F, 9, 1, 1, 0.0F, false));
        this.muzzle.cubeList.add(new ModelBox(this.muzzle, 16, 10, 3.75F, -7.5F, -4.1F, 1, 1, 1, 0.0F, false));
        this.muzzle.cubeList.add(new ModelBox(this.muzzle, 6, 12, -4.75F, -7.5F, -4.1F, 1, 1, 1, 0.0F, false));
        this.muzzle.cubeList.add(new ModelBox(this.muzzle, 12, 23, -4.0F, -8.0F, -3.5F, 0, 1, 8, -0.25F, false));
        this.muzzle.cubeList.add(new ModelBox(this.muzzle, 12, 23, 4.0F, -8.0F, -3.5F, 0, 1, 8, -0.25F, false));
        this.muzzle.cubeList.add(new ModelBox(this.muzzle, 0, 5, -4.0F, -8.15F, 4.25F, 8, 1, 0, -0.25F, false));
        this.muzzle.cubeList.add(new ModelBox(this.muzzle, 0, 5, -4.0F, -7.15F, 4.25F, 8, 1, 0, -0.25F, false));
        this.muzzle.cubeList.add(new ModelBox(this.muzzle, 13, 23, 4.0F, -7.0F, -3.5F, 0, 1, 8, -0.25F, false));
        this.muzzle.cubeList.add(new ModelBox(this.muzzle, 13, 23, -4.0F, -7.0F, -3.5F, 0, 1, 8, -0.25F, false));
        this.muzzle.cubeList.add(new ModelBox(this.muzzle, 18, 17, 3.0F, -8.0F, -4.85F, 1, 2, 1, -0.25F, false));
        this.muzzle.cubeList.add(new ModelBox(this.muzzle, 14, 17, -4.0F, -8.0F, -4.85F, 1, 2, 1, -0.25F, false));
        this.muzzle.cubeList.add(new ModelBox(this.muzzle, 10, 17, -3.0F, -8.0F, -4.85F, 1, 2, 1, -0.25F, false));
        this.muzzle.cubeList.add(new ModelBox(this.muzzle, 16, 27, -1.35F, -8.75F, -5.2F, 2, 3, 2, -0.9F, false));
        this.muzzle.cubeList.add(new ModelBox(this.muzzle, 16, 27, -0.65F, -8.75F, -5.2F, 2, 3, 2, -0.9F, false));
        this.muzzle.cubeList.add(new ModelBox(this.muzzle, 6, 17, 2.0F, -8.0F, -4.85F, 1, 2, 1, -0.25F, false));
        this.muzzle.cubeList.add(new ModelBox(this.muzzle, 14, 12, -1.5F, -7.05F, -4.85F, 3, 1, 1, -0.25F, false));
        this.muzzle.cubeList.add(new ModelBox(this.muzzle, 0, 20, -0.5608F, -5.8054F, -4.5F, 1, 1, 1, 0.0F, false));
        this.muzzle.cubeList.add(new ModelBox(this.muzzle, 19, 1, -0.4392F, -5.8054F, -4.5F, 1, 1, 1, 0.0F, false));
        this.muzzle.cubeList.add(new ModelBox(this.muzzle, 0, 0, -4.5F, -6.5F, -4.5F, 9, 1, 1, 0.0F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(-2.65F, -0.85F, 0.1F);
        this.setRotation(this.bone5, 0.0F, 0.0F, 0.48F);
        this.muzzle.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 0, 17, 0.0F, -8.5F, -4.85F, 2, 2, 1, -0.25F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(2.65F, -0.85F, 0.1F);
        this.setRotation(this.bone6, 0.0F, 0.0F, -0.48F);
        this.muzzle.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 16, 14, -2.0F, -8.5F, -4.85F, 2, 2, 1, -0.25F, false));
        this.bone = new MModelRenderer(this);
        this.setRotation(this.bone, 0.0F, 0.0F, -0.1745F);
        this.muzzle.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 10, 6, 1.3867F, -5.635F, -4.5F, 4, 1, 1, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(-0.75F, -15.15F, 0.0F);
        this.setRotation(this.bone3, 0.0F, 0.0F, 0.3491F);
        this.muzzle.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 16, 8, 2.61F, 5.032F, -4.5F, 3, 1, 1, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(0.75F, -15.15F, 0.0F);
        this.setRotation(this.bone4, 0.0F, 0.0F, -0.3491F);
        this.muzzle.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 16, 4, -5.6446F, 5.0194F, -4.5F, 3, 1, 1, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.setRotation(this.bone2, 0.0F, 0.0F, 0.1745F);
        this.muzzle.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 6, -5.3867F, -5.635F, -4.5F, 4, 1, 1, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "head/muzzle.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0D, 0.35D, 0.0D);

        if (player.isWearing(EnumPlayerModelParts.HAT))
        {
            double d0 = 1.05D;
            GlStateManager.scale(d0, d0, d0);
        }
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0D, 0.1D, 0.0D);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041d\u0430\u043c\u043e\u0440\u0434\u043d\u0438\u043a";
    }

    public String getCreator()
    {
        return "xRolaaan";
    }
}
