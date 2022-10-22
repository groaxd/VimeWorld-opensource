package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelBox;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class HornsHead extends BaseItem
{
    private final MModelRenderer Demoness_horns;
    private final MModelRenderer left;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final MModelRenderer right;
    private final MModelRenderer bone6;
    private final MModelRenderer bone7;
    private final MModelRenderer bone8;
    private final MModelRenderer bone9;
    private final MModelRenderer bone10;

    public HornsHead()
    {
        super(ItemType.HEAD);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.Demoness_horns = new MModelRenderer(this);
        this.Demoness_horns.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.left = new MModelRenderer(this);
        this.left.setRotationPoint(-3.75F, 2.0F, 0.75F);
        this.setRotation(this.left, 0.0F, 0.0F, -0.1745F);
        this.Demoness_horns.addChild(this.left);
        this.left.cubeList.add(new ModelBox(this.left, 8, 2, -3.0F, -1.0F, -1.0F, 3, 2, 2, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(-2.5F, 0.0F, 0.0F);
        this.setRotation(this.bone, 0.1325F, -0.276F, -0.4548F);
        this.left.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 16, 0, -1.9F, -1.0F, -1.0F, 2, 2, 2, -0.1F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-3.25F, -0.5F, 0.0F);
        this.setRotation(this.bone2, 0.4325F, -0.3545F, -1.3809F);
        this.left.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 16, -2.65F, -1.0F, -1.0F, 2, 2, 2, -0.2F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(-4.25F, 0.5F, -0.25F);
        this.setRotation(this.bone3, 0.5951F, -0.3674F, -2.1833F);
        this.left.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 14, 12, -2.65F, -1.0F, -1.0F, 2, 2, 2, -0.4F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(-4.3F, 2.0F, -0.75F);
        this.setRotation(this.bone4, 0.6773F, -0.1643F, -3.0928F);
        this.left.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 14, 8, -2.65F, -1.0F, -1.0F, 2, 2, 2, -0.5F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(-4.05F, 2.75F, -0.6F);
        this.setRotation(this.bone5, 0.833F, -0.2735F, 2.7235F);
        this.left.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 0, 8, -3.65F, -1.0F, -0.95F, 3, 2, 2, -0.7F, false));
        this.right = new MModelRenderer(this);
        this.right.setRotationPoint(3.75F, 2.0F, 0.75F);
        this.setRotation(this.right, 0.0F, 0.0F, 0.1745F);
        this.Demoness_horns.addChild(this.right);
        this.right.cubeList.add(new ModelBox(this.right, 0, 4, 0.0F, -1.0F, -1.0F, 3, 2, 2, 0.0F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(2.5F, 0.0F, 0.0F);
        this.setRotation(this.bone6, 0.1325F, 0.276F, 0.4548F);
        this.right.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 6, 14, -0.1F, -1.0F, -1.0F, 2, 2, 2, -0.1F, false));
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(3.25F, -0.5F, 0.0F);
        this.setRotation(this.bone7, 0.4325F, 0.3545F, 1.3809F);
        this.right.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 0, 12, 0.65F, -1.0F, -1.0F, 2, 2, 2, -0.2F, false));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(4.25F, 0.5F, -0.25F);
        this.setRotation(this.bone8, 0.5951F, 0.3674F, 2.1833F);
        this.right.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 8, 10, 0.65F, -1.0F, -1.0F, 2, 2, 2, -0.4F, false));
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(4.3F, 2.0F, -0.75F);
        this.setRotation(this.bone9, 0.6773F, 0.1643F, 3.0928F);
        this.right.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 8, 6, 0.65F, -1.0F, -1.0F, 2, 2, 2, -0.5F, false));
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(4.05F, 2.75F, -0.6F);
        this.setRotation(this.bone10, 0.833F, 0.2735F, -2.7235F);
        this.right.addChild(this.bone10);
        this.bone10.cubeList.add(new ModelBox(this.bone10, 0, 0, 0.65F, -1.0F, -0.95F, 3, 2, 2, -0.7F, false));
        super.setTexture(new ResourceLocation("minidot", "head/hornshead.png"));
    }

    public String getName()
    {
        return "\u0420\u043e\u0433\u0430";
    }

    public String getCreator()
    {
        return "xRolaaan";
    }
}
