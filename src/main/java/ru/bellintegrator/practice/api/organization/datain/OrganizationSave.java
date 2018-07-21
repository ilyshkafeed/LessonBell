package ru.bellintegrator.practice.api.organization.datain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.bellintegrator.practice.api.Validation;
import ru.bellintegrator.practice.api.exception.FieldFailedValidationException;
import ru.bellintegrator.practice.api.exception.RequiredFieldException;
import ru.bellintegrator.practice.api.organization.model.Organization;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class OrganizationSave implements Validation {
    private static final Pattern REGEX_PATTERN_NAME = Pattern.compile("^[a-zA-Z ,\"]{2,50}$");
    private static final Pattern REGEX_PATTERN_PHONE = Pattern.compile("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");


    @JsonIgnore
    public RuntimeException ex;

    public String name;
    public String fullName;
    public String inn;
    public String kpp;
    public String address;
    public String phone;
    public Boolean isActive;

    public OrganizationSave() {
    }

    public OrganizationSave(String name, String fullName, String inn, String kpp, String address, String phone, Boolean isActive) {
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }


    @Override
    public String toString() {
        return "{" +
                ", name=\"" + name + '\"' +
                ", fullName=\"" + fullName + '\"' +
                ", inn=\"" + inn + '\"' +
                ", kpp=\"" + kpp + '\"' +
                ", address=\"" + address + '\"' +
                ", phone=\"" + phone + '\"' +
                ", isActive=\"" + isActive + '\"' +
                '}';
    }

    @Override
    public boolean validate() {
        return validateNull()           // 1
                && validateFields();      // 2
    }

    @Override
    public RuntimeException getValidateException() {
        return ex;
    }

    private boolean validateNull() {
        List<String> l = new ArrayList<>();
        if (name == null) l.add("name");
        if (fullName == null) l.add("fullName");
        if (inn == null) l.add("inn");
        if (kpp == null) l.add("kpp");
        if (address == null) l.add("address");
        if (l.size() > 0) {
            ex = new RequiredFieldException(l);
            return false;
        }
        return true;
    }

    @SuppressWarnings("Duplicates")
    private boolean validateFields() {
        if (!REGEX_PATTERN_NAME.matcher(name).matches()) {
            ex = new FieldFailedValidationException("name");
            return false;
        }
        if (!REGEX_PATTERN_NAME.matcher(fullName).matches()) {
            ex = new FieldFailedValidationException("fullName");
            return false;
        }
        if (inn.length() != 10) {
            ex = new FieldFailedValidationException("inn");
            return false;
        }
        if (kpp.length() != 9) {
            ex = new FieldFailedValidationException("kpp");
            return false;
        }
        if (!REGEX_PATTERN_PHONE.matcher(phone).matches()) {
            ex = new FieldFailedValidationException("phone");
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public String getInn() {
        return inn;
    }

    public String getKpp() {
        return kpp;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public Boolean isActive() {
        return isActive;
    }
}
