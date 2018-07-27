package ru.bellintegrator.practice.api.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.api.docs.dao.DocDao;
import ru.bellintegrator.practice.api.docs.model.Doc;
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
import ru.bellintegrator.practice.api.сountries.dao.CountriesDao;
import ru.bellintegrator.practice.api.сountries.model.Countries;

import java.util.List;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class UserServiceImpl implements UserService {

    private final OfficeDao officeDao;
    private final UserDao dao;
    private final DocDao docDao;
    private final CountriesDao countriesDao;

    @Autowired
    public UserServiceImpl(OfficeDao officeDao, UserDao dao, DocDao docDao, CountriesDao countriesDao) {
        this.officeDao = officeDao;
        this.dao = dao;
        this.docDao = docDao;
        this.countriesDao = countriesDao;
    }


    @Override
    @Transactional(readOnly = true)
    public UserView get(int id) {
        return new UserView(getUser(id));
    }

    @Override
    @Transactional
    public void delete(int id) {
        User user = getUser(id);
        dao.delete(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ListView> getList(UserList param) {
        getOffice(param.getOfficeId());
        return dao.getList(param).stream()
                .map(p -> new ListView(p.getId(), p.getLastName(), p.getFirstName(), p.getMiddleName(), p.getPosition()))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void save(UserSave param) {
        User user = new User();

        user.setFirstName(param.getFirstName());
        user.setPosition(param.getPosition());

        Office office = getOffice(param.getOfficeId());
        office.addUser(user);

        if (param.getLastName() != null) {
            user.setLastName(param.getLastName());
        }
        if (param.getMiddleName() != null) {
            user.setMiddleName(param.getMiddleName());
        }
        if (param.getPhone() != null) {
            user.setPhone(param.getPhone());
        }
        if (param.getDocName() != null) {
            Doc doc = docFindByName(param.getDocName());
            user.setDoc(doc);
        }
        if (param.getDocNumber() != null) {
            user.setDocNumber(param.getDocNumber());
        }
        if (param.getDocDate() != null) {
            user.setDocDate(param.getDocDate());
        }
        if (param.getCitizenshipCode() != null) {
            Countries countries = countriesFindByCode(param.getCitizenshipCode());
            user.setCitizenship(countries);
        }
        if (param.getIdentified() != null) {
            user.setIdentified(param.getIdentified());
        }
        dao.save(user);
        dao.flush();
    }

    @Override
    @Transactional
    public void update(UserUpdate param) {
        User user = getUser(param.getId());

        user.setFirstName(param.getFirstName());
        user.setPosition(param.getPosition());

        if (param.getOfficeId() != null) {
            Office office = getOffice(param.getOfficeId());
            user.getOffice().getUsers().remove(user);
            office.addUser(user);
        }
        if (param.getLastName() != null) {
            user.setLastName(param.getLastName());
        }
        if (param.getMiddleName() != null) {
            user.setMiddleName(param.getMiddleName());
        }
        if (param.getPhone() != null) {
            user.setPhone(param.getPhone());
        }
        if (param.getDocName() != null) {
            Doc doc = docFindByName(param.getDocName());
            user.setDoc(doc);
        }
        if (param.getDocNumber() != null) {
            user.setDocNumber(param.getDocNumber());
        }
        if (param.getDocDate() != null) {
            user.setDocDate(param.getDocDate());
        }
        if (param.getCitizenshipCode() != null) {
            Countries countries = countriesFindByCode(param.getCitizenshipCode());
            user.setCitizenship(countries);
        }
        if (param.getIdentified() != null) {
            user.setIdentified(param.getIdentified());
        }
        dao.flush();
    }


    private User getUser(int id) {
        User user = dao.get(id);
        if (user == null) {
            throw new NoEntityFoundForQueryException("User");
        }
        return user;
    }

    private Office getOffice(int id) {
        Office org = officeDao.get(id);
        if (org == null) {
            throw new NoEntityFoundForQueryException("Office");
        }
        return org;
    }


    private Doc getDoc(int id) {
        Doc org = docDao.get(id);
        if (org == null) {
            throw new NoEntityFoundForQueryException("Docs");
        }
        return org;
    }

    private Doc docFindByCode(int code) {
        Doc org = docDao.findByCode(code);
        if (org == null) {
            throw new NoEntityFoundForQueryException("Docs");
        }
        return org;
    }

    private Doc docFindByName(String name) {
        Doc org = docDao.findByName(name);
        if (org == null) {
            throw new NoEntityFoundForQueryException("Docs");
        }
        return org;
    }

    private Countries getCountries(int id) {
        Countries org = countriesDao.get(id);
        if (org == null) {
            throw new NoEntityFoundForQueryException("Countries");
        }
        return org;
    }

    private Countries countriesFindByCode(int code) {
        Countries org = countriesDao.findByCode(code);
        if (org == null) {
            throw new NoEntityFoundForQueryException("Countries");
        }
        return org;
    }

    private Countries countriesFindByName(String name) {
        Countries org = countriesDao.findByName(name);
        if (org == null) {
            throw new NoEntityFoundForQueryException("Countries");
        }
        return org;
    }

}


