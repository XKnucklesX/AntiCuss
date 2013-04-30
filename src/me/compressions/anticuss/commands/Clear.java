package me.compressions.anticuss.commands;

import me.compressions.anticuss.AntiCuss;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Clear implements CommandExecutor {
	
	public AntiCuss plugin;
	public Clear(AntiCuss instance) {
		plugin = instance;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "You must be a player to execute this command!");
		} else {
			Player p = (Player) sender;
			if(cmd.getName().equalsIgnoreCase("clearchat")) {
				if(args.length == 0) {
					if(!p.hasPermission("anticuss.clear")) {
						p.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
					} else if(p.hasPermission("anticuss.clear")) {
						for(int msgs = 1; msgs <= 100; msgs++) {
							p.sendMessage("");
						}
					}
				}
			}
		}
		return true;		
	}

}
