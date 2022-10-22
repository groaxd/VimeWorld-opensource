package net.xtrafrancyz.mods.texteria.world.aabb;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

public class EntityBoxesContainer extends BoxesContainer
{
    public Set<BoundingBox> ticking = Collections.<BoundingBox>newSetFromMap(new LinkedHashMap());

    public void clear()
    {
        super.clear();
        this.ticking.clear();
    }

    public void add(BoundingBox box)
    {
        super.add(box);

        if (box.isTicking())
        {
            this.ticking.add(box);
        }
    }

    public void remove(BoundingBox box)
    {
        super.remove(box);

        if (box.isTicking())
        {
            this.ticking.remove(box);
        }
    }

    public void updateBoxIndex(BoundingBox box)
    {
        super.updateBoxIndex(box);

        if (box.isTicking())
        {
            this.ticking.add(box);
        }
        else
        {
            this.ticking.remove(box);
        }
    }
}
