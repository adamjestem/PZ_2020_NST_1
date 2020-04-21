import org.budowa.entities.User;
import org.budowa.entities.UserRole;
import org.budowa.repositories.UsersRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsersRepositoryTest {
    UsersRepository usersRepository = new UsersRepository();

    static int insertId;


    @Test
    public void user_repository_crud(){
        insert();
        find();
        update();
        delete();
    }



    public void insert() {
        User u = new User();
        u.setUsername("Test1");
        u.setPassword("password3834");
        u.setFullName("Adam Kowalski");
        u.setUserRole(UserRole.OWNER);
        int id = usersRepository.insert(u);
        insertId = id;
        assertNotNull(id);
    }

    public void find(){
        User user = usersRepository.findById(insertId);
        assertNotNull(user);
    }


    void update(){
        User user = usersRepository.findById(insertId);
        String changeFullname = "AfterTest!";
        user.setFullName(changeFullname);
        usersRepository.update(user);

        User userAfterUpdate = usersRepository.findById(insertId);
        assertSame(userAfterUpdate.getFullName(), changeFullname);
    }


    void delete(){
        User user = usersRepository.findById(insertId);
        usersRepository.delete(user);

        User userAfterDelete = usersRepository.findById(insertId);
        assertNull(userAfterDelete);
    }



}