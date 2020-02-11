package com.example.Player;


import com.example.Match.Match;
import com.example.repo.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@EnableMongoRepositories("com.example.Match")
class PlayerServiceImp implements PlayerService {

    @Autowired
    private PlayerRepo playerRepo;

    @Override
    public void save(Match match) {
         playerRepo.save(match);
    }

    @Override
    public Optional<Match> findbyIndexes(String id) {
       return  null ;//playerRepo.findById(id);
    }




}
