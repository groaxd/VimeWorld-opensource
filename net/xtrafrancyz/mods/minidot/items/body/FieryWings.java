package net.xtrafrancyz.mods.minidot.items.body;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class FieryWings extends BaseItem
{
    private static final Map<String, ResourceLocation> colors = new HashMap();
    private static MModelRenderer[] Shape;
    private static int displayList;
    private static boolean compiled;
    private String color;

    public FieryWings(String color)
    {
        super(ItemType.BODY);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.useDisplayLists = true;
        this.color = color;

        if (Shape == null)
        {
            Shape = new MModelRenderer[11];
            Shape[0] = new MModelRenderer(this, 0, 0);
            Shape[1] = new MModelRenderer(this, 0, 0);
            Shape[2] = new MModelRenderer(this, 0, 0);
            Shape[3] = new MModelRenderer(this, 0, 0);
            Shape[4] = new MModelRenderer(this, 0, 0);
            Shape[5] = new MModelRenderer(this, 0, 0);
            Shape[6] = new MModelRenderer(this, 0, 0);
            Shape[7] = new MModelRenderer(this, 0, 0);
            Shape[8] = new MModelRenderer(this, 0, 0);
            Shape[9] = new MModelRenderer(this, 0, 0);
            Shape[10] = new MModelRenderer(this, 0, 0);
            Shape[2].scaleModifier = 0.99F;
            Shape[3].scaleModifier = 0.99F;
            Shape[10].scaleModifier = 0.99F;
            Shape[0].addBox(-4.0F, -23.0F, 2.0F, 0, 32, 22);
            Shape[1].addBox(-5.0F, -4.0F, 2.2F, 2, 4, 2);
            Shape[2].addBox(-5.0F, -4.0F, 1.2F, 2, 4, 2);
            Shape[3].addBox(-5.0F, -6.4F, 1.2F, 2, 2, 2);
            Shape[4].addBox(-5.0F, 6.0F, -1.6F, 2, 2, 4);
            Shape[5].addBox(-5.0F, -7.8F, 3.0F, 2, 4, 2);
            Shape[6].addBox(-5.0F, 4.0F, 1.4F, 2, 2, 6);
            Shape[7].addBox(-5.0F, -9.4F, 0.2F, 2, 4, 2);
            Shape[8].addBox(-5.0F, 1.6F, 1.4F, 2, 2, 4);
            Shape[9].addBox(-5.0F, -12.0F, -2.4F, 2, 4, 2);
            Shape[10].addBox(-5.0F, 0.0F, 0.0F, 2, 4, 4);
            Shape[0].setRotationPoint(0.0F, 4.0F, 2.0F);
            Shape[1].setRotationPoint(0.0F, 4.0F, 2.0F);
            Shape[2].setRotationPoint(0.0F, 4.0F, 2.0F);
            Shape[3].setRotationPoint(0.0F, 4.0F, 2.0F);
            Shape[4].setRotationPoint(0.0F, 4.0F, 2.0F);
            Shape[5].setRotationPoint(0.0F, 4.0F, 2.0F);
            Shape[6].setRotationPoint(0.0F, 4.0F, 2.0F);
            Shape[7].setRotationPoint(0.0F, 4.0F, 2.0F);
            Shape[8].setRotationPoint(0.0F, 4.0F, 2.0F);
            Shape[9].setRotationPoint(0.0F, 4.0F, 2.0F);
            Shape[10].setRotationPoint(0.0F, 4.0F, 2.0F);
            this.setRotation(Shape[0], -0.5061455F, -0.4363323F, 0.0F);
            this.setRotation(Shape[1], -0.6365804F, -0.4363323F, 0.0F);
            this.setRotation(Shape[2], -0.6365804F, -0.4363323F, 0.0F);
            this.setRotation(Shape[3], -0.6540337F, -0.4363323F, 0.0F);
            this.setRotation(Shape[4], 0.0698132F, -0.4363323F, 0.0F);
            this.setRotation(Shape[5], -0.2647943F, -0.4363323F, 0.0F);
            this.setRotation(Shape[6], -0.4506874F, -0.4363323F, 0.0F);
            this.setRotation(Shape[7], -0.8596521F, -0.4363323F, 0.0F);
            this.setRotation(Shape[8], -0.4506874F, -0.4363323F, 0.0F);
            this.setRotation(Shape[9], -0.9300021F, -0.4363323F, 0.0F);
            this.setRotation(Shape[10], 0.0698132F, -0.4363323F, 0.0F);
        }

        this.setTexture((ResourceLocation)colors.get(color));
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        float f = MathHelper.cos(time * 0.15F) * 8.0F;
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.tex);
        GlStateManager.pushMatrix();
        GlStateManager.enableCull();
        this.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, -0.2F, 0.13F);
        GlStateManager.scale(0.7F, 0.8F, 0.6F);
        GlStateManager.cullFace(1028);
        GlStateManager.pushMatrix();
        GlStateManager.scale(-1.0F, 1.0F, 1.0F);
        GlStateManager.translate(0.0F, 0.0F, 0.03F);
        GlStateManager.rotate(16.0F, -1.0F, 1.0F, 0.0F);
        GlStateManager.rotate(f, 0.0F, -0.2F, 0.0F);
        this.renderModels();
        GlStateManager.popMatrix();
        GlStateManager.cullFace(1029);
        GlStateManager.pushMatrix();
        GlStateManager.translate(0.0F, 0.0F, 0.03F);
        GlStateManager.rotate(16.0F, -1.0F, 1.0F, 0.0F);
        GlStateManager.rotate(f, 0.0F, -0.2F, 0.0F);
        this.renderModels();
        GlStateManager.popMatrix();
        GlStateManager.disableCull();
        GlStateManager.popMatrix();
    }

    public void renderAsItem(float time)
    {
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.tex);
        GlStateManager.enableCull();
        GlStateManager.translate(0.0F, -0.1F, -0.2F);
        GlStateManager.scale(0.35F, 0.4F, 0.35F);
        GlStateManager.cullFace(1028);
        GlStateManager.pushMatrix();
        GlStateManager.scale(-1.0F, 1.0F, 1.0F);
        GlStateManager.translate(0.0F, 0.0F, 0.03F);
        GlStateManager.rotate(5.0F, -1.0F, 1.0F, 0.0F);
        GlStateManager.rotate(10.0F, 0.0F, -0.2F, 0.0F);
        this.renderModels();
        GlStateManager.popMatrix();
        GlStateManager.cullFace(1029);
        GlStateManager.pushMatrix();
        GlStateManager.translate(0.0F, 0.0F, 0.03F);
        GlStateManager.rotate(5.0F, -1.0F, 1.0F, 0.0F);
        GlStateManager.rotate(10.0F, 0.0F, -0.2F, 0.0F);
        this.renderModels();
        GlStateManager.popMatrix();
        GlStateManager.disableCull();
    }

    protected void renderModels()
    {
        if (super.compiled)
        {
            super.renderModels();
        }
        else
        {
            if (compiled)
            {
                super.compiled = true;
                super.displayList = displayList;
                this.recollectModels();
            }

            super.renderModels();

            if (!compiled)
            {
                compiled = true;
                displayList = super.displayList;
            }
        }
    }

    public String getCreator()
    {
        return "Ursun";
    }

    public String getName()
    {
        String s = this.color;
        byte b0 = -1;

        switch (s.hashCode())
        {
            case 112785:
                if (s.equals("red"))
                {
                    b0 = 0;
                }

                break;

            case 3027034:
                if (s.equals("blue"))
                {
                    b0 = 1;
                }

                break;

            case 3075958:
                if (s.equals("dark"))
                {
                    b0 = 4;
                }

                break;

            case 3441014:
                if (s.equals("pink"))
                {
                    b0 = 3;
                }

                break;

            case 98619139:
                if (s.equals("green"))
                {
                    b0 = 2;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u041a\u0440\u0430\u0441\u043d\u044b\u0435 \u043e\u0433\u043d\u0435\u043d\u043d\u044b\u0435 \u043a\u0440\u044b\u043b\u044c\u044f";

            case 1:
                return "\u0421\u0438\u043d\u0438\u0435 \u043e\u0433\u043d\u0435\u043d\u043d\u044b\u0435 \u043a\u0440\u044b\u043b\u044c\u044f";

            case 2:
                return "\u0417\u0435\u043b\u0435\u043d\u044b\u0435 \u043e\u0433\u043d\u0435\u043d\u043d\u044b\u0435 \u043a\u0440\u044b\u043b\u044c\u044f";

            case 3:
                return "\u0420\u043e\u0437\u043e\u0432\u044b\u0435 \u043e\u0433\u043d\u0435\u043d\u043d\u044b\u0435 \u043a\u0440\u044b\u043b\u044c\u044f";

            case 4:
                return "\u0422\u0435\u043c\u043d\u044b\u0435 \u043e\u0433\u043d\u0435\u043d\u043d\u044b\u0435 \u043a\u0440\u044b\u043b\u044c\u044f";

            default:
                return "\u041f\u0438\u0437\u0434\u0430";
        }
    }

    static
    {
        colors.put("red", new ResourceLocation("minidot:body/fierywings_red.png"));
        colors.put("blue", new ResourceLocation("minidot:body/fierywings_blue.png"));
        colors.put("green", new ResourceLocation("minidot:body/fierywings_green.png"));
        colors.put("pink", new ResourceLocation("minidot:body/fierywings_pink.png"));
        colors.put("dark", new ResourceLocation("minidot:body/fierywings_dark.png"));
    }
}
