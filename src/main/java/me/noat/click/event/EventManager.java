package me.noat.click.event;

import me.noat.click.Clicker;
import me.noat.click.gui.Gui;
import me.noat.click.util.Timer;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class EventManager {
    Timer timer = new Timer();
    public EventManager() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
            Minecraft.getMinecraft().displayGuiScreen(new Gui());
        }
        if (Mouse.isButtonDown(0)) {
            if (Clicker.enabled) {
                Clicker.click();
            }
        }
        if (timer.passedMs(1000)) {
            Clicker.clicks = 1;
            timer.reset();
        }
    }
}
