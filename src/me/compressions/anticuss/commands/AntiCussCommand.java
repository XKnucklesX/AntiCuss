package me.compressions.anticuss.commands;

import me.compressions.anticuss.AntiCuss;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AntiCussCommand implements CommandExecutor {
	
	public AntiCuss plugin;
	public AntiCussCommand(AntiCuss instance) {
		plugin = instance;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "You must be a player to execute this command!");
		} else {
			Player p = (Player) sender;
			if(cmd.getName().equalsIgnoreCase("anticuss")) {
				if(args.length == 0) {
					p.sendMessage(ChatColor.GRAY + "Commands:");
					p.sendMessage(ChatColor.GRAY + "/anticuss : Help screen!");
					p.sendMessage(ChatColor.GRAY + "/acreload : Reloads AntiCuss config!");
					p.sendMessage(ChatColor.GRAY + "/clearchat : Clears chat!");
					p.sendMessage(ChatColor.GRAY + "/chat [on/off] : Toggles chat!");
				}
			}
		}
		return true;		
	}

}
