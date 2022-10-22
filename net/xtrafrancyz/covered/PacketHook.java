package net.xtrafrancyz.covered;

public class PacketHook
{
    public static void ensureInsideTick()
    {
        if (!HashGovna.isTick.get())
        {
            throw new RuntimeException("This call is outside of tick");
        }
    }
}
