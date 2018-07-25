package ru.bellintegrator.practice.api.office.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.api.office.findings.OfficeList;
import ru.bellintegrator.practice.api.office.model.Office;
import ru.bellintegrator.practice.api.office.model.Office_;
import ru.bellintegrator.practice.api.organization.model.Organization;
import ru.bellintegrator.practice.utilits.PhoneUtility;

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
public class OfficeDaoImpl implements OfficeDao {

    private final EntityManager em;

    @Autowired
    public OfficeDaoImpl(EntityManager em) {
        this.em = em;
    }


    @Override
    public Office get(int id) {
        return em.find(Office.class, id);
    }

    @Override
    public List<Office> getList(OfficeList data) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Office> cq = cb.createQuery(Office.class);
        Root<Office> orgRoot = cq.from(Office.class);
        // SELECT id, name, is_active
        cq.multiselect(
                orgRoot.get(Office_.id),
                orgRoot.get(Office_.name),
                orgRoot.get(Office_.isActive)
        );
        // WHERE orgId = :orgId:
        cq.where(cb.equal(orgRoot.get(Office_.organization), data.getOrgId()));

        if (data.getName() != null) {
            // WHERE lower(name) like :%name%:
            cq.where(cb.like(cb.lower(orgRoot.get(Office_.name)), "%" + data.getName().toLowerCase() + "%"));
        }
        if (data.getPhone() != null) {
            // WHERE phone = :phone:
            cq.where(cb.equal(orgRoot.get(Office_.phone), PhoneUtility.phoneToStandard(data.getPhone())));
        }
        if (data.isActive() != null) {
            // WHERE is_active = :isActive:
            cq.where(cb.equal(orgRoot.get(Office_.isActive), data.isActive()));
        }

        TypedQuery<Office> query = em.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void save(Office org) {
        em.persist(org);
    }

    @Override
    public void flush() {
        em.flush();
    }
}
