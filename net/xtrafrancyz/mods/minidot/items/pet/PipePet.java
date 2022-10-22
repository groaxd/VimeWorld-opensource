package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.List;
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

public class PipePet extends BasePet
{
    private final MModelRenderer thepiranhaplantpipe;
    private final MModelRenderer thepiranhaplant;
    private final MModelRenderer plants;
    private final MModelRenderer plant5;
    private final MModelRenderer plant4;
    private final MModelRenderer plant3;
    private final MModelRenderer plant;
    private final MModelRenderer plant2;
    private final MModelRenderer pipe;
    private final MModelRenderer pipe2;
    private final IAnimation anim;

    public PipePet()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.thepiranhaplantpipe = new MModelRenderer(this);
        this.thepiranhaplantpipe.setRotationPoint(0.0F, 25.0F, 0.0F);
        this.thepiranhaplant = new MModelRenderer(this);
        this.thepiranhaplant.setRotationPoint(0.0F, -10.2F, 0.0F);
        this.thepiranhaplantpipe.addChild(this.thepiranhaplant);
        this.plants = new MModelRenderer(this);
        this.plants.setRotationPoint(0.0F, 15.0F, 0.0F);
        this.thepiranhaplant.addChild(this.plants);
        this.plant5 = new MModelRenderer(this);
        this.plant5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.plants.addChild(this.plant5);
        this.plant5.setTextureOffset(18, 0).addBox(-0.5F, -16.5F, -0.5F, 1, 4, 1, 0.0F);
        this.plant4 = new MModelRenderer(this);
        this.plant4.setRotationPoint(0.5F, -13.25F, 0.0F);
        this.plants.addChild(this.plant4);
        this.setRotation(this.plant4, 0.0F, 0.0F, -0.6109F);
        this.plant4.setTextureOffset(0, 8).addBox(0.0F, 0.0F, -1.0F, 3, 0, 2, 0.0F);
        this.plant3 = new MModelRenderer(this);
        this.plant3.setRotationPoint(-0.5F, -13.25F, 0.0F);
        this.plants.addChild(this.plant3);
        this.setRotation(this.plant3, 0.0F, 0.0F, 0.6109F);
        this.plant3.setTextureOffset(0, 8).addBox(-3.0F, 0.0F, -1.0F, 3, 0, 2, 0.0F);
        this.plant = new MModelRenderer(this);
        this.plant.setRotationPoint(0.0F, -1.5F, 0.0F);
        this.thepiranhaplant.addChild(this.plant);
        this.plant.setTextureOffset(0, 10).addBox(-1.5F, -2.5F, -1.0F, 1, 2, 2, 0.0F);
        this.plant.setTextureOffset(32, 29).addBox(-1.0F, -3.0F, -1.5F, 1, 3, 3, 0.0F);
        this.plant.setTextureOffset(0, 3).addBox(0.0F, -3.0F, -1.25F, 1, 3, 0, 0.0F);
        this.plant.setTextureOffset(0, 0).addBox(0.0F, -3.0F, 1.25F, 1, 3, 0, 0.0F);
        this.plant.setTextureOffset(0, 0).addBox(0.0F, -2.75F, -1.5F, 1, 0, 3, 0.0F);
        this.plant2 = new MModelRenderer(this);
        this.plant2.setRotationPoint(0.0F, -1.5F, 0.0F);
        this.thepiranhaplant.addChild(this.plant2);
        this.plant2.setTextureOffset(0, 10).addBox(0.5F, -2.5F, -1.0F, 1, 2, 2, 0.0F);
        this.plant2.setTextureOffset(8, 8).addBox(-0.25F, -2.25F, -1.0F, 1, 2, 2, 0.0F);
        this.plant2.setTextureOffset(32, 29).addBox(0.0F, -3.0F, -1.5F, 1, 3, 3, 0.0F);
        this.plant2.setTextureOffset(0, 3).addBox(-1.0F, -3.0F, -1.25F, 1, 3, 0, 0.0F);
        this.plant2.setTextureOffset(0, 0).addBox(-1.0F, -3.0F, 1.25F, 1, 3, 0, 0.0F);
        this.plant2.setTextureOffset(0, 0).addBox(-1.0F, -2.75F, -1.5F, 1, 0, 3, 0.0F);
        this.pipe = new MModelRenderer(this);
        this.pipe.setRotationPoint(0.0F, -3.0F, 0.0F);
        this.thepiranhaplantpipe.addChild(this.pipe);
        this.pipe.setTextureOffset(0, 0).addBox(-3.0F, -5.3F, -3.0F, 6, 0, 6, 0.0F);
        this.pipe.setTextureOffset(18, 36).addBox(-2.0F, 2.0F, -1.5F, 4, 0, 3, 0.0F);
        this.pipe.setTextureOffset(12, 6).addBox(3.0F, -6.0001F, -3.0F, 1, 2, 6, 0.001F);
        this.pipe.setTextureOffset(0, 12).addBox(-4.0F, -6.0001F, -3.0F, 1, 2, 6, 0.001F);
        this.pipe.setTextureOffset(22, 26).addBox(-3.0F, -6.0001F, 3.0F, 6, 2, 1, 0.001F);
        this.pipe.setTextureOffset(26, 10).addBox(-3.0F, -6.0001F, -4.0F, 6, 2, 1, 0.001F);
        this.pipe.setTextureOffset(20, 14).addBox(-3.5F, -6.0F, -3.5F, 7, 2, 1, 0.0F);
        this.pipe.setTextureOffset(20, 7).addBox(-3.5F, -6.0F, 2.5F, 7, 2, 1, 0.0F);
        this.pipe.setTextureOffset(20, 0).addBox(-3.5F, -6.0F, -2.5F, 1, 2, 5, 0.0F);
        this.pipe.setTextureOffset(19, 19).addBox(2.5F, -6.0F, -2.5F, 1, 2, 5, 0.0F);
        this.pipe2 = new MModelRenderer(this);
        this.pipe2.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.thepiranhaplantpipe.addChild(this.pipe2);
        this.pipe2.setTextureOffset(0, 30).addBox(-2.0F, -6.0F, -3.0F, 4, 6, 1, 0.0F);
        this.pipe2.setTextureOffset(22, 29).addBox(-2.0F, -6.0F, 2.0F, 4, 6, 1, 0.0F);
        this.pipe2.setTextureOffset(10, 26).addBox(-2.5F, -6.0F, -2.5F, 5, 6, 1, 0.0F);
        this.pipe2.setTextureOffset(26, 17).addBox(-2.5F, -6.0F, 1.5F, 5, 6, 1, 0.0F);
        this.pipe2.setTextureOffset(0, 20).addBox(2.0F, -6.0F, -2.0F, 1, 6, 4, 0.0F);
        this.pipe2.setTextureOffset(14, 14).addBox(-3.0F, -6.0F, -2.0F, 1, 6, 4, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "pets/pipe.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/pipe_animation.json"));
        this.anim = bbanimationloader.mustGet("pipe.anim", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        this.anim.tick(time);
        super.preRender(modelPlayer, player, time, pi);
        float f = MathHelper.sin(time * 0.1F) * 0.04F;
        GlStateManager.scale(1.1F, 1.1F, 1.1F);
        GlStateManager.translate(0.9F, -1.8F + f, 0.45F);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(1.5F, 1.5F, 1.5F);
        GlStateManager.translate(0.0F, -0.6F, 0.0F);
        this.anim.tick(time);
        super.renderAsItem(time);
    }

    public String getCreator()
    {
        return "EvilBendy";
    }

    public String getName()
    {
        return "\u0422\u0440\u0443\u0431\u0430 \u0441 \u0440\u0430\u0441\u0442\u0435\u043d\u0438\u0435\u043c";
    }

    public List<String> getDescription()
    {
        return MNaming.fromGame("Super Mario Bros");
    }
}
