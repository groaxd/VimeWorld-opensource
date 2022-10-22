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

public class SmileyJess extends BasePet
{
    private final MModelRenderer legs;
    private final MModelRenderer bone10;
    private final MModelRenderer bone11;
    private final MModelRenderer head;
    private final MModelRenderer bone7;
    private final MModelRenderer bone6;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer body;
    private final MModelRenderer bone9;
    private final MModelRenderer bone8;
    private final MModelRenderer hands;
    private final MModelRenderer bone13;
    private final MModelRenderer bone14;
    private final MModelRenderer bone15;
    private final MModelRenderer bone12;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final IAnimation animation;

    public SmileyJess()
    {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.legs = new MModelRenderer(this);
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(0.5F, -0.6F, 0.05F);
        this.legs.addChild(this.bone10);
        this.bone10.cubeList.add(new ModelBox(this.bone10, 4, 14, -0.475F, -0.875F, -0.5F, 1, 2, 1, 0.0F, false));
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(-0.5F, -0.6F, 0.05F);
        this.setRotation(this.bone11, 0.0F, 0.0F, 0.0567F);
        this.legs.addChild(this.bone11);
        this.bone11.cubeList.add(new ModelBox(this.bone11, 0, 14, -0.525F, -0.875F, -0.5F, 1, 2, 1, 0.0F, false));
        this.head = new MModelRenderer(this);
        this.head.setRotationPoint(0.0775F, -5.735F, 0.165F);
        this.head.cubeList.add(new ModelBox(this.head, 18, 0, -0.3775F, -2.24F, -1.965F, 3, 1, 1, -0.4F, true));
        this.head.cubeList.add(new ModelBox(this.head, 18, 0, 0.1475F, -0.865F, -0.165F, 3, 1, 1, -0.4F, true));
        this.head.cubeList.add(new ModelBox(this.head, 18, 0, -3.4025F, -0.04F, 0.71F, 3, 1, 1, -0.4F, false));
        this.head.cubeList.add(new ModelBox(this.head, 0, 0, -2.0775F, -2.39F, -2.065F, 4, 4, 4, 0.0F, false));
        this.head.cubeList.add(new ModelBox(this.head, 0, 8, -2.0775F, -2.39F, 1.285F, 4, 4, 1, -0.15F, false));
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(1.6475F, -1.74F, -1.465F);
        this.setRotation(this.bone7, 0.0F, 1.5708F, 0.0F);
        this.head.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 26, 0, -1.0F, -1.0F, 0.025F, 2, 2, 1, -0.6F, true));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(2.1725F, -0.365F, 0.335F);
        this.setRotation(this.bone6, 0.0F, 1.5708F, 0.0F);
        this.head.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 26, 0, -1.0F, -1.0F, 0.025F, 2, 2, 1, -0.6F, true));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(-1.5775F, -2.44F, 0.235F);
        this.setRotation(this.bone, 0.0F, -1.5708F, 1.5708F);
        this.head.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 26, 0, -1.0F, -2.05F, 0.575F, 2, 2, 1, -0.6F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-0.5275F, -2.44F, 0.235F);
        this.setRotation(this.bone2, 0.0F, 0.0F, 1.5708F);
        this.head.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 18, 0, -1.5F, -0.5F, -0.5F, 3, 1, 1, -0.4F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(-2.4275F, 0.46F, 1.21F);
        this.setRotation(this.bone3, 0.0F, -1.5708F, 0.0F);
        this.head.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 26, 0, -1.0F, -1.0F, 0.025F, 2, 2, 1, -0.6F, false));
        this.body = new MModelRenderer(this);
        this.body.setRotationPoint(0.0566F, -3.0572F, -0.0833F);
        this.body.cubeList.add(new ModelBox(this.body, 12, 0, -1.0566F, -1.2928F, -0.3667F, 2, 3, 1, 0.0F, false));
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(-0.1342F, -0.1036F, -0.8417F);
        this.setRotation(this.bone9, 3.1416F, 0.3054F, -3.1416F);
        this.body.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 26, 0, -1.0F, -1.0F, -0.225F, 2, 2, 1, -0.6F, true));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(-0.1342F, -0.1036F, -0.8417F);
        this.setRotation(this.bone8, 0.0F, 1.2654F, 0.0F);
        this.body.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 18, 0, -1.275F, -0.5F, -0.5F, 2, 1, 1, -0.4F, true));
        this.hands = new MModelRenderer(this);
        this.hands.setRotationPoint(0.1917F, -3.6102F, 0.0375F);
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(-1.6802F, 0.5753F, 0.0125F);
        this.setRotation(this.bone13, 0.0F, 0.0F, 0.1265F);
        this.hands.addChild(this.bone13);
        this.bone13.cubeList.add(new ModelBox(this.bone13, 13, 8, -0.5F, -1.0F, -0.5F, 1, 2, 1, -0.025F, false));
        this.bone14 = new MModelRenderer(this);
        this.bone14.setRotationPoint(-1.7667F, 1.1352F, 0.5625F);
        this.setRotation(this.bone14, 0.0F, 0.0F, 0.1265F);
        this.hands.addChild(this.bone14);
        this.bone14.cubeList.add(new ModelBox(this.bone14, 8, 10, -0.525F, -0.5F, -1.5F, 1, 1, 3, -0.275F, false));
        this.bone15 = new MModelRenderer(this);
        this.bone15.setRotationPoint(-1.7666F, 1.3937F, 1.9625F);
        this.setRotation(this.bone15, 0.0F, 0.0F, 0.1196F);
        this.hands.addChild(this.bone15);
        this.bone15.cubeList.add(new ModelBox(this.bone15, 0, 9, -0.05F, -0.5F, -1.15F, 0, 1, 4, 0.0F, false));
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(1.2969F, 0.5753F, 0.0125F);
        this.setRotation(this.bone12, 0.0F, 0.0F, -0.1265F);
        this.hands.addChild(this.bone12);
        this.bone12.cubeList.add(new ModelBox(this.bone12, 0, 0, -0.5F, -1.0F, -0.5F, 1, 2, 1, -0.025F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(2.0083F, 0.4852F, 0.0625F);
        this.setRotation(this.bone4, 0.0F, 0.0F, -0.144F);
        this.hands.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 18, 0, -1.025F, -0.5F, -0.5F, 2, 1, 1, -0.4F, true));
        this.bone5 = new MModelRenderer(this);
        this.setRotation(this.bone5, 0.0F, 1.5708F, 0.0F);
        this.bone4.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 26, 0, -1.0F, -1.0F, 0.025F, 2, 2, 1, -0.6F, true));
        super.setTexture(new ResourceLocation("minidot", "pets/smileyjess.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/smileyjess_animation.json"));
        this.animation = bbanimationloader.mustGet("animation.model.new", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        double d0 = (double)MathHelper.sin(time * 0.1F) * 0.03D;
        GlStateManager.translate(1.0D, -0.2D + d0, 0.45D);
        double d1 = 2.0D;
        GlStateManager.scale(d1, d1, d1);
        GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
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
        double d0 = 2.0D;
        GlStateManager.scale(d0, d0, d0);
        GlStateManager.translate(0.0D, 0.15D, 0.0D);
        this.animation.tick(time);
        GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0423\u043b\u044b\u0431\u0430\u0448\u043a\u0430 \u0414\u0436\u0435\u0441\u0441";
    }

    public String getCreator()
    {
        return "GUllT";
    }
}
