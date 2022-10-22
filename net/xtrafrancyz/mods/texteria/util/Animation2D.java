package net.xtrafrancyz.mods.texteria.util;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import net.xtrafrancyz.util.ByteMap;
import net.xtrafrancyz.util.Easing;

public class Animation2D
{
    public Animation2D.Params start;
    public Animation2D.Params finish;
    public int editDuration = 255;
    public Easing.Function editEasing = Easing.EASE_IN_SINE;

    public static class Params
    {
        public float x;
        public float y;
        public float scaleX;
        public float scaleY;
        public float rotate;
        public Easing.Function easing;
        public int duration = 255;
        public int color;
        public Animation2D.Params next;
        public boolean cyclic;

        public Params(int color)
        {
            this.color = color;
            this.easing = Easing.EASE_IN_SINE;
        }

        public Params(Animation2D.Params params)
        {
            this.color = params.color;
            this.easing = params.easing;
            this.x = params.x;
            this.y = params.y;
            this.scaleX = params.scaleX;
            this.scaleY = params.scaleY;
            this.rotate = params.rotate;
            this.duration = params.duration;
            this.next = params.next;
            this.cyclic = params.cyclic;
        }

        public Params(ByteMap map, int defaultColor)
        {
            this.x = (float)map.getInt("x", 0);
            this.y = (float)map.getInt("y", 0);
            this.duration = map.getInt("d", 255);
            this.color = map.getInt("c", defaultColor);
            this.rotate = map.getFloat("rot", 0.0F);
            this.easing = (Easing.Function)Easing.BY_NAME.getOrDefault(map.getString("easing", "easeInSine"), Easing.EASE_IN_SINE);

            if (map.containsKey("scale"))
            {
                this.scaleX = this.scaleY = map.getFloat("scale");
            }
            else
            {
                this.scaleX = map.getFloat("scale.x", 0.0F);
                this.scaleY = map.getFloat("scale.y", 0.0F);
            }

            ByteMap bytemap = map.getMap("next");

            if (bytemap != null)
            {
                this.next = new Animation2D.Params(bytemap, this.color);
            }

            if (map.getBoolean("cyclic", false))
            {
                this.cyclic = true;

                if (this.next != null)
                {
                    Set<Animation2D.Params> set = Collections.<Animation2D.Params>newSetFromMap(new IdentityHashMap());
                    set.add(this);
                    set.add(this.next);
                    Animation2D.Params animation2d$params = this.next;

                    while (animation2d$params.next != null)
                    {
                        animation2d$params = animation2d$params.next;

                        if (set.contains(animation2d$params))
                        {
                            this.cyclic = false;
                            return;
                        }

                        set.add(animation2d$params);
                    }

                    animation2d$params.next = this;
                }
            }
        }
    }
}
