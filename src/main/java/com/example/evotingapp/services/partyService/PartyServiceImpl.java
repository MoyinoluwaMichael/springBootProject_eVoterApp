package com.example.evotingapp.services.partyService;

import com.example.evotingapp.data.models.Party;
import com.example.evotingapp.data.repositories.PartyRepo;
import com.example.evotingapp.dtos.register.PartyRegisterRequest;
import com.example.evotingapp.dtos.response.PartyRegisterResponse;
import com.example.evotingapp.exceptions.DuplicateRegistrationException;
import com.example.evotingapp.exceptions.PartyNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PartyServiceImpl implements PartyService{
    @Autowired
    PartyRepo partyRepo;
    ModelMapper mapper = new ModelMapper();
    @Override
    public PartyRegisterResponse register(PartyRegisterRequest partyRegisterRequest) throws DuplicateRegistrationException {
        validateDuplicateRegistration(partyRegisterRequest.getFullName());
        return  mapper.map(partyRepo.save(mapper.map(partyRegisterRequest, Party.class)), PartyRegisterResponse.class);
    }

    private void validateDuplicateRegistration(String fullName) throws DuplicateRegistrationException {
        if (partyRepo.findByFullName(fullName).isPresent())
            throw new DuplicateRegistrationException("Party with name: "+fullName+" already exist.");
    }

    @Override
    public long count() {
        return partyRepo.count();
    }

    @Override
    public PartyRegisterResponse findById(String id) throws PartyNotFoundException {
        Optional<Party> party = partyRepo.findById(id);
        validatePartyExistence(party);
        return mapper.map(party, PartyRegisterResponse.class);
    }

    private void validatePartyExistence(Optional<Party> party) throws PartyNotFoundException {
        if (party.isEmpty()) throw new PartyNotFoundException("Party does not exist.");
    }
}
