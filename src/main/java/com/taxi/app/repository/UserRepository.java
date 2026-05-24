package com.taxi.app.repository;

import com.taxi.app.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for Passenger entity operations.
 * Provides authentication, duplicate checking, and search functionality.
 */
@Repository
public interface UserRepository extends JpaRepository<Passenger, String> {
    /** Lookup passenger by login credentials. */
    Optional<Passenger> findByEmailAndPassword(String email, String password);
    /** Check if a passenger with the given email already exists (case-insensitive). */
    boolean existsByEmailIgnoreCase(String email);
    /** Find a passenger by their exact email address. */
    Optional<Passenger> findByEmail(String email);
    /** Search passengers by name, email, or phone (partial match, case-insensitive). */
    List<Passenger> findByNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrPhoneContaining(
            String name, String email, String phone);
}
