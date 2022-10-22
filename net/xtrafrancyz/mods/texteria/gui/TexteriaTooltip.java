package net.xtrafrancyz.mods.texteria.gui;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import net.xtrafrancyz.mods.texteria.Texteria;
import net.xtrafrancyz.util.ByteMap;

public class TexteriaTooltip
{
    private static final Visibility DEFAULT_VISIBILITY = new Visibility(GuiRenderLayer.HUD, new Visibility.Selector[] {(new Visibility.AlwaysSelector()).setShow(true)});
    private static final LoadingCache<String, GuiElementWrapper> elementCache = CacheBuilder.newBuilder().expireAfterAccess(5L, TimeUnit.SECONDS).removalListener((elem) ->
    {
        if (elem.getValue() != null)
        {
            ((GuiElementWrapper)elem.getValue()).dispose();
        }
    }).<String, GuiElementWrapper>build(new CacheLoader<String, GuiElementWrapper>()
    {
        public GuiElementWrapper load(String spec) throws Exception
        {
            try
            {
                if (spec.startsWith("\u00a7f\u00a7o%txt%"))
                {
                    int i = spec.lastIndexOf("\u00a7r");

                    if (i == -1)
                    {
                        spec = spec.substring(9);
                    }
                    else
                    {
                        spec = spec.substring(9, i);
                    }
                }
                else
                {
                    int j = spec.endsWith("\u00a7r") ? spec.length() - 2 : spec.length();

                    if (spec.startsWith("\u00a77\u00a75\u00a7o%txt%"))
                    {
                        spec = spec.substring(11, j);
                    }
                    else
                    {
                        spec = spec.substring(5, j);
                    }
                }

                ByteMap bytemap1 = new ByteMap(Base64.getDecoder().decode(spec));
                DummyContainer dummycontainer1 = new DummyContainer();
                GuiElementWrapper guielementwrapper1 = new GuiElementWrapper(bytemap1, dummycontainer1);

                if (guielementwrapper1.visibility == Visibility.DEFAULT)
                {
                    guielementwrapper1.visibility = TexteriaTooltip.DEFAULT_VISIBILITY;
                }

                dummycontainer1.setChild(guielementwrapper1.element);
                return guielementwrapper1;
            }
            catch (Exception exception)
            {
                Texteria.log.error((String)"Could not build element in tooltip", (Throwable)exception);
                ByteMap bytemap = new ByteMap();
                bytemap.put("type", "Text");
                bytemap.put("text", new String[] {"\u00a7cTexteria Error"});
                DummyContainer dummycontainer = new DummyContainer();
                GuiElementWrapper guielementwrapper = new GuiElementWrapper(bytemap, dummycontainer);

                if (guielementwrapper.visibility == Visibility.DEFAULT)
                {
                    guielementwrapper.visibility = TexteriaTooltip.DEFAULT_VISIBILITY;
                }

                dummycontainer.setChild(guielementwrapper.element);
                return guielementwrapper;
            }
        }
    });
    public static Map<Integer, GuiElementWrapper> tempMap = new HashMap();

    public static GuiElementWrapper getTexteriaLine(String str)
    {
        if (str.startsWith("%txt%") || str.startsWith("\u00a77\u00a75\u00a7o%txt%") || str.startsWith("\u00a7f\u00a7o%txt%"))
        {
            try
            {
                return (GuiElementWrapper)elementCache.get(str);
            }
            catch (Exception exception)
            {
                Texteria.log.error((String)"Could not build element in tooltip", (Throwable)exception);
            }
        }

        return null;
    }
}
