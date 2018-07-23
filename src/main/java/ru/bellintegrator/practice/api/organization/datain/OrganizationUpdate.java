package ru.bellintegrator.practice.api.organization.datain;

import java.util.regex.Pattern;

public class OrganizationUpdate {
    private static final Pattern REGEX_PATTERN_NAME = Pattern.compile("^[0-9a-zA-Z ,\"]{2,50}$", Pattern.MULTILINE);
    private static final Pattern REGEX_PATTERN_PHONE = Pattern.compile("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$", Pattern.MULTILINE);


    private Integer id;
    private String name;
    private String fullName;
    private String inn;
    private String kpp;
    private String address;
    private String phone;
    private Boolean isActive;

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
