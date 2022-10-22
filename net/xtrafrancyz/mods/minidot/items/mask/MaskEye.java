package net.xtrafrancyz.mods.minidot.items.mask;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;
import net.xtrafrancyz.mods.minidot.items.head.BaseHelm;

public class MaskEye extends BaseHelm
{
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final MModelRenderer bone6;
    private final MModelRenderer bone8;
    private final MModelRenderer bone9;
    private final MModelRenderer bone7;
    private final MModelRenderer bone10;
    private final IAnimation anim;

    public MaskEye()
    {
        super(ItemType.MASK);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(4.0F, 0.0F, 0.0F);
        this.bone2 = new MModelRenderer(this);
        this.bone.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 0, -8.0F, -8.0F, -1.0F, 8, 8, 1, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(-2.0F, -5.1F, -0.9F);
        this.setRotation(this.bone3, 0.0F, 0.0F, 0.7854F);
        this.bone2.addChild(this.bone3);
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(-5.6F, -5.1F, -0.9F);
        this.bone2.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 0, 9, -0.4F, -0.9F, -0.5F, 4, 4, 1, 0.0F, false));
        this.bone4.cubeList.add(new ModelBox(this.bone4, 6, 14, 2.8F, -0.4F, -0.4F, 1, 3, 1, 0.0F, false));
        this.bone4.cubeList.add(new ModelBox(this.bone4, 6, 14, -0.6F, -0.4F, -0.4F, 1, 3, 1, 0.0F, true));
        this.bone4.cubeList.add(new ModelBox(this.bone4, 6, 18, 3.0F, 0.1F, -0.3F, 1, 2, 1, 0.0F, false));
        this.bone4.cubeList.add(new ModelBox(this.bone4, 6, 18, -0.8F, 0.1F, -0.3F, 1, 2, 1, 0.0F, true));
        this.bone5 = new MModelRenderer(this);
        this.bone2.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 10, 12, -6.5F, -2.0F, -1.6F, 5, 1, 1, 0.0F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.bone2.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 10, 10, -6.5F, -2.0F, -1.6F, 5, 1, 1, 0.0F, false));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(-1.5F, -1.0F, -1.6F);
        this.setRotation(this.bone8, ((float)Math.PI * 2F / 9F), 0.0F, 0.0F);
        this.bone2.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 10, 14, -4.5F, 0.0F, 0.0F, 4, 1, 1, 0.0F, false));
        this.bone8.cubeList.add(new ModelBox(this.bone8, 16, 14, -4.8F, 0.0366F, 0.1551F, 4, 1, 1, 0.0F, false));
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(-1.5F, -7.0F, -1.6F);
        this.setRotation(this.bone9, -((float)Math.PI * 2F / 9F), 0.0F, 0.0F);
        this.bone2.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 10, 16, -4.5F, -1.0F, 0.0F, 4, 1, 1, 0.0F, false));
        this.bone9.cubeList.add(new ModelBox(this.bone9, 16, 14, -4.8F, -1.1286F, 0.1532F, 4, 1, 1, 0.0F, false));
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(-4.0F, -6.0F, -1.6F);
        this.setRotation(this.bone7, 0.6109F, 0.0F, 0.0F);
        this.bone.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 0, 14, -1.5F, -1.0F, 0.0F, 3, 1, 0, 0.0F, false));
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(-4.0F, -2.0F, -1.6F);
        this.setRotation(this.bone10, -0.6109F, 0.0F, 0.0F);
        this.bone.addChild(this.bone10);
        this.bone10.cubeList.add(new ModelBox(this.bone10, 0, 15, -1.5F, 0.0F, 0.0F, 3, 1, 0, 0.0F, false));
        this.bone5.setDynamic(true);
        this.bone6.setDynamic(true);
        this.bone7.setDynamic(true);
        this.bone10.setDynamic(true);
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "masks/3d_eye_animation.json"));
        this.anim = bbanimationloader.mustGet("3d_eye", this);
        this.setTexture(new ResourceLocation("minidot", "masks/3d_eye.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, 0.0F, -0.245F);
        this.anim.tick(time);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.0F, -0.245F);
        this.anim.tick(time);
        super.renderAsItem(time);
    }

    public String getCreator()
    {
        return "chikon";
    }

    public String getName()
    {
        return "\u0413\u0438\u0433\u0430\u043d\u0442\u0441\u043a\u0438\u0439 \u0433\u043b\u0430\u0437";
    }
}
