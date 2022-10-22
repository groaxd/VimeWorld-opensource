package net.minecraft.client.renderer.block.model;

import net.minecraft.util.EnumFacing;

class FaceBakery$1
{
    static
    {
        try
        {
            field_178399_b[EnumFacing.Axis.X.ordinal()] = 1;
        }
        catch (NoSuchFieldError var9)
        {
            ;
        }

        try
        {
            field_178399_b[EnumFacing.Axis.Y.ordinal()] = 2;
        }
        catch (NoSuchFieldError var8)
        {
            ;
        }

        try
        {
            field_178399_b[EnumFacing.Axis.Z.ordinal()] = 3;
        }
        catch (NoSuchFieldError var7)
        {
            ;
        }

        field_178400_a = new int[EnumFacing.values().length];

        try
        {
            field_178400_a[EnumFacing.DOWN.ordinal()] = 1;
        }
        catch (NoSuchFieldError var6)
        {
            ;
        }

        try
        {
            field_178400_a[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError var5)
        {
            ;
        }

        try
        {
            field_178400_a[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError var4)
        {
            ;
        }

        try
        {
            field_178400_a[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError var3)
        {
            ;
        }

        try
        {
            field_178400_a[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError var2)
        {
            ;
        }

        try
        {
            field_178400_a[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError var1)
        {
            ;
        }
    }
}
