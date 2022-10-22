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

public class RaccoonPet extends BasePet
{
    private final MModelRenderer bb_main;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final MModelRenderer bone6;
    private final MModelRenderer bone7;
    private final IAnimation animation;

    public RaccoonPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.bb_main = new MModelRenderer(this);
        this.bb_main.cubeList.add(new ModelBox(this.bb_main, 0, 0, -6.5F, -9.0F, -6.0F, 13, 9, 16, 0.0F, false));
        this.bb_main.cubeList.add(new ModelBox(this.bb_main, 19, 25, -4.5F, -2.75F, -9.5F, 9, 2, 3, 0.0F, false));
        this.bb_main.cubeList.add(new ModelBox(this.bb_main, 19, 30, -3.5F, -6.25F, -9.0F, 7, 3, 3, 0.0F, false));
        this.bb_main.cubeList.add(new ModelBox(this.bb_main, 0, 48, -2.0F, -3.25F, -11.5F, 4, 2, 2, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(4.5F, 0.0F, -6.75F);
        this.setRotation(this.bone, 0.0F, 0.7854F, 0.0F);
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 9, 1.0F, -1.0F, 1.25F, 1, 1, 1, 0.3F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-6.0F, -1.0F, -7.0F);
        this.setRotation(this.bone2, 0.0F, 0.7854F, 0.0F);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 7, 8, -1.5F, 0.0F, -0.6F, 1, 1, 1, 0.3F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(-6.1F, -1.0F, 9.75F);
        this.setRotation(this.bone3, 0.0F, 0.7854F, 0.0F);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 4, 7, -1.2738F, 0.0F, -0.599F, 1, 1, 1, 0.3F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(7.1F, -1.0F, 7.35F);
        this.setRotation(this.bone4, 0.0F, 0.7854F, 0.0F);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 0, 7, -2.7284F, 0.0F, 1.2784F, 1, 1, 1, 0.3F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(0.0F, -1.75F, 10.5F);
        this.setRotation(this.bone5, 0.0F, -0.829F, 0.0F);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 0, 48, -1.5F, -2.35F, -3.0F, 4, 4, 12, 0.0F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(-1.5F, -4.5F, -7.5F);
        this.setRotation(this.bone6, 0.0F, 0.0F, 0.7854F);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 6, 3, -2.7213F, -1.2929F, -0.5F, 2, 3, 1, 0.0F, false));
        this.bone6.cubeList.add(new ModelBox(this.bone6, 3, 0, -3.7213F, -1.2929F, -0.5F, 1, 3, 0, 0.0F, false));
        this.bone6.cubeList.add(new ModelBox(this.bone6, 4, 1, -4.7F, -0.7929F, -0.5F, 1, 2, 0, 0.0F, false));
        this.bone6.cubeList.add(new ModelBox(this.bone6, 2, 2, -5.7F, -0.2929F, -0.5F, 1, 1, 0, 0.0F, false));
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(1.35F, -4.5F, -7.5F);
        this.setRotation(this.bone7, 0.0F, 0.0F, 2.3562F);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 0, 3, -2.7872F, -1.7306F, -0.5F, 2, 3, 1, 0.0F, false));
        this.bone7.cubeList.add(new ModelBox(this.bone7, 3, 0, -3.7872F, -1.7306F, -0.5F, 1, 3, 0, 0.0F, false));
        this.bone7.cubeList.add(new ModelBox(this.bone7, 3, 1, -4.75F, -1.2306F, -0.5F, 1, 2, 0, 0.0F, false));
        this.bone7.cubeList.add(new ModelBox(this.bone7, 2, 2, -5.75F, -0.7306F, -0.5F, 1, 1, 0, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/raccoon.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/raccoon_animation.json"));
        this.animation = bbanimationloader.mustGet("raccoon.floating", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.translate(0.7D, -0.15D, 0.3D);
        double d0 = (double)MathHelper.sin(time * 0.1F) * 0.03D;
        GlStateManager.translate(0.0D, d0, 0.0D);
        this.animation.tick(time);
        super.preRender(modelPlayer, player, time, pi);
        double d1 = 0.9D;
        GlStateManager.scale(d1, d1, d1);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0D, 0.2D, 0.0D);
        GlStateManager.scale(0.9D, 0.9D, 0.9D);
        this.animation.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0415\u043d\u043e\u0442\u0438\u043a";
    }

    public String getCreator()
    {
        return "arteditm";
    }
}
