package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class ShavermaPet extends BasePet
{
    private final MModelRenderer s19;
    private final MModelRenderer s20;
    private final MModelRenderer s21;
    private final MModelRenderer s22;
    private final MModelRenderer s23;
    private final MModelRenderer s24;
    private final MModelRenderer s25;
    private final MModelRenderer Piece1;

    public ShavermaPet()
    {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.useDisplayLists = true;
        this.setTextureOffset("Piece1.1", 0, 0);
        this.setTextureOffset("Piece1.2", 0, 0);
        this.setTextureOffset("Piece1.3", 0, 0);
        this.setTextureOffset("Piece1.4", 0, 0);
        this.setTextureOffset("Piece1.5", 0, 0);
        this.setTextureOffset("Piece1.6", 0, 0);
        this.setTextureOffset("Piece1.7", 0, 1);
        this.setTextureOffset("Piece1.8", 0, 0);
        this.setTextureOffset("Piece1.9", 0, 0);
        this.setTextureOffset("Piece1.10", 0, 29);
        this.setTextureOffset("Piece1.11", 0, 27);
        this.setTextureOffset("Piece1.12", 0, 27);
        this.setTextureOffset("Piece1.13", 0, 27);
        this.setTextureOffset("Piece1.14", 0, 27);
        this.setTextureOffset("Piece1.15", 0, 27);
        this.setTextureOffset("Piece1.16", 0, 27);
        this.setTextureOffset("Piece1.17", 0, 27);
        this.setTextureOffset("Piece1.18", 0, 27);
        this.s19 = new MModelRenderer(this, 0, 8);
        this.s19.addBox(-1.4F, 1.7F, -6.0F, 1, 1, 4);
        this.setRotation(this.s19, -0.1858931F, 0.0F, 0.0743572F);
        this.s20 = new MModelRenderer(this, 0, 13);
        this.s20.addBox(-0.5F, 2.7F, -5.5F, 1, 1, 4);
        this.setRotation(this.s20, -0.1578026F, 0.1858931F, -0.0743572F);
        this.s21 = new MModelRenderer(this, 0, 13);
        this.s21.addBox(0.0F, 1.7F, 0.0F, 1, 1, 4);
        this.s22 = new MModelRenderer(this, 0, 13);
        this.s22.addBox(0.7F, 1.4F, 0.0F, 1, 1, 4);
        this.s23 = new MModelRenderer(this, 0, 18);
        this.s23.addBox(0.3F, 3.0F, -5.1F, 1, 1, 2);
        this.setRotation(this.s23, -0.4461433F, -0.0371786F, 0.2602503F);
        this.s24 = new MModelRenderer(this, 0, 18);
        this.s24.addBox(0.5F, 2.0F, -5.0F, 1, 1, 2);
        this.setRotation(this.s24, -0.1487144F, -0.0371786F, 0.0F);
        this.s25 = new MModelRenderer(this, 0, 21);
        this.s25.addBox(-1.3F, 1.8F, -5.5F, 1, 1, 1);
        this.setRotation(this.s25, -0.0371786F, -0.3346075F, 0.0F);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.addBox("1", -2.0F, 0.0F, -5.0F, 4, 1, 5);
        this.Piece1.addBox("2", -2.0F, 3.0F, -5.0F, 4, 1, 5);
        this.Piece1.addBox("3", -2.5F, 1.0F, -5.0F, 1, 2, 5);
        this.Piece1.addBox("4", 1.5F, 1.0F, -5.0F, 1, 2, 5);
        this.Piece1.addBox("5", -2.0F, 1.5F, 5.0F, 4, 2, 1);
        this.Piece1.addBox("6", -2.0F, 0.5F, 0.0F, 4, 1, 5);
        this.Piece1.addBox("7", -2.0F, 3.5F, 0.0F, 4, 1, 5);
        this.Piece1.addBox("8", 1.5F, 1.5F, 0.0F, 1, 2, 5);
        this.Piece1.addBox("9", -2.5F, 1.5F, 0.0F, 1, 2, 5);
        this.Piece1.addBox("10", -2.0F, 1.0F, -4.5F, 4, 2, 1);
        this.Piece1.addBox("11", -1.6F, -0.1F, -4.0F, 3, 1, 1);
        this.Piece1.addBox("12", -1.6F, -0.1F, -2.0F, 3, 1, 1);
        this.Piece1.addBox("13", -1.6F, 0.4F, 1.0F, 3, 1, 1);
        this.Piece1.addBox("14", -1.6F, 0.4F, 3.0F, 3, 1, 1);
        this.Piece1.addBox("15", -1.6F, 3.6F, 3.0F, 3, 1, 1);
        this.Piece1.addBox("16", -1.5F, 3.6F, 1.0F, 3, 1, 1);
        this.Piece1.addBox("17", -1.6F, 3.1F, -1.5F, 3, 1, 1);
        this.Piece1.addBox("18", -1.6F, 3.1F, -4.0F, 3, 1, 1);
        this.setTexture(new ResourceLocation("minidot", "pets/shavermapet.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        GlStateManager.translate(0.7F, -0.45F + f, 0.4F);
        GlStateManager.rotate(time * 1.5F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(-120.0F, 1.0F, 0.0F, 0.0F);
        GlStateManager.scale(1.3F, 1.3F, 1.3F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(1.4F, 1.4F, 1.4F);
        GlStateManager.translate(0.0F, -0.08F, 0.0F);
        super.renderAsItem(time);
    }

    public String getCreator()
    {
        return "iKpudka";
    }

    public String getName()
    {
        return "\u0428\u0430\u0443\u0440\u043c\u0430";
    }
}
