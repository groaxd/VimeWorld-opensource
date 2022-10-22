package net.xtrafrancyz.mods.discord.lib;

import com.sun.jna.Library;
import com.sun.jna.Native;
import java.io.File;

public class DiscordRPC
{
    private static final String LIB_NAME = System.getProperty("sun.arch.data.model").equals("64") ? "discord-rpc64" : "discord-rpc32";
    private static final String DLL_VERSION = "3.3.0";

    public static void discordInitialize(String applicationId, DiscordEventHandlers handlers, boolean autoRegister)
    {
        DiscordRPC.DLL.INSTANCE.Discord_Initialize(applicationId, handlers, autoRegister ? 1 : 0, (String)null);
    }

    public static void discordRegister(String applicationId, String command)
    {
        DiscordRPC.DLL.INSTANCE.Discord_Register(applicationId, command);
    }

    public static void discordInitialize(String applicationId, DiscordEventHandlers handlers, boolean autoRegister, String steamId)
    {
        DiscordRPC.DLL.INSTANCE.Discord_Initialize(applicationId, handlers, autoRegister ? 1 : 0, steamId);
    }

    public static void discordRegisterSteam(String applicationId, String steamId)
    {
        DiscordRPC.DLL.INSTANCE.Discord_RegisterSteamGame(applicationId, steamId);
    }

    public static void discordShutdown()
    {
        DiscordRPC.DLL.INSTANCE.Discord_Shutdown();
    }

    public static void discordRunCallbacks()
    {
        DiscordRPC.DLL.INSTANCE.Discord_RunCallbacks();
    }

    public static void discordUpdatePresence(DiscordRichPresence presence)
    {
        DiscordRPC.DLL.INSTANCE.Discord_UpdatePresence(presence);
    }

    public static void discordClearPresence()
    {
        DiscordRPC.DLL.INSTANCE.Discord_ClearPresence();
    }

    public static void discordRespond(String userId, DiscordReply reply)
    {
        DiscordRPC.DLL.INSTANCE.Discord_Respond(userId, reply.reply);
    }

    static
    {
        File file1 = new File(System.getProperty("java.library.path"), LIB_NAME + ".dll");
        System.load(file1.getAbsolutePath());
    }

    public interface DLL extends Library
    {
        DiscordRPC.DLL INSTANCE = (DiscordRPC.DLL)Native.loadLibrary(DiscordRPC.LIB_NAME, DiscordRPC.DLL.class);

        void Discord_Initialize(String var1, DiscordEventHandlers var2, int var3, String var4);

        void Discord_Register(String var1, String var2);

        void Discord_RegisterSteamGame(String var1, String var2);

        void Discord_Shutdown();

        void Discord_RunCallbacks();

        void Discord_UpdatePresence(DiscordRichPresence var1);

        void Discord_ClearPresence();

        void Discord_Respond(String var1, int var2);
    }
}
