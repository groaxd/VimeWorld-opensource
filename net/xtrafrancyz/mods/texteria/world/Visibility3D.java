package net.xtrafrancyz.mods.texteria.world;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.xtrafrancyz.mods.texteria.world.elements.Element3D;
import net.xtrafrancyz.util.ByteMap;
import org.lwjgl.input.Keyboard;

public class Visibility3D
{
    public static final Visibility3D DEFAULT = new Visibility3D(new Visibility3D.Selector[] {(new Visibility3D.AlwaysSelector()).setShow(true)});
    public final Visibility3D.Selector[] selectors;

    public Visibility3D(ByteMap[] maps)
    {
        List<Visibility3D.Selector> list = new ArrayList(maps.length);

        for (ByteMap bytemap : maps)
        {
            Visibility3D.Selector visibility3d$selector = null;
            String s = bytemap.getString("type");
            byte b0 = -1;

            switch (s.hashCode())
            {
                case -1414557169:
                    if (s.equals("always"))
                    {
                        b0 = 0;
                    }

                    break;

                case 503739367:
                    if (s.equals("keyboard"))
                    {
                        b0 = 1;
                    }

                    break;

                case 1541691859:
                    if (s.equals("debugbb"))
                    {
                        b0 = 2;
                    }
            }

            switch (b0)
            {
                case 0:
                    visibility3d$selector = new Visibility3D.AlwaysSelector();
                    break;

                case 1:
                    visibility3d$selector = new Visibility3D.KeyboardSelector(bytemap.getInt("key"));
                    break;

                case 2:
                    visibility3d$selector = new Visibility3D.DebugBBSelector();
                    break;

                default:
                    throw new IllegalArgumentException("");
            }

            visibility3d$selector.show = bytemap.getBoolean("show");
            list.add(visibility3d$selector);
        }

        this.selectors = (Visibility3D.Selector[])list.toArray(new Visibility3D.Selector[0]);
    }

    public Visibility3D(Visibility3D.Selector... selectors)
    {
        this.selectors = selectors;
    }

    public static class AlwaysSelector extends Visibility3D.Selector
    {
        public boolean acceptable(Minecraft mc, Element3D element)
        {
            return true;
        }
    }

    public static class DebugBBSelector extends Visibility3D.Selector
    {
        public boolean acceptable(Minecraft mc, Element3D element)
        {
            return mc.getRenderManager().isDebugBoundingBox();
        }
    }

    public static class KeyboardSelector extends Visibility3D.Selector
    {
        private final int key;

        public KeyboardSelector(int key)
        {
            this.key = key;
        }

        public boolean acceptable(Minecraft mc, Element3D element)
        {
            return Keyboard.isKeyDown(this.key);
        }
    }

    public abstract static class Selector
    {
        public boolean show;

        public abstract boolean acceptable(Minecraft var1, Element3D var2);

        public Visibility3D.Selector setShow(boolean value)
        {
            this.show = value;
            return this;
        }
    }
}
