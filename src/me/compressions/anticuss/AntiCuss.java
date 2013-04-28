package me.compressions.anticuss;

import org.bukkit.plugin.java.JavaPlugin;

public class AntiCuss extends JavaPlugin {

	
	public void onEnable() {
		this.getLogger().info("AntiCuss enabled!");
		getConfig().options().copyDefaults(true);
		saveConfig();
		getServer().getPluginManager().registerEvents(new AntiCussListener(this), this); //error on new AntiCussListener()
		getCommand("anticuss").setExecutor(new AntiCussCommandExecutor(this));
	}
	
	public void onDisable() {
		
	}

}
