package ru.bellintegrator.practice.api.user.service;

import Utilites.Creator;
import Utilites.SetField;
import org.junit.Before;
import org.junit.Test;
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

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    private final OfficeDao officeDao = mock(OfficeDao.class);
    private final UserDao userDao = mock(UserDao.class);
    private final DocDao docDao = mock(DocDao.class);
    private final CountriesDao countriesDao = mock(CountriesDao.class);

    private UserService userService = new UserServiceImpl(officeDao, userDao, docDao, countriesDao);

    private final User USER_GET = new User(1, "Мослов", "Илья", "Петрович", "Админ");
    private final User USER_LIST_1 = new User(1, "Мослов 1", "Илья 1", "Петрович 1", "Админ 1");
    private final User USER_LIST_2 = new User(2, "Мослов 2", "Илья 2", "Петрович 2", "Админ 2");
    private final User USER_LIST_3 = new User(3, "Мослов 3", "Илья 3", "Петрович 3", "Админ 3");

    private final Office mockOffice = mock(Office.class);
    private final Doc mockDoc = mock(Doc.class);
    private final Countries mockCountries = mock(Countries.class);


    @Before
    public void setUp() {

        when(mockDoc.getId()).thenReturn(1);
        when(mockDoc.getName()).thenReturn("Паспорт");
        when(mockDoc.getCode()).thenReturn((byte) 27);

        when(mockCountries.getId()).thenReturn(1);
        when(mockCountries.getName()).thenReturn("Россия");
        when(mockCountries.getCode()).thenReturn((short) 655);

        when(mockOffice.getId()).thenReturn(1);

        when(officeDao.get(anyInt())).thenReturn(mockOffice);
        when(officeDao.get(0)).thenReturn(null);

        USER_GET.setOffice(mockOffice);
        USER_GET.setIdentified(true);
        USER_GET.setDocDate(new Date());
        USER_GET.setDocNumber("123123123");
        USER_GET.setDoc(mockDoc);
        USER_GET.setPhone("+71234561212");
        USER_GET.setCitizenship(mockCountries);

        when(userDao.get(anyInt())).thenReturn(USER_GET);
        when(userDao.get(0)).thenReturn(null);
        when(docDao.findByName(any(String.class))).thenReturn(mockDoc);
        when(countriesDao.findByName(any(String.class))).thenReturn(mockCountries);
        when(countriesDao.findByCode(anyInt())).thenReturn(mockCountries);

        List<User> list = Arrays.asList(USER_LIST_1, USER_LIST_2, USER_LIST_3);
        when(userDao.getList(any(UserList.class))).thenReturn(list);


    }

    @Test
    public void get() {
        UserView uv = userService.get(1);

        assertEquals(USER_GET.getId(), uv.getId());
        assertEquals(USER_GET.getOffice().getId(), uv.getOfficeId());

        assertEquals(USER_GET.getFirstName(), uv.getFirstName());
        assertEquals(USER_GET.getLastName(), uv.getLastName());
        assertEquals(USER_GET.getMiddleName(), uv.getMiddleName());

        assertEquals(USER_GET.getPosition(), uv.getPosition());
        assertEquals(USER_GET.getPhone(), uv.getPhone());

        assertEquals(Byte.valueOf(USER_GET.getDoc().getCode()), uv.getDocCode());
        assertEquals(USER_GET.getDoc().getName(), uv.getDocName());
        assertEquals(USER_GET.getDocDate(), uv.getDocDate());
        assertEquals(USER_GET.getDocNumber(), uv.getDocNumber());

        assertEquals(Short.valueOf(USER_GET.getCitizenship().getCode()), uv.getCitizenshipCode());
        assertEquals(USER_GET.getCitizenship().getName(), uv.getCitizenshipName());

        assertEquals(USER_GET.isIdentified(), uv.isIdentified());
    }

    @Test(expected = NoEntityFoundForQueryException.class)
    public void get_null() {
        userService.get(0);
    }

    @Test
    public void delete() {
        userService.delete(1);
    }

    @Test(expected = NoEntityFoundForQueryException.class)
    public void delete_null() {
        userService.delete(0);
    }

    @Test
    public void getList() {
        UserList ul = new UserList();
        SetField.set(ul, "officeId", 1);
        List<ListView> l = userService.getList(ul);

        assertEquals(USER_LIST_1.getId(), Integer.valueOf(l.get(0).getId()));
        assertEquals(USER_LIST_2.getId(), Integer.valueOf(l.get(1).getId()));
        assertEquals(USER_LIST_3.getId(), Integer.valueOf(l.get(2).getId()));

        assertEquals(USER_LIST_1.getFirstName(), l.get(0).getFirstName());
        assertEquals(USER_LIST_2.getFirstName(), l.get(1).getFirstName());
        assertEquals(USER_LIST_3.getFirstName(), l.get(2).getFirstName());


        assertEquals(USER_LIST_1.getLastName(), l.get(0).getLastName());
        assertEquals(USER_LIST_2.getLastName(), l.get(1).getLastName());
        assertEquals(USER_LIST_3.getLastName(), l.get(2).getLastName());

        assertEquals(USER_LIST_1.getMiddleName(), l.get(0).getMiddleName());
        assertEquals(USER_LIST_2.getMiddleName(), l.get(1).getMiddleName());
        assertEquals(USER_LIST_3.getMiddleName(), l.get(2).getMiddleName());

        assertEquals(USER_LIST_1.getPosition(), l.get(0).getPosition());
        assertEquals(USER_LIST_2.getPosition(), l.get(1).getPosition());
        assertEquals(USER_LIST_3.getPosition(), l.get(2).getPosition());
    }

    @Test
    public void save() {
        UserSave us = Creator.newUserSave(1, "test", "test", "test", "test", "+71231231212", "123123", "Паспорт", new Date(), (short) 21, true);
        userService.save(us);
    }

    @Test(expected = NoEntityFoundForQueryException.class)
    public void save_officeNull() {
        UserSave us = Creator.newUserSave(0, "test", "test", "test", "test", "+71231231212", "123123", "Паспорт", new Date(), (short) 21, true);
        userService.save(us);
    }

    @Test
    public void update() {
        UserUpdate uu = Creator.newUserUpdate(1, 1, "test", "test", "test", "test", "+71231231212", "123123", "Паспорт", new Date(), (short) 21, true);
        userService.update(uu);
    }

    @Test(expected = NoEntityFoundForQueryException.class)
    public void update_userNull() {
        UserUpdate uu = Creator.newUserUpdate(0, 1, "test", "test", "test", "test", "+71231231212", "123123", "Паспорт", new Date(), (short) 21, true);
        userService.update(uu);
    }

    @Test(expected = NoEntityFoundForQueryException.class)
    public void update_officeNull() {
        UserUpdate uu = Creator.newUserUpdate(1, 0, "test", "test", "test", "test", "+71231231212", "123123", "Паспорт", new Date(), (short) 21, true);
        userService.update(uu);
    }
}