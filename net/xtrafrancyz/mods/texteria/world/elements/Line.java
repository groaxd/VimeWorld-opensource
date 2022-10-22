package net.xtrafrancyz.mods.texteria.world.elements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.Map.Entry;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.AxisAlignedBB;
import net.xtrafrancyz.mods.texteria.Texteria;
import net.xtrafrancyz.mods.texteria.util.ColorValue;
import net.xtrafrancyz.mods.texteria.util.FValue;
import net.xtrafrancyz.mods.texteria.util.ValueVector3f;
import net.xtrafrancyz.util.ByteMap;
import net.xtrafrancyz.util.Easing;
import org.lwjgl.opengl.GL11;

public class Line extends Element3D
{
    public Easing.Function editEasing;
    public int editDuration;
    public List<ValueVector3f> points;
    public TreeMap<Integer, ColorValue> colors = new TreeMap();
    public FValue width = new FValue(0.0F);
    public Line.DrawMode drawMode;
    private boolean lastFrameAnimation = false;

    public Line(ByteMap params)
    {
        super(params);
        this.editDuration = params.getInt("editD", 255);
        this.editEasing = Easing.getOrDefault(params, "editE", Easing.EASE_IN_SINE);
        int[] aint = params.getIntArray("p");
        this.points = new ArrayList(aint.length / 3);

        for (int i = 0; i < aint.length; i += 3)
        {
            this.points.add(new ValueVector3f(Float.intBitsToFloat(aint[i]), Float.intBitsToFloat(aint[i + 1]), Float.intBitsToFloat(aint[i + 2])));
        }

        if (params.containsKey("cs"))
        {
            int[] aint1 = params.getIntArray("cs");

            for (int j = 0; j < aint1.length; j += 2)
            {
                this.colors.put(Integer.valueOf(aint1[j]), new ColorValue(aint1[j + 1], this.editEasing, this.editDuration));
            }
        }
        else
        {
            this.colors.put(Integer.valueOf(0), new ColorValue(-1, Easing.EASE_IN_SINE, 255));
        }

        this.width.set(params.getFloat("width", 1.0F));
        this.drawMode = (Line.DrawMode)params.getStringEnum("dm", Line.DrawMode.LINE_STRIP);
        this.recalculateBoundingBox();
    }

    private void recalculateBoundingBox()
    {
        float f = Float.MAX_VALUE;
        float f1 = -3.4028235E38F;
        float f2 = Float.MAX_VALUE;
        float f3 = -3.4028235E38F;
        float f4 = Float.MAX_VALUE;
        float f5 = -3.4028235E38F;
        long i = Texteria.time;

        for (ValueVector3f valuevector3f : this.points)
        {
            valuevector3f.renderValue(i);

            if (valuevector3f.x.render < f)
            {
                f = valuevector3f.x.render;
            }

            if (valuevector3f.x.render > f1)
            {
                f1 = valuevector3f.x.render;
            }

            if (valuevector3f.y.render < f2)
            {
                f2 = valuevector3f.y.render;
            }

            if (valuevector3f.y.render > f3)
            {
                f3 = valuevector3f.y.render;
            }

            if (valuevector3f.z.render < f4)
            {
                f4 = valuevector3f.z.render;
            }

            if (valuevector3f.z.render > f5)
            {
                f5 = valuevector3f.z.render;
            }
        }

        this.boundingBox = new AxisAlignedBB((double)f, (double)f2, (double)f4, (double)f1, (double)f3, (double)f5);
    }

    public void revalidateBB(long time)
    {
        boolean flag = false;

        for (ValueVector3f valuevector3f : this.points)
        {
            if (valuevector3f.isAnimationActive())
            {
                flag = true;
                break;
            }
        }

        if (flag || this.lastFrameAnimation)
        {
            this.lastFrameAnimation = flag;
            this.recalculateBoundingBox();
        }
    }

