package ru.bellintegrator.practice.api.user.model;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import ru.bellintegrator.practice.api.office.model.Office;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @Version
    private Integer version;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(name = "office_id")
    private Office office;

    //Имя
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    //Фамилия
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    //Отчество или чтото еще для иностранных гражданинов
    @Column(name = "middle_name", length = 50, nullable = false)
    private String middleName;

    // Должность
    @Column(nullable = false)
    private String position;


    @Column
    private String phone;

    // Тип документа
    // TODO Сделать связь с обектом документов.
    @Column(name = "doc_code")
    private Integer docCode;

    // номер документа
    @Column(name = "doc_number")
    private String docNumber;

    // Дата документа
    @Column(name = "doc_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date docDate;

    // Id номера страны
    // TODO Сделать свзяь с стаблицей (обектом) страны
    @Column(name = "citizenship_code")
    private Integer citizenshipCode;

    // Проверенный пользователь
    @Column(name = "is_identified")
    private boolean isIdentified = true;

    public User() {

    }

    public User(Integer id, String firstName, String lastName, String middleName, String position) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.position = position;
    }

    //======= getters and setters
    public Integer getId() {
        return id;
    }

    public Office getOffice() {
        return office;
    }

    public Integer getOfficeId() {
        LazyInitializer initializer = ((HibernateProxy) getOffice()).getHibernateLazyInitializer();
        return (Integer) initializer.getIdentifier();
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

    public Integer getDocCode() {
        return docCode;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public Date getDocDate() {
        return docDate;
    }

    public Integer getCitizenshipCode() {
        return citizenshipCode;
    }

    public boolean isIdentified() {
        return isIdentified;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOffice(Office office) {
        this.office = office;
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

    public void setDocCode(Integer docCode) {
        this.docCode = docCode;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public void setCitizenshipCode(Integer citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }

    public void setIdentified(boolean identified) {
        isIdentified = identified;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
