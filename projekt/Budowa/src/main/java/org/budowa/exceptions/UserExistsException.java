package org.budowa.exceptions;

import org.budowa.entities.User;

public class UserExistsException extends Exception {
    public UserExistsException(User user) {
        super("User with username " + user.getUsername() + " already exists!");
    }
}
