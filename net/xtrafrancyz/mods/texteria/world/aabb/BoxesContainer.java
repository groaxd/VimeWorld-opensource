package net.xtrafrancyz.mods.texteria.world.aabb;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import net.minecraft.util.AxisAlignedBB;
import org.khelekore.prtree.MBR;
import org.khelekore.prtree.MBRConverter;
import org.khelekore.prtree.PRTree;
import org.khelekore.prtree.SimpleMBR;

public class BoxesContainer
{
    private final int MIN_BOXES_IN_INDEX = 30;
    private final int INDEX_BRUNCHING_FACTOR = 9;
    private final MBRConverter<BoundingBox> CONVERTER = new BoundingBoxMBRConverter();
    public Set<BoundingBox> boxes = Collections.<BoundingBox>newSetFromMap(new LinkedHashMap());
    public Set<BoundingBox> dynamic = Collections.<BoundingBox>newSetFromMap(new LinkedHashMap());
    public PRTree<BoundingBox> index;
    private boolean indexDirty = false;
    private final Set<BoundingBox> staticAddedLastTick = new HashSet();

    public void clear()
    {
        this.boxes.clear();
        this.dynamic.clear();
        this.indexDirty = false;
        this.staticAddedLastTick.clear();
        this.index = null;
    }

    public void rebuildIndex()
    {
        if (!this.indexDirty && !this.staticAddedLastTick.isEmpty())
        {
            this.indexDirty = true;
            this.staticAddedLastTick.clear();
        }

        if (this.indexDirty)
        {
            this.indexDirty = false;

            if (this.boxes.size() - this.dynamic.size() < 30)
            {
                this.index = null;
            }
            else
            {
                this.index = new PRTree(this.CONVERTER, 9);
                this.index.load(Collections2.filter(this.boxes, (box) ->
                {
                    return !this.dynamic.contains(box);
                }));
            }
        }
    }

    public void add(BoundingBox box)
    {
        this.boxes.add(box);
        this.staticAddedLastTick.add(box);
    }

    public void remove(BoundingBox box)
    {
        this.boxes.remove(box);
        this.staticAddedLastTick.remove(box);

        if (box.isDynamic())
        {
            this.dynamic.remove(box);
        }
        else
        {
            this.indexDirty = true;
        }
    }

    public void updateBoxIndex(BoundingBox box)
    {
        if (box.isDynamic() && this.dynamic.add(box) && !this.staticAddedLastTick.remove(box))
        {
            this.indexDirty = true;
        }
    }

    public void getCollisionBoxes(AxisAlignedBB bb, Collection<BoundingBox> result)
    {
        if (this.index != null)
        {
            MBR mbr = new SimpleMBR(new double[] {bb.minX, bb.maxX, bb.minY, bb.maxY, bb.minZ, bb.maxZ});

            for (BoundingBox boundingbox : this.index.find(mbr))
            {
                result.add(boundingbox);
            }

            for (BoundingBox boundingbox2 : this.dynamic)
            {
                if (boundingbox2.bb.intersectsWith(bb))
                {
                    result.add(boundingbox2);
                }
            }
        }
        else
        {
            for (BoundingBox boundingbox1 : this.boxes)
            {
                if (boundingbox1.bb.intersectsWith(bb))
                {
                    result.add(boundingbox1);
                }
            }
        }
    }

    public void getCollisionAABB(AxisAlignedBB bb, List<AxisAlignedBB> result)
    {
        if (this.index != null)
        {
            MBR mbr = new SimpleMBR(new double[] {bb.minX, bb.maxX, bb.minY, bb.maxY, bb.minZ, bb.maxZ});

            for (BoundingBox boundingbox : this.index.find(mbr))
            {
                result.add(boundingbox.bb);
            }

            for (BoundingBox boundingbox2 : this.dynamic)
            {
                if (boundingbox2.bb.intersectsWith(bb))
                {
                    result.add(boundingbox2.bb);
                }
            }
        }
        else
        {
            for (BoundingBox boundingbox1 : this.boxes)
            {
                if (boundingbox1.bb.intersectsWith(bb))
                {
                    result.add(boundingbox1.bb);
                }
            }
        }
    }
}
