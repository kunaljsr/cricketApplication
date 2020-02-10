package com.example.config;

import com.example.Player.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PlayerRepo extends MongoRepository<Player, String> {
    public List<Player> findByScoreGreaterThan(int maxScore);

}
