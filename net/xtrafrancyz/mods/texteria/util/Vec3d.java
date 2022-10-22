package net.xtrafrancyz.mods.texteria.util;

import java.util.function.ToDoubleFunction;
import net.minecraft.util.Vec3;

public class Vec3d
{
    public static final ToDoubleFunction<Vec3d> GET_X = (v) ->
    {
        return v.x;
    };
    public static final ToDoubleFunction<Vec3d> GET_Y = (v) ->
    {
        return v.y;
    };
    public static final ToDoubleFunction<Vec3d> GET_Z = (v) ->
    {
        return v.z;
    };
    public final double x;
    public final double y;
    public final double z;

    public Vec3d()
    {
        this(0.0D, 0.0D, 0.0D);
    }

    public Vec3d(Vec3 mcVec)
    {
        this(mcVec.xCoord, mcVec.yCoord, mcVec.zCoord);
    }

    public Vec3d(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vec3d setX(double x)
    {
        return new Vec3d(x, this.y, this.z);
    }

    public Vec3d setY(double y)
    {
        return new Vec3d(this.x, y, this.z);
    }

    public Vec3d setZ(double z)
    {
        return new Vec3d(this.x, this.y, z);
    }

    public Vec3d add(double val)
    {
        return new Vec3d(this.x + val, this.y + val, this.z + val);
    }

    public Vec3d add(Vec3d vec)
    {
        return new Vec3d(this.x + vec.x, this.y + vec.y, this.z + vec.z);
    }

    public Vec3d add(double x, double y, double z)
    {
        return new Vec3d(this.x + x, this.y + y, this.z + z);
    }

    public Vec3d sub(double val)
    {
        return new Vec3d(this.x - val, this.y - val, this.z - val);
    }

    public Vec3d sub(Vec3d vec)
    {
        return new Vec3d(this.x - vec.x, this.y - vec.y, this.z - vec.z);
    }

    public Vec3d sub(double x, double y, double z)
    {
        return new Vec3d(this.x - x, this.y - y, this.z - z);
    }

    public Vec3d multiply(double val)
    {
        return new Vec3d(this.x * val, this.y * val, this.z * val);
    }

    public Vec3d multiply(Vec3d vec)
    {
        return new Vec3d(this.x * vec.x, this.y * vec.y, this.z * vec.z);
    }

    public Vec3d multiply(double x, double y, double z)
    {
        return new Vec3d(this.x * x, this.y * y, this.z * z);
    }

    public Vec3d divide(double val)
    {
        return new Vec3d(this.x / val, this.y / val, this.z / val);
    }

    public Vec3d divide(Vec3d vec)
    {
        return new Vec3d(this.x / vec.x, this.y / vec.y, this.z / vec.z);
    }

    public Vec3d divide(double x, double y, double z)
    {
        return new Vec3d(this.x / x, this.y / y, this.z / z);
    }

    public Vec3d cross(Vec3d other)
    {
        return new Vec3d(this.y * other.z - this.z * other.y, this.z * other.x - this.x * other.z, this.x * other.y - this.y * other.x);
    }

    public Vec3d invert()
    {
        return new Vec3d(-this.x, -this.y, -this.z);
    }

    public Vec3d normalize()
    {
        return this.divide(this.length());
    }

    public Vec3d abs()
    {
        return new Vec3d(Math.abs(this.x), Math.abs(this.y), Math.abs(this.z));
    }

    public Vec3d clone()
    {
        return new Vec3d(this.x, this.y, this.z);
    }

    public double dot(Vec3d other)
    {
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }

    public double length()
    {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    public double lengthSq()
    {
        return this.x * this.x + this.y * this.y + this.z * this.z;
    }

    public String toString()
    {
        return "Vec3d[" + this.x + "," + this.y + "," + this.z + "]";
    }

    public int hashCode()
    {
        long j = Double.doubleToLongBits(this.x);
        int i = (int)(j ^ j >>> 32);
        j = Double.doubleToLongBits(this.y);
        i = 31 * i + (int)(j ^ j >>> 32);
        j = Double.doubleToLongBits(this.z);
        i = 31 * i + (int)(j ^ j >>> 32);
        return i;
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof Vec3d))
        {
            return false;
        }
        else
        {
            Vec3d vec3d = (Vec3d)obj;
            return vec3d.x == this.x && vec3d.y == this.y && vec3d.z == this.z;
        }
    }
}
