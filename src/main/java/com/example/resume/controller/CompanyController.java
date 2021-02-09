package com.example.resume.controller;

import com.example.resume.model.Company;
import com.example.resume.serviece.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class CompanyController {

    private final CompanyService service;

    @Autowired
    public CompanyController(CompanyService service) {
        this.service = service;
    }


    @PostMapping(value = "/companies")
    public ResponseEntity<?> create(@RequestBody Company company) {

        company.setCreated_at(LocalDateTime.now());
        service.create(company);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping(value = "/companies")
    public ResponseEntity<List<Company>> readAll() {
        final List<Company> companies = service.readAll();

        if (companies != null && !companies.isEmpty()) {

            return new ResponseEntity<>(companies, HttpStatus.OK);
        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping(value = "/companies/{id}")
    public ResponseEntity<Company> read(@PathVariable(name = "id") Long id) {
        final Company company = service.read(id);

        return company != null
                ? new ResponseEntity<>(company, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }

    @PutMapping(value = "/companies/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody Company company) {
        final boolean updated = service.update(company, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);


    }

    @DeleteMapping(value = "/companies/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        final boolean deleted = service.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);


    }


}
