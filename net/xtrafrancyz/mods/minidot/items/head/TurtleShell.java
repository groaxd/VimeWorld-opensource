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

public class TurtleShell extends BaseHelm
{
    private final MModelRenderer Helmet;
    private final MModelRenderer Bubbles2;
    private final MModelRenderer Bubbles;
    private final IAnimation animation;

    public TurtleShell()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Helmet = new MModelRenderer(this);
        this.Helmet.cubeList.add(new ModelBox(this.Helmet, 0, 0, -5.0F, -3.0F, -1.0F, 1, 3, 1, 0.0F, false));
        this.Helmet.cubeList.add(new ModelBox(this.Helmet, 0, 0, -5.0F, -9.0F, -5.0F, 10, 1, 10, 0.0F, false));
        this.Helmet.cubeList.add(new ModelBox(this.Helmet, 22, 11, -4.0F, -8.0F, -5.0F, 8, 4, 1, 0.0F, false));
        this.Helmet.cubeList.add(new ModelBox(this.Helmet, 18, 22, 4.0F, -8.0F, -5.0F, 1, 4, 4, 0.0F, false));
        this.Helmet.cubeList.add(new ModelBox(this.Helmet, 0, 11, -5.0F, -8.0F, -1.0F, 1, 5, 6, 0.0F, false));
        this.Helmet.cubeList.add(new ModelBox(this.Helmet, 0, 0, -5.0F, -8.0F, -5.0F, 1, 4, 4, 0.0F, false));
        this.Helmet.cubeList.add(new ModelBox(this.Helmet, 14, 11, 4.0F, -8.0F, -1.0F, 1, 5, 6, 0.0F, false));
        this.Helmet.cubeList.add(new ModelBox(this.Helmet, 0, 22, -4.0F, -8.0F, 4.0F, 8, 5, 1, 0.0F, false));
        this.Helmet.cubeList.add(new ModelBox(this.Helmet, 6, 0, 4.0F, -3.0F, -1.0F, 1, 3, 1, 0.0F, false));
        this.Bubbles2 = new MModelRenderer(this);
        this.Bubbles2.setRotationPoint(2.5F, -14.55F, -1.0F);
        this.Bubbles2.cubeList.add(new ModelBox(this.Bubbles2, 11, 14, -0.5F, 0.55F, 0.0F, 1, 1, 0, 0.0F, false));
        this.Bubbles2.cubeList.add(new ModelBox(this.Bubbles2, 9, 13, -1.5F, -0.45F, 0.0F, 1, 1, 0, 0.0F, false));
        this.Bubbles2.cubeList.add(new ModelBox(this.Bubbles2, 12, 14, 0.5F, -0.45F, 0.0F, 1, 1, 0, 0.0F, false));
        this.Bubbles2.cubeList.add(new ModelBox(this.Bubbles2, 10, 14, -0.5F, -1.45F, 0.0F, 1, 1, 0, 0.0F, false));
        this.Bubbles = new MModelRenderer(this);
        this.Bubbles.setRotationPoint(-2.0F, -12.0F, 1.0F);
        this.Bubbles.cubeList.add(new ModelBox(this.Bubbles, 12, 13, -1.0F, 1.0F, 0.0F, 2, 1, 0, 0.0F, false));
        this.Bubbles.cubeList.add(new ModelBox(this.Bubbles, 10, 13, -2.0F, -1.0F, 0.0F, 1, 2, 0, 0.0F, false));
        this.Bubbles.cubeList.add(new ModelBox(this.Bubbles, 13, 13, 1.0F, -1.0F, 0.0F, 1, 2, 0, 0.0F, false));
        this.Bubbles.cubeList.add(new ModelBox(this.Bubbles, 8, 13, -1.0F, -2.0F, 0.0F, 2, 1, 0, 0.0F, false));
        this.Bubbles.cubeList.add(new ModelBox(this.Bubbles, 16, 13, -1.0F, -1.0F, 0.0F, 1, 1, 0, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "head/turtleshell.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "head/turtleshell_animation.json"));
        this.animation = bbanimationloader.mustGet("turtleshell.animation", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        this.animation.tick(time);
    }

    public void renderAsItem(float time)
    {
        this.animation.tick(time);
        double d0 = 0.7D;
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
        return "\u0427\u0435\u0440\u0435\u043f\u0430\u0448\u0438\u0439 \u043f\u0430\u043d\u0446\u0438\u0440\u044c";
    }

    public String getCreator()
    {
        return "TheLiryk";
    }
}
