package me.maxdev;

import me.maxdev.file.FileBinder;
import me.maxdev.service.UHCService;
import me.maxdev.uhcteam.TeamBinder;
import org.bukkit.plugin.java.JavaPlugin;

public class Uhc extends JavaPlugin {

    private UHCService service;

    private FileBinder fileBinder;
    private TeamBinder teamBinder;

    @Override
    public void onEnable(){
        initializeVariables();
        service = new UHCService(this, fileBinder, teamBinder);
        service.setup();
    }

    @Override
    public void onDisable(){
        service.shutdown();
    }

    public void initializeVariables(){
        fileBinder = new FileBinder();
        teamBinder = new TeamBinder();
    }
}
