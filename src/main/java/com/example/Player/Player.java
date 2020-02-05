package com.example.Player;

public class Player {
    public int getBallPlayed() {
        return ballPlayed;
    }

    public void setBallPlayed(int ballPlayed) {
        this.ballPlayed = ballPlayed;
    }

    public int getNoOfFour() {
        return noOfFour;
    }

    public void setNoOfFour(int noOfFour) {
        this.noOfFour = noOfFour;
    }

    public int getNoofSix() {
        return noofSix;
    }

    public void setNoofSix(int noofSix) {
        this.noofSix = noofSix;
    }

    public int getNoOfOver() {
        return noOfOver;
    }

    public void setNoOfOver(int noOfOver) {
        this.noOfOver = noOfOver;
    }

    public int getRunGiven() {
        return runGiven;
    }

    public void setRunGiven(int runGiven) {
        this.runGiven = runGiven;
    }

    public int getNoOfWicketTaken() {
        return noOfWicketTaken;
    }

    public void setNoOfWicketTaken(int noOfWicketTaken) {
        this.noOfWicketTaken = noOfWicketTaken;
    }

    public enum type{
        BATSMAN, ALLROUNDER, BOWLER;
    }

    private String name;
    private int age;
    private type t;
    private int score;
    private int wickets;
    private int ballPlayed;
    private  int noOfFour;
    private int noofSix;

    //bowler
    private int noOfOver;
    private  int runGiven;
    private   int noOfWicketTaken;

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
