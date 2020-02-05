package com.example.Team;

import com.example.Player.Player;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Component
@Scope(value = "prototype")
public class Team {
    private String name;
    private int score;
    private int wickets;
    private int overs;
    private int balls;
    private ArrayList<Player> playerList;

    public Team() {
        this.playerList = new ArrayList<Player>(11);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getOvers() {
        return overs;
    }

    public void setOvers(int overs) {
        this.overs = overs;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public void makeTeamIndia(){
        playerList.add(new Player("Sachin", 30, Player.type.BATSMAN, 0, 0 ,5) );
        playerList.add(new Player("Shehwag", 29, Player.type.BATSMAN, 0, 0,4));
        playerList.add(new Player("Gambhir", 26, Player.type.BATSMAN,0, 0,4));
        playerList.add(new Player("Kohli", 23, Player.type.BATSMAN, 0, 0,4));
        playerList.add(new Player("Yuvraj", 27, Player.type.BATSMAN, 0, 0,3));
        playerList.add(new Player("Dhoni", 27, Player.type.BATSMAN, 0, 0,5));
        playerList.add(new Player("Raina", 26, Player.type.BATSMAN, 0, 0,3));
        playerList.add(new Player("Shami", 28, Player.type.BOWLER, 0, 0,5));
        playerList.add(new Player("Zaheer", 29, Player.type.BOWLER,0, 0,4));
        playerList.add(new Player("Ashwin", 25, Player.type.BOWLER,0,0,2));
        playerList.add(new Player("Chawla", 28, Player.type.BOWLER,0,0,1));
    }

    public void makeTeamPakistan(){
        playerList.add(new Player("Abdur", 30, Player.type.BATSMAN,0,0,5));
        playerList.add(new Player("Hafeez", 29, Player.type.BATSMAN,0,0,4));
        playerList.add(new Player("Misbah", 26, Player.type.BATSMAN,0,0,4));
        playerList.add(new Player("Younis", 23, Player.type.BATSMAN,0,0,4));
        playerList.add(new Player("Kamran", 27, Player.type.BATSMAN,0,0,3));
        playerList.add(new Player("Shoiab", 27, Player.type.BATSMAN,0,0,4));
        playerList.add(new Player("Afridi", 26, Player.type.BOWLER,0,0,3));
        playerList.add(new Player("Riaz", 28, Player.type.BOWLER,0,0,2));
        playerList.add(new Player("Umar", 29, Player.type.BOWLER,0,0,0));
        playerList.add(new Player("Asad", 25, Player.type.BOWLER,0,0,1));
        playerList.add(new Player("Junaid", 28, Player.type.BOWLER,0,0,0));
    }
}
