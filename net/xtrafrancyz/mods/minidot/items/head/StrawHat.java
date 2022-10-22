package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class StrawHat extends BaseHelm
{
    private final MModelRenderer Hat;
    private final MModelRenderer bone;

    public StrawHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Hat = new MModelRenderer(this);
        this.Hat.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.Hat.setTextureOffset(0, 0).addBox(-8.0F, 0.001F, -8.0F, 16, 0, 16, 0.0F);
        this.Hat.setTextureOffset(26, 28).addBox(-6.0F, 0.0F, 8.0F, 12, 0, 1, 0.0F);
        this.Hat.setTextureOffset(26, 27).addBox(-6.0F, 0.0F, -9.0F, 12, 0, 1, 0.0F);
        this.Hat.setTextureOffset(2, 0).addBox(8.0F, 0.0F, -6.0F, 1, 0, 12, 0.0F);
        this.Hat.setTextureOffset(0, 0).addBox(-9.0F, 0.0F, -6.0F, 1, 0, 12, 0.0F);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Hat.addChild(this.bone);
        this.bone.setTextureOffset(0, 27).addBox(-4.5F, -3.5F, -4.5F, 9, 3, 9, 0.0F);
        this.bone.setTextureOffset(0, 16).addBox(-5.0F, -1.001F, -5.0F, 10, 1, 10, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "head/strawhat.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, -1.91F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -1.2F, 0.0F);
        GlStateManager.scale(0.7F, 0.7F, 0.7F);
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
        return "\u0421\u043e\u043b\u043e\u043c\u0435\u043d\u043d\u0430\u044f \u0448\u043b\u044f\u043f\u0430";
    }

    public String getCreator()
    {
        return "EvilBendy & Wenston";
    }
}
