package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class SkullPet extends BasePet
{
    private static final ResourceLocation tex = new ResourceLocation("minidot", "pets/skullpet.png");
    private static final ResourceLocation tex1 = new ResourceLocation("minidot", "pets/skullpet2.png");
    private final MModelRenderer Piece1;

    public SkullPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("Piece1.Shape1", 0, 0);
        this.setTextureOffset("Piece1.Shape17", 0, 19);
        this.setTextureOffset("Piece1.Shape2", 30, 0);
        this.setTextureOffset("Piece1.Shape16", 0, 19);
        this.setTextureOffset("Piece1.Shape3", 33, 0);
        this.setTextureOffset("Piece1.Shape15", 0, 19);
        this.setTextureOffset("Piece1.Shape4", 33, 0);
        this.setTextureOffset("Piece1.Shape14", 0, 19);
        this.setTextureOffset("Piece1.Shape5", 34, 4);
        this.setTextureOffset("Piece1.Shape13", 30, 0);
        this.setTextureOffset("Piece1.Shape6", 30, 3);
        this.setTextureOffset("Piece1.Shape12", 31, 2);
        this.setTextureOffset("Piece1.Shape7", 36, 2);
        this.setTextureOffset("Piece1.Shape11", 39, 2);
        this.setTextureOffset("Piece1.Shape8", 41, 3);
        this.setTextureOffset("Piece1.Shape10", 31, 1);
        this.setTextureOffset("Piece1.Shape9", 42, 3);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.addBox("Shape1", -4.0F, -4.0F, -3.0F, 8, 8, 7);
        this.Piece1.addBox("Shape17", 0.2F, 5.0F, -4.0F, 1, 1, 1);
        this.Piece1.addBox("Shape2", -4.0F, -4.0F, -4.0F, 8, 4, 1);
        this.Piece1.addBox("Shape16", 1.6F, 5.0F, -4.0F, 1, 1, 1);
        this.Piece1.addBox("Shape3", -4.0F, 0.0F, -4.0F, 1, 1, 1);
        this.Piece1.addBox("Shape15", -1.2F, 5.0F, -4.0F, 1, 1, 1);
        this.Piece1.addBox("Shape4", 3.0F, 0.0F, -4.0F, 1, 1, 1);
        this.Piece1.addBox("Shape14", -2.6F, 5.0F, -4.0F, 1, 1, 1);
        this.Piece1.addBox("Shape5", -1.0F, 0.0F, -4.0F, 2, 1, 1);
        this.Piece1.addBox("Shape13", -3.0F, 4.0F, -4.0F, 6, 1, 5);
        this.Piece1.addBox("Shape6", -4.0F, 1.0F, -4.0F, 8, 1, 1);
        this.Piece1.addBox("Shape12", -4.5F, 2.0F, -4.5F, 2, 2, 2);
        this.Piece1.addBox("Shape7", -4.0F, 2.0F, -4.0F, 3, 1, 1);
        this.Piece1.addBox("Shape11", 2.5F, 2.0F, -4.5F, 2, 2, 2);
        this.Piece1.addBox("Shape8", 1.0F, 2.0F, -4.0F, 3, 1, 1);
        this.Piece1.addBox("Shape10", -4.0F, 3.0F, -4.0F, 8, 1, 1);
        this.Piece1.addBox("Shape9", -0.5F, 2.0F, -4.0F, 1, 1, 1);
        this.setTexture(tex);
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        GlStateManager.translate(0.6F, -0.5F + f, 0.4F);

        if (time % 90.0F > 30.0F)
        {
            this.setTexture(tex);
        }
        else
        {
            this.setTexture(tex1);
        }
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0427\u0435\u0440\u0435\u043f";
    }
}
