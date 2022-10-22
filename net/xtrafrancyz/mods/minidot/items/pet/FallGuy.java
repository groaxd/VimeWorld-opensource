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

public class FallGuy extends BasePet
{
    private final MModelRenderer FallGuy;
    private final MModelRenderer Body;
    private final MModelRenderer Legs;
    private final MModelRenderer LeftLeg;
    private final MModelRenderer RightLeg;
    private final MModelRenderer Eyes;
    private final MModelRenderer Arms;
    private final MModelRenderer LeftArm;
    private final MModelRenderer RightArm;
    private final IAnimation animation;

    public FallGuy()
    {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.FallGuy = new MModelRenderer(this);
        this.Body = new MModelRenderer(this);
        this.Body.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.FallGuy.addChild(this.Body);
        this.Body.cubeList.add(new ModelBox(this.Body, 0, 0, -4.0F, -11.0F, -2.0F, 8, 11, 4, 0.0F, false));
        this.Legs = new MModelRenderer(this);
        this.Legs.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.Body.addChild(this.Legs);
        this.LeftLeg = new MModelRenderer(this);
        this.LeftLeg.setRotationPoint(2.0F, -2.0F, 0.0F);
        this.Legs.addChild(this.LeftLeg);
        this.LeftLeg.cubeList.add(new ModelBox(this.LeftLeg, 12, 15, -1.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F, false));
        this.RightLeg = new MModelRenderer(this);
        this.RightLeg.setRotationPoint(-2.0F, -2.1F, 0.0F);
        this.Legs.addChild(this.RightLeg);
        this.RightLeg.cubeList.add(new ModelBox(this.RightLeg, 18, 18, -1.0F, 0.1F, -1.0F, 2, 2, 2, 0.0F, false));
        this.Eyes = new MModelRenderer(this);
        this.Eyes.setRotationPoint(0.0F, -7.0F, -2.01F);
        this.Body.addChild(this.Eyes);
        this.Eyes.cubeList.add(new ModelBox(this.Eyes, 0, 0, -2.0F, -1.0F, 0.0F, 1, 2, 0, 0.0F, false));
        this.Eyes.cubeList.add(new ModelBox(this.Eyes, 0, 0, 1.0F, -1.0F, 0.0F, 1, 2, 0, 0.0F, false));
        this.Arms = new MModelRenderer(this);
        this.Arms.setRotationPoint(0.0F, 2.9F, 0.0F);
        this.Body.addChild(this.Arms);
        this.LeftArm = new MModelRenderer(this);
        this.LeftArm.setRotationPoint(4.0F, -7.9F, 0.0F);
        this.setRotation(this.LeftArm, 0.0F, 0.0F, -0.0873F);
        this.Arms.addChild(this.LeftArm);
        this.LeftArm.cubeList.add(new ModelBox(this.LeftArm, 6, 15, 0.0F, -1.0F, -1.0F, 1, 6, 2, 0.0F, false));
        this.RightArm = new MModelRenderer(this);
        this.RightArm.setRotationPoint(-4.0F, -7.9F, 0.0F);
        this.setRotation(this.RightArm, 0.0F, 0.0F, 0.0873F);
        this.Arms.addChild(this.RightArm);
        this.RightArm.cubeList.add(new ModelBox(this.RightArm, 0, 15, -1.0F, -1.0F, -1.0F, 1, 6, 2, 0.0F, true));
        super.setTexture(new ResourceLocation("minidot", "pets/fallguy.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/fallguy_animation.json"));
        this.animation = bbanimationloader.mustGet("animation.fallGuy.general", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.translate(0.65D, -0.1D, 0.3D);
        double d0 = (double)MathHelper.sin(time * 0.1F) * 0.03D;
        GlStateManager.translate(0.0D, d0, 0.0D);
        this.animation.tickDelayed(time, 10.0F);
        super.preRender(modelPlayer, player, time, pi);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0D, 0.3D, 0.0D);
        double d0 = 1.2D;
        GlStateManager.scale(d0, d0, d0);
        this.animation.tickDelayed(time, 10.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0427\u0435\u043b\u043e\u0432\u0435\u0447\u0435\u043a";
    }

    public String getCreator()
    {
        return "Wenston";
    }

    public List<String> getDescription()
    {
        return MNaming.fromGame("Fall Guys");
    }
}
