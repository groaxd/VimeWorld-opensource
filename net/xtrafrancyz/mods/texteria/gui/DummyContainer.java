package net.xtrafrancyz.mods.texteria.gui;

import net.xtrafrancyz.mods.texteria.elements.Element2D;
import net.xtrafrancyz.mods.texteria.elements.container.IContainer;
import net.xtrafrancyz.mods.texteria.util.Fluidity;

public class DummyContainer implements IContainer
{
    private Element2D singleChild;

    public void setChild(Element2D singleChild)
    {
        this.singleChild = singleChild;
    }

    public Element2D getElement(String id)
    {
        return this.singleChild.id.equals(id) ? this.singleChild : null;
    }

    public float getWidth()
    {
        return this.singleChild.getWidthFluidity() == Fluidity.MATCH_PARENT ? 0.0F : this.singleChild.getWidth();
    }

    public float getHeight()
    {
        return this.singleChild.getHeightFluidity() == Fluidity.MATCH_PARENT ? 0.0F : this.singleChild.getHeight();
    }
}
