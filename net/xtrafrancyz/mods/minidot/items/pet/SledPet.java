package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class SledPet extends BasePet
{
    private final MModelRenderer Piece1;

    public SledPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("Piece1.Shape1", 0, 24);
        this.setTextureOffset("Piece1.Shape2", 1, 24);
        this.setTextureOffset("Piece1.Shape3", 0, 24);
        this.setTextureOffset("Piece1.Shape4", 0, 24);
        this.setTextureOffset("Piece1.Shape5", 0, 24);
        this.setTextureOffset("Piece1.Shape6", 0, 11);
        this.setTextureOffset("Piece1.Shape7", 40, 0);
        this.setTextureOffset("Piece1.Shape8", 40, 0);
        this.setTextureOffset("Piece1.Shape9", 40, 0);
        this.setTextureOffset("Piece1.Shape10", 40, 0);
        this.setTextureOffset("Piece1.Shape11", 40, 0);
        this.setTextureOffset("Piece1.Shape12", 40, 0);
        this.setTextureOffset("Piece1.Shape13", 40, 0);
        this.setTextureOffset("Piece1.Shape14", 40, 0);
        this.setTextureOffset("Piece1.Shape15", 40, 0);
        this.setTextureOffset("Piece1.Shape16", 40, 0);
        this.setTextureOffset("Piece1.Shape17", 40, 0);
        this.setTextureOffset("Piece1.Shape18", 40, 0);
        this.setTextureOffset("Piece1.Shape19", 40, 0);
        this.setTextureOffset("Piece1.Shape20", 40, 0);
        this.setTextureOffset("Piece1.Shape21", 40, 0);
        this.setTextureOffset("Piece1.Shape22", 40, 0);
        this.setTextureOffset("Piece1.Shape23", 40, 0);
        this.setTextureOffset("Piece1.Shape24", 40, 0);
        this.setTextureOffset("Piece1.Shape25", 40, 0);
        this.setTextureOffset("Piece1.Shape26", 40, 0);
        this.setTextureOffset("Piece1.Shape27", 40, 0);
        this.setTextureOffset("Piece1.Shape28", 40, 0);
        this.setTextureOffset("Piece1.Shape29", 0, 24);
        this.setTextureOffset("Piece1.Shape30", 40, 0);
        this.setTextureOffset("Piece1.Shape31", 40, 0);
        this.setTextureOffset("Piece1.Shape32", 40, 0);
        this.setTextureOffset("Piece1.Shape33", 0, 24);
        this.setTextureOffset("Piece1.Shape34", 40, 0);
        this.setTextureOffset("Piece1.Shape35", 40, 0);
        this.setTextureOffset("Piece1.Shape36", 40, 0);
        this.setTextureOffset("Piece1.Shape37", 0, 24);
        this.setTextureOffset("Piece1.Shape38", 0, 24);
        this.setTextureOffset("Piece1.Shape39", 0, 24);
        this.setTextureOffset("Piece1.Shape40", 0, 24);
        this.setTextureOffset("Piece1.Shape41", 8, 25);
        this.setTextureOffset("Piece1.Shape42", 8, 25);
        this.setTextureOffset("Piece1.Shape43", 0, 24);
        this.setTextureOffset("Piece1.Shape44", 0, 24);
        this.setTextureOffset("Piece1.Shape45", 0, 11);
        this.setTextureOffset("Piece1.Shape46", 0, 24);
        this.setTextureOffset("Piece1.Shape47", 12, 17);
        this.setTextureOffset("Piece1.Shape48", 17, 15);
        this.setTextureOffset("Piece1.Shape49", 0, 17);
        this.setTextureOffset("Piece1.Shape50", 7, 17);
        this.setTextureOffset("Piece1.Shape51", 0, 11);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.setRotation(this.Piece1, 0.0F, 0.0F, 0.0F);
        this.Piece1.mirror = true;
        this.Piece1.addBox("Shape1", -4.0F, 0.0F, 0.0F, 8, 1, 1);
        this.Piece1.addBox("Shape2", -3.0F, 0.0F, 1.0F, 6, 1, 1);
        this.Piece1.addBox("Shape3", -3.0F, 1.0F, 2.0F, 6, 2, 1);
        this.Piece1.addBox("Shape4", -3.0F, 3.0F, 3.0F, 6, 1, 7);
        this.Piece1.addBox("Shape5", -4.0F, 2.0F, 9.0F, 8, 1, 1);
        this.Piece1.addBox("Shape6", -3.0F, 2.0F, 4.0F, 6, 1, 2);
        this.Piece1.addBox("Shape7", 3.0F, 0.0F, -1.0F, 1, 2, 1);
        this.Piece1.addBox("Shape8", 3.0F, 1.0F, 0.0F, 1, 1, 1);
        this.Piece1.addBox("Shape9", 3.0F, 3.0F, -1.0F, 1, 2, 2);
        this.Piece1.addBox("Shape10", 3.0F, -1.0F, 0.0F, 1, 1, 2);
        this.Piece1.addBox("Shape11", -4.0F, -1.0F, 0.0F, 1, 1, 2);
        this.Piece1.addBox("Shape12", -4.0F, 3.0F, -1.0F, 1, 2, 2);
        this.Piece1.addBox("Shape13", -4.0F, 0.0F, -1.0F, 1, 2, 1);
        this.Piece1.addBox("Shape14", -4.0F, 1.0F, 0.0F, 1, 1, 1);
        this.Piece1.addBox("Shape15", 3.0F, 0.0F, 2.0F, 1, 2, 1);
        this.Piece1.addBox("Shape16", -4.0F, 0.0F, 2.0F, 1, 2, 1);
        this.Piece1.addBox("Shape17", 3.0F, 2.0F, 3.0F, 1, 2, 1);
        this.Piece1.addBox("Shape18", -4.0F, 2.0F, 3.0F, 1, 2, 1);
        this.Piece1.addBox("Shape19", -4.0F, 5.0F, 0.0F, 1, 1, 11);
        this.Piece1.addBox("Shape20", -4.0F, 4.0F, 4.0F, 1, 1, 1);
        this.Piece1.addBox("Shape21", -4.0F, 4.0F, 8.0F, 1, 1, 1);
        this.Piece1.addBox("Shape22", -4.0F, 3.0F, 4.0F, 1, 1, 6);
        this.Piece1.addBox("Shape23", 3.0F, 3.0F, 4.0F, 1, 1, 6);
        this.Piece1.addBox("Shape24", 3.0F, 5.0F, 0.0F, 1, 1, 11);
        this.Piece1.addBox("Shape25", 3.0F, 4.0F, 4.0F, 1, 1, 1);
        this.Piece1.addBox("Shape26", 3.0F, 4.0F, 8.0F, 1, 1, 1);
        this.Piece1.addBox("Shape27", -4.0F, -1.0F, 10.0F, 1, 4, 1);
        this.Piece1.addBox("Shape28", -4.0F, -1.0F, 7.0F, 1, 3, 1);
        this.Piece1.addBox("Shape29", -4.0F, 1.0F, 9.0F, 1, 1, 1);
        this.Piece1.addBox("Shape30", -4.0F, 1.0F, 8.0F, 1, 1, 1);
        this.Piece1.addBox("Shape31", 3.0F, 1.0F, 8.0F, 1, 1, 1);
        this.Piece1.addBox("Shape32", 3.0F, -1.0F, 7.0F, 1, 3, 1);
        this.Piece1.addBox("Shape33", 3.0F, 1.0F, 9.0F, 1, 1, 1);
        this.Piece1.addBox("Shape34", 3.0F, -1.0F, 10.0F, 1, 4, 1);
        this.Piece1.addBox("Shape35", 3.0F, -1.0F, 8.0F, 1, 1, 2);
        this.Piece1.addBox("Shape36", -4.0F, -1.0F, 8.0F, 1, 1, 2);
        this.Piece1.addBox("Shape37", 3.0F, -1.0F, 6.0F, 1, 2, 1);
        this.Piece1.addBox("Shape38", -4.0F, -1.0F, 6.0F, 1, 2, 1);
        this.Piece1.addBox("Shape39", 3.0F, 0.0F, 8.0F, 1, 1, 2);
        this.Piece1.addBox("Shape40", -4.0F, 0.0F, 8.0F, 1, 1, 2);
        this.Piece1.addBox("Shape41", 3.0F, 2.0F, 4.0F, 1, 1, 5);
        this.Piece1.addBox("Shape42", -4.0F, 2.0F, 4.0F, 1, 1, 5);
        this.Piece1.addBox("Shape43", 3.0F, 1.0F, 3.0F, 1, 1, 4);
        this.Piece1.addBox("Shape44", -4.0F, 1.0F, 3.0F, 1, 1, 4);
        this.Piece1.addBox("Shape45", -3.0F, -1.0F, 6.0F, 6, 3, 1);
        this.Piece1.addBox("Shape46", -3.0F, -1.0F, 10.0F, 6, 3, 1);
        this.Piece1.addBox("Shape47", 2.0F, -3.0F, 9.0F, 1, 1, 1);
        this.Piece1.addBox("Shape48", -3.0F, -2.0F, 7.0F, 6, 1, 3);
        this.Piece1.addBox("Shape49", -1.0F, -3.0F, 7.0F, 2, 1, 1);
        this.Piece1.addBox("Shape50", -3.0F, -3.0F, 9.0F, 1, 1, 1);
        this.Piece1.addBox("Shape51", -2.0F, -2.0F, 6.0F, 4, 1, 1);
        this.setTexture(new ResourceLocation("minidot", "pets/sledpet.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        float f1 = MathHelper.cos(time * 0.16F);
        GlStateManager.translate(0.7F, -0.65F + f, 0.4F);
        GlStateManager.rotate(f1 * 3.0F, 0.2F, 0.0F, 0.0F);
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -0.1F, -0.2F);
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0421\u0430\u043d\u043a\u0438";
    }
}
