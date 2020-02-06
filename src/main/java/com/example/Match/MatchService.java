package com.example.Match;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public interface MatchService {
    public void createTeam();
    public void doToss();
    public void startMatch();
    public void scoreFirstInning();
    public void scoreSecondInning();
    public String decideWinner();
}
