package org.budowa.services;

import org.budowa.entities.User;
import org.budowa.entities.UserRole;
import org.budowa.repositories.UsersRepository;

import java.util.ArrayList;

public class UsersService {

    private final UsersRepository usersRepository = UsersRepository.inject();

    public static UsersService inject() {
        return new UsersService();
    }

    public User getById(int id) {
        return usersRepository.findById(id);
    }

    public ArrayList<User> getByRole(UserRole role) {
        return usersRepository.findByRole(role);
    }
}
