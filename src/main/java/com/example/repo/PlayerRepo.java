package com.example.repo;

import com.example.Match.Match;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface PlayerRepo extends MongoRepository<Match,String> {
   // public List<Player> findByScoreGreaterThan(int maxScore);

}

//public interface PlayerRepo extends TMongoRepository<Match> {
////    // public List<Player> findByScoreGreaterThan(int maxScore);
////
////}




