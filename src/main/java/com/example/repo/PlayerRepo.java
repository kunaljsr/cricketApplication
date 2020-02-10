package com.example.repo;

import com.example.Match.Match;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepo extends MongoRepository<Match, String> {
//    public List<Player> findByScoreGreaterThan(int maxScore);

}
