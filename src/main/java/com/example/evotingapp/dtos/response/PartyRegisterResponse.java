package com.example.evotingapp.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartyRegisterResponse {
    private String id;
    private String nameAcronym;
    private String fullName;
    private String candidateName;
}
