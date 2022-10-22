package net.xtrafrancyz.covered;

import java.security.SecureRandom;
import java.util.Arrays;

public class SecurityHax
{
    private static SecureRandom random;

    public static synchronized SecureRandom getRandom()
    {
        if (random == null)
        {
            byte[] abyte = new byte[6];
            Class<?> oclass = Reflect.findClass("sun.security.provider.SeedGenerator$ThreadedSeedGenerator");
            Object object = Reflect.construct(oclass, new Object[0]);
            Reflect.invoke(object, "getSeedBytes", new Object[] {abyte});

            if (Arrays.equals(abyte, new byte[abyte.length]))
            {
                abyte = SecureRandom.getSeed(20);
            }

            random = new SecureRandom(abyte);
        }

        return random;
    }
}
