package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class YTButton extends BasePet
{
    private final MModelRenderer Piece1;

    public YTButton()
    {
        this.textureWidth = 32;
        this.textureHeight = 16;
        this.setTextureOffset("Piece1.Shape1", 0, 8);
        this.setTextureOffset("Piece1.Shape2", 0, 0);
        this.setTextureOffset("Piece1.Shape3", 0, 0);
        this.setTextureOffset("Piece1.Shape4", 0, 0);
        this.setTextureOffset("Piece1.Shape5", 0, 0);
        this.setTextureOffset("Piece1.Shape6", 0, 0);
        this.setTextureOffset("Piece1.Shape7", 0, 0);
        this.setTextureOffset("Piece1.Shape8", 0, 0);
        this.setTextureOffset("Piece1.Shape9", 0, 0);
        this.setTextureOffset("Piece1.Shape10", 0, 0);
        this.setTextureOffset("Piece1.Shape11", 0, 0);
        this.setTextureOffset("Piece1.Shape12", 0, 0);
        this.setTextureOffset("Piece1.Shape13", 0, 0);
        this.setTextureOffset("Piece1.Shape14", 0, 0);
        this.setTextureOffset("Piece1.Shape15", 0, 0);
        this.setTextureOffset("Piece1.Shape16", 0, 0);
        this.setTextureOffset("Piece1.Shape17", 0, 0);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.addBox("Shape1", -6.0F, -3.0F, 1.0F, 10, 7, 1);
        this.Piece1.addBox("Shape2", 3.5F, -2.5F, 1.0F, 1, 6, 1);
        this.Piece1.addBox("Shape3", -6.5F, -2.5F, 1.0F, 1, 6, 1);
        this.Piece1.addBox("Shape4", -6.0F, -3.0F, 0.5F, 3, 7, 1);
        this.Piece1.addBox("Shape5", 1.0F, -3.0F, 0.5F, 3, 7, 1);
        this.Piece1.addBox("Shape6", -3.0F, 3.0F, 0.5F, 4, 1, 1);
        this.Piece1.addBox("Shape7", -3.0F, 2.5F, 0.5F, 1, 1, 1);
        this.Piece1.addBox("Shape8", -1.0F, 1.5F, 0.5F, 1, 2, 1);
        this.Piece1.addBox("Shape9", -3.0F, -3.0F, 0.5F, 4, 1, 1);
        this.Piece1.addBox("Shape10", -2.0F, 2.0F, 0.5F, 1, 1, 1);
        this.Piece1.addBox("Shape11", -2.0F, -2.0F, 0.5F, 1, 1, 1);
        this.Piece1.addBox("Shape12", -3.0F, -2.5F, 0.5F, 1, 1, 1);
        this.Piece1.addBox("Shape13", -1.0F, -2.5F, 0.5F, 1, 2, 1);
        this.Piece1.addBox("Shape14", 0.0F, -2.0F, 0.5F, 1, 2, 1);
        this.Piece1.addBox("Shape15", 0.0F, 1.0F, 0.5F, 1, 2, 1);
        this.Piece1.addBox("Shape16", -6.5F, -2.5F, 0.5F, 1, 6, 1);
        this.Piece1.addBox("Shape17", 3.5F, -2.5F, 0.5F, 1, 6, 1);
        this.setTexture(new ResourceLocation("minidot", "pets/yt_button.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        GlStateManager.translate(0.8F, -0.5F + f, 0.4F);
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
    }

    public void itemMotion(float rotation, int number)
    {
        GlStateManager.rotate(180.0F + MathHelper.sin(rotation * 0.07F) * 20.0F, 0.0F, 0.2F, 0.0F);
        GlStateManager.translate(0.0F, -0.1F, -0.2F);
    }

    public String getName()
    {
        return "\u041a\u043d\u043e\u043f\u043a\u0430" + EnumChatFormatting.RESET + EnumChatFormatting.BOLD + " You" + EnumChatFormatting.RED + EnumChatFormatting.BOLD + "Tube";
    }
}
