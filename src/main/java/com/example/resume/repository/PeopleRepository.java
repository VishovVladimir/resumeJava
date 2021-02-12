package com.example.resume.repository;

import com.example.resume.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PeopleRepository extends JpaRepository<People, Long> {

    @Query(value = "SELECT p FROM People p WHERE (:name is null or p.name = :name) and (:surname is null"
            + " or p.surname = :surname) and (:sex is null or p.sex = :sex)")
    List<People> findAllByNameAndSurnameAndSex(@Param("name") String name, @Param("surname") String surname,
                                            @Param("sex") String sex);
//
//    List<People> findBySurname();
//
//    List<People> findByCompany();


}
