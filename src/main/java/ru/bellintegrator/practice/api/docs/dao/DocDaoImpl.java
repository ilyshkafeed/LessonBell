package ru.bellintegrator.practice.api.docs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.api.docs.model.Doc;
import ru.bellintegrator.practice.api.docs.model.Doc_;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class DocDaoImpl implements DocDao {


    private final EntityManager em;

    @Autowired
    public DocDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Doc get(int id) {
        return em.find(Doc.class, id);
    }

    @Override
    public Doc findByCode(int code) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Doc> cq = cb.createQuery(Doc.class);
        Root<Doc> orgRoot = cq.from(Doc.class);
        cq.where(cb.equal(orgRoot.get(Doc_.code), code));
        TypedQuery<Doc> query = em.createQuery(cq);
        query.setMaxResults(1);
        return query.getSingleResult();
    }

    @Override
    public Doc findByName(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Doc> cq = cb.createQuery(Doc.class);
        Root<Doc> orgRoot = cq.from(Doc.class);
        cq.where(cb.like(cb.lower(orgRoot.get(Doc_.name)), "%" + name.toLowerCase() + "%"));
        TypedQuery<Doc> query = em.createQuery(cq);
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}
