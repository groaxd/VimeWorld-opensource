package net.xtrafrancyz.mods.texteria.elements;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import javax.script.Bindings;
import javax.script.CompiledScript;
import javax.script.ScriptException;
import jdk.nashorn.api.scripting.ScriptObjectMirror;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.xtrafrancyz.mods.texteria.Texteria;
import net.xtrafrancyz.mods.texteria.elements.container.Element2DWrapper;
import net.xtrafrancyz.mods.texteria.elements.container.IContainer;
import net.xtrafrancyz.mods.texteria.util.AngleFValue;
import net.xtrafrancyz.mods.texteria.util.Animation2D;
import net.xtrafrancyz.mods.texteria.util.Attachment;
import net.xtrafrancyz.mods.texteria.util.ColorValue;
import net.xtrafrancyz.mods.texteria.util.FValue;
import net.xtrafrancyz.mods.texteria.util.Fluidity;
import net.xtrafrancyz.mods.texteria.util.OnClick;
import net.xtrafrancyz.mods.texteria.util.Point2F;
import net.xtrafrancyz.mods.texteria.util.Position;
import net.xtrafrancyz.util.ByteMap;
import net.xtrafrancyz.util.CommonUtils;
import net.xtrafrancyz.util.Easing;

public abstract class Element2D extends Element implements Element2DWrapper
{
    private static final Map<String, Function<ByteMap, Element2D>> TYPES = new HashMap();
    private static final Object[] EMPTY_ARGS = new Object[0];
    protected boolean inited;
    public boolean isIn3d;
    public IContainer parent;
    public long startTime;
    public long finishTime;
    public ColorValue color;
    public FValue x;
    public FValue y;
    public FValue scaleX;
    public FValue scaleY;
    public AngleFValue rotate;
    public Position pos;
    public Attachment attach;
    private final Point2F lastPos;
    private long lastXYcalcTime;
    public Animation2D anim;
    public Animation2D.Params activeAnim;
    public long finishAnimationDuration;
    public long animStartTime;
    public boolean hover;
    public boolean hoverable;
    public String[] tooltip;
    public OnClick click;
    public String script;
    public Bindings scriptBindings;
    public boolean integerPosition;

    public static Element2D construct(ByteMap params, IContainer parent) throws Exception
    {
        String s = params.getString("type");
        Function<ByteMap, Element2D> function = (Function)TYPES.get(s);

        if (function == null)
        {
            throw new IllegalArgumentException("Element type \'" + s + "\' not defined");
        }
        else
        {
            Element2D element2d = (Element2D)function.apply(params);
            element2d.parent = parent;
            return element2d;
        }
    }

    public Element2D(String id)
    {
        super(id);
        this.isIn3d = false;
        this.startTime = Texteria.time;
        this.finishTime = this.startTime + 2592000000L;
        this.color = new ColorValue(-1, Easing.EASE_IN_SINE, 255);
        this.x = new FValue(0.0F);
        this.y = new FValue(0.0F);
        this.scaleX = new FValue(1.0F);
        this.scaleY = new FValue(1.0F);
        this.rotate = new AngleFValue(0.0F);
        this.pos = null;
        this.attach = null;
        this.lastPos = new Point2F();
        this.lastXYcalcTime = 0L;
        this.anim = new Animation2D();
        this.activeAnim = null;
        this.hover = false;
        this.hoverable = false;
        this.tooltip = null;
        this.click = null;
        this.anim.finish = new Animation2D.Params(16777215);
        this.anim.start = new Animation2D.Params(16777215);
    }

