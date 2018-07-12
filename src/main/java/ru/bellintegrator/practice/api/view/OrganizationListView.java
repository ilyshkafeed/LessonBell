package ru.bellintegrator.practice.api.view;


import io.swagger.annotations.ApiModelProperty;

public class OrganizationListView {


    public String name;
    public String inn;
    public boolean isActive;


    @Override
    public String toString() {
        return "{" +
                "name=\"" + name + '"' +
                ", inn=\"" + inn + '"' +
                ", isActive=" + isActive +
                '}';
    }
}