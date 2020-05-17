import org.budowa.entities.User;
import org.budowa.entities.UserRole;
import org.budowa.repositories.UsersRepository;
import org.budowa.router.Router;
import org.budowa.services.AuthService;
import org.budowa.services.SessionManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


public class AuthServiceTest {
    private final AuthService authService = AuthService.inject();
    private final Router router = Router.inject();
    private final SessionManager sessionManager = SessionManager.inject();
    private final UsersRepositoryTest UserTest = new UsersRepositoryTest();

    @BeforeAll
    public static void createUser(){
        UsersRepositoryTest UserTest = new UsersRepositoryTest();
        UserTest.insert();
    }

    @Test
    public void LoginTest(){
        try {
            authService.login(UserTest.Username, UserTest.Password);
        } catch(Exception e){
        } catch(ExceptionInInitializerError e){ // Fail load scene, test mode
        }

        assertTrue(this.sessionManager.isLoggedIn());
    }

    @Test void LogoutTest(){
        try {
            authService.logout();
        }catch(Exception e){
        }catch(ExceptionInInitializerError e){ // Fail load scene
        } catch (Throwable t) { // failed to load javafx.scene.control.Control, unnecessary in test
        }

        assertFalse(this.sessionManager.isLoggedIn());
    }

    @AfterAll
    public static void deleteUser(){
        UsersRepositoryTest UserTest = new UsersRepositoryTest();
        UserTest.delete();
    }

}
