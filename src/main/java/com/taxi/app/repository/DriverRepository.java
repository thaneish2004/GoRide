package com.taxi.app.repository;

import com.taxi.app.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for Driver entity operations.
 * Supports authentication and status-based queries for dispatching.
 */
@Repository
public interface DriverRepository extends JpaRepository<Driver, String> {
    /** Lookup driver by login credentials. */
    Optional<Driver> findByEmailAndPassword(String email, String password);
    /** Find drivers by availability status (case-insensitive). */
    List<Driver> findByStatusIgnoreCase(String status);
}
