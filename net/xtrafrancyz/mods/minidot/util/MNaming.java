package net.xtrafrancyz.mods.minidot.util;

import java.util.Collections;
import java.util.List;
import net.minecraft.util.EnumChatFormatting;

public class MNaming
{
    public static List<String> fromMult(String name)
    {
        return Collections.<String>singletonList(EnumChatFormatting.WHITE + "\u0418\u0437 \u043c\u0443\u043b\u044c\u0442\u0441\u0435\u0440\u0438\u0430\u043b\u0430: " + EnumChatFormatting.BOLD + name);
    }

    public static List<String> fromGame(String name)
    {
        return Collections.<String>singletonList(EnumChatFormatting.WHITE + "\u0418\u0437 \u0438\u0433\u0440\u044b: " + EnumChatFormatting.BOLD + name);
    }

    public static List<String> fromFilmSeries(String name)
    {
        return Collections.<String>singletonList(EnumChatFormatting.WHITE + "\u0418\u0437 \u0441\u0435\u0440\u0438\u0438 \u0444\u0438\u043b\u044c\u043c\u043e\u0432 " + EnumChatFormatting.BOLD + name);
    }

    public static List<String> fromAnime(String name)
    {
        return Collections.<String>singletonList(EnumChatFormatting.WHITE + "\u0418\u0437 \u0430\u043d\u0438\u043c\u0435: " + EnumChatFormatting.BOLD + name);
    }
}
