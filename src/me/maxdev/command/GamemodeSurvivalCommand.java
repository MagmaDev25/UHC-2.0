package me.maxdev.command;

import me.maxdev.uhcteam.TeamBinder;
import me.maxdev.uhcteam.UhcTeam;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Map;

public class GamemodeSurvivalCommand implements CommandExecutor {

    private TeamBinder teamBinder;

    public GamemodeSurvivalCommand(TeamBinder teamBinder){
        this.teamBinder = teamBinder;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        for (Map.Entry<String, UhcTeam> teamEntry : teamBinder.getTeams().entrySet()) {
            UhcTeam team = teamEntry.getValue();
            team.getPlayers().forEach(player -> player.setGameMode(GameMode.SURVIVAL));
        }
        return false;
    }
}
