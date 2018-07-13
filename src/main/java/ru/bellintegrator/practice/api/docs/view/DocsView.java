package ru.bellintegrator.practice.api.docs.view;

public class DocsView {


    public String name;
    public short code;


    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", code=" + code +
                '}';
    }
}