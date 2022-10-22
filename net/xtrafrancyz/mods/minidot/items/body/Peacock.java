package net.xtrafrancyz.mods.minidot.items.body;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class Peacock extends BaseItem
{
    private final MModelRenderer Peacock;
    private final MModelRenderer bone10;
    private final MModelRenderer bone9;
    private final MModelRenderer bone8;
    private final MModelRenderer bone21;
    private final MModelRenderer bone7;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final MModelRenderer bone6;
    private final MModelRenderer bone3;
    private final MModelRenderer bone2;
    private final MModelRenderer bone;
    private final MModelRenderer bone11;
    private final MModelRenderer bone12;
    private final MModelRenderer bone13;
    private final MModelRenderer bone14;
    private final MModelRenderer bone15;
    private final MModelRenderer bone16;
    private final MModelRenderer bone17;
    private final MModelRenderer bone18;
    private final MModelRenderer bone19;
    private final IAnimation animation;

    public Peacock()
    {
        super(ItemType.BODY);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.Peacock = new MModelRenderer(this);
        this.Peacock.setRotationPoint(0.0F, 0.0F, -1.0F);
        this.setRotation(this.Peacock, -0.0873F, 0.0F, 0.0F);
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(0.0F, 0.0F, 1.0F);
        this.Peacock.addChild(this.bone10);
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(3.0F, -8.0F, -0.5F);
        this.setRotation(this.bone9, -0.2626F, 0.1656F, 1.2362F);
        this.bone10.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 0, 0, -1.0F, -15.0F, 1.0F, 12, 19, 0, 0.0F, false));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(0.0F, -8.0F, -0.5F);
        this.setRotation(this.bone8, -0.4326F, -0.2149F, 0.3528F);
        this.bone10.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 0, 0, -1.0F, -15.0F, 1.0F, 12, 19, 0, 0.0F, false));
        this.bone21 = new MModelRenderer(this);
        this.bone21.setRotationPoint(-5.0F, -8.0F, -0.5F);
        this.setRotation(this.bone21, -0.3889F, 0.0F, 0.0F);
        this.bone10.addChild(this.bone21);
        this.bone21.cubeList.add(new ModelBox(this.bone21, 0, 0, -1.0F, -15.0F, 1.0F, 12, 19, 0, 0.0F, false));
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(0.0F, -8.0F, -0.5F);
        this.setRotation(this.bone7, -0.3491F, 0.0F, 0.7854F);
        this.bone10.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 0, 0, -1.0F, -15.0F, 1.0F, 12, 19, 0, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(1.0F, -5.0F, 0.0F);
        this.setRotation(this.bone4, 0.0F, 0.0F, -1.1781F);
        this.bone10.addChild(this.bone4);
        this.bone5 = new MModelRenderer(this);
        this.setRotation(this.bone5, 0.0F, 0.0F, -1.0472F);
        this.bone4.addChild(this.bone5);
        this.bone6 = new MModelRenderer(this);
        this.setRotation(this.bone6, 0.0F, 0.0F, -0.6109F);
        this.bone4.addChild(this.bone6);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(1.0F, -4.0F, 0.0F);
        this.bone10.addChild(this.bone3);
        this.bone2 = new MModelRenderer(this);
        this.setRotation(this.bone2, 0.0F, 0.0F, 1.0472F);
        this.bone3.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 12, 19, -6.9432F, -11.1655F, 0.0F, 1, 5, 1, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.setRotation(this.bone, 0.0F, 0.0F, 0.6109F);
        this.bone3.addChild(this.bone);
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(0.0F, 0.0F, 1.0F);
        this.Peacock.addChild(this.bone11);
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(-3.0F, -8.0F, -0.5F);
        this.setRotation(this.bone12, -0.2626F, -0.1656F, -1.2362F);
        this.bone11.addChild(this.bone12);
        this.bone12.cubeList.add(new ModelBox(this.bone12, 0, 0, -11.0F, -15.0F, 1.0F, 12, 19, 0, 0.0F, true));
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(0.0F, -8.0F, -0.5F);
        this.setRotation(this.bone13, -0.4326F, 0.2149F, -0.3528F);
        this.bone11.addChild(this.bone13);
        this.bone13.cubeList.add(new ModelBox(this.bone13, 0, 0, -11.0F, -15.0F, 1.0F, 12, 19, 0, 0.0F, true));
        this.bone14 = new MModelRenderer(this);
        this.bone14.setRotationPoint(0.0F, -8.0F, -0.5F);
        this.setRotation(this.bone14, -0.3491F, 0.0F, -0.7854F);
        this.bone11.addChild(this.bone14);
        this.bone14.cubeList.add(new ModelBox(this.bone14, 0, 0, -11.0F, -15.0F, 1.0F, 12, 19, 0, 0.0F, true));
        this.bone15 = new MModelRenderer(this);
        this.bone15.setRotationPoint(-1.0F, -5.0F, 0.0F);
        this.setRotation(this.bone15, 0.0F, 0.0F, 1.1781F);
        this.bone11.addChild(this.bone15);
        this.bone16 = new MModelRenderer(this);
        this.setRotation(this.bone16, 0.0F, 0.0F, 1.0472F);
        this.bone15.addChild(this.bone16);
        this.bone17 = new MModelRenderer(this);
        this.setRotation(this.bone17, 0.0F, 0.0F, 0.6109F);
        this.bone15.addChild(this.bone17);
        this.bone18 = new MModelRenderer(this);
        this.bone18.setRotationPoint(-1.0F, -4.0F, 0.0F);
        this.bone11.addChild(this.bone18);
        this.bone19 = new MModelRenderer(this);
        this.setRotation(this.bone19, 0.0F, 0.0F, -1.0472F);
        this.bone18.addChild(this.bone19);
        this.bone19.cubeList.add(new ModelBox(this.bone19, 12, 19, 5.9432F, -11.1655F, 0.0F, 1, 5, 1, 0.0F, true));
        super.setTexture(new ResourceLocation("minidot", "body/peacock.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "body/peacock_animation.json"));
        this.animation = bbanimationloader.mustGet("peacock.default", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0D, 0.65D, 0.175D);
        float f = 0.65F;
        GlStateManager.scale(f, f, f);

        if (player.getCurrentArmor(2) != null)
        {
            GlStateManager.translate(0.0D, 0.0D, 0.05D);
        }

        this.animation.tick(time);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0D, 0.5D, 0.2D);
        double d0 = 0.7D;
        GlStateManager.scale(d0, d0, d0);
        this.animation.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0425\u0432\u043e\u0441\u0442 \u043f\u0430\u0432\u043b\u0438\u043d\u0430";
    }

    public String getCreator()
    {
        return "Rander_";
    }
}
