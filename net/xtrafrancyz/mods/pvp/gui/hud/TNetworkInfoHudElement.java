package net.xtrafrancyz.mods.pvp.gui.hud;

import net.minecraft.client.Minecraft;
import net.xtrafrancyz.mods.pvp.PvPMod;
import net.xtrafrancyz.mods.pvp.PvpOptions;
import net.xtrafrancyz.mods.texteria.Texteria;
import net.xtrafrancyz.mods.texteria.elements.Element2D;
import net.xtrafrancyz.mods.texteria.gui.GuiElementWrapper;
import net.xtrafrancyz.mods.texteria.gui.GuiRenderLayer;
import net.xtrafrancyz.mods.texteria.gui.Visibility;
import net.xtrafrancyz.mods.texteria.util.Position;
import net.xtrafrancyz.util.ByteMap;

public class TNetworkInfoHudElement extends Element2D
{
    public static final String TID = "##TNetworkInfoHud";
    public static final GuiElementWrapper WRAPPER;
    private final Minecraft mc = Minecraft.getMinecraft();
    private String text;
    private float width;

    public TNetworkInfoHudElement()
    {
        super("##TNetworkInfoHud");
        this.x.set(2.0F);
        this.y.set(2.0F);
        this.pos = Position.TOP_RIGHT;
    }

    public float getWidth()
    {
        return this.width;
    }

    public float getHeight()
    {
        return (float)this.mc.fontRendererObj.FONT_HEIGHT;
    }

    public void edit(ByteMap data)
    {
    }

    public boolean preRender(long time)
    {
        if (!super.preRender(time))
        {
            return false;
        }
        else
        {
            if (this.mc.thePlayer != null && this.mc.thePlayer.getPlayerInfo() != null)
            {
                this.text = "FPS: " + Minecraft.getDebugFPS() + " / \u041f\u0438\u043d\u0433: " + this.mc.thePlayer.getPlayerInfo().getResponseTime();
            }
            else
            {
                this.text = "FPS: " + Minecraft.getDebugFPS();
            }

            this.width = this.mc.fontRendererObj.getStringWidthFloat(this.text);
            return true;
        }
    }

    public void render(long time)
    {
        this.mc.fontRendererObj.drawStringWithShadow(this.text, 0.0F, 0.0F, 16777215);
    }

    public static void applyOptions()
    {
        PvpOptions.selector.update(Position.TOP_RIGHT);
        PvPMod.addOrRemove(WRAPPER, PvpOptions.otherNetworkInfo);
    }

    static
    {
        WRAPPER = new GuiElementWrapper(new TNetworkInfoHudElement(), new Visibility(GuiRenderLayer.HUD, new Visibility.Selector[] {(new Visibility.AlwaysSelector()).setShow(true), (new Visibility.F3Selector()).setShow(false)}), Texteria.instance.gui);
    }
}
