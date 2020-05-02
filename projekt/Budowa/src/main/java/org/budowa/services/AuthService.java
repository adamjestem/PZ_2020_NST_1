package org.budowa.services;

import org.apache.commons.codec.digest.DigestUtils;
import org.budowa.entities.User;
import org.budowa.repositories.UsersRepository;
import org.budowa.router.Route;
import org.budowa.router.Router;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

public class AuthService {
    private static AuthService authService;
    private final Router router = Router.inject();
    private final UsersRepository usersRepository = UsersRepository.inject();
    private final SessionManager sessionManager = SessionManager.inject();
    private final PasswordEncryptor passwordEncryptor = PasswordEncryptor.inject();

    public static AuthService inject() {
        if (AuthService.authService == null) {
            AuthService.authService = new AuthService();
        }
        return AuthService.authService;
    }

    public void login(String username, String password) throws IOException {
        String encryptedPassword = passwordEncryptor.encryptPassword(password);
        User user = usersRepository.findByUsernameAndPassword(
                username,
                encryptedPassword
        );

        this.sessionManager.setUser(user);
        this.router.goTo(Route.DASHBOARD);
    }

    public void logout() throws IOException {
        this.sessionManager.setUser(null);
        this.router.goTo(Route.LOGIN);
    }

}
