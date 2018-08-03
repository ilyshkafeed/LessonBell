package ru.bellintegrator.practice.api.user.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.bellintegrator.practice.api.user.model.User;

import java.util.Date;

public class UserView {


    private Integer id;
    private Integer officeId;
    private String firstName;
    private String lastName;
    private String middleName;
    private String position;
    private String phone;
    private Byte docCode;
    private String docName;
    private String docNumber;
    private Date docDate;
    private Short citizenshipCode;
    private String citizenshipName;
    private Boolean isIdentified;


    public UserView() {
    }

    public UserView(User user) {
        setId(user.getId());
        // Офис
        if (user.getOffice() != null) {
            setOfficeId(user.getOffice().getId());
        }
        setPosition(user.getPosition());
        // ФИО
        setFirstName(user.getFirstName());
        setLastName(user.getLastName());
        setMiddleName(user.getMiddleName());
        // Телефон
        setPhone(user.getPhone());
        // Документ
        if (user.getDoc() != null) {
            setDocCode(user.getDoc().getCode());
            setDocName(user.getDoc().getName());
            setDocNumber(user.getDocNumber());
            setDocDate(user.getDocDate());
        }
        // Страна
        if (user.getCitizenship() != null) {
            setCitizenshipCode(user.getCitizenship().getCode());
            setCitizenshipName(user.getCitizenship().getName());
        }
        // Статус верификации
        setIdentified(user.isIdentified());

    }


    // getters and setter (autoGenerate)

    public Integer getId() {
        return id;
    }

    public Integer getOfficeId() {
        return officeId;
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

    public String getDocName() {
        return docName;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public Date getDocDate() {
        return docDate;
    }

    public Short getCitizenshipCode() {
        return citizenshipCode;
    }

    public String getCitizenshipName() {
        return citizenshipName;
    }

    @JsonProperty("isIdentified")
    public Boolean isIdentified() {
        return isIdentified;
    }

    public String getPhone() {
        return phone;
    }

    public Byte getDocCode() {
        return docCode;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
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

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public void setCitizenshipCode(Short citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }

    public void setCitizenshipName(String citizenshipName) {
        this.citizenshipName = citizenshipName;
    }

    public void setIdentified(Boolean isIdentified) {
        this.isIdentified = isIdentified;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDocCode(Byte docCode) {
        this.docCode = docCode;
    }
}