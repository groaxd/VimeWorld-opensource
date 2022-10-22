package net.xtrafrancyz.mods.texteria.world.elements;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.renderer.vertex.VertexFormatElement;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.xtrafrancyz.util.ByteMap;

public class DirectDraw extends Element3D
{
    private static final BlockPos.MutableBlockPos BLOCK_POS = new BlockPos.MutableBlockPos();
    public int mode;
    public VertexFormat format;
    public DirectDraw.Component[] components;
    public ByteBuffer data;
    public int vertexSize;
    public int vertexes;
    public boolean culling;
    private boolean hasLight;
    private long lightCacheTick;
    private int[] lightCache;

    public DirectDraw(ByteMap params)
    {
        super(params);
        this.startFade = 0;
        this.finishFade = 0;
        this.hoverable = false;
        this.culling = params.getBoolean("culling", true);
        this.mode = params.getInt("mode");
        this.format = new VertexFormat();
        List<DirectDraw.Component> list = new ArrayList();

        for (int i : params.getByteArray("fmt"))
        {
            DirectDraw.Component directdraw$component = DirectDraw.Component.values()[i];
            this.format.func_181721_a(directdraw$component.element);
            list.add(directdraw$component);
            this.vertexSize += directdraw$component.inputSize;

            if (directdraw$component == DirectDraw.Component.LIGHT_DYNAMIC_BLOCKSKY)
            {
                this.hasLight = true;
            }
        }

        this.components = (DirectDraw.Component[])list.toArray(new DirectDraw.Component[0]);
        this.data = ByteBuffer.wrap(params.getByteArray("data"));
        this.vertexes = this.data.array().length / this.vertexSize;

        if (this.vertexes * this.vertexSize != this.data.array().length)
        {
            throw new IllegalArgumentException("Invalid data length");
        }
        else
        {
            this.recalculateBB();

            if (this.hasLight)
            {
                this.lightCache = new int[this.vertexes];
            }
        }
    }

    private void recalculateBB()
    {
        float f = Float.MAX_VALUE;
        float f1 = Float.MAX_VALUE;
        float f2 = Float.MAX_VALUE;
        float f3 = Float.MIN_VALUE;
        float f4 = Float.MIN_VALUE;
        float f5 = Float.MIN_VALUE;

        for (int i = 0; i < this.vertexes; ++i)
        {
            int j = 0;

            for (int k = 0; j < this.components.length; ++j)
            {
                if (this.components[j] == DirectDraw.Component.POSITION_3F)
                {
                    int l = i * this.vertexSize + k;
                    float f6 = this.data.getFloat(l);
                    float f7 = this.data.getFloat(l + 4);
                    float f8 = this.data.getFloat(l + 8);
                    f = Math.min(f6, f);
                    f1 = Math.min(f7, f1);
                    f2 = Math.min(f8, f2);
                    f3 = Math.max(f6, f3);
                    f4 = Math.max(f7, f4);
                    f5 = Math.max(f8, f5);
                    break;
                }

                k += this.components[j].inputSize;
            }
        }

        this.boundingBox = AxisAlignedBB.fromBounds((double)f, (double)f1, (double)f2, (double)f3, (double)f4, (double)f5);
    }

    public void edit(ByteMap data)
    {
    }

    public void render(long time)
    {
        Minecraft minecraft = Minecraft.getMinecraft();
        boolean flag = true;

        if (this.hasLight)
        {
            int i = minecraft.globalTickCounter.get();

            if ((long)i < this.lightCacheTick || (long)i - this.lightCacheTick > 5L)
            {
                this.lightCacheTick = (long)i;
                flag = false;
            }

            minecraft.entityRenderer.enableLightmap();
            RenderHelper.disableStandardItemLighting();
        }

        if (this.culling)
        {
            GlStateManager.enableCull();
        }
        else
        {
            GlStateManager.disableCull();
        }

        GlStateManager.disableTexture2D();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.depthMask(true);
        this.data.position(0);
        WorldRenderer worldrenderer = Tessellator.getInstance().getWorldRenderer();
        worldrenderer.begin(this.mode, this.format);
        float f = 0.0F;
        float f1 = 0.0F;
        float f2 = 0.0F;

        for (int j = 0; j < this.vertexes; ++j)
        {
            for (int k = 0; k < this.components.length; ++k)
            {
                switch (this.components[k])
                {
                    case POSITION_3F:
                        worldrenderer.pos((double)(f = this.data.getFloat()) - TileEntityRendererDispatcher.staticPlayerX, (double)(f1 = this.data.getFloat()) - TileEntityRendererDispatcher.staticPlayerY, (double)(f2 = this.data.getFloat()) - TileEntityRendererDispatcher.staticPlayerZ);
                        break;

                    case COLOR_4UB:
                        worldrenderer.color(this.data.get(), this.data.get(), this.data.get(), this.data.get());
                        break;

                    case NORMAL_3B:
                        int k1 = j * worldrenderer.getVertexFormat().getNextOffset() + worldrenderer.getVertexFormat().func_181720_d(k);
                        worldrenderer.getByteBuffer().put(k1, this.data.get()).put(k1 + 1, this.data.get()).put(k1 + 2, this.data.get());
                        break;

                    case LIGHT_DYNAMIC_BLOCKSKY:
                        int l;

                        if (flag)
                        {
                            l = this.lightCache[j];
                        }
                        else
                        {
                            l = minecraft.theWorld.getCombinedLight(BLOCK_POS.func_181079_c((int)f, (int)f1, (int)f2), 0);
                            this.lightCache[j] = l;
                        }

                        int i1 = l >> 16 & 65535;
                        int j1 = l & 65535;
                        worldrenderer.lightmap(i1, j1);
                }
            }

            worldrenderer.endVertex();
        }

        Tessellator.getInstance().draw();
        GlStateManager.enableTexture2D();

        if (this.hasLight)
        {
            minecraft.entityRenderer.disableLightmap();
        }
    }

    static enum Component
    {
        POSITION_3F(DefaultVertexFormats.POSITION_3F, 12),
        COLOR_4UB(DefaultVertexFormats.COLOR_4UB, 4),
        NORMAL_3B(DefaultVertexFormats.NORMAL_3B, 3),
        PADDING_1B(DefaultVertexFormats.PADDING_1B, 1),
        LIGHT_DYNAMIC_BLOCKSKY(DefaultVertexFormats.TEX_2S, 0);

        final VertexFormatElement element;
        final int inputSize;

        private Component(VertexFormatElement element, int inputSize)
        {
            this.element = element;
            this.inputSize = inputSize;
        }
    }
}
