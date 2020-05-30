import org.budowa.entities.User;
import org.budowa.entities.UserRole;
import org.budowa.exceptions.UserExistsException;
import org.budowa.repositories.UsersRepository;
import org.budowa.services.PasswordEncryptor;
import org.budowa.services.UsersService;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UsersServiceTest {
    private UsersService usersService = UsersService.inject();
    private UsersRepository usersRepository = UsersRepository.inject();

    User user = new User();

    @BeforeEach
    public void createUser () {
        user.setPassword("pass");
        user.setUsername("test_user_123");
        user.setFullName("test user");
        user.setUserRole(UserRole.OWNER);
        usersRepository.insert(user);
    }

    @AfterEach
    public void deleteUser () {
        usersRepository.delete(user);
    }

    @Test
    @Order(1)
    public void getUserByIdTest () {
        int id = user.getId();

        assertNotNull(usersService.getById(id));
    }

    @Test
    @Order(2)
    public void getByRoleTest () {
        UserRole role = user.getUserRole();

        assertTrue(usersService.getByRole(role).contains(user));
    }

    @Test
    @Order(3)
    public void createAlreadyExistingUserTest () {
        String username = user.getUsername();
        User alreadyExistsUser = new User();
        alreadyExistsUser.setUsername(username);
        alreadyExistsUser.setUserRole(UserRole.OWNER);
        alreadyExistsUser.setPassword("ass");

        try {
            usersService.create(alreadyExistsUser);
        } catch (Exception e) {
            assertTrue(e instanceof UserExistsException);
        }
    }

    @Test
    @Order(4)
    public void getAllUsersTest () {
        ArrayList<User> users = usersService.getAll();

        assertTrue(users.contains(user));
    }

    @Test
    @Order(4)
    public void updateUserPasswordTest () {
        String expectedHash = "098f6bcd4621d373cade4e832627b4f6";

        user.setPassword("test");
        usersService.update(user, true);

        User updatedUser = usersService.getById(user.getId());
        assertTrue(Objects.equals(updatedUser.getPassword(), expectedHash));
    }

    @Test
    @Order(5)
    public void updateUserTest () {
        user.setUsername("new_username");
        user.setFullName("new_full_name");
        usersService.update(user, false);

        User updatedUser = usersService.getById(user.getId());
        assertTrue(Objects.equals(updatedUser.getUsername(), "new_username"));
        assertTrue(Objects.equals(updatedUser.getFullName(), "new_full_name"));
    }
}