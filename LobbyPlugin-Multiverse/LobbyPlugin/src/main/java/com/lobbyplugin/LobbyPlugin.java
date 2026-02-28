package com.lobbyplugin;

import com.lobbyplugin.commands.HubCommand;
import com.lobbyplugin.gui.ServerSelectorGUI;
import com.lobbyplugin.listeners.GUIListener;
import com.lobbyplugin.listeners.LobbyListener;
import org.bukkit.plugin.java.JavaPlugin;

public class LobbyPlugin extends JavaPlugin {

    private static LobbyPlugin instance;
    private ServerSelectorGUI serverSelectorGUI;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        this.serverSelectorGUI = new ServerSelectorGUI(this);
        getServer().getPluginManager().registerEvents(new GUIListener(this), this);
        getServer().getPluginManager().registerEvents(new LobbyListener(this), this);
        getCommand("hub").setExecutor(new HubCommand(this));
        getCommand("lobby").setExecutor(new HubCommand(this));
        getCommand("server").setExecutor(new HubCommand(this));
        getLogger().info("LobbyPlugin enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("LobbyPlugin disabled!");
    }

    public static LobbyPlugin getInstance() { return instance; }
    public ServerSelectorGUI getServerSelectorGUI() { return serverSelectorGUI; }
}
