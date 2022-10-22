package net.xtrafrancyz.mods.texteria.elements.container;

import net.xtrafrancyz.mods.texteria.elements.Element2D;

public interface IContainer
{
    Element2D getElement(String var1);

    float getWidth();

    float getHeight();
}
