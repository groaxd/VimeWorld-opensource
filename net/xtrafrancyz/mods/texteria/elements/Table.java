package net.xtrafrancyz.mods.texteria.elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.xtrafrancyz.util.ByteMap;
import org.lwjgl.opengl.GL11;

public class Table extends Element2D
{
    private final FontRenderer fontRenderer;
    private int width;
    private int height;
    private boolean cullingEnabled;
    public Table.Column[] columns;
    public List<String[]> rows;
    public String title;
    public int titleColor;
    public int headingColor;
    public boolean drawBack;
    public int hoverRow;
    public int startRow;
    public int origMaxRows;
    public int maxRows;
    public int scrollbarColor;
    public int rowHoverColor;

    public Table(ByteMap params)
    {
        super(params);
        this.fontRenderer = Minecraft.getMinecraft().fontRendererObj;
        this.hoverRow = -1;
        this.startRow = 0;
        this.origMaxRows = 0;
        this.title = params.getString("title", (String)null);
        this.titleColor = params.getInt("title.c", -769226);
        this.headingColor = params.getInt("heading.c", -5317);
        this.drawBack = params.getBoolean("drawBack", false);
        this.scrollbarColor = params.getInt("sb.c", -5317);
        this.rowHoverColor = params.getInt("rh.c", 1140946643);

        if (params.get("cols") instanceof ByteMap)
        {
            ByteMap bytemap = params.getMap("cols");
            int i = bytemap.getInt("size");
            this.columns = new Table.Column[i];

            for (int j = 0; j < i; ++j)
            {
                String s = bytemap.getString(j + ".n");
                this.columns[j] = new Table.Column(s, bytemap.getInt(j + ".w", -1));
                this.columns[j].center = bytemap.getBoolean(j + ".c", false);
                this.columns[j].color = bytemap.getInt(j + ".t", -1);
            }
        }
        else
        {
            ByteMap[] abytemap = params.getMapArray("cols");
            this.columns = new Table.Column[abytemap.length];

            for (int k = 0; k < abytemap.length; ++k)
            {
                this.columns[k] = new Table.Column(abytemap[k].getString("n"), abytemap[k].getInt("w", -1));
                this.columns[k].center = abytemap[k].getBoolean("c", false);
                this.columns[k].color = abytemap[k].getInt("t", -1);
            }
        }

        for (Table.Column table$column : this.columns)
        {
            if (table$column.width == -1)
            {
                table$column.width = this.fontRenderer.getStringWidth(table$column.name);
            }
        }

        if (params.get("rows") instanceof ByteMap)
        {
            ByteMap bytemap1 = params.getMap("rows");
            this.rows = new ArrayList(bytemap1.size());

            for (int l = 0; l < bytemap1.size(); ++l)
            {
                this.rows.add(bytemap1.getStringArray(Integer.toString(l)));
            }
        }
        else
        {
            this.rows = new ArrayList(Arrays.asList((String[][])((String[][])params.get("rows"))));
        }

        if (params.containsKey("maxRows"))
        {
            this.origMaxRows = params.getInt("maxRows");
        }

        this.updateBounds();
    }

    private void updateBounds()
    {
        if (this.origMaxRows == 0)
        {
            this.maxRows = this.rows.size();
        }
        else
        {
            this.maxRows = Math.min(this.origMaxRows, this.rows.size());
        }

        this.height = this.title != null ? 10 : 0;
        this.height += this.maxRows * 10 + 10;
        this.width = 0;

        for (Table.Column table$column : this.columns)
        {
            this.width += table$column.width + 1;
        }

        --this.width;

        if (this.hasScrollbar())
        {
            this.width += 3;
        }
    }

    public void edit(ByteMap data)
    {
        super.edit(data);
        ByteMap[] abytemap = data.getMapArray("actions");

        if (abytemap != null)
        {
            for (ByteMap bytemap : abytemap)
            {
                String s = bytemap.getString("%", "none");
                byte b0 = -1;

                switch (s.hashCode())
                {
                    case -1887985808:
                        if (s.equals("editRow"))
                        {
                            b0 = 2;
                        }

                        break;

                    case -1422526087:
                        if (s.equals("addRow"))
                        {
                            b0 = 0;
                        }

                        break;

                    case 94746189:
                        if (s.equals("clear"))
                        {
                            b0 = 3;
                        }

                        break;

                    case 1282362038:
                        if (s.equals("removeRow"))
                        {
                            b0 = 1;
                        }
                }

                switch (b0)
                {
                    case 0:
                        String[] astring1 = bytemap.getStringArray("value");
                        int j = bytemap.getInt("row", -1);

                        if (j == -1)
                        {
                            this.rows.add(astring1);
                        }
                        else
                        {
                            this.rows.add(j, astring1);
                        }

                        this.updateBounds();
                        break;

                    case 1:
                        this.rows.remove(bytemap.getInt("row"));

                        if (this.startRow + this.maxRows > this.rows.size())
                        {
                            this.startRow = Math.max(0, this.rows.size() - this.maxRows);
                        }

                        this.updateBounds();
                        break;

                    case 2:
                        String[] astring = bytemap.getStringArray("value");
                        int i = bytemap.getInt("row");
                        this.rows.set(i, astring);
                        break;

                    case 3:
                        this.rows.clear();
                        this.startRow = 0;
                        this.updateBounds();
                }
            }
        }
    }

    public float getWidth()
    {
        return (float)this.width;
    }

    public float getHeight()
    {
        return (float)this.height;
    }

