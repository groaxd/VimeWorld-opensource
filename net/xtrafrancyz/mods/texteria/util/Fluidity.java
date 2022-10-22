package net.xtrafrancyz.mods.texteria.util;

public enum Fluidity
{
    FIXED,
    WRAP_CONTENT,
    MATCH_PARENT;

    public static Fluidity byValue(int size)
    {
        return size == -1 ? WRAP_CONTENT : (size == -2 ? MATCH_PARENT : FIXED);
    }
}
