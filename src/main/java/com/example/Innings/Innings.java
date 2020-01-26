package com.example.Innings;
import com.example.Team.Team;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.Random;

@Component
@Scope(value = "prototype")
public class Innings {
    private Team team;
    private int score;
    private int wickets;
    private int overs;
    private int balls;
    private int striker;
    private int nonstriker;
    private int baller;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
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

    public int getScore() {
        return score;
    }

    public void setScore() {
        int i;
        int j = 0;
        int ball;
        int wickets = 0;
        int score = 0;
        int striker = 0, nonstriker = 1, temp;
        Random rand = new Random();
        for(i = 0; i < 20 ; i++){
            for(j = 0; j < 6; j++){
                ball = rand.nextInt(7);

                if(ball == 6) {
                    wickets++;
                    setWickets(wickets);
                    striker = wickets + 1;
                }
                else {
                    score += ball + 1;

                    if(ball == 1 || ball == 3){
                        temp = striker;
                        striker = nonstriker;
                        nonstriker = temp;
                    }
                }

                if(wickets == 10)
                    break;

            }
            if(wickets == 10)
                break;

            temp = striker;
            striker = nonstriker;
            nonstriker = temp;
        }
        this.score = score;

        if(i==20) {
            setOvers(20);
            setBalls(0);
        }
        else{
            setOvers(i);
            setBalls(j);
        }

    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public int getStriker() {
        return striker;
    }

    public void setStriker(int striker) {
        this.striker = striker;
    }

    public int getNonstriker() {
        return nonstriker;
    }

    public void setNonstriker(int nonstriker) {
        this.nonstriker = nonstriker;
    }

    public int getBaller() {
        return baller;
    }

    public void setBaller(int baller) {
        this.baller = baller;
    }
}
