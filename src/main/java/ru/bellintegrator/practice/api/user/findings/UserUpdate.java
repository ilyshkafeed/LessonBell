package ru.bellintegrator.practice.api.user.findings;


import ru.bellintegrator.practice.validator.Phone;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


public class UserUpdate {

    @NotNull(message = "Поле 'id' не может быть пустым")
    private Integer id;

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
    @Phone
    private String phone;

    private Integer officeId;

    private String docName;

    private String docNumber;

    private Date docDate;






    public UserUpdate() {
    }


}
