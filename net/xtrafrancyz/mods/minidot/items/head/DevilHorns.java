package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class DevilHorns extends BaseItem
{
    private final MModelRenderer Horns;

    public DevilHorns()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("Horns.Shape1", 56, 0);
        this.setTextureOffset("Horns.Shape2", 47, 0);
        this.setTextureOffset("Horns.Shape3", 38, 0);
        this.setTextureOffset("Horns.Shape4", 27, 0);
        this.setTextureOffset("Horns.Shape5", 18, 0);
        this.setTextureOffset("Horns.Shape6", 56, 7);
        this.setTextureOffset("Horns.Shape7", 45, 8);
        this.setTextureOffset("Horns.Shape8", 36, 6);
        this.setTextureOffset("Horns.Shape9", 25, 6);
        this.setTextureOffset("Horns.Shape10", 12, 6);
        this.setTextureOffset("Horns.Shape11", 58, 12);
        this.setTextureOffset("Horns.Shape12", 51, 14);
        this.setTextureOffset("Horns.Shape13", 42, 14);
        this.setTextureOffset("Horns.Shape14", 40, 11);
        this.setTextureOffset("Horns.Shape15", 35, 11);
        this.setTextureOffset("Horns.Shape16", 0, 26);
        this.setTextureOffset("Horns.Shape17", 9, 25);
        this.setTextureOffset("Horns.Shape18", 18, 28);
        this.setTextureOffset("Horns.Shape19", 27, 27);
        this.setTextureOffset("Horns.Shape20", 38, 28);
        this.setTextureOffset("Horns.Shape21", 47, 28);
        this.setTextureOffset("Horns.Shape22", 0, 19);
        this.setTextureOffset("Horns.Shape23", 11, 20);
        this.setTextureOffset("Horns.Shape24", 20, 22);
        this.setTextureOffset("Horns.Shape26", 31, 21);
        this.setTextureOffset("Horns.Shape27", 44, 24);
        this.setTextureOffset("Horns.Shape28", 51, 25);
        this.setTextureOffset("Horns.Shape29", 44, 19);
        this.setTextureOffset("Horns.Shape30", 56, 30);
        this.setTextureOffset("Horns.Shape31", 59, 26);
        this.Horns = new MModelRenderer(this, "Horns");
        this.Horns.addBox("Shape1", -5.0F, -7.0F, -1.0F, 1, 3, 3);
        this.Horns.addBox("Shape2", -6.0F, -8.0F, -1.0F, 1, 4, 3);
        this.Horns.addBox("Shape3", -7.0F, -6.0F, -1.0F, 1, 1, 3);
        this.Horns.addBox("Shape4", -8.0F, -8.0F, -2.0F, 2, 2, 3);
        this.Horns.addBox("Shape5", -9.0F, -8.0F, -2.0F, 1, 1, 3);
        this.Horns.addBox("Shape6", -7.0F, -9.0F, -2.0F, 1, 1, 3);
        this.Horns.addBox("Shape7", -9.0F, -10.0F, -3.0F, 2, 2, 3);
        this.Horns.addBox("Shape8", -9.0F, -11.0F, -3.0F, 1, 1, 3);
        this.Horns.addBox("Shape9", -8.0F, -11.0F, -4.0F, 2, 1, 3);
        this.Horns.addBox("Shape10", -8.0F, -13.0F, -4.0F, 3, 2, 3);
        this.Horns.addBox("Shape11", -7.0F, -14.0F, -4.0F, 1, 1, 2);
        this.Horns.addBox("Shape12", -6.0F, -14.0F, -3.0F, 2, 1, 1);
        this.Horns.addBox("Shape13", -6.0F, -15.0F, -5.0F, 2, 2, 2);
        this.Horns.addBox("Shape14", -4.0F, -15.0F, -5.0F, 1, 1, 1);
        this.Horns.addBox("Shape15", -4.0F, -16.0F, -6.0F, 1, 2, 1);
        this.Horns.addBox("Shape16", 4.0F, -7.0F, -1.0F, 1, 3, 3);
        this.Horns.addBox("Shape17", 5.0F, -8.0F, -1.0F, 1, 4, 3);
        this.Horns.addBox("Shape18", 6.0F, -6.0F, -1.0F, 1, 1, 3);
        this.Horns.addBox("Shape19", 6.0F, -8.0F, -2.0F, 2, 2, 3);
        this.Horns.addBox("Shape20", 6.0F, -9.0F, -2.0F, 1, 1, 3);
        this.Horns.addBox("Shape21", 8.0F, -8.0F, -2.0F, 1, 1, 3);
        this.Horns.addBox("Shape22", 7.0F, -10.0F, -3.0F, 2, 2, 3);
        this.Horns.addBox("Shape23", 8.0F, -11.0F, -3.0F, 1, 1, 3);
        this.Horns.addBox("Shape24", 6.0F, -11.0F, -4.0F, 2, 1, 3);
        this.Horns.addBox("Shape26", 5.0F, -13.0F, -4.0F, 3, 2, 3);
        this.Horns.addBox("Shape27", 6.0F, -14.0F, -4.0F, 1, 1, 2);
        this.Horns.addBox("Shape28", 4.0F, -14.0F, -3.0F, 2, 1, 1);
        this.Horns.addBox("Shape29", 4.0F, -15.0F, -5.0F, 2, 2, 2);
        this.Horns.addBox("Shape30", 3.0F, -15.0F, -5.0F, 1, 1, 1);
        this.Horns.addBox("Shape31", 3.0F, -16.0F, -6.0F, 1, 2, 1);
        this.setTexture(new ResourceLocation("minidot", "head/devil_horns.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.translate(0.0F, 0.25F, 0.0F);
        super.renderAsItem(time);
    }

    public String getCreator()
    {
        return "Netherfox";
    }

    public String getName()
    {
        return "\u0420\u043e\u0433\u0430 \u0434\u0435\u043c\u043e\u043d\u0430";
    }
}
