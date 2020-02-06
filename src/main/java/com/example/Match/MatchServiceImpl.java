package com.example.Match;

import com.example.Innings.Innings;
import com.example.Team.Team;
//import com.sun.source.tree.BreakTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MatchServiceImpl implements MatchService {
    @Autowired
    private Team A;
    @Autowired
    private Team B;
    @Autowired
    private Innings first;
    @Autowired
    private Innings second;

    @Override
    public void createTeam() {
        A.setName("India");
        A.makeTeamIndia();
        B.setName("Pakistan");
        B.makeTeamPakistan();
    }

    @Override
    public void doToss() {
        Random rand = new Random();
        int toss = rand.nextInt(2);

        if(toss==1){
            System.out.print("India won the toss ");
        }
        else{
            System.out.print("Pakistan won the toss ");
        }

        int bat = rand.nextInt(2);;

        if(bat == 1)
            System.out.println("and chose to bat.\n");
        else
            System.out.println("and chose to ball.\n");

        if((toss == 1 && bat == 1) || (toss ==0 && bat ==0)){
            first.setTeam(A);
            first.setTeam2(B);
            second.setTeam(B);
            second.setTeam2(A);
        }
        else{
            first.setTeam(B);
            first.setTeam2(A);
            second.setTeam(A);
            second.setTeam2(B);

        }

    }

    @Override
    public void startMatch() {
        System.out.println(first.getTeam().getName() + " in first Inning:");
        first.setStriker(0);
        first.setNonStriker(1);
        first.setBowler(6);
        scoreFirstInning();
        System.out.println(first.getTeam().getName() + ": " + first.getTeam().getScore() + "/" + first.getTeam().getWickets() + " in " + first.getTeam().getOvers() + "." + first.getTeam().getBalls() + " overs\n");

        System.out.println(second.getTeam().getName() + " in Second Inning:");
        second.setStriker(0);
        second.setNonStriker(1);
        second.setBowler(6);
        scoreSecondInning();
        System.out.println(second.getTeam().getName() + ": " + second.getTeam().getScore() + "/" + second.getTeam().getWickets() + " in " + second.getTeam().getOvers() + "." + second.getTeam().getBalls() + " overs");
    }


    @Override
    public void scoreFirstInning() {
        first.setScoreFirstInning();
    }

    @Override
    public void scoreSecondInning() {
        second.setScoreSecondInning();
    }

    @Override
    public String decideWinner() {
        String result = " ";
        if(first.getTeam().getScore() > second.getTeam().getScore()){
            System.out.println("\n" + first.getTeam().getName() + " won by " + (first.getTeam().getScore() - second.getTeam().getScore()) + " run(s)\n");
            result +=  first.getTeam().getName() + " won by " + (first.getTeam().getScore() - second.getTeam().getScore()) + " run(s)";
            return  result;
        }
        else if(second.getTeam().getScore() > first.getTeam().getScore()){
            System.out.println("\n" + second.getTeam().getName() + " won by " + (10 - second.getTeam().getWickets()) + " wicket(s)\n");
            result +=  second.getTeam().getName() + " won by " + (10 - second.getTeam().getWickets()) + " wicket(s)";
            return  result;
        }
        else {
            System.out.println("/nMatch draw\n");
            result += "Match draw";
            return  result;
        }
    }
}
