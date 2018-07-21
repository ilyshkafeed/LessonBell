package ru.bellintegrator.practice.api.organization.datain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.bellintegrator.practice.api.Validation;
import ru.bellintegrator.practice.api.exception.FieldFailedValidationException;
import ru.bellintegrator.practice.api.exception.RequiredFieldException;
import ru.bellintegrator.practice.api.organization.model.Organization;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class OrganizationUpdate implements Validation  {
    private static final Pattern REGEX_PATTERN_NAME = Pattern.compile("^[0-9a-zA-Z ,\"]{2,50}$", Pattern.MULTILINE);
    private static final Pattern REGEX_PATTERN_PHONE = Pattern.compile("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$", Pattern.MULTILINE);


    @JsonIgnore
    public RuntimeException ex;

    public Integer id;
    public String name;
    public String fullName;
    public String inn;
    public String kpp;
    public String address;
    public String phone;
    public Boolean isActive;

    public OrganizationUpdate() {
    }

    public OrganizationUpdate(Integer id, String name, String fullName, String inn, String kpp, String address, String phone, Boolean isActive) {
        this.id = id;
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
                ", id=\"" + id + '\"' +
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
        if (id == null) l.add("id");

        if (name == null) l.add("name");
        else name = name.trim();

        if (fullName == null) l.add("fullName");
        else fullName = fullName.trim();

        if (inn == null) l.add("inn");
        else inn = inn.trim();

        if (kpp == null) l.add("kpp");
        else kpp = kpp.trim();

        if (address == null) l.add("address");
        else address = address.trim();

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

    public Integer getId() {
        return id;
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
