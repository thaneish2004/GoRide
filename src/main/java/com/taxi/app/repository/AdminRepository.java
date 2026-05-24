package com.taxi.app.repository;

import com.taxi.app.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for Admin entity operations.
 * Provides authentication lookup by email/password and duplicate checking.
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {
    /** Lookup admin by login credentials. */
    Optional<Admin> findByEmailAndPassword(String email, String password);
    /** Check if an admin with the given email already exists. */
    boolean existsByEmail(String email);
}
