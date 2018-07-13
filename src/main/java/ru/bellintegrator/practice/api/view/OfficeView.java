package ru.bellintegrator.practice.api.view;

import io.swagger.annotations.ApiModelProperty;

public class OfficeView {


    public long id;
    @ApiModelProperty(hidden = true)
    public long ordId;
    public String name;

    public String address;
    public String phone;
    public boolean isActive;


    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name=\"" + name + '"' +
                ", address=\"" + address + '"' +
                ", phone=\"" + phone + '"' +
                ", isActive=" + isActive +
                '}';
    }
}