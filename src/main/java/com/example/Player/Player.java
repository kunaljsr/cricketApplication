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
        BATSMAN, BOWLER;
    }

    private String name;
    private int age;
    private type type;

    public void setRating(int rating) {
        this.rating = rating;
    }

    private int score;
    private int wickets;
    private int ballPlayed;

    public int getRating() {
        return rating;
    }

    private  int noOfFour;
    private int noofSix;
    private int rating;
    //bowler
    private int noOfOver;
    private  int runGiven;
    private   int noOfWicketTaken;

    public Player() {
    }

    public Player(String name, int age, type type, int score, int wickets, int rating) {
        this.name = name;
        this.age = age;
        this.type = type;
        this.score = score;
        this.wickets = wickets;
        this.rating = rating;

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

    public type getType() {
        return type;
    }

    public void setType(type type) {
        this.type = type;
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
