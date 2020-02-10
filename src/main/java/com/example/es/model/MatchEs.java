package com.example.es.model;

import com.example.Team.Team;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.stereotype.Component;

@Component
@org.springframework.data.elasticsearch.annotations.Document(indexName = "cricket", type = "_doc")
public class MatchEs {

    @org.springframework.data.annotation.Id
    private String id;

    @Indexed
    private String team1;
    @Indexed
    private String team2;
    @Indexed


    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private String date;
    private Team firstTeam;
    private Team secondTeam;
    private String matchResult;
    private String firstBat;
    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getMatchResult() {
        return matchResult;
    }

    public void setMatchResult(String matchResult) {
        this.matchResult = matchResult;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstBat() {
        return firstBat;
    }

    public void setFirstBat(String firstBat) {
        this.firstBat = firstBat;
    }

    public Team getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(Team firstTeam) {
        this.firstTeam = firstTeam;
    }

    public Team getSecondTeam() {
        return secondTeam;
    }

    public void setSecondTeam(Team secondTeam) {
        this.secondTeam = secondTeam;
    }
}


