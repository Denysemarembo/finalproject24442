package com.Denyse.Final.Project.repository;

import com.Denyse.Final.Project.model.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FuelRepo extends JpaRepository<Fuel, UUID> {

}
