package org.budowa.services;

import org.budowa.entities.Building;
import org.budowa.repositories.BuildingsRepository;

import java.util.Collection;

public class BuildingsService {

    public static BuildingsService inject() {
        return new BuildingsService();
    }

    private BuildingsRepository buildingsRepository = BuildingsRepository.inject();

    public Collection<Building> getManagerBuildings(int userId) {
        return this.buildingsRepository.findByUserid(userId);
    }

    public Collection<Building> getWorkerBuildings(int userId) {
        return this.buildingsRepository.findByUserid(userId);
    }

    public Collection<Building> getAllBuildings() {
        return this.buildingsRepository.findAll();
    }
}
