package com.example.evotingapp.dtos.response;

import lombok.Data;

@Data
public class VoterRegisterResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private boolean hasVoted;
}
