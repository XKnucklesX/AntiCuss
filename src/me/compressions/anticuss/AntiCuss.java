package me.compressions.anticuss;

import me.compressions.anticuss.commands.AntiCussCommand;
import me.compressions.anticuss.commands.Chat;
import me.compressions.anticuss.commands.Clear;
import me.compressions.anticuss.commands.Reload;
import net.milkbowl.vault.economy.Economy;

import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiCuss extends JavaPlugin {
    
    public AntiCuss plugin;
    
    public boolean chatMuted;
	
public static Economy econ = null;
	
	private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
	

	public void onEnable() {
		getLogger().info("AntiCuss enabled!");
		getConfig().options().copyDefaults(true);
		saveConfig();
		getServer().getPluginManager().registerEvents(new AntiCussListener(this), this);
		getServer().getPluginManager().registerEvents(new MuteListener(this), this);
		getCommand("anticuss").setExecutor(new AntiCussCommand(this));
		getCommand("acreload").setExecutor(new Reload(this));
		getCommand("clearchat").setExecutor(new Clear(this));
		getCommand("chat").setExecutor(new Chat(this));
		
		if (!setupEconomy() ) {
            getLogger().severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
		}
	}
	
	public void onDisable() {
		getLogger().info("AntiCuss has been disabled!");
	}

}
