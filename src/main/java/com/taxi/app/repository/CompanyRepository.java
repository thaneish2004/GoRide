package com.taxi.app.repository;

import com.taxi.app.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for Company entity operations.
 * Provides authentication lookup by email/password.
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {
    /** Lookup company by login credentials. */
    Optional<Company> findByEmailAndPassword(String email, String password);
}
