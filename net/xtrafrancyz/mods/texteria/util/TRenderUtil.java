package net.xtrafrancyz.mods.texteria.util;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

public class TRenderUtil
{
    public static void drawRect(double x, double y, double width, double height, int color)
    {
        float f = (float)(color >> 24 & 255) / 255.0F;
        float f1 = (float)(color >> 16 & 255) / 255.0F;
        float f2 = (float)(color >> 8 & 255) / 255.0F;
        float f3 = (float)(color & 255) / 255.0F;
        GlStateManager.color(f1, f2, f3, f);
        GlStateManager.disableTexture2D();
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(7, DefaultVertexFormats.POSITION);
        worldrenderer.pos(x, y + height, 0.0D).endVertex();
        worldrenderer.pos(x + width, y + height, 0.0D).endVertex();
        worldrenderer.pos(x + width, y, 0.0D).endVertex();
        worldrenderer.pos(x, y, 0.0D).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
    }

    public static void drawTexturedRect(int x, int y, float u, float v, float width, float height, float textureWidth, float textureHeight)
    {
        float f = 1.0F / textureWidth;
        float f1 = 1.0F / textureHeight;
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        worldrenderer.pos((double)x, (double)((float)y + height), 0.0D).tex((double)(u * f), (double)((v + height) * f1)).endVertex();
        worldrenderer.pos((double)((float)x + width), (double)((float)y + height), 0.0D).tex((double)((u + width) * f), (double)((v + height) * f1)).endVertex();
        worldrenderer.pos((double)((float)x + width), (double)y, 0.0D).tex((double)((u + width) * f), (double)(v * f1)).endVertex();
        worldrenderer.pos((double)x, (double)y, 0.0D).tex((double)(u * f), (double)(v * f1)).endVertex();
        tessellator.draw();
    }

    public static void drawRepeatedTexturedRect(int x, int y, float u, float v, float width, float height, float textureWidth, float textureHeight)
    {
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        worldrenderer.pos((double)x, (double)((float)y + height), 0.0D).tex((double)(u * textureWidth), (double)((v + height) * textureHeight)).endVertex();
        worldrenderer.pos((double)((float)x + width), (double)((float)y + height), 0.0D).tex((double)((u + width) * textureWidth), (double)((v + height) * textureHeight)).endVertex();
        worldrenderer.pos((double)((float)x + width), (double)y, 0.0D).tex((double)((u + width) * textureWidth), (double)(v * textureHeight)).endVertex();
        worldrenderer.pos((double)x, (double)y, 0.0D).tex((double)(u * textureWidth), (double)(v * textureHeight)).endVertex();
        tessellator.draw();
    }

    public static void drawScaledTexturedRect(int x, int y, float u, float v, float uWidth, float vHeight, float width, float height, float textureWidth, float textureHeight)
    {
        float f = 1.0F / textureWidth;
        float f1 = 1.0F / textureHeight;
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        worldrenderer.pos((double)x, (double)((float)y + height), 0.0D).tex((double)(u * f), (double)((v + vHeight) * f1)).endVertex();
        worldrenderer.pos((double)((float)x + width), (double)((float)y + height), 0.0D).tex((double)((u + uWidth) * f), (double)((v + vHeight) * f1)).endVertex();
        worldrenderer.pos((double)((float)x + width), (double)y, 0.0D).tex((double)((u + uWidth) * f), (double)(v * f1)).endVertex();
        worldrenderer.pos((double)x, (double)y, 0.0D).tex((double)(u * f), (double)(v * f1)).endVertex();
        tessellator.draw();
    }
}
