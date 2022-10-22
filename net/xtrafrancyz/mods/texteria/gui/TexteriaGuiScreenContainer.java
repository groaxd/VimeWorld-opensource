package net.xtrafrancyz.mods.texteria.gui;

import net.minecraft.client.Minecraft;
import net.xtrafrancyz.mods.texteria.Texteria;
import net.xtrafrancyz.mods.texteria.elements.Container;
import net.xtrafrancyz.mods.texteria.elements.Element2D;
import net.xtrafrancyz.mods.texteria.elements.container.Element2DWrapper;
import net.xtrafrancyz.mods.texteria.util.Fluidity;
import net.xtrafrancyz.mods.texteria.util.Position;
import net.xtrafrancyz.util.ByteMap;

public class TexteriaGuiScreenContainer extends Container
{
    public static final Visibility ALWAYS_SCREEN = new Visibility(GuiRenderLayer.SCREEN, new Visibility.Selector[] {(new Visibility.AlwaysSelector()).setShow(true)});
    public TexteriaGuiScreen screen;
    public GuiElementWrapper wrapper;

    public TexteriaGuiScreenContainer(ByteMap params)
    {
        super(params.getString("id"), -2.0F, -2.0F);
        this.setupScript(params.getString("script"));
        this.setupElements(params.getMapArray("e"));
        this.hoverable = true;
        this.pos = Position.TOP_LEFT;
    }

    public void load()
    {
        this.wrapper.visibility = new Visibility(GuiRenderLayer.SCREEN, new Visibility.Selector[] {(new Visibility.Selector()
        {
            public boolean acceptable(Minecraft mc, GuiElementWrapper wrapper)
            {
                if (mc.currentScreen == TexteriaGuiScreenContainer.this.screen)
                {
                    return true;
                }
                else
                {
                    TexteriaGuiScreenContainer.this.remove();
                    return false;
                }
            }
        }).setShow(true)
                                                                                                  });
    }

    public void remove()
    {
        if (this.finishTime > Texteria.time)
        {
            this.finishTime = Texteria.time;
        }
    }

    protected void addElement(Element2DWrapper el)
    {
        super.addElement(el);
        recursiveFixVisibility(el);
    }

    protected void editElement(Element2D el, ByteMap data)
    {
        super.editElement(el, data);
        recursiveFixVisibility(el);
    }

    public float getWidth()
    {
        return this.parent.getWidth();
    }

    public Fluidity getWidthFluidity()
    {
        return Fluidity.MATCH_PARENT;
    }

    public float getHeight()
    {
        return this.parent.getHeight();
    }

    public Fluidity getHeightFluidity()
    {
        return Fluidity.MATCH_PARENT;
    }

    private static void recursiveFixVisibility(Element2DWrapper wrapper)
    {
        if (wrapper instanceof GuiElementWrapper)
        {
            GuiElementWrapper guielementwrapper = (GuiElementWrapper)wrapper;

            if (guielementwrapper.visibility == Visibility.DEFAULT)
            {
                guielementwrapper.visibility = ALWAYS_SCREEN;
            }
        }

        if (wrapper.getElement2D() instanceof Container)
        {
            Container container = (Container)wrapper.getElement2D();

            for (Element2DWrapper element2dwrapper : container.getElementsWrapper())
            {
                recursiveFixVisibility(element2dwrapper);
            }
        }
    }
}
