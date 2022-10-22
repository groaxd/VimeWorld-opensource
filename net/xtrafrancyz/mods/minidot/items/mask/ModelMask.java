package net.xtrafrancyz.mods.minidot.items.mask;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.util.MNaming;

public class ModelMask extends BaseItem
{
    private static final Map<String, ModelMask.MaskSkin> skins = new HashMap();
    private ModelMask.MaskSkin skin;
    static MModelRenderer Mask;

    public ModelMask(String skin)
    {
        super(ItemType.MASK);
        this.skin = (ModelMask.MaskSkin)skins.get(skin);
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
        return this.skin.description;
    }

    static
    {
        skins.put("anonymous", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0413\u0430\u044f \u0424\u043e\u043a\u0441\u0430", new ResourceLocation("minidot", "masks/anonymous.png")));
        skins.put("patrick", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u041f\u0430\u0442\u0440\u0438\u043a\u0430", new ResourceLocation("minidot", "masks/patrick.png")));
        skins.put("pikachu", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u041f\u0438\u043a\u0430\u0447\u0443", new ResourceLocation("minidot", "masks/pikachu.png")));
        skins.put("saw", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0414\u0436\u043e\u043d\u0430 \u041a\u0440\u0430\u043c\u0435\u0440\u0430", new ResourceLocation("minidot", "masks/saw.png"))).setDescription("\u0424\u0438\u043b\u044c\u043c \'\'\u041f\u0438\u043b\u0430\'\'"));
        skins.put("jason_v", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0414\u0436\u0435\u0439\u0441\u043e\u043d\u0430 \u0412\u0443\u0440\u0445\u0438\u0437\u0430", new ResourceLocation("minidot", "masks/jason_v.png"))).setDescription("\u0424\u0438\u043b\u044c\u043c \'\'\u041f\u044f\u0442\u043d\u0438\u0446\u0430 13\'\'"));
        skins.put("vass", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0412\u0430\u0441\u0441\u0430", new ResourceLocation("minidot", "masks/vass.png")));
        skins.put("mcdonald", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0420\u043e\u043d\u0430\u043b\u044c\u0434\u0430 \u041c\u0430\u043a\u0434\u043e\u043d\u0430\u043b\u044c\u0434\u0430", new ResourceLocation("minidot", "masks/mcdonald.png")));
        skins.put("facehrena", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0418\u0433\u043e\u0440\u044f", new ResourceLocation("minidot", "masks/facehrena.png")));
        skins.put("cake", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u041f\u0438\u0440\u043e\u0436\u043a\u0430", new ResourceLocation("minidot", "masks/cake.png")));
        skins.put("hellboy", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0425\u0435\u043b\u043b\u0431\u043e\u044f", new ResourceLocation("minidot", "masks/hellboy.png")));
        skins.put("mummy", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u041c\u0443\u043c\u0438\u0438", new ResourceLocation("minidot", "masks/mummy.png")));
        skins.put("mr_t", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u041c\u0438\u0441\u0442\u0435\u0440\u0430 \u0422\u0438", new ResourceLocation("minidot", "masks/mr_t.png")));
        skins.put("kratos", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u041a\u0440\u0430\u0442\u043e\u0441\u0430", new ResourceLocation("minidot", "masks/kratos.png"))).setDescription(MNaming.fromGame("God Of War")));
        skins.put("skull", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0427\u0435\u0440\u0435\u043f\u0430", new ResourceLocation("minidot", "masks/skull.png")));
        skins.put("trollface", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 TrollFace", new ResourceLocation("minidot", "masks/trollface.png")));
        skins.put("dirt", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0417\u0435\u043c\u043b\u0435\u043c\u043e\u0440\u0434\u044b", new ResourceLocation("minidot", "masks/dirt.png")));
        skins.put("doge", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 Doge", new ResourceLocation("minidot", "masks/doge.png")));
        skins.put("sonic", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0421\u043e\u043d\u0438\u043a\u0430", new ResourceLocation("minidot", "masks/sonic.png")));
        skins.put("panda", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u041f\u0430\u043d\u0434\u044b", new ResourceLocation("minidot", "masks/panda.png")));
        skins.put("onepunch", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0412\u0430\u043d\u043f\u0430\u043d\u0447\u043c\u0435\u043d\u0430", new ResourceLocation("minidot", "masks/onepunch.png")));
        skins.put("minion", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u041c\u0438\u043d\u044c\u043e\u043d\u0430", new ResourceLocation("minidot", "masks/minion.png")));
        skins.put("knight", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0420\u044b\u0446\u0430\u0440\u044f", new ResourceLocation("minidot", "masks/knight.png")));
        skins.put("misha", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u041c\u0438\u0448\u043a\u0438", new ResourceLocation("minidot", "masks/misha.png")));
        skins.put("sloth", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u041b\u0435\u043d\u0438\u0432\u0446\u0430", new ResourceLocation("minidot", "masks/sloth.png")));
        skins.put("ninja", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u041d\u0438\u043d\u0434\u0437\u044f", new ResourceLocation("minidot", "masks/ninja.png")));
        List<String> list = Collections.<String>singletonList(EnumChatFormatting.GRAY + "" + EnumChatFormatting.BOLD + "Power Rangers");
        skins.put("pr_red", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u041a\u0440\u0430\u0441\u043d\u043e\u0433\u043e \u0440\u0435\u0439\u043d\u0434\u0436\u0435\u0440\u0430", new ResourceLocation("minidot", "masks/pr_red.png"))).setDescription(list));
        skins.put("pr_blue", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0421\u0438\u043d\u0435\u0433\u043e \u0440\u0435\u0439\u043d\u0434\u0436\u0435\u0440\u0430", new ResourceLocation("minidot", "masks/pr_blue.png"))).setDescription(list));
        skins.put("pr_yellow", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0416\u0451\u043b\u0442\u043e\u0433\u043e \u0440\u0435\u0439\u043d\u0434\u0436\u0435\u0440\u0430", new ResourceLocation("minidot", "masks/pr_yellow.png"))).setDescription(list));
        skins.put("pr_green", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0417\u0435\u043b\u0451\u043d\u043e\u0433\u043e \u0440\u0435\u0439\u043d\u0434\u0436\u0435\u0440\u0430", new ResourceLocation("minidot", "masks/pr_green.png"))).setDescription(list));
        skins.put("pr_pink", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0420\u043e\u0437\u043e\u0432\u043e\u0433\u043e \u0440\u0435\u0439\u043d\u0434\u0436\u0435\u0440\u0430", new ResourceLocation("minidot", "masks/pr_pink.png"))).setDescription(list));
        skins.put("pr_black", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0427\u0451\u0440\u043d\u043e\u0433\u043e \u0440\u0435\u0439\u043d\u0434\u0436\u0435\u0440\u0430", new ResourceLocation("minidot", "masks/pr_black.png"))).setDescription(list));
        skins.put("pr_white", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0411\u0435\u043b\u043e\u0433\u043e \u0440\u0435\u0439\u043d\u0434\u0436\u0435\u0440\u0430", new ResourceLocation("minidot", "masks/pr_white.png"))).setDescription(list));
        skins.put("cavespider", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u041f\u0435\u0449\u0435\u0440\u043d\u043e\u0433\u043e \u043f\u0430\u0443\u043a\u0430", new ResourceLocation("minidot", "masks/cavespider.png")));
        skins.put("creeper", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u041a\u0440\u0438\u043f\u0435\u0440\u0430", new ResourceLocation("minidot", "masks/creeper.png")));
        skins.put("pigman", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0421\u0432\u0438\u043d\u043e\u0437\u043e\u043c\u0431\u0438", new ResourceLocation("minidot", "masks/pigman.png")));
        skins.put("skeleton", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0421\u043a\u0435\u043b\u0435\u0442\u0430", new ResourceLocation("minidot", "masks/skeleton.png")));
        skins.put("witherskeleton", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0421\u043a\u0435\u043b\u0435\u0442\u0430-\u0438\u0441\u0441\u0443\u0448\u0438\u0442\u0435\u043b\u044f", new ResourceLocation("minidot", "masks/witherskeleton.png")));
        skins.put("wither", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0418\u0441\u0441\u0443\u0448\u0438\u0442\u0435\u043b\u044f", new ResourceLocation("minidot", "masks/wither.png")));
        skins.put("zombi", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0417\u043e\u043c\u0431\u0438", new ResourceLocation("minidot", "masks/zombi.png")));
        skins.put("heroender", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0425\u0438\u0440\u043e\u0431\u0440\u0438\u043d-\u042d\u043d\u0434\u0435\u0440\u043c\u0435\u043d", new ResourceLocation("minidot", "masks/herobrine_enderman.png")));
        skins.put("slime", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0421\u043b\u0430\u0439\u043c\u0430", new ResourceLocation("minidot", "masks/slime.png")));
        skins.put("spider", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u041f\u0430\u0443\u043a\u0430", new ResourceLocation("minidot", "masks/spider.png")));
        skins.put("magma", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u041b\u0430\u0432\u043e\u0432\u043e\u0433\u043e \u043a\u0443\u0431\u0430", new ResourceLocation("minidot", "masks/magma.png")));
        skins.put("pig", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0421\u0432\u0438\u043d\u044c\u0438", new ResourceLocation("minidot", "masks/pig.png")));
        skins.put("blaze", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0418\u0444\u0440\u0438\u0442\u0430", new ResourceLocation("minidot", "masks/blaze.png")));
        skins.put("cow", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u041a\u043e\u0440\u043e\u0432\u044b", new ResourceLocation("minidot", "masks/cow.png")));
        skins.put("ocelot", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u041e\u0446\u0435\u043b\u043e\u0442\u0430", new ResourceLocation("minidot", "masks/ocelot.png")));
        skins.put("enderman", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u042d\u043d\u0434\u0435\u0440\u043c\u0435\u043d\u0430", new ResourceLocation("minidot", "masks/enderman.png")));
        skins.put("herobrine", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0425\u0438\u0440\u043e\u0431\u0440\u0438\u043d\u0430", new ResourceLocation("minidot", "masks/herobrine.png")));
        skins.put("mushroom", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0413\u0440\u0438\u0431\u043d\u043e\u0439 \u043a\u043e\u0440\u043e\u0432\u044b", new ResourceLocation("minidot", "masks/mushroom.png")));
        skins.put("steve", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0421\u0442\u0438\u0432\u0430", new ResourceLocation("minidot", "masks/steve.png")));
        skins.put("black_steve", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0427\u0451\u0440\u043d\u043e\u0433\u043e \u0421\u0442\u0438\u0432\u0430", new ResourceLocation("minidot", "masks/black_steve.png")));
        skins.put("beast_boy", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0411\u0438\u0441\u0442\u0431\u043e\u044f", new ResourceLocation("minidot", "masks/beast_boy.png")));
        skins.put("hall_frankenstein", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0424\u0440\u0430\u043d\u043a\u0435\u043d\u0448\u0442\u0435\u0439\u043d\u0430", new ResourceLocation("minidot", "masks/hall_frankenstein.png")));
        skins.put("hall_werewolf", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u041e\u0431\u043e\u0440\u043e\u0442\u043d\u044f", new ResourceLocation("minidot", "masks/hall_werewolf.png")));
        skins.put("hall_vampire", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0412\u0430\u043c\u043f\u0438\u0440\u0430", new ResourceLocation("minidot", "masks/hall_vampire.png")));
        skins.put("hall_wraith", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u041f\u0440\u0438\u0437\u0440\u0430\u043a\u0430", new ResourceLocation("minidot", "masks/hall_wraith.png")));
        skins.put("hall_negasteve", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u043d\u0435\u0433\u0430\u0442\u0438\u0432\u043d\u043e\u0433\u043e \u0421\u0442\u0438\u0432\u0430", new ResourceLocation("minidot", "masks/hall_negasteve.png")));
        skins.put("hall_pennywise", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u041f\u0435\u043d\u043d\u0438\u0432\u0430\u0439\u0437\u0430", new ResourceLocation("minidot", "masks/hall_pennywise.png")));
        skins.put("hall_pumpkin", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0422\u044b\u043a\u0432\u044b", new ResourceLocation("minidot", "masks/hall_pumpkin.png")));
        skins.put("hall_sans", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0421\u0430\u043d\u0441\u0430", new ResourceLocation("minidot", "masks/hall_sans.png")));
        skins.put("hall_skull", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0421\u043a\u0435\u043b\u0435\u0442\u0430", new ResourceLocation("minidot", "masks/hall_skull.png")));
        skins.put("hall_steve", new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0421\u0442\u0438\u0432\u0430", new ResourceLocation("minidot", "masks/hall_steve.png")));
        list = MNaming.fromGame("FNAF");
        skins.put("fnaf_freddy", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 Freddy", new ResourceLocation("minidot", "masks/fnaf_freddy.png"))).setDescription(list));
        skins.put("fnaf_chica", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 Chica", new ResourceLocation("minidot", "masks/fnaf_chica.png"))).setDescription(list));
        skins.put("fnaf_mangle", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 Mangle", new ResourceLocation("minidot", "masks/fnaf_mangle.png"))).setDescription(list));
        skins.put("fnaf_foxy", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 Foxy", new ResourceLocation("minidot", "masks/fnaf_foxy.png"))).setDescription(list));
        skins.put("fnaf_marionette", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 Marionette", new ResourceLocation("minidot", "masks/fnaf_marionette.png"))).setDescription(list));
        skins.put("fnaf_bonnie", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 Bonnie", new ResourceLocation("minidot", "masks/fnaf_bonnie.png"))).setDescription(list));
        skins.put("fnaf_springtrap", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 Springtrap", new ResourceLocation("minidot", "masks/fnaf_springtrap.png"))).setDescription(list));
        skins.put("fnaf_purple_guy", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 Purple Guy", new ResourceLocation("minidot", "masks/fnaf_purple_guy.png"))).setDescription(list));
        skins.put("fnaf_balloon_boy", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 Balloon Boy", new ResourceLocation("minidot", "masks/fnaf_balloon_boy.png"))).setDescription(list));
        list = Collections.<String>singletonList(EnumChatFormatting.RED + "" + EnumChatFormatting.BOLD + "MARVEL");
        skins.put("mrv_deadpool", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0414\u0435\u0430\u0434\u043f\u0443\u043b\u0430", new ResourceLocation("minidot", "masks/mrv_deadpool.png"))).setDescription(list));
        skins.put("mrv_ironman", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0416\u0435\u043b\u0435\u0437\u043d\u043e\u0433\u043e \u0447\u0435\u043b\u043e\u0432\u0435\u043a\u0430", new ResourceLocation("minidot", "masks/mrv_ironman.png"))).setDescription(list));
        skins.put("mrv_nick_fury", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u041d\u0438\u043a\u0430 \u0424\u044c\u044e\u0440\u0438", new ResourceLocation("minidot", "masks/mrv_nick_fury.png"))).setDescription(list));
        skins.put("mrv_captain_america", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u041a\u0430\u043f\u0438\u0442\u0430\u043d\u0430 \u0410\u043c\u0435\u0440\u0438\u043a\u0438", new ResourceLocation("minidot", "masks/mrv_captain_america.png"))).setDescription(list));
        skins.put("mrv_spiderman", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0427\u0435\u043b\u043e\u0432\u0435\u043a\u0430 \u041f\u0430\u0443\u043a\u0430", new ResourceLocation("minidot", "masks/mrv_spiderman.png"))).setDescription(list));
        skins.put("mrv_groot", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0413\u0440\u0443\u0442\u0430", new ResourceLocation("minidot", "masks/mrv_groot.png"))).setDescription(list));
        list = MNaming.fromGame("PAYDAY");
        skins.put("payday_dallas", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0414\u0430\u043b\u043b\u0430\u0441\u0430", new ResourceLocation("minidot", "masks/payday_dallas.png"))).setDescription(list));
        skins.put("payday_hoxton", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0425\u043e\u043a\u0441\u0442\u043e\u043d\u0430", new ResourceLocation("minidot", "masks/payday_hoxton.png"))).setDescription(list));
        skins.put("payday_wolf", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0412\u0443\u043b\u0444\u0430", new ResourceLocation("minidot", "masks/payday_wolf.png"))).setDescription(list));
        skins.put("payday_chains", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0427\u0435\u0439\u043d\u0441\u0430", new ResourceLocation("minidot", "masks/payday_chains.png"))).setDescription(list));
        list = MNaming.fromMult("\u0412\u0440\u0435\u043c\u044f \u041f\u0440\u0438\u043a\u043b\u044e\u0447\u0435\u043d\u0438\u0439");
        skins.put("at_finn", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0424\u0438\u043d\u0430", new ResourceLocation("minidot", "masks/at_finn.png"))).setDescription(list));
        skins.put("at_jake", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0414\u0436\u0435\u0439\u043a\u0430", new ResourceLocation("minidot", "masks/at_jake.png"))).setDescription(list));
        list = Collections.<String>singletonList(EnumChatFormatting.BOLD + "DC Comics");
        skins.put("dc_joker", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0414\u0436\u043e\u043a\u0435\u0440\u0430", new ResourceLocation("minidot", "masks/dc_joker.png"))).setDescription(list));
        skins.put("dc_batman", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0411\u044d\u0442\u043c\u0435\u043d\u0430", new ResourceLocation("minidot", "masks/dc_batman.png"))).setDescription(list));
        skins.put("dc_bane", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0411\u044d\u0439\u043d\u0430", new ResourceLocation("minidot", "masks/dc_bane.png"))).setDescription(list));
        list = MNaming.fromGame("DOTA 2");
        skins.put("d2_jugger", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 Juggernaut", new ResourceLocation("minidot", "masks/d2_juggernaut.png"))).setDescription(list));
        skins.put("d2_void", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 Void", new ResourceLocation("minidot", "masks/d2_void.png"))).setDescription(list));
        skins.put("d2_axe", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 Axe", new ResourceLocation("minidot", "masks/d2_axe.png"))).setDescription(list));
        skins.put("d2_rubik", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 Rubick", new ResourceLocation("minidot", "masks/d2_rubik.png"))).setDescription(list));
        skins.put("d2_bh", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 Bounty Hunter", new ResourceLocation("minidot", "masks/d2_bh.png"))).setDescription(list));
        skins.put("d2_invoker", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 Invoker", new ResourceLocation("minidot", "masks/d2_invoker.png"))).setDescription(list));
        skins.put("d2_tidehunter", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 Tidehunter", new ResourceLocation("minidot", "masks/d2_tidehunter.png"))).setDescription(list));
        skins.put("d2_drowranger", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 Drow Ranger", new ResourceLocation("minidot", "masks/d2_drowranger.png"))).setDescription(list));
        skins.put("d2_riki", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 Riki", new ResourceLocation("minidot", "masks/d2_riki.png"))).setDescription(list));
        skins.put("d2_sk", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 Skeleton King", new ResourceLocation("minidot", "masks/d2_sk.png"))).setDescription(list));
        skins.put("d2_kunkka", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 Kunkka", new ResourceLocation("minidot", "masks/d2_kunkka.png"))).setDescription(list));
        skins.put("d2_lycan", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 Lycan", new ResourceLocation("minidot", "masks/d2_lycan.png"))).setDescription(list));
        skins.put("d2_antimage", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 Anti-mage", new ResourceLocation("minidot", "masks/d2_antimage.png"))).setDescription(list));
        skins.put("d2_templar", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 Templar Assasin", new ResourceLocation("minidot", "masks/d2_templar_assasin.png"))).setDescription(list));
        skins.put("d2_pudge", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 Pudge", new ResourceLocation("minidot", "masks/d2_pudge.png"))).setDescription(list));
        skins.put("d2_lina", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 Lina", new ResourceLocation("minidot", "masks/d2_lina.png"))).setDescription(list));
        skins.put("d2_cm", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 Crystal Maiden", new ResourceLocation("minidot", "masks/d2_crystal_maidan.png"))).setDescription(list));
        skins.put("d2_slark", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 Slark", new ResourceLocation("minidot", "masks/d2_slark.png"))).setDescription(list));
        skins.put("d2_dk", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 Dragon Knight", new ResourceLocation("minidot", "masks/d2_dk.png"))).setDescription(list));
        skins.put("d2_fura", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 Nature\'s Prophet", new ResourceLocation("minidot", "masks/d2_fura.png"))).setDescription(list));
        skins.put("d2_bs", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 Bloodseeker", new ResourceLocation("minidot", "masks/d2_bloodseeker.png"))).setDescription(list));
        skins.put("d2_abbadon", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 Abbadon", new ResourceLocation("minidot", "masks/d2_abbadon.png"))).setDescription(list));
        skins.put("d2_undying", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 Undying", new ResourceLocation("minidot", "masks/d2_undying.png"))).setDescription(list));
        skins.put("d2_pl", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 Phantom Lancer", new ResourceLocation("minidot", "masks/d2_pl.png"))).setDescription(list));
        skins.put("d2_warlock", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 Warlock", new ResourceLocation("minidot", "masks/d2_warlock.png"))).setDescription(list));
        list = MNaming.fromMult("TMNT");
        skins.put("tmnt_donatello", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0414\u043e\u043d\u0430\u0442\u0435\u043b\u043b\u043e", new ResourceLocation("minidot", "masks/tmnt_donatello.png"))).setDescription(list));
        skins.put("tmnt_leonardo", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u041b\u0435\u043e\u043d\u0430\u0440\u0434\u043e", new ResourceLocation("minidot", "masks/tmnt_leonardo.png"))).setDescription(list));
        skins.put("tmnt_michelangelo", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u041c\u0438\u043a\u0435\u043b\u0430\u043d\u0434\u0436\u0435\u043b\u043e", new ResourceLocation("minidot", "masks/tmnt_michelangelo.png"))).setDescription(list));
        skins.put("tmnt_raphael", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0420\u0430\u0444\u0430\u044d\u043b\u044f", new ResourceLocation("minidot", "masks/tmnt_raphael.png"))).setDescription(list));
        list = MNaming.fromMult("My little pony");
        skins.put("mlp_rainbow_dash", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0420\u0430\u0434\u0443\u0433\u0438 \u0414\u044d\u0448", new ResourceLocation("minidot", "masks/mlp_rainbow_dash.png"))).setDescription(list));
        skins.put("mlp_fluttershy", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0424\u043b\u0430\u0442\u0442\u0435\u0440\u0448\u0430\u0439", new ResourceLocation("minidot", "masks/mlp_fluttershy.png"))).setDescription(list));
        skins.put("mlp_twilight_sparkle", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0421\u0443\u043c\u0435\u0440\u0435\u0447\u043d\u043e\u0439 \u0418\u0441\u043a\u043e\u0440\u043a\u0438", new ResourceLocation("minidot", "masks/mlp_twilight_sparkle.png"))).setDescription(list));
        skins.put("mlp_applejack", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u042d\u043f\u043f\u043b\u0434\u0436\u0435\u043a", new ResourceLocation("minidot", "masks/mlp_applejack.png"))).setDescription(list));
        skins.put("mlp_rarity", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0420\u0430\u0440\u0438\u0442\u0438", new ResourceLocation("minidot", "masks/mlp_rarity.png"))).setDescription(list));
        skins.put("mlp_pinki_pie", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u041f\u0438\u043d\u043a\u0438 \u041f\u0430\u0439", new ResourceLocation("minidot", "masks/mlp_pinki_pie.png"))).setDescription(list));
        skins.put("mlp_celestia", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u041f\u0440\u0438\u043d\u0446\u0435\u0441\u0441\u044b \u0421\u0435\u043b\u0435\u0441\u0442\u0438\u0438", new ResourceLocation("minidot", "masks/mlp_celestia.png"))).setDescription(list));
        skins.put("mlp_luna", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u041f\u0440\u0438\u043d\u0446\u0435\u0441\u0441\u044b \u041b\u0443\u043d\u044b", new ResourceLocation("minidot", "masks/mlp_luna.png"))).setDescription(list));
        list = MNaming.fromMult("\u041f\u043e\u043a\u0435\u043c\u043e\u043d");
        skins.put("pikachu", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u041f\u0438\u043a\u0430\u0447\u0443", new ResourceLocation("minidot", "masks/pikachu.png"))).setDescription(list));
        list = MNaming.fromMult("\u0421\u0442\u0430\u0440 \u043f\u0440\u043e\u0442\u0438\u0432 \u0441\u0438\u043b \u0437\u043b\u0430");
        skins.put("svtfoe_eclipsa", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u042d\u043a\u043b\u0438\u043f\u0441\u044b", new ResourceLocation("minidot", "masks/svtfoe_eclipsa.png"))).setDescription(list));
        skins.put("svtfoe_heckapoo", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0425\u0438\u043a\u0430\u043f\u0443", new ResourceLocation("minidot", "masks/svtfoe_heckapoo.png"))).setDescription(list));
        skins.put("svtfoe_moon", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u041c\u0443\u043d", new ResourceLocation("minidot", "masks/svtfoe_moon.png"))).setDescription(list));
        skins.put("svtfoe_talon", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0422\u0430\u043b\u043e\u043d\u0430", new ResourceLocation("minidot", "masks/svtfoe_talon.png"))).setDescription(list));
        skins.put("svtfoe_star", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0421\u0442\u0430\u0440", new ResourceLocation("minidot", "masks/svtfoe_star.png"))).setDescription(list));
        skins.put("svtfoe_mewberty", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0421\u0442\u0430\u0440 \u0432 \u043c\u044c\u044e\u0437\u0440\u0435\u0432\u0430\u043d\u0438\u0438", new ResourceLocation("minidot", "masks/svtfoe_mewberty.png"))).setDescription(list));
        skins.put("svtfoe_toffee", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0422\u043e\u0444\u0444\u0438", new ResourceLocation("minidot", "masks/svtfoe_toffee.png"))).setDescription(list));
        skins.put("svtfoe_glossaryck", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0413\u043b\u043e\u0441\u0441\u0430\u0440\u0438\u043a\u0430", new ResourceLocation("minidot", "masks/svtfoe_glossaryck.png"))).setDescription(list));
        skins.put("svtfoe_globgor", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0413\u043b\u043e\u0431\u0433\u043e\u0440\u0430", new ResourceLocation("minidot", "masks/svtfoe_globgor.png"))).setDescription(list));
        skins.put("svtfoe_meteora", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u041c\u0435\u0442\u0435\u043e\u0440\u044b", new ResourceLocation("minidot", "masks/svtfoe_meteora.png"))).setDescription(list));
        skins.put("svtfoe_rhombulus", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0420\u043e\u043c\u0431\u0443\u043b\u0443\u0441\u0430", new ResourceLocation("minidot", "masks/svtfoe_rhombulus.png"))).setDescription(list));
        skins.put("svtfoe_jenna", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0414\u0436\u0435\u043d\u043d\u044b", new ResourceLocation("minidot", "masks/svtfoe_jenna.png"))).setDescription(list));
        skins.put("svtfoe_solaria", (new ModelMask.MaskSkin("\u041c\u0430\u0441\u043a\u0430 \u0421\u043e\u043b\u044f\u0440\u0438\u0438", new ResourceLocation("minidot", "masks/svtfoe_solaria.png"))).setDescription(list));
    }

    private static class MaskSkin
    {
        final ResourceLocation texture;
        final String name;
        List<String> description = null;

        public MaskSkin(String name, ResourceLocation texture)
        {
            this.name = name;
            this.texture = texture;
        }

        public ModelMask.MaskSkin setDescription(String desc)
        {
            this.description = Collections.<String>singletonList(desc);
            return this;
        }

        public ModelMask.MaskSkin setDescription(List<String> desc)
        {
            this.description = desc;
            return this;
        }
    }
}
