package ru.bellintegrator.practice.api.organization.model;

import javax.persistence.*;

@Entity
public class Organization {
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    //Поля сами за себя говорят
    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 255, nullable = false)
    private String full_name;

    @Column(length = 10, nullable = false)
    private String inn;

    @Column(length = 9, nullable = false)
    private String kpp;

    @Column(length = 255, nullable = false)
    private String address;

    @Column(length = 50, nullable = false)
    private String phone;

    @Column(name = "is_active", length = 50, nullable = false)
    private boolean isActive;

//  Привер заготовки под офисы
//    @ManyToMany(
//            cascade = {
//                    CascadeType.PERSIST,
//                    CascadeType.MERGE
//            }
//    )
//    @JoinTable(
//            name = "Person_House",
//            joinColumns = @JoinColumn(name = "person_id"),
//            inverseJoinColumns = @JoinColumn(name = "house_id")
//    )
//    private Set<House> houses;




    public Organization() {

    }

    public Organization(String name, String full_name, String inn, String kpp, String address, String phone, boolean isActive) {
        this.name = name;
        this.full_name = full_name;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public Organization(String name, String full_name, String inn, String kpp, String address, String phone) {
        this(name, full_name, inn, kpp, address, phone, true);
    }

    public Organization(String name, String full_name, String inn, String kpp, String address) {
        this(name, full_name, inn, kpp, address, "", true);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getInn() {
        return inn;
    }

    public String getKpp() {
        return kpp;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


}
