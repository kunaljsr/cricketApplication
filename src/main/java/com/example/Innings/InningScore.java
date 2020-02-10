package com.example.Innings;

import com.example.Player.Player;

import java.util.List;

public class InningScore {
    private String summary;
    private List<Player> batting;
    private List<Player> bowling;




    public List<Player> getBatting() {
        return batting;
    }

    public void setBatting(List<Player> batting) {
        this.batting = batting;
    }

    public List<Player> getBowling() {
        return bowling;
    }

    public void setBowling(List<Player> bowling) {
        this.bowling = bowling;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
