package net.xtrafrancyz.mods.minidot.items;

import net.minecraft.util.ResourceLocation;

public enum ItemCollection
{
    NONE(true, (String)null, 0),
    GENERIC_RARE(false, (String)null, -7488865),
    WINTER(false, "\u00a7b\u0417\u0438\u043c\u043d\u044f\u044f \u043a\u043e\u043b\u043b\u0435\u043a\u0446\u0438\u044f", -7685438),
    SPRING(false, "\u00a7a\u0412\u0435\u0441\u0435\u043d\u043d\u044f\u044f \u043a\u043e\u043b\u043b\u0435\u043a\u0446\u0438\u044f", -6501275),
    SUMMER(false, "\u00a7e\u041b\u0435\u0442\u043d\u044f\u044f \u043a\u043e\u043b\u043b\u0435\u043a\u0446\u0438\u044f", -1651586),
    FALL(false, "\u00a76\u041e\u0441\u0435\u043d\u043d\u044f\u044f \u043a\u043e\u043b\u043b\u0435\u043a\u0446\u0438\u044f", -3171776),
    HALLOWEEN(false, "\u00a76\u0425\u0435\u043b\u043b\u043e\u0443\u0438\u043d\u0441\u043a\u0430\u044f \u043a\u043e\u043b\u043b\u0435\u043a\u0446\u0438\u044f", -3892376),
    EASTER(false, "\u00a7d\u041f\u0430\u0441\u0445\u0430\u043b\u044c\u043d\u0430\u044f \u043a\u043e\u043b\u043b\u0435\u043a\u0446\u0438\u044f", -749647),
    TOURNAMENT(false, (String)null, -4540803);

    private final boolean visible;
    private final String name;
    private ResourceLocation background;
    private int backgroundColor;

    private ItemCollection(boolean visible, String name, int color)
    {
        this.visible = visible;
        this.name = name;
        this.backgroundColor = color;
    }

    private ItemCollection(boolean visible, String name, ResourceLocation color)
    {
        this.visible = visible;
        this.name = name;
        this.background = color;
    }

    public ResourceLocation getBackground()
    {
        return this.background;
    }

    public int getBackgroundColor()
    {
        return this.backgroundColor;
    }

    public boolean isVisible()
    {
        return this.visible;
    }

    public String getName()
    {
        return this.name;
    }

    public String getStringId()
    {
        return this == NONE ? "" : this.name().toLowerCase();
    }
}
