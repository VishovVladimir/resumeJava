package com.example.resume.repository;

import com.example.resume.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

     Company findIdByName(String name);
}
