package net.xtrafrancyz.mods.texteria.world;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.xtrafrancyz.mods.texteria.world.elements.Element3D;

public class Element3DList
{
    private final Map<String, Element3D> map = new HashMap();
    private final Set<Element3D> set = new LinkedHashSet();
    private Element3D[] sortedVisible = new Element3D[0];
    private boolean changed;
    private long lastDistanceValidation;

    public void add(Element3D elem)
    {
        if (this.map.put(elem.id, elem) != null)
        {
            this.remove(elem.id);
        }

        this.set.add(elem);
        this.changed = true;
    }

    void remove0(Element3D elem)
    {
        this.map.remove(elem.id, elem);
        this.set.remove(elem);
        this.changed = true;
    }

    public void remove(String id)
    {
        for (Element3D element3d : this.set)
        {
            if (element3d.id.equals(id))
            {
                element3d.remove();
            }
        }
    }

    public void removeStartsWith(String str)
    {
        for (Element3D element3d : this.set)
        {
            if (element3d.id.startsWith(str))
            {
                element3d.remove();
            }
        }
    }

    public void clear()
    {
        for (Element3D element3d : this.set)
        {
            element3d.remove();
        }
    }

    public void clearNow()
    {
        for (Element3D element3d : this.set)
        {
            element3d.dispose();
        }

        this.set.clear();
        this.map.clear();
        this.sortedVisible = new Element3D[0];
    }

    public Element3D get(String id)
    {
        return (Element3D)this.map.get(id);
    }

    public boolean isEmpty()
    {
        return this.set.isEmpty();
    }

    public Element3D[] getSortedVisible(long time)
    {
        if (!this.changed && time - this.lastDistanceValidation <= 1000L)
        {
            for (Element3D element3d2 : this.sortedVisible)
            {
                element3d2.calcDistanceSquaredToPlayer();
            }
        }
        else
        {
            this.changed = false;
            this.lastDistanceValidation = time;
            List<Element3D> list = new ArrayList(Math.max(10, this.sortedVisible.length + 5));
            List<Element3D> list1 = new ArrayList();

            for (Element3D element3d : this.set)
            {
                element3d.calcDistanceSquaredToPlayer();

                if (element3d.distanceSquaredToPlayer < Math.max(element3d.renderDistanceSquared, 10000.0F))
                {
                    list.add(element3d);
                }
                else if (element3d.finishTime < time)
                {
                    list1.add(element3d);
                }
            }

            for (Element3D element3d1 : list1)
            {
                element3d1.dispose();
                this.remove0(element3d1);
            }

            this.sortedVisible = (Element3D[])list.toArray(new Element3D[0]);
        }

        Arrays.sort(this.sortedVisible, (e1, e2) ->
        {
            return Float.compare(e2.distanceSquaredToPlayer, e1.distanceSquaredToPlayer);
        });
        return this.sortedVisible;
    }

    public Element3D[] getCachedSortedVisible()
    {
        return this.sortedVisible;
    }

    public Collection<Element3D> getAll()
    {
        return this.set;
    }
}
