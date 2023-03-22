package com.example.evotingapp.dtos.response;

import java.util.Arrays;

public class ResultResponse {
    private String[] parties;
    private int[] votes;
    private int count;

    public ResultResponse(int noOfParties) {
        parties = new String[noOfParties];
        Arrays.fill(parties, "");
        votes = new int[noOfParties];
    }

    public void setParty(String partyName) {
        for (var party : parties) if (party.equalsIgnoreCase(partyName))return;
        parties[count] = partyName;
        count++;
    }

    public void increaseVote(String partyName) {
        for (int i = 0; i < parties.length; i++) {
            if (parties[i].equalsIgnoreCase(partyName)) votes[i]++;
        }
    }

    public String toString() {
        StringBuilder message = new StringBuilder("""
                ============================
                      ELECTION RESULT
                ============================
                """);
        for (int i = 0; i < parties.length; i++) {
            message.append(String.format("%s. %s: %s vote(s)\n", (i + 1), parties[i], votes[i]));
        }
        return message.toString();
    }
}
