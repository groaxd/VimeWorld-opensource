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

public class MoustacheGlasses extends BaseItem
{
    private final MModelRenderer frame1;
    private final MModelRenderer frame2;
    private final MModelRenderer frame3;
    private final MModelRenderer frame4;
    private final MModelRenderer frame5;
    private final MModelRenderer frame6;
    private final MModelRenderer frame7;
    private final MModelRenderer frame8;
    private final MModelRenderer frame9;
    private final MModelRenderer nose1;
    private final MModelRenderer nose2;
    private final MModelRenderer nose3;
    private final MModelRenderer stache1;
    private final MModelRenderer stache2;
    private final MModelRenderer stache3;
    private final MModelRenderer stache4;
    private final MModelRenderer stache5;
    private final MModelRenderer frame10;

    public MoustacheGlasses()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.useDisplayLists = true;
        this.frame1 = new MModelRenderer(this, 0, 23);
        this.frame1.addBox(-4.5F, -1.0F, -4.5F, 9, 1, 1);
        this.frame2 = new MModelRenderer(this, 0, 23);
        this.frame2.addBox(1.0F, 1.0F, -4.5F, 2, 1, 1);
        this.frame3 = new MModelRenderer(this, 0, 23);
        this.frame3.addBox(-3.0F, 1.0F, -4.5F, 2, 1, 1);
        this.frame4 = new MModelRenderer(this, 0, 22);
        this.frame4.addBox(-3.75F, -0.5F, -4.5F, 1, 2, 1);
        this.frame5 = new MModelRenderer(this, 0, 22);
        this.frame5.addBox(-1.25F, -0.5F, -4.5F, 1, 2, 1);
        this.frame6 = new MModelRenderer(this, 0, 22);
        this.frame6.addBox(0.25F, -0.5F, -4.5F, 1, 2, 1);
        this.frame7 = new MModelRenderer(this, 0, 22);
        this.frame7.addBox(2.75F, -0.5F, -4.5F, 1, 2, 1);
        this.frame8 = new MModelRenderer(this, 0, 23);
        this.frame8.addBox(-4.5F, -1.0F, -3.5F, 1, 1, 3);
        this.frame9 = new MModelRenderer(this, 0, 23);
        this.frame9.addBox(3.5F, -1.0F, -3.5F, 1, 1, 3);
        this.nose1 = new MModelRenderer(this, 0, 0);
        this.nose1.addBox(-1.0F, 1.733333F, -4.0F, 2, 2, 2);
        this.setRotation(this.nose1, -0.4089647F, 0.0F, 0.0F);
        this.nose2 = new MModelRenderer(this, 0, 0);
        this.nose2.addBox(-1.0F, 1.733333F, -5.133333F, 2, 1, 2);
        this.nose3 = new MModelRenderer(this, 0, 0);
        this.nose3.addBox(-1.5F, 1.6F, -4.51F, 3, 1, 1);
        this.stache1 = new MModelRenderer(this, 0, 16);
        this.stache1.addBox(-1.8F, 3.5F, -3.0F, 1, 2, 1);
        this.setRotation(this.stache1, -0.4089656F, 0.0F, -0.7807508F);
        this.stache2 = new MModelRenderer(this, 0, 16);
        this.stache2.addBox(0.8F, 3.533333F, -3.0F, 1, 2, 1);
        this.setRotation(this.stache2, -0.4089647F, 0.0F, 0.7807556F);
        this.stache3 = new MModelRenderer(this, 0, 16);
        this.stache3.addBox(-1.133333F, 3.833333F, -3.0F, 1, 2, 1);
        this.setRotation(this.stache3, -0.4089656F, 0.0F, -0.3307864F);
        this.stache4 = new MModelRenderer(this, 0, 16);
        this.stache4.addBox(0.1F, 3.833333F, -3.0F, 1, 2, 1);
        this.setRotation(this.stache4, -0.4089656F, 0.0F, 0.3307923F);
        this.stache5 = new MModelRenderer(this, 0, 16);
        this.stache5.addBox(-0.5F, 4.1F, -3.0F, 1, 2, 1);
        this.setRotation(this.stache5, -0.4089656F, 0.0F, 0.0F);
        this.frame10 = new MModelRenderer(this, 0, 25);
        this.frame10.addBox(-0.5F, 0.0F, -4.5F, 1, 1, 1);
        this.setTexture(new ResourceLocation("minidot", "head/moustacheglasses.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(1.0001F, 1.0001F, 1.0001F);
        GlStateManager.translate(0.0F, -0.25F, 0.0F);
    }

    public void itemMotion(float rotation, int number)
    {
        GlStateManager.rotate(180.0F + MathHelper.sin(rotation * 0.07F + (float)number) * 20.0F, 0.0F, 0.2F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -0.45F, 0.2F);
        GlStateManager.scale(1.1F, 1.1F, 1.1F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041e\u0447\u043a\u0438 \u0441 \u0443\u0441\u0430\u043c\u0438";
    }

    public String getCreator()
    {
        return "Ursun";
    }
}
