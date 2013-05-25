package me.compressions.anticuss.commands;

import me.compressions.anticuss.AntiCuss;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Chat implements CommandExecutor {
    
    public AntiCuss plugin;
    public Chat(AntiCuss instance) {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You must be a player to execute this command!");
        } else {
            if(label.equalsIgnoreCase("chat")) {
                Player player = (Player) sender;
                if(player.hasPermission("anticuss.mute")) {
                    if(args.length == 1 && args[0].equalsIgnoreCase("on")) {
                        plugin.chatMuted = false;
                        Bukkit.getServer().broadcastMessage(ChatColor.GREEN + plugin.getConfig().getString("chatOnMessage"));
                        return true;
                    } else if(args.length == 1 && args[0].equalsIgnoreCase("off")) {
                        plugin.chatMuted = true;
                        Bukkit.getServer().broadcastMessage(ChatColor.RED + plugin.getConfig().getString("chatOffMessage"));
                        return true;
                    } else if(args.length == 0) {
                        player.sendMessage(ChatColor.RED + "/chat [on/off]");
                    }
                }
            }
        }
        return true;
    }

}
