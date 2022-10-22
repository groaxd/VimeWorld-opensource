package net.xtrafrancyz.util;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public class PngDecoder
{
    public static PngDecoder.Format ALPHA = new PngDecoder.Format(1, true);
    public static PngDecoder.Format LUMINANCE = new PngDecoder.Format(1, false);
    public static PngDecoder.Format LUMINANCE_ALPHA = new PngDecoder.Format(2, true);
    public static PngDecoder.Format RGB = new PngDecoder.Format(3, false);
    public static PngDecoder.Format RGBA = new PngDecoder.Format(4, true);
    public static PngDecoder.Format BGRA = new PngDecoder.Format(4, true);
    public static PngDecoder.Format ABGR = new PngDecoder.Format(4, true);
    public static PngDecoder.Format ARGB = new PngDecoder.Format(4, true);
    private static final byte[] SIGNATURE = new byte[] {(byte) - 119, (byte)80, (byte)78, (byte)71, (byte)13, (byte)10, (byte)26, (byte)10};
    private static final int IHDR = 1229472850;
    private static final int PLTE = 1347179589;
    private static final int tRNS = 1951551059;
    private static final int IDAT = 1229209940;
    private static final int IEND = 1229278788;
    private static final int acTL = 1633899596;
    private static final int fcTL = 1717785676;
    private static final int fdAT = 1717846356;
    private static final byte COLOR_GREYSCALE = 0;
    private static final byte COLOR_TRUECOLOR = 2;
    private static final byte COLOR_INDEXED = 3;
    private static final byte COLOR_GREYALPHA = 4;
    private static final byte COLOR_TRUEALPHA = 6;
    private static final byte APNG_DISPOSE_OP_NONE = 0;
    private static final byte APNG_DISPOSE_OP_BACKGROUND = 1;
    private static final byte APNG_DISPOSE_OP_PREVIOUS = 2;
    private static final byte APNG_BLEND_OP_SOURCE = 0;
    private static final byte APNG_BLEND_OP_OVER = 1;
    private final InputStream input;
    private final CRC32 crc;
    private final byte[] buffer;
    private int chunkLength;
    private int chunkType;
    private int chunkRemaining;
    private int width;
    private int height;
    private int bitdepth;
    private int colorType;
    private int bytesPerPixel;
    private byte[] palette;
    private byte[] paletteA;
    private byte[] transPixel;
    public int loopCount;
    public List<PngDecoder.Frame> frames = new ArrayList();
    public ByteBuffer defaultFrame;
    private boolean animated;
    private int outBytesPerPixel;
    private PngDecoder.Format outFormat;
    private int seqNum = -1;
    private int numFrames = 1;
    private PngDecoder.Frame fc;

    public PngDecoder(InputStream input) throws IOException
    {
        this.input = input;
        this.crc = new CRC32();
        this.buffer = new byte[4096];
        this.readFully(this.buffer, 0, SIGNATURE.length);

        if (!checkSignature(this.buffer))
        {
            throw new IOException("Not a valid PNG file");
        }
        else
        {
            this.outFormat = ARGB;
            this.outBytesPerPixel = this.outFormat.numComponents;
            this.openChunk(1229472850);
            this.readIHDR();
            this.closeChunk();

            while (true)
            {
                this.openChunk();

                switch (this.chunkType)
                {
                    case 1229209940:
                        this.readIDAT();
                        break;

                    case 1229278788:
                        if (this.colorType == 3 && this.palette == null)
                        {
                            throw new IOException("Missing PLTE chunk");
                        }

                        if (this.animated && ((PngDecoder.Frame)this.frames.get(0)).width == 0)
                        {
                            this.frames.remove(0);
                        }

                        return;

                    case 1347179589:
                        this.readPLTE();
                        break;

                    case 1633899596:
                        this.readacTL();
                        break;

                    case 1717785676:
                        this.readfcTL();
                        break;

                    case 1717846356:
                        this.readfdAT();
                        break;

                    case 1951551059:
                        this.readtRNS();
                }

                this.closeChunk();
            }
        }
    }

    public int getHeight()
    {
        return this.height;
    }

    public int getWidth()
    {
        return this.width;
    }

    public boolean isAnimated()
    {
        return this.animated;
    }

    public boolean hasAlpha()
    {
        return this.colorType == 6 || this.paletteA != null || this.transPixel != null;
    }

    public boolean isRGB()
    {
        return this.colorType == 6 || this.colorType == 2 || this.colorType == 3;
    }

    private void readIDAT() throws IOException
    {
        ByteBuffer bytebuffer = ByteBuffer.allocate(this.width * this.height * this.outBytesPerPixel);
        this.decode(bytebuffer, this.width * this.outBytesPerPixel, this.outFormat, 1229209940);
        bytebuffer.rewind();
        this.defaultFrame = bytebuffer;
        PngDecoder.Frame pngdecoder$frame;

        if (this.fc == null)
        {
            pngdecoder$frame = new PngDecoder.Frame();
        }
        else
        {
            pngdecoder$frame = this.fc;
        }

        pngdecoder$frame.image = bytebuffer;
        this.frames.add(pngdecoder$frame);
        this.fc = null;
    }

    private void readfdAT() throws IOException
    {
        this.readChunk(this.buffer, 0, 4);
        this.checkSeqNum(this.readInt(this.buffer, 0));
        ByteBuffer bytebuffer = ByteBuffer.allocate(this.fc.width * this.fc.height * this.outBytesPerPixel);
        this.decode(bytebuffer, this.fc.width * this.outBytesPerPixel, this.outFormat, 1717846356);
        ByteBuffer bytebuffer1 = ByteBuffer.allocate(this.width * this.height * this.outBytesPerPixel);

        switch (this.fc.disposeOp)
        {
            case 0:
                ByteBuffer bytebuffer3 = ((PngDecoder.Frame)this.frames.get(this.frames.size() - 1)).image;
                bytebuffer1.put(bytebuffer3);
                bytebuffer3.rewind();
                break;

            case 1:
                ByteBuffer bytebuffer2 = ((PngDecoder.Frame)this.frames.get(this.frames.size() - 1)).image;
                bytebuffer1.put(bytebuffer2);
                bytebuffer2.rewind();

                if (this.fc.blendOp != 0)
                {
                    this.fillFrameBlack(bytebuffer1, this.fc, this.outBytesPerPixel);
                }

                break;

            case 2:
                int i = this.frames.size();

                if (i > 1)
                {
                    for (int j = i - 2; j >= 0; --j)
                    {
                        PngDecoder.Frame pngdecoder$frame = (PngDecoder.Frame)this.frames.get(j);

                        if (pngdecoder$frame.disposeOp != 2)
                        {
                            bytebuffer1.put(pngdecoder$frame.image);
                            pngdecoder$frame.image.rewind();

                            if (pngdecoder$frame.disposeOp == 1)
                            {
                                this.fillFrameBlack(bytebuffer1, pngdecoder$frame, this.outBytesPerPixel);
                            }

                            break;
                        }
                    }
                }
        }

        int k2 = this.outBytesPerPixel;

        if (k2 == 3 && this.fc.blendOp == 1)
        {
            this.fc.blendOp = 0;
        }

        label0:

        switch (this.fc.blendOp)
        {
            case 0:
                int i3 = this.fc.yOffset;

                while (true)
                {
                    if (i3 >= this.fc.yOffset + this.fc.height)
                    {
                        break label0;
                    }

                    bytebuffer1.position((i3 * this.width + this.fc.xOffset) * k2);
                    bytebuffer.position((i3 - this.fc.yOffset) * this.fc.width * k2);
                    bytebuffer.limit(bytebuffer.position() + this.fc.width * k2);
                    bytebuffer1.put(bytebuffer);
                    ++i3;
                }

            case 1:
                for (int j1 = this.fc.yOffset; j1 < this.fc.yOffset + this.fc.height; ++j1)
                {
                    int k1 = (j1 * this.width + this.fc.xOffset) * k2;
                    int l1 = (j1 - this.fc.yOffset) * this.fc.width * k2;

                    for (int i2 = this.fc.xOffset; i2 < this.fc.xOffset + this.fc.width; l1 += 4)
                    {
                        int l2 = bytebuffer.get(l1) & 255;
                        int j3 = bytebuffer1.get(k1) & 255;

                        if (l2 != 255 && (l2 != 0 || j3 != 0))
                        {
                            int k = l2 * 255;
                            int l = (255 - l2) * j3;
                            int i1 = k + l;

                            for (int k3 = 1; k3 < 4; ++k3)
                            {
                                bytebuffer1.put(k1 + k3, (byte)(((bytebuffer.get(l1 + k3) & 255) * k + (bytebuffer1.get(k1 + k3) & 255) * l) / i1));
                            }

                            bytebuffer1.put(k1, (byte)(i1 / 255));
                        }
                        else
                        {
                            for (int j2 = 0; j2 < 4; ++j2)
                            {
                                bytebuffer1.put(k1 + j2, bytebuffer.get(l1 + j2));
                            }
                        }

                        ++i2;
                        k1 += 4;
                    }
                }
        }

        bytebuffer1.clear();
        this.fc.image = bytebuffer1;
        this.frames.add(this.fc);
        this.fc = null;
    }

    private void fillFrameBlack(ByteBuffer canvas, PngDecoder.Frame frame, int bytesPerPixel)
    {
        byte[] abyte;

        if (this.buffer.length >= frame.width * bytesPerPixel)
        {
            Arrays.fill((byte[])this.buffer, 0, frame.width * bytesPerPixel, (byte)0);
            abyte = this.buffer;
        }
        else
        {
            abyte = new byte[frame.width * bytesPerPixel];
        }

        for (int i = frame.yOffset; i < frame.yOffset + frame.height; ++i)
        {
            canvas.position(i * this.width * bytesPerPixel + frame.xOffset * bytesPerPixel);
            canvas.put(abyte, 0, frame.width * bytesPerPixel);
        }

        canvas.rewind();
    }

    private void decode(ByteBuffer buffer, int stride, PngDecoder.Format fmt, int chunkType) throws IOException
    {
        int i = chunkType == 1229209940 ? this.width : this.fc.width;
        int j = chunkType == 1229209940 ? this.height : this.fc.height;
        int k = buffer.position();
        int l = (i * this.bitdepth + 7) / 8 * this.bytesPerPixel;
        byte[] abyte = new byte[l + 1];
        byte[] abyte1 = new byte[l + 1];
        byte[] abyte2 = this.bitdepth < 8 ? new byte[i + 1] : null;
        Inflater inflater = new Inflater();

        try
        {
            for (int i1 = 0; i1 < j; ++i1)
            {
                this.readChunkUnzip(inflater, abyte, 0, abyte.length, chunkType);
                this.unfilter(abyte, abyte1);
                buffer.position(k + i1 * stride);

                switch (this.colorType)
                {
                    case 0:
                        switch (this.bitdepth)
                        {
                            case 1:
                                this.expand1(abyte, abyte2);
                                break;

                            case 2:
                                this.expand2(abyte, abyte2);
                                break;

                            case 3:
                            case 5:
                            case 6:
                            case 7:
                            default:
                                throw new UnsupportedOperationException("Unsupported bitdepth for this image");

                            case 4:
                                this.expand4(abyte, abyte2);
                                break;

                            case 8:
                                abyte2 = abyte;
                        }

                        if (fmt != LUMINANCE && fmt != ALPHA)
                        {
                            if (fmt != ARGB)
                            {
                                throw new UnsupportedOperationException("Unsupported format for this image");
                            }

                            this.copyGREYtoARGB(buffer, abyte2);
                        }
                        else
                        {
                            this.copy(buffer, abyte2);
                        }

                        break;

                    case 1:
                    case 5:
                    default:
                        throw new UnsupportedOperationException("Not yet implemented");

                    case 2:
                        if (fmt == ABGR)
                        {
                            this.copyRGBtoABGR(buffer, abyte);
                        }
                        else if (fmt == RGBA)
                        {
                            this.copyRGBtoRGBA(buffer, abyte);
                        }
                        else if (fmt == BGRA)
                        {
                            this.copyRGBtoBGRA(buffer, abyte);
                        }
                        else if (fmt == ARGB)
                        {
                            this.copyRGBtoARGB(buffer, abyte);
                        }
                        else
                        {
                            if (fmt != RGB)
                            {
                                throw new UnsupportedOperationException("Unsupported format for this image");
                            }

                            this.copy(buffer, abyte);
                        }

                        break;

                    case 3:
                        switch (this.bitdepth)
                        {
                            case 1:
                                this.expand1(abyte, abyte2);
                                break;

                            case 2:
                                this.expand2(abyte, abyte2);
                                break;

                            case 3:
                            case 5:
                            case 6:
                            case 7:
                            default:
                                throw new UnsupportedOperationException("Unsupported bitdepth for this image");

                            case 4:
                                this.expand4(abyte, abyte2);
                                break;

                            case 8:
                                abyte2 = abyte;
                        }

                        if (fmt == ABGR)
                        {
                            this.copyPALtoABGR(buffer, abyte2);
                        }
                        else if (fmt == RGBA)
                        {
                            this.copyPALtoRGBA(buffer, abyte2);
                        }
                        else if (fmt == BGRA)
                        {
                            this.copyPALtoBGRA(buffer, abyte2);
                        }
                        else
                        {
                            if (fmt != ARGB)
                            {
                                throw new UnsupportedOperationException("Unsupported format for this image");
                            }

                            this.copyPALtoARGB(buffer, abyte2);
                        }

                        break;

                    case 4:
                        if (fmt == LUMINANCE_ALPHA)
                        {
                            this.copy(buffer, abyte);
                        }
                        else
                        {
                            if (fmt != ARGB)
                            {
                                throw new UnsupportedOperationException("Unsupported format for this image");
                            }

                            this.copyGREYALPHAtoARGB(buffer, abyte);
                        }

                        break;

                    case 6:
                        if (fmt == ABGR)
                        {
                            this.copyRGBAtoABGR(buffer, abyte);
                        }
                        else if (fmt == RGBA)
                        {
                            this.copy(buffer, abyte);
                        }
                        else if (fmt == BGRA)
                        {
                            this.copyRGBAtoBGRA(buffer, abyte);
                        }
                        else if (fmt == ARGB)
                        {
                            this.copyRGBAtoARGB(buffer, abyte);
                        }
                        else
                        {
                            if (fmt != RGB)
                            {
                                throw new UnsupportedOperationException("Unsupported format for this image");
                            }

                            this.copyRGBAtoRGB(buffer, abyte);
                        }
                }

                byte[] abyte3 = abyte;
                abyte = abyte1;
                abyte1 = abyte3;
            }
        }
        finally
        {
            inflater.end();
        }
    }

    private void copy(ByteBuffer buffer, byte[] curLine)
    {
        buffer.put(curLine, 1, curLine.length - 1);
    }

    private void copyRGBtoABGR(ByteBuffer buffer, byte[] curLine)
    {
        if (this.transPixel != null)
        {
            byte b0 = this.transPixel[1];
            byte b1 = this.transPixel[3];
            byte b2 = this.transPixel[5];
            int i = 1;

            for (int j = curLine.length; i < j; i += 3)
            {
                byte b3 = curLine[i];
                byte b4 = curLine[i + 1];
                byte b5 = curLine[i + 2];
                byte b6 = -1;

                if (b3 == b0 && b4 == b1 && b5 == b2)
                {
                    b6 = 0;
                }

                buffer.put(b6).put(b5).put(b4).put(b3);
            }
        }
        else
        {
            int k = 1;

            for (int l = curLine.length; k < l; k += 3)
            {
                buffer.put((byte) - 1).put(curLine[k + 2]).put(curLine[k + 1]).put(curLine[k]);
            }
        }
    }

    private void copyRGBtoRGBA(ByteBuffer buffer, byte[] curLine)
    {
        if (this.transPixel != null)
        {
            byte b0 = this.transPixel[1];
            byte b1 = this.transPixel[3];
            byte b2 = this.transPixel[5];
            int i = 1;

            for (int j = curLine.length; i < j; i += 3)
            {
                byte b3 = curLine[i];
                byte b4 = curLine[i + 1];
                byte b5 = curLine[i + 2];
                byte b6 = -1;

                if (b3 == b0 && b4 == b1 && b5 == b2)
                {
                    b6 = 0;
                }

                buffer.put(b3).put(b4).put(b5).put(b6);
            }
        }
        else
        {
            int k = 1;

            for (int l = curLine.length; k < l; k += 3)
            {
                buffer.put(curLine[k]).put(curLine[k + 1]).put(curLine[k + 2]).put((byte) - 1);
            }
        }
    }

    private void copyRGBtoARGB(ByteBuffer buffer, byte[] curLine)
    {
        if (this.transPixel != null)
        {
            byte b0 = this.transPixel[1];
            byte b1 = this.transPixel[3];
            byte b2 = this.transPixel[5];
            int i = 1;

            for (int j = curLine.length; i < j; i += 3)
            {
                byte b3 = curLine[i];
                byte b4 = curLine[i + 1];
                byte b5 = curLine[i + 2];
                byte b6 = -1;

                if (b3 == b0 && b4 == b1 && b5 == b2)
                {
                    b6 = 0;
                }

                buffer.put(b6).put(b3).put(b4).put(b5);
            }
        }
        else
        {
            int k = 1;

            for (int l = curLine.length; k < l; k += 3)
            {
                buffer.put((byte) - 1).put(curLine[k]).put(curLine[k + 1]).put(curLine[k + 2]);
            }
        }
    }

    private void copyRGBtoBGRA(ByteBuffer buffer, byte[] curLine)
    {
        if (this.transPixel != null)
        {
            byte b0 = this.transPixel[1];
            byte b1 = this.transPixel[3];
            byte b2 = this.transPixel[5];
            int i = 1;

            for (int j = curLine.length; i < j; i += 3)
            {
                byte b3 = curLine[i];
                byte b4 = curLine[i + 1];
                byte b5 = curLine[i + 2];
                byte b6 = -1;

                if (b3 == b0 && b4 == b1 && b5 == b2)
                {
                    b6 = 0;
                }

                buffer.put(b5).put(b4).put(b3).put(b6);
            }
        }
        else
        {
            int k = 1;

            for (int l = curLine.length; k < l; k += 3)
            {
                buffer.put(curLine[k + 2]).put(curLine[k + 1]).put(curLine[k]).put((byte) - 1);
            }
        }
    }

    private void copyRGBAtoABGR(ByteBuffer buffer, byte[] curLine)
    {
        int i = 1;

        for (int j = curLine.length; i < j; i += 4)
        {
            buffer.put(curLine[i + 3]).put(curLine[i + 2]).put(curLine[i + 1]).put(curLine[i]);
        }
    }

    private void copyRGBAtoARGB(ByteBuffer buffer, byte[] curLine)
    {
        int i = 1;

        for (int j = curLine.length; i < j; i += 4)
        {
            buffer.put(curLine[i + 3]).put(curLine[i]).put(curLine[i + 1]).put(curLine[i + 2]);
        }
    }

    private void copyRGBAtoBGRA(ByteBuffer buffer, byte[] curLine)
    {
        int i = 1;

        for (int j = curLine.length; i < j; i += 4)
        {
            buffer.put(curLine[i + 2]).put(curLine[i + 1]).put(curLine[i]).put(curLine[i + 3]);
        }
    }

    private void copyRGBAtoRGB(ByteBuffer buffer, byte[] curLine)
    {
        int i = 1;

        for (int j = curLine.length; i < j; i += 4)
        {
            buffer.put(curLine[i]).put(curLine[i + 1]).put(curLine[i + 2]);
        }
    }

    private void copyPALtoABGR(ByteBuffer buffer, byte[] curLine)
    {
        if (this.paletteA != null)
        {
            int i = 1;

            for (int j = curLine.length; i < j; ++i)
            {
                int k = curLine[i] & 255;
                byte b0 = this.palette[k * 3];
                byte b1 = this.palette[k * 3 + 1];
                byte b2 = this.palette[k * 3 + 2];
                byte b3 = this.paletteA[k];
                buffer.put(b3).put(b2).put(b1).put(b0);
            }
        }
        else
        {
            int l = 1;

            for (int i1 = curLine.length; l < i1; ++l)
            {
                int j1 = curLine[l] & 255;
                byte b4 = this.palette[j1 * 3];
                byte b5 = this.palette[j1 * 3 + 1];
                byte b6 = this.palette[j1 * 3 + 2];
                byte b7 = -1;
                buffer.put(b7).put(b6).put(b5).put(b4);
            }
        }
    }

    private void copyPALtoARGB(ByteBuffer buffer, byte[] curLine)
    {
        if (this.paletteA != null)
        {
            int i = 1;

            for (int j = curLine.length; i < j; ++i)
            {
                int k = curLine[i] & 255;
                byte b0 = this.palette[k * 3];
                byte b1 = this.palette[k * 3 + 1];
                byte b2 = this.palette[k * 3 + 2];
                byte b3 = this.paletteA[k];
                buffer.put(b3).put(b0).put(b1).put(b2);
            }
        }
        else
        {
            int l = 1;

            for (int i1 = curLine.length; l < i1; ++l)
            {
                int j1 = curLine[l] & 255;
                byte b4 = this.palette[j1 * 3];
                byte b5 = this.palette[j1 * 3 + 1];
                byte b6 = this.palette[j1 * 3 + 2];
                byte b7 = -1;
                buffer.put(b7).put(b4).put(b5).put(b6);
            }
        }
    }

    private void copyPALtoRGBA(ByteBuffer buffer, byte[] curLine)
    {
        if (this.paletteA != null)
        {
            int i = 1;

            for (int j = curLine.length; i < j; ++i)
            {
                int k = curLine[i] & 255;
                byte b0 = this.palette[k * 3];
                byte b1 = this.palette[k * 3 + 1];
                byte b2 = this.palette[k * 3 + 2];
                byte b3 = this.paletteA[k];
                buffer.put(b0).put(b1).put(b2).put(b3);
            }
        }
        else
        {
            int l = 1;

            for (int i1 = curLine.length; l < i1; ++l)
            {
                int j1 = curLine[l] & 255;
                byte b4 = this.palette[j1 * 3];
                byte b5 = this.palette[j1 * 3 + 1];
                byte b6 = this.palette[j1 * 3 + 2];
                byte b7 = -1;
                buffer.put(b4).put(b5).put(b6).put(b7);
            }
        }
    }

    private void copyPALtoBGRA(ByteBuffer buffer, byte[] curLine)
    {
        if (this.paletteA != null)
        {
            int i = 1;

            for (int j = curLine.length; i < j; ++i)
            {
                int k = curLine[i] & 255;
                byte b0 = this.palette[k * 3];
                byte b1 = this.palette[k * 3 + 1];
                byte b2 = this.palette[k * 3 + 2];
                byte b3 = this.paletteA[k];
                buffer.put(b2).put(b1).put(b0).put(b3);
            }
        }
        else
        {
            int l = 1;

            for (int i1 = curLine.length; l < i1; ++l)
            {
                int j1 = curLine[l] & 255;
                byte b4 = this.palette[j1 * 3];
                byte b5 = this.palette[j1 * 3 + 1];
                byte b6 = this.palette[j1 * 3 + 2];
                byte b7 = -1;
                buffer.put(b6).put(b5).put(b4).put(b7);
            }
        }
    }

    private void copyGREYtoARGB(ByteBuffer buffer, byte[] curLine)
    {
        int i = 1;

        for (int j = curLine.length; i < j; ++i)
        {
            byte b0 = curLine[i];
            buffer.put((byte) - 1).put(b0).put(b0).put(b0);
        }
    }

    private void copyGREYALPHAtoARGB(ByteBuffer buffer, byte[] curLine)
    {
        int i = 1;

        for (int j = curLine.length; i < j; i += 2)
        {
            byte b0 = curLine[i];
            byte b1 = curLine[i + 1];
            buffer.put(b1).put(b0).put(b0).put(b0);
        }
    }

    private void expand4(byte[] src, byte[] dst)
    {
        int i = 1;

        for (int j = dst.length; i < j; i += 2)
        {
            int k = src[1 + (i >> 1)] & 255;

            switch (j - i)
            {
                default:
                    dst[i + 1] = (byte)(k & 15);

                case 1:
                    dst[i] = (byte)(k >> 4);
            }
        }
    }

    private void expand2(byte[] src, byte[] dst)
    {
        int i = 1;

        for (int j = dst.length; i < j; i += 4)
        {
            int k = src[1 + (i >> 2)] & 255;

            switch (j - i)
            {
                default:
                    dst[i + 3] = (byte)(k & 3);

                case 3:
                    dst[i + 2] = (byte)(k >> 2 & 3);

                case 2:
                    dst[i + 1] = (byte)(k >> 4 & 3);

                case 1:
                    dst[i] = (byte)(k >> 6);
            }
        }
    }

    private void expand1(byte[] src, byte[] dst)
    {
        int i = 1;

        for (int j = dst.length; i < j; i += 8)
        {
            int k = src[1 + (i >> 3)] & 255;

            switch (j - i)
            {
                default:
                    dst[i + 7] = (byte)(k & 1);

                case 7:
                    dst[i + 6] = (byte)(k >> 1 & 1);

                case 6:
                    dst[i + 5] = (byte)(k >> 2 & 1);

                case 5:
                    dst[i + 4] = (byte)(k >> 3 & 1);

                case 4:
                    dst[i + 3] = (byte)(k >> 4 & 1);

                case 3:
                    dst[i + 2] = (byte)(k >> 5 & 1);

                case 2:
                    dst[i + 1] = (byte)(k >> 6 & 1);

                case 1:
                    dst[i] = (byte)(k >> 7);
            }
        }
    }

    private void unfilter(byte[] curLine, byte[] prevLine) throws IOException
    {
        switch (curLine[0])
        {
            case 0:
                break;

            case 1:
                this.unfilterSub(curLine);
                break;

            case 2:
                this.unfilterUp(curLine, prevLine);
                break;

            case 3:
                this.unfilterAverage(curLine, prevLine);
                break;

            case 4:
                this.unfilterPaeth(curLine, prevLine);
                break;

            default:
                throw new IOException("invalide filter type in scanline: " + curLine[0]);
        }
    }

    private void unfilterSub(byte[] curLine)
    {
        int i = this.bytesPerPixel;
        int j = i + 1;

        for (int k = curLine.length; j < k; ++j)
        {
            curLine[j] += curLine[j - i];
        }
    }

    private void unfilterUp(byte[] curLine, byte[] prevLine)
    {
        int i = 1;

        for (int j = curLine.length; i < j; ++i)
        {
            curLine[i] += prevLine[i];
        }
    }

    private void unfilterAverage(byte[] curLine, byte[] prevLine)
    {
        int i = this.bytesPerPixel;
        int j;

        for (j = 1; j <= i; ++j)
        {
            curLine[j] += (byte)((prevLine[j] & 255) >>> 1);
        }

        for (int k = curLine.length; j < k; ++j)
        {
            curLine[j] += (byte)((prevLine[j] & 255) + (curLine[j - i] & 255) >>> 1);
        }
    }

    private void unfilterPaeth(byte[] curLine, byte[] prevLine)
    {
        int i = this.bytesPerPixel;
        int j;

        for (j = 1; j <= i; ++j)
        {
            curLine[j] += prevLine[j];
        }

        for (int k = curLine.length; j < k; ++j)
        {
            int l = curLine[j - i] & 255;
            int i1 = prevLine[j] & 255;
            int j1 = prevLine[j - i] & 255;
            int k1 = l + i1 - j1;
            int l1 = k1 - l;

            if (l1 < 0)
            {
                l1 = -l1;
            }

            int i2 = k1 - i1;

            if (i2 < 0)
            {
                i2 = -i2;
            }

            int j2 = k1 - j1;

            if (j2 < 0)
            {
                j2 = -j2;
            }

            if (l1 <= i2 && l1 <= j2)
            {
                j1 = l;
            }
            else if (i2 <= j2)
            {
                j1 = i1;
            }

            curLine[j] += (byte)j1;
        }
    }

    private void readIHDR() throws IOException
    {
        this.checkChunkLength(13);
        this.readChunk(this.buffer, 0, 13);
        this.width = this.readInt(this.buffer, 0);
        this.height = this.readInt(this.buffer, 4);
        this.bitdepth = this.buffer[8] & 255;
        this.colorType = this.buffer[9] & 255;
        label0:

        switch (this.colorType)
        {
            case 0:
            case 3:
                switch (this.bitdepth)
                {
                    case 1:
                    case 2:
                    case 4:
                    case 8:
                        this.bytesPerPixel = 1;
                        break label0;

                    case 3:
                    case 5:
                    case 6:
                    case 7:
                    default:
                        throw new IOException("Unsupported bit depth: " + this.bitdepth);
                }

            case 1:
            case 5:
            default:
                throw new IOException("unsupported color format: " + this.colorType);

            case 2:
                if (this.bitdepth != 8)
                {
                    throw new IOException("Unsupported bit depth: " + this.bitdepth);
                }

                this.bytesPerPixel = 3;
                break;

            case 4:
                if (this.bitdepth != 8)
                {
                    throw new IOException("Unsupported bit depth: " + this.bitdepth);
                }

                this.bytesPerPixel = 2;
                break;

            case 6:
                if (this.bitdepth != 8)
                {
                    throw new IOException("Unsupported bit depth: " + this.bitdepth);
                }

                this.bytesPerPixel = 4;
        }

        if (this.buffer[10] != 0)
        {
            throw new IOException("unsupported compression method");
        }
        else if (this.buffer[11] != 0)
        {
            throw new IOException("unsupported filtering method");
        }
        else if (this.buffer[12] != 0)
        {
            throw new IOException("unsupported interlace method");
        }
    }

    private void readPLTE() throws IOException
    {
        int i = this.chunkLength / 3;

        if (i >= 1 && i <= 256 && this.chunkLength % 3 == 0)
        {
            this.palette = new byte[i * 3];
            this.readChunk(this.palette, 0, this.palette.length);
        }
        else
        {
            throw new IOException("PLTE chunk has wrong length");
        }
    }

    private void readtRNS() throws IOException
    {
        switch (this.colorType)
        {
            case 0:
                this.checkChunkLength(2);
                this.transPixel = new byte[2];
                this.readChunk(this.transPixel, 0, 2);

            case 1:
            default:
                break;

            case 2:
                this.checkChunkLength(6);
                this.transPixel = new byte[6];
                this.readChunk(this.transPixel, 0, 6);
                break;

            case 3:
                if (this.palette == null)
                {
                    throw new IOException("tRNS chunk without PLTE chunk");
                }

                this.paletteA = new byte[this.palette.length / 3];
                Arrays.fill(this.paletteA, (byte) - 1);
                this.readChunk(this.paletteA, 0, this.paletteA.length);
        }
    }

    private void readacTL() throws IOException
    {
        this.readChunk(this.buffer, 0, 8);
        this.numFrames = this.readInt(this.buffer, 0);
        this.loopCount = this.readInt(this.buffer, 4);
        this.animated = true;
    }

    private void readfcTL() throws IOException
    {
        this.readChunk(this.buffer, 0, 26);
        this.checkSeqNum(this.readInt(this.buffer, 0));
        this.fc = new PngDecoder.Frame();
        this.fc.width = this.readInt(this.buffer, 4);
        this.fc.height = this.readInt(this.buffer, 8);
        this.fc.xOffset = this.readInt(this.buffer, 12);
        this.fc.yOffset = this.readInt(this.buffer, 16);
        this.fc.delayNum = this.readShort(this.buffer, 20);
        this.fc.delayDen = this.readShort(this.buffer, 22);
        this.fc.disposeOp = this.buffer[24];
        this.fc.blendOp = this.buffer[25];
    }

    private void checkSeqNum(int num) throws IOException
    {
        if (num != this.seqNum + 1)
        {
            throw new IOException("Invalid animation sequence");
        }
        else
        {
            this.seqNum = num;
        }
    }

    private void closeChunk() throws IOException
    {
        if (this.chunkRemaining > 0)
        {
            this.skip((long)(this.chunkRemaining + 4));
        }
        else
        {
            this.readFully(this.buffer, 0, 4);
            int i = this.readInt(this.buffer, 0);
            int j = (int)this.crc.getValue();

            if (j != i)
            {
                throw new IOException("Invalid CRC");
            }
        }

        this.chunkRemaining = 0;
        this.chunkLength = 0;
        this.chunkType = 0;
    }

    private void openChunk() throws IOException
    {
        this.readFully(this.buffer, 0, 8);
        this.chunkLength = this.readInt(this.buffer, 0);
        this.chunkType = this.readInt(this.buffer, 4);
        this.chunkRemaining = this.chunkLength;
        this.crc.reset();
        this.crc.update(this.buffer, 4, 4);
    }

    private void openChunk(int expected) throws IOException
    {
        this.openChunk();

        if (this.chunkType != expected)
        {
            throw new IOException("Expected chunk: " + Integer.toHexString(expected));
        }
    }

    private void checkChunkLength(int expected) throws IOException
    {
        if (this.chunkLength != expected)
        {
            throw new IOException("Chunk has wrong size");
        }
    }

    private int readChunk(byte[] buffer, int offset, int length) throws IOException
    {
        if (length > this.chunkRemaining)
        {
            length = this.chunkRemaining;
        }

        this.readFully(buffer, offset, length);
        this.crc.update(buffer, offset, length);
        this.chunkRemaining -= length;
        return length;
    }

    private void refillInflater(Inflater inflater, int chunkType) throws IOException
    {
        while (this.chunkRemaining == 0)
        {
            this.closeChunk();
            this.openChunk(chunkType);

            if (chunkType == 1717846356)
            {
                this.readChunk(this.buffer, 0, 4);
                this.checkSeqNum(this.readInt(this.buffer, 0));
            }
        }

        int i = this.readChunk(this.buffer, 0, this.buffer.length);
        inflater.setInput(this.buffer, 0, i);
    }

    private void readChunkUnzip(Inflater inflater, byte[] buffer, int offset, int length, int chunkType) throws IOException
    {
        try
        {
            while (true)
            {
                int i = inflater.inflate(buffer, offset, length);

                if (i <= 0)
                {
                    if (inflater.finished())
                    {
                        throw new EOFException();
                    }

                    if (!inflater.needsInput())
                    {
                        throw new IOException("Can\'t inflate " + length + " bytes");
                    }

                    this.refillInflater(inflater, chunkType);
                }
                else
                {
                    offset += i;
                    length -= i;
                }

                if (length <= 0)
                {
                    break;
                }
            }
        }
        catch (DataFormatException dataformatexception)
        {
            throw new IOException("inflate error", dataformatexception);
        }
    }

    private void readFully(byte[] buffer, int offset, int length) throws IOException
    {
        while (true)
        {
            int i = this.input.read(buffer, offset, length);

            if (i < 0)
            {
                throw new EOFException();
            }

            offset += i;
            length -= i;

            if (length <= 0)
            {
                break;
            }
        }
    }

    private int readInt(byte[] buffer, int offset)
    {
        return buffer[offset] << 24 | (buffer[offset + 1] & 255) << 16 | (buffer[offset + 2] & 255) << 8 | buffer[offset + 3] & 255;
    }

    private int readShort(byte[] buffer, int offset)
    {
        return (buffer[offset] & 255) << 8 | buffer[offset + 1] & 255;
    }

    private void skip(long amount) throws IOException
    {
        while (amount > 0L)
        {
            amount -= this.input.skip(amount);
        }
    }

    private static boolean checkSignature(byte[] buffer)
    {
        for (int i = 0; i < SIGNATURE.length; ++i)
        {
            if (buffer[i] != SIGNATURE[i])
            {
                return false;
            }
        }

        return true;
    }

    public static class Format
    {
        final int numComponents;
        final boolean hasAlpha;

        private Format(int numComponents, boolean hasAlpha)
        {
            this.numComponents = numComponents;
            this.hasAlpha = hasAlpha;
        }

        public int getNumComponents()
        {
            return this.numComponents;
        }

        public boolean isHasAlpha()
        {
            return this.hasAlpha;
        }
    }

    public static class Frame
    {
        public ByteBuffer image;
        int width;
        int height;
        int xOffset;
        int yOffset;
        int delayNum;
        int delayDen;
        byte disposeOp;
        byte blendOp;

        public int delayMillis()
        {
            if (this.delayDen == 0)
            {
                this.delayDen = 100;
            }

            float f = (float)this.delayNum / (float)this.delayDen;
            return (int)(1000.0F * f);
        }

        public void extractARGB(int[] argb)
        {
            this.image.asIntBuffer().get(argb);
        }
    }
}
