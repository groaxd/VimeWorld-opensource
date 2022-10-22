package net.xtrafrancyz.mods.texteria.util;

public class Attachment
{
    public String attachTo;
    public Position attachLocation;
    public Position orientation;
    public boolean removeWhenParentRemove = false;

    public Attachment(String attachTo, Position attachLocation)
    {
        this.attachTo = attachTo;
        this.attachLocation = attachLocation;
        this.orientation = attachLocation;
    }
}
