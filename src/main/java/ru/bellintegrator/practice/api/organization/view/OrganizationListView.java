package ru.bellintegrator.practice.api.organization.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.bellintegrator.practice.api.organization.model.Organization;
import ru.bellintegrator.practice.api.view.StaticView;

public class OrganizationListView implements StaticView {
    private int id;
    private String name;
    private Boolean isActive;


    public OrganizationListView() {
    }

    public OrganizationListView(int id, String name, Boolean isActive) {
        setId(id);
        setName(name);
        setActive(isActive);
    }

    public OrganizationListView(Organization el) {
        this(el.getId(), el.getName(), el.isActive());
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
    public Boolean isActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
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
