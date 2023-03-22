package com.example.evotingapp.data.repositories;

import com.example.evotingapp.data.models.Voter;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface VoterRepo extends MongoRepository<Voter, String> {

    Optional<Voter> findByEmailAddress(String emailAddress);
}
