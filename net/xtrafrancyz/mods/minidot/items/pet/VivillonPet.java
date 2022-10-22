package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class VivillonPet extends BasePet
{
    private final MModelRenderer body;
    private final MModelRenderer leftLeg;
    private final MModelRenderer rightLeg;
    private final MModelRenderer leftHand;
    private final MModelRenderer rightHand;
    private final MModelRenderer head;
    private final MModelRenderer rightStick;
    private final MModelRenderer leftStick;
    private final MModelRenderer leftWing;
    private final MModelRenderer rightWing;

    public VivillonPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.setTextureOffset("rightStick.rightHorn", 0, 0);
        this.setTextureOffset("rightStick.rightStick", 10, 31);
        this.setTextureOffset("leftStick.leftHorn", 0, 0);
        this.setTextureOffset("leftStick.LeftStick", 10, 31);
        this.body = new MModelRenderer(this, 0, 16);
        this.body.addBox(-3.0F, 0.0F, -2.0F, 6, 9, 5);
        this.leftLeg = new MModelRenderer(this, 0, 31);
        this.leftLeg.addBox(-0.8F, -0.5F, -1.0F, 2, 5, 2);
        this.leftLeg.setRotationPoint(2.0F, 8.0F, -1.0F);
        this.setRotation(this.leftLeg, -0.5235988F, 0.0F, 0.0F);
        this.leftLeg.setDynamic(true);
        this.rightLeg = new MModelRenderer(this, 0, 31);
        this.rightLeg.addBox(-1.2F, -0.5F, -1.0F, 2, 5, 2);
        this.rightLeg.setRotationPoint(-2.0F, 8.0F, -1.0F);
        this.setRotation(this.rightLeg, -0.5235988F, 0.0F, 0.0F);
        this.rightLeg.setDynamic(true);
        this.leftHand = new MModelRenderer(this, 0, 0);
        this.leftHand.addBox(-1.0F, -1.0F, -2.0F, 2, 2, 2);
        this.leftHand.setRotationPoint(2.0F, 3.0F, -2.0F);
        this.rightHand = new MModelRenderer(this, 0, 0);
        this.rightHand.addBox(-1.0F, -1.0F, -2.0F, 2, 2, 2);
        this.rightHand.setRotationPoint(-2.0F, 3.0F, -2.0F);
        this.head = new MModelRenderer(this, 2, 0);
        this.head.addBox(-4.0F, -7.0F, -4.0F, 8, 7, 8);
        this.rightStick = new MModelRenderer(this, "rightStick");
        this.rightStick.setRotationPoint(-2.0F, -7.0F, 1.0F);
        this.rightStick.addBox("rightHorn", -0.5F, -6.0F, -0.5F, 1, 6, 1);
        this.rightStick.addBox("rightStick", -1.0F, -10.0F, -1.0F, 2, 4, 2);
        this.rightStick.setDynamic(true);
        this.leftStick = new MModelRenderer(this, "leftStick");
        this.leftStick.setRotationPoint(2.0F, -7.0F, 1.0F);
        this.leftStick.addBox("leftHorn", -0.5F, -6.0F, -0.5F, 1, 6, 1);
        this.leftStick.addBox("LeftStick", -1.0F, -10.0F, -1.0F, 2, 4, 2);
        this.leftStick.setDynamic(true);
        this.leftWing = new MModelRenderer(this, 0, 38);
        this.leftWing.addBox(1.0F, -19.0F, 0.0F, 20, 26, 0);
        this.leftWing.setRotationPoint(2.0F, 5.0F, 2.0F);
        this.setRotation(this.leftWing, 0.0872665F, -0.8726646F, 0.0F);
        this.leftWing.setDynamic(true);
        this.rightWing = new MModelRenderer(this, 0, 38);
        this.rightWing.addBox(1.0F, -19.0F, 0.0F, 20, 26, 0);
        this.rightWing.setRotationPoint(-2.0F, 5.0F, 2.0F);
        this.setRotation(this.rightWing, -0.0872665F, -2.268928F, 0.0F);
        this.rightWing.setDynamic(true);
        this.setTexture(new ResourceLocation("minidot", "pets/vivillon.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        float f1 = MathHelper.sin(time * 0.36F) * 0.05F;
        float f2 = MathHelper.cos(time * 0.16F);
        GlStateManager.translate(0.6F, -0.5F + f, 0.3F);
        GlStateManager.rotate(f2 * 4.0F, 1.0F, 0.6F, 0.0F);
        GlStateManager.scale(0.65F, 0.65F, 0.65F);
        this.leftWing.rotationZ = f * 6.0F;
        this.leftWing.rotationY = f * 5.0F;
        this.rightWing.rotationZ = -this.leftWing.rotationZ;
        this.rightWing.rotationY = -this.leftWing.rotationY;
        this.leftStick.rotationX = f1 * 1.2F;
        this.rightStick.rotationX = -this.leftStick.rotationX;
        this.leftStick.rotationY = f * 6.0F;
        this.rightStick.rotationY = -f2 * 0.2F;
        this.leftStick.rotationZ = f * 1.7F;
        this.rightStick.rotationZ = -this.leftStick.rotationZ;
        this.rightLeg.rotationX = 0.2F;
        this.rightLeg.rotationY = -0.2F;
        this.rightLeg.rotationZ = f1;
        this.leftLeg.rotationX = this.rightLeg.rotationX;
        this.leftLeg.rotationY = -this.rightLeg.rotationY;
        this.leftLeg.rotationZ = -this.rightLeg.rotationZ;
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.65F, 0.65F, 0.65F);
        GlStateManager.translate(0.0F, 0.0F, -0.2F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0411\u0430\u0431\u043e\u0447\u043a\u0430";
    }
}
