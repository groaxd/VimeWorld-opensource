package net.xtrafrancyz.mods.minidot.items.head;

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

public class SpringHat extends BaseItem
{
    private final MModelRenderer spring_hat;
    private final MModelRenderer base;
    private final MModelRenderer flower;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final MModelRenderer bone6;
    private final MModelRenderer bone7;
    private final MModelRenderer bone8;
    private final MModelRenderer bone23;
    private final MModelRenderer bone;
    private final MModelRenderer knot;
    private final MModelRenderer bone18;
    private final MModelRenderer bone17;
    private final MModelRenderer two;
    private final MModelRenderer bone22;
    private final MModelRenderer one;
    private final MModelRenderer bone19;
    private final IAnimation animation;

    public SpringHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.spring_hat = new MModelRenderer(this);
        this.spring_hat.setRotationPoint(-2.0F, 8.0F, 1.0F);
        this.base = new MModelRenderer(this);
        this.spring_hat.addChild(this.base);
        this.base.cubeList.add(new ModelBox(this.base, 0, 0, -5.0F, -8.0F, -8.0F, 14, 0, 14, 0.0F, false));
        this.base.cubeList.add(new ModelBox(this.base, 0, 14, -2.0F, -10.0F, -4.0F, 8, 2, 7, 0.0F, false));
        this.flower = new MModelRenderer(this);
        this.flower.setRotationPoint(1.775F, -11.025F, -0.5F);
        this.spring_hat.addChild(this.flower);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.setRotation(this.bone2, 0.0F, 0.829F, 0.0F);
        this.flower.addChild(this.bone2);
        this.bone3 = new MModelRenderer(this);
        this.setRotation(this.bone3, 0.0F, -1.5708F, 0.0F);
        this.bone2.addChild(this.bone3);
        this.bone4 = new MModelRenderer(this);
        this.setRotation(this.bone4, 0.0F, 0.0F, 0.2618F);
        this.bone3.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 0, 9, -3.0F, 0.0F, -1.5F, 3, 0, 3, 0.0F, false));
        this.bone5 = new MModelRenderer(this);
        this.setRotation(this.bone5, -3.1416F, 0.0F, 3.1416F);
        this.bone2.addChild(this.bone5);
        this.bone6 = new MModelRenderer(this);
        this.setRotation(this.bone6, 0.0F, 0.0F, 0.2618F);
        this.bone5.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 0, 6, -3.0F, 0.0F, -1.5F, 3, 0, 3, 0.0F, false));
        this.bone7 = new MModelRenderer(this);
        this.setRotation(this.bone7, 0.0F, 1.5708F, 0.0F);
        this.bone2.addChild(this.bone7);
        this.bone8 = new MModelRenderer(this);
        this.setRotation(this.bone8, 0.0F, 0.0F, 0.2618F);
        this.bone7.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 0, 3, -3.0F, 0.0F, -1.5F, 3, 0, 3, 0.0F, false));
        this.bone23 = new MModelRenderer(this);
        this.setRotation(this.bone23, 0.0F, 0.0F, 0.2618F);
        this.bone2.addChild(this.bone23);
        this.bone23.cubeList.add(new ModelBox(this.bone23, 0, 0, -3.0F, 0.0F, -1.5F, 3, 0, 3, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.spring_hat.addChild(this.bone);
        this.knot = new MModelRenderer(this);
        this.knot.setRotationPoint(1.5F, 4.7F, -4.425F);
        this.setRotation(this.knot, -((float)Math.PI * 2F / 9F), 0.0F, 0.0F);
        this.bone.addChild(this.knot);
        this.knot.cubeList.add(new ModelBox(this.knot, 9, 6, 0.0F, -11.0F, -9.0F, 1, 1, 1, 0.0F, false));
        this.bone18 = new MModelRenderer(this);
        this.bone18.setRotationPoint(0.0F, -10.0F, -8.5F);
        this.setRotation(this.bone18, 0.0F, -0.2182F, 0.1745F);
        this.knot.addChild(this.bone18);
        this.bone18.cubeList.add(new ModelBox(this.bone18, 0, 23, -3.0F, -2.0F, -0.5F, 3, 3, 1, 0.0F, false));
        this.bone17 = new MModelRenderer(this);
        this.bone17.setRotationPoint(1.0F, -10.0F, -8.5F);
        this.setRotation(this.bone17, 0.0F, 0.2182F, -0.1745F);
        this.knot.addChild(this.bone17);
        this.bone17.cubeList.add(new ModelBox(this.bone17, 8, 23, 0.0F, -2.0F, -0.5F, 3, 3, 1, 0.0F, false));
        this.two = new MModelRenderer(this);
        this.two.setRotationPoint(3.0F, 0.0F, 0.0F);
        this.bone.addChild(this.two);
        this.two.cubeList.add(new ModelBox(this.two, 6, 0, 0.0F, -8.05F, 3.0F, 1, 0, 3, 0.0F, false));
        this.bone22 = new MModelRenderer(this);
        this.bone22.setRotationPoint(0.5F, -8.0F, 6.0F);
        this.two.addChild(this.bone22);
        this.bone22.cubeList.add(new ModelBox(this.bone22, 0, 0, -0.5F, -0.05F, 0.0F, 1, 4, 0, 0.0F, false));
        this.one = new MModelRenderer(this);
        this.bone.addChild(this.one);
        this.one.cubeList.add(new ModelBox(this.one, 6, 3, 0.0F, -8.05F, 3.0F, 1, 0, 3, 0.0F, false));
        this.bone19 = new MModelRenderer(this);
        this.bone19.setRotationPoint(0.5F, -8.0F, 6.0F);
        this.one.addChild(this.bone19);
        this.bone19.cubeList.add(new ModelBox(this.bone19, 0, 4, -0.5F, -0.05F, 0.0F, 1, 4, 0, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "head/springhat.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "head/springhat_animation.json"));
        this.animation = bbanimationloader.mustGet("springhat.animation", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        this.animation.tick(time);
        GlStateManager.translate(0.0D, -0.5D - (player.inventory.armorItemInSlot(3) != null ? 0.025D : 0.0D), 0.0D);
    }

    public void renderAsItem(float time)
    {
        this.animation.tick(time);
        GlStateManager.translate(0.0D, -0.3D, 0.0D);
        double d0 = 0.67D;
        GlStateManager.scale(d0, d0, d0);
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
        return "\u0412\u0435\u0441\u0435\u043d\u043d\u044f\u044f \u043f\u0430\u043d\u0430\u043c\u043a\u0430";
    }

    public String getCreator()
    {
        return "Rander_";
    }
}
