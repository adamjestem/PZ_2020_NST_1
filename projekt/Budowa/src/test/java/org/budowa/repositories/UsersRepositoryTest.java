package org.budowa.repositories;

import org.budowa.entities.User;
import org.budowa.entities.UserRole;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class UsersRepositoryTest {

    UsersRepository usersRepository = new UsersRepository();


    @Test
    void insert() {
        User u = new User();
        u.setUsername("Test1");
        u.setPassword("password3834");
        u.setUserRole(UserRole.OWNER);

        int id = usersRepository.insert(u);

        assertNotNull(id);
    }
}