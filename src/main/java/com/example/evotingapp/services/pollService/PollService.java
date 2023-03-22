package com.example.evotingapp.services.pollService;

import com.example.evotingapp.dtos.register.PollRequest;
import com.example.evotingapp.dtos.response.PollResponse;
import com.example.evotingapp.exceptions.OverVotingException;
import org.springframework.stereotype.Service;

@Service
public interface PollService {

    PollResponse castVote(PollRequest pollRequest) throws OverVotingException;

    long count();
    String checkResult();
}
