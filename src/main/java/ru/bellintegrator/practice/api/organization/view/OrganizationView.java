package ru.bellintegrator.practice.api.organization.view;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.bellintegrator.practice.api.organization.model.Organization;
import ru.bellintegrator.practice.api.view.StaticView;

public class OrganizationView implements StaticView {


    @JsonIgnore
    public RuntimeException ex;

    public Integer id;
    public String name;
    public String fullName;
    public String inn;
    public String kpp;
    public String address;
    public String phone;
    public boolean isActive;

    public OrganizationView() {
    }

    public OrganizationView(String name, String fullName, String inn, String kpp, String address, String phone, boolean isActive) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public OrganizationView(Organization organization) {
        this(organization.getName(),
                organization.getFullName(),
                organization.getInn(),
                organization.getKpp(),
                organization.getAddress(),
                organization.getPhone(),
                organization.isActive()
        );
        this.id = organization.getId();
    }

    @Override
    public String toString() {
        return "{" +
                "id=\"" + id + '\"' +
                ", name=\"" + name + '\"' +
                ", fullName=\"" + fullName + '\"' +
                ", inn=\"" + inn + '\"' +
                ", kpp=\"" + kpp + '\"' +
                ", address=\"" + address + '\"' +
                ", phone=\"" + phone + '\"' +
                ", isActive=\"" + isActive + '\"' +
                '}';
    }
}