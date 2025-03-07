package com.josh.backend_solution.controllers;

import com.josh.backend_solution.entity.Player;
import com.josh.backend_solution.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/player")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    /** ✅ Get Players with Filters */
    @GetMapping
    public ResponseEntity<List<Player>> getPlayers(
            @RequestParam(required = false) String team,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String position,
            @RequestParam(required = false) String nation,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) Integer mp,
            @RequestParam(required = false) Integer starts,
            @RequestParam(required = false) Double min,
            @RequestParam(required = false) Integer gls,
            @RequestParam(required = false) Integer ast,
            @RequestParam(required = false) Integer pk,
            @RequestParam(required = false) Integer crdy,
            @RequestParam(required = false) Integer crdr,
            @RequestParam(required = false) Double xg,
            @RequestParam(required = false) Double xag) {

        List<Player> result = playerService.getFilteredPlayers(
                team, name, position, nation, age, mp, starts, min, gls, ast, pk, crdy, crdr, xg, xag
        );
        return result.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(result);
    }

    /** ✅ Get Players with Pagination */
    @GetMapping("/list")
    public ResponseEntity<Page<Player>> getPlayersPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<Player> result = playerService.getAllPlayers(PageRequest.of(page, size));
        return ResponseEntity.ok(result);
    }

    /** ✅ Get Player by ID */
    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id) {
        Optional<Player> player = playerService.getPlayerById(id);
        return player.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /** ✅ Delete a Player */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
        return ResponseEntity.ok("✅ Player deleted successfully!");
    }
}
