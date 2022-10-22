package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class HornetPet extends BasePet
{
    private final MModelRenderer hornet;
    private final MModelRenderer bone2;
    private final MModelRenderer bone;
    private final MModelRenderer bone8;
    private final MModelRenderer head;
    private final MModelRenderer bone6;
    private final MModelRenderer bone7;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final MModelRenderer antenas;
    private final MModelRenderer bone9;
    private final MModelRenderer antenas2;
    private final MModelRenderer bone10;
    private final MModelRenderer wings;
    private final MModelRenderer bone11;
    private final MModelRenderer bone12;
    private final MModelRenderer bone13;
    private final MModelRenderer bone3;
    private final IAnimation anim;

    public HornetPet()
    {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.hornet = new MModelRenderer(this);
        this.hornet.setRotationPoint(3.0F, 14.0F, -2.0F);
        this.hornet.setTextureOffset(10, 23).addBox(-4.0F, -0.0872F, 2.9331F, 4, 1, 2, 0.0F);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.0F, 5.0F, 2.0F);
        this.hornet.addChild(this.bone2);
        this.setRotation(this.bone2, -0.2618F, 0.0F, 0.0F);
        this.bone2.setTextureOffset(16, 4).addBox(-4.0F, -4.7071F, -1.2247F, 4, 4, 3, 3.0E-4F);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, 1.0F, 2.0F);
        this.hornet.addChild(this.bone);
        this.setRotation(this.bone, 0.5236F, 0.0F, 0.0F);
        this.bone.setTextureOffset(16, 16).addBox(-4.0F, -3.4751F, 0.0837F, 4, 4, 3, 0.0F);
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(0.0F, -1.0F, 2.0F);
        this.hornet.addChild(this.bone8);
        this.setRotation(this.bone8, 0.9163F, 0.0F, 0.0F);
        this.bone8.setTextureOffset(0, 20).addBox(-4.0F, -2.3701F, 0.247F, 4, 2, 2, 3.0E-4F);
        this.head = new MModelRenderer(this);
        this.head.setRotationPoint(-2.0F, -3.0F, 0.0F);
        this.hornet.addChild(this.head);
        this.setRotation(this.head, 0.2618F, 0.0F, 0.0F);
        this.head.setTextureOffset(0, 0).addBox(-2.5F, -2.4961F, -2.1728F, 5, 3, 4, 0.0F);
        this.head.setTextureOffset(14, 0).addBox(-2.0F, -3.4961F, -1.6728F, 4, 1, 3, 0.0F);
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(-0.5F, 0.0039F, -3.1728F);
        this.head.addChild(this.bone6);
        this.setRotation(this.bone6, 0.0F, 0.0F, 0.1745F);
        this.bone6.setTextureOffset(0, 24).addBox(-2.4924F, -1.9132F, 0.65F, 2, 2, 1, 0.0F);
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(0.5F, 0.0039F, -3.1728F);
        this.head.addChild(this.bone7);
        this.setRotation(this.bone7, 0.0F, 0.0F, -0.1745F);
        this.bone7.setTextureOffset(22, 23).addBox(0.4924F, -1.9132F, 0.65F, 2, 2, 1, 0.0F);
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(2.0F, 2.5039F, -2.1728F);
        this.head.addChild(this.bone4);
        this.setRotation(this.bone4, 0.0F, 0.0F, 0.3927F);
        this.bone4.setTextureOffset(13, 26).addBox(-1.7654F, -1.8478F, 0.25F, 1, 2, 1, 0.0F);
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(-2.0F, 2.5039F, -2.1728F);
        this.head.addChild(this.bone5);
        this.setRotation(this.bone5, 0.0F, 0.0F, -0.3927F);
        this.bone5.setTextureOffset(13, 26).addBox(0.7654F, -1.8478F, 0.25F, 1, 2, 1, 0.0F);
        this.antenas = new MModelRenderer(this);
        this.antenas.setRotationPoint(-0.1F, -2.4961F, 0.8272F);
        this.head.addChild(this.antenas);
        this.setRotation(this.antenas, 0.2657F, -0.1685F, -0.0456F);
        this.antenas.setTextureOffset(6, 24).addBox(0.7196F, -2.7899F, -1.847F, 1, 2, 1, 0.0F);
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(1.9696F, 9.0681F, 0.1703F);
        this.antenas.addChild(this.bone9);
        this.setRotation(this.bone9, 1.0036F, 0.0F, 0.0F);
        this.bone9.setTextureOffset(0, 0).addBox(-1.25F, -9.2293F, 8.4544F, 1, 2, 1, 0.0F);
        this.antenas2 = new MModelRenderer(this);
        this.antenas2.setRotationPoint(0.1F, -2.4961F, 0.8272F);
        this.head.addChild(this.antenas2);
        this.setRotation(this.antenas2, 0.0F, 0.1745F, 0.0F);
        this.antenas2.setTextureOffset(6, 24).addBox(-1.7196F, -2.7899F, -1.847F, 1, 2, 1, 0.0F);
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(-1.9696F, 9.0681F, 0.1703F);
        this.antenas2.addChild(this.bone10);
        this.setRotation(this.bone10, 1.0036F, 0.0F, 0.0F);
        this.bone10.setTextureOffset(0, 0).addBox(0.25F, -9.2293F, 8.4544F, 1, 2, 1, 0.0F);
        this.wings = new MModelRenderer(this);
        this.wings.setRotationPoint(-2.0F, -2.0F, 2.0F);
        this.hornet.addChild(this.wings);
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(1.25F, 3.25F, 2.0F);
        this.wings.addChild(this.bone11);
        this.setRotation(this.bone11, 0.2182F, 0.2182F, 0.0F);
        this.bone11.setTextureOffset(0, 6).addBox(0.0F, -6.0F, 0.0F, 0, 6, 8, 0.0F);
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(-1.25F, 3.25F, 2.0F);
        this.wings.addChild(this.bone12);
        this.setRotation(this.bone12, 0.2182F, -0.2182F, 0.0F);
        this.bone12.setTextureOffset(0, 0).addBox(0.0F, -6.0F, 0.0F, 0, 6, 8, 0.0F);
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(0.0F, 5.0F, 2.0F);
        this.hornet.addChild(this.bone13);
        this.bone13.setTextureOffset(10, 17).addBox(-2.0F, -1.0F, -4.25F, 0, 2, 3, 0.0F);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.0F, 0.25F, 0.25F);
        this.bone13.addChild(this.bone3);
        this.setRotation(this.bone3, 0.5672F, 0.0F, 0.0F);
        this.bone3.setTextureOffset(16, 11).addBox(-3.5F, -1.847F, -1.6903F, 3, 2, 3, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "pets/hornetpet.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/hornetpet_animation.json"));
        this.anim = bbanimationloader.mustGet("hornet", this);
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.05F;
        GlStateManager.scale(1.1F, 1.1F, 1.1F);
        GlStateManager.translate(0.5F, -0.9F + f, 0.3F);
        this.anim.tick(time);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(-0.05F, -0.6F, 0.0F);
        GlStateManager.scale(1.3F, 1.3F, 1.3F);
        this.anim.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0428\u0435\u0440\u0448\u0435\u043d\u044c";
    }

    public String getCreator()
    {
        return "xRolaaan";
    }
}
