package net.xtrafrancyz.mods.texteria.util;

import net.xtrafrancyz.util.ByteMap;

public class ValueVector3f
{
    public FValue x;
    public FValue y;
    public FValue z;

    public ValueVector3f(String prefix, ByteMap params)
    {
        this(prefix, params, 0.0F);
    }

    public ValueVector3f(String prefix, ByteMap params, float def)
    {
        if (params.containsKey(prefix))
        {
            this.x = new FValue(params.getFloat(prefix));
            this.y = new FValue(this.x.orig);
            this.z = new FValue(this.x.orig);
        }
        else
        {
            this.x = new FValue(params.getFloat(prefix + ".x", def));
            this.y = new FValue(params.getFloat(prefix + ".y", def));
            this.z = new FValue(params.getFloat(prefix + ".z", def));
        }
    }

    public ValueVector3f(float x, float y, float z)
    {
        this.x = new FValue(x);
        this.y = new FValue(y);
        this.z = new FValue(z);
    }

    public void renderValue(long time)
    {
        this.x.renderValue(time);
        this.y.renderValue(time);
        this.z.renderValue(time);
    }

    public boolean isAnimationActive()
    {
        return this.x.animStartTime + this.y.animStartTime + this.z.animStartTime != 0L;
    }
}
