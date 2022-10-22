package net.xtrafrancyz.mods.minidot.items.animation;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.function.ToDoubleFunction;
import net.minecraft.util.MathHelper;
import net.xtrafrancyz.mods.minidot.MiniDot;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import org.apache.logging.log4j.Level;

public class BBAnimation implements IAnimation
{
    private final String name;
    private final boolean loop;
    private final List<BBAnimation.Bone> bones;
    private float duration;
    private float startTime = -1.0F;
    private float nextPlay;

    public BBAnimation(String name, JsonObject animation)
    {
        this.name = name;
        this.loop = animation.has("loop") && animation.getAsJsonPrimitive("loop").getAsBoolean();
        this.bones = new ArrayList();

        for (Entry<String, JsonElement> entry : animation.getAsJsonObject("bones").entrySet())
        {
            List<BBAnimation.KeyFrameSequense> list = new ArrayList();

            for (Entry<String, JsonElement> entry1 : ((JsonElement)entry.getValue()).getAsJsonObject().entrySet())
            {
                BBAnimation.KeyFrameSequense bbanimation$keyframesequense = new BBAnimation.KeyFrameSequense(BBAnimation.Channel.valueOf(((String)entry1.getKey()).toUpperCase(Locale.US)));
                list.add(bbanimation$keyframesequense);
                JsonElement jsonelement = (JsonElement)entry1.getValue();

                if (jsonelement.isJsonObject())
                {
                    for (Entry<String, JsonElement> entry2 : jsonelement.getAsJsonObject().entrySet())
                    {
                        BBAnimation.KeyFrame bbanimation$keyframe1 = new BBAnimation.KeyFrame();
                        bbanimation$keyframe1.time = Float.parseFloat((String)entry2.getKey());
                        this.duration = Math.max(bbanimation$keyframe1.time, this.duration);
                        JsonElement jsonelement1 = (JsonElement)entry2.getValue();

                        if (jsonelement1.isJsonObject())
                        {
                            JsonObject jsonobject = jsonelement1.getAsJsonObject();

                            if (jsonobject.has("lerp_mode"))
                            {
                                String s = jsonobject.get("lerp_mode").getAsString();

                                if (s.equals("catmullrom"))
                                {
                                    bbanimation$keyframe1.lerp = BBAnimation.KFLerp.CATMULLROM;
                                }
                            }

                            bbanimation$keyframe1.post = new BBAnimation.Point(jsonobject.get("post"));
                            bbanimation$keyframe1.pre = jsonobject.has("pre") ? new BBAnimation.Point(jsonobject.get("pre")) : bbanimation$keyframe1.post;
                        }
                        else
                        {
                            bbanimation$keyframe1.pre = bbanimation$keyframe1.post = new BBAnimation.Point(jsonelement1);
                        }

                        bbanimation$keyframesequense.frames.add(bbanimation$keyframe1);
                    }

                    bbanimation$keyframesequense.frames.sort(Comparator.<BBAnimation.KeyFrame>comparingDouble((f) ->
                    {
                        return (double)f.time;
                    }));
                }
                else
                {
                    BBAnimation.KeyFrame bbanimation$keyframe = new BBAnimation.KeyFrame();
                    bbanimation$keyframe.pre = bbanimation$keyframe.post = new BBAnimation.Point(jsonelement);
                    bbanimation$keyframesequense.frames.add(bbanimation$keyframe);
                }
            }

            this.bones.add(new BBAnimation.Bone((String)entry.getKey(), list));
        }
    }

    public IAnimation bind(BaseItem item)
    {
        for (BBAnimation.Bone bbanimation$bone : this.bones)
        {
            if (bbanimation$bone.renderer == null)
            {
                bbanimation$bone.renderer = findRenderer(bbanimation$bone.name, item.getAllModels());

                if (bbanimation$bone.renderer == null)
                {
                    MiniDot.log.log(Level.WARN, "Unable to find bone \'" + bbanimation$bone.name + "\' for the animation \'" + this.name + "\' in " + item.getClass().getName());
                    bbanimation$bone.renderer = new MModelRenderer(item);
                }

                bbanimation$bone.renderer.setDynamic(true);
            }
        }

        item.recollectModels();
        return this;
    }

