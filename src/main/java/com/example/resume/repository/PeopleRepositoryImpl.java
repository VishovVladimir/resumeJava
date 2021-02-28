package com.example.resume.repository;

import com.example.resume.model.People;
import com.example.resume.model.PeopleFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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
        Predicate finalQuery = cb.and(predicates.toArray(new Predicate[0]));
        cq.where(finalQuery);


        if (filter.getPage_number() != null && filter.getPage_size() != null) {
            TypedQuery<People> typedQuery = em.createQuery(cq);
            CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);

            countQuery.select(cb.count(countQuery.from(People.class)));
            em.createQuery(countQuery);
            countQuery.where(finalQuery);
            Long count = em.createQuery(countQuery).getSingleResult();
            int firstNum = (filter.getPage_number() - 1) * filter.getPage_size();

            if (count > 0 && firstNum < count) {


                typedQuery.setFirstResult(firstNum);
                int quotient = (int) (count - firstNum);
                if (quotient > filter.getPage_size()) {
                    typedQuery.setMaxResults(filter.getPage_size());

                } else {
                    typedQuery.setMaxResults(quotient);

                }
                return typedQuery.getResultList();


            } else return new ArrayList<>();
        } else {
            return em.createQuery(cq).getResultList();
        }

    }



}
