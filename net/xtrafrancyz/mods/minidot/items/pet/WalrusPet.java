package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class WalrusPet extends BasePet
{
    private final MModelRenderer tail1;
    private final MModelRenderer tail2;
    private final MModelRenderer tail3;
    private final MModelRenderer tail4;
    private final MModelRenderer shape1;
    private final MModelRenderer shape2;
    private final MModelRenderer shape3;
    private final MModelRenderer shape4;
    private final MModelRenderer Body1;
    private final MModelRenderer Body2;
    private final MModelRenderer Body3;
    private final MModelRenderer shape12;
    private final MModelRenderer shape13;

    public WalrusPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.useDisplayLists = true;
        this.tail2 = new MModelRenderer(this, 0, 11);
        this.tail2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail2.addBox(-1.0F, 0.0F, 3.5F, 2, 1, 2, 0.0F);
        this.tail3 = new MModelRenderer(this, 1, 13);
        this.tail3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail3.addBox(-1.4F, -1.0E-4F, 5.0F, 1, 1, 2, 0.0F);
        this.setRotation(this.tail3, 0.0F, 0.2617994F, 0.0F);
        this.Body3 = new MModelRenderer(this, 44, 2);
        this.Body3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Body3.addBox(-4.0F, 2.0F, -1.0F, 2, 1, 2, 0.0F);
        this.shape12 = new MModelRenderer(this, 52, 0);
        this.shape12.setRotationPoint(3.5F, 3.0F, 0.5F);
        this.shape12.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 2, 0.0F);
        this.setRotation(this.shape12, 0.0F, 0.4537856F, 0.0F);
        this.shape13 = new MModelRenderer(this, 52, 4);
        this.shape13.setRotationPoint(-3.5F, 3.0F, 0.5F);
        this.shape13.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 2, 0.0F);
        this.setRotation(this.shape13, 0.0F, -0.4537856F, 0.0F);
        this.Body2 = new MModelRenderer(this, 44, 2);
        this.Body2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Body2.addBox(2.0F, 2.0F, -1.0F, 2, 1, 2, 0.0F);
        this.shape3 = new MModelRenderer(this, 27, 9);
        this.shape3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape3.addBox(0.95F, 0.7F, -3.0F, 1, 4, 1, 0.0F);
        this.setRotation(this.shape3, 0.12217305F, 0.0F, -0.034906585F);
        this.shape4 = new MModelRenderer(this, 27, 9);
        this.shape4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape4.addBox(-1.95F, 0.7F, -3.0F, 1, 4, 1, 0.0F);
        this.setRotation(this.shape4, 0.12217305F, 0.0F, 0.034906585F);
        this.tail1 = new MModelRenderer(this, 26, 0);
        this.tail1.setRotationPoint(0.0F, 2.3F, 7.0F);
        this.tail1.addBox(-2.0F, -1.5F, -1.0F, 4, 3, 5, 0.0F);
        this.Body1 = new MModelRenderer(this, 0, 0);
        this.Body1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Body1.addBox(-3.0F, 0.0F, 0.0F, 6, 4, 7, 0.0F);
        this.shape2 = new MModelRenderer(this, 32, 16);
        this.shape2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape2.addBox(-1.0F, 0.0F, -3.0F, 2, 2, 1, 0.0F);
        this.tail4 = new MModelRenderer(this, 1, 13);
        this.tail4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail4.addBox(0.4F, -1.0E-4F, 5.0F, 1, 1, 2, 0.0F);
        this.setRotation(this.tail4, 0.0F, -0.2617994F, 0.0F);
        this.shape1 = new MModelRenderer(this, 31, 9);
        this.shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1.addBox(-2.0F, -1.0F, -2.0F, 4, 3, 3, 0.0F);
        this.tail1.addChild(this.tail2);
        this.tail2.addChild(this.tail3);
        this.tail2.addChild(this.tail4);

        for (MModelRenderer mmodelrenderer : this.getAllModels())
        {
            mmodelrenderer.setDynamic(true);
        }

        this.recollectModels();
        this.setTexture(new ResourceLocation("minidot", "pets/walrus.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.cos(time * 0.16F);
        float f1 = MathHelper.cos(time * 0.2F);
        float f2 = MathHelper.sin(time * 0.16F) * 0.02F;
        GlStateManager.translate(0.7F, -0.65F + f2, 0.4F);
        GlStateManager.scale(1.5F, 1.5F, 1.5F);
        GlStateManager.rotate(f * 3.0F, 0.2F, 0.0F, 0.0F);
        this.shape12.rotationY = -f * 0.2F;
        this.shape13.rotationY = -f * 0.2F;
        this.tail1.rotationX = f * 0.09F;
        this.tail1.rotationY = f1 * 0.03F;
        this.tail2.rotationX = f * 0.04F;
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -0.1F, -0.2F);
        GlStateManager.scale(1.4F, 1.4F, 1.2F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041c\u043e\u0440\u0436";
    }
}
