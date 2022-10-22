package net.xtrafrancyz.mods.minidot.items;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import org.lwjgl.opengl.GL11;

public abstract class BaseItem extends ModelBase
{
    public static final float DEFAULT_SCALE = 0.0625F;
    protected static MModelRenderer LIGHT_FIX;
    public int id = -1;
    private final ItemType type;
    private boolean isNew = false;
    private ItemCollection collection = ItemCollection.NONE;
    public int discount = 0;
    protected float rotateX = 0.0F;
    protected float rotateY = 0.0F;
    protected float rotateZ = 0.0F;
    protected ResourceLocation tex = null;
    private MModelRenderer[] staticModels = null;
    private MModelRenderer[] dynamicModels = null;
    private MModelRenderer[] allModels = null;
    private boolean needLightFix = false;
    protected boolean useDisplayLists = false;
    protected int displayList = -1;
    protected boolean compiled = false;
    protected boolean disableAnimationInPreview = false;
    private static final float ANGLES_IN_RADIAN = (180F / (float)Math.PI);

    protected BaseItem(ItemType type)
    {
        this.type = type;

        if (LIGHT_FIX == null)
        {
            LIGHT_FIX = new MModelRenderer(this, 0, 0);
            LIGHT_FIX.addBox(0.0F, 0.0F, 0.0F, 1, 1, 0);
        }
    }