    public void edit(ByteMap data)
    {
        if (data.containsKey("aed"))
        {
            this.editDuration = data.getInt("aed");
        }

        if (data.containsKey("aee"))
        {
            this.editEasing = Easing.getOrDefault(data, "aee", Easing.EASE_IN_SINE);
        }

        this.editFindReflectionFields(data, this.editDuration, this.editEasing);
        ByteMap[] abytemap = data.getMapArray("actions");

        if (abytemap != null)
        {
            for (ByteMap bytemap : abytemap)
            {
                String s = bytemap.getString("%", "none");
                byte b0 = -1;

                switch (s.hashCode())
                {
                    case 3177:
                        if (s.equals("cl"))
                        {
                            b0 = 3;
                        }

                        break;

                    case 3643:
                        if (s.equals("rm"))
                        {
                            b0 = 2;
                        }

                        break;

                    case 96417:
                        if (s.equals("add"))
                        {
                            b0 = 0;
                        }

                        break;

                    case 113762:
                        if (s.equals("set"))
                        {
                            b0 = 1;
                        }
                }

                switch (b0)
                {
                    case 0:
                        ValueVector3f valuevector3f = new ValueVector3f(bytemap.getFloat("x"), bytemap.getFloat("y"), bytemap.getFloat("z"));
                        int j1 = bytemap.getInt("i");

                        if (j1 == -1)
                        {
                            this.points.add(valuevector3f);
                        }
                        else if (j1 >= 0 && j1 < this.points.size())
                        {
                            this.points.add(j1, valuevector3f);
                        }

                        break;

                    case 1:
                        int i1 = bytemap.getInt("i");

                        if (i1 >= 0 && i1 < this.points.size())
                        {
                            ValueVector3f valuevector3f1 = (ValueVector3f)this.points.get(i1);

                            if (bytemap.getBoolean("a", false))
                            {
                                valuevector3f1.x.startAnimation(bytemap.getFloat("x"), this.editDuration, this.editEasing, false);
                                valuevector3f1.y.startAnimation(bytemap.getFloat("y"), this.editDuration, this.editEasing, false);
                                valuevector3f1.z.startAnimation(bytemap.getFloat("z"), this.editDuration, this.editEasing, false);
                            }
                            else
                            {
                                valuevector3f1.x.set(bytemap.getFloat("x"));
                                valuevector3f1.y.set(bytemap.getFloat("y"));
                                valuevector3f1.z.set(bytemap.getFloat("z"));
                            }
                        }

                        break;

                    case 2:
                        int l = bytemap.getInt("i");

                        if (l >= 0 && l < this.points.size())
                        {
                            this.points.remove(l);
                        }

                        break;

                    case 3:
                        int i = bytemap.getInt("i");
                        int j = bytemap.getInt("c");
                        ColorValue colorvalue = (ColorValue)this.colors.get(Integer.valueOf(i));

                        if (colorvalue == null)
                        {
                            Entry<Integer, ColorValue> entry = this.colors.ceilingEntry(Integer.valueOf(i));
                            Entry<Integer, ColorValue> entry1 = this.colors.floorEntry(Integer.valueOf(i));
                            int k;

                            if (entry == null)
                            {
                                k = ((ColorValue)entry1.getValue()).renderValue(Texteria.time);
                            }
                            else if (entry1 == null)
                            {
                                k = ((ColorValue)entry.getValue()).renderValue(Texteria.time);
                            }
                            else
                            {
                                float f = (float)(i - ((Integer)entry1.getKey()).intValue()) / (float)(((Integer)entry.getKey()).intValue() - ((Integer)entry1.getKey()).intValue());
                                k = ColorValue.lerp(f, ((ColorValue)entry.getValue()).render, ((ColorValue)entry1.getValue()).render);
                            }

                            colorvalue = new ColorValue(k, this.editEasing, this.editDuration);
                        }

                        if (bytemap.getBoolean("a", false))
                        {
                            colorvalue.startAnimation(j, this.editDuration, this.editEasing);
                        }
                        else
                        {
                            colorvalue.set(j);
                        }

                        this.colors.put(Integer.valueOf(i), colorvalue);
                }
            }
        }

        this.recalculateBoundingBox();
    }

