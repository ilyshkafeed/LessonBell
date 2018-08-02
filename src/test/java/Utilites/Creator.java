package Utilites;

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


}
