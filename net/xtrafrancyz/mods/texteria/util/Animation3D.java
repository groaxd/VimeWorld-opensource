package net.xtrafrancyz.mods.texteria.util;

import net.xtrafrancyz.util.ByteMap;
import net.xtrafrancyz.util.Easing;

public class Animation3D
{
    public Animation3D.Params start = null;
    public Animation3D.Params finish = null;
    public int editDuration = 255;
    public Easing.Function editEasing = Easing.EASE_IN_SINE;

    public static class Params
    {
        public float x;
        public float y;
        public float z;
        public float scaleX;
        public float scaleY;
        public float scaleZ;
        public float angleX;
        public float angleY;
        public float angleZ;

        public Params(ByteMap map)
        {
            this.x = map.getFloat("x", 0.0F);
            this.y = map.getFloat("y", 0.0F);
            this.z = map.getFloat("z", 0.0F);

            if (map.containsKey("scale"))
            {
                this.scaleX = this.scaleY = this.scaleZ = map.getFloat("scale");
            }
            else
            {
                this.scaleX = map.getFloat("scale.x", 0.0F);
                this.scaleY = map.getFloat("scale.y", 0.0F);
                this.scaleZ = map.getFloat("scale.z", 0.0F);
            }

            this.angleX = map.getFloat("angle.x", 0.0F);
            this.angleY = map.getFloat("angle.y", 0.0F);
            this.angleZ = map.getFloat("angle.z", 0.0F);
        }
    }
}
