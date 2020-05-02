package org.budowa.services;

import org.budowa.entities.User;
import org.budowa.entities.UserRole;
import org.budowa.repositories.UsersRepository;

import java.util.ArrayList;

public class UsersService {

    private final UsersRepository usersRepository = UsersRepository.inject();
    private final PasswordEncryptor authService = PasswordEncryptor.inject();

    public static UsersService inject() {
        return new UsersService();
    }

    public User getById(int id) {
        return usersRepository.findById(id);
    }

    public ArrayList<User> getByRole(UserRole role) {
        return usersRepository.findByRole(role);
    }

    public void create (User user) {
        var encryptedPassword = this.authService.encryptPassword(user.getPassword());
        user.setPassword(encryptedPassword);
        usersRepository.insert(user); }
}
