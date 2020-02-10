package com.example.Player;


import org.springframework.data.annotation.Id;

public class Player {

    public enum type{
        BATSMAN, BOWLER;
    }
    @Id
    private String name;

    private type type;


    private int score;

    private int ballPlayed;

    private  int noOfFour;
    private int noofSix;
    private int batRating;
    private int bowlRating;
    //bowler
    private int noOfOver;
    private  int runGiven;
    private   int noOfWicketTaken;

    public Player() {
    }

    public Player(String name, type type, int score, int wickets, int batRating , int bowlRating) {
        this.name = name;

        this.type = type;
        this.score = score;

        this.batRating = batRating;
        this.bowlRating = bowlRating;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getBatRating() {
        return batRating;
    }

    public void setBatRating(int batRating) {
        this.batRating = batRating;
    }

    public int getBowlRating() {
        return bowlRating;
    }

    public void setBowlRating(int bowlRating) {
        this.bowlRating = bowlRating;
    }
}
