package net.xtrafrancyz.mods.minidot.items;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;

public class MModelRenderer extends ModelRenderer
{
    public String name;
    public float origRotationX = 0.0F;
    public float origRotationY = 0.0F;
    public float origRotationZ = 0.0F;
    public float rotationX = 0.0F;
    public float rotationY = 0.0F;
    public float rotationZ = 0.0F;
    public float origRotationPointX;
    public float origRotationPointY;
    public float origRotationPointZ;
    public float scaleX = 1.0F;
    public float scaleY = 1.0F;
    public float scaleZ = 1.0F;
    private boolean isDynamic = false;
    public MModelRenderer parent = null;
    public float scaleModifier = 1.0F;

    public MModelRenderer(ModelBase par1ModelBase, int par2, int par3)
    {
        super(par1ModelBase, par2, par3);
    }

    public MModelRenderer(ModelBase par1ModelBase, String name)
    {
        super(par1ModelBase, name);
    }

    public MModelRenderer(ModelBase par1ModelBase)
    {
        super(par1ModelBase);
    }

    public void setDynamic(boolean isDynamic)
    {
        this.isDynamic = isDynamic;

        if (isDynamic && this.parent != null)
        {
            this.parent.setDynamic(true);
        }
    }

    public boolean isDynamic()
    {
        return this.isDynamic;
    }

    public void setRotationPoint(float x, float y, float z)
    {
        this.origRotationPointX = x;
        this.origRotationPointY = y;
        this.origRotationPointZ = z;
        super.setRotationPoint(x, y, z);
    }

    /**
     * Sets the current box's rotation points and rotation angles to another box.
     */
    public void addChild(ModelRenderer renderer)
    {
        super.addChild(renderer);

        if (renderer instanceof MModelRenderer)
        {
            ((MModelRenderer)renderer).parent = this;
        }
    }

    public void render(float scale)
    {
        if (!this.isHidden && this.showModel)
        {
            this.rotateAngleX = this.origRotationX + this.rotationX;
            this.rotateAngleY = this.origRotationY + this.rotationY;
            this.rotateAngleZ = this.origRotationZ + this.rotationZ;

            if (this.scaleX == 1.0F && this.scaleY == 1.0F && this.scaleZ == 1.0F)
            {
                super.render(scale * this.scaleModifier);
            }
            else
            {
                GlStateManager.pushMatrix();
                GlStateManager.translate(this.rotationPointX * scale, this.rotationPointY * scale, this.rotationPointZ * scale);
                GlStateManager.scale(this.scaleX, this.scaleY, this.scaleZ);
                GlStateManager.translate(-this.rotationPointX * scale, -this.rotationPointY * scale, -this.rotationPointZ * scale);
                super.render(scale * this.scaleModifier);
                GlStateManager.popMatrix();
            }
        }
    }
}
