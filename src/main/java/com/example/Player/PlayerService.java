package com.example.Player;

import com.example.Match.Match;

import java.util.Optional;


public interface PlayerService {

    public void save(Match match);

    public Optional<Match> findbyIndexes(String id);


}
