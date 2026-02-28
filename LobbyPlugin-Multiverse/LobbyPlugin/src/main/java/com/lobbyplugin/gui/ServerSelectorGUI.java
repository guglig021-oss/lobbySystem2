package com.lobbyplugin.gui;

import com.lobbyplugin.LobbyPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ServerSelectorGUI {

    private final LobbyPlugin plugin;

    public ServerSelectorGUI(LobbyPlugin plugin) {
        this.plugin = plugin;
    }

    public void open(Player player) {
        Inventory inv = Bukkit.createInventory(null, 27, ChatColor.DARK_PURPLE + "» Server Selector «");

        ItemStack filler = createItem(Material.GRAY_STAINED_GLASS_PANE, " ");
        for (int i = 0; i < 27; i++) inv.setItem(i, filler);

        inv.setItem(10, createItem(Material.DIAMOND_SWORD,
                ChatColor.RED + "" + ChatColor.BOLD + "PvP",
                ChatColor.GRAY + "Click to join PvP!",
                ChatColor.YELLOW + "Fight other players!"));

        inv.setItem(12, createItem(Material.FEATHER,
                ChatColor.GREEN + "" + ChatColor.BOLD + "Parkour",
                ChatColor.GRAY + "Click to join Parkour!",
                ChatColor.YELLOW + "Test your skills!"));

        inv.setItem(14, createItem(Material.WOODEN_SWORD,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Training",
                ChatColor.GRAY + "Click to join Training!",
                ChatColor.YELLOW + "Practice and improve!"));

        inv.setItem(16, createItem(Material.GRASS_BLOCK,
                ChatColor.GOLD + "" + ChatColor.BOLD + "Survival",
                ChatColor.GRAY + "Click to join Survival!",
                ChatColor.YELLOW + "Survive and thrive!"));

        player.openInventory(inv);
    }

    public void teleportToWorld(Player player, String worldName, String displayName, ChatColor color) {
        World world = Bukkit.getWorld(worldName);
        if (world == null) {
            player.sendMessage(ChatColor.RED + "World '" + worldName + "' not found! Make sure Multiverse-Core is installed and the world exists.");
            return;
        }
        player.teleport(world.getSpawnLocation());
        player.sendMessage(color + "Teleported to " + displayName + "!");
    }

    private ItemStack createItem(Material material, String name, String... lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(name);
            if (lore.length > 0) meta.setLore(Arrays.asList(lore));
            item.setItemMeta(meta);
        }
        return item;
    }
}
