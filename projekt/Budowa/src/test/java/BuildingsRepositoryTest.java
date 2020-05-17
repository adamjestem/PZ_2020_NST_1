import org.budowa.entities.*;

import org.budowa.repositories.BuildingsRepository;
import org.budowa.repositories.UsersRepository;


import org.junit.jupiter.api.*;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BuildingsRepositoryTest {
    BuildingsRepository buildingsRepository = new BuildingsRepository();
    UsersRepository usersRepository = new UsersRepository();

    static int insertId;
    static int userId;


    @Test
    @Order(1)
    public void createUserManager_ExpectNotNull() {
        User u = new User();
        u.setUsername("Test5");
        u.setPassword("password3834");
        u.setFullName("Adam Kowalski");
        u.setUserRole(UserRole.OWNER);
        int id = usersRepository.insert(u);
        userId = id;
        assertNotNull(id);
    }


    @Test
    @Order(2)
    public void createBuilidng_ExpectNotNull() {
        Building b = new Building();
        b.setDescription("Testowa budowla");
        b.setStatus(BuildingStatus.CEILING);
        b.setAddress("Warszawska 20");
        b.setCustomer("Jerzy Dudek");
        b.setPriority(BuildingPriority.LOW);
        b.setStartDate("2021-01-01");
        b.setStatus(BuildingStatus.FOUNDATIONS);
        b.setAdditionalNotes("My additional notes!");
        b.setManager(usersRepository.findById(userId));
        b.setEndDate("2021-01-04");
        b.setName("Test!");
        b.setWorkers(java.util.Collections.singleton(usersRepository.findById(userId)));
        int id = buildingsRepository.insert(b);
        insertId = id;
        assertNotNull(id);
    }

    @Test
    @Order(3)
    void update_ExpectTrue(){
        Building building = buildingsRepository.findById(insertId);
        String changeName = "AfterTest!";
        building.setName(changeName);
        buildingsRepository.update(building);
        Building buildingAfterUpdate = buildingsRepository.findById(insertId);
        assertSame(buildingAfterUpdate.getName(), changeName);
    }

    @Test
    @Order(4)
    public void find_ExpectNotNull(){
        Building building = buildingsRepository.findById(insertId);
        assertNotNull(building);
    }



    @Test
    @Order(4)
    void findByManager_ExpectArray(){
        User user = usersRepository.findById(userId);
        Collection<Building> building = buildingsRepository.findByManager(user);
        assertTrue(building.size() > 0);
    }


    @Test
    @Order(3)
    void findById_ExpectNotNull(){
        Building build = buildingsRepository.findById(insertId);
        assertNotNull(build);
    }

    @Test
    @Order(4)
    public void findAll_ExpectNotNull(){
        Collection<Building> building = buildingsRepository.findAll();
        assertNotNull(building);
    }

    @Test
    @Order(6)
    public void getWorkerBuildings_ExpectNotNull(){
        Building [] building = buildingsRepository.getWorkerBuildings(userId);
        assertNotNull(building);
    }


    @Test
    void delete(){
        Building building = buildingsRepository.findById(insertId);
        buildingsRepository.delete(building);

        Building buildingAfterDelete = buildingsRepository.findById(insertId);
        assertNull(buildingAfterDelete);
    }


    @Test
    public void deleteUser(){
        User user = usersRepository.findById(userId);
        usersRepository.delete(user);
        User userAfterDelete = usersRepository.findById(userId);
        assertNull(userAfterDelete);
    }

}
