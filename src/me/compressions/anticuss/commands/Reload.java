package me.compressions.anticuss.commands;

import me.compressions.anticuss.AntiCuss;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Reload implements CommandExecutor {
	
	public AntiCuss plugin;
	public Reload(AntiCuss instance) {
		plugin = instance;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "You must be a player to execute this command!");
		} else {
			Player p = (Player) sender;
			if(cmd.getName().equalsIgnoreCase("acreload")) {
				if(args.length == 0) {
					if(!p.hasPermission("anticuss.reload")) {
						p.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");	
					} else if(p.hasPermission("anticuss.reload")) {
							plugin.reloadConfig();
							plugin.saveConfig();
							p.sendMessage(ChatColor.GREEN + "AntiCuss config reloaded!");
					}
				}
			}
		}
		return true;		
	}

}
