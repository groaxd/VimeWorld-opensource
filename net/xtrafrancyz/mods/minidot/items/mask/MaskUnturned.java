package net.xtrafrancyz.mods.minidot.items.mask;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.util.MNaming;

public class MaskUnturned extends BaseItem
{
    private static final Map<String, MaskUnturned.MaskSkin> skins = new HashMap();
    MaskUnturned.MaskSkin skin;
    static MModelRenderer Mask;

    public MaskUnturned(String skin)
    {
        super(ItemType.MASK);
        this.skin = (MaskUnturned.MaskSkin)skins.get(skin);
        this.textureWidth = 32;
        this.textureHeight = 16;

        if (Mask == null)
        {
            Mask = new MModelRenderer(this, 0, 0);
            Mask.addBox(-4.0F, -4.0F, -4.9F, 8, 8, 1);
            Mask.setRotationPoint(0.0F, -4.0F, 0.0F);
            Mask.mirror = true;
        }

        this.setTexture(this.skin.texture);
    }

    public String getName()
    {
        return this.skin.name;
    }

    public List<String> getDescription()
    {
        return MNaming.fromGame("Unturned");
    }

    static
    {
        skins.put("untrn_1", new MaskUnturned.MaskSkin("\u042d\u043c\u043e\u0446\u0438\u044f #1", new ResourceLocation("minidot", "masks/unturned_1.png")));
        skins.put("untrn_2", new MaskUnturned.MaskSkin("\u042d\u043c\u043e\u0446\u0438\u044f #2", new ResourceLocation("minidot", "masks/unturned_2.png")));
        skins.put("untrn_3", new MaskUnturned.MaskSkin("\u042d\u043c\u043e\u0446\u0438\u044f #3", new ResourceLocation("minidot", "masks/unturned_3.png")));
        skins.put("untrn_4", new MaskUnturned.MaskSkin("\u042d\u043c\u043e\u0446\u0438\u044f #4", new ResourceLocation("minidot", "masks/unturned_4.png")));
        skins.put("untrn_5", new MaskUnturned.MaskSkin("\u042d\u043c\u043e\u0446\u0438\u044f #5", new ResourceLocation("minidot", "masks/unturned_5.png")));
        skins.put("untrn_6", new MaskUnturned.MaskSkin("\u042d\u043c\u043e\u0446\u0438\u044f #6", new ResourceLocation("minidot", "masks/unturned_6.png")));
        skins.put("untrn_7", new MaskUnturned.MaskSkin("\u042d\u043c\u043e\u0446\u0438\u044f #7", new ResourceLocation("minidot", "masks/unturned_7.png")));
        skins.put("untrn_8", new MaskUnturned.MaskSkin("\u042d\u043c\u043e\u0446\u0438\u044f #8", new ResourceLocation("minidot", "masks/unturned_8.png")));
        skins.put("untrn_9", new MaskUnturned.MaskSkin("\u042d\u043c\u043e\u0446\u0438\u044f #9", new ResourceLocation("minidot", "masks/unturned_9.png")));
        skins.put("untrn_10", new MaskUnturned.MaskSkin("\u042d\u043c\u043e\u0446\u0438\u044f #10", new ResourceLocation("minidot", "masks/unturned_10.png")));
        skins.put("untrn_11", new MaskUnturned.MaskSkin("\u042d\u043c\u043e\u0446\u0438\u044f #11", new ResourceLocation("minidot", "masks/unturned_11.png")));
        skins.put("untrn_12", new MaskUnturned.MaskSkin("\u042d\u043c\u043e\u0446\u0438\u044f #12", new ResourceLocation("minidot", "masks/unturned_12.png")));
        skins.put("untrn_13", new MaskUnturned.MaskSkin("\u042d\u043c\u043e\u0446\u0438\u044f #13", new ResourceLocation("minidot", "masks/unturned_13.png")));
        skins.put("untrn_14", new MaskUnturned.MaskSkin("\u042d\u043c\u043e\u0446\u0438\u044f #14", new ResourceLocation("minidot", "masks/unturned_14.png")));
        skins.put("untrn_15", new MaskUnturned.MaskSkin("\u042d\u043c\u043e\u0446\u0438\u044f #15", new ResourceLocation("minidot", "masks/unturned_15.png")));
        skins.put("untrn_16", new MaskUnturned.MaskSkin("\u042d\u043c\u043e\u0446\u0438\u044f #16", new ResourceLocation("minidot", "masks/unturned_16.png")));
        skins.put("untrn_17", new MaskUnturned.MaskSkin("\u042d\u043c\u043e\u0446\u0438\u044f #17", new ResourceLocation("minidot", "masks/unturned_17.png")));
        skins.put("untrn_18", new MaskUnturned.MaskSkin("\u042d\u043c\u043e\u0446\u0438\u044f #18", new ResourceLocation("minidot", "masks/unturned_18.png")));
        skins.put("untrn_19", new MaskUnturned.MaskSkin("\u042d\u043c\u043e\u0446\u0438\u044f #19", new ResourceLocation("minidot", "masks/unturned_19.png")));
        skins.put("untrn_20", new MaskUnturned.MaskSkin("\u042d\u043c\u043e\u0446\u0438\u044f #20", new ResourceLocation("minidot", "masks/unturned_20.png")));
        skins.put("untrn_21", new MaskUnturned.MaskSkin("\u042d\u043c\u043e\u0446\u0438\u044f #21", new ResourceLocation("minidot", "masks/unturned_21.png")));
        skins.put("untrn_22", new MaskUnturned.MaskSkin("\u042d\u043c\u043e\u0446\u0438\u044f #22", new ResourceLocation("minidot", "masks/unturned_22.png")));
        skins.put("untrn_23", new MaskUnturned.MaskSkin("\u042d\u043c\u043e\u0446\u0438\u044f #23", new ResourceLocation("minidot", "masks/unturned_23.png")));
        skins.put("untrn_24", new MaskUnturned.MaskSkin("\u042d\u043c\u043e\u0446\u0438\u044f #24", new ResourceLocation("minidot", "masks/unturned_24.png")));
        skins.put("untrn_25", new MaskUnturned.MaskSkin("\u042d\u043c\u043e\u0446\u0438\u044f #25", new ResourceLocation("minidot", "masks/unturned_25.png")));
        skins.put("untrn_26", new MaskUnturned.MaskSkin("\u042d\u043c\u043e\u0446\u0438\u044f #26", new ResourceLocation("minidot", "masks/unturned_26.png")));
        skins.put("untrn_27", new MaskUnturned.MaskSkin("\u042d\u043c\u043e\u0446\u0438\u044f #27", new ResourceLocation("minidot", "masks/unturned_27.png")));
        skins.put("untrn_28", new MaskUnturned.MaskSkin("\u042d\u043c\u043e\u0446\u0438\u044f #28", new ResourceLocation("minidot", "masks/unturned_28.png")));
        skins.put("untrn_29", new MaskUnturned.MaskSkin("\u042d\u043c\u043e\u0446\u0438\u044f #29", new ResourceLocation("minidot", "masks/unturned_29.png")));
        skins.put("untrn_30", new MaskUnturned.MaskSkin("\u042d\u043c\u043e\u0446\u0438\u044f #30", new ResourceLocation("minidot", "masks/unturned_30.png")));
        skins.put("untrn_31", new MaskUnturned.MaskSkin("\u042d\u043c\u043e\u0446\u0438\u044f #31", new ResourceLocation("minidot", "masks/unturned_31.png")));
        skins.put("untrn_32", new MaskUnturned.MaskSkin("\u042d\u043c\u043e\u0446\u0438\u044f #32", new ResourceLocation("minidot", "masks/unturned_32.png")));
    }

    private static class MaskSkin
    {
        final ResourceLocation texture;
        final String name;

        public MaskSkin(String name, ResourceLocation texture)
        {
            this.name = name;
            this.texture = texture;
        }
    }
}
