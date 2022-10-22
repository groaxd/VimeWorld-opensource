package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class BurgerPet extends BasePet
{
    private final MModelRenderer Piece1;

    public BurgerPet()
    {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.setTextureOffset("Piece1.1", 0, 0);
        this.setTextureOffset("Piece1.2", 0, 0);
        this.setTextureOffset("Piece1.3", 0, 0);
        this.setTextureOffset("Piece1.4", 0, 0);
        this.setTextureOffset("Piece1.5", 0, 0);
        this.setTextureOffset("Piece1.6", 0, 27);
        this.setTextureOffset("Piece1.7", 0, 27);
        this.setTextureOffset("Piece1.8", 0, 27);
        this.setTextureOffset("Piece1.9", 0, 27);
        this.setTextureOffset("Piece1.10", 0, 27);
        this.setTextureOffset("Piece1.11", 4, 24);
        this.setTextureOffset("Piece1.12", 4, 24);
        this.setTextureOffset("Piece1.13", 4, 25);
        this.setTextureOffset("Piece1.14", 4, 25);
        this.setTextureOffset("Piece1.15", 0, 25);
        this.setTextureOffset("Piece1.16", 0, 25);
        this.setTextureOffset("Piece1.17", 0, 20);
        this.setTextureOffset("Piece1.18", 0, 20);
        this.setTextureOffset("Piece1.19", 0, 11);
        this.setTextureOffset("Piece1.20", 0, 7);
        this.setTextureOffset("Piece1.21", 0, 0);
        this.setTextureOffset("Piece1.22", 0, 0);
        this.setTextureOffset("Piece1.23", 0, 0);
        this.setTextureOffset("Piece1.24", 0, 0);
        this.setTextureOffset("Piece1.25", 0, 0);
        this.setTextureOffset("Piece1.26", 0, 0);
        this.setTextureOffset("Piece1.27", 0, 0);
        this.setTextureOffset("Piece1.28", 0, 0);
        this.setTextureOffset("Piece1.29", 0, 0);
        this.setTextureOffset("Piece1.30", 0, 0);
        this.setTextureOffset("Piece1.31", 0, 7);
        this.setTextureOffset("Piece1.32", 0, 7);
        this.setTextureOffset("Piece1.33", 0, 7);
        this.setTextureOffset("Piece1.34", 0, 7);
        this.setTextureOffset("Piece1.35", 0, 7);
        this.setTextureOffset("Piece1.36", 0, 7);
        this.setTextureOffset("Piece1.37", 0, 7);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.setRotation(this.Piece1, 0.0F, 0.0F, 0.0F);
        this.Piece1.mirror = true;
        this.Piece1.addBox("1", -3.0F, 0.0F, -3.0F, 6, 1, 6);
        this.Piece1.addBox("2", -2.0F, 0.0F, -4.0F, 4, 1, 1);
        this.Piece1.addBox("3", -2.0F, 0.0F, 3.0F, 4, 1, 1);
        this.Piece1.addBox("4", -4.0F, 0.0F, -2.0F, 1, 1, 4);
        this.Piece1.addBox("5", 3.0F, 0.0F, -2.0F, 1, 1, 4);
        this.Piece1.addBox("6", -2.0F, -0.5F, -2.0F, 4, 1, 4);
        this.Piece1.addBox("7", -3.0F, -0.5F, -1.0F, 1, 1, 2);
        this.Piece1.addBox("8", 2.0F, -0.5F, -1.0F, 1, 1, 2);
        this.Piece1.addBox("9", -1.0F, -0.5F, -3.0F, 2, 1, 1);
        this.Piece1.addBox("10", -1.0F, -0.5F, 2.0F, 2, 1, 1);
        this.Piece1.addBox("11", -4.1F, -0.5F, -1.0F, 1, 1, 2);
        this.Piece1.addBox("12", 3.1F, -0.5F, -1.0F, 1, 1, 2);
        this.Piece1.addBox("13", -0.9F, -0.5F, -4.1F, 2, 1, 1);
        this.Piece1.addBox("14", -0.9F, -0.5F, 3.1F, 2, 1, 1);
        this.Piece1.addBox("15", -3.0F, -1.5F, 1.0F, 6, 1, 1);
        this.Piece1.addBox("16", -3.0F, -1.5F, -2.0F, 6, 1, 1);
        this.Piece1.addBox("17", -2.0F, -1.5F, -3.0F, 1, 1, 6);
        this.Piece1.addBox("18", 1.0F, -1.5F, -3.0F, 1, 1, 6);
        this.Piece1.addBox("19", -3.0F, -1.5F, -1.0F, 6, 1, 2);
        this.Piece1.addBox("20", -1.0F, -1.5F, -3.0F, 2, 1, 6);
        this.Piece1.addBox("21", -3.0F, -2.5F, -3.0F, 6, 1, 6);
        this.Piece1.addBox("22", -4.0F, -2.5F, -2.0F, 1, 1, 4);
        this.Piece1.addBox("23", 3.0F, -2.5F, -2.0F, 1, 1, 4);
        this.Piece1.addBox("24", -2.0F, -2.5F, -4.0F, 4, 1, 1);
        this.Piece1.addBox("25", -2.0F, -2.5F, 3.0F, 4, 1, 1);
        this.Piece1.addBox("26", -2.0F, -3.0F, -2.0F, 4, 1, 4);
        this.Piece1.addBox("27", -1.0F, -3.0F, -3.0F, 2, 1, 1);
        this.Piece1.addBox("28", -1.0F, -3.0F, 2.0F, 2, 1, 1);
        this.Piece1.addBox("29", 2.0F, -3.0F, -1.0F, 1, 1, 2);
        this.Piece1.addBox("30", -3.0F, -3.0F, -1.0F, 1, 1, 2);
        this.Piece1.addBox("31", 1.0F, -3.1F, -1.0F, 1, 1, 1);
        this.Piece1.addBox("32", -1.0F, -3.1F, -1.0F, 1, 1, 1);
        this.Piece1.addBox("33", -1.0F, -3.1F, 1.0F, 1, 1, 1);
        this.Piece1.addBox("34", 1.0F, -2.6F, 2.0F, 1, 1, 1);
        this.Piece1.addBox("35", 2.0F, -2.6F, -2.0F, 1, 1, 1);
        this.Piece1.addBox("36", -3.0F, -2.6F, -2.0F, 1, 1, 1);
        this.Piece1.addBox("37", -2.0F, -2.6F, 2.0F, 1, 1, 1);
        this.setTexture(new ResourceLocation("minidot", "pets/burgerpet.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        GlStateManager.translate(0.7F, -0.45F + f, 0.4F);
        GlStateManager.rotate(time * 1.5F, 0.0F, 1.0F, 0.0F);
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(1.4F, 1.4F, 1.4F);
        super.renderAsItem(time);
    }

    public String getCreator()
    {
        return "iKpudka";
    }

    public String getName()
    {
        return "\u0411\u0443\u0440\u0433\u0435\u0440";
    }
}
