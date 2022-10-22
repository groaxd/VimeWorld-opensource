package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class HelmetZombie extends BaseHelm
{
    private final MModelRenderer Piece1;

    public HelmetZombie()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.setTextureOffset("Piece1.Shape2", 38, 0);
        this.setTextureOffset("Piece1.Shape3", 40, 41);
        this.setTextureOffset("Piece1.Shape4", 0, 41);
        this.setTextureOffset("Piece1.Shape5", 14, 38);
        this.setTextureOffset("Piece1.Shape6", 25, 53);
        this.setTextureOffset("Piece1.Shape7", 30, 53);
        this.setTextureOffset("Piece1.Shape8", 29, 24);
        this.setTextureOffset("Piece1.Shape9", 29, 24);
        this.setTextureOffset("Piece1.Shape10", 2, 28);
        this.setTextureOffset("Piece1.Shape11", 39, 21);
        this.setTextureOffset("Piece1.Shape12", 39, 21);
        this.setTextureOffset("Piece1.Shape13", 39, 21);
        this.setTextureOffset("Piece1.Shape14", 39, 21);
        this.setTextureOffset("Piece1.Shape15", 39, 21);
        this.setTextureOffset("Piece1.Shape16", 0, 47);
        this.setTextureOffset("Piece1.Shape17", 0, 40);
        this.setTextureOffset("Piece1.Shape18", 0, 5);
        this.setTextureOffset("Piece1.Shape19", 50, 21);
        this.setTextureOffset("Piece1.Shape20", 50, 21);
        this.setTextureOffset("Piece1.Shape21", 50, 21);
        this.setTextureOffset("Piece1.Shape22", 50, 21);
        this.setTextureOffset("Piece1.Shape23", 50, 21);
        this.setTextureOffset("Piece1.Shape24", 50, 21);
        this.setTextureOffset("Piece1.Shape25", 50, 21);
        this.setTextureOffset("Piece1.Shape26", 60, 23);
        this.setTextureOffset("Piece1.Shape27", 60, 23);
        this.setTextureOffset("Piece1.Shape28", 60, 23);
        this.setTextureOffset("Piece1.Shape29", 60, 23);
        this.setTextureOffset("Piece1.Shape30", 60, 23);
        this.setTextureOffset("Piece1.Shape31", 60, 23);
        this.setTextureOffset("Piece1.Shape32", 42, 25);
        this.setTextureOffset("Piece1.Shape33", 42, 25);
        this.setTextureOffset("Piece1.Shape34", 42, 25);
        this.setTextureOffset("Piece1.Shape35", 42, 25);
        this.setTextureOffset("Piece1.Shape36", 42, 25);
        this.setTextureOffset("Piece1.Shape37", 42, 25);
        this.setTextureOffset("Piece1.Shape38", 42, 25);
        this.setTextureOffset("Piece1.Shape39", 42, 25);
        this.setTextureOffset("Piece1.Shape40", 42, 25);
        this.setTextureOffset("Piece1.Shape41", 42, 25);
        this.setTextureOffset("Piece1.Shape42", 42, 25);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.addBox("Shape2", -6.0F, -11.0F, -6.0F, 12, 12, 1);
        this.Piece1.addBox("Shape3", 5.0F, -11.0F, -5.0F, 1, 12, 11);
        this.Piece1.addBox("Shape4", -6.0F, -11.0F, -5.0F, 1, 12, 11);
        this.Piece1.addBox("Shape5", -5.0F, -11.0F, 6.0F, 10, 12, 1);
        this.Piece1.addBox("Shape6", -6.0F, -10.0F, 6.0F, 1, 10, 1);
        this.Piece1.addBox("Shape7", 5.0F, -10.0F, 6.0F, 1, 10, 1);
        this.Piece1.addBox("Shape8", 6.0F, -2.0F, -7.0F, 1, 3, 5);
        this.Piece1.addBox("Shape9", -7.0F, -2.0F, -7.0F, 1, 3, 5);
        this.Piece1.addBox("Shape10", -6.0F, -2.0F, -7.0F, 12, 3, 1);
        this.Piece1.addBox("Shape11", 6.0F, -3.0F, -5.0F, 1, 1, 2);
        this.Piece1.addBox("Shape12", -7.0F, -3.0F, -5.0F, 1, 1, 2);
        this.Piece1.addBox("Shape13", -6.0F, -3.0F, -7.0F, 2, 1, 1);
        this.Piece1.addBox("Shape14", 4.0F, -3.0F, -7.0F, 2, 1, 1);
        this.Piece1.addBox("Shape15", -2.0F, -3.0F, -7.0F, 4, 1, 1);
        this.Piece1.addBox("Shape16", -4.0F, -7.0F, -7.0F, 2, 2, 1);
        this.Piece1.addBox("Shape17", 1.0F, -8.0F, -8.0F, 3, 3, 2);
        this.Piece1.addBox("Shape18", -5.0F, -11.0F, -5.0F, 10, 1, 11);
        this.Piece1.addBox("Shape19", 0.0F, -11.0F, 7.0F, 6, 9, 1);
        this.Piece1.addBox("Shape20", 2.0F, -2.0F, 7.0F, 3, 1, 1);
        this.Piece1.addBox("Shape21", -5.0F, -4.0F, 7.0F, 1, 1, 1);
        this.Piece1.addBox("Shape22", -1.0F, -10.0F, 7.0F, 1, 10, 1);
        this.Piece1.addBox("Shape23", -2.0F, -9.0F, 7.0F, 1, 9, 1);
        this.Piece1.addBox("Shape24", -3.0F, -8.0F, 7.0F, 1, 7, 1);
        this.Piece1.addBox("Shape25", -4.0F, -6.0F, 7.0F, 1, 5, 1);
        this.Piece1.addBox("Shape26", 6.0F, -11.0F, 1.0F, 1, 2, 1);
        this.Piece1.addBox("Shape27", 6.0F, -11.0F, 6.0F, 1, 8, 1);
        this.Piece1.addBox("Shape28", 6.0F, -11.0F, 5.0F, 1, 7, 1);
        this.Piece1.addBox("Shape29", 6.0F, -11.0F, 3.0F, 1, 5, 1);
        this.Piece1.addBox("Shape30", 6.0F, -11.0F, 4.0F, 1, 6, 1);
        this.Piece1.addBox("Shape31", 6.0F, -11.0F, 2.0F, 1, 4, 1);
        this.Piece1.addBox("Shape32", 0.0F, -12.0F, 2.0F, 1, 1, 5);
        this.Piece1.addBox("Shape33", -1.0F, -12.0F, 5.0F, 1, 1, 1);
        this.Piece1.addBox("Shape34", -2.0F, -12.0F, -2.0F, 7, 1, 1);
        this.Piece1.addBox("Shape35", 1.0F, -12.0F, 1.0F, 5, 1, 6);
        this.Piece1.addBox("Shape36", 0.0F, -12.0F, 0.0F, 5, 1, 1);
        this.Piece1.addBox("Shape37", -1.0F, -12.0F, -1.0F, 7, 1, 1);
        this.Piece1.addBox("Shape38", -1.0F, -12.0F, -4.0F, 3, 1, 2);
        this.Piece1.addBox("Shape39", 3.0F, -12.0F, -4.0F, 1, 1, 2);
        this.Piece1.addBox("Shape40", 0.0F, -14.0F, -5.0F, 1, 3, 1);
        this.Piece1.addBox("Shape41", 0.0F, -13.0F, -4.0F, 2, 1, 1);
        this.Piece1.addBox("Shape42", -1.0F, -13.0F, -5.0F, 1, 2, 1);
        this.setTexture(new ResourceLocation("minidot", "head/helmet_zombie.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(0.76F, 0.76F, 0.76F);
        GlStateManager.translate(0.0F, -0.05F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.55F, 0.55F, 0.55F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0417\u043e\u043c\u0431\u0438";
    }
}
