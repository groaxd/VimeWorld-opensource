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

public class BatWings extends BaseItem
{
    private final MModelRenderer[] wings;

    public BatWings()
    {
        super(ItemType.BODY);
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.useDisplayLists = true;
        this.wings = new MModelRenderer[33];
        this.wings[0] = new MModelRenderer(this, 2, 27);
        this.wings[0].addBox(-2.0F, -0.63F, 3.23F, 1, 1, 14);
        this.wings[0].mirror = true;
        this.setRotation(this.wings[0], -1.012291F, 0.0F, 0.0F);
        this.wings[1] = new MModelRenderer(this, 72, 0);
        this.wings[1].addBox(-2.0F, 3.03F, -1.15F, 1, 1, 7);
        this.wings[1].mirror = true;
        this.setRotation(this.wings[1], 0.8203047F, 0.0F, 0.0F);
        this.wings[2] = new MModelRenderer(this, 118, 3);
        this.wings[2].addBox(-2.0F, -5.17F, 2.56F, 1, 1, 2);
        this.wings[2].mirror = true;
        this.setRotation(this.wings[2], -((float)Math.PI / 5F), 0.0F, 0.0F);
        this.wings[3] = new MModelRenderer(this, 124, 2);
        this.wings[3].addBox(-2.0F, -4.05F, 3.82F, 1, 1, 1);
        this.wings[3].mirror = true;
        this.setRotation(this.wings[3], -0.2792527F, 0.0F, 0.0F);
        this.wings[4] = new MModelRenderer(this, 118, 3);
        this.wings[4].addBox(-2.0F, -2.51F, 4.97F, 1, 1, 2);
        this.wings[4].mirror = true;
        this.setRotation(this.wings[4], 0.0698132F, 0.0F, 0.0F);
        this.wings[5] = new MModelRenderer(this, 73, 8);
        this.wings[5].addBox(-2.0F, 5.69F, 2.39F, 1, 1, 6);
        this.wings[5].mirror = true;
        this.setRotation(this.wings[5], 1.448623F, 0.0F, 0.0F);
        this.wings[6] = new MModelRenderer(this, 88, 0);
        this.wings[6].addBox(-2.0F, -7.57F, -0.97F, 1, 1, 5);
        this.wings[6].mirror = true;
        this.setRotation(this.wings[6], -1.32645F, 0.0F, 0.0F);
        this.wings[7] = new MModelRenderer(this, 100, 5);
        this.wings[7].addBox(-2.0F, -9.96F, -1.71F, 1, 1, 4);
        this.wings[7].mirror = true;
        this.setRotation(this.wings[7], -0.5934119F, 0.0F, 0.0F);
        this.wings[8] = new MModelRenderer(this, 124, 4);
        this.wings[8].addBox(-2.0F, -10.13F, 0.02F, 1, 1, 1);
        this.wings[8].mirror = true;
        this.setRotation(this.wings[8], -0.4014257F, 0.0F, 0.0F);
        this.wings[9] = new MModelRenderer(this, 100, 0);
        this.wings[9].addBox(-2.0F, -9.95F, 1.95F, 1, 1, 4);
        this.wings[9].mirror = true;
        this.setRotation(this.wings[9], -0.2094395F, 0.0F, 0.0F);
        this.wings[10] = new MModelRenderer(this, 124, 0);
        this.wings[10].addBox(-2.0F, -10.13F, 2.6F, 1, 1, 1);
        this.wings[10].mirror = true;
        this.setRotation(this.wings[10], -0.4014257F, 0.0F, 0.0F);
        this.wings[11] = new MModelRenderer(this, 32, 11);
        this.wings[11].addBox(-2.0F, -3.06F, 10.54F, 1, 1, 10);
        this.wings[11].mirror = true;
        this.setRotation(this.wings[11], 0.5759587F, 0.0F, 0.0F);
        this.wings[12] = new MModelRenderer(this, 32, 0);
        this.wings[12].addBox(-2.0F, 6.1F, 19.39F, 1, 1, 10);
        this.wings[12].mirror = true;
        this.setRotation(this.wings[12], 1.029744F, 0.0F, 0.0F);
        this.wings[13] = new MModelRenderer(this, 54, 0);
        this.wings[13].addBox(-2.0F, -8.9F, 7.45F, 1, 1, 8);
        this.wings[13].mirror = true;
        this.setRotation(this.wings[13], -0.0872665F, 0.0F, 0.0F);
        this.wings[14] = new MModelRenderer(this, 54, 9);
        this.wings[14].addBox(-2.0F, -5.54F, 16.75F, 1, 1, 8);
        this.wings[14].mirror = true;
        this.setRotation(this.wings[14], 0.122173F, 0.0F, 0.0F);
        this.wings[15] = new MModelRenderer(this, 4, 13);
        this.wings[15].addBox(-2.0F, -10.65F, 2.6F, 1, 1, 13);
        this.wings[15].mirror = true;
        this.setRotation(this.wings[15], -0.4886922F, 0.0F, 0.0F);
        this.wings[17] = new MModelRenderer(this, 118, 0);
        this.wings[17].addBox(-2.0F, -18.75F, 15.84F, 1, 1, 2);
        this.wings[17].mirror = true;
        this.setRotation(this.wings[17], -0.3490659F, 0.0F, 0.0F);
        this.wings[16] = new MModelRenderer(this, 6, 0);
        this.wings[16].addBox(-2.0F, -10.47F, -2.44F, 1, 1, 12);
        this.wings[16].mirror = true;
        this.setRotation(this.wings[16], -1.029744F, 0.0F, 0.0F);
        this.wings[18] = new MModelRenderer(this, 110, 0);
        this.wings[18].addBox(-2.0F, -9.55F, 17.15F, 1, 1, 3);
        this.wings[18].mirror = true;
        this.setRotation(this.wings[18], -0.1745329F, 0.0F, 0.0F);
        this.wings[19] = new MModelRenderer(this, 118, 6);
        this.wings[19].addBox(-2.0F, 2.65F, 11.8F, 1, 1, 2);
        this.wings[19].mirror = true;
        this.setRotation(this.wings[19], -0.5934119F, 0.0F, 0.0F);
        this.wings[20] = new MModelRenderer(this, 82, 59);
        this.wings[20].addBox(-1.5F, 9.6F, -12.56F, 0, 1, 3);
        this.wings[20].mirror = true;
        this.setRotation(this.wings[20], 1.466077F, 0.0F, 0.0F);
        this.wings[21] = new MModelRenderer(this, 80, 61);
        this.wings[21].addBox(-1.5F, 8.6F, -11.3F, 0, 1, 2);
        this.wings[21].mirror = true;
        this.setRotation(this.wings[21], 1.466077F, 0.0F, 0.0F);
        this.wings[22] = new MModelRenderer(this, 70, 45);
        this.wings[22].addBox(-1.5F, -0.55F, 4.85F, 0, 5, 9);
        this.wings[22].mirror = true;
        this.setRotation(this.wings[22], -0.6108652F, 0.0F, 0.0F);
        this.wings[23] = new MModelRenderer(this, 76, 59);
        this.wings[23].addBox(-1.5F, 7.1F, -2.5F, 0, 1, 3);
        this.wings[23].mirror = true;
        this.setRotation(this.wings[23], ((float)Math.PI * 2F / 5F), 0.0F, 0.0F);
        this.wings[24] = new MModelRenderer(this, 84, 61);
        this.wings[24].addBox(-1.5F, -13.45F, 2.55F, 0, 1, 2);
        this.wings[24].mirror = true;
        this.setRotation(this.wings[24], -1.448623F, 0.0F, 0.0F);
        this.wings[25] = new MModelRenderer(this, 76, 54);
        this.wings[25].addBox(-1.5F, 5.55F, 11.1F, 0, 1, 6);
        this.wings[25].mirror = true;
        this.setRotation(this.wings[25], 0.4363323F, 0.0F, 0.0F);
        this.wings[26] = new MModelRenderer(this, 80, 57);
        this.wings[26].addBox(-1.5F, 11.75F, 13.8F, 0, 1, 4);
        this.wings[26].mirror = true;
        this.setRotation(this.wings[26], 0.8552113F, 0.0F, 0.0F);
        this.wings[27] = new MModelRenderer(this, 70, 59);
        this.wings[27].addBox(-1.5F, 5.7F, 21.25F, 0, 1, 3);
        this.wings[27].mirror = true;
        this.setRotation(this.wings[27], 0.5759587F, 0.0F, 0.0F);
        this.wings[28] = new MModelRenderer(this, 64, 59);
        this.wings[28].addBox(-1.5F, 13.68F, 17.5F, 0, 1, 3);
        this.wings[28].mirror = true;
        this.setRotation(this.wings[28], 1.064651F, 0.0F, 0.0F);
        this.wings[29] = new MModelRenderer(this, 68, 49);
        this.wings[29].addBox(-1.5F, -24.85F, -17.16F, 0, 1, 10);
        this.wings[29].mirror = true;
        this.setRotation(this.wings[29], -1.396263F, 0.0F, 0.0F);
        this.wings[30] = new MModelRenderer(this, 88, 19);
        this.wings[30].addBox(-1.5F, -20.98F, 2.33F, 0, 25, 20);
        this.wings[30].mirror = true;
        this.setRotation(this.wings[30], 0.0F, 0.0F, 0.0F);
        this.wings[31] = new MModelRenderer(this, 88, 6);
        this.wings[31].addBox(-2.0F, 2.13F, 3.0F, 1, 1, 5);
        this.wings[31].mirror = true;
        this.setRotation(this.wings[31], -0.2617994F, 0.0F, 0.0F);
        this.wings[32] = new MModelRenderer(this, 72, 61);
        this.wings[32].addBox(-1.5F, 5.7F, 21.1F, 0, 1, 1);
        this.wings[32].mirror = true;
        this.setRotation(this.wings[32], 0.5759587F, 0.0F, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "body/bat_wings.png"));
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        float f = MathHelper.cos(time * 0.18F) * 8.0F;
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.tex);
        GlStateManager.pushMatrix();
        GlStateManager.enableCull();
        this.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, 0.1F, 0.05F);
        GlStateManager.scale(0.75F, 0.75F, 0.65F);
        GlStateManager.cullFace(1028);
        GlStateManager.pushMatrix();
        GlStateManager.scale(-1.0F, 1.0F, 1.0F);
        GlStateManager.translate(-0.1F, 0.0F, 0.03F);
        GlStateManager.rotate(-16.0F, 1.0F, 1.0F, 0.0F);
        GlStateManager.rotate(f, 0.0F, -0.2F, 0.0F);
        GlStateManager.translate(0.07F, 0.0F, 0.0F);
        this.renderModels();
        GlStateManager.popMatrix();
        GlStateManager.cullFace(1029);
        GlStateManager.pushMatrix();
        GlStateManager.translate(-0.1F, 0.0F, 0.03F);
        GlStateManager.rotate(-16.0F, 1.0F, 1.0F, 0.0F);
        GlStateManager.rotate(f, 0.0F, -0.2F, 0.0F);
        GlStateManager.translate(0.07F, 0.0F, 0.0F);
        this.renderModels();
        GlStateManager.popMatrix();
        GlStateManager.disableCull();
        GlStateManager.popMatrix();
    }

    public void renderAsItem(float time)
    {
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.tex);
        GlStateManager.translate(0.0F, 0.07F, -0.35F);
        GlStateManager.scale(0.42F, 0.34F, 0.34F);
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
        return "_Mik_";
    }

    public String getName()
    {
        return "\u041a\u0440\u044b\u043b\u044c\u044f \u043b\u0435\u0442\u0443\u0447\u0435\u0439 \u043c\u044b\u0448\u0438";
    }
}
