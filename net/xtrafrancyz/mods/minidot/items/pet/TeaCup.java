package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class TeaCup extends BasePet
{
    private final MModelRenderer Tea_Cup;
    private final MModelRenderer Cup;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;

    public TeaCup()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Tea_Cup = new MModelRenderer(this);
        this.Tea_Cup.setRotationPoint(0.0F, 26.0F, 0.0F);
        this.Tea_Cup.cubeList.add(new ModelBox(this.Tea_Cup, 0, 0, -4.0F, -3.0F, -4.0F, 8, 1, 8, 0.0F));
        this.Tea_Cup.cubeList.add(new ModelBox(this.Tea_Cup, 10, 10, 4.0F, -3.75F, -4.0F, 1, 1, 8, 0.0F));
        this.Tea_Cup.cubeList.add(new ModelBox(this.Tea_Cup, 0, 9, -5.0F, -3.75F, -4.0F, 1, 1, 8, 0.0F));
        this.Tea_Cup.cubeList.add(new ModelBox(this.Tea_Cup, 20, 16, -4.0F, -3.75F, -5.0F, 8, 1, 1, 0.0F));
        this.Tea_Cup.cubeList.add(new ModelBox(this.Tea_Cup, 20, 14, -4.0F, -3.75F, 4.0F, 8, 1, 1, 0.0F));
        this.Cup = new MModelRenderer(this);
        this.Cup.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Tea_Cup.addChild(this.Cup);
        this.Cup.cubeList.add(new ModelBox(this.Cup, 20, 9, -2.0F, -4.0F, -2.0F, 4, 1, 4, 0.0F));
        this.Cup.cubeList.add(new ModelBox(this.Cup, 0, 0, -1.0F, -5.0F, -1.0F, 2, 1, 2, 0.0F));
        this.Cup.cubeList.add(new ModelBox(this.Cup, 9, 29, -1.5F, -5.75F, -1.5F, 3, 1, 3, 0.0F));
        this.Cup.cubeList.add(new ModelBox(this.Cup, 15, 20, -2.5F, -6.25F, -2.5F, 5, 1, 5, 0.0F));
        this.Cup.cubeList.add(new ModelBox(this.Cup, 0, 19, -2.5F, -7.75F, -2.5F, 5, 1, 5, 0.0F));
        this.Cup.cubeList.add(new ModelBox(this.Cup, 21, 26, -3.0F, -8.25F, -3.5F, 6, 2, 1, 0.0F));
        this.Cup.cubeList.add(new ModelBox(this.Cup, 7, 26, -3.0F, -8.25F, 2.5F, 6, 2, 1, 0.0F));
        this.Cup.cubeList.add(new ModelBox(this.Cup, 0, 25, 2.5F, -8.25F, -2.5F, 1, 2, 5, 0.0F));
        this.Cup.cubeList.add(new ModelBox(this.Cup, 24, 0, -3.5F, -8.25F, -2.5F, 1, 2, 5, 0.0F));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(4.25F, -7.0F, 0.5F);
        this.Cup.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 5, -0.201F, -2.5385F, -1.0F, 2, 1, 1, 0.0F));
        this.bone.cubeList.add(new ModelBox(this.bone, 4, 9, 1.4418F, -1.7724F, -1.0F, 1, 2, 1, 0.0F));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 3, -0.201F, -0.0064F, -1.0F, 2, 1, 1, 0.0F));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-0.75F, -0.45F, 0.0F);
        this.bone.addChild(this.bone2);
        this.setRotation(this.bone2, 0.0F, 0.0F, 0.829F);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 10, 10, -1.1689F, -1.8157F, -1.0F, 1, 2, 1, 0.0F));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(2.25F, -0.45F, 0.0F);
        this.bone.addChild(this.bone3);
        this.setRotation(this.bone3, 0.0F, 0.0F, -((float)Math.PI * 2F / 9F));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 4, 12, -0.0031F, -1.8898F, -1.0F, 1, 1, 1, 0.0F));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(2.25F, -1.55F, 0.0F);
        this.bone.addChild(this.bone4);
        this.setRotation(this.bone4, 0.0F, 0.0F, ((float)Math.PI * 2F / 9F));
        this.bone4.cubeList.add(new ModelBox(this.bone4, 0, 12, 0.2895F, 1.2385F, -1.0F, 1, 1, 1, 0.0F));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(-0.75F, -1.55F, 0.0F);
        this.bone.addChild(this.bone5);
        this.setRotation(this.bone5, 0.0F, 0.0F, -0.9599F);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 0, 9, -1.7687F, -0.0913F, -1.0F, 1, 2, 1, 0.0F));
        this.setTexture(new ResourceLocation("minidot", "pets/teacup.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.04F;
        GlStateManager.translate(0.75F, -1.1F + f, 0.25F);
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
        GlStateManager.rotate(time * 1.5F, 0.0F, 1.0F, 0.0F);
        super.preRender(modelPlayer, player, time, pi);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(1.5F, 1.5F, 1.5F);
        GlStateManager.translate(0.0F, -0.7F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0427\u0430\u0448\u043a\u0430 \u0447\u0430\u044f";
    }

    public String getCreator()
    {
        return "xRolaaan";
    }
}
