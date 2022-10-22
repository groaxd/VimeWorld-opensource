package net.xtrafrancyz.util;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntFunction;

public class Parsers
{
    private static final Map<Character, IntFunction<Integer>> DURATION_UNITS = new HashMap();

    public static int parseDuration(String raw) throws IllegalArgumentException
    {
        raw = raw.trim();

        if (raw.isEmpty())
        {
            return 0;
        }
        else
        {
            int i = 0;
            int j = 0;
            boolean flag = false;

            for (char c0 : raw.toCharArray())
            {
                if (Character.isDigit(c0))
                {
                    if (flag)
                    {
                        j *= 10;
                    }

                    flag = true;
                    j += Character.getNumericValue(c0);
                }
                else
                {
                    IntFunction<Integer> intfunction = (IntFunction)DURATION_UNITS.get(Character.valueOf(c0));

                    if (!flag)
                    {
                        throw new IllegalArgumentException("Invalid duration");
                    }

                    if (intfunction == null)
                    {
                        throw new IllegalArgumentException("Unknown unit \'" + c0 + "\'");
                    }

                    i += ((Integer)intfunction.apply(j)).intValue();
                    j = 0;
                    flag = false;
                }
            }

            i = i + j;
            return i;
        }
    }

    static
    {
        DURATION_UNITS.put('q', (i) ->
        {
            return Integer.valueOf(i);
        });
        DURATION_UNITS.put('s', (i) ->
        {
            return Integer.valueOf(i * 1000);
        });
        DURATION_UNITS.put('m', (i) ->
        {
            return Integer.valueOf(i * 60 * 1000);
        });
        DURATION_UNITS.put('h', (i) ->
        {
            return Integer.valueOf(i * 60 * 60 * 1000);
        });
        DURATION_UNITS.put('d', (i) ->
        {
            return Integer.valueOf(i * 60 * 60 * 24 * 1000);
        });
        DURATION_UNITS.put('w', (i) ->
        {
            return Integer.valueOf(i * 60 * 60 * 24 * 7 * 1000);
        });
        DURATION_UNITS.put('y', (i) ->
        {
            return Integer.valueOf(i * 60 * 60 * 24 * 365 * 1000);
        });
    }
}
