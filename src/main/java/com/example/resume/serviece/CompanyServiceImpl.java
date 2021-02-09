package com.example.resume.serviece;

import com.example.resume.model.Company;
import com.example.resume.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private CompanyRepository repository;


    @Override
    public void create(Company company) {
        repository.save(company);
    }

    @Override
    public List<Company> readAll() {
        return repository.findAll();
    }

    @Override
    public Company read(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public boolean update(Company company, Long id) {
        if (repository.existsById(id)) {
            company.setId(id);
            repository.save(company);
            return true;

        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;

        }
        return false;
    }
}