    public Element2D(ByteMap params)
    {
        this(params.getString("id"));
        this.x.set(params.getFloat("x", 0.0F));
        this.y.set(params.getFloat("y", 0.0F));
        this.rotate.set(params.getFloat("rot", 0.0F));
        this.color.set(params.getInt("color", -1));

        if (params.containsKey("scale"))
        {
            this.scaleX.set(params.getFloat("scale"));
            this.scaleY.set(this.scaleX.orig);
        }
        else
        {
            this.scaleX.set(params.getFloat("scale.x", 1.0F));
            this.scaleY.set(params.getFloat("scale.y", 1.0F));
        }

        int i = params.getInt("delay", 0);
        this.startTime += (long)i;
        this.finishTime = this.startTime + params.getLong("dur", 432000000L);
        this.anim.editDuration = params.getInt("anim.editD", 255);

        if (params.containsKey("anim.editEasing"))
        {
            this.anim.editEasing = (Easing.Function)Easing.BY_NAME.getOrDefault(params.getString("anim.editEasing"), Easing.EASE_IN_SINE);
        }

        if (params.containsKey("anim.s"))
        {
            this.anim.start = new Animation2D.Params(params.getMap("anim.s"), this.setAlpha(this.color.orig, 0));
        }
        else
        {
            this.anim.start = new Animation2D.Params(this.setAlpha(this.color.orig, 0));
        }

        if (params.containsKey("anim.f"))
        {
            this.anim.finish = new Animation2D.Params(params.getMap("anim.f"), this.setAlpha(this.color.orig, 0));
            Animation2D.Params animation2d$params = this.anim.finish;

            while (true)
            {
                this.finishAnimationDuration += (long)animation2d$params.duration;
                animation2d$params = animation2d$params.next;

                if (animation2d$params == null || animation2d$params.cyclic)
                {
                    break;
                }
            }
        }
        else
        {
            this.anim.finish = new Animation2D.Params(this.setAlpha(this.color.orig, 0));
            this.finishAnimationDuration = (long)this.anim.finish.duration;
        }

        this.setBeginningAnimation(this.anim.start, i >= 0 ? this.startTime : Texteria.time);

        if (params.containsKey("pos"))
        {
            this.pos = Position.valueOf(params.getString("pos"));
        }

        if (params.containsKey("attach.to"))
        {
            this.attach = new Attachment(params.getString("attach.to"), Position.valueOf(params.getString("attach.loc")));

            if (params.containsKey("attach.orient"))
            {
                this.attach.orientation = Position.valueOf(params.getString("attach.orient"));
            }

            this.attach.removeWhenParentRemove = params.getBoolean("attach.rwpr", true);

            if (this.attach.removeWhenParentRemove)
            {
                Element2D element2d = Texteria.instance.gui.getElement(this.attach.attachTo);

                if (element2d != null)
                {
                    this.finishTime = element2d.finishTime;
                }
            }
        }

        if (params.containsKey("click"))
        {
            this.click = new OnClick(params.getMap("click"));
            this.hoverable = true;
        }
        else
        {
            this.hoverable = params.getBoolean("hv", false);
        }

        if (params.containsKey("tooltip"))
        {
            this.tooltip = params.getStringArray("tooltip");
            this.hoverable = true;
        }

        this.integerPosition = !params.getBoolean("fp", false);
        this.setupScript(params.getString("script"));
    }

    protected void setupScript(String script)
    {
        if (script != null)
        {
            this.script = script;
            CompiledScript compiledscript;

            try
            {
                compiledscript = Texteria.instance.scriptManager.compile(script);
            }
            catch (ScriptException scriptexception1)
            {
                Texteria.log.warn((String)("Could not compile script \'" + script + "\'. Scripts will be disabled for the element \'" + this.id + "\'"), (Throwable)scriptexception1);
                return;
            }

            this.scriptBindings = Texteria.instance.scriptManager.newBinginds();
            this.scriptBindings.put((String)"self", this);

            try
            {
                long i = System.nanoTime();
                compiledscript.eval(this.scriptBindings);
                Texteria.printDebug("Script for element {} eval in {} ns", new Object[] {this.id, Long.valueOf(System.nanoTime() - i)});
            }
            catch (ScriptException scriptexception)
            {
                Texteria.log.warn((String)("An error occurred while executing a script \'" + script + "\'. Scripts will be disabled for the element \'" + this.id + "\'"), (Throwable)scriptexception);
                this.scriptBindings = null;
            }

            this.callScriptFunction("_construct");
        }
    }

