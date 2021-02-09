package com.example.resume.serviece;

import com.example.resume.model.Company;

import java.util.List;

public interface CompanyService {


    void create(Company company);

    List<Company> readAll();

    Company read(Long id);

    boolean update(Company company, Long id);

    boolean delete(Long id);

}
