package com.example.resume.serviece;

import com.example.resume.model.People;

import java.util.List;

public interface PeopleService {

    void create(People people);

    List<People> readAll();

    People read ( Long id);

    boolean update (People people, Long id);

    boolean delete ( Long id);



    List<People> findByNameAndSurname(String name, String surname);






}
