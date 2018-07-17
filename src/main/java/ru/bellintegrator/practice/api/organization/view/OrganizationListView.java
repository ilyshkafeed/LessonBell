package ru.bellintegrator.practice.api.organization.view;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrganizationListView {
    private int id;
    private String name;
    private boolean isActive;


    public OrganizationListView() {
    }

    public OrganizationListView(int id, String name, boolean isActive) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @JsonProperty("isActive")
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "OrganizationListView{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
