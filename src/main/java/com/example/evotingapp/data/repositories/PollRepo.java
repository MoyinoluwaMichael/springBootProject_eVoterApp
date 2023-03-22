package com.example.evotingapp.data.repositories;

import com.example.evotingapp.data.models.Poll;
import com.example.evotingapp.data.models.Voter;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PollRepo extends MongoRepository<Poll, String> {

    Optional<Voter> findByVoterId(String voterId);
}
