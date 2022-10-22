package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class HoglinPet extends BasePet
{
    private final MModelRenderer body;
    private final MModelRenderer spikes;
    private final MModelRenderer legs;
    private final MModelRenderer head;
    private final MModelRenderer ears;
    private final MModelRenderer tusks;
    private final MModelRenderer eyes;

    public HoglinPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 16;
        this.body = new MModelRenderer(this);
        this.body.cubeList.add(new ModelBox(this.body, 34, 0, -3.0F, -7.0F, -3.0F, 6, 5, 9, 0.0F, false));
        this.spikes = new MModelRenderer(this);
        this.spikes.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.setRotation(this.spikes, 0.0F, 3.1416F, 0.0F);
        this.body.addChild(this.spikes);
        this.spikes.cubeList.add(new ModelBox(this.spikes, 5, 6, 0.0F, -10.0F, -2.0F, 0, 3, 7, 0.0F, false));
        this.legs = new MModelRenderer(this);
        this.legs.cubeList.add(new ModelBox(this.legs, 25, 4, 0.75F, -2.25F, -2.5F, 2, 3, 2, 0.0F, false));
        this.legs.cubeList.add(new ModelBox(this.legs, 25, 4, -2.75F, -2.25F, -2.5F, 2, 3, 2, 0.0F, false));
        this.legs.cubeList.add(new ModelBox(this.legs, 25, 4, 0.75F, -2.25F, 3.75F, 2, 3, 2, 0.0F, false));
        this.legs.cubeList.add(new ModelBox(this.legs, 25, 4, -2.75F, -2.25F, 3.75F, 2, 3, 2, 0.0F, false));
        this.head = new MModelRenderer(this);
        this.head.setRotationPoint(0.5F, -5.6F, 2.4F);
        this.setRotation(this.head, 0.6109F, 0.0F, 0.0F);
        this.head.cubeList.add(new ModelBox(this.head, 0, 0, -4.5F, -6.5573F, -11.9292F, 8, 4, 9, 0.0F, false));
        this.ears = new MModelRenderer(this);
        this.head.addChild(this.ears);
        this.ears.cubeList.add(new ModelBox(this.ears, 0, 0, -5.5F, -6.1879F, -6.084F, 1, 4, 3, 0.0F, false));
        this.ears.cubeList.add(new ModelBox(this.ears, 0, 0, 3.5F, -6.1879F, -6.084F, 1, 4, 3, 0.0F, false));
        this.tusks = new MModelRenderer(this);
        this.tusks.setRotationPoint(-1.0F, 0.0F, 0.0F);
        this.head.addChild(this.tusks);
        this.tusks.cubeList.add(new ModelBox(this.tusks, 39, 3, 4.5F, -8.1101F, -10.0162F, 1, 5, 1, 0.0F, false));
        this.tusks.cubeList.add(new ModelBox(this.tusks, 39, 3, -4.5F, -8.1101F, -10.0162F, 1, 5, 1, 0.0F, false));
        this.eyes = new MModelRenderer(this);
        this.eyes.setRotationPoint(-0.5F, 5.6F, -2.4F);
        this.head.addChild(this.eyes);
        this.eyes.cubeList.add(new ModelBox(this.eyes, 55, 6, -3.8F, -12.3144F, -5.8723F, 2, 1, 2, 0.0F, false));
        this.eyes.cubeList.add(new ModelBox(this.eyes, 55, 6, 1.8F, -12.3144F, -5.8723F, 2, 1, 2, 0.0F, false));
        this.setTexture(new ResourceLocation("minidot", "pets/hoglin.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.02F;
        float f1 = MathHelper.cos(time * 0.1F);
        GlStateManager.translate(0.7F, -0.2F + f, 0.3F);
        GlStateManager.rotate(f1 * 4.0F, 0.0F, 0.6F, 0.0F);
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
        GlStateManager.translate(0.0F, 0.18F, 0.1F);
        GlStateManager.disableCull();
        super.renderAsItem(time);
        GlStateManager.enableCull();
    }

    public String getName()
    {
        return "\u0411\u043e\u0440\u043e\u0432";
    }

    public String getCreator()
    {
        return "xRolaaan";
    }
}
