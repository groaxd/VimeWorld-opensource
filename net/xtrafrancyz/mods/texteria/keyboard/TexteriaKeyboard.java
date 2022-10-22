package net.xtrafrancyz.mods.texteria.keyboard;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import net.xtrafrancyz.util.ByteMap;
import org.lwjgl.input.Keyboard;

public class TexteriaKeyboard
{
    private int idCounter = 0;
    private final Map<Integer, Map<String, KeyboardHandler>> keybinding = new HashMap();

    public void bind(int key, ByteMap params) throws Exception
    {
        Map<String, KeyboardHandler> map = (Map)this.keybinding.computeIfAbsent(Integer.valueOf(key), (k) ->
        {
            return new LinkedHashMap();
        });
        String s = params.getString("id");

        if (s == null)
        {
            s = "gen_" + this.idCounter++;
        }

        map.put(s, this.createHandler(key, params));
    }

    public void remove(int key, String id)
    {
        if (id == null)
        {
            this.keybinding.remove(Integer.valueOf(key));
        }
        else
        {
            Map<String, KeyboardHandler> map = (Map)this.keybinding.get(Integer.valueOf(key));

            if (map != null && map.containsKey(id))
            {
                if (map.size() == 1)
                {
                    this.keybinding.remove(Integer.valueOf(key));
                    return;
                }

                Map<String, KeyboardHandler> map1 = new HashMap(map);
                map1.remove(id);
                this.keybinding.put(Integer.valueOf(key), map1);
            }
        }
    }

    public void remove(int key, KeyboardHandler handler)
    {
        Map<String, KeyboardHandler> map = (Map)this.keybinding.get(Integer.valueOf(key));

        if (map != null)
        {
            Map<String, KeyboardHandler> map1 = new HashMap(map);
            map1.values().removeIf((handler1) ->
            {
                return handler1 == handler;
            });
            this.keybinding.put(Integer.valueOf(key), map1);

            if (map1.isEmpty())
            {
                this.keybinding.remove(Integer.valueOf(key));
            }
        }
    }

    public void clear()
    {
        this.keybinding.clear();
    }

    public boolean handleKeyboardEvent()
    {
        if (this.keybinding.isEmpty())
        {
            return false;
        }
        else
        {
            int int = Keyboard.getEventKey() == 0 ? Keyboard.getEventCharacter() + 256 : Keyboard.getEventKey();
            Map<String, KeyboardHandler> map = (Map)this.keybinding.get(Integer.valueOf(int));

            if (map != null)
            {
                boolean boolean = Keyboard.getEventKeyState();

                for (KeyboardHandler keyboardhandler : map.values())
                {
                    if (keyboardhandler.onStateChanged(boolean))
                    {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    private KeyboardHandler createHandler(int key, ByteMap params) throws Exception
    {
        String string = params.getString("type", "");
        byte byte = -1;

        switch (string.hashCode())
        {
            case -1422950858:
                if (string.equals("action"))
                {
                    byte = 1;
                }

                break;

            case -907685685:
                if (string.equals("script"))
                {
                    byte = 0;
                }
        }

        switch (byte)
        {
            case 0:
                return new ScriptHandler(key, params);

            case 1:
                return new ActionHandler(key, params);

            default:
                throw new IllegalArgumentException("No keyboard handler for \'" + params.getString("%") + "\'");
        }
    }
}
