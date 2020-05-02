package org.budowa.services;

import org.budowa.entities.Building;
import org.budowa.entities.User;
import org.budowa.repositories.BuildingsRepository;

public class BuildingsService {

    public static BuildingsService inject() {
        return new BuildingsService();
    }

    private BuildingsRepository buildingsRepository = BuildingsRepository.inject();

    public Building[] getManagerBuildings(User manager) {
        return this.buildingsRepository.findByManager(manager).toArray(Building[]::new);
    }

    public Building[] getWorkerBuildings(int userId) {
        return this.buildingsRepository.getWorkerBuildings(userId);
    }

    public Building[] getAllBuildings() {
        return this.buildingsRepository.findAll().toArray(Building[]::new);
    }

    public void delete (Building building) { this.buildingsRepository.delete(building); };

    public Building getById(int id) {
        return this.buildingsRepository.findById(id);
    }

    public void add(Building building) {
        buildingsRepository.insert(building);
    }

    public void update(Building building) {
        buildingsRepository.update(building);
    }
}
