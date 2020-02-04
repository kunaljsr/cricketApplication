package com.example.Innings;
import com.example.Team.Team;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.Random;

@Component
@Scope(value = "prototype")
public class Innings {
    private Team team;
    private int striker;
    private int nonStriker;
    private int bowler;
    private static int chasingScore;

    private int score;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getStriker() {
        return striker;
    }

    public void setStriker(int striker) {
        this.striker = striker;
    }

    public int getNonStriker() {
        return nonStriker;
    }

    public void setNonStriker(int nonStriker) {
        this.nonStriker = nonStriker;
    }

    public int getBowler() {
        return bowler;
    }

    public void setBowler(int bowler) {
        this.bowler = bowler;
    }

    public int getChasingScore() {
        return chasingScore;
    }

    public void setChasingScore(int score) {
        this.chasingScore = score;
    }

    public void setScoreFirstInning(){
        makeScore(false );
        setChasingScore(getTeam().getScore());
    }

    public void setScoreSecondInning(){
        makeScore(true);
    }

    public void makeScore(boolean chase) {
        int i;
        int j = 0;
        int ball;
        int wickets = 0;
        int score = 0;
        Random rand = new Random();
        for(i = 0; i < 20 ; i++){
            for(j = 0; j < 6; j++){
                do {
                    ball = rand.nextInt(7);
                }while(ball == 4);

                if(ball == 6) {
                    wickets++;
                    getTeam().setWickets(wickets);
                    setStriker(wickets + 1);
                }

                else {
                    score += ball + 1;
                    getTeam().getPlayerList().get(striker).setScore(getTeam().getPlayerList().get(striker).getScore() + ball + 1);
                    if(score == 1 || score == 3){
                        changeStrikers();
                    }
                }
                if(wickets == 10 || (chase && score > getChasingScore()))
                    break;
            }
            if(wickets == 10 || (chase && score > getChasingScore()))
                break;
            changeStrikers();
        }
        getTeam().setScore(score);
        if(i==20) {
            getTeam().setOvers(20);
            getTeam().setBalls(0);
        }
        else{
            getTeam().setOvers(i);
            getTeam().setBalls(j);
        }
        playerScore();
    }

    public void changeStrikers(){
        int temp = getStriker();
        setStriker(getNonStriker());
        setNonStriker(temp);
    }

    public void playerScore(){
        int i=0;
        for(i = 0;i < 11;i++){
            System.out.println(getTeam().getPlayerList().get(i).getName() + " " + getTeam().getPlayerList().get(i).getScore());
        }
    }
}
