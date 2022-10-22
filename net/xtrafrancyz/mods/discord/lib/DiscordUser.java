package net.xtrafrancyz.mods.discord.lib;

import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class DiscordUser extends Structure
{
    public String userId;
    public String username;
    public String discriminator;
    public String avatar;

    public List<String> getFieldOrder()
    {
        return Arrays.<String>asList(new String[] {"userId", "username", "discriminator", "avatar"});
    }
}
