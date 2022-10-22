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

public class TractorPet extends BasePet
{
    private final MModelRenderer Tractor;
    private final MModelRenderer kolesa;
    private final MModelRenderer pokrishki;
    private final MModelRenderer corpus;
    private final MModelRenderer kryjuk;
    private final MModelRenderer shtyki;
    private final MModelRenderer rylosnova;
    private final MModelRenderer ryl;
    private final MModelRenderer tryba;
    private final MModelRenderer izgib;
    private final MModelRenderer TRYBA2;
    private final MModelRenderer zashitadlyakoles;
    private final MModelRenderer fari;
    private final MModelRenderer provetrivalka;
    private final MModelRenderer kosayaprovetrivalki;
    private final MModelRenderer kosayaprovetrivalki2;
    private final MModelRenderer kabina_krasnaya;
    private final MModelRenderer kabina_kosie_palki;
    private final MModelRenderer kabina_seroe;
    private final MModelRenderer osnova;
    private final MModelRenderer Dim;
    private final MModelRenderer bone3;
    private final MModelRenderer bone2;
    private final MModelRenderer bone;
    private final MModelRenderer bone5;
    private final MModelRenderer bone4;
    private final IAnimation animation;

    public TractorPet()
    {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.Tractor = new MModelRenderer(this);
        this.Tractor.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.kolesa = new MModelRenderer(this);
        this.kolesa.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Tractor.addChild(this.kolesa);
        this.kolesa.setTextureOffset(114, 109).addBox(-7.8F, -5.0F, -8.0F, 2, 5, 5, 0.0F);
        this.kolesa.setTextureOffset(113, 101).addBox(5.8F, -5.0F, -8.0F, 2, 5, 5, 0.0F);
        this.kolesa.setTextureOffset(106, 101).addBox(5.8F, -9.0F, 4.0F, 2, 9, 9, 0.0F);
        this.kolesa.setTextureOffset(106, 101).addBox(-7.8F, -9.0F, 4.0F, 2, 9, 9, 0.0F);
        this.pokrishki = new MModelRenderer(this);
        this.pokrishki.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Tractor.addChild(this.pokrishki);
        this.pokrishki.setTextureOffset(77, 114).addBox(-8.1F, -4.0F, -7.0F, 2, 3, 3, 0.0F);
        this.pokrishki.setTextureOffset(77, 114).addBox(6.1F, -4.0F, -7.0F, 2, 3, 3, 0.0F);
        this.pokrishki.setTextureOffset(77, 110).addBox(7.1F, -7.0F, 6.0F, 1, 5, 5, 0.0F);
        this.pokrishki.setTextureOffset(77, 110).addBox(-8.1F, -7.0F, 6.0F, 1, 5, 5, 0.0F);
        this.corpus = new MModelRenderer(this);
        this.corpus.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Tractor.addChild(this.corpus);
        this.kryjuk = new MModelRenderer(this);
        this.kryjuk.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.corpus.addChild(this.kryjuk);
        this.kryjuk.setTextureOffset(124, 8).addBox(-0.5F, -4.5F, 14.5F, 1, 2, 1, 0.0F);
        this.kryjuk.setTextureOffset(124, 13).addBox(-0.5F, -3.0F, 13.75F, 1, 1, 1, 0.0F);
        this.shtyki = new MModelRenderer(this);
        this.shtyki.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.corpus.addChild(this.shtyki);
        this.shtyki.setTextureOffset(124, 0).addBox(-6.5F, -8.0F, -1.5F, 1, 4, 1, 0.0F);
        this.shtyki.setTextureOffset(124, 0).addBox(-6.5F, -8.0F, 1.5F, 1, 4, 1, 0.0F);
        this.shtyki.setTextureOffset(124, 0).addBox(-6.5F, -8.0F, 0.0F, 1, 4, 1, 0.0F);
        this.rylosnova = new MModelRenderer(this);
        this.rylosnova.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.corpus.addChild(this.rylosnova);
        this.rylosnova.setTextureOffset(43, 102).addBox(-1.5F, -14.0F, 5.475F, 3, 3, 1, 0.0F);
        this.ryl = new MModelRenderer(this);
        this.ryl.setRotationPoint(0.0F, 0.0F, -1.625F);
        this.rylosnova.addChild(this.ryl);
        this.setRotation(this.ryl, -0.1484F, 0.0F, 0.0F);
        this.ryl.setTextureOffset(43, 102).addBox(-0.5F, -13.0F, 5.0F, 1, 3, 1, 0.0F);
        this.tryba = new MModelRenderer(this);
        this.tryba.setRotationPoint(1.25F, 0.2F, 0.0F);
        this.corpus.addChild(this.tryba);
        this.tryba.setTextureOffset(44, 122).addBox(1.5F, -11.2F, -5.0F, 3, 1, 3, 0.0F);
        this.tryba.setTextureOffset(42, 119).addBox(2.0F, -15.2F, -4.5F, 2, 4, 2, 0.0F);
        this.izgib = new MModelRenderer(this);
        this.izgib.setRotationPoint(0.0F, 0.4F, -7.05F);
        this.tryba.addChild(this.izgib);
        this.setRotation(this.izgib, -0.4014F, 0.0F, 0.0F);
        this.izgib.setTextureOffset(45, 118).addBox(2.0001F, -19.325F, -3.725F, 2, 4, 2, 0.001F);
        this.TRYBA2 = new MModelRenderer(this);
        this.TRYBA2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tryba.addChild(this.TRYBA2);
        this.setRotation(this.TRYBA2, -0.5236F, 0.0F, 0.0F);
        this.TRYBA2.setTextureOffset(21, 116).addBox(2.0F, -15.775F, -12.375F, 2, 1, 3, 0.001F);
        this.zashitadlyakoles = new MModelRenderer(this);
        this.zashitadlyakoles.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.corpus.addChild(this.zashitadlyakoles);
        this.zashitadlyakoles.setTextureOffset(29, 24).addBox(-8.0F, -6.0F, -8.0F, 2, 1, 5, 0.0F);
        this.zashitadlyakoles.setTextureOffset(29, 24).addBox(6.0F, -6.0F, -8.0F, 2, 1, 5, 0.0F);
        this.zashitadlyakoles.setTextureOffset(29, 24).addBox(-8.0F, -6.0F, -9.0F, 2, 3, 1, 0.0F);
        this.zashitadlyakoles.setTextureOffset(29, 24).addBox(6.0F, -6.0F, -9.0F, 2, 3, 1, 0.0F);
        this.zashitadlyakoles.setTextureOffset(29, 24).addBox(-8.0F, -6.0F, -3.0F, 2, 5, 1, 0.0F);
        this.zashitadlyakoles.setTextureOffset(29, 24).addBox(-8.0F, -10.0F, 3.0F, 2, 8, 1, 0.0F);
        this.zashitadlyakoles.setTextureOffset(29, 24).addBox(6.0F, -10.0F, 3.0F, 2, 8, 1, 0.0F);
        this.zashitadlyakoles.setTextureOffset(29, 24).addBox(-8.0F, -10.0F, 4.0F, 2, 1, 9, 0.0F);
        this.zashitadlyakoles.setTextureOffset(29, 24).addBox(6.0F, -10.0F, 4.0F, 2, 1, 9, 0.0F);
        this.zashitadlyakoles.setTextureOffset(29, 24).addBox(-8.0F, -10.0F, 13.0F, 2, 8, 1, 0.0F);
        this.zashitadlyakoles.setTextureOffset(29, 24).addBox(6.0F, -10.0F, 13.0F, 2, 8, 1, 0.0F);
        this.zashitadlyakoles.setTextureOffset(29, 24).addBox(6.0F, -6.0F, -3.0F, 2, 5, 1, 0.0F);
        this.fari = new MModelRenderer(this);
        this.fari.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.corpus.addChild(this.fari);
        this.fari.setTextureOffset(58, 0).addBox(-7.0F, -8.0F, -9.775F, 2, 2, 1, 0.0F);
        this.fari.setTextureOffset(58, 0).addBox(5.0F, -8.0F, -9.775F, 2, 2, 1, 0.0F);
        this.fari.setTextureOffset(64, 0).addBox(4.5F, -8.0F, 13.5F, 2, 2, 1, 0.0F);
        this.fari.setTextureOffset(64, 0).addBox(-6.5F, -8.0F, 13.5F, 2, 2, 1, 0.0F);
        this.provetrivalka = new MModelRenderer(this);
        this.provetrivalka.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.corpus.addChild(this.provetrivalka);
        this.provetrivalka.setTextureOffset(5, 58).addBox(3.025F, -7.075F, -9.8F, 1, 5, 1, 0.0F);
        this.provetrivalka.setTextureOffset(5, 58).addBox(-2.975F, -3.075F, -9.8F, 6, 1, 1, 0.0F);
        this.provetrivalka.setTextureOffset(5, 58).addBox(1.025F, -8.075F, -9.6F, 1, 5, 1, 0.0F);
        this.provetrivalka.setTextureOffset(5, 58).addBox(-1.975F, -8.075F, -9.6F, 1, 5, 1, 0.0F);
        this.provetrivalka.setTextureOffset(5, 58).addBox(-0.5F, -8.075F, -9.6F, 1, 5, 1, 0.0F);
        this.provetrivalka.setTextureOffset(5, 58).addBox(-2.45F, -8.4F, -9.8F, 5, 1, 1, 0.0F);
        this.provetrivalka.setTextureOffset(5, 58).addBox(-3.925F, -7.075F, -9.8F, 1, 5, 1, 0.0F);
        this.kosayaprovetrivalki = new MModelRenderer(this);
        this.kosayaprovetrivalki.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.provetrivalka.addChild(this.kosayaprovetrivalki);
        this.setRotation(this.kosayaprovetrivalki, 0.0F, 0.0F, -0.8378F);
        this.kosayaprovetrivalki.setTextureOffset(5, 58).addBox(6.95F, -3.725F, -9.8004F, 1, 2, 1, 0.0F);
        this.kosayaprovetrivalki2 = new MModelRenderer(this);
        this.kosayaprovetrivalki2.setRotationPoint(-12.025F, -8.6F, 0.0F);
        this.provetrivalka.addChild(this.kosayaprovetrivalki2);
        this.setRotation(this.kosayaprovetrivalki2, 0.0F, 0.0F, 0.8378F);
        this.kosayaprovetrivalki2.setTextureOffset(5, 58).addBox(6.55F, -6.975F, -9.8004F, 1, 2, 1, 0.0F);
        this.kabina_krasnaya = new MModelRenderer(this);
        this.kabina_krasnaya.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.corpus.addChild(this.kabina_krasnaya);
        this.kabina_krasnaya.setTextureOffset(91, 71).addBox(5.4F, -21.5F, 4.1F, 1, 1, 11, 0.0F);
        this.kabina_krasnaya.setTextureOffset(91, 71).addBox(-5.0F, -22.3F, 5.0F, 10, 2, 9, 0.0F);
        this.kabina_krasnaya.setTextureOffset(82, 71).addBox(-6.0F, -22.0F, 4.0F, 12, 2, 11, 0.0F);
        this.kabina_krasnaya.setTextureOffset(91, 71).addBox(-6.4F, -21.5F, 4.1F, 1, 1, 11, 0.0F);
        this.kabina_krasnaya.setTextureOffset(91, 71).addBox(-6.0F, -21.5F, 3.5F, 12, 1, 3, 0.0F);
        this.kabina_kosie_palki = new MModelRenderer(this);
        this.kabina_kosie_palki.setRotationPoint(0.0F, -6.9F, 23.3F);
        this.corpus.addChild(this.kabina_kosie_palki);
        this.setRotation(this.kabina_kosie_palki, 1.1868F, 0.0F, 0.0F);
        this.kabina_kosie_palki.setTextureOffset(0, 92).addBox(-5.875F, -21.0F, -6.0F, 2, 2, 13, 0.0F);
        this.kabina_kosie_palki.setTextureOffset(0, 113).addBox(3.875F, -21.0F, -6.0F, 2, 2, 13, 0.0F);
        this.kabina_seroe = new MModelRenderer(this);
        this.kabina_seroe.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.corpus.addChild(this.kabina_seroe);
        this.kabina_seroe.setTextureOffset(42, 116).addBox(4.0F, -20.0F, 11.0F, 2, 10, 2, 0.0F);
        this.kabina_seroe.setTextureOffset(42, 116).addBox(-6.0F, -20.0F, 11.0F, 2, 10, 2, 0.0F);
        this.kabina_seroe.setTextureOffset(42, 116).addBox(-6.0F, -12.0F, 3.0F, 1, 2, 8, 0.0F);
        this.kabina_seroe.setTextureOffset(42, 116).addBox(5.0F, -12.0F, 3.0F, 1, 2, 8, 0.0F);
        this.kabina_seroe.setTextureOffset(42, 116).addBox(-4.0F, -12.0F, 3.0F, 8, 2, 1, 0.0F);
        this.kabina_seroe.setTextureOffset(42, 116).addBox(-4.0F, -12.0F, 12.0F, 8, 2, 1, 0.0F);
        this.kabina_seroe.setTextureOffset(42, 116).addBox(-4.0F, -20.0F, 12.0F, 8, 1, 1, 0.0F);
        this.kabina_seroe.setTextureOffset(42, 116).addBox(-4.0F, -20.0F, 7.0F, 8, 1, 1, 0.0F);
        this.kabina_seroe.setTextureOffset(42, 116).addBox(-4.0F, -22.8F, 6.0F, 2, 2, 7, 0.0F);
        this.kabina_seroe.setTextureOffset(42, 116).addBox(-1.0F, -22.8F, 6.0F, 2, 2, 7, 0.0F);
        this.kabina_seroe.setTextureOffset(42, 116).addBox(2.0F, -22.8F, 6.0F, 2, 2, 7, 0.0F);
        this.kabina_seroe.setTextureOffset(42, 116).addBox(4.0F, -20.0F, 7.0F, 1, 1, 5, 0.0F);
        this.kabina_seroe.setTextureOffset(42, 116).addBox(-5.0F, -20.0F, 7.0F, 1, 1, 5, 0.0F);
        this.osnova = new MModelRenderer(this);
        this.osnova.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.corpus.addChild(this.osnova);
        this.osnova.setTextureOffset(62, 32).addBox(-6.0F, -7.25F, 13.0F, 12, 5, 1, 0.0F);
        this.osnova.setTextureOffset(60, 32).addBox(-6.0F, -10.0F, -8.875F, 12, 9, 22, 0.0F);
        this.osnova.setTextureOffset(62, 32).addBox(-5.0F, -10.2F, -8.0F, 10, 1, 11, 0.0F);
        this.osnova.setTextureOffset(62, 32).addBox(-5.0F, -9.0F, -9.4F, 10, 8, 1, 0.0F);
        this.Dim = new MModelRenderer(this);
        this.Dim.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.corpus.addChild(this.Dim);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(3.75F, -22.4F, -1.0F);
        this.Dim.addChild(this.bone3);
        this.bone3.setTextureOffset(116, 111).addBox(-1.0F, 0.8563F, -0.5243F, 3, 1, 1, 0.0F);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(3.75F, -20.4F, -1.0F);
        this.Dim.addChild(this.bone2);
        this.setRotation(this.bone2, -0.2618F, 0.0F, 0.0F);
        this.bone2.setTextureOffset(116, 111).addBox(-0.5F, -0.2619F, -0.5777F, 2, 1, 1, 0.0F);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(4.25F, -19.5F, -1.5F);
        this.Dim.addChild(this.bone);
        this.setRotation(this.bone, -0.48F, 0.0F, 0.0F);
        this.bone.setTextureOffset(116, 111).addBox(-0.5F, -0.4F, -0.4F, 1, 1, 1, 0.0F);
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(3.75F, -21.4F, -1.0F);
        this.Dim.addChild(this.bone5);
        this.bone5.setTextureOffset(116, 111).addBox(-1.0F, -1.1437F, -0.5243F, 3, 1, 1, 0.0F);
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(3.75F, -22.4F, -1.0F);
        this.Dim.addChild(this.bone4);
        this.bone4.setTextureOffset(116, 111).addBox(-1.0F, -1.1437F, -0.5243F, 3, 1, 1, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "pets/tractorpet.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/tractorpet_animation.json"));
        this.animation = bbanimationloader.mustGet("animation.model.new", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.04F;
        GlStateManager.translate(0.7F, -0.7F + f, 0.25F);
        GlStateManager.scale(0.6F, 0.6F, 0.6F);
        this.animation.tick(time);
        super.preRender(modelPlayer, player, time, pi);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.7F, 0.7F, 0.7F);
        GlStateManager.translate(0.0F, -0.5F, -0.1F);
        this.animation.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0422\u0440\u0430\u043a\u0442\u043e\u0440";
    }

    public String getCreator()
    {
        return "Mabult";
    }
}
