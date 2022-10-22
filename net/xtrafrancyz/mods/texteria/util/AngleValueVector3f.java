package net.xtrafrancyz.mods.texteria.util;

import net.xtrafrancyz.util.ByteMap;

public class AngleValueVector3f
{
    public AngleFValue x;
    public AngleFValue y;
    public AngleFValue z;

    public AngleValueVector3f(String prefix, ByteMap params)
    {
        this(prefix, params, 0.0F);
    }

    public AngleValueVector3f(String prefix, ByteMap params, float def)
    {
        if (params.containsKey(prefix))
        {
            this.x = new AngleFValue(params.getFloat(prefix));
            this.y = new AngleFValue(this.x.orig);
            this.z = new AngleFValue(this.x.orig);
        }
        else
        {
            this.x = new AngleFValue(params.getFloat(prefix + ".x", def));
            this.y = new AngleFValue(params.getFloat(prefix + ".y", def));
            this.z = new AngleFValue(params.getFloat(prefix + ".z", def));
        }
    }

    public boolean isAnimationActive()
    {
        return this.x.animStartTime + this.y.animStartTime + this.z.animStartTime != 0L;
    }
}
