package net.xtrafrancyz.util;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.regex.Pattern;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.xtrafrancyz.mods.texteria.Texteria;

public class CommonUtils
{
    private static final Pattern URL_REGEXP = Pattern.compile("https?://(www\\.)?[-a-zA-Z0-9@:%._+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_+.~#?&/=]*)");

    public static String plurals(int n, String form1, String form2, String form3)
    {
        int i = n;

        if (n == 0)
        {
            return n + " " + form3;
        }
        else
        {
            n = Math.abs(n) % 100;

            if (n > 10 && n < 20)
            {
                return i + " " + form3;
            }
            else
            {
                n = n % 10;
                return n > 1 && n < 5 ? i + " " + form2 : (n == 1 ? i + " " + form1 : i + " " + form3);
            }
        }
    }

    public static void openUrl(String url)
    {
        if (URL_REGEXP.matcher(url).matches())
        {
            try
            {
                Desktop.getDesktop().browse(new URI(url));
            }
            catch (Exception exception)
            {
                Texteria.log.error("Couldn\'t open link (" + exception.getMessage() + "). Trying Windows rundll32 feature...");
                exception.printStackTrace();

                try
                {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
                }
                catch (IOException ioexception)
                {
                    Texteria.log.error((String)"Couldn\'t open link with rundll32", (Throwable)ioexception);
                }
            }
        }
    }

    public static void println(String message)
    {
        Texteria.log.info(message);
    }

    public static void sendMessage(String message)
    {
        if (message.charAt(0) != 47)
        {
            Minecraft.getMinecraft().ingameGUI.getChatGUI().addToSentMessages(message);
        }

        Minecraft.getMinecraft().thePlayer.sendChatMessage(message);
    }

    public static void addChatMessage(IChatComponent message)
    {
        Minecraft.getMinecraft().thePlayer.addChatMessage(message);
    }

    public static IChatComponent fromLegacy(String message)
    {
        ArrayList<IChatComponent> arraylist = new ArrayList();
        StringBuilder stringbuilder = new StringBuilder();
        ChatComponentText chatcomponenttext = new ChatComponentText("");

        for (int i = 0; i < message.length(); ++i)
        {
            char c0 = message.charAt(i);

            if (c0 != 38 && c0 != 167)
            {
                stringbuilder.append(c0);
            }
            else
            {
                ++i;
                c0 = message.charAt(i);

                if (c0 >= 65 && c0 <= 90)
                {
                    c0 = (char)(c0 + 32);
                }

                EnumChatFormatting enumchatformatting = parseFormatting(c0);

                if (enumchatformatting != null)
                {
                    if (stringbuilder.length() > 0)
                    {
                        ChatComponentText chatcomponenttext1 = chatcomponenttext;
                        ChatStyle chatstyle = chatcomponenttext.getChatStyle();
                        chatcomponenttext = new ChatComponentText("");
                        chatcomponenttext.setChatStyle((new ChatStyle()).setParentStyle(chatstyle));
                        chatcomponenttext1.setText(stringbuilder.toString());
                        stringbuilder = new StringBuilder();
                        arraylist.add(chatcomponenttext1);
                    }

                    switch (enumchatformatting)
                    {
                        case BOLD:
                            chatcomponenttext.getChatStyle().setBold(Boolean.valueOf(true));
                            break;

                        case ITALIC:
                            chatcomponenttext.getChatStyle().setItalic(Boolean.valueOf(true));
                            break;

                        case UNDERLINE:
                            chatcomponenttext.getChatStyle().setUnderlined(Boolean.valueOf(true));
                            break;

                        case STRIKETHROUGH:
                            chatcomponenttext.getChatStyle().setStrikethrough(Boolean.valueOf(true));
                            break;

                        case OBFUSCATED:
                            chatcomponenttext.getChatStyle().setObfuscated(Boolean.valueOf(true));
                            break;

                        case RESET:
                            enumchatformatting = EnumChatFormatting.WHITE;

                        default:
                            chatcomponenttext = new ChatComponentText("");
                            chatcomponenttext.getChatStyle().setColor(enumchatformatting);
                    }
                }
            }
        }

        if (stringbuilder.length() > 0)
        {
            chatcomponenttext.setText(stringbuilder.toString());
            arraylist.add(chatcomponenttext);
        }

        if (arraylist.isEmpty())
        {
            arraylist.add(new ChatComponentText(""));
        }

        ChatComponentText chatcomponenttext2 = new ChatComponentText("");

        for (IChatComponent ichatcomponent : arraylist)
        {
            chatcomponenttext2.appendSibling(ichatcomponent);
        }

        return chatcomponenttext2;
    }

    private static EnumChatFormatting parseFormatting(char c)
    {
        for (EnumChatFormatting enumchatformatting : EnumChatFormatting.values())
        {
            if (enumchatformatting.toString().charAt(1) == c)
            {
                return enumchatformatting;
            }
        }

        return null;
    }

    public static boolean isAllowedCharacter(char c)
    {
        return ChatAllowedCharacters.isAllowedCharacter(c);
    }

    public static String getTabHeader()
    {
        return Minecraft.getMinecraft().ingameGUI.getTabList().getHeader().getFormattedText();
    }

    public static String getTabFooter()
    {
        return Minecraft.getMinecraft().ingameGUI.getTabList().getFooter().getFormattedText();
    }
}
