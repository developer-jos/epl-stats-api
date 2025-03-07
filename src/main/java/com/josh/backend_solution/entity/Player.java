package com.josh.backend_solution.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "player_stats", indexes = {
        @Index(name = "idx_player_name", columnList = "name"),
        @Index(name = "idx_player_nation", columnList = "nation"),
        @Index(name = "idx_player_team", columnList = "team")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-incrementing ID
    private Long id;

    @Column(nullable = false) // Every player must have a name
    private String name;

    @Column(nullable = true, length = 3) // Example: "ENG", "ITA"
    private String nation;

    @Column(nullable = true, length = 10) // Example: "FW", "MF", "DF"
    private String pos;

    @Column(nullable = true)
    private Integer age;

    @Column(nullable = true)
    private Integer mp;  // Matches Played

    @Column(nullable = true)
    private Integer starts;

    @Column(nullable = true)
    private Integer matchesCompleted; // Renamed from "ends" for clarity

    @Column(nullable = true)
    private Double min;  // Minutes Played

    @Column(nullable = true)
    private Integer gls;  // Goals Scored

    @Column(nullable = true)
    private Integer ast;  // Assists

    @Column(nullable = true)
    private Integer pk;  // Penalty Kicks

    @Column(nullable = true)
    private Integer crdy;  // Yellow Cards

    @Column(nullable = true)
    private Integer crdr;  // Red Cards

    @Column(nullable = true)
    private Double xg;  // Expected Goals

    @Column(nullable = true)
    private Double xag;  // Expected Assists

    @Column(nullable = true)
    private String team;
}
