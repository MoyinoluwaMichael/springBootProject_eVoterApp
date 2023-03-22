package com.example.evotingapp.services.pollService;

import com.example.evotingapp.data.models.Poll;
import com.example.evotingapp.data.repositories.PartyRepo;
import com.example.evotingapp.data.repositories.PollRepo;
import com.example.evotingapp.dtos.register.PollRequest;
import com.example.evotingapp.dtos.response.PollResponse;
import com.example.evotingapp.dtos.response.ResultResponse;
import com.example.evotingapp.exceptions.OverVotingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PollServiceImpl implements PollService {
    @Autowired
    private PollRepo pollRepo;
    @Autowired
    private PartyRepo partyRepo;
    private ModelMapper mapper = new ModelMapper();

    @Override
    public PollResponse castVote(PollRequest pollRequest) throws OverVotingException {
        validateOverVoting(pollRequest.getVoterId());
        return mapper.map(pollRepo.save(mapper.map(pollRequest, Poll.class)), PollResponse.class);
    }

    private void validateOverVoting(String voterId) throws OverVotingException {
        if (pollRepo.findByVoterId(voterId).isPresent())
            throw new OverVotingException("You have already voted.");
    }

    @Override
    public long count() {
        return pollRepo.count();
    }

    @Override
    public String checkResult() {
        ResultResponse result = new ResultResponse((int) partyRepo.count());
        for (var party: partyRepo.findAll()) result.setParty(party.getNameAcronym());
        for (var poll : pollRepo.findAll()) {
            String partyName = partyRepo.findById(poll.getPartyId()).get().getNameAcronym();
            result.increaseVote(partyName);
        }
        return result.toString();
    }
}
