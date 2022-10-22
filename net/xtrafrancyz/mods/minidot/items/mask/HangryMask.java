package net.xtrafrancyz.mods.minidot.items.mask;

import java.util.List;
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
import net.xtrafrancyz.mods.minidot.util.MNaming;

public class HangryMask extends BaseItem
{
    private final MModelRenderer Hangry_mask;
    private final MModelRenderer ears;
    private final MModelRenderer ear1;
    private final MModelRenderer bone;
    private final MModelRenderer ear2;
    private final MModelRenderer bone2;
    private final MModelRenderer bone5;
    private final MModelRenderer bone6;
    private final MModelRenderer bone4;
    private final MModelRenderer bone3;
    private final IAnimation animation;

    public HangryMask()
    {
        super(ItemType.MASK);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.Hangry_mask = new MModelRenderer(this);
        this.Hangry_mask.cubeList.add(new ModelBox(this.Hangry_mask, 0, 0, -4.0F, -9.0F, 0.0F, 8, 9, 1, 0.0F, false));
        this.Hangry_mask.cubeList.add(new ModelBox(this.Hangry_mask, 8, 14, -1.5F, -4.75F, -1.0F, 3, 2, 1, 0.0F, false));
        this.Hangry_mask.cubeList.add(new ModelBox(this.Hangry_mask, 0, 10, -2.0F, -4.5F, -2.0F, 4, 2, 1, 0.0F, false));
        this.Hangry_mask.cubeList.add(new ModelBox(this.Hangry_mask, 16, 14, -1.5F, -5.25F, -2.0F, 3, 1, 1, 0.0F, false));
        this.Hangry_mask.cubeList.add(new ModelBox(this.Hangry_mask, 0, 17, -5.0F, -6.0F, 0.0F, 1, 5, 1, 0.0F, false));
        this.Hangry_mask.cubeList.add(new ModelBox(this.Hangry_mask, 15, 16, 4.0F, -6.0F, 0.0F, 1, 5, 1, 0.0F, false));
        this.ears = new MModelRenderer(this);
        this.Hangry_mask.addChild(this.ears);
        this.ear1 = new MModelRenderer(this);
        this.ear1.setRotationPoint(2.75F, -8.0F, 0.55F);
        this.setRotation(this.ear1, 0.4401F, 0.025F, 0.4176F);
        this.ears.addChild(this.ear1);
        this.ear1.cubeList.add(new ModelBox(this.ear1, 0, 13, -1.5F, -3.0F, -0.5F, 3, 3, 1, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(-0.5F, -2.6F, 0.1F);
        this.setRotation(this.bone, 1.0036F, 0.0F, 0.0F);
        this.ear1.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 18, 3, -0.5F, -2.0F, -0.5F, 2, 2, 1, 0.0F, false));
        this.ear2 = new MModelRenderer(this);
        this.ear2.setRotationPoint(-2.75F, -8.0F, 0.55F);
        this.setRotation(this.ear2, 0.4401F, -0.025F, -0.4176F);
        this.ears.addChild(this.ear2);
        this.ear2.cubeList.add(new ModelBox(this.ear2, 10, 10, -1.5F, -3.0F, -0.5F, 3, 3, 1, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.5F, -2.6F, 0.1F);
        this.setRotation(this.bone2, 1.0036F, 0.0F, 0.0F);
        this.ear2.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 4, 17, -1.5F, -2.0F, -0.5F, 2, 2, 1, 0.0F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(2.0F, -6.25F, -0.25F);
        this.Hangry_mask.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 19, 7, -1.0F, -1.0F, 0.0F, 2, 2, 0, 0.4F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(-2.0F, -6.25F, -0.25F);
        this.Hangry_mask.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 26, 2, -1.0F, -1.0F, 0.0F, 2, 2, 0, 0.4F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(-2.0F, -6.25F, -0.7F);
        this.Hangry_mask.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 24, 6, -1.5F, -1.5F, 0.0F, 3, 3, 0, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(1.85F, -6.15F, -0.6F);
        this.Hangry_mask.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 20, 11, -0.5F, -0.45F, 0.05F, 1, 1, 0, 0.2F, false));
        super.setTexture(new ResourceLocation("minidot", "masks/hangrymask.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "masks/hangrymask_animation.json"));
        this.animation = bbanimationloader.mustGet("hangry", this);
    }

    public void renderAsItem(float time)
    {
        this.animation.tick(time);
        GlStateManager.translate(0.0D, 0.2D, -0.1D);
        double d0 = 0.75D;
        GlStateManager.scale(d0, d0, d0);
        super.renderAsItem(time);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        this.animation.tick(time);
        GlStateManager.translate(0.0D, 0.0D, -0.3D);
    }

    public String getName()
    {
        return "\u041c\u0430\u0441\u043a\u0430 \u0425\u044d\u043d\u0433\u0440\u0438";
    }

    public String getCreator()
    {
        return "xRolaaan";
    }

    public List<String> getDescription()
    {
        return MNaming.fromGame("Dark Deception");
    }
}
