package org.budowa.services;

import org.budowa.entities.UserRole;

// todo:
public class SessionManager {

    private static SessionManager sessionManager;

    public static SessionManager inject() {
        if (SessionManager.sessionManager == null) {
            SessionManager.sessionManager = new SessionManager();
        }
        return SessionManager.sessionManager;
    }

    public void logout() {
        // todo: logout user
    }

    public boolean isLoggedIn() {
        // todo: implement
        return true;
    }

    public UserRole getUserRole() {
        // todo
        return UserRole.MANAGER;
    }
}
