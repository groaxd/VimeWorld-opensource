package net.xtrafrancyz.mods.minidot.util;

public class Rainbow
{
    public static final int SIZE = 1536;
    public static final float[][] PALETTE = new float[1536][3];

    public static int getAlpha(int color)
    {
        return color >> 24 & 255;
    }

    public static int setAlpha(int color, int alpha)
    {
        return (color & 16777215) + (alpha << 24);
    }

    static
    {
        int i = 0;

        for (int j = 0; j < 256; ++j)
        {
            PALETTE[i][0] = 1.0F;
            PALETTE[i][1] = (float)j / 255.0F;
            PALETTE[i][2] = 0.0F;
            ++i;
        }

        i = 256;

        for (int k = 0; k < 256; ++k)
        {
            PALETTE[i][0] = 1.0F - (float)k / 255.0F;
            PALETTE[i][1] = 1.0F;
            PALETTE[i][2] = 0.0F;
            ++i;
        }

        i = 512;

        for (int l = 0; l < 256; ++l)
        {
            PALETTE[i][0] = 0.0F;
            PALETTE[i][1] = 1.0F;
            PALETTE[i][2] = (float)l / 255.0F;
            ++i;
        }

        i = 768;

        for (int i1 = 0; i1 < 256; ++i1)
        {
            PALETTE[i][0] = 0.0F;
            PALETTE[i][1] = 1.0F - (float)i1 / 255.0F;
            PALETTE[i][2] = 1.0F;
            ++i;
        }

        i = 1024;

        for (int j1 = 0; j1 < 256; ++j1)
        {
            PALETTE[i][0] = (float)j1 / 255.0F;
            PALETTE[i][1] = 0.0F;
            PALETTE[i][2] = 1.0F;
            ++i;
        }

        i = 1280;

        for (int k1 = 0; k1 < 256; ++k1)
        {
            PALETTE[i][0] = 1.0F;
            PALETTE[i][1] = 0.0F;
            PALETTE[i][2] = 1.0F - (float)k1 / 255.0F;
            ++i;
        }
    }
}
