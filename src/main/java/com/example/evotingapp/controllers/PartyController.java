package com.example.evotingapp.controllers;

import com.example.evotingapp.dtos.register.PartyRegisterRequest;
import com.example.evotingapp.exceptions.DuplicateRegistrationException;
import com.example.evotingapp.exceptions.PartyNotFoundException;
import com.example.evotingapp.services.partyService.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PartyController {

    @Autowired
    private PartyService partyService;

    @PostMapping("/party/register")
    public ResponseEntity<?> register(@RequestBody PartyRegisterRequest request) throws DuplicateRegistrationException {
        return ResponseEntity.ok().body(partyService.register(request));
    }

    @GetMapping("/getParty/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) throws PartyNotFoundException {
        return ResponseEntity.ok().body(partyService.findById(id));
    }
}
