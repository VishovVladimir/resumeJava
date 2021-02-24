package com.example.resume.repository;

import com.example.resume.model.People;
import com.example.resume.model.PeopleFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PeopleRepositoryImpl implements PeopleRepositoryCustom {
    @Autowired
    EntityManager em;


    @Override
    public List<People> findAll(PeopleFilter filter) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<People> cq = cb.createQuery(People.class);

        Root<People> people = cq.from(People.class);
        List<Predicate> predicates = new ArrayList<>();

        if (filter.getName() != null) {
            predicates.add(cb.equal(cb.upper(people.get("name")), filter.getName().toUpperCase()));

        }
        if (filter.getSurname() != null) {
            predicates.add(cb.equal(cb.upper(people.get("surname")), filter.getSurname().toUpperCase()));

        }

        if (filter.getSex() != null) {
            predicates.add(cb.equal(cb.upper(people.get("sex")), filter.getSex().toUpperCase()));

        }
        if (filter.getCreatedAfter() != null) {
            predicates.add(cb.greaterThanOrEqualTo(people.get("created_at"), filter.getCreatedAfter()));


        }
        if (filter.getCreatedBefore() != null) {
            predicates.add(cb.lessThanOrEqualTo(people.get("created_at"), filter.getCreatedBefore()));

        }
        if (filter.getOlder() != null) {
            predicates.add(cb.greaterThanOrEqualTo(people.get("age"), filter.getOlder()));

        }
        if (filter.getUnder() != null) {
            predicates.add(cb.lessThanOrEqualTo(people.get("age"), filter.getUnder()));
        }
        if (filter.getCompany() != null) {
            predicates.add(cb.equal(people.get("company").get("id"), filter.getCompany().getId()));

        }
        cq.where(predicates.toArray(new Predicate[0]));

        return em.createQuery(cq).getResultList();

    }
}
