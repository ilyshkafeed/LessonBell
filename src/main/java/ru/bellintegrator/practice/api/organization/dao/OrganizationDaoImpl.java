package ru.bellintegrator.practice.api.organization.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.api.organization.datain.OrganizationList;
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

        // SELECT Organization
        cq.multiselect(
                orgRoot.get(Organization_.id),
                orgRoot.get(Organization_.name),
                orgRoot.get(Organization_.isActive)
        );


        cq.where(cb.like(cb.lower(orgRoot.get(Organization_.name)), "%" + data.getName().toLowerCase() + "%"));
        if (data.getInn() != null) {
            cq.where(cb.equal(orgRoot.get(Organization_.inn), data.getInn()));
        }
        if (data.isActive() != null) {
            cq.where(cb.equal(orgRoot.get(Organization_.isActive), data.isActive()));
        }

        TypedQuery<Organization> query = em.createQuery(cq);
        List<Organization> listOrg = query.getResultList();
        return listOrg;
    }

    @Override
    public Organization get(int id) {
        return null;
    }

    @Override
    public void save(Organization organization) {

    }
}
