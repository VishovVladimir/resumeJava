package com.example.resume.service;

import com.example.resume.model.People;
import com.example.resume.model.PeopleFilter;
import com.example.resume.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService {


    @Autowired
    private PeopleRepository repository;


    @Override
    public boolean create(People people) {

        if(repository.findByEmail(people.getEmail())==null){
            repository.save(people);
            return true;
        }
        else return false;


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
    public List<People> find(PeopleFilter filter) {

        //Specification<People> spec = builder.build();
        //Specification<People> spec = PeopleSpecificationBuilder.getSpecification(filter);


//apache commons 3 isBlank()

return  repository.findAll(filter);

    }
}
