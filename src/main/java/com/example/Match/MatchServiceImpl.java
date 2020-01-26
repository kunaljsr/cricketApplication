package com.example.Match;

import com.example.Innings.Innings;
import com.example.Team.Team;
import com.sun.source.tree.BreakTree;
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
        A.makeTeamIndia();
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

        int head = rand.nextInt(2);;

        if(head == 1)
            System.out.println("and chose to bat.");
        else
            System.out.println("and chose to ball");

        scoreFirstInning();
        scoreSecondInning();
        if((toss == 1 && head == 1) || (toss ==0 && head ==0)){
            first.setTeam(A);
            second.setTeam(B);
            A.setScore(first.getScore());
            A.setWickets(first.getWickets());
            A.setOvers(first.getOvers());
            A.setBalls(first.getBalls());
            B.setScore(second.getScore());
            B.setWickets(second.getWickets());
            B.setOvers(second.getOvers());
            B.setBalls(second.getBalls());
        }
        else{
            first.setTeam(B);
            second.setTeam(A);
            B.setScore(first.getScore());
            B.setWickets(first.getWickets());
            B.setOvers(first.getOvers());
            B.setBalls(first.getBalls());
            A.setScore(second.getScore());
            A.setWickets(second.getWickets());
            A.setOvers(second.getOvers());
            A.setBalls(second.getBalls());
        }
        System.out.println("India: " + A.getScore() + "/" + A.getWickets() + " in " + A.getOvers() + "." + A.getBalls() + " overs");
        System.out.println("Pakistan: " + B.getScore() + "/" + B.getWickets() + " in " + B.getOvers() + "." + B.getBalls() + " overs");
    }

    @Override
    public void scoreFirstInning() {
        first.setScore();
    }

    @Override
    public void scoreSecondInning() {
        second.setScore();
    }

    @Override
    public void decideWinner() {
        if(A.getScore() > B.getScore())
            System.out.println("India won by " + (A.getScore() - B.getScore()) + " runs\n\n");
        else if(A.getScore() < B.getScore())
            System.out.println("Pakistan won by " + (B.getScore() - A.getScore()) + " runs\n\n");
        else
            System.out.println("Match draw\n\n");
    }
}
