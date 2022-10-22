package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class CloudPet extends BasePet
{
    private final MModelRenderer Piece3;
    private final MModelRenderer Piece2;
    private final MModelRenderer Piece1;

    public CloudPet()
    {
        this.textureWidth = 32;
        this.textureHeight = 16;
        this.setTextureOffset("Piece2.Shape16", 5, 9);
        this.setTextureOffset("Piece2.Shape17", 0, 9);
        this.setTextureOffset("Piece2.Shape18", 5, 9);
        this.setTextureOffset("Piece3.Shape13", 5, 9);
        this.setTextureOffset("Piece3.Shape14", 0, 9);
        this.setTextureOffset("Piece3.Shape15", 5, 9);
        this.setTextureOffset("Piece1.Shape1", 0, 0);
        this.setTextureOffset("Piece1.Shape2", 5, 9);
        this.setTextureOffset("Piece1.Shape3", 5, 9);
        this.setTextureOffset("Piece1.Shape4", 5, 9);
        this.setTextureOffset("Piece1.Shape5", 5, 9);
        this.setTextureOffset("Piece1.Shape6", 5, 9);
        this.setTextureOffset("Piece1.Shape7", 5, 9);
        this.setTextureOffset("Piece1.Shape8", 5, 9);
        this.setTextureOffset("Piece1.Shape9", 5, 9);
        this.Piece2 = new MModelRenderer(this, "Piece2");
        this.Piece2.addBox("Shape16", -8.0F, 8.0F, 0.0F, 1, 1, 1);
        this.Piece2.addBox("Shape17", -9.0F, 7.0F, 0.0F, 1, 3, 1);
        this.Piece2.addBox("Shape18", -10.0F, 8.0F, 0.0F, 1, 1, 1);
        this.Piece3 = new MModelRenderer(this, "Piece3");
        this.Piece3.addBox("Shape13", -6.0F, 5.0F, 0.0F, 1, 1, 1);
        this.Piece3.addBox("Shape14", -5.0F, 4.0F, 0.0F, 1, 3, 1);
        this.Piece3.addBox("Shape15", -4.0F, 5.0F, 0.0F, 1, 1, 1);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.addBox("Shape1", -6.0F, -4.0F, 0.0F, 11, 7, 1);
        this.Piece1.addBox("Shape2", -5.0F, -5.0F, 0.0F, 3, 1, 1);
        this.Piece1.addBox("Shape3", 2.0F, -5.0F, 0.0F, 3, 1, 1);
        this.Piece1.addBox("Shape4", 5.0F, -4.0F, 0.0F, 1, 3, 1);
        this.Piece1.addBox("Shape5", 5.0F, 0.0F, 0.0F, 1, 2, 1);
        this.Piece1.addBox("Shape6", 1.0F, 3.0F, 0.0F, 3, 1, 1);
        this.Piece1.addBox("Shape7", -3.0F, 3.0F, 0.0F, 2, 1, 1);
        this.Piece1.addBox("Shape8", -7.0F, -1.0F, 0.0F, 1, 3, 1);
        this.Piece1.addBox("Shape9", -7.0F, -3.0F, 0.0F, 1, 1, 1);
        this.setTexture(new ResourceLocation("minidot", "pets/cloudpet.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        float f1 = MathHelper.sin(time * 0.1F) * 0.05F;
        GlStateManager.scale(1.3F, 1.3F, 2.0F);
        GlStateManager.translate(0.65F, -0.6F + f, 0.0F);
        this.Piece3.offsetY = 1.5F;
        this.Piece3.offsetY = -f / 4.0F;
        this.Piece2.offsetY = -f1 / 2.0F;
    }

    public void itemMotion(float rotation, int number)
    {
        GlStateManager.rotate(180.0F + MathHelper.sin(rotation * 0.07F + (float)number) * 20.0F, 0.0F, 0.2F, 0.0F);
        GlStateManager.scale(1.0F, 1.0F, 1.5F);
        GlStateManager.translate(0.0F, -0.1F, 0.0F);
    }

    public String getName()
    {
        return "\u041e\u0431\u043b\u0430\u0447\u043a\u043e";
    }

    public String getCreator()
    {
        return "ThisDorry";
    }
}
