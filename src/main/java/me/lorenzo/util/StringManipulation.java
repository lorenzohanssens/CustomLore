package me.lorenzo.util;

import org.bukkit.ChatColor;

public class StringManipulation {
    public static String getArguments(String[] s) {
        String arguments = "";
        for (String args : s) {
            arguments += args + " ";
        }

        return ChatColor.translateAlternateColorCodes('&', arguments);
    }
}
