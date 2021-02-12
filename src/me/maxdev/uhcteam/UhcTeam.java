package me.maxdev.uhcteam;

import me.maxdev.file.FileBinder;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class UhcTeam {
    private int size;
    private FileBinder fileBinder;
    private List<Player> teamMembers;

    public UhcTeam(FileBinder fileBinder){
        this.fileBinder = fileBinder;
        this.teamMembers = new ArrayList<>();
        size = fileBinder.getFile("config").get().getInt("team-size");
    }

    public void addPlayer(Player player){
        if(!(size > fileBinder.getFile("config").get().getInt("team-size"))){
            teamMembers.add(player);
        }else{
            throw new IndexOutOfBoundsException();
        }
    }

}
