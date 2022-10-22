package net.xtrafrancyz.mods.minidot.items.animation;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.function.ToDoubleFunction;
import net.xtrafrancyz.mods.minidot.MiniDot;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.util.Easing;
import org.apache.logging.log4j.Level;

public class BBVimeAnimation implements IAnimation
{
    private final String name;
    private final boolean loop;
    private final List<BBVimeAnimation.Bone> bones;
    private float duration;
    private float startTime = -1.0F;
    private float nextPlay;

    public BBVimeAnimation(String name, JsonObject animation)
    {
        this.name = name;
        this.loop = animation.has("loop") && animation.getAsJsonPrimitive("loop").getAsBoolean();
        this.bones = new ArrayList();

        for (Entry<String, JsonElement> entry : animation.getAsJsonObject("bones").entrySet())
        {
            List<BBVimeAnimation.KeyFrameSequense> list = new ArrayList();

            for (Entry<String, JsonElement> entry1 : ((JsonElement)entry.getValue()).getAsJsonObject().entrySet())
            {
                BBVimeAnimation.KeyFrameSequense bbvimeanimation$keyframesequense = new BBVimeAnimation.KeyFrameSequense(BBVimeAnimation.Channel.valueOf(((String)entry1.getKey()).toUpperCase(Locale.US)));

                for (Entry<String, JsonElement> entry2 : ((JsonElement)entry1.getValue()).getAsJsonObject().entrySet())
                {
                    BBVimeAnimation.KeyFrame bbvimeanimation$keyframe = new BBVimeAnimation.KeyFrame();
                    bbvimeanimation$keyframe.time = Float.parseFloat((String)entry2.getKey());
                    this.duration = Math.max(bbvimeanimation$keyframe.time, this.duration);
                    JsonObject jsonobject = ((JsonElement)entry2.getValue()).getAsJsonObject();
                    bbvimeanimation$keyframe.x = jsonobject.getAsJsonPrimitive("x").getAsFloat();
                    bbvimeanimation$keyframe.y = jsonobject.getAsJsonPrimitive("y").getAsFloat();
                    bbvimeanimation$keyframe.z = jsonobject.getAsJsonPrimitive("z").getAsFloat();
                    bbvimeanimation$keyframe.easing = (Easing.Function)Easing.BY_NAME.getOrDefault(jsonobject.getAsJsonPrimitive("easing").getAsString(), Easing::linear);
                    bbvimeanimation$keyframesequense.frames.add(bbvimeanimation$keyframe);
                }

                bbvimeanimation$keyframesequense.frames.sort(Comparator.<BBVimeAnimation.KeyFrame>comparingDouble((f) ->
                {
                    return (double)f.time;
                }));
                list.add(bbvimeanimation$keyframesequense);
            }

            this.bones.add(new BBVimeAnimation.Bone((String)entry.getKey(), list));
        }
    }

