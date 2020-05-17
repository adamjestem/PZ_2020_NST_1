import org.budowa.entities.Building;
import org.budowa.entities.User;
import org.budowa.entities.UserRole;
import org.budowa.repositories.UsersRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {
    UsersRepository usersRepository = new UsersRepository();

    @Test()
    public void should_not_allow_null_object() {
        Exception exception = assertThrows(javax.persistence.PersistenceException.class, () -> {
            User user = new User();
            usersRepository.insert(user);
        });
    }

}
