package org.budowa.services;

import org.budowa.entities.Building;
import org.budowa.repositories.BuildingsRepository;

public class BuildingsService {

    public static BuildingsService create() {
        return new BuildingsService();
    }

    private BuildingsRepository buildingsRepository = BuildingsRepository.create();

    public Building[] getManagerBuildings(int userId) {
        return this.buildingsRepository.getBuildingsByUserId(userId);
    }

    public Building[] getAllBuildings() {
        return this.buildingsRepository.getAllBuildings();
    }
}
