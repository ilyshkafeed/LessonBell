package ru.bellintegrator.practice.api.сountries.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.api.сountries.model.Countries;
import ru.bellintegrator.practice.api.сountries.model.Countries_;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class CountriesDaoImpl implements CountriesDao {


    private final EntityManager em;

    @Autowired
    public CountriesDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Countries get(int id) {
        return em.find(Countries.class, id);
    }

    @Override
    public Countries findByCode(int code) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Countries> cq = cb.createQuery(Countries.class);
        Root<Countries> orgRoot = cq.from(Countries.class);
        cq.where(cb.equal(orgRoot.get(Countries_.code), code));
        TypedQuery<Countries> query = em.createQuery(cq);
        query.setMaxResults(1);
        return query.getSingleResult();
    }

    @Override
    public Countries findByName(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Countries> cq = cb.createQuery(Countries.class);
        Root<Countries> orgRoot = cq.from(Countries.class);
        cq.where(cb.like(cb.lower(orgRoot.get(Countries_.name)), "%" + name.toLowerCase() + "%"));
        TypedQuery<Countries> query = em.createQuery(cq);
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}
