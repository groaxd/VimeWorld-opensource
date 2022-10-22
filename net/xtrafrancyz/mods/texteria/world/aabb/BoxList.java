package net.xtrafrancyz.mods.texteria.world.aabb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.xtrafrancyz.util.ByteMap;

public class BoxList
{
    private final Map<String, BoundingBox> boxes = new HashMap();
    private final PlayerBoxesContainer playerBoxes = new PlayerBoxesContainer();
    private final EntityBoxesContainer entityBoxes = new EntityBoxesContainer();
    private int tickingCount;

    public void clearNow()
    {
        this.boxes.clear();
        this.playerBoxes.clear();
        this.entityBoxes.clear();
    }

    public void add(String id, BoundingBox box)
    {
        this.remove(id);
        this.boxes.put(id, box);
        this.playerBoxes.add(box);

        if (!box.affectOnlyPlayers)
        {
            this.entityBoxes.add(box);
        }
    }

    public void remove(String id)
    {
        List<BoundingBox> list = null;

        if (id.endsWith("*"))
        {
            id = id.substring(0, id.length() - 1);
            Iterator<Entry<String, BoundingBox>> iterator = this.boxes.entrySet().iterator();

            while (iterator.hasNext())
            {
                Entry<String, BoundingBox> entry = (Entry)iterator.next();

                if (((String)entry.getKey()).startsWith(id))
                {
                    iterator.remove();

                    if (list == null)
                    {
                        list = new ArrayList();
                    }

                    list.add(entry.getValue());
                }
            }
        }
        else
        {
            BoundingBox boundingbox = (BoundingBox)this.boxes.remove(id);

            if (boundingbox != null)
            {
                list = Collections.<BoundingBox>singletonList(boundingbox);
            }
        }

        if (list != null)
        {
            for (BoundingBox boundingbox1 : list)
            {
                this.playerBoxes.remove(boundingbox1);

                if (!boundingbox1.affectOnlyPlayers)
                {
                    this.entityBoxes.remove(boundingbox1);
                }
            }
        }
    }

    public void edit(String id, ByteMap map)
    {
        BoundingBox boundingbox = (BoundingBox)this.boxes.get(id);

        if (boundingbox != null)
        {
            boundingbox.edit(map);
            this.playerBoxes.updateBoxIndex(boundingbox);

            if (!boundingbox.affectOnlyPlayers)
            {
                this.entityBoxes.updateBoxIndex(boundingbox);
            }
        }
    }

    public int count()
    {
        return this.boxes.size();
    }

    public int dynamicCount()
    {
        return this.playerBoxes.dynamic.size();
    }

    public int tickingCount()
    {
        return this.tickingCount;
    }

    public void tick()
    {
        this.playerBoxes.rebuildIndex();
        this.entityBoxes.rebuildIndex();

        if (Minecraft.getMinecraft().thePlayer != null)
        {
            Set<BoundingBox> set = this.playerBoxes.getPlayersTicking(this.entityBoxes.ticking.size());
            set.addAll(this.entityBoxes.ticking);
            this.tickingCount = set.size();

            for (BoundingBox boundingbox : set)
            {
                boundingbox.tick();

                if (!boundingbox.affectOnlyPlayers)
                {
                    this.entityBoxes.updateBoxIndex(boundingbox);
                }
            }
        }
    }

    public void getCollisionBoxes(Entity entity, AxisAlignedBB bb, List<AxisAlignedBB> result)
    {
        BoxesContainer boxescontainer = (BoxesContainer)(entity instanceof EntityPlayerSP ? this.playerBoxes : this.entityBoxes);
        boxescontainer.getCollisionAABB(bb, result);
    }

    public void playerJump(EntityPlayerSP player)
    {
        AxisAlignedBB axisalignedbb = player.getEntityBoundingBox().offset(0.0D, -0.02D, 0.0D);
        List<BoundingBox> list = new ArrayList();
        this.playerBoxes.getCollisionBoxes(axisalignedbb, list);
        Iterator iterator = list.iterator();

        if (iterator.hasNext())
        {
            BoundingBox boundingbox = (BoundingBox)iterator.next();

            if (boundingbox.isMoving())
            {
                player.motionX += boundingbox.moveOffsetX / (double)boundingbox.moveTicks;
                player.motionY += boundingbox.moveOffsetY / (double)boundingbox.moveTicks;
                player.motionZ += boundingbox.moveOffsetZ / (double)boundingbox.moveTicks;
            }

            if (boundingbox.impelType == BoundingBox.ImpelType.MOVE && boundingbox.hasImpel())
            {
                player.motionX += (double)boundingbox.impelX;
                player.motionY += (double)boundingbox.impelY;
                player.motionZ += (double)boundingbox.impelZ;
            }
        }
    }

    public void render(Frustum frustum)
    {
        if (!this.boxes.isEmpty())
        {
            GlStateManager.disableTexture2D();
            GlStateManager.color(1.0F, 0.0F, 1.0F, 1.0F);
            renderBoxes(frustum, this.playerBoxes.boxes);
            GlStateManager.color(1.0F, 0.0F, 1.0F, 0.0F);
            renderBoxes(frustum, this.entityBoxes.boxes);
            GlStateManager.enableTexture2D();
        }
    }

    private static void renderBoxes(Frustum frustum, Collection<BoundingBox> boxes)
    {
        for (BoundingBox boundingbox : boxes)
        {
            if (frustum.isBoundingBoxInFrustum(boundingbox.bb))
            {
                RenderGlobal.func_181561_a(boundingbox.bb.offset(-TileEntityRendererDispatcher.staticPlayerX, -TileEntityRendererDispatcher.staticPlayerY, -TileEntityRendererDispatcher.staticPlayerZ));
            }
        }
    }
}
