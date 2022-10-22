package net.minecraft.client.resources;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Maps;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.InsecureTextureException;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IImageBuffer;
import net.minecraft.client.renderer.ImageBufferDownload;
import net.minecraft.client.renderer.LegacyCapeTransformer;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.VimeSkinStorage;

public class SkinManager
{
    private static final List<String> REPLACE_DOMAINS = Arrays.<String>asList(new String[] {"http://mc.vimeworld.ru/", "https://mc.vimeworld.ru/", "http://mc.vimeworld.com/"});
    private static final ExecutorService THREAD_POOL = new ThreadPoolExecutor(0, 2, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue());
    private final TextureManager textureManager;
    private final File skinCacheDir;
    private final File capeCacheDir;
    private final MinecraftSessionService sessionService;
    private final LoadingCache<GameProfile, Map<Type, MinecraftProfileTexture>> skinCacheLoader;

    public SkinManager(TextureManager textureManagerInstance, File skinCacheDirectory, MinecraftSessionService sessionService)
    {
        this.textureManager = textureManagerInstance;
        this.skinCacheDir = skinCacheDirectory;
        this.capeCacheDir = new File(this.skinCacheDir.getParentFile(), "capes");
        this.sessionService = sessionService;
        this.skinCacheLoader = CacheBuilder.newBuilder().expireAfterAccess(15L, TimeUnit.SECONDS).<GameProfile, Map<Type, MinecraftProfileTexture>>build(new CacheLoader<GameProfile, Map<Type, MinecraftProfileTexture>>()
        {
            public Map<Type, MinecraftProfileTexture> load(GameProfile p_load_1_) throws Exception
            {
                return Minecraft.getMinecraft().getSessionService().getTextures(p_load_1_, false);
            }
        });
    }

    /**
     * Used in the Skull renderer to fetch a skin. May download the skin if it's not in the cache
     */
    public ResourceLocation loadSkin(MinecraftProfileTexture profileTexture, Type p_152792_2_)
    {
        return this.loadSkin(profileTexture, p_152792_2_, (SkinManager.SkinAvailableCallback)null);
    }

    /**
     * May download the skin if its not in the cache, can be passed a SkinManager#SkinAvailableCallback for handling
     */
    public ResourceLocation loadSkin(final MinecraftProfileTexture profileTexture, final Type p_152789_2_, final SkinManager.SkinAvailableCallback skinAvailableCallback)
    {
        String s = profileTexture.getHash();
        final VimeSkinStorage.Entry vimeskinstorage$entry = Minecraft.getMinecraft().skinStorage.getEntryForTexture(p_152789_2_, s);
        final ResourceLocation resourcelocation = new ResourceLocation((p_152789_2_ == Type.SKIN ? "skins/" : "capes/") + s + ".png");
        ITextureObject itextureobject = this.textureManager.getTexture(resourcelocation);

        if (itextureobject != null)
        {
            if (itextureobject instanceof ThreadDownloadImageData && ((ThreadDownloadImageData)itextureobject).imageFound != Boolean.TRUE)
            {
                if (skinAvailableCallback != null)
                {
                    skinAvailableCallback.skinAvailable(p_152789_2_, DefaultPlayerSkin.getDefaultSkinLegacy(), profileTexture);
                }

                return DefaultPlayerSkin.getDefaultSkinLegacy();
            }

            boolean flag = vimeskinstorage$entry.exists() && vimeskinstorage$entry.getLastModify() < profileTexture.timestamp;

            if (!profileTexture.getUrl().contains("://mc.vimeworld."))
            {
                flag = false;
            }

            if (!flag)
            {
                if (skinAvailableCallback != null)
                {
                    skinAvailableCallback.skinAvailable(p_152789_2_, resourcelocation, profileTexture);
                }

                return resourcelocation;
            }
        }

        if (itextureobject instanceof AbstractTexture)
        {
            ((AbstractTexture)itextureobject).deleteGlTexture();
        }

        String s2 = profileTexture.getUrl();

        for (String s1 : REPLACE_DOMAINS)
        {
            if (s2.startsWith(s1))
            {
                s2 = "https://mc.vimeworld.com/" + s2.substring(s1.length());
                break;
            }
        }

        if (s2.startsWith("https://mc.vimeworld.com/"))
        {
            if (s2.contains("?"))
            {
                s2 = s2 + "&t=" + profileTexture.timestamp;
            }
            else
            {
                s2 = s2 + "?t=" + profileTexture.timestamp;
            }
        }

        final IImageBuffer iimagebuffer = (IImageBuffer)(p_152789_2_ == Type.SKIN ? new ImageBufferDownload() : new LegacyCapeTransformer());
        ThreadDownloadImageData threaddownloadimagedata = new ThreadDownloadImageData(vimeskinstorage$entry, s2, DefaultPlayerSkin.getDefaultSkinLegacy(), new IImageBuffer()
        {
            public BufferedImage parseUserSkin(BufferedImage image)
            {
                return iimagebuffer.parseUserSkin(image);
            }
            public void skinAvailable()
            {
                vimeskinstorage$entry.setLastModify(profileTexture.timestamp);
                iimagebuffer.skinAvailable();

                if (skinAvailableCallback != null)
                {
                    skinAvailableCallback.skinAvailable(p_152789_2_, resourcelocation, profileTexture);
                }
            }
        });
        threaddownloadimagedata.checkFileTime = Long.valueOf(profileTexture.timestamp);
        this.textureManager.loadTexture(resourcelocation, threaddownloadimagedata);
        return resourcelocation;
    }

    public void loadProfileTextures(final GameProfile profile, final SkinManager.SkinAvailableCallback skinAvailableCallback, final boolean requireSecure)
    {
        THREAD_POOL.submit(new Runnable()
        {
            public void run()
            {
                final Map<Type, MinecraftProfileTexture> map = Maps.<Type, MinecraftProfileTexture>newHashMap();

                try
                {
                    map.putAll(SkinManager.this.sessionService.getTextures(profile, requireSecure));
                }
                catch (InsecureTextureException var3)
                {
                    ;
                }

                if (map.isEmpty() && profile.getId().equals(Minecraft.getMinecraft().getSession().getProfile().getId()))
                {
                    profile.getProperties().clear();
                    profile.getProperties().putAll(Minecraft.getMinecraft().func_181037_M());
                    map.putAll(SkinManager.this.sessionService.getTextures(profile, false));
                }

                Minecraft.getMinecraft().addScheduledTask(new Runnable()
                {
                    public void run()
                    {
                        if (map.containsKey(Type.SKIN))
                        {
                            SkinManager.this.loadSkin((MinecraftProfileTexture)map.get(Type.SKIN), Type.SKIN, skinAvailableCallback);
                        }

                        if (map.containsKey(Type.CAPE))
                        {
                            SkinManager.this.loadSkin((MinecraftProfileTexture)map.get(Type.CAPE), Type.CAPE, skinAvailableCallback);
                        }
                    }
                });
            }
        });
    }

    public Map<Type, MinecraftProfileTexture> loadSkinFromCache(GameProfile profile)
    {
        return (Map)this.skinCacheLoader.getUnchecked(profile);
    }

    public interface SkinAvailableCallback
    {
        void skinAvailable(Type p_180521_1_, ResourceLocation location, MinecraftProfileTexture profileTexture);
    }

    private static class SkinTime
    {
        long time;
    }
}
