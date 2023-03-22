package com.example.evotingapp.controllers;

import com.example.evotingapp.dtos.register.VoterRegisterRequest;
import com.example.evotingapp.exceptions.DuplicateRegistrationException;
import com.example.evotingapp.exceptions.VoterNotFoundException;
import com.example.evotingapp.services.voterService.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VoterController {
    @Autowired
    private VoterService voterService;

    @PostMapping("/voter/register")
    public ResponseEntity<?> register(@RequestBody VoterRegisterRequest request) throws DuplicateRegistrationException {
        return ResponseEntity.ok().body(voterService.register(request));
    }

    @GetMapping("/getVoter/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) throws VoterNotFoundException {
        return ResponseEntity.ok().body(voterService.findById(id));
    }
}
