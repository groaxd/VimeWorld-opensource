package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class BuilderHat extends BaseItem
{
    private final MModelRenderer bone;
    private final MModelRenderer bone6;
    private final MModelRenderer bone4;
    private final MModelRenderer bone7;
    private final MModelRenderer bone8;
    private final MModelRenderer bone5;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;

    public BuilderHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, 0.0F, -0.5F);
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 0, -4.5F, -9.0F, -5.75F, 9, 1, 11, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 4, -0.1955F, -9.0F, -7.2807F, 1, 1, 3, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 0, -0.8045F, -9.0F, -7.2807F, 1, 1, 3, 0.0F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(4.5F, -7.0F, 4.0F);
        this.bone.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 19, 22, -9.0F, 0.0F, 0.0F, 9, 1, 1, 0.0F, false));
        this.bone6.cubeList.add(new ModelBox(this.bone6, 0, 8, -0.75F, -1.0F, -1.0F, 1, 2, 1, 0.0F, false));
        this.bone6.cubeList.add(new ModelBox(this.bone6, 7, 7, -9.25F, -1.0F, -1.0F, 1, 2, 1, 0.0F, false));
        this.bone6.cubeList.add(new ModelBox(this.bone6, 19, 24, -8.0F, 1.0F, 0.0F, 7, 1, 1, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(4.5F, -9.0F, -4.75F);
        this.bone.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 0, 12, -8.0F, -2.0F, 1.25F, 7, 2, 8, 0.0F, false));
        this.bone4.cubeList.add(new ModelBox(this.bone4, 0, 22, -7.5F, -2.5F, 1.75F, 6, 1, 7, 0.0F, false));
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(-0.25F, 0.0F, 3.75F);
        this.setRotation(this.bone7, 0.0F, 0.0F, -0.5236F);
        this.bone4.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 5, 4, -1.0F, -2.0F, -1.0F, 1, 2, 1, 0.0F, false));
        this.bone7.cubeList.add(new ModelBox(this.bone7, 0, 16, -1.0F, -2.0F, 2.5F, 1, 2, 2, 0.0F, false));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(-8.75F, 0.0F, 3.75F);
        this.setRotation(this.bone8, 0.0F, 0.0F, 0.5236F);
        this.bone4.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 5, 0, 0.0F, -2.0F, -1.0F, 1, 2, 1, 0.0F, false));
        this.bone8.cubeList.add(new ModelBox(this.bone8, 0, 12, 0.0F, -2.0F, 2.5F, 1, 2, 2, 0.0F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(-4.0F, 0.0F, 0.75F);
        this.bone4.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 0, 22, -1.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F, false));
        this.bone5.cubeList.add(new ModelBox(this.bone5, 22, 12, -1.0F, -3.0F, 1.25F, 1, 1, 6, 0.0F, false));
        this.bone5.cubeList.add(new ModelBox(this.bone5, 4, 9, -1.0F, -2.65F, 0.45F, 1, 1, 1, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(4.5F, 0.0F, -6.0F);
        this.setRotation(this.bone2, 0.0F, -0.3927F, 0.0F);
        this.bone.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 29, 0, -3.9043F, -9.0F, 0.231F, 4, 1, 3, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(-4.5F, 0.0F, -6.0F);
        this.setRotation(this.bone3, 0.0F, 0.3927F, 0.0F);
        this.bone.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 26, 26, -0.0957F, -9.0F, 0.231F, 4, 1, 3, 0.0F, false));
        this.setTexture(new ResourceLocation("minidot", "head/builder_hat.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(1.01F, 1.01F, 1.01F);
        GlStateManager.translate(0.0F, 0.015F, 0.025F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.22F, 0.05F);
        GlStateManager.scale(0.9F, 0.9F, 0.9F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041a\u0430\u0441\u043a\u0430 \u0421\u0442\u0440\u043e\u0438\u0442\u0435\u043b\u044f";
    }

    public String getCreator()
    {
        return "xRolaaan";
    }
}
