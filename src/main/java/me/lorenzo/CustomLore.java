package me.lorenzo;

import me.lorenzo.commands.SetName;
import me.lorenzo.commands.SetLore;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomLore extends JavaPlugin {
    public static String setLoreCommand = "setLore";
    public static String setNameCommand = "setName";
    SetName setName = new SetName();
    SetLore setLore = new SetLore();

    @Override
    public void onEnable() {
        initializeCommands();
    }

    void initializeCommands() {
        this.getCommand(setNameCommand).setExecutor(setName);
        this.getCommand(setLoreCommand).setExecutor(setLore);
    }


}
