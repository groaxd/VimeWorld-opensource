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

public class WingsDragon extends BaseItem
{
    private final MModelRenderer[] wing;

    public WingsDragon()
    {
        super(ItemType.BODY);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.useDisplayLists = true;
        this.wing = new MModelRenderer[27];
        this.wing[0] = new MModelRenderer(this, 12, 7);
        this.wing[1] = new MModelRenderer(this, 4, 7);
        this.wing[2] = new MModelRenderer(this, 8, 7);
        this.wing[3] = new MModelRenderer(this, 4, 0);
        this.wing[4] = new MModelRenderer(this, 12, 11);
        this.wing[5] = new MModelRenderer(this, 12, 7);
        this.wing[6] = new MModelRenderer(this, 0, 0);
        this.wing[7] = new MModelRenderer(this, 12, 7);
        this.wing[8] = new MModelRenderer(this, 20, 0);
        this.wing[9] = new MModelRenderer(this, 26, 0);
        this.wing[10] = new MModelRenderer(this, 8, 0);
        this.wing[11] = new MModelRenderer(this, 16, 11);
        this.wing[12] = new MModelRenderer(this, 12, 0);
        this.wing[13] = new MModelRenderer(this, 16, 0);
        this.wing[14] = new MModelRenderer(this, 16, 0);
        this.wing[15] = new MModelRenderer(this, 12, 11);
        this.wing[16] = new MModelRenderer(this, 0, 7);
        this.wing[17] = new MModelRenderer(this, 20, 4);
        this.wing[18] = new MModelRenderer(this, 12, 7);
        this.wing[19] = new MModelRenderer(this, 12, 7);
        this.wing[20] = new MModelRenderer(this, 32, 0);
        this.wing[21] = new MModelRenderer(this, 14, 9);
        this.wing[22] = new MModelRenderer(this, 14, 17);
        this.wing[23] = new MModelRenderer(this, 6, 23);
        this.wing[24] = new MModelRenderer(this, 12, 28);
        this.wing[25] = new MModelRenderer(this, 12, 25);
        this.wing[26] = new MModelRenderer(this, 6, 23);
        this.wing[0].addBox(-3.1F, 12.1F, 7.8F, 1, 3, 1);
        this.wing[1].addBox(-3.1F, -14.5F, -4.1F, 1, 5, 1);
        this.wing[2].addBox(-3.1F, -10.3F, 1.2F, 1, 4, 1);
        this.wing[3].addBox(-3.1F, -10.1F, -5.1F, 1, 5, 1);
        this.wing[4].addBox(-3.1F, 8.3F, 6.5F, 1, 3, 1);
        this.wing[5].addBox(-3.1F, 7.0F, 10.6F, 1, 3, 1);
        this.wing[6].addBox(-3.1F, -1.3F, 5.7F, 1, 6, 1);
        this.wing[7].addBox(-3.1F, 1.4F, 7.0F, 1, 3, 1);
        this.wing[8].addBox(-3.1F, -6.0F, -5.0F, 1, 2, 2);
        this.wing[9].addBox(-3.1F, -5.0F, -4.0F, 1, 1, 2);
        this.wing[10].addBox(-3.1F, -5.9F, 2.7F, 1, 4, 1);
        this.wing[11].addBox(-3.1F, 0.5F, 3.3F, 1, 3, 1);
        this.wing[12].addBox(-3.1F, 0.9F, 4.5F, 1, 3, 1);
        this.wing[13].addBox(-3.1F, 0.0F, 5.7F, 1, 2, 1);
        this.wing[14].addBox(-3.1F, 3.8F, 4.7F, 1, 2, 1);
        this.wing[15].addBox(-3.1F, 7.0F, -2.6F, 1, 3, 1);
        this.wing[16].addBox(-3.1F, 3.7F, -9.7F, 1, 5, 1);
        this.wing[17].addBox(-3.1F, 12.3F, -2.1F, 1, 2, 1);
        this.wing[18].addBox(-3.1F, 9.8F, 3.3F, 1, 3, 1);
        this.wing[19].addBox(-3.1F, 11.1F, -1.8F, 1, 3, 1);
        this.wing[20].addBox(-3.1F, 7.5F, -12.3F, 1, 1, 1);
        this.wing[21].addBox(-2.6F, 5.4F, -2.0F, 0, 8, 7);
        this.wing[22].addBox(-2.6F, -2.5F, 5.2F, 0, 8, 7);
        this.wing[23].addBox(-2.6F, -1.7F, 3.3F, 0, 6, 3);
        this.wing[24].addBox(9.7F, -8.5F, 2.7F, 1, 4, 0);
        this.wing[25].addBox(10.7F, -7.5F, 2.7F, 1, 3, 0);
        this.wing[26].addBox(-2.6F, 12.9F, -2.5F, 0, 1, 2);
        this.wing[0].setRotationPoint(0.0F, 0.0F, -2.0F);
        this.wing[1].setRotationPoint(0.0F, 0.0F, -2.0F);
        this.wing[2].setRotationPoint(0.0F, 0.0F, -2.0F);
        this.wing[3].setRotationPoint(0.0F, 0.0F, -2.0F);
        this.wing[4].setRotationPoint(0.0F, 0.0F, -2.0F);
        this.wing[5].setRotationPoint(0.0F, 0.0F, -2.0F);
        this.wing[6].setRotationPoint(0.0F, 0.0F, -2.0F);
        this.wing[7].setRotationPoint(0.0F, 0.0F, -2.0F);
        this.wing[8].setRotationPoint(0.0F, 0.0F, -2.0F);
        this.wing[9].setRotationPoint(0.0F, 0.0F, -2.0F);
        this.wing[10].setRotationPoint(0.0F, 0.0F, -2.0F);
        this.wing[11].setRotationPoint(0.0F, 0.0F, -2.0F);
        this.wing[12].setRotationPoint(0.0F, 0.0F, -2.0F);
        this.wing[13].setRotationPoint(0.0F, 0.0F, -2.0F);
        this.wing[14].setRotationPoint(0.0F, 0.0F, -2.0F);
        this.wing[15].setRotationPoint(0.0F, 0.0F, -2.0F);
        this.wing[16].setRotationPoint(0.0F, 0.0F, -2.0F);
        this.wing[17].setRotationPoint(0.0F, 0.0F, -2.0F);
        this.wing[18].setRotationPoint(0.0F, 0.0F, -2.0F);
        this.wing[19].setRotationPoint(0.0F, 0.0F, -2.0F);
        this.wing[20].setRotationPoint(0.0F, 0.0F, -2.0F);
        this.wing[21].setRotationPoint(0.0F, 0.0F, -2.0F);
        this.wing[22].setRotationPoint(0.0F, 0.0F, -2.0F);
        this.wing[23].setRotationPoint(0.0F, 0.0F, -2.0F);
        this.wing[24].setRotationPoint(0.0F, 0.0F, -2.0F);
        this.wing[25].setRotationPoint(0.0F, 0.0F, -2.0F);
        this.wing[26].setRotationPoint(0.0F, 0.0F, -2.0F);
        this.setRotation(this.wing[0], ((float)Math.PI / 2F), 0.0F, 0.0F);
        this.setRotation(this.wing[1], -1.22173F, 0.0F, 0.0F);
        this.setRotation(this.wing[2], -((float)Math.PI * 2F / 9F), 0.0F, 0.0F);
        this.setRotation(this.wing[3], -1.745329F, 0.0F, 0.0F);
        this.setRotation(this.wing[4], 1.134464F, 0.0F, 0.0F);
        this.setRotation(this.wing[5], ((float)Math.PI * 2F / 9F), 0.0F, 0.0F);
        this.setRotation(this.wing[6], 0.3490659F, 0.0F, 0.0F);
        this.setRotation(this.wing[7], -0.0872665F, 0.0F, 0.0F);
        this.setRotation(this.wing[8], -((float)Math.PI / 2F), 0.0F, 0.0F);
        this.setRotation(this.wing[9], -((float)Math.PI / 2F), 0.0F, 0.0F);
        this.setRotation(this.wing[10], -0.4363323F, 0.0F, 0.0F);
        this.setRotation(this.wing[11], 0.3490659F, 0.0F, 0.0F);
        this.setRotation(this.wing[12], -0.1745329F, 0.0F, 0.0F);
        this.setRotation(this.wing[13], -((float)Math.PI / 4F), 0.0F, 0.0F);
        this.setRotation(this.wing[14], -0.4363323F, 0.0F, 0.0F);
        this.setRotation(this.wing[15], 0.6108652F, 0.0F, 0.0F);
        this.setRotation(this.wing[16], ((float)Math.PI / 2F), 0.0F, 0.0F);
        this.setRotation(this.wing[17], 0.8726646F, 0.0F, 0.0F);
        this.setRotation(this.wing[18], 0.0872665F, 0.0F, 0.0F);
        this.setRotation(this.wing[19], ((float)Math.PI * 2F / 9F), 0.0F, 0.0F);
        this.setRotation(this.wing[20], ((float)Math.PI / 2F), 0.0F, 0.0F);
        this.setRotation(this.wing[21], 1.832596F, 0.0F, 0.0F);
        this.setRotation(this.wing[22], 0.5235988F, 0.0F, 0.0F);
        this.setRotation(this.wing[23], 0.3490659F, 0.0F, 0.0F);
        this.setRotation(this.wing[24], -((float)Math.PI / 2F), 0.0F, ((float)Math.PI / 2F));
        this.setRotation(this.wing[25], -((float)Math.PI / 2F), 0.0F, ((float)Math.PI / 2F));
        this.setRotation(this.wing[26], ((float)Math.PI / 4F), 0.0F, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "body/wings_dragon_white.png"));
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        float f = MathHelper.cos(time * 0.25F) * 6.0F;
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.tex);
        GlStateManager.pushMatrix();
        GlStateManager.enableCull();
        this.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, 0.46F, 0.14F);
        GlStateManager.scale(0.88F, 0.88F, 0.88F);
        GlStateManager.cullFace(1028);
        GlStateManager.pushMatrix();
        GlStateManager.scale(-1.0F, 1.0F, 1.0F);
        GlStateManager.rotate(-30.0F, -1.0F, 0.5F, 0.0F);
        GlStateManager.rotate(f, 0.0F, -0.2F, 0.0F);
        this.renderModels();
        GlStateManager.popMatrix();
        GlStateManager.cullFace(1029);
        GlStateManager.pushMatrix();
        GlStateManager.rotate(-30.0F, -1.0F, 0.5F, 0.0F);
        GlStateManager.rotate(f, 0.0F, -0.2F, 0.0F);
        this.renderModels();
        GlStateManager.popMatrix();
        GlStateManager.disableCull();
        GlStateManager.popMatrix();
    }

    public void renderAsItem(float time)
    {
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.tex);
        GlStateManager.translate(0.0F, 0.0F, -0.2F);
        GlStateManager.scale(0.55F, 0.55F, 0.55F);
        GlStateManager.cullFace(1028);
        GlStateManager.pushMatrix();
        GlStateManager.scale(-1.0F, 1.0F, 1.0F);
        GlStateManager.rotate(35.0F, 1.0F, 1.5F, 0.0F);
        GlStateManager.translate(0.2F, 0.0F, 0.0F);
        this.renderModels();
        GlStateManager.popMatrix();
        GlStateManager.cullFace(1029);
        GlStateManager.pushMatrix();
        GlStateManager.rotate(35.0F, 1.0F, 1.5F, 0.0F);
        GlStateManager.translate(0.2F, 0.0F, 0.0F);
        this.renderModels();
        GlStateManager.popMatrix();
    }

    public String getCreator()
    {
        return "_Mik_";
    }

    public String getName()
    {
        return "\u041a\u0440\u044b\u043b\u044c\u044f \u0434\u0440\u0430\u043a\u043e\u043d\u0430";
    }
}
