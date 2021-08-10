package me.justalorenzo.commands;

import me.justalorenzo.CustomLore;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SetName implements CommandExecutor {

    String setNameCommand = CustomLore.setNameCommand;


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase(setNameCommand)) {
            if (commandSender instanceof Player) {
                Player p = (Player) commandSender;
                //if they're holding an item aka not AIR
                if (p.getItemInHand().getType() != Material.AIR) {
                    p.sendMessage(p.getItemInHand().getType().toString());
                    if (p.hasPermission("customlore.setname")) {
                        if (args != null) {
                            ItemStack playerItem = p.getItemInHand();
                            ItemMeta playerItemMeta = playerItem.getItemMeta();
                            playerItemMeta.setDisplayName(getArguments(args));
                            playerItem.setItemMeta(playerItemMeta);
                            p.sendMessage(ChatColor.GREEN + "Applied!");
                        } else {
                            commandSender.sendMessage(ChatColor.RED + "Please provide a name!");

                        }

                    } else {
                        commandSender.sendMessage(ChatColor.RED + "You do not have the customlore.setname permission!");
                    }
                } else {
                    commandSender.sendMessage(ChatColor.RED + "You must be holding an item!");
                }

            } else {
                commandSender.sendMessage("Only players can perform this command!");
            }

        }
        return true;
    }


    String getArguments(String[] s) {
        String arguments = "";
        for (String args : s) {
            arguments += args + " ";
        }

        return ChatColor.translateAlternateColorCodes('&', arguments);
    }

}
