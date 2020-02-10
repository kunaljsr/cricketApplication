package com.example.Match;

import com.example.Innings.Innings;
import com.example.MatchFormat;
import com.example.MatchStart;
import com.example.Player.PlayerService;
import com.example.Team.Team;
import com.example.es.model.MatchEs;
import com.example.es.service.MatchEsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class MatchServiceImpl implements MatchService {
    @Autowired
    private Team A ;
    @Autowired
    private Team B ;
    @Autowired
    private Innings first ;
    @Autowired
    private Innings second ;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private MatchEsService matchEsService;

    private  String result ;

    @Autowired Match match;

    @Autowired
    MatchEs matchEs;

    MatchStart matchStart;
    @Override
    public void createTeam(MatchInput request) {
        A = new Team();
        B = new Team();
        first = new Innings();
        second = new Innings();
        A.setName(request.getTeamOne());
        A.makeTeamOne();
        B.setName(request.getTeamTwo());
        B.makeTeamTwo();
        matchStart.setMatchDescription("match started between" +"\t" + request.getTeamOne() +"\t" +"and" +"\t" + request.getTeamTwo() );
    }

    @Override
    public void doToss(MatchInput request) {
       
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
    public void startMatch(MatchInput request) {
//        MatchResult.clearAll();
        if(MatchFormat.ODI.name().equals(request.getMatchType()) ) {
            first.setOvers(50);
            second.setOvers(50);
        }
        else if(MatchFormat.TEST.equals(request.getMatchType()) ) {
            first.setOvers(90);
            second.setOvers(90);
        }
        else 
        {
            first.setOvers(20);
            second.setOvers(20);
        }
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
    public void stats(MatchInput request) {
        match.setId(request.getTeamOne() + request.getTeamTwo() + request.getDate());
        match.setTeam1(request.getTeamOne());
        match.setTeam2(request.getTeamTwo());
        match.setFirstBat(first.getTeam().getName());
        match.setFirstTeam(first.getTeam());
        match.setSecondTeam(first.getTeam2());
        match.setDate(request.getDate());
        match.setMatchResult(result);



        matchEs.setId(request.getTeamOne() + request.getTeamTwo() + request.getDate());
        matchEs.setTeam1(request.getTeamOne());
        matchEs.setTeam2(request.getTeamTwo());
        matchEs.setDate(request.getDate());
        matchEs.setFirstBat(first.getTeam().getName());
        matchEs.setFirstTeam(first.getTeam());
        matchEs.setSecondTeam(first.getTeam2());
        matchEs.setMatchResult(result);
        playerService.save(match);
        matchEsService.save(matchEs);
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
    public void decideWinner() {
        result="";
        if(first.getTeam().getScore() > second.getTeam().getScore()){
            result +=  first.getTeam().getName() + " won by " + (first.getTeam().getScore() - second.getTeam().getScore()) + " run(s)";
        }
        else if(second.getTeam().getScore() > first.getTeam().getScore()){
            result +=  second.getTeam().getName() + " won by " + (10 - second.getTeam().getWickets()) + " wicket(s)";
        }
        else {
            result += "Match draw";
        }
    }

    @Override
    public Optional<Match> getScorecard(MatchInput request)
    {
        return playerService.findbyIndexes(request.getTeamOne()+ request.getTeamTwo());
    }


}
