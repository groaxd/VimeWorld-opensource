package net.xtrafrancyz.mods.discord.lib.callbacks;

import com.sun.jna.Callback;
import net.xtrafrancyz.mods.discord.lib.DiscordUser;

public interface JoinRequestCallback extends Callback
{
    void apply(DiscordUser var1);
}
