package net.xtrafrancyz;

import java.util.HashMap;
import java.util.function.Predicate;
import net.minecraft.client.Minecraft;
import net.minecraft.util.BlockPos;

public class LightUpdateGuard
{
    private final HashMap<BlockPos, LightUpdateGuard.Entry> blocks = new HashMap();
    private final BlockPos.MutableBlockPos tempPos = new BlockPos.MutableBlockPos();
    public boolean batch;
    private int iterationsThisBatch;
    private int currentX;
    private int currentY;
    private int currentZ;
    private LightUpdateGuard.Entry currentEntry;
    public boolean enabled;

    public void tick()
    {
        int i = getTick();

        if (i % 600 == 0)
        {
            int j = i - 600;
            this.blocks.values().removeIf((entry) ->
            {
                return entry.lastTriggered < ttl;
            });
        }
    }

    public boolean startBatch(int x, int y, int z)
    {
        this.iterationsThisBatch = 0;
        boolean boolean = this.startUpdate(this.tempPos.func_181079_c(x, y, z));

        if (boolean)
        {
            this.batch = true;
        }

        return boolean;
    }

    public void endBatch()
    {
        this.batch = false;

        if (this.iterationsThisBatch >= 20000)
        {
            this.endUpdate(this.iterationsThisBatch);
        }
    }

    public boolean startUpdate(BlockPos pos)
    {
        if (!this.enabled)
        {
            return true;
        }
        else if (this.batch)
        {
            return true;
        }
        else
        {
            this.currentEntry = null;
            LightUpdateGuard.Entry lightupdateguard$entry = (LightUpdateGuard.Entry)this.blocks.get(pos);

            if (lightupdateguard$entry != null)
            {
                int int = getTick();
                int int = int - lightupdateguard$entry.lastTriggered;

                if (lightupdateguard$entry.banCyka && int < 600)
                {
                    lightupdateguard$entry.lastTriggered = int;
                    return false;
                }

                if (int > 600)
                {
                    this.blocks.remove(pos);
                }
                else
                {
                    this.currentEntry = lightupdateguard$entry;
                }
            }

            this.currentX = pos.getX();
            this.currentY = pos.getY();
            this.currentZ = pos.getZ();
            return true;
        }
    }

    public void endUpdate(int iterations)
    {
        if (this.batch)
        {
            this.iterationsThisBatch += iterations;
        }
        else if (this.enabled)
        {
            if (iterations > 2000)
            {
                if (this.currentEntry == null)
                {
                    this.blocks.put(new BlockPos(this.currentX, this.currentY, this.currentZ), new LightUpdateGuard.Entry());
                }
                else
                {
                    int int;

                    if ((int = getTick()) - this.currentEntry.lastTriggered < 200)
                    {
                        this.currentEntry.numTriggered++;
                        this.currentEntry.lastTriggered = int;
                        int int = 4;

                        if (iterations > 20000)
                        {
                            int = 3;
                        }

                        if (this.currentEntry.numTriggered >= int)
                        {
                            this.currentEntry.banCyka = true;
                        }
                    }
                }
            }
        }
    }

    private static int getTick()
    {
        return Minecraft.getMinecraft().globalTickCounter.get();
    }

    public static class Entry
    {
        private boolean banCyka;
        private int lastTriggered = LightUpdateGuard.getTick();
        private int numTriggered = 1;

        public String toString()
        {
            return "{trigs=" + this.numTriggered + ",ban=" + this.banCyka + "}";
        }
    }
}
