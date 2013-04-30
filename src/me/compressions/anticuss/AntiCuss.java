package me.compressions.anticuss;

import org.bukkit.plugin.java.JavaPlugin;

public class AntiCuss extends JavaPlugin {

	
	public void onEnable() {
		getConfig().options().copyDefaults(true);
		saveConfig();
		getServer().getPluginManager().registerEvents(new AntiCussListener(this), this);
		getCommand("anticuss").setExecutor(new AntiCussCommandExecutor(this));
	}
	
	public void onDisable() {
		
	}

}
