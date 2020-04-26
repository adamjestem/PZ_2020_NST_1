package org.budowa.services;

import org.budowa.entities.Building;
import org.budowa.repositories.BuildingsRepository;

public class BuildingsService {

    public static BuildingsService inject() {
        return new BuildingsService();
    }

    private BuildingsRepository buildingsRepository = BuildingsRepository.inject();

    public Building[] getManagerBuildings(int userId) {
        return this.buildingsRepository.findByUserid(userId).toArray(Building[]::new);
    }

    public Building[] getWorkerBuildings(int userId) {
        return this.buildingsRepository.getWorkerBuildings(userId);
    }

    public Building[] getAllBuildings() {
        return this.buildingsRepository.findAll().toArray(Building[]::new);
    }

    public Building getById(int id) {
        return this.buildingsRepository.findById(id);
    }
}
