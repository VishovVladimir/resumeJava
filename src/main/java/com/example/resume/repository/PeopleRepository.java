package com.example.resume.repository;

import com.example.resume.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PeopleRepository extends JpaRepository<People, Long>, JpaSpecificationExecutor<People> {


//
//    List<People> findBySurname();
//
//    List<People> findByCompany();


}
