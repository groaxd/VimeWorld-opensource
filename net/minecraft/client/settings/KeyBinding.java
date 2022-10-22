package net.minecraft.client.settings;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Set;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.IntHashMap;
import net.xtrafrancyz.covered.ObfValue;

public class KeyBinding implements Comparable<KeyBinding>
{
    private static final List<KeyBinding> keybindArray = Lists.<KeyBinding>newArrayList();
    private static final IntHashMap<KeyBinding> hash = new IntHashMap();
    private static final Set<String> keybindSet = Sets.<String>newHashSet();
    private final String keyDescription;
    private final int keyCodeDefault;
    private final String keyCategory;
    private int keyCode;

    /** Is the key held down? */
    private ObfValue.WalkingBoolean pressed = new ObfValue.WalkingBoolean(false, 5);
    private int pressTime;
    private ArrayDeque<Long> pressedNanos = new ArrayDeque();
    private long pressedEventNanos;

    public static void onTick(int p_onTick_0_, long p_onTick_1_)
    {
        if (p_onTick_0_ != 0)
        {
            KeyBinding keybinding = (KeyBinding)hash.lookup(p_onTick_0_);

            if (keybinding != null)
            {
                ++keybinding.pressTime;
                keybinding.pressedNanos.add(Long.valueOf(p_onTick_1_));
            }
        }
    }

    public static void setKeyBindState(int keyCode, boolean pressed)
    {
        if (keyCode != 0)
        {
            KeyBinding keybinding = (KeyBinding)hash.lookup(keyCode);

            if (keybinding != null)
            {
                keybinding.pressed.set(pressed);
            }
        }
    }

    public static void unPressAllKeys()
    {
        for (KeyBinding keybinding : keybindArray)
        {
            keybinding.unpressKey();
        }
    }

    public static void resetKeyBindingArrayAndHash()
    {
        hash.clearMap();

        for (KeyBinding keybinding : keybindArray)
        {
            hash.addKey(keybinding.keyCode, keybinding);
        }
    }

    public static Set<String> getKeybinds()
    {
        return keybindSet;
    }

    public KeyBinding(String description, int keyCode, String category)
    {
        this.keyDescription = description;
        this.keyCode = keyCode;
        this.keyCodeDefault = keyCode;
        this.keyCategory = category;
        keybindArray.add(this);
        hash.addKey(keyCode, this);
        keybindSet.add(category);
    }

    /**
     * Returns true if the key is pressed (used for continuous querying). Should be used in tickers.
     */
    public boolean isKeyDown()
    {
        return this.pressed.get();
    }

    public String getKeyCategory()
    {
        return this.keyCategory;
    }

    /**
     * Returns true on the initial key press. For continuous querying use {@link isKeyDown()}. Should be used in key
     * events.
     */
    public boolean isPressed()
    {
        if (this.pressTime == 0)
        {
            this.pressedEventNanos = 0L;
            return false;
        }
        else
        {
            --this.pressTime;
            Long olong = (Long)this.pressedNanos.poll();

            if (olong != null)
            {
                this.pressedEventNanos = olong.longValue();
            }

            return true;
        }
    }

    private void unpressKey()
    {
        this.pressTime = 0;
        this.pressedNanos.clear();
        this.pressedEventNanos = 0L;
        this.pressed.set(false);
    }

    public long getPressedEventNanos()
    {
        return this.pressedEventNanos;
    }

    public String getKeyDescription()
    {
        return this.keyDescription;
    }

    public int getKeyCodeDefault()
    {
        return this.keyCodeDefault;
    }

    public int getKeyCode()
    {
        return this.keyCode;
    }

    public void setKeyCode(int keyCode)
    {
        this.keyCode = keyCode;
    }

    public int compareTo(KeyBinding p_compareTo_1_)
    {
        int i = I18n.format(this.keyCategory, new Object[0]).compareTo(I18n.format(p_compareTo_1_.keyCategory, new Object[0]));

        if (i == 0)
        {
            i = I18n.format(this.keyDescription, new Object[0]).compareTo(I18n.format(p_compareTo_1_.keyDescription, new Object[0]));
        }

        return i;
    }
}
