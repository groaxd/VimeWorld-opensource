package net.xtrafrancyz.mods.texteria.elements;

import net.xtrafrancyz.mods.texteria.Texteria;
import net.xtrafrancyz.mods.texteria.util.FValue;
import net.xtrafrancyz.mods.texteria.util.Fluidity;
import net.xtrafrancyz.mods.texteria.util.TRenderUtil;
import net.xtrafrancyz.util.ByteMap;

public class Rectangle extends Element2D
{
    protected Fluidity widthFluidity;
    protected Fluidity heightFluidity;
    public FValue width;
    public FValue height;

    public Rectangle(ByteMap params)
    {
        this(params, 1);
    }

    public Rectangle(ByteMap params, int defaultSize)
    {
        super(params);

        if (params.containsKey("size"))
        {
            this.width = new FValue(params.getFloat("size", (float)defaultSize));
            this.height = new FValue(this.width.orig);
        }
        else
        {
            this.width = new FValue(params.getFloat("width", (float)defaultSize));
            this.height = new FValue(params.getFloat("height", (float)defaultSize));
        }

        this.widthFluidity = Fluidity.byValue((int)this.width.orig);
        this.heightFluidity = Fluidity.byValue((int)this.height.orig);
    }

    public Rectangle(String id, float width, float height)
    {
        super(id);
        this.width = new FValue(width);
        this.height = new FValue(height);
    }

    public boolean hasActiveBBAnimation(long time)
    {
        return super.hasActiveBBAnimation(time) || this.width.isActiveTick(time) || this.height.isActiveTick(time);
    }

    public Fluidity getWidthFluidity()
    {
        return this.widthFluidity;
    }

    public float getWidth()
    {
        return this.widthFluidity == Fluidity.MATCH_PARENT ? this.parent.getWidth() / this.scaleX.renderValue(Texteria.time) : this.width.renderValue(Texteria.time);
    }

    public Fluidity getHeightFluidity()
    {
        return this.heightFluidity;
    }

    public float getHeight()
    {
        return this.heightFluidity == Fluidity.MATCH_PARENT ? this.parent.getHeight() / this.scaleY.renderValue(Texteria.time) : this.height.renderValue(Texteria.time);
    }

    public void render(long time)
    {
        TRenderUtil.drawRect(0.0D, 0.0D, (double)this.getWidth(), (double)this.getHeight(), this.color.render);
    }
}
