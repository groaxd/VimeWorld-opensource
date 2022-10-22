package net.xtrafrancyz.util;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class GifDecoder
{
    public static final int STATUS_OK = 0;
    public static final int STATUS_FORMAT_ERROR = 1;
    public static final int STATUS_OPEN_ERROR = 2;
    protected BufferedInputStream in;
    protected int status;
    protected int width;
    protected int height;
    protected boolean gctFlag;
    protected int gctSize;
    protected int loopCount = 1;
    protected int[] gct;
    protected int[] lct;
    protected int[] act;
    protected int bgIndex;
    protected int bgColor;
    protected int lastBgColor;
    protected int pixelAspect;
    protected boolean lctFlag;
    protected boolean interlace;
    protected int lctSize;
    protected int ix;
    protected int iy;
    protected int iw;
    protected int ih;
    protected Rectangle lastRect;
    protected BufferedImage image;
    protected BufferedImage lastImage;
    protected byte[] block = new byte[256];
    protected int blockSize = 0;
    protected int dispose = 0;
    protected int lastDispose = 0;
    protected boolean transparency = false;
    protected int delay = 0;
    protected int transIndex;
    protected static final int MaxStackSize = 4096;
    protected short[] prefix;
    protected byte[] suffix;
    protected byte[] pixelStack;
    protected byte[] pixels;
    protected ArrayList<GifDecoder.GifFrame> frames;
    protected int frameCount;

    public int getDelay(int n)
    {
        this.delay = -1;

        if (n >= 0 && n < this.frameCount)
        {
            this.delay = ((GifDecoder.GifFrame)this.frames.get(n)).delay;
        }

        return this.delay;
    }

    public int getFrameCount()
    {
        return this.frameCount;
    }

    public BufferedImage getImage()
    {
        return this.getFrame(0);
    }

    public int getLoopCount()
    {
        return this.loopCount;
    }

    protected void setPixels()
    {
        int[] aint = ((DataBufferInt)this.image.getRaster().getDataBuffer()).getData();

        if (this.lastDispose > 0)
        {
            if (this.lastDispose == 3)
            {
                int i = this.frameCount - 2;

                if (i > 0)
                {
                    this.lastImage = this.getFrame(i - 1);
                }
                else
                {
                    this.lastImage = null;
                }
            }

            if (this.lastImage != null)
            {
                int[] aint1 = ((DataBufferInt)this.lastImage.getRaster().getDataBuffer()).getData();
                System.arraycopy(aint1, 0, aint, 0, this.width * this.height);

                if (this.lastDispose == 2)
                {
                    Graphics2D graphics2d = this.image.createGraphics();
                    Color color;

                    if (this.transparency)
                    {
                        color = new Color(0, 0, 0, 0);
                    }
                    else
                    {
                        color = new Color(this.lastBgColor);
                    }

                    graphics2d.setColor(color);
                    graphics2d.setComposite(AlphaComposite.Src);
                    graphics2d.fill(this.lastRect);
                    graphics2d.dispose();
                }
            }
        }

        int j2 = 1;
        int k2 = 8;
        int l2 = 0;

        for (int j = 0; j < this.ih; ++j)
        {
            int k = j;

            if (this.interlace)
            {
                if (l2 >= this.ih)
                {
                    ++j2;

                    switch (j2)
                    {
                        case 2:
                            l2 = 4;
                            break;

                        case 3:
                            l2 = 2;
                            k2 = 4;
                            break;

                        case 4:
                            l2 = 1;
                            k2 = 2;
                    }
                }

                k = l2;
                l2 += k2;
            }

            k = k + this.iy;

            if (k < this.height)
            {
                int l = k * this.width;
                int i1 = l + this.ix;
                int j1 = i1 + this.iw;

                if (l + this.width < j1)
                {
                    j1 = l + this.width;
                }

                for (int k1 = j * this.iw; i1 < j1; ++i1)
                {
                    int l1 = this.pixels[k1++] & 255;
                    int i2 = this.act[l1];

                    if (i2 != 0)
                    {
                        aint[i1] = i2;
                    }
                }
            }
        }
    }

    public BufferedImage getFrame(int n)
    {
        BufferedImage bufferedimage = null;

        if (n >= 0 && n < this.frameCount)
        {
            bufferedimage = ((GifDecoder.GifFrame)this.frames.get(n)).image;
        }

        return bufferedimage;
    }

    public Dimension getFrameSize()
    {
        return new Dimension(this.width, this.height);
    }

    public int read(BufferedInputStream is)
    {
        this.init();

        if (is != null)
        {
            this.in = is;
            this.readHeader();

            if (!this.err())
            {
                this.readContents();

                if (this.frameCount < 0)
                {
                    this.status = 1;
                }
            }

            try
            {
                is.close();
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
            }
        }
        else
        {
            this.status = 2;
        }

        return this.status;
    }

    public int read(InputStream is)
    {
        this.init();

        if (is != null)
        {
            if (!(is instanceof BufferedInputStream))
            {
                is = new BufferedInputStream((InputStream)is);
            }

            this.in = (BufferedInputStream)is;
            this.readHeader();

            if (!this.err())
            {
                this.readContents();

                if (this.frameCount < 0)
                {
                    this.status = 1;
                }
            }

            try
            {
                ((InputStream)is).close();
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
            }
        }
        else
        {
            this.status = 2;
        }

        return this.status;
    }

    public int read(String name)
    {
        this.status = 0;

        try
        {
            name = name.trim().toLowerCase();

            if (!name.contains("file:") && name.indexOf(":/") <= 0)
            {
                this.in = new BufferedInputStream(new FileInputStream(name));
            }
            else
            {
                URL url = new URL(name);
                this.in = new BufferedInputStream(url.openStream());
            }

            this.status = this.read(this.in);
        }
        catch (IOException var3)
        {
            this.status = 2;
        }

        return this.status;
    }

    protected void decodeImageData()
    {
        int i = -1;
        int j = this.iw * this.ih;

        if (this.pixels == null || this.pixels.length < j)
        {
            this.pixels = new byte[j];
        }

        if (this.prefix == null)
        {
            this.prefix = new short[4096];
        }

        if (this.suffix == null)
        {
            this.suffix = new byte[4096];
        }

        if (this.pixelStack == null)
        {
            this.pixelStack = new byte[4097];
        }

        int k3 = this.read();
        int l = 1 << k3;
        int k1 = l + 1;
        int k = l + 2;
        int i2 = i;
        int j1 = k3 + 1;
        int i1 = (1 << j1) - 1;

        for (int k2 = 0; k2 < l; ++k2)
        {
            this.prefix[k2] = 0;
            this.suffix[k2] = (byte)k2;
        }

        int j4 = 0;
        int k4 = 0;
        int i4 = 0;
        int l3 = 0;
        int l2 = 0;
        int j2 = 0;
        int j3 = 0;
        int i3 = 0;

        while (i3 < j)
        {
            if (i4 == 0)
            {
                if (j2 < j1)
                {
                    if (l2 == 0)
                    {
                        l2 = this.readBlock();

                        if (l2 <= 0)
                        {
                            break;
                        }

                        j4 = 0;
                    }

                    j3 += (this.block[j4] & 255) << j2;
                    j2 += 8;
                    ++j4;
                    --l2;
                    continue;
                }

                int l4 = j3 & i1;
                j3 >>= j1;
                j2 -= j1;

                if (l4 > k || l4 == k1)
                {
                    break;
                }

                if (l4 == l)
                {
                    j1 = k3 + 1;
                    i1 = (1 << j1) - 1;
                    k = l + 2;
                    i2 = i;
                    continue;
                }

                if (i2 == i)
                {
                    this.pixelStack[i4++] = this.suffix[l4];
                    i2 = l4;
                    l3 = l4;
                    continue;
                }

                int l1 = l4;

                if (l4 == k)
                {
                    this.pixelStack[i4++] = (byte)l3;
                    l4 = i2;
                }

                while (l4 > l)
                {
                    this.pixelStack[i4++] = this.suffix[l4];
                    l4 = this.prefix[l4];
                }

                l3 = this.suffix[l4] & 255;

                if (k >= 4096)
                {
                    this.pixelStack[i4++] = (byte)l3;
                    continue;
                }

                this.pixelStack[i4++] = (byte)l3;
                this.prefix[k] = (short)i2;
                this.suffix[k] = (byte)l3;
                ++k;

                if ((k & i1) == 0 && k < 4096)
                {
                    ++j1;
                    i1 += k;
                }

                i2 = l1;
            }

            --i4;
            this.pixels[k4++] = this.pixelStack[i4];
            ++i3;
        }

        for (i3 = k4; i3 < j; ++i3)
        {
            this.pixels[i3] = 0;
        }
    }

    protected boolean err()
    {
        return this.status != 0;
    }

    protected void init()
    {
        this.status = 0;
        this.frameCount = 0;
        this.frames = new ArrayList();
        this.gct = null;
        this.lct = null;
    }

    protected int read()
    {
        int i = 0;

        try
        {
            i = this.in.read();
        }
        catch (IOException var3)
        {
            this.status = 1;
        }

        return i;
    }

    protected int readBlock()
    {
        this.blockSize = this.read();
        int i = 0;

        if (this.blockSize > 0)
        {
            while (true)
            {
                try
                {
                    if (i < this.blockSize)
                    {
                        int j = this.in.read(this.block, i, this.blockSize - i);

                        if (j != -1)
                        {
                            i += j;
                            continue;
                        }
                    }
                }
                catch (IOException ioexception)
                {
                    ioexception.printStackTrace();
                }

                if (i < this.blockSize)
                {
                    this.status = 1;
                }

                break;
            }
        }

        return i;
    }

    protected int[] readColorTable(int ncolors)
    {
        int i = 3 * ncolors;
        int[] aint = null;
        byte[] abyte = new byte[i];
        int j = 0;

        try
        {
            j = this.in.read(abyte);
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }

        if (j < i)
        {
            this.status = 1;
        }
        else
        {
            aint = new int[256];
            int k = 0;
            int i1;
            int j1;
            int k1;

            for (int l = 0; k < ncolors; aint[k++] = -16777216 | i1 << 16 | j1 << 8 | k1)
            {
                i1 = abyte[l++] & 255;
                j1 = abyte[l++] & 255;
                k1 = abyte[l++] & 255;
            }
        }

        return aint;
    }

    protected void readContents()
    {
        boolean flag = false;

        while (!flag && !this.err())
        {
            int i = this.read();

            switch (i)
            {
                case 0:
                    break;

                case 33:
                    i = this.read();

                    switch (i)
                    {
                        case 249:
                            this.readGraphicControlExt();
                            continue;

                        case 255:
                            this.readBlock();
                            StringBuilder stringbuilder = new StringBuilder(11);

                            for (int j = 0; j < 11; ++j)
                            {
                                stringbuilder.append((char)this.block[j]);
                            }

                            if (stringbuilder.toString().equals("NETSCAPE2.0"))
                            {
                                this.readNetscapeExt();
                            }
                            else
                            {
                                this.skip();
                            }

                            continue;

                        default:
                            this.skip();
                            continue;
                    }

                case 44:
                    this.readImage();
                    break;

                case 59:
                    flag = true;
                    break;

                default:
                    this.status = 1;
            }
        }
    }

    protected void readGraphicControlExt()
    {
        this.read();
        int i = this.read();
        this.dispose = (i & 28) >> 2;

        if (this.dispose == 0)
        {
            this.dispose = 1;
        }

        this.transparency = (i & 1) != 0;
        this.delay = this.readShort() * 10;
        this.transIndex = this.read();
        this.read();
    }

    protected void readHeader()
    {
        StringBuilder stringbuilder = new StringBuilder(6);

        for (int i = 0; i < 6; ++i)
        {
            stringbuilder.append((char)this.read());
        }

        if (!stringbuilder.toString().startsWith("GIF"))
        {
            this.status = 1;
        }
        else
        {
            this.readLSD();

            if (this.gctFlag && !this.err())
            {
                this.gct = this.readColorTable(this.gctSize);
                this.bgColor = this.gct[this.bgIndex];
            }
        }
    }

    protected void readImage()
    {
        this.ix = this.readShort();
        this.iy = this.readShort();
        this.iw = this.readShort();
        this.ih = this.readShort();
        int i = this.read();
        this.lctFlag = (i & 128) != 0;
        this.interlace = (i & 64) != 0;
        this.lctSize = 2 << (i & 7);

        if (this.lctFlag)
        {
            this.lct = this.readColorTable(this.lctSize);
            this.act = this.lct;
        }
        else
        {
            this.act = this.gct;

            if (this.bgIndex == this.transIndex)
            {
                this.bgColor = 0;
            }
        }

        int j = 0;

        if (this.transparency)
        {
            j = this.act[this.transIndex];
            this.act[this.transIndex] = 0;
        }

        if (this.act == null)
        {
            this.status = 1;
        }

        if (!this.err())
        {
            this.decodeImageData();
            this.skip();

            if (!this.err())
            {
                ++this.frameCount;
                this.image = new BufferedImage(this.width, this.height, 2);
                this.setPixels();
                this.frames.add(new GifDecoder.GifFrame(this.image, this.delay));

                if (this.transparency)
                {
                    this.act[this.transIndex] = j;
                }

                this.resetFrame();
            }
        }
    }

    protected void readLSD()
    {
        this.width = this.readShort();
        this.height = this.readShort();
        int i = this.read();
        this.gctFlag = (i & 128) != 0;
        this.gctSize = 2 << (i & 7);
        this.bgIndex = this.read();
        this.pixelAspect = this.read();
    }

    protected void readNetscapeExt()
    {
        while (true)
        {
            this.readBlock();

            if (this.block[0] == 1)
            {
                int i = this.block[1] & 255;
                int j = this.block[2] & 255;
                this.loopCount = j << 8 | i;
            }

            if (this.blockSize <= 0 || this.err())
            {
                break;
            }
        }
    }

    protected int readShort()
    {
        return this.read() | this.read() << 8;
    }

    protected void resetFrame()
    {
        this.lastDispose = this.dispose;
        this.lastRect = new Rectangle(this.ix, this.iy, this.iw, this.ih);
        this.lastImage = this.image;
        this.lastBgColor = this.bgColor;
        this.dispose = 0;
        this.transparency = false;
        this.delay = 0;
        this.lct = null;
    }

    protected void skip()
    {
        while (true)
        {
            this.readBlock();

            if (this.blockSize <= 0 || this.err())
            {
                break;
            }
        }
    }

    static class GifFrame
    {
        public BufferedImage image;
        public int delay;

        public GifFrame(BufferedImage im, int del)
        {
            this.image = im;
            this.delay = del;
        }
    }
}
