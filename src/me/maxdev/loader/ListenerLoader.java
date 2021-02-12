package me.maxdev.loader;

import me.maxdev.Uhc;
import me.maxdev.file.FileBinder;
import me.maxdev.listener.PlayerDeathListener;
import me.maxdev.uhcteam.TeamBinder;
import org.bukkit.event.Listener;

public class ListenerLoader implements Loadable{

    private Uhc plugin;
    private FileBinder fileBinder;
    private TeamBinder teamBinder;

    private PlayerDeathListener playerDeathListener;

    public ListenerLoader(Uhc plugin, FileBinder fileBinder, TeamBinder teamBinder){
        this.plugin = plugin;
        this.fileBinder = fileBinder;
        this.teamBinder = teamBinder;
        playerDeathListener = new PlayerDeathListener(fileBinder);
    }

    @Override
    public void load() {
        loadListeners(playerDeathListener);
    }


    private void loadListeners(Listener... listeners){
        for(Listener listener : listeners){
            plugin.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }
}
