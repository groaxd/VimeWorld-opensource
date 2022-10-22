package net.xtrafrancyz.mods.texteria.elements;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.ImageObserver;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.VimeStorage;
import net.xtrafrancyz.mods.texteria.Texteria;
import net.xtrafrancyz.mods.texteria.resources.TexteriaResource;
import net.xtrafrancyz.mods.texteria.util.Fluidity;
import net.xtrafrancyz.mods.texteria.util.TRenderUtil;
import net.xtrafrancyz.mods.texteria.util.maxrects.MaxRectsPacker;
import net.xtrafrancyz.util.ByteMap;
import net.xtrafrancyz.util.PngDecoder;
import net.xtrafrancyz.util.StreamingGifDecoder;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;

public class Image extends Rectangle
{
    private static final Map<Image.ImageDescriptor, Image.ImageInfo> inMemoryCache = new HashMap();
    private static final List<Image.TextureAtlas> FREE_ATLASES = new ArrayList();
    private static final Map<Integer, Image.TextureAtlas> ALL_ATLASES = new HashMap();
    private static final int MAX_TEX_SIZE = Minecraft.getGLMaximumTextureSize();
    private static final int ATLAX_TEX_SIZE = Math.min(MAX_TEX_SIZE, 2048);
    public final Image.ImageInfo image;
    private final boolean useMemCache;
    public final float gifSpeed;
    public final int loadingColor;
    public Image.AnimationContext animationContext;
    public final Image.TextureRenderHint textureRenderHint;
    private static final byte[] PNG_MAGIC = new byte[] {(byte) - 119, (byte)80, (byte)78, (byte)71, (byte)13, (byte)10, (byte)26, (byte)10};

    public Image(ByteMap params)
    {
        super(params);
        this.loadingColor = params.getInt("lc", 16777215);
        this.gifSpeed = params.getFloat("gs", 1.0F);
        this.textureRenderHint = (Image.TextureRenderHint)params.getStringEnum("trh", Image.TextureRenderHint.CLAMP);
        Image.LoadingRequest image$loadingrequest = new Image.LoadingRequest(params.getString("image"));
        image$loadingrequest.data = params.getByteArray("idata");
        image$loadingrequest.gifStreaming = params.getBoolean("gst", false);
        image$loadingrequest.fileCache = params.getBoolean("cache", true);
        image$loadingrequest.memCache = image$loadingrequest.fileCache && !image$loadingrequest.gifStreaming;
        image$loadingrequest.textureRenderHint = this.textureRenderHint;
        this.image = createImage(image$loadingrequest);
        this.useMemCache = image$loadingrequest.memCache;

        if (this.image == null)
        {
            throw new IllegalStateException("Unresolved image");
        }
    }

    protected void init()
    {
        this.animationContext = new Image.AnimationContext(this.startTime);

        if (Math.abs(this.gifSpeed - 1.0F) > 0.001F)
        {
            this.animationContext.speedModifier = (double)this.gifSpeed;
        }
    }

    public void render(long time)
    {
        switch (this.image.loadingState)
        {
            case LOADING:
                TRenderUtil.drawRect(0.0D, 0.0D, (double)this.getWidth(), (double)this.getHeight(), this.setAlphaToBaseColorIfGreater(this.loadingColor));
                break;

            case ERROR:
                TRenderUtil.drawRect(0.0D, 0.0D, (double)this.getWidth(), (double)this.getHeight(), this.setAlphaToBaseColor(-21846));
                break;

            case READY:
                GlStateManager.enableTexture2D();
                this.setColor(this.color.render);
                this.image.render(this, time);
        }
    }

    public float getHeight()
    {
        return this.heightFluidity == Fluidity.WRAP_CONTENT ? (float)this.image.getHeight() : super.getHeight();
    }

    public float getWidth()
    {
        return this.widthFluidity == Fluidity.WRAP_CONTENT ? (float)this.image.getWidth() : super.getWidth();
    }

    public void dispose()
    {
        if (!this.useMemCache && this.image != null)
        {
            this.image.dispose();
        }

        super.dispose();
    }

    public static Image.ImageInfo createImage(Image.LoadingRequest request)
    {
        Image.ImageDescriptor image$imagedescriptor = new Image.ImageDescriptor(request.path, request.textureRenderHint);
        Image.ImageInfo image$imageinfo = request.memCache ? (Image.ImageInfo)inMemoryCache.get(image$imagedescriptor) : null;

        if (image$imageinfo == null)
        {
            if (!image$imagedescriptor.id.startsWith("http:") && !image$imagedescriptor.id.startsWith("https:") && !image$imagedescriptor.id.startsWith("file:") && !image$imagedescriptor.id.startsWith("#"))
            {
                if (!image$imagedescriptor.id.startsWith("data:"))
                {
                    if (image$imagedescriptor.id.startsWith("item:"))
                    {
                        ItemStack itemstack = parseItemStack(image$imagedescriptor.id.substring(5));
                        image$imageinfo = new Image.BakedItemImageInfo(itemstack);

                        if (itemstack == null)
                        {
                            image$imageinfo.loadingState = Image.LoadState.ERROR;
                        }
                    }
                    else if (!image$imagedescriptor.id.startsWith("head:") && !image$imagedescriptor.id.startsWith("helm:"))
                    {
                        if (!image$imagedescriptor.id.startsWith("btex:"))
                        {
                            Texteria.log.warn("Image id \'" + image$imagedescriptor.id + "\' not resolved");
                            return null;
                        }

                        image$imageinfo = new Image.BlocksTextureImageInfo(image$imagedescriptor.id.substring(5));
                    }
                    else
                    {
                        image$imageinfo = new Image.HeadImageInfo(image$imagedescriptor.id.substring(5), image$imagedescriptor.id.startsWith("helm:"));
                    }
                }
                else
                {
                    image$imageinfo = new Image.TexturedImageInfo(!request.memCache || image$imagedescriptor.textureRenderHint != Image.TextureRenderHint.CLAMP);
                    (new Image.ByteLoaderThread(request, (Image.TexturedImageInfo)image$imageinfo)).start();
                }
            }
            else
            {
                image$imageinfo = new Image.TexturedImageInfo(!request.memCache || image$imagedescriptor.textureRenderHint != Image.TextureRenderHint.CLAMP);
                (new Image.LoaderThread(request, (Image.TexturedImageInfo)image$imageinfo)).start();
            }

            if (request.memCache)
            {
                inMemoryCache.put(image$imagedescriptor, image$imageinfo);
            }
        }

        return image$imageinfo;
    }

