package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class Diadem extends BaseItem
{
    private final MModelRenderer base;
    private final MModelRenderer lur1;
    private final MModelRenderer lur2;
    private final MModelRenderer lur3;
    private final MModelRenderer lur4;
    private final MModelRenderer lur5;
    private final MModelRenderer lul1;
    private final MModelRenderer lul2;
    private final MModelRenderer lul3;
    private final MModelRenderer lul4;
    private final MModelRenderer lul5;
    private final MModelRenderer b1;
    private final MModelRenderer b2;
    private final MModelRenderer endl;
    private final MModelRenderer endr;
    private final MModelRenderer b3;
    private final MModelRenderer b4;
    private final MModelRenderer ldr1;
    private final MModelRenderer ldr2;
    private final MModelRenderer ldr3;
    private final MModelRenderer ldr4;
    private final MModelRenderer ldr5;
    private final MModelRenderer ldl1;
    private final MModelRenderer ldl2;
    private final MModelRenderer ldl3;
    private final MModelRenderer ldl5;
    private final MModelRenderer ldl4;

    public Diadem()
    {
        super(ItemType.HEAD);
        this.textureWidth = 8;
        this.textureHeight = 8;
        this.useDisplayLists = true;
        this.base = new MModelRenderer(this, 0, 5);
        this.base.addBox(-1.0F, -1.0F, -5.0F, 2, 2, 1);
        this.base.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.lur1 = new MModelRenderer(this, 0, 0);
        this.lur1.addBox(1.0F, -1.8F, -4.9F, 1, 2, 1);
        this.lur1.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.setRotation(this.lur1, 0.0F, -0.5576792F, 0.6297644F);
        this.lur2 = new MModelRenderer(this, 0, 0);
        this.lur2.addBox(1.0F, -1.9F, -4.9F, 1, 2, 1);
        this.lur2.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.setRotation(this.lur2, 0.0F, -0.2974289F, 0.6297644F);
        this.lur3 = new MModelRenderer(this, 0, 0);
        this.lur3.addBox(1.0F, -2.0F, -4.9F, 1, 2, 1);
        this.lur3.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.setRotation(this.lur3, 0.0F, -0.0371786F, 0.6297644F);
        this.lur4 = new MModelRenderer(this, 0, 0);
        this.lur4.addBox(1.0F, -1.7F, -4.9F, 1, 2, 1);
        this.lur4.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.setRotation(this.lur4, 0.0F, -0.8551081F, 0.6297644F);
        this.lur5 = new MModelRenderer(this, 0, 0);
        this.lur5.addBox(1.0F, -1.6F, -4.9F, 1, 2, 1);
        this.lur5.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.setRotation(this.lur5, 0.0F, -1.152537F, 0.6297644F);
        this.lul1 = new MModelRenderer(this, 0, 0);
        this.lul1.addBox(-2.0F, -2.0F, -4.9F, 1, 2, 1);
        this.lul1.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.setRotation(this.lul1, 0.0F, 0.0371755F, -0.6297672F);
        this.lul2 = new MModelRenderer(this, 0, 0);
        this.lul2.addBox(-2.0F, -1.9F, -4.9F, 1, 2, 1);
        this.lul2.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.setRotation(this.lul2, 0.0F, 0.2974216F, -0.6297672F);
        this.lul3 = new MModelRenderer(this, 0, 0);
        this.lul3.addBox(-1.92F, -1.8F, -4.9F, 1, 2, 1);
        this.lul3.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.setRotation(this.lul3, 0.0F, 0.5576851F, -0.6297672F);
        this.lul4 = new MModelRenderer(this, 0, 0);
        this.lul4.addBox(-2.0F, -1.7F, -4.9F, 1, 2, 1);
        this.lul4.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.setRotation(this.lul4, 0.0F, 0.8551066F, -0.6297672F);
        this.lul5 = new MModelRenderer(this, 0, 0);
        this.lul5.addBox(-2.0F, -1.6F, -4.9F, 1, 2, 1);
        this.lul5.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.setRotation(this.lul5, 0.0F, 1.152546F, -0.6297672F);
        this.b1 = new MModelRenderer(this, 0, 0);
        this.b1.addBox(-1.5F, -1.0F, -5.5F, 1, 2, 1);
        this.b1.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.setRotation(this.b1, 0.0F, 0.0F, -((float)Math.PI / 4F));
        this.b2 = new MModelRenderer(this, 0, 0);
        this.b2.addBox(-1.0F, 0.5F, -5.51F, 2, 1, 1);
        this.b2.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.setRotation(this.b2, 0.0F, 0.0F, -((float)Math.PI / 4F));
        this.endl = new MModelRenderer(this, 0, 0);
        this.endl.addBox(-1.0F, -1.933333F, -4.9F, 1, 3, 1);
        this.endl.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.setRotation(this.endl, 0.0743572F, 1.784582F, -0.8156602F);
        this.endr = new MModelRenderer(this, 0, 0);
        this.endr.addBox(0.0F, -1.933333F, -4.9F, 1, 3, 1);
        this.endr.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.setRotation(this.endr, 0.0743572F, -1.784582F, 0.8156622F);
        this.b3 = new MModelRenderer(this, 0, 0);
        this.b3.addBox(-1.0F, -1.5F, -5.5F, 2, 1, 1);
        this.b3.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.setRotation(this.b3, 0.0F, 0.0F, -((float)Math.PI / 4F));
        this.b4 = new MModelRenderer(this, 0, 0);
        this.b4.addBox(0.5F, -1.0F, -5.49F, 1, 2, 1);
        this.b4.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.setRotation(this.b4, 0.0F, 0.0F, -((float)Math.PI / 4F));
        this.ldr1 = new MModelRenderer(this, 0, 0);
        this.ldr1.addBox(1.0F, -1.0F, -4.7F, 2, 1, 1);
        this.ldr1.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.setRotation(this.ldr1, 0.0F, -0.0371786F, 0.6297644F);
        this.ldr2 = new MModelRenderer(this, 0, 0);
        this.ldr2.addBox(1.0F, -1.0F, -4.7F, 2, 1, 1);
        this.ldr2.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.setRotation(this.ldr2, 0.0F, -0.2974216F, 0.6297644F);
        this.ldr3 = new MModelRenderer(this, 0, 0);
        this.ldr3.addBox(1.0F, -1.0F, -4.7F, 2, 1, 1);
        this.ldr3.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.setRotation(this.ldr3, 0.0F, -0.5576851F, 0.6297644F);
        this.ldr4 = new MModelRenderer(this, 0, 0);
        this.ldr4.addBox(1.0F, -1.0F, -4.7F, 2, 1, 1);
        this.ldr4.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.setRotation(this.ldr4, 0.0F, -1.152546F, 0.6297644F);
        this.ldr5 = new MModelRenderer(this, 0, 0);
        this.ldr5.addBox(1.0F, -1.0F, -4.7F, 2, 1, 1);
        this.ldr5.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.setRotation(this.ldr5, 0.0F, -0.8551066F, 0.6297644F);
        this.ldl1 = new MModelRenderer(this, 0, 0);
        this.ldl1.addBox(-3.0F, -1.0F, -4.7F, 2, 1, 1);
        this.ldl1.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.setRotation(this.ldl1, 0.0F, 0.0371755F, -0.6297672F);
        this.ldl2 = new MModelRenderer(this, 0, 0);
        this.ldl2.addBox(-3.0F, -1.0F, -4.7F, 2, 1, 1);
        this.ldl2.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.setRotation(this.ldl2, 0.0F, 0.2974216F, -0.6297672F);
        this.ldl3 = new MModelRenderer(this, 0, 0);
        this.ldl3.addBox(-3.0F, -1.0F, -4.7F, 2, 1, 1);
        this.ldl3.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.setRotation(this.ldl3, 0.0F, 0.5514019F, -0.6297672F);
        this.ldl5 = new MModelRenderer(this, 0, 0);
        this.ldl5.addBox(-3.0F, -1.0F, -4.7F, 2, 1, 1);
        this.ldl5.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.setRotation(this.ldl5, 0.0F, 0.8551066F, -0.6297672F);
        this.ldl4 = new MModelRenderer(this, 0, 0);
        this.ldl4.addBox(-3.0F, -1.0F, -4.7F, 2, 1, 1);
        this.ldl4.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.setRotation(this.ldl4, 0.0F, 1.152546F, -0.6297672F);
        this.setTexture(new ResourceLocation("minidot", "head/wreathtexture.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, 0.0F, -0.05F);
        GlStateManager.scale(1.15F, 1.1F, 1.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.1F, 0.05F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041a\u043e\u0440\u043e\u043d\u0430";
    }

    public String getCreator()
    {
        return "Ursun";
    }
}
