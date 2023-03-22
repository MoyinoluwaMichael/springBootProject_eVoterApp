package com.example.evotingapp.services.partyService;

import com.example.evotingapp.data.repositories.PartyRepo;
import com.example.evotingapp.dtos.register.PartyRegisterRequest;
import com.example.evotingapp.dtos.response.PartyRegisterResponse;
import com.example.evotingapp.exceptions.DuplicateRegistrationException;
import com.example.evotingapp.exceptions.PartyNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class PartyServiceTest {

    @Autowired
    PartyService partyService;
    @Autowired
    PartyRepo partyRepo;
    PartyRegisterRequest partyRegisterRequest;
    PartyRegisterResponse partyRegisterResponse;


    @BeforeEach void startUp() throws DuplicateRegistrationException {
        partyRepo.deleteAll();
        partyRegisterRequest = PartyRegisterRequest.builder()
                .nameAcronym("LP")
                .fullName("Labour Party")
                .candidateName("Peter Obi")
                .build();
        partyRegisterResponse = partyService.register(partyRegisterRequest);
    }

    @Test void testThatAPartyCanBeRegistered(){
        assertEquals(1, partyService.count());
    }

    @Test void testThatPartyCanBeFoundAfterRegistration() throws PartyNotFoundException {
        PartyRegisterResponse partyRegisterResponse1 = partyService.findById(partyRegisterResponse.getId());
        assertEquals(partyRegisterResponse1.getId(), partyRegisterResponse.getId());
    }

    @Test void findAPartyThatDoesNotExistThrowsException(){
        assertThrows(PartyNotFoundException.class, ()->partyService.findById("1234"));
    }
}