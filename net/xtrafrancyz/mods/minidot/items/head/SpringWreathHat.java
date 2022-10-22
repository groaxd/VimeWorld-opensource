package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class SpringWreathHat extends BaseItem
{
    private final MModelRenderer Wreath;
    private final MModelRenderer Green;
    private final MModelRenderer Flowers;
    private final MModelRenderer Flower1;
    private final MModelRenderer Part1;
    private final MModelRenderer Part2;
    private final MModelRenderer Flower2;
    private final MModelRenderer Part3;
    private final MModelRenderer Part4;
    private final MModelRenderer Flower3;
    private final MModelRenderer Part11;
    private final MModelRenderer Part12;
    private final MModelRenderer Flower4;
    private final MModelRenderer Part9;
    private final MModelRenderer Part10;
    private final MModelRenderer Flower5;
    private final MModelRenderer Part7;
    private final MModelRenderer Part8;
    private final MModelRenderer Flower6;
    private final MModelRenderer Part5;
    private final MModelRenderer Part6;

    public SpringWreathHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 32;
        this.textureHeight = 16;
        this.Wreath = new MModelRenderer(this);
        this.Wreath.setRotationPoint(0.0F, 17.5F, 0.0F);
        this.setRotation(this.Wreath, 0.1309F, 3.1416F, 0.0F);
        this.Green = new MModelRenderer(this);
        this.Green.setRotationPoint(-3.75F, 0.5F, 0.5F);
        this.Wreath.addChild(this.Green);
        this.Green.setTextureOffset(0, 1).addBox(8.25F, -1.0F, -5.0F, 0, 1, 9, 0.0F);
        this.Green.setTextureOffset(0, 0).addBox(-0.75F, -1.0F, -5.0F, 0, 1, 9, 0.0F);
        this.Green.setTextureOffset(0, 1).addBox(-0.75F, -1.0F, 4.0F, 9, 1, 0, 0.0F);
        this.Green.setTextureOffset(0, 0).addBox(-0.75F, -1.0F, -5.0F, 9, 1, 0, 0.0F);
        this.Flowers = new MModelRenderer(this);
        this.Flowers.setRotationPoint(0.0F, 5.5F, 0.0F);
        this.Wreath.addChild(this.Flowers);
        this.Flower1 = new MModelRenderer(this);
        this.Flower1.setRotationPoint(-4.5F, -5.5F, -2.4F);
        this.Flowers.addChild(this.Flower1);
        this.setRotation(this.Flower1, 0.1745F, 0.0F, 0.0F);
        this.Part1 = new MModelRenderer(this);
        this.Part1.setRotationPoint(0.0F, 1.5F, 0.0F);
        this.Flower1.addChild(this.Part1);
        this.setRotation(this.Part1, 0.0F, -0.4363F, 0.0F);
        this.Part1.setTextureOffset(0, 8).addBox(0.0F, -3.0F, -1.3037F, 0, 3, 3, 0.0F);
        this.Part2 = new MModelRenderer(this);
        this.Part2.setRotationPoint(0.0F, 1.5F, 0.0F);
        this.Flower1.addChild(this.Part2);
        this.setRotation(this.Part2, 0.0F, 0.4363F, 0.0F);
        this.Part2.setTextureOffset(0, 8).addBox(0.0F, -3.0F, -1.4396F, 0, 3, 3, 0.0F);
        this.Flower2 = new MModelRenderer(this);
        this.Flower2.setRotationPoint(-4.5F, -5.5F, 1.85F);
        this.Flowers.addChild(this.Flower2);
        this.setRotation(this.Flower2, -0.1745F, 0.0F, 0.0F);
        this.Part3 = new MModelRenderer(this);
        this.Part3.setRotationPoint(0.0F, 1.5F, 0.0F);
        this.Flower2.addChild(this.Part3);
        this.setRotation(this.Part3, 0.0F, -0.4363F, 0.0F);
        this.Part3.setTextureOffset(6, 8).addBox(0.0F, -3.0F, -1.3037F, 0, 3, 3, 0.0F);
        this.Part4 = new MModelRenderer(this);
        this.Part4.setRotationPoint(0.0F, 1.5F, 0.0F);
        this.Flower2.addChild(this.Part4);
        this.setRotation(this.Part4, 0.0F, 0.4363F, 0.0F);
        this.Part4.setTextureOffset(6, 8).addBox(0.0F, -3.0F, -1.4396F, 0, 3, 3, 0.0F);
        this.Flower3 = new MModelRenderer(this);
        this.Flower3.setRotationPoint(-2.2F, -5.5F, 4.5F);
        this.Flowers.addChild(this.Flower3);
        this.setRotation(this.Flower3, -0.1309F, 1.5272F, 0.0F);
        this.Part11 = new MModelRenderer(this);
        this.Part11.setRotationPoint(0.0F, 1.5F, 0.0F);
        this.Flower3.addChild(this.Part11);
        this.setRotation(this.Part11, 0.0F, -0.4363F, 0.0F);
        this.Part11.setTextureOffset(0, 8).addBox(0.0F, -3.0F, -1.3037F, 0, 3, 3, 0.0F);
        this.Part12 = new MModelRenderer(this);
        this.Part12.setRotationPoint(0.0F, 1.5F, 0.0F);
        this.Flower3.addChild(this.Part12);
        this.setRotation(this.Part12, 0.0F, 0.4363F, 0.0F);
        this.Part12.setTextureOffset(0, 8).addBox(0.0F, -3.0F, -1.4396F, 0, 3, 3, 0.0F);
        this.Flower4 = new MModelRenderer(this);
        this.Flower4.setRotationPoint(2.2F, -5.5F, 4.5F);
        this.Flowers.addChild(this.Flower4);
        this.setRotation(this.Flower4, -0.1309F, -1.5272F, 0.0F);
        this.Part9 = new MModelRenderer(this);
        this.Part9.setRotationPoint(0.0F, 1.5F, 0.0F);
        this.Flower4.addChild(this.Part9);
        this.setRotation(this.Part9, 0.0F, -2.7053F, 0.0F);
        this.Part9.setTextureOffset(6, 8).addBox(0.0F, -3.0F, -1.3037F, 0, 3, 3, 0.0F);
        this.Part10 = new MModelRenderer(this);
        this.Part10.setRotationPoint(0.0F, 1.5F, 0.0F);
        this.Flower4.addChild(this.Part10);
        this.setRotation(this.Part10, 0.0F, 2.7053F, 0.0F);
        this.Part10.setTextureOffset(6, 8).addBox(0.0F, -3.0F, -1.4396F, 0, 3, 3, 0.0F);
        this.Flower5 = new MModelRenderer(this);
        this.Flower5.setRotationPoint(4.5F, -5.5F, 1.85F);
        this.Flowers.addChild(this.Flower5);
        this.setRotation(this.Flower5, -0.1745F, 0.0F, 0.0F);
        this.Part7 = new MModelRenderer(this);
        this.Part7.setRotationPoint(0.0F, 1.5F, 0.0F);
        this.Flower5.addChild(this.Part7);
        this.setRotation(this.Part7, 0.0F, -2.7053F, 0.0F);
        this.Part7.setTextureOffset(0, 8).addBox(0.0F, -3.0F, -1.3037F, 0, 3, 3, 0.0F);
        this.Part8 = new MModelRenderer(this);
        this.Part8.setRotationPoint(0.0F, 1.5F, 0.0F);
        this.Flower5.addChild(this.Part8);
        this.setRotation(this.Part8, 0.0F, 2.7053F, 0.0F);
        this.Part8.setTextureOffset(0, 8).addBox(0.0F, -3.0F, -1.4396F, 0, 3, 3, 0.0F);
        this.Flower6 = new MModelRenderer(this);
        this.Flower6.setRotationPoint(4.5F, -5.5F, -2.4F);
        this.Flowers.addChild(this.Flower6);
        this.setRotation(this.Flower6, 0.1745F, 0.0F, 0.0F);
        this.Part5 = new MModelRenderer(this);
        this.Part5.setRotationPoint(0.0F, 1.5F, 0.0F);
        this.Flower6.addChild(this.Part5);
        this.setRotation(this.Part5, 0.0F, -2.7053F, 0.0F);
        this.Part5.setTextureOffset(6, 8).addBox(0.0F, -3.0F, -1.3037F, 0, 3, 3, 0.0F);
        this.Part6 = new MModelRenderer(this);
        this.Part6.setRotationPoint(0.0F, 1.5F, 0.0F);
        this.Flower6.addChild(this.Part6);
        this.setRotation(this.Part6, 0.0F, 2.7053F, 0.0F);
        this.Part6.setTextureOffset(6, 8).addBox(0.0F, -3.0F, -1.4396F, 0, 3, 3, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "head/spring_wreath.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(1.05F, 1.05F, 1.05F);
        GlStateManager.translate(0.0F, -1.5F, 0.0F);
    }

    public void itemMotion(float rotation, int number)
    {
        GlStateManager.rotate(195.0F + MathHelper.cos(rotation * 0.07F + (float)number) * 10.0F, 0.0F, 0.2F, 0.0F);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -1.4F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0426\u0432\u0435\u0442\u043e\u0447\u043d\u044b\u0439 \u0432\u0435\u043d\u043e\u043a";
    }

    public String getCreator()
    {
        return "Wenston";
    }
}
