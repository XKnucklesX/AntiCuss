package me.compressions.anticuss;


import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AntiCussListener implements Listener {
	
	private AntiCuss plugin;
	public AntiCussListener(AntiCuss plugin) {
		this.plugin = plugin;
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
			} else {
				if(e.getPlayer().hasPermission("anticuss.kick") && plugin.getConfig().getStringList("cusswords").contains(word)) {
					e.setCancelled(true);
					String kickmessage = plugin.getConfig().getString("kickmessage");
					e.getPlayer().kickPlayer(ChatColor.RED + kickmessage);
						}
					}
				}

			}

		}
}
	