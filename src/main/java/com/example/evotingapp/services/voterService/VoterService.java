package com.example.evotingapp.services.voterService;

import com.example.evotingapp.dtos.register.VoterRegisterRequest;
import com.example.evotingapp.dtos.response.VoterRegisterResponse;
import com.example.evotingapp.exceptions.DuplicateRegistrationException;
import com.example.evotingapp.exceptions.VoterNotFoundException;

public interface VoterService {

    VoterRegisterResponse register(VoterRegisterRequest voterRegisterRequest) throws DuplicateRegistrationException;

    long count();

    VoterRegisterResponse findById(String id) throws VoterNotFoundException;
}
