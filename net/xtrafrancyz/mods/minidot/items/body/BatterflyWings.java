package net.xtrafrancyz.mods.minidot.items.body;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class BatterflyWings extends BaseItem
{
    private final MModelRenderer Left;
    private final MModelRenderer Right;

    public BatterflyWings()
    {
        super(ItemType.BODY);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Left = new MModelRenderer(this, 0, -30);
        this.Left.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.Left.addBox(1.5F, -10.0F, 6.0F, 0, 32, 30);
        this.setRotation(this.Left, 0.0F, 0.4F, 0.0F);
        this.Left.setDynamic(true);
        this.Right = new MModelRenderer(this, 0, -30);
        this.Right.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.Right.addBox(-1.5F, -10.0F, 6.0F, 0, 32, 30);
        this.setRotation(this.Right, 0.0F, -0.4F, 0.0F);
        this.Right.setDynamic(true);
        this.setTexture(new ResourceLocation("minidot", "body/batterfly_wings.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        float f = MathHelper.cos(time * 0.05F) * 0.06F;
        this.Left.rotationY = -f;
        this.Right.rotationY = f;
        GlStateManager.scale(0.65F, 0.65F, 0.6F);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.03F, -0.1F);
        GlStateManager.scale(0.55F, 0.5F, 0.38F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0411\u043e\u043b\u044c\u0448\u0438\u0435 \u043a\u0440\u044b\u043b\u044c\u044f \u0431\u0430\u0431\u043e\u0447\u043a\u0438";
    }
}
