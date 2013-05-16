package me.compressions.anticuss.commands;

import me.compressions.anticuss.AntiCuss;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Mute implements CommandExecutor {
	
	public AntiCuss plugin;
	public Mute(AntiCuss instance) {
		plugin = instance;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "You must be a player to execute this command!");
		} else {
			if(cmd.getName().equalsIgnoreCase("mutechat")) {
				if(args.length == 0) {
					Player p = (Player) sender;
					if(!p.hasPermission("anticuss.mute")) {
						p.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
					} else if(p.hasPermission("anticuss.mute")) {
						if(plugin.muted = false) {
							p.sendMessage(ChatColor.GREEN + "Chat muted!");
							plugin.muted = true;
						} else if(plugin.muted = true) {
							p.sendMessage(ChatColor.GREEN + "Chat unmuted!");
							plugin.muted = false;
						}
					}
				}
			}
		}
		return true;
	}

}
