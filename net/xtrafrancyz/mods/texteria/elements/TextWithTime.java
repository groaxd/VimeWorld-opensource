package net.xtrafrancyz.mods.texteria.elements;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.xtrafrancyz.util.ByteMap;

public class TextWithTime extends Text
{
    private static final Pattern REPLACE_PATTERN = Pattern.compile("\\{([^}]{1,2})}");
    protected String[] original;
    protected boolean fixedWidth;

    public TextWithTime(ByteMap params)
    {
        super(params);
        this.original = (String[])Arrays.copyOf(this.text, this.text.length);
        this.fixedWidth = params.containsKey("width");
    }

    protected void replaceText(long diff)
    {
        int i = (int)(diff % 1000L);
        int j = (int)((diff = diff / 1000L) % 60L);
        int k = (int)((diff = diff / 60L) % 60L);
        int l = (int)((diff = diff / 60L) % 24L);
        int i1 = (int)(diff = diff / 24L);

        for (int j1 = 0; j1 < this.original.length; ++j1)
        {
            Matcher matcher = REPLACE_PATTERN.matcher(this.original[j1]);
            StringBuffer stringbuffer = new StringBuffer();

            while (matcher.find())
            {
                String s = matcher.group(1);
                byte b0 = -1;

                switch (s.hashCode())
                {
                    case 68:
                        if (s.equals("D"))
                        {
                            b0 = 0;
                        }

                        break;

                    case 72:
                        if (s.equals("H"))
                        {
                            b0 = 2;
                        }

                        break;

                    case 77:
                        if (s.equals("M"))
                        {
                            b0 = 4;
                        }

                        break;

                    case 83:
                        if (s.equals("S"))
                        {
                            b0 = 7;
                        }

                        break;

                    case 109:
                        if (s.equals("m"))
                        {
                            b0 = 10;
                        }

                        break;

                    case 2176:
                        if (s.equals("DD"))
                        {
                            b0 = 1;
                        }

                        break;

                    case 2304:
                        if (s.equals("HH"))
                        {
                            b0 = 3;
                        }

                        break;

                    case 2464:
                        if (s.equals("MM"))
                        {
                            b0 = 5;
                        }

                        break;

                    case 2656:
                        if (s.equals("SS"))
                        {
                            b0 = 8;
                        }

                        break;

                    case 3488:
                        if (s.equals("mm"))
                        {
                            b0 = 11;
                        }

                        break;

                    case 1064901855:
                        if (s.equals("minutes"))
                        {
                            b0 = 6;
                        }

                        break;

                    case 1970096767:
                        if (s.equals("seconds"))
                        {
                            b0 = 9;
                        }
                }

                switch (b0)
                {
                    case 0:
                    case 1:
                        matcher.appendReplacement(stringbuffer, "" + i1);
                        break;

                    case 2:
                        matcher.appendReplacement(stringbuffer, "" + l);
                        break;

                    case 3:
                        matcher.appendReplacement(stringbuffer, toString(l, 2));
                        break;

                    case 4:
                        matcher.appendReplacement(stringbuffer, "" + k);
                        break;

                    case 5:
                        matcher.appendReplacement(stringbuffer, toString(k, 2));
                        break;

                    case 6:
                        matcher.appendReplacement(stringbuffer, "" + diff / 1000L / 60L);
                        break;

                    case 7:
                        matcher.appendReplacement(stringbuffer, "" + j);
                        break;

                    case 8:
                        matcher.appendReplacement(stringbuffer, toString(j, 2));
                        break;

                    case 9:
                        matcher.appendReplacement(stringbuffer, "" + diff / 1000L);
                        break;

                    case 10:
                        if (i < 100)
                        {
                            matcher.appendReplacement(stringbuffer, "0");
                        }
                        else
                        {
                            matcher.appendReplacement(stringbuffer, toString(i, 1));
                        }

                        break;

                    case 11:
                        matcher.appendReplacement(stringbuffer, toString(i, 2));
                }
            }

            matcher.appendTail(stringbuffer);
            this.text[j1] = stringbuffer.toString();
        }

        if (!this.fixedWidth)
        {
            super.update();
        }
    }

    public void edit(ByteMap data)
    {
        super.edit(data);

        if (data.containsKey(".text"))
        {
            this.original = (String[])Arrays.copyOf(this.text, this.text.length);
        }
    }

    private static String toString(int num, int needed)
    {
        String s;

        for (s = num + ""; s.length() < needed; s = "0" + s)
        {
            ;
        }

        if (s.length() > needed)
        {
            s = s.substring(0, needed);
        }

        return s;
    }
}
