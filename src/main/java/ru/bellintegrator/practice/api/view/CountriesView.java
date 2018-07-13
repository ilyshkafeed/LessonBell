package ru.bellintegrator.practice.api.view;

public class CountriesView {


    public String name;
    public int code;


    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", code=" + code +
                '}';
    }
}