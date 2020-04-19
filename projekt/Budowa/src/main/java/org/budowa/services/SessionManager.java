package org.budowa.services;

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
}
