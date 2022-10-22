package net.xtrafrancyz.mods.texteria.util;

import net.xtrafrancyz.mods.texteria.Texteria;
import net.xtrafrancyz.util.Easing;

public class FValue
{
    private int animDuration;
    private Easing.Function easing;
    public long animStartTime;
    public float valueDiff;
    public float orig;
    public float render;

    public FValue(float val)
    {
        this.orig = this.render = val;
    }

    public boolean isActiveTick(long time)
    {
        boolean flag = this.animStartTime != 0L;
        this.renderValue(time);
        return flag;
    }

    public float renderValue(long time)
    {
        if (this.animStartTime != 0L)
        {
            int i = (int)(time - this.animStartTime);

            if (i < this.animDuration)
            {
                this.render = animate(this.easing.ease((float)i / (float)this.animDuration), this.orig, this.valueDiff);
            }
            else
            {
                this.animStartTime = 0L;
                this.render = this.orig;
            }
        }

        return this.render;
    }

    public void set(float val)
    {
        this.animStartTime = 0L;
        this.valueDiff = 0.0F;
        this.orig = this.render = val;
    }

    public void startAnimation(float newValue, int duration, Easing.Function easing, boolean smart)
    {
        this.startAnimation(newValue, duration, easing, smart, Texteria.time);
    }

    public void startAnimation(float newValue, int duration, Easing.Function easing, boolean smart, long time)
    {
        this.renderValue(time);
        this.animDuration = duration;
        this.easing = easing;
        this.orig = newValue;
        this.valueDiff = this.render - this.orig;
        this.animStartTime = time;
    }

    private static float animate(float progress, float finish, float diff)
    {
        return finish + diff * (1.0F - progress);
    }
}
