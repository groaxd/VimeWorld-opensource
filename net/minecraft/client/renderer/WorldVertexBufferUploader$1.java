package net.minecraft.client.renderer;

import net.minecraft.client.renderer.vertex.VertexFormatElement;

class WorldVertexBufferUploader$1
{
    static
    {
        try
        {
            field_178958_a[VertexFormatElement.EnumUsage.POSITION.ordinal()] = 1;
        }
        catch (NoSuchFieldError var4)
        {
            ;
        }

        try
        {
            field_178958_a[VertexFormatElement.EnumUsage.UV.ordinal()] = 2;
        }
        catch (NoSuchFieldError var3)
        {
            ;
        }

        try
        {
            field_178958_a[VertexFormatElement.EnumUsage.COLOR.ordinal()] = 3;
        }
        catch (NoSuchFieldError var2)
        {
            ;
        }

        try
        {
            field_178958_a[VertexFormatElement.EnumUsage.NORMAL.ordinal()] = 4;
        }
        catch (NoSuchFieldError var1)
        {
            ;
        }
    }
}
