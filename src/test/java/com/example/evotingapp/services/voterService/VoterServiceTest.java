package com.example.evotingapp.services.voterService;

import com.example.evotingapp.data.repositories.VoterRepo;
import com.example.evotingapp.dtos.register.VoterRegisterRequest;
import com.example.evotingapp.dtos.response.VoterRegisterResponse;
import com.example.evotingapp.exceptions.VoterNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VoterServiceTest {

    @Autowired
    VoterService voterService;
    @Autowired
    VoterRepo voterRepo;
    VoterRegisterRequest voterRegisterRequest;
    VoterRegisterResponse voterRegisterResponse;

    @BeforeEach void startWith() throws VoterAlreadyExistException {
        voterRepo.deleteAll();
        voterRegisterRequest = VoterRegisterRequest.builder()
                .firstName("Renike")
                .lastName("Aliyah")
                .emailAddress("aliyaheniola91@gmail.com")
                .build();
        voterRegisterResponse = voterService.register(voterRegisterRequest);
    }

    @Test void voterCanRegisterTest(){
        assertEquals(1, voterService.count());
    }

    @Test void registeringTwoVotersWithSameEmailThrowsException(){
        assertThrows(VoterAlreadyExistException.class, ()->voterService.register(voterRegisterRequest));
    }

    @Test void voterCanBeFoundAfterRegistrationTest() throws VoterNotFoundException {
        VoterRegisterResponse response = voterService.findById(voterRegisterResponse.getId());
        assertEquals(response.getId(), voterRegisterResponse.getId());
    }

    @Test void findingNonExistingVoterThrowsExceptionTest(){
        assertThrows(VoterNotFoundException.class, ()-> voterService.findById("123"));
    }
}