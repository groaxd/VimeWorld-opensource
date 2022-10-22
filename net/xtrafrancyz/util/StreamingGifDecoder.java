package net.xtrafrancyz.util;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;

public class StreamingGifDecoder
{
    public static final int STATUS_OK = 0;
    public static final int STATUS_FORMAT_ERROR = 1;
    public static final int STATUS_OPEN_ERROR = 2;
    protected static final int MAX_STACK_SIZE = 4096;
    private static final int DISPOSAL_UNSPECIFIED = 0;
    private static final int DISPOSAL_NONE = 1;
    private static final int DISPOSAL_BACKGROUND = 2;
    private static final int DISPOSAL_PREVIOUS = 3;
    protected int status;
    protected int width;
    protected int height;
    protected boolean gctFlag;
    protected int gctSize;
    protected int loopCount = 1;
    protected int[] gct;
    protected int[] act;
    protected int bgIndex;
    protected int bgColor;
    protected int pixelAspect;
    protected boolean lctFlag;
    protected int lctSize;
    protected ByteBuffer rawData;
    protected byte[] block = new byte[256];
    protected int blockSize = 0;
    protected short[] prefix;
    protected byte[] suffix;
    protected byte[] pixelStack;
    protected byte[] mainPixels;
    protected ArrayList<StreamingGifDecoder.GifFrame> frames;
    protected StreamingGifDecoder.GifFrame currentFrame;
    protected BufferedImage previousImage;
    protected BufferedImage currentImage;
    protected int framePointer;
    protected int frameCount;
    protected BufferedImage currentImageCached;

    public void advance()
    {
        this.framePointer = (this.framePointer + 1) % this.frameCount;
        this.currentImageCached = null;
    }

    public int getDelay(int n)
    {
        int i = -1;

        if (n >= 0 && n < this.frameCount)
        {
            i = ((StreamingGifDecoder.GifFrame)this.frames.get(n)).delay;
        }

        return i;
    }

    public int getNextDelay()
    {
        return this.frameCount > 0 && this.framePointer >= 0 ? this.getDelay(this.framePointer) : -1;
    }

    public int getFrameCount()
    {
        return this.frameCount;
    }

    public int getCurrentFrameIndex()
    {
        return this.framePointer;
    }

    public int getLoopCount()
    {
        return this.loopCount;
    }

    public int getWidth()
    {
        return this.width;
    }

    public int getHeight()
    {
        return this.height;
    }

    public BufferedImage getNextFrame()
    {
        if (this.frameCount > 0 && this.framePointer >= 0 && this.currentImage != null)
        {
            if (this.currentImageCached != null)
            {
                return this.currentImageCached;
            }
            else
            {
                StreamingGifDecoder.GifFrame streaminggifdecoder$gifframe = (StreamingGifDecoder.GifFrame)this.frames.get(this.framePointer);

                if (streaminggifdecoder$gifframe.lct == null)
                {
                    this.act = this.gct;
                }
                else
                {
                    this.act = streaminggifdecoder$gifframe.lct;

                    if (this.bgIndex == streaminggifdecoder$gifframe.transIndex)
                    {
                        this.bgColor = 0;
                    }
                }

                int i = 0;

                if (streaminggifdecoder$gifframe.transparency)
                {
                    i = this.act[streaminggifdecoder$gifframe.transIndex];
                    this.act[streaminggifdecoder$gifframe.transIndex] = 0;
                }

                if (this.act == null)
                {
                    this.status = 1;
                    return null;
                }
                else
                {
                    this.setPixels(this.framePointer);

                    if (streaminggifdecoder$gifframe.transparency)
                    {
                        this.act[streaminggifdecoder$gifframe.transIndex] = i;
                    }

                    return this.currentImageCached = this.currentImage;
                }
            }
        }
        else
        {
            return null;
        }
    }

