package com.example.resume.service;

import com.example.resume.model.People;
import com.example.resume.model.PeopleFilter;

import java.util.List;

public interface PeopleService {

    boolean create(People people);

    List<People> readAll();

    People read ( Long id);

    boolean update (People people, Long id);

    boolean delete ( Long id);



    List<People> find(PeopleFilter filter);






}
