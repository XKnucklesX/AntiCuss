package me.compressions.anticuss;

import me.compressions.anticuss.commands.AntiCussCommand;
import me.compressions.anticuss.commands.Clear;
import me.compressions.anticuss.commands.Mute;
import me.compressions.anticuss.commands.Reload;

import org.bukkit.plugin.java.JavaPlugin;

public class AntiCuss extends JavaPlugin {
	
	public boolean muted;

	//testf
	public void onEnable() {
		getLogger().info("AntiCuss enabled!");
		getConfig().options().copyDefaults(true);
		saveConfig();
		getServer().getPluginManager().registerEvents(new AntiCussListener(this), this);
		getCommand("anticuss").setExecutor(new AntiCussCommand(this));
		getCommand("acreload").setExecutor(new Reload(this));
		getCommand("clearchat").setExecutor(new Clear(this));
		getCommand("mutechat").setExecutor(new Mute(this));
<<<<<<< HEAD
		getCommand("mutechat").setExecutor(new Clear(this));
=======
>>>>>>> d70321a6782ae59e27f3e16aedc4a2c34a71deab
	}
	
	public void onDisable() {
		getLogger().info("AntiCuss has been disabled!");
	}

}