    protected void init()
    {
        if (this.isIn3d)
        {
            this.integerPosition = false;
        }

        this.callScriptFunction("_init");
    }

    public Object callScriptFunction(String function)
    {
        return this.callScriptFunction(function, EMPTY_ARGS);
    }

    public Object callScriptFunction(String function, Object... args)
    {
        if (this.scriptBindings != null)
        {
            Object object = this.scriptBindings.get(function);

            if (object instanceof ScriptObjectMirror && ((ScriptObjectMirror)object).isFunction())
            {
                try
                {
                    Object object1 = ((ScriptObjectMirror)object).call((Object)null, args);
                    return object1;
                }
                catch (Exception exception)
                {
                    Texteria.log.warn((String)("An error occurred while calling a function \'" + function + "\' for a script \'" + this.script + "\'. Scripts will be disabled for the element \'" + this.id + "\'"), (Throwable)exception);
                    this.scriptBindings = null;
                }
            }
        }

        return null;
    }

    public boolean isScriptsEnabled()
    {
        return this.scriptBindings != null;
    }

    public void remove()
    {
        long i = Texteria.time;

        if (this.finishTime > i + this.finishAnimationDuration)
        {
            this.finishTime = i + this.finishAnimationDuration;
        }
    }

    public float getScaledWidth()
    {
        return this.scaleX.render * this.getWidth();
    }

    public float getScaledHeight()
    {
        return this.scaleY.render * this.getHeight();
    }

    public boolean mouseWheel(int delta)
    {
        return this.isScriptsEnabled() && this.callScriptFunction("_mouseWheel", new Object[] {Integer.valueOf(delta)}) == Boolean.TRUE;
    }

    public boolean mouseClick(int x, int y, int button)
    {
        if (this.click != null)
        {
            switch (this.click.action)
            {
                case URL:
                    CommonUtils.openUrl((String)this.click.data);
                    break;

                case CHAT:
                    CommonUtils.sendMessage((String)this.click.data);
                    break;

                case CALLBACK:
                    Texteria.sendCallbackPacket((ByteMap)this.click.data);
                    break;

                case CLOSE_GUI:
                    Minecraft.getMinecraft().displayGuiScreen((GuiScreen)null);
                    break;

                case SCRIPT:
                    return this.callScriptFunction("_click", new Object[] {Integer.valueOf(x), Integer.valueOf(y), Integer.valueOf(button)}) == Boolean.TRUE;
            }

            return true;
        }
        else
        {
            return false;
        }
    }

    public void checkHover(int x, int y, long time)
    {
        this.hover = x >= 0 && (float)x < this.getWidth() && y >= 0 && (float)y < this.getHeight();

        if (this.isScriptsEnabled())
        {
            this.callScriptFunction("_checkHover", new Object[] {Integer.valueOf(x), Integer.valueOf(y)});
        }
    }

    public boolean hasActiveBBAnimation(long time)
    {
        return this.x.isActiveTick(time) || this.y.isActiveTick(time) || this.scaleX.isActiveTick(time) || this.scaleY.isActiveTick(time);
    }

    public boolean preRender(long time)
    {
        if (time >= this.startTime && time <= this.finishTime)
        {
            if (this.callScriptFunction("_preRender") == Boolean.FALSE)
            {
                return false;
            }
            else
            {
                if (this.finishAnimationDuration != 0L && time + this.finishAnimationDuration > this.finishTime)
                {
                    this.setActiveAnimation(this.anim.finish, this.finishTime - this.finishAnimationDuration);
                    this.finishAnimationDuration = 0L;
                }

                for (int i = 0; this.activeAnim != null && time - this.animStartTime > (long)this.activeAnim.duration; ++i)
                {
                    if (i == 1000)
                    {
                        return false;
                    }

                    if (this.activeAnim.next != null)
                    {
                        this.setActiveAnimation(this.activeAnim.next, this.animStartTime + (long)this.activeAnim.duration);
                    }
                    else if (this.activeAnim.cyclic)
                    {
                        this.setActiveAnimation(this.activeAnim, this.animStartTime + (long)this.activeAnim.duration);
                    }
                    else
                    {
                        this.activeAnim = null;
                    }
                }

                return true;
            }
        }
        else
        {
            return false;
        }
    }

