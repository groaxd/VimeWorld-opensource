package net.xtrafrancyz.mods.texteria.elements;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.xtrafrancyz.mods.texteria.Texteria;
import net.xtrafrancyz.mods.texteria.elements.container.Element2DWrapper;
import net.xtrafrancyz.mods.texteria.elements.container.IContainer;
import net.xtrafrancyz.mods.texteria.elements.container.IWrapper2DContainer;
import net.xtrafrancyz.mods.texteria.gui.GuiElementWrapper;
import net.xtrafrancyz.mods.texteria.util.Fluidity;
import net.xtrafrancyz.mods.texteria.util.Point2F;
import net.xtrafrancyz.mods.texteria.util.Position;
import net.xtrafrancyz.mods.texteria.util.TRenderUtil;
import net.xtrafrancyz.mods.texteria.world.elements.WorldGroup;
import net.xtrafrancyz.util.ByteMap;
import org.apache.logging.log4j.Level;
import org.lwjgl.opengl.GL11;

public class Container extends Rectangle implements IContainer, IWrapper2DContainer
{
    private final Minecraft mc = Minecraft.getMinecraft();
    private final List<Element2DWrapper> elements = new CopyOnWriteArrayList();
    private final Map<String, Element2DWrapper> byId = new HashMap();
    private boolean overflow;
    private boolean lastHoverState;
    private boolean firstRenderPass = true;

    public Container(ByteMap params)
    {
        super(params, -1);
        this.overflow = params.getBoolean("ovf", true);

        if (!this.overflow && (this.heightFluidity != Fluidity.FIXED || this.widthFluidity != Fluidity.FIXED))
        {
            this.overflow = true;
        }

        this.setupElements(params.getMapArray("e"));
    }

    public Container(String id, float width, float height)
    {
        super(id, width, height);
    }

    protected void setupElements(ByteMap[] arr)
    {
        for (ByteMap bytemap : arr)
        {
            try
            {
                this.addElement(new GuiElementWrapper(bytemap, this));
            }
            catch (Exception exception)
            {
                Texteria.log.log(Level.WARN, (String)("Unable to construct element " + bytemap), (Throwable)exception);
            }
        }
    }

    protected void init()
    {
        super.init();

        for (Element2DWrapper element2dwrapper : this.elements)
        {
            Element2D element2d = element2dwrapper.getElement2D();
            element2d.isIn3d = this.isIn3d;
            element2d.init();
        }
    }

    public void reload()
    {
        super.reload();
        this.firstRenderPass = true;

        for (Element2DWrapper element2dwrapper : this.elements)
        {
            element2dwrapper.getElement2D().reload();
        }
    }

    public void remove()
    {
        super.remove();
        long i = 0L;

        for (Element2DWrapper element2dwrapper : this.elements)
        {
            Element2D element2d = element2dwrapper.getElement2D();
            element2d.remove();

            if (element2d.finishTime > i)
            {
                i = element2d.finishTime;
            }
        }

        if (i > this.finishTime)
        {
            this.finishTime = i;
        }
    }

    public void dispose()
    {
        super.dispose();

        for (Element2DWrapper element2dwrapper : this.elements)
        {
            element2dwrapper.getElement2D().dispose();
        }
    }

    protected void addElement(Element2DWrapper wrapper)
    {
        Element2D element2d = wrapper.getElement2D();

        if (element2d.finishTime > this.finishTime)
        {
            element2d.finishTime = this.finishTime;
        }

        this.elements.add(wrapper);
        Element2DWrapper element2dwrapper = (Element2DWrapper)this.byId.put(element2d.id, wrapper);

        if (element2dwrapper != null)
        {
            this.elements.remove(element2dwrapper);
        }
    }

    public void removeElement(String id)
    {
        for (Element2DWrapper element2dwrapper : this.elements)
        {
            if (element2dwrapper.getElement2D().id.equals(id))
            {
                element2dwrapper.getElement2D().remove();
            }
        }
    }

