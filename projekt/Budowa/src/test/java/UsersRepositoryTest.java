import org.budowa.entities.User;
import org.budowa.entities.UserRole;
import org.budowa.repositories.UsersRepository;
import org.budowa.services.PasswordEncryptor;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.budowa.services.PasswordEncryptor;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UsersRepositoryTest {
    UsersRepository usersRepository = new UsersRepository();
    private final PasswordEncryptor authService = PasswordEncryptor.inject();
    static int insertId;

    static final String Username = "Test1";
    static final String Password = "password3834";





    @Test
    @Order(1)
    public void insert_ExpectNotNull() {
        User u = new User();
        u.setUsername(this.Username);
        var encryptedPassword = this.authService.encryptPassword(this.Password);
        u.setPassword(encryptedPassword);
        u.setFullName("Adam Kowalski");
        u.setUserRole(UserRole.OWNER);
        int id = usersRepository.insert(u);
        insertId = id;
        assertNotNull(id);
    }


    @Test
    @Order(2)
    public void findByUsernameAndPassword_ExpectNotNull(){
        User user = usersRepository.findById(insertId);
        assertNotNull(user);
    }

    @Test
    @Order(2)
    public void findAll_ExpectNotNull(){
        Collection<User> user = usersRepository.findAll();
        assertNotNull(user);
    }

    @Test
    @Order(2)
    public void findByUsername_ExpectNotNull(){
        User user = usersRepository.findByUsername(this.Username);
        assertNotNull(user);
    }

    @Test
    @Order(2)
    void findById_ExpectNotNull(){
        try {
            var encryptedPassword = this.authService.encryptPassword(this.Password);
            User user = usersRepository.findByUsernameAndPassword(this.Username, encryptedPassword);
            assertNotNull(user);
        }catch(javax.persistence.NoResultException e){
            fail("findByUsernameAndPassword does not return result");
        }
    }

    @Test
    @Order(2)
    public void find_ExpectNotNull(){
        User user = usersRepository.findById(insertId);
        assertNotNull(user);
    }

    @Test
    @Order(3)
    void update_ExpectSame(){
        User user = usersRepository.findById(insertId);
        String changeFullname = "AfterTest!";
        user.setFullName(changeFullname);
        usersRepository.update(user);

        User userAfterUpdate = usersRepository.findById(insertId);
        assertSame(userAfterUpdate.getFullName(), changeFullname);
    }

    @Test
    @Order(4)
    void delete_ExpectNull(){
        User user = usersRepository.findById(insertId);
        usersRepository.delete(user);
        User userAfterDelete = usersRepository.findById(insertId);
        assertNull(userAfterDelete);
    }



}