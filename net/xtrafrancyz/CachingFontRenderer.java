package net.xtrafrancyz;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import org.apache.logging.log4j.LogManager;
import org.lwjgl.opengl.GL11;

public class CachingFontRenderer
{
    public static final boolean disabled = Boolean.getBoolean("CachingFontRenderer.disabled");
    private static final Cache<CachingFontRenderer.CacheKey, CachingFontRenderer.StringDrawingPair> DISPLAY_LISTS_CACHE = CacheBuilder.newBuilder().expireAfterAccess(2L, TimeUnit.SECONDS).removalListener((removalNotification) ->
    {
        GL11.glDeleteLists(((CachingFontRenderer.StringDrawingPair)removalNotification.getValue()).displayListId, 1);
    }).<CachingFontRenderer.CacheKey, CachingFontRenderer.StringDrawingPair>build();
    private static final CachingFontRenderer.CacheKey CACHE_KEY_TEMP = new CachingFontRenderer.CacheKey(0, false, (String)null);

    public static void flushCache()
    {
        DISPLAY_LISTS_CACHE.invalidateAll();
    }

    public static int drawString(String text, float x, float y, int color, boolean withShadow)
    {
        Minecraft minecraft = Minecraft.getMinecraft();
        FontRenderer fontrenderer = minecraft.fontRendererObj;

        if (!disabled && canStringBeCached(text))
        {
            CachingFontRenderer.StringDrawingPair cachingfontrenderer$stringdrawingpair = (CachingFontRenderer.StringDrawingPair)DISPLAY_LISTS_CACHE.getIfPresent(CACHE_KEY_TEMP.set(color, withShadow, text));

            if (cachingfontrenderer$stringdrawingpair == null)
            {
                fontrenderer.drawString0(text, x, y, color, withShadow);
            }

            GlStateManager.enableAlpha();
            GlStateManager.enableTexture2D();
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.pushMatrix();
            GlStateManager.translate(x, y, 0.0F);

            if (cachingfontrenderer$stringdrawingpair == null)
            {
                GlStateManager.bindTexture(0);
                int i = GLAllocation.generateDisplayLists(1);
                GL11.glNewList(i, GL11.GL_COMPILE);
                int j = fontrenderer.drawString0(text, 0.0F, 0.0F, color, withShadow);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                GL11.glEndList();
                cachingfontrenderer$stringdrawingpair = new CachingFontRenderer.StringDrawingPair(i, j);
                cachingfontrenderer$stringdrawingpair.resultingTexture = GlStateManager.getBoundTexture();
                GlStateManager.bindCurrentTexture();
                DISPLAY_LISTS_CACHE.put(new CachingFontRenderer.CacheKey(color, withShadow, text), cachingfontrenderer$stringdrawingpair);
            }
            else
            {
                GlStateManager.callList(cachingfontrenderer$stringdrawingpair.displayListId);
                GlStateManager.unsafeUpdateTextureId(cachingfontrenderer$stringdrawingpair.resultingTexture);
            }

            GlStateManager.popMatrix();
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            return (int)x + cachingfontrenderer$stringdrawingpair.returnableInteger;
        }
        else
        {
            return fontrenderer.drawString0(text, x, y, color, withShadow);
        }
    }

    private static boolean canStringBeCached(String str)
    {
        return !str.contains("\u00a7k") && str.length() > 2;
    }

    static
    {
        LogManager.getLogger("CachingFontRenderer").info("CachingFontRenderer Enabled: " + !disabled);
    }

    private static class CacheKey
    {
        private int color;
        private boolean shadow;
        private String text;

        public CacheKey(int color, boolean shadow, String text)
        {
            this.set(color, shadow, text);
        }

        CachingFontRenderer.CacheKey set(int color, boolean shadow, String text)
        {
            this.color = color;
            this.shadow = shadow;
            this.text = text;
            return this;
        }

        public int hashCode()
        {
            return Objects.hash(new Object[] {Integer.valueOf(this.color), Boolean.valueOf(this.shadow), this.text});
        }

        public boolean equals(Object o)
        {
            CachingFontRenderer.CacheKey cachingfontrenderer$cachekey = (CachingFontRenderer.CacheKey)o;
            return this.color == cachingfontrenderer$cachekey.color && this.shadow == cachingfontrenderer$cachekey.shadow && Objects.equals(this.text, cachingfontrenderer$cachekey.text);
        }
    }

    private static class StringDrawingPair
    {
        private final int displayListId;
        private final int returnableInteger;
        private int resultingTexture;

        private StringDrawingPair(int displayListId, int returnableInteger)
        {
            this.displayListId = displayListId;
            this.returnableInteger = returnableInteger;
        }
    }
}
