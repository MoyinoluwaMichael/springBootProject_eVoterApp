package com.example.evotingapp.dtos.response;

import lombok.Data;

@Data
public class PollResponse {
    private String voterId;
    private String partyId;
}

