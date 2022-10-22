package net.minecraft.client.renderer;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.Proxy.Type;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.VimeSkinStorage;
import optifine.Config;
import optifine.HttpPipeline;
import optifine.HttpRequest;
import optifine.HttpResponse;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadDownloadImageData extends SimpleTexture
{
    private static final boolean debug = Boolean.getBoolean("DebugSkinLoading");
    private static final Pattern SKIN_URL_PATTERN = Pattern.compile("^https?://(?:textures\\.minecraft\\.net/texture/[a-zA-Z0-9_.-]+|mc\\.vimeworld.(?:ru|com)/launcher/(?:skins|cloaks)/[a-zA-Z0-9\u0410-\u042f\u0430-\u044f_-]+\\.png(?:\\?.+)?)$");
    private static final Logger logger = LogManager.getLogger();
    private static final AtomicInteger threadDownloadCounter = new AtomicInteger(0);
    private final VimeSkinStorage.Entry cacheEntry;
    private final String imageUrl;
    private final IImageBuffer imageBuffer;
    private BufferedImage bufferedImage;
    private Thread imageThread;
    private boolean textureUploaded;
    private static final String __OBFID = "CL_00001049";
    public Boolean imageFound = null;
    public boolean pipeline = false;
    public Long checkFileTime = null;

    public ThreadDownloadImageData(VimeSkinStorage.Entry p_i15_1_, String p_i15_2_, ResourceLocation p_i15_3_, IImageBuffer p_i15_4_)
    {
        super(p_i15_3_);
        this.cacheEntry = p_i15_1_;
        this.imageUrl = p_i15_2_;
        this.imageBuffer = p_i15_4_;
    }

    private void checkTextureUploaded()
    {
        if (!this.textureUploaded && this.bufferedImage != null)
        {
            this.textureUploaded = true;

            if (this.textureLocation != null)
            {
                this.deleteGlTexture();
            }

            TextureUtil.uploadTextureImage(super.getGlTextureId(), this.bufferedImage);
        }
    }

    public int getGlTextureId()
    {
        this.checkTextureUploaded();
        return super.getGlTextureId();
    }

    public void setBufferedImage(BufferedImage bufferedImageIn)
    {
        this.bufferedImage = bufferedImageIn;

        if (this.imageBuffer != null)
        {
            this.imageBuffer.skinAvailable();
        }

        this.imageFound = Boolean.valueOf(this.bufferedImage != null);
    }

    public void loadTexture(IResourceManager resourceManager) throws IOException
    {
        if (this.bufferedImage == null && this.textureLocation != null)
        {
            super.loadTexture(resourceManager);
        }

        if (this.imageFound == null)
        {
            this.loadTextureFromServer();
        }
    }

    protected void loadTextureFromServer()
    {
        if (!SKIN_URL_PATTERN.matcher(this.imageUrl).matches())
        {
            logger.warn("Texture " + this.imageUrl + " is not loaded due to whitelist");
            this.imageFound = Boolean.valueOf(false);
        }
        else
        {
            this.imageThread = new Thread("Texture Downloader #" + threadDownloadCounter.incrementAndGet())
            {
                private static final String __OBFID = "CL_00001050";
                private boolean tryLoadFromCache()
                {
                    if (ThreadDownloadImageData.this.cacheEntry != null && ThreadDownloadImageData.this.cacheEntry.exists())
                    {
                        if (ThreadDownloadImageData.this.checkFileTime != null && ThreadDownloadImageData.this.cacheEntry.getLastModify() < ThreadDownloadImageData.this.checkFileTime.longValue())
                        {
                            if (ThreadDownloadImageData.debug)
                            {
                                ThreadDownloadImageData.logger.info("Texture is newer than on disk ({}, {} > {})", new Object[] {ThreadDownloadImageData.this.cacheEntry.getPath(), ThreadDownloadImageData.this.checkFileTime, Long.valueOf(ThreadDownloadImageData.this.cacheEntry.getLastModify())});
                            }

                            return false;
                        }

                        if (ThreadDownloadImageData.debug)
                        {
                            ThreadDownloadImageData.logger.info("Loading http texture from local cache ({})", new Object[] {ThreadDownloadImageData.this.cacheEntry.getPath()});
                        }

                        try
                        {
                            FileInputStream fileinputstream = ThreadDownloadImageData.this.cacheEntry.getInputStream();
                            Throwable throwable = null;

                            try
                            {
                                ThreadDownloadImageData.this.bufferedImage = ImageIO.read((InputStream)fileinputstream);
                            }
                            catch (Throwable throwable2)
                            {
                                throwable = throwable2;
                                throw throwable2;
                            }
                            finally
                            {
                                if (fileinputstream != null)
                                {
                                    if (throwable != null)
                                    {
                                        try
                                        {
                                            fileinputstream.close();
                                        }
                                        catch (Throwable throwable1)
                                        {
                                            throwable.addSuppressed(throwable1);
                                        }
                                    }
                                    else
                                    {
                                        fileinputstream.close();
                                    }
                                }
                            }

                            if (ThreadDownloadImageData.this.imageBuffer != null)
                            {
                                ThreadDownloadImageData.this.setBufferedImage(ThreadDownloadImageData.this.imageBuffer.parseUserSkin(ThreadDownloadImageData.this.bufferedImage));
                            }

                            ThreadDownloadImageData.this.imageFound = Boolean.valueOf(ThreadDownloadImageData.this.bufferedImage != null);
                            return true;
                        }
                        catch (IOException ioexception)
                        {
                            ThreadDownloadImageData.logger.error((String)("Couldn\'t load skin " + ThreadDownloadImageData.this.cacheEntry.getPath()), (Throwable)ioexception);
                            ThreadDownloadImageData.this.cacheEntry.delete();
                        }
                    }

                    return false;
                }
                public void run()
                {
                    if (!this.tryLoadFromCache())
                    {
                        HttpURLConnection httpurlconnection = null;

                        if (ThreadDownloadImageData.debug)
                        {
                            ThreadDownloadImageData.logger.info("Downloading http texture from {} to {}", new Object[] {ThreadDownloadImageData.this.imageUrl, ThreadDownloadImageData.this.cacheEntry.getPath()});
                        }

                        if (ThreadDownloadImageData.this.shouldPipeline())
                        {
                            ThreadDownloadImageData.this.loadPipelined();
                        }
                        else
                        {
                            try
                            {
                                httpurlconnection = (HttpURLConnection)(new URL(ThreadDownloadImageData.this.imageUrl)).openConnection(Minecraft.getMinecraft().getProxy());
                                httpurlconnection.setDoInput(true);
                                httpurlconnection.setDoOutput(false);
                                httpurlconnection.connect();

                                if (httpurlconnection.getResponseCode() / 100 == 2)
                                {
                                    BufferedImage bufferedimage;

                                    if (ThreadDownloadImageData.this.cacheEntry != null)
                                    {
                                        try
                                        {
                                            OutputStream outputstream = ThreadDownloadImageData.this.cacheEntry.getOutputStream();
                                            Throwable throwable = null;

                                            try
                                            {
                                                IOUtils.copy(httpurlconnection.getInputStream(), outputstream);
                                            }
                                            catch (Throwable throwable4)
                                            {
                                                throwable = throwable4;
                                                throw throwable4;
                                            }
                                            finally
                                            {
                                                if (outputstream != null)
                                                {
                                                    if (throwable != null)
                                                    {
                                                        try
                                                        {
                                                            outputstream.close();
                                                        }
                                                        catch (Throwable throwable2)
                                                        {
                                                            throwable.addSuppressed(throwable2);
                                                        }
                                                    }
                                                    else
                                                    {
                                                        outputstream.close();
                                                    }
                                                }
                                            }
                                        }
                                        catch (Exception exception)
                                        {
                                            ThreadDownloadImageData.this.cacheEntry.delete();
                                            throw exception;
                                        }

                                        if (ThreadDownloadImageData.this.checkFileTime != null)
                                        {
                                            ThreadDownloadImageData.this.cacheEntry.setLastModify(ThreadDownloadImageData.this.checkFileTime.longValue());
                                        }

                                        ThreadDownloadImageData.this.cacheEntry.save(2592000);
                                        FileInputStream fileinputstream = ThreadDownloadImageData.this.cacheEntry.getInputStream();
                                        Throwable throwable5 = null;

                                        try
                                        {
                                            bufferedimage = ImageIO.read((InputStream)fileinputstream);
                                        }
                                        catch (Throwable throwable3)
                                        {
                                            throwable5 = throwable3;
                                            throw throwable3;
                                        }
                                        finally
                                        {
                                            if (fileinputstream != null)
                                            {
                                                if (throwable5 != null)
                                                {
                                                    try
                                                    {
                                                        fileinputstream.close();
                                                    }
                                                    catch (Throwable throwable1)
                                                    {
                                                        throwable5.addSuppressed(throwable1);
                                                    }
                                                }
                                                else
                                                {
                                                    fileinputstream.close();
                                                }
                                            }
                                        }
                                    }
                                    else
                                    {
                                        bufferedimage = TextureUtil.readBufferedImage(httpurlconnection.getInputStream());
                                    }

                                    if (ThreadDownloadImageData.this.imageBuffer != null)
                                    {
                                        bufferedimage = ThreadDownloadImageData.this.imageBuffer.parseUserSkin(bufferedimage);
                                    }

                                    ThreadDownloadImageData.this.setBufferedImage(bufferedimage);
                                    return;
                                }

                                if (httpurlconnection.getErrorStream() != null)
                                {
                                    Config.readAll(httpurlconnection.getErrorStream());
                                }

                                return;
                            }
                            catch (Exception exception1)
                            {
                                ThreadDownloadImageData.logger.error("Couldn\'t download http texture " + ThreadDownloadImageData.this.imageUrl + ": " + exception1.getClass().getName() + ": " + exception1.getMessage());
                            }
                            finally
                            {
                                if (httpurlconnection != null)
                                {
                                    httpurlconnection.disconnect();
                                }

                                ThreadDownloadImageData.this.imageFound = Boolean.valueOf(ThreadDownloadImageData.this.bufferedImage != null);
                            }
                        }
                    }
                }
            };
            this.imageThread.setDaemon(true);
            this.imageThread.start();
        }
    }

    private boolean shouldPipeline()
    {
        if (!this.pipeline)
        {
            return false;
        }
        else
        {
            Proxy proxy = Minecraft.getMinecraft().getProxy();
            return proxy.type() != Type.DIRECT && proxy.type() != Type.SOCKS ? false : this.imageUrl.startsWith("http://");
        }
    }

    private void loadPipelined()
    {
        try
        {
            HttpRequest httprequest = HttpPipeline.makeRequest(this.imageUrl, Minecraft.getMinecraft().getProxy());
            HttpResponse httpresponse = HttpPipeline.executeRequest(httprequest);

            if (httpresponse.getStatus() / 100 == 2)
            {
                byte[] abyte = httpresponse.getBody();
                ByteArrayInputStream bytearrayinputstream = new ByteArrayInputStream(abyte);
                BufferedImage bufferedimage;

                if (this.cacheEntry != null)
                {
                    try
                    {
                        OutputStream outputstream = this.cacheEntry.getOutputStream();
                        Throwable throwable = null;

                        try
                        {
                            IOUtils.copy((InputStream)bytearrayinputstream, (OutputStream)outputstream);
                        }
                        catch (Throwable throwable4)
                        {
                            throwable = throwable4;
                            throw throwable4;
                        }
                        finally
                        {
                            if (outputstream != null)
                            {
                                if (throwable != null)
                                {
                                    try
                                    {
                                        outputstream.close();
                                    }
                                    catch (Throwable throwable2)
                                    {
                                        throwable.addSuppressed(throwable2);
                                    }
                                }
                                else
                                {
                                    outputstream.close();
                                }
                            }
                        }
                    }
                    catch (Exception exception)
                    {
                        this.cacheEntry.delete();
                        throw exception;
                    }

                    if (this.checkFileTime != null)
                    {
                        this.cacheEntry.setLastModify(this.checkFileTime.longValue());
                    }

                    this.cacheEntry.save(2592000);
                    FileInputStream fileinputstream = this.cacheEntry.getInputStream();
                    Throwable throwable5 = null;

                    try
                    {
                        bufferedimage = ImageIO.read((InputStream)fileinputstream);
                    }
                    catch (Throwable throwable3)
                    {
                        throwable5 = throwable3;
                        throw throwable3;
                    }
                    finally
                    {
                        if (fileinputstream != null)
                        {
                            if (throwable5 != null)
                            {
                                try
                                {
                                    fileinputstream.close();
                                }
                                catch (Throwable throwable1)
                                {
                                    throwable5.addSuppressed(throwable1);
                                }
                            }
                            else
                            {
                                fileinputstream.close();
                            }
                        }
                    }
                }
                else
                {
                    bufferedimage = TextureUtil.readBufferedImage(bytearrayinputstream);
                }

                if (this.imageBuffer != null)
                {
                    bufferedimage = this.imageBuffer.parseUserSkin(bufferedimage);
                }

                this.setBufferedImage(bufferedimage);
                return;
            }
        }
        catch (Exception exception1)
        {
            logger.error("Couldn\'t download http texture: " + exception1.getClass().getName() + ": " + exception1.getMessage());
            return;
        }
        finally
        {
            this.imageFound = Boolean.valueOf(this.bufferedImage != null);
        }
    }
}
