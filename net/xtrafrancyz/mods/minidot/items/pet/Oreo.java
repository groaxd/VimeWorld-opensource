package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class Oreo extends BasePet
{
    private final MModelRenderer Piece1;

    public Oreo()
    {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.setTextureOffset("Piece1.Shape1", 0, 14);
        this.setTextureOffset("Piece1.Shape2", 0, 14);
        this.setTextureOffset("Piece1.Shape3", 0, 14);
        this.setTextureOffset("Piece1.Shape4", 0, 14);
        this.setTextureOffset("Piece1.Shape5", 0, 14);
        this.setTextureOffset("Piece1.Shape6", 0, 14);
        this.setTextureOffset("Piece1.Shape7", 0, 14);
        this.setTextureOffset("Piece1.Shape8", 0, 0);
        this.setTextureOffset("Piece1.Shape9", 0, 0);
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
        this.setTextureOffset("Piece1.Shape20", 0, 0);
        this.setTextureOffset("Piece1.Shape21", 0, 0);
        this.setTextureOffset("Piece1.Shape22", 0, 0);
        this.setTextureOffset("Piece1.Shape23", 0, 0);
        this.setTextureOffset("Piece1.Shape24", 0, 0);
        this.setTextureOffset("Piece1.Shape25", 0, 0);
        this.setTextureOffset("Piece1.Shape26", 0, 0);
        this.setTextureOffset("Piece1.Shape27", 0, 0);
        this.setTextureOffset("Piece1.Shape28", 0, 0);
        this.setTextureOffset("Piece1.Shape29", 0, 0);
        this.setTextureOffset("Piece1.Shape30", 0, 0);
        this.setTextureOffset("Piece1.Shape31", 0, 0);
        this.setTextureOffset("Piece1.Shape32", 0, 0);
        this.setTextureOffset("Piece1.Shape33", 0, 0);
        this.setTextureOffset("Piece1.Shape34", 0, 0);
        this.setTextureOffset("Piece1.Shape35", 0, 0);
        this.setTextureOffset("Piece1.Shape36", 0, 0);
        this.setTextureOffset("Piece1.Shape37", 0, 0);
        this.setTextureOffset("Piece1.Shape38", 0, 0);
        this.setTextureOffset("Piece1.Shape39", 0, 0);
        this.setTextureOffset("Piece1.Shape40", 0, 0);
        this.setTextureOffset("Piece1.Shape41", 0, 0);
        this.setTextureOffset("Piece1.Shape42", 0, 0);
        this.setTextureOffset("Piece1.Shape43", 0, 0);
        this.setTextureOffset("Piece1.Shape44", 0, 0);
        this.setTextureOffset("Piece1.Shape45", 0, 0);
        this.setTextureOffset("Piece1.Shape46", 0, 0);
        this.setTextureOffset("Piece1.Shape47", 0, 0);
        this.setTextureOffset("Piece1.Shape48", 0, 0);
        this.setTextureOffset("Piece1.Shape49", 0, 0);
        this.setTextureOffset("Piece1.Shape50", 0, 0);
        this.setTextureOffset("Piece1.Shape51", 0, 0);
        this.setTextureOffset("Piece1.Shape52", 0, 0);
        this.setTextureOffset("Piece1.Shape53", 0, 0);
        this.setTextureOffset("Piece1.Shape54", 0, 0);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.setRotation(this.Piece1, 0.0F, 0.0F, 0.0F);
        this.Piece1.mirror = true;
        this.Piece1.addBox("Shape1", -5.0F, -1.0F, -1.0F, 1, 2, 2);
        this.Piece1.addBox("Shape2", -1.0F, -1.0F, -5.0F, 2, 2, 10);
        this.Piece1.addBox("Shape3", -3.0F, -1.0F, -4.0F, 2, 2, 8);
        this.Piece1.addBox("Shape4", -4.0F, -1.0F, -3.0F, 1, 2, 6);
        this.Piece1.addBox("Shape5", 4.0F, -1.0F, -1.0F, 1, 2, 2);
        this.Piece1.addBox("Shape6", 3.0F, -1.0F, -3.0F, 1, 2, 6);
        this.Piece1.addBox("Shape7", 1.0F, -1.0F, -4.0F, 2, 2, 8);
        this.Piece1.addBox("Shape8", -2.0F, 1.0F, -6.0F, 4, 1, 12);
        this.Piece1.addBox("Shape9", -4.0F, 1.0F, -5.0F, 2, 1, 10);
        this.Piece1.addBox("Shape10", -6.0F, 1.0F, -2.0F, 1, 1, 4);
        this.Piece1.addBox("Shape11", -5.0F, 1.0F, -4.0F, 1, 1, 8);
        this.Piece1.addBox("Shape12", 2.0F, 1.0F, -5.0F, 2, 1, 10);
        this.Piece1.addBox("Shape13", 4.0F, 1.0F, -4.0F, 1, 1, 8);
        this.Piece1.addBox("Shape14", 5.0F, 1.0F, -2.0F, 1, 1, 4);
        this.Piece1.addBox("Shape15", 5.0F, -2.0F, -2.0F, 1, 1, 4);
        this.Piece1.addBox("Shape16", 4.0F, -2.0F, -4.0F, 1, 1, 8);
        this.Piece1.addBox("Shape17", 2.0F, -2.0F, -5.0F, 2, 1, 10);
        this.Piece1.addBox("Shape18", -2.0F, -2.0F, -6.0F, 4, 1, 12);
        this.Piece1.addBox("Shape19", -5.0F, -2.0F, -4.0F, 1, 1, 8);
        this.Piece1.addBox("Shape20", -4.0F, -2.0F, -5.0F, 2, 1, 10);
        this.Piece1.addBox("Shape21", -6.0F, -2.0F, -2.0F, 1, 1, 4);
        this.Piece1.addBox("Shape22", 0.0F, 0.0F, 0.0F, 1, 1, 1);
        this.Piece1.addBox("Shape23", -3.0F, 1.5F, -4.0F, 1, 1, 2);
        this.Piece1.addBox("Shape24", 4.0F, 1.5F, -1.0F, 1, 1, 2);
        this.Piece1.addBox("Shape25", -5.0F, 1.5F, -1.0F, 1, 1, 2);
        this.Piece1.addBox("Shape26", -2.0F, 1.5F, -1.0F, 1, 1, 2);
        this.Piece1.addBox("Shape27", 1.0F, 1.5F, -1.0F, 1, 1, 2);
        this.Piece1.addBox("Shape28", -3.0F, 1.5F, 2.0F, 1, 1, 2);
        this.Piece1.addBox("Shape29", 2.0F, 1.5F, 2.0F, 1, 1, 2);
        this.Piece1.addBox("Shape30", 2.0F, 1.5F, -4.0F, 1, 1, 2);
        this.Piece1.addBox("Shape31", -4.0F, 1.5F, 2.0F, 1, 1, 1);
        this.Piece1.addBox("Shape32", -1.0F, 1.5F, 1.0F, 2, 1, 1);
        this.Piece1.addBox("Shape33", -1.0F, 1.5F, 4.0F, 2, 1, 1);
        this.Piece1.addBox("Shape34", -1.0F, 1.5F, -2.0F, 2, 1, 1);
        this.Piece1.addBox("Shape35", -1.0F, 1.5F, -5.0F, 2, 1, 1);
        this.Piece1.addBox("Shape36", -4.0F, 1.5F, -3.0F, 1, 1, 1);
        this.Piece1.addBox("Shape37", 3.0F, 1.5F, 2.0F, 1, 1, 1);
        this.Piece1.addBox("Shape38", 3.0F, 1.5F, -3.0F, 1, 1, 1);
        this.Piece1.addBox("Shape39", -5.0F, -2.5F, -1.0F, 1, 1, 2);
        this.Piece1.addBox("Shape40", -4.0F, -2.5F, -3.0F, 1, 1, 1);
        this.Piece1.addBox("Shape41", -3.0F, -2.5F, -4.0F, 1, 1, 2);
        this.Piece1.addBox("Shape42", -1.0F, -2.5F, -5.0F, 2, 1, 1);
        this.Piece1.addBox("Shape43", 2.0F, -2.5F, -4.0F, 1, 1, 2);
        this.Piece1.addBox("Shape44", 3.0F, -2.5F, -3.0F, 1, 1, 1);
        this.Piece1.addBox("Shape45", 4.0F, -2.5F, -1.0F, 1, 1, 2);
        this.Piece1.addBox("Shape46", 1.0F, -2.5F, -1.0F, 1, 1, 2);
        this.Piece1.addBox("Shape47", 2.0F, -2.5F, 2.0F, 1, 1, 2);
        this.Piece1.addBox("Shape48", 3.0F, -2.5F, 2.0F, 1, 1, 1);
        this.Piece1.addBox("Shape49", -2.0F, -2.5F, -1.0F, 1, 1, 2);
        this.Piece1.addBox("Shape50", -1.0F, -2.5F, 1.0F, 2, 1, 1);
        this.Piece1.addBox("Shape51", -4.0F, -2.5F, 2.0F, 1, 1, 1);
        this.Piece1.addBox("Shape52", -3.0F, -2.5F, 2.0F, 1, 1, 2);
        this.Piece1.addBox("Shape53", -1.0F, -2.5F, 4.0F, 2, 1, 1);
        this.Piece1.addBox("Shape54", -1.0F, -2.5F, -2.0F, 2, 1, 1);
        this.setTexture(new ResourceLocation("minidot", "pets/oreo.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.05F) * 0.06F;
        float f1 = time * 0.6F;
        float f2 = -time * 0.6F;
        GlStateManager.translate(0.8F, -0.5F + f, 0.5F);
        GlStateManager.rotate(f1 * 4.0F, 0.0F, 0.6F, time + 0.0F);
        GlStateManager.rotate(0.0F + f2, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(90.0F + f2, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(90.0F + f1, 0.0F, 0.0F, 1.0F);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
    }

    public void renderAsItem(float time)
    {
        float f = time * 0.6F;
        float f1 = -time * 0.6F;
        GlStateManager.rotate(f * 4.0F, 0.0F, 0.6F, time + 0.0F);
        GlStateManager.rotate(0.0F + f1, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(90.0F + f1, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(90.0F + f, 0.0F, 0.0F, 1.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041f\u0435\u0447\u0435\u043d\u044c\u043a\u0430 Oreo";
    }
}
