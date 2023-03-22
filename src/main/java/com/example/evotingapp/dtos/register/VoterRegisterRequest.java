package com.example.evotingapp.dtos.register;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VoterRegisterRequest {
    private String firstName;
    private String lastName;
    private String emailAddress;
}
