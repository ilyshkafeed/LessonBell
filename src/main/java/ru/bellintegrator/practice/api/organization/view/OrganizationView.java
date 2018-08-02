package ru.bellintegrator.practice.api.organization.view;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.bellintegrator.practice.api.organization.model.Organization;
import ru.bellintegrator.practice.api.view.StaticView;

public class OrganizationView implements StaticView {

    private Integer id;
    private String name;
    private String fullName;
    private String inn;
    private String kpp;
    private String address;
    private String phone;
    private boolean isActive;

    public OrganizationView() {
    }

    public OrganizationView(String name, String fullName, String inn, String kpp, String address, String phone, boolean isActive) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}