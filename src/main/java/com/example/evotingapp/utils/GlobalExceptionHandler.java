package com.example.evotingapp.utils;

import com.example.evotingapp.exceptions.DuplicateRegistrationException;
import com.example.evotingapp.exceptions.OverVotingException;
import com.example.evotingapp.exceptions.PartyNotFoundException;
import com.example.evotingapp.exceptions.VoterNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String> handleExceptions(PartyNotFoundException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handleExceptions(OverVotingException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handleExceptions(DuplicateRegistrationException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handleExceptions(VoterNotFoundException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
