package com.example.evotingapp.services.pollService;

import com.example.evotingapp.data.repositories.PartyRepo;
import com.example.evotingapp.data.repositories.PollRepo;
import com.example.evotingapp.data.repositories.VoterRepo;
import com.example.evotingapp.dtos.register.PartyRegisterRequest;
import com.example.evotingapp.dtos.register.PollRequest;
import com.example.evotingapp.dtos.register.VoterRegisterRequest;
import com.example.evotingapp.dtos.response.PartyRegisterResponse;
import com.example.evotingapp.dtos.response.VoterRegisterResponse;
import com.example.evotingapp.exceptions.OverVotingException;
import com.example.evotingapp.services.partyService.PartyService;
import com.example.evotingapp.services.voterService.VoterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class PollServiceTest {

    @Autowired
    PollService pollService;
    @Autowired
    PollRepo pollRepo;
    @Autowired
    VoterService voterService;
    @Autowired
    VoterRepo voterRepo;
    @Autowired
    PartyRepo partyRepo;
    @Autowired
    PartyService partyService;
    PollRequest pollRequest;
    PartyRegisterResponse partyRegisterResponse;
    VoterRegisterResponse voterRegisterResponse;

    @BeforeEach void startUp() throws VoterAlreadyExistException, OverVotingException {
        pollRepo.deleteAll();
        voterRepo.deleteAll();
        partyRepo.deleteAll();
        partyRegisterResponse = partyService.register(PartyRegisterRequest.builder()
                .nameAcronym("LP")
                .fullName("Labour Party")
                .candidateName("Peter Obi")
                .build());
        voterRegisterResponse = voterService.register(VoterRegisterRequest.builder()
                .firstName("Renike")
                .lastName("Aliyah")
                .emailAddress("aliyaheniola91@gmail.com")
                .build());
        pollRequest = PollRequest.builder()
                .voterId(partyRegisterResponse.getId())
                .voterId(voterRegisterResponse.getId())
                .build();
        pollService.castVote(pollRequest);
    }

    @Test void voterCanCastVoteTest() {
        assertEquals(1, pollService.count());
    }

    @Test void votingTwiceThrowsExceptionTest(){
        assertThrows(OverVotingException.class, ()->pollService.castVote(pollRequest));
    }

}