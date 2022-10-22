package net.xtrafrancyz.mods.minidot.items.mask;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class MaskRabbit extends BaseItem
{
    private final MModelRenderer maskparts;
    private final MModelRenderer mask;
    private final MModelRenderer nose;
    private final MModelRenderer eyes;
    private final MModelRenderer teeth;
    private final MModelRenderer ears2;
    private final MModelRenderer earRight;
    private final MModelRenderer earRight2;
    private final MModelRenderer earLeft;
    private final MModelRenderer earleft;

    public MaskRabbit()
    {
        super(ItemType.MASK);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.maskparts = new MModelRenderer(this);
        this.maskparts.cubeList.add(new ModelBox(this.maskparts, 18, 4, 0.5F, -5.6F, -5.3F, 3, 1, 1, 0.0F, false));
        this.maskparts.cubeList.add(new ModelBox(this.maskparts, 16, 14, -3.5F, -5.6F, -5.3F, 3, 1, 1, 0.0F, false));
        this.mask = new MModelRenderer(this);
        this.maskparts.addChild(this.mask);
        this.mask.cubeList.add(new ModelBox(this.mask, 0, 0, -4.0F, -8.0F, -5.0F, 8, 8, 1, 0.0F, false));
        this.mask.cubeList.add(new ModelBox(this.mask, 12, 14, -4.3F, -5.25F, -5.0F, 1, 5, 1, 0.0F, false));
        this.mask.cubeList.add(new ModelBox(this.mask, 8, 14, 3.3F, -5.25F, -5.0F, 1, 5, 1, 0.0F, false));
        this.nose = new MModelRenderer(this);
        this.maskparts.addChild(this.nose);
        this.nose.cubeList.add(new ModelBox(this.nose, 8, 9, -0.5F, -2.85F, -7.8F, 1, 1, 1, 0.0F, false));
        this.nose.cubeList.add(new ModelBox(this.nose, 10, 10, 1.5F, -2.35F, -6.1F, 2, 2, 2, 0.0F, false));
        this.nose.cubeList.add(new ModelBox(this.nose, 0, 9, -1.5F, -2.6F, -7.0F, 3, 2, 2, 0.0F, false));
        this.nose.cubeList.add(new ModelBox(this.nose, 0, 13, -3.5F, -2.35F, -6.1F, 2, 2, 2, 0.0F, false));
        this.eyes = new MModelRenderer(this);
        this.maskparts.addChild(this.eyes);
        this.eyes.cubeList.add(new ModelBox(this.eyes, 23, 11, 0.5F, -5.3F, -5.1F, 3, 2, 1, -0.001F, false));
        this.eyes.cubeList.add(new ModelBox(this.eyes, 23, 17, -3.5F, -5.3F, -5.1F, 3, 2, 1, -0.001F, false));
        this.teeth = new MModelRenderer(this);
        this.maskparts.addChild(this.teeth);
        this.teeth.cubeList.add(new ModelBox(this.teeth, 5, 20, -1.0F, -0.6F, -6.8F, 1, 1, 1, 0.0F, false));
        this.teeth.cubeList.add(new ModelBox(this.teeth, 5, 20, 0.1F, -0.6F, -6.8F, 1, 1, 1, 0.0F, false));
        this.ears2 = new MModelRenderer(this);
        this.earRight2 = new MModelRenderer(this);
        this.earRight2.setRotationPoint(0.0F, 0.0F, 2.1F);
        this.setRotation(this.earRight2, 0.1745F, 0.0F, 0.0F);
        this.ears2.addChild(this.earRight2);
        this.earRight2.cubeList.add(new ModelBox(this.earRight2, 22, 23, 0.45F, -11.6957F, -5.6737F, 3, 3, 1, 0.0F, false));
        this.earRight = new MModelRenderer(this);
        this.earRight.setRotationPoint(0.0F, -1.7262F, -7.0204F);
        this.setRotation(this.earRight, 0.8727F, 0.0F, 0.0F);
        this.earRight2.addChild(this.earRight);
        this.earRight.cubeList.add(new ModelBox(this.earRight, 14, 23, 0.45F, -7.6106F, 8.1455F, 3, 3, 1, 0.0F, false));
        this.earLeft = new MModelRenderer(this);
        this.earLeft.setRotationPoint(0.0F, 0.0F, 3.2F);
        this.setRotation(this.earLeft, 0.2618F, 0.0F, 0.0F);
        this.ears2.addChild(this.earLeft);
        this.earLeft.cubeList.add(new ModelBox(this.earLeft, 22, 23, -3.55F, -12.2369F, -5.9891F, 3, 3, 1, 0.0F, false));
        this.earleft = new MModelRenderer(this);
        this.earleft.setRotationPoint(0.0F, -0.8134F, -8.3644F);
        this.setRotation(this.earleft, 1.309F, 0.0F, 0.0F);
        this.earLeft.addChild(this.earleft);
        this.earleft.cubeList.add(new ModelBox(this.earleft, 14, 23, -3.55F, -2.774F, 11.1976F, 3, 3, 1, 0.0F, false));
        this.setTexture(new ResourceLocation("minidot", "masks/3d_rabbit.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        this.ears2.scaleX = 0.8F;
        this.earLeft.offsetX = -0.055F;
        this.earRight2.offsetX = 0.055F;

        if (player.getCurrentArmor(3) != null)
        {
            GlStateManager.scale(1.001F, 1.001F, 1.001F);
        }
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.translate(0.0F, 0.1F, 0.0F);
        super.renderAsItem(time);
    }

    public String getCreator()
    {
        return "xRolaaan";
    }

    public String getName()
    {
        return "\u041c\u0430\u0441\u043a\u0430 \u043a\u0440\u043e\u043b\u0438\u043a\u0430";
    }
}