    private static void copyImg(BufferedImage from, int fromX1, int fromY1, int fromX2, int fromY2, BufferedImage to)
    {
        int i = fromX2 - fromX1;
        int j = fromY2 - fromY1;
        int[] aint = from.getRGB(fromX1, fromY1, i, j, (int[])null, 0, i);
        to.setRGB(0, 0, i, j, aint, 0, i);
    }

    private static void loadTexture(Image.LoadingRequest request, Image.TexturedImageInfo image, InputStream is) throws Exception
    {
        if (is instanceof BufferedInputStream)
        {
            loadTexture(request, image, (BufferedInputStream)is);
        }
        else
        {
            loadTexture(request, image, new BufferedInputStream(is));
        }
    }

    private static void loadTexture(Image.LoadingRequest request, Image.TexturedImageInfo image, BufferedInputStream is) throws Exception
    {
        try
        {
            long i = System.nanoTime();

            if (isGif(is))
            {
                StreamingGifDecoder streaminggifdecoder = new StreamingGifDecoder();
                int j = request.data != null ? streaminggifdecoder.read(request.data) : streaminggifdecoder.read(is, 0);

                if (j != 0)
                {
                    String s = j == 1 ? "(format error)" : "(open error)";
                    throw new Exception("Could not decode gif " + s);
                }

                image.width = streaminggifdecoder.getWidth();
                image.height = streaminggifdecoder.getHeight();

                if (image.width > MAX_TEX_SIZE || image.height > MAX_TEX_SIZE)
                {
                    throw new IllegalStateException("Gif image size is larger than max supported texture size: " + image.width + "x" + image.height + " vs " + MAX_TEX_SIZE);
                }

                if (!request.gifStreaming && image.width * image.height * streaminggifdecoder.getFrameCount() > 262144)
                {
                    Texteria.log.warn("Gif streaming is recommended for gif " + request.path + " " + image.width + "x" + image.getHeight() + " (" + streaminggifdecoder.getFrameCount() + ")");
                }

                image.tex = new Image.AnimatedTexture(new Image.GifAnimationSource(streaminggifdecoder, request.gifStreaming), image.ownTexture);
                image.loadingState = Image.LoadState.READY;
                Texteria.log.info("Loaded gif " + request.path + " with " + streaminggifdecoder.getFrameCount() + " frames");
            }
            else if (isPng(is))
            {
                PngDecoder pngdecoder = new PngDecoder(is);
                image.width = pngdecoder.getWidth();
                image.height = pngdecoder.getHeight();

                if (pngdecoder.isAnimated())
                {
                    image.tex = new Image.AnimatedTexture(new Image.PngAnimationSource(pngdecoder), image.ownTexture);
                }
                else
                {
                    BufferedImage bufferedimage = new BufferedImage(pngdecoder.getWidth(), pngdecoder.getHeight(), 2);
                    int[] aint = ((DataBufferInt)bufferedimage.getRaster().getDataBuffer()).getData();
                    pngdecoder.defaultFrame.asIntBuffer().get(aint);
                    image.tex = new Image.MultipartTexture(bufferedimage, image.ownTexture);
                }

                image.loadingState = Image.LoadState.READY;
                Texteria.log.info("Loaded png image " + request.path);
            }
            else
            {
                BufferedImage bufferedimage1 = ImageIO.read((InputStream)is);

                if (bufferedimage1 == null)
                {
                    throw new Exception(request.path + " is not an image");
                }

                if (bufferedimage1.getType() != 2 && bufferedimage1.getWidth() <= MAX_TEX_SIZE && bufferedimage1.getHeight() <= MAX_TEX_SIZE)
                {
                    BufferedImage bufferedimage2 = new BufferedImage(bufferedimage1.getWidth(), bufferedimage1.getHeight(), 2);
                    bufferedimage2.getGraphics().drawImage(bufferedimage1, 0, 0, (ImageObserver)null);
                    bufferedimage1 = bufferedimage2;
                }

                image.width = bufferedimage1.getWidth();
                image.height = bufferedimage1.getHeight();
                image.tex = new Image.MultipartTexture(bufferedimage1, image.ownTexture);
                image.loadingState = Image.LoadState.READY;
                Texteria.log.info("Loaded image " + request.path);
            }

            Texteria.printDebug("Image " + request.path + " prepared in {} ns", new Object[] {Long.valueOf(System.nanoTime() - i)});
        }
        finally
        {
            is.close();
        }
    }

    private static Image.Sprite insertSprite(int width, int height)
    {
        synchronized (FREE_ATLASES)
        {
            Iterator<Image.TextureAtlas> iterator = FREE_ATLASES.iterator();

            while (iterator.hasNext())
            {
                Image.TextureAtlas image$textureatlas = (Image.TextureAtlas)iterator.next();
                Image.Sprite image$sprite = image$textureatlas.insert(width, height);

                if (image$sprite != null)
                {
                    return image$sprite;
                }

                if (image$textureatlas.fails++ > 75)
                {
                    image$textureatlas.packer = null;
                    iterator.remove();
                }
            }

            Image.TextureAtlas image$textureatlas1 = new Image.TextureAtlas(ATLAX_TEX_SIZE, ATLAX_TEX_SIZE, true);
            FREE_ATLASES.add(image$textureatlas1);
            return image$textureatlas1.insert(width, height);
        }
    }

