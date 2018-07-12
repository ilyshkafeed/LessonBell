package ru.bellintegrator.practice.api.view;

import io.swagger.annotations.ApiModelProperty;

public class OrganizationView {


    public String id;
    public String name;
    public String fullName;
    public String inn;
    public String kpp;
    public String address;
    public String phone;
    public boolean isActive;

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