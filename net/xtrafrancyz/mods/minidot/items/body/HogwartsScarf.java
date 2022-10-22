package net.xtrafrancyz.mods.minidot.items.body;

import java.util.List;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;
import net.xtrafrancyz.mods.minidot.util.MNaming;

public class HogwartsScarf extends BaseItem
{
    private final MModelRenderer HogwartsScarf;
    private final MModelRenderer bone10;
    private final MModelRenderer bone9;
    private final MModelRenderer bone8;
    private final MModelRenderer bone7;
    private final MModelRenderer bone6;
    private final MModelRenderer bone5;
    private final MModelRenderer bone4;
    private final MModelRenderer bone3;
    private final MModelRenderer bone2;
    private final MModelRenderer bone;
    private final String faculty;
    private final IAnimation animation;

    public HogwartsScarf(String faculty)
    {
        super(ItemType.BODY);
        this.faculty = faculty;
        this.textureWidth = 16;
        this.textureHeight = 16;
        this.HogwartsScarf = new MModelRenderer(this);
        this.HogwartsScarf.setRotationPoint(4.0F, 24.0F, -2.0F);
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(-7.15F, -11.8F, -0.25F);
        this.HogwartsScarf.addChild(this.bone10);
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(9.0F, 2.8F, -4.5F);
        this.bone10.addChild(this.bone9);
        this.setRotation(this.bone9, -0.4746F, -0.0462F, -1.5972F);
        this.bone9.setTextureOffset(0, 0).addBox(-4.3374F, -11.917F, -0.8855F, 4, 3, 1, 0.01F);
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(0.4F, -0.2F, -0.1F);
        this.bone10.addChild(this.bone8);
        this.setRotation(this.bone8, -0.4756F, 0.0338F, -1.442F);
        this.bone8.setTextureOffset(0, 0).addBox(-4.1228F, -1.7103F, -0.7701F, 4, 3, 1, 0.0F);
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(-9.9F, -11.5F, 2.75F);
        this.HogwartsScarf.addChild(this.bone7);
        this.setRotation(this.bone7, 2.4677F, 1.5411F, 2.6123F);
        this.bone7.setTextureOffset(0, 4).addBox(-0.0774F, -0.5015F, 1.6421F, 3, 3, 1, 0.0F);
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(-6.9F, -10.5F, 4.75F);
        this.HogwartsScarf.addChild(this.bone6);
        this.setRotation(this.bone6, -3.1243F, 0.9867F, -3.0386F);
        this.bone6.setTextureOffset(0, 4).addBox(-1.5934F, -1.1281F, -0.1636F, 4, 3, 1, 0.0F);
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(-4.15F, -10.0F, 6.0F);
        this.HogwartsScarf.addChild(this.bone5);
        this.setRotation(this.bone5, -3.1252F, 0.0869F, 3.0983F);
        this.bone5.setTextureOffset(0, 0).addBox(-1.9548F, -1.3541F, -0.0829F, 4, 3, 1, 0.0F);
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(-0.8F, -10.8F, 4.8F);
        this.HogwartsScarf.addChild(this.bone4);
        this.setRotation(this.bone4, -2.9932F, -((float)Math.PI * 2F / 9F), 3.0107F);
        this.bone4.setTextureOffset(0, 0).addBox(-1.9978F, -0.8491F, -0.1204F, 4, 3, 1, 0.0F);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(-0.65F, 0.0F, 2.0F);
        this.HogwartsScarf.addChild(this.bone3);
        this.setRotation(this.bone3, 0.0F, -1.5708F, 0.0436F);
        this.bone3.setTextureOffset(0, 0).addBox(-2.4337F, -11.9973F, -0.9F, 4, 3, 1, 0.0F);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-4.9F, -10.4F, -1.0F);
        this.HogwartsScarf.addChild(this.bone2);
        this.setRotation(this.bone2, -0.0815F, 0.1346F, -0.087F);
        this.bone2.setTextureOffset(0, 0).addBox(-2.9737F, -1.522F, 0.0152F, 4, 3, 1, 0.0F);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(-2.0F, -10.0F, 0.0F);
        this.HogwartsScarf.addChild(this.bone);
        this.setRotation(this.bone, 0.0F, 0.0F, 0.0175F);
        this.bone.setTextureOffset(0, 0).addBox(-2.0346F, -1.9648F, -1.0F, 4, 3, 1, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "body/" + faculty + "_scarf.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "body/hogwarts_scarf_animation.json"));
        this.animation = bbanimationloader.mustGet("rotating", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0D, -0.78D, -0.01D);
        this.animation.tick(time);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(1.5D, 1.5D, 1.5D);
        GlStateManager.translate(0.0D, -0.3D, 0.4D);
        this.animation.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        String s = this.faculty;
        byte b0 = -1;

        switch (s.hashCode())
        {
            case 825834644:
                if (s.equals("gryffindor"))
                {
                    b0 = 0;
                }

                break;

            case 916423499:
                if (s.equals("hufflepuff"))
                {
                    b0 = 2;
                }

                break;

            case 980034630:
                if (s.equals("slytherin"))
                {
                    b0 = 3;
                }

                break;

            case 2004939119:
                if (s.equals("ravenclaw"))
                {
                    b0 = 1;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u0428\u0430\u0440\u0444 \u0413\u0440\u0438\u0444\u0444\u0438\u043d\u0434\u043e\u0440\u0430";

            case 1:
                return "\u0428\u0430\u0440\u0444 \u041a\u043e\u0433\u0442\u0435\u0432\u0440\u0430\u043d\u0430";

            case 2:
                return "\u0428\u0430\u0440\u0444 \u041f\u0443\u0444\u0444\u0435\u043d\u0434\u0443\u044f";

            case 3:
                return "\u0428\u0430\u0440\u0444 \u0421\u043b\u0438\u0437\u0435\u0440\u0438\u043d\u0430";

            default:
                return "";
        }
    }

    public String getCreator()
    {
        return "Rander_";
    }

    public List<String> getDescription()
    {
        return MNaming.fromFilmSeries("\u0413\u0430\u0440\u0440\u0438 \u041f\u043e\u0442\u0442\u0435\u0440");
    }
}
