package com.example.summary.repository;

import com.example.summary.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

     Company findIdByName(String name);
}
