package com.example.evotingapp.services.partyService;

import com.example.evotingapp.dtos.register.PartyRegisterRequest;
import com.example.evotingapp.dtos.response.PartyRegisterResponse;
import com.example.evotingapp.exceptions.DuplicateRegistrationException;
import com.example.evotingapp.exceptions.PartyNotFoundException;

public interface PartyService {

    PartyRegisterResponse register(PartyRegisterRequest partyRegisterRequest) throws DuplicateRegistrationException;

    long count();

    PartyRegisterResponse findById(String id) throws PartyNotFoundException;
}
