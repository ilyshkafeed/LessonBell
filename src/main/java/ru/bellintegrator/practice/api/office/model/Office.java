package ru.bellintegrator.practice.api.office.model;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import ru.bellintegrator.practice.api.organization.model.Organization;
import ru.bellintegrator.practice.api.user.model.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

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
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @OneToMany(
            mappedBy = "office",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Set<User> users;


    @Column(name = "is_active")
    boolean isActive = true;

    public Office() {

    }

    public Office(Integer id, String name, boolean isActive) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
    }


    public void addOffice(User user) {
        getUsers().add(user);
        user.setOffice(this);
    }


    public Integer getOrganizationId() {
        LazyInitializer initializer = ((HibernateProxy) getOrganization()).getHibernateLazyInitializer();
        return (Integer) initializer.getIdentifier();
    }

    public Integer getId() {
        return id;
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

    public Organization getOrganization() {
        return organization;
    }

    public Set<User> getUsers() {
        return users;
    }

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

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
