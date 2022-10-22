package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.List;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.util.MNaming;

public class BimoPet extends BasePet
{
    private final MModelRenderer body;
    private final MModelRenderer leftHand;
    private final MModelRenderer rightHand;
    private final MModelRenderer rightLeg;
    private final MModelRenderer leftLeg;

    public BimoPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.disableAnimationInPreview = true;
        this.setTextureOffset("rightLeg.rightLeg", 0, 0);
        this.setTextureOffset("rightLeg.rightLeg1", 0, 0);
        this.setTextureOffset("leftLeg.leftLeg", 0, 0);
        this.setTextureOffset("leftLeg.leftLeg1", 0, 0);
        this.body = new MModelRenderer(this, 0, 0);
        this.body.addBox(0.0F, 0.0F, 0.0F, 9, 13, 7);
        this.body.setRotationPoint(-4.5F, 0.0F, -4.0F);
        this.leftHand = new MModelRenderer(this, 0, 0);
        this.leftHand.addBox(0.0F, -0.5F, -0.5F, 1, 5, 1);
        this.leftHand.setRotationPoint(4.5F, 9.5F, -0.5F);
        this.leftHand.setDynamic(true);
        this.rightHand = new MModelRenderer(this, 0, 0);
        this.rightHand.addBox(-1.0F, -0.5F, -0.5F, 1, 5, 1);
        this.rightHand.setRotationPoint(-4.5F, 9.5F, -0.5F);
        this.rightHand.setDynamic(true);
        this.rightLeg = new MModelRenderer(this, "rightLeg");
        this.rightLeg.setRotationPoint(-2.0F, 13.0F, -0.5F);
        this.rightLeg.addBox("rightLeg", -0.5F, 0.0F, -0.5F, 1, 3, 1);
        this.rightLeg.addBox("rightLeg1", -0.5F, 2.0F, -1.5F, 1, 1, 1);
        this.rightLeg.setDynamic(true);
        this.leftLeg = new MModelRenderer(this, "leftLeg");
        this.leftLeg.setRotationPoint(2.0F, 13.0F, -0.5F);
        this.leftLeg.addBox("leftLeg", -0.5F, 0.0F, -0.5F, 1, 3, 1);
        this.leftLeg.addBox("leftLeg1", -0.5F, 2.0F, -1.5F, 1, 1, 1);
        this.leftLeg.setDynamic(true);
        this.setTexture(new ResourceLocation("minidot", "pets/bimopet.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        float f1 = MathHelper.sin(time * 0.26F) * 0.05F;
        float f2 = MathHelper.cos(time * 0.16F);
        float f3 = 0.0F;

        if (time % 70.0F > 50.0F)
        {
            f3 = MathHelper.cos(time % 70.0F * 0.15F + 0.4F) * 2.0F;
        }

        GlStateManager.translate(0.6F, -0.6F + f, 0.4F);
        GlStateManager.rotate(f2 * 4.0F, 0.0F, 0.6F, 0.0F);
        this.rightLeg.rotationX = f1 * 3.0F;
        this.rightLeg.rotationY = f * 6.0F;
        this.leftLeg.rotationX = -f1 * 3.0F;
        this.leftLeg.rotationZ = f * 5.0F;
        this.leftHand.rotationX = f2 * 0.1F;
        this.leftHand.rotationY = -f2 * f * 2.0F;
        this.leftHand.rotationZ = f2 * f * 4.0F + f3;
        this.rightHand.rotationX = -this.leftHand.rotationX;
        this.rightHand.rotationY = -this.leftHand.rotationY;
        this.rightHand.rotationZ = f2 * f * 4.0F - f3;
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -0.24F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "Bimo";
    }

    public List<String> getDescription()
    {
        return MNaming.fromMult("\u0412\u0440\u0435\u043c\u044f \u041f\u0440\u0438\u043a\u043b\u044e\u0447\u0435\u043d\u0438\u0439");
    }
}
