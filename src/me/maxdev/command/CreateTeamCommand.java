package me.maxdev.command;

import me.maxdev.file.FileBinder;
import me.maxdev.file.FileCreator;
import me.maxdev.uhcteam.TeamBinder;
import me.maxdev.uhcteam.UhcTeam;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CreateTeamCommand implements CommandExecutor {
    private FileBinder fileBinder;
    private TeamBinder teamBinder;
    private FileCreator config;

    public CreateTeamCommand(FileBinder fileBinder, TeamBinder teamBinder){
        this.fileBinder = fileBinder;
        this.teamBinder = teamBinder;
        config = fileBinder.getFile("config");
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(args.length != config.getInt("team-size") + 1){
            sender.sendMessage(ChatColor.RED + "Haz usado mal el comando, /createteam nombre1 nombre2 nombre del team");
            return false;
        }
        UhcTeam team = new UhcTeam(fileBinder);
        for(int i = 0; i<args.length -1 ; i++) {
            team.addPlayer(Bukkit.getPlayer(args[i]), sender);
            System.out.println("ASDASDASD");
        }
        if(team.getSize() == 0){
            sender.sendMessage(ChatColor.RED + "No hay personas en el equipo!!!!");
        }else {
            team.setName(args[args.length - 1]);
            teamBinder.put(args[args.length - 1], team);
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aEl team &b" + args[2] +
                    " &aha sido creado correctamente."));
        }
        return true;
    }

}
