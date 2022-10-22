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

public class MagicianHat extends BaseItem
{
    private final MModelRenderer hat;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer bone4;
    private final MModelRenderer bone3;

    public MagicianHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.hat = new MModelRenderer(this);
        this.hat.cubeList.add(new ModelBox(this.hat, 0, 10, -4.5175F, -10.25F, -4.0F, 9, 1, 8, 0.0F, false));
        this.hat.cubeList.add(new ModelBox(this.hat, 0, 0, -5.0175F, -9.0F, -4.5F, 10, 1, 9, 0.0F, false));
        this.hat.cubeList.add(new ModelBox(this.hat, 34, 13, -4.0175F, -14.0F, -3.5F, 8, 5, 7, 0.0F, false));
        this.hat.cubeList.add(new ModelBox(this.hat, 0, 19, -4.5175F, -15.0F, -4.0F, 9, 1, 8, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.4F, 1.0F, -0.5F);
        this.setRotation(this.bone, -0.4014F, 0.0F, 0.0F);
        this.hat.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 5, 25, -5.4175F, -7.7216F, -9.1986F, 10, 1, 2, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.4F, 1.0F, -0.5F);
        this.setRotation(this.bone2, -0.3665F, 0.0F, 0.0F);
        this.hat.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 6, 25, -5.4175F, -11.1276F, 1.0842F, 10, 1, 2, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(10.65F, 3.0F, -1.7F);
        this.setRotation(this.bone4, 0.0F, 0.0F, 0.2182F);
        this.hat.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 42, 3, -10.1675F, -13.0F, 0.0F, 1, 2, 3, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.setRotation(this.bone3, 0.0F, 0.0F, 0.384F);
        this.bone4.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 52, 4, -14.3274F, -9.401F, 0.0F, 1, 1, 3, 0.0F, false));
        this.setTexture(new ResourceLocation("minidot", "head/magician_hat.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.translate(0.0F, 0.4F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0428\u043b\u044f\u043f\u0430 \u0424\u043e\u043a\u0443\u0441\u043d\u0438\u043a\u0430";
    }

    public String getCreator()
    {
        return "xRolaaan";
    }
}
