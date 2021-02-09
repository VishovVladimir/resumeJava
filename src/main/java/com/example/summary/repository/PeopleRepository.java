package com.example.summary.repository;

import com.example.summary.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PeopleRepository extends JpaRepository<People, Long> {

    @Query(value = "SELECT p FROM People p WHERE (:name is null or p.name = :name) and (:surname is null"
            + " or p.surname = :surname)")
    List<People> findAllByNameAndSurname(@Param("name") String name, @Param("surname") String surname);
//
//    List<People> findBySurname();
//
//    List<People> findByCompany();


}
