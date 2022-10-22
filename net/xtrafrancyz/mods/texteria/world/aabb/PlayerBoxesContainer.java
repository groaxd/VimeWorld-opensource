package net.xtrafrancyz.mods.texteria.world.aabb;

import java.util.HashSet;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.util.AxisAlignedBB;

public class PlayerBoxesContainer extends BoxesContainer
{
    public Set<BoundingBox> getPlayersTicking(int expandSize)
    {
        Set<BoundingBox> set = new HashSet(this.dynamic.size() + 5 + expandSize, 1.0F);
        AxisAlignedBB axisalignedbb = Minecraft.getMinecraft().thePlayer.getEntityBoundingBox().expand(0.02D, 0.02D, 0.02D);
        this.getCollisionBoxes(axisalignedbb, set);
        set.addAll(this.dynamic);
        return set;
    }
}
