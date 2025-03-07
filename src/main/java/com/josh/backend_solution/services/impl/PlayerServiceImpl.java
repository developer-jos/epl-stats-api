package com.josh.backend_solution.services.impl;

import com.josh.backend_solution.entity.Player;
import com.josh.backend_solution.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayerById(Long id) {
        return playerRepository.findById(id);
    }

    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player updatePlayer(Long id, Player updatedPlayer) {
        return playerRepository.findById(id)
                .map(existingPlayer -> {
                    existingPlayer.setName(updatedPlayer.getName());
                    existingPlayer.setNation(updatedPlayer.getNation());
                    existingPlayer.setPos(updatedPlayer.getPos());
                    existingPlayer.setAge(updatedPlayer.getAge());
                    existingPlayer.setMp(updatedPlayer.getMp());
                    existingPlayer.setStarts(updatedPlayer.getStarts());
                    existingPlayer.setMin(updatedPlayer.getMin());
                    existingPlayer.setGls(updatedPlayer.getGls());
                    existingPlayer.setAst(updatedPlayer.getAst());
                    existingPlayer.setTeam(updatedPlayer.getTeam());
                    return playerRepository.save(existingPlayer);
                })
                .orElseThrow(() -> new RuntimeException("Player not found"));
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
