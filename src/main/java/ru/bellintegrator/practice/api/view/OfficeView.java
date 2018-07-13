package ru.bellintegrator.practice.api.view;

public class OfficeView {


    public String id;
    public String name;

    public String address;
    public String phone;
    public boolean isActive;

    public String fullName;
    public String inn;
    public String kpp;




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