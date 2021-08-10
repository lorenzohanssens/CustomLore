package me.lorenzo.commands;

import me.lorenzo.CustomLore;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

import static me.lorenzo.util.StringManipulation.getArguments;

public class SetLore implements CommandExecutor {

    String setLoreCommand = CustomLore.setLoreCommand;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(command.getName().equalsIgnoreCase(setLoreCommand)) {
            if(!(commandSender instanceof Player)) {
                commandSender.sendMessage("Only players can perform this command!");
            }
            else {
            Player p = (Player) commandSender;
            if(!p.hasPermission("customlore.setlore")) {
                commandSender.sendMessage(ChatColor.RED + "You do not have the customlore.setlore permission!");
            }
            else {
                if(p.getItemInHand().getType() == Material.AIR) {
                    commandSender.sendMessage(ChatColor.RED + "You must be holding an item!");
                }
                else if(args == null){
                    commandSender.sendMessage(ChatColor.RED + "Please provide a name!");

                }
                else {
                    ItemStack playerItem = p.getItemInHand();
                    ItemMeta playerItemMeta = playerItem.getItemMeta();
                    playerItemMeta.setLore(Collections.singletonList(getArguments(args)));
                    playerItem.setItemMeta(playerItemMeta);
                    p.sendMessage(ChatColor.GREEN + "Applied!");
                }
            }
            }
        }
        return true;
    }
}
