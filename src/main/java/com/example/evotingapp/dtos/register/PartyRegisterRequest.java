package com.example.evotingapp.dtos.register;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PartyRegisterRequest {
    private String nameAcronym;
    private String fullName;
    private String candidateName;
}
