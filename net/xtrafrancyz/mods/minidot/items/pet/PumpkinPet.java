package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class PumpkinPet extends BasePet
{
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final MModelRenderer bone6;
    private final MModelRenderer bone7;
    private final MModelRenderer bone8;
    private final MModelRenderer bone9;
    private final MModelRenderer bone10;
    private final MModelRenderer bone11;
    private final MModelRenderer bone17;
    private final MModelRenderer bone12;
    private final MModelRenderer bone13;
    private final MModelRenderer bone14;
    private final MModelRenderer bone15;
    private final MModelRenderer bone16;
    private final MModelRenderer bone18;
    private final IAnimation laughter;

    public PumpkinPet()
    {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.bone = new MModelRenderer(this);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.05F, -2.0F, -2.25F);
        this.setRotation(this.bone2, 0.0F, -0.7854F, 0.0F);
        this.bone.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 24, 13, -0.0354F, -7.01F, -5.2073F, 3, 7, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 24, 13, -0.0354F, -6.99F, 7.278F, 3, 7, 1, 0.0F, true));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 24, 11, -5.278F, -7.0F, 0.0354F, 1, 7, 3, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 0, -4.278F, -8.0F, 0.0354F, 3, 1, 3, -0.001F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 0, -4.278F, -0.001F, 0.0354F, 3, 1, 3, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 0, -0.0354F, -0.001F, -4.2073F, 3, 1, 3, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 0, 4.2073F, -8.0F, 0.0354F, 3, 1, 3, -0.001F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 0, 4.2073F, -0.001F, 0.0354F, 3, 1, 3, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 0, -0.0354F, -8.0F, 4.278F, 3, 1, 3, -0.001F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 0, -0.0354F, -8.0F, -4.2073F, 3, 1, 3, -0.001F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 0, -0.0354F, -0.001F, 4.278F, 3, 1, 3, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 24, 11, 7.2073F, -6.99F, 0.0354F, 1, 7, 3, 0.0F, true));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.05F, -2.0F, -2.25F);
        this.setRotation(this.bone3, 0.0F, 0.0F, -0.5236F);
        this.bone.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 0, 2.5548F, -4.7212F, -4.0F, 3, 1, 1, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(0.05F, -2.0F, -2.25F);
        this.setRotation(this.bone4, 0.0F, 0.0F, -0.1745F);
        this.bone.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 0, 0, 0.513F, -3.9346F, -4.0F, 3, 1, 1, 0.0F, false));
        this.bone4.cubeList.add(new ModelBox(this.bone4, 0, 0, -0.4812F, -1.3737F, -4.0F, 2, 1, 1, 0.0F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(0.05F, -2.0F, -2.25F);
        this.setRotation(this.bone5, 0.0F, 0.0F, -1.309F);
        this.bone.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 0, 0, 1.1443F, 0.9436F, -4.0F, 3, 1, 1, 0.0F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(0.05F, -2.0F, -2.25F);
        this.setRotation(this.bone6, 0.0F, 0.0F, -((float)Math.PI * 2F / 9F));
        this.bone.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 0, 0, 1.5021F, -0.5642F, -4.0F, 1, 1, 1, 0.0F, false));
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(-0.05F, -2.0F, -2.25F);
        this.setRotation(this.bone7, 0.0F, 0.0F, 0.1745F);
        this.bone.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 0, 0, -3.513F, -3.9346F, -4.0F, 3, 1, 1, 0.0F, true));
        this.bone7.cubeList.add(new ModelBox(this.bone7, 0, 0, -1.6173F, -1.3563F, -4.0F, 2, 1, 1, 0.0F, true));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(-0.05F, -2.0F, -2.25F);
        this.setRotation(this.bone8, 0.0F, 0.0F, ((float)Math.PI * 2F / 9F));
        this.bone.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 0, 0, -2.5787F, -0.4999F, -4.0F, 1, 1, 1, 0.0F, true));
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(-0.05F, -2.0F, -2.25F);
        this.setRotation(this.bone9, 0.0F, 0.0F, 1.309F);
        this.bone.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 0, 0, -4.1443F, 0.9436F, -4.0F, 3, 1, 1, 0.0F, true));
        this.bone10 = new MModelRenderer(this);
        this.setRotation(this.bone10, 0.0F, 0.0F, 0.5236F);
        this.bone.addChild(this.bone10);
        this.bone10.cubeList.add(new ModelBox(this.bone10, 0, 0, -6.5981F, -6.4282F, -6.25F, 3, 1, 1, 0.0F, true));
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(0.0F, -10.5F, 0.0F);
        this.setRotation(this.bone11, 0.0F, 0.7854F, -0.2618F);
        this.bone.addChild(this.bone11);
        this.bone11.cubeList.add(new ModelBox(this.bone11, 24, 27, -1.1201F, -1.3407F, -1.0155F, 2, 3, 2, 0.0F, true));
        this.bone17 = new MModelRenderer(this);
        this.bone17.setRotationPoint(0.0F, 0.5F, 0.0F);
        this.setRotation(this.bone17, -0.5236F, 0.0F, 0.0F);
        this.bone11.addChild(this.bone17);
        this.bone17.cubeList.add(new ModelBox(this.bone17, 14, 21, -2.1201F, -2.1558F, -0.7184F, 4, 0, 5, 0.0F, true));
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(-0.1201F, -1.8407F, -0.0155F);
        this.setRotation(this.bone12, 0.0F, 0.0F, -0.5236F);
        this.bone11.addChild(this.bone12);
        this.bone12.cubeList.add(new ModelBox(this.bone12, 22, 26, -0.75F, -1.25F, -0.5F, 1, 2, 1, 0.0F, true));
        this.bone13 = new MModelRenderer(this);
        this.setRotation(this.bone13, 0.0F, 0.0F, -0.7854F);
        this.bone12.addChild(this.bone13);
        this.bone13.cubeList.add(new ModelBox(this.bone13, 22, 26, 0.0607F, -2.7071F, -0.5F, 1, 2, 1, 0.0F, true));
        this.bone14 = new MModelRenderer(this);
        this.setRotation(this.bone14, 0.0F, 0.0F, -0.7854F);
        this.bone13.addChild(this.bone14);
        this.bone14.cubeList.add(new ModelBox(this.bone14, 22, 26, 1.6642F, -2.1642F, -0.5F, 1, 1, 1, 0.0F, true));
        this.bone15 = new MModelRenderer(this);
        this.setRotation(this.bone15, 0.0F, 0.0F, -0.6109F);
        this.bone14.addChild(this.bone15);
        this.bone15.cubeList.add(new ModelBox(this.bone15, 22, 26, 2.4237F, -1.2447F, -0.5F, 1, 1, 1, 0.0F, true));
        this.bone16 = new MModelRenderer(this);
        this.setRotation(this.bone16, 0.0F, 0.0F, -0.8727F);
        this.bone15.addChild(this.bone16);
        this.bone16.cubeList.add(new ModelBox(this.bone16, 22, 26, 2.1542F, 0.8227F, -0.5F, 1, 1, 1, 0.0F, true));
        this.bone18 = new MModelRenderer(this);
        this.bone18.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.bone.addChild(this.bone18);
        this.bone18.cubeList.add(new ModelBox(this.bone18, 0, 0, -3.0F, -7.0F, -6.25F, 6, 1, 1, 0.0F, false));
        this.bone18.cubeList.add(new ModelBox(this.bone18, 0, 4, 2.0F, -4.0F, -6.25F, 1, 3, 1, 0.0F, false));
        this.bone18.cubeList.add(new ModelBox(this.bone18, 0, 4, -3.0F, -4.0F, -6.25F, 1, 3, 1, 0.0F, false));
        this.bone18.cubeList.add(new ModelBox(this.bone18, 9, 3, -3.0F, -1.0F, -6.25F, 6, 1, 2, 0.0F, false));
        this.bone18.cubeList.add(new ModelBox(this.bone18, 0, 5, -0.5F, -5.9F, -6.25F, 1, 3, 1, 0.0F, false));
        this.bone18.cubeList.add(new ModelBox(this.bone18, 9, 6, -1.3519F, -6.35F, -6.25F, 3, 1, 2, 0.0F, false));
        this.bone18.cubeList.add(new ModelBox(this.bone18, 0, 0, -3.0F, -4.5F, -6.25F, 6, 1, 1, 0.0F, false));
        this.bone18.cubeList.add(new ModelBox(this.bone18, 0, 11, -6.1213F, -7.0F, -3.1287F, 1, 7, 6, 0.0F, false));
        this.bone18.cubeList.add(new ModelBox(this.bone18, 14, 4, -5.1213F, -8.0F, -3.1287F, 3, 1, 6, -5.0E-4F, true));
        this.bone18.cubeList.add(new ModelBox(this.bone18, 14, 4, 2.1213F, 0.0F, -3.1287F, 3, 1, 6, 0.0F, true));
        this.bone18.cubeList.add(new ModelBox(this.bone18, 14, 0, -3.0F, -8.0F, -5.25F, 6, 1, 3, 0.0F, true));
        this.bone18.cubeList.add(new ModelBox(this.bone18, 14, 3, 2.1213F, -8.0F, -3.1287F, 3, 1, 6, -5.0E-4F, true));
        this.bone18.cubeList.add(new ModelBox(this.bone18, 14, 4, -5.1213F, 0.0F, -3.1287F, 3, 1, 6, 0.0F, true));
        this.bone18.cubeList.add(new ModelBox(this.bone18, 0, 25, -3.0F, -8.5F, -3.0F, 6, 2, 6, 0.0F, true));
        this.bone18.cubeList.add(new ModelBox(this.bone18, 14, 0, -3.0F, 0.0F, -5.25F, 6, 1, 3, 0.0F, true));
        this.bone18.cubeList.add(new ModelBox(this.bone18, 0, 25, -3.0F, -0.75F, -3.0F, 6, 2, 6, 0.0F, true));
        this.bone18.cubeList.add(new ModelBox(this.bone18, 14, 0, -3.0F, 0.0F, 1.9926F, 6, 1, 3, 0.0F, true));
        this.bone18.cubeList.add(new ModelBox(this.bone18, 0, 17, -3.0F, -7.0F, 4.9926F, 6, 7, 1, 0.0F, true));
        this.bone18.cubeList.add(new ModelBox(this.bone18, 0, 11, 5.1213F, -7.0F, -3.1287F, 1, 7, 6, 0.0F, true));
        this.bone18.cubeList.add(new ModelBox(this.bone18, 14, 6, -3.0F, -8.0F, 1.9926F, 6, 1, 3, 0.0F, true));
        this.bone18.cubeList.add(new ModelBox(this.bone18, 8, 10, -3.2F, -6.5F, -5.25F, 7, 6, 1, 0.0F, false));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/pumpkin_animation.json"));
        this.laughter = bbanimationloader.mustGet("laughter", this);
        this.setTexture(new ResourceLocation("minidot", "pets/pumpkin.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        GlStateManager.translate(0.8F, -0.3F + f, 0.3F);
        this.laughter.tickDelayed(time, 10.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(1.15F, 1.15F, 1.15F);
        GlStateManager.translate(0.0F, 0.23F, 0.0F);
        super.renderAsItem(time);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public String getName()
    {
        return "\u0416\u0443\u0442\u043a\u0430\u044f \u0442\u044b\u043a\u0432\u0430";
    }
}
