package net.minecraft.client;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import net.minecraft.client.resources.DefaultResourcePack;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.IOUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;

public class AWTWindow extends Frame
{
    private Canvas canvas;
    private Minecraft mc;
    private boolean lastFullscreen;

    public AWTWindow(final Minecraft p_i23_1_, DefaultResourcePack p_i23_2_)
    {
        super("VimeWorld");
        this.mc = p_i23_1_;
        this.setResizable(true);
        this.canvas = new Canvas();
        this.canvas.setIgnoreRepaint(true);
        this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent p_windowClosing_1_)
            {
                p_i23_1_.shutdown();
            }
        });
        Toolkit.getDefaultToolkit().setDynamicLayout(true);
        this.setLayout(new BorderLayout());
        this.add(this.canvas, "Center");

        try
        {
            InputStream inputstream = p_i23_2_.getInputStream(new ResourceLocation("icons/icon_32x32.png"));
            ImageIcon imageicon = new ImageIcon(IOUtils.toByteArray(inputstream));
            this.setIconImage(imageicon.getImage());
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
    }

    public void updateDisplay() throws LWJGLException
    {
        Display.setVSyncEnabled(this.mc.gameSettings.enableVsync);

        if (this.mc.isFullScreen())
        {
            Display.setParent((Canvas)null);
            SwingUtilities.invokeLater(() ->
            {
                this.setVisible(false);
            });
        }
        else
        {
            SwingUtilities.invokeLater(() ->
            {
                this.canvas.setPreferredSize(new Dimension(this.mc.displayWidth, this.mc.displayHeight));
                this.pack();
            });
            Display.setParent(this.canvas);

            if (!this.isVisible())
            {
                SwingUtilities.invokeLater(() ->
                {
                    this.setLocationRelativeTo((Component)null);
                });
                this.setVisible(true);
            }

            if (this.lastFullscreen)
            {
                SwingUtilities.invokeLater(this::toFront);
            }
        }

        this.lastFullscreen = this.mc.isFullScreen();
    }
}
