package me.maxdev.uhcteam;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TeamBinder {
    private Map<String, UhcTeam> teams = new HashMap<>();

    public void put(String name, UhcTeam uhcTeam){
        teams.put(name, uhcTeam);
    }

    public Optional<UhcTeam> getTeam(String name){
        return Optional.ofNullable(teams.get(name));
    }
}
