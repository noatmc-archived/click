package me.noat.click;

import me.noat.click.event.EventManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.lwjgl.opengl.Display;

@Mod(modid = Click.MODID, version = Click.VERSION, clientSideOnly = true)
public class Click {
    public static final String MODID = "clicker";
    public static final String VERSION = "0.1";

    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        new EventManager();
        System.out.println("initialized eventmanager!");
        Display.setTitle("noat.click v0.1");
    }
}
