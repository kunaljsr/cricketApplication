package com.example.Innings;
import com.example.Team.Team;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.Random;

@Component
@Scope(value = "prototype")
public class Innings {
    private Team team;
    private  Team team2;
    private int striker;
    private int nonStriker;
    private int bowler;
    private static int chasingScore;

    private int score;

    public Innings() {
    }

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
    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
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

                if(ball == 3)
                {
                    getTeam().getPlayerList().get(striker).setNoOfFour(getTeam().getPlayerList().get(striker).getNoOfFour() + 1);
                }
                if(ball == 5)
                {
                    getTeam().getPlayerList().get(striker).setNoofSix(getTeam().getPlayerList().get(striker).getNoofSix() + 1);
                }

                if(ball == 6) {
                    wickets++;
                    getTeam2().getPlayerList().get(bowler).setNoOfWicketTaken(getTeam2().getPlayerList().get(bowler).getNoOfWicketTaken() + 1);
                    getTeam().setWickets(wickets);
                    getTeam().getPlayerList().get(striker).setBallPlayed(getTeam().getPlayerList().get(striker).getBallPlayed() + 1);
                    setStriker(wickets + 1);

                }
                else {
                    score += ball + 1;
                    getTeam().getPlayerList().get(striker).setScore(getTeam().getPlayerList().get(striker).getScore() + ball + 1);
                    getTeam().getPlayerList().get(striker).setBallPlayed(getTeam().getPlayerList().get(striker).getBallPlayed()  + 1);
                    getTeam2().getPlayerList().get(bowler).setRunGiven(getTeam2().getPlayerList().get(bowler).getRunGiven() + ball + 1);
                    if(score == 1 || score == 3){
                        changeStrikers();
                    }
                }
                if(wickets == 10 || (chase && score > getChasingScore()))
                    break;
            }
            getTeam2().getPlayerList().get(bowler).setNoOfOver(getTeam2().getPlayerList().get(bowler).getNoOfOver() + 1);
            changeBowler();
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

    public void changeBowler(){
        int temp = getBowler();
        if(temp == 10)
        setBowler(6);
        else
            setBowler(temp + 1);
    }

    public void playerScore(){
        int i=0;
        System.out.println("BATTING SCORE CARD");
        System.out.println("Player     " + "\t" + "Score" + "\t" + "Ball Played" + "\t" + "4's"  + "\t" + "6's");
        for(i = 0;i < 11;i++){
            System.out.println(getTeam().getPlayerList().get(i).getName() + "\t" + "\t" + getTeam().getPlayerList().get(i).getScore() + "\t" + "\t" + getTeam().getPlayerList().get(i).getBallPlayed() + "\t" + "\t" + "\t" + getTeam().getPlayerList().get(i).getNoOfFour()  + "\t" + getTeam().getPlayerList().get(i).getNoofSix());
        }
        System.out.println("\n");
        System.out.println("BOWLING SCORE CARD");
        System.out.println("Player     " + "\t" + "Over" + "\t" + "Run Given" + "\t" + "Wickets");
        for(i = 6;i < 11;i++){
            System.out.println(getTeam2().getPlayerList().get(i).getName() + "\t" + "\t" + getTeam2().getPlayerList().get(i).getNoOfOver() + "\t" + "\t" + getTeam2().getPlayerList().get(i).getRunGiven() + "\t" + "\t" + "\t" + getTeam2().getPlayerList().get(i).getNoOfWicketTaken()  + "\t" );
        }
    }



}
