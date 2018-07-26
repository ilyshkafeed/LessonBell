package ru.bellintegrator.practice.api.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.api.user.findings.UserList;
import ru.bellintegrator.practice.api.user.model.User;
import ru.bellintegrator.practice.api.user.model.User_;

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
public class UserDaoImpl implements UserDao {

    private final EntityManager em;

    @Autowired
    public UserDaoImpl(EntityManager em) {
        this.em = em;
    }


    @Override
    public User get(int id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> getList(UserList data) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> orgRoot = cq.from(User.class);
        // SELECT id, name, is_active
        cq.multiselect(
                orgRoot.get(User_.id),
                orgRoot.get(User_.firstName),
                orgRoot.get(User_.lastName),
                orgRoot.get(User_.middleName),
                orgRoot.get(User_.position)
        );
        // WHERE orgId = :orgId:
        cq.where(cb.equal(orgRoot.get(User_.office), data.getOfficeId()));

        if (data.getFirstName() != null) {
            // WHERE lower(first_name) like :%firstName%:
            cq.where(cb.like(cb.lower(orgRoot.get(User_.firstName)), "%" + data.getFirstName().toLowerCase() + "%"));
        }
        if (data.getLastName() != null) {
            // WHERE lower(last_name) like :%lastName%:
            cq.where(cb.like(cb.lower(orgRoot.get(User_.lastName)), "%" + data.getLastName().toLowerCase() + "%"));
        }
        if (data.getMiddleName() != null) {
            // WHERE lower(middle_name) like :%middleName%:
            cq.where(cb.like(cb.lower(orgRoot.get(User_.middleName)), "%" + data.getMiddleName().toLowerCase() + "%"));
        }
        if (data.getPosition() != null) {
            // WHERE lower(position) like :%position%:
            cq.where(cb.like(cb.lower(orgRoot.get(User_.position)), "%" + data.getPosition().toLowerCase() + "%"));
        }
        if (data.getDocCode() != null) {
            // WHERE doc_code = :docCode:
            cq.where(cb.equal(orgRoot.get(User_.doc), data.getDocCode()));
        }
        if (data.getCitizenshipCode() != null) {
            // WHERE citizenship_code = :citizenship_code:
            cq.where(cb.equal(orgRoot.get(User_.citizenship), data.getCitizenshipCode()));
        }

        TypedQuery<User> query = em.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void save(User org) {
        em.persist(org);
    }

    @Override
    public void flush() {
        em.flush();
    }
}
