package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.List;
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
import net.xtrafrancyz.mods.minidot.util.MNaming;

public class CeaslessVoid extends BasePet
{
    private final MModelRenderer CeaselessVoid;
    private final MModelRenderer bone9;
    private final MModelRenderer bone10;
    private final MModelRenderer bone;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final MModelRenderer bone6;
    private final MModelRenderer bone11;
    private final MModelRenderer bone2;
    private final MModelRenderer bone7;
    private final MModelRenderer bone3;
    private final MModelRenderer bone8;
    private final IAnimation animation;

    public CeaslessVoid()
    {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.CeaselessVoid = new MModelRenderer(this);
        this.CeaselessVoid.cubeList.add(new ModelBox(this.CeaselessVoid, 14, 0, -3.0F, -5.5F, -2.25F, 5, 1, 1, 0.0F, false));
        this.CeaselessVoid.cubeList.add(new ModelBox(this.CeaselessVoid, 0, 17, 1.5F, -9.75F, -1.75F, 1, 5, 3, 0.003F, false));
        this.CeaselessVoid.cubeList.add(new ModelBox(this.CeaselessVoid, 9, 14, -3.5F, -9.75F, -1.75F, 1, 5, 3, 0.003F, false));
        this.CeaselessVoid.cubeList.add(new ModelBox(this.CeaselessVoid, 0, 0, -3.0F, -10.0F, -2.25F, 5, 1, 4, 0.0F, false));
        this.CeaselessVoid.cubeList.add(new ModelBox(this.CeaselessVoid, 12, 9, -3.0F, -9.25F, 1.25F, 5, 4, 1, 0.0F, false));
        this.CeaselessVoid.cubeList.add(new ModelBox(this.CeaselessVoid, 12, 5, -2.5F, -5.25F, -1.5F, 4, 1, 3, 0.0F, false));
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(2.4F, -7.0F, -0.2F);
        this.CeaselessVoid.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 0, 11, 0.1F, -3.25F, -0.05F, 6, 6, 0, 0.0F, false));
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(-3.3F, -6.6F, 0.0F);
        this.CeaselessVoid.addChild(this.bone10);
        this.bone10.cubeList.add(new ModelBox(this.bone10, 0, 5, -6.2F, -3.65F, -0.25F, 6, 6, 0, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(1.35F, -8.75F, -1.25F);
        this.setRotation(this.bone, 0.0F, 0.0F, 0.9163F);
        this.CeaselessVoid.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 17, 20, -1.0F, -0.5F, -0.5F, 2, 1, 1, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(-2.35F, -8.75F, -1.25F);
        this.setRotation(this.bone4, 0.0F, 0.0F, -0.9163F);
        this.CeaselessVoid.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 19, 3, -1.0F, -0.5F, -0.5F, 2, 1, 1, 0.0F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(-2.35F, -5.75F, -1.25F);
        this.setRotation(this.bone5, 0.0F, 0.0F, 0.9163F);
        this.CeaselessVoid.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 17, 18, -1.0F, -0.5F, -0.5F, 2, 1, 1, 0.0F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(1.35F, -5.75F, -1.25F);
        this.setRotation(this.bone6, 0.0F, 0.0F, -0.9163F);
        this.CeaselessVoid.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 14, 2, -1.0F, -0.5F, -0.5F, 2, 1, 1, 0.0F, false));
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(-0.55F, -7.2F, -0.9F);
        this.CeaselessVoid.addChild(this.bone11);
        this.bone11.cubeList.add(new ModelBox(this.bone11, 17, 14, -1.95F, -2.05F, -0.1F, 4, 4, 0, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(1.75F, -10.0F, -2.0F);
        this.setRotation(this.bone2, 0.0F, 0.0F, -0.2182F);
        this.CeaselessVoid.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 1, 0.0F, -1.25F, 0.0F, 2, 1, 0, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 14, 22, -1.0F, -0.75F, -0.5F, 2, 1, 1, 0.0F, false));
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(1.75F, -10.0F, 1.5F);
        this.setRotation(this.bone7, 0.0F, 0.0F, -0.2182F);
        this.CeaselessVoid.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 0, 1, 0.0F, -1.25F, 0.0F, 2, 1, 0, 0.0F, false));
        this.bone7.cubeList.add(new ModelBox(this.bone7, 14, 22, -1.0F, -0.75F, -0.5F, 2, 1, 1, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(-2.75F, -10.0F, -2.0F);
        this.setRotation(this.bone3, 0.0F, 0.0F, 0.2182F);
        this.CeaselessVoid.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 0, -2.0F, -1.25F, 0.0F, 2, 1, 0, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 8, 22, -1.0F, -0.75F, -0.5F, 2, 1, 1, 0.0F, false));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(-2.75F, -10.0F, 1.5F);
        this.setRotation(this.bone8, 0.0F, 0.0F, 0.2182F);
        this.CeaselessVoid.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 0, 0, -2.0F, -1.25F, 0.0F, 2, 1, 0, 0.0F, false));
        this.bone8.cubeList.add(new ModelBox(this.bone8, 8, 22, -1.0F, -0.75F, -0.5F, 2, 1, 1, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/ceaslessvoid.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/ceaslessvoid_animation.json"));
        this.animation = bbanimationloader.mustGet("default", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.translate(0.65D, 0.0D, 0.3D);
        double d0 = (double)MathHelper.sin(time * 0.1F) * 0.03D;
        GlStateManager.translate(0.0D, d0, 0.0D);
        this.animation.tick(time);
        super.preRender(modelPlayer, player, time, pi);
        double d1 = 1.2D;
        GlStateManager.scale(d1, d1, d1);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0D, 0.4D, 0.0D);
        double d0 = 1.5D;
        GlStateManager.scale(d0, d0, d0);
        this.animation.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0411\u0435\u0441\u043a\u043e\u043d\u0435\u0447\u043d\u0430\u044f \u043f\u0443\u0441\u0442\u043e\u0442\u0430";
    }

    public String getCreator()
    {
        return "xRolaaan";
    }

    public List<String> getDescription()
    {
        return MNaming.fromGame("Terraria");
    }
}
