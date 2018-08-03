package ru.bellintegrator.practice.api.user.findings;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class UserList {
    @NotNull(message = "Поле 'officeId' не может быть пустым")
    private Integer officeId;

    @Size(max = 50, message = "Размер 'firstName' не должно привышать 50 символов")
    private String firstName;

    @Size(max = 50, message = "Размер 'lastName' не должно привышать 50 символов")
    private String lastName;

    @Size(max = 50, message = "Размер 'lastName' не должно привышать 50 символов")
    private String middleName;

    @Size(max = 255, message = "Размер 'lastName' не должно привышать 255 символов")
    private String position;

    private Integer docCode;

    private Integer citizenshipCode;


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

    public Integer getCitizenshipCode() {
        return citizenshipCode;
    }
}
