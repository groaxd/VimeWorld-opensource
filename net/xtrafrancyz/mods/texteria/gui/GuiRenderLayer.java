package net.xtrafrancyz.mods.texteria.gui;

public enum GuiRenderLayer
{
    HUD,
    BEFORE_TOOLTIP,
    SCREEN;

    public static final GuiRenderLayer[] REVERSED_RENDER_ORDER = new GuiRenderLayer[]{SCREEN, BEFORE_TOOLTIP, HUD};
}