    private static void packSameSpritesDumb(List<Image.Sprite> sprites)
    {
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        Image.TextureAtlas image$textureatlas = new Image.TextureAtlas(0, 0, false);

        for (Image.Sprite image$sprite : sprites)
        {
            if (i + image$sprite.width < MAX_TEX_SIZE)
            {
                image$sprite.x = i;
                image$sprite.y = j;
                i += image$sprite.width;
                k = Math.max(i, k);
                l = Math.max(j + image$sprite.height, l);
            }
            else if (j + image$sprite.height < MAX_TEX_SIZE)
            {
                j += image$sprite.height;
                image$sprite.y = j;
                i = image$sprite.width;
                l = Math.max(j + image$sprite.height, l);
            }
            else
            {
                image$textureatlas.width = MathHelper.roundUpToPowerOfTwo(k);
                image$textureatlas.height = MathHelper.roundUpToPowerOfTwo(l);
                image$textureatlas = new Image.TextureAtlas(0, 0, false);
                k = image$sprite.width;
                l = image$sprite.height;
            }

            image$sprite.atlas = image$textureatlas;
        }

        image$textureatlas.width = MathHelper.roundUpToPowerOfTwo(k);
        image$textureatlas.height = MathHelper.roundUpToPowerOfTwo(l);
    }

    private static void uploadSpriteToAtlas(Image.Sprite sprite, int mipmapLevel, int[] pixels)
    {
        if (sprite.atlas.glid == -1)
        {
            sprite.atlas.glid = TextureUtil.glGenTextures();
            ALL_ATLASES.put(Integer.valueOf(sprite.atlas.glid), sprite.atlas);
            Texteria.printDebug("Allocating texture {}x{}", new Object[] {Integer.valueOf(sprite.atlas.width), Integer.valueOf(sprite.atlas.height)});
            TextureUtil.allocateTextureImpl(sprite.atlas.glid, mipmapLevel, sprite.atlas.width, sprite.atlas.height);
        }
        else
        {
            GlStateManager.bindTexture(sprite.atlas.glid);
        }

        int[][] aint = new int[mipmapLevel + 1][];
        aint[0] = pixels;
        aint = TextureUtil.generateMipmapData(mipmapLevel, sprite.width, aint);
        TextureUtil.uploadTextureMipmap(aint, sprite.width, sprite.height, sprite.x, sprite.y, false, false);
    }

    private static void deleteTextureAtlas(int glid)
    {
        if (glid != -1)
        {
            Image.TextureAtlas image$textureatlas = (Image.TextureAtlas)ALL_ATLASES.remove(Integer.valueOf(glid));
            Texteria.printDebug("Deleting texture {} - {}x{}", new Object[] {Integer.valueOf(glid), Integer.valueOf(image$textureatlas.width), Integer.valueOf(image$textureatlas.height)});
            TextureUtil.deleteTexture(glid);
        }
    }

    public static void debugSaveAtlases()
    {
        for (Image.TextureAtlas image$textureatlas : ALL_ATLASES.values())
        {
            TextureUtil.saveGlTexture("tex" + image$textureatlas.glid + "__" + image$textureatlas.width + "x" + image$textureatlas.height, image$textureatlas.glid, 0, image$textureatlas.width, image$textureatlas.height);
        }
    }

    private static boolean isGif(BufferedInputStream is) throws Exception
    {
        is.mark(6);
        byte[] abyte = new byte[6];
        int i = is.read(abyte);
        is.reset();
        return i < 6 ? false : abyte[0] == 71 && abyte[1] == 73 && abyte[2] == 70 && abyte[3] == 56 && (abyte[4] == 55 || abyte[4] == 57) && abyte[5] == 97;
    }

    private static boolean isPng(BufferedInputStream is) throws Exception
    {
        is.mark(PNG_MAGIC.length);
        byte[] abyte = new byte[PNG_MAGIC.length];
        int i = is.read(abyte);
        is.reset();
        return i < PNG_MAGIC.length ? false : Arrays.equals(abyte, PNG_MAGIC);
    }

