package me.compressions.anticuss;


import net.milkbowl.vault.economy.EconomyResponse;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AntiCussListener implements Listener {
	
	public AntiCuss plugin;
	public AntiCussListener(AntiCuss instance) {
		plugin = instance;
	}
	
	//TODO: charge players for cussing
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		for(String word : e.getMessage().toLowerCase().split(" ")) {
			if(e.getPlayer().hasPermission("anticuss.bypass") || e.getPlayer().isOp()) {
				e.setCancelled(false);
			} else {
				if(!e.getPlayer().hasPermission("anticuss.kick") && plugin.getConfig().getStringList("cusswords").contains(word)) {
				e.setCancelled(true);
				String warnmessage = plugin.getConfig().getString("warnmessage");
				e.getPlayer().sendMessage(ChatColor.RED + warnmessage);
				int cost = plugin.getConfig().getInt("cost");
				if(cost == 0) {			
				} else if(cost > 0) {
					EconomyResponse cussr = AntiCuss.econ.depositPlayer(e.getPlayer().getName(), cost);
					if(cussr.transactionSuccess()) {
						e.getPlayer().sendMessage(ChatColor.RED + "You were charged " + cost + " for cussing!");
					} else {
						e.getPlayer().sendMessage(ChatColor.RED + "An error occurred!");
					}
				}
			} else {
				if(e.getPlayer().hasPermission("anticuss.kick") && plugin.getConfig().getStringList("cusswords").contains(word)) {
					e.setCancelled(true);
					String kickmessage = plugin.getConfig().getString("kickmessage");
					e.getPlayer().kickPlayer(ChatColor.RED + kickmessage);
						} else {
							if(plugin.getConfig().getBoolean("replace") == false && plugin.getConfig().getStringList("cusswords").contains(word)) {
								//nothing
							} else if(plugin.getConfig().getBoolean("replace") == true && plugin.getConfig().getStringList("cusswords").contains(word)) {
								e.setCancelled(true);
								e.getPlayer().chat(plugin.getConfig().getString("replaceWith"));
							}
						}
					}
				}

			}

		}
	
	@EventHandler
	public void onPlayerMute(AsyncPlayerChatEvent e) {
		if(plugin.muted = true) {
			e.setCancelled(true);
		} 
	}
}
