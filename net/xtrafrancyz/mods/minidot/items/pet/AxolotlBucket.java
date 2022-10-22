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

public class AxolotlBucket extends BasePet
{
    private final MModelRenderer telo;
    private final MModelRenderer hand;
    private final MModelRenderer hand1;
    private final MModelRenderer hand2;
    private final MModelRenderer vedro;
    private final MModelRenderer head;
    private final MModelRenderer water;
    private final IAnimation animation;

    public AxolotlBucket()
    {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.telo = new MModelRenderer(this);
        this.telo.setRotationPoint(2.5F, 0.0F, 0.0F);
        this.setRotation(this.telo, 0.0F, 0.0F, -0.2182F);
        this.telo.cubeList.add(new ModelBox(this.telo, 0, 36, -2.0F, -17.75F, -2.5F, 4, 13, 6, 0.001F, false));
        this.telo.cubeList.add(new ModelBox(this.telo, 0, 0, 0.75F, -19.0F, 0.5F, 2, 8, 0, 0.0F, false));
        this.hand = new MModelRenderer(this);
        this.hand.setRotationPoint(1.5F, -0.5F, 0.0F);
        this.hand.cubeList.add(new ModelBox(this.hand, 0, 13, -7.5F, -14.25F, 2.0F, 4, 0, 1, 0.001F, false));
        this.hand.cubeList.add(new ModelBox(this.hand, 0, 8, -7.5F, -14.25F, -2.0F, 4, 0, 1, 0.001F, false));
        this.hand1 = new MModelRenderer(this);
        this.hand1.setRotationPoint(-1.5F, -4.5F, 0.0F);
        this.hand.addChild(this.hand1);
        this.hand1.cubeList.add(new ModelBox(this.hand1, 3, 1, -8.0F, -9.75F, -2.0F, 2, 0, 1, 0.001F, false));
        this.hand1.cubeList.add(new ModelBox(this.hand1, 2, 15, -7.0F, -9.75F, -1.0F, 1, 0, 1, 0.001F, false));
        this.hand1.cubeList.add(new ModelBox(this.hand1, 0, 15, -7.0F, -9.75F, -3.0F, 1, 0, 1, 0.001F, false));
        this.hand2 = new MModelRenderer(this);
        this.hand2.setRotationPoint(-9.5F, 1.5F, 0.0F);
        this.hand.addChild(this.hand2);
        this.hand2.cubeList.add(new ModelBox(this.hand2, 6, 15, 1.0F, -15.75F, 1.0F, 1, 0, 1, 0.001F, false));
        this.hand2.cubeList.add(new ModelBox(this.hand2, 4, 15, 1.0F, -15.75F, 3.0F, 1, 0, 1, 0.001F, false));
        this.hand2.cubeList.add(new ModelBox(this.hand2, 3, 0, 0.0F, -15.75F, 2.0F, 2, 0, 1, 0.001F, false));
        this.vedro = new MModelRenderer(this);
        this.vedro.cubeList.add(new ModelBox(this.vedro, 0, 13, -4.5F, -4.75F, -4.0F, 9, 1, 9, 0.0F, false));
        this.vedro.cubeList.add(new ModelBox(this.vedro, 21, 27, -4.5F, -12.75F, -4.0F, 1, 8, 9, 0.001F, false));
        this.vedro.cubeList.add(new ModelBox(this.vedro, 27, 4, 3.5F, -12.75F, -4.0F, 1, 8, 9, 0.001F, false));
        this.vedro.cubeList.add(new ModelBox(this.vedro, 43, 32, -3.5F, -12.75F, 4.0F, 7, 8, 1, 0.001F, false));
        this.vedro.cubeList.add(new ModelBox(this.vedro, 43, 21, -3.5F, -12.75F, -4.0F, 7, 8, 1, 0.001F, false));
        this.vedro.cubeList.add(new ModelBox(this.vedro, 38, 4, -6.0F, -14.75F, 4.5F, 12, 2, 2, 0.001F, false));
        this.vedro.cubeList.add(new ModelBox(this.vedro, 25, 0, -6.0F, -14.75F, -5.5F, 12, 2, 2, 0.001F, false));
        this.vedro.cubeList.add(new ModelBox(this.vedro, 30, 35, -6.0F, -14.75F, -4.0F, 2, 2, 9, 0.0F, false));
        this.vedro.cubeList.add(new ModelBox(this.vedro, 30, 21, 4.0F, -14.75F, -4.0F, 2, 2, 9, 0.0F, false));
        this.head = new MModelRenderer(this);
        this.head.cubeList.add(new ModelBox(this.head, 0, 23, -6.0F, -21.0F, -3.5F, 6, 5, 8, 0.0F, false));
        this.head.cubeList.add(new ModelBox(this.head, 4, 18, -1.0F, -24.0F, 3.0F, 0, 1, 1, 0.0F, false));
        this.head.cubeList.add(new ModelBox(this.head, 4, 12, -1.0F, -22.0F, -2.0F, 0, 1, 2, 0.0F, false));
        this.head.cubeList.add(new ModelBox(this.head, 6, 18, -1.0F, -24.0F, -3.0F, 0, 1, 1, 0.0F, false));
        this.head.cubeList.add(new ModelBox(this.head, 0, 12, -1.0F, -23.0F, -3.0F, 0, 1, 2, 0.0F, false));
        this.head.cubeList.add(new ModelBox(this.head, 4, 5, -1.0F, -22.0F, 1.0F, 0, 1, 2, 0.0F, false));
        this.head.cubeList.add(new ModelBox(this.head, 4, 4, -1.0F, -23.0F, 2.0F, 0, 1, 2, 0.0F, false));
        this.head.cubeList.add(new ModelBox(this.head, 6, 17, -1.0F, -19.0F, -6.5F, 0, 1, 1, 0.0F, false));
        this.head.cubeList.add(new ModelBox(this.head, 4, 2, -1.0F, -18.0F, -6.5F, 0, 1, 2, 0.0F, false));
        this.head.cubeList.add(new ModelBox(this.head, 4, 3, -1.0F, -17.0F, -5.5F, 0, 1, 2, 0.0F, false));
        this.head.cubeList.add(new ModelBox(this.head, 6, 15, -1.0F, -23.0F, -6.5F, 0, 2, 1, 0.0F, false));
        this.head.cubeList.add(new ModelBox(this.head, 0, 17, -1.0F, -22.0F, -5.5F, 0, 2, 1, 0.0F, false));
        this.head.cubeList.add(new ModelBox(this.head, 2, 17, -1.0F, -21.0F, -4.5F, 0, 2, 1, 0.0F, false));
        this.head.cubeList.add(new ModelBox(this.head, 4, 17, -1.0F, -19.0F, 6.5F, 0, 1, 1, 0.0F, false));
        this.head.cubeList.add(new ModelBox(this.head, 4, 0, -1.0F, -18.0F, 5.5F, 0, 1, 2, 0.0F, false));
        this.head.cubeList.add(new ModelBox(this.head, 4, 1, -1.0F, -17.0F, 4.5F, 0, 1, 2, 0.0F, false));
        this.head.cubeList.add(new ModelBox(this.head, 0, 15, -1.0F, -23.0F, 6.5F, 0, 2, 1, 0.0F, false));
        this.head.cubeList.add(new ModelBox(this.head, 2, 15, -1.0F, -22.0F, 5.5F, 0, 2, 1, 0.0F, false));
        this.head.cubeList.add(new ModelBox(this.head, 4, 15, -1.0F, -21.0F, 4.5F, 0, 2, 1, 0.0F, false));
        this.water = new MModelRenderer(this);
        this.water.cubeList.add(new ModelBox(this.water, 0, 0, -4.0F, -13.0F, -4.0F, 8, 4, 9, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/axolotlbucket.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/axolotlbucket_animation.json"));
        this.animation = bbanimationloader.mustGet("animation.model.new3", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.translate(0.7D, 0.0D, 0.3D);
        double d0 = (double)MathHelper.sin(time * 0.1F) * 0.03D;
        GlStateManager.translate(0.0D, d0, 0.0D);
        GlStateManager.rotate(90.0F, 0.0F, -1.0F, 0.0F);
        this.animation.tick(time);
        super.preRender(modelPlayer, player, time, pi);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0D, 0.4D, 0.0D);
        this.animation.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0410\u043a\u0441\u043e\u043b\u043e\u0442\u043b\u044c \u0432 \u0432\u0435\u0434\u0440\u0435";
    }

    public String getCreator()
    {
        return "Florina";
    }
}