    private static ItemStack parseItemStack(String definition)
    {
        String[] astring = definition.trim().split(" ");
        int i = 0;
        Item item;

        if (astring[0].contains(":"))
        {
            String[] astring1 = astring[0].split(":");
            item = Item.getByNameOrId(astring1[0]);
            i = Integer.parseInt(astring1[1]);
        }
        else
        {
            item = Item.getByNameOrId(astring[0]);
        }

        if (item == null)
        {
            Texteria.log.warn("Can\'t parse item \'" + definition + "\'");
            return null;
        }
        else
        {
            ItemStack itemstack = new ItemStack(item, 1, i);

            if (astring.length == 1)
            {
                return itemstack;
            }
            else
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                itemstack.writeToNBT(nbttagcompound);
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();

                for (int j = 1; j < astring.length; ++j)
                {
                    String[] astring2 = astring[j].split("=", 2);

                    if (astring2.length == 1)
                    {
                        if ("glow".equals(astring2[0]))
                        {
                            nbttagcompound1.setTag("ench", new NBTTagList());
                        }
                    }
                    else
                    {
                        String s = astring2[0];
                        byte b0 = -1;

                        switch (s.hashCode())
                        {
                            case 94842723:
                                if (s.equals("color"))
                                {
                                    b0 = 0;
                                }

                                break;

                            case 106164915:
                                if (s.equals("owner"))
                                {
                                    b0 = 1;
                                }
                        }

                        switch (b0)
                        {
                            case 0:
                                NBTTagCompound nbttagcompound2 = nbttagcompound1.getCompoundTag("display");

                                if (nbttagcompound2 == null)
                                {
                                    nbttagcompound1.setTag("display", nbttagcompound2 = new NBTTagCompound());
                                }

                                nbttagcompound2.setInteger("color", Integer.parseInt(astring2[1].charAt(0) == 35 ? astring2[1].substring(1) : astring2[1], 16));
                                break;

                            case 1:
                                nbttagcompound1.setString("SkullOwner", astring2[1]);
                        }
                    }
                }

                if (!nbttagcompound1.hasNoTags())
                {
                    nbttagcompound.setTag("tag", nbttagcompound1);
                    itemstack.readFromNBT(nbttagcompound);
                }

                return itemstack;
            }
        }
    }

    public static class AnimatedFrame
    {
        public final int id;
        public Image.Sprite sprite;
        public int delay;
        public final int delayBefore;

        public AnimatedFrame(int id, Image.Sprite sprite, int delay, int delayBefore)
        {
            this.id = id;
            this.sprite = sprite;
            this.delay = delay;
            this.delayBefore = delayBefore;

            if (this.delay < 20)
            {
                this.delay = 100;
            }
        }
    }

    public static class AnimatedTexture implements Image.Texture
    {
        Image.AnimationSource source;
        Image.AnimatedFrame[] frames;
        boolean uploaded;
        int duration;
        int width;
        int height;
        int loopCount;
        boolean ownTexture;
        int uploadedFrameId = -1;

        public AnimatedTexture(Image.AnimationSource source, boolean ownTexture)
        {
            this.source = source;
            this.frames = new Image.AnimatedFrame[source.getFrameCount() + 1];
            this.loopCount = source.getLoopCount();
            this.width = source.getWidth();
            this.height = source.getHeight();
            this.ownTexture = ownTexture;

            if (source.isStreaming())
            {
                Image.Sprite image$sprite;

                if (ownTexture)
                {
                    Image.TextureAtlas image$textureatlas = new Image.TextureAtlas(MathHelper.roundUpToPowerOfTwo(this.width), MathHelper.roundUpToPowerOfTwo(this.height), false);
                    image$sprite = new Image.Sprite(image$textureatlas, 0, 0, this.width, this.height);
                }
                else
                {
                    image$sprite = Image.insertSprite(this.width, this.height);
                }

                for (int j = 0; j < this.frames.length - 1; ++j)
                {
                    this.frames[j] = new Image.AnimatedFrame(j, image$sprite, source.getDelay(j), this.duration);
                    this.duration += this.frames[j].delay;
                }
            }
            else if (ownTexture)
            {
                List<Image.Sprite> list = new ArrayList();

                for (int k = 0; k < this.frames.length - 1; ++k)
                {
                    Image.Sprite image$sprite1 = new Image.Sprite((Image.TextureAtlas)null, 0, 0, this.width, this.height);
                    list.add(image$sprite1);
                    this.frames[k] = new Image.AnimatedFrame(k, image$sprite1, source.getDelay(k), this.duration);
                    this.duration += this.frames[k].delay;
                }

                Image.packSameSpritesDumb(list);
            }
            else
            {
                for (int i = 0; i < this.frames.length - 1; ++i)
                {
                    Image.Sprite image$sprite2 = Image.insertSprite(this.width, this.height);
                    this.frames[i] = new Image.AnimatedFrame(i, image$sprite2, source.getDelay(i), this.duration);
                    this.duration += this.frames[i].delay;
                }
            }

            this.frames[this.frames.length - 1] = new Image.AnimatedFrame(this.frames.length - 1, this.frames[this.frames.length - 2].sprite, 0, this.duration);
        }

        public void render(Image element, long time)
        {
            Image.AnimatedFrame image$animatedframe = this.getCurrentFrame(element.animationContext, time);

            if (this.source != null && this.source.isStreaming())
            {
                if (image$animatedframe.id != this.uploadedFrameId)
                {
                    Image.uploadSpriteToAtlas(image$animatedframe.sprite, element.textureRenderHint.getMipmapLevel(), this.source.getFrameData(image$animatedframe.id));
                    this.uploadedFrameId = image$animatedframe.id;
                    this.uploaded = true;
                }
            }
            else
            {
                this.upload(element.image, element.textureRenderHint);
            }

            GlStateManager.bindTexture(image$animatedframe.sprite.atlas.glid);

            if (element.textureRenderHint.isRepeat())
            {
                TRenderUtil.drawRepeatedTexturedRect(0, 0, 0.0F, 0.0F, element.getWidth(), element.getHeight(), 1.0F, 1.0F);
            }
            else
            {
                TRenderUtil.drawTexturedRect(0, 0, (float)image$animatedframe.sprite.x, (float)image$animatedframe.sprite.y, (float)image$animatedframe.sprite.width, (float)image$animatedframe.sprite.height, (float)image$animatedframe.sprite.atlas.width, (float)image$animatedframe.sprite.atlas.height);
            }
        }

        public void upload(Image.ImageInfo image, Image.TextureRenderHint textureRenderHint)
        {
            if (!this.uploaded)
            {
                int i = textureRenderHint.getMipmapLevel();
                long j = System.nanoTime();

                for (int k = 0; k < this.frames.length - 1; ++k)
                {
                    Image.uploadSpriteToAtlas(this.frames[k].sprite, i, this.source.getFrameData(k));
                }

                Texteria.printDebug("GIF texture uploaded in {} ns", new Object[] {Long.valueOf(System.nanoTime() - j)});
                this.uploaded = true;
                this.source = null;
            }
        }

        public Image.AnimatedFrame getCurrentFrame(Image.AnimationContext context, long time)
        {
            long i = time - context.startTime;

            if (this.loopCount != 0 && context.loopNum >= this.loopCount)
            {
                context.frame = this.frames.length - 2;
            }
            else
            {
                i = (long)((double)i * context.speedModifier);
                i = i - (long)context.loopNum * (long)this.duration;

                if (i > (long)this.duration)
                {
                    context.loopNum = (int)((long)context.loopNum + i / (long)this.duration);
                    context.frame = 0;
                    return this.getCurrentFrame(context, time);
                }

                for (int j = context.frame + 1; j < this.frames.length; ++j)
                {
                    Image.AnimatedFrame image$animatedframe = this.frames[j];

                    if ((long)image$animatedframe.delayBefore > i)
                    {
                        context.frame = Math.max(0, j - 1);
                        break;
                    }
                }
            }

            return this.frames[context.frame];
        }

        public void dispose()
        {
            if (this.uploaded && this.ownTexture)
            {
                for (int i = 0; i < this.frames.length; ++i)
                {
                    if (i == 0 || this.frames[i - 1].sprite.atlas != this.frames[i].sprite.atlas)
                    {
                        Image.deleteTextureAtlas(this.frames[i].sprite.atlas.glid);
                    }
                }
            }
        }
    }

    public static class AnimationContext
    {
        public long startTime;
        public int loopNum;
        public int frame;
        public double speedModifier = 1.0D;

        public AnimationContext(long startTime)
        {
            this.startTime = startTime;
        }
    }

    public interface AnimationSource
    {
        int getFrameCount();

        int getLoopCount();

        int[] getFrameData(int var1);

        int getDelay(int var1);

        int getWidth();

        int getHeight();

        boolean isStreaming();
    }

    public static class BakedItemImageInfo extends Image.ImageInfo
    {
        ItemStack is;

        public BakedItemImageInfo(ItemStack is)
        {
            this.is = is;
            this.loadingState = Image.LoadState.READY;
        }

        public void render(Image element, long time)
        {
            GlStateManager.scale(element.getWidth() / (float)this.getWidth(), element.getHeight() / (float)this.getHeight(), element.isIn3d ? 0.0F : 2.0F);
            RenderItem renderitem = Minecraft.getMinecraft().getRenderItem();

            if (element.isIn3d)
            {
                IBakedModel ibakedmodel = renderitem.getItemModelMesher().getItemModel(this.is);

                if (!ibakedmodel.isGui3d())
                {
                    TextureManager texturemanager = Minecraft.getMinecraft().getTextureManager();
                    texturemanager.bindTexture(TextureMap.locationBlocksTexture);
                    texturemanager.getTexture(TextureMap.locationBlocksTexture).setBlurMipmap(false, false);
                    GlStateManager.translate(8.0F, 8.0F, 0.0F);
                    GlStateManager.scale(32.0F, 32.0F, 32.0F);
                    GlStateManager.rotate(180.0F, 1.0F, 0.0F, 0.0F);
                    renderitem.renderItem(this.is, ibakedmodel);
                    texturemanager.bindTexture(TextureMap.locationBlocksTexture);
                    texturemanager.getTexture(TextureMap.locationBlocksTexture).restoreLastBlurMipmap();
                }
            }
            else
            {
                GlStateManager.enableDepth();
                RenderHelper.enableGUIStandardItemLighting();
                renderitem.renderItemAndEffectIntoGUI(this.is, 0, 0);
                RenderHelper.disableStandardItemLighting();
                GlStateManager.enableAlpha();
                GlStateManager.disableDepth();
            }
        }

        public int getWidth()
        {
            return 16;
        }

        public int getHeight()
        {
            return 16;
        }
    }

    public static class BlocksTextureImageInfo extends Image.ImageInfo
    {
        String iconName;
        ItemStack is;
        EnumFacing facing;

        public BlocksTextureImageInfo(String descriptor)
        {
            if (!descriptor.startsWith("blocks/") && !descriptor.startsWith("items/"))
            {
                this.is = Image.parseItemStack(descriptor);

                if (this.is == null)
                {
                    this.loadingState = Image.LoadState.ERROR;
                    return;
                }

                if (descriptor.contains("%"))
                {
                    String s = descriptor.substring(descriptor.indexOf("%") + 1).toLowerCase(Locale.US);
                    this.facing = EnumFacing.byName(s);

                    if (this.facing == null)
                    {
                        Texteria.log.info("Unable to find EnumFacing with name \'" + s + "\'");
                    }
                }
            }
            else
            {
                this.iconName = "minecraft:" + descriptor;
            }

            this.loadingState = Image.LoadState.READY;
        }

        public void render(Image element, long time)
        {
            TextureMap texturemap = this.getBlocksMap();
            GlStateManager.bindTexture(texturemap.getGlTextureId());
            TextureAtlasSprite textureatlassprite = this.getSprite(texturemap);
            draw(textureatlassprite.getMinU(), textureatlassprite.getMinV(), textureatlassprite.getMaxU(), textureatlassprite.getMaxV(), element.getWidth(), element.getHeight());
        }

        public TextureMap getBlocksMap()
        {
            return Minecraft.getMinecraft().getTextureMapBlocks();
        }

        public TextureAtlasSprite getSprite(TextureMap blocks)
        {
            if (this.iconName != null)
            {
                return blocks.getAtlasSprite(this.iconName);
            }
            else
            {
                IBakedModel ibakedmodel = Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getItemModel(this.is);
                List<BakedQuad> list = this.facing == null ? ibakedmodel.getGeneralQuads() : ibakedmodel.getFaceQuads(this.facing);
                return !list.isEmpty() ? ((BakedQuad)list.get(0)).getSprite() : blocks.getMissingSprite();
            }
        }

        private static void draw(float u1, float v1, float u2, float v2, float width, float height)
        {
            Tessellator tessellator = Tessellator.getInstance();
            WorldRenderer worldrenderer = tessellator.getWorldRenderer();
            worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
            worldrenderer.pos(0.0D, (double)height, 0.0D).tex((double)u1, (double)v2).endVertex();
            worldrenderer.pos((double)width, (double)height, 0.0D).tex((double)u2, (double)v2).endVertex();
            worldrenderer.pos((double)width, 0.0D, 0.0D).tex((double)u2, (double)v1).endVertex();
            worldrenderer.pos(0.0D, 0.0D, 0.0D).tex((double)u1, (double)v1).endVertex();
            tessellator.draw();
        }

        public int getWidth()
        {
            return 16;
        }

        public int getHeight()
        {
            return 16;
        }
    }

    private static class ByteLoaderThread extends Thread
    {
        Image.LoadingRequest request;
        Image.TexturedImageInfo image;

        ByteLoaderThread(Image.LoadingRequest request, Image.TexturedImageInfo image)
        {
            super("Byte image loader");
            this.setDaemon(true);
            this.request = request;
            this.image = image;
        }

        public void run()
        {
            try
            {
                Image.loadTexture(this.request, this.image, (InputStream)(new ByteArrayInputStream(this.request.data)));
            }
            catch (Exception exception)
            {
                Texteria.log.warn((String)("Loading image \'" + this.request.path + "\'."), (Throwable)exception);
                this.image.loadingState = Image.LoadState.ERROR;
            }
        }
    }

    public static class GifAnimationSource implements Image.AnimationSource
    {
        StreamingGifDecoder decoder;
        private final boolean streaming;
        private List<BufferedImage> preparedFrames;

        public GifAnimationSource(StreamingGifDecoder decoder, boolean streaming)
        {
            this.decoder = decoder;
            this.streaming = streaming;

            if (!streaming)
            {
                this.preparedFrames = new ArrayList();

                for (int i = 0; i < decoder.getFrameCount(); ++i)
                {
                    decoder.advance();
                    BufferedImage bufferedimage = decoder.getNextFrame();
                    BufferedImage bufferedimage1 = new BufferedImage(bufferedimage.getWidth(), bufferedimage.getHeight(), bufferedimage.getType());
                    int[] aint = ((DataBufferInt)bufferedimage.getRaster().getDataBuffer()).getData();
                    System.arraycopy(aint, 0, ((DataBufferInt)bufferedimage1.getRaster().getDataBuffer()).getData(), 0, aint.length);
                    this.preparedFrames.add(bufferedimage1);
                }
            }
        }

        public int getFrameCount()
        {
            return this.decoder.getFrameCount();
        }

        public int getLoopCount()
        {
            return this.decoder.getLoopCount();
        }

        public int[] getFrameData(int frame)
        {
            if (!this.streaming)
            {
                return ((DataBufferInt)((BufferedImage)this.preparedFrames.get(frame)).getRaster().getDataBuffer()).getData();
            }
            else
            {
                BufferedImage bufferedimage;

                for (bufferedimage = this.decoder.getNextFrame(); this.decoder.getCurrentFrameIndex() != frame; bufferedimage = this.decoder.getNextFrame())
                {
                    this.decoder.advance();
                }

                return ((DataBufferInt)bufferedimage.getRaster().getDataBuffer()).getData();
            }
        }

        public int getDelay(int frame)
        {
            return this.decoder.getDelay(frame);
        }

        public int getWidth()
        {
            return this.decoder.getWidth();
        }

        public int getHeight()
        {
            return this.decoder.getHeight();
        }

        public boolean isStreaming()
        {
            return this.streaming;
        }
    }

    public static class HeadImageInfo extends Image.ImageInfo
    {
        ResourceLocation texture;
        boolean secondLayer;

        public HeadImageInfo(String username, boolean secondLayer)
        {
            this.texture = AbstractClientPlayer.getLocationSkin(username);
            this.secondLayer = secondLayer;
            AbstractClientPlayer.getDownloadImageSkin(this.texture, username);
            this.loadingState = Image.LoadState.READY;
        }

        public void render(Image element, long time)
        {
            Minecraft.getMinecraft().getTextureManager().bindTexture(this.texture);
            TRenderUtil.drawScaledTexturedRect(0, 0, 8.0F, 8.0F, 8.0F, 8.0F, element.getWidth(), element.getHeight(), 64.0F, 64.0F);

            if (this.secondLayer)
            {
                TRenderUtil.drawScaledTexturedRect(0, 0, 40.0F, 8.0F, 8.0F, 8.0F, element.getWidth(), element.getHeight(), 64.0F, 64.0F);
            }
        }

        public int getWidth()
        {
            return 8;
        }

        public int getHeight()
        {
            return 8;
        }
    }

    public static class ImageDescriptor
    {
        String id;
        Image.TextureRenderHint textureRenderHint;

        public ImageDescriptor(String id, Image.TextureRenderHint textureRenderHint)
        {
            this.id = id;
            this.textureRenderHint = textureRenderHint;
        }

        public boolean equals(Object o)
        {
            if (!(o instanceof Image.ImageDescriptor))
            {
                return false;
            }
            else
            {
                Image.ImageDescriptor image$imagedescriptor = (Image.ImageDescriptor)o;
                return this.id.equals(image$imagedescriptor.id) && this.textureRenderHint == image$imagedescriptor.textureRenderHint;
            }
        }

        public int hashCode()
        {
            int i = this.id.hashCode();
            i = 31 * i + this.textureRenderHint.hashCode();
            return i;
        }
    }

    public abstract static class ImageInfo
    {
        public Image.LoadState loadingState = Image.LoadState.LOADING;

        public abstract void render(Image var1, long var2);

        public abstract int getWidth();

        public abstract int getHeight();

        public void dispose()
        {
        }
    }

    public static enum LoadState
    {
        LOADING,
        READY,
        ERROR;
    }

    private static class LoaderThread extends Thread
    {
        Image.LoadingRequest request;
        Image.TexturedImageInfo image;

        LoaderThread(Image.LoadingRequest request, Image.TexturedImageInfo image)
        {
            super("Image loader");
            this.setDaemon(true);
            this.request = request;
            this.image = image;
        }

        public void run()
        {
            try
            {
                if (this.request.path.startsWith("file:"))
                {
                    Image.loadTexture(this.request, this.image, (InputStream)(new FileInputStream(new File(Minecraft.getMinecraft().mcDataDir, this.request.path.substring(5)))));
                }
                else if (this.request.path.startsWith("#"))
                {
                    TexteriaResource texteriaresource = Texteria.instance.resourceManager.getResource(this.request.path.substring(1));

                    if (texteriaresource == null)
                    {
                        Texteria.log.warn("Resource " + this.request.path + " not exists");
                        this.image.loadingState = Image.LoadState.ERROR;
                        return;
                    }

                    try
                    {
                        Image.loadTexture(this.request, this.image, texteriaresource.getInputStream());
                    }
                    catch (Exception exception1)
                    {
                        texteriaresource.invalidate();
                        throw exception1;
                    }
                }
                else if (this.request.fileCache)
                {
                    String s1 = DigestUtils.md5Hex(this.request.path.getBytes());
                    VimeStorage.Entry vimestorage$entry = Texteria.instance.storage.getEntry("image/" + s1);

                    if (!vimestorage$entry.exists())
                    {
                        try
                        {
                            OutputStream outputstream = vimestorage$entry.getOutputStream();
                            Throwable throwable = null;

                            try
                            {
                                IOUtils.copy((new URL(this.request.path)).openStream(), outputstream);
                            }
                            catch (Throwable throwable2)
                            {
                                throwable = throwable2;
                                throw throwable2;
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
                                        catch (Throwable throwable1)
                                        {
                                            throwable.addSuppressed(throwable1);
                                        }
                                    }
                                    else
                                    {
                                        outputstream.close();
                                    }
                                }
                            }
                        }
                        catch (Exception exception2)
                        {
                            vimestorage$entry.delete();
                            throw exception2;
                        }

                        vimestorage$entry.save(2592000);
                    }

                    try
                    {
                        Image.loadTexture(this.request, this.image, (InputStream)vimestorage$entry.getInputStream());
                    }
                    catch (Exception exception)
                    {
                        vimestorage$entry.delete();
                        throw exception;
                    }
                }
                else
                {
                    Image.loadTexture(this.request, this.image, (new URL(this.request.path)).openStream());
                }
            }
            catch (Exception exception3)
            {
                String s = this.request.path;

                if (s.startsWith("file:"))
                {
                    s = (new File(Minecraft.getMinecraft().mcDataDir, s.substring(5))).getAbsolutePath();
                }

                Texteria.log.warn((String)("Loading image \'" + s + "\'."), (Throwable)exception3);
                this.image.loadingState = Image.LoadState.ERROR;
            }
        }
    }

    public static class LoadingRequest
    {
        public final String path;
        public boolean fileCache = true;
        public boolean gifStreaming = false;
        public byte[] data = null;
        public boolean memCache = true;
        public Image.TextureRenderHint textureRenderHint = Image.TextureRenderHint.CLAMP;

        public LoadingRequest(String path)
        {
            this.path = path;
        }
    }

    public static class MultipartTexture implements Image.Texture
    {
        private BufferedImage img;
        public int width;
        public int height;
        public Image.Sprite sprite;
        public List<Image.TexturePart> parts;
        boolean uploaded;
        boolean ownTexture;

        public MultipartTexture(BufferedImage img, boolean ownTexture)
        {
            this.width = img.getWidth();
            this.height = img.getHeight();
            this.img = img;

            if (!ownTexture && this.width <= Image.ATLAX_TEX_SIZE && this.height <= Image.ATLAX_TEX_SIZE)
            {
                this.sprite = Image.insertSprite(this.width, this.height);
            }
            else
            {
                this.ownTexture = true;
                this.parts = new ArrayList();
                int k;

                for (int i = 0; i < this.height; i += k)
                {
                    int j = 0;
                    k = Math.min(Image.MAX_TEX_SIZE, MathHelper.roundUpToPowerOfTwo(this.height - i));

                    while (j < this.width)
                    {
                        Image.TexturePart image$texturepart = new Image.TexturePart();
                        image$texturepart.x = j;
                        image$texturepart.y = i;
                        image$texturepart.height = k;
                        image$texturepart.width = Math.min(Image.MAX_TEX_SIZE, MathHelper.roundUpToPowerOfTwo(this.width - j));
                        j += image$texturepart.width;
                        image$texturepart.img = new BufferedImage(image$texturepart.width, image$texturepart.height, 2);
                        Image.copyImg(img, image$texturepart.x, image$texturepart.y, Math.min(image$texturepart.x + image$texturepart.width, this.width), Math.min(image$texturepart.y + image$texturepart.height, this.height), image$texturepart.img);
                        this.parts.add(image$texturepart);
                    }
                }
            }
        }

        public void render(Image element, long time)
        {
            this.upload(element.image, element.textureRenderHint);

            if (element.textureRenderHint.isRepeat())
            {
                Image.TexturePart image$texturepart = (Image.TexturePart)this.parts.get(0);
                GlStateManager.bindTexture(image$texturepart.glTextureId);
                TRenderUtil.drawRepeatedTexturedRect(0, 0, 0.0F, 0.0F, element.getWidth(), element.getHeight(), 1.0F, 1.0F);
            }
            else if (this.sprite != null)
            {
                GlStateManager.bindTexture(this.sprite.atlas.glid);
                TRenderUtil.drawTexturedRect(0, 0, (float)this.sprite.x, (float)this.sprite.y, (float)this.sprite.width, (float)this.sprite.height, (float)this.sprite.atlas.width, (float)this.sprite.atlas.height);
            }
            else
            {
                for (Image.TexturePart image$texturepart1 : this.parts)
                {
                    GlStateManager.bindTexture(image$texturepart1.glTextureId);
                    TRenderUtil.drawTexturedRect(image$texturepart1.x, image$texturepart1.y, 0.0F, 0.0F, (float)image$texturepart1.width, (float)image$texturepart1.height, (float)image$texturepart1.width, (float)image$texturepart1.height);
                }
            }
        }

        public void upload(Image.ImageInfo image, Image.TextureRenderHint textureRenderHint)
        {
            if (!this.uploaded)
            {
                long i = System.nanoTime();
                int j = textureRenderHint.getMipmapLevel();

                if (this.sprite != null)
                {
                    Image.uploadSpriteToAtlas(this.sprite, j, ((DataBufferInt)this.img.getRaster().getDataBuffer()).getData());
                }
                else
                {
                    for (Image.TexturePart image$texturepart : this.parts)
                    {
                        Image.Sprite image$sprite = new Image.Sprite(new Image.TextureAtlas(image$texturepart.width, image$texturepart.height, false), 0, 0, image$texturepart.width, image$texturepart.height);
                        Image.uploadSpriteToAtlas(image$sprite, j, ((DataBufferInt)image$texturepart.img.getRaster().getDataBuffer()).getData());
                        image$texturepart.glTextureId = image$sprite.atlas.glid;
                        image$texturepart.img = null;
                    }
                }

                this.img = null;
                Texteria.printDebug("Image texture uploaded in {} ns", new Object[] {Long.valueOf(System.nanoTime() - i)});
                this.uploaded = true;
            }
        }

        public void dispose()
        {
            if (this.uploaded && this.ownTexture)
            {
                if (this.sprite != null)
                {
                    Image.deleteTextureAtlas(this.sprite.atlas.glid);
                }
                else
                {
                    for (Image.TexturePart image$texturepart : this.parts)
                    {
                        Image.deleteTextureAtlas(image$texturepart.glTextureId);
                    }
                }
            }
        }
    }

    public static class PngAnimationSource implements Image.AnimationSource
    {
        PngDecoder decoder;
        int[] temp;

        public PngAnimationSource(PngDecoder decoder)
        {
            this.decoder = decoder;
            this.temp = new int[decoder.getWidth() * decoder.getHeight()];
        }

        public int getFrameCount()
        {
            return this.decoder.frames.size();
        }

        public int getLoopCount()
        {
            return this.decoder.loopCount;
        }

        public int[] getFrameData(int frame)
        {
            ((PngDecoder.Frame)this.decoder.frames.get(frame)).extractARGB(this.temp);
            return this.temp;
        }

        public int getDelay(int frame)
        {
            return ((PngDecoder.Frame)this.decoder.frames.get(frame)).delayMillis();
        }

        public int getWidth()
        {
            return this.decoder.getWidth();
        }

        public int getHeight()
        {
            return this.decoder.getHeight();
        }

        public boolean isStreaming()
        {
            return false;
        }
    }

    public static class Sprite
    {
        public Image.TextureAtlas atlas;
        public int x;
        public int y;
        public int width;
        public int height;

        public Sprite(Image.TextureAtlas atlas, int x, int y, int width, int height)
        {
            this.atlas = atlas;
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
    }

    public interface Texture
    {
        void upload(Image.ImageInfo var1, Image.TextureRenderHint var2);

        void render(Image var1, long var2);

        void dispose();
    }

    public static class TextureAtlas
    {
        public int glid = -1;
        public int width;
        public int height;
        private MaxRectsPacker packer;
        private int fails;

        public TextureAtlas(int width, int height, boolean packer)
        {
            this.width = width;
            this.height = height;

            if (packer)
            {
                this.packer = new MaxRectsPacker();
                this.packer.init(width, height);
            }
        }

        public Image.Sprite insert(int width, int height)
        {
            MaxRectsPacker.Rect maxrectspacker$rect = new MaxRectsPacker.Rect(width, height);
            MaxRectsPacker.Rect maxrectspacker$rect1 = this.packer.insert(maxrectspacker$rect, MaxRectsPacker.FreeRectChoiceHeuristic.BestAreaFit);
            return maxrectspacker$rect1 != null ? new Image.Sprite(this, maxrectspacker$rect1.x, maxrectspacker$rect1.y, width, height) : null;
        }
    }

    public static class TexturePart
    {
        public int x;
        public int y;
        public int width;
        public int height;
        public int glTextureId;
        BufferedImage img;
    }

    public static enum TextureRenderHint
    {
        CLAMP,
        REPEAT,
        REPEAT_MIPMAP;

        public boolean isRepeat()
        {
            return this == REPEAT || this == REPEAT_MIPMAP;
        }

        public boolean hasMipmap()
        {
            return this == REPEAT_MIPMAP;
        }

        public int getMipmapLevel()
        {
            return this.hasMipmap() ? Minecraft.getMinecraft().gameSettings.mipmapLevels : 0;
        }
    }

    public static class TexturedImageInfo extends Image.ImageInfo
    {
        public Image.Texture tex;
        public int width = -1;
        public int height = -1;
        boolean ownTexture;

        TexturedImageInfo(boolean ownTexture)
        {
            this.ownTexture = ownTexture;
        }

        public void render(Image element, long time)
        {
            if (!element.textureRenderHint.isRepeat())
            {
                GlStateManager.scale(element.getWidth() / (float)this.width, element.getHeight() / (float)this.height, 1.0F);
            }

            this.tex.render(element, time);
        }

        public void dispose()
        {
            if (this.tex != null)
            {
                this.tex.dispose();
            }
        }

        public int getWidth()
        {
            return this.width;
        }

        public int getHeight()
        {
            return this.height;
        }
    }
}
