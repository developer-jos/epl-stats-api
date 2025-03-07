package com.josh.backend_solution.repositories;

import com.josh.backend_solution.entity.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    /** ✅ Search by Name (Case-Insensitive) */
    List<Player> findByNameContainingIgnoreCase(String name);

    /** ✅ Search by Team */
    List<Player> findByTeamIgnoreCase(String team);

    /** ✅ Search by Position */
    List<Player> findByPosIgnoreCase(String pos);

    /** ✅ Search by Nation */
    List<Player> findByNationIgnoreCase(String nation);

    /** ✅ Advanced Filtering (Stats-based) */
    List<Player> findByAgeGreaterThanEqual(int age);
    List<Player> findByMpGreaterThanEqual(int mp);
    List<Player> findByStartsGreaterThanEqual(int starts);
    List<Player> findByMatchesCompletedGreaterThanEqual(int matchesCompleted);
    List<Player> findByMinGreaterThanEqual(double min);
    List<Player> findByGlsGreaterThanEqual(int gls);
    List<Player> findByAstGreaterThanEqual(int ast);
    List<Player> findByPkGreaterThanEqual(int pk);
    List<Player> findByCrdyGreaterThanEqual(int crdy);
    List<Player> findByCrdrGreaterThanEqual(int crdr);
    List<Player> findByXgGreaterThanEqual(double xg);
    List<Player> findByXagGreaterThanEqual(double xag);

    /** ✅ Pagination Support */
    Page<Player> findAll(Pageable pageable);
}
