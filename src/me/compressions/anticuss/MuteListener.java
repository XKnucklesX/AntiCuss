package me.compressions.anticuss;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class MuteListener implements Listener {
    
    public AntiCuss plugin;
    public MuteListener(AntiCuss instance) {
        plugin = instance;
    }
    
    @EventHandler
    public void onAsynPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if(plugin.chatMuted && !player.hasPermission("anticuss.bypass")) {
            event.setCancelled(true);
            player.sendMessage(ChatColor.RED + plugin.getConfig().getString("cancelChatMessage"));
        }
    }

}
