package com.project.Services.Player;

import com.project.models.entitys.Player;

import java.util.List;

public interface PlayerService {
    public Player save(Player player);
    public Player editPlayer(Player player, Long id);
    public List<Player> getPlayers();
    public void deletePlayer(Long id);
    public  List<Player> getPlayersByCategory(Long id);
    public  List<Player> getPlayerByName(String name);
    public List<Player> getPlayerOnEventByIds(List<Long> ids);


}
