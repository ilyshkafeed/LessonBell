package ru.bellintegrator.practice.api.organization.model;

import javax.persistence.*;

@Entity
public class Organization {
    public static final String PARAM_NAME = "name";
    public static final String PARAM_FULL_NAME = "full_name";
    public static final String PARAM_INN = "inn";
    public static final String PARAM_KPP = "kpp";
    public static final String PARAM_ADDRESS = "address";
    public static final String PARAM_PHONE = "phone";
    public static final String PARAM_IS_ACTIVE = "is_active";


    @Id
    @GeneratedValue
    private Integer id;

    /**
     * Служебное поле hibernate
     */
//    @Version
//    private Integer version;

    //Поля сами за себя говорят
    @Column(length = 50, updatable = false, nullable = false)
    private String name;

    @Column(name = "full_name", length = 255, nullable = false)
    private String fullName;

    @Column(length = 10, nullable = false)
    private String inn;

    @Column(length = 9, nullable = false)
    private String kpp;

    @Column(length = 255, nullable = false)
    private String address;

    @Column(length = 50, nullable = false)
    private String phone = "";

    @Column(name = "is_active", length = 50, nullable = false)
    private boolean isActive = true;

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

    public Organization(Integer id, String name, boolean isActive) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
    }


    public Organization(String name, String fullName, String inn, String kpp, String address, String phone, boolean isActive) {
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public Organization(String name, String fullName, String inn, String kpp, String address, String phone) {
        this(name, fullName, inn, kpp, address, phone, true);
    }

    public Organization(String name, String fullName, String inn, String kpp, String address) {
        this(name, fullName, inn, kpp, address, "", true);
    }

    //getter-ы
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
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

    //setter-ы
    public void setName(String name) {
        this.name = name;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", inn='" + inn + '\'' +
                ", kpp='" + kpp + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
