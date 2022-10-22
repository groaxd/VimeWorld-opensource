package net.xtrafrancyz.mods.pvp;

import java.util.EnumMap;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.xtrafrancyz.mods.pvp.gui.hud.TArmorStatusHudElement;
import net.xtrafrancyz.mods.pvp.gui.hud.TEffectHudElement;
import net.xtrafrancyz.mods.pvp.gui.hud.TKeystrokesHudElement;
import net.xtrafrancyz.mods.texteria.gui.GuiElementWrapper;
import net.xtrafrancyz.mods.texteria.gui.GuiRenderLayer;
import net.xtrafrancyz.mods.texteria.gui.Visibility;
import net.xtrafrancyz.mods.texteria.util.Position;

public class PvPSelector
{
    private static final Visibility LEFT_VISIBILITY = new Visibility(GuiRenderLayer.HUD, new Visibility.Selector[] {(new Visibility.AlwaysSelector()).setShow(true), (new Visibility.ChatSelector()).setShow(false), (new Visibility.F3Selector()).setShow(false)});
    private static final Visibility TOP_RIGHT_VISIBILITY = new Visibility(GuiRenderLayer.HUD, new Visibility.Selector[] {(new Visibility.AlwaysSelector()).setShow(true), (new Visibility.F3Selector()).setShow(false)});
    private static final Visibility BOTTOM_RIGHT_VISIBILITY = new Visibility(GuiRenderLayer.HUD, new Visibility.Selector[] {(new Visibility.AlwaysSelector()).setShow(true)});
    private Position lastPosition;
    private GuiElementWrapper lastWrapper;
    public final Map<Position, GuiElementWrapper> wrappers = new EnumMap(Position.class);

    public PvPSelector()
    {
        this.set(Position.LEFT, TKeystrokesHudElement.WRAPPER);
        this.set(Position.TOP_RIGHT, TEffectHudElement.WRAPPER);
        this.set(Position.BOTTOM_RIGHT, TArmorStatusHudElement.WRAPPER);
    }

    public void set(Position position, GuiElementWrapper wrapper)
    {
        wrapper.visibility = position == Position.LEFT ? LEFT_VISIBILITY : (position == Position.TOP_RIGHT ? TOP_RIGHT_VISIBILITY : BOTTOM_RIGHT_VISIBILITY);
        wrapper.element.pos = position;
        wrapper.element.y.set((float)((PvpOptions.otherNetworkInfo && position == Position.TOP_RIGHT ? Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT : 0) + 2));
        this.wrappers.put(position, wrapper);
    }

    public void update(Position position)
    {
        GuiElementWrapper guielementwrapper = (GuiElementWrapper)this.wrappers.get(position);

        if (guielementwrapper != null)
        {
            this.set(position, guielementwrapper);
        }
    }

    public void move(GuiElementWrapper wrapper)
    {
        Position position = wrapper.element.pos;

        if (this.lastWrapper == null || !this.lastWrapper.equals(wrapper))
        {
            this.lastPosition = position;
            this.lastWrapper = wrapper;
        }

        Position position1 = getNextPosition(position);

        if (this.lastPosition == position)
        {
            GuiElementWrapper guielementwrapper = (GuiElementWrapper)this.wrappers.get(position1);
            this.set(position, guielementwrapper);
        }
        else
        {
            GuiElementWrapper guielementwrapper2 = (GuiElementWrapper)this.wrappers.get(this.lastPosition);

            if (this.lastPosition != position1)
            {
                GuiElementWrapper guielementwrapper1 = (GuiElementWrapper)this.wrappers.get(position1);
                this.set(this.lastPosition, guielementwrapper1);
            }

            this.set(position, guielementwrapper2);
        }

        this.set(position1, wrapper);
    }

    private static Position getNextPosition(Position position)
    {
        switch (position)
        {
            case LEFT:
                return Position.TOP_RIGHT;

            case TOP_RIGHT:
                return Position.BOTTOM_RIGHT;

            case BOTTOM_RIGHT:
                return Position.LEFT;

            default:
                throw new IllegalArgumentException();
        }
    }
}
