package fr.alex.dev;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class hologramCreateCommand implements CommandExecutor {

    private final Main plugin;

    public hologramCreateCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length >= 1) {
                StringBuilder customText = new StringBuilder();
                for (String arg : args) {
                    customText.append(arg).append(" ");
                }

                customText.deleteCharAt(customText.length() - 1); // Supprime l'espace final

                createHologram(player, customText.toString());
                return true;
            } else {
                player.sendMessage(ChatColor.RED + "Utilisation: /createh <texte personnalisé>");
                return false;
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Cette commande doit être exécutée par un joueur.");
            return false;
        }
    }

    private void createHologram(Player player, String customText) {
        ArmorStand hologram = (ArmorStand) player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
        hologram.setVisible(false);
        hologram.setCustomNameVisible(true);
        hologram.setGravity(false);
        hologram.setCustomName(ChatColor.translateAlternateColorCodes('&', customText));
    }
}