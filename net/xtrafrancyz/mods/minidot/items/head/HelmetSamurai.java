package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class HelmetSamurai extends BaseHelm
{
    private final MModelRenderer All;
    private final MModelRenderer bone7;
    private final MModelRenderer bone10;
    private final MModelRenderer bone9;
    private final MModelRenderer bone6;
    private final MModelRenderer bone5;
    private final MModelRenderer bone2;
    private final MModelRenderer bone;
    private final MModelRenderer bone4;
    private final MModelRenderer bone3;
    private final MModelRenderer bone8;
    private final MModelRenderer Jtuka;

    public HelmetSamurai()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.All = new MModelRenderer(this);
        this.All.cubeList.add(new ModelBox(this.All, 36, 5, -5.0F, -8.0F, -4.0F, 1, 4, 8, 0.0F, false));
        this.All.cubeList.add(new ModelBox(this.All, 0, 0, 5.4428F, -6.4F, -3.0014F, 1, 2, 3, 0.0F, false));
        this.All.cubeList.add(new ModelBox(this.All, 0, 0, -6.1572F, -6.4F, -3.0014F, 1, 2, 3, 0.0F, false));
        this.All.cubeList.add(new ModelBox(this.All, 24, 1, 4.0F, -8.0F, -4.0F, 1, 4, 8, 0.0F, false));
        this.All.cubeList.add(new ModelBox(this.All, 30, 22, -5.0F, -4.0F, 4.0F, 10, 4, 1, 0.0F, false));
        this.All.cubeList.add(new ModelBox(this.All, 0, 18, 2.5F, -8.0F, 3.5F, 2, 4, 1, 0.0F, false));
        this.All.cubeList.add(new ModelBox(this.All, 0, 18, 2.5F, -8.0F, -4.5F, 2, 2, 1, 0.0F, false));
        this.All.cubeList.add(new ModelBox(this.All, 0, 18, -4.5F, -8.0F, -4.5F, 2, 2, 1, 0.0F, false));
        this.All.cubeList.add(new ModelBox(this.All, 0, 18, -4.5F, -8.0F, 3.5F, 2, 4, 1, 0.0F, false));
        this.All.cubeList.add(new ModelBox(this.All, 40, 27, -4.0F, -8.0F, 4.0F, 8, 4, 1, 0.0F, false));
        this.All.cubeList.add(new ModelBox(this.All, 10, 25, -4.0F, -8.0F, -5.0F, 8, 2, 1, 0.0F, false));
        this.All.cubeList.add(new ModelBox(this.All, 0, 9, -3.0F, -9.0F, -4.0F, 6, 1, 8, 0.0F, false));
        this.All.cubeList.add(new ModelBox(this.All, 25, 5, -1.2F, -8.7F, -4.7F, 2, 1, 1, 0.0F, false));
        this.All.cubeList.add(new ModelBox(this.All, 22, 41, -1.0F, -8.7F, -4.7F, 2, 1, 1, -0.25F, false));
        this.All.cubeList.add(new ModelBox(this.All, 0, 18, -4.0F, -9.0F, -3.0F, 8, 1, 6, 0.0F, false));
        this.All.cubeList.add(new ModelBox(this.All, 0, 0, -4.0F, -8.4F, -4.0F, 8, 1, 8, 0.0F, false));
        this.All.cubeList.add(new ModelBox(this.All, 3, 12, -3.0F, -8.4F, 3.5F, 6, 1, 1, 0.0F, false));
        this.All.cubeList.add(new ModelBox(this.All, 2, 12, -3.0F, -8.4F, -4.5F, 6, 1, 1, 0.0F, false));
        this.All.cubeList.add(new ModelBox(this.All, 1, 9, -4.5F, -8.4F, -3.0F, 1, 1, 6, 0.0F, false));
        this.All.cubeList.add(new ModelBox(this.All, 4, 9, 3.5F, -8.4F, -3.0F, 1, 1, 6, 0.0F, false));
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.setRotation(this.bone7, 0.0F, 0.0F, 0.1745F);
        this.All.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 46, 9, -5.8437F, -3.1137F, 0.0F, 1, 4, 8, 0.0F, false));
        this.bone7.cubeList.add(new ModelBox(this.bone7, 34, 0, -5.7569F, -2.6213F, -0.4F, 1, 3, 1, 0.0F, false));
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.setRotation(this.bone10, 0.1745F, -((float)Math.PI * 2F / 9F), 0.0F);
        this.All.addChild(this.bone10);
        this.bone10.cubeList.add(new ModelBox(this.bone10, 24, 0, -4.032F, -5.5172F, 2.5793F, 1, 2, 3, 0.0F, false));
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.setRotation(this.bone9, 0.1745F, ((float)Math.PI * 2F / 9F), 0.0F);
        this.All.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 24, 0, 3.1933F, -5.4481F, 2.8249F, 1, 2, 3, 0.0F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.setRotation(this.bone6, 0.0F, 0.0F, -0.1745F);
        this.All.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 46, 9, 4.8437F, -3.1137F, 0.0F, 1, 4, 8, 0.0F, false));
        this.bone6.cubeList.add(new ModelBox(this.bone6, 34, 0, 4.7569F, -2.6213F, -0.4F, 1, 3, 1, 0.0F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.setRotation(this.bone5, -0.1745F, 0.0F, 0.0F);
        this.All.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 24, 29, -2.5F, -6.2678F, -2.4025F, 5, 2, 1, 0.0F, false));
        this.bone5.cubeList.add(new ModelBox(this.bone5, 20, 13, -3.0F, -6.6617F, -2.4719F, 6, 2, 1, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.setRotation(this.bone2, 0.0F, 0.0F, ((float)Math.PI * 2F / 9F));
        this.All.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 24, 6, -8.6206F, -6.2333F, -0.7F, 3, 1, 1, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.setRotation(this.bone, 0.0F, 0.0F, -((float)Math.PI * 2F / 9F));
        this.All.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 24, 5, 5.752F, -6.1708F, -0.7F, 3, 1, 1, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.setRotation(this.bone4, 0.0F, 0.0F, 1.1345F);
        this.All.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 24, 5, -13.0579F, -2.1118F, -0.7F, 3, 1, 1, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.setRotation(this.bone3, 0.0F, 0.0F, -1.1345F);
        this.All.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 24, 5, 10.0701F, -2.004F, -0.7F, 3, 1, 1, 0.0F, false));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.setRotation(this.bone8, 0.1745F, 0.0F, 0.0F);
        this.All.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 32, 22, -4.0F, -2.3258F, 8.7048F, 8, 4, 1, 0.0F, false));
        this.Jtuka = new MModelRenderer(this);
        this.Jtuka.setRotationPoint(0.0F, 1.0F, -4.0F);
        this.All.addChild(this.Jtuka);
        this.Jtuka.cubeList.add(new ModelBox(this.Jtuka, 56, 2, -1.0F, -10.7F, 0.3F, 2, 1, 1, -0.25F, false));
        this.Jtuka.cubeList.add(new ModelBox(this.Jtuka, 57, 2, 0.5F, -12.2F, 0.3F, 1, 2, 1, -0.25F, false));
        this.Jtuka.cubeList.add(new ModelBox(this.Jtuka, 56, 3, -1.5F, -12.2F, 0.3F, 1, 2, 1, -0.25F, false));
        this.Jtuka.cubeList.add(new ModelBox(this.Jtuka, 56, 2, -1.0F, -12.7F, 0.3F, 2, 1, 1, -0.25F, false));
        this.Jtuka.cubeList.add(new ModelBox(this.Jtuka, 0, 26, -1.0F, -12.2F, 0.1F, 2, 2, 1, -0.25F, false));
        this.Jtuka.cubeList.add(new ModelBox(this.Jtuka, 57, 1, -1.0F, -12.2F, 0.5F, 2, 2, 1, -0.25F, false));
        this.Jtuka.cubeList.add(new ModelBox(this.Jtuka, 0, 8, -2.0F, -11.0F, 1.0F, 4, 3, 6, 0.0F, false));
        this.Jtuka.cubeList.add(new ModelBox(this.Jtuka, 7, 12, 1.5F, -10.7F, 1.5F, 1, 3, 1, 0.0F, false));
        this.Jtuka.cubeList.add(new ModelBox(this.Jtuka, 34, 0, -3.0F, -11.0F, 2.0F, 6, 3, 4, 0.0F, false));
        this.Jtuka.cubeList.add(new ModelBox(this.Jtuka, 5, 11, 1.5F, -10.7F, 5.5F, 1, 3, 1, 0.0F, false));
        this.Jtuka.cubeList.add(new ModelBox(this.Jtuka, 7, 12, -2.5F, -10.7F, 5.5F, 1, 3, 1, 0.0F, false));
        this.Jtuka.cubeList.add(new ModelBox(this.Jtuka, 7, 12, -2.5F, -10.7F, 1.5F, 1, 3, 1, 0.0F, false));
        this.Jtuka.cubeList.add(new ModelBox(this.Jtuka, 24, 17, -2.0F, -11.5F, 2.0F, 4, 1, 4, 0.0F, false));
        this.Jtuka.cubeList.add(new ModelBox(this.Jtuka, 0, 14, -1.5F, -11.4F, 5.5F, 3, 1, 1, 0.0F, false));
        this.Jtuka.cubeList.add(new ModelBox(this.Jtuka, 6, 12, -2.4F, -11.4F, 2.5F, 1, 1, 3, 0.0F, false));
        this.Jtuka.cubeList.add(new ModelBox(this.Jtuka, 2, 10, 1.4F, -11.4F, 2.5F, 1, 1, 3, 0.0F, false));
        this.Jtuka.cubeList.add(new ModelBox(this.Jtuka, 0, 5, -1.5F, -11.4F, 1.5F, 3, 1, 1, 0.0F, false));
        this.setTexture(new ResourceLocation("minidot", "head/helmet_samurai.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(1.01F, 1.01F, 1.01F);
        GlStateManager.translate(0.0F, -0.028F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.7F, 0.7F, 0.7F);
        GlStateManager.translate(0.0F, 0.03F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0428\u043b\u0435\u043c \u0441\u0430\u043c\u0443\u0440\u0430\u044f";
    }

    public String getCreator()
    {
        return "Veltorn";
    }
}
