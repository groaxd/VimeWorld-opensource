package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.List;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;
import net.xtrafrancyz.mods.minidot.util.MNaming;

public class PredatorPet extends BasePet
{
    private final MModelRenderer LeftUpCube;
    private final MModelRenderer Teeth;
    private final MModelRenderer Teeth2;
    private final MModelRenderer Teeth3;
    private final MModelRenderer RightUpCube;
    private final MModelRenderer Teeth4;
    private final MModelRenderer Teeth5;
    private final MModelRenderer Teeth6;
    private final MModelRenderer RightDownCube;
    private final MModelRenderer Teeth7;
    private final MModelRenderer Teeth8;
    private final MModelRenderer Teeth9;
    private final MModelRenderer LeftDownCube;
    private final MModelRenderer Teeth10;
    private final MModelRenderer Teeth11;
    private final MModelRenderer Teeth12;
    private final IAnimation animation;

    public PredatorPet()
    {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.LeftUpCube = new MModelRenderer(this);
        this.LeftUpCube.setRotationPoint(-2.5F, 17.0F, 0.0F);
        this.LeftUpCube.setTextureOffset(0, 0).addBox(-2.0F, -3.0F, -2.0F, 4, 4, 4, 0.0F);
        this.LeftUpCube.setTextureOffset(0, 8).addBox(-1.5F, -3.25F, -1.5F, 3, 1, 3, 0.0F);
        this.LeftUpCube.setTextureOffset(0, 12).addBox(-1.5F, -2.5F, 1.25F, 3, 3, 1, 0.0F);
        this.LeftUpCube.setTextureOffset(0, 16).addBox(-1.5F, -2.5F, -2.25F, 3, 3, 1, 0.0F);
        this.LeftUpCube.setTextureOffset(16, 2).addBox(-2.25F, -2.5F, -1.5F, 1, 3, 3, 0.0F);
        this.LeftUpCube.setTextureOffset(12, 8).addBox(-1.75F, -2.75F, -1.5F, 4, 4, 3, 0.0F);
        this.Teeth = new MModelRenderer(this);
        this.Teeth.setRotationPoint(0.75F, 0.5F, 0.5F);
        this.LeftUpCube.addChild(this.Teeth);
        this.Teeth.setTextureOffset(24, 5).addBox(0.75F, 0.0F, -1.5F, 1, 1, 2, 0.0F);
        this.Teeth2 = new MModelRenderer(this);
        this.Teeth2.setRotationPoint(-0.75F, 0.25F, -0.5F);
        this.Teeth.addChild(this.Teeth2);
        this.setRotation(this.Teeth2, 0.0F, 0.0F, 0.7854F);
        this.Teeth2.setTextureOffset(24, 5).addBox(-0.8839F, 0.591F, -1.0F, 1, 1, 2, 0.0F);
        this.Teeth2.setTextureOffset(24, 5).addBox(-0.061F, -0.4088F, -1.0F, 1, 1, 2, 0.0F);
        this.Teeth2.setTextureOffset(24, 5).addBox(0.8936F, -1.222F, -1.0F, 1, 1, 2, 0.0F);
        this.Teeth3 = new MModelRenderer(this);
        this.Teeth3.setRotationPoint(-0.5F, 0.5F, 0.0F);
        this.Teeth.addChild(this.Teeth3);
        this.setRotation(this.Teeth3, 0.0F, 0.0F, -0.7854F);
        this.Teeth3.setTextureOffset(24, 5).addBox(1.2884F, 0.5756F, -1.5F, 1, 1, 2, 0.0F);
        this.Teeth3.setTextureOffset(24, 5).addBox(2.1113F, -0.4243F, -1.5F, 1, 1, 2, 0.0F);
        this.Teeth3.setTextureOffset(24, 5).addBox(3.0659F, -1.2374F, -1.5F, 1, 1, 2, 0.0F);
        this.RightUpCube = new MModelRenderer(this);
        this.RightUpCube.setRotationPoint(3.0F, 17.0F, 0.0F);
        this.RightUpCube.setTextureOffset(0, 0).addBox(-2.5F, -3.0F, -2.0F, 4, 4, 4, 0.0F);
        this.RightUpCube.setTextureOffset(0, 8).addBox(-2.0F, -3.25F, -1.5F, 3, 1, 3, 0.0F);
        this.RightUpCube.setTextureOffset(0, 12).addBox(-2.0F, -2.5F, 1.25F, 3, 3, 1, 0.0F);
        this.RightUpCube.setTextureOffset(0, 16).addBox(-2.0F, -2.5F, -2.25F, 3, 3, 1, 0.0F);
        this.RightUpCube.setTextureOffset(16, 2).addBox(0.75F, -2.5F, -1.5F, 1, 3, 3, 0.0F);
        this.RightUpCube.setTextureOffset(12, 8).addBox(-2.75F, -2.75F, -1.5F, 4, 4, 3, 0.0F);
        this.Teeth4 = new MModelRenderer(this);
        this.Teeth4.setRotationPoint(-0.75F, 0.5F, 0.5F);
        this.RightUpCube.addChild(this.Teeth4);
        this.Teeth4.setTextureOffset(24, 5).addBox(-2.25F, 0.0F, -1.5F, 1, 1, 2, 0.0F);
        this.Teeth5 = new MModelRenderer(this);
        this.Teeth5.setRotationPoint(1.0F, 0.5F, 0.0F);
        this.Teeth4.addChild(this.Teeth5);
        this.setRotation(this.Teeth5, 0.0F, 0.0F, -0.7854F);
        this.Teeth5.setTextureOffset(24, 5).addBox(-2.2471F, -2.96F, -1.5F, 1, 1, 2, 0.0F);
        this.Teeth5.setTextureOffset(24, 5).addBox(-1.4243F, -3.9598F, -1.5F, 1, 1, 2, 0.0F);
        this.Teeth5.setTextureOffset(24, 5).addBox(-0.4697F, -4.773F, -1.5F, 1, 1, 2, 0.0F);
        this.Teeth6 = new MModelRenderer(this);
        this.Teeth6.setRotationPoint(0.75F, -0.75F, 0.0F);
        this.Teeth4.addChild(this.Teeth6);
        this.setRotation(this.Teeth6, 0.0F, 0.0F, 0.7854F);
        this.Teeth6.setTextureOffset(24, 5).addBox(-0.8329F, 1.9898F, -1.5F, 1, 1, 2, 0.0F);
        this.Teeth6.setTextureOffset(24, 5).addBox(-0.0101F, 0.9899F, -1.5F, 1, 1, 2, 0.0F);
        this.Teeth6.setTextureOffset(24, 5).addBox(0.9445F, 0.1768F, -1.5F, 1, 1, 2, 0.0F);
        this.RightDownCube = new MModelRenderer(this);
        this.RightDownCube.setRotationPoint(2.5F, 21.95F, 0.0F);
        this.RightDownCube.setTextureOffset(0, 12).addBox(-1.5F, -2.45F, 1.25F, 3, 3, 1, 0.0F);
        this.RightDownCube.setTextureOffset(0, 16).addBox(-1.5F, -2.45F, -2.25F, 3, 3, 1, 0.0F);
        this.RightDownCube.setTextureOffset(0, 0).addBox(-2.0F, -3.0F, -2.0F, 4, 4, 4, 0.0F);
        this.RightDownCube.setTextureOffset(0, 8).addBox(-1.5F, 0.25F, -1.5F, 3, 1, 3, 0.0F);
        this.RightDownCube.setTextureOffset(16, 2).addBox(1.25F, -2.5F, -1.5F, 1, 3, 3, 0.0F);
        this.RightDownCube.setTextureOffset(12, 8).addBox(-2.25F, -3.25F, -1.5F, 4, 4, 3, 0.0F);
        this.Teeth7 = new MModelRenderer(this);
        this.Teeth7.setRotationPoint(-0.25F, 0.55F, 0.5F);
        this.RightDownCube.addChild(this.Teeth7);
        this.Teeth7.setTextureOffset(24, 5).addBox(-2.25F, -4.0F, -1.5F, 1, 1, 2, 0.0F);
        this.Teeth8 = new MModelRenderer(this);
        this.Teeth8.setRotationPoint(0.0F, 0.0F, 0.5F);
        this.Teeth7.addChild(this.Teeth8);
        this.setRotation(this.Teeth8, 0.0F, 0.0F, -0.7854F);
        this.Teeth8.setTextureOffset(24, 5).addBox(-1.591F, -2.2374F, -2.0F, 1, 1, 2, 0.0F);
        this.Teeth8.setTextureOffset(24, 5).addBox(-0.7681F, -3.2373F, -2.0F, 1, 1, 2, 0.0F);
        this.Teeth8.setTextureOffset(24, 5).addBox(0.1865F, -4.0504F, -2.0F, 1, 1, 2, 0.0F);
        this.Teeth9 = new MModelRenderer(this);
        this.Teeth9.setRotationPoint(0.75F, -0.15F, 0.0F);
        this.Teeth7.addChild(this.Teeth9);
        this.setRotation(this.Teeth9, 0.0F, 0.0F, 0.7854F);
        this.Teeth9.setTextureOffset(24, 5).addBox(-4.4392F, -1.6165F, -1.5F, 1, 1, 2, 0.0F);
        this.Teeth9.setTextureOffset(24, 5).addBox(-3.6163F, -2.6163F, -1.5F, 1, 1, 2, 0.0F);
        this.Teeth9.setTextureOffset(24, 5).addBox(-2.6617F, -3.4295F, -1.5F, 1, 1, 2, 0.0F);
        this.LeftDownCube = new MModelRenderer(this);
        this.LeftDownCube.setRotationPoint(-2.5F, 22.0F, 0.0F);
        this.LeftDownCube.setTextureOffset(0, 12).addBox(-1.5F, -2.5F, 1.25F, 3, 3, 1, 0.0F);
        this.LeftDownCube.setTextureOffset(0, 16).addBox(-1.5F, -2.5F, -2.25F, 3, 3, 1, 0.0F);
        this.LeftDownCube.setTextureOffset(0, 0).addBox(-2.0F, -3.0F, -2.0F, 4, 4, 4, 0.0F);
        this.LeftDownCube.setTextureOffset(0, 8).addBox(-1.5F, 0.25F, -1.5F, 3, 1, 3, 0.0F);
        this.LeftDownCube.setTextureOffset(16, 2).addBox(-2.25F, -2.5F, -1.5F, 1, 3, 3, 0.0F);
        this.LeftDownCube.setTextureOffset(12, 8).addBox(-1.75F, -3.25F, -1.5F, 4, 4, 3, 0.0F);
        this.Teeth10 = new MModelRenderer(this);
        this.Teeth10.setRotationPoint(0.75F, 0.5F, 0.5F);
        this.LeftDownCube.addChild(this.Teeth10);
        this.Teeth10.setTextureOffset(24, 5).addBox(0.75F, -4.0F, -1.5F, 1, 1, 2, 0.0F);
        this.Teeth11 = new MModelRenderer(this);
        this.Teeth11.setRotationPoint(-0.75F, -0.25F, -0.5F);
        this.Teeth10.addChild(this.Teeth11);
        this.setRotation(this.Teeth11, 0.0F, 0.0F, 0.7854F);
        this.Teeth11.setTextureOffset(24, 5).addBox(-3.7123F, -2.2374F, -1.0F, 1, 1, 2, 0.0F);
        this.Teeth11.setTextureOffset(24, 5).addBox(-2.8894F, -3.2373F, -1.0F, 1, 1, 2, 0.0F);
        this.Teeth11.setTextureOffset(24, 5).addBox(-1.9349F, -4.0504F, -1.0F, 1, 1, 2, 0.0F);
        this.Teeth12 = new MModelRenderer(this);
        this.Teeth12.setRotationPoint(-0.5F, 0.0F, -0.5F);
        this.Teeth10.addChild(this.Teeth12);
        this.setRotation(this.Teeth12, 0.0F, 0.0F, -0.7854F);
        this.Teeth12.setTextureOffset(24, 5).addBox(1.2374F, 0.591F, -1.0F, 1, 1, 2, 0.0F);
        this.Teeth12.setTextureOffset(24, 5).addBox(2.0603F, -0.4088F, -1.0F, 1, 1, 2, 0.0F);
        this.Teeth12.setTextureOffset(24, 5).addBox(3.0149F, -1.222F, -1.0F, 1, 1, 2, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "pets/predatorpet.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/predatorpet_animation.json"));
        this.animation = bbanimationloader.mustGet("Animation", this);
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.04F;
        GlStateManager.translate(0.7F, -1.2F + f, 0.25F);
        GlStateManager.scale(1.4F, 1.4F, 1.4F);
        this.animation.tick(time);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(1.6F, 1.6F, 1.6F);
        GlStateManager.translate(0.0F, -0.65F, 0.0F);
        this.animation.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0425\u0438\u0449\u043d\u0438\u043a";
    }

    public String getCreator()
    {
        return "EvilBendy";
    }

    public List<String> getDescription()
    {
        return MNaming.fromGame("Project Arrhythmia");
    }
}
