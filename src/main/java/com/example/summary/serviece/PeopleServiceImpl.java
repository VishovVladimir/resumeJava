package com.example.summary.serviece;

import com.example.summary.model.People;
import com.example.summary.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService {


    @Autowired
    private PeopleRepository repository;


    @Override
    public void create(People people) {
        repository.save(people);


    }


    @Override
    public List<People> readAll() {

        return repository.findAll();
    }

    @Override
    public People read(Long id) {

        return repository.findById(id).get();
    }

    @Override
    public boolean update(People people, Long id) {
        if (repository.existsById(id)) {
            people.setId(id);
            repository.save(people);
            return true;

        }
        return false;
    }

    @Override
    public boolean delete(Long id) {

        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;

        }
        return false;
    }




    @Override
    public List<People> findByNameAndSurname(String name, String surname) {
        return repository.findAllByNameAndSurname(name, surname);
    }
}
