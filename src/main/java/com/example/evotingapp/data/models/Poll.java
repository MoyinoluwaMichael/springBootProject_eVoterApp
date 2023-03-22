package com.example.evotingapp.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Polls")
public class Poll {
    @Id
    private String voterId;
    private String partyId;
}
