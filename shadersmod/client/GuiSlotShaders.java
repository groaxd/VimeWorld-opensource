package shadersmod.client;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import net.minecraft.client.gui.GuiSlot;
import net.xtrafrancyz.VimeShaderUtil;
import optifine.Lang;

class GuiSlotShaders extends GuiSlot
{
    private final Map<String, VimeShaderUtil.Verifier.Status> shadersStatusCache = new HashMap();
    private ArrayList<String> shaderslist;
    private int selectedIndex;
    private long lastClickedCached = 0L;
    final GuiShaders shadersGui;

    public GuiSlotShaders(GuiShaders par1GuiShaders, int width, int height, int top, int bottom, int slotHeight)
    {
        super(par1GuiShaders.getMc(), width, height, top, bottom, slotHeight);
        this.shadersGui = par1GuiShaders;
        this.updateList();
        this.amountScrolled = 0.0F;
        int i = this.selectedIndex * slotHeight;
        int j = (bottom - top) / 2;

        if (i > j)
        {
            this.scrollBy(i - j);
        }
    }

    /**
     * Gets the width of the list
     */
    public int getListWidth()
    {
        return this.width - 20;
    }

    public void updateList()
    {
        this.shaderslist = Shaders.listOfShaders();
        this.selectedIndex = 0;
        int i = 0;

        for (int j = this.shaderslist.size(); i < j; ++i)
        {
            if (((String)this.shaderslist.get(i)).equals(Shaders.currentshadername))
            {
                this.selectedIndex = i;
                break;
            }
        }

        this.shadersStatusCache.clear();
    }

    protected int getSize()
    {
        return this.shaderslist.size();
    }

    /**
     * The element in the slot that was clicked, boolean for whether it was double clicked or not
     */
    protected void elementClicked(int index, boolean doubleClicked, int mouseX, int mouseY)
    {
        if (index != this.selectedIndex || this.lastClicked != this.lastClickedCached)
        {
            Shaders.setShaderPack((String)this.shaderslist.get(index));
            Shaders.uninit();

            if (Objects.equals(Shaders.currentshadername, this.shaderslist.get(index)))
            {
                this.selectedIndex = index;
                this.lastClickedCached = this.lastClicked;
            }

            this.shadersGui.updateButtons();
        }
    }

    /**
     * Returns true if the element passed in is currently selected
     */
    protected boolean isSelected(int index)
    {
        return index == this.selectedIndex;
    }

    protected int getScrollBarX()
    {
        return this.width - 6;
    }

    /**
     * Return the height of the content being scrolled
     */
    protected int getContentHeight()
    {
        return this.getSize() * 18;
    }

    protected void drawBackground()
    {
    }

    protected void drawSlot(int index, int posX, int posY, int contentY, int mouseX, int mouseY)
    {
        String s = (String)this.shaderslist.get(index);

        if (s.equals(Shaders.packNameNone))
        {
            s = Lang.get("of.options.shaders.packNone");
        }
        else if (s.equals(Shaders.packNameDefault))
        {
            s = Lang.get("of.options.shaders.packDefault");
        }
        else
        {
            VimeShaderUtil.Verifier.Status vimeshaderutil$verifier$status = (VimeShaderUtil.Verifier.Status)this.shadersStatusCache.computeIfAbsent(s, (s0) ->
            {
                return VimeShaderUtil.Verifier.instance().getStatus(new File(Shaders.shaderpacksdir, s0));
            });

            switch (vimeshaderutil$verifier$status)
            {
                case ERROR:
                    s = s + " \u00a7f(\u00a7c\u041e\u0448\u0438\u0431\u043a\u0430 \u043f\u0440\u0438 \u043f\u0440\u043e\u0432\u0435\u0440\u043a\u0435\u00a7f)";
                    break;

                case DENY:
                    s = "\u00a77" + s + " \u00a77(\u00a7c\u0428\u0435\u0439\u0434\u0435\u0440 \u043d\u0435 \u0432\u0445\u043e\u0434\u0438\u0442 \u0432 \u0441\u043f\u0438\u0441\u043e\u043a \u0440\u0430\u0437\u0440\u0435\u0448\u0435\u043d\u043d\u044b\u0445\u00a77)";
                    break;

                case VALIDATING:
                    s = s + " \u00a7f(\u00a77\u0418\u0434\u0435\u0442 \u043f\u0440\u043e\u0432\u0435\u0440\u043a\u0430...\u00a7f)";
            }
        }

        this.shadersGui.drawCenteredString(s, this.width / 2, posY + 1, 16777215);
    }

    public int getSelectedIndex()
    {
        return this.selectedIndex;
    }
}
