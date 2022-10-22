package net.xtrafrancyz.mods.texteria.elements;

import net.xtrafrancyz.util.ByteMap;

public class TextStopwatch extends TextWithTime
{
    public TextStopwatch(ByteMap params)
    {
        super(params);
    }

    public void render(long time)
    {
        this.replaceText(time - this.startTime);
        super.render(time);
    }
}