    public void render(long time)
    {
        int i = (int)(this.finishTime - time);
        int j = (int)(time - this.startTime);

        if (j >= 0)
        {
            float f = 1.0F;

            if (j < this.startFade)
            {
                f = (float)j / (float)this.startFade;
            }

            if (i < this.finishFade)
            {
                f = (float)i / (float)this.finishFade;
            }

            GlStateManager.disableTexture2D();
            this.width.renderValue(time);
            GL11.glLineWidth(this.width.render);
            Tessellator tessellator = Tessellator.getInstance();
            WorldRenderer worldrenderer = tessellator.getWorldRenderer();

            if (this.colors.size() == 1)
            {
                int k = ((ColorValue)this.colors.firstEntry().getValue()).renderValue(time);

                if (f != 1.0F)
                {
                    k = this.setAlpha(k, (int)((float)this.getAlpha(k) * f));
                }

                this.setColor(k);
                worldrenderer.begin(this.drawMode.glDrawMode, DefaultVertexFormats.POSITION);

                for (ValueVector3f valuevector3f : this.points)
                {
                    worldrenderer.pos((double)valuevector3f.x.renderValue(time) - TileEntityRendererDispatcher.staticPlayerX, (double)valuevector3f.y.renderValue(time) - TileEntityRendererDispatcher.staticPlayerY, (double)valuevector3f.z.renderValue(time) - TileEntityRendererDispatcher.staticPlayerZ).endVertex();
                }
            }
            else
            {
                worldrenderer.begin(this.drawMode.glDrawMode, DefaultVertexFormats.POSITION_COLOR);
                Iterator<Entry<Integer, ColorValue>> iterator = this.colors.entrySet().iterator();
                Entry<Integer, ColorValue> entry = (Entry)iterator.next();
                Entry<Integer, ColorValue> entry1 = entry;
                ((ColorValue)entry.getValue()).renderValue(time);
                int l = 0;

                for (ValueVector3f valuevector3f1 : this.points)
                {
                    if (((Integer)entry1.getKey()).intValue() < l)
                    {
                        entry = entry1;

                        if (iterator.hasNext())
                        {
                            entry1 = (Entry)iterator.next();
                            ((ColorValue)entry1.getValue()).renderValue(time);
                        }
                    }

                    int i1;

                    if (l <= ((Integer)entry.getKey()).intValue())
                    {
                        i1 = ((ColorValue)entry.getValue()).render;
                    }
                    else if (l < ((Integer)entry1.getKey()).intValue())
                    {
                        float f1 = (float)(l - ((Integer)entry.getKey()).intValue()) / (float)(((Integer)entry1.getKey()).intValue() - ((Integer)entry.getKey()).intValue());
                        i1 = ColorValue.lerp(f1, ((ColorValue)entry1.getValue()).render, ((ColorValue)entry.getValue()).render);
                    }
                    else
                    {
                        i1 = ((ColorValue)entry1.getValue()).render;
                    }

                    if (f != 1.0F)
                    {
                        i1 = this.setAlpha(i1, (int)((float)this.getAlpha(i1) * f));
                    }

                    worldrenderer.pos((double)valuevector3f1.x.renderValue(time) - TileEntityRendererDispatcher.staticPlayerX, (double)valuevector3f1.y.renderValue(time) - TileEntityRendererDispatcher.staticPlayerY, (double)valuevector3f1.z.renderValue(time) - TileEntityRendererDispatcher.staticPlayerZ).color(i1 >> 16 & 255, i1 >> 8 & 255, i1 & 255, i1 >> 24 & 255).endVertex();
                    ++l;
                }
            }

            tessellator.draw();
            GL11.glLineWidth(1.0F);
            GlStateManager.enableTexture2D();
            this.revalidateBB(time);
        }
    }

    private static enum DrawMode
    {
        LINE_STRIP(3),
        LINE_LOOP(2),
        LINES(1);

        final int glDrawMode;

        private DrawMode(int glDrawMode)
        {
            this.glDrawMode = glDrawMode;
        }
    }
}
