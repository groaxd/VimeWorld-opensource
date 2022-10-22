package net.xtrafrancyz.mods.pvp.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.xtrafrancyz.mods.pvp.PvpOptions;
import net.xtrafrancyz.mods.pvp.gui.hud.TKeystrokesHudElement;

public class GuiKeystrokesSettings extends GuiPvPScreen
{
    private static final int BTN_KEY_STATUS = 1;
    private static final int BTN_KEY_POSITION = 2;
    private static final int BTN_KEY_MOVEMENT_BUTTONS = 3;
    private static final int BTN_KEY_MOUSE_BUTTONS = 4;
    private static final int BTN_KEY_SNEAK_BUTTON = 5;
    private static final int BTN_KEY_JUMP_BUTTON = 6;
    private static final int SCT_KEY_TEXT_COLOR = 7;
    private static final int BTN_KEY_TEXT_BOLD = 8;
    private static final int BTN_KEY_TEXT_RAINBOW = 9;
    private static final int BTN_KEY_TEXT_SHADOW = 10;

    public GuiKeystrokesSettings(GuiScreen parent)
    {
        super(parent, "Keystrokes");
    }

    protected void onInit()
    {
        this.addButton(1, getKeyStatus());
        this.addButton(2, getPositionText(TKeystrokesHudElement.WRAPPER));
        this.addButton(3, getKeyMovementButtons());
        this.addButton(4, getKeyMouseButtons());
        this.addButton(5, getKeySneakButton());
        this.addButton(6, getKeyJumpButton(), 3);
        this.addSection(7, PvpOptions.keyTextColor);
        this.addButton(8, getKeyTextBold(), 2);
        this.addButton(9, getTextAnimation(PvpOptions.keyTextAnimation), 2);
        this.addButton(10, getTextShadow());
        this.updateButtons();
    }

    protected void onButtonAction(GuiButton button)
    {
        switch (button.id)
        {
            case 1:
                PvpOptions.keyStatus = (PvpOptions.keyStatus + 1) % 3;
                button.displayString = getKeyStatus();
                this.updateButtons();
                TKeystrokesHudElement.applyOptions();
                break;

            case 2:
                PvpOptions.selector.move(TKeystrokesHudElement.WRAPPER);
                button.displayString = getPositionText(TKeystrokesHudElement.WRAPPER);
                break;

            case 3:
                PvpOptions.keyMovementButtons = !PvpOptions.keyMovementButtons;
                button.displayString = getKeyMovementButtons();
                break;

            case 4:
                PvpOptions.keyMouseButtons = !PvpOptions.keyMouseButtons;
                button.displayString = getKeyMouseButtons();
                break;

            case 5:
                PvpOptions.keySneakButton = !PvpOptions.keySneakButton;
                button.displayString = getKeySneakButton();
                break;

            case 6:
                PvpOptions.keyJumpButton = !PvpOptions.keyJumpButton;
                button.displayString = getKeyJumpButton();
                break;

            case 7:
                GuiPvPScreen.GuiColorButton guipvpscreen$guicolorbutton = (GuiPvPScreen.GuiColorButton)button;
                PvpOptions.keyTextColor = guipvpscreen$guicolorbutton.section.color;
                break;

            case 8:
                PvpOptions.keyTextBold = !PvpOptions.keyTextBold;
                button.displayString = getKeyTextBold();
                break;

            case 9:
                PvpOptions.keyTextAnimation = (PvpOptions.keyTextAnimation + 1) % 3;
                button.displayString = getTextAnimation(PvpOptions.keyTextAnimation);
                this.updateButtons();
                break;

            case 10:
                PvpOptions.keyTextShadow = !PvpOptions.keyTextShadow;
                button.displayString = getTextShadow();
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
                if (PvpOptions.keyStatus == 0)
                {
                    setEnabled(guibutton, false);
                }
                else if (PvpOptions.keyTextAnimation != 0 && guibutton.id == 7)
                {
                    setEnabled(guibutton, false);
                }
                else
                {
                    setEnabled(guibutton, true);
                }
            }
        }
    }

    private static String getKeyStatus()
    {
        String s = null;

        switch (PvpOptions.keyStatus)
        {
            case 0:
                s = "\u0412\u042b\u041a\u041b";
                break;

            case 1:
                s = "\u041c\u0430\u043b\u0435\u043d\u044c\u043a\u0438\u0439";
                break;

            case 2:
                s = "\u0411\u043e\u043b\u044c\u0448\u043e\u0439";
        }

        return "Keystrokes: " + s;
    }

    private static String getKeyMovementButtons()
    {
        return getBoolOptionText("\u041a\u043d\u043e\u043f\u043a\u0438 \u0434\u0432\u0438\u0436\u0435\u043d\u0438\u044f", PvpOptions.keyMovementButtons);
    }

    private static String getKeyMouseButtons()
    {
        return getBoolOptionText("\u041a\u043d\u043e\u043f\u043a\u0438 \u043c\u044b\u0448\u0438", PvpOptions.keyMouseButtons);
    }

    private static String getKeySneakButton()
    {
        return getBoolOptionText("\u041a\u043d\u043e\u043f\u043a\u0430 \u043a\u0440\u0430\u0441\u0442\u044c\u0441\u044f", PvpOptions.keySneakButton);
    }

    private static String getKeyJumpButton()
    {
        return getBoolOptionText("\u041a\u043d\u043e\u043f\u043a\u0430 \u043f\u0440\u044b\u0436\u043a\u0430", PvpOptions.keyJumpButton);
    }

    private static String getKeyTextBold()
    {
        return getBoolOptionText("\u0416\u0438\u0440\u043d\u044b\u0439 \u0442\u0435\u043a\u0441\u0442", PvpOptions.keyTextBold);
    }

    private static String getTextShadow()
    {
        return getBoolOptionText("\u0422\u0435\u043d\u044c \u0443 \u0442\u0435\u043a\u0441\u0442\u0430", PvpOptions.keyTextShadow);
    }
}
