package com.DreamTeam.DreamTeamAPI;

public class DreamTeamNotFoundException extends RuntimeException {
    public DreamTeamNotFoundException() {
        super("Greeting has not been found");
    }
}
