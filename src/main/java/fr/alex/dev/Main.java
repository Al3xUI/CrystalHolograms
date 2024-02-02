package fr.alex.dev;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    public void onEnable() {
        instance = this;
        getCommand("hologram").setExecutor(new HologramCommand(this));
        getCommand("createh").setExecutor(new hologramCreateCommand(this));
    }

    public static Main getInstance() {
        return instance;
    }
}