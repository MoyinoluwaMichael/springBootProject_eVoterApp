package com.example.evotingapp.services.voterService;

import com.example.evotingapp.data.models.Voter;
import com.example.evotingapp.data.repositories.VoterRepo;
import com.example.evotingapp.dtos.register.VoterRegisterRequest;
import com.example.evotingapp.dtos.response.VoterRegisterResponse;
import com.example.evotingapp.exceptions.DuplicateRegistrationException;
import com.example.evotingapp.exceptions.VoterNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoterServiceImpl implements VoterService{
    @Autowired
    private VoterRepo voterRepo;
    ModelMapper mapper = new ModelMapper();

    @Override
    public VoterRegisterResponse register(VoterRegisterRequest voterRegisterRequest) throws DuplicateRegistrationException {
        String email = voterRegisterRequest.getEmailAddress();
        Optional<Voter> voter = voterRepo.findByEmailAddress(email);
        if (voter.isPresent()) throw new DuplicateRegistrationException("Voter with "+email+" already exist");
        return mapper.map(voterRepo.save(mapper.map(voterRegisterRequest, Voter.class)), VoterRegisterResponse.class);
    }

    @Override
    public long count() {
        return voterRepo.count();
    }

    @Override
    public VoterRegisterResponse findById(String id) throws VoterNotFoundException {
        Optional<Voter> voter = voterRepo.findById(id);
        if (voter.isEmpty()) throw new VoterNotFoundException("Voter does not exist");
        return mapper.map(voter, VoterRegisterResponse.class);
    }
}
