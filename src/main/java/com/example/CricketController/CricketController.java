package com.example.CricketController;

import com.example.Match.MatchInput;
import com.example.Match.MatchService;
import com.example.MatchStart;
import com.example.es.service.MatchEsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/match")
@ComponentScan("com.example.CricketController")
@EnableMongoRepositories("com.example")
public class CricketController {
    @Autowired
    private MatchService matchService;


    @Autowired
    private MatchEsService esMatch;


    @GetMapping("/start-match")
    public ResponseEntity startMatch(@RequestBody MatchInput request)
    {
        matchService.createTeam(request);
        matchService.doToss(request);
        matchService.startMatch(request);
        matchService.decideWinner();
        matchService.stats(request);
        return ResponseEntity.ok(MatchStart.getMatchDescription());
    }

    @GetMapping("/firstInningScore")
    public ResponseEntity firstInningScore(@RequestBody MatchInput request) {
        return ResponseEntity.ok(esMatch.firstInningScore(request));
    }

    @GetMapping("/secondInningScore")
    public ResponseEntity secondInningScore(@RequestBody MatchInput request) {
        return ResponseEntity.ok(esMatch.secondInningScore(request));
    }


    @GetMapping("/summary")
    public ResponseEntity getScorecard(@RequestBody MatchInput request)
    {
     return ResponseEntity.ok(esMatch.findById(request));
    }
    }
