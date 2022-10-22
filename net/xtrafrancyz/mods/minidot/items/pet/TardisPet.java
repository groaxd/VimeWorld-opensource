package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class TardisPet extends BasePet
{
    private final MModelRenderer Shape;

    public TardisPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.setTextureOffset("Shape.Shape1", 0, 0);
        this.setTextureOffset("Shape.Shape2", 0, 28);
        this.setTextureOffset("Shape.Shape3", 0, 40);
        this.setTextureOffset("Shape.Shape4", 0, 18);
        this.setTextureOffset("Shape.Shape5", 0, 0);
        this.Shape = new MModelRenderer(this, "Shape");
        this.Shape.addBox("Shape1", -4.0F, 0.0F, -4.0F, 8, 10, 8);
        this.Shape.addBox("Shape2", -5.0F, 10.0F, -5.0F, 10, 2, 10);
        this.Shape.addBox("Shape3", -5.0F, -2.0F, -5.0F, 10, 2, 10);
        this.Shape.addBox("Shape4", -4.0F, -3.0F, -4.0F, 8, 2, 8);
        this.Shape.addBox("Shape5", -1.0F, -5.0F, -1.0F, 2, 2, 2);
        this.setTexture(new ResourceLocation("minidot", "pets/tardispet.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        GlStateManager.translate(0.6F, -0.5F + f, 0.3F);
        GlStateManager.rotate(time * 1.5F, 0.0F, 1.0F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -0.2F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0422\u0430\u0440\u0434\u0438\u0441";
    }
}