    public void checkHover(int x, int y, long time)
    {
        super.checkHover(x, y, time);

        if (this.hover)
        {
            if (this.hasScrollbar() && x + 3 >= this.width)
            {
                this.hoverRow = -1;
                return;
            }

            y = y - 10;

            if (this.title != null)
            {
                y -= 10;
            }

            if (y >= 0 && y % 10 != 9)
            {
                this.hoverRow = this.startRow + y / 10;
            }
        }
    }

    public boolean mouseWheel(int delta)
    {
        if (super.mouseWheel(delta))
        {
            return true;
        }
        else if (this.hasScrollbar())
        {
            if (this.startRow - delta >= 0 && this.startRow - delta + this.maxRows <= this.rows.size())
            {
                this.startRow -= delta;
            }

            return true;
        }
        else
        {
            return false;
        }
    }

    public void render(long time)
    {
        int i = this.getAlpha(this.color.render);
        int j = -2013265920;

        if (this.getAlpha(j) > i)
        {
            j = this.setAlpha(j, i);
        }

        this.cullingEnabled = GL11.glIsEnabled(GL11.GL_CULL_FACE);
        GlStateManager.disableTexture2D();

        if (this.cullingEnabled && this.drawBack)
        {
            GlStateManager.disableCull();
        }

        Tessellator.getInstance().getWorldRenderer().begin(7, DefaultVertexFormats.POSITION_COLOR);
        int k = 0;

        if (this.title != null)
        {
            int l = this.fontRenderer.getStringWidth(this.title) + 10;
            addRectToPipe((double)(this.width - l) / 2.0D, 0.0D, (double)l, 9.0D, j);
            k += 10;
        }

        addRectToPipe(0.0D, (double)k, (double)this.width, 9.0D, j);
        k = k + 10;
        int j2 = k;

        if (this.hasScrollbar())
        {
            int j1 = this.width - 2;
            int k1 = this.height - k - 1;
            int l1 = (int)((float)k1 * ((float)this.maxRows / (float)this.rows.size()));
            addRectToPipe((double)j1, (double)k, 2.0D, (double)k1, j);
            int offsetY0 = (int)((float)k + (float)(k1 - l1) * (float)this.startRow / (float)(this.rows.size() - this.maxRows));
            int i2 = this.scrollbarColor;

            if (this.getAlpha(i2) > i)
            {
                i2 = this.setAlpha(i2, i);
            }

            addRectToPipe((double)j1, (double)offsetY0, 2.0D, (double)l1, i2);
        }

        for (int k2 = this.startRow; k2 < this.startRow + this.maxRows && k2 < this.rows.size(); ++k2)
        {
            int i3 = j;

            if (this.hoverRow == k2)
            {
                i3 = this.rowHoverColor;

                if (this.getAlpha(i3) > i)
                {
                    i3 = this.setAlpha(i3, i);
                }
            }

            int l3 = 0;

            for (Table.Column table$column : this.columns)
            {
                addRectToPipe((double)l3, (double)k, (double)table$column.width, 9.0D, i3);
                l3 += table$column.width + 1;
            }

            k += 10;
        }

        Tessellator.getInstance().draw();

        if (this.cullingEnabled && this.drawBack)
        {
            GlStateManager.enableCull();
        }

        GlStateManager.enableTexture2D();
        int l2 = this.setAlpha(this.headingColor, i);

        if (this.title != null)
        {
            int j3 = this.fontRenderer.getStringWidth(this.title) + 10;
            this.renderText(this.title, (this.width - j3) / 2, 0, j3, this.setAlpha(this.titleColor, i), true);
        }

        int k3 = 0;

        for (Table.Column table$column1 : this.columns)
        {
            this.renderText(table$column1.name, k3, j2 - 10, table$column1.width, l2, true);
            k3 += table$column1.width + 1;
        }

        k = j2;

        for (int i4 = this.startRow; i4 < this.startRow + this.maxRows && i4 < this.rows.size(); ++i4)
        {
            k3 = 0;
            String[] astring = (String[])this.rows.get(i4);

            for (int j4 = 0; j4 < astring.length; ++j4)
            {
                this.renderText(astring[j4], k3, k, this.columns[j4].width, this.setAlpha(this.columns[j4].color, i), this.columns[j4].center);
                k3 += this.columns[j4].width + 1;
            }

            k += 10;
        }

        this.hoverRow = -1;
    }

    public boolean hasScrollbar()
    {
        return this.maxRows < this.rows.size();
    }

    private void renderText(String text, int x, int y, int width, int color, boolean center)
    {
        this.fontRenderer.drawString(text, x + (center ? (width - this.fontRenderer.getStringWidth(text)) / 2 : 1), y, color);
    }

    public static void addRectToPipe(double x, double y, double width, double height, int color)
    {
        int i = color >> 24 & 255;
        int j = color >> 16 & 255;
        int k = color >> 8 & 255;
        int l = color & 255;
        WorldRenderer worldrenderer = Tessellator.getInstance().getWorldRenderer();
        worldrenderer.pos(x, y + height, 0.0D).color(j, k, l, i).endVertex();
        worldrenderer.pos(x + width, y + height, 0.0D).color(j, k, l, i).endVertex();
        worldrenderer.pos(x + width, y, 0.0D).color(j, k, l, i).endVertex();
        worldrenderer.pos(x, y, 0.0D).color(j, k, l, i).endVertex();
    }

    public static class Column
    {
        String name;
        int width;
        boolean center = false;
        int color = -1;

        public Column(String name, int width)
        {
            this.name = name;
            this.width = width;
        }
    }
}
