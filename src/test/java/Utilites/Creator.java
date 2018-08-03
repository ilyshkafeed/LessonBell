package Utilites;

import ru.bellintegrator.practice.api.office.findings.OfficeList;
import ru.bellintegrator.practice.api.office.findings.OfficeSave;
import ru.bellintegrator.practice.api.office.findings.OfficeUpdate;
import ru.bellintegrator.practice.api.organization.findings.OrganizationList;
import ru.bellintegrator.practice.api.organization.findings.OrganizationSave;
import ru.bellintegrator.practice.api.organization.findings.OrganizationUpdate;

public class Creator {
    // Думаю фабрики для тестов ненужны))
    public static OrganizationList newOrganizationList(String name, String inn, Boolean isActive) {
        OrganizationList organizationList = new OrganizationList();
        SetField.set(organizationList, "name", name);
        SetField.set(organizationList, "inn", inn);
        SetField.set(organizationList, "isActive", isActive);
        return organizationList;
    }

    public static OrganizationUpdate newOrganizationUpdate(Integer id, String name, String fullName, String inn, String kpp, String address, String phone, Boolean isActive) {
        OrganizationUpdate organizationUpdate = new OrganizationUpdate();
        SetField.set(organizationUpdate, "id", id);
        SetField.set(organizationUpdate, "name", name);
        SetField.set(organizationUpdate, "fullName", fullName);
        SetField.set(organizationUpdate, "inn", inn);
        SetField.set(organizationUpdate, "kpp", kpp);
        SetField.set(organizationUpdate, "address", address);
        SetField.set(organizationUpdate, "phone", phone);
        SetField.set(organizationUpdate, "isActive", isActive);
        return organizationUpdate;
    }

    public static OrganizationSave newOrganizationSave(String name, String fullName, String inn, String kpp, String address, String phone, Boolean isActive) {
        OrganizationSave organizationSave = new OrganizationSave();
        SetField.set(organizationSave, "name", name);
        SetField.set(organizationSave, "fullName", fullName);
        SetField.set(organizationSave, "inn", inn);
        SetField.set(organizationSave, "kpp", kpp);
        SetField.set(organizationSave, "address", address);
        SetField.set(organizationSave, "phone", phone);
        SetField.set(organizationSave, "isActive", isActive);
        return organizationSave;
    }


    public static OfficeList newOfficeList(Integer orgId, String name, String phone, Boolean isActive) {
        OfficeList officeList = new OfficeList();
        SetField.set(officeList, "orgId", orgId);
        SetField.set(officeList, "name", name);
        SetField.set(officeList, "phone", phone);
        SetField.set(officeList, "isActive", isActive);
        return officeList;
    }

    public static OfficeSave newOfficeSave(Integer orgId, String name, String address, String phone, Boolean isActive) {
        OfficeSave officeSave = new OfficeSave();
        SetField.set(officeSave, "orgId", orgId);
        SetField.set(officeSave, "name", name);
        SetField.set(officeSave, "phone", phone);
        SetField.set(officeSave, "address", address);
        SetField.set(officeSave, "isActive", isActive);
        return officeSave;
    }

    public static OfficeUpdate newOfficeUpdate(Integer id, Integer orgId, String name, String address, String phone, Boolean isActive) {
        OfficeUpdate officeUpdate = new OfficeUpdate();
        SetField.set(officeUpdate, "id", id);
        SetField.set(officeUpdate, "orgId", orgId);
        SetField.set(officeUpdate, "name", name);
        SetField.set(officeUpdate, "address", address);
        SetField.set(officeUpdate, "phone", phone);
        SetField.set(officeUpdate, "isActive", isActive);
        return officeUpdate;
    }
}
