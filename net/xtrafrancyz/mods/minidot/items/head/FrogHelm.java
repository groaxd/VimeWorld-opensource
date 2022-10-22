package net.xtrafrancyz.mods.minidot.items.head;

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

public class FrogHelm extends BaseHelm
{
    private final MModelRenderer Head;
    private final MModelRenderer Eye2;
    private final MModelRenderer bone;
    private final MModelRenderer Eye;
    private final MModelRenderer bone2;
    private final IAnimation animation;

    public FrogHelm()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Head = new MModelRenderer(this);
        this.Head.cubeList.add(new ModelBox(this.Head, 32, 0, -4.0F, -9.0F, -3.8F, 8, 1, 8, 0.0F, false));
        this.Head.cubeList.add(new ModelBox(this.Head, 0, 25, -5.0F, -9.0F, 4.2F, 10, 9, 1, 0.0F, false));
        this.Head.cubeList.add(new ModelBox(this.Head, 16, 8, 4.0F, -9.0F, -3.8F, 1, 9, 8, 0.0F, false));
        this.Head.cubeList.add(new ModelBox(this.Head, 0, 8, -5.0F, -9.0F, -3.8F, 1, 9, 8, 0.0F, false));
        this.Eye2 = new MModelRenderer(this);
        this.Eye2.setRotationPoint(-5.2F, -9.1F, 0.0F);
        this.setRotation(this.Eye2, -0.1319F, 0.1302F, -0.0134F);
        this.Eye2.cubeList.add(new ModelBox(this.Eye2, 23, 0, -1.5F, -1.9F, -2.8F, 3, 3, 3, -0.02F, false));
        this.Eye2.cubeList.add(new ModelBox(this.Eye2, 0, 2, -1.0F, -1.4F, -2.8F, 2, 2, 1, 0.15F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(4.8762F, 3.0843F, -4.6226F);
        this.Eye2.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 1, 10, -4.9262F, -4.4343F, 1.7226F, 1, 1, 1, 0.15F, false));
        this.Eye = new MModelRenderer(this);
        this.Eye.setRotationPoint(5.2F, -9.1F, 0.0F);
        this.setRotation(this.Eye, -0.1319F, -0.1302F, 0.0134F);
        this.Eye.cubeList.add(new ModelBox(this.Eye, 9, 8, -1.5F, -1.9F, -2.8F, 3, 3, 3, -0.02F, false));
        this.Eye.cubeList.add(new ModelBox(this.Eye, 0, 0, -1.0F, -1.4F, -2.8F, 2, 2, 1, 0.15F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-5.9738F, 2.8343F, 1.5774F);
        this.Eye.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 10, 5.9238F, -4.1843F, -4.4774F, 1, 1, 1, 0.15F, false));
        super.setTexture(new ResourceLocation("minidot", "head/froghelm.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "head/froghelm_animation.json"));
        this.animation = bbanimationloader.mustGet("animation.model.new", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        this.animation.tick(time);
        super.preRender(modelPlayer, player, time, pi);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.9D, 0.9D, 0.9D);
        this.animation.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041b\u044f\u0433\u0443\u0448\u0430\u0447\u044c\u044f \u0448\u043b\u044f\u043f\u0430";
    }

    public String getCreator()
    {
        return "TheLiryk";
    }
}
