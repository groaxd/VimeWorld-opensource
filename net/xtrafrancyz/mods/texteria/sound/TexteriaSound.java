package net.xtrafrancyz.mods.texteria.sound;

import java.io.File;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.SoundEventAccessor;
import net.minecraft.client.audio.SoundEventAccessorComposite;
import net.minecraft.client.audio.SoundPoolEntry;
import net.minecraft.client.resources.SimpleReloadableResourceManager;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.VimeStorage;
import net.xtrafrancyz.mods.texteria.Texteria;
import net.xtrafrancyz.mods.texteria.resources.TexteriaResource;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;

public class TexteriaSound
{
    static final String RESOURCE_DOMAIN = "texteria-sound";
    private final Minecraft mc;
    private final Map<String, TSound> trackedSounds = new HashMap();

    public TexteriaSound(Minecraft mc)
    {
        this.mc = mc;
    }

    public void clear()
    {
        for (Entry<String, TSound> entry : this.trackedSounds.entrySet())
        {
            this.mc.getSoundHandler().stopSound((ISound)entry.getValue());
        }

        this.trackedSounds.clear();
    }

    public void play(TSound sound)
    {
        if (sound.path.startsWith("#"))
        {
            TexteriaResource texteriaresource = Texteria.instance.resourceManager.getResource(sound.path.substring(1));

            if (texteriaresource != null && texteriaresource.getEntry().isDone())
            {
                sound.path = "file:" + texteriaresource.getRelativePath() + ".ogg";
                this.realPlay(sound);
                return;
            }
        }

        if (!sound.path.startsWith("https://") && !sound.path.startsWith("http://") && !sound.path.startsWith("#"))
        {
            this.realPlay(sound);
        }
        else
        {
            (new TexteriaSound.LoaderThread(sound)).start();
        }
    }

    public void stop(String id)
    {
        if (id.endsWith("*"))
        {
            id = id.substring(0, id.length() - 1);
            Iterator<Entry<String, TSound>> iterator = this.trackedSounds.entrySet().iterator();

            while (iterator.hasNext())
            {
                Entry<String, TSound> entry = (Entry)iterator.next();

                if (((String)entry.getKey()).startsWith(id))
                {
                    this.mc.getSoundHandler().stopSound((ISound)entry.getValue());
                    iterator.remove();
                }
            }
        }
        else
        {
            ISound isound = (ISound)this.trackedSounds.remove(id);

            if (isound != null)
            {
                this.mc.getSoundHandler().stopSound(isound);
            }
        }
    }

    public void onResourceManagerReload()
    {
        SimpleReloadableResourceManager simplereloadableresourcemanager = (SimpleReloadableResourceManager)this.mc.getResourceManager();
        simplereloadableresourcemanager.domainResourceManagers.put("texteria-sound", new TSoundResourceManager(this));
    }

    public File getLocalFile(ResourceLocation location)
    {
        String s = location.getResourcePath();

        if (s.startsWith("file:"))
        {
            s = s.substring(5);

            if (s.startsWith("texteria/cache/resource/") && s.endsWith(".ogg"))
            {
                s = s.substring(0, s.length() - 4);
            }
        }

        return new File(this.mc.mcDataDir, s);
    }

    private void realPlay(TSound sound)
    {
        ResourceLocation resourcelocation = sound.getSoundLocation();
        SoundEventAccessorComposite soundeventaccessorcomposite = new SoundEventAccessorComposite(resourcelocation, 1.0D, 1.0D, sound.category);
        soundeventaccessorcomposite.addSoundToEventPool(new SoundEventAccessor(new SoundPoolEntry(resourcelocation, 1.0D, 1.0D, sound.streaming), 1));
        this.mc.getSoundHandler().sndRegistry.registerSound(soundeventaccessorcomposite);

        if (sound.id != null)
        {
            ISound isound = (ISound)this.trackedSounds.put(sound.id, sound);

            if (isound != null)
            {
                this.mc.getSoundHandler().stopSound(isound);
            }
        }
        else if (sound.repeat)
        {
            this.trackedSounds.put(UUID.randomUUID().toString(), sound);
        }

        this.mc.getSoundHandler().playSound(sound);
    }

    private class LoaderThread extends Thread
    {
        TSound request;

        LoaderThread(TSound request)
        {
            super("Sound loader");
            this.setDaemon(true);
            this.request = request;
        }

        public void run()
        {
            if (this.request.path.startsWith("#"))
            {
                TexteriaResource texteriaresource = Texteria.instance.resourceManager.getResource(this.request.path.substring(1));
                texteriaresource.getEntry().join();
                this.request.path = "file:" + texteriaresource.getRelativePath() + ".ogg";
                TexteriaSound.this.mc.addScheduledTask(() ->
                {
                    TexteriaSound.this.realPlay(this.request);
                });
            }
            else
            {
                HttpURLConnection httpurlconnection = null;

                try
                {
                    String s = DigestUtils.md5Hex(this.request.path.getBytes());
                    VimeStorage.Entry vimestorage$entry = Texteria.instance.storage.getEntry("sound/" + s + ".ogg");

                    if (vimestorage$entry.exists())
                    {
                        Texteria.log.info("Loaded sound \'" + this.request.path + "\' from cache");
                    }
                    else
                    {
                        String s2 = this.request.path;
                        label212:

                        for (int i = 0; i < 3; ++i)
                        {
                            httpurlconnection = (HttpURLConnection)(new URL(s2)).openConnection();
                            httpurlconnection.setConnectTimeout(15000);
                            httpurlconnection.setRequestProperty("Accept-Charset", "UTF-8");

                            switch (httpurlconnection.getResponseCode())
                            {
                                case 301:
                                case 302:
                                    s2 = (new URL(new URL(s2), httpurlconnection.getHeaderField("Location"))).toExternalForm();
                                    httpurlconnection.disconnect();
                                    break;

                                default:
                                    break label212;
                            }
                        }

                        try
                        {
                            OutputStream outputstream = vimestorage$entry.getOutputStream();
                            Throwable throwable = null;

                            try
                            {
                                IOUtils.copy(httpurlconnection.getInputStream(), outputstream);
                            }
                            catch (Throwable throwable2)
                            {
                                throwable = throwable2;
                                throw throwable2;
                            }
                            finally
                            {
                                if (outputstream != null)
                                {
                                    if (throwable != null)
                                    {
                                        try
                                        {
                                            outputstream.close();
                                        }
                                        catch (Throwable throwable1)
                                        {
                                            throwable.addSuppressed(throwable1);
                                        }
                                    }
                                    else
                                    {
                                        outputstream.close();
                                    }
                                }
                            }
                        }
                        catch (Exception exception)
                        {
                            vimestorage$entry.delete();
                            throw exception;
                        }

                        vimestorage$entry.save(2592000);
                        Texteria.log.info("Loaded sound \'" + this.request.path + "\'");
                    }

                    this.request.path = "file:texteria/cache/sound/" + s + ".ogg";
                    TexteriaSound.this.mc.addScheduledTask(() ->
                    {
                        TexteriaSound.this.realPlay(this.request);
                    });
                }
                catch (Exception exception1)
                {
                    String s1 = this.request.path;

                    if (s1.startsWith("file:"))
                    {
                        s1 = (new File(TexteriaSound.this.mc.mcDataDir, s1.substring(5))).getAbsolutePath();
                    }

                    Texteria.log.warn((String)("Loading sound \'" + s1 + "\'."), (Throwable)exception1);
                }
                finally
                {
                    if (httpurlconnection != null)
                    {
                        httpurlconnection.disconnect();
                    }
                }
            }
        }
    }
}
