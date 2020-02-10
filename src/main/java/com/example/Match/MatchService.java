package com.example.Match;

import java.util.Optional;

public interface MatchService {
    public void createTeam(MatchInput request);
    public void doToss(MatchInput request);
    public void startMatch(MatchInput request);
    public void scoreFirstInning();
    public void scoreSecondInning();
    public void decideWinner();
    public void stats(MatchInput request);
    public Optional<Match> getScorecard(MatchInput request);

//    public Optional<MatchEs> findbyId(MatchInput request);
}
