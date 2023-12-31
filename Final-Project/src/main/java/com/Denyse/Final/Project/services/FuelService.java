package com.Denyse.Final.Project.services;

import com.Denyse.Final.Project.model.Fuel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FuelService {
    List<Fuel> getAllFuels();
    void saveFuel(Fuel fuel);
    void updateFuel(Fuel fuel);
    Optional<Fuel> findByID(UUID id);
    void deleteById(UUID id);
    long countFuels();
}
