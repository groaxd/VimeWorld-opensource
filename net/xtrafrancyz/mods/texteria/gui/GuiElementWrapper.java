package net.xtrafrancyz.mods.texteria.gui;

import net.minecraft.client.Minecraft;
import net.xtrafrancyz.mods.texteria.Texteria;
import net.xtrafrancyz.mods.texteria.elements.Element;
import net.xtrafrancyz.mods.texteria.elements.Element2D;
import net.xtrafrancyz.mods.texteria.elements.container.Element2DWrapper;
import net.xtrafrancyz.mods.texteria.elements.container.IContainer;
import net.xtrafrancyz.mods.texteria.util.Point2F;
import net.xtrafrancyz.mods.texteria.util.Position;
import net.xtrafrancyz.util.ByteMap;

public class GuiElementWrapper extends Element implements Element2DWrapper
{
    public Element2D element;
    public Visibility visibility;
    public boolean visible;

    public GuiElementWrapper(ByteMap params, IContainer parent) throws Exception
    {
        super(params.getString("id"));
        this.visibility = Visibility.DEFAULT;
        this.visible = false;
        this.element = Element2D.construct(params, parent);

        if (this.element.pos == null)
        {
            this.element.pos = Position.CENTER;
        }

        if (params.containsKey("vis"))
        {
            this.visibility = new Visibility(params.getMapArray("vis"));
        }

        if (this.element.isScriptsEnabled())
        {
            this.element.scriptBindings.put((String)"selfWrapper", this);
        }
    }

    public GuiElementWrapper(Element2D element, IContainer parent)
    {
        this(element, Visibility.DEFAULT, parent);
    }

    public GuiElementWrapper(Element2D element, Visibility visibility, IContainer parent)
    {
        super(element.id);
        this.visibility = Visibility.DEFAULT;
        this.visible = false;
        element.parent = parent;
        this.element = element;
        this.visibility = visibility;
    }

    void checkHover(Minecraft mc, long time)
    {
        if (this.element.hoverable)
        {
            if (mc.currentScreen != null)
            {
                Point2F point2f = this.element.getXY(time);
                this.element.checkHover((int)(((float)TexteriaGui.mouseX - point2f.x) / this.element.scaleX.render), (int)(((float)TexteriaGui.mouseY - point2f.y) / this.element.scaleY.render), time);

                if (this.element.hover && this.element.tooltip != null && !this.element.isIn3d && this.isVisible(mc))
                {
                    Texteria.instance.gui.currentTooltip = this.element.tooltip;
                }
            }
            else
            {
                this.element.checkHover(-1, -1, time);
            }
        }
    }

    public void render(long time)
    {
        this.element.renderInContainer(time);
    }

    public boolean isVisible(Minecraft mc)
    {
        boolean flag = false;

        for (Visibility.Selector visibility$selector : this.visibility.selectors)
        {
            if (visibility$selector.acceptable(mc, this))
            {
                flag = visibility$selector.show;
            }
        }

        this.visible = flag;
        return flag;
    }

    public void dispose()
    {
        this.element.dispose();
    }

    public void edit(ByteMap data)
    {
        this.element.edit(data);
    }

    public String toString()
    {
        return "Gui " + this.element;
    }

    public Element2D getElement2D()
    {
        return this.element;
    }

    public int hashCode()
    {
        return this.element.hashCode();
    }

    public boolean equals(Object obj)
    {
        return obj == this;
    }
}
