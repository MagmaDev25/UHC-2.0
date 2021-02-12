package me.maxdev.loader;

import me.maxdev.Uhc;
import me.maxdev.command.CreateTeamCommand;
import me.maxdev.file.FileBinder;
import me.maxdev.uhcteam.TeamBinder;
import org.bukkit.command.CommandExecutor;


public class CommandLoader implements Loadable{
    private Uhc plugin;
    private FileBinder fileBinder;
    private TeamBinder teamBinder;

    private CreateTeamCommand createTeamCommand;

    public CommandLoader(Uhc plugin, FileBinder fileBinder, TeamBinder teamBinder){
        this.plugin = plugin;
        this.fileBinder = fileBinder;
        this.teamBinder = teamBinder;
        createTeamCommand = new CreateTeamCommand();
    }

    @Override
    public void load() {
        loadCommands(createTeamCommand);
    }


    private void loadCommands(CommandExecutor... commands){
        for(CommandExecutor command : commands){
            plugin.getCommand("createteam").setExecutor(command);
        }
    }
}
