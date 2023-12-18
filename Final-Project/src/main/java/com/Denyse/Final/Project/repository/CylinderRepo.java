package com.Denyse.Final.Project.repository;

import com.Denyse.Final.Project.model.Cylinder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CylinderRepo extends JpaRepository<Cylinder, UUID> {
    Cylinder findCylinderByCode(String code);

   // Cylinder deleteById(UUID id);
}