    public IAnimation bind(BaseItem item)
    {
        for (BBVimeAnimation.Bone bbvimeanimation$bone : this.bones)
        {
            if (bbvimeanimation$bone.renderer == null)
            {
                bbvimeanimation$bone.renderer = findRenderer(bbvimeanimation$bone.name, item.getAllModels());

                if (bbvimeanimation$bone.renderer == null)
                {
                    MiniDot.log.log(Level.WARN, "Unable to find bone \'" + bbvimeanimation$bone.name + "\' for the animation \'" + this.name + "\' in " + item.getClass().getName());
                    bbvimeanimation$bone.renderer = new MModelRenderer(item);
                }

                bbvimeanimation$bone.renderer.setDynamic(true);
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

            for (BBVimeAnimation.Bone bbvimeanimation$bone : this.bones)
            {
                for (BBVimeAnimation.KeyFrameSequense bbvimeanimation$keyframesequense : bbvimeanimation$bone.channels)
                {
                    boolean boolean = false;

                    for (int int = 0; int < bbvimeanimation$keyframesequense.frames.size(); ++int)
                    {
                        BBVimeAnimation.KeyFrame bbvimeanimation$keyframe = (BBVimeAnimation.KeyFrame)bbvimeanimation$keyframesequense.frames.get(int);

                        if (bbvimeanimation$keyframe.time > float)
                        {
                            if (int == 0)
                            {
                                apply(bbvimeanimation$bone, bbvimeanimation$keyframesequense.channel, (BBVimeAnimation.KeyFrame)null, bbvimeanimation$keyframe, 1.0F);
                            }
                            else
                            {
                                BBVimeAnimation.KeyFrame bbvimeanimation$keyframe1 = (BBVimeAnimation.KeyFrame)bbvimeanimation$keyframesequense.frames.get(int - 1);
                                apply(bbvimeanimation$bone, bbvimeanimation$keyframesequense.channel, bbvimeanimation$keyframe1, bbvimeanimation$keyframe, (float - bbvimeanimation$keyframe1.time) / (bbvimeanimation$keyframe.time - bbvimeanimation$keyframe1.time));
                            }

                            boolean = true;
                            break;
                        }
                    }

                    if (!boolean)
                    {
                        BBVimeAnimation.KeyFrame bbvimeanimation$keyframe2 = (BBVimeAnimation.KeyFrame)bbvimeanimation$keyframesequense.frames.get(bbvimeanimation$keyframesequense.frames.size() - 1);
                        apply(bbvimeanimation$bone, bbvimeanimation$keyframesequense.channel, bbvimeanimation$keyframe2, (BBVimeAnimation.KeyFrame)null, 0.0F);
                    }
                }
            }

            if (!this.loop && float == this.duration)
            {
                this.startTime = -2.0F;
            }
        }
    }

    private static void apply(BBVimeAnimation.Bone bone, BBVimeAnimation.Channel channel, BBVimeAnimation.KeyFrame before, BBVimeAnimation.KeyFrame after, float progress)
    {
        BBVimeAnimation.KeyFrame bbvimeanimation$keyframe = null;

        if (progress == 1.0F)
        {
            bbvimeanimation$keyframe = after;
        }
        else if (progress == 0.0F)
        {
            bbvimeanimation$keyframe = before;
        }

        if (bbvimeanimation$keyframe != null)
        {
            switch (channel)
            {
                case POSITION:
                    bone.renderer.rotationPointX = bone.renderer.origRotationPointX + bbvimeanimation$keyframe.x;
                    bone.renderer.rotationPointY = bone.renderer.origRotationPointY - bbvimeanimation$keyframe.y;
                    bone.renderer.rotationPointZ = bone.renderer.origRotationPointZ + bbvimeanimation$keyframe.z;
                    break;

                case ROTATION:
                    bone.renderer.rotationX = 0.017453292F * bbvimeanimation$keyframe.x;
                    bone.renderer.rotationY = 0.017453292F * bbvimeanimation$keyframe.y;
                    bone.renderer.rotationZ = 0.017453292F * bbvimeanimation$keyframe.z;
                    break;

                case SCALE:
                    bone.renderer.scaleX = bbvimeanimation$keyframe.x;
                    bone.renderer.scaleY = bbvimeanimation$keyframe.y;
                    bone.renderer.scaleZ = bbvimeanimation$keyframe.z;
            }
        }
        else
        {
            progress = before.easing.ease(progress);

            switch (channel)
            {
                case POSITION:
                    bone.renderer.rotationPointX = bone.renderer.origRotationPointX + lerp(before.x, after.x, progress);
                    bone.renderer.rotationPointY = bone.renderer.origRotationPointY - lerp(before.y, after.y, progress);
                    bone.renderer.rotationPointZ = bone.renderer.origRotationPointZ + lerp(before.z, after.z, progress);
                    break;

                case ROTATION:
                    bone.renderer.rotationX = 0.017453292F * lerp(before.x, after.x, progress);
                    bone.renderer.rotationY = 0.017453292F * lerp(before.y, after.y, progress);
                    bone.renderer.rotationZ = 0.017453292F * lerp(before.z, after.z, progress);
                    break;

                case SCALE:
                    bone.renderer.scaleX = lerp(before.x, after.x, progress);
                    bone.renderer.scaleY = lerp(before.y, after.y, progress);
                    bone.renderer.scaleZ = lerp(before.z, after.z, progress);
            }
        }
    }

    private static float lerp(float before, float after, float progress)
    {
        return before + (after - before) * progress;
    }

    private static class Bone
    {
        final String name;
        MModelRenderer renderer;
        final List<BBVimeAnimation.KeyFrameSequense> channels;

        public Bone(String name, List<BBVimeAnimation.KeyFrameSequense> channels)
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

    private static class KeyFrame
    {
        float time;
        float x;
        float y;
        float z;
        Easing.Function easing;

        private KeyFrame()
        {
        }
    }

    private static class KeyFrameSequense
    {
        final BBVimeAnimation.Channel channel;
        final List<BBVimeAnimation.KeyFrame> frames;

        public KeyFrameSequense(BBVimeAnimation.Channel channel)
        {
            this.channel = channel;
            this.frames = new ArrayList();
        }
    }
}
