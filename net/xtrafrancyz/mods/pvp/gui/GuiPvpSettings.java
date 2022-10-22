package net.xtrafrancyz.mods.pvp.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class GuiPvpSettings extends GuiPvPScreen
{
    private static final int BTN_EFFECTS = 1;
    private static final int BTN_ARMOR_STATUS = 2;
    private static final int BTN_KEYSTROKES = 3;
    private static final int BTN_OTHER = 4;

    public GuiPvpSettings(GuiScreen parent)
    {
        super(parent, "\u041d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 VimeWorld");
    }

    protected void onInit()
    {
        this.addButton(1, "\u042d\u0444\u0444\u0435\u043a\u0442\u044b \u0437\u0435\u043b\u0438\u0439");
        this.addButton(2, "Armor Status HUD");
        this.addButton(3, "Keystrokes");
        this.addButton(4, "\u041f\u0440\u043e\u0447\u0435\u0435");
    }

    protected void onButtonAction(GuiButton button)
    {
        switch (button.id)
        {
            case 1:
                this.mc.displayGuiScreen(new GuiEffectSettings(this));
                break;

            case 2:
                this.mc.displayGuiScreen(new GuiArmorStatusSettings(this));
                break;

            case 3:
                this.mc.displayGuiScreen(new GuiKeystrokesSettings(this));
                break;

            case 4:
                this.mc.displayGuiScreen(new GuiOtherSettings(this));
        }
    }
}
