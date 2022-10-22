package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class HelmetVillager extends BaseHelm
{
    private final MModelRenderer Piece1;

    public HelmetVillager()
    {
        super(ItemType.HEAD);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.setTextureOffset("Piece1.Shape1", 0, 0);
        this.setTextureOffset("Piece1.Shape2", 0, 0);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.addBox("Shape1", -4.0F, -10.0F, -4.0F, 8, 10, 8);
        this.Piece1.addBox("Shape2", -1.0F, -3.0F, -6.0F, 2, 4, 2);
        this.setTexture(new ResourceLocation("minidot", "head/helmet_villager.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(1.01F, 1.01F, 1.01F);
        GlStateManager.translate(0.0F, 0.01F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0416\u0438\u0442\u0435\u043b\u044c";
    }
}
