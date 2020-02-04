package com.example.Player;

public class Player {
    public enum type{
        BATSMAN, ALLROUNDER, BOWLER;
    }

    private String name;
    private int age;
    private type t;
    private int score;
    private int wickets;

    public Player() {
    }

    public Player(String name, int age, type t, int score, int wickets) {
        this.name = name;
        this.age = age;
        this.t = t;
        this.score = score;
        this.wickets = wickets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public type getT() {
        return t;
    }

    public void setT(type t) {
        this.t = t;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }
}
