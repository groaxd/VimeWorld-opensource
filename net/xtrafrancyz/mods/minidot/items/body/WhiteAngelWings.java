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

public class WhiteAngelWings extends BaseItem
{
    private final MModelRenderer bb_main;
    private final MModelRenderer wingleft;
    private final MModelRenderer left;
    private final MModelRenderer wingright;
    private final MModelRenderer right;
    private final IAnimation animation;

    public WhiteAngelWings()
    {
        super(ItemType.BODY);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.bb_main = new MModelRenderer(this);
        this.bb_main.cubeList.add(new ModelBox(this.bb_main, 24, 0, -2.5F, -22.0F, 2.0F, 5, 3, 2, 0.0F, false));
        this.wingleft = new MModelRenderer(this);
        this.wingleft.setRotationPoint(0.0F, -21.0F, 2.0F);
        this.setRotation(this.wingleft, 0.3927F, 1.0472F, 0.0F);
        this.wingleft.cubeList.add(new ModelBox(this.wingleft, 24, 5, 0.0F, -0.4239F, 1.8827F, 1, 2, 10, 0.0F, false));
        this.wingleft.cubeList.add(new ModelBox(this.wingleft, 0, -12, 0.5F, -2.4239F, -0.1173F, 0, 12, 12, 0.0F, false));
        this.left = new MModelRenderer(this);
        this.left.setRotationPoint(0.5F, 10.5F, 6.0F);
        this.setRotation(this.left, 0.0F, 0.0F, 0.2182F);
        this.wingleft.addChild(this.left);
        this.left.cubeList.add(new ModelBox(this.left, 0, 0, -0.2F, -2.902F, -6.1173F, 0, 10, 12, 0.0F, false));
        this.wingright = new MModelRenderer(this);
        this.wingright.setRotationPoint(0.0F, -21.0F, 2.0F);
        this.setRotation(this.wingright, 0.3927F, -1.0472F, 0.0F);
        this.wingright.cubeList.add(new ModelBox(this.wingright, 24, 17, -1.0F, -0.4239F, 1.8827F, 1, 2, 10, 0.0F, false));
        this.wingright.cubeList.add(new ModelBox(this.wingright, 0, 10, -0.5F, -2.4239F, -0.1173F, 0, 12, 12, 0.0F, false));
        this.right = new MModelRenderer(this);
        this.right.setRotationPoint(-0.5F, 10.5F, 6.0F);
        this.setRotation(this.right, 0.0F, 0.0F, -0.2182F);
        this.wingright.addChild(this.right);
        this.right.cubeList.add(new ModelBox(this.right, 0, 22, 0.2F, -2.902F, -6.1173F, 0, 10, 12, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "body/whiteangelwings.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "body/whiteangelwings_animation.json"));
        this.animation = bbanimationloader.mustGet("whiteangelwings.animation", this);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        this.animation.tick(time);
        GlStateManager.translate(0.0D, 0.75D, 0.1312D);
        double d0 = 0.7394D;
        GlStateManager.scale(d0, d0, d0);
        super.renderAsItem(time);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, 1.52F, 0.0F);
        this.animation.tick(time);
    }

    public String getName()
    {
        return "\u0411\u0435\u043b\u043e\u0441\u043d\u0435\u0436\u043d\u044b\u0435 \u043a\u0440\u044b\u043b\u044c\u044f \u0430\u043d\u0433\u0435\u043b\u0430";
    }

    public String getCreator()
    {
        return "7keyz";
    }
}
