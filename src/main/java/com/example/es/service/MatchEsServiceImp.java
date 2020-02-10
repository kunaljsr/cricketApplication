package com.example.es.service;

import com.example.Innings.InningScore;
import com.example.Match.MatchInput;
import com.example.es.model.MatchEs;
import com.example.es.repo.MatchElasticRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MatchEsServiceImp implements MatchEsService {

    @Autowired
    private MatchElasticRepo repoEs;

    @Override
    public void save(MatchEs matchEs) {
        repoEs.save(matchEs);
    }

    @Override
    public Optional<MatchEs> findById(MatchInput request) {
        return repoEs.findById(request.getTeamOne()+request.getTeamTwo()+request.getDate());
    }

    @Override
    public InningScore firstInningScore(MatchInput request) {
        Optional<MatchEs> allScore = repoEs.findById(request.getTeamOne()+request.getTeamTwo()+request.getDate());
        InningScore scoreBoard = new InningScore();
        scoreBoard.setBatting(allScore.get().getFirstTeam().getPlayerList());
        scoreBoard.setBowling(allScore.get().getSecondTeam().getPlayerList().subList(6,11) );
        scoreBoard.setSummary(allScore.get().getFirstTeam().getName() + " : " + allScore.get().getFirstTeam().getScore() + "/" +
                allScore.get().getFirstTeam().getWickets() + "  in  " + allScore.get().getFirstTeam().getOvers() +"." + allScore.get().getFirstTeam().getBalls() + "  Overs  ");


        return scoreBoard;

    }


    @Override
    public InningScore secondInningScore(MatchInput request) {
        Optional<MatchEs> allScore = repoEs.findById(request.getTeamOne()+request.getTeamTwo()+request.getDate());
        InningScore scoreBoard = new InningScore();
        scoreBoard.setBatting(allScore.get().getSecondTeam().getPlayerList());
        scoreBoard.setBowling(allScore.get().getFirstTeam().getPlayerList().subList(6,11) );
        scoreBoard.setSummary(allScore.get().getSecondTeam().getName() + " : " + allScore.get().getSecondTeam().getScore() + "/" +
                allScore.get().getSecondTeam().getWickets() + "  in  " + allScore.get().getSecondTeam().getOvers() +"." + allScore.get().getSecondTeam().getBalls() + "  Overs  ");


        return scoreBoard;

    }
}
