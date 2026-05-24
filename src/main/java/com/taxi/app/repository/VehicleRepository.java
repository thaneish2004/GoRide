package com.taxi.app.repository;

import com.taxi.app.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    List<Vehicle> findByOwnerId(String ownerId);
    Optional<Vehicle> findByPlateIgnoreCase(String plate);
}
