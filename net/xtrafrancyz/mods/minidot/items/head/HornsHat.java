package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class HornsHat extends BaseItem
{
    private final MModelRenderer Piece1;

    public HornsHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("Piece1.Shape19", 38, 10);
        this.setTextureOffset("Piece1.Shape18", 11, 11);
        this.setTextureOffset("Piece1.Shape17", 21, 8);
        this.setTextureOffset("Piece1.Shape16", 32, 15);
        this.setTextureOffset("Piece1.Shape15", 33, 0);
        this.setTextureOffset("Piece1.Shape14", 0, 15);
        this.setTextureOffset("Piece1.Shape13", 33, 0);
        this.setTextureOffset("Piece1.Shape12", 33, 6);
        this.setTextureOffset("Piece1.Shape11", 33, 3);
        this.setTextureOffset("Piece1.Shape10", 24, 22);
        this.setTextureOffset("Piece1.Shape9", 33, 0);
        this.setTextureOffset("Piece1.Shape8", 0, 11);
        this.setTextureOffset("Piece1.Shape7", 28, 11);
        this.setTextureOffset("Piece1.Shape6", 0, 0);
        this.setTextureOffset("Piece1.Shape5", 0, 0);
        this.setTextureOffset("Piece1.Shape4", 0, 0);
        this.setTextureOffset("Piece1.Shape3", 0, 0);
        this.setTextureOffset("Piece1.Shape2", 0, 0);
        this.setTextureOffset("Piece1.Shape1", 16, 25);
        this.setTextureOffset("Piece1.Shape20", 11, 11);
        this.setTextureOffset("Piece1.Shape22", 28, 11);
        this.setTextureOffset("Piece1.Shape21", 16, 11);
        this.setTextureOffset("Piece1.Shape24", 0, 0);
        this.setTextureOffset("Piece1.Shape25", 0, 0);
        this.setTextureOffset("Piece1.Shape26", 0, 0);
        this.setTextureOffset("Piece1.Shape23", 6, 15);
        this.setTextureOffset("Piece1.Shape28", 0, 0);
        this.setTextureOffset("Piece1.Shape30", 0, 0);
        this.setTextureOffset("Piece1.Shape29", 0, 0);
        this.setTextureOffset("Piece1.Shape31", 0, 0);
        this.setTextureOffset("Piece1.Shape32", 0, 0);
        this.setTextureOffset("Piece1.Shape34", 0, 0);
        this.setTextureOffset("Piece1.Shape33", 0, 0);
        this.setTextureOffset("Piece1.Shape35", 0, 0);
        this.setTextureOffset("Piece1.Shape37", 0, 0);
        this.setTextureOffset("Piece1.Shape39", 16, 25);
        this.setTextureOffset("Piece1.Shape40", 25, 25);
        this.setTextureOffset("Piece1.Shape41", 16, 25);
        this.setTextureOffset("Piece1.Shape38", 0, 0);
        this.setTextureOffset("Piece1.Shape42", 16, 25);
        this.setTextureOffset("Piece1.Shape44", 25, 25);
        this.setTextureOffset("Piece1.Shape43", 25, 25);
        this.setTextureOffset("Piece1.Shape36", 0, 0);
        this.setTextureOffset("Piece1.Shape45", 25, 25);
        this.setTextureOffset("Piece1.Shape47", 0, 0);
        this.setTextureOffset("Piece1.Shape48", 0, 0);
        this.setTextureOffset("Piece1.Shape49", 0, 0);
        this.setTextureOffset("Piece1.Shape50", 0, 0);
        this.setTextureOffset("Piece1.Shape46", 2, 0);
        this.setTextureOffset("Piece1.Shape51", 0, 0);
        this.setTextureOffset("Piece1.Shape52", 0, 0);
        this.setTextureOffset("Piece1.Shape54", 0, 0);
        this.setTextureOffset("Piece1.Shape56", 0, 0);
        this.setTextureOffset("Piece1.Shape57", 0, 0);
        this.setTextureOffset("Piece1.Shape55", 0, 0);
        this.setTextureOffset("Piece1.Shape60", 0, 0);
        this.setTextureOffset("Piece1.Shape62", 0, 0);
        this.setTextureOffset("Piece1.Shape63", 0, 0);
        this.setTextureOffset("Piece1.Shape59", 0, 0);
        this.setTextureOffset("Piece1.Shape61", 0, 0);
        this.setTextureOffset("Piece1.Shape65", 0, 0);
        this.setTextureOffset("Piece1.Shape64", 0, 0);
        this.setTextureOffset("Piece1.Shape58", 0, 0);
        this.setTextureOffset("Piece1.Shape69", 0, 0);
        this.setTextureOffset("Piece1.Shape72", 0, 0);
        this.setTextureOffset("Piece1.Shape73", 0, 0);
        this.setTextureOffset("Piece1.Shape74", 0, 0);
        this.setTextureOffset("Piece1.Shape75", 0, 0);
        this.setTextureOffset("Piece1.Shape70", 0, 0);
        this.setTextureOffset("Piece1.Shape71", 0, 0);
        this.setTextureOffset("Piece1.Shape68", 0, 0);
        this.setTextureOffset("Piece1.Shape66", 0, 0);
        this.setTextureOffset("Piece1.Shape78", 0, 0);
        this.setTextureOffset("Piece1.Shape77", 0, 0);
        this.setTextureOffset("Piece1.Shape79", 0, 21);
        this.setTextureOffset("Piece1.Shape67", 0, 0);
        this.setTextureOffset("Piece1.Shape81", 0, 0);
        this.setTextureOffset("Piece1.Shape83", 19, 19);
        this.setTextureOffset("Piece1.Shape86", 0, 0);
        this.setTextureOffset("Piece1.Shape85", 19, 19);
        this.setTextureOffset("Piece1.Shape84", 0, 0);
        this.setTextureOffset("Piece1.Shape82", 0, 0);
        this.setTextureOffset("Piece1.Shape80", 0, 0);
        this.setTextureOffset("Piece1.Shape53", 0, 0);
        this.setTextureOffset("Piece1.Shape87", 0, 0);
        this.setTextureOffset("Piece1.Shape90", 0, 0);
        this.setTextureOffset("Piece1.Shape92", 25, 25);
        this.setTextureOffset("Piece1.Shape89", 0, 0);
        this.setTextureOffset("Piece1.Shape94", 0, 0);
        this.setTextureOffset("Piece1.Shape93", 25, 25);
        this.setTextureOffset("Piece1.Shape88", 25, 25);
        this.setTextureOffset("Piece1.Shape91", 25, 25);
        this.setTextureOffset("Piece1.Shape76", 0, 21);
        this.setTextureOffset("Piece1.Shape27", 0, 0);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.addBox("Shape19", -5.0F, -12.0F, -4.0F, 10, 1, 3);
        this.Piece1.addBox("Shape18", -2.0F, -11.0F, -6.0F, 4, 1, 1);
        this.Piece1.addBox("Shape17", -4.0F, -11.0F, 1.0F, 8, 1, 1);
        this.Piece1.addBox("Shape16", -5.0F, -11.0F, -5.0F, 10, 1, 6);
        this.Piece1.addBox("Shape15", -3.0F, -10.0F, -7.0F, 6, 2, 1);
        this.Piece1.addBox("Shape14", -1.0F, -11.0F, -8.0F, 2, 1, 2);
        this.Piece1.addBox("Shape13", -4.0F, -10.0F, -6.0F, 8, 1, 1);
        this.Piece1.addBox("Shape12", -5.0F, -9.0F, 3.0F, 10, 1, 1);
        this.Piece1.addBox("Shape11", -4.0F, -9.0F, 4.0F, 8, 1, 1);
        this.Piece1.addBox("Shape10", -6.0F, -10.0F, -5.0F, 12, 2, 8);
        this.Piece1.addBox("Shape9", -5.0F, -9.0F, -6.0F, 10, 1, 1);
        this.Piece1.addBox("Shape8", -2.0F, -10.0F, -8.0F, 4, 2, 1);
        this.Piece1.addBox("Shape7", -1.0F, -10.0F, 3.0F, 2, 1, 2);
        this.Piece1.addBox("Shape6", -6.0F, -12.0F, -2.0F, 1, 1, 2);
        this.Piece1.addBox("Shape5", -6.0F, -11.0F, -3.0F, 1, 1, 3);
        this.Piece1.addBox("Shape4", 5.0F, -11.0F, -3.0F, 1, 1, 3);
        this.Piece1.addBox("Shape3", -7.0F, -10.0F, -2.0F, 1, 2, 5);
        this.Piece1.addBox("Shape2", -10.0F, -10.0F, 3.0F, 5, 1, 1);
        this.Piece1.addBox("Shape1", -11.0F, -12.0F, 5.0F, 2, 2, 2);
        this.Piece1.addBox("Shape20", -2.0F, -12.0F, -5.0F, 4, 1, 1);
        this.Piece1.addBox("Shape22", -1.0F, -11.0F, 2.0F, 2, 1, 2);
        this.Piece1.addBox("Shape21", -1.0F, -13.0F, -4.0F, 2, 1, 6);
        this.Piece1.addBox("Shape24", 5.0F, -10.0F, 3.0F, 5, 1, 1);
        this.Piece1.addBox("Shape25", -10.0F, -10.0F, 4.0F, 4, 1, 1);
        this.Piece1.addBox("Shape26", -10.0F, -10.0F, 5.0F, 2, 1, 1);
        this.Piece1.addBox("Shape23", -1.0F, -12.0F, -1.0F, 2, 1, 4);
        this.Piece1.addBox("Shape28", -7.0F, -11.0F, 0.0F, 1, 1, 4);
        this.Piece1.addBox("Shape30", -8.0F, -10.0F, 0.0F, 1, 1, 3);
        this.Piece1.addBox("Shape29", 6.0F, -10.0F, -2.0F, 1, 2, 5);
        this.Piece1.addBox("Shape31", -9.0F, -11.0F, 2.0F, 1, 1, 4);
        this.Piece1.addBox("Shape32", 7.0F, -10.0F, 0.0F, 1, 1, 3);
        this.Piece1.addBox("Shape34", -8.0F, -11.0F, 2.0F, 1, 1, 3);
        this.Piece1.addBox("Shape33", 6.0F, -11.0F, 0.0F, 1, 1, 4);
        this.Piece1.addBox("Shape35", 8.0F, -11.0F, 2.0F, 1, 1, 4);
        this.Piece1.addBox("Shape37", 6.0F, -10.0F, 4.0F, 4, 1, 1);
        this.Piece1.addBox("Shape39", -11.0F, -12.0F, 7.0F, 2, 1, 1);
        this.Piece1.addBox("Shape40", -11.0F, -13.0F, 6.0F, 1, 1, 2);
        this.Piece1.addBox("Shape41", 9.0F, -12.0F, 7.0F, 2, 1, 1);
        this.Piece1.addBox("Shape38", 8.0F, -10.0F, 5.0F, 2, 1, 1);
        this.Piece1.addBox("Shape42", 9.0F, -12.0F, 5.0F, 2, 2, 2);
        this.Piece1.addBox("Shape44", 10.0F, -13.0F, 6.0F, 1, 1, 2);
        this.Piece1.addBox("Shape43", 10.0F, -14.0F, 7.0F, 1, 1, 1);
        this.Piece1.addBox("Shape36", 7.0F, -11.0F, 2.0F, 1, 1, 3);
        this.Piece1.addBox("Shape45", -11.0F, -14.0F, 7.0F, 1, 1, 1);
        this.Piece1.addBox("Shape47", -5.0F, -14.0F, -2.0F, 2, 1, 6);
        this.Piece1.addBox("Shape48", -5.0F, -13.0F, -3.0F, 2, 1, 4);
        this.Piece1.addBox("Shape49", 2.0F, -14.0F, -1.0F, 1, 1, 3);
        this.Piece1.addBox("Shape50", 3.0F, -13.0F, -3.0F, 2, 1, 4);
        this.Piece1.addBox("Shape46", 2.0F, -13.0F, -2.0F, 1, 1, 2);
        this.Piece1.addBox("Shape51", -5.0F, -15.0F, -1.0F, 1, 1, 9);
        this.Piece1.addBox("Shape52", -3.0F, -13.0F, -2.0F, 1, 1, 2);
        this.Piece1.addBox("Shape54", 3.0F, -14.0F, -2.0F, 2, 1, 6);
        this.Piece1.addBox("Shape56", 4.0F, -15.0F, -1.0F, 1, 1, 9);
        this.Piece1.addBox("Shape57", -6.0F, -15.0F, 0.0F, 1, 1, 9);
        this.Piece1.addBox("Shape55", -5.0F, -17.0F, 1.0F, 1, 1, 3);
        this.Piece1.addBox("Shape60", 2.0F, -15.0F, 1.0F, 1, 1, 2);
        this.Piece1.addBox("Shape62", -3.0F, -15.0F, 1.0F, 1, 1, 2);
        this.Piece1.addBox("Shape63", 3.0F, -15.0F, 0.0F, 1, 1, 5);
        this.Piece1.addBox("Shape59", -4.0F, -15.0F, 0.0F, 1, 1, 5);
        this.Piece1.addBox("Shape61", -4.0F, -16.0F, 1.0F, 1, 1, 3);
        this.Piece1.addBox("Shape65", 3.0F, -16.0F, 1.0F, 1, 1, 3);
        this.Piece1.addBox("Shape64", -6.0F, -16.0F, 1.0F, 1, 1, 6);
        this.Piece1.addBox("Shape58", -5.0F, -16.0F, 0.0F, 1, 1, 5);
        this.Piece1.addBox("Shape69", -5.0F, -14.0F, 1.0F, 1, 1, 2);
        this.Piece1.addBox("Shape72", 5.0F, -14.0F, 3.0F, 1, 1, 7);
        this.Piece1.addBox("Shape73", 4.0F, -15.0F, -1.0F, 1, 1, 9);
        this.Piece1.addBox("Shape74", 4.0F, -14.0F, 1.0F, 1, 1, 2);
        this.Piece1.addBox("Shape75", 5.0F, -15.0F, 0.0F, 1, 1, 9);
        this.Piece1.addBox("Shape70", -6.0F, -14.0F, 3.0F, 1, 1, 7);
        this.Piece1.addBox("Shape71", -7.0F, -15.0F, 4.0F, 1, 1, 3);
        this.Piece1.addBox("Shape68", 5.0F, -16.0F, 1.0F, 1, 1, 6);
        this.Piece1.addBox("Shape66", 4.0F, -17.0F, 1.0F, 1, 1, 3);
        this.Piece1.addBox("Shape78", -7.0F, -13.0F, 7.0F, 2, 1, 3);
        this.Piece1.addBox("Shape77", 6.0F, -15.0F, 4.0F, 1, 1, 3);
        this.Piece1.addBox("Shape79", 6.0F, -14.0F, 5.0F, 1, 1, 6);
        this.Piece1.addBox("Shape67", 4.0F, -16.0F, 0.0F, 1, 1, 5);
        this.Piece1.addBox("Shape81", 5.0F, -13.0F, 7.0F, 2, 1, 3);
        this.Piece1.addBox("Shape83", 7.0F, -14.0F, 9.0F, 1, 2, 3);
        this.Piece1.addBox("Shape86", -8.0F, -14.0F, 12.0F, 2, 2, 1);
        this.Piece1.addBox("Shape85", -8.0F, -14.0F, 9.0F, 1, 2, 3);
        this.Piece1.addBox("Shape84", 6.0F, -13.0F, 9.0F, 2, 2, 2);
        this.Piece1.addBox("Shape82", -8.0F, -13.0F, 9.0F, 2, 2, 2);
        this.Piece1.addBox("Shape80", -8.0F, -15.0F, 13.0F, 2, 2, 1);
        this.Piece1.addBox("Shape53", -3.0F, -14.0F, -1.0F, 1, 1, 3);
        this.Piece1.addBox("Shape87", 6.0F, -14.0F, 12.0F, 2, 2, 1);
        this.Piece1.addBox("Shape90", 6.0F, -13.0F, 11.0F, 1, 1, 1);
        this.Piece1.addBox("Shape92", 7.0F, -15.0F, 12.0F, 1, 1, 1);
        this.Piece1.addBox("Shape89", 6.0F, -15.0F, 13.0F, 2, 2, 1);
        this.Piece1.addBox("Shape94", -7.0F, -13.0F, 11.0F, 1, 1, 1);
        this.Piece1.addBox("Shape93", -8.0F, -15.0F, 12.0F, 1, 1, 1);
        this.Piece1.addBox("Shape88", -8.0F, -17.0F, 13.0F, 1, 2, 1);
        this.Piece1.addBox("Shape91", 7.0F, -17.0F, 13.0F, 1, 2, 1);
        this.Piece1.addBox("Shape76", -7.0F, -14.0F, 5.0F, 1, 1, 6);
        this.Piece1.addBox("Shape27", 5.0F, -12.0F, -2.0F, 1, 1, 2);
        this.setTexture(new ResourceLocation("minidot", "head/hornshat.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, -0.15F, 0.06F);
        GlStateManager.scale(0.7F, 0.7F, 0.7F);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.25F, -0.15F);
        GlStateManager.scale(0.6F, 0.6F, 0.6F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041b\u0435\u0434\u044f\u043d\u044b\u0435 \u0440\u043e\u0433\u0430";
    }

    public String getCreator()
    {
        return "ANACTAC";
    }
}
