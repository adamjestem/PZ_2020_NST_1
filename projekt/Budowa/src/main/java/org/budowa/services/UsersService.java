package org.budowa.services;

import org.budowa.entities.User;
import org.budowa.entities.UserRole;
import org.budowa.exceptions.UserExistsException;
import org.budowa.repositories.UsersRepository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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

    public void create (User user) throws UserExistsException {
        var existingUser = this.usersRepository.findByUsername(user.getUsername());
        if(existingUser != null) {
            throw new UserExistsException(existingUser);
        }
        var encryptedPassword = this.authService.encryptPassword(user.getPassword());
        user.setPassword(encryptedPassword);
        usersRepository.insert(user);
    }

    public ArrayList<User> getAll() {
        return new ArrayList<>(this.usersRepository.findAll());
    }

    public void update(User user, boolean newPassword) {
        if (newPassword) {
            var encryptedPassword = this.authService.encryptPassword(user.getPassword());
            user.setPassword(encryptedPassword);
        }
        usersRepository.update(user);
    }

    public void removeUser(int userId) {
        var user = this.usersRepository.findById(userId);
        var buildings = user.getBuildings();
        if (buildings != null) {
            for(var building : buildings) {
                building.getWorkers().remove(user);
            }
        }

        var managedBuildings = user.getManagedBuildings();
        if (managedBuildings != null) {
            for(var building : managedBuildings) {
                building.setManager(null);
            }
        }

        this.usersRepository.delete(user);
    }
}
