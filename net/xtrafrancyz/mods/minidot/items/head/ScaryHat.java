package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class ScaryHat extends BaseHelm
{
    private final MModelRenderer ScaryHat;
    private final MModelRenderer bone;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final MModelRenderer bone2;

    public ScaryHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.ScaryHat = new MModelRenderer(this);
        this.setRotation(this.ScaryHat, -3.1416F, 1.5708F, 3.1416F);
        this.bone = new MModelRenderer(this);
        this.ScaryHat.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 0, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(-0.1F, -4.0F, 4.5F);
        this.setRotation(this.bone3, 0.0F, 0.0F, -0.5236F);
        this.bone.addChild(this.bone3);
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(-0.1F, -4.0F, 4.5F);
        this.setRotation(this.bone4, 0.0F, 0.0F, -0.5236F);
        this.bone.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 0, 16, -2.0F, -3.0F, -0.51F, 4, 6, 1, 0.0F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(-0.1F, -4.0F, -3.5F);
        this.setRotation(this.bone5, 0.0F, 0.0F, -0.5236F);
        this.bone.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 10, 16, -2.0F, -3.0F, -1.49F, 4, 6, 1, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(7.0F, -4.0F, 0.0F);
        this.setRotation(this.bone2, 0.0F, 0.0F, 0.7854F);
        this.bone.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 20, 16, -4.1213F, 1.1213F, -1.75F, 3, 3, 4, 0.1F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 23, -5.1213F, 0.1213F, -3.0F, 5, 4, 6, 0.15F, false));
        super.setTexture(new ResourceLocation("minidot", "head/scaryhat.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        double d0 = 1.1D;
        GlStateManager.translate(0.0D, 0.025D, 0.0D);
        GlStateManager.scale(d0, d0, d0);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0D, -0.05D, 0.0D);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0423\u0436\u0430\u0441\u0430\u044e\u0449\u0438\u0439 \u0448\u043b\u0435\u043c";
    }

    public String getCreator()
    {
        return "Wenston";
    }
}
