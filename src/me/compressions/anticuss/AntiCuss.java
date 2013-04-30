package me.compressions.anticuss;

import me.compressions.anticuss.commands.AntiCussCommand;
import me.compressions.anticuss.commands.Clear;
import me.compressions.anticuss.commands.Reload;

import org.bukkit.plugin.java.JavaPlugin;

public class AntiCuss extends JavaPlugin {

	
	public void onEnable() {
		getLogger().info("AntiCuss has been enabled!");
		getConfig().options().copyDefaults(true);
		saveConfig();
		getServer().getPluginManager().registerEvents(new AntiCussListener(this), this);
		getCommand("anticuss").setExecutor(new AntiCussCommand(this));
		getCommand("acreload").setExecutor(new Reload(this));
		getCommand("clearchat").setExecutor(new Clear(this));
	}
	
	public void onDisable() {
		getLogger().info("AntiCuss has been disabled!");
	}

}
