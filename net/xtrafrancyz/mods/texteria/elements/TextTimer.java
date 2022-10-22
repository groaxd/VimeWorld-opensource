package net.xtrafrancyz.mods.texteria.elements;

import net.xtrafrancyz.mods.texteria.Texteria;
import net.xtrafrancyz.util.ByteMap;

public class TextTimer extends TextWithTime
{
    protected long timerTo;
    protected boolean customTime = false;

    public TextTimer(ByteMap params)
    {
        super(params);
        long i = Texteria.time;

        if (params.containsKey("millis"))
        {
            this.customTime = true;
            this.timerTo = i + params.getLong("millis");
        }

        this.replaceText(Math.max(0L, this.getTimerTo() - i));
    }

    public void edit(ByteMap data)
    {
        if (data.containsKey(".millis"))
        {
            this.customTime = true;
            this.timerTo = Texteria.time + data.getLong(".millis");
        }

        super.edit(data);
    }

    private long getTimerTo()
    {
        return this.customTime ? this.timerTo : this.finishTime;
    }

    public void render(long time)
    {
        this.replaceText(Math.max(0L, this.getTimerTo() - time));
        super.render(time);
    }
}
