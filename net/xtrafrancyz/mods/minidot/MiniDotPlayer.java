package net.xtrafrancyz.mods.minidot;

import java.util.LinkedHashMap;
import java.util.Map;
import net.xtrafrancyz.mods.minidot.items.BaseItem;

public class MiniDotPlayer
{
    public Map<String, BaseItem> items;
    public float prevPetBodyYawOffset = 0.0F;

    public MiniDotPlayer(MiniDotPlayer clone)
    {
        this.items = new LinkedHashMap(clone.items);
    }

    public MiniDotPlayer()
    {
        this.items = new LinkedHashMap();
    }
}
