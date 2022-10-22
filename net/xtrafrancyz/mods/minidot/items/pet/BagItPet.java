package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.Collections;
import java.util.List;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class BagItPet extends BasePet
{
    private final MModelRenderer Pet;

    public BagItPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("Pet.Shape1", 0, 0);
        this.setTextureOffset("Pet.Shape9", 38, 28);
        this.setTextureOffset("Pet.Shape2", 54, 0);
        this.setTextureOffset("Pet.Shape8", 52, 7);
        this.setTextureOffset("Pet.Shape3", 54, 0);
        this.setTextureOffset("Pet.Shape7", 0, 28);
        this.setTextureOffset("Pet.Shape4", 0, 27);
        this.setTextureOffset("Pet.Shape6", 0, 29);
        this.setTextureOffset("Pet.Shape5", 0, 26);
        this.Pet = new MModelRenderer(this, "Pet");
        this.Pet.addBox("Shape1", -5.5F, -9.0F, -4.0F, 11, 18, 8);
        this.Pet.addBox("Shape9", -5.5F, -13.0F, -1.0F, 11, 2, 2);
        this.Pet.addBox("Shape2", -4.5F, -9.0F, -5.0F, 4, 3, 1);
        this.Pet.addBox("Shape8", -1.5F, -12.0F, -5.0F, 3, 2, 3);
        this.Pet.addBox("Shape3", 0.5F, -9.0F, -5.0F, 4, 3, 1);
        this.Pet.addBox("Shape7", -4.5F, -10.0F, -1.0F, 9, 1, 3);
        this.Pet.addBox("Shape4", -5.5F, -10.0F, -5.0F, 11, 1, 4);
        this.Pet.addBox("Shape6", -5.5F, -10.0F, 2.0F, 11, 1, 2);
        this.Pet.addBox("Shape5", -5.5F, -11.0F, -2.0F, 11, 1, 5);
        this.setTexture(new ResourceLocation("minidot", "pets/bag_it.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.02F;
        float f1 = MathHelper.cos(time * 0.1F);
        GlStateManager.translate(0.6F, -0.5F + f, 0.3F);
        GlStateManager.rotate(f1 * 4.0F, 0.0F, 0.6F, 0.0F);
        GlStateManager.scale(0.7F, 0.7F, 0.7F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "BAG-IT!";
    }

    public List<String> getDescription()
    {
        return Collections.<String>singletonList(EnumChatFormatting.WHITE + "\u0418\u0437 \u0438\u0433\u0440\u044b: " + EnumChatFormatting.BOLD + "Crossy Road");
    }
}
