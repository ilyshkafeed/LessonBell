package ru.bellintegrator.practice.api.user.model;


import org.hibernate.EmptyInterceptor;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.hibernate.type.Type;
import ru.bellintegrator.practice.api.docs.model.Doc;
import ru.bellintegrator.practice.api.office.model.Office;
import ru.bellintegrator.practice.api.сountries.model.Countries;
import ru.bellintegrator.practice.api.utilits.PhoneUtility;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@EntityListeners(UserListener.class)
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @Version
    private Integer version;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "office_id")
    private Office office;

    //Имя
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    //Фамилия
    @Column(name = "last_name", length = 50)
    private String lastName = "";

    //Отчество или чтото еще для иностранных гражданинов
    @Column(name = "middle_name", length = 50)
    private String middleName = "";

    // Должность
    @Column(nullable = false)
    private String position;


    @Column
    private String phone = "";

    // Тип документа
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "doc_code")
    private Doc doc;

    // номер документа
    @Column(name = "doc_number")
    private String docNumber = "";

    // Дата документа
    @Column(name = "doc_date")
    @Temporal(TemporalType.DATE)
    private Date docDate;

    // Id номера страны
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "citizenship_code")
    private Countries citizenship;

    // Проверенный пользователь
    @Column(name = "is_identified")
    private boolean isIdentified = false;

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

    public Doc getDoc() {
        return doc;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public Date getDocDate() {
        return docDate;
    }

    public Countries getCitizenship() {
        return citizenship;
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

    public void setDoc(Doc doc) {
        this.doc = doc;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public void setCitizenship(Countries citizenship) {
        this.citizenship = citizenship;
    }

    public void setIdentified(boolean identified) {
        isIdentified = identified;
    }

    public void setPhone(String phone) {
        this.phone = PhoneUtility.phoneToStandard(phone);
    }
}
