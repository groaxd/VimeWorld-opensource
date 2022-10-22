package net.xtrafrancyz.mods.texteria.gui;

import java.io.IOException;
import net.minecraft.client.gui.GuiScreen;
import net.xtrafrancyz.mods.texteria.Texteria;
import net.xtrafrancyz.util.ByteMap;

public class TexteriaGuiScreen extends GuiScreen
{
    public final TexteriaGuiScreenContainer container;
    private final boolean defaultBackground;
    private final boolean closeOnEsc;
    private final boolean closeOnInventoryKey;
    private final ByteMap closeCallback;

    public TexteriaGuiScreen(ByteMap params, TexteriaGuiScreenContainer container)
    {
        this.container = container;
        this.defaultBackground = params.getBoolean("db", true);
        this.closeOnEsc = params.getBoolean("esc", true);
        this.closeOnInventoryKey = params.getBoolean("invkey", true);
        this.closeCallback = params.getMap("closecb");
    }

    /**
     * Adds the buttons (and other controls) to the screen in question. Called when the GUI is displayed and when the
     * window resizes, the buttonList is cleared beforehand.
     */
    public void initGui()
    {
    }

    /**
     * Fired when a key is typed (except F11 which toggles full screen). This is the equivalent of
     * KeyListener.keyTyped(KeyEvent e). Args : character (character on the key), keyCode (lwjgl Keyboard key code)
     */
    protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
        if (this.container.callScriptFunction("_keyTyped", new Object[] {Character.valueOf(typedChar), Integer.valueOf(keyCode)}) != Boolean.FALSE)
        {
            if (this.closeOnEsc && keyCode == 1 || this.closeOnInventoryKey && keyCode == this.mc.gameSettings.keyBindInventory.getKeyCode())
            {
                this.closeGui();
            }
        }
    }

    /**
     * Draws the screen and all the components in it. Args : mouseX, mouseY, renderPartialTicks
     */
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        if (this.defaultBackground)
        {
            this.drawDefaultBackground();
        }
    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        super.updateScreen();

        if (Texteria.instance.gui.getElement(this.container.id) != this.container)
        {
            this.closeGui();
        }
    }

    public void closeGui()
    {
        this.mc.displayGuiScreen((GuiScreen)null);

        if (this.mc.currentScreen == null)
        {
            this.mc.setIngameFocus();
        }
    }

    /**
     * Called when the screen is unloaded. Used to disable keyboard repeat events
     */
    public void onGuiClosed()
    {
        if (this.closeCallback != null)
        {
            Texteria.sendCallbackPacket(this.closeCallback);
        }
    }
}
