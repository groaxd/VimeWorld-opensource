package net.xtrafrancyz.mods.texteria.elements;

import net.xtrafrancyz.util.ByteMap;

public class RadialProgressTimer extends RadialProgressBar
{
    private long timerDuration;

    public RadialProgressTimer(ByteMap params)
    {
        super(params);
        this.timerDuration = this.finishTime - this.startTime;
    }

    public void render(long time)
    {
        this.progress = 1.0F - (float)(time - this.startTime) / (float)this.timerDuration;

        if (this.progress < 0.0F)
        {
            this.progress = 0.0F;
        }

        super.render(time);
    }
}
