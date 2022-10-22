package net.xtrafrancyz.mods.texteria.util;

import net.xtrafrancyz.mods.texteria.Texteria;
import net.xtrafrancyz.util.Easing;

public class ColorValue
{
    public int animDuration;
    public Easing.Function easing;
    public long animStartTime;
    public int prev;
    public int orig;
    public int render;

    public ColorValue(int val, Animation2D anim)
    {
        this(val, anim.editEasing, anim.editDuration);
    }

    public ColorValue(int val, Easing.Function easing, int animDuration)
    {
        this.orig = this.render = val;
        this.animDuration = animDuration;
        this.easing = easing;
    }

    public int renderValue(long time)
    {
        if (this.animStartTime != 0L)
        {
            int i = (int)(time - this.animStartTime);

            if (i < this.animDuration)
            {
                this.render = lerp(this.easing.ease((float)i / (float)this.animDuration), this.orig, this.prev);
            }
            else
            {
                this.animStartTime = 0L;
                this.render = this.orig;
            }
        }

        return this.render;
    }

    public void set(int val)
    {
        this.animStartTime = 0L;
        this.prev = this.orig = this.render = val;
    }

    public void startAnimation(int newValue, int duration, Easing.Function easing)
    {
        this.startAnimation(newValue, duration, easing, Texteria.time);
    }

    public void startAnimation(int newValue, int duration, Easing.Function easing, long time)
    {
        this.animDuration = duration;
        this.easing = easing;
        this.orig = newValue;
        this.prev = this.render;
        this.animStartTime = time;
    }

    public static int lerp(float progress, int finish, int start)
    {
        int i = start >> 24 & 255;
        int j = start >> 16 & 255;
        int k = start >> 8 & 255;
        int l = start & 255;
        i = (int)((float)i + (float)((finish >> 24 & 255) - i) * progress);
        j = (int)((float)j + (float)((finish >> 16 & 255) - j) * progress);
        k = (int)((float)k + (float)((finish >> 8 & 255) - k) * progress);
        l = (int)((float)l + (float)((finish & 255) - l) * progress);

        if (i < 5)
        {
            i = 5;
        }

        return i << 24 | j << 16 | k << 8 | l;
    }
}
