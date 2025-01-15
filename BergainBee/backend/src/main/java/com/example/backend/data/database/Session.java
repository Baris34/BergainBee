package com.example.backend.data.database;

import com.example.backend.business.domain.model.User;

import java.util.UUID;

public class Session {

    private String sessionID;
    private User user;

    public Session(String sessionID, User user) {
        this.sessionID = sessionID;
        this.user = user;
    }

    public static Session startSession(User user) {
        String sessionId = UUID.randomUUID().toString();
        return new Session(sessionId, user);
    }

    public void endSession() {
    }

}
