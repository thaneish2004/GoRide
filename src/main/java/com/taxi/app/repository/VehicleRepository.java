package com.taxi.app.repository;

import com.taxi.app.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for Vehicle entity operations.
 * Supports owner-based lookups and plate uniqueness checks.
 */
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    /** Retrieve all vehicles owned by a specific driver or company. */
    List<Vehicle> findByOwnerId(String ownerId);
    /** Find a vehicle by its license plate (case-insensitive). */
    Optional<Vehicle> findByPlateIgnoreCase(String plate);
}
