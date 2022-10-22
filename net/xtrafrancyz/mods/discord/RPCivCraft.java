package net.xtrafrancyz.mods.discord;

import net.minecraft.client.Minecraft;
import net.xtrafrancyz.mods.discord.lib.DiscordRichPresence;

public class RPCivCraft implements RPGenerator
{
    private String username = Minecraft.getMinecraft().getSession().getUsername();
    private long gameStart = System.currentTimeMillis() / 1000L;

    public DiscordRichPresence generate()
    {
        DiscordRichPresence discordrichpresence = new DiscordRichPresence();
        discordrichpresence.largeImageKey = "logo";
        discordrichpresence.details = "CivCraft";
        discordrichpresence.state = this.username;
        discordrichpresence.startTimestamp = this.gameStart;
        return discordrichpresence;
    }
}
