package net.xtrafrancyz.mods.minidot.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.xtrafrancyz.mods.minidot.MiniDot;

public abstract class ModalGui
{
    public MGuiMain parent;
    protected MiniDot md = MiniDot.instance;
    public static final int MODAL_WIDTH = 144;
    public static final int MODAL_HEIGHT = 144;
    public static final int MODAL_OFFSET_X = 99;
    public static final int MODAL_OFFSET_Y = 15;

    public void actionPerformed(GuiButton btn)
    {
    }

    public void updateScreen()
    {
    }

    public void onGuiClosed()
    {
    }

    public void initGui()
    {
    }

    protected abstract void onDraw(int var1, int var2);

    public final void draw(int mouseX, int mouseY)
    {
        int[] aint = this.translatePoint(mouseX, mouseY);
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)(this.parent.guiLeft + 99), (float)(this.parent.guiTop + 15), 0.0F);
        this.onDraw(aint[0], aint[1]);
        GlStateManager.popMatrix();
    }

    public void scroll(int delta)
    {
    }

    protected boolean onMouseClicked(int mouseX, int mouseY, int mouseButton)
    {
        return false;
    }

    public final boolean mouseClicked(int mouseX, int mouseY, int mouseButton)
    {
        int[] aint = this.translatePoint(mouseX, mouseY);
        return this.onMouseClicked(aint[0], aint[1], mouseButton);
    }

    public int[] translatePoint(int x, int y)
    {
        return new int[] {x - this.parent.guiLeft - 99, y - this.parent.guiTop - 15};
    }

    public final boolean isInTranslatedBounds(int x, int y)
    {
        return x > 0 && x < 144 && y > 0 && y < 144;
    }
}
