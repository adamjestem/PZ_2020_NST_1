import org.budowa.entities.Building;
import org.junit.jupiter.api.Test;
import org.budowa.repositories.BuildingsRepository;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class BuildingTest {
    BuildingsRepository buildingsRepository = new BuildingsRepository();


    @Test()
    public void should_not_allow_null_object() {
        Exception exception = assertThrows(javax.persistence.PersistenceException.class, () -> {
            Building building = new Building();
            buildingsRepository.insert(building);
        });
    }


}
