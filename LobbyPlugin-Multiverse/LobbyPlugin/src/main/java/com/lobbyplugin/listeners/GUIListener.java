package com.lobbyplugin.listeners;

import com.lobbyplugin.LobbyPlugin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GUIListener implements Listener {

    private final LobbyPlugin plugin;

    public GUIListener(LobbyPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player player)) return;
        if (!event.getView().getTitle().equals(ChatColor.DARK_PURPLE + "» Server Selector «")) return;

        event.setCancelled(true);
        if (event.getCurrentItem() == null) return;

        switch (event.getSlot()) {
            case 10 -> plugin.getServerSelectorGUI().teleportToWorld(player, "world_pvp", "PvP", ChatColor.RED);
            case 12 -> plugin.getServerSelectorGUI().teleportToWorld(player, "world_parkour", "Parkour", ChatColor.GREEN);
            case 14 -> plugin.getServerSelectorGUI().teleportToWorld(player, "world_training", "Training", ChatColor.AQUA);
            case 16 -> plugin.getServerSelectorGUI().teleportToWorld(player, "world_survival", "Survival", ChatColor.GOLD);
        }
    }
}
