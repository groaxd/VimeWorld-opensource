package net.xtrafrancyz.mods.discord;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import net.minecraft.client.Minecraft;
import net.xtrafrancyz.covered.Reflect;
import net.xtrafrancyz.mods.discord.lib.DiscordEventHandlers;
import net.xtrafrancyz.mods.discord.lib.DiscordRPC;
import net.xtrafrancyz.mods.discord.lib.callbacks.ReadyCallback;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DiscordMod
{
    private static final String APP_ID = "423155716178706433";
    public static final DiscordMod instance = new DiscordMod();
    public static final Logger log = LogManager.getLogger("Discord");
    private boolean ready = false;
    private RPGenerator generator;
    private ScheduledExecutorService executor;
    private AtomicBoolean stopped = new AtomicBoolean(true);

    public void init(Minecraft mc)
    {
        String handler = mc.mcDataDir.getName();
        byte b0 = -1;

        switch (handler.hashCode())
        {
            case -1383668912:
                if (handler.equals("civcraft"))
                {
                    b0 = 1;
                }

                break;

            case 812788938:
                if (handler.equals("minigames"))
                {
                    b0 = 0;
                }
        }

        switch (b0)
        {
            case 0:
                this.generator = new RPMiniGames();
                break;

            case 1:
                this.generator = new RPCivCraft();
                break;

            default:
                return;
        }

        this.stopped.set(false);

        try
        {
            DiscordEventHandlers discordeventhandlers = new DiscordEventHandlers();
            discordeventhandlers.ready = (user) ->
            {
                log.info("Discord RPC is ready!");
                this.ready = true;
            };
            DiscordRPC.discordInitialize("423155716178706433", discordeventhandlers, true);
        }
        catch (Exception exception)
        {
            log.warn((String)"Coudn\'t setup Discord RPC", (Throwable)exception);
            return;
        }

        this.executor = Executors.newSingleThreadScheduledExecutor((r) ->
        {
            return new Thread(r, "Discord RPC");
        });
        this.executor.scheduleWithFixedDelay(DiscordRPC::discordRunCallbacks, 0L, 1L, TimeUnit.SECONDS);
        this.executor.scheduleWithFixedDelay(() ->
        {
            if (this.ready)
            {
                try
                {
                    Charset charset = Charset.defaultCharset();
                    Reflect.set((Class)Charset.class, "defaultCharset", StandardCharsets.UTF_8);
                    DiscordRPC.discordUpdatePresence(this.generator.generate());
                    Reflect.set((Class)Charset.class, "defaultCharset", charset);
                }
                catch (Exception exception)
                {
                    log.warn((String)"Coudn\'t update Discord status", (Throwable)exception);
                }
            }
        }, 1L, 1L, TimeUnit.SECONDS);
        Runtime.getRuntime().addShutdownHook(new Thread(this::stop, "Discord RPC Finalizer"));
    }

    public void stop()
    {
        if (this.stopped.compareAndSet(false, true))
        {
            try
            {
                log.info("Disabling Discord RPC");
                this.executor.shutdownNow();
                DiscordRPC.discordShutdown();
            }
            catch (Throwable throwable)
            {
                log.log(Level.WARN, "Could not stop Discord RPC", throwable);
            }
        }
    }
}
