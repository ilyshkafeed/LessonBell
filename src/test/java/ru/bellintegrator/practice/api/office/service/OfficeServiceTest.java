package ru.bellintegrator.practice.api.office.service;

import Utilites.SetField;
import org.junit.*;
import org.mockito.Mock;
import ru.bellintegrator.practice.api.exception.NoEntityFoundForQueryException;
import ru.bellintegrator.practice.api.office.dao.OfficeDao;
import ru.bellintegrator.practice.api.office.findings.OfficeList;
import ru.bellintegrator.practice.api.office.findings.OfficeSave;
import ru.bellintegrator.practice.api.office.findings.OfficeUpdate;
import ru.bellintegrator.practice.api.office.model.Office;
import ru.bellintegrator.practice.api.office.view.ListView;
import ru.bellintegrator.practice.api.office.view.OfficeView;
import ru.bellintegrator.practice.api.organization.dao.OrganizationDao;
import ru.bellintegrator.practice.api.organization.findings.OrganizationList;
import ru.bellintegrator.practice.api.organization.model.Organization;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OfficeServiceTest {
    @Mock
    private OfficeDao dao = mock(OfficeDao.class);
    @Mock
    private OrganizationDao orgDao = mock(OrganizationDao.class);
    @Mock
    private OfficeService officeService = new OfficeServiceImpl(dao, orgDao);

    private final Organization ORG_LIST_1 = new Organization(1, "name 1", true);
    private final Organization ORG_LIST_2 = new Organization(2, "name 2", false);

    private Organization ORG_GET = mock(Organization.class);


    private final Office OFFICE_LIST_1 = new Office(1, "name 1", true);
    private final Office OFFICE_LIST_2 = new Office(2, "name 2", false);
    private final Office OFFICE_GET = new Office(3, "name get", false);

    @Before
    public void setUp() {
        //
        List<Organization> list = new ArrayList<>();
        list.add(ORG_LIST_1);
        list.add(ORG_LIST_2);
        when(orgDao.getList(any(OrganizationList.class))).thenReturn(list);
        when(orgDao.get(anyInt())).thenReturn(ORG_GET);
        when(orgDao.get(0)).thenReturn(null);


        OFFICE_GET.setOrganization(ORG_GET);
        OFFICE_GET.setPhone("+7 223 123-12-12");
        OFFICE_GET.setAddress("street offece");
        //
        List<Office> listOff = new ArrayList<>();
        listOff.add(OFFICE_LIST_1);
        listOff.add(OFFICE_LIST_2);
        when(dao.getList(any(OfficeList.class))).thenReturn(listOff);
        when(dao.get(anyInt())).thenReturn(OFFICE_GET);
        when(dao.get(0)).thenReturn(null);
    }


    @Test
    public void get() {
        OfficeView ow = officeService.get(1);
        // проверка
        assertEquals(OFFICE_GET.getId(), Integer.valueOf(ow.getId()));
        assertEquals(OFFICE_GET.getName(), ow.getName());
        assertEquals(OFFICE_GET.getAddress(), ow.getAddress());
        assertEquals(OFFICE_GET.getPhone(), ow.getPhone());
        assertEquals(OFFICE_GET.isActive(), ow.isActive());
    }

    @Test(expected = NoEntityFoundForQueryException.class)
    public void get_null() {
        officeService.get(0);
    }

    @Test(expected = NoEntityFoundForQueryException.class)
    public void get_orgNull() {
        OfficeList of = new OfficeList();
        SetField.set(of, "orgId", 0);
        officeService.getList(of);
    }

    @Test
    public void delete() {
        officeService.delete(1);
    }

    @Test(expected = NoEntityFoundForQueryException.class)
    public void delete_null() {
        officeService.delete(0);
    }

    @Test
    public void getList() {
        OfficeList of = new OfficeList();
        SetField.set(of, "orgId", 1);
        List<ListView> list = officeService.getList(of);
        // проверка
        assertEquals(OFFICE_LIST_1.getId(), Integer.valueOf(list.get(0).getId()));
        assertEquals(OFFICE_LIST_2.getId(), Integer.valueOf(list.get(1).getId()));

        assertEquals(OFFICE_LIST_1.getName(), list.get(0).getName());
        assertEquals(OFFICE_LIST_2.getName(), list.get(1).getName());

        assertEquals(OFFICE_LIST_1.isActive(), list.get(0).isActive());
        assertEquals(OFFICE_LIST_2.isActive(), list.get(1).isActive());
    }

    @Test(expected = NoEntityFoundForQueryException.class)
    public void getList_orgNull() {
        OfficeList of = new OfficeList();
        SetField.set(of, "orgId", 0);
        officeService.getList(of);
    }


    @Test
    public void save() {
        OfficeSave os = new OfficeSave();
        SetField.set(os, "name", "name");
        SetField.set(os, "orgId", 1);
        SetField.set(os, "address", "address");
        officeService.save(os);
        // должно выполниться без ошибок)
    }
    @Test(expected = NoEntityFoundForQueryException.class)
    public void save_orgNull() {
        OfficeSave os = new OfficeSave();
        SetField.set(os, "name", "name");
        SetField.set(os, "orgId", 0);
        SetField.set(os, "address", "address");
        officeService.save(os);
        // должно выполниться без ошибок)
    }
    @Test
    public void update() {
        OfficeUpdate ou = new OfficeUpdate();
        SetField.set(ou, "id", 1);
        SetField.set(ou, "name", "name");
        SetField.set(ou, "address", "address");
        officeService.update(ou);
    }
    @Test(expected = NoEntityFoundForQueryException.class)
    public void update_orgNull() {
        OfficeUpdate ou = new OfficeUpdate();
        SetField.set(ou, "id", 1);
        SetField.set(ou, "orgId", 0);
        SetField.set(ou, "name", "name");
        SetField.set(ou, "address", "address");
        officeService.update(ou);
    }
    @Test(expected = NoEntityFoundForQueryException.class)
    public void update_OfficeNull() {
        OfficeUpdate ou = new OfficeUpdate();
        SetField.set(ou, "id", 0);
        SetField.set(ou, "name", "name");
        SetField.set(ou, "address", "address");
        officeService.update(ou);
    }
}