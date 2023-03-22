package com.example.evotingapp.dtos.register;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PollRequest {
    private String voterId;
    private String partyId;
}
