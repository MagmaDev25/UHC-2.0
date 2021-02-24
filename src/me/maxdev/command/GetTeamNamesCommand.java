package me.maxdev.command;

import me.maxdev.uhcteam.TeamBinder;
import me.maxdev.uhcteam.UhcTeam;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Map;

public class GetTeamNamesCommand implements CommandExecutor {
    private TeamBinder teamBinder;

    public GetTeamNamesCommand(TeamBinder teamBinder){
        this.teamBinder = teamBinder;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(ChatColor.BLUE +" TEAMS:");
        for (Map.Entry<String, UhcTeam> teamEntry : teamBinder.getTeams().entrySet()) {
            String teamName = teamEntry.getKey();
            sender.sendMessage(ChatColor.LIGHT_PURPLE+ "-" + ChatColor.AQUA + teamName + "\n");
        }

        return true;
    }
}
