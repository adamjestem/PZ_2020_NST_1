import org.budowa.entities.User;
import org.budowa.entities.UserRole;
import org.budowa.repositories.UsersRepository;
import org.budowa.router.Router;
import org.budowa.services.AuthService;
import org.budowa.services.SessionManager;
import org.junit.jupiter.api.*;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuthServiceTest {
    private final AuthService authService = AuthService.inject();
    private final Router router = Router.inject();
    private final SessionManager sessionManager = SessionManager.inject();
    private final UsersRepositoryTest UserTest = new UsersRepositoryTest();

    @Test
    @Order(1)
    public void createUser(){
        UserTest.insert_ExpectNotNull();
    }

    @Test
    @Order(2)
    public void LoginTest(){
        try {
            authService.login(UserTest.Username, UserTest.Password);
        } catch(Exception e){
        } catch(ExceptionInInitializerError e){ // Fail load scene, test mode
        }

        assertTrue(this.sessionManager.isLoggedIn());
    }

    @Test
    @Order(3)
    void LogoutTest(){
        try {
            authService.logout();
        }catch(Exception e){
        }catch(ExceptionInInitializerError e){ // Fail load scene
        } catch (Throwable t) { // failed to load javafx.scene.control.Control, unnecessary in test
        }

        assertFalse(this.sessionManager.isLoggedIn());
    }

    @Test
    @Order(100)
    public void deleteUser(){
        UserTest.delete_ExpectNull();
    }
}
