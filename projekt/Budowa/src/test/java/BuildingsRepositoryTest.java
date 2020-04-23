import org.budowa.entities.Building;
import org.budowa.entities.BuildingStatus;

import org.budowa.entities.User;
import org.budowa.entities.UserRole;
import org.budowa.repositories.BuildingsRepository;
import org.budowa.repositories.UsersRepository;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuildingsRepositoryTest {
    BuildingsRepository buildingsRepository = new BuildingsRepository();
    UsersRepository usersRepository = new UsersRepository();

    static int insertId;
    static int userId;


    @Test
    public void building_repository_crud(){
        create_user_manager();

        insert();
        find();
        update();
        delete();

        deleteUser();
    }



    public void create_user_manager() {
        User u = new User();
        u.setUsername("Test1");
        u.setPassword("password3834");
        u.setFullName("Adam Kowalski");
        u.setUserRole(UserRole.OWNER);
        int id = usersRepository.insert(u);
        userId = id;
        assertNotNull(id);
    }


    public void deleteUser(){
        User user = usersRepository.findById(userId);
        usersRepository.delete(user);

        User userAfterDelete = usersRepository.findById(userId);
        assertNull(userAfterDelete);
    }


    public void insert() {
        Building b = new Building();
        b.setDescription("Testowa budowla");
        b.setStatus(BuildingStatus.CEILING);
        b.setManager(usersRepository.findById(userId));
        b.setName("Test!");

        int id = buildingsRepository.insert(b);
        insertId = id;
        assertNotNull(id);
    }

    public void find(){
        Building building = buildingsRepository.findById(insertId);
        assertNotNull(building);
    }


    void update(){
        Building building = buildingsRepository.findById(insertId);
        String changeName = "AfterTest!";
        building.setName(changeName);
        buildingsRepository.update(building);

        Building buildingAfterUpdate = buildingsRepository.findById(insertId);
        assertSame(buildingAfterUpdate.getName(), changeName);
    }


    void delete(){
        Building building = buildingsRepository.findById(insertId);
        buildingsRepository.delete(building);

        Building buildingAfterDelete = buildingsRepository.findById(insertId);
        assertNull(buildingAfterDelete);
    }



}