    private void setActiveAnimation(Animation2D.Params anim, long startTime)
    {
        Animation2D.Params animation2d$params = new Animation2D.Params(anim);

        if (animation2d$params.cyclic && animation2d$params.next == null)
        {
            animation2d$params.next = anim;
        }

        if (anim.x != 0.0F)
        {
            this.x.startAnimation(this.x.orig + anim.x, anim.duration, anim.easing, false, startTime);
        }

        if (anim.y != 0.0F)
        {
            this.y.startAnimation(this.y.orig + anim.y, anim.duration, anim.easing, false, startTime);
        }

        if (anim.scaleX != 0.0F)
        {
            this.scaleX.startAnimation(this.scaleX.orig + anim.scaleX, anim.duration, anim.easing, false, startTime);
        }

        if (anim.scaleY != 0.0F)
        {
            this.scaleY.startAnimation(this.scaleY.orig + anim.scaleY, anim.duration, anim.easing, false, startTime);
        }

        if (anim.rotate != 0.0F)
        {
            this.rotate.startAnimation(this.rotate.orig + anim.rotate, anim.duration, anim.easing, false, startTime);
        }

        if (anim.color != this.color.orig)
        {
            this.color.startAnimation(anim.color, anim.duration, anim.easing, startTime);
        }

        animation2d$params.x = this.x.render - this.x.orig;
        animation2d$params.y = this.y.render - this.y.orig;
        animation2d$params.scaleX = this.scaleX.render - this.scaleX.orig;
        animation2d$params.scaleY = this.scaleY.render - this.scaleY.orig;
        animation2d$params.rotate = this.rotate.render - this.rotate.orig;
        animation2d$params.color = this.color.render;
        this.activeAnim = animation2d$params;
        this.animStartTime = startTime;
    }

    private void setBeginningAnimation(Animation2D.Params anim, long startTime)
    {
        if (anim.x != 0.0F)
        {
            applyBeginningAnimation(this.x, anim.x, anim, startTime);
        }

        if (anim.y != 0.0F)
        {
            applyBeginningAnimation(this.y, anim.y, anim, startTime);
        }

        if (anim.scaleX != 0.0F)
        {
            applyBeginningAnimation(this.scaleX, anim.scaleX, anim, startTime);
        }

        if (anim.scaleY != 0.0F)
        {
            applyBeginningAnimation(this.scaleY, anim.scaleY, anim, startTime);
        }

        if (anim.rotate != 0.0F)
        {
            applyBeginningAnimation(this.rotate, anim.rotate, anim, startTime);
        }

        if (anim.color != this.color.orig)
        {
            this.color.startAnimation(this.color.orig, anim.duration, anim.easing, startTime);
            this.color.prev = anim.color;
        }

        this.activeAnim = anim;
        this.animStartTime = startTime;
    }

    private static void applyBeginningAnimation(FValue val, float diff, Animation2D.Params anim, long time)
    {
        val.startAnimation(val.orig, anim.duration, anim.easing, false, time);
        val.valueDiff = diff;
    }

    public void renderInContainer(long time)
    {
        if (this.preRender(time))
        {
            Point2F point2f = this.getXY(time);
            this.color.renderValue(time);
            this.scaleX.renderValue(time);
            this.scaleY.renderValue(time);

            if (!this.inited)
            {
                this.inited = true;
                this.init();
            }

            GlStateManager.enableBlend();
            GlStateManager.blendFunc(770, 771);
            GlStateManager.pushMatrix();

            if (point2f.x != 0.0F || point2f.y != 0.0F)
            {
                GlStateManager.translate(point2f.x, point2f.y, 0.0F);
            }

            if (this.rotate.renderValue(time) != 0.0F)
            {
                GlStateManager.translate(this.getScaledWidth() / 2.0F, this.getScaledHeight() / 2.0F, 0.0F);
                GlStateManager.rotate(this.rotate.render, 0.0F, 0.0F, 1.0F);
                GlStateManager.translate(-this.getScaledWidth() / 2.0F, -this.getScaledHeight() / 2.0F, 0.0F);
            }

            if (this.scaleX.render != 1.0F || this.scaleY.render != 1.0F)
            {
                GlStateManager.scale(this.scaleX.render, this.scaleY.render, 1.0F);
            }

            this.callScriptFunction("_beforeRender");
            this.render(time);
            this.callScriptFunction("_afterRender");
            GlStateManager.popMatrix();
        }
    }