    protected void editElement(Element2D el, ByteMap data)
    {
        el.edit(data);
    }

    public List<Element2DWrapper> getElementsWrapper()
    {
        return this.elements;
    }

    public Element2D getElement(String id)
    {
        Element2DWrapper element2dwrapper = (Element2DWrapper)this.byId.get(id);
        return element2dwrapper == null ? null : element2dwrapper.getElement2D();
    }

    public Element2DWrapper getElementWrapper(String id)
    {
        return (Element2DWrapper)this.byId.get(id);
    }

    public boolean hasActiveBBAnimation(long time)
    {
        if (super.hasActiveBBAnimation(time))
        {
            return true;
        }
        else
        {
            if (this.getWidthFluidity() == Fluidity.WRAP_CONTENT || this.getHeightFluidity() == Fluidity.WRAP_CONTENT)
            {
                for (Element2DWrapper element2dwrapper : this.elements)
                {
                    if (element2dwrapper.getElement2D().hasActiveBBAnimation(time))
                    {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    private float walkChildrenCalcWidth()
    {
        long i = Texteria.time - (long)(this.firstRenderPass ? 0 : 15445004);
        float f = 0.0F;
        label43:

        for (Element2DWrapper element2dwrapper : this.elements)
        {
            float f1 = 0.0F;
            Element2D element2d = element2dwrapper.getElement2D();

            if (element2d.attach == null)
            {
                if (element2d.getWidthFluidity() != Fluidity.MATCH_PARENT)
                {
                    f1 = element2d.x.orig + element2d.scaleX.orig * element2d.getWidth();
                }
            }
            else
            {
                Element2D element2d1 = element2d;

                while (true)
                {
                    if (element2d1.getWidthFluidity() == Fluidity.MATCH_PARENT)
                    {
                        continue label43;
                    }

                    element2d1 = this.getElement(element2d1.attach.attachTo);

                    if (element2d1 == null || element2d1.attach == null)
                    {
                        break;
                    }
                }

                if (element2d1 == null || element2d1.getWidthFluidity() == Fluidity.MATCH_PARENT)
                {
                    continue;
                }

                if (element2d1.pos == Position.TOP_LEFT || element2d1.pos == Position.LEFT || element2d1.pos == Position.BOTTOM_LEFT)
                {
                    f1 = element2d.getXY(i).x + element2d.scaleX.orig * element2d.getWidth();
                }
            }

            if (f < f1)
            {
                f = f1;
            }
        }

        return f;
    }

    private float walkChildrenCalcHeight()
    {
        long i = Texteria.time - (long)(this.firstRenderPass ? 0 : 15445004);
        float f = 0.0F;
        label43:

        for (Element2DWrapper element2dwrapper : this.elements)
        {
            float f1 = 0.0F;
            Element2D element2d = element2dwrapper.getElement2D();

            if (element2d.attach == null)
            {
                if (element2d.getHeightFluidity() != Fluidity.MATCH_PARENT)
                {
                    f1 = element2d.y.orig + element2d.scaleY.orig * element2d.getHeight();
                }
            }
            else
            {
                Element2D element2d1 = element2d;

                while (true)
                {
                    if (element2d1.getHeightFluidity() == Fluidity.MATCH_PARENT)
                    {
                        continue label43;
                    }

                    element2d1 = this.getElement(element2d1.attach.attachTo);

                    if (element2d1 == null || element2d1.attach == null)
                    {
                        break;
                    }
                }

                if (element2d1 == null || element2d1.getHeightFluidity() == Fluidity.MATCH_PARENT)
                {
                    continue;
                }

                if (element2d1.pos == Position.TOP_LEFT || element2d1.pos == Position.TOP || element2d1.pos == Position.TOP_RIGHT)
                {
                    f1 = element2d.getXY(i).y + element2d.scaleY.orig * element2d.getHeight();
                }
            }

            if (f < f1)
            {
                f = f1;
            }
        }

        return f;
    }

    public Fluidity getWidthFluidity()
    {
        return this.widthFluidity;
    }

    public float getWidth()
    {
        switch (this.getWidthFluidity())
        {
            case MATCH_PARENT:
                return this.parent.getWidth() / this.scaleX.render;

            case WRAP_CONTENT:
                if (this.width.render < 0.0F)
                {
                    this.width.render = this.walkChildrenCalcWidth();
                }

                return this.width.render;

            default:
                return this.width.renderValue(Texteria.time);
        }
    }

    public Fluidity getHeightFluidity()
    {
        return this.heightFluidity;
    }

    public float getHeight()
    {
        switch (this.getHeightFluidity())
        {
            case MATCH_PARENT:
                return this.parent.getHeight() / this.scaleY.render;

            case WRAP_CONTENT:
                if (this.height.render < 0.0F)
                {
                    this.height.render = this.walkChildrenCalcHeight();
                }

                return this.height.render;

            default:
                return this.height.renderValue(Texteria.time);
        }
    }

    public void checkHover(int x, int y, long time)
    {
        super.checkHover(x, y, time);

        if (this.hover || this.lastHoverState)
        {
            this.lastHoverState = this.hover;

            if (this.hover)
            {
                for (Element2DWrapper element2dwrapper : this.elements)
                {
                    Element2D element2d = element2dwrapper.getElement2D();

                    if (element2d.hoverable)
                    {
                        Point2F point2f = element2d.getXY(time);
                        element2d.checkHover((int)(((float)x - point2f.x) / element2d.scaleX.render), (int)(((float)y - point2f.y) / element2d.scaleY.render), time);

                        if (element2d.hover && element2d.tooltip != null && !this.isIn3d && ((GuiElementWrapper)element2dwrapper).visible)
                        {
                            Texteria.instance.gui.currentTooltip = element2d.tooltip;
                        }
                    }
                }
            }
            else
            {
                for (Element2DWrapper element2dwrapper1 : this.elements)
                {
                    element2dwrapper1.getElement2D().checkHover(-1, -1, time);
                }
            }
        }
    }

    public boolean mouseClick(int x, int y, int button)
    {
        return this.iterateHover((e) ->
        {
            return e.mouseClick(x, y, button);
        }) ? true : super.mouseClick(x, y, button);
    }

    public boolean mouseWheel(int delta)
    {
        return this.iterateHover((e) ->
        {
            return e.mouseWheel(delta);
        }) ? true : super.mouseWheel(delta);
    }

    private boolean iterateHover(Predicate<Element2D> checker)
    {
        ListIterator<Element2DWrapper> listiterator = this.elements.listIterator(this.elements.size());
        boolean boolean = false;

        while (listiterator.hasPrevious() && !boolean)
        {
            Element2DWrapper element2dwrapper = (Element2DWrapper)listiterator.previous();

            if (this.isIn3d || ((GuiElementWrapper)element2dwrapper).visible)
            {
                Element2D element2d = element2dwrapper.getElement2D();

                if (element2d.hover)
                {
                    boolean = checker.test(element2d);
                }
            }
        }

        return boolean;
    }

    public void render(long time)
    {
        if (this.firstRenderPass)
        {
            if (this.getWidthFluidity() == Fluidity.WRAP_CONTENT)
            {
                this.width.set(this.getWidth());
            }

            if (this.getHeightFluidity() == Fluidity.WRAP_CONTENT)
            {
                this.height.set(this.getHeight());
            }
        }

        if (!this.overflow)
        {
            if (this.isIn3d && ((WorldGroup)this.parent).depth)
            {
                GlStateManager.disableDepth();
            }

            GL11.glEnable(GL11.GL_STENCIL_TEST);
            GL11.glStencilOp(GL11.GL_KEEP, GL11.GL_KEEP, GL11.GL_REPLACE);
            GL11.glStencilFunc(GL11.GL_ALWAYS, 1, 255);
            GL11.glStencilMask(255);
            GL11.glClear(1024);
            GlStateManager.colorMask(false, false, false, false);
            TRenderUtil.drawRect(0.0D, 0.0D, (double)this.getScaledWidth(), (double)this.getScaledHeight(), -1);
            GlStateManager.colorMask(true, true, true, true);
            GL11.glStencilMask(0);
            GL11.glStencilFunc(GL11.GL_EQUAL, 1, 255);

            if (this.isIn3d && ((WorldGroup)this.parent).depth)
            {
                GlStateManager.enableDepth();
            }
        }

        for (Element2DWrapper element2dwrapper : this.elements)
        {
            Element2D element2d = element2dwrapper.getElement2D();

            if (this.isIn3d || ((GuiElementWrapper)element2dwrapper).isVisible(this.mc))
            {
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

                try
                {
                    element2d.renderInContainer(time);
                }
                catch (Exception exception)
                {
                    Texteria.log.error((String)("Element render error (" + element2d + ")"), (Throwable)exception);
                }

                if (element2d.finishTime < time)
                {
                    this.byId.remove(element2d.id, element2dwrapper);
                    this.elements.remove(element2dwrapper);
                    element2d.dispose();
                }
            }
        }

        if (!this.overflow)
        {
            GL11.glDisable(GL11.GL_STENCIL_TEST);
        }

        if (this.firstRenderPass)
        {
            this.firstRenderPass = false;

            if (this.getWidthFluidity() == Fluidity.WRAP_CONTENT)
            {
                this.width.render = -1.0F;
                this.width.set(this.getWidth());
            }

            if (this.getHeightFluidity() == Fluidity.WRAP_CONTENT)
            {
                this.height.render = -1.0F;
                this.height.set(this.getHeight());
            }
        }
    }

    public void edit(ByteMap data)
    {
        super.edit(data);

        if (data.containsKey("child"))
        {
            ByteMap bytemap = data.getMap("child");
            Element2D element2d = this.getElement(bytemap.getString("id"));

            if (element2d != null)
            {
                float float = element2d.getWidth();
                float float = element2d.getHeight();
                element2d.edit(bytemap.getMap("data"));

                if (element2d.getWidthFluidity() != Fluidity.MATCH_PARENT && float != element2d.getWidth() || element2d.getHeightFluidity() != Fluidity.MATCH_PARENT && float != element2d.getHeight())
                {
                    this.firstRenderPass = true;
                }
            }
        }

        ByteMap[] abytemap = data.getMapArray("actions");

        if (abytemap != null)
        {
            for (ByteMap bytemap1 : abytemap)
            {
                String string = bytemap1.getString("%", "none");
                byte byte = -1;

                switch (string.hashCode())
                {
                    case -934610812:
                        if (string.equals("remove"))
                        {
                            byte = 1;
                        }

                        break;

                    case 96417:
                        if (string.equals("add"))
                        {
                            byte = 0;
                        }

                        break;

                    case 3108362:
                        if (string.equals("edit"))
                        {
                            byte = 2;
                        }
                }

                switch (byte)
                {
                    case 0:
                        try
                        {
                            GuiElementWrapper guielementwrapper = new GuiElementWrapper(bytemap1, this);
                            this.addElement(guielementwrapper);
                            guielementwrapper.element.isIn3d = this.isIn3d;
                            guielementwrapper.element.init();
                        }
                        catch (Exception exception)
                        {
                            Texteria.log.error((String)("Could not add element to container \'" + this.id + "\'"), (Throwable)exception);
                        }

                        break;

                    case 1:
                        this.removeElement(bytemap1.getString("id"));
                        break;

                    case 2:
                        Element2D element2d1 = this.getElement(bytemap1.getString("id"));

                        if (element2d1 != null)
                        {
                            this.editElement(element2d1, bytemap1.getMap("data"));
                        }
                }
            }

            this.firstRenderPass = true;
        }

        if (!this.overflow && (this.heightFluidity != Fluidity.FIXED || this.widthFluidity != Fluidity.FIXED))
        {
            this.overflow = true;
        }
    }
}
