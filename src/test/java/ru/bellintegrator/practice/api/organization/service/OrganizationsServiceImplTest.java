package ru.bellintegrator.practice.api.organization.service;

import Utilites.Creator;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.bellintegrator.practice.api.exception.NoEntityFoundForQueryException;
import ru.bellintegrator.practice.api.organization.dao.OrganizationDao;
import ru.bellintegrator.practice.api.organization.findings.OrganizationList;
import ru.bellintegrator.practice.api.organization.findings.OrganizationSave;
import ru.bellintegrator.practice.api.organization.findings.OrganizationUpdate;
import ru.bellintegrator.practice.api.organization.model.Organization;
import ru.bellintegrator.practice.api.organization.view.OrganizationListView;
import ru.bellintegrator.practice.api.organization.view.OrganizationView;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class OrganizationsServiceImplTest {

    private OrganizationDao dao = mock(OrganizationDao.class);
    private OrganizationsService organizationsService = new OrganizationsServiceImpl(dao);


    private final Organization ORG_LIST_1 = new Organization(1, "name 1", true);
    private final Organization ORG_LIST_2 = new Organization(2, "name 2", false);
    private final Organization ORG_GET = new Organization(3, "name get", false);


    @Before
    public void setUp(){
        ORG_GET.setFullName("test full name");
        ORG_GET.setAddress("street");
        ORG_GET.setInn("1234567890");
        ORG_GET.setKpp("123456789");
        ORG_GET.setPhone("+7 123 123-12-12");

        //
        List<Organization> list = new ArrayList<>();
        list.add(ORG_LIST_1);
        list.add(ORG_LIST_2);
        when(dao.getList(any(OrganizationList.class))).thenReturn(list);
        when(dao.get(anyInt())).thenReturn(ORG_GET);
        when(dao.get(0)).thenReturn(null);
    }

    @Test
    public void list() {
        // получение
        OrganizationList orgList = new OrganizationList();

        List<OrganizationListView> list = organizationsService.shortList(orgList);

        // проверка
        assertEquals(ORG_LIST_1.getId(), Integer.valueOf(list.get(0).getId()));
        assertEquals(ORG_LIST_2.getId(), Integer.valueOf(list.get(1).getId()));

        assertEquals(ORG_LIST_1.getName(), list.get(0).getName());
        assertEquals(ORG_LIST_2.getName(), list.get(1).getName());

        assertEquals(ORG_LIST_1.isActive(), list.get(0).isActive());
        assertEquals(ORG_LIST_2.isActive(), list.get(1).isActive());
    }


    @Test
    public void get() {
        // получение
        OrganizationView org = organizationsService.get(1);

        // проверка
        assertEquals(ORG_GET.getId(), org.getId());
        assertEquals(ORG_GET.getName(), org.getName());
        assertEquals(ORG_GET.getFullName(), org.getFullName());
        assertEquals(ORG_GET.getAddress(), org.getAddress());
        assertEquals(ORG_GET.getInn(), org.getInn());
        assertEquals(ORG_GET.getKpp(), org.getKpp());
        assertEquals(ORG_GET.getPhone(), org.getPhone());
    }

    @Test(expected = NoEntityFoundForQueryException.class)
    public void get_null() {
        organizationsService.get(0);
    }

    @Test
    public void delete() {
        organizationsService.delete(1);
    }

    @Test
    public void update() {
        OrganizationUpdate org = Creator.newOrganizationUpdate(1, "new name", "new full name", "1234567890", "123456789", "new street", "+71231231212", true);
        organizationsService.update(org);
    }

    @Test
    public void save() {
        OrganizationSave org = Creator.newOrganizationSave("new name", "new full name", "1234567890", "123456789", "new street", "+71231231212", true);
        organizationsService.save(org);
    }
}