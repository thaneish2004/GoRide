package com.taxi.app.service;

import com.taxi.app.dto.LoginRequest;
import com.taxi.app.model.Company;
import com.taxi.app.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service layer for Company operations.
 * Handles authentication and CRUD for company/organization accounts.
 */
@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    /** Authenticate company via email/password. */
    public Optional<Company> login(LoginRequest req) {
        return companyRepository.findByEmailAndPassword(req.getEmail(), req.getPassword());
    }

    /** Retrieve all companies. */
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    /** Find company by ID. */
    public Optional<Company> findById(String id) {
        return companyRepository.findById(id);
    }

    /** Save new company, generating ID if not set. */
    public Company save(Company company) {
        if (company.getId() == null || company.getId().isBlank()) {
            company.setId(UUID.randomUUID().toString());
        }
        return companyRepository.save(company);
    }

    /** Update existing company record. */
    public Company update(Company company) {
        return companyRepository.save(company);
    }
}
