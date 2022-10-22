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

public class PopItPet extends BasePet
{
    private final MModelRenderer Corpus;
    private final MModelRenderer Vneshni;
    private final MModelRenderer Vnutreni;
    private final MModelRenderer Pupirki;
    private final MModelRenderer Red;
    private final MModelRenderer Orange;
    private final MModelRenderer Yellow;
    private final MModelRenderer Green;
    private final MModelRenderer Blue;
    private final MModelRenderer Purple;
    private final MModelRenderer Peregorodki;
    private final IAnimation anim;

    public PopItPet()
    {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.Corpus = new MModelRenderer(this);
        this.Corpus.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.Vneshni = new MModelRenderer(this);
        this.Vneshni.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Corpus.addChild(this.Vneshni);
        this.Vneshni.setTextureOffset(14, 0).addBox(-4.0F, -9.0F, -0.5F, 8, 1, 1, 0.0F);
        this.Vneshni.setTextureOffset(14, 2).addBox(-4.0F, 0.0F, -0.5F, 8, 1, 1, 0.0F);
        this.Vneshni.setTextureOffset(4, 0).addBox(-5.0F, -8.0F, -0.5F, 1, 8, 1, 0.0F);
        this.Vneshni.setTextureOffset(0, 0).addBox(4.0F, -8.0F, -0.5F, 1, 8, 1, 0.0F);
        this.Vneshni.setTextureOffset(20, 30).addBox(3.75F, -8.75F, -0.5001F, 1, 1, 1, 0.0F);
        this.Vneshni.setTextureOffset(16, 30).addBox(-4.75F, -8.75F, -0.5001F, 1, 1, 1, 0.0F);
        this.Vneshni.setTextureOffset(28, 30).addBox(-4.75F, -0.25F, -0.5001F, 1, 1, 1, 0.0F);
        this.Vneshni.setTextureOffset(24, 30).addBox(3.75F, -0.25F, -0.5001F, 1, 1, 1, 0.0F);
        this.Vnutreni = new MModelRenderer(this);
        this.Vnutreni.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Corpus.addChild(this.Vnutreni);
        this.Vnutreni.setTextureOffset(16, 4).addBox(-4.0F, -8.0F, 0.0F, 8, 8, 0, 0.0F);
        this.Pupirki = new MModelRenderer(this);
        this.Pupirki.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.Red = new MModelRenderer(this);
        this.Red.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.Pupirki.addChild(this.Red);
        this.Red.setTextureOffset(28, 12).addBox(-3.75F, -0.75F, -0.5F, 1, 1, 1, 0.0F);
        this.Red.setTextureOffset(24, 12).addBox(-2.5F, -0.75F, -0.5F, 1, 1, 1, 0.0F);
        this.Red.setTextureOffset(20, 12).addBox(-1.25F, -0.75F, -0.5F, 1, 1, 1, 0.0F);
        this.Red.setTextureOffset(16, 12).addBox(0.25F, -0.75F, -0.5F, 1, 1, 1, 0.0F);
        this.Red.setTextureOffset(28, 14).addBox(1.5F, -0.75F, -0.5F, 1, 1, 1, 0.0F);
        this.Red.setTextureOffset(24, 14).addBox(2.75F, -0.75F, -0.5F, 1, 1, 1, 0.0F);
        this.Orange = new MModelRenderer(this);
        this.Orange.setRotationPoint(0.0F, -6.75F, 0.0F);
        this.Pupirki.addChild(this.Orange);
        this.Orange.setTextureOffset(20, 14).addBox(-3.75F, -0.75F, -0.5F, 1, 1, 1, 0.0F);
        this.Orange.setTextureOffset(16, 14).addBox(-2.5F, -0.75F, -0.5F, 1, 1, 1, 0.0F);
        this.Orange.setTextureOffset(28, 16).addBox(-1.25F, -0.75F, -0.5F, 1, 1, 1, 0.0F);
        this.Orange.setTextureOffset(24, 16).addBox(0.25F, -0.75F, -0.5F, 1, 1, 1, 0.0F);
        this.Orange.setTextureOffset(20, 16).addBox(1.5F, -0.75F, -0.5F, 1, 1, 1, 0.0F);
        this.Orange.setTextureOffset(16, 16).addBox(2.75F, -0.75F, -0.5F, 1, 1, 1, 0.0F);
        this.Yellow = new MModelRenderer(this);
        this.Yellow.setRotationPoint(0.0F, -5.5F, 0.0F);
        this.Pupirki.addChild(this.Yellow);
        this.Yellow.setTextureOffset(24, 20).addBox(-3.75F, -0.75F, -0.5F, 1, 1, 1, 0.0F);
        this.Yellow.setTextureOffset(28, 20).addBox(-2.5F, -0.75F, -0.5F, 1, 1, 1, 0.0F);
        this.Yellow.setTextureOffset(16, 18).addBox(-1.25F, -0.75F, -0.5F, 1, 1, 1, 0.0F);
        this.Yellow.setTextureOffset(20, 18).addBox(0.25F, -0.75F, -0.5F, 1, 1, 1, 0.0F);
        this.Yellow.setTextureOffset(24, 18).addBox(1.5F, -0.75F, -0.5F, 1, 1, 1, 0.0F);
        this.Yellow.setTextureOffset(28, 18).addBox(2.75F, -0.75F, -0.5F, 1, 1, 1, 0.0F);
        this.Green = new MModelRenderer(this);
        this.Green.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.Pupirki.addChild(this.Green);
        this.Green.setTextureOffset(16, 22).addBox(-3.75F, -0.75F, -0.5F, 1, 1, 1, 0.0F);
        this.Green.setTextureOffset(20, 22).addBox(-2.5F, -0.75F, -0.5F, 1, 1, 1, 0.0F);
        this.Green.setTextureOffset(24, 22).addBox(-1.25F, -0.75F, -0.5F, 1, 1, 1, 0.0F);
        this.Green.setTextureOffset(28, 22).addBox(0.25F, -0.75F, -0.5F, 1, 1, 1, 0.0F);
        this.Green.setTextureOffset(16, 20).addBox(1.5F, -0.75F, -0.5F, 1, 1, 1, 0.0F);
        this.Green.setTextureOffset(20, 20).addBox(2.75F, -0.75F, -0.5F, 1, 1, 1, 0.0F);
        this.Blue = new MModelRenderer(this);
        this.Blue.setRotationPoint(0.0F, -2.75F, 0.0F);
        this.Pupirki.addChild(this.Blue);
        this.Blue.setTextureOffset(24, 26).addBox(-3.75F, -0.75F, -0.5F, 1, 1, 1, 0.0F);
        this.Blue.setTextureOffset(28, 26).addBox(-2.5F, -0.75F, -0.5F, 1, 1, 1, 0.0F);
        this.Blue.setTextureOffset(16, 24).addBox(-1.25F, -0.75F, -0.5F, 1, 1, 1, 0.0F);
        this.Blue.setTextureOffset(20, 24).addBox(0.25F, -0.75F, -0.5F, 1, 1, 1, 0.0F);
        this.Blue.setTextureOffset(24, 24).addBox(1.5F, -0.75F, -0.5F, 1, 1, 1, 0.0F);
        this.Blue.setTextureOffset(28, 24).addBox(2.75F, -0.75F, -0.5F, 1, 1, 1, 0.0F);
        this.Purple = new MModelRenderer(this);
        this.Purple.setRotationPoint(0.0F, -1.5F, 0.0F);
        this.Pupirki.addChild(this.Purple);
        this.Purple.setTextureOffset(16, 28).addBox(-3.75F, -0.75F, -0.5F, 1, 1, 1, 0.0F);
        this.Purple.setTextureOffset(20, 28).addBox(-2.5F, -0.75F, -0.5F, 1, 1, 1, 0.0F);
        this.Purple.setTextureOffset(24, 28).addBox(-1.25F, -0.75F, -0.5F, 1, 1, 1, 0.0F);
        this.Purple.setTextureOffset(28, 28).addBox(0.25F, -0.75F, -0.5F, 1, 1, 1, 0.0F);
        this.Purple.setTextureOffset(16, 26).addBox(1.5F, -0.75F, -0.5F, 1, 1, 1, 0.0F);
        this.Purple.setTextureOffset(20, 26).addBox(2.75F, -0.75F, -0.5F, 1, 1, 1, 0.0F);
        this.Peregorodki = new MModelRenderer(this);
        this.Peregorodki.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.Peregorodki.setTextureOffset(14, 1).addBox(-4.0F, -7.65F, -0.5F, 8, 0, 1, 0.0F);
        this.Peregorodki.setTextureOffset(14, 7).addBox(-4.0F, -6.4F, -0.5F, 8, 0, 1, 0.0F);
        this.Peregorodki.setTextureOffset(0, 12).addBox(-4.0F, -5.0F, -0.5F, 8, 0, 1, 0.0F);
        this.Peregorodki.setTextureOffset(14, 8).addBox(-4.0F, -3.65F, -0.5F, 8, 0, 1, 0.0F);
        this.Peregorodki.setTextureOffset(14, 11).addBox(-4.0F, -2.4F, -0.5F, 8, 0, 1, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "pets/popit.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/popit_animation.json"));
        this.anim = bbanimationloader.mustGet("popit.anim", this);
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.05F;
        GlStateManager.translate(0.7F, -1.25F - f, 0.3F);
        float f1 = 1.2F;
        GlStateManager.scale(f1, f1, f1);
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
        GlStateManager.translate(0.0F, -0.75F, 0.0F);
        float f = 1.3F;
        GlStateManager.scale(f, f, f);
        this.anim.tick(time);
        super.renderAsItem(time);
    }

    public String getCreator()
    {
        return "EvilBendy";
    }

    public String getName()
    {
        return "\u041f\u043e\u043f \u0418\u0442";
    }
}
