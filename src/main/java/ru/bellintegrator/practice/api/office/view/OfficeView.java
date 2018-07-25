package ru.bellintegrator.practice.api.office.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.bellintegrator.practice.api.office.model.Office;

public class OfficeView {


    private int id;
    private String name;
    private String address;
    private String phone;
    private boolean isActive;

    public OfficeView() {


    }

    public OfficeView(Office o) {
        id = o.getId();
        name = o.getName();
        address = o.getAddress();
        phone = o.getPhone();
        isActive = o.isActive();
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

    @JsonProperty("isActive")
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "OfficeView{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}