    public Point2F getXY(long time)
    {
        if (this.lastXYcalcTime == time)
        {
            return this.lastPos;
        }
        else
        {
            this.lastXYcalcTime = time;
            float f = this.x.renderValue(time);
            float f1 = this.y.renderValue(time);

            if (this.attach == null)
            {
                if (this.pos != null)
                {
                    switch (this.pos)
                    {
                        case RIGHT:
                            f = this.parent.getWidth() - this.getScaledWidth() - f;

                        case LEFT:
                            f1 += (this.parent.getHeight() - this.getScaledHeight()) / 2.0F;
                            break;

                        case BOTTOM_LEFT:
                            f1 = this.parent.getHeight() - this.getScaledHeight() - f1;
                            break;

                        case BOTTOM:
                            f1 = this.parent.getHeight() - this.getScaledHeight() - f1;

                        case TOP:
                            f += (this.parent.getWidth() - this.getScaledWidth()) / 2.0F;
                            break;

                        case BOTTOM_RIGHT:
                            f1 = this.parent.getHeight() - this.getScaledHeight() - f1;

                        case TOP_RIGHT:
                            f = this.parent.getWidth() - this.getScaledWidth() - f;
                            break;

                        case CENTER:
                            f += (this.parent.getWidth() - this.getScaledWidth()) / 2.0F;
                            f1 += (this.parent.getHeight() - this.getScaledHeight()) / 2.0F;
                    }
                }
            }
            else
            {
                Element2D element2d = this.parent.getElement(this.attach.attachTo);

                if (element2d == null)
                {
                    if (this.attach.removeWhenParentRemove)
                    {
                        this.remove();
                    }

                    return this.lastPos;
                }

                float f2 = this.getScaledWidth();
                float f3 = this.getScaledHeight();
                Point2F point2f = element2d.getXY(time);

                switch (this.attach.attachLocation)
                {
                    case RIGHT:
                        f += point2f.x + element2d.getScaledWidth() - f2 / 2.0F;
                        f1 += point2f.y + (element2d.getScaledHeight() - f3) / 2.0F;
                        break;

                    case LEFT:
                        f += point2f.x - f2 / 2.0F;
                        f1 += point2f.y + (element2d.getScaledHeight() - f3) / 2.0F;
                        break;

                    case BOTTOM_LEFT:
                        f += point2f.x - f2 / 2.0F;
                        f1 += point2f.y + element2d.getScaledHeight() - f3 / 2.0F;
                        break;

                    case BOTTOM:
                        f += point2f.x + (element2d.getScaledWidth() - f2) / 2.0F;
                        f1 += point2f.y + element2d.getScaledHeight() - f3 / 2.0F;
                        break;

                    case TOP:
                        f += point2f.x + (element2d.getScaledWidth() - f2) / 2.0F;
                        f1 += point2f.y - f3 / 2.0F;
                        break;

                    case BOTTOM_RIGHT:
                        f += point2f.x + element2d.getScaledWidth() - f2 / 2.0F;
                        f1 += point2f.y + element2d.getScaledHeight() - f3 / 2.0F;
                        break;

                    case TOP_RIGHT:
                        f += point2f.x + element2d.getScaledWidth() - f2 / 2.0F;
                        f1 += point2f.y - f3 / 2.0F;
                        break;

                    case CENTER:
                        f += point2f.x + (element2d.getScaledWidth() - f2) / 2.0F;
                        f1 += point2f.y + (element2d.getScaledHeight() - f3) / 2.0F;
                        break;

                    case TOP_LEFT:
                        f += point2f.x - f2 / 2.0F;
                        f1 += point2f.y - f3 / 2.0F;
                }

                switch (this.attach.orientation)
                {
                    case BOTTOM_LEFT:
                        f1 += f3 / 2.0F;

                    case LEFT:
                        f -= f2 / 2.0F;
                        break;

                    case BOTTOM:
                        f1 += f3 / 2.0F;
                        break;

                    case TOP:
                        f1 -= f3 / 2.0F;
                        break;

                    case BOTTOM_RIGHT:
                        f1 += f3 / 2.0F;

                    case RIGHT:
                        f += f2 / 2.0F;
                        break;

                    case TOP_RIGHT:
                        f += f2 / 2.0F;
                        f1 -= f3 / 2.0F;

                    case CENTER:
                    default:
                        break;

                    case TOP_LEFT:
                        f -= f2 / 2.0F;
                        f1 -= f3 / 2.0F;
                }
            }

            if (this.activeAnim == null && this.integerPosition)
            {
                this.lastPos.set((float)((int)f), (float)((int)f1));
            }
            else
            {
                this.lastPos.set(f, f1);
            }

            return this.lastPos;
        }
    }

