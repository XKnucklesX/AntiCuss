package me.compressions.anticuss;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AntiCussCommandExecutor implements CommandExecutor {
	
	private AntiCuss plugin;
	public AntiCussCommandExecutor(AntiCuss plugin) {
		this.plugin = plugin;
	}

	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("anticuss")) {
			if(args.length == 0) {
				p.sendMessage(ChatColor.GRAY + "Commands");
				p.sendMessage(ChatColor.GRAY + "/anticuss reload : Reloads config!");
				p.sendMessage(ChatColor.GRAY + "/anticuss clear : Clears chat!");
			} if(args.length == 1 && args[0].equalsIgnoreCase("reload")) {
				if(!p.hasPermission("anticuss.reload")) {
					p.sendMessage(ChatColor.RED + "Insufficient permissions!");
				} else {
					if(p.hasPermission("anticuss.reload")) {
						plugin.reloadConfig();
						plugin.saveConfig();
						p.sendMessage(ChatColor.GREEN + "Config reloaded!");
					} if(args.length == 1 && args[0].equalsIgnoreCase("clear")) {
						p.sendMessage("DEBUG");
			
			
					}
			
				}		
		
			}

		}
		return true;
	}

}