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

public class Cauldron extends BaseItem
{
    private final MModelRenderer Project;
    private final MModelRenderer bag;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final MModelRenderer Caudron;
    private final MModelRenderer jija;
    private final MModelRenderer bone9;
    private final MModelRenderer bone8;
    private final MModelRenderer bone7;
    private final MModelRenderer bone6;
    private final MModelRenderer bubble1;
    private final MModelRenderer bubble2;
    private final MModelRenderer bubble3;
    private final MModelRenderer bubble4;
    private final MModelRenderer bubble5;
    private final MModelRenderer bubble6;
    private final MModelRenderer bubble7;
    private final MModelRenderer bubble8;
    private final MModelRenderer bubble9;
    private final MModelRenderer Eye;
    private final MModelRenderer bone11;
    private final IAnimation animation;

    public Cauldron()
    {
        super(ItemType.BODY);
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.Project = new MModelRenderer(this);
        this.bag = new MModelRenderer(this);
        this.Project.addChild(this.bag);
        this.bag.cubeList.add(new ModelBox(this.bag, 16, 58, -9.0F, -25.0F, -3.0F, 2, 9, 1, 0.0F, false));
        this.bag.cubeList.add(new ModelBox(this.bag, 22, 58, 7.0F, -25.0F, -3.0F, 2, 9, 1, 0.0F, false));
        this.bag.cubeList.add(new ModelBox(this.bag, 54, 54, 7.01F, -15.6F, -1.6F, 2, 1, 6, 0.0F, false));
        this.bag.cubeList.add(new ModelBox(this.bag, 58, 12, -9.01F, -15.6F, -1.6F, 2, 1, 6, 0.0F, false));
        this.bag.cubeList.add(new ModelBox(this.bag, 0, 25, 7.02F, -24.61F, 4.0F, 2, 10, 3, 0.0F, false));
        this.bag.cubeList.add(new ModelBox(this.bag, 16, 40, -9.0F, -25.0F, -2.0F, 2, 1, 9, 0.0F, false));
        this.bag.cubeList.add(new ModelBox(this.bag, 42, 4, 7.0F, -25.0F, -2.0F, 2, 1, 9, 0.0F, false));
        this.bag.cubeList.add(new ModelBox(this.bag, 0, 0, -9.02F, -24.61F, 4.0F, 2, 10, 3, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(5.0F, -0.2513F, -0.7782F);
        this.setRotation(this.bone, 0.7854F, 0.0F, 0.0F);
        this.bag.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 42, 0, -12.0F, 9.0F, 21.0F, 14, 2, 2, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(8.0F, -16.0F, -2.2929F);
        this.setRotation(this.bone2, -0.7854F, 0.0F, 0.0F);
        this.bag.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 50, 61, -1.0F, -0.5F, -0.5F, 2, 1, 2, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(8.0F, -16.0F, -2.2929F);
        this.setRotation(this.bone3, -0.7854F, 0.0F, 0.0F);
        this.bag.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 44, 60, -17.0F, -0.5F, -0.5F, 2, 1, 2, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(7.99F, -24.7913F, 6.4992F);
        this.setRotation(this.bone4, 0.7854F, 0.0F, 0.0F);
        this.bag.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 0, 58, -16.98F, 0.2066F, -1.4983F, 2, 23, 2, 0.0F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(8.01F, -24.7913F, 6.4992F);
        this.setRotation(this.bone5, 0.7854F, 0.0F, 0.0F);
        this.bag.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 8, 58, -1.02F, 0.2066F, -1.4983F, 2, 23, 2, 0.0F, false));
        this.Caudron = new MModelRenderer(this);
        this.Project.addChild(this.Caudron);
        this.jija = new MModelRenderer(this);
        this.jija.setRotationPoint(0.0F, -18.0F, 15.1F);
        this.Caudron.addChild(this.jija);
        this.jija.cubeList.add(new ModelBox(this.jija, 39, 27, -6.5F, -1.0F, -6.5F, 13, 2, 13, 0.0F, false));
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(0.0F, -9.5F, 14.0F);
        this.setRotation(this.bone9, -0.1745F, 0.0F, 0.0F);
        this.Caudron.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 0, 0, -7.0F, -5.5F, -7.0F, 14, 11, 14, 0.0F, false));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(0.0F, -16.0F, 13.9F);
        this.setRotation(this.bone8, -0.1745F, 0.0F, 0.0F);
        this.Caudron.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 0, 25, -6.5F, -1.0F, -5.3F, 13, 2, 13, 0.0F, false));
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(0.0F, -19.0F, 14.0F);
        this.setRotation(this.bone7, -0.1745F, 0.0F, 0.0F);
        this.Caudron.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 30, 42, -7.0F, -2.0F, -5.4F, 1, 4, 14, 0.0F, false));
        this.bone7.cubeList.add(new ModelBox(this.bone7, 0, 40, 6.0F, -2.0F, -5.4F, 1, 4, 14, 0.0F, false));
        this.bone7.cubeList.add(new ModelBox(this.bone7, 46, 42, -6.0F, -2.0F, -5.4F, 12, 4, 1, 0.0F, false));
        this.bone7.cubeList.add(new ModelBox(this.bone7, 46, 47, -6.0F, -2.0F, 7.6F, 12, 4, 1, 0.0F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(0.0F, -9.5F, 14.0F);
        this.setRotation(this.bone6, -0.1745F, 0.0F, 0.0F);
        this.Caudron.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 10, 5, 5.4F, 7.5F, -6.3F, 1, 1, 1, 0.0F, false));
        this.bone6.cubeList.add(new ModelBox(this.bone6, 10, 7, -6.4F, 7.5F, -6.4F, 1, 1, 1, 0.0F, false));
        this.bone6.cubeList.add(new ModelBox(this.bone6, 10, 3, 5.3F, 7.5F, 5.4F, 1, 1, 1, 0.0F, false));
        this.bone6.cubeList.add(new ModelBox(this.bone6, 10, 9, -6.4F, 7.5F, 5.4F, 1, 1, 1, 0.0F, false));
        this.bone6.cubeList.add(new ModelBox(this.bone6, 0, 44, 4.0F, 5.5F, 4.0F, 3, 1, 3, 0.0F, false));
        this.bone6.cubeList.add(new ModelBox(this.bone6, 0, 48, -7.0F, 5.5F, 4.0F, 3, 1, 3, 0.0F, false));
        this.bone6.cubeList.add(new ModelBox(this.bone6, 42, 63, 4.7F, 6.5F, -6.7F, 2, 1, 2, 0.0F, false));
        this.bone6.cubeList.add(new ModelBox(this.bone6, 28, 64, -6.7F, 6.5F, -6.7F, 2, 1, 2, 0.0F, false));
        this.bone6.cubeList.add(new ModelBox(this.bone6, 34, 63, 4.7F, 6.5F, 4.7F, 2, 1, 2, 0.0F, false));
        this.bone6.cubeList.add(new ModelBox(this.bone6, 48, 64, -6.7F, 6.5F, 4.7F, 2, 1, 2, 0.0F, false));
        this.bone6.cubeList.add(new ModelBox(this.bone6, 29, 44, 4.0F, 5.5F, -7.0F, 3, 1, 3, 0.0F, false));
        this.bone6.cubeList.add(new ModelBox(this.bone6, 16, 50, -7.0F, 5.5F, -7.0F, 3, 1, 3, 0.0F, false));
        this.bubble1 = new MModelRenderer(this);
        this.bubble1.setRotationPoint(1.0F, -21.0F, 12.0F);
        this.Project.addChild(this.bubble1);
        this.bubble1.cubeList.add(new ModelBox(this.bubble1, 28, 60, -1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F, false));
        this.bubble2 = new MModelRenderer(this);
        this.bubble2.setRotationPoint(-2.0F, -22.0F, 18.0F);
        this.Project.addChild(this.bubble2);
        this.bubble2.cubeList.add(new ModelBox(this.bubble2, 35, 52, -1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F, false));
        this.bubble3 = new MModelRenderer(this);
        this.bubble3.setRotationPoint(3.5F, -22.5F, 17.5F);
        this.Project.addChild(this.bubble3);
        this.bubble3.cubeList.add(new ModelBox(this.bubble3, 39, 31, -1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F, false));
        this.bubble4 = new MModelRenderer(this);
        this.bubble4.setRotationPoint(-2.0F, -27.0F, 18.0F);
        this.Project.addChild(this.bubble4);
        this.bubble4.cubeList.add(new ModelBox(this.bubble4, 36, 48, -1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F, false));
        this.bubble5 = new MModelRenderer(this);
        this.bubble5.setRotationPoint(-2.0F, -25.0F, 18.0F);
        this.Project.addChild(this.bubble5);
        this.bubble5.cubeList.add(new ModelBox(this.bubble5, 16, 44, -1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F, false));
        this.bubble6 = new MModelRenderer(this);
        this.bubble6.setRotationPoint(-2.0F, -25.0F, 18.0F);
        this.Project.addChild(this.bubble6);
        this.bubble6.cubeList.add(new ModelBox(this.bubble6, 42, 8, -1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F, false));
        this.bubble7 = new MModelRenderer(this);
        this.bubble7.setRotationPoint(3.5F, -22.5F, 17.5F);
        this.Project.addChild(this.bubble7);
        this.bubble7.cubeList.add(new ModelBox(this.bubble7, 39, 25, -1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F, false));
        this.bubble8 = new MModelRenderer(this);
        this.bubble8.setRotationPoint(-2.0F, -25.0F, 18.0F);
        this.Project.addChild(this.bubble8);
        this.bubble8.cubeList.add(new ModelBox(this.bubble8, 42, 4, -1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F, false));
        this.bubble9 = new MModelRenderer(this);
        this.bubble9.setRotationPoint(-2.0F, -25.0F, 18.0F);
        this.Project.addChild(this.bubble9);
        this.bubble9.cubeList.add(new ModelBox(this.bubble9, 16, 40, -1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F, false));
        this.Eye = new MModelRenderer(this);
        this.Eye.setRotationPoint(-2.5F, -20.3698F, 30.2421F);
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(3.5F, 20.75F, -31.5F);
        this.setRotation(this.bone11, -0.1745F, 0.0F, 0.0F);
        this.Eye.addChild(this.bone11);
        this.bone11.cubeList.add(new ModelBox(this.bone11, 78, 34, -6.0F, -27.0F, 25.0F, 5, 1, 5, 0.0F, false));
        this.bone11.cubeList.add(new ModelBox(this.bone11, 75, 0, -8.0F, -26.0F, 23.0F, 9, 2, 9, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "body/cauldron.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "body/cauldron_animation.json"));
        this.animation = bbanimationloader.mustGet("jija", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        this.animation.tick(time);
        double d0 = 0.5D;
        GlStateManager.translate(0.0D, 0.75D, -0.075D);
        GlStateManager.scale(d0, d0, d0);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0D, 0.5D, 0.0D);
        double d0 = 0.5D;
        GlStateManager.scale(d0, d0, d0);
        this.animation.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041a\u043e\u0442\u0451\u043b";
    }

    public String getCreator()
    {
        return "Sir_Kelt";
    }
}
