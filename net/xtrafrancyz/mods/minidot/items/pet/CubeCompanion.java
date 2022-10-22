package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.List;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.util.MNaming;

public class CubeCompanion extends BasePet
{
    private final MModelRenderer Piece1;

    public CubeCompanion()
    {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.setTextureOffset("Piece1.Shape1", 0, 0);
        this.setTextureOffset("Piece1.Shape2", 0, 0);
        this.setTextureOffset("Piece1.Shape3", 0, 0);
        this.setTextureOffset("Piece1.Shape4", 0, 0);
        this.setTextureOffset("Piece1.Shape5", 0, 0);
        this.setTextureOffset("Piece1.Shape6", 0, 0);
        this.setTextureOffset("Piece1.Shape7", 0, 0);
        this.setTextureOffset("Piece1.Shape8", 0, 0);
        this.setTextureOffset("Piece1.Shape9", 17, 0);
        this.setTextureOffset("Piece1.Shape10", 0, 0);
        this.setTextureOffset("Piece1.Shape11", 0, 0);
        this.setTextureOffset("Piece1.Shape12", 0, 0);
        this.setTextureOffset("Piece1.Shape13", 0, 0);
        this.setTextureOffset("Piece1.Shape14", 0, 0);
        this.setTextureOffset("Piece1.Shape15", 0, 0);
        this.setTextureOffset("Piece1.Shape16", 0, 0);
        this.setTextureOffset("Piece1.Shape17", 0, 0);
        this.setTextureOffset("Piece1.Shape18", 0, 0);
        this.setTextureOffset("Piece1.Shape19", 0, 0);
        this.setTextureOffset("Piece1.Shape21", 0, 0);
        this.setTextureOffset("Piece1.Shape20", 0, 0);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.addBox("Shape1", -8.0F, 4.0F, 4.0F, 4, 4, 4);
        this.Piece1.addBox("Shape2", 4.0F, 4.0F, 4.0F, 4, 4, 4);
        this.Piece1.addBox("Shape3", 4.0F, 4.0F, -8.0F, 4, 4, 4);
        this.Piece1.addBox("Shape4", -8.0F, 4.0F, -8.0F, 4, 4, 4);
        this.Piece1.addBox("Shape5", -8.0F, -8.0F, -8.0F, 4, 4, 4);
        this.Piece1.addBox("Shape6", 4.0F, -8.0F, 4.0F, 4, 4, 4);
        this.Piece1.addBox("Shape7", -8.0F, -8.0F, 4.0F, 4, 4, 4);
        this.Piece1.addBox("Shape8", 4.0F, -8.0F, -8.0F, 4, 4, 4);
        this.Piece1.addBox("Shape9", -7.0F, -7.0F, -7.0F, 14, 14, 14);
        this.Piece1.addBox("Shape10", -7.5F, -3.0F, -7.5F, 2, 6, 2);
        this.Piece1.addBox("Shape11", -7.5F, -3.0F, 5.5F, 2, 6, 2);
        this.Piece1.addBox("Shape12", 5.5F, -3.0F, 5.5F, 2, 6, 2);
        this.Piece1.addBox("Shape13", 5.5F, -3.0F, -7.5F, 2, 6, 2);
        this.Piece1.addBox("Shape14", 5.5F, -7.5F, -3.0F, 2, 2, 6);
        this.Piece1.addBox("Shape15", -7.5F, -7.5F, -3.0F, 2, 2, 6);
        this.Piece1.addBox("Shape16", -7.5F, 5.5F, -3.0F, 2, 2, 6);
        this.Piece1.addBox("Shape17", 5.5F, 5.5F, -3.0F, 2, 2, 6);
        this.Piece1.addBox("Shape18", -3.0F, -7.5F, -7.5F, 6, 2, 2);
        this.Piece1.addBox("Shape19", -3.0F, -7.5F, 5.5F, 6, 2, 2);
        this.Piece1.addBox("Shape21", -3.0F, 5.5F, 5.5F, 6, 2, 2);
        this.Piece1.addBox("Shape20", -3.0F, 5.5F, -7.5F, 6, 2, 2);
        this.setTexture(new ResourceLocation("minidot", "pets/cubecompanion.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        GlStateManager.scale(0.85F, 0.85F, 0.85F);
        GlStateManager.translate(0.85F, -0.55F + f, 0.5F);
        GlStateManager.rotate(time * 1.5F, 0.0F, 1.0F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.83F, 0.83F, 0.83F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041a\u0443\u0431-\u043a\u043e\u043c\u043f\u0430\u043d\u044c\u043e\u043d";
    }

    public String getCreator()
    {
        return "ZLP_MASTER";
    }

    public List<String> getDescription()
    {
        return MNaming.fromGame("Portal 2");
    }
}
