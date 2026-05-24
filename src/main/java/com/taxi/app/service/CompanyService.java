package com.taxi.app.service;

import com.taxi.app.dto.LoginRequest;
import com.taxi.app.model.Company;
import com.taxi.app.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Optional<Company> login(LoginRequest req) {
        return companyRepository.findByEmailAndPassword(req.getEmail(), req.getPassword());
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Optional<Company> findById(String id) {
        return companyRepository.findById(id);
    }

    public Company save(Company company) {
        if (company.getId() == null || company.getId().isBlank()) {
            company.setId(UUID.randomUUID().toString());
        }
        return companyRepository.save(company);
    }

    public Company update(Company company) {
        return companyRepository.save(company);
    }
}
