package net.xtrafrancyz.mods.texteria.util;

import net.xtrafrancyz.util.ByteMap;

public class OnClick
{
    public OnClick.Action action;
    public Object data;

    public OnClick(ByteMap map)
    {
        this.action = OnClick.Action.valueOf(map.getString("act"));
        this.data = map.get("data");
    }

    public static enum Action
    {
        URL,
        CHAT,
        CALLBACK,
        SCRIPT,
        CLOSE_GUI;
    }
}
