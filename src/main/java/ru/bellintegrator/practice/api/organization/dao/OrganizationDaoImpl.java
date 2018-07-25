package ru.bellintegrator.practice.api.organization.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.api.organization.findings.OrganizationList;
import ru.bellintegrator.practice.api.organization.model.Organization;
import ru.bellintegrator.practice.api.organization.model.Organization_;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class OrganizationDaoImpl implements OrganizationDao {
    private static final Logger LOG = LoggerFactory.getLogger(OrganizationDaoImpl.class);

    private final EntityManager em;

    @Autowired
    public OrganizationDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Organization> all() {
        return null;
    }


    @Override
    public List<Organization> getShortList(OrganizationList data) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Organization> cq = cb.createQuery(Organization.class);
        Root<Organization> orgRoot = cq.from(Organization.class);
        // SELECT id, name, is_active
        cq.multiselect(
                orgRoot.get(Organization_.id),
                orgRoot.get(Organization_.name),
                orgRoot.get(Organization_.isActive)
        );

        // WHERE lower(name) like :%name%:
        cq.where(cb.like(cb.lower(orgRoot.get(Organization_.name)), "%" + data.getName().toLowerCase() + "%"));

        if (data.getInn() != null) {
            // AND inn like :inn:
            cq.where(cb.like(orgRoot.get(Organization_.inn), data.getInn()));
        }

        if (data.isActive() != null) {
            // AND is_active = :isActive:
            cq.where(cb.equal(orgRoot.get(Organization_.isActive), data.isActive()));
        }

        // SELECT id, name, is_active
        //      WHERE lower(name) like :%name%:
        //      AND inn like :inn:
        //      AND is_active = :isActive:
        TypedQuery<Organization> query = em.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public Organization get(int id) {
        return em.find(Organization.class, id);
    }


    public void flush() {
        em.flush();
    }

    @Override
    public void save(Organization org) {
        em.persist(org);
    }
}
