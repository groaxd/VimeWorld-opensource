package net.xtrafrancyz.mods.minidot.items.body;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class Snowboard extends BaseItem
{
    private final String name;
    private final MModelRenderer bonesix;
    private final MModelRenderer boneone;
    private final MModelRenderer boneseven;
    private final MModelRenderer boneeight;
    private final MModelRenderer bone;
    private final MModelRenderer bonefive;
    private final MModelRenderer bonetwo;
    private final MModelRenderer bonethree;
    private final MModelRenderer bonefour;

    public Snowboard(String name)
    {
        super(ItemType.BODY);
        this.name = name;
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.bonesix = new MModelRenderer(this);
        this.boneone = new MModelRenderer(this);
        this.boneone.setRotationPoint(10.0F, -6.5F, 0.0F);
        this.setRotation(this.boneone, 0.0F, 0.0F, -0.7854F);
        this.bonesix.addChild(this.boneone);
        this.boneone.cubeList.add(new ModelBox(this.boneone, 19, 8, -3.0F, -22.5F, 4.25F, 5, 1, 1, -0.3F, false));
        this.boneone.cubeList.add(new ModelBox(this.boneone, 18, 13, -3.0F, -7.0F, 4.0F, 5, 2, 1, -0.3001F, false));
        this.boneone.cubeList.add(new ModelBox(this.boneone, 19, 6, -3.0F, -6.0F, 4.25F, 5, 1, 1, -0.3F, false));
        this.boneone.cubeList.add(new ModelBox(this.boneone, 18, 16, -3.0F, -22.5F, 4.0F, 5, 2, 1, -0.3001F, false));
        this.boneone.cubeList.add(new ModelBox(this.boneone, 0, 0, -3.0F, -21.75F, 3.75F, 5, 16, 1, -0.3F, false));
        this.boneseven = new MModelRenderer(this);
        this.boneone.addChild(this.boneseven);
        this.boneseven.cubeList.add(new ModelBox(this.boneseven, 17, 21, -2.0F, -13.0F, 4.0F, 3, 1, 1, -0.3F, false));
        this.boneseven.cubeList.add(new ModelBox(this.boneseven, 6, 23, 0.0F, -18.25F, 4.0F, 1, 3, 1, -0.3001F, false));
        this.boneseven.cubeList.add(new ModelBox(this.boneseven, 18, 19, -2.0F, -16.25F, 4.0F, 3, 1, 1, -0.3F, false));
        this.boneseven.cubeList.add(new ModelBox(this.boneseven, 10, 25, -2.0F, -18.25F, 4.0F, 1, 3, 1, -0.3001F, false));
        this.boneseven.cubeList.add(new ModelBox(this.boneseven, 21, 0, -2.0F, -18.25F, 4.0F, 3, 1, 1, -0.3F, false));
        this.boneseven.cubeList.add(new ModelBox(this.boneseven, 14, 25, -2.0F, -13.0F, 4.0F, 1, 3, 1, -0.3001F, false));
        this.boneseven.cubeList.add(new ModelBox(this.boneseven, 21, 2, -2.0F, -11.0F, 4.0F, 3, 1, 1, -0.3F, false));
        this.boneseven.cubeList.add(new ModelBox(this.boneseven, 22, 25, 0.0F, -13.0F, 4.0F, 1, 3, 1, -0.3001F, false));
        this.boneseven.cubeList.add(new ModelBox(this.boneseven, 12, 6, -0.75F, -18.25F, 4.25F, 1, 3, 1, -0.4F, false));
        this.boneseven.cubeList.add(new ModelBox(this.boneseven, 12, 0, -0.75F, -13.0F, 4.25F, 1, 3, 1, -0.4F, false));
        this.boneeight = new MModelRenderer(this);
        this.bonesix.addChild(this.boneeight);
        this.bone = new MModelRenderer(this);
        this.setRotation(this.bone, 0.0F, 0.0F, 0.7854F);
        this.boneeight.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 17, -12.592F, -15.4899F, 3.75F, 2, 8, 1, -0.2F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 12, 13, -12.592F, -15.4899F, -0.75F, 2, 8, 1, -0.2F, false));
        this.bonefive = new MModelRenderer(this);
        this.boneeight.addChild(this.bonefive);
        this.bonefive.cubeList.add(new ModelBox(this.bonefive, 12, 0, 1.7946F, -20.7882F, -0.25F, 2, 1, 5, -0.2F, false));
        this.bonefive.cubeList.add(new ModelBox(this.bonefive, 23, 23, 1.7946F, -20.7882F, -0.75F, 2, 1, 1, -0.2F, false));
        this.bonefive.cubeList.add(new ModelBox(this.bonefive, 12, 6, -4.7232F, -13.9683F, -0.25F, 1, 2, 5, -0.2001F, false));
        this.bonefive.cubeList.add(new ModelBox(this.bonefive, 24, 10, -4.7232F, -13.9683F, -0.75F, 1, 2, 1, -0.2F, false));
        this.bonetwo = new MModelRenderer(this);
        this.bonetwo.setRotationPoint(-5.5F, 0.25F, 0.0F);
        this.setRotation(this.bonetwo, 0.0F, 0.0F, 0.2618F);
        this.boneeight.addChild(this.bonetwo);
        this.bonetwo.cubeList.add(new ModelBox(this.bonetwo, 17, 23, 1.7467F, -22.1025F, 3.75F, 2, 2, 1, -0.2001F, false));
        this.bonetwo.cubeList.add(new ModelBox(this.bonetwo, 6, 17, 1.7467F, -22.1025F, -0.75F, 2, 2, 1, -0.2001F, false));
        this.bonethree = new MModelRenderer(this);
        this.bonethree.setRotationPoint(-12.25F, -3.25F, 0.0F);
        this.setRotation(this.bonethree, 0.0F, 0.0F, 1.0908F);
        this.boneeight.addChild(this.bonethree);
        this.bonethree.cubeList.add(new ModelBox(this.bonethree, 11, 22, -5.8657F, -13.654F, 3.75F, 2, 2, 1, -0.2002F, false));
        this.bonethree.cubeList.add(new ModelBox(this.bonethree, 18, 26, -4.8657F, -12.304F, 3.75F, 1, 1, 1, -0.2001F, false));
        this.bonethree.cubeList.add(new ModelBox(this.bonethree, 26, 4, -5.3657F, -12.304F, 3.75F, 1, 1, 1, -0.2F, false));
        this.bonefour = new MModelRenderer(this);
        this.bonefour.setRotationPoint(-12.25F, -3.25F, -4.5F);
        this.setRotation(this.bonefour, 0.0F, 0.0F, 1.0908F);
        this.boneeight.addChild(this.bonefour);
        this.bonefour.cubeList.add(new ModelBox(this.bonefour, 6, 20, -5.8657F, -13.654F, 3.75F, 2, 2, 1, -0.2002F, false));
        this.bonefour.cubeList.add(new ModelBox(this.bonefour, 0, 26, -4.8657F, -12.304F, 3.75F, 1, 1, 1, -0.201F, false));
        this.bonefour.cubeList.add(new ModelBox(this.bonefour, 25, 20, -5.3657F, -12.304F, 3.75F, 1, 1, 1, -0.2F, false));
        super.setTexture(new ResourceLocation("minidot", "body/snowboard_" + name + ".png"));
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0D, 0.9943D, 0.3802D);
        super.renderAsItem(time);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0D, 1.3098D, -0.1267D);

        if (player.inventory.armorItemInSlot(2) != null)
        {
            GlStateManager.scale(1.05F, 1.05F, 1.05F);
        }
    }

    public String getName()
    {
        String s = this.name;
        byte b0 = -1;

        switch (s.hashCode())
        {
            case -1679325940:
                if (s.equals("technology"))
                {
                    b0 = 2;
                }

                break;

            case 3619723:
                if (s.equals("vime"))
                {
                    b0 = 0;
                }

                break;

            case 973576630:
                if (s.equals("rainbow"))
                {
                    b0 = 1;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u0421\u043d\u043e\u0443\u0431\u043e\u0440\u0434 \u0412\u0430\u0439\u043c\u0430";

            case 1:
                return "\u0421\u043d\u043e\u0443\u0431\u043e\u0440\u0434 \u0420\u0430\u0434\u0443\u0433\u0430";

            case 2:
                return "\u0421\u043d\u043e\u0443\u0431\u043e\u0440\u0434 \u0422\u0435\u0445\u043d\u043e\u043b\u043e\u0433\u0438\u0438";

            default:
                return "\u0421\u043d\u043e\u0443\u0431\u043e\u0440\u0434 \u041d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u043e\u0441\u0442\u0438";
        }
    }

    public String getCreator()
    {
        return "Florina";
    }
}
