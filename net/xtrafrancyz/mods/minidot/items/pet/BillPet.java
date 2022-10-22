package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.List;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.util.MNaming;

public class BillPet extends BasePet
{
    private final MModelRenderer Bill1;
    private final MModelRenderer Bill2;
    private final MModelRenderer Piece1;

    public BillPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("Bill1.Bill20", 60, 13);
        this.setTextureOffset("Bill1.Bil14", 60, 13);
        this.setTextureOffset("Bill2.Bill15", 60, 13);
        this.setTextureOffset("Bill2.Bill21", 60, 13);
        this.setTextureOffset("Piece1.Bill0", 56, 25);
        this.setTextureOffset("Piece1.Bill1", 36, 26);
        this.setTextureOffset("Piece1.Bill2", 10, 8);
        this.setTextureOffset("Piece1.Bill3", 8, 12);
        this.setTextureOffset("Piece1.Bill4", 6, 16);
        this.setTextureOffset("Piece1.Bill5", 4, 20);
        this.setTextureOffset("Piece1.Bill6", 2, 24);
        this.setTextureOffset("Piece1.Bill7", 0, 28);
        this.setTextureOffset("Piece1.Bill8", 56, 0);
        this.setTextureOffset("Piece1.Bill9", 50, 0);
        this.setTextureOffset("Piece1.Bill10", 60, 0);
        this.setTextureOffset("Piece1.Bill11", 56, 0);
        this.setTextureOffset("Piece1.Bill12", 60, 0);
        this.setTextureOffset("Piece1.Bill13", 60, 16);
        this.setTextureOffset("Piece1.Bill16", 56, 20);
        this.setTextureOffset("Piece1.Bill17", 48, 22);
        this.setTextureOffset("Piece1.Bill18", 60, 13);
        this.setTextureOffset("Piece1.Bill19", 60, 16);
        this.setTextureOffset("Piece1.Bill22", 56, 20);
        this.setTextureOffset("Piece1.Bill23", 48, 22);
        this.setTextureOffset("Piece1.Bill24", 60, 13);
        this.Bill1 = new MModelRenderer(this, "Bill1");
        this.setRotation(this.Bill1, -((float)Math.PI / 4F), 0.0F, 0.0F);
        this.Bill1.addBox("Bill20", 5.0F, 5.3F, 5.2F, 1, 2, 1);
        this.Bill1.addBox("Bil14", -6.0F, 5.3F, 5.2F, 1, 2, 1);
        this.Bill2 = new MModelRenderer(this, "Bill2");
        this.setRotation(this.Bill2, ((float)Math.PI / 4F), 0.0F, 0.0F);
        this.Bill2.addBox("Bill21", 5.0F, 6.0F, -5.5F, 1, 2, 1);
        this.Bill2.addBox("Bill15", -6.0F, 6.0F, -5.5F, 1, 2, 1);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.addBox("Bill0", -1.0F, -16.0F, -0.5F, 2, 5, 2);
        this.Piece1.addBox("Bill1", -2.5F, -11.0F, -2.0F, 5, 1, 5);
        this.Piece1.addBox("Bill2", -2.0F, -10.0F, -0.5F, 4, 2, 2);
        this.Piece1.addBox("Bill3", -3.0F, -8.0F, -0.5F, 6, 2, 2);
        this.Piece1.addBox("Bill4", -4.0F, -6.0F, -0.5F, 8, 2, 2);
        this.Piece1.addBox("Bill5", -5.0F, -4.0F, -0.5F, 10, 2, 2);
        this.Piece1.addBox("Bill6", -6.0F, -2.0F, -0.5F, 12, 2, 2);
        this.Piece1.addBox("Bill7", -7.0F, 0.0F, -0.5F, 14, 2, 2);
        this.Piece1.addBox("Bill8", -2.0F, -7.0F, -1.0F, 1, 3, 1);
        this.Piece1.addBox("Bill9", -1.0F, -8.0F, -1.0F, 2, 5, 1);
        this.Piece1.addBox("Bill10", -3.0F, -6.0F, -1.0F, 1, 1, 1);
        this.Piece1.addBox("Bill11", 1.0F, -7.0F, -1.0F, 1, 3, 1);
        this.Piece1.addBox("Bill12", 2.0F, -6.0F, -1.0F, 1, 1, 1);
        this.Piece1.addBox("Bill13", -6.0F, 2.0F, 0.0F, 1, 8, 1);
        this.Piece1.addBox("Bill16", -3.0F, 2.0F, 0.0F, 1, 4, 1);
        this.Piece1.addBox("Bill17", -3.0F, 5.0F, 1.0F, 1, 1, 3);
        this.Piece1.addBox("Bill18", -3.0F, 6.0F, 3.0F, 1, 2, 1);
        this.Piece1.addBox("Bill19", 5.0F, 2.0F, 0.0F, 1, 8, 1);
        this.Piece1.addBox("Bill22", 2.0F, 2.0F, 0.0F, 1, 4, 1);
        this.Piece1.addBox("Bill23", 2.0F, 5.0F, 1.0F, 1, 1, 3);
        this.Piece1.addBox("Bill24", 2.0F, 6.0F, 3.0F, 1, 2, 1);
        this.setTexture(new ResourceLocation("minidot", "pets/billpet.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.12F) * 0.08F;
        GlStateManager.translate(0.7F, -0.5F + f, 0.4F);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.08F, 0.0F);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0411\u0438\u043b\u043b \u0428\u0438\u0444\u0440";
    }

    public String getCreator()
    {
        return "_Mik_";
    }

    public List<String> getDescription()
    {
        return MNaming.fromMult("Gravity Falls");
    }
}
