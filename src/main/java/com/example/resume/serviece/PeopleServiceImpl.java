package com.example.resume.serviece;

import com.example.resume.model.People;
import com.example.resume.repository.PeopleRepository;
import com.example.resume.repository.PeopleSpecification;
import com.example.resume.repository.PeopleSpecificationBuilder;
import com.example.resume.repository.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
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
    public List<People> findByNameAndSurnameAndSex(String name, String surname, String sex) {
        PeopleSpecificationBuilder builder = new PeopleSpecificationBuilder();
        if(isBlan name!=null&& name!=""){
         builder.with("name",":", name);

        }
        if(surname!=null&& surname!=""){
            builder.with("surname",":", surname);

        }
        if(sex!=null&& sex!=""){
            builder.with("sex",":", sex);

        }
        Specification<People> spec = builder.build();

//apache commons 3 isBlank()

return  repository.findAll(spec);

    }
}
