package org.budowa.services;

import org.budowa.entities.User;

public class SessionManager {

    private User user = null;

    private static SessionManager sessionManager;

    public static SessionManager inject() {
        if (SessionManager.sessionManager == null) {
            SessionManager.sessionManager = new SessionManager();
        }
        return SessionManager.sessionManager;
    }

    public boolean isLoggedIn() {
        return this.user != null;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getLoggedInUser() {
        return this.user;
    }
}
