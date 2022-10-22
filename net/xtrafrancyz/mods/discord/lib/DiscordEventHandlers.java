package net.xtrafrancyz.mods.discord.lib;

import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
import net.xtrafrancyz.mods.discord.lib.callbacks.DisconnectedCallback;
import net.xtrafrancyz.mods.discord.lib.callbacks.ErroredCallback;
import net.xtrafrancyz.mods.discord.lib.callbacks.JoinGameCallback;
import net.xtrafrancyz.mods.discord.lib.callbacks.JoinRequestCallback;
import net.xtrafrancyz.mods.discord.lib.callbacks.ReadyCallback;
import net.xtrafrancyz.mods.discord.lib.callbacks.SpectateGameCallback;

public class DiscordEventHandlers extends Structure
{
    public ReadyCallback ready;
    public DisconnectedCallback disconnected;
    public ErroredCallback errored;
    public JoinGameCallback joinGame;
    public SpectateGameCallback spectateGame;
    public JoinRequestCallback joinRequest;

    public List<String> getFieldOrder()
    {
        return Arrays.<String>asList(new String[] {"ready", "disconnected", "errored", "joinGame", "spectateGame", "joinRequest"});
    }
}
