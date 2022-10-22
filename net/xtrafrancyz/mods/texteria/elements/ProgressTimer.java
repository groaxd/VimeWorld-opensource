package net.xtrafrancyz.mods.texteria.elements;

import net.xtrafrancyz.util.ByteMap;

public class ProgressTimer extends ProgressBar
{
    private long timerDuration;
    private boolean reverse;

    public ProgressTimer(ByteMap params)
    {
        super(params);
        this.timerDuration = this.finishTime - this.startTime;
        this.reverse = params.getBoolean("reverse", false);
    }

    public void render(long time)
    {
        this.progress.render = 1.0F - (float)(time - this.startTime) / (float)this.timerDuration;

        if (this.progress.render < 0.0F)
        {
            this.progress.render = 0.0F;
        }

        if (this.reverse)
        {
            this.progress.render = 1.0F - this.progress.render;
        }

        super.render(time);
    }
}
