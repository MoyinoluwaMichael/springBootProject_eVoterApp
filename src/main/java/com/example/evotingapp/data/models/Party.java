package com.example.evotingapp.data.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Parties")
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Party {
    @Id
    private String id;
    @NonNull
    private String nameAcronym;
    @NonNull
    private String fullName;
    @NonNull
    private String candidateName;
}
