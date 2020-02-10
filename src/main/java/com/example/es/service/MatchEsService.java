package com.example.es.service;

import com.example.Innings.InningScore;
import com.example.Match.MatchInput;
import com.example.es.model.MatchEs;

import java.util.Optional;

public interface MatchEsService {
    public void save(MatchEs player);

    public Optional<MatchEs> findById(MatchInput request);

    public InningScore firstInningScore(MatchInput request);

    public InningScore secondInningScore(MatchInput request);

}
