package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class HelmetEagle extends BaseHelm
{
    private final MModelRenderer Piece1;

    public HelmetEagle()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.setTextureOffset("Piece1.Shape1", 0, 0);
        this.setTextureOffset("Piece1.Shape2", 40, 52);
        this.setTextureOffset("Piece1.Shape3", 42, 31);
        this.setTextureOffset("Piece1.Shape4", 42, 0);
        this.setTextureOffset("Piece1.Shape5", 31, 44);
        this.setTextureOffset("Piece1.Shape6", 42, 31);
        this.setTextureOffset("Piece1.Shape7", 15, 31);
        this.setTextureOffset("Piece1.Shape8", 31, 55);
        this.setTextureOffset("Piece1.Shape9", 15, 36);
        this.setTextureOffset("Piece1.Shape10", 31, 48);
        this.setTextureOffset("Piece1.Shape11", 31, 48);
        this.setTextureOffset("Piece1.Shape12", 31, 48);
        this.setTextureOffset("Piece1.Shape13", 0, 42);
        this.setTextureOffset("Piece1.Shape14", 0, 42);
        this.setTextureOffset("Piece1.Shape15", 0, 42);
        this.setTextureOffset("Piece1.Shape16", 0, 42);
        this.setTextureOffset("Piece1.Shape17", 31, 58);
        this.setTextureOffset("Piece1.Shape18", 9, 44);
        this.setTextureOffset("Piece1.Shape19", 8, 43);
        this.setTextureOffset("Piece1.Shape20", 22, 44);
        this.setTextureOffset("Piece1.Shape21", 9, 56);
        this.setTextureOffset("Piece1.Shape22", 0, 45);
        this.setTextureOffset("Piece1.Shape23", 0, 42);
        this.setTextureOffset("Piece1.Shape24", 0, 42);
        this.setTextureOffset("Piece1.Shape25", 0, 42);
        this.setTextureOffset("Piece1.Shape26", 0, 45);
        this.setTextureOffset("Piece1.Shape27", 9, 44);
        this.setTextureOffset("Piece1.Shape28", 0, 55);
        this.setTextureOffset("Piece1.Shape29", 8, 43);
        this.setTextureOffset("Piece1.Shape30", 22, 44);
        this.setTextureOffset("Piece1.Shape31", 31, 58);
        this.setTextureOffset("Piece1.Shape32", 0, 42);
        this.setTextureOffset("Piece1.Shape33", 0, 45);
        this.setTextureOffset("Piece1.Shape34", 0, 42);
        this.setTextureOffset("Piece1.Shape35", 0, 45);
        this.setTextureOffset("Piece1.Shape36", 0, 42);
        this.setTextureOffset("Piece1.Shape37", 0, 55);
        this.setTextureOffset("Piece1.Shape38", 0, 55);
        this.setTextureOffset("Piece1.Shape39", 0, 0);
        this.setTextureOffset("Piece1.Shape40", 0, 0);
        this.setTextureOffset("Piece1.Shape41", 0, 0);
        this.setTextureOffset("Piece1.Shape42", 0, 0);
        this.setTextureOffset("Piece1.Shape43", 0, 0);
        this.setTextureOffset("Piece1.Shape44", 0, 0);
        this.setTextureOffset("Piece1.Shape45", 0, 55);
        this.setTextureOffset("Piece1.Shape46", 0, 55);
        this.setTextureOffset("Piece1.Shape47", 55, 31);
        this.setTextureOffset("Piece1.Shape48", 0, 60);
        this.setTextureOffset("Piece1.Shape49", 0, 60);
        this.setTextureOffset("Piece1.Shape50", 0, 60);
        this.setTextureOffset("Piece1.Shape51", 0, 60);
        this.setTextureOffset("Piece1.Shape52", 0, 50);
        this.setTextureOffset("Piece1.Shape53", 32, 52);
        this.setTextureOffset("Piece1.Shape54", 15, 40);
        this.setTextureOffset("Piece1.Shape56", 0, 50);
        this.setTextureOffset("Piece1.Shape57", 40, 52);
        this.setTextureOffset("Piece1.Shape58", 0, 50);
        this.setTextureOffset("Piece1.Shape59", 0, 55);
        this.setTextureOffset("Piece1.Shape60", 55, 31);
        this.setTextureOffset("Piece1.Shape61", 0, 55);
        this.setTextureOffset("Piece1.Shape62", 42, 55);
        this.setTextureOffset("Piece1.Shape64", 41, 19);
        this.setTextureOffset("Piece1.Shape65", 0, 50);
        this.setTextureOffset("Piece1.Shape67", 0, 19);
        this.setTextureOffset("Piece1.Shape68", 60, 60);
        this.setTextureOffset("Piece1.Shape69", 54, 55);
        this.setTextureOffset("Piece1.Shape70", 60, 60);
        this.setTextureOffset("Piece1.Shape71", 0, 55);
        this.setTextureOffset("Piece1.Shape72", 0, 19);
        this.setTextureOffset("Piece1.Shape73", 0, 55);
        this.setTextureOffset("Piece1.Shape74", 41, 19);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.addBox("Shape1", -6.0F, -10.0F, -6.0F, 12, 1, 12);
        this.Piece1.addBox("Shape2", -7.0F, -13.0F, -4.0F, 1, 1, 11);
        this.Piece1.addBox("Shape3", 5.0F, -9.0F, -4.0F, 1, 10, 10);
        this.Piece1.addBox("Shape4", -5.0F, -9.0F, 5.0F, 10, 10, 1);
        this.Piece1.addBox("Shape5", 2.0F, -6.0F, 6.0F, 4, 2, 1);
        this.Piece1.addBox("Shape6", -6.0F, -9.0F, -4.0F, 1, 10, 10);
        this.Piece1.addBox("Shape7", -6.0F, -4.0F, 6.0F, 12, 3, 1);
        this.Piece1.addBox("Shape8", -6.0F, -6.0F, 6.0F, 4, 2, 1);
        this.Piece1.addBox("Shape9", -6.0F, -8.0F, 6.0F, 12, 2, 1);
        this.Piece1.addBox("Shape10", -1.0F, -1.0F, 6.0F, 2, 2, 1);
        this.Piece1.addBox("Shape11", -5.0F, -1.0F, 6.0F, 2, 2, 1);
        this.Piece1.addBox("Shape12", 3.0F, -1.0F, 6.0F, 2, 2, 1);
        this.Piece1.addBox("Shape13", -6.0F, -1.0F, 6.0F, 1, 1, 1);
        this.Piece1.addBox("Shape14", -2.0F, -1.0F, 6.0F, 1, 1, 1);
        this.Piece1.addBox("Shape15", 1.0F, -1.0F, 6.0F, 1, 1, 1);
        this.Piece1.addBox("Shape16", 5.0F, -1.0F, 6.0F, 1, 1, 1);
        this.Piece1.addBox("Shape17", 6.0F, -4.0F, -1.0F, 1, 3, 3);
        this.Piece1.addBox("Shape18", 6.0F, -8.0F, -4.0F, 1, 1, 10);
        this.Piece1.addBox("Shape19", 6.0F, -7.0F, 2.0F, 1, 6, 4);
        this.Piece1.addBox("Shape20", 6.0F, -7.0F, -4.0F, 1, 6, 3);
        this.Piece1.addBox("Shape21", -5.0F, -9.0F, -6.0F, 10, 7, 1);
        this.Piece1.addBox("Shape22", 6.0F, -1.0F, -2.0F, 1, 2, 2);
        this.Piece1.addBox("Shape23", 6.0F, -1.0F, -3.0F, 1, 1, 1);
        this.Piece1.addBox("Shape24", 6.0F, -1.0F, 5.0F, 1, 1, 1);
        this.Piece1.addBox("Shape25", 6.0F, -1.0F, 1.0F, 1, 1, 1);
        this.Piece1.addBox("Shape26", 6.0F, -1.0F, 2.0F, 1, 2, 2);
        this.Piece1.addBox("Shape27", -7.0F, -8.0F, -4.0F, 1, 1, 10);
        this.Piece1.addBox("Shape28", -7.0F, -6.0F, 0.0F, 1, 1, 1);
        this.Piece1.addBox("Shape29", -7.0F, -7.0F, 2.0F, 1, 6, 4);
        this.Piece1.addBox("Shape30", -7.0F, -7.0F, -4.0F, 1, 6, 3);
        this.Piece1.addBox("Shape31", -7.0F, -4.0F, -1.0F, 1, 3, 3);
        this.Piece1.addBox("Shape32", -7.0F, -1.0F, -3.0F, 1, 1, 1);
        this.Piece1.addBox("Shape33", -7.0F, -1.0F, -2.0F, 1, 2, 2);
        this.Piece1.addBox("Shape34", -7.0F, -1.0F, 1.0F, 1, 1, 1);
        this.Piece1.addBox("Shape35", -7.0F, -1.0F, 2.0F, 1, 2, 2);
        this.Piece1.addBox("Shape36", -7.0F, -1.0F, 5.0F, 1, 1, 1);
        this.Piece1.addBox("Shape37", 6.0F, -6.0F, 0.0F, 1, 1, 1);
        this.Piece1.addBox("Shape38", -7.0F, -8.0F, -6.0F, 1, 2, 2);
        this.Piece1.addBox("Shape39", 6.0F, -8.0F, -7.0F, 1, 1, 1);
        this.Piece1.addBox("Shape40", 6.0F, -8.0F, -6.0F, 1, 2, 2);
        this.Piece1.addBox("Shape41", 5.0F, -9.0F, -6.0F, 1, 7, 2);
        this.Piece1.addBox("Shape42", 6.0F, -8.0F, -7.0F, 1, 1, 1);
        this.Piece1.addBox("Shape43", 6.0F, -8.0F, -6.0F, 1, 2, 2);
        this.Piece1.addBox("Shape44", 5.0F, -9.0F, -6.0F, 1, 7, 2);
        this.Piece1.addBox("Shape45", 6.0F, -8.0F, -7.0F, 1, 1, 1);
        this.Piece1.addBox("Shape46", 6.0F, -8.0F, -6.0F, 1, 2, 2);
        this.Piece1.addBox("Shape47", 5.0F, -9.0F, -6.0F, 1, 7, 2);
        this.Piece1.addBox("Shape48", 2.0F, -2.0F, -6.0F, 3, 1, 1);
        this.Piece1.addBox("Shape49", -5.0F, -2.0F, -6.0F, 3, 1, 1);
        this.Piece1.addBox("Shape50", -1.0F, -4.0F, -8.0F, 2, 2, 2);
        this.Piece1.addBox("Shape51", -1.0F, -2.0F, -8.0F, 2, 1, 1);
        this.Piece1.addBox("Shape52", -2.0F, -12.0F, -7.0F, 1, 3, 1);
        this.Piece1.addBox("Shape53", -3.0F, -7.0F, -7.0F, 6, 1, 1);
        this.Piece1.addBox("Shape54", -6.0F, -9.0F, -7.0F, 12, 2, 1);
        this.Piece1.addBox("Shape56", 1.0F, -13.0F, -8.0F, 1, 3, 1);
        this.Piece1.addBox("Shape57", 6.0F, -13.0F, -4.0F, 1, 1, 11);
        this.Piece1.addBox("Shape58", -2.0F, -13.0F, -8.0F, 1, 3, 1);
        this.Piece1.addBox("Shape59", -5.0F, -11.0F, -7.0F, 1, 2, 1);
        this.Piece1.addBox("Shape60", -6.0F, -9.0F, -6.0F, 1, 7, 2);
        this.Piece1.addBox("Shape61", 4.0F, -11.0F, -7.0F, 1, 2, 1);
        this.Piece1.addBox("Shape62", -6.0F, -12.0F, -6.0F, 2, 1, 2);
        this.Piece1.addBox("Shape64", 4.0F, -11.0F, -6.0F, 1, 1, 10);
        this.Piece1.addBox("Shape65", 1.0F, -12.0F, -7.0F, 1, 3, 1);
        this.Piece1.addBox("Shape67", 5.0F, -12.0F, -4.0F, 1, 1, 10);
        this.Piece1.addBox("Shape68", -6.0F, -13.0F, -4.0F, 1, 1, 1);
        this.Piece1.addBox("Shape69", 4.0F, -12.0F, -6.0F, 2, 1, 2);
        this.Piece1.addBox("Shape70", 5.0F, -13.0F, -4.0F, 1, 1, 1);
        this.Piece1.addBox("Shape71", -1.0F, -6.0F, -7.0F, 2, 1, 1);
        this.Piece1.addBox("Shape72", -6.0F, -12.0F, -4.0F, 1, 1, 10);
        this.Piece1.addBox("Shape73", -7.0F, -8.0F, -7.0F, 1, 1, 1);
        this.Piece1.addBox("Shape74", -5.0F, -11.0F, -6.0F, 1, 1, 10);
        this.setTexture(new ResourceLocation("minidot", "head/helmet_eagle.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.translate(0.0F, -0.04F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.05F, 0.0F);
        GlStateManager.scale(0.6F, 0.6F, 0.6F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0428\u043b\u0435\u043c \u043e\u0440\u043b\u0430";
    }
}
