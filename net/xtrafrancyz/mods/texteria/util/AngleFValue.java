package net.xtrafrancyz.mods.texteria.util;

import net.xtrafrancyz.util.Easing;

public class AngleFValue extends FValue
{
    public AngleFValue(float val)
    {
        super(val);
    }

    public void startAnimation(float newValue, int duration, Easing.Function easing, boolean smart, long time)
    {
        if (smart)
        {
            float f = makePositiveRotation(newValue);
            float f1 = makePositiveRotation(this.orig);
            float f2 = f - f1;

            if (Math.abs(f - f1) > 180.0F)
            {
                if (f > f1)
                {
                    f2 -= 360.0F;
                }
                else
                {
                    f2 += 360.0F;
                }
            }

            newValue = this.orig + f2;
        }

        super.startAnimation(newValue, duration, easing, smart, time);
    }

    private static float makePositiveRotation(float rotation)
    {
        rotation = rotation % 360.0F;
        return rotation < 0.0F ? rotation + 360.0F : rotation;
    }
}
