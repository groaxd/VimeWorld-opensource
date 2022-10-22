package net.xtrafrancyz.mods.texteria.gui;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.xtrafrancyz.mods.texteria.Texteria;
import net.xtrafrancyz.mods.texteria.elements.Element2D;
import net.xtrafrancyz.mods.texteria.elements.container.Element2DWrapper;
import net.xtrafrancyz.mods.texteria.elements.container.IContainer;
import net.xtrafrancyz.mods.texteria.elements.container.IWrapper2DContainer;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class TexteriaGui implements IContainer, IWrapper2DContainer
{
    public static int mouseX;
    public static int mouseY;
    public static ScaledResolution scaledResolution;
    private static int screenWidth;
    private static int screenHeight;
    private final Minecraft mc;
    public final Map<GuiRenderLayer, List<GuiElementWrapper>> elements;
    public final Map<String, GuiElementWrapper> byId;
    private final List<GuiElementWrapper> persistentElements;
    public int visibleElementsCount;
    private int visibleElementsCountThisFrame;
    public String[] currentTooltip = null;

    public TexteriaGui(Minecraft mc)
    {
        this.mc = mc;
        this.elements = new EnumMap(GuiRenderLayer.class);

        for (GuiRenderLayer guirenderlayer : GuiRenderLayer.values())
        {
            this.elements.put(guirenderlayer, new CopyOnWriteArrayList());
        }

        this.persistentElements = new CopyOnWriteArrayList();
        this.byId = new HashMap();
    }

    public void addElement(GuiElementWrapper c)
    {
        this.removeElement(c.element.id);
        this.byId.put(c.element.id, c);
        ((List)this.elements.get(c.visibility.layer)).add(c);
    }

    private void addPersistentElement(GuiElementWrapper c)
    {
        this.byId.put(c.element.id, c);
        this.persistentElements.add(c);
    }

    public void onResourceManagerReload()
    {
        this.elements.values().forEach((list) ->
        {
            list.forEach((w) -> {
                w.element.reload();
            });
        });
        this.persistentElements.forEach((w) ->
        {
            w.element.reload();
        });
    }

    public Element2D getElement(String id)
    {
        GuiElementWrapper guielementwrapper = (GuiElementWrapper)this.byId.get(id);
        return guielementwrapper == null ? null : guielementwrapper.element;
    }

    public Element2DWrapper getElementWrapper(String id)
    {
        return (Element2DWrapper)this.byId.get(id);
    }

    public void removeElement(String id)
    {
        Iterator iterator = this.elements.values().iterator();

        while (iterator.hasNext())
        {
            for (GuiElementWrapper guielementwrapper : (List)iterator.next())
            {
                if (guielementwrapper.element.id.equals(id))
                {
                    guielementwrapper.element.remove();
                }
            }
        }
    }

    public float getWidth()
    {
        return (float)screenWidth;
    }

    public float getHeight()
    {
        return (float)screenHeight;
    }

    private void removePersistentElement(String id)
    {
        if (this.byId.remove(id) != null)
        {
            this.persistentElements.removeIf((w) ->
            {
                return w.element.id.equals(id);
            });
        }
    }

    public void removeGroup(String group)
    {
        Iterator iterator = this.elements.values().iterator();

        while (iterator.hasNext())
        {
            for (GuiElementWrapper guielementwrapper : (List)iterator.next())
            {
                if (guielementwrapper.element.id.startsWith(group))
                {
                    guielementwrapper.element.remove();
                }
            }
        }
    }

    public void clear()
    {
        Iterator iterator = this.elements.values().iterator();

        while (iterator.hasNext())
        {
            for (GuiElementWrapper guielementwrapper : (List)iterator.next())
            {
                guielementwrapper.element.remove();
            }
        }
    }

    public void clearNow()
    {
        for (List<GuiElementWrapper> list : this.elements.values())
        {
            for (GuiElementWrapper guielementwrapper : list)
            {
                guielementwrapper.element.dispose();
                this.byId.remove(guielementwrapper.element.id);
            }

            list.clear();
        }
    }

    public void render(GuiRenderLayer layer)
    {
        if (!this.mc.gameSettings.hideGUI)
        {
            if (layer == GuiRenderLayer.HUD)
            {
                this.beforeAnyRender();
            }
            else if (layer == GuiRenderLayer.SCREEN && this.mc.theWorld == null)
            {
                return;
            }

            this.mc.theWorld.theProfiler.startSection("TexteriaGui");
            GlStateManager.disableRescaleNormal();
            GlStateManager.alphaFunc(516, 0.01F);
            GlStateManager.disableDepth();
            GlStateManager.disableLighting();
            boolean boolean = GL11.glIsEnabled(GL11.GL_CULL_FACE);

            if (boolean)
            {
                GlStateManager.disableCull();
            }

            long long = Texteria.time = System.currentTimeMillis();
            List<GuiElementWrapper> list = (List)this.elements.get(layer);

            for (GuiElementWrapper guielementwrapper : list)
            {
                this.renderElement(guielementwrapper, long);

                if (guielementwrapper.element.finishTime < long)
                {
                    this.byId.remove(guielementwrapper.element.id, guielementwrapper);
                    list.remove(guielementwrapper);
                    guielementwrapper.element.dispose();
                }
            }

            if (!this.persistentElements.isEmpty())
            {
                for (GuiElementWrapper guielementwrapper1 : this.persistentElements)
                {
                    if (guielementwrapper1.visibility.layer == layer)
                    {
                        this.renderElement(guielementwrapper1, long);

                        if (guielementwrapper1.element.finishTime < long)
                        {
                            this.byId.remove(guielementwrapper1.element.id, guielementwrapper1);
                            this.persistentElements.remove(guielementwrapper1);
                            guielementwrapper1.element.dispose();
                        }
                    }
                }
            }

            if (layer == GuiRenderLayer.SCREEN)
            {
                this.afterAllRender();
            }

            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.enableRescaleNormal();

            if (layer != GuiRenderLayer.BEFORE_TOOLTIP)
            {
                GlStateManager.disableBlend();
                GlStateManager.enableDepth();
            }

            if (boolean)
            {
                GlStateManager.enableCull();
            }

            this.mc.theWorld.theProfiler.endSection();
        }
    }

    private void renderElement(GuiElementWrapper e, long time)
    {
        e.checkHover(this.mc, time);

        if (e.isVisible(this.mc))
        {
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            ++this.visibleElementsCount;

            try
            {
                e.render(time);
            }
            catch (Exception exception)
            {
                Texteria.log.error((String)("GuiElement render error (" + e + ")"), (Throwable)exception);
            }
        }
    }

    private void beforeAnyRender()
    {
        this.currentTooltip = null;
        mouseX = Mouse.getX();
        mouseY = Mouse.getY();
        scaledResolution = new ScaledResolution(this.mc);
        screenWidth = scaledResolution.getScaledWidth();
        screenHeight = scaledResolution.getScaledHeight();
        mouseX = mouseX * screenWidth / this.mc.displayWidth;
        mouseY = screenHeight - mouseY * screenHeight / this.mc.displayHeight - 1;
        this.visibleElementsCount = this.visibleElementsCountThisFrame;
        this.visibleElementsCountThisFrame = 0;
    }

    private void afterAllRender()
    {
        if (this.currentTooltip != null && this.mc.currentScreen != null)
        {
            this.mc.currentScreen.drawHoveringText(Arrays.<String>asList(this.currentTooltip), mouseX, mouseY);
        }
    }
}
