package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class Mandarin extends BasePet
{
    private final MModelRenderer Piece1;

    public Mandarin()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("Piece1.Shape1", 0, 0);
        this.setTextureOffset("Piece1.Shape2", 0, 0);
        this.setTextureOffset("Piece1.Shape3", 0, 0);
        this.setTextureOffset("Piece1.Shape4", 0, 0);
        this.setTextureOffset("Piece1.Shape5", 0, 0);
        this.setTextureOffset("Piece1.Shape6", 0, 0);
        this.setTextureOffset("Piece1.Shape7", 0, 0);
        this.setTextureOffset("Piece1.Shape8", 0, 0);
        this.setTextureOffset("Piece1.Shape9", 0, 0);
        this.setTextureOffset("Piece1.Shape10", 32, 21);
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
        this.setTextureOffset("Piece1.Shape38", 56, 0);
        this.setTextureOffset("Piece1.Shape39", 56, 0);
        this.setTextureOffset("Piece1.Shape40", 56, 0);
        this.setTextureOffset("Piece1.Shape41", 56, 0);
        this.setTextureOffset("Piece1.Shape42", 56, 0);
        this.setTextureOffset("Piece1.Shape43", 56, 0);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.addBox("Shape1", -4.0F, 7.0F, -6.0F, 8, 1, 12);
        this.Piece1.addBox("Shape2", -6.0F, 7.0F, -4.0F, 12, 1, 8);
        this.Piece1.addBox("Shape3", -5.0F, 7.0F, -5.0F, 10, 1, 10);
        this.Piece1.addBox("Shape4", -3.0F, 8.0F, -5.0F, 6, 1, 10);
        this.Piece1.addBox("Shape5", -4.0F, 8.0F, -4.0F, 8, 1, 8);
        this.Piece1.addBox("Shape6", -5.0F, 8.0F, -3.0F, 10, 1, 6);
        this.Piece1.addBox("Shape7", -6.0F, -5.0F, -6.0F, 12, 12, 12);
        this.Piece1.addBox("Shape8", -5.0F, -6.001F, -5.0F, 10, 1, 10);
        this.Piece1.addBox("Shape9", -6.0F, -6.0F, -4.0F, 12, 1, 8);
        this.Piece1.addBox("Shape10", -3.0F, -7.003F, -5.0F, 6, 1, 10);
        this.Piece1.addBox("Shape11", -4.0F, -7.002F, -4.0F, 8, 1, 8);
        this.Piece1.addBox("Shape12", -5.0F, -7.001F, -3.0F, 10, 1, 6);
        this.Piece1.addBox("Shape13", -4.0F, -6.002F, -6.0F, 8, 1, 12);
        this.Piece1.addBox("Shape14", -5.0F, -2.0F, -8.001F, 10, 6, 1);
        this.Piece1.addBox("Shape15", -3.0F, -4.0F, -8.0F, 6, 10, 1);
        this.Piece1.addBox("Shape16", -4.0F, -3.0F, -8.002F, 8, 8, 1);
        this.Piece1.addBox("Shape17", -6.0F, -3.0F, -7.001F, 12, 8, 1);
        this.Piece1.addBox("Shape18", -5.0F, -4.0F, -7.002F, 10, 10, 1);
        this.Piece1.addBox("Shape19", -4.0F, -5.0F, -7.0F, 8, 12, 1);
        this.Piece1.addBox("Shape20", 7.002F, -2.0F, -5.0F, 1, 6, 10);
        this.Piece1.addBox("Shape21", 7.001F, -4.0F, -3.0F, 1, 10, 6);
        this.Piece1.addBox("Shape22", 7.0F, -3.0F, -4.0F, 1, 8, 8);
        this.Piece1.addBox("Shape23", 6.002F, -4.0F, -5.0F, 1, 10, 10);
        this.Piece1.addBox("Shape24", 6.0F, -5.0F, -4.0F, 1, 12, 8);
        this.Piece1.addBox("Shape25", 6.001F, -3.0F, -6.0F, 1, 8, 12);
        this.Piece1.addBox("Shape26", -8.001F, -3.0F, -4.0F, 1, 8, 8);
        this.Piece1.addBox("Shape27", -8.0F, -4.0F, -3.0F, 1, 10, 6);
        this.Piece1.addBox("Shape28", -8.002F, -2.0F, -5.0F, 1, 6, 10);
        this.Piece1.addBox("Shape29", -7.002F, -3.0F, -6.0F, 1, 8, 12);
        this.Piece1.addBox("Shape30", -7.001F, -4.0F, -5.0F, 1, 10, 10);
        this.Piece1.addBox("Shape31", -7.0F, -5.0F, -4.0F, 1, 12, 8);
        this.Piece1.addBox("Shape32", -6.0F, -3.0F, 6.0F, 12, 8, 1);
        this.Piece1.addBox("Shape33", -5.0F, -4.0F, 6.002F, 10, 10, 1);
        this.Piece1.addBox("Shape34", -4.0F, -5.0F, 6.001F, 8, 12, 1);
        this.Piece1.addBox("Shape35", -3.0F, -4.0F, 7.001F, 6, 10, 1);
        this.Piece1.addBox("Shape36", -4.0F, -3.0F, 7.002F, 8, 8, 1);
        this.Piece1.addBox("Shape37", -5.0F, -2.0F, 7.0F, 10, 6, 1);
        this.Piece1.addBox("Shape38", -4.0F, -8.002F, -4.0F, 2, 1, 2);
        this.Piece1.addBox("Shape39", -2.0F, -8.0F, -2.0F, 2, 1, 2);
        this.Piece1.addBox("Shape40", -3.0F, -8.001F, -3.0F, 2, 1, 2);
        this.Piece1.addBox("Shape41", 3.0F, -8.002F, -4.0F, 2, 1, 2);
        this.Piece1.addBox("Shape42", 1.0F, -8.0F, -2.0F, 2, 1, 2);
        this.Piece1.addBox("Shape43", 2.0F, -8.001F, -3.0F, 2, 1, 2);
        this.setTexture(new ResourceLocation("minidot", "pets/mandarin.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        GlStateManager.scale(0.3F, 0.3F, 0.3F);
        GlStateManager.translate(2.6F, -1.5F + f, 1.3F);
        GlStateManager.rotate(time * 1.5F, 0.0F, 1.0F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.6F, 0.6F, 0.6F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041c\u0430\u043d\u0434\u0430\u0440\u0438\u043d\u043a\u0430";
    }
}
