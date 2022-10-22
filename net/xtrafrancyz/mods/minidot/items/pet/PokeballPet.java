package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.List;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.util.MNaming;

public class PokeballPet extends BasePet
{
    private final MModelRenderer Piece1;

    public PokeballPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.setTextureOffset("Piece1.Shape1", 0, 0);
        this.setTextureOffset("Piece1.Shape2", 0, 46);
        this.setTextureOffset("Piece1.Shape3", 12, 5);
        this.setTextureOffset("Piece1.Shape4", 0, 54);
        this.setTextureOffset("Piece1.Shape5", 12, 5);
        this.setTextureOffset("Piece1.Shape6", 12, 5);
        this.setTextureOffset("Piece1.Shape7", 0, 52);
        this.setTextureOffset("Piece1.Shape8", 0, 52);
        this.setTextureOffset("Piece1.Shape9", 0, 58);
        this.setTextureOffset("Piece1.Shape10", 12, 5);
        this.setTextureOffset("Piece1.Shape11", 12, 5);
        this.setTextureOffset("Piece1.Shape12", 0, 58);
        this.setTextureOffset("Piece1.Shape13", 0, 28);
        this.setTextureOffset("Piece1.Shape14", 0, 28);
        this.setTextureOffset("Piece1.Shape15", 0, 28);
        this.setTextureOffset("Piece1.Shape16", 0, 20);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.mirror = true;
        this.Piece1.addBox("Shape1", -6.0F, -6.5F, -6.0F, 12, 6, 12);
        this.Piece1.addBox("Shape2", -6.0F, 0.5F, -6.0F, 12, 6, 12);
        this.Piece1.addBox("Shape3", -4.0F, -8.0F, -4.0F, 8, 2, 8);
        this.Piece1.addBox("Shape4", -4.0F, 6.0F, -4.0F, 8, 2, 8);
        this.Piece1.addBox("Shape5", 5.5F, -4.5F, -4.0F, 2, 4, 8);
        this.Piece1.addBox("Shape6", -7.5F, -4.5F, -4.0F, 2, 4, 8);
        this.Piece1.addBox("Shape7", 5.5F, 0.5F, -4.0F, 2, 4, 8);
        this.Piece1.addBox("Shape8", -7.5F, 0.5F, -4.0F, 2, 4, 8);
        this.Piece1.addBox("Shape9", -4.0F, 0.5F, 5.5F, 8, 4, 2);
        this.Piece1.addBox("Shape10", -4.0F, -4.5F, 5.5F, 8, 4, 2);
        this.Piece1.addBox("Shape11", -4.0F, -4.5F, -7.5F, 8, 4, 2);
        this.Piece1.addBox("Shape12", -4.0F, 0.5F, -7.5F, 8, 4, 2);
        this.Piece1.addBox("Shape13", -5.5F, -1.0F, -5.5F, 11, 2, 11);
        this.Piece1.addBox("Shape14", -7.0F, -1.0F, -3.5F, 14, 2, 7);
        this.Piece1.addBox("Shape15", -3.5F, -1.0F, -7.0F, 7, 2, 14);
        this.Piece1.addBox("Shape16", -2.0F, -2.0F, -8.0F, 4, 4, 2);
        this.setTexture(new ResourceLocation("minidot", "pets/pokeball.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.05F;
        GlStateManager.translate(0.6F, -0.5F + f, 0.3F);
        GlStateManager.scale(0.5F, 0.5F, 0.5F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041f\u043e\u043a\u0435\u0431\u043e\u043b";
    }

    public List<String> getDescription()
    {
        return MNaming.fromMult("\u041f\u043e\u043a\u0435\u043c\u043e\u043d");
    }
}
