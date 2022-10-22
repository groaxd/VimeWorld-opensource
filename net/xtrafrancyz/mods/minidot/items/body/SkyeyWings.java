package net.xtrafrancyz.mods.minidot.items.body;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class SkyeyWings extends BaseItem
{
    private final MModelRenderer[] wings;

    public SkyeyWings()
    {
        super(ItemType.BODY);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.useDisplayLists = true;
        this.wings = new MModelRenderer[9];
        this.wings[1] = new MModelRenderer(this, 0, 0);
        this.wings[1].addBox(-1.0F, 0.0F, -1.0F, 1, 2, 4);
        this.wings[1].mirror = true;
        this.setRotation(this.wings[1], 0.669215F, 0.0F, 0.0F);
        this.wings[2] = new MModelRenderer(this, 0, 13);
        this.wings[2].addBox(-0.9F, 2.3F, -0.2F, 1, 2, 3);
        this.wings[2].mirror = true;
        this.setRotation(this.wings[2], -0.2602503F, 0.0F, 0.0F);
        this.wings[3] = new MModelRenderer(this, 0, 7);
        this.wings[3].addBox(-0.9F, 0.6F, -0.2F, 1, 2, 3);
        this.wings[3].mirror = true;
        this.setRotation(this.wings[3], -0.0743572F, 0.0F, 0.0F);
        this.wings[4] = new MModelRenderer(this, 0, 19);
        this.wings[4].addBox(-1.02F, 1.2F, 1.4F, 1, 1, 3);
        this.wings[4].mirror = true;
        this.setRotation(this.wings[4], 1.07818F, 0.0F, 0.0F);
        this.wings[5] = new MModelRenderer(this, 5, 24);
        this.wings[5].addBox(-0.91F, 1.6F, 0.9F, 1, 1, 3);
        this.wings[5].mirror = true;
        this.setRotation(this.wings[5], 0.3717861F, 0.0F, 0.0F);
        this.wings[6] = new MModelRenderer(this, 0, 28);
        this.wings[6].addBox(-0.91F, 3.1F, 0.2F, 1, 1, 3);
        this.wings[6].mirror = true;
        this.setRotation(this.wings[6], 0.0743572F, 0.0F, 0.0F);
        this.wings[7] = new MModelRenderer(this, 14, 0);
        this.wings[7].addBox(-0.5F, -1.8F, 0.4F, 0, 4, 12);
        this.wings[7].mirror = true;
        this.setRotation(this.wings[7], 0.6320364F, 0.0F, 0.0F);
        this.wings[8] = new MModelRenderer(this, 14, 6);
        this.wings[8].addBox(-0.5F, -0.4F, -0.2F, 0, 4, 11);
        this.wings[8].mirror = true;
        this.setRotation(this.wings[8], 0.3019729F, 0.0F, 0.0F);
        this.wings[0] = new MModelRenderer(this, 14, 12);
        this.wings[0].addBox(-0.5F, 2.3F, -0.2F, 0, 4, 10);
        this.wings[0].mirror = true;
        this.setRotation(this.wings[0], 0.1487144F, 0.0F, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "body/skyey_wings.png"));
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        float f = MathHelper.cos(time * 0.15F) * 8.0F;
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.tex);
        GlStateManager.pushMatrix();
        GlStateManager.enableCull();
        this.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, 0.1F, 0.13F);
        GlStateManager.scale(1.2F, 1.3F, 1.2F);
        GlStateManager.cullFace(1028);
        GlStateManager.pushMatrix();
        GlStateManager.scale(-1.0F, 1.0F, 1.0F);
        GlStateManager.translate(-0.07F, 0.0F, 0.03F);
        GlStateManager.rotate(-16.0F, 1.0F, 1.0F, 0.0F);
        GlStateManager.rotate(f, 0.0F, -0.2F, 0.0F);
        this.renderModels();
        GlStateManager.popMatrix();
        GlStateManager.cullFace(1029);
        GlStateManager.pushMatrix();
        GlStateManager.translate(-0.07F, 0.0F, 0.03F);
        GlStateManager.rotate(-16.0F, 1.0F, 1.0F, 0.0F);
        GlStateManager.rotate(f, 0.0F, -0.2F, 0.0F);
        this.renderModels();
        GlStateManager.popMatrix();
        GlStateManager.disableCull();
        GlStateManager.popMatrix();
    }

    public void renderAsItem(float time)
    {
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.tex);
        GlStateManager.translate(0.0F, 0.07F, -0.2F);
        GlStateManager.scale(0.72F, 0.72F, 0.72F);
        GlStateManager.pushMatrix();
        GlStateManager.rotate(26.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.translate(0.1F, 0.0F, 0.03F);
        this.renderModels();
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.rotate(-26.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.translate(-0.1F, 0.0F, 0.03F);
        this.renderModels();
        GlStateManager.popMatrix();
    }

    public String getCreator()
    {
        return "Ursun";
    }

    public String getName()
    {
        return "\u041d\u0435\u0431\u0435\u0441\u043d\u044b\u0435 \u043a\u0440\u044b\u043b\u044c\u044f";
    }
}
