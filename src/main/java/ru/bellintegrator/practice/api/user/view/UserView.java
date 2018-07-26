package ru.bellintegrator.practice.api.user.view;

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
    private Integer docCode;
    private String docNumber;
    private Date docDate;
    private Integer citizenshipCode;
    private Boolean isIdentified;


    public UserView() {
    }

    public UserView(User user) {
        setId(user.getId());
        setOfficeId(user.getOfficeId());
        setFirstName(user.getFirstName());
        setLastName(user.getLastName());
        setMiddleName(user.getMiddleName());
        setPosition(user.getPosition());
        setDocCode(user.getDocCode());
        setDocNumber(user.getDocNumber());
        setDocDate(user.getDocDate());
        setCitizenshipCode(user.getCitizenshipCode());
        setIdentified(user.isIdentified());
        setPosition(user.getPhone());
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

    public Boolean getIsIdentified() {
        return isIdentified;
    }

    public String getPhone() {
        return phone;
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

    public void setIdentified(Boolean isIdentified) {
        this.isIdentified = isIdentified;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}