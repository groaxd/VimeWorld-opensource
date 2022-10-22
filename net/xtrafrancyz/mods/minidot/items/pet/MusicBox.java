package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class MusicBox extends BasePet
{
    private final MModelRenderer MusicPower;
    private final MModelRenderer musicbox;
    private final MModelRenderer Notes;
    private final MModelRenderer bone2;
    private final MModelRenderer bone;
    private final MModelRenderer bone3;
    private final MModelRenderer musicDisks;
    private final IAnimation animation;

    public MusicBox()
    {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.MusicPower = new MModelRenderer(this);
        this.musicbox = new MModelRenderer(this);
        this.musicbox.setRotationPoint(0.5F, -11.5F, 0.5F);
        this.MusicPower.addChild(this.musicbox);
        this.musicbox.cubeList.add(new ModelBox(this.musicbox, 0, 0, -3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F, false));
        this.Notes = new MModelRenderer(this);
        this.musicbox.addChild(this.Notes);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.Notes.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 8, 21, -1.5F, -1.5F, 0.0F, 3, 3, 0, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.Notes.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 14, 21, -1.5F, -1.5F, 0.0F, 3, 3, 0, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.Notes.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 20, 21, -1.5F, -1.5F, 0.0F, 3, 3, 0, 0.0F, false));
        this.musicDisks = new MModelRenderer(this);
        this.musicDisks.setRotationPoint(0.25F, -11.5F, 0.0F);
        this.MusicPower.addChild(this.musicDisks);
        this.musicDisks.cubeList.add(new ModelBox(this.musicDisks, 0, 21, -1.75F, -10.5F, 0.5F, 4, 3, 0, 0.0F, false));
        this.musicDisks.cubeList.add(new ModelBox(this.musicDisks, 16, 18, -6.75F, -9.5F, 0.5F, 4, 3, 0, 0.0F, false));
        this.musicDisks.cubeList.add(new ModelBox(this.musicDisks, 0, 15, -6.75F, 6.5F, 0.5F, 4, 3, 0, 0.0F, false));
        this.musicDisks.cubeList.add(new ModelBox(this.musicDisks, 8, 12, 3.25F, 6.5F, 0.5F, 4, 3, 0, 0.0F, false));
        this.musicDisks.cubeList.add(new ModelBox(this.musicDisks, 0, 12, -1.75F, 7.5F, 0.5F, 4, 3, 0, 0.0F, false));
        this.musicDisks.cubeList.add(new ModelBox(this.musicDisks, 8, 18, 3.25F, -9.5F, 0.5F, 4, 3, 0, 0.0F, false));
        this.musicDisks.cubeList.add(new ModelBox(this.musicDisks, 18, 3, 6.25F, -5.5F, 0.5F, 4, 3, 0, 0.0F, false));
        this.musicDisks.cubeList.add(new ModelBox(this.musicDisks, 16, 12, -10.75F, -5.5F, 0.5F, 4, 3, 0, 0.0F, false));
        this.musicDisks.cubeList.add(new ModelBox(this.musicDisks, 0, 18, 6.25F, 2.5F, 0.5F, 4, 3, 0, 0.0F, false));
        this.musicDisks.cubeList.add(new ModelBox(this.musicDisks, 16, 15, -10.75F, 2.5F, 0.5F, 4, 3, 0, 0.0F, false));
        this.musicDisks.cubeList.add(new ModelBox(this.musicDisks, 18, 0, 7.25F, -1.5F, 0.5F, 4, 3, 0, 0.0F, false));
        this.musicDisks.cubeList.add(new ModelBox(this.musicDisks, 8, 15, -11.75F, -1.5F, 0.5F, 4, 3, 0, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/musicbox.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/musicbox_animation.json"));
        this.animation = bbanimationloader.mustGet("musicbox.animation", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        double d0 = Math.sin((double)(time * 0.05F)) * 0.10000000149011612D;
        GlStateManager.translate(1.35D, -0.126D + d0, 0.4D);
        this.animation.tick(time);
        GlStateManager.rotate(30.0F, -1.0F, 0.0F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        this.animation.tick(time);
        GlStateManager.translate(0.0D, 0.34650000000000003D, 0.0D);
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
        return "\u041c\u0443\u0437\u044b\u043a\u0430\u043b\u044c\u043d\u0430\u044f \u0448\u043a\u0430\u0442\u0443\u043b\u043a\u0430";
    }

    public String getCreator()
    {
        return "xRolaaan";
    }
}
