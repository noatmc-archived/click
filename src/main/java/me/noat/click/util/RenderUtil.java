package me.noat.click.util;

import net.minecraft.client.gui.Gui;
import org.lwjgl.opengl.GL11;

import java.awt.*;

import static org.lwjgl.opengl.GL11.*;

public class RenderUtil {
    public static void drawRoundedRect(double x, double y, double width, double height, double radius, Color color) {
        glPushAttrib(GL_POINTS);
        glScaled(0.5, 0.5, 0.5); {
            x *= 2;
            y *= 2;
            width *= 2;
            height *= 2;
            width += x;
            height += y;
            glEnable(GL_BLEND);
            glDisable(GL_TEXTURE_2D);
            glColor4f(color.getRed() / 255F, color.getGreen() / 255F, color.getBlue() / 255F, color.getAlpha() / 255F);
            glEnable(GL_LINE_SMOOTH);
            glBegin(GL_POLYGON);
            int i;
            for (i = 0; i <= 90; i++) {
                glVertex2d(x + radius + Math.sin(i * Math.PI / 180.0D) * radius * -1.0D, y + radius + Math.cos(i * Math.PI / 180.0D) * radius * -1.0D);
            }
            for (i = 90; i <= 180; i++) {
                glVertex2d(x + radius + Math.sin(i * Math.PI / 180.0D) * radius * -1.0D, height - radius + Math.cos(i * Math.PI / 180.0D) * radius * -1.0D);
            }
            for (i = 0; i <= 90; i++) {
                glVertex2d(width - radius + Math.sin(i * Math.PI / 180.0D) * radius, height - radius + Math.cos(i * Math.PI / 180.0D) * radius);
            }
            for (i = 90; i <= 180; i++) {
                glVertex2d(width - radius + Math.sin(i * Math.PI / 180.0D) * radius, y + radius + Math.cos(i * Math.PI / 180.0D) * radius);
            }
            glEnd();
            glEnable(GL_TEXTURE_2D);
            glDisable(GL_BLEND);
            glDisable(GL_LINE_SMOOTH);
            glDisable(GL_BLEND);
            glEnable(GL_TEXTURE_2D);
        }
        glScaled(2, 2, 2);
        glPopAttrib();
    }

    public static void drawRect(final int x,  final int y,  final int width,  final int height,  int color) {
        Gui.drawRect(x,  y,  x + width,  y + height,  color);
    }
}
