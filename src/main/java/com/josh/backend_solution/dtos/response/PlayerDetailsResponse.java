package com.josh.backend_solution.dtos.response;

public class PlayerDetailsResponse {
    private Long id;
    private String name;
    private String nation;
    private String position;
    private int age;
    private int appearances;
    private int starts;
    private double minutesPlayed;
    private int goals;
    private int assists;
    private int yellowCards;
    private int redCards;
    private double expectedGoals;
    private double expectedAssists;
    private String team;

    public PlayerDetailsResponse(Long id, String name, String nation, String position, int age, int appearances, int starts, double minutesPlayed, int goals, int assists, int yellowCards, int redCards, double expectedGoals, double expectedAssists, String team) {
        this.id = id;
        this.name = name;
        this.nation = nation;
        this.position = position;
        this.age = age;
        this.appearances = appearances;
        this.starts = starts;
        this.minutesPlayed = minutesPlayed;
        this.goals = goals;
        this.assists = assists;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
        this.expectedGoals = expectedGoals;
        this.expectedAssists = expectedAssists;
        this.team = team;
    }

    // ✅ Getters and Setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getNation() { return nation; }

    public void setNation(String nation) { this.nation = nation; }

    public String getPosition() { return position; }

    public void setPosition(String position) { this.position = position; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public int getAppearances() { return appearances; }

    public void setAppearances(int appearances) { this.appearances = appearances; }

    public int getStarts() { return starts; }

    public void setStarts(int starts) { this.starts = starts; }

    public double getMinutesPlayed() { return minutesPlayed; }

    public void setMinutesPlayed(double minutesPlayed) { this.minutesPlayed = minutesPlayed; }

    public int getGoals() { return goals; }

    public void setGoals(int goals) { this.goals = goals; }

    public int getAssists() { return assists; }

    public void setAssists(int assists) { this.assists = assists; }

    public int getYellowCards() { return yellowCards; }

    public void setYellowCards(int yellowCards) { this.yellowCards = yellowCards; }

    public int getRedCards() { return redCards; }

    public void setRedCards(int redCards) { this.redCards = redCards; }

    public double getExpectedGoals() { return expectedGoals; }

    public void setExpectedGoals(double expectedGoals) { this.expectedGoals = expectedGoals; }

    public double getExpectedAssists() { return expectedAssists; }

    public void setExpectedAssists(double expectedAssists) { this.expectedAssists = expectedAssists; }

    public String getTeam() { return team; }

    public void setTeam(String team) { this.team = team; }
}
