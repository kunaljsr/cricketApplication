package com.example.CricketController;

import com.example.Match.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/match")
public class CricketController {
    @Autowired
    private MatchService matchService;

    @RequestMapping(method = RequestMethod.GET)
    public String  startMatch(){
        System.out.println("\n***** Match Starts *****\n");
        matchService.createTeam();
        matchService.doToss();
        matchService.startMatch();
        matchService.decideWinner();
        System.out.println("***** Match Ends *****");
        return "Match Started, go to console for more updates.";
    }
}
