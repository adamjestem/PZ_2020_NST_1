package org.budowa.repositories;

import org.budowa.entities.Building;
import org.budowa.entities.BuildingStatus;

// todo: add db connection
public class BuildingsRepository {

    private final Building[] fakeData;

    BuildingsRepository() {
        this.fakeData = new Building[3];
        var b1 = new Building();
        b1.setName("Budowa u Staszka");
        b1.setStatus(BuildingStatus.CEILING);
        fakeData[0] = b1;
        var b2 = new Building();
        b2.setName("Budowa u Zbyszka");
        b2.setStatus(BuildingStatus.FOUNDATIONS);
        fakeData[1] = b2;
        var b3 = new Building();
        b3.setName("Budowa u Janusza");
        b3.setStatus(BuildingStatus.TODO);
        fakeData[2] = b3;
    }

    public Building[] getAllBuildings() {
        return this.fakeData;
    }

    public Building[] getBuildingsByUserId(int userId) {
        return this.fakeData;
    }

    public static BuildingsRepository create() {
        return new BuildingsRepository();
    }
}
