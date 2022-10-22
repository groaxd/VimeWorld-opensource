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

public class DemonicWings extends BaseItem
{
    private final MModelRenderer wing;

    public DemonicWings()
    {
        super(ItemType.BODY);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("right.Shape29", 58, 0);
        this.setTextureOffset("right.Shape47", 58, 0);
        this.setTextureOffset("right.Shape30", 58, 0);
        this.setTextureOffset("right.Shape32", 58, 0);
        this.setTextureOffset("right.Shape28", 58, 0);
        this.setTextureOffset("right.Shape33", 58, 0);
        this.setTextureOffset("right.Shape35", 58, 0);
        this.setTextureOffset("right.Shape37", 58, 0);
        this.setTextureOffset("right.Shape38", 58, 0);
        this.setTextureOffset("right.Shape40", 58, 0);
        this.setTextureOffset("right.Shape34", 58, 0);
        this.setTextureOffset("right.Shape36", 58, 0);
        this.setTextureOffset("right.Shape42", 58, 0);
        this.setTextureOffset("right.Shape46", 58, 0);
        this.setTextureOffset("right.Shape44", 58, 0);
        this.setTextureOffset("right.Shape51", 0, 0);
        this.setTextureOffset("right.Shape50", 0, 0);
        this.setTextureOffset("right.Shape45", 58, 0);
        this.setTextureOffset("right.Shape48", 58, 0);
        this.setTextureOffset("right.Shape53", 0, 0);
        this.setTextureOffset("right.Shape39", 58, 0);
        this.setTextureOffset("right.Shape52", 0, 0);
        this.setTextureOffset("right.Shape54", 0, 0);
        this.setTextureOffset("right.Shape43", 58, 0);
        this.setTextureOffset("right.Shape31", 58, 0);
        this.setTextureOffset("right.Shape41", 58, 0);
        this.wing = new MModelRenderer(this, "right");
        this.wing.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.wing.mirror = true;
        this.wing.addBox("Shape29", -2.0F, 1.0F, 4.0F, 1, 1, 2);
        this.wing.addBox("Shape47", -2.0F, 9.0F, 8.0F, 1, 2, 1);
        this.wing.addBox("Shape30", -2.0F, 0.0F, 6.0F, 1, 1, 1);
        this.wing.addBox("Shape32", -2.0F, -2.0F, 8.0F, 1, 1, 1);
        this.wing.addBox("Shape28", -2.0F, 2.0F, 2.0F, 1, 1, 2);
        this.wing.addBox("Shape33", -2.0F, -5.0F, 9.0F, 1, 3, 2);
        this.wing.addBox("Shape35", -2.0F, -4.0F, 11.0F, 1, 9, 1);
        this.wing.addBox("Shape37", -2.0F, -2.0F, 13.0F, 1, 2, 1);
        this.wing.addBox("Shape38", -2.0F, 0.0F, 14.0F, 1, 4, 1);
        this.wing.addBox("Shape40", -2.0F, 7.0F, 14.0F, 1, 5, 1);
        this.wing.addBox("Shape34", -2.0F, -7.0F, 9.0F, 1, 2, 1);
        this.wing.addBox("Shape36", -2.0F, -3.0F, 12.0F, 1, 1, 1);
        this.wing.addBox("Shape42", -2.0F, 15.0F, 12.0F, 1, 2, 1);
        this.wing.addBox("Shape46", -2.0F, 7.0F, 9.0F, 1, 2, 1);
        this.wing.addBox("Shape44", -2.0F, 19.0F, 10.0F, 1, 2, 1);
        this.wing.addBox("Shape51", -1.5F, 12.0F, 9.0F, 0, 5, 4);
        this.wing.addBox("Shape50", -1.5F, 0.0F, 6.0F, 0, 7, 9);
        this.wing.addBox("Shape45", -2.0F, 5.0F, 10.0F, 1, 2, 1);
        this.wing.addBox("Shape48", -2.0F, 11.0F, 7.0F, 1, 1, 1);
        this.wing.addBox("Shape53", -1.5F, 17.0F, 10.0F, 0, 2, 2);
        this.wing.addBox("Shape39", -2.0F, 4.0F, 15.0F, 1, 3, 1);
        this.wing.addBox("Shape52", -1.5F, -2.0F, 8.0F, 0, 14, 6);
        this.wing.addBox("Shape54", -1.5F, 2.0F, 2.0F, 0, 2, 4);
        this.wing.addBox("Shape43", -2.0F, 17.0F, 11.0F, 1, 2, 1);
        this.wing.addBox("Shape31", -2.0F, -1.0F, 7.0F, 1, 1, 1);
        this.wing.addBox("Shape41", -2.0F, 12.0F, 13.0F, 1, 3, 1);
        this.setTexture(new ResourceLocation("minidot", "body/dwings.png"));
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        float f = MathHelper.cos(time * 0.26F) * 2.0F;
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.tex);
        GlStateManager.pushMatrix();
        GlStateManager.enableCull();
        this.preRender(modelPlayer, player, time, pi);
        GlStateManager.cullFace(1028);
        GlStateManager.pushMatrix();
        GlStateManager.scale(-1.0F, 1.0F, 1.0F);
        GlStateManager.rotate(-25.0F + f, -0.5F, 1.0F, 0.0F);
        this.wing.render(0.052500002F);
        GlStateManager.popMatrix();
        GlStateManager.cullFace(1029);
        GlStateManager.pushMatrix();
        GlStateManager.rotate(-25.0F + f, -0.5F, 1.0F, 0.0F);
        this.wing.render(0.052500002F);
        GlStateManager.popMatrix();
        GlStateManager.disableCull();
        GlStateManager.popMatrix();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -0.07F, -0.4F);
        GlStateManager.scale(0.6F, 0.6F, 0.6F);
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.tex);
        GlStateManager.cullFace(1028);
        GlStateManager.pushMatrix();
        GlStateManager.scale(-1.0F, 1.0F, 1.0F);
        GlStateManager.rotate(-35.0F, -0.5F, 1.0F, 0.0F);
        GlStateManager.translate(0.0F, 0.0F, 0.2F);
        this.wing.render(0.052500002F);
        GlStateManager.popMatrix();
        GlStateManager.cullFace(1029);
        GlStateManager.pushMatrix();
        GlStateManager.rotate(-35.0F, -0.5F, 1.0F, 0.0F);
        GlStateManager.translate(0.0F, 0.0F, 0.2F);
        this.wing.render(0.052500002F);
        GlStateManager.popMatrix();
    }

    public String getName()
    {
        return "\u0414\u0435\u043c\u043e\u043d\u0438\u0447\u0435\u0441\u043a\u0438\u0435 \u043a\u0440\u044b\u043b\u044c\u044f";
    }

    public String getCreator()
    {
        return "Ender_Nyashka";
    }
}
