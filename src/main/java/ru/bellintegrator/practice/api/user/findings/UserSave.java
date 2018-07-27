package ru.bellintegrator.practice.api.user.findings;


import ru.bellintegrator.practice.validator.Phone;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


public class UserSave {

    @NotNull(message = "Поле 'officeId' не может быть пустым")
    private Integer officeId;

    @NotNull(message = "Поле 'firstName' не может быть пустым")
    @Size(min = 1, max = 50, message = "Размер 'firstName' должен быть от 1 до 50 символов")
    private String firstName;

    @Size(max = 50, message = "Размер 'lastName' не должно привышать 50 символов")
    private String lastName;

    @Size(max = 50, message = "Размер 'lastName' не должно привышать 50 символов")
    private String middleName;

    @NotNull(message = "Поле 'position' не может быть пустым")
    @Size(max = 255, message = "Размер 'lastName' не должно привышать 255 символов")
    private String position;

    @Size(max = 50, message = "Размер 'phone' не должно привышать 50 символов")
    @Phone(message = "Неправильный формат телефона")
    private String phone;


    @Size(max = 255, message = "Размер 'docName' не должно привышать 255 символов")
    private String docName;

    @Size(max = 255, message = "Размер 'docNumber' не должно привышать 255 символов")
    private String docNumber;

    private Date docDate;

    private Short citizenshipCode;

    private Boolean isIdentified;


    public UserSave() {
    }


    @NotNull
    public Integer getOfficeId() {
        return officeId;
    }

    @NotNull
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    @NotNull
    public String getPosition() {
        return position;
    }

    public String getPhone() {
        return phone;
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

    public Boolean getIdentified() {
        return isIdentified;
    }
}