    private static MModelRenderer findRenderer(String name, MModelRenderer[] renderers)
    {
        for (MModelRenderer mmodelrenderer : renderers)
        {
            if (mmodelrenderer.name.equals(name))
            {
                return mmodelrenderer;
            }

            if (mmodelrenderer.childModels != null)
            {
                MModelRenderer[] ammodelrenderer = new MModelRenderer[mmodelrenderer.childModels.size()];
                int int = 0;

                for (Object object : mmodelrenderer.childModels)
                {
                    ammodelrenderer[int++] = (MModelRenderer)object;
                }

                MModelRenderer mmodelrenderer1 = findRenderer(name, ammodelrenderer);

                if (mmodelrenderer1 != null)
                {
                    return mmodelrenderer1;
                }
            }
        }

        return null;
    }

    public void reset()
    {
        this.startTime = -1.0F;
    }

    public void stop()
    {
        this.startTime = -3.0F;
    }

    public boolean isFinished()
    {
        return this.startTime == -2.0F || this.startTime == -3.0F;
    }

    public void tickDelayed(float time, float delaySeconds)
    {
        if (this.nextPlay <= time)
        {
            this.reset();
            this.nextPlay = time + (delaySeconds + this.duration) * 20.0F;
        }

        if (!this.isFinished())
        {
            this.tick(time);
        }
    }

    public void tick(float time)
    {
        if (this.startTime != -3.0F)
        {
            time = time / 20.0F;

            if (this.startTime == -1.0F)
            {
                this.startTime = time;
            }

            float float = time - this.startTime;

            if (this.loop)
            {
                if (float > this.duration)
                {
                    if (float / this.duration > 100.0F)
                    {
                        this.startTime = time;
                        float = 0.0F;
                    }
                    else
                    {
                        while (float > this.duration)
                        {
                            float -= this.duration;
                            this.startTime += this.duration;
                        }
                    }
                }
            }
            else
            {
                if (this.isFinished())
                {
                    return;
                }

                if (float > this.duration)
                {
                    float = this.duration;
                }
            }

            for (BBAnimation.Bone bbanimation$bone : this.bones)
            {
                for (BBAnimation.KeyFrameSequense bbanimation$keyframesequense : bbanimation$bone.channels)
                {
                    boolean boolean = false;

                    for (int int = 0; int < bbanimation$keyframesequense.frames.size(); ++int)
                    {
                        BBAnimation.KeyFrame bbanimation$keyframe = (BBAnimation.KeyFrame)bbanimation$keyframesequense.frames.get(int);

                        if (bbanimation$keyframe.time > float)
                        {
                            if (int == 0)
                            {
                                applyChanges(bbanimation$bone.renderer, bbanimation$keyframesequense.channel, bbanimation$keyframe.pre.x, bbanimation$keyframe.pre.y, bbanimation$keyframe.pre.z);
                            }
                            else
                            {
                                BBAnimation.KeyFrame bbanimation$keyframe1 = (BBAnimation.KeyFrame)bbanimation$keyframesequense.frames.get(int - 1);

                                if (bbanimation$keyframe1.lerp != BBAnimation.KFLerp.CATMULLROM && bbanimation$keyframe.lerp != BBAnimation.KFLerp.CATMULLROM)
                                {
                                    applyLinearLerp(bbanimation$bone, bbanimation$keyframesequense.channel, bbanimation$keyframe1, bbanimation$keyframe, (float - bbanimation$keyframe1.time) / (bbanimation$keyframe.time - bbanimation$keyframe1.time));
                                }
                                else
                                {
                                    BBAnimation.KeyFrame bbanimation$keyframe2 = int > 2 ? (BBAnimation.KeyFrame)bbanimation$keyframesequense.frames.get(int - 2) : bbanimation$keyframe1;
                                    BBAnimation.KeyFrame bbanimation$keyframe3 = int + 1 < bbanimation$keyframesequense.frames.size() ? (BBAnimation.KeyFrame)bbanimation$keyframesequense.frames.get(int + 1) : bbanimation$keyframe;
                                    float float = (float - bbanimation$keyframe1.time) / (bbanimation$keyframe.time - bbanimation$keyframe1.time);
                                    applyCatmullRomLerp(bbanimation$bone, bbanimation$keyframesequense.channel, bbanimation$keyframe2, bbanimation$keyframe1, bbanimation$keyframe, bbanimation$keyframe3, float);
                                }
                            }

                            boolean = true;
                            break;
                        }
                    }

                    if (!boolean)
                    {
                        BBAnimation.KeyFrame bbanimation$keyframe4 = (BBAnimation.KeyFrame)bbanimation$keyframesequense.frames.get(bbanimation$keyframesequense.frames.size() - 1);
                        applyChanges(bbanimation$bone.renderer, bbanimation$keyframesequense.channel, bbanimation$keyframe4.post.x, bbanimation$keyframe4.post.y, bbanimation$keyframe4.post.z);
                    }
                }
            }

            if (!this.loop && float == this.duration)
            {
                this.startTime = -2.0F;
            }
        }
    }

