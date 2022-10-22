package net.minecraft.client.renderer;

import net.minecraft.client.renderer.vertex.VertexFormatElement;

class RenderGlobal$2
{
    static
    {
        try
        {
            field_178037_a[VertexFormatElement.EnumUsage.POSITION.ordinal()] = 1;
        }
        catch (NoSuchFieldError var3)
        {
            ;
        }

        try
        {
            field_178037_a[VertexFormatElement.EnumUsage.UV.ordinal()] = 2;
        }
        catch (NoSuchFieldError var2)
        {
            ;
        }

        try
        {
            field_178037_a[VertexFormatElement.EnumUsage.COLOR.ordinal()] = 3;
        }
        catch (NoSuchFieldError var1)
        {
            ;
        }
    }
}
