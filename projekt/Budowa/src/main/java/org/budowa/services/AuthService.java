package org.budowa.services;

import org.apache.commons.codec.digest.DigestUtils;
import org.budowa.entities.User;
import org.budowa.repositories.UsersRepository;
import org.budowa.router.Route;
import org.budowa.router.Router;

import java.io.IOException;

public class AuthService {
	private static AuthService authService;
	private final Router router = Router.inject();
	private final UsersRepository usersRepository = UsersRepository.inject();
	private final SessionManager sessionManager = SessionManager.inject();

	public static AuthService inject() {
		if (AuthService.authService == null) {
			AuthService.authService = new AuthService();
		}
		return AuthService.authService;
	}

	public void login(String username, String password) throws IOException {
		String encryptedPassword = DigestUtils.md5Hex( password );
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
