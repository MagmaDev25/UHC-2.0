package me.maxdev.service;

import me.maxdev.Uhc;
import me.maxdev.command.CreateTeamCommand;
import me.maxdev.command.GamemodeSurvivalCommand;
import me.maxdev.command.GetPlayersOnATeamCommand;
import me.maxdev.command.GetTeamNamesCommand;
import me.maxdev.file.FileBinder;
import me.maxdev.file.FileCreator;
import me.maxdev.loader.ListenerLoader;
import me.maxdev.uhcteam.TeamBinder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class UHCService implements Service{
    private Uhc plugin;
    private FileBinder fileBinder;
    private TeamBinder teamBinder;


    private FileCreator config;
    private FileCreator lang;

    private ListenerLoader listenerLoader;

    public UHCService(Uhc plugin, FileBinder fileBinder, TeamBinder teamBinder){
        this.plugin = plugin;
        this.fileBinder = fileBinder;
        this.teamBinder = teamBinder;
        listenerLoader = new ListenerLoader(plugin, fileBinder, teamBinder);
    }

    @Override
    public void setup() {
        config = new FileCreator(plugin, "config");
        config.create();
        fileBinder.bind("config", config);
        lang = new FileCreator(plugin, "lang");
        lang.create();
        fileBinder.bind("lang", lang);
        listenerLoader.load();
        loadCommands();
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&2UHC activated."));
    }

    @Override
    public void shutdown() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&cUHC desactivated."));
    }


    public void loadCommands(){
        plugin.getCommand("createteam").setExecutor(new CreateTeamCommand(fileBinder, teamBinder));
        plugin.getCommand("getteams").setExecutor(new GetTeamNamesCommand(teamBinder));
        plugin.getCommand("setsurvival").setExecutor(new GamemodeSurvivalCommand(teamBinder));
        plugin.getCommand("getplayers").setExecutor(new GetPlayersOnATeamCommand(teamBinder));
    }
}
