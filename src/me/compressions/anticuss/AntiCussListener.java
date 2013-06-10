package me.compressions.anticuss;


import net.milkbowl.vault.economy.EconomyResponse;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AntiCussListener implements Listener {
	
	public AntiCuss plugin;
	public AntiCussListener(AntiCuss instance) {
		plugin = instance;
	}
	
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
				if(plugin.getConfig().getBoolean("killOnCurse")) {
				    e.getPlayer().setHealth(0);
				    String killMsg = plugin.getConfig().getString("killMessage");
				    e.getPlayer().sendMessage(ChatColor.RED + killMsg);
				}
				int cost = plugin.getConfig().getInt("cost");
				if(cost > 0) {
					EconomyResponse cussr = AntiCuss.econ.withdrawPlayer(e.getPlayer().getName(), cost);
					if(cussr.transactionSuccess()) {
						e.getPlayer().sendMessage(ChatColor.RED + "You were charged $" + cost + " for cussing!");
					} else {
						e.getPlayer().sendMessage(ChatColor.RED + "An error occurred!");
					        }
				        }
				
				    }
			    }

			}

		}
	
	@EventHandler
	public void onAsyncPlayerChat(AsyncPlayerChatEvent e) {
	    Player player = e.getPlayer();
	    String message = e.getMessage();
	    if(!player.hasPermission("anticuss.bypass")) {
	        int caps = 0;
	        for(int i = 0; i < message.length(); i++) {
	            if(Character.isUpperCase(message.charAt(i))) {
	                caps++;
	            }
	        } try {
	        
	        int iPercent = plugin.getConfig().getInt("capsPercentage");
	        
	        if((1.*caps / message.length()) * 100 > iPercent) {
	            e.setCancelled(true);
	            player.sendMessage(ChatColor.RED + "You used too many caps in that chat message.");
	            }
	        } catch(ArithmeticException ae) {
	            System.out.println("Message had a length of 0 :(");
	        }
	    }
	}
	
}
