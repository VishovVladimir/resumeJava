package com.example.resume.repository;

import com.example.resume.model.People;
import com.example.resume.model.PeopleFilter;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PeopleRepositoryCustom {

    public List<People> findAll(PeopleFilter filter);
}
