package net.xtrafrancyz.util;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.util.MathHelper;

public class Easing
{
    public static final Map<String, Easing.Function> BY_NAME = new HashMap();
    public static final Easing.Function EASE_IN_SINE = Easing::easeInSine;

    public static Easing.Function getOrDefault(ByteMap params, String key, Easing.Function def)
    {
        String s = params.getString(key);
        return s == null ? def : (Easing.Function)BY_NAME.getOrDefault(s, def);
    }

    public static float linear(float t)
    {
        return t;
    }

    public static float easeInSine(float t)
    {
        return MathHelper.sin(t * ((float)Math.PI / 2F));
    }

    public static float easeOutSine(float t)
    {
        return 1.0F + MathHelper.sin((t - 1.0F) * ((float)Math.PI / 2F));
    }

    public static float easeInOutSine(float t)
    {
        return 0.5F * (1.0F + MathHelper.sin((float)Math.PI * (t - 0.5F)));
    }

    public static float easeInQuad(float t)
    {
        return t * t;
    }

    public static float easeOutQuad(float t)
    {
        return t * (2.0F - t);
    }

    public static float easeInOutQuad(float t)
    {
        return (double)t < 0.5D ? 2.0F * t * t : -1.0F + (4.0F - 2.0F * t) * t;
    }

    public static float easeInCubic(float t)
    {
        return t * t * t;
    }

    public static float easeOutCubic(float t)
    {
        return --t * t * t + 1.0F;
    }

    public static float easeInOutCubic(float t)
    {
        return (double)t < 0.5D ? 4.0F * t * t * t : (t - 1.0F) * (2.0F * t - 2.0F) * (2.0F * t - 2.0F) + 1.0F;
    }

    public static float easeInQuart(float t)
    {
        return t * t * t * t;
    }

    public static float easeOutQuart(float t)
    {
        return 1.0F - --t * t * t * t;
    }

    public static float easeInOutQuart(float t)
    {
        return (double)t < 0.5D ? 8.0F * t * t * t * t : 1.0F - 8.0F * --t * t * t * t;
    }

    public static float easeInQuint(float t)
    {
        return t * t * t * t * t;
    }

    public static float easeOutQuint(float t)
    {
        return 1.0F + --t * t * t * t * t;
    }

    public static float easeInOutQuint(float t)
    {
        return (double)t < 0.5D ? 16.0F * t * t * t * t * t : 1.0F + 16.0F * --t * t * t * t * t;
    }

    public static float easeInExpo(float t)
    {
        return ((float)Math.pow(2.0D, (double)(8.0F * t)) - 1.0F) / 255.0F;
    }

    public static float easeOutExpo(float t)
    {
        return 1.0F - (float)Math.pow(2.0D, (double)(-8.0F * t));
    }

    public static float easeInOutExpo(float t)
    {
        return t < 0.5F ? ((float)Math.pow(2.0D, (double)(16.0F * t)) - 1.0F) / 510.0F : 1.0F - 0.5F * (float)Math.pow(2.0D, (double)(-16.0F * (t - 0.5F)));
    }

    public static float easeInCirc(float t)
    {
        return 1.0F - MathHelper.sqrt_float(1.0F - t);
    }

    public static float easeOutCirc(float t)
    {
        return MathHelper.sqrt_float(t);
    }

    public static float easeInOutCirc(float t)
    {
        return t < 0.5F ? (1.0F - MathHelper.sqrt_float(1.0F - 2.0F * t)) * 0.5F : (1.0F + MathHelper.sqrt_float(2.0F * t - 1.0F)) * 0.5F;
    }

    public static float easeInBack(float t)
    {
        return t * t * (2.70158F * t - 1.70158F);
    }

    public static float easeOutBack(float t)
    {
        return 1.0F + --t * t * (2.70158F * t + 1.70158F);
    }

    public static float easeInOutBack(float t)
    {
        return t < 0.5F ? t * t * (7.0F * t - 2.5F) * 2.0F : 1.0F + --t * t * 2.0F * (7.0F * t + 2.5F);
    }

    public static float easeInElastic(float t)
    {
        float f = t * t;
        return f * f * MathHelper.sin(t * (float)Math.PI * 4.5F);
    }

