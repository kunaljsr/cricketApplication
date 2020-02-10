package com.example.Team;

import com.example.Player.Player;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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

    public void makeTeamOne(){
        playerList.add(new Player("t1-Player1", Player.type.BATSMAN,  0, 0,5,0) );
        playerList.add(new Player("t1-Player2", Player.type.BATSMAN,  0, 0,4,0));
        playerList.add(new Player("t1-Player3", Player.type.BATSMAN,  0, 0,4,0));
        playerList.add(new Player("t1-Player4", Player.type.BATSMAN,  0, 0,4,0));
        playerList.add(new Player("t1-Player5", Player.type.BATSMAN,  0, 0,3,2));
        playerList.add(new Player("t1-Player6", Player.type.BATSMAN,  0, 0,5,0));
        playerList.add(new Player("t1-Player7", Player.type.BATSMAN,  0, 0,3,4));
        playerList.add(new Player("t1-Player8", Player.type.BOWLER,   0, 0,2,1));
        playerList.add(new Player("t1-Player9", Player.type.BOWLER,   0, 0,4,4));
        playerList.add(new Player("t1-Player10",Player.type.BOWLER,   0, 0,2,2));
        playerList.add(new Player("t1-Player11",Player.type.BOWLER,   0, 0,1,5));

    }

    public void makeTeamTwo(){
        playerList.add(new Player("t2-Player1", Player.type.BATSMAN, 0,0,5,0));
        playerList.add(new Player("t2-Player2", Player.type.BATSMAN, 0,0,4,0));
        playerList.add(new Player("t2-Player3", Player.type.BATSMAN, 0,0,4,0));
        playerList.add(new Player("t2-Player4", Player.type.BATSMAN, 0,0,4,1));
        playerList.add(new Player("t2-Player5", Player.type.BATSMAN, 0,0,3,1));
        playerList.add(new Player("t2-Player6", Player.type.BATSMAN, 0,0,4,2));
        playerList.add(new Player("t2-Player7", Player.type.BOWLER,  0,0,3,2));
        playerList.add(new Player("t2-Player8", Player.type.BOWLER,  0,0,2,5));
        playerList.add(new Player("t2-Player9", Player.type.BOWLER,  0,0,2,2));
        playerList.add(new Player("t2-Player10",Player.type.BOWLER,  0,0,1,3));
        playerList.add(new Player("t2-Player11",Player.type.BOWLER,  0,0,1,4));
    }
}
