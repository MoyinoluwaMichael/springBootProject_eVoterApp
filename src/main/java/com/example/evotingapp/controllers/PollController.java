package com.example.evotingapp.controllers;

import com.example.evotingapp.dtos.register.PollRequest;
import com.example.evotingapp.exceptions.OverVotingException;
import com.example.evotingapp.services.pollService.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PollController {

    @Autowired
    private PollService pollService;

    @PostMapping("/poll/castVote")
    public ResponseEntity<?> castVote(@RequestBody PollRequest request) throws OverVotingException {
        return ResponseEntity.ok().body(pollService.castVote(request));
    }

    @GetMapping("poll/getResult")
    public ResponseEntity<?> getResult(){
        return ResponseEntity.ok().body(pollService.checkResult());
    }
}
