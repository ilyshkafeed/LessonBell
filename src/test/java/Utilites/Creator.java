package Utilites;

import ru.bellintegrator.practice.api.office.findings.OfficeList;
import ru.bellintegrator.practice.api.office.findings.OfficeSave;
import ru.bellintegrator.practice.api.office.findings.OfficeUpdate;
import ru.bellintegrator.practice.api.organization.findings.OrganizationList;
import ru.bellintegrator.practice.api.organization.findings.OrganizationSave;
import ru.bellintegrator.practice.api.organization.findings.OrganizationUpdate;
import ru.bellintegrator.practice.api.user.findings.UserList;
import ru.bellintegrator.practice.api.user.findings.UserSave;
import ru.bellintegrator.practice.api.user.findings.UserUpdate;

import java.util.Date;

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

    public static UserList newUserList(
            Integer officeId,
            String firstName,
            String lastName,
            String middleName,
            String position,
            Integer docCode,
            Integer citizenshipCode
    ) {
        UserList userList = new UserList();
        SetField.set(userList, "officeId", officeId);
        SetField.set(userList, "firstName", firstName);
        SetField.set(userList, "lastName", lastName);
        SetField.set(userList, "middleName", middleName);
        SetField.set(userList, "position", position);
        SetField.set(userList, "docCode", docCode);
        SetField.set(userList, "citizenshipCode", citizenshipCode);
        return userList;
    }
    public static UserSave newUserSave(
            Integer officeId,
            String firstName,
            String lastName,
            String middleName,
            String position,
            String phone,
            String docNumber,
            String docName,
            Date docDate,
            Short citizenshipCode,
            Boolean isIdentified
    ) {
        UserSave userSave = new UserSave();
        SetField.set(userSave, "officeId", officeId);
        SetField.set(userSave, "firstName", firstName);
        SetField.set(userSave, "lastName", lastName);
        SetField.set(userSave, "middleName", middleName);
        SetField.set(userSave, "position", position);
        SetField.set(userSave, "phone", phone);
        SetField.set(userSave, "docNumber", docNumber);
        SetField.set(userSave, "docName", docName);
        SetField.set(userSave, "docDate", docDate);
        SetField.set(userSave, "citizenshipCode", citizenshipCode);
        SetField.set(userSave, "isIdentified", isIdentified);

        return userSave;
    }

    public static UserUpdate newUserUpdate(
            Integer id,
            Integer officeId,
            String firstName,
            String lastName,
            String middleName,
            String position,
            String phone,
            String docName,
            String docNumber,
            Date docDate,
            Short citizenshipCode,
            Boolean isIdentified) {
        UserUpdate userUpdate = new UserUpdate();
        SetField.set(userUpdate, "id", id);
        SetField.set(userUpdate, "officeId", officeId);
        SetField.set(userUpdate, "firstName", firstName);
        SetField.set(userUpdate, "lastName", lastName);
        SetField.set(userUpdate, "middleName", middleName);
        SetField.set(userUpdate, "position", position);
        SetField.set(userUpdate, "phone", phone);
        SetField.set(userUpdate, "docNumber", docNumber);
        SetField.set(userUpdate, "docName", docName);
        SetField.set(userUpdate, "docDate", docDate);
        SetField.set(userUpdate, "citizenshipCode", citizenshipCode);
        SetField.set(userUpdate, "isIdentified", isIdentified);
        return userUpdate;
    }
}
