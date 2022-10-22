package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class HotDog extends BasePet
{
    private final MModelRenderer Piece1;

    public HotDog()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("Piece1.Shape1", 0, 0);
        this.setTextureOffset("Piece1.Shape2", 0, 16);
        this.setTextureOffset("Piece1.Shape3", 0, 12);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.setRotation(this.Piece1, 0.0F, 0.0F, 0.0F);
        this.Piece1.mirror = true;
        this.Piece1.addBox("Shape1", -7.0F, -1.0F, -3.0F, 14, 4, 7);
        this.Piece1.addBox("Shape2", -9.0F, -2.0F, -1.0F, 18, 4, 3);
        this.Piece1.addBox("Shape3", -7.0F, -3.0F, 0.0F, 14, 1, 1);
        this.setTexture(new ResourceLocation("minidot", "pets/hotdog.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.04F;
        float f1 = time * 1.5F;
        GlStateManager.translate(0.8F, -0.5F + f, 0.4F);
        GlStateManager.rotate(90.0F + f1, 0.0F, 1.0F, 0.0F);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
    }

    public String getCreator()
    {
        return "ANACTAC";
    }

    public String getName()
    {
        return "\u0413\u041e\u0420\u042f\u0427\u0410\u042f\u0421\u041e\u0411\u0410\u041a\u0410";
    }
}
