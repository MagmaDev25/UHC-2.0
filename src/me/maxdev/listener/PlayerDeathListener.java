package me.maxdev.listener;

import me.maxdev.file.FileBinder;
import me.maxdev.file.FileCreator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {
    private FileBinder fileBinder;

    private FileCreator lang;

    public PlayerDeathListener(FileBinder fileBinder){
        this.fileBinder = fileBinder;
        lang = fileBinder.getFile("lang");
    }


    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        Bukkit.getOnlinePlayers().forEach(player ->{
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', lang.getString("messages.prefix") +
                    lang.getString("messages.on-death")));
        });
    }

}
