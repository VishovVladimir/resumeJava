package com.example.resume.controller;


import com.example.resume.model.People;
import com.example.resume.model.PeopleFilter;
import com.example.resume.serviece.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
public class PeopleController {
    private final PeopleService peopleService;


    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }


    @PostMapping(value = "/peoples")
    public ResponseEntity<?> create(@RequestBody People people) {

        people.setCreated_at(LocalDateTime.now());

        peopleService.create(people);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }


    @GetMapping(value = "/peoples")
    public ResponseEntity<List<People>> read() {
        final List<People> peoples = peopleService.readAll();


        if (peoples != null && !peoples.isEmpty()) {


            return new ResponseEntity<>(peoples, HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }


    @GetMapping(value = "/peoples/{id}")
    public ResponseEntity<People> read(@PathVariable(name = "id") Long id) {
        final People people = peopleService.read(id);

        return people != null
                ? new ResponseEntity<>(people, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }

    @PutMapping(value = "/peoples/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody People people) {

        people.setUpdate_at(LocalDateTime.now());
        final boolean updated = peopleService.update(people, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);


    }

    @DeleteMapping(value = "/peoples/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        final boolean deleted = peopleService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);


    }

    @GetMapping(value = "/peoples/find")
    public ResponseEntity<List<People>> find( PeopleFilter filter) {

        final List<People> peoples = peopleService.find(filter);




            return new ResponseEntity<>(peoples, HttpStatus.OK);
    }


}
