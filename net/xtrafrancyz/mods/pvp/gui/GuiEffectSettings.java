package net.xtrafrancyz.mods.pvp.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.xtrafrancyz.mods.pvp.PvpOptions;
import net.xtrafrancyz.mods.pvp.gui.hud.TEffectHudElement;

public class GuiEffectSettings extends GuiPvPScreen
{
    private static final int BTN_EFFECT_ENABLED = 1;
    private static final int BTN_EFFECT_POSITION = 2;
    private static final int BTN_EFFECT_SCALE = 3;
    private static final int SCT_EFFECT_TEXT_COLOR = 4;
    private static final int BTN_EFFECT_TEXT_SIZE = 5;
    private static final int BTN_EFFECT_TEXT_RAINBOW = 6;

    public GuiEffectSettings(GuiScreen parent)
    {
        super(parent, "\u042d\u0444\u0444\u0435\u043a\u0442\u044b \u0437\u0435\u043b\u0438\u0439");
    }

    protected void onInit()
    {
        this.addButton(1, getEffectEnabled());
        this.addButton(2, getPositionText(TEffectHudElement.WRAPPER));
        this.addButton(3, getEffectScaleText(), 4);
        this.addSection(4, PvpOptions.effectTextColor);
        this.addButton(5, getEffectTextSizeText(), 2);
        this.addButton(6, getTextAnimation(PvpOptions.effectTextAnimation));
        this.updateButtons();
    }

    protected void onButtonAction(GuiButton button)
    {
        switch (button.id)
        {
            case 1:
                PvpOptions.effectEnabled = !PvpOptions.effectEnabled;
                button.displayString = getEffectEnabled();
                this.updateButtons();
                TEffectHudElement.applyOptions();
                break;

            case 2:
                PvpOptions.selector.move(TEffectHudElement.WRAPPER);
                button.displayString = getPositionText(TEffectHudElement.WRAPPER);
                break;

            case 3:
                PvpOptions.effectScale = PvpOptions.effectScale == 1 ? 2 : 1;
                button.displayString = getEffectScaleText();
                TEffectHudElement.applyOptions();
                break;

            case 4:
                GuiPvPScreen.GuiColorButton guipvpscreen$guicolorbutton = (GuiPvPScreen.GuiColorButton)button;
                PvpOptions.effectTextColor = guipvpscreen$guicolorbutton.section.color;
                break;

            case 5:
                PvpOptions.effectTextSize = PvpOptions.effectTextSize == 1 ? 2 : 1;
                button.displayString = getEffectTextSizeText();
                break;

            case 6:
                PvpOptions.effectTextAnimation = (PvpOptions.effectTextAnimation + 1) % 3;
                button.displayString = getTextAnimation(PvpOptions.effectTextAnimation);
                this.updateButtons();
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
                if (!PvpOptions.effectEnabled)
                {
                    setEnabled(guibutton, false);
                }
                else if (PvpOptions.effectTextAnimation != 0 && guibutton.id == 4)
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

    private static String getEffectEnabled()
    {
        return getBoolOptionText("\u042d\u0444\u0444\u0435\u043a\u0442\u044b \u0437\u0435\u043b\u0438\u0439", PvpOptions.effectEnabled);
    }

    private static String getEffectTextSizeText()
    {
        return "\u0420\u0430\u0437\u043c\u0435\u0440 \u0442\u0435\u043a\u0441\u0442\u0430: " + (PvpOptions.effectTextSize == 1 ? "\u041c\u0430\u043b\u0435\u043d\u044c\u043a\u0438\u0439" : "\u0411\u043e\u043b\u044c\u0448\u043e\u0439");
    }

    private static String getEffectScaleText()
    {
        return "\u041c\u0430\u0441\u0448\u0442\u0430\u0431: " + (PvpOptions.effectScale == 1 ? "\u041c\u0430\u043b\u0435\u043d\u044c\u043a\u0438\u0439" : "\u0411\u043e\u043b\u044c\u0448\u043e\u0439");
    }
}
