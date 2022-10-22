package net.xtrafrancyz.mods.texteria.elements;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import net.xtrafrancyz.mods.texteria.Texteria;
import net.xtrafrancyz.util.ByteMap;

public class TextClock extends Text
{
    private final SimpleDateFormat format;
    private final long offsetMs;
    private final boolean fixedWidth;
    private final boolean useCache;
    private long currentDateGenerated;

    public TextClock(ByteMap params)
    {
        super(fixTextParam(params));

        if (this.text[0].equals(""))
        {
            this.format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            this.useCache = false;
        }
        else
        {
            this.format = new SimpleDateFormat(this.text[0]);
            this.useCache = !this.text[0].contains("S");
        }

        this.format.setTimeZone(TimeZone.getTimeZone(params.getString("tz", TimeZone.getDefault().getID())));
        this.offsetMs = Texteria.time - params.getLong("st", Texteria.time);
        this.fixedWidth = params.containsKey("width");
    }

    private static ByteMap fixTextParam(ByteMap params)
    {
        if (params.containsKey("text"))
        {
            String[] astring = params.getStringArray("text");

            if (astring.length == 1)
            {
                return params;
            }
        }

        params.put("text", new String[] {""});
        return params;
    }

    public void init()
    {
        this.currentDateGenerated = Texteria.time;
        this.text[0] = this.format.format(new Date(Texteria.time - this.offsetMs));
        super.init();
    }

    public void updateClock()
    {
        if (!this.useCache || Texteria.time - this.currentDateGenerated >= 1000L)
        {
            this.currentDateGenerated = Texteria.time;
            this.text[0] = this.format.format(new Date(Texteria.time - this.offsetMs));

            if (!this.fixedWidth)
            {
                this.update();
            }
        }
    }

    public void render(long time)
    {
        this.updateClock();
        super.render(time);
    }
}
