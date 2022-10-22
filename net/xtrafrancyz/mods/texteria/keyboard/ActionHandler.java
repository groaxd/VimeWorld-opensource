package net.xtrafrancyz.mods.texteria.keyboard;

import java.util.ArrayList;
import java.util.List;
import net.xtrafrancyz.mods.texteria.Texteria;
import net.xtrafrancyz.mods.texteria.gui.TexteriaGui;
import net.xtrafrancyz.util.ByteMap;
import org.lwjgl.input.Keyboard;

class ActionHandler implements KeyboardHandler
{
    private static final int DOUBLECLICK_DURATION_MS = 300;
    private final int key;
    private final boolean cancel;
    private final boolean keydown;
    private final boolean keyup;
    private final boolean doubleclick;
    private final int[] modifiers;
    private final int actionTimeout;
    private final List<Runnable> actions = new ArrayList();
    private long lastClick = 0L;
    private long lastActionTime = 0L;
    private boolean pressed;

    public ActionHandler(int key, ByteMap params)
    {
        this.key = key;
        this.cancel = params.getBoolean("cancel", false);
        this.keydown = params.getBoolean("kd", true);
        this.keyup = params.getBoolean("ku", false);
        this.doubleclick = params.getBoolean("double", false);
        this.modifiers = params.getIntArray("mods");
        this.actionTimeout = params.getInt("timeout", 0);

        for (ByteMap bytemap : params.getMapArray("actions"))
        {
            String s = bytemap.getString("%", "");
            byte b0 = -1;

            switch (s.hashCode())
            {
                case -861614187:
                    if (s.equals("unbind_self"))
                    {
                        b0 = 2;
                    }

                    break;

                case -840745386:
                    if (s.equals("unbind"))
                    {
                        b0 = 1;
                    }

                    break;

                case -172220347:
                    if (s.equals("callback"))
                    {
                        b0 = 0;
                    }

                    break;

                case 1098897152:
                    if (s.equals("remove_gui"))
                    {
                        b0 = 3;
                    }
            }

            switch (b0)
            {
                case 0:
                    this.actions.add(new ActionHandler.CallbackAction(bytemap));
                    break;

                case 1:
                    this.actions.add(new ActionHandler.UnbindAction(bytemap));
                    break;

                case 2:
                    this.actions.add(new ActionHandler.UnbindSelfAction());
                    break;

                case 3:
                    this.actions.add(new ActionHandler.RemoveGuiAction(bytemap));
            }
        }
    }

    public boolean onStateChanged(boolean pressed)
    {
        if (pressed && !this.keydown)
        {
            return false;
        }
        else if (!pressed && !this.keyup)
        {
            return false;
        }
        else
        {
            if (this.modifiers != null)
            {
                for (int i : this.modifiers)
                {
                    if (!Keyboard.isKeyDown(i))
                    {
                        return false;
                    }
                }
            }

            if (this.doubleclick)
            {
                long j = System.currentTimeMillis();
                long l = j - this.lastClick;
                this.lastClick = j;

                if (l > 300L)
                {
                    return false;
                }
            }

            if (this.actionTimeout > 0)
            {
                long k = System.currentTimeMillis();

                if (k - this.lastActionTime < (long)this.actionTimeout)
                {
                    return false;
                }

                this.lastActionTime = k;
            }

            this.pressed = pressed;

            for (Runnable runnable : this.actions)
            {
                runnable.run();
            }

            return this.cancel;
        }
    }

    private class CallbackAction implements Runnable
    {
        private final ByteMap data;

        public CallbackAction(ByteMap data)
        {
            this.data = data.getMap("data");
        }

        public void run()
        {
            this.data.put("_pressed", Boolean.valueOf(ActionHandler.this.pressed));
            Texteria.sendCallbackPacket(this.data);
        }
    }

    private static class RemoveGuiAction implements Runnable
    {
        private final String id;

        public RemoveGuiAction(ByteMap params)
        {
            this.id = params.getString("id");
        }

        public void run()
        {
            TexteriaGui texteriagui = Texteria.instance.gui;

            if (this.id.endsWith("*"))
            {
                texteriagui.removeGroup(this.id.substring(0, this.id.length() - 1));
            }
            else
            {
                texteriagui.removeElement(this.id);
            }
        }
    }

    private static class UnbindAction implements Runnable
    {
        private final int key;
        private final String id;

        public UnbindAction(ByteMap params)
        {
            this.key = params.getInt("key");
            this.id = params.getString("id");
        }

        public void run()
        {
            Texteria.instance.keyboard.remove(this.key, this.id);
        }
    }

    private class UnbindSelfAction implements Runnable
    {
        private UnbindSelfAction()
        {
        }

        public void run()
        {
            Texteria.instance.keyboard.remove(ActionHandler.this.key, (KeyboardHandler)ActionHandler.this);
        }
    }
}
