package me.maxdev.uhcteam;

import java.util.HashMap;
import java.util.Map;

public class TeamBinder {
    private Map<String, UhcTeam> teams = new HashMap<>();

    public void put(String name, UhcTeam uhcTeam){
        teams.put(name, uhcTeam);
    }

    public UhcTeam getTeam(String name){
        return teams.get(name);
    }
    public Map<String, UhcTeam> getTeams(){
        return teams;
    }
}
