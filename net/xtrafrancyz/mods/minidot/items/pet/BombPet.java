package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class BombPet extends BasePet
{
    private final MModelRenderer Shape1;
    private final MModelRenderer Shape2;
    private final MModelRenderer Shape3;
    private final MModelRenderer Shape4;
    private final MModelRenderer Shape10;
    private final MModelRenderer Shape11;
    private final MModelRenderer Piece1;

    public BombPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.disableAnimationInPreview = true;
        this.setTextureOffset("Piece1.Shape5", 0, 24);
        this.setTextureOffset("Piece1.Shape6", 0, 24);
        this.setTextureOffset("Piece1.Shape7", 0, 24);
        this.setTextureOffset("Piece1.Shape8", 0, 24);
        this.setTextureOffset("Piece1.Shape9", 5, 24);
        this.Shape1 = new MModelRenderer(this, 0, 0);
        this.Shape1.addBox(0.0F, 0.0F, 0.0F, 6, 6, 6);
        this.Shape1.setRotationPoint(-3.0F, 0.0F, -3.0F);
        this.Shape2 = new MModelRenderer(this, 0, 12);
        this.Shape2.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2);
        this.Shape2.setRotationPoint(-1.0F, -1.0F, -1.0F);
        this.Shape3 = new MModelRenderer(this, 8, 12);
        this.Shape3.addBox(-0.5F, -3.0F, -0.7F, 1, 3, 1);
        this.setRotation(this.Shape3, -0.2602503F, 0.0F, 0.0F);
        this.Shape4 = new MModelRenderer(this, 0, 21);
        this.Shape4.addBox(-0.5F, -0.5F, 0.5F, 1, 1, 1);
        this.Shape4.setRotationPoint(0.0F, 3.0F, 2.5F);
        this.Shape4.setDynamic(true);
        this.Shape10 = new MModelRenderer(this, 0, 16);
        this.Shape10.addBox(0.0F, 0.0F, -3.0F, 2, 2, 3);
        this.Shape10.setRotationPoint(1.0F, 6.0F, 0.0F);
        this.setRotation(this.Shape10, 0.0F, -0.1745329F, 0.0F);
        this.Shape10.setDynamic(true);
        this.Shape11 = new MModelRenderer(this, 0, 16);
        this.Shape11.addBox(-2.0F, 0.0F, -3.0F, 2, 2, 3);
        this.Shape11.setRotationPoint(-1.0F, 6.0F, 0.0F);
        this.setRotation(this.Shape11, 0.0F, 0.1745329F, 0.0F);
        this.Shape11.setDynamic(true);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.setRotationPoint(0.0F, 3.0F, 4.0F);
        this.Piece1.addBox("Shape5", -0.5F, -2.5F, 0.0F, 1, 5, 1);
        this.Piece1.addBox("Shape6", -0.5F, -2.5F, 1.0F, 1, 1, 1);
        this.Piece1.addBox("Shape7", -0.5F, -0.5F, 1.0F, 1, 1, 1);
        this.Piece1.addBox("Shape8", -0.5F, 1.5F, 1.0F, 1, 1, 1);
        this.Piece1.addBox("Shape9", -0.5F, -2.5F, 2.0F, 1, 5, 1);
        this.Piece1.setDynamic(true);
        this.setTexture(new ResourceLocation("minidot", "pets/bomb.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        float f1 = MathHelper.cos(time * 0.16F);
        float f2 = MathHelper.sin(time * 0.7F) * 0.6F;
        GlStateManager.translate(0.7F, -0.5F + f, 0.3F);
        GlStateManager.rotate(f1 * 4.0F, 0.0F, 0.6F, 0.0F);
        GlStateManager.scale(1.3F, 1.3F, 1.3F);
        this.Piece1.rotationZ = time * 0.13F;
        this.Shape4.rotationZ = this.Piece1.rotationZ;
        this.Shape10.rotationX = f2 + 0.6F;
        this.Shape11.rotationX = -f2 + 0.6F;
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -0.25F, 0.0F);
        GlStateManager.scale(1.5F, 1.5F, 1.5F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0411\u043e\u043c\u0431\u043e\u0447\u043a\u0430";
    }
}
