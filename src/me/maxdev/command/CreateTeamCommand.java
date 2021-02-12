package me.maxdev.command;

import me.maxdev.file.FileBinder;
import me.maxdev.file.FileCreator;
import me.maxdev.uhcteam.TeamBinder;
import me.maxdev.uhcteam.UhcTeam;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CreateTeamCommand implements CommandExecutor {
    private FileBinder fileBinder;
    private TeamBinder teamBinder;
    private FileCreator config;

    public CreateTeamCommand(){
        config = fileBinder.getFile("config").get();
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(args.length >= 1)){
            return false;
        }
        if(!(args.length == config.getInt("team-size"))){
            return false;
        }
        UhcTeam team = new UhcTeam(fileBinder);
        team.addPlayer(Bukkit.getPlayer(args[0]));
        team.addPlayer(Bukkit.getPlayer(args[1]));
        teamBinder.put(args[2], team);
        return false;
    }
}
