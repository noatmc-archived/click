package me.noat.click;

import me.noat.click.gui.Gui;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

public class Clicker {
    public static boolean enabled=true;
    public static int clicks = 0;

    public static void click() {
        if (clicks < Gui.getCps()) {
            clicks++;
            int key = Minecraft.getMinecraft().gameSettings.keyBindAttack.getKeyCode();
            KeyBinding.setKeyBindState(key, true);
            KeyBinding.onTick(key);
        }
    }
}
