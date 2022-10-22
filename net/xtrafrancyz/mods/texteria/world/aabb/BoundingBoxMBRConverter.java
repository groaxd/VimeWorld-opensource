package net.xtrafrancyz.mods.texteria.world.aabb;

import org.khelekore.prtree.MBRConverter;

public class BoundingBoxMBRConverter implements MBRConverter<BoundingBox>
{
    public int getDimensions()
    {
        return 3;
    }

    public double getMin(int axis, BoundingBox box)
    {
        switch (axis)
        {
            case 0:
                return box.bb.minX;

            case 1:
                return box.bb.minY;

            case 2:
                return box.bb.minZ;

            default:
                return 0.0D;
        }
    }

    public double getMax(int axis, BoundingBox box)
    {
        switch (axis)
        {
            case 0:
                return box.bb.maxX;

            case 1:
                return box.bb.maxY;

            case 2:
                return box.bb.maxZ;

            default:
                return 0.0D;
        }
    }
}
