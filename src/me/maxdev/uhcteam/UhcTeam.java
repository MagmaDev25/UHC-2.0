package me.maxdev.uhcteam;

import me.maxdev.file.FileBinder;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class UhcTeam {
    private int size;
    private String name;
    private FileBinder fileBinder;
    private List<Player> teamMembers;

    public UhcTeam(FileBinder fileBinder){
        this.fileBinder = fileBinder;
        this.teamMembers = new ArrayList<>();
        size = fileBinder.getFile("config").getInt("team-size");
    }

    public void addPlayer(Player player, CommandSender sender){
        if(!(teamMembers.size() > size)) {
            teamMembers.add(player);
        }else{
            sender.sendMessage(ChatColor.RED + "No se puede crear team porque el equipo ha llegado a su tamaño máximo,aumenta el tamaño desde el config.");
        }
    }
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getSize(){
        return teamMembers.size();
    }
    public List<Player> getPlayers(){
        return teamMembers;
    }
}
