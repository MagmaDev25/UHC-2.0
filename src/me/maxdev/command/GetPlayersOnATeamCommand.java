package me.maxdev.command;

import me.maxdev.uhcteam.TeamBinder;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class GetPlayersOnATeamCommand implements CommandExecutor {
    private TeamBinder teamBinder;

    public GetPlayersOnATeamCommand(TeamBinder teamBinder){
        this.teamBinder = teamBinder;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length != 1){
            sender.sendMessage(ChatColor.RED + "Haz usado mal el comando. /getplayers TEAM");
            return false;
        }
        teamBinder.getTeam(args[0]).getPlayers().forEach(player -> sender
                .sendMessage(ChatColor.LIGHT_PURPLE+ "-" + ChatColor.AQUA + player.getName() + "\n"));

        return false;
    }
}
