package net.xtrafrancyz.mods.discord;

import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.xtrafrancyz.mods.discord.lib.DiscordRichPresence;
import net.xtrafrancyz.mods.texteria.Texteria;
import net.xtrafrancyz.mods.texteria.elements.Element2D;
import net.xtrafrancyz.mods.texteria.elements.Text;

public class RPMiniGames implements RPGenerator
{
    private String username = Minecraft.getMinecraft().getSession().getUsername();
    private String lastGame;
    private long gameStart;

    public DiscordRichPresence generate()
    {
        String s = Texteria.tryGetServerId((String)null);

        if (!Objects.equals(this.lastGame, s))
        {
            this.lastGame = s;
            this.gameStart = System.currentTimeMillis() / 1000L;
        }

        String s1 = null;
        Element2D element2d = Texteria.instance.gui.getElement("vn.n");

        if (element2d instanceof Text)
        {
            String s2 = ((Text)element2d).text[0];

            if (s2.charAt(0) == 91)
            {
                int i = s2.indexOf(167, 3);

                if (i != -1)
                {
                    s1 = s2.substring(3, i);
                }
            }
        }

        String s4 = null;
        int k = 0;
        element2d = Texteria.instance.gui.getElement("vn.p");

        if (element2d instanceof Text)
        {
            k = ((Text)element2d).text.length + 1;
            String s3 = ((Text)element2d).text[0];

            if (!s3.endsWith("\u2603"))
            {
                s4 = this.username;
            }
            else
            {
                int j = s3.indexOf(93);

                if (j != -1)
                {
                    for (s3 = s3.substring(j + 2, s3.length() - 3); s3.charAt(0) == 167; s3 = s3.substring(2))
                    {
                        ;
                    }
                }
            }
        }

        DiscordRichPresence discordrichpresence = new DiscordRichPresence();
        discordrichpresence.startTimestamp = this.gameStart;

        if (s1 != null)
        {
            discordrichpresence.state = this.username + ", \u0443\u0440. " + s1;
        }
        else
        {
            discordrichpresence.state = this.username;
        }

        if (s == null && Minecraft.getMinecraft().thePlayer == null)
        {
            discordrichpresence.largeImageKey = "logo";
            discordrichpresence.details = "\u0412 \u043c\u0435\u043d\u044e";
        }
        else if (s == null)
        {
            discordrichpresence.largeImageKey = "logo";
            discordrichpresence.details = "\u0413\u0434\u0435-\u0442\u043e \u0432 \u0438\u0433\u0440\u0435";
        }
        else
        {
            String s5 = s.split("_")[0];
            byte b0 = -1;

            switch (s5.hashCode())
            {
                case -1926649461:
                    if (s5.equals("PRISON"))
                    {
                        b0 = 17;
                    }

                    break;

                case 2112:
                    if (s5.equals("BB"))
                    {
                        b0 = 9;
                    }

                    break;

                case 2126:
                    if (s5.equals("BP"))
                    {
                        b0 = 10;
                    }

                    break;

                case 2133:
                    if (s5.equals("BW"))
                    {
                        b0 = 0;
                    }

                    break;

                case 2157:
                    if (s5.equals("CP"))
                    {
                        b0 = 7;
                    }

                    break;

                case 2190:
                    if (s5.equals("DR"))
                    {
                        b0 = 11;
                    }

                    break;

                case 2272:
                    if (s5.equals("GG"))
                    {
                        b0 = 12;
                    }

                    break;

                case 2303:
                    if (s5.equals("HG"))
                    {
                        b0 = 14;
                    }

                    break;

                case 2474:
                    if (s5.equals("MW"))
                    {
                        b0 = 6;
                    }

                    break;

                case 2532:
                    if (s5.equals("OS"))
                    {
                        b0 = 19;
                    }

                    break;

                case 2660:
                    if (s5.equals("SW"))
                    {
                        b0 = 4;
                    }

                    break;

                case 64961:
                    if (s5.equals("ANN"))
                    {
                        b0 = 8;
                    }

                    break;

                case 65074:
                    if (s5.equals("ARC"))
                    {
                        b0 = 18;
                    }

                    break;

                case 66195:
                    if (s5.equals("BWH"))
                    {
                        b0 = 1;
                    }

                    break;

                case 66204:
                    if (s5.equals("BWQ"))
                    {
                        b0 = 3;
                    }

                    break;

                case 71469:
                    if (s5.equals("HGL"))
                    {
                        b0 = 15;
                    }

                    break;

                case 82544:
                    if (s5.equals("SWT"))
                    {
                        b0 = 5;
                    }

                    break;

                case 2313951:
                    if (s5.equals("KPVP"))
                    {
                        b0 = 13;
                    }

                    break;

                case 63557198:
                    if (s5.equals("BUILD"))
                    {
                        b0 = 21;
                    }

                    break;

                case 63614874:
                    if (s5.equals("BWH-T"))
                    {
                        b0 = 2;
                    }

                    break;

                case 65400411:
                    if (s5.equals("DUELS"))
                    {
                        b0 = 16;
                    }

                    break;

                case 72606646:
                    if (s5.equals("LOBBY"))
                    {
                        b0 = 20;
                    }
            }

            switch (b0)
            {
                case 0:
                    discordrichpresence.details = "BedWars";
                    discordrichpresence.largeImageKey = "game_bw";
                    break;

                case 1:
                case 2:
                    discordrichpresence.details = "BedWars Hard";
                    discordrichpresence.largeImageKey = "game_bw";
                    break;

                case 3:
                    discordrichpresence.details = "BedWars Quick";
                    discordrichpresence.largeImageKey = "game_bw";
                    break;

                case 4:
                    discordrichpresence.details = "SkyWars";
                    discordrichpresence.largeImageKey = "game_sw";
                    break;

                case 5:
                    discordrichpresence.details = "SkyWars Team";
                    discordrichpresence.largeImageKey = "game_sw";
                    break;

                case 6:
                    discordrichpresence.details = "MobWars";
                    discordrichpresence.largeImageKey = "game_mw";
                    break;

                case 7:
                    discordrichpresence.details = "ClashPoint";
                    discordrichpresence.largeImageKey = "game_cp";
                    break;

                case 8:
                    discordrichpresence.details = "Annihilation";
                    discordrichpresence.largeImageKey = "game_ann";
                    break;

                case 9:
                    discordrichpresence.details = "BuildBattle";
                    discordrichpresence.largeImageKey = "game_bb";
                    break;

                case 10:
                    discordrichpresence.details = "BlockParty";
                    discordrichpresence.largeImageKey = "game_bp";
                    break;

                case 11:
                    discordrichpresence.details = "DeathRun";
                    discordrichpresence.largeImageKey = "game_dr";
                    break;

                case 12:
                    discordrichpresence.details = "GunGame";
                    discordrichpresence.largeImageKey = "game_gg";
                    break;

                case 13:
                    discordrichpresence.details = "KitPvP";
                    discordrichpresence.largeImageKey = "game_kpvp";
                    break;

                case 14:
                    discordrichpresence.details = "HungerGames";
                    discordrichpresence.largeImageKey = "game_hg";
                    break;

                case 15:
                    discordrichpresence.details = "HungerGames Lucky";
                    discordrichpresence.largeImageKey = "game_hg";
                    break;

                case 16:
                    discordrichpresence.details = "\u0414\u0443\u044d\u043b\u0438";
                    discordrichpresence.largeImageKey = "game_duels";
                    break;

                case 17:
                    discordrichpresence.details = "Prison";
                    discordrichpresence.largeImageKey = "game_prison";
                    break;

                case 18:
                    discordrichpresence.details = "\u0410\u0440\u043a\u0430\u0434\u044b";
                    discordrichpresence.largeImageKey = "game_arc";
                    break;

                case 19:
                    discordrichpresence.details = "\u041f\u0440\u0438\u0432\u0430\u0442\u043d\u044b\u0439 \u0441\u0435\u0440\u0432\u0435\u0440";
                    discordrichpresence.largeImageKey = "generic_explode";
                    discordrichpresence.largeImageText = "\u0421\u0430\u043c \u0441\u0435\u0431\u0435 \u0445\u043e\u0437\u044f\u0438\u043d";
                    break;

                case 20:
                    discordrichpresence.details = "\u041b\u043e\u0431\u0431\u0438";
                    break;

                case 21:
                    discordrichpresence.details = "\u0421\u0442\u0440\u043e\u0438\u0442 \u043d\u043e\u0432\u044b\u0435 \u043a\u0430\u0440\u0442\u044b";
                    discordrichpresence.largeImageKey = "game_bb";
                    discordrichpresence.largeImageText = "\u0421\u0442\u0440\u043e\u0438\u0442\u0435\u043b\u044c \u043e\u0442 \u0431\u043e\u0433\u0430";
                    break;

                default:
                    discordrichpresence.details = "\u041e\u043d\u043b\u0430\u0439\u043d";
            }

            if (discordrichpresence.largeImageText == null && !"\u041e\u043d\u043b\u0430\u0439\u043d".equals(discordrichpresence.details))
            {
                discordrichpresence.largeImageText = discordrichpresence.details;
            }

            if (discordrichpresence.largeImageKey == null)
            {
                discordrichpresence.largeImageKey = "logo";
                discordrichpresence.largeImageText = "VimeWorld";
            }
            else
            {
                discordrichpresence.smallImageKey = "logo";
                discordrichpresence.smallImageText = "VimeWorld";
            }
        }

        return discordrichpresence;
    }
}
