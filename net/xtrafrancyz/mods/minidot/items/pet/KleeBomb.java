package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.List;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;
import net.xtrafrancyz.mods.minidot.util.MNaming;

public class KleeBomb extends BasePet
{
    private final MModelRenderer obshee;
    private final MModelRenderer meshok;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final MModelRenderer bone6;
    private final MModelRenderer bone18;
    private final MModelRenderer bone19;
    private final MModelRenderer bone20;
    private final MModelRenderer bone21;
    private final MModelRenderer bone25;
    private final MModelRenderer bone24;
    private final MModelRenderer bone22;
    private final MModelRenderer bone23;
    private final MModelRenderer bone26;
    private final MModelRenderer bone27;
    private final MModelRenderer bone28;
    private final MModelRenderer bone29;
    private final MModelRenderer head;
    private final MModelRenderer eyes;
    private final MModelRenderer eye1;
    private final MModelRenderer eye2;
    private final MModelRenderer uho1;
    private final MModelRenderer uho2;
    private final IAnimation animation;

    public KleeBomb()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.obshee = new MModelRenderer(this);
        this.meshok = new MModelRenderer(this);
        this.meshok.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.obshee.addChild(this.meshok);
        this.meshok.cubeList.add(new ModelBox(this.meshok, 0, 0, -3.0F, -2.5F, -3.0F, 6, 1, 6, 0.0F, false));
        this.meshok.cubeList.add(new ModelBox(this.meshok, 15, 11, -2.5F, -6.45F, -2.5F, 5, 1, 5, 0.2F, false));
        this.meshok.cubeList.add(new ModelBox(this.meshok, 19, 21, -3.5F, -6.77F, -2.5F, 1, 1, 5, -0.1001F, false));
        this.meshok.cubeList.add(new ModelBox(this.meshok, 19, 17, -2.5F, -6.77F, -3.5F, 5, 1, 2, -0.1001F, false));
        this.meshok.cubeList.add(new ModelBox(this.meshok, 15, 7, -2.5F, -6.77F, 1.5F, 5, 1, 2, -0.1F, false));
        this.meshok.cubeList.add(new ModelBox(this.meshok, 18, 0, 1.5F, -6.77F, -2.5F, 2, 1, 5, -0.101F, false));
        this.meshok.cubeList.add(new ModelBox(this.meshok, 26, 20, -2.5F, -5.9571F, -3.9571F, 5, 4, 1, 0.0F, false));
        this.meshok.cubeList.add(new ModelBox(this.meshok, 0, 25, -2.5F, -5.9571F, 2.9571F, 5, 4, 1, 0.0F, false));
        this.meshok.cubeList.add(new ModelBox(this.meshok, 0, 16, -3.9571F, -5.9571F, -2.5F, 1, 4, 5, 0.0F, false));
        this.meshok.cubeList.add(new ModelBox(this.meshok, 27, 0, -4.0F, -5.0F, -1.5F, 1, 2, 3, 0.25F, false));
        this.meshok.cubeList.add(new ModelBox(this.meshok, 20, 27, -1.5F, -5.0F, -4.0F, 3, 2, 1, 0.25F, false));
        this.meshok.cubeList.add(new ModelBox(this.meshok, 27, 6, -1.5F, -5.0F, 3.0F, 3, 2, 1, 0.25F, false));
        this.meshok.cubeList.add(new ModelBox(this.meshok, 12, 26, 3.0F, -5.0F, -1.5F, 1, 2, 3, 0.25F, false));
        this.meshok.cubeList.add(new ModelBox(this.meshok, 12, 17, 2.9571F, -5.9571F, -2.5F, 1, 4, 5, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.setRotation(this.bone3, 0.0F, -0.7854F, 0.0F);
        this.meshok.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 33, 13, -0.8071F, -7.77F, -4.2012F, 1, 1, 1, -0.1F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 32, 29, -0.1929F, -7.77F, -4.2012F, 1, 1, 1, -0.1001F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.setRotation(this.bone4, 0.0F, 0.7854F, 0.0F);
        this.meshok.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 27, 32, -0.1929F, -7.77F, -4.2012F, 1, 1, 1, -0.1F, false));
        this.bone4.cubeList.add(new ModelBox(this.bone4, 32, 0, -0.8071F, -7.77F, -4.2012F, 1, 1, 1, -0.101F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.setRotation(this.bone5, 0.0F, -0.7854F, 0.0F);
        this.meshok.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 31, 17, -0.1929F, -7.77F, 3.2012F, 1, 1, 1, -0.1001F, false));
        this.bone5.cubeList.add(new ModelBox(this.bone5, 30, 14, -0.8071F, -7.77F, 3.2012F, 1, 1, 1, -0.101F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.setRotation(this.bone6, 0.0F, 0.7854F, 0.0F);
        this.meshok.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 19, 20, -0.8071F, -7.77F, 3.2012F, 1, 1, 1, -0.1001F, false));
        this.bone6.cubeList.add(new ModelBox(this.bone6, 12, 20, -0.1929F, -7.77F, 3.2012F, 1, 1, 1, -0.101F, false));
        this.bone18 = new MModelRenderer(this);
        this.bone18.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.setRotation(this.bone18, 0.0F, -0.7854F, 0.0F);
        this.meshok.addChild(this.bone18);
        this.bone18.cubeList.add(new ModelBox(this.bone18, 30, 9, -1.0303F, -6.9571F, -4.5659F, 1, 4, 1, -1.0E-4F, false));
        this.bone18.cubeList.add(new ModelBox(this.bone18, 0, 7, 0.0303F, -6.9571F, -4.5659F, 1, 4, 1, -1.0E-4F, false));
        this.bone18.cubeList.add(new ModelBox(this.bone18, 0, 0, -0.0303F, -6.9571F, -4.5659F, 1, 4, 1, -0.001F, false));
        this.bone19 = new MModelRenderer(this);
        this.bone19.setRotationPoint(-8.0F, 1.0F, 0.0F);
        this.setRotation(this.bone19, 0.0F, -0.7854F, 0.0F);
        this.meshok.addChild(this.bone19);
        this.bone19.cubeList.add(new ModelBox(this.bone19, 12, 31, 1.091F, -6.9571F, -5.6265F, 1, 4, 1, -1.0E-4F, false));
        this.bone19.cubeList.add(new ModelBox(this.bone19, 8, 30, 1.091F, -6.9571F, -6.6872F, 1, 4, 1, -1.0E-4F, false));
        this.bone19.cubeList.add(new ModelBox(this.bone19, 4, 30, 1.091F, -6.9571F, -5.6872F, 1, 4, 1, -0.001F, false));
        this.bone20 = new MModelRenderer(this);
        this.bone20.setRotationPoint(-8.0F, 1.0F, 7.0F);
        this.setRotation(this.bone20, 0.0F, -0.7854F, 0.0F);
        this.meshok.addChild(this.bone20);
        this.bone20.cubeList.add(new ModelBox(this.bone20, 23, 30, 0.7374F, -6.9571F, -7.0407F, 1, 4, 1, -1.0E-4F, false));
        this.bone20.cubeList.add(new ModelBox(this.bone20, 0, 30, -0.3232F, -6.9571F, -7.0407F, 1, 4, 1, -1.0E-4F, false));
        this.bone20.cubeList.add(new ModelBox(this.bone20, 28, 27, 0.6768F, -6.9571F, -7.0407F, 1, 4, 1, -0.001F, false));
        this.bone21 = new MModelRenderer(this);
        this.bone21.setRotationPoint(1.0F, 1.0F, 7.0F);
        this.setRotation(this.bone21, 0.0F, -0.7854F, 0.0F);
        this.meshok.addChild(this.bone21);
        this.bone21.cubeList.add(new ModelBox(this.bone21, 19, 30, -2.091F, -6.9571F, -5.273F, 1, 4, 1, -1.0E-4F, false));
        this.bone21.cubeList.add(new ModelBox(this.bone21, 18, 0, -2.091F, -6.9571F, -4.2123F, 1, 4, 1, -1.0E-4F, false));
        this.bone21.cubeList.add(new ModelBox(this.bone21, 0, 16, -2.091F, -6.9571F, -5.2123F, 1, 4, 1, -0.001F, false));
        this.bone25 = new MModelRenderer(this);
        this.bone25.setRotationPoint(4.0F, 0.0F, 0.0F);
        this.setRotation(this.bone25, 0.0F, 0.0F, -0.7854F);
        this.meshok.addChild(this.bone25);
        this.bone25.cubeList.add(new ModelBox(this.bone25, 7, 12, -0.2914F, -10.7158F, -2.4701F, 0, 1, 5, 0.0F, false));
        this.bone24 = new MModelRenderer(this);
        this.bone24.setRotationPoint(4.0F, 0.0F, 0.0F);
        this.setRotation(this.bone24, 0.0F, 0.0F, 0.7854F);
        this.meshok.addChild(this.bone24);
        this.bone24.cubeList.add(new ModelBox(this.bone24, 7, 13, -5.1795F, -5.2431F, -2.4706F, 0, 1, 5, 0.0F, false));
        this.bone22 = new MModelRenderer(this);
        this.bone22.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.setRotation(this.bone22, -0.7854F, 0.0F, 0.0F);
        this.meshok.addChild(this.bone22);
        this.bone22.cubeList.add(new ModelBox(this.bone22, 7, 19, -2.37F, -8.7123F, -3.1363F, 5, 1, 0, 0.0F, false));
        this.bone23 = new MModelRenderer(this);
        this.bone23.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.setRotation(this.bone23, 0.7854F, 0.0F, 0.0F);
        this.meshok.addChild(this.bone23);
        this.bone23.cubeList.add(new ModelBox(this.bone23, 15, 10, -2.3698F, -8.6703F, 3.1771F, 5, 1, 0, 0.0F, false));
        this.bone26 = new MModelRenderer(this);
        this.bone26.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.setRotation(this.bone26, 0.5208F, -0.6178F, -0.7854F);
        this.meshok.addChild(this.bone26);
        this.bone26.cubeList.add(new ModelBox(this.bone26, 15, 9, -2.2445F, -4.4887F, -1.0791F, 0, 1, 2, 0.0F, false));
        this.bone27 = new MModelRenderer(this);
        this.bone27.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.setRotation(this.bone27, 0.5208F, 0.6178F, 0.7854F);
        this.meshok.addChild(this.bone27);
        this.bone27.cubeList.add(new ModelBox(this.bone27, 11, 14, 2.3966F, -4.5954F, -0.895F, 0, 1, 2, 0.0F, false));
        this.bone28 = new MModelRenderer(this);
        this.bone28.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.setRotation(this.bone28, -0.5208F, -0.6178F, 0.7854F);
        this.meshok.addChild(this.bone28);
        this.bone28.cubeList.add(new ModelBox(this.bone28, 7, 14, 2.4298F, -4.6195F, -1.0629F, 0, 1, 2, 0.0F, false));
        this.bone29 = new MModelRenderer(this);
        this.bone29.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.setRotation(this.bone29, -0.5208F, 0.6178F, -0.7854F);
        this.meshok.addChild(this.bone29);
        this.bone29.cubeList.add(new ModelBox(this.bone29, 0, 3, -2.2781F, -4.5132F, -0.8795F, 0, 1, 2, 0.0F, false));
        this.head = new MModelRenderer(this);
        this.head.setRotationPoint(0.0F, -0.25F, 0.0F);
        this.obshee.addChild(this.head);
        this.head.cubeList.add(new ModelBox(this.head, 0, 7, -2.5F, -9.75F, -2.5F, 5, 4, 5, -0.1F, false));
        this.eyes = new MModelRenderer(this);
        this.eyes.setRotationPoint(0.0F, 0.25F, 0.0F);
        this.head.addChild(this.eyes);
        this.eye1 = new MModelRenderer(this);
        this.eyes.addChild(this.eye1);
        this.eye1.cubeList.add(new ModelBox(this.eye1, 34, 4, 1.0F, -9.0F, -2.75F, 1, 1, 1, -0.25F, false));
        this.eye2 = new MModelRenderer(this);
        this.eyes.addChild(this.eye2);
        this.eye2.cubeList.add(new ModelBox(this.eye2, 34, 8, -2.0F, -9.0F, -2.75F, 1, 1, 1, -0.25F, false));
        this.uho1 = new MModelRenderer(this);
        this.uho1.setRotationPoint(-7.25F, -2.75F, 0.0F);
        this.setRotation(this.uho1, 0.0F, 0.0F, 0.7854F);
        this.head.addChild(this.uho1);
        this.uho1.cubeList.add(new ModelBox(this.uho1, 32, 25, 1.5F, -14.0F, -0.5F, 1, 3, 1, 0.0F, false));
        this.uho2 = new MModelRenderer(this);
        this.uho2.setRotationPoint(7.25F, -2.75F, 0.0F);
        this.setRotation(this.uho2, 0.0F, 0.0F, -0.7854F);
        this.head.addChild(this.uho2);
        this.uho2.cubeList.add(new ModelBox(this.uho2, 31, 31, -2.5F, -14.0F, -0.5F, 1, 3, 1, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/kleebomb.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/kleebomb_animation.json"));
        this.animation = bbanimationloader.mustGet("animation.model.new", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.translate(0.7D, 0.0D, 0.3D);
        float f = 1.5F;
        GlStateManager.scale(f, f, f);
        this.animation.tick(time);
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
        GlStateManager.translate(0.0D, 0.4D, 0.0D);
        float f = 1.75F;
        GlStateManager.scale(f, f, f);
        this.animation.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0411\u043e\u043c\u0431\u043e\u0447\u043a\u0430 \u041a\u043b\u0438";
    }

    public String getCreator()
    {
        return "Florina";
    }

    public List<String> getDescription()
    {
        return MNaming.fromGame("Genshin Impact");
    }
}
