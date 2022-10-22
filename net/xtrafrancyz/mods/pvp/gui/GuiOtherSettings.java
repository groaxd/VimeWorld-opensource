package net.xtrafrancyz.mods.pvp.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.xtrafrancyz.mods.pvp.PvpOptions;
import net.xtrafrancyz.mods.pvp.gui.hud.TNetworkInfoHudElement;

public class GuiOtherSettings extends GuiPvPScreen
{
    private static final int BTN_OTHER_NETWORK_INFO = 1;
    private static final int BTN_SHOW_MODELS = 2;

    public GuiOtherSettings(GuiScreen parent)
    {
        super(parent, "\u041f\u0440\u043e\u0447\u0435\u0435");
    }

    protected void onInit()
    {
        this.addButton(1, getOtherNetworkInfo());
        this.addButton(2, getShowModels());
    }

    protected void onButtonAction(GuiButton button)
    {
        switch (button.id)
        {
            case 1:
                PvpOptions.otherNetworkInfo = !PvpOptions.otherNetworkInfo;
                button.displayString = getOtherNetworkInfo();
                TNetworkInfoHudElement.applyOptions();
                break;

            case 2:
                PvpOptions.showModels = !PvpOptions.showModels;
                button.displayString = getShowModels();
                break;

            default:
                return;
        }

        this.modified = true;
    }

    private static String getOtherNetworkInfo()
    {
        return getBoolOptionText("\u041f\u043e\u043a\u0430\u0437\u044b\u0432\u0430\u0442\u044c \u043f\u0438\u043d\u0433", PvpOptions.otherNetworkInfo);
    }

    private static String getShowModels()
    {
        return getBoolOptionText("\u041c\u043e\u0434\u0435\u043b\u044c\u043a\u0438 \u043d\u0430 \u0434\u0440\u0443\u0433\u0438\u0445 \u0438\u0433\u0440\u043e\u043a\u0430\u0445", PvpOptions.showModels);
    }
}