    public void edit(ByteMap data)
    {
        if (data.containsKey("aed"))
        {
            this.anim.editDuration = data.getInt("aed");
        }

        if (data.containsKey("aee"))
        {
            this.anim.editEasing = Easing.getOrDefault(data, "aee", Easing.EASE_IN_SINE);
        }

        this.editFindReflectionFields(data, this.anim.editDuration, this.anim.editEasing);

        if (data.containsKey("animate"))
        {
            this.playAnimation(data.getMap("animate"));
        }
    }

    public void playAnimation(ByteMap data)
    {
        this.setActiveAnimation(new Animation2D.Params(data, this.color.orig), Texteria.time);
    }

    public int setAlphaToBaseColor(int color2)
    {
        return this.setAlpha(color2, this.getAlpha(this.color.render));
    }

    public int setAlphaToBaseColorIfGreater(int color2)
    {
        int i = this.getAlpha(this.color.render);
        return i >= this.getAlpha(color2) ? color2 : this.setAlpha(color2, i);
    }

    public boolean isInited()
    {
        return this.inited;
    }

    public void reload()
    {
        super.reload();
        this.callScriptFunction("_reload");
    }

    public Fluidity getWidthFluidity()
    {
        return Fluidity.FIXED;
    }

    public abstract float getWidth();

    public Fluidity getHeightFluidity()
    {
        return Fluidity.FIXED;
    }

    public abstract float getHeight();

    public Element2D getElement2D()
    {
        return this;
    }

    public String toString()
    {
        return this.getClass().getSimpleName() + "[" + this.id + "]";
    }

    static
    {
        TYPES.put("Rectangle", Rectangle::<init>);
        TYPES.put("Text", Text::<init>);
        TYPES.put("TextTimer", TextTimer::<init>);
        TYPES.put("TextStopwatch", TextStopwatch::<init>);
        TYPES.put("TextClock", TextClock::<init>);
        TYPES.put("Image", Image::<init>);
        TYPES.put("ProgressBar", ProgressBar::<init>);
        TYPES.put("ProgressTimer", ProgressTimer::<init>);
        TYPES.put("RadialProgressBar", RadialProgressBar::<init>);
        TYPES.put("RadialProgressTimer", RadialProgressTimer::<init>);
        TYPES.put("Vignette", Vignette::<init>);
        TYPES.put("Table", Table::<init>);
        TYPES.put("OctagonBarFull", OctagonBarFull::<init>);
        TYPES.put("OctagonBar", OctagonBar::<init>);
        TYPES.put("Button", Button::<init>);
        TYPES.put("Container", Container::<init>);
        TYPES.put("Spacer", Spacer::<init>);
    }
}
