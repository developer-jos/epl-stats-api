package com.josh.backend_solution.services;

import com.josh.backend_solution.entity.Player;
import com.josh.backend_solution.repositories.PlayerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    /** ✅ Get All Players (with Caching) */
    @Cacheable("players")
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    /** ✅ Get Players with Pagination */
    @Cacheable(value = "players", key = "#page + '-' + #size")
    public Page<Player> getAllPlayers(Pageable pageable) {
        return playerRepository.findAll(pageable);
    }

    /** ✅ Get Player by ID */
    public Optional<Player> getPlayerById(Long id) {
        return playerRepository.findById(id);
    }

    /** ✅ Get Players by Filters */
    public List<Player> getFilteredPlayers(String team, String name, String position, String nation, Integer age,
                                           Integer mp, Integer starts, Double min, Integer gls, Integer ast,
                                           Integer pk, Integer crdy, Integer crdr, Double xg, Double xag) {
        if (team != null) return playerRepository.findByTeamIgnoreCase(team);
        if (name != null) return playerRepository.findByNameContainingIgnoreCase(name);
        if (position != null) return playerRepository.findByPosIgnoreCase(position);
        if (nation != null) return playerRepository.findByNationIgnoreCase(nation);
        if (age != null) return playerRepository.findByAgeGreaterThanEqual(age);
        if (mp != null) return playerRepository.findByMpGreaterThanEqual(mp);
        if (starts != null) return playerRepository.findByStartsGreaterThanEqual(starts);
        if (min != null) return playerRepository.findByMinGreaterThanEqual(min);
        if (gls != null) return playerRepository.findByGlsGreaterThanEqual(gls);
        if (ast != null) return playerRepository.findByAstGreaterThanEqual(ast);
        if (pk != null) return playerRepository.findByPkGreaterThanEqual(pk);
        if (crdy != null) return playerRepository.findByCrdyGreaterThanEqual(crdy);
        if (crdr != null) return playerRepository.findByCrdrGreaterThanEqual(crdr);
        if (xg != null) return playerRepository.findByXgGreaterThanEqual(xg);
        if (xag != null) return playerRepository.findByXagGreaterThanEqual(xag);

        return playerRepository.findAll();
    }

    /** ✅ Delete Player */
    @Transactional
    public void deletePlayer(Long playerId) {
        playerRepository.deleteById(playerId);
    }
}