    private static void applyLinearLerp(BBAnimation.Bone bone, BBAnimation.Channel channel, BBAnimation.KeyFrame before, BBAnimation.KeyFrame after, float progress)
    {
        float float = lerp(before.post.x, after.pre.x, progress);
        float float = lerp(before.post.y, after.pre.y, progress);
        float float = lerp(before.post.z, after.pre.z, progress);
        applyChanges(bone.renderer, channel, float, float, float);
    }

    private static float lerp(float before, float after, float progress)
    {
        return before + (after - before) * progress;
    }

    private static void applyCatmullRomLerp(BBAnimation.Bone bone, BBAnimation.Channel channel, BBAnimation.KeyFrame before_plus, BBAnimation.KeyFrame before, BBAnimation.KeyFrame after, BBAnimation.KeyFrame after_plus, float progress)
    {
        int int = 2;

        if (before_plus != before)
        {
            ++int;
        }

        if (after != after_plus)
        {
            ++int;
        }

        progress = (progress + (float)(before_plus != before ? 1 : 0)) / (float)(int - 1);
        float float = (float)(int - 1) * progress;
        float float = float - (float)MathHelper.floor_float(float);
        float float = catmullRomLerp(before_plus.post.x, before.post.x, after.pre.x, after_plus.pre.x, float);
        float float = catmullRomLerp(before_plus.post.y, before.post.y, after.pre.y, after_plus.pre.y, float);
        float float = catmullRomLerp(before_plus.post.z, before.post.z, after.pre.z, after_plus.pre.z, float);
        applyChanges(bone.renderer, channel, float, float, float);
    }

    private static float catmullRomLerp(float p0, float p1, float p2, float p3, float t)
    {
        float float = (p2 - p0) * 0.5F;
        float float = (p3 - p1) * 0.5F;
        float float = t * t;
        float float = t * float;
        return (2.0F * p1 - 2.0F * p2 + float + float) * float + (-3.0F * p1 + 3.0F * p2 - 2.0F * float - float) * float + float * t + p1;
    }

    private static void applyChanges(MModelRenderer renderer, BBAnimation.Channel channel, float x, float y, float z)
    {
        switch (channel)
        {
            case POSITION:
                renderer.rotationPointX = renderer.origRotationPointX + x;
                renderer.rotationPointY = renderer.origRotationPointY - y;
                renderer.rotationPointZ = renderer.origRotationPointZ + z;
                break;

            case ROTATION:
                renderer.rotationX = 0.017453292F * x;
                renderer.rotationY = 0.017453292F * y;
                renderer.rotationZ = 0.017453292F * z;
                break;

            case SCALE:
                renderer.scaleX = x;
                renderer.scaleY = y;
                renderer.scaleZ = z;
        }
    }

    private static class Bone
    {
        final String name;
        MModelRenderer renderer;
        final List<BBAnimation.KeyFrameSequense> channels;

        public Bone(String name, List<BBAnimation.KeyFrameSequense> channels)
        {
            this.name = name;
            this.channels = channels;
        }
    }

    private static enum Channel
    {
        POSITION,
        ROTATION,
        SCALE;
    }

    private static enum KFLerp
    {
        LINEAR,
        CATMULLROM;
    }

    private static class KeyFrame
    {
        float time;
        BBAnimation.Point pre;
        BBAnimation.Point post;
        BBAnimation.KFLerp lerp;

        private KeyFrame()
        {
            this.lerp = BBAnimation.KFLerp.LINEAR;
        }
    }

    private static class KeyFrameSequense
    {
        final BBAnimation.Channel channel;
        final List<BBAnimation.KeyFrame> frames;

        public KeyFrameSequense(BBAnimation.Channel channel)
        {
            this.channel = channel;
            this.frames = new ArrayList();
        }
    }

    private static class Point
    {
        float x;
        float y;
        float z;

        private Point(JsonElement value)
        {
            if (value.isJsonPrimitive())
            {
                this.x = this.y = this.z = value.getAsFloat();
            }

            if (value.isJsonArray())
            {
                JsonArray jsonarray = value.getAsJsonArray();

                if (jsonarray.size() == 1)
                {
                    this.x = this.y = this.z = jsonarray.get(0).getAsFloat();
                }
                else
                {
                    this.x = jsonarray.get(0).getAsFloat();
                    this.y = jsonarray.get(1).getAsFloat();
                    this.z = jsonarray.get(2).getAsFloat();
                }
            }
        }
    }
}
