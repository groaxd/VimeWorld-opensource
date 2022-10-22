package net.minecraft.client.renderer;

import java.nio.ByteBuffer;
import java.util.List;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.renderer.vertex.VertexFormatElement;
import optifine.Config;
import org.lwjgl.opengl.GL11;
import shadersmod.client.SVertexBuilder;

public class WorldVertexBufferUploader
{
    private static final String __OBFID = "CL_00002567";

    public void func_181679_a(WorldRenderer p_181679_1_)
    {
        if (p_181679_1_.getVertexCount() > 0)
        {
            VertexFormat vertexformat = p_181679_1_.getVertexFormat();
            int i = vertexformat.getNextOffset();
            ByteBuffer bytebuffer = p_181679_1_.getByteBuffer();
            List list = vertexformat.getElements();

            for (int j = 0; j < list.size(); ++j)
            {
                VertexFormatElement vertexformatelement = (VertexFormatElement)list.get(j);
                VertexFormatElement.EnumUsage vertexformatelement$enumusage = vertexformatelement.getUsage();
                int k = vertexformatelement.getType().getGlConstant();
                int l = vertexformatelement.getIndex();
                bytebuffer.position(vertexformat.func_181720_d(j));

                switch (WorldVertexBufferUploader.WorldVertexBufferUploader$WorldVertexBufferUploader$1.field_178958_a[vertexformatelement$enumusage.ordinal()])
                {
                    case 1:
                        GL11.glVertexPointer(vertexformatelement.getElementCount(), k, i, bytebuffer);
                        GL11.glEnableClientState(GL11.GL_VERTEX_ARRAY);
                        break;

                    case 2:
                        OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit + l);
                        GL11.glTexCoordPointer(vertexformatelement.getElementCount(), k, i, bytebuffer);
                        GL11.glEnableClientState(GL11.GL_TEXTURE_COORD_ARRAY);
                        OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
                        break;

                    case 3:
                        GL11.glColorPointer(vertexformatelement.getElementCount(), k, i, bytebuffer);
                        GL11.glEnableClientState(GL11.GL_COLOR_ARRAY);
                        break;

                    case 4:
                        GL11.glNormalPointer(k, i, bytebuffer);
                        GL11.glEnableClientState(GL11.GL_NORMAL_ARRAY);
                }
            }

            if (p_181679_1_.isMultiTexture())
            {
                p_181679_1_.drawMultiTexture();
            }
            else if (Config.isShaders())
            {
                SVertexBuilder.drawArrays(p_181679_1_.getDrawMode(), 0, p_181679_1_.getVertexCount(), p_181679_1_);
            }
            else
            {
                GL11.glDrawArrays(p_181679_1_.getDrawMode(), 0, p_181679_1_.getVertexCount());
            }

            int i1 = 0;

            for (int j1 = list.size(); i1 < j1; ++i1)
            {
                VertexFormatElement vertexformatelement1 = (VertexFormatElement)list.get(i1);
                VertexFormatElement.EnumUsage vertexformatelement$enumusage1 = vertexformatelement1.getUsage();
                int k1 = vertexformatelement1.getIndex();

                switch (WorldVertexBufferUploader.WorldVertexBufferUploader$WorldVertexBufferUploader$1.field_178958_a[vertexformatelement$enumusage1.ordinal()])
                {
                    case 1:
                        GL11.glDisableClientState(GL11.GL_VERTEX_ARRAY);
                        break;

                    case 2:
                        OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit + k1);
                        GL11.glDisableClientState(GL11.GL_TEXTURE_COORD_ARRAY);
                        OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
                        break;

                    case 3:
                        GL11.glDisableClientState(GL11.GL_COLOR_ARRAY);
                        GlStateManager.resetColor();
                        break;

                    case 4:
                        GL11.glDisableClientState(GL11.GL_NORMAL_ARRAY);
                }
            }
        }

        p_181679_1_.reset();
    }

    static final class WorldVertexBufferUploader$WorldVertexBufferUploader$1
    {
        static final int[] field_178958_a = new int[VertexFormatElement.EnumUsage.values().length];
        private static final String __OBFID = "CL_00002566";

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
}