    public void itemMotion(float rotation, int number)
    {
        if (this.type == ItemType.MASK)
        {
            GlStateManager.scale(0.9F, 0.9F, 0.9F);
            GlStateManager.rotate(180.0F + MathHelper.sin(rotation * 0.07F + (float)number) * 20.0F, 0.0F, 0.2F, 0.0F);
            GlStateManager.translate(0.0F, -0.1F, 0.3F);
        }
        else
        {
            GlStateManager.rotate(-rotation * 1.8F, 0.0F, 0.2F, 0.0F);
        }
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.pushMatrix();
        this.preRender(modelPlayer, player, time, pi);
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.tex);
        this.renderModels();
        GlStateManager.popMatrix();
    }

    public void renderAsItem(float time)
    {
        switch (this.type)
        {
            case HEAD:
            case MASK:
                GlStateManager.translate(0.0F, 0.35F, 0.0F);
                break;

            case BODY:
                GlStateManager.translate(0.0F, -0.3F, -0.4F);
                GlStateManager.scale(0.7F, 0.7F, 0.7F);
        }

        if (this.disableAnimationInPreview)
        {
            this.forEachDynamicModel((mm) ->
            {
                mm.rotationX = 0.0F;
                mm.rotationY = 0.0F;
                mm.rotationZ = 0.0F;
                mm.rotationPointX = mm.origRotationPointX;
                mm.rotationPointY = mm.origRotationPointY;
                mm.rotationPointZ = mm.origRotationPointZ;
            });
        }

        Minecraft.getMinecraft().getTextureManager().bindTexture(this.tex);
        this.renderModels();
    }

    protected void renderModels()
    {
        if (this.useDisplayLists)
        {
            if (this.compiled)
            {
                GlStateManager.callList(this.displayList);

                if (this.dynamicModels.length > 0)
                {
                    for (MModelRenderer mmodelrenderer : this.dynamicModels)
                    {
                        mmodelrenderer.render(0.0625F);
                    }
                }
            }
            else
            {
                this.renderStaticModels();
                this.displayList = GLAllocation.generateDisplayLists(1);
                GL11.glNewList(this.displayList, GL11.GL_COMPILE);
                this.renderStaticModels();
                GL11.glEndList();
                this.compiled = true;
            }
        }
        else
        {
            for (MModelRenderer mmodelrenderer1 : this.getAllModels())
            {
                mmodelrenderer1.render(0.0625F);
            }
        }

        if (this.needLightFix)
        {
            LIGHT_FIX.render(1.0E-6F);
        }
    }

    protected void renderStaticModels()
    {
        for (MModelRenderer mmodelrenderer : this.getStaticModels())
        {
            mmodelrenderer.render(0.0625F);
        }
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        switch (this.type)
        {
            case HEAD:
                this.setModelRotation(modelPlayer.bipedHead);

                if (modelPlayer.isSneak)
                {
                    GlStateManager.translate(0.0F, 0.265F, 0.0F);
                }

                this.setRotationAngles(this.rotateX, this.rotateY, this.rotateZ);

                if (player.getCurrentArmor(3) != null)
                {
                    GlStateManager.scale(1.1F, 1.1F, 1.1F);
                }

                break;

            case MASK:
                this.setModelRotation(modelPlayer.bipedHead);

                if (modelPlayer.isSneak)
                {
                    GlStateManager.translate(0.0F, 0.265F, 0.0F);
                }

                this.setRotationAngles(this.rotateX, this.rotateY, this.rotateZ);
                break;

            case BODY:
                this.setModelRotation(modelPlayer.bipedBody);

                if (player.getCurrentArmor(2) != null)
                {
                    GlStateManager.translate(0.0F, 0.0F, 0.025F);
                }

                this.setRotationAngles(this.rotateX, this.rotateY, this.rotateZ);

                if (modelPlayer.isSneak)
                {
                    GlStateManager.translate(0.0F, 0.203125F, -0.1F);
                }
        }
    }

    private void collectModels()
    {
        if (this.allModels == null)
        {
            try
            {
                List<MModelRenderer> list = new LinkedList();
                List<MModelRenderer> list1 = new LinkedList();
                List<MModelRenderer> list2 = new LinkedList();

                for (Field field : this.getClass().getDeclaredFields())
                {
                    field.setAccessible(true);

                    if (MModelRenderer.class.isAssignableFrom(field.getType()))
                    {
                        MModelRenderer mmodelrenderer1 = (MModelRenderer)field.get(this);

                        if (mmodelrenderer1 != null)
                        {
                            mmodelrenderer1.name = field.getName();

                            if (mmodelrenderer1.parent == null)
                            {
                                if (mmodelrenderer1.isDynamic())
                                {
                                    list1.add(mmodelrenderer1);
                                }
                                else
                                {
                                    list.add(mmodelrenderer1);
                                }

                                list2.add(mmodelrenderer1);
                            }
                        }
                    }
                    else if (MModelRenderer[].class.isAssignableFrom(field.getType()))
                    {
                        MModelRenderer[] ammodelrenderer = (MModelRenderer[])((MModelRenderer[])field.get(this));
                        int int = 0;

                        for (MModelRenderer mmodelrenderer : ammodelrenderer)
                        {
                            mmodelrenderer.name = field.getName() + "[" + int++ + "]";

                            if (mmodelrenderer.parent == null)
                            {
                                if (mmodelrenderer.isDynamic())
                                {
                                    list1.add(mmodelrenderer);
                                }
                                else
                                {
                                    list.add(mmodelrenderer);
                                }

                                list2.add(mmodelrenderer);
                            }
                        }
                    }
                }

                this.staticModels = (MModelRenderer[])list.toArray(new MModelRenderer[0]);
                this.dynamicModels = (MModelRenderer[])list1.toArray(new MModelRenderer[0]);
                this.allModels = (MModelRenderer[])list2.toArray(new MModelRenderer[0]);
                Function<ModelRenderer, Boolean> function = (mr) ->
                {
                    while (mr.childModels != null)
                    {
                        mr = (ModelRenderer)mr.childModels.get(mr.childModels.size() - 1);
                    }

                    ModelBox modelbox = (ModelBox)mr.cubeList.get(mr.cubeList.size() - 1);
                    return Boolean.valueOf(modelbox.posX1 == modelbox.posX2 || modelbox.posY1 == modelbox.posY2);
                };
                ModelRenderer modelrenderer = null;

                if (this.staticModels.length > 0)
                {
                    modelrenderer = this.staticModels[this.staticModels.length - 1];
                }

                if (this.dynamicModels.length > 0)
                {
                    modelrenderer = this.dynamicModels[this.dynamicModels.length - 1];
                }

                if (modelrenderer != null)
                {
                    this.needLightFix |= ((Boolean)function.apply(modelrenderer)).booleanValue();
                }

                if (this.allModels.length > 0)
                {
                    this.needLightFix |= ((Boolean)function.apply(this.allModels[this.allModels.length - 1])).booleanValue();
                }
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                this.staticModels = new MModelRenderer[0];
                this.dynamicModels = new MModelRenderer[0];
                this.allModels = new MModelRenderer[0];
            }
        }
    }

    public final MModelRenderer[] getAllModels()
    {
        this.collectModels();
        return this.allModels;
    }

    public final MModelRenderer[] getStaticModels()
    {
        this.collectModels();
        return this.staticModels;
    }

    public final MModelRenderer[] getDynamicModels()
    {
        this.collectModels();
        return this.dynamicModels;
    }

    public final void forEachModel(Consumer<MModelRenderer> consumer)
    {
        for (MModelRenderer mmodelrenderer : this.getAllModels())
        {
            this.walkModelsRecursive(mmodelrenderer, consumer, (mr) ->
            {
                return (void)true;
            });
        }
    }

    public final void forEachStaticModel(Consumer<MModelRenderer> consumer)
    {
        for (MModelRenderer mmodelrenderer : this.getStaticModels())
        {
            this.walkModelsRecursive(mmodelrenderer, consumer, (mr) ->
            {
                return (void)(!mr.isDynamic());
            });
        }
    }

    public final void forEachDynamicModel(Consumer<MModelRenderer> consumer)
    {
        for (MModelRenderer mmodelrenderer : this.getDynamicModels())
        {
            this.walkModelsRecursive(mmodelrenderer, consumer, MModelRenderer::isDynamic);
        }
    }

    private void walkModelsRecursive(MModelRenderer rr, Consumer<MModelRenderer> consumer, Predicate<MModelRenderer> filter)
    {
        if (filter.test(rr))
        {
            consumer.accept(rr);

            if (rr.childModels != null)
            {
                for (Object object : rr.childModels)
                {
                    this.walkModelsRecursive((MModelRenderer)object, consumer, filter);
                }
            }
        }
    }

    public final void recollectModels()
    {
        this.allModels = null;
        this.collectModels();
    }

    public abstract String getName();

    public String getCreator()
    {
        return null;
    }

    public List<String> getDescription()
    {
        return null;
    }

    public BaseItem setNew(boolean flag)
    {
        this.isNew = flag;
        return this;
    }

    public BaseItem setCollection(ItemCollection collection)
    {
        this.collection = collection;
        return this;
    }

    public boolean isNew()
    {
        return this.isNew;
    }

    public ItemCollection getCollection()
    {
        return this.collection;
    }

    protected void setRotation(MModelRenderer model, float x, float y, float z)
    {
        model.origRotationX = x;
        model.origRotationY = y;
        model.origRotationZ = z;
    }

    protected void setTexture(ResourceLocation tex)
    {
        this.tex = tex;
    }

    protected void setModelRotation(ModelRenderer parent)
    {
        this.rotateX = parent.rotateAngleX;
        this.rotateY = parent.rotateAngleY;
        this.rotateZ = parent.rotateAngleZ;
    }

    protected void setRotationAngles(float x, float y, float z)
    {
        if (z != 0.0F)
        {
            GlStateManager.rotate(z * (180F / (float)Math.PI), 0.0F, 0.0F, 1.0F);
        }

        if (y != 0.0F)
        {
            GlStateManager.rotate(y * (180F / (float)Math.PI), 0.0F, 1.0F, 0.0F);
        }

        if (x != 0.0F)
        {
            GlStateManager.rotate(x * (180F / (float)Math.PI), 1.0F, 0.0F, 0.0F);
        }
    }

    public final ItemType getType()
    {
        return this.type;
    }

    public ResourceLocation getTexture()
    {
        return this.tex;
    }

    public int hashCode()
    {
        return this.id;
    }

    public boolean equals(Object obj)
    {
        return obj == this;
    }

    public String toString()
    {
        return this.getName();
    }
}
