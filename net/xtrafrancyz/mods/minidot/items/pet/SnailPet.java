package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class SnailPet extends BasePet
{
    private final MModelRenderer Shape1;
    private final MModelRenderer Shape2;
    private final MModelRenderer Shape3;
    private final MModelRenderer Shape4;
    private final MModelRenderer Shape5;
    private final MModelRenderer Shape6;
    private final MModelRenderer Shape7;

    public SnailPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Shape1 = new MModelRenderer(this, 16, 21);
        this.Shape1.addBox(0.0F, 0.0F, 0.0F, 4, 3, 8);
        this.Shape1.setRotationPoint(-2.0F, 0.0F, -3.0F);
        this.Shape1.mirror = true;
        this.Shape2 = new MModelRenderer(this, 0, 27);
        this.Shape2.addBox(0.0F, 0.0F, 0.0F, 3, 2, 3);
        this.Shape2.setRotationPoint(-1.5F, 1.0F, -5.0F);
        this.Shape2.mirror = true;
        this.Shape3 = new MModelRenderer(this, 54, 28);
        this.Shape3.addBox(-1.0F, -0.5F, 0.0F, 2, 1, 3);
        this.Shape3.setRotationPoint(0.0F, 2.5F, 7.0F);
        this.Shape3.mirror = true;
        this.Shape4 = new MModelRenderer(this, 0, 11);
        this.Shape4.addBox(-0.5F, -5.0F, -0.5F, 1, 5, 1);
        this.Shape4.setRotationPoint(0.7F, 1.0F, -4.0F);
        this.Shape4.mirror = true;
        this.Shape7 = new MModelRenderer(this, 0, 11);
        this.Shape7.addBox(-0.5F, -5.0F, -0.5F, 1, 5, 1);
        this.Shape7.setRotationPoint(-0.7F, 1.0F, -4.0F);
        this.Shape7.mirror = true;
        this.Shape5 = new MModelRenderer(this, 24, 0);
        this.Shape5.addBox(0.0F, 0.0F, 0.0F, 5, 9, 8);
        this.Shape5.setRotationPoint(-2.5F, -7.3F, -1.0F);
        this.Shape5.mirror = true;
        this.Shape6 = new MModelRenderer(this, 40, 26);
        this.Shape6.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 4);
        this.Shape6.setRotationPoint(0.0F, 1.0F, 4.0F);
        this.Shape6.mirror = true;

        for (MModelRenderer mmodelrenderer : this.getAllModels())
        {
            mmodelrenderer.setDynamic(true);
        }

        this.recollectModels();
        this.setTexture(new ResourceLocation("minidot", "pets/snail.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        float f1 = MathHelper.sin(time * 0.16F) * 0.15F;
        float f2 = MathHelper.sin(time * 0.1F) * 0.01F;
        float f3 = MathHelper.sin(time * 0.1F - 0.7F) * 0.01F;
        float f4 = MathHelper.cos(time * 0.16F);
        GlStateManager.translate(0.65F, -0.35F + f, 0.3F);
        GlStateManager.rotate(f4 * 4.0F, 0.0F, 0.6F, 0.0F);
        this.Shape3.offsetZ = f3 * 1.8F;
        this.Shape2.offsetZ = -this.Shape3.offsetZ * 0.5F;
        this.Shape4.rotationY = f1;
        this.Shape4.rotationZ = f1 * 0.25F;
        this.Shape4.offsetZ = this.Shape2.offsetZ;
        this.Shape7.rotationY = -f1;
        this.Shape7.rotationZ = -this.Shape4.rotationZ;
        this.Shape7.offsetZ = this.Shape2.offsetZ;
        this.Shape6.offsetZ = f2;
        this.Shape1.offsetZ = this.Shape2.offsetZ;
        this.Shape5.offsetZ = this.Shape2.offsetZ;
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(1.3F, 1.3F, 1.3F);
        GlStateManager.translate(0.0F, 0.04F, -0.06F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0423\u043b\u0438\u0442\u043a\u0430";
    }
}
