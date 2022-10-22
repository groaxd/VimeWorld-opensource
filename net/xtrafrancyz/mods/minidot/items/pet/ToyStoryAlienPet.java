package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.List;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.util.MNaming;

public class ToyStoryAlienPet extends BasePet
{
    private final MModelRenderer Alien;
    private final MModelRenderer Body;
    private final MModelRenderer Head;
    private final MModelRenderer AleinHorn;
    private final MModelRenderer Eyes;
    private final MModelRenderer Ears;
    private final MModelRenderer LeftEar;
    private final MModelRenderer RightEar;
    private final MModelRenderer Arms;
    private final MModelRenderer LeftArm;
    private final MModelRenderer RightArm;
    private final MModelRenderer Legs;
    private final MModelRenderer LeftLeg;
    private final MModelRenderer RightLeg;

    public ToyStoryAlienPet()
    {
        this.textureWidth = 34;
        this.textureHeight = 34;
        this.Alien = new MModelRenderer(this);
        this.Alien.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.Body = new MModelRenderer(this);
        this.Body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Alien.addChild(this.Body);
        this.Body.setTextureOffset(0, 11).addBox(-4.0F, -13.0F, -2.0F, 8, 8, 4, 0.0F);
        this.Head = new MModelRenderer(this);
        this.Head.setRotationPoint(1.5F, -13.0F, 0.0F);
        this.Alien.addChild(this.Head);
        this.Head.setTextureOffset(0, 0).addBox(-7.0F, -5.0F, -3.0F, 11, 5, 6, 0.0F);
        this.AleinHorn = new MModelRenderer(this);
        this.AleinHorn.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.Head.addChild(this.AleinHorn);
        this.setRotation(this.AleinHorn, -0.5672F, 0.0F, 0.0F);
        this.AleinHorn.setTextureOffset(0, 0).addBox(-2.0F, -6.0F, -3.0F, 1, 5, 1, 0.0F);
        this.AleinHorn.setTextureOffset(0, 11).addBox(-2.0F, -7.0F, -3.0F, 1, 1, 1, 0.2F);
        this.Eyes = new MModelRenderer(this);
        this.Eyes.setRotationPoint(2.5F, -2.5F, -4.1F);
        this.Head.addChild(this.Eyes);
        this.Eyes.setTextureOffset(29, 0).addBox(-4.5F, -1.0F, 1.1F, 1, 1, 0, 0.1F);
        this.Eyes.setTextureOffset(28, 0).addBox(-8.0F, -1.0F, 1.0F, 1, 1, 0, 0.0F);
        this.Eyes.setTextureOffset(28, 0).addBox(-1.0F, -1.0F, 1.0F, 1, 1, 0, 0.0F);
        this.Ears = new MModelRenderer(this);
        this.Ears.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head.addChild(this.Ears);
        this.LeftEar = new MModelRenderer(this);
        this.LeftEar.setRotationPoint(11.0F, -2.0F, 0.0F);
        this.Ears.addChild(this.LeftEar);
        this.setRotation(this.LeftEar, -1.0472F, 0.0F, 0.0F);
        this.LeftEar.setTextureOffset(26, 27).addBox(-7.0F, -5.0F, -2.0F, 1, 5, 2, 0.0F);
        this.RightEar = new MModelRenderer(this);
        this.RightEar.setRotationPoint(-14.0F, -2.0F, 0.0F);
        this.Ears.addChild(this.RightEar);
        this.setRotation(this.RightEar, -1.0472F, 0.0F, 0.0F);
        this.RightEar.setTextureOffset(20, 27).addBox(6.0F, -5.0F, -2.0F, 1, 5, 2, 0.0F);
        this.Arms = new MModelRenderer(this);
        this.Arms.setRotationPoint(-9.0F, -5.0F, 0.5F);
        this.Alien.addChild(this.Arms);
        this.LeftArm = new MModelRenderer(this);
        this.LeftArm.setRotationPoint(13.0F, -7.0F, -0.5F);
        this.Arms.addChild(this.LeftArm);
        this.LeftArm.setTextureOffset(24, 11).addBox(0.0F, 0.0F, -1.5F, 1, 6, 3, 0.0F);
        this.RightArm = new MModelRenderer(this);
        this.RightArm.setRotationPoint(4.9F, -7.05F, -0.5F);
        this.Arms.addChild(this.RightArm);
        this.RightArm.setTextureOffset(12, 23).addBox(-0.9F, 0.05F, -1.5F, 1, 6, 3, 0.0F);
        this.Legs = new MModelRenderer(this);
        this.Legs.setRotationPoint(2.5F, 4.8F, -0.5F);
        this.Alien.addChild(this.Legs);
        this.LeftLeg = new MModelRenderer(this);
        this.LeftLeg.setRotationPoint(-0.4F, -9.9F, 0.4F);
        this.Legs.addChild(this.LeftLeg);
        this.LeftLeg.setTextureOffset(21, 21).addBox(-1.6F, -0.1F, -1.4F, 3, 3, 3, -0.1F);
        this.RightLeg = new MModelRenderer(this);
        this.RightLeg.setRotationPoint(-4.5F, -9.8F, 0.7F);
        this.Legs.addChild(this.RightLeg);
        this.RightLeg.setTextureOffset(0, 23).addBox(-1.5F, -0.2F, -1.7F, 3, 3, 3, -0.1F);
        this.setTexture(new ResourceLocation("minidot", "pets/toystoryalienpet.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.05F;
        GlStateManager.translate(0.699999988079071D, -0.8D + (double)f, 0.25D);
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(0.85F, 0.85F, 0.85F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
        GlStateManager.translate(0.0F, -0.4F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041f\u0440\u0438\u0448\u0435\u043b\u0435\u0446";
    }

    public String getCreator()
    {
        return "Wenston";
    }

    public List<String> getDescription()
    {
        return MNaming.fromMult("\u0418\u0441\u0442\u043e\u0440\u0438\u044f \u0438\u0433\u0440\u0443\u0448\u0435\u043a");
    }
}
