package org.budowa.services;

import org.budowa.entities.User;
import org.budowa.repositories.UsersRepository;

public class UsersService {

    private final UsersRepository usersRepository = UsersRepository.inject();

    public static UsersService inject() {
        return new UsersService();
    }

    public User getById(int id) {
        return usersRepository.findById(id);
    }
}
