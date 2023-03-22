package com.example.evotingapp.data.repositories;

import com.example.evotingapp.data.models.Party;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PartyRepo extends MongoRepository<Party, String> {
    Optional<Party> findByFullName(String fullName);

    Optional<Party> findById(String partyId);
}
