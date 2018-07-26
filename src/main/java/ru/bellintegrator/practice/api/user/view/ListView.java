package ru.bellintegrator.practice.api.user.view;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ListView {


    private int id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String position;

    public ListView() {
    }

    public ListView(int id, String firstName, String lastName, String middleName, String position) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}

