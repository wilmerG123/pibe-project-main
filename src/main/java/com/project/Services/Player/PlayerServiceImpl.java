package com.project.Services.Player;

import com.project.models.entitys.Player;
import com.project.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository repo) {
        this.playerRepository = repo;
    }

    @Override
    public Player save(Player player) {
        return this.playerRepository.save(player);
    }

    @Override
    public Player editPlayer(Player player, Long id) {
        player.setId(id);
        return playerRepository.save(player);
    }

    @Override
    public List<Player> getPlayers() {
        return this.playerRepository.findAll();
    }

    @Override
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }

    @Override
    public List<Player> getPlayersByCategory(Long id) {
        return playerRepository.findByCategoryId(id);
    }

    @Override
    public List<Player> getPlayerByName(String name) {
        return playerRepository.findByNameIgnoreCase(name);
    }

    @Override
    public List<Player> getPlayerOnEventByIds(List<Long> ids) {
        return playerRepository.findAllById(ids);
    }
}
