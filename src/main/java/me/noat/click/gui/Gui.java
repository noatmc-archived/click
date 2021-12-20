package me.noat.click.gui;

import me.noat.click.Clicker;
import me.noat.click.util.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

import java.awt.*;

public class Gui extends GuiScreen {

    static int x;

    public Gui() {
        x = 60;
    }
    @Override
    public void drawScreen(int mX, int mY, float partialTicks) {
        // i need to do drawRoundedRect instead of drawRect because my render is bugged or some shit
        // -----------------------------------------------------------------------------------------
        // clickgui render
        RenderUtil.drawRoundedRect(10, 10, 300, 120, 10, new Color(30, 30, 30, 255));
        RenderUtil.drawRoundedRect(10, 40, 300, 10, 0, new Color(255, 255, 255));
        mc.fontRendererObj.drawString( "click v0.1 - by noat", 110, 20, new Color(255, 255, 255, 255).hashCode());
        // cps slider
        RenderUtil.drawRoundedRect(60, 75, 200, 5, 5, new Color(255, 255, 255));
        RenderUtil.drawRoundedRect(x, 70, 15, 15, 15, new Color(255, 255, 255));
        mc.fontRendererObj.drawString("cps - " + getCps(), 135, 95, new Color(255, 255, 255).hashCode());
        // enable button
        RenderUtil.drawRoundedRect(280, 20, 10, 10, 0, new Color(!Clicker.enabled ? 255:0, Clicker.enabled ? 255 : 0, 0));
    }

    @Override
    public void mouseClicked(int mx, int my, int mouseButton) {
        if (isInArea(mx, my, 60, 260, 75, 80)) {
            x = mx;
        } else if (isInArea(mx, my, 280, 290, 20, 30)) {
            Clicker.enabled = !Clicker.enabled;
        }
    }

    public static int getCps() {
        return (int)Math.floor((x - 60) / 10f);
    }

    boolean isInArea(int mX,int mY, int areaStartX, int areaEndX, int areaStartY, int areaEndY) {
        return (mX >= areaStartX && areaEndX >= mX) && (mY >= areaStartY && areaEndY >= mY);
    }

}