    public int read(InputStream is, int contentLength)
    {
        if (is != null)
        {
            try
            {
                int i = contentLength > 0 ? contentLength + 4096 : 4096;
                ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream(i);
                byte[] abyte = new byte[16384];
                int j;

                while ((j = is.read(abyte, 0, abyte.length)) != -1)
                {
                    bytearrayoutputstream.write(abyte, 0, j);
                }

                bytearrayoutputstream.flush();
                this.read(bytearrayoutputstream.toByteArray());
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
            }

            try
            {
                is.close();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
        else
        {
            this.status = 2;
        }

        return this.status;
    }

    public int read(byte[] data)
    {
        this.init();

        if (data != null)
        {
            this.rawData = ByteBuffer.wrap(data);
            this.rawData.rewind();
            this.rawData.order(ByteOrder.LITTLE_ENDIAN);
            this.readHeader();

            if (!this.err())
            {
                this.readContents();

                if (this.frameCount < 0)
                {
                    this.status = 1;
                }
            }
        }
        else
        {
            this.status = 2;
        }

        return this.status;
    }

    protected void setPixels(int frameIndex)
    {
        StreamingGifDecoder.GifFrame streaminggifdecoder$gifframe = (StreamingGifDecoder.GifFrame)this.frames.get(frameIndex);
        StreamingGifDecoder.GifFrame streaminggifdecoder$gifframe1 = null;
        int i = frameIndex - 1;

        if (i >= 0)
        {
            streaminggifdecoder$gifframe1 = (StreamingGifDecoder.GifFrame)this.frames.get(i);
        }

        int[] aint = ((DataBufferInt)this.currentImage.getRaster().getDataBuffer()).getData();

        if (streaminggifdecoder$gifframe1 != null && streaminggifdecoder$gifframe1.dispose > 0)
        {
            if (streaminggifdecoder$gifframe1.dispose == 3)
            {
                System.arraycopy(((DataBufferInt)this.previousImage.getRaster().getDataBuffer()).getData(), 0, aint, 0, aint.length);
            }
            else
            {
                System.arraycopy(aint, 0, ((DataBufferInt)this.previousImage.getRaster().getDataBuffer()).getData(), 0, aint.length);

                if (streaminggifdecoder$gifframe1.dispose == 2)
                {
                    int j = 0;

                    if (!streaminggifdecoder$gifframe.transparency)
                    {
                        j = this.bgColor;
                    }

                    for (int k = 0; k < streaminggifdecoder$gifframe1.ih; ++k)
                    {
                        int l = (streaminggifdecoder$gifframe1.iy + k) * this.width + streaminggifdecoder$gifframe1.ix;
                        int i1 = l + streaminggifdecoder$gifframe1.iw;

                        for (int j1 = l; j1 < i1; ++j1)
                        {
                            aint[j1] = j;
                        }
                    }
                }
            }
        }
        else
        {
            Arrays.fill(aint, streaminggifdecoder$gifframe.transparency ? 0 : this.bgColor);
        }

        this.decodePixels(streaminggifdecoder$gifframe, this.mainPixels);
        int i3 = 1;
        int j3 = 8;
        int k3 = 0;

        for (int l3 = 0; l3 < streaminggifdecoder$gifframe.ih; ++l3)
        {
            int i4 = l3;

            if (streaminggifdecoder$gifframe.interlace)
            {
                if (k3 >= streaminggifdecoder$gifframe.ih)
                {
                    ++i3;

                    switch (i3)
                    {
                        case 2:
                            k3 = 4;
                            break;

                        case 3:
                            k3 = 2;
                            j3 = 4;
                            break;

                        case 4:
                            k3 = 1;
                            j3 = 2;
                    }
                }

                i4 = k3;
                k3 += j3;
            }

            i4 = i4 + streaminggifdecoder$gifframe.iy;

            if (i4 < this.height)
            {
                int k1 = i4 * this.width;
                int l1 = k1 + streaminggifdecoder$gifframe.ix;
                int i2 = l1 + streaminggifdecoder$gifframe.iw;

                if (k1 + this.width < i2)
                {
                    i2 = k1 + this.width;
                }

                for (int j2 = l3 * streaminggifdecoder$gifframe.iw; l1 < i2; ++l1)
                {
                    int k2 = this.mainPixels[j2++] & 255;
                    int l2 = this.act[k2];

                    if (l2 != 0)
                    {
                        aint[l1] = l2;
                    }
                }
            }
        }

        System.arraycopy(aint, 0, ((DataBufferInt)this.currentImage.getRaster().getDataBuffer()).getData(), 0, aint.length);
    }

    protected void decodePixels(StreamingGifDecoder.GifFrame frame, byte[] dstPixels)
    {
        this.rawData.position(frame.bufferFrameStart);
        int i = -1;
        int j = frame.iw * frame.ih;

        if (dstPixels == null || dstPixels.length < j)
        {
            dstPixels = new byte[j];
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
            dstPixels[k4++] = this.pixelStack[i4];
            ++i3;
        }

        for (i3 = k4; i3 < j; ++i3)
        {
            dstPixels[i3] = 0;
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
        this.framePointer = -1;
        this.frames = new ArrayList();
        this.gct = null;
    }

    protected int read()
    {
        int i = 0;

        try
        {
            i = this.rawData.get() & 255;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
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
            try
            {
                while (i < this.blockSize)
                {
                    int j = this.blockSize - i;
                    this.rawData.get(this.block, i, j);
                    i += j;
                }
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                this.status = 1;
            }
        }

        return i;
    }

    protected int[] readColorTable(int ncolors)
    {
        int i = 3 * ncolors;
        int[] aint = null;
        byte[] abyte = new byte[i];

        try
        {
            this.rawData.get(abyte);
            aint = new int[256];
            int j = 0;
            int l;
            int i1;
            int j1;

            for (int k = 0; j < ncolors; aint[j++] = -16777216 | l << 16 | i1 << 8 | j1)
            {
                l = abyte[k++] & 255;
                i1 = abyte[k++] & 255;
                j1 = abyte[k++] & 255;
            }
        }
        catch (BufferUnderflowException bufferunderflowexception)
        {
            bufferunderflowexception.printStackTrace();
            this.status = 1;
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
                default:
                    this.status = 1;
                    break;

                case 33:
                    i = this.read();

                    switch (i)
                    {
                        case 1:
                        case 254:
                        default:
                            this.skip();
                            continue;

                        case 249:
                            this.currentFrame = new StreamingGifDecoder.GifFrame();
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
                    }

                case 44:
                    this.readImageData();
                    break;

                case 59:
                    flag = true;
            }
        }
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

    protected void readGraphicControlExt()
    {
        this.read();
        int i = this.read();
        this.currentFrame.dispose = (i & 28) >> 2;

        if (this.currentFrame.dispose == 0)
        {
            this.currentFrame.dispose = 1;
        }

        this.currentFrame.transparency = (i & 1) != 0;
        this.currentFrame.delay = this.readShort() * 10;
        this.currentFrame.transIndex = this.read();
        this.read();
    }

    protected void readImageData()
    {
        if (this.currentFrame == null || this.currentFrame.bufferFrameStart != 0)
        {
            this.currentFrame = new StreamingGifDecoder.GifFrame();
        }

        this.currentFrame.ix = this.readShort();
        this.currentFrame.iy = this.readShort();
        this.currentFrame.iw = this.readShort();
        this.currentFrame.ih = this.readShort();
        int i = this.read();
        this.lctFlag = (i & 128) != 0;
        this.lctSize = (int)Math.pow(2.0D, (double)((i & 7) + 1));
        this.currentFrame.interlace = (i & 64) != 0;

        if (this.lctFlag)
        {
            this.currentFrame.lct = this.readColorTable(this.lctSize);
        }
        else
        {
            this.currentFrame.lct = null;
        }

        this.currentFrame.bufferFrameStart = this.rawData.position();
        this.read();
        this.skip();

        if (!this.err())
        {
            ++this.frameCount;
            this.frames.add(this.currentFrame);
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
        this.mainPixels = new byte[this.width * this.height];
        this.previousImage = new BufferedImage(this.width, this.height, 2);
        this.currentImage = new BufferedImage(this.width, this.height, 2);
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
        return this.rawData.getShort();
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

    private static class GifFrame
    {
        public int ix;
        public int iy;
        public int iw;
        public int ih;
        public boolean interlace;
        public boolean transparency;
        public int dispose;
        public int transIndex;
        public int delay;
        public int bufferFrameStart;
        public int[] lct;

        private GifFrame()
        {
        }
    }
}
