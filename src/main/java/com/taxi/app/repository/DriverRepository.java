package com.taxi.app.repository;

import com.taxi.app.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, String> {
    Optional<Driver> findByEmailAndPassword(String email, String password);
    List<Driver> findByStatusIgnoreCase(String status);
}
