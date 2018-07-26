package ru.bellintegrator.practice.api.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.api.exception.NoEntityFoundForQueryException;
import ru.bellintegrator.practice.api.office.dao.OfficeDao;
import ru.bellintegrator.practice.api.office.model.Office;
import ru.bellintegrator.practice.api.user.dao.UserDao;
import ru.bellintegrator.practice.api.user.findings.UserList;
import ru.bellintegrator.practice.api.user.findings.UserSave;
import ru.bellintegrator.practice.api.user.findings.UserUpdate;
import ru.bellintegrator.practice.api.user.model.User;
import ru.bellintegrator.practice.api.user.view.ListView;
import ru.bellintegrator.practice.api.user.view.UserView;

import java.util.List;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class UserServiceImpl implements UserService {

    private final OfficeDao officeDao;
    private final UserDao dao;

    @Autowired
    public UserServiceImpl(OfficeDao officeDao, UserDao dao) {
        this.officeDao = officeDao;
        this.dao = dao;
    }


    @Override
    @Transactional(readOnly = true)
    public UserView get(int id) {
        return new UserView(getUser(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ListView> getList(UserList param) {
        return dao.getList(param).stream()
                .map(p -> new ListView(p.getId(), p.getLastName(), p.getFirstName(), p.getMiddleName(), p.getPosition()))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void save(UserSave param) {
        User o = new User();
        if (param.getOrgId() != null) {
            o.setOffice(getOffice(param.getOrgId()));
        }
//        if (param.getPhone() != null) {
//            o.setPhone(PhoneUtility.phoneToStandard(param.getPhone()));
//        }
//        if (param.isActive() != null) {
//            o.setActive(param.isActive());
//        }
        dao.save(o);
        dao.flush();
    }

    @Override
    @Transactional
    public void update(UserUpdate param) {

//        User user = getUser(param.getId());
//
//
//
//        Office o = getOffice(param.getId());

//        o.setName(param.getName());
//        o.setAddress(param.getAddress());
//        if (param.getPhone() != null) {
//            o.setPhone(PhoneUtility.phoneToStandard(param.getPhone()));
//        }
//        if (param.isActive() != null) {
//            o.setActive(param.isActive());
//        }
//        if (param.getOrgId() != null) {
//            Organization org = getOrganization(param.getOrgId());
//            o.setOrganization(org);
//        }
        dao.flush();
    }


    private User getUser(int id) {
        User org = dao.get(id);
        if (org == null) {
            throw new NoEntityFoundForQueryException("User");
        }
        return org;
    }

    private Office getOffice(int id) {
        Office org = officeDao.get(id);
        if (org == null) {
            throw new NoEntityFoundForQueryException("Office");
        }
        return org;
    }

}
