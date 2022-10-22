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

public class RamenPet extends BasePet
{
    private final MModelRenderer root;
    private final MModelRenderer notroot;
    private final MModelRenderer bone;
    private final MModelRenderer lapsha;
    private final MModelRenderer yaico2;
    private final MModelRenderer myaso2;
    private final MModelRenderer lapsha20;
    private final MModelRenderer nori2;
    private final MModelRenderer nori;
    private final MModelRenderer krug;
    private final MModelRenderer myaso3;
    private final MModelRenderer myaso;
    private final MModelRenderer yaico;
    private final MModelRenderer palka;
    private final MModelRenderer palka2;
    private final MModelRenderer par;
    private final MModelRenderer par2;
    private final MModelRenderer par3;
    private final IAnimation animation;

    public RamenPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.root = new MModelRenderer(this);
        this.notroot = new MModelRenderer(this);
        this.setRotation(this.notroot, 0.0F, 0.7854F, 0.0F);
        this.root.addChild(this.notroot);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, -2.25F, 0.0F);
        this.notroot.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 18, -5.0F, 1.25F, -5.0F, 10, 1, 10, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 0, -6.0F, -4.75F, -6.0F, 12, 6, 12, 0.0F, false));
        this.lapsha = new MModelRenderer(this);
        this.lapsha.setRotationPoint(0.0F, -7.5F, 0.0F);
        this.notroot.addChild(this.lapsha);
        this.lapsha.cubeList.add(new ModelBox(this.lapsha, 0, 31, -5.0F, -0.4F, -5.0F, 10, 2, 10, 0.0F, false));
        this.yaico2 = new MModelRenderer(this);
        this.yaico2.setRotationPoint(3.1F, -1.3F, -2.9F);
        this.setRotation(this.yaico2, 0.1272F, 0.6333F, 0.303F);
        this.lapsha.addChild(this.yaico2);
        this.yaico2.cubeList.add(new ModelBox(this.yaico2, 0, 5, -1.5F, -0.5F, -0.5F, 3, 1, 2, 0.1F, false));
        this.myaso2 = new MModelRenderer(this);
        this.myaso2.setRotationPoint(-2.1F, -1.3F, 1.5F);
        this.setRotation(this.myaso2, 0.0465F, -0.649F, 0.1551F);
        this.lapsha.addChild(this.myaso2);
        this.myaso2.cubeList.add(new ModelBox(this.myaso2, 30, 22, -2.8022F, -0.5185F, -2.8979F, 3, 1, 5, 0.0F, false));
        this.lapsha20 = new MModelRenderer(this);
        this.lapsha20.setRotationPoint(0.0F, -8.2F, 0.0F);
        this.notroot.addChild(this.lapsha20);
        this.lapsha20.cubeList.add(new ModelBox(this.lapsha20, 0, 42, -4.0F, -0.5F, -4.0F, 8, 3, 8, 0.0F, false));
        this.nori2 = new MModelRenderer(this);
        this.nori2.setRotationPoint(2.4997F, -1.2587F, 2.3493F);
        this.setRotation(this.nori2, -2.296F, -1.3653F, -3.1214F);
        this.lapsha20.addChild(this.nori2);
        this.nori2.cubeList.add(new ModelBox(this.nori2, 0, 0, -1.7F, 0.0F, -2.5F, 3, 0, 5, 0.0F, false));
        this.nori = new MModelRenderer(this);
        this.nori.setRotationPoint(3.0829F, -1.1192F, 3.7306F);
        this.setRotation(this.nori, 0.2488F, -1.4188F, 0.858F);
        this.lapsha20.addChild(this.nori);
        this.nori.cubeList.add(new ModelBox(this.nori, 0, 0, -1.5F, -0.6F, -2.5F, 3, 0, 5, 0.0F, false));
        this.krug = new MModelRenderer(this);
        this.krug.setRotationPoint(4.1195F, -0.4477F, 0.1767F);
        this.setRotation(this.krug, -0.0577F, -0.5574F, 0.5276F);
        this.lapsha20.addChild(this.krug);
        this.krug.cubeList.add(new ModelBox(this.krug, 36, 8, -1.5F, -0.5F, -1.5F, 3, 1, 3, -0.3F, false));
        this.myaso3 = new MModelRenderer(this);
        this.myaso3.setRotationPoint(0.15F, -1.0F, 2.0F);
        this.setRotation(this.myaso3, 0.0773F, -0.1592F, 0.3688F);
        this.lapsha20.addChild(this.myaso3);
        this.myaso3.cubeList.add(new ModelBox(this.myaso3, 30, 22, -1.1358F, -0.839F, -2.9796F, 3, 1, 5, 0.0F, false));
        this.myaso = new MModelRenderer(this);
        this.myaso.setRotationPoint(-1.3671F, -0.9701F, 1.0578F);
        this.setRotation(this.myaso, 0.0075F, -0.4222F, 0.29F);
        this.lapsha20.addChild(this.myaso);
        this.myaso.cubeList.add(new ModelBox(this.myaso, 30, 22, -1.5F, -0.5F, -2.5F, 3, 1, 5, 0.0F, false));
        this.yaico = new MModelRenderer(this);
        this.yaico.setRotationPoint(1.9F, -0.6F, -2.9F);
        this.setRotation(this.yaico, 0.9159F, 1.2795F, 0.8995F);
        this.lapsha20.addChild(this.yaico);
        this.yaico.cubeList.add(new ModelBox(this.yaico, 0, 5, -1.5F, -0.5F, -2.3F, 3, 1, 2, 0.1F, false));
        this.palka = new MModelRenderer(this);
        this.palka.setRotationPoint(-2.2394F, -8.666F, -3.4511F);
        this.setRotation(this.palka, -0.5863F, -0.2487F, 1.0862F);
        this.notroot.addChild(this.palka);
        this.palka.cubeList.add(new ModelBox(this.palka, 0, 29, -8.0182F, -0.6339F, -0.5257F, 15, 1, 1, -0.2F, false));
        this.palka2 = new MModelRenderer(this);
        this.palka2.setRotationPoint(-4.5F, -8.5F, 0.0F);
        this.setRotation(this.palka2, 0.0F, 0.0F, 1.0036F);
        this.notroot.addChild(this.palka2);
        this.palka2.cubeList.add(new ModelBox(this.palka2, 0, 29, -8.1179F, -1.4971F, -2.9F, 15, 1, 1, -0.2F, false));
        this.par = new MModelRenderer(this);
        this.par.setRotationPoint(-3.0F, -17.0F, 0.0F);
        this.setRotation(this.par, 0.0F, -0.7854F, 0.0F);
        this.notroot.addChild(this.par);
        this.par.cubeList.add(new ModelBox(this.par, 24, 43, -1.0F, -1.3F, -2.7F, 2, 6, 0, 0.0F, false));
        this.par2 = new MModelRenderer(this);
        this.par2.setRotationPoint(-0.6901F, -18.25F, 1.0316F);
        this.setRotation(this.par2, 0.0F, -0.7854F, 0.0F);
        this.notroot.addChild(this.par2);
        this.par2.cubeList.add(new ModelBox(this.par2, 24, 43, -1.0F, -3.0F, 0.0F, 2, 6, 0, 0.0F, false));
        this.par3 = new MModelRenderer(this);
        this.par3.setRotationPoint(2.142F, -16.0F, 1.8634F);
        this.setRotation(this.par3, 0.0F, -0.7854F, 0.0F);
        this.notroot.addChild(this.par3);
        this.par3.cubeList.add(new ModelBox(this.par3, 24, 43, -1.0F, -3.0F, 0.0F, 2, 6, 0, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/ramenpet.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/ramenpet_animation.json"));
        this.animation = bbanimationloader.mustGet("ramenpet.animation", this);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        this.animation.tick(time);
        float f = MathHelper.sin(time * 0.16F) * 0.04F;
        GlStateManager.translate(0.65F, -0.25F + f, 0.2F);
        double d0 = 0.8D;
        GlStateManager.scale(d0, d0, d0);
        super.preRender(modelPlayer, player, time, pi);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.2065F, 0.0F);
        this.animation.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0420\u0430\u043c\u0435\u043d";
    }

    public String getCreator()
    {
        return "Adl3r";
    }
}
