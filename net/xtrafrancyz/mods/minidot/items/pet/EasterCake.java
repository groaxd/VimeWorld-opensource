package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class EasterCake extends BasePet
{
    private final MModelRenderer TOPPING;
    private final MModelRenderer GLAZE;
    private final MModelRenderer MAIN;

    public EasterCake()
    {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.useDisplayLists = true;
        this.TOPPING = new MModelRenderer(this);
        this.TOPPING.cubeList.add(new ModelBox(this.TOPPING, 4, 14, -1.75F, -11.6F, 0.75F, 1, 1, 1, 0.0F, false));
        this.TOPPING.cubeList.add(new ModelBox(this.TOPPING, 0, 14, 0.4F, -11.6F, -1.65F, 1, 1, 1, 0.0F, false));
        this.TOPPING.cubeList.add(new ModelBox(this.TOPPING, 8, 14, -1.6F, -11.8F, -1.65F, 1, 1, 1, -0.2F, false));
        this.TOPPING.cubeList.add(new ModelBox(this.TOPPING, 12, 14, 0.9F, -11.9F, 0.95F, 1, 1, 1, -0.3F, false));
        this.TOPPING.cubeList.add(new ModelBox(this.TOPPING, 12, 14, -2.7F, -10.3F, 1.75F, 1, 1, 1, -0.2F, false));
        this.TOPPING.cubeList.add(new ModelBox(this.TOPPING, 8, 14, -3.6F, -10.3F, 0.55F, 1, 1, 1, -0.2F, false));
        this.TOPPING.cubeList.add(new ModelBox(this.TOPPING, 16, 14, -0.5F, -10.3F, -3.65F, 1, 1, 1, -0.2F, false));
        this.TOPPING.cubeList.add(new ModelBox(this.TOPPING, 12, 14, 1.9F, -10.3F, -2.95F, 1, 1, 1, -0.2F, false));
        this.TOPPING.cubeList.add(new ModelBox(this.TOPPING, 16, 14, -0.1F, -11.7F, -0.05F, 1, 1, 1, -0.1F, false));
        this.TOPPING.cubeList.add(new ModelBox(this.TOPPING, 16, 14, -0.2F, -10.2F, 2.55F, 1, 1, 1, -0.1F, false));
        this.TOPPING.cubeList.add(new ModelBox(this.TOPPING, 24, 14, -3.0F, -11.2F, -0.85F, 1, 1, 1, -0.1F, false));
        this.TOPPING.cubeList.add(new ModelBox(this.TOPPING, 28, 14, -1.75F, -11.2F, -2.95F, 1, 1, 1, -0.1F, false));
        this.TOPPING.cubeList.add(new ModelBox(this.TOPPING, 28, 14, 1.95F, -11.2F, 0.15F, 1, 1, 1, -0.1F, false));
        this.TOPPING.cubeList.add(new ModelBox(this.TOPPING, 24, 14, 0.55F, -11.1F, 1.95F, 1, 1, 1, 0.0F, false));
        this.GLAZE = new MModelRenderer(this);
        this.GLAZE.cubeList.add(new ModelBox(this.GLAZE, 0, 16, -3.0F, -10.0F, -3.0F, 6, 2, 6, 0.0F, false));
        this.GLAZE.cubeList.add(new ModelBox(this.GLAZE, 0, 16, -2.0F, -10.0F, -3.5F, 4, 2, 7, 0.0F, false));
        this.GLAZE.cubeList.add(new ModelBox(this.GLAZE, 0, 16, -3.5F, -10.0F, -2.0F, 7, 2, 4, 0.0F, false));
        this.GLAZE.cubeList.add(new ModelBox(this.GLAZE, 0, 16, 2.0F, -8.5F, 2.1F, 1, 4, 1, -0.001F, false));
        this.GLAZE.cubeList.add(new ModelBox(this.GLAZE, 0, 16, -3.0F, -7.7F, 1.1F, 1, 3, 2, -0.002F, false));
        this.GLAZE.cubeList.add(new ModelBox(this.GLAZE, 0, 16, -3.1F, -9.0F, 1.1F, 2, 3, 2, -0.003F, false));
        this.GLAZE.cubeList.add(new ModelBox(this.GLAZE, 0, 16, 1.1F, -8.9F, 1.1F, 2, 3, 2, -0.002F, false));
        this.GLAZE.cubeList.add(new ModelBox(this.GLAZE, 0, 16, -3.1F, -8.2F, -3.1F, 2, 3, 2, -0.003F, false));
        this.GLAZE.cubeList.add(new ModelBox(this.GLAZE, 0, 16, 1.0F, -7.7F, -3.1F, 2, 4, 2, -0.002F, false));
        this.GLAZE.cubeList.add(new ModelBox(this.GLAZE, 0, 16, 1.1F, -8.6F, -3.1F, 2, 3, 2, -0.003F, false));
        this.GLAZE.cubeList.add(new ModelBox(this.GLAZE, 0, 16, -3.0F, -8.0F, -3.1F, 2, 4, 2, -0.002F, false));
        this.GLAZE.cubeList.add(new ModelBox(this.GLAZE, 0, 16, -2.0F, -11.0F, -3.0F, 4, 1, 6, 0.0F, false));
        this.GLAZE.cubeList.add(new ModelBox(this.GLAZE, 0, 16, -3.0F, -11.0F, -2.0F, 6, 1, 4, 0.0F, false));
        this.GLAZE.cubeList.add(new ModelBox(this.GLAZE, 0, 16, -2.0F, -11.5F, -2.0F, 4, 1, 4, 0.0F, false));
        this.MAIN = new MModelRenderer(this);
        this.MAIN.cubeList.add(new ModelBox(this.MAIN, 0, 0, -3.0F, -8.0F, -3.0F, 6, 8, 6, 0.0F, false));
        this.MAIN.cubeList.add(new ModelBox(this.MAIN, 0, 0, -2.0F, -8.0F, -4.0F, 4, 8, 1, 0.0F, false));
        this.MAIN.cubeList.add(new ModelBox(this.MAIN, 0, 0, -2.0F, -8.0F, 3.0F, 4, 8, 1, 0.0F, false));
        this.MAIN.cubeList.add(new ModelBox(this.MAIN, 0, 0, 3.0F, -8.0F, -2.0F, 1, 8, 4, 0.0F, false));
        this.MAIN.cubeList.add(new ModelBox(this.MAIN, 0, 0, -4.0F, -8.0F, -2.0F, 1, 8, 4, 0.0F, false));
        this.setTexture(new ResourceLocation("minidot", "pets/easter_cake_pet.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.05F;
        float f1 = time * 1.5F;
        GlStateManager.translate(0.7F, -0.2F + f, 0.3F);
        GlStateManager.rotate(90.0F + f1, 0.0F, 1.0F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.275F, 0.0F);
        GlStateManager.scale(1.1F, 1.1F, 1.1F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041a\u0443\u043b\u0438\u0447";
    }

    public String getCreator()
    {
        return "Defiant";
    }
}
