package com.example.resume.repository;

import com.example.resume.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PeopleRepository extends JpaRepository<People, Long>, PeopleRepositoryCustom {
    People findByEmail(String email);

}