    public static float easeOutElastic(float t)
    {
        float f = (t - 1.0F) * (t - 1.0F);
        return 1.0F - f * f * MathHelper.cos(t * (float)Math.PI * 4.5F);
    }

    public static float easeInOutElastic(float t)
    {
        if (t < 0.45F)
        {
            float f1 = t * t;
            return 8.0F * f1 * f1 * MathHelper.sin(t * (float)Math.PI * 9.0F);
        }
        else if (t < 0.55F)
        {
            return 0.5F + 0.75F * MathHelper.sin(t * (float)Math.PI * 4.0F);
        }
        else
        {
            float f = (t - 1.0F) * (t - 1.0F);
            return 1.0F - 8.0F * f * f * MathHelper.sin(t * (float)Math.PI * 9.0F);
        }
    }

    public static float easeInBounce(float t)
    {
        return (float)Math.pow(2.0D, (double)(6.0F * (t - 1.0F))) * MathHelper.abs(MathHelper.sin(t * (float)Math.PI * 3.5F));
    }

    public static float easeOutBounce(float t)
    {
        return 1.0F - (float)Math.pow(2.0D, (double)(-6.0F * t)) * MathHelper.abs(MathHelper.cos(t * (float)Math.PI * 3.5F));
    }

    public static float easeInOutBounce(float t)
    {
        return (double)t < 0.5D ? 8.0F * (float)Math.pow(2.0D, (double)(8.0F * (t - 1.0F))) * MathHelper.abs(MathHelper.sin(t * (float)Math.PI * 7.0F)) : 1.0F - 8.0F * (float)Math.pow(2.0D, (double)(-8.0F * t)) * MathHelper.abs(MathHelper.sin(t * (float)Math.PI * 7.0F));
    }

    static
    {
        BY_NAME.put("linear", Easing::linear);
        BY_NAME.put("easeInSine", Easing::easeInSine);
        BY_NAME.put("easeOutSine", Easing::easeOutSine);
        BY_NAME.put("easeInOutSine", Easing::easeInOutSine);
        BY_NAME.put("easeInQuad", Easing::easeInQuad);
        BY_NAME.put("easeOutQuad", Easing::easeOutQuad);
        BY_NAME.put("easeInOutQuad", Easing::easeInOutQuad);
        BY_NAME.put("easeInCubic", Easing::easeInCubic);
        BY_NAME.put("easeOutCubic", Easing::easeOutCubic);
        BY_NAME.put("easeInOutCubic", Easing::easeInOutCubic);
        BY_NAME.put("easeInQuart", Easing::easeInQuart);
        BY_NAME.put("easeOutQuart", Easing::easeOutQuart);
        BY_NAME.put("easeInOutQuart", Easing::easeInOutQuart);
        BY_NAME.put("easeInQuint", Easing::easeInQuint);
        BY_NAME.put("easeOutQuint", Easing::easeOutQuint);
        BY_NAME.put("easeInOutQuint", Easing::easeInOutQuint);
        BY_NAME.put("easeInExpo", Easing::easeInExpo);
        BY_NAME.put("easeOutExpo", Easing::easeOutExpo);
        BY_NAME.put("easeInOutExpo", Easing::easeInOutExpo);
        BY_NAME.put("easeInCirc", Easing::easeInCirc);
        BY_NAME.put("easeOutCirc", Easing::easeOutCirc);
        BY_NAME.put("easeInOutCirc", Easing::easeInOutCirc);
        BY_NAME.put("easeInBack", Easing::easeInBack);
        BY_NAME.put("easeOutBack", Easing::easeOutBack);
        BY_NAME.put("easeInOutBack", Easing::easeInOutBack);
        BY_NAME.put("easeInElastic", Easing::easeInElastic);
        BY_NAME.put("easeOutElastic", Easing::easeOutElastic);
        BY_NAME.put("easeInOutElastic", Easing::easeInOutElastic);
        BY_NAME.put("easeInBounce", Easing::easeInBounce);
        BY_NAME.put("easeOutBounce", Easing::easeOutBounce);
        BY_NAME.put("easeInOutBounce", Easing::easeInOutBounce);
    }

    public interface Function
    {
        float ease(float var1);
    }
}
