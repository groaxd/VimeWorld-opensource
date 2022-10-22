package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class HolographicIroquois extends BaseItem
{
    private final MModelRenderer Prikol;
    private final MModelRenderer bb_main;

    public HolographicIroquois()
    {
        super(ItemType.HEAD);
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.Prikol = new MModelRenderer(this);
        this.Prikol.setRotationPoint(-4.0F, 1.0F, -8.0F);
        this.Prikol.setTextureOffset(12, 19).addBox(2.0F, -2.0F, 19.0F, 3, 2, 2, 0.0F);
        this.Prikol.setTextureOffset(0, 19).addBox(2.0F, 0.0F, 20.0F, 3, 15, 6, 0.0F);
        this.Prikol.setTextureOffset(0, 6).addBox(2.0F, 15.0F, 21.0F, 3, 1, 5, 0.0F);
        this.Prikol.setTextureOffset(29, 43).addBox(2.0F, 16.0F, 22.0F, 3, 1, 4, 0.0F);
        this.Prikol.setTextureOffset(48, 8).addBox(2.0F, 17.0F, 23.0F, 3, 1, 3, 0.0F);
        this.Prikol.setTextureOffset(0, 0).addBox(2.0F, -1.0F, 21.0F, 3, 1, 5, 0.0F);
        this.Prikol.setTextureOffset(0, 12).addBox(2.0F, -2.0F, 21.0F, 3, 1, 4, 0.0F);
        this.Prikol.setTextureOffset(0, 43).addBox(2.0F, -3.0F, 1.0F, 3, 1, 23, 0.0F);
        this.Prikol.setTextureOffset(29, 29).addBox(2.0F, -4.0F, 0.0F, 3, 1, 23, 0.0F);
        this.Prikol.setTextureOffset(31, 53).addBox(2.0F, -7.0F, -1.0F, 3, 1, 21, 0.0F);
        this.Prikol.setTextureOffset(0, 19).addBox(2.0F, -5.0F, -1.0F, 3, 1, 23, 0.0F);
        this.Prikol.setTextureOffset(44, 0).addBox(2.0F, -6.0F, -1.0F, 3, 1, 22, 0.0F);
        this.Prikol.setTextureOffset(29, 19).addBox(11.0F, 7.0F, -4.0F, 1, 4, 2, 0.0F);
        this.Prikol.setTextureOffset(0, 19).addBox(-5.0F, 7.0F, -4.0F, 1, 4, 2, 0.0F);
        this.Prikol.setTextureOffset(72, 13).addBox(-4.0F, 7.0F, -4.0F, 15, 4, 1, 0.0F);
        this.bb_main = new MModelRenderer(this);
        this.bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.bb_main.setTextureOffset(61, 61).addBox(8.0F, -16.0F, -11.0F, 2, 4, 18, 0.0F);
        this.bb_main.setTextureOffset(58, 23).addBox(-11.0F, -16.0F, -11.0F, 2, 4, 18, 0.0F);
        this.bb_main.setTextureOffset(0, 43).addBox(8.0F, -18.0F, -4.0F, 3, 8, 8, 0.001F);
        this.bb_main.setTextureOffset(29, 19).addBox(-12.0F, -18.0F, -4.0F, 3, 8, 8, 0.0F);
        this.bb_main.setTextureOffset(48, 0).addBox(11.0F, -16.0F, -2.0F, 1, 4, 4, 0.0F);
        this.bb_main.setTextureOffset(39, 44).addBox(-13.0F, -16.0F, -2.0F, 1, 4, 4, 0.0F);
        this.bb_main.setTextureOffset(43, 23).addBox(-8.0F, -23.0F, -8.0F, 15, 2, 1, 0.0F);
        this.bb_main.setTextureOffset(49, 75).addBox(-7.0F, -21.0F, -8.0F, 13, 1, 1, 0.0F);
        this.bb_main.setTextureOffset(21, 77).addBox(-6.0F, -20.0F, -8.0F, 11, 1, 1, 0.0F);
        this.bb_main.setTextureOffset(0, 40).addBox(-4.0F, -21.0F, -9.0F, 7, 1, 1, 0.0F);
        this.bb_main.setTextureOffset(29, 37).addBox(-5.0F, -22.0F, -9.0F, 9, 1, 1, 0.0F);
        this.bb_main.setTextureOffset(72, 18).addBox(-7.0F, -24.0F, -9.0F, 13, 2, 1, 0.0F);
        this.bb_main.setTextureOffset(0, 0).addBox(-8.0F, -23.0F, -7.0F, 15, 1, 18, 0.0F);
        this.bb_main.setTextureOffset(72, 0).addBox(-8.0F, -22.0F, 10.0F, 15, 12, 1, 0.0F);
        this.bb_main.setTextureOffset(21, 75).addBox(-7.0F, -10.0F, 10.0F, 13, 1, 1, 0.0F);
        this.bb_main.setTextureOffset(51, 26).addBox(-6.0F, -9.0F, 10.0F, 11, 1, 1, 0.0F);
        this.bb_main.setTextureOffset(21, 67).addBox(-6.0F, -21.0F, 11.0F, 11, 6, 1, 0.0F);
        this.bb_main.setTextureOffset(29, 35).addBox(-5.0F, -15.0F, 11.0F, 9, 1, 1, 0.0F);
        this.bb_main.setTextureOffset(29, 39).addBox(-4.0F, -14.0F, 11.0F, 7, 1, 1, 0.0F);
        this.bb_main.setTextureOffset(0, 67).addBox(3.0F, -24.0F, -8.0F, 3, 1, 15, 0.0F);
        this.bb_main.setTextureOffset(66, 45).addBox(-7.0F, -24.0F, -8.0F, 3, 1, 15, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "head/holographiciroquois.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, -0.55F, -0.05F);
        GlStateManager.scale(0.5F, 0.5F, 0.5F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -0.3F, 0.0F);
        GlStateManager.scale(0.4F, 0.4F, 0.4F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041a\u0438\u0431\u0435\u0440\u043f\u0430\u043d\u043a-\u0438\u0440\u043e\u043a\u0435\u0437";
    }

    public String getCreator()
    {
        return "Sir_Kelt";
    }
}
