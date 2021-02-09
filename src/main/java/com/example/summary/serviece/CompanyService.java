package com.example.summary.serviece;

import com.example.summary.model.Company;

import java.util.List;

public interface CompanyService {


    void create(Company company);

    List<Company> readAll();

    Company read(Long id);

    boolean update(Company company, Long id);

    boolean delete(Long id);

}
