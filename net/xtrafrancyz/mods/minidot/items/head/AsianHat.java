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

public class AsianHat extends BaseItem
{
    private final MModelRenderer ChineseHat;
    private final MModelRenderer bone3;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final MModelRenderer bone6;

    public AsianHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.ChineseHat = new MModelRenderer(this);
        this.ChineseHat.setRotationPoint(0.0F, 0.0F, 1.0F);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.0F, 0.0F, -1.0F);
        this.ChineseHat.addChild(this.bone3);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, -9.0F, -6.0F);
        this.setRotation(this.bone, -0.7854F, 0.0F, 0.0F);
        this.bone3.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 0, -5.0F, -6.6464F, 1.6464F, 10, 8, 0, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.0F, -2.0F, 1.0F);
        this.setRotation(this.bone2, 0.7854F, 0.0F, 0.0F);
        this.bone3.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 0, -5.0F, -8.252F, 6.6464F, 10, 8, 0, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(-1.25F, 0.0F, 0.05F);
        this.setRotation(this.bone4, -3.1416F, -1.5708F, 3.1416F);
        this.ChineseHat.addChild(this.bone4);
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(-1.25F, -9.0F, -7.1F);
        this.setRotation(this.bone5, -0.7854F, 0.0F, 0.0F);
        this.bone4.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 0, 0, -5.0F, -6.6464F, 1.6464F, 10, 8, 0, 0.0F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(-1.25F, -2.0F, -0.1F);
        this.setRotation(this.bone6, 0.7854F, 0.0F, 0.0F);
        this.bone4.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 0, 0, -5.0F, -8.252F, 6.6464F, 10, 8, 0, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "head/asianhat.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0D, -0.04D, 0.0D);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0D, 0.2D, 0.0D);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0410\u0437\u0438\u0430\u0442\u0441\u043a\u0430\u044f \u0448\u043b\u044f\u043f\u0430";
    }

    public String getCreator()
    {
        return "Rander_ & Wenston";
    }
}
