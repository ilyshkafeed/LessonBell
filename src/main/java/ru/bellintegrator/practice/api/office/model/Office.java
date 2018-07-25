package ru.bellintegrator.practice.api.office.model;


import ru.bellintegrator.practice.api.organization.model.Organization;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Office implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    @Version
    private Integer version;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(length = 50, nullable = false)
    private String phone = "";

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "organization_id")
    private Organization organization;




    @Column
    boolean isActive = true;

    public Office() {

    }

    public Office(Integer id, String name, boolean isActive) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }


    public Organization getOrganization() {
        return organization;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    @Column(name = "is_active")
    public boolean isActive() {
        return isActive;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "is_active")
    public void setActive(boolean active) {
        isActive = active;
    }


}
