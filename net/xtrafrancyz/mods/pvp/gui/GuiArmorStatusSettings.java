package net.xtrafrancyz.mods.pvp.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.xtrafrancyz.mods.pvp.PvpOptions;
import net.xtrafrancyz.mods.pvp.gui.hud.TArmorStatusHudElement;

public class GuiArmorStatusSettings extends GuiPvPScreen
{
    private static final int BTN_ARMOR_ENABLED = 1;
    private static final int BTN_ARMOR_POSITION = 2;
    private static final int BTN_ARMOR_DIRECTION = 3;
    private static final int BTN_ARMOR_DURABILITY_BAR = 4;
    private static final int SCT_ARMOR_TEXT_COLOR = 5;
    private static final int BTN_ARMOR_TEXT_TYPE = 6;
    private static final int BTN_ARMOR_ITEM_AMOUNT = 7;
    private static final int BTN_ARMOR_TEXT_RAINBOW = 8;
    private static final int BTN_ARMOR_TEXT_DIRECTION = 9;
    private GuiButton textDirectionButton;

    public GuiArmorStatusSettings(GuiScreen parent)
    {
        super(parent, "Armor Status HUD");
    }

    protected void onInit()
    {
        this.addButton(1, getArmorStatus());
        this.addButton(2, getPositionText(TArmorStatusHudElement.WRAPPER));
        this.addButton(3, getDirection());
        this.addButton(4, getDurabilityBar(), 3);
        this.addSection(5, PvpOptions.armorTextColor);
        this.addButton(6, getTextType(), 2);
        this.addButton(7, getItemAmount(), 2);
        this.addButton(8, getTextAnimation(PvpOptions.armorTextAnimation), 2);
        this.textDirectionButton = this.addButton(9, getTextDirection());
        this.updateButtons();
    }

    protected void onButtonAction(GuiButton button)
    {
        switch (button.id)
        {
            case 1:
                PvpOptions.armorStatus = (PvpOptions.armorStatus + 1) % 3;
                button.displayString = getArmorStatus();
                this.updateButtons();
                TArmorStatusHudElement.applyOptions();
                break;

            case 2:
                PvpOptions.selector.move(TArmorStatusHudElement.WRAPPER);
                button.displayString = getPositionText(TArmorStatusHudElement.WRAPPER);
                break;

            case 3:
                PvpOptions.armorDirection = !PvpOptions.armorDirection;
                button.displayString = getDirection();
                this.textDirectionButton.displayString = getTextDirection();
                break;

            case 4:
                PvpOptions.armorDurabilityBar = !PvpOptions.armorDurabilityBar;
                button.displayString = getDurabilityBar();
                break;

            case 5:
                GuiPvPScreen.GuiColorButton guipvpscreen$guicolorbutton = (GuiPvPScreen.GuiColorButton)button;
                PvpOptions.armorTextColor = guipvpscreen$guicolorbutton.section.color;
                break;

            case 6:
                PvpOptions.armorTextType = (PvpOptions.armorTextType + 1) % 3;
                button.displayString = getTextType();
                this.updateButtons();
                break;

            case 7:
                PvpOptions.armorItemAmount = !PvpOptions.armorItemAmount;
                button.displayString = getItemAmount();
                this.updateButtons();
                break;

            case 8:
                PvpOptions.armorTextAnimation = (PvpOptions.armorTextAnimation + 1) % 3;
                button.displayString = getTextAnimation(PvpOptions.armorTextAnimation);
                this.updateButtons();
                break;

            case 9:
                PvpOptions.armorTextDirection = !PvpOptions.armorTextDirection;
                button.displayString = getTextDirection();
                break;

            default:
                return;
        }

        this.modified = true;
    }

    private void updateButtons()
    {
        for (GuiButton guibutton : this.buttonList)
        {
            if (guibutton.id != 1 && guibutton.id != 200)
            {
                if (PvpOptions.armorStatus == 0)
                {
                    setEnabled(guibutton, false);
                }
                else if (PvpOptions.armorTextAnimation != 0 && guibutton.id == 5)
                {
                    setEnabled(guibutton, false);
                }
                else if (guibutton.id != 5 && guibutton.id != 8 && guibutton.id != 9)
                {
                    setEnabled(guibutton, true);
                }
                else
                {
                    setEnabled(guibutton, PvpOptions.armorTextType != 0 || PvpOptions.armorItemAmount);
                }
            }
        }
    }

    private static String getArmorStatus()
    {
        String s = null;

        switch (PvpOptions.armorStatus)
        {
            case 0:
                s = "\u0412\u042b\u041a\u041b";
                break;

            case 1:
                s = "\u0422\u043e\u043b\u044c\u043a\u043e \u0431\u0440\u043e\u043d\u044f";
                break;

            case 2:
                s = "\u0412\u0441\u0435";
        }

        return "Armor Status HUD: " + s;
    }

    private static String getDirection()
    {
        return "\u0420\u0430\u0441\u043f\u043e\u043b\u043e\u0436\u0435\u043d\u0438\u0435: " + (PvpOptions.armorDirection ? "\u0412\u0435\u0440\u0442\u0438\u043a\u0430\u043b\u044c\u043d\u043e" : "\u0413\u043e\u0440\u0438\u0437\u043e\u043d\u0442\u0430\u043b\u044c\u043d\u043e");
    }

    private static String getDurabilityBar()
    {
        return getBoolOptionText("\u0411\u0430\u0440 \u043f\u0440\u043e\u0447\u043d\u043e\u0441\u0442\u0438", PvpOptions.armorDurabilityBar);
    }

    private static String getItemAmount()
    {
        return getBoolOptionText("\u041a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u0430", PvpOptions.armorItemAmount);
    }

    private static String getTextType()
    {
        String s = null;

        switch (PvpOptions.armorTextType)
        {
            case 0:
                s = "\u0421\u043a\u0440\u044b\u0442";
                break;

            case 1:
                s = "\u0417\u043d\u0430\u0447\u0435\u043d\u0438\u0435";
                break;

            case 2:
                s = "\u041f\u0440\u043e\u0446\u0435\u043d\u0442";
        }

        return "\u0422\u0435\u043a\u0441\u0442: " + s;
    }

    private static String getTextDirection()
    {
        String s;

        if (PvpOptions.armorDirection)
        {
            s = PvpOptions.armorTextDirection ? "\u041b\u0435\u0432\u043e" : "\u041f\u0440\u0430\u0432\u043e";
        }
        else
        {
            s = PvpOptions.armorTextDirection ? "\u0412\u0435\u0440\u0445" : "\u041d\u0438\u0437";
        }

        return "\u0420\u0430\u0441\u043f\u043e\u043b\u043e\u0436\u0435\u043d\u0438\u0435 \u0442\u0435\u043a\u0441\u0442\u0430: " + s;
    }
}